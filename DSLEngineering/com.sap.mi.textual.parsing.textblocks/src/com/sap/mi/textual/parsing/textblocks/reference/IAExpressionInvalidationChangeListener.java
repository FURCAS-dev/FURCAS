/**
 *
 */
package com.sap.mi.textual.parsing.textblocks.reference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

import org.eclipse.core.runtime.NullProgressMonitor;

import tcs.ContextTemplate;
import tcs.InjectorAction;
import tcs.InjectorActionsBlock;
import tcs.Property;
import tcs.Template;
import textblockdefinition.TextBlockDefinition;
import textblockdefinition.TextblockDefinitionReferencesProduction;
import textblocks.AbstractToken;
import textblocks.DocumentNode;
import textblocks.ForeachContext;
import textblocks.LexedToken;
import textblocks.LexedTokenReferenesSequenceElement;
import textblocks.TextBlock;
import textblocks.TextBlockAdditionalTemplates;
import textblocks.TextBlockType;

import com.sap.mi.textual.common.interfaces.IModelElementProxy;
import com.sap.mi.textual.common.util.ContextAndForeachHelper;
import com.sap.mi.textual.grammar.impl.DelayedReference;
import com.sap.mi.textual.parsing.textblocks.LexedTokenWrapper;
import com.sap.mi.textual.parsing.textblocks.LocalContextBuilder;
import com.sap.mi.textual.parsing.textblocks.TbUtil;
import com.sap.mi.textual.tcs.util.TcsUtil;
import com.sap.mi.textual.textblocks.model.ShortPrettyPrinter;
import com.sap.tc.moin.globalmodellistener.Activator;
import com.sap.tc.moin.ocl.ia.Statistics;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.ocl.freestyle.OclExpressionRegistration;
import com.sap.tc.moin.textual.moinadapter.adapter.MoinHelper;


/**
 * An event listener responsible to queue a {@link DelayedReference} for re-evaluation
 * in the {@link ReferenceResolver}.
 *
 */
public class IAExpressionInvalidationChangeListener implements UpdateListener, ChangeListener {

    /**
     * The OCL expressions used by the {@link #reference} for (re-)evaluation.
     * This listener will be notified about changes that may affect any of those
     * OCL expressions in order for the reference to be re-evaluated.
     */
    private final OclExpressionRegistration[] registrations;
    private final DelayedReference reference;
    private final WeakHashMap<ChangeEvent, Set<MRI>> elementsImpactedByEvent = new WeakHashMap<ChangeEvent, Set<MRI>>();
    private final ReferenceResolver resolver;

    public IAExpressionInvalidationChangeListener(ReferenceResolver resolver, DelayedReference ref,
	    OclExpressionRegistration... registration) {
	this.resolver = resolver;
	this.registrations = registration;
	this.reference = ref;
    }

    @Override
    public void notifyUpdate(EventChain events) {
	try {
	    if (!events.getEvents().isEmpty()) {
		Connection conn = events.getEvents().iterator().next().getEventTriggerConnection();
		if (reference.isGenericReference()) {
		    // Its a generic reference not an unresolved one
		    if (reference.getQueryElement() != null) {
			List<DelayedReference> newRefs = null;
			if (reference.getQueryElement() instanceof InjectorAction) {
			    newRefs = filterEventsAndRegisterDelayedReferencesForInjectorAction(events.getEvents(), conn);
			} else if (reference.getQueryElement() instanceof Property) {
			    if (reference.getType() == DelayedReference.CONTEXT_LOOKUP) {
				newRefs = filterEventsAndQueueDelayedReferencesForContextLookup(events.getEvents(), conn);
			    } else {
				newRefs = filterEventsAndQueueDelayedReferencesForPropertyQuery(events.getEvents(), conn);
			    }
			}
			if (newRefs != null && newRefs.size() > 0) {
			    resolve(newRefs);
			}
		    }
		}
	    }
	} catch (Exception e) {
	    Activator.logError(e, "Preparing Delayed Reference Re-Evaluation");
	}
    }

