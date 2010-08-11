package com.sap.mi.textual.parsing.textblocks.reference;

import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.metamodel.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.TCS.Template;
import com.sap.furcas.metamodel.textblocks.AbstractToken;
import com.sap.furcas.metamodel.textblocks.DocumentNode;
import com.sap.furcas.metamodel.textblocks.LexedToken;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.mi.textual.grammar.ModelElementCreationException;
import com.sap.mi.textual.grammar.impl.DelayedReference;
import com.sap.mi.textual.grammar.impl.ModelInjector;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.mi.textual.parsing.textblocks.LexedTokenWrapper;
import com.sap.mi.textual.parsing.textblocks.LocalContextBuilder;
import com.sap.mi.textual.parsing.textblocks.TbUtil;
import com.sap.mi.textual.parsing.textblocks.TextBlocksAwareModelAdapter;
import com.sap.mi.textual.parsing.textblocks.observer.ParserTextBlocksHandler;


/**
 * This class is responsible to resolve {@link DelayedReference}s. This includes references
 * that could not instantly be resolved during parsing and references that need to be re-evaluated
 * because they might potentially change due to recent model changes.
 * <p>
 * The queue of the resolver is filled by the various {@link IAExpressionInvalidationChangeListener}s.
 * </p>
 */
public class ReferenceResolver {

    private final class ReferenceReevaluationCommand extends Command {

	private final DelayedReference ref;

	private ReferenceReevaluationCommand(DelayedReference ref) {
	    super(ref.getConnection(), "Re-evaluate unresolved Reference: " + ref);
	    this.ref = ref;

	}

	@Override
	public boolean canExecute() {
	    return true;
	}

	@Override
	public void doExecute() {
	    EPackage outermostPackage = MoinHelper.getOutermostPackageThroughClusteredImports(getConnection(),
		    (EObject) ref.getModelElement());
	    reEvaluateUnresolvedRef(getConnection(), outermostPackage, ref, (TextBlock) ref.getTextBlock());
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
	    PRI pri = ((EObject) ref.getModelElement()).get___Partition().getPri();
	    PartitionOperation editOperation = new PartitionOperation(PartitionOperation.Operation.EDIT, pri);
	    return Collections.singleton(editOperation);
	}
    }

    /**
     * Synchronized access to this collection on this object (the
     * {@link ReferenceResolver} instance) because the repetition of reference
     * resolution is affected by it.
     */
    private final Collection<DelayedReference> unresolvedReferences = new Vector<DelayedReference>();
    private final IncrementalReferenceEvaluationRegistry registry;
    private final GlobalDelayedReferenceResolver notifier;

    public ReferenceResolver(GlobalDelayedReferenceResolver globalDelayedReferenceResolver,
	    IncrementalReferenceEvaluationRegistry registry) {
	this.notifier = globalDelayedReferenceResolver;
	this.registry = registry;
    }

