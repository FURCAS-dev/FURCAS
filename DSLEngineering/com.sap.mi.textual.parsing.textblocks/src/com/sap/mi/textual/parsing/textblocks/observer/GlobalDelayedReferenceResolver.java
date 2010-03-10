package com.sap.mi.textual.parsing.textblocks.observer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
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
import textblocks.ForeachContext;
import textblocks.LexedToken;
import textblocks.LexedTokenReferenesSequenceElement;
import textblocks.TextBlock;
import textblocks.TextBlockAdditionalTemplates;
import textblocks.TextBlockType;

import com.sap.mi.textual.common.exceptions.ModelAdapterException;
import com.sap.mi.textual.common.interfaces.IModelElementProxy;
import com.sap.mi.textual.common.interfaces.IRuleName;
import com.sap.mi.textual.common.util.ContextAndForeachHelper;
import com.sap.mi.textual.grammar.ModelElementCreationException;
import com.sap.mi.textual.grammar.impl.DelayedReference;
import com.sap.mi.textual.grammar.impl.ModelInjector;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
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
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.PartitionEditingNotPossibleException;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.ReferencedTransientElementsException;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.EventListener;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.filter.OrFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ElementDeleteEvent;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.InvalidObjectException;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.repository.ocl.freestyle.OclExpressionRegistration;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationSeverity;
import com.sap.tc.moin.textual.moinadapter.adapter.MOINModelAdapter;
import com.sap.tc.moin.textual.moinadapter.adapter.MoinHelper;

public class GlobalDelayedReferenceResolver implements GlobalEventListener, UpdateListener {
    private static final String TEMPORARY_QUERY_PARAM_REPLACEMENT = "__TEMP__";

