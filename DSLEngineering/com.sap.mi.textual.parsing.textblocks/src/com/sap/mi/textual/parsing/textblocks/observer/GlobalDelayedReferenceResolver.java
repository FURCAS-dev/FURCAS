package com.sap.mi.textual.parsing.textblocks.observer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.regex.Matcher;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import tcs.ClassTemplate;
import tcs.ConcreteSyntax;
import tcs.ContextTemplate;
import tcs.FilterParg;
import tcs.ForeachPredicatePropertyInit;
import tcs.InjectorAction;
import tcs.InjectorActionsBlock;
import tcs.LookupPropertyInit;
import tcs.PredicateSemantic;
import tcs.Property;
import tcs.QueryParg;
import tcs.Template;
import textblockdefinition.TextBlockDefinition;
import textblockdefinition.TextblockDefinitionReferencesProduction;
import textblocks.AbstractToken;
import textblocks.DocumentNode;
import textblocks.LexedToken;
import textblocks.LexedTokenReferenesSequenceElement;
import textblocks.TextBlock;
import textblocks.TextBlockAdditionalTemplates;
import textblocks.TextBlockType;
import textblocks.VersionEnum;

import com.sap.mi.textual.common.exceptions.ModelAdapterException;
import com.sap.mi.textual.common.interfaces.IRuleName;
import com.sap.mi.textual.grammar.ModelElementCreationException;
import com.sap.mi.textual.grammar.impl.DelayedReference;
import com.sap.mi.textual.grammar.impl.ModelElementProxy;
import com.sap.mi.textual.grammar.impl.ModelInjector;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.mi.textual.grammar.impl.ParsingError;
import com.sap.mi.textual.grammar.impl.context.ContextManager;
import com.sap.mi.textual.parsing.textblocks.LexedTokenWrapper;
import com.sap.mi.textual.parsing.textblocks.LocalContextBuilder;
import com.sap.mi.textual.parsing.textblocks.TbUtil;
import com.sap.mi.textual.parsing.textblocks.TextBlocksAwareModelAdapter;
import com.sap.mi.textual.tcs.util.TcsUtil;
import com.sap.tc.moin.globalmodellistener.Activator;
import com.sap.tc.moin.globalmodellistener.GlobalEventListener;
import com.sap.tc.moin.globalmodellistener.GlobalEventListenerRegistry;
import com.sap.tc.moin.ocl.ia.Statistics;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.InvalidConnectionException;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.PartitionEditingNotPossibleException;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.EventListener;
import com.sap.tc.moin.repository.events.PreChangeListener;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.filter.InstanceFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ElementDeleteEvent;
import com.sap.tc.moin.repository.events.type.LinkRemoveEvent;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.mmi.model.Aliases;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.Import;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.model.TypedElement;
import com.sap.tc.moin.repository.mmi.reflect.InvalidObjectException;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.repository.ocl.freestyle.OclExpressionRegistration;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationSeverity;
import com.sap.tc.moin.textual.moinadapter.adapter.MOINModelAdapter;
import com.sap.tc.moin.textual.moinadapter.adapter.MoinHelper;

