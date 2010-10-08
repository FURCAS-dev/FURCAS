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

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.metamodel.TCS.ContextTemplate;
import com.sap.furcas.metamodel.TCS.InjectorAction;
import com.sap.furcas.metamodel.TCS.InjectorActionsBlock;
import com.sap.furcas.metamodel.TCS.Property;
import com.sap.furcas.metamodel.TCS.Template;
import com.sap.furcas.metamodel.textblocks.AbstractToken;
import com.sap.furcas.metamodel.textblocks.DocumentNode;
import com.sap.furcas.metamodel.textblocks.ForEachContext;
import com.sap.furcas.metamodel.textblocks.LexedToken;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.furcas.parsing.textblocks.LexedTokenWrapper;
import com.sap.furcas.parsing.textblocks.LocalContextBuilder;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.common.util.ContextAndForeachHelper;
import com.sap.furcas.runtime.parser.impl.DelayedReference;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.furcas.textual.textblocks.TbUtil;



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
	if (!events.getEvents().isEmpty()) {
	   ResourceSet conn = events.getEvents().iterator().next().getEventTriggerConnection();
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
    }

    private void resolve(Collection<DelayedReference> unresolvedReferences) {
	if (unresolvedReferences != null && !unresolvedReferences.isEmpty()) {
	    resolver.queueNewUnresolvedReferences(unresolvedReferences);
	    resolver.resolveReferences(new NullProgressMonitor());
	}
    }

    private List<DelayedReference> filterEventsAndRegisterDelayedReferencesForInjectorAction(List<ChangeEvent> events,
	    Resource conn) {
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
		    Set<EObject> intersectionOfCorrespondingAndAffectedElements = filterCorrespondingOrContextElementWithAffectedElements(
			    conn, allAffectedElements, textBlock);
		    for (EObject ro : intersectionOfCorrespondingAndAffectedElements) {
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
	ResourceSet conn = event.getEventTriggerConnection();
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
    }

    private Collection<TextBlock> getTextBlocksInChosenAlternativeForInjectorAction(ResourceSet conn) {
	Collection<TextBlock> result = new ArrayList<TextBlock>();
	InjectorAction injectorAction = (InjectorAction) conn.getElement(((EObject) reference.getQueryElement())
		.get___Mri());
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

    private Collection<TextBlock> getTextBlocksUsingQueryElement(ResourceSet conn, Template template) {
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

    private List<DelayedReference> filterEventsAndQueueDelayedReferencesForPropertyQuery(List<ChangeEvent> events, ResourceSet conn) {
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
		    Set<EObject> intersectionOfCorrespondingAndAffectedElements = filterCorrespondingOrContextElementWithAffectedElements(
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

    private List<DelayedReference> filterEventsAndQueueDelayedReferencesForContextLookup(List<ChangeEvent> events, ResourceSet conn) {
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
		    Set<EObject> intersectionOfCorrespondingAndAffectedElements = filterAffectedElements(conn,
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

    private Collection<? extends DelayedReference> getReferencesToReEvaluate(ResourceSet conn, LexedToken lt) {
	Set<EObject> result = filterCorrespondingElementsByDelayedReferenceSourceType(conn, lt.getParentBlock(), reference);
	List<DelayedReference> newReferences = new ArrayList<DelayedReference>();
	for (EObject ro : result) {
	    DelayedReference clonedRef = reference.clone();
	    clonedRef.setModelElement(ro);
	    clonedRef.setRealValue(null);
	    clonedRef.setResourceSet(conn);

	    clonedRef.setToken(new LexedTokenWrapper(lt));
	    clonedRef.setTextBlock(lt.getParentBlock());
	    clonedRef.setKeyValue(lt.getValue());
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
    private Set<EObject> filterCorrespondingElementsByDelayedReferenceSourceType(ResourceSet conn, DocumentNode node,
	    DelayedReference delayedReference) {
	Set<EObject> result = new HashSet<EObject>();
	EObject queryElement = (EObject) conn.getElement(((EObject) delayedReference.getQueryElement()).get___Mri());
	for (EObject refObject : node.getCorrespondingModelElements()) {

	    if (refObject.refIsInstanceOf(TcsUtil.getParentTemplate(queryElement).getMetaReference(), false)) {
		result.add(refObject);
	    }
	}
	return result;
    }

    private Collection<LexedToken> getTokensUsingQueryElement(ResourceSet conn) {
	Property property = (Property) conn.getElement(((EObject) reference.getQueryElement()).get___Mri());
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
    private Set<EObject> filterCorrespondingOrContextElementWithAffectedElements(ResourceSet conn, Set<MRI> affectedElements,
	    DocumentNode node) {
	Collection<EObject> correspondingModelElements = null;
	boolean isContext = ContextAndForeachHelper.usesContext(reference.getOclQuery());
	boolean usesForEach = ContextAndForeachHelper.usesForeach(reference.getOclQuery());
	Set<EObject> sourceModelElements = null;
	if (isContext) {
	    LocalContextBuilder localContextBuilder = new LocalContextBuilder();
	    TbUtil.constructContext(node, localContextBuilder);
	    correspondingModelElements = new ArrayList<EObject>();
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
		    EObject unwrappedContext = null;
		    if (taggedContext instanceof IModelElementProxy) {
			unwrappedContext = (EObject) ((IModelElementProxy) taggedContext).getRealObject();
		    } else {
			unwrappedContext = (EObject) taggedContext;
		    }
		    correspondingModelElements.add(unwrappedContext);
		}
	    }
	} else if (usesForEach) {
	    correspondingModelElements = new ArrayList<EObject>();
	    sourceModelElements = new HashSet<EObject>();
	    Collection<ForEachContext> fec = null;
	    if (node instanceof TextBlock) {
		fec = ((TextBlock) node).getForEachContext();
	    } else {
		fec = ((TextBlock) node.refImmediateComposite()).getForEachContext();
	    }
	    for (ForEachContext foreachContext : fec) {
		if (foreachContext.getForeachPedicatePropertyInit().equals(reference.getQueryElement())) {
		    correspondingModelElements.addAll(foreachContext.getContextElement());
		    sourceModelElements.add(foreachContext.getSourceModelElement());
		}
	    }
	} else {
	    correspondingModelElements = new ArrayList<EObject>(node.getCorrespondingModelElements());
	    correspondingModelElements.addAll(node.getReferencedElements());
	}

	Set<EObject> intersectionOfCorrespondingAndAffectedElements = filterAffectedElements(conn, affectedElements,
		correspondingModelElements);
	if (isContext) {
	    if (intersectionOfCorrespondingAndAffectedElements.size() > 0) {
		Set<EObject> result = filterCorrespondingElementsByDelayedReferenceSourceType(conn, node, reference);
		return result;
	    } else {
		return new HashSet<EObject>(0);
	    }
	} else if (usesForEach) {
	    return sourceModelElements;
	} else {
	    return intersectionOfCorrespondingAndAffectedElements;
	}
    }

    private Set<EObject> filterAffectedElements(ResourceSet conn, Set<MRI> affectedElements,
	    Collection<? extends EObject> correspondingModelElements) {
	Set<EObject> intersectionOfCorrespondingAndAffectedElements = new HashSet<EObject>(correspondingModelElements);
	if (intersectionOfCorrespondingAndAffectedElements.size() > 0) {
	    List<MRI> correspondingModelElementsMris = new ArrayList<MRI>(correspondingModelElements.size());
	    for (EObject cme : correspondingModelElements) {
		correspondingModelElementsMris.add(cme.get___Mri());
	    }

	    Set<MRI> intersectionOfCorrespondingAndAffectedElementsMris = new HashSet<MRI>(affectedElements);
	    intersectionOfCorrespondingAndAffectedElementsMris.retainAll(correspondingModelElementsMris);
	    intersectionOfCorrespondingAndAffectedElements.clear();
	    for (MRI mri : intersectionOfCorrespondingAndAffectedElementsMris) {
		intersectionOfCorrespondingAndAffectedElements.add((EObject) conn.getElement(mri));
	    }
	}
	return intersectionOfCorrespondingAndAffectedElements;
    }

    private Set<MRI> getAffectedElements(ChangeEvent event, ResourceSet conn) {
	Statistics.getInstance().setCurrentObjectForSelf(reference.getElementForSelf());
	Set<MRI> affectedElements = new HashSet<MRI>();
	for (OclExpressionRegistration registration : registrations) {
	    if (event instanceof ModelChangeEvent) {
		affectedElements.addAll(registration.getAffectedModelElements((ModelChangeEvent) event, conn));
	    }
	}
	return affectedElements;
    }

    public String getDebugInfo(ResourceSet conn) {
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

    public String getDebugInfoAsCsv(ResourceSet conn) {
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