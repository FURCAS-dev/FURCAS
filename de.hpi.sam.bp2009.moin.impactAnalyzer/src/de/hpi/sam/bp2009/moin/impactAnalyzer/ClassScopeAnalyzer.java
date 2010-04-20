package de.hpi.sam.bp2009.moin.impactAnalyzer;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EAttributeImpl;
import org.eclipse.ocl.ecore.NavigationCallExp;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.PropertyCallExp;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.ocl.ecore.delegate.InvocationBehavior;
import org.eclipse.ocl.parser.OCLParsersym;

import de.hpi.sam.bp2009.moin.impactAnalyzer.treewalker.TreeWalker;
import de.hpi.sam.bp2009.solution.eventManager.AndFilter;
import de.hpi.sam.bp2009.solution.eventManager.AssociationFilter;
import de.hpi.sam.bp2009.solution.eventManager.AttributeFilter;
import de.hpi.sam.bp2009.solution.eventManager.ClassFilter;
import de.hpi.sam.bp2009.solution.eventManager.ElementCreateEvent;
import de.hpi.sam.bp2009.solution.eventManager.ElementDeleteEvent;
import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.EventTypeFilter;
import de.hpi.sam.bp2009.solution.eventManager.OrFilter;
import de.hpi.sam.bp2009.solution.eventManager.impl.ElementCreateEventImpl;
import de.hpi.sam.bp2009.solution.eventManager.impl.OrFilterImpl;

/**
 * Collects the events for a single {@link OclExpression} recursively. The analyzer can be parameterized during
 * construction such that it either registers for creation events on the context type or not. Registering for element
 * creation on the context type is useful for invariants / constraints because when a new element is created, validating
 * the constraint may be useful. For other use cases, registering for element creation may not be so useful. For
 * example, when a type inferencer defines its rules using OCL, it only wants to receive <em>update</em> events after
 * the element has been fully initialized from those OCL expressions. In those cases, some framework may be responsible
 * for the initial evaluation of those OCL expressions on new element, and therefore, context element creation events
 * are not of interest.
 * 
 * @author Axel Uhl D043530
 * 
 */
public class ClassScopeAnalyzer extends TreeWalker {
    final private boolean notifyNewContextElements;
    final private Set<EventFilter> filters = new HashSet<EventFilter>();
    
    /**
     * For each operation body analyzed, stores the calls to the operation that were visited
     */
    final private Map<OCLExpression, Set<OperationCallExp>> visitedOperationBodies = new HashMap<OCLExpression, Set<OperationCallExp>>();
    
    // TODO declare structures to accumulate the events of the expression analyzed; may need to add some data to avoid
    // redundant/duplicate filters

    /**
     * Use this constructor when you have a {@link CoreConnection} at hand, meaning that you're "inside" the
     * core. The OCL expression in this case is an "Impl" object.
     * 
     * @param notifyNewContextElements
     *            The analyzer can be parameterized during construction such that it either registers for creation
     *            events on the context type or not. Registering for element creation on the context type is useful for
     *            invariants / constraints because when a new element is created, validating the constraint may be
     *            useful. For other use cases, registering for element creation may not be so useful. For example, when
     *            a type inferencer defines its rules using OCL, it only wants to receive <em>update</em> events after
     *            the element has been fully initialized from those OCL expressions. In those cases, some framework may
     *            be responsible for the initial evaluation of those OCL expressions on new elementt, and therefore,
     *            context element creation events are not of interest.
     */
    public ClassScopeAnalyzer(OCLExpression exp, boolean notifyNewContextElements) {
	super();
	this.notifyNewContextElements = notifyNewContextElements;
	walk((OCLExpression) exp);
    }
    
//    /**
//     * Use this constructor when invoking from outside the core. This means you have a client's connection
//     * at hand, and the OCL expression object is actually a wrapper 
//     * @param conn
//     * @param exp
//     * @param notifyNewContextElements
//     */
//    public ClassScopeAnalyzer(Connection conn, OclExpression exp, boolean notifyNewContextElements) {
//	this(((ConnectionWrapper) conn).unwrap(), (OclExpressionInternal) ((Wrapper<?>) exp).unwrap(),
//		notifyNewContextElements);
//    }

    /**
     * Obtains the event filter for the expression passed to the constructor. When an event matches the filter, the
     * value of the expression may have changed for one or more evaluation contexts. To determine a superset of those
     * context elements for which the value may have changed, feed the event and the {@link OclStatement} holding the
     * expression and its context into
     * {@link InstanceScopeAnalysis#getAffectedElements(com.sap.tc.moin.ocl.utils.OclStatement, com.sap.tc.moin.repository.events.type.ModelChangeEvent, Map)}.
     */
    public EventFilter getEventFilter() {
    	OrFilter orFilter = EventManagerFactory.eINSTANCE.createOrFilter();
    	orFilter.getFilters().addAll(filters);
	return orFilter;
    }
    
    /**
     * TODO check if adding the filter is redundant to another filter already in {@link #filters}. If so, combine into one.
     * 
     * The combination of filters 
     */
    private void addFilter(EventFilter filter) {
	filters.add(filter);
    }