public class GlobalDelayedReferenceResolver implements GlobalEventListener,
	PreChangeListener, UpdateListener {
    private static final String TEMPORARY_QUERY_PARAM_REPLACEMENT = "__TEMP__";

    public class IAExpressionInvalidationChangeListener implements
	    UpdateListener {

	private final OclExpressionRegistration registration;
	private final DelayedReference reference;

	public IAExpressionInvalidationChangeListener(
		OclExpressionRegistration registration, DelayedReference ref) {
	    this.registration = registration;
	    this.reference = ref;
	}

	@Override
	public void notifyUpdate(EventChain events) {
	    for (ChangeEvent event : events.getEvents()) {
		Connection conn = event.getEventTriggerConnection();
		if(reference.isGenericReference()) {
		     //Its a generic reference not an unresolved one
		     if(reference.getQueryElement() != null) {
			 if(reference.getQueryElement() instanceof InjectorAction) {
			     InjectorAction injectorAction = (InjectorAction) conn.getElement(((Partitionable)reference.getQueryElement()).get___Mri());
			     InjectorActionsBlock injectorActionsBlock = (InjectorActionsBlock)injectorAction.refImmediateComposite();
			     Template template = injectorActionsBlock.getParentTemplate();
			     //now find all TextBlocks referencing this template;
			     TextblockDefinitionReferencesProduction tbDefAssoc = conn.getAssociation(TextblockDefinitionReferencesProduction.ASSOCIATION_DESCRIPTOR);
			     TextBlockDefinition def = tbDefAssoc.getTextBlockDefinition(template).iterator().next();
			     TextBlockType tbTypeAssoc = conn.getAssociation(TextBlockType.ASSOCIATION_DESCRIPTOR);
			     //TODO use affectedModelElements instead but first find out which elements are actually contained in there
			     Collection<TextBlock> tbs = new ArrayList<TextBlock>(tbTypeAssoc.getTextBlock(def));
			     //now find all TextBlocks that reference the template in their "additionalTemplate"
			     TextBlockAdditionalTemplates tbAdditionalAssoc = conn.getAssociation(TextBlockAdditionalTemplates.ASSOCIATION_DESCRIPTOR);
			     Collection<TextBlock> additionalTbs = tbAdditionalAssoc.getTextblock(template);
			     tbs.addAll(additionalTbs);
			     Set<MRI> affectedElements = null;
			     for (TextBlock textBlock : tbs) {
				//first check if the alternative in which the injector action resides was
				//chosen during the parsing process
				//TODO this is a workaround. to properly decide this we need to keep track
				//of the alternative chosen at runtime of the parser
				boolean wasInChosenAlternative = false;
				for (AbstractToken tok : textBlock.getTokens()) {
					if(tok instanceof LexedToken) {
						LexedToken lt = (LexedToken)tok;
						//check if injectoraction was in chosen alternative or directly in in the template
						if(lt.getSequenceElement() != null &&
							(lt.getSequenceElement().getElementSequence().equals(
								injectorActionsBlock.getElementSequence())
								|| injectorActionsBlock.getElementSequence().refImmediateComposite() instanceof ContextTemplate)) {
							wasInChosenAlternative = true;
							break;
						}
					}
				}
				
				if (wasInChosenAlternative) {
				    if (affectedElements == null) {
					affectedElements = getAffectedElements(events, conn);
				    }
				    Set<RefObject> intersectionOfCorrespondingAndAffectedElements = filterWithAffectedElements(
					    conn, affectedElements, textBlock);
				    for (RefObject ro : intersectionOfCorrespondingAndAffectedElements) {
					DelayedReference clonedRef = (DelayedReference) reference.clone();
					clonedRef.setModelElement(ro);
					clonedRef.setRealValue(null);
					clonedRef.setTextBlock(textBlock);
					clonedRef.setConnection(conn);
					GlobalDelayedReferenceResolver.this.iaUnresolvedReferences.add(clonedRef);
					// reference.setModelElement(null);
				    }
				}
			    }
			 } else if(reference.getQueryElement() instanceof Property) {
			     Property property = (Property) conn.getElement(((Partitionable)reference.getQueryElement()).get___Mri());
			     //now find all TextBlocks referencing this property;
			     LexedTokenReferenesSequenceElement lexedTokenSeqElAssoc = conn.getAssociation(LexedTokenReferenesSequenceElement.ASSOCIATION_DESCRIPTOR);
			     Collection<LexedToken> toks = lexedTokenSeqElAssoc.getLexedtoken(property);
			     Set<MRI> affectedElements = null;
			     for (LexedToken lt : toks) {
				 if (affectedElements == null) {
				     affectedElements = getAffectedElements(events, conn);
				 }
				Set<RefObject> intersectionOfCorrespondingAndAffectedElements = filterWithAffectedElements(
					conn, affectedElements, lt.getParentBlock());
				for (RefObject ro : intersectionOfCorrespondingAndAffectedElements) {
				    DelayedReference clonedRef = (DelayedReference) reference.clone();
                                    clonedRef.setModelElement(ro);
                                    clonedRef.setRealValue(null);
                                    clonedRef.setConnection(conn);
                                    
                                    clonedRef.setToken(new LexedTokenWrapper(lt));
                                    clonedRef.setKeyValue(lt.getValue());
				    String oclQuery = clonedRef.getOclQuery();
				    clonedRef.setOclQuery(oclQuery.replaceAll(TEMPORARY_QUERY_PARAM_REPLACEMENT, lt.getValue()));
				    GlobalDelayedReferenceResolver.this.iaUnresolvedReferences.add(clonedRef);
				}
			    }
			 }
		     }
                     backgroundResolver.scheduleIfNeeded();
                     
		 } else {
		    // TODO (for Thomas) this code can probably be removed
		    RefObject element = (RefObject) conn.getElement(((RefObject) reference.getModelElement())
			    .get___Mri());
		    if (element == null) {
			// Element doesnt exist anymore, so reference can be removed
			GlobalDelayedReferenceResolver.this.removeRegistration(reference);
			return;
		    }
		    RefPackage outermostPackage = getOutermostPackageThroughClusteredImports(conn, element);
		    GlobalDelayedReferenceResolver.this.reEvaluateUnresolvedRef(conn, outermostPackage, this.reference);
		}
	    }
	}

	/**
	 * Filters the given elements with the corresponding elements of the given {@link TextBlock}.
	 * 
	 * @param conn the connection used to resolve the MRIs within affecedElements
	 * @param affectedElements Elements that were affected by 
	 * @param tb The {@link TextBlock} which's corresponding elements should be filtered.
	 * @return the intersection between affected elements and the corresponding elements of the given {@link TextBlock}. 
	 */
	private Set<RefObject> filterWithAffectedElements(Connection conn,
		Set<MRI> affectedElements, TextBlock tb) {
		List<RefObject> correspondingModelElements = tb.getCorrespondingModelElements();
		Set<RefObject> intersectionOfCorrespondingAndAffectedElements = new HashSet<RefObject>(correspondingModelElements);
		if (intersectionOfCorrespondingAndAffectedElements.size() > 1) {
		    List<MRI> correspondingModelElementsMris = new ArrayList<MRI>(correspondingModelElements.size());
		    for (RefObject cme : correspondingModelElements) {
			correspondingModelElementsMris.add(cme.get___Mri());
		    }
		    
		    Set<MRI> intersectionOfCorrespondingAndAffectedElementsMris = new HashSet<MRI>(affectedElements);
		    intersectionOfCorrespondingAndAffectedElementsMris.retainAll(correspondingModelElementsMris);
		    intersectionOfCorrespondingAndAffectedElements.clear();
		    for (MRI mri : intersectionOfCorrespondingAndAffectedElementsMris) {
			intersectionOfCorrespondingAndAffectedElements.add((RefObject) conn.getElement(mri));
		    }
		}
		return intersectionOfCorrespondingAndAffectedElements;
	}

	private Set<MRI> getAffectedElements(EventChain events, Connection conn) {
	    Statistics.getInstance().setCurrentObjectForSelf(reference.getElementForSelf());
	    Set<MRI> affectedElements = new HashSet<MRI>();
	    for (ChangeEvent e : events.getEvents()) {
	     if (e instanceof ModelChangeEvent) {
	         affectedElements.addAll(
	    	     registration.getAffectedModelElements((ModelChangeEvent) e, conn));
	     }
	     }
	    return affectedElements;
	}
    }

    public class DeletionListener implements UpdateListener {

	private final DelayedReference unresolvedRef;

	public DeletionListener(DelayedReference unresolvedRef) {
	    this.unresolvedRef = unresolvedRef;
	}

	@Override
	public void notifyUpdate(EventChain events) {
	    for (ChangeEvent event : events.getEvents()) {

		if (event instanceof ElementDeleteEvent) {
		    // ElementDeleteEvent delEvent = (ElementDeleteEvent) event;
		    removeRegistration(unresolvedRef);
		    notifyReferenceResolvingListenerReferencesRemoved(Collections
			    .singleton(unresolvedRef));
		}
	    }
	}

    }
    
    public class BackgroundResolver  {
	
	private final GlobalDelayedReferenceResolver resolver;
	private final Job job;
	private boolean runInAsynchronousModus = true;
	
        public BackgroundResolver(final GlobalDelayedReferenceResolver resolver) {
	    this.resolver = resolver;
	    
	    this.job = new Job("Reevaluating OCL References") {
		
		@Override
	        public IStatus run(final IProgressMonitor monitor) {
		    resolver.resolveReferences(monitor);
		    if (resolver.hasEmptyQueue()) {
			return Status.OK_STATUS;
		    } else {
			return new Status(Status.WARNING, Activator.PLUGIN_ID, "Could not resolve all delayed references.");
		    }
	        }
	    };
	}

	public void scheduleIfNeeded() {
	    if (!resolver.hasEmptyQueue()) {
		if (runInAsynchronousModus) {
		    job.schedule(500);
		} else {
		    resolver.resolveReferences(new NullProgressMonitor());
		}
	    }
	}
	
	public void runInAsynchronousMode(boolean isAsync) {
	    this.runInAsynchronousModus = isAsync;
	}
	
	public boolean isBackgroundJobRunningOrScheduled() {
	    return this.job.getState() != Job.NONE; 
	}
    }

    // public class KeyAttributeSetListener implements UpdateListener {
    //
    // private final DelayedReference unresolvedRef;
    //
    // public KeyAttributeSetListener(DelayedReference unresolvedRef) {
    // this.unresolvedRef = unresolvedRef;
    // }
    //
    // @Override
    // public void notifyUpdate(EventChain events) {
    // for (ChangeEvent event : events.getEvents()) {
    //
    // if (event instanceof AttributeValueChangeEvent) {
    // AttributeValueChangeEvent attEvent = (AttributeValueChangeEvent) event;
    // // Only trigger re-resolving if value changed to the one the
    // // ref is waiting for
    // if (attEvent.getNewValue() != null &&
    // attEvent.getNewValue().equals(unresolvedRef.getKeyValue())) {
    // Connection conn = event.getEventTriggerConnection();
    //
    // RefPackage outermostPackage = getOutermostPackageThroughClusteredImports(
    // conn, attEvent.getAffectedElement(conn));
    // GlobalDelayedReferenceResolver.this.reEvaluateUnresolvedRef(
    // conn, outermostPackage, this.unresolvedRef);
    // }
    // }
    // }
    // }
    //
    //	
    //
    //	
    // }

    private final Set<DelayedReference> unresolvedReferences = new HashSet<DelayedReference>();

    public Set<DelayedReference> getUnresolvedReferences() {
	return unresolvedReferences;
    }

    private final Map<DelayedReference, Map<EventFilter, Map<ListenerType, EventListener>>> refsToListners = new HashMap<DelayedReference, Map<EventFilter, Map<ListenerType, EventListener>>>();
    private final Map<DelayedReference, Map<EventFilter, Map<ListenerType, EventListener>>> refsToDeletionListners = new HashMap<DelayedReference, Map<EventFilter, Map<ListenerType, EventListener>>>();
    private final Set<ReferenceResolvingListener> listeners = new HashSet<ReferenceResolvingListener>(
	    1);
    private final Map<LexedToken, DelayedReference> token2References = new HashMap<LexedToken, DelayedReference>();
    private static GlobalDelayedReferenceResolver instance;
    /**
     * The OSGi bundle context; will be initialized when {@link #getFilters} is
     * called.
     */
    private BundleContext context;

    private ServiceReference globalEventListenerRegistryRef;
    private final Map<String, DelayedReference> registration2DelayedReference = new HashMap<String, DelayedReference>();
    private final Map<DelayedReference, String> delayedReference2Registration = new HashMap<DelayedReference, String>();

    private final Map<DelayedReference, Map<EventFilter, Map<ListenerType, EventListener>>> delayedReference2ReEvaluationListener = new HashMap<DelayedReference, Map<EventFilter, Map<ListenerType, EventListener>>>();
    private final Set<ConcreteSyntax> registeredSytaxes = new HashSet<ConcreteSyntax>();
    private final Collection<DelayedReference> iaUnresolvedReferences = new Vector<DelayedReference>();
    private final BackgroundResolver backgroundResolver;
    private Map<ConcreteSyntax, ObservableInjectingParser> parsersBySyntax = new HashMap<ConcreteSyntax, ObservableInjectingParser>();

    public GlobalDelayedReferenceResolver() {
	// Do the assignment here as the constructor will be invoked by the
	// extension point.
	instance = this;
	backgroundResolver = new BackgroundResolver(this);
    }

    public static synchronized GlobalDelayedReferenceResolver getInstance() {
	return instance;
    }
    
    public boolean hasEmptyQueue() {
        return iaUnresolvedReferences.isEmpty();
    }
    
    /**
     * Clears all currently deferred references.
     * 
     * This should ONLY be used in tests.
     */
    public void clearUnresolvedIAReferences() {
	assert !backgroundResolver.isBackgroundJobRunningOrScheduled();
	iaUnresolvedReferences.clear();
    }
    
    /**
     * Set to false to run synchronously. This is useful for testcases.
     * @param isAsync
     */
    public void runInAsynchronousMode(boolean isAsync) {
	backgroundResolver.runInAsynchronousMode(isAsync);
    }

    public void removeRegistration(DelayedReference unresolvedRef) {
	unresolvedReferences.remove(unresolvedRef);
	if(unresolvedRef.getToken() != null) {
	    token2References.remove(((LexedTokenWrapper) unresolvedRef.getToken())
		.getWrappedToken());
	}

	GlobalEventListenerRegistry registry = (GlobalEventListenerRegistry) context
		.getService(globalEventListenerRegistryRef);
	Map<EventFilter, Map<ListenerType, EventListener>> removeListener = refsToDeletionListners
		.remove(unresolvedRef);
	if (removeListener != null) {
	    registry.removeFilters(removeListener);
	}
	removeListener = refsToListners.remove(unresolvedRef);
	if (removeListener != null) {
	    registry.removeFilters(removeListener);
	}
	String reg = delayedReference2Registration.remove(unresolvedRef);
	registration2DelayedReference.remove(reg);
	Map<EventFilter, Map<ListenerType, EventListener>> filter = delayedReference2ReEvaluationListener
		.remove(unresolvedRef);
	if (filter != null) {
	    registry.removeFilters(filter);
	}
    }

    /**
     * The given {@link DelayedReference} will be registered and resolved as
     * soon as possible.
     * 
     * @param unresolvedRef
     * @param referringToken
     *            The model element token referring to the element searched by
     *            the unresolved reference. if given this token will replace the
     *            {@link DelayedReference#getToken()}.
     * @param buildNewContext
     *            If a token is given in <tt>referringToken</tt>
     *            <tt>useContext</tt> indicated wether this token should be used
     *            to construct a new context for the reference.
     */
    public void registerUnresolvedReference(DelayedReference unresolvedRef,
	    LexedToken referringToken, boolean buildNewContext) {
	if (unresolvedRef.getModelElement() == null
		|| !((RefObject) unresolvedRef.getModelElement()).is___Alive()) {
	    return;
	}
	if (referringToken != null) {
	    unresolvedRef.setToken(new LexedTokenWrapper(referringToken));
	    if (buildNewContext) {
		LocalContextBuilder localContextBuilder = new LocalContextBuilder();
		TbUtil.constructContext(referringToken, localContextBuilder);
		unresolvedRef.setContextElement(localContextBuilder
			.getContextStack().isEmpty() ? null
			: localContextBuilder.getContextStack().peek());
	    }
	}

	DelayedReference registeredRefForToken = token2References
		.get(referringToken);
	if (registeredRefForToken != null) {
	    // there is an existing reference for the token, as a new delayed
	    // reference was created for it
	    // this one is out of date, so remove it.
	    removeRegistration(registeredRefForToken);
	}
	unresolvedReferences.add(unresolvedRef);
	token2References.put(referringToken, unresolvedRef);

	Connection conn = ((Partitionable) unresolvedRef.getModelElement())
		.get___Connection();

	Map<EventFilter, Map<ListenerType, EventListener>> resolveListener = null;
	// createResolveListener(conn, unresolvedRef);
	if (false /*resolveListener != null*/) {
	    // also register a deletion listener that removes all registrations
	    // if the model element was deleted.
	    Map<EventFilter, Map<ListenerType, EventListener>> deletionListener = createDeletionListener(
		    conn, unresolvedRef);
	    GlobalEventListenerRegistry registry = (GlobalEventListenerRegistry) context
		    .getService(globalEventListenerRegistryRef);
	    registry.addFilters(resolveListener);
	    registry.addFilters(deletionListener);
	    refsToListners.put(unresolvedRef, resolveListener);
	    refsToDeletionListners.put(unresolvedRef, deletionListener);
	} else {
	    registerReferenceForIncrementalEvaluation(unresolvedRef,
		    referringToken, conn);
	}
	notifyReferenceResolvingListenerReferenceAdded(unresolvedRef);
    }

    private Map<EventFilter, Map<ListenerType, EventListener>> createDeletionListener(
	    Connection conn, DelayedReference unresolvedRef) {
	EventFilter filter = new InstanceFilter(((RefObject) unresolvedRef
		.getModelElement()).get___Mri());
	Map<ListenerType, EventListener> listenerForType = new HashMap<ListenerType, EventListener>();
	listenerForType.put(ListenerType.UPDATE, new DeletionListener(
		unresolvedRef));
	Map<EventFilter, Map<ListenerType, EventListener>> map = new HashMap<EventFilter, Map<ListenerType, EventListener>>();
	map.put(filter, listenerForType);
	return map;
    }

    @Override
    public Map<EventFilter, Map<ListenerType, EventListener>> getFilters(
	    Connection connection, BundleContext bundleContext) {
	this.context = bundleContext;
	globalEventListenerRegistryRef = context
		.getServiceReference(GlobalEventListenerRegistry.class
			.getName());
	HashMap<EventFilter, Map<ListenerType, EventListener>> result = new HashMap<EventFilter, Map<ListenerType, EventListener>>();
	//addFilterAndListenerForDeleteEvent(connection, result);
	return result;
    }

//    private void addFilterAndListenerForDeleteEvent(Connection connection,
//	    HashMap<EventFilter, Map<ListenerType, EventListener>> result) {
//	DocumentNodeReferencedElement refAssoc = connection
//		.getAssociation(DocumentNodeReferencedElement.ASSOCIATION_DESCRIPTOR);
//	Association tbAssoc = refAssoc.refMetaObject();
//	EventFilter filter = new AssociationFilter(tbAssoc);
//	Map<ListenerType, EventListener> listenerForType = new HashMap<ListenerType, EventListener>();
//	listenerForType.put(ListenerType.PRE_CHANGE, this);
//	result.put(filter, listenerForType);
//
//	// also register event for deletion of element to remove from unresolved
//	// references if element is deleted
//	EventFilter deleteFilter = new EventTypeFilter(ElementDeleteEvent.class);
//	Map<ListenerType, EventListener> listenerForDeleteEvent = new HashMap<ListenerType, EventListener>();
//	listenerForDeleteEvent.put(ListenerType.UPDATE, this);
//	result.put(deleteFilter, listenerForDeleteEvent);
//    }

    public RefPackage getOutermostPackageThroughClusteredImports(
	    Connection conn, RefBaseObject refObject) {
	RefPackage result = refObject.refOutermostPackage();
	RefPackage candidate = result;
	while (candidate != null) {
	    // ascend the clustered imports in the metamodel
	    MofPackage p = candidate.refMetaObject();
	    candidate = null;
	    Aliases a = conn.getAssociation(Aliases.ASSOCIATION_DESCRIPTOR);
	    for (Import i : a.getImporter(p)) {
		if (i.isClustered()) {
		    MofPackage importer = (MofPackage) i.getContainer();
		    candidate = conn.getJmiHelper().getRefPackageForMofPackage(
			    importer);
		    result = candidate;
		    break;
		}
	    }
	}
	return result;
    }

    public void reEvaluateUnresolvedRef(Connection conn,
	    RefPackage outermostPackage, DelayedReference unresolvedRef) {
	reEvaluateUnresolvedRef(conn, outermostPackage, unresolvedRef, null);
    }

    public void reEvaluateUnresolvedRef(Connection conn,
	    RefPackage outermostPackage, DelayedReference unresolvedRef,
	    TextBlock contextTextBlock) {
	LocalContextBuilder localContextBuilder = new LocalContextBuilder();
	try {
	    LexedTokenWrapper token = (LexedTokenWrapper) unresolvedRef
		    .getToken();
	    DocumentNode referringDocumentNode = null;
	    ConcreteSyntax cs;
        if (token != null) {
		AbstractToken modelElementToken = token.getWrappedToken();
		LexedToken tokenInCurrentConnection = (LexedToken) conn
			.getElement(modelElementToken.get___Mri());
		if (tokenInCurrentConnection == null
			|| unresolvedRef.getModelElement() == null) {
		    removeRegistration(unresolvedRef);
		    notifyReferenceResolvingListenerReferencesRemoved(Collections
			    .singleton(unresolvedRef));
		    return;
		}
		TbUtil.constructContext(tokenInCurrentConnection,
			localContextBuilder);
		referringDocumentNode = tokenInCurrentConnection;
		if(!localContextBuilder.getContextStack().isEmpty()) {
		    unresolvedRef.setContextElement(localContextBuilder.getContextStack().peek());
		}
		cs = token.getParentBlock().getType().getParseRule().getConcretesyntax();
	    } else if (contextTextBlock != null) {
		TbUtil.constructContext(contextTextBlock, localContextBuilder);
		referringDocumentNode = contextTextBlock;
		if(!localContextBuilder.getContextStack().isEmpty()) {
		    unresolvedRef.setContextElement(localContextBuilder.getContextStack().peek());
		}
		cs = contextTextBlock.getType().getParseRule().getConcretesyntax();
	    } else {
		removeRegistration(unresolvedRef);
		notifyReferenceResolvingListenerReferencesRemoved(Collections
			.singleton(unresolvedRef));
		return;
	    }

	    try {
		// ensure that the model element uses the current connection
		RefObject elementInCurrentConnection = (RefObject) conn
			.getElement(((Partitionable) unresolvedRef
				.getModelElement()).get___Mri());
		if (elementInCurrentConnection != null) {
		    unresolvedRef.setModelElement(elementInCurrentConnection);
		    boolean resolved = constructModelInjector(conn,
			    outermostPackage).resolveReference(unresolvedRef,
			    localContextBuilder.getContextManager(), 
			    getParser(cs));
		    if (resolved) {
			if(unresolvedRef.getRealValue() instanceof RefObject) {
			    referringDocumentNode.getReferencedElements().add(
					(RefObject) unresolvedRef.getRealValue());
			}
			if(!unresolvedRef.isGenericReference()) {
			    removeRegistration(unresolvedRef);
			    notifyReferenceResolvingListenerReferenceResolved(unresolvedRef);
			}
		    }
		} else {
		    removeRegistration(unresolvedRef);
		}
	    } catch (ModelElementCreationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }

	} catch (InvalidConnectionException ice) {
	    ice.printStackTrace();
	}
    }

    private ObservableInjectingParser getParser(ConcreteSyntax concretesyntax) {
        return parsersBySyntax.get(concretesyntax);
    }

    @Override
    public void prepare(ChangeEvent event) {
	// TODO this is probably also dead code
	if (event instanceof LinkRemoveEvent) {
	    LinkRemoveEvent lre = (LinkRemoveEvent) event;
	    MRI documentNodeMri = lre.getFirstLinkEndMri();
	    Connection conn = event.getEventTriggerConnection();
	    DocumentNode documentNode = (DocumentNode) conn
		    .getElement(documentNodeMri);
	    if (documentNode instanceof LexedToken) {
		LexedToken lt = (LexedToken) documentNode;
		// Only if an persistent link is deleted which is the case only
		// for REFRENCE Version DocumentNodes
		if (VersionEnum.REFERENCE.equals(lt.getVersion())) {
		    LocalContextBuilder localContextBuilder = new LocalContextBuilder();
		    TbUtil.constructContext(lt, localContextBuilder);
		    // FIXME context elements are not filled; where do we need
		    // to
		    // build up
		    // those contents? Only upon lookup?
		    if (lt.getParentBlock().getCorrespondingModelElements()
			    .size() > 0
			    && lt.getSequenceElement() instanceof Property) {
			Property se = (Property) lt.getSequenceElement();
			if (se != null) {
			    DelayedReference unresolvedRef = new DelayedReference(
				    // the next outer context element, as
				    // obtained from
				    // the
				    // re-constructed
				    // context stack:
				    localContextBuilder.getContextStack()
					    .isEmpty() ? null
					    : localContextBuilder
						    .getContextStack().peek(),
				    // the model element on which the reference
				    // is to be set, obtained from
				    // the parent text block corresponding with
				    // the template containing the reference
				    // FIXME link could be broken; what to do?
				    // FIXME what about referenceOnly templates
				    // and how to resolve them?
				    lt.getParentBlock()
					    .getCorrespondingModelElements()
					    .iterator().next(),
				    // the name of the property to be set by the
				    // reference
				    /* propertyName */
				    se.getPropertyReference().getStrucfeature()
					    .getName(),
				    /* keyName */
				    TcsUtil.getRefersToParg(se) != null ? TcsUtil
					    .getRefersToParg(se)
					    .getPropertyName()
					    : null,
				    /* keyValue */lt.getValue(),
				    /* oclQuery */TcsUtil.getQueryParg(se) != null ? TcsUtil
					    .getQuery(se)
					    : null,
				    /* isOptional */isOptional(se
					    .getPropertyReference()
					    .getStrucfeature()),
				    /* token */new LexedTokenWrapper(lt));
			    registerUnresolvedReference(unresolvedRef, null,
				    false);
			}
		    }
		}
	    }
	}
    }

    private boolean isOptional(TypedElement strucfeature) {
	if (strucfeature instanceof AssociationEnd) {
	    AssociationEnd end = (AssociationEnd) strucfeature;
	    return end.getMultiplicity().getLower() == 0;

	}
	if (strucfeature instanceof StructuralFeature) {
	    StructuralFeature feat = (StructuralFeature) strucfeature;
	    return feat.getMultiplicity().getLower() == 0;
	}
	return false;
    }

    @Override
    public void notifyUpdate(EventChain events) {
	for (ChangeEvent event : events.getEvents()) {

	    if (event instanceof ElementDeleteEvent) {
		ElementDeleteEvent delEvent = (ElementDeleteEvent) event;
		Collection<DelayedReference> refs = new ArrayList<DelayedReference>();
		for (DelayedReference ref : new ArrayList<DelayedReference>(
			unresolvedReferences)) {
		    if (delEvent.getAffectedElementMri().equals(
			    ((RefObject) ref.getModelElement()).get___Mri())) {
			removeRegistration(ref);
			refs.add(ref);
		    }
		}
		notifyReferenceResolvingListenerReferencesRemoved(refs);
	    }
	}
    }

    // /**
    // * Creates a combination of {@link EventFilter} and {@link ListenerType} +
    // * {@link EventListener} for the given {@link DelayedReference}
    // * <tt>unresolvedRef</tt>. The Event is triggered if, at any class
    // * instance the attribute which is uses as keyValue of the reference is
    // set
    // * to the keyValue given by the reference. This might be a good point in
    // * time to try re-resolving the reference. TODO: However this could be
    // * improved by using Impact Analyis for this task.
    // *
    // * @param conn
    // * @param unresolvedRef
    // * @return
    // */
    // private Map<EventFilter, Map<ListenerType, EventListener>>
    // createResolveListener(
    // Connection conn, DelayedReference unresolvedRef) {
    // // TODO currently only attribute based refrences are supported. -> Add
    // // supported for
    // // lookIn Property inits which may also refer to references!!
    // MofClass parentElementMofClass = ((MofClass) ((RefObject) unresolvedRef
    // .getModelElement()).refMetaObject());
    // Reference property = conn.getJmiHelper().getReferenceByName(
    // parentElementMofClass, unresolvedRef.getPropertyName(), true);
    // if(property != null) {
    // Attribute referredKeyAttribute = conn.getJmiHelper()
    // .getAttributeByName((MofClass) property.getType(),
    // unresolvedRef.getKeyName(), true);
    // if (referredKeyAttribute != null) {
    // EventFilter filter = new AttributeFilter(referredKeyAttribute);
    // Map<ListenerType, EventListener> listenerForType = new
    // HashMap<ListenerType, EventListener>();
    // listenerForType.put(ListenerType.UPDATE,
    // new KeyAttributeSetListener(unresolvedRef));
    // Map<EventFilter, Map<ListenerType, EventListener>> map = new
    // HashMap<EventFilter, Map<ListenerType, EventListener>>();
    // map.put(filter, listenerForType);
    // return map;
    // }
    // }
    // return null;
    // }

    /**
     * Tries to resolved <tt>unresolvedRef</tt>. Returns <tt>true</tt> if
     * successful, <tt>false</tt> otherwise.
     */
    @SuppressWarnings("unused")
    // preparing the resolver
    private boolean resolveAll(Connection connection,
	    DelayedReference unresolvedRef, RefPackage outermostPackage) {
	// TODO need to construct the "context" inside out
	ModelInjector mi = constructModelInjector(connection, outermostPackage);

	/*
	 * It is assumed here that at this point of time, the code structure
	 * guarantees that the list of delayed References does not contain any
	 * IModelElementproxy elements, neither does the ContextManager contain
	 * any IModelElementProxy object.
	 */
	// try to resolve references as long as there are new references
	// resolved
	// this is done because the actual optimal ordering is not known at
	// this point
	boolean resolvedNewReference = true;
	while (!unresolvedReferences.isEmpty() && resolvedNewReference) {
	    // clear the error list as the errors might get resolved within
	    // the next iteration
	    // if not they will be added again anyways
	    mi.getErrorList().clear();
	    resolvedNewReference = false;
	    for (Iterator<DelayedReference> iterator = unresolvedReferences
		    .iterator(); iterator.hasNext();) {
		DelayedReference reference = iterator.next();
		try {
		    LocalContextBuilder localContextBuilder = new LocalContextBuilder();
		    TbUtil.constructContext(((LexedTokenWrapper) reference
			    .getToken()), localContextBuilder);
		    boolean newlyResolved = mi.resolveReference(reference,
			    localContextBuilder.getContextManager(), (ObservableInjectingParser)null);
		    if (newlyResolved) {
			iterator.remove();
			resolvedNewReference = true;
		    }

		    if (reference.getRealValue() != null) {
			/*
			 * Object me = (reference.getModelElement() instanceof
			 * IModelElementProxy) ? ((IModelElementProxy) reference
			 * .getModelElement()).getRealObject() :
			 * reference.getModelElement();
			 */
			// onRuleElementResolvedOutOfContext(reference
			// .getRealValue(), me, reference.getToken());
		    }
		} catch (ModelElementCreationException e) {
		    mi.addError(new ParsingError(e.getMessage(), reference
			    .getToken()));
		}
	    }
	}
	return mi.getErrorList().size() == 0;
    }

    private ModelInjector constructModelInjector(Connection connection,
	    RefPackage outermostPackage) {
	// tokenNames only needed for parse error reporting regarding keyword
	// issues; not needed here
 	ModelInjector mi = new ModelInjector(/* tonekNames */null);
	// Use global scope (null) for now
	TextBlocksAwareModelAdapter ma = new TextBlocksAwareModelAdapter(
		new MOINModelAdapter(outermostPackage, connection, /* partitionScope */
		null, /* criScope */null));
	mi.setModelAdapter(ma);
	return mi;
    }

    /**
     * Removes the registration for all {@link DelayedReference delyed
     * references} in within <code>refs</code>.
     * 
     * @param refs
     */
    public void removeUnresolvedReferences(Collection<DelayedReference> refs) {
	for (DelayedReference delayedReference : refs) {
	    removeRegistration(delayedReference);
	}
	notifyReferenceResolvingListenerReferencesRemoved(refs);
    }

    /**
     * Registers a new {@link ReferenceResolvingListener} that gets notified on
     * registration as well as resolving of {@link DelayedReference delayed
     * references}.
     * 
     * @param listener
     *            The listener to be registered.
     */
    public void addReferenceResolvingListener(
	    ReferenceResolvingListener listener) {
	listeners.add(listener);
    }

    /**
     * Unregisters a {@link ReferenceResolvingListener} that gets notified on
     * registration as well as resolving of {@link DelayedReference delayed
     * references}.
     * 
     * @param listener
     *            The listener to be unregistered.
     */
    public void removeReferenceResolvingListener(
	    ReferenceResolvingListener listener) {
	listeners.remove(listener);
    }

    private void notifyReferenceResolvingListenerReferenceAdded(
	    DelayedReference ref) {
	for (ReferenceResolvingListener listener : listeners) {
	    listener.unresolvedReferenceRegistered(ref);
	}
    }

    private void notifyReferenceResolvingListenerReferenceResolved(
	    DelayedReference ref) {
	for (ReferenceResolvingListener listener : listeners) {
	    listener.referenceResolved(ref);
	}
    }

    private void notifyReferenceResolvingListenerReferencesRemoved(
	    Collection<DelayedReference> refs) {
	for (ReferenceResolvingListener listener : listeners) {
	    listener.outdatedReferencesRemoved(refs);
	}
    }

    public void registerReferenceForIncrementalEvaluation(DelayedReference ref,
	    LexedToken referringToken, Connection connection) {
	Object modelElement = ref.getModelElement();
	RefObject ro = null;
	if (modelElement instanceof RefObject) {
	    ro = (RefObject) modelElement;
	} else if (modelElement instanceof ModelElementProxy) {
	    ro = (RefObject) ((ModelElementProxy) modelElement).getRealObject();
	} else {
	    return;
	}

	if (referringToken != null) {
	    ref.setToken(new LexedTokenWrapper(referringToken));
	}

	RefPackage root = ro.refOutermostPackage();
	Collection<RefPackage> packagesForLookup = new ArrayList<RefPackage>();
	packagesForLookup.addAll(MoinHelper.getImportedRefPackages(root));
	packagesForLookup.add(root);
	try {
	    String query = MoinHelper.prepareOclQuery(ref.getOclQuery(), ref
		    .getContextElement(), ref.getKeyValue());
	    if (query != null) {
		String name = ro.refMofId() + ref.getPropertyName();
		OclExpressionRegistration registration = (OclExpressionRegistration) connection
			.getOclRegistryService().getFreestyleRegistry()
			.getRegistration(name);
		if (registration != null) {
		    connection.getOclRegistryService().getFreestyleRegistry()
			    .deleteRegistration(name);
		}
		registration = connection.getOclRegistryService()
			.getFreestyleRegistry().createExpressionRegistration(
				name, query, OclRegistrationSeverity.Info,
				new String[] { "TCS Property Init" },
				ro.refClass(),
				packagesForLookup.toArray(new RefPackage[] {}));
		Map<EventFilter, Map<ListenerType, EventListener>> reEvaluationListener = createReEvaluationListener(
			registration, ref);
		GlobalEventListenerRegistry registry = (GlobalEventListenerRegistry) context
			.getService(globalEventListenerRegistryRef);
		registry.addFilters(reEvaluationListener);
		registration2DelayedReference.put(registration.getName(), ref);
		delayedReference2Registration.put(ref, registration.getName());
		delayedReference2ReEvaluationListener.put(ref,
			reEvaluationListener);

	    }
	} catch (OclManagerException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (ModelAdapterException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    public void registerReferenceForIncrementalEvaluation(ConcreteSyntax cs,
	    Connection connection, RefPackage outermostPackageOfMetamodel, 
	    ObservableInjectingParser parser, IRuleName ruleNameBuilder,
	    IProgressMonitor monitor) {

	if (!registeredSytaxes.contains(cs)) {
	    parsersBySyntax.put(cs, parser);
	    Collection<RefPackage> packagesForLookup = new ArrayList<RefPackage>();
	    packagesForLookup.addAll(MoinHelper
		    .getImportedRefPackages(outermostPackageOfMetamodel));
	    packagesForLookup.add(outermostPackageOfMetamodel);
	    
	    MofClass elementClass = MoinHelper.getReflectElement(connection);

	    String mqlQuery = "select instance \n"
		    + "from TCS::InjectorAction as instance";

	    MQLResultSet resultSet = connection.getMQLProcessor().execute(
		    mqlQuery,
		    connection.getMQLProcessor()
			    .getInclusivePartitionScopeProvider(
				    cs.get___Partition().getPri()));
	    
	    mqlQuery = "select instance \n" + "from TCS::Property as instance";

            MQLResultSet resultSetQueries = connection.getMQLProcessor().execute(
                    mqlQuery,
                    connection.getMQLProcessor()
                            .getInclusivePartitionScopeProvider(
                                    cs.get___Partition().getPri()));
	    try {
        	monitor.beginTask("Registering OCL expressions for Impact Analysis for syntax: "
                    + cs.getName(), resultSet.getSize() + resultSetQueries.getSize());
        	monitor.subTask("PropertyInits");

                for (RefObject result : resultSet.getRefObjects("instance")) {
                    monitor.worked(1);
                    InjectorAction injectorActionBase = (InjectorAction) result;
                    //check if metamodel element is present
                    if(injectorActionBase.getInjectorActionsBlockReference().getParentTemplate().getMetaReference() == null) {
                        throw new RuntimeException("Cannot resolve reference to metamodel for template:\n" +
                                injectorActionBase.getInjectorActionsBlockReference().getParentTemplate().get___Mri() + "\n" +
                                "Make sure the metamodel is correctly referenced and loaded.");
                    }
                    if (injectorActionBase instanceof LookupPropertyInit) {
                        registerLookupPropertyInitForIA(cs, connection,
                                packagesForLookup, elementClass,
                                injectorActionBase);
                    } else if (injectorActionBase instanceof ForeachPredicatePropertyInit) {
                        registerForEachPropertyInitForIA(cs, connection,
                                packagesForLookup, elementClass,
                                injectorActionBase, ruleNameBuilder);
                    }
                } 
                monitor.subTask("Property Queries");

        	for (RefObject result : resultSetQueries.getRefObjects("instance")) {
        	    monitor.worked(1);
                    Property property = (Property) result;
                    registerPropertyQueryForIA(connection, packagesForLookup,
                            elementClass, property);
                }
	    } finally{
                //monitor.done();
            }
	    registeredSytaxes.add(cs);
	}
    }

    private void registerPropertyQueryForIA(Connection connection,
            Collection<RefPackage> packagesForLookup, MofClass elementClass,
            Property property) {
        Template template = property.getParentTemplate();
        if (template != null && template.getMetaReference() instanceof MofClass) {
            // TODO what about StructureTypes?
            QueryParg qarg = TcsUtil.getQueryParg(property);
            FilterParg filter = TcsUtil.getFilterParg(property);
            if (qarg != null) {
                try {
                    String query = qarg.getQuery();
                    if (filter != null) {
                        query += filter.getFilter();
                    }
                    RefObject parsingContext = null;
                    if (!MoinHelper.usesContext(query)) {
                        parsingContext = template.getMetaReference();
                    } else {
                        parsingContext = elementClass;
                        // TODO currently this works only if a "#context" is postfixed
                        // by a .oclAsType(...) expression.
                    }
                    DelayedReference ref = new DelayedReference(
                            null,
                            null,
                            property.getPropertyReference().getStrucfeature().getName(),
                            null, null, query, false, null);
                    query = MoinHelper.prepareOclQuery(query, null,
                        TEMPORARY_QUERY_PARAM_REPLACEMENT);
                    if (query != null) {
                        ref.setQueryElement(property);
                        ref.setGenericReference(true);
                        String name = "<genericReference>" + property.refMofId();
                        OclExpressionRegistration registration = (OclExpressionRegistration) connection
                            .getOclRegistryService().getFreestyleRegistry()
                            .getRegistration(name);
                        if (registration != null) {
                            connection.getOclRegistryService().getFreestyleRegistry()
                                .deleteRegistration(name);
                        }
                        registration = connection.getOclRegistryService()
                            .getFreestyleRegistry().createExpressionRegistration(name,
                                query, OclRegistrationSeverity.Info,
                                new String[] { "TCS Property Query" }, parsingContext,
                                packagesForLookup.toArray(new RefPackage[] {}));
                        Map<EventFilter, Map<ListenerType, EventListener>> reEvaluationListener = createReEvaluationListener(
                            registration, ref);
                        GlobalEventListenerRegistry registry = (GlobalEventListenerRegistry) context
                            .getService(globalEventListenerRegistryRef);
                        registry.addFilters(reEvaluationListener);
                        registration2DelayedReference.put(registration.getName(), ref);
                        delayedReference2Registration.put(ref, registration.getName());
                        delayedReference2ReEvaluationListener.put(ref,
                            reEvaluationListener);

                    }
                } catch (OclManagerException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (ModelAdapterException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch(MoinLocalizedBaseRuntimeException ex) {
                    System.err.println("Failed to register at IA: " + qarg.getQuery() + "\n" + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        }
    }

    private void registerForEachPropertyInitForIA(ConcreteSyntax cs,
            Connection connection, Collection<RefPackage> packagesForLookup,
            MofClass elementClass, InjectorAction injectorActionBase, IRuleName ruleNameFinder) {
        ForeachPredicatePropertyInit foreachPredicatePropertyInit = (ForeachPredicatePropertyInit) injectorActionBase;
        InjectorActionsBlock block = foreachPredicatePropertyInit.getInjectorActionsBlockReference();
        Template template = block
            .getParentTemplate();
        RefObject parsingContext = null;
        if (!MoinHelper.usesContext(foreachPredicatePropertyInit.getValue())) {
            parsingContext = template.getMetaReference();
        } else if (MoinHelper.usesContextWithSubsequentCast(foreachPredicatePropertyInit
            .getValue())) {
            parsingContext = MoinHelper.getContextMetaObject(connection,
                packagesForLookup, foreachPredicatePropertyInit.getValue());
            if (parsingContext == null) {
                throw new RuntimeException(
                    "Didn't find type use in context casts in expression "
                        + foreachPredicatePropertyInit.getValue());
            }
        } else {
            Matcher matcher = ContextManager.contextPattern.matcher(foreachPredicatePropertyInit
                .getValue());
            matcher.find();
            parsingContext = getCommonBaseClassForContextTag(cs, matcher.group(2),
                elementClass);
            if (parsingContext == null) {
                throw new RuntimeException("Expected to find use of context "
                    + matcher.group(2) + " but didn't");
            }
        }
        try {
            String query = foreachPredicatePropertyInit.getValue();
            List<com.sap.mi.textual.grammar.impl.PredicateSemantic> list = new ArrayList<com.sap.mi.textual.grammar.impl.PredicateSemantic>();
            Iterator<PredicateSemantic> semIt = ((ForeachPredicatePropertyInit) foreachPredicatePropertyInit).getPredicatesemantic().iterator();
            String mode = template instanceof ClassTemplate ? ((ClassTemplate) template).getMode() : null;
            while (semIt.hasNext()) {
                PredicateSemantic next = semIt.next();
                String localMode = mode;
                if (next.getMode() != null) {
                    localMode = next.getMode();
                }
                if (next.getWhen() != null) {
                    String javaQueryWhen = next.getWhen().replaceAll("\\\"", "\\\\\"");
                    javaQueryWhen = javaQueryWhen.replaceAll("\r\n", "\"+\"");
                    javaQueryWhen = javaQueryWhen.replaceAll("\n", "\"+\"");
                    list.add(new com.sap.mi.textual.grammar.impl.PredicateSemantic(
                            javaQueryWhen,
                            ruleNameFinder.getRuleName(next.getAs(), localMode)));
            
                } else {
                    list.add(new com.sap.mi.textual.grammar.impl.PredicateSemantic(null, ruleNameFinder.getRuleName(next.getAs(), localMode)));
                }
            }
            boolean hasContext = false;
            if (block.getParentTemplate() instanceof ClassTemplate) {
                hasContext = ((ClassTemplate) block.getParentTemplate()).isContext();
            }
            DelayedReference ref = new DelayedReference(null,
                        DelayedReference.SEMANTIC_PREDICATE, null, 
                        foreachPredicatePropertyInit.getPropertyReference().getStrucfeature().getName(),
                        query, null, list, ruleNameFinder, null, hasContext, 
                        /*isOptional: ForEach is always considered optional as 
                         * error reporting will be done based on metamodel constraints.*/
                        true);
                
            //now replace any #context parts within the query with self
            //and use the context element type for registration if it is
            //used here, 
            query = MoinHelper.prepareOclQuery(query, null, null);
            if (query != null) {
                ref.setQueryElement(foreachPredicatePropertyInit);
                ref.setGenericReference(true);
                String name = "<genericReference>" + foreachPredicatePropertyInit.refMofId();
                OclExpressionRegistration registration = (OclExpressionRegistration) connection
                    .getOclRegistryService().getFreestyleRegistry()
                    .getRegistration(name);
                if (registration != null) {
                    connection.getOclRegistryService().getFreestyleRegistry()
                        .deleteRegistration(name);
                }
                registration = connection.getOclRegistryService()
                    .getFreestyleRegistry().createExpressionRegistration(name,
                        query, OclRegistrationSeverity.Info,
                        new String[] { "TCS Property Init" }, parsingContext,
                        packagesForLookup.toArray(new RefPackage[] {}));
                Map<EventFilter, Map<ListenerType, EventListener>> reEvaluationListener = createReEvaluationListener(
                    registration, ref);
                GlobalEventListenerRegistry registry = (GlobalEventListenerRegistry) context
                    .getService(globalEventListenerRegistryRef);
                registry.addFilters(reEvaluationListener);
                registration2DelayedReference.put(registration.getName(), ref);
                delayedReference2Registration.put(ref, registration.getName());
                delayedReference2ReEvaluationListener
                    .put(ref, reEvaluationListener);

            }
        } catch (OclManagerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ModelAdapterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch(MoinLocalizedBaseRuntimeException ex) {
            System.err.println("Failed to register at IA: " + foreachPredicatePropertyInit.getValue() + "\n" + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void registerLookupPropertyInitForIA(ConcreteSyntax cs,
            Connection connection, Collection<RefPackage> packagesForLookup,
            MofClass elementClass, InjectorAction injectorActionBase) {
        LookupPropertyInit injectorAction = (LookupPropertyInit) injectorActionBase;
        Template template = ((InjectorActionsBlock) injectorAction
            .refImmediateComposite()).getParentTemplate();
        RefObject parsingContext = null;
        if (!MoinHelper.usesContext(injectorAction.getValue())) {
            parsingContext = template.getMetaReference();
        } else if (MoinHelper.usesContextWithSubsequentCast(injectorAction
            .getValue())) {
            parsingContext = MoinHelper.getContextMetaObject(connection,
                packagesForLookup, injectorAction.getValue());
            if (parsingContext == null) {
                throw new RuntimeException(
                    "Didn't find type use in context casts in expression "
                        + injectorAction.getValue());
            }
        } else {
            Matcher matcher = ContextManager.contextPattern.matcher(injectorAction
                .getValue());
            matcher.find();
            parsingContext = getCommonBaseClassForContextTag(cs, matcher.group(2),
                elementClass);
            if (parsingContext == null) {
                throw new RuntimeException("Expected to find use of context "
                    + matcher.group(2) + " but didn't");
            }
        }
        try {
            String query = injectorAction.getValue();
            DelayedReference ref = new DelayedReference(null, null,
                    injectorAction.getPropertyReference().getStrucfeature()
                        .getName(), null, null, query, false, null);
            //now replace any #context parts within the query with self
            //and use the context element type for registration if it is
            //used here, 
            query = MoinHelper.prepareOclQuery(query, null, null);
            if (query != null) {
                ref.setQueryElement(injectorAction);
                ref.setGenericReference(true);
                String name = "<genericReference>" + injectorAction.refMofId();
                OclExpressionRegistration registration = (OclExpressionRegistration) connection
                    .getOclRegistryService().getFreestyleRegistry()
                    .getRegistration(name);
                if (registration != null) {
                    connection.getOclRegistryService().getFreestyleRegistry()
                        .deleteRegistration(name);
                }
                registration = connection.getOclRegistryService()
                    .getFreestyleRegistry().createExpressionRegistration(name,
                        query, OclRegistrationSeverity.Info,
                        new String[] { "TCS Property Init" }, parsingContext,
                        packagesForLookup.toArray(new RefPackage[] {}));
                Map<EventFilter, Map<ListenerType, EventListener>> reEvaluationListener = createReEvaluationListener(
                    registration, ref);
                GlobalEventListenerRegistry registry = (GlobalEventListenerRegistry) context
                    .getService(globalEventListenerRegistryRef);
                registry.addFilters(reEvaluationListener);
                registration2DelayedReference.put(registration.getName(), ref);
                delayedReference2Registration.put(ref, registration.getName());
                delayedReference2ReEvaluationListener
                    .put(ref, reEvaluationListener);

            }
        } catch (OclManagerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ModelAdapterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch(MoinLocalizedBaseRuntimeException ex) {
            System.err.println("Failed to register at IA: " + injectorAction.getValue() + "\n" + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * For a given context tag and a concrete syntax determines the meta-classes for which templates exist that use this tag for
     * declaring a context. The common generalization of all such classes will be returned. This may be <tt>Reflect::Element</tt>
     * if no other common generalization exists.
     * <p>
     * 
     * This implementation currently uses MQL to find the classes for which templates (class or operator) exist that declare a
     * context with the <tt>contextTag</tt> among the tags.
     * 
     * @param cs
     *            the concrete syntax in which to search for the use of the <tt>contextTag</tt>
     * @param contextTag
     *            may be <tt>null</tt> or an empty string which means the untagged context
     * @param elementClass
     *            the <tt>Reflect::Element</tt> class to use as common generalization if no other common generalization can be
     *            found
     * @return the common generalization of all classes for which a template is defined as context using <tt>contextTag</tt> as
     *         the tag for the context declaration; <tt>null</tt> if no such template exists; <tt>Reflect::Element</tt> if no
     *         other common generalization exists
     */
    private RefObject getCommonBaseClassForContextTag(ConcreteSyntax cs, String contextTag, Classifier elementClass) {
	MQLProcessor mql = cs.get___Connection().getMQLProcessor();
	MQLResultSet classTemplatesClasses;
	if (contextTag==null || contextTag.length()==0) {
	    classTemplatesClasses = mql.execute("select me from Model::Classifier as me,"+
		    	"TCS::ContextTemplate as ct,"+
		    	"\"" + ((Partitionable) cs).get___Mri() + "\" as cs "+
		    	"where ct.concreteSyntax=cs "+
		    	"where ct.metaReference=me "+
		    	"where ct.contextTags=null "+
			"where ct.isContext=true");
	} else {
	    classTemplatesClasses = mql.execute("select me from Model::Classifier as me,"+
			"TCS::ContextTemplate as ct,"+
			"TCS::ContextTags as tags,"+
			"\"" + ((Partitionable) cs).get___Mri() + "\" as cs "+
			"where ct.concreteSyntax=cs "+
			"where ct.metaReference=me "+
			"where ct.contextTags=tags "+
			"where ct.isContext=true "+
			"where tags.tags='"+contextTag+"'");
	}
	Set<Classifier> metaReferences = new HashSet<Classifier>();
	for (RefObject ro : classTemplatesClasses.getRefObjects("me")) {
	    metaReferences.add((Classifier) ro);
	}
	MQLResultSet operatorTemplatesClasses;
	if (contextTag==null || contextTag.length()==0) {
	    operatorTemplatesClasses = mql.execute("select me from Model::Classifier as me,"+
		    	"TCS::ContextTemplate as ct,"+
		    	"TCS::ContextTags as tags,"+
		    	"\"" + ((Partitionable) cs).get___Mri() + "\" as cs "+
		    	"where ct.concreteSyntax=cs "+
		    	"where ct.metaReference=me "+
		    	"where ct.contextTags=null "+
			"where ct.isContext=true");
	} else {
		operatorTemplatesClasses = mql.execute("select me from Model::Classifier as me,"+
			"TCS::ContextTemplate as ct,"+
			"TCS::ContextTags as tags,"+
			"\"" + ((Partitionable) cs).get___Mri() + "\" as cs "+
			"where ct.concreteSyntax=cs "+
			"where ct.metaReference=me "+
			"where ct.contextTags=tags "+
			"where ct.isContext=true "+
			"where tags.tags='"+contextTag+"'");
	}
	for (RefObject ro : operatorTemplatesClasses.getRefObjects("me")) {
	    metaReferences.add((Classifier) ro);
	}
	boolean needReflectElement = false;
	Classifier commonGeneralization = null;
	while (!needReflectElement && metaReferences.size() > 0) {
	    Classifier candidate = metaReferences.iterator().next();
	    if (commonGeneralization == null) {
		commonGeneralization = candidate;
		metaReferences.remove(candidate); // first candidate
	    } else if (candidate.allSupertypes().contains(commonGeneralization)) {
		metaReferences.remove(candidate); // commonGeneralization already covers candidate
	    } else {
		List<GeneralizableElement> allCommonGeneralizationSupertypes = commonGeneralization.allSupertypes();
		boolean foundCommonSupertype = false;
		for (GeneralizableElement candidateSuperclass : candidate.allSupertypes()) {
		    if (allCommonGeneralizationSupertypes.contains(candidateSuperclass)) {
			commonGeneralization = (Classifier) candidateSuperclass;
			metaReferences.remove(candidate); // now commongeneralization also covers candidate
			foundCommonSupertype = true;
			break;
		    }
		}
		if (!foundCommonSupertype) {
		    needReflectElement = true;
		    break;
		}
	    }
	}
	if (needReflectElement) {
	    commonGeneralization = elementClass;
	}
	return commonGeneralization;
    }

    private Map<EventFilter, Map<ListenerType, EventListener>> createReEvaluationListener(
	    OclExpressionRegistration registration, DelayedReference ref) {
	EventFilter filter = registration.getEventFilter(/* notifyNewContextElement */ true); // TODO clarify if this should be false
	// if(ref.getToken() != null) {
	// //for refersTo References add filter that only re-evaluates the Query
	// if
	// //the originally referenced element was deleted
	// filter = appendTextBlockRefBroken(ref);
	// }
	Map<ListenerType, EventListener> listenerForType = new HashMap<ListenerType, EventListener>();
	listenerForType.put(ListenerType.UPDATE,
		new IAExpressionInvalidationChangeListener(registration, ref));
	Map<EventFilter, Map<ListenerType, EventListener>> map = new HashMap<EventFilter, Map<ListenerType, EventListener>>();
	map.put(filter, listenerForType);
	return map;
    }

    // @Override
    // public void notify(Collection<MRI> objectsToReEvaluate,
    // OclExpressionRegistration registration, Connection con) {
    // for (MRI mri : objectsToReEvaluate) {
    // RefBaseObject ro = con.getElement(mri);
    // RefPackage outermostPackage = getOutermostPackageThroughClusteredImports(
    // con, ro);
    // DelayedReference unresolvedRef = registration2DelayedReference
    // .get(registration.getName());
    //
    // if(unresolvedRef != null) {
    // reEvaluateUnresolvedRef(con, outermostPackage, unresolvedRef);
    // }
    //    
    // }
    // }
    
    public void resolveReferences(IProgressMonitor monitor) {
	Collection<DelayedReference> workingCopy = new ArrayList<DelayedReference>(iaUnresolvedReferences);
	monitor.beginTask("Reevaluating OCL References...", workingCopy.size());
	Collection<DelayedReference> deferredReferences = new ArrayList<DelayedReference>();

	for (final DelayedReference ref : workingCopy) {
	    if (!ref.getConnection().isAlive()) {
		Activator.logWarning("Could not re-resolve reference: " + ref + ". Connection: " + ref.getConnection()
			+ " is not alive anymore!");
		monitor.worked(1);
		continue;
	    }
	    assert !(ref.getModelElement() instanceof RefObject) || ref.getConnection() == ((RefObject) ref.getModelElement()).get___Connection()
	    	: "Element must be resolved in given connection.";

	    try {
		final RefPackage outermostPackage = getOutermostPackageThroughClusteredImports(ref.getConnection(),
			(RefBaseObject) ref.getModelElement());

		ref.getConnection().getCommandStack().execute(
			new Command(ref.getConnection(), "Re-evaluate unresolved Reference") {

			    @Override
			    public boolean canExecute() {
				return true;
			    }

			    @Override
			    public void doExecute() {
				reEvaluateUnresolvedRef(ref.getConnection(), outermostPackage, ref, ref.getTextBlock());
			    }

			    @Override
			    public Collection<PartitionOperation> getAffectedPartitions() {
				PRI pri = ((Partitionable) ref.getModelElement()).get___Partition().getPri();
				PartitionOperation editOperation = new PartitionOperation(PartitionOperation.Operation.EDIT, pri);
				return Collections.singleton(editOperation);
			    }

			});

	    } catch (InvalidObjectException ex) {
		Activator.logWarning("Could not re-resolve reference: " + ref + ". Element: " + ref.getModelElement()
			+ " is not alive anymore! Reference is ignored.");
	    } catch (PartitionEditingNotPossibleException ex) {
		Activator.logWarning("Could not re-resolve reference: " + ref + ". Partition: " + ex.getPri()
			+ " is locked by connection " + ref.getConnection() +"! Will try again later");
		deferredReferences.add(ref);
	    } catch (Exception ex) {
		Activator.logError(ex, " Could not re-resolve reference: " + ref + ". Reference is ignored.");
	    }
	    monitor.worked(1);
	}
	// deferred references will tried to be resolved again later so dont't
	// remove them
	workingCopy.removeAll(deferredReferences);
	iaUnresolvedReferences.removeAll(workingCopy);
	backgroundResolver.scheduleIfNeeded();
	monitor.done();
    }
}