    private void resolve(Collection<DelayedReference> unresolvedReferences) {
	if (unresolvedReferences != null && !unresolvedReferences.isEmpty()) {
	    resolver.queueNewUnresolvedReferences(unresolvedReferences);
	    resolver.resolveReferences(new NullProgressMonitor());
	}
    }

    private List<DelayedReference> filterEventsAndRegisterDelayedReferencesForInjectorAction(List<ChangeEvent> events,
	    Connection conn) {
	List<DelayedReference> newReferences = new ArrayList<DelayedReference>();
	Collection<TextBlock> textBlocksInChosenAlternativeForInjectorAction = getTextBlocksInChosenAlternativeForInjectorAction(conn);
	if (textBlocksInChosenAlternativeForInjectorAction.size() > 0) {
	    Set<MRI> allAffectedElements = new HashSet<MRI>();
	    for (ChangeEvent event : events) {
		// checking for
		// !areAllRegistrationsUnaffectedDueToPrimitiveAttributeValueComparisonWithLiteralOnly
		// not necessary because an entry in elementsImpactedByEvent
		// only appears after this check was performed
		// TODO this is a workaround. to properly decide this we need to
		// keep track of the alternative chosen at runtime of the parser
		Set<MRI> affectedElementsForEvent = elementsImpactedByEvent.remove(event);
		if (affectedElementsForEvent != null) {
		    allAffectedElements.addAll(affectedElementsForEvent);
		}
	    }
	    if (allAffectedElements.size() > 0) {
		for (TextBlock textBlock : textBlocksInChosenAlternativeForInjectorAction) {
		    Set<RefObject> intersectionOfCorrespondingAndAffectedElements = filterCorrespondingOrContextElementWithAffectedElements(
			    conn, allAffectedElements, textBlock);
		    for (RefObject ro : intersectionOfCorrespondingAndAffectedElements) {
			DelayedReference clonedRef = reference.clone();
			clonedRef.setModelElement(ro);
			clonedRef.setRealValue(null);
			clonedRef.setTextBlock(textBlock);
			clonedRef.setConnection(conn);
			newReferences.add(clonedRef);
			// reference.setModelElement(null);
		    }
		}
	    }
	}
	return newReferences;
    }

    /**
     * We catch both, the immediate change event for each single event at the
     * time the change happens, and later the update event when all changes of a
     * command or command group are done (see {@link #notifyUpdate(EventChain)}
     * ). When the change occurs, the model is still in the state immediately
     * after that particular change. Therefore, other than in the update event,
     * the impact analysis can be performed truthfully and better than in the
     * update listener where other model changes may incorrectly influence the
     * results of the impact analysis.
     * <p>
     *
     * We record the results of the impact analysis, keyed by the model change
     * event and store it in a weak hash map. If the update handler is executed,
     * all events will be handled and removed from the map. If not, the events
     * will eventually disappear from the weak map due to garbage collection.
     */
    @Override
    public void notify(ChangeEvent event) {
	try {
	    Connection conn = event.getEventTriggerConnection();
	    if (reference.isGenericReference()) {
		// Its a generic reference not an unresolved one
		if (reference.getQueryElement() != null) {
		    if (reference.getQueryElement() instanceof InjectorAction) {
			if (!areAllRegistrationsUnaffectedDueToPrimitiveAttributeValueComparisonWithLiteralOnly(event,
				/* replacement for __TEMP__*/ null)) {
			    if (getTextBlocksInChosenAlternativeForInjectorAction(conn).size() > 0) {
				elementsImpactedByEvent.put(event, getAffectedElements(event, conn));
			    }
			}
		    } else {
			// compute affected elements because
			// filterEventsAndQueueDelayedReferencesForContextLookup
			// and filterEventsAndQueueDelayedReferencesForPropertyQuery
			// always need them
			elementsImpactedByEvent.put(event, getAffectedElements(event, conn));
		    }
		}
	    }
	} catch (Exception e) {
	    Activator.logError(e, "Calculating effected elements for change event: " + event);
	}
    }

    private Collection<TextBlock> getTextBlocksInChosenAlternativeForInjectorAction(Connection conn) {
	Collection<TextBlock> result = new ArrayList<TextBlock>();
	InjectorAction injectorAction = (InjectorAction) conn.getElement(((Partitionable) reference.getQueryElement())
		.get___Mri());
	if(injectorAction != null) {
        	InjectorActionsBlock injectorActionsBlock = (InjectorActionsBlock) injectorAction.refImmediateComposite();
        	Template template = injectorActionsBlock.getParentTemplate();
        
        	// now find all TextBlocks referencing this template;
        	Collection<TextBlock> tbs = getTextBlocksUsingQueryElement(conn, template);
        
        	for (TextBlock textBlock : tbs) {
        	    // first check if the alternative in which the injector action
        	    // resides was
        	    // chosen during the parsing process
        	    // TODO this is a workaround. to properly decide this we need to
        	    // keep track
        	    // of the alternative chosen at runtime of the parser
        	    boolean wasInChosenAlternative = isInjectorActionInChosenAlternative(injectorActionsBlock, textBlock);
        
        	    if (wasInChosenAlternative) {
        		result.add(textBlock);
        	    }
        	}
	}
	return result;
    }

    private boolean areAllRegistrationsUnaffectedDueToPrimitiveAttributeValueComparisonWithLiteralOnly(ChangeEvent event,
	    String replacementFor__TEMP__) {
	boolean allRegistrationsUnaffectedDueToPrimitiveAttributeValueComparisonWithLiteralOnly = true;
	for (OclExpressionRegistration registration : registrations) {
	    if (!registration.isUnaffectedDueToPrimitiveAttributeValueComparisonWithLiteralOnly(event, replacementFor__TEMP__)) {
		allRegistrationsUnaffectedDueToPrimitiveAttributeValueComparisonWithLiteralOnly = false;
		break;
	    }
	}
	return allRegistrationsUnaffectedDueToPrimitiveAttributeValueComparisonWithLiteralOnly;
    }

    private boolean isInjectorActionInChosenAlternative(InjectorActionsBlock injectorActionsBlock, TextBlock textBlock) {
	boolean wasInChosenAlternative = false;
	if (textBlock.getTokens().isEmpty()) {
	    for (TextBlock tb : textBlock.getSubBlocks()) {
		if (tb.getSequenceElement() != null
			&& (tb.getSequenceElement().getElementSequence().equals(injectorActionsBlock.getElementSequence()) || injectorActionsBlock
				.getElementSequence().refImmediateComposite() instanceof ContextTemplate)) {
		    wasInChosenAlternative = true;
		    break;
		}
	    }
	} else {
	    for (AbstractToken tok : textBlock.getTokens()) {
		if (tok instanceof LexedToken) {
		    LexedToken lt = (LexedToken) tok;
		    // check if injectoraction was in chosen alternative or
		    // directly in in the template
		    if (lt.getSequenceElement() != null
			    && (lt.getSequenceElement().getElementSequence().equals(injectorActionsBlock.getElementSequence()) || injectorActionsBlock
				    .getElementSequence().refImmediateComposite() instanceof ContextTemplate)) {
			wasInChosenAlternative = true;
			break;
		    }
		}
	    }
	}
	return wasInChosenAlternative;
    }

    private Collection<TextBlock> getTextBlocksUsingQueryElement(Connection conn, Template template) {
	TextblockDefinitionReferencesProduction tbDefAssoc = conn
		.getAssociation(TextblockDefinitionReferencesProduction.ASSOCIATION_DESCRIPTOR);
	TextBlockDefinition def = tbDefAssoc.getTextBlockDefinition(template).iterator().next();
	TextBlockType tbTypeAssoc = conn.getAssociation(TextBlockType.ASSOCIATION_DESCRIPTOR);
	Collection<TextBlock> tbs = new ArrayList<TextBlock>(tbTypeAssoc.getTextBlock(def));
	// now find all TextBlocks that reference the template in their
	// "additionalTemplate"
	TextBlockAdditionalTemplates tbAdditionalAssoc = conn.getAssociation(TextBlockAdditionalTemplates.ASSOCIATION_DESCRIPTOR);
	Collection<TextBlock> additionalTbs = tbAdditionalAssoc.getTextblock(template);
	tbs.addAll(additionalTbs);
	tbs = TbUtil.filterVersionedTextBlockForNewest(tbs);
	return tbs;
    }