    /**
     * Attempt to resolve all queued unresolved references. References that
     * could not be resolved remain queued.
     * <p>
     * This method is thread safe: One thread at a time is responsible to resolve
     * references. Multiple threads however are allowed to queue new references,
     * while a resolve run is in progress. Those references will be picked up
     * automatically.
     * </p>
     */
    public synchronized void resolveReferences(IProgressMonitor monitor) {
	synchronized (unresolvedReferences) {
	    if (unresolvedReferences.isEmpty()) {
		return; // nothing to do, exit "early"
	    }
	}
	boolean referencesAddedFromOutsideOrOneResolved;
	do {
	    referencesAddedFromOutsideOrOneResolved = false;
	    Collection<DelayedReference> failedReferences = new ArrayList<DelayedReference>();
	    Collection<DelayedReference> workingCopy = new ArrayList<DelayedReference>();
	    synchronized (unresolvedReferences) {
		workingCopy.addAll(unresolvedReferences);
		unresolvedReferences.clear();
	    }
	    monitor.beginTask("Reevaluating OCL References...", workingCopy.size());
	    for (Entry<ResourceSet, Collection<DelayedReference>> referencesPerConnection : splitPerConnection(workingCopy).entrySet()) {
		CommandStack cmdStack = referencesPerConnection.getKey().getCommandStack();
		if (cmdStack.canRedo()) {
		    // the current connection is in the process of undoing commands
		    // we may not issue reference resolving commands at this point, because
		    // this would clear the redo stack and make it impossible to ever
		    // redo the commands.
		    failedReferences.addAll(referencesPerConnection.getValue());
		    Activator.logInfo("Deferring Reevaluation due to ongoing undo action");
		    continue;
		}
		cmdStack.openGroup("Re-evaluate unresolved References");
		try {
		    for (DelayedReference ref : referencesPerConnection.getValue()) {
			try {
			    Command cmd = new ReferenceReevaluationCommand(ref);
			    cmd.execute();
			    referencesAddedFromOutsideOrOneResolved = true;
			    // no exception means successfully resolved
			    // FIXME the comment above is high likely wrong!
			} catch (InvalidConnectionException ex) {
			    Activator.logWarning("Could not re-resolve reference: " + ref + ". Connection: "
				    + ref.getConnection() + " is not alive anymore! Reference is ignored and removed.");
			} catch (InvalidObjectException ex) {
			    Activator.logWarning("Could not re-resolve reference: " + ref + ". Element: " + ref.getModelElement()
				    + " is not alive anymore! Reference is ignored and removed.");
			} catch (PartitionEditingNotPossibleException ex) {
			    Activator.logWarning("Could not re-resolve reference: " + ref + ". Partition: " + ex.getPri()
				    + " is locked by connection " + ref.getConnection() + "! Will try again later");
			    failedReferences.add(ref);
			} catch (Exception ex) {
			    Activator.logError(ex, " Could not re-resolve reference: " + ref
				    + ". Reference is ignored and removed.");
			}
			monitor.worked(1);
		    }
		} finally {
		    cmdStack.closeGroup();
		}
	    }
	    monitor.done();
	    synchronized (unresolvedReferences) {
		referencesAddedFromOutsideOrOneResolved = referencesAddedFromOutsideOrOneResolved || !hasEmptyQueue();
		// will try to resolve deferred references again later;
		// re-queue. Note that this
		// doesn't force another run; if nothing changed, we still
		// wouldn't be able to resolve
		queueNewUnresolvedReferences(failedReferences);
	    }
	} while (referencesAddedFromOutsideOrOneResolved);
    }

    private Map<ResourceSet, Collection<DelayedReference>> splitPerConnection(Collection<DelayedReference> workingCopy) {
	Map<ResourceSet, Collection<DelayedReference>> referencesPerConnection = new HashMap<ResourceSet, Collection<DelayedReference>>();
	for (DelayedReference ref : workingCopy) {
	    if (!referencesPerConnection.containsKey(ref.getConnection())) {
		referencesPerConnection.put(ref.getConnection(), new ArrayList<DelayedReference>());
	    }
	    referencesPerConnection.get(ref.getConnection()).add(ref);
	}
	return referencesPerConnection;
    }