    public class IAExpressionInvalidationChangeListener implements
	    UpdateListener {

	/**
	 * The OCL expressions used by the {@link #reference} for (re-)evaluation. This
	 * listener will be notified about changes that may affect any of those OCL expressions
	 * in order for the reference to be re-evaluated.
	 */
	private final OclExpressionRegistration[] registrations;
	private final DelayedReference reference;

	public IAExpressionInvalidationChangeListener(
		DelayedReference ref, OclExpressionRegistration... registration) {
	    this.registrations = registration;
	    this.reference = ref;
	}

	@Override
	public void notifyUpdate(EventChain events) {
	    if (!events.getEvents().isEmpty()) {
		Connection conn = events.getEvents().iterator().next().getEventTriggerConnection();
		if(reference.isGenericReference()) {
		     //Its a generic reference not an unresolved one
		     if(reference.getQueryElement() != null) {
		         List<DelayedReference> newRefs = null;
			 if(reference.getQueryElement() instanceof InjectorAction) {
			     newRefs = filterEventsAndRegisterDelayedReferencesForInjectorAction(events, conn);
			 } else if(reference.getQueryElement() instanceof Property) {
			     if(reference.getType() == DelayedReference.CONTEXT_LOOKUP) {
			         newRefs = filterEventsAndQueueDelayedReferencesForContextLookup(events, conn);
			     } else {
			         newRefs = filterEventsAndQueueDelayedReferencesForPropertyQuery(events, conn);
			     }
			 }
			 if(newRefs != null && newRefs.size() > 0) {
			     GlobalDelayedReferenceResolver.this.iaUnresolvedReferences.addAll(newRefs);
	                     backgroundResolver.scheduleIfNeeded();
			 }
		     }
		}
	    }
	}

	private List<DelayedReference> filterEventsAndRegisterDelayedReferencesForInjectorAction(EventChain events,
		Connection conn) {
	    List<DelayedReference> newReferences = new ArrayList<DelayedReference>();
	    boolean allRegistrationsUnaffectedDueToPrimitiveAttributeValueComparisonWithLiteralOnly =
		areAllRegistrationsUnaffectedDueToPrimitiveAttributeValueComparisonWithLiteralOnly(events,
			/* replacement for __TEMP__ */ null);
	    if (!allRegistrationsUnaffectedDueToPrimitiveAttributeValueComparisonWithLiteralOnly) {
		InjectorAction injectorAction = (InjectorAction) conn.getElement(((Partitionable) reference
			.getQueryElement()).get___Mri());
		InjectorActionsBlock injectorActionsBlock = (InjectorActionsBlock) injectorAction
			.refImmediateComposite();
		Template template = injectorActionsBlock.getParentTemplate();

		// now find all TextBlocks referencing this template;
		Collection<TextBlock> tbs = getTextBlocksUsingQueryElement(conn, template);

		Set<MRI> affectedElements = null;
		for (TextBlock textBlock : tbs) {
		    // first check if the alternative in which the injector action resides was
		    // chosen during the parsing process
		    // TODO this is a workaround. to properly decide this we need to keep track
		    // of the alternative chosen at runtime of the parser
		    boolean wasInChosenAlternative = isInjectorActionInChosenAlternative(injectorActionsBlock,
			    textBlock);

		    if (wasInChosenAlternative) {
			if (affectedElements == null) {
			    affectedElements = getAffectedElements(events, conn);
			}
			// TODO if affectedElements.size()==0, don't compute filterCorrespondingOrContextElement...
			Set<RefObject> intersectionOfCorrespondingAndAffectedElements = filterCorrespondingOrContextElementWithAffectedElements(
				conn, affectedElements, textBlock);
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

	private boolean areAllRegistrationsUnaffectedDueToPrimitiveAttributeValueComparisonWithLiteralOnly(
		EventChain events, String replacementFor__TEMP__) {
	    boolean allRegistrationsUnaffectedDueToPrimitiveAttributeValueComparisonWithLiteralOnly = true;
	    for (OclExpressionRegistration registration : registrations) {
		if (!registration.isUnaffectedDueToPrimitiveAttributeValueComparisonWithLiteralOnly(events.getEvents(),
			replacementFor__TEMP__)) {
		    allRegistrationsUnaffectedDueToPrimitiveAttributeValueComparisonWithLiteralOnly = false;
		    break;
		}
	    }
	    return allRegistrationsUnaffectedDueToPrimitiveAttributeValueComparisonWithLiteralOnly;
	}

    private boolean isInjectorActionInChosenAlternative(
            InjectorActionsBlock injectorActionsBlock, TextBlock textBlock) {
        boolean wasInChosenAlternative = false;
        if (textBlock.getTokens().isEmpty()) {
            for (TextBlock tb : textBlock.getSubBlocks()) {
        	if (tb.getSequenceElement() != null
			&& (tb.getSequenceElement().getElementSequence().equals(
				injectorActionsBlock.getElementSequence()) || injectorActionsBlock
				.getElementSequence().refImmediateComposite() instanceof ContextTemplate)) {
		    wasInChosenAlternative = true;
		    break;
		}
            }
	} else {
		for (AbstractToken tok : textBlock.getTokens()) {
		    if (tok instanceof LexedToken) {
			LexedToken lt = (LexedToken) tok;
			// check if injectoraction was in chosen alternative or directly in in the template
			if (lt.getSequenceElement() != null
				&& (lt.getSequenceElement().getElementSequence().equals(
					injectorActionsBlock.getElementSequence()) || injectorActionsBlock
					.getElementSequence().refImmediateComposite() instanceof ContextTemplate)) {
			    wasInChosenAlternative = true;
			    break;
			}
		    }
		}
	    }
        return wasInChosenAlternative;
    }

    private Collection<TextBlock> getTextBlocksUsingQueryElement(
            Connection conn, Template template) {
        TextblockDefinitionReferencesProduction tbDefAssoc = conn.getAssociation(TextblockDefinitionReferencesProduction.ASSOCIATION_DESCRIPTOR);
         TextBlockDefinition def = tbDefAssoc.getTextBlockDefinition(template).iterator().next();
         TextBlockType tbTypeAssoc = conn.getAssociation(TextBlockType.ASSOCIATION_DESCRIPTOR);
         Collection<TextBlock> tbs = new ArrayList<TextBlock>(tbTypeAssoc.getTextBlock(def));
         //now find all TextBlocks that reference the template in their "additionalTemplate"
         TextBlockAdditionalTemplates tbAdditionalAssoc = conn.getAssociation(TextBlockAdditionalTemplates.ASSOCIATION_DESCRIPTOR);
         Collection<TextBlock> additionalTbs = tbAdditionalAssoc.getTextblock(template);
         tbs.addAll(additionalTbs);
         tbs = TbUtil.filterVersionedTextBlockForNewest(tbs);
        return tbs;
    }

    private List<DelayedReference> filterEventsAndQueueDelayedReferencesForPropertyQuery(
            EventChain events, Connection conn) {
        Collection<LexedToken> toks = getTokensUsingQueryElement(conn);
         Set<MRI> affectedElements = getAffectedElements(events, conn);
         List<DelayedReference> newReferences = new ArrayList<DelayedReference>();
         if(affectedElements.size() > 0) {
             for (LexedToken lt : toks) {
        	 boolean allRegistrationsUnaffectedDueToPrimitiveAttributeValueComparisonWithLiteralOnly =
        	     areAllRegistrationsUnaffectedDueToPrimitiveAttributeValueComparisonWithLiteralOnly(events, lt.getValue());
                 if(!allRegistrationsUnaffectedDueToPrimitiveAttributeValueComparisonWithLiteralOnly) {
                     Set<RefObject> intersectionOfCorrespondingAndAffectedElements = filterCorrespondingOrContextElementWithAffectedElements(
                                 conn, affectedElements, lt.getParentBlock());
                    if(intersectionOfCorrespondingAndAffectedElements.size() > 0) {
                        newReferences.addAll(getReferencesToReEvaluate(conn, lt));
                    }
                 }
            }
         }
         return newReferences;
    }
    
    
    private List<DelayedReference> filterEventsAndQueueDelayedReferencesForContextLookup(
            EventChain events, Connection conn) {
         Collection<LexedToken> toks = getTokensUsingQueryElement(conn);
         Set<MRI> affectedElements = getAffectedElements(events, conn);
         List<DelayedReference> newReferences = new ArrayList<DelayedReference>();
         if(affectedElements.size() > 0) {
             for (LexedToken lt : toks) {
        	 boolean allRegistrationsUnaffectedDueToPrimitiveAttributeValueComparisonWithLiteralOnly =
        	     areAllRegistrationsUnaffectedDueToPrimitiveAttributeValueComparisonWithLiteralOnly(events, lt.getValue());
                 if(!allRegistrationsUnaffectedDueToPrimitiveAttributeValueComparisonWithLiteralOnly) {
                     Set<RefObject> intersectionOfCorrespondingAndAffectedElements = filterAffectedElements(conn, 
                             affectedElements, Collections.singletonList(lt.getParentBlock()));
                    if(intersectionOfCorrespondingAndAffectedElements.size() > 0) {
                        newReferences.addAll(getReferencesToReEvaluate(conn, lt));
                    }
                 }
            }
         }
         return newReferences;
    }
    

    private Collection<? extends DelayedReference> getReferencesToReEvaluate(Connection conn, LexedToken lt) {
        Set<RefObject> result = filterCorrespondingElementsByDelayedReferenceSourceType(
                    conn, lt.getParentBlock(), reference);
        List<DelayedReference> newReferences = new ArrayList<DelayedReference>();
            for (RefObject ro : result) {
                DelayedReference clonedRef = reference.clone();
                clonedRef.setModelElement(ro);
                clonedRef.setRealValue(null);
                clonedRef.setConnection(conn);
                
                clonedRef.setToken(new LexedTokenWrapper(lt));
                clonedRef.setTextBlock(lt.getParentBlock());
                clonedRef.setKeyValue(lt.getValue());
                String oclQuery = clonedRef.getOclQuery();
                clonedRef.setOclQuery(oclQuery.replaceAll(TEMPORARY_QUERY_PARAM_REPLACEMENT, lt.getValue()));
                newReferences.add(clonedRef);
            }
        return newReferences;
    }

    private Collection<LexedToken> getTokensUsingQueryElement(Connection conn) {
        Property property = (Property) conn.getElement(((Partitionable)reference.getQueryElement()).get___Mri());
         //now find all TextBlocks referencing this property;
         LexedTokenReferenesSequenceElement lexedTokenSeqElAssoc = conn.getAssociation(LexedTokenReferenesSequenceElement.ASSOCIATION_DESCRIPTOR);
         Collection<LexedToken> toks = lexedTokenSeqElAssoc.getLexedtoken(property);
        return toks;
    }

        /**
	 * Filters the given elements with the corresponding elements or, if the query
	 * uses a #context reference with the context element of the given {@link TextBlock}.<p>
	 * 
	 * TODO handle #foreach here too
	 * 
	 * @param conn the connection used to resolve the MRIs within affecedElements
	 * @param affectedElements Elements that were affected by 
	 * @param node The {@link TextBlock} which's corresponding elements should be filtered.
	 * @return the intersection between affected elements and the corresponding elements of the given {@link TextBlock}. 
	 */
	private Set<RefObject> filterCorrespondingOrContextElementWithAffectedElements(Connection conn,
		Set<MRI> affectedElements, DocumentNode node) {
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
		    Object taggedContext = localContextBuilder.getContextManager().getTaggedContext(
			    innermostContext, ContextAndForeachHelper.getContextTag(reference.getOclQuery()));
		    if (taggedContext != null) {
			// null may occur in case the node leads to a context stack that doesn't fit the
			// context stack expected by the OCL expression; in this case, e.g., if a tag exists
			// on the OCL expression's #context, no context object will be found. In this case,
			// don't add anything to the correspondingModelElements.
			RefObject unwrappedContext = null;
			if (taggedContext instanceof IModelElementProxy) {
			    unwrappedContext = (RefObject) ((IModelElementProxy) taggedContext).getRealObject();
			} else {
			    unwrappedContext = (RefObject) taggedContext;
			}
			correspondingModelElements.add(unwrappedContext);
		    }
		}
	    } else if(usesForEach) {
	        correspondingModelElements = new ArrayList<RefObject>();
	        sourceModelElements = new HashSet<RefObject>();
	        Collection<ForeachContext> fec = null;
	        if(node instanceof TextBlock) {
	            fec = ((TextBlock)node).getForeachContext();
	        } else {
	            fec = ((TextBlock)node.refImmediateComposite()).getForeachContext();
	        }
	        for (ForeachContext foreachContext : fec) {
                    if(foreachContext.getForeachPredicatePropertyInit().equals(reference.getQueryElement())) {
                        correspondingModelElements.addAll(foreachContext.getContextElement());
                        sourceModelElements.add(foreachContext.getSourceModelelement());
                    }
                }
	    } else {
                correspondingModelElements = new ArrayList<RefObject>(node.getCorrespondingModelElements());
                correspondingModelElements.addAll(node.getReferencedElements());
            }

	    Set<RefObject> intersectionOfCorrespondingAndAffectedElements = filterAffectedElements(conn,
		    affectedElements, correspondingModelElements);
	    if (isContext) {
		if (intersectionOfCorrespondingAndAffectedElements.size() > 0) {
		    Set<RefObject> result = filterCorrespondingElementsByDelayedReferenceSourceType(conn, node, reference);
		    return result;
		} else {
		    return new HashSet<RefObject>(0);
		}
	    } else if(usesForEach) {
	        return sourceModelElements;
	    } else {
		return intersectionOfCorrespondingAndAffectedElements;
	    }
	}

        private Set<RefObject> filterAffectedElements(Connection conn,
                Set<MRI> affectedElements,
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

	

	private Set<MRI> getAffectedElements(EventChain events, Connection conn) {
	    Statistics.getInstance().setCurrentObjectForSelf(reference.getElementForSelf());
	    Set<MRI> affectedElements = new HashSet<MRI>();
	    for (OclExpressionRegistration registration : registrations) {
		affectedElements.addAll(registration.getAffectedModelElements(events, conn));
	    }
	    return affectedElements;
	}
    }

    public class BackgroundResolver  {
	
	private final GlobalDelayedReferenceResolver resolver;
	
        public BackgroundResolver(final GlobalDelayedReferenceResolver resolver) {
	    this.resolver = resolver;
	}

	public void scheduleIfNeeded() {
	    if (!resolver.hasEmptyQueue()) {
		resolver.resolveReferences(new NullProgressMonitor());
	    }
	}
    }

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
    private final Map<DelayedReference, String[]> delayedReference2RegistrationNames = new HashMap<DelayedReference, String[]>();

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
    
    
    /**
     * Filtes the elements in {@link DocumentNode#getCorrespondingModelElements()} by comparing them
     * to the type given by the parent template of the query element of the {@link #reference}.
     * 
     * @param conn The connection to use to resolve the template
     * @param node To node from which the corresponding elements should be filtered.
     * @param delayedReference TODO
     * @return A type filtered set of elements by the {@link #reference}'s query elements template.
     */
    private Set<RefObject> filterCorrespondingElementsByDelayedReferenceSourceType(Connection conn, DocumentNode node, DelayedReference delayedReference) {
        Set<RefObject> result = new HashSet<RefObject>();
        RefObject queryElement = (RefObject) conn.getElement(((Partitionable)delayedReference.getQueryElement()).get___Mri());
        for (RefObject refObject : node.getCorrespondingModelElements()) {
           
                    if(refObject.refIsInstanceOf(TcsUtil.getParentTemplate(queryElement).getMetaReference(), false)){
                        result.add(refObject);
                    }
                }
        return result;
    }
    
    private Set<IAExpressionInvalidationChangeListener> getAllListeners() {
	Set<IAExpressionInvalidationChangeListener> result = new HashSet<IAExpressionInvalidationChangeListener>();
	for (Map<EventFilter, Map<ListenerType, EventListener>> m : delayedReference2ReEvaluationListener.values()) {
	    for (Map<ListenerType, EventListener> ltel : m.values()) {
		for (EventListener listener : ltel.values()) {
		    result.add((IAExpressionInvalidationChangeListener) listener);
		}
	    }
	}
	return result;
    }
    
    public boolean hasEmptyQueue() {
        return iaUnresolvedReferences.isEmpty();
    }
    
    public String getDebugInfo(Connection conn) {
	Statistics oclIaStatistics = Statistics.getInstance();
	StringBuilder result = new StringBuilder();
	for (IAExpressionInvalidationChangeListener listener : getAllListeners()) {
	    for (OclExpressionRegistration registration : listener.registrations) {
		if (registration != null) {
		    result.append(oclIaStatistics.toString(registration, conn));
		    result.append('\n');
		}
	    }
	}
	return result.toString();
    }
    
    public String getDebugInfoAsCsv(Connection conn) {
	Statistics oclIaStatistics = Statistics.getInstance();
	StringBuilder result = new StringBuilder();
	result.append(oclIaStatistics.getCsvHeader());
	for (IAExpressionInvalidationChangeListener listener : getAllListeners()) {
	    for (OclExpressionRegistration registration : listener.registrations) {
		if (registration != null) {
		    result.append(oclIaStatistics.toCsv(registration, conn));
		    result.append('\n');
		}
	    }
	}
	return result.toString();
    }

    /**
     * Clears all currently deferred references.
     * 
     * This should ONLY be used in tests.
     */
    public void clearUnresolvedIAReferences() {
	iaUnresolvedReferences.clear();
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
	String[] regs = delayedReference2RegistrationNames.remove(unresolvedRef);
	for (String reg : regs) {
	    registration2DelayedReference.remove(reg);
	}
	Map<EventFilter, Map<ListenerType, EventListener>> filter = delayedReference2ReEvaluationListener
		.remove(unresolvedRef);
	if (filter != null) {
	    registry.removeFilters(filter);
	}
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
	    ModelInjector modelInjector = constructModelInjector(conn,
                    outermostPackage);
	    ObservableInjectingParser parser = null;
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
		cs = tokenInCurrentConnection.getParentBlock().getType().getParseRule().getConcretesyntax();
		parser = getParser(cs);
		((ParserTextBlocksHandler) parser.getObserver()).setConnection(conn);
		TbUtil.constructContext(tokenInCurrentConnection,
			localContextBuilder);
		referringDocumentNode = tokenInCurrentConnection;
                //also rebuild the context for the parser, 
                //as it may be used e.g. in foreach predicate references
		if(unresolvedRef.getType() == DelayedReference.SEMANTIC_PREDICATE) {
		    parser.reset();
                    TbUtil.constructContext(tokenInCurrentConnection, parser);
		}
		if(!localContextBuilder.getContextStack().isEmpty()) {
		    unresolvedRef.setContextElement(localContextBuilder.getContextStack().peek());
		}
		
	    } else if (contextTextBlock != null) {
		TbUtil.constructContext(contextTextBlock, localContextBuilder);
		referringDocumentNode = contextTextBlock;
		if(!localContextBuilder.getContextStack().isEmpty()) {
		    unresolvedRef.setContextElement(localContextBuilder.getContextStack().peek());
		}
		cs = contextTextBlock.getType().getParseRule().getConcretesyntax();
		parser = getParser(cs);
		//also rebuild the context for the parser, 
                //as it may be used e.g. in foreach predicate references
                if(unresolvedRef.getType() == DelayedReference.SEMANTIC_PREDICATE) {
                    parser.reset();
                    TbUtil.constructContext(contextTextBlock, parser);
                    ((ParserTextBlocksHandler) parser.getObserver()).setConnection(conn);
                    parser.setInjector(modelInjector);
                    //remove all old values
                    try {
                        Set<RefObject> correspondingElements = new HashSet<RefObject>(unresolvedRef.getTextBlock().getCorrespondingModelElements());
                        Set<RefObject> filteredElements = filterCorrespondingElementsByDelayedReferenceSourceType(conn, unresolvedRef.getTextBlock(), unresolvedRef);
                        correspondingElements.removeAll(filteredElements);
                        for (RefObject value : correspondingElements) {
                            modelInjector.unset(unresolvedRef.getModelElement(), unresolvedRef.getPropertyName(), value);
                            //if we are here no exception occurred which means element was successfully unset
                            //as foreachpredicates always create new values we have to delete the old one
                            value.refDelete();
                            // FIXME remove DelayedReferences from queue that try to set a property on value
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }

	    } else {
		removeRegistration(unresolvedRef);
		notifyReferenceResolvingListenerReferencesRemoved(Collections
			.singleton(unresolvedRef));
		return;
	    }
        	//TODO set currentForeachElement on reference
	    try {
		// ensure that the model element uses the current connection
		RefObject elementInCurrentConnection = (RefObject) conn
			.getElement(((Partitionable) unresolvedRef
				.getModelElement()).get___Mri());
		if (elementInCurrentConnection != null) {
		    unresolvedRef.setModelElement(elementInCurrentConnection);
		    
                    boolean resolved = modelInjector.resolveReference(unresolvedRef,
			    localContextBuilder.getContextManager(), 
			    parser);
		    if (resolved) {
			if (unresolvedRef.getType() == DelayedReference.SEMANTIC_PREDICATE) {
			    // to be able to incrementally re evaluate the reference later
			    // we need to setup a link between the textblock and the
			    // template used in the ref
			    unresolvedRef.getTextBlock().getAdditionalTemplates().add(
				    ((ParserTextBlocksHandler) parser.getObserver()).getCurrentTbProxy()
					    .getTemplate());
                            referringDocumentNode.getCorrespondingModelElements().add(
                                        (RefObject) unresolvedRef.getRealValue());
                            TbUtil.addForEachContext(unresolvedRef
                                    .getTextBlock(), (RefObject) unresolvedRef
                                    .getModelElement(), (RefObject) unresolvedRef
                                    .getCurrentForeachElement(),(ForeachPredicatePropertyInit) unresolvedRef
                                    .getQueryElement(), (RefObject) unresolvedRef.getRealValue(), conn);
                            parser.setDelayedReferencesAfterParsing();
			} else {
			    if (unresolvedRef.getRealValue() instanceof RefObject) {
			        referringDocumentNode.getReferencedElements().add(
					(RefObject) unresolvedRef.getRealValue());
			    }
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
                            elementClass, property, cs);
                }
	    } finally{
                //monitor.done();
            }
	    registeredSytaxes.add(cs);
	}
    }

    private void registerPropertyQueryForIA(Connection connection,
            Collection<RefPackage> packagesForLookup, MofClass elementClass,
            Property property, ConcreteSyntax cs) {
        Template template = property.getParentTemplate();
        if (template != null && template.getMetaReference() instanceof MofClass) {
            // TODO what about StructureTypes?
            QueryParg qarg = TcsUtil.getQueryParg(property);
            // TODO still needed? if not, delete
            // RefersToParg refersToArg = TcsUtil.getRefersToParg(property);
            FilterParg filter = TcsUtil.getFilterParg(property);
            if (qarg != null) {
                try {
                    String query = qarg.getQuery();
                    if (filter != null) {
                        query += filter.getFilter();
                    }
                    RefObject parsingContext = ContextAndForeachHelper.getParsingContext(connection, query, template, packagesForLookup, elementClass);
                    DelayedReference ref = new DelayedReference(
                            null,
                            null,
                            null,
                            property.getPropertyReference().getStrucfeature().getName(), null, null, query, false, null);
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
                            ref, registration);
                        GlobalEventListenerRegistry registry = (GlobalEventListenerRegistry) context
                            .getService(globalEventListenerRegistryRef);
                        registry.addFilters(reEvaluationListener);
                        registration2DelayedReference.put(registration.getName(), ref);
                        delayedReference2RegistrationNames.put(ref, new String[] { registration.getName() });
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
//            else if(refersToArg != null) {
//                String query = refersToArg.getPropertyName();
//                try {                   
//                    RefObject parsingContext = null;
//                    if (!MoinHelper.usesContext(query)) {
//                        query = "self.lookInContext(null)";
//                    } else {
//                        parsingContext = elementClass;
//                        // TODO add context tag instead of "null"
//                        query = "self.lookInContext(null)";
//                    }
//                    String qualifiedName = TcsUtil.joinNameList(property.getPropertyReference().getStrucfeature().getType().getQualifiedName());
//                    query += "->select(e | e.oclIsKindOf(" +
//                            qualifiedName + "))->select(e | e.oclAsType(" + qualifiedName + ")."
//                            + refersToArg.getPropertyName() + " = '" + TEMPORARY_QUERY_PARAM_REPLACEMENT + "')";;
//                    
//                    DelayedReference ref = new DelayedReference(
//                            null,
//                            null,
//                            property.getPropertyReference().getStrucfeature().getName(),
//                            null, null, query, false, null);
//                    ref.setType(DelayedReference.CONTEXT_LOOKUP);
//                    parsingContext = connection.getClass(TextBlock.CLASS_DESCRIPTOR).refMetaObject();
//                    ref.setQueryElement(property);
//                    ref.setGenericReference(true);
//                    String name = "<genericReference>" + property.refMofId();
//                    OclExpressionRegistration registration = (OclExpressionRegistration) connection
//                        .getOclRegistryService().getFreestyleRegistry()
//                        .getRegistration(name);
//                    if (registration != null) {
//                        connection.getOclRegistryService().getFreestyleRegistry()
//                            .deleteRegistration(name);
//                    }
//                    registration = connection.getOclRegistryService()
//                        .getFreestyleRegistry().createExpressionRegistration(name,
//                            query, OclRegistrationSeverity.Info,
//                            new String[] { "TCS Property Context Lookup" }, parsingContext,
//                            packagesForLookup.toArray(new RefPackage[] {}));
//                    Map<EventFilter, Map<ListenerType, EventListener>> reEvaluationListener = createReEvaluationListener(
//                        registration, ref);
//                    GlobalEventListenerRegistry registry = (GlobalEventListenerRegistry) context
//                        .getService(globalEventListenerRegistryRef);
//                    registry.addFilters(reEvaluationListener);
//                    registration2DelayedReference.put(registration.getName(), ref);
//                    delayedReference2Registration.put(ref, registration.getName());
//                    delayedReference2ReEvaluationListener.put(ref,
//                        reEvaluationListener);
//
//                } catch (OclManagerException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                } catch(MoinLocalizedBaseRuntimeException ex) {
//                    System.err.println("Failed to register at IA: " + query + "\n" + ex.getMessage());
//                    ex.printStackTrace();
//                }
//            }
        }
    }

    private void registerForEachPropertyInitForIA(ConcreteSyntax cs,
            Connection connection, Collection<RefPackage> packagesForLookup,
            MofClass elementClass, InjectorAction injectorActionBase, IRuleName ruleNameFinder) {
        ForeachPredicatePropertyInit foreachPredicatePropertyInit = (ForeachPredicatePropertyInit) injectorActionBase;
        InjectorActionsBlock block = foreachPredicatePropertyInit.getInjectorActionsBlockReference();
        Template template = block.getParentTemplate();
        String query = foreachPredicatePropertyInit.getValue();
        try {
            List<com.sap.mi.textual.grammar.impl.PredicateSemantic> list = new ArrayList<com.sap.mi.textual.grammar.impl.PredicateSemantic>();
            String mode = template instanceof ClassTemplate ? ((ClassTemplate) template).getMode() : null;
            for (PredicateSemantic next : foreachPredicatePropertyInit.getPredicatesemantic()) {
                String localMode = mode;
                if (next.getMode() != null) {
                    localMode = next.getMode();
                }
                if (next.getWhen() != null) {
                    list.add(new com.sap.mi.textual.grammar.impl.PredicateSemantic(
                            next.getWhen(),
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
                        null, DelayedReference.SEMANTIC_PREDICATE, 
                        null,
                        foreachPredicatePropertyInit.getPropertyReference().getStrucfeature().getName(), query, foreachPredicatePropertyInit.getMode(), list, ruleNameFinder, null, 
                        hasContext, /*isOptional: ForEach is always considered optional as 
                         * error reporting will be done based on metamodel constraints.*/
                        true);
	    ref.setQueryElement(foreachPredicatePropertyInit);
	    ref.setGenericReference(true);
                
            //now replace any #context parts within the query with self
            //and use the context element type for registration if it is
            //used here, 
            registerOclExpressionsOfForeachConstruct(connection, packagesForLookup, elementClass,
		    foreachPredicatePropertyInit, template, ref);
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

    /**
     * Combine the <tt>foreach</tt> and all <tt>when</tt> expressions into one event listener. For each expression a
     * separate {@link OclExpressionRegistration} is created. Their event filters are combined into one filter by using
     * an {@link OrFilter}. Therefore, events that affect any of the <tt>foreach</tt> or the <tt>when</tt> expressions
     * are delivered to the <tt>ref</tt> reference only once. The same listener instance is registered for the combined
     * event filter.
     */
    private void registerOclExpressionsOfForeachConstruct(Connection connection,
	    Collection<RefPackage> packagesForLookup, MofClass elementClass,
	    ForeachPredicatePropertyInit foreachPredicatePropertyInit, Template template, DelayedReference ref) throws ModelAdapterException, OclManagerException {
	Set<OclExpressionRegistration> registrations = new HashSet<OclExpressionRegistration>();
	Map<String, String> mofIdToOclQueryPairs = new HashMap<String, String>();
	if (foreachPredicatePropertyInit.getValue() != null) {
	    mofIdToOclQueryPairs.put(foreachPredicatePropertyInit.refMofId(), foreachPredicatePropertyInit.getValue());
	}
	for (PredicateSemantic whenClause : foreachPredicatePropertyInit.getPredicatesemantic()) {
	    if (whenClause.getWhen() != null) {
		mofIdToOclQueryPairs.put(whenClause.refMofId(), whenClause.getWhen());
	    }
	}
	List<String> registrationNames = new ArrayList<String>();
	for (String mofId : mofIdToOclQueryPairs.keySet()) {
	    String oclRegistrationName = "<genericReference>" + mofId;
	    OclExpressionRegistration registration = (OclExpressionRegistration) connection
	        .getOclRegistryService().getFreestyleRegistry()
	        .getRegistration(oclRegistrationName);
	    if (registration != null) {
	        connection.getOclRegistryService().getFreestyleRegistry()
	            .deleteRegistration(oclRegistrationName);
	    }
	    RefObject parsingContext = ContextAndForeachHelper.getParsingContext(connection, mofIdToOclQueryPairs.get(mofId), template, packagesForLookup, elementClass);
	    String preparedQuery = MoinHelper.prepareOclQuery(mofIdToOclQueryPairs.get(mofId), null, null);
	    registration = connection.getOclRegistryService()
	        .getFreestyleRegistry().createExpressionRegistration(oclRegistrationName,
	            preparedQuery, OclRegistrationSeverity.Info,
	            new String[] { "TCS Property Init" }, parsingContext,
	            packagesForLookup.toArray(new RefPackage[] {}));
	    registrations.add(registration);
	    registration2DelayedReference.put(oclRegistrationName, ref);
	    registrationNames.add(oclRegistrationName);
	}
	delayedReference2RegistrationNames.put(ref, registrationNames.toArray(new String[0]));
	Map<EventFilter, Map<ListenerType, EventListener>> reEvaluationListener = createReEvaluationListener(ref,
		registrations.toArray(new OclExpressionRegistration[0]));
	GlobalEventListenerRegistry registry = (GlobalEventListenerRegistry) context
		.getService(globalEventListenerRegistryRef);
	registry.addFilters(reEvaluationListener);
	delayedReference2ReEvaluationListener.put(ref, reEvaluationListener);
    }

    private void registerLookupPropertyInitForIA(ConcreteSyntax cs,
            Connection connection, Collection<RefPackage> packagesForLookup,
            MofClass elementClass, InjectorAction injectorActionBase) {
        LookupPropertyInit injectorAction = (LookupPropertyInit) injectorActionBase;
        Template template = ((InjectorActionsBlock) injectorAction
            .refImmediateComposite()).getParentTemplate();
        String query = injectorAction.getValue();
        RefObject parsingContext = ContextAndForeachHelper.getParsingContext(connection, query, template, packagesForLookup, elementClass);
        try {
            DelayedReference ref = new DelayedReference(null, null,
                    null, injectorAction.getPropertyReference().getStrucfeature()
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
                    ref, registration);
                GlobalEventListenerRegistry registry = (GlobalEventListenerRegistry) context
                    .getService(globalEventListenerRegistryRef);
                registry.addFilters(reEvaluationListener);
                registration2DelayedReference.put(registration.getName(), ref);
                delayedReference2RegistrationNames.put(ref, new String[] { registration.getName() });
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
     * Fetches the event filters for <tt>registrations</tt> (see
     * {@link OclExpressionRegistration#getEventFilter(boolean)}) and combines them into one {@link OrFilter}. An event
     * filter map suitable for use with {@link GlobalEventListenerRegistry#addFilters(Map)} is created with a new
     * {@link IAExpressionInvalidationChangeListener} listener object for the <tt>ref</tt> reference.
     */
    private Map<EventFilter, Map<ListenerType, EventListener>> createReEvaluationListener(
	    DelayedReference ref, OclExpressionRegistration... registrations) {
	IAExpressionInvalidationChangeListener listener = new IAExpressionInvalidationChangeListener(ref, registrations);
	Map<EventFilter, Map<ListenerType, EventListener>> map = new HashMap<EventFilter, Map<ListenerType, EventListener>>();
	Set<EventFilter> filters = new HashSet<EventFilter>();
	for (OclExpressionRegistration registration : registrations) {
	    // notifyNewContextElement can be set to false because element creation is handled by the
	    // parser itself, evaluating all properties initially that cna be evaluated at that point.
	    filters.add(registration.getEventFilter(/* notifyNewContextElement */false));
	}
	OrFilter filter = new OrFilter(filters.toArray(new EventFilter[0]));
	Map<ListenerType, EventListener> listenerForType = new HashMap<ListenerType, EventListener>();
	listenerForType.put(ListenerType.UPDATE, listener);
	map.put(filter, listenerForType);
	return map;
    }
    
    public void resolveReferences(IProgressMonitor monitor) {
	Collection<DelayedReference> workingCopy = new ArrayList<DelayedReference>(iaUnresolvedReferences);
	monitor.beginTask("Reevaluating OCL References...", workingCopy.size());
	Collection<DelayedReference> deferredReferences = new ArrayList<DelayedReference>();
	Set<Connection> connectionsToSave = new HashSet<Connection>();
	iaUnresolvedReferences.removeAll(workingCopy);
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
		final RefPackage outermostPackage = MoinHelper.getOutermostPackageThroughClusteredImports(ref.getConnection(),
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
		connectionsToSave.add(ref.getConnection());
	    } catch (InvalidObjectException ex) {
		Activator.logWarning("Could not re-resolve reference: " + ref + ". Element: " + ref.getModelElement()
			+ " is not alive anymore! Reference is ignored and removed.");
	    } catch (PartitionEditingNotPossibleException ex) {
		Activator.logWarning("Could not re-resolve reference: " + ref + ". Partition: " + ex.getPri()
			+ " is locked by connection " + ref.getConnection() +"! Will try again later");
		deferredReferences.add(ref);
	    } catch (Exception ex) {
		Activator.logError(ex, " Could not re-resolve reference: " + ref + ". Reference is ignored and removed.");
	    }
	    monitor.worked(1);
	}
	//TODO see if this is good, maybe we should not save these connection automatically
	for (Connection connection : connectionsToSave) {
            try {
                connection.save();
            } catch (NullPartitionNotEmptyException e) {
                Activator.logError(e, " Could not save connection: " + connection + " after re-resolving reference");
            } catch (ReferencedTransientElementsException e) {
                Activator.logError(e, " Could not save connection: " + connection + " after re-resolving reference");
            } catch (PartitionsNotSavedException e) {
                Activator.logError(e, " Could not save connection: " + connection + " after re-resolving reference");
            }
        }
	// deferred references will tried to be resolved again later so dont't
	// remove them
	iaUnresolvedReferences.addAll(deferredReferences);
	backgroundResolver.scheduleIfNeeded();
	monitor.done();
    }
}