    private List<DelayedReference> filterEventsAndQueueDelayedReferencesForPropertyQuery(List<ChangeEvent> events, Connection conn) {
	List<DelayedReference> newReferences = new ArrayList<DelayedReference>();
	Collection<LexedToken> toks = getTokensUsingQueryElement(conn);
	Set<LexedToken> tokensForWhichToAddNewReference = new HashSet<LexedToken>();
	for (ChangeEvent event : events) {
	    Set<MRI> affectedElements = elementsImpactedByEvent.remove(event);
	    // check for
	    // !allRegistrationsUnaffectedDueToPrimitiveAttributeValueComparisonWithLiteralOnly
	    // not necessary because this check is performed before affected
	    // elements are cached in elementsImpactedByEvent
	    if (affectedElements != null && affectedElements.size() > 0) {
		for (LexedToken lt : toks) {
		    if (lt == null || lt.getParentBlock() == null) {
			// dangling token. Ignoring
			continue;
		    }
		    Set<RefObject> intersectionOfCorrespondingAndAffectedElements = filterCorrespondingOrContextElementWithAffectedElements(
			    conn, affectedElements, lt.getParentBlock());
		    if (intersectionOfCorrespondingAndAffectedElements.size() > 0) {
			tokensForWhichToAddNewReference.add(lt);
		    }
		}
	    }
	}
	for (LexedToken lt : tokensForWhichToAddNewReference) {
	    newReferences.addAll(getReferencesToReEvaluate(conn, lt));
	}
	return newReferences;
    }

    private List<DelayedReference> filterEventsAndQueueDelayedReferencesForContextLookup(List<ChangeEvent> events, Connection conn) {
	Collection<LexedToken> toks = getTokensUsingQueryElement(conn);
	Set<LexedToken> tokensForWhichToAddNewReference = new HashSet<LexedToken>();
	List<DelayedReference> newReferences = new ArrayList<DelayedReference>();
	for (ChangeEvent event : events) {
	    Set<MRI> affectedElements = elementsImpactedByEvent.remove(event);
	    // check
	    // for!allRegistrationsUnaffectedDueToPrimitiveAttributeValueComparisonWithLiteralOnly
	    // not necessary because this check is performed before affected
	    // elements are cached in elementsImpactedByEvent
	    if (affectedElements != null && affectedElements.size() > 0) {
		for (LexedToken lt : toks) {
		    Set<RefObject> intersectionOfCorrespondingAndAffectedElements = filterAffectedElements(conn,
			    affectedElements, Collections.singletonList(lt.getParentBlock()));
		    if (intersectionOfCorrespondingAndAffectedElements.size() > 0) {
			tokensForWhichToAddNewReference.add(lt);
		    }
		}
	    }
	}
	for (LexedToken lt : tokensForWhichToAddNewReference) {
	    newReferences.addAll(getReferencesToReEvaluate(conn, lt));
	}
	return newReferences;
    }