    @Override
    protected void upAssociationEndCallExp(NavigationCallExp exp) {
    	AndFilter andFilter = EventManagerFactory.eINSTANCE.createAndFilter();
    	AssociationFilter assocFilter = EventManagerFactory.eINSTANCE.createAssociationFilter();
    	assocFilter.setReference(exp.getNavigationSource().eContainmentFeature());
    	ClassFilter classFilter = EventManagerFactory.eINSTANCE.createClassFilter();
    	classFilter.setWantedClass(exp.getSource().getType().eClass());
    	andFilter.getFilters().add(assocFilter);
    	andFilter.getFilters().add(classFilter);
    	addFilter(andFilter);
    }

    @Override
    protected void upAttributeCallExp(PropertyCallExp exp) {
	
	EClassifier sourceType = exp.getSource().getType();
	EStructuralFeature attribute = exp.getReferredProperty();
	if (sourceType instanceof EClass) { // and not a TupleType, which is the other possible source type
		AndFilter andFilter = EventManagerFactory.eINSTANCE.createAndFilter();
		AttributeFilter attrFilter = EventManagerFactory.eINSTANCE.createAttributeFilter();
		attrFilter.setAttribute((EAttribute) attribute);
		ClassFilter classFilter = EventManagerFactory.eINSTANCE.createClassFilter();
		classFilter.setWantedClass(sourceType.eClass());
		andFilter.getFilters().add(attrFilter);
		andFilter.getFilters().add(classFilter);
	    addFilter(andFilter);
	}
    }

    @Override
    protected void upOperationCallExp(OperationCallExp exp) {

	if (exp.getReferredOperation().getName().equals("allInstances") ) {
	    OCLExpression typeExp = (OCLExpression) exp.getSource();
	    AndFilter andFilter = EventManagerFactory.eINSTANCE.createAndFilter();
	    OrFilter orFilter = EventManagerFactory.eINSTANCE.createOrFilter();
	    EventTypeFilter evCreateFilter = EventManagerFactory.eINSTANCE.createEventTypeFilter();
	    EventTypeFilter evDeleteFilter = EventManagerFactory.eINSTANCE.createEventTypeFilter();
	    ElementCreateEvent createEvent = EventManagerFactory.eINSTANCE.createElementCreateEvent();
	    ElementDeleteEvent deleteEvent = EventManagerFactory.eINSTANCE.createElementDeleteEvent();
	    evCreateFilter.setEventEClass(createEvent.eClass());
	    evDeleteFilter.setEventEClass(deleteEvent.eClass());
	    orFilter.getFilters().add(evCreateFilter);
	    orFilter.getFilters().add(evDeleteFilter);
	    ClassFilter classFilter = EventManagerFactory.eINSTANCE.createClassFilter();
	    classFilter.setWantedClass(typeExp.getEType().eClass());
	    andFilter.getFilters().add(orFilter);
	    andFilter.getFilters().add(classFilter);
	    
	    addFilter(andFilter);
	} else {
//	    OperationBodyDefinitionImpl a = (OperationBodyDefinitionImpl) connection
//		    .getAssociation(OperationBodyDefinition.ASSOCIATION_DESCRIPTOR);
	    OCLExpression body = InvocationBehavior.INSTANCE.getOperationBody(OCL.newInstance(), exp.getReferredOperation());
	    //a.getBody(exp.getReferredOperation());
	    if (body != null) {
		Set<OperationCallExp> analyzedCallsToBody = visitedOperationBodies.get(body);
		if (analyzedCallsToBody == null) {
		    analyzedCallsToBody = new HashSet<OperationCallExp>();
		    // we didn't analyze the body on behalf of the this analyzer's root expression yet; do it now: 
		    visitedOperationBodies.put(body, analyzedCallsToBody);
		    walk(body);
		}
		analyzedCallsToBody.add(exp);
	    }
	}
    }
    
    /**
     * Returns all the calls to the operation whose body is <tt>operationBody</tt> that are reachable
     * from the root expression analyzed by this {@link ClassScopeAnalyzer}. If no such calls exist,
     * an empty set is returned.
     */
    public Set<OperationCallExp> getCallsOf(OCLExpression operationBody) {
	Set<OperationCallExp> result = visitedOperationBodies.get(operationBody);
	if (result == null) {
	    result = Collections.emptySet();
	}
	return result;
    }

    @Override
    protected void upVariableExp(VariableExp exp) {
	if ( exp.getReferredVariable().getName().equals(OCLParsersym.orderedTerminalSymbols[OCLParsersym.TK_self])
		&& notifyNewContextElements) {
		AndFilter andFilter = EventManagerFactory.eINSTANCE.createAndFilter();
		EventTypeFilter evTypeFilter = EventManagerFactory.eINSTANCE.createEventTypeFilter();
		ClassFilter classFilter = EventManagerFactory.eINSTANCE.createClassFilter();
		classFilter.setWantedClass(exp.getEType().eClass());
		evTypeFilter.setEventEClass(EventManagerFactory.eINSTANCE.createElementCreateEvent().eClass());
		andFilter.getFilters().add(evTypeFilter);
		andFilter.getFilters().add(classFilter);
		addFilter(andFilter);
	}
    }
}