    private void reEvaluateUnresolvedRef(ResourceSet conn, EPackage outermostPackage, DelayedReference unresolvedRef,
	    TextBlock contextTextBlock) {
	LocalContextBuilder localContextBuilder = new LocalContextBuilder();
	try {
	    // ensure that the model element uses the current connection
	    ensureUsageOfConnection(unresolvedRef, conn);
	    LexedTokenWrapper token = (LexedTokenWrapper) unresolvedRef.getToken();
	    DocumentNode referringDocumentNode = null;
	    ConcreteSyntax cs;
	    ModelInjector modelInjector = constructModelInjector(conn, outermostPackage);
	    ObservableInjectingParser parser = null;
	    if (token != null) {
		AbstractToken modelElementToken = token.getWrappedToken();
		LexedToken tokenInCurrentConnection = (LexedToken) conn.getElement(modelElementToken.get___Mri());
		if (tokenInCurrentConnection == null || unresolvedRef.getModelElement() == null) {
		    registry.removeRegistration(unresolvedRef);
		    notifier.notifyReferenceResolvingListenerReferencesRemoved(Collections.singleton(unresolvedRef));
		    return;
		}
		cs = tokenInCurrentConnection.getParent().getType().getParseRule().getConcretesyntax();
		parser = registry.getParser(cs);
		((ParserTextBlocksHandler) parser.getObserver()).setConnection(conn);
		TbUtil.constructContext(tokenInCurrentConnection, localContextBuilder);
		referringDocumentNode = tokenInCurrentConnection;
		// also rebuild the context for the parser,
		// as it may be used e.g. in foreach predicate references
		if (unresolvedRef.getType() == DelayedReference.TYPE_SEMANTIC_PREDICATE) {
		    parser.reset();
		    TbUtil.constructContext(tokenInCurrentConnection, parser);
		}
		if (!localContextBuilder.getContextStack().isEmpty()) {
		    unresolvedRef.setContextElement(localContextBuilder.getContextStack().peek());
		}

	    } else if (contextTextBlock != null) {
		TbUtil.constructContext(contextTextBlock, localContextBuilder);
		referringDocumentNode = contextTextBlock;
		if (!localContextBuilder.getContextStack().isEmpty()) {
		    unresolvedRef.setContextElement(localContextBuilder.getContextStack().peek());
		}
		cs = contextTextBlock.getType().getParseRule().getConcretesyntax();
		parser = registry.getParser(cs);
		// also rebuild the context for the parser,
		// as it may be used e.g. in foreach predicate references
		if (unresolvedRef.getType() == DelayedReference.TYPE_SEMANTIC_PREDICATE) {
		    parser.reset();
		    TbUtil.constructContext(contextTextBlock, parser);
		    ((ParserTextBlocksHandler) parser.getObserver()).setConnection(conn);
		    parser.setInjector(modelInjector);
		}

	    } else {
		registry.removeRegistration(unresolvedRef);
		notifier.notifyReferenceResolvingListenerReferencesRemoved(Collections.singleton(unresolvedRef));
		return;
	    }
	    // TODO set currentForeachElement on reference
	    try {
		boolean resolved = modelInjector.resolveReference(unresolvedRef, localContextBuilder.getContextManager(), parser);
		if (resolved) {
		    if (unresolvedRef.getType() == DelayedReference.TYPE_SEMANTIC_PREDICATE) {
			// to be able to incrementally re evaluate the reference
			// later
			// we need to setup a link between the textblock and the
			// template used in the ref
			Collection<Template> templates = ((ParserTextBlocksHandler) parser.getObserver()).getCurrentTbProxy()
				.getAdditionalTemplates();
			for (Template template : templates) {
			    if (!((TextBlock) unresolvedRef.getTextBlock()).getAdditionalTemplates().contains(template)) {
				((TextBlock) unresolvedRef.getTextBlock()).getAdditionalTemplates().add(template);
			    }
			}
			EObject value = (EObject) unresolvedRef.getRealValue();
			if (!referringDocumentNode.getCorrespondingModelElements().contains(value)) {
			    referringDocumentNode.getCorrespondingModelElements().add(value);
			}

			// TbUtil.addForEachContext(unresolvedRef.getTextBlock(),
			// (RefObject) unresolvedRef.getModelElement(),
			// (RefObject) unresolvedRef.getCurrentForeachElement(),
			// (ForeachPredicatePropertyInit)
			// unresolvedRef.getQueryElement(),
			// (RefObject) unresolvedRef.getRealValue(), conn);
			parser.setDelayedReferencesAfterParsing();
		    } else {
			if (unresolvedRef.getRealValue() instanceof EObject) {
			    referringDocumentNode.getReferencedElements().add((EObject) unresolvedRef.getRealValue());
			}
		    }
		    if (!unresolvedRef.isGenericReference()) {
			registry.removeRegistration(unresolvedRef);
			notifier.notifyReferenceResolvingListenerReferenceResolved(unresolvedRef);
		    }
		}
	    } catch (ModelElementCreationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }

	} catch (InvalidConnectionException ice) {
	    ice.printStackTrace();
	}
    }