    private Collection<? extends DelayedReference> getReferencesToReEvaluate(Connection conn, LexedToken lt) {
	Set<RefObject> result = filterCorrespondingElementsByDelayedReferenceSourceType(conn, lt.getParentBlock(), reference);
	List<DelayedReference> newReferences = new ArrayList<DelayedReference>();
	for (RefObject ro : result) {
	    DelayedReference clonedRef = reference.clone();
	    clonedRef.setModelElement(ro);
	    clonedRef.setRealValue(null);
	    clonedRef.setConnection(conn);

	    clonedRef.setToken(new LexedTokenWrapper(lt));
	    RefPackage outermostPackage = MoinHelper.getOutermostPackageThroughClusteredImports(conn, (RefBaseObject) clonedRef.getModelElement());
	    ShortPrettyPrinter shortPrettyPrinter = new ShortPrettyPrinter(resolver.constructModelInjector(conn, outermostPackage).getModelAdapter());
	    clonedRef.setKeyValue(shortPrettyPrinter.resynchronizeToEditableState(lt));
	    
	    clonedRef.setTextBlock(lt.getParentBlock());
	    String oclQuery = clonedRef.getOclQuery();
	    clonedRef.setOclQuery(oclQuery.replaceAll(GlobalDelayedReferenceResolver.TEMPORARY_QUERY_PARAM_REPLACEMENT, lt
		    .getValue()));
	    newReferences.add(clonedRef);
	}
	return newReferences;
    }

    /**
     * Filtes the elements in
     * {@link DocumentNode#getCorrespondingModelElements()} by comparing them to
     * the type given by the parent template of the query element of the
     * {@link #reference}.
     *
     * @param conn
     *            The connection to use to resolve the template
     * @param node
     *            To node from which the corresponding elements should be
     *            filtered.
     * @param delayedReference
     *            TODO
     * @return A type filtered set of elements by the {@link #reference}'s query
     *         elements template.
     */
    private Set<RefObject> filterCorrespondingElementsByDelayedReferenceSourceType(Connection conn, DocumentNode node,
	    DelayedReference delayedReference) {
	Set<RefObject> result = new HashSet<RefObject>();
	RefObject queryElement = (RefObject) conn.getElement(((Partitionable) delayedReference.getQueryElement()).get___Mri());
	for (RefObject refObject : node.getCorrespondingModelElements()) {

	    if (refObject.refIsInstanceOf(TcsUtil.getParentTemplate(queryElement).getMetaReference(), false)) {
		result.add(refObject);
	    }
	}
	return result;
    }

    private Collection<LexedToken> getTokensUsingQueryElement(Connection conn) {
	Property property = (Property) conn.getElement(((Partitionable) reference.getQueryElement()).get___Mri());
	// now find all TextBlocks referencing this property;
	LexedTokenReferenesSequenceElement lexedTokenSeqElAssoc = conn
		.getAssociation(LexedTokenReferenesSequenceElement.ASSOCIATION_DESCRIPTOR);
	Collection<LexedToken> toks = lexedTokenSeqElAssoc.getLexedtoken(property);
	return toks;
    }