    /**
     * Ensures that the {@link DelayedReference unresolvedRef} carries the
     * element using the correct connection given by <code>conn</code>.
     *
     * @param unresolvedRef
     *            the {@link DelayedReference} for which the elements should be
     *            checked.
     * @param conn
     *            the {@link Connection} where the elements should be used from.
     */
    private void ensureUsageOfConnection(DelayedReference unresolvedRef, ResourceSet conn) {
	EObject elementInCurrentConnection = (EObject) conn.getElement(((EObject) unresolvedRef.getModelElement()).get___Mri());
	if (elementInCurrentConnection == null) {
	    throw new RuntimeException("Element: " + unresolvedRef.getModelElement() + " is not available in connection: " + conn);
	} else {
	    unresolvedRef.setModelElement(elementInCurrentConnection);
	}
	Object elementInOldConnection = unresolvedRef.getContextElement();
	if (elementInOldConnection != null) {
	    elementInCurrentConnection = (EObject) conn.getElement(((EObject) elementInOldConnection).get___Mri());
	    if (elementInCurrentConnection == null) {
		throw new RuntimeException("Element: " + elementInOldConnection + " is not available in connection: " + conn);
	    } else {
		unresolvedRef.setContextElement(elementInCurrentConnection);
	    }
	}
	elementInOldConnection = unresolvedRef.getCurrentForeachElement();
	if (elementInOldConnection != null) {
	    elementInCurrentConnection = (EObject) conn.getElement(((EObject) elementInOldConnection).get___Mri());
	    if (elementInCurrentConnection == null) {
		throw new RuntimeException("Element: " + elementInOldConnection + " is not available in connection: " + conn);
	    } else {
		unresolvedRef.setCurrentForeachElement(elementInCurrentConnection);
	    }
	}
	elementInOldConnection = unresolvedRef.getQueryElement();
	if (elementInOldConnection != null) {
	    elementInCurrentConnection = (EObject) conn.getElement(((EObject) elementInOldConnection).get___Mri());
	    if (elementInCurrentConnection == null) {
		throw new RuntimeException("Element: " + elementInOldConnection + " is not available in connection: " + conn);
	    } else {
		unresolvedRef.setQueryElement(elementInCurrentConnection);
	    }
	}
	elementInOldConnection = unresolvedRef.getTextBlock();
	if (elementInOldConnection != null) {
	    elementInCurrentConnection = (EObject) conn.getElement(((EObject) elementInOldConnection).get___Mri());
	    if (elementInCurrentConnection == null) {
		throw new RuntimeException("Element: " + elementInOldConnection + " is not available in connection: " + conn);
	    } else {
		unresolvedRef.setTextBlock(elementInCurrentConnection);
	    }
	}
    }

    private ModelInjector constructModelInjector(ResourceSet connection, RefPackage outermostPackage) {
	// tokenNames only needed for parse error reporting regarding keyword
	// issues; not needed here
	ModelInjector mi = new ModelInjector(/* tonekNames */null);
	// Use global scope (null) for now
	TextBlocksAwareModelAdapter ma = new TextBlocksAwareModelAdapter(new MOINModelAdapter(outermostPackage, connection, /* partitionScope */
	null, /* criScope */null));
	mi.setModelAdapter(ma);
	return mi;
    }

    void queueNewUnresolvedReferences(Collection<DelayedReference> unresolvedIAReferences) {
	synchronized (unresolvedReferences) {
	    unresolvedReferences.addAll(unresolvedIAReferences);
	}
    }

    public boolean hasEmptyQueue() {
	synchronized (unresolvedReferences) {
	    return unresolvedReferences.isEmpty();
	}
    }

    /**
     * Clears all currently deferred references.
     *
     * This should <b>ONLY</b> be used in <b>tests</b>.
     */
    public void clearUnresolvedReferences() {
	synchronized (this) {
	    synchronized (unresolvedReferences) {
		unresolvedReferences.clear();
	    }
	}
    }

}