    /**
     * Filters the given elements with the corresponding elements or, if the
     * query uses a #context reference with the context element of the given
     * {@link TextBlock}.
     * <p>
     *
     * TODO handle #foreach here too
     *
     * @param conn
     *            the connection used to resolve the MRIs within affecedElements
     * @param affectedElements
     *            Elements that were affected by
     * @param node
     *            The {@link TextBlock} which's corresponding elements should be
     *            filtered.
     * @return the intersection between affected elements and the corresponding
     *         elements of the given {@link TextBlock}.
     */
    private Set<RefObject> filterCorrespondingOrContextElementWithAffectedElements(Connection conn, Set<MRI> affectedElements,
	    DocumentNode node) {
	Collection<RefObject> correspondingModelElements = null;
	boolean isContext = ContextAndForeachHelper.usesContext(reference.getOclQuery());
	boolean usesForEach = ContextAndForeachHelper.usesForeach(reference.getOclQuery());
	Set<RefObject> sourceModelElements = null;
	if (isContext) {
	    LocalContextBuilder localContextBuilder = new LocalContextBuilder();
	    TbUtil.constructContext(node, localContextBuilder);
	    correspondingModelElements = new ArrayList<RefObject>();
	    if (!localContextBuilder.getContextStack().isEmpty()) {
		IModelElementProxy innermostContext = localContextBuilder.getContextStack().peek();
		Object taggedContext = localContextBuilder.getContextManager().getTaggedContext(innermostContext,
			ContextAndForeachHelper.getContextTag(reference.getOclQuery()));
		if (taggedContext != null) {
		    // null may occur in case the node leads to a context stack
		    // that doesn't fit the
		    // context stack expected by the OCL expression;
		    // in this case, e.g., if a tag exists on the OCL
		    // expression's #context, no context object will
		    // be found. In this case, don't add anything to the
		    // correspondingModelElements.
		    RefObject unwrappedContext = null;
		    if (taggedContext instanceof IModelElementProxy) {
			unwrappedContext = (RefObject) ((IModelElementProxy) taggedContext).getRealObject();
		    } else {
			unwrappedContext = (RefObject) taggedContext;
		    }
		    correspondingModelElements.add(unwrappedContext);
		}
	    }
	} else if (usesForEach) {
	    correspondingModelElements = new ArrayList<RefObject>();
	    sourceModelElements = new HashSet<RefObject>();
	    Collection<ForeachContext> fec = null;
	    if (node instanceof TextBlock) {
		fec = ((TextBlock) node).getForeachContext();
	    } else {
		fec = ((TextBlock) node.refImmediateComposite()).getForeachContext();
	    }
	    for (ForeachContext foreachContext : fec) {
		if (foreachContext.getForeachPredicatePropertyInit().equals(reference.getQueryElement())) {
		    correspondingModelElements.addAll(foreachContext.getContextElement());
		    sourceModelElements.add(foreachContext.getSourceModelelement());
		}
	    }
	} else {
	    correspondingModelElements = new ArrayList<RefObject>(node.getCorrespondingModelElements());
	    correspondingModelElements.addAll(node.getReferencedElements());
	}

	Set<RefObject> intersectionOfCorrespondingAndAffectedElements = filterAffectedElements(conn, affectedElements,
		correspondingModelElements);
	if (isContext) {
	    if (intersectionOfCorrespondingAndAffectedElements.size() > 0) {
		Set<RefObject> result = filterCorrespondingElementsByDelayedReferenceSourceType(conn, node, reference);
		return result;
	    } else {
		return new HashSet<RefObject>(0);
	    }
	} else if (usesForEach) {
	    return sourceModelElements;
	} else {
	    return intersectionOfCorrespondingAndAffectedElements;
	}
    }

    private Set<RefObject> filterAffectedElements(Connection conn, Set<MRI> affectedElements,
	    Collection<? extends RefObject> correspondingModelElements) {
	Set<RefObject> intersectionOfCorrespondingAndAffectedElements = new HashSet<RefObject>(correspondingModelElements);
	if (intersectionOfCorrespondingAndAffectedElements.size() > 0) {
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

    private Set<MRI> getAffectedElements(ChangeEvent event, Connection conn) {
	Statistics.getInstance().setCurrentObjectForSelf(reference.getElementForSelf());
	Set<MRI> affectedElements = new HashSet<MRI>();
	for (OclExpressionRegistration registration : registrations) {
	    if (event instanceof ModelChangeEvent) {
		affectedElements.addAll(registration.getAffectedModelElements((ModelChangeEvent) event, conn));
	    }
	}
	return affectedElements;
    }

    public String getDebugInfo(Connection conn) {
	Statistics oclIaStatistics = Statistics.getInstance();
	StringBuilder result = new StringBuilder();
	for (OclExpressionRegistration registration : registrations) {
	    if (registration != null) {
		result.append(oclIaStatistics.toString(registration, conn));
		result.append('\n');
	    }
	}
	return result.toString();
    }

    public String getDebugInfoAsCsv(Connection conn) {
	Statistics oclIaStatistics = Statistics.getInstance();
	StringBuilder result = new StringBuilder();
	for (OclExpressionRegistration registration : registrations) {
	    if (registration != null) {
		result.append(oclIaStatistics.toCsv(registration, conn));
		result.append('\n');
	    }
	}
	return result.toString();
    }
}