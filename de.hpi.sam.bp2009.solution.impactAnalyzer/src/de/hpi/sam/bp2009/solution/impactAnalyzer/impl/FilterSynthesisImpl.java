package de.hpi.sam.bp2009.solution.impactAnalyzer.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.delegate.InvocationBehavior;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.parser.OCLParsersym;
import org.eclipse.ocl.utilities.AbstractVisitor;

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

/**
 * Collects the events for a single {@link OCLExpression} recursively. The analyzer can be parameterized during
 * construction such that it either registers for creation events on the context type or not. Registering for element
 * creation on the context type is useful for invariants / constraints because when a new element is created, validating
 * the constraint may be useful. For other use cases, registering for element creation may not be so useful. For
 * example, when a type inferencer defines its rules using OCL, it only wants to receive <em>update</em> events after
 * the element has been fully initialized from those OCL expressions. In those cases, some framework may be responsible
 * for the initial evaluation of those OCL expressions on new element, and therefore, context element creation events
 * are not of interest.
 * 
 */
public class FilterSynthesisImpl extends AbstractVisitor<EPackage, EClassifier, EOperation, EStructuralFeature,
EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> {

    final private boolean notifyNewContextElements;
    /**
     * For each {@link OCLExpression} analyzed, stores the filters to merge into the resulting filter 
     */
    final private Set<EventFilter> filters = new HashSet<EventFilter>();

    /**
     * For each operation body analyzed, stores the calls to the operation that were visited
     */
    final private Map<OCLExpression<EClassifier>, Set<OperationCallExp>> visitedOperationBodies = new HashMap<OCLExpression<EClassifier>, Set<OperationCallExp>>();

    // TODO declare structures to accumulate the events of the expression analyzed; may need to add some data to avoid
    // redundant/duplicate filters

    /**
     * @param exp The {@link OCLExpression} the filter should be created from. 
     * @param notifyNewContextElements
     *            The analyzer can be parameterized during construction such that it either registers for creation
     *            events on the context type or not. Registering for element creation on the context type is useful for
     *            invariants / constraints because when a new element is created, validating the constraint may be
     *            useful. For other use cases, registering for element creation may not be so useful. For example, when
     *            a type inferencer defines its rules using OCL, it only wants to receive <em>update</em> events after
     *            the element has been fully initialized from those OCL expressions. In those cases, some framework may
     *            be responsible for the initial evaluation of those OCL expressions on new element, and therefore,
     *            context element creation events are not of interest.
     */
    public FilterSynthesisImpl(OCLExpression<EClassifier> exp, boolean notifyNewContextElements) {
        super();
        this.notifyNewContextElements = notifyNewContextElements;
        safeVisit(exp);
    }

    public EventFilter getSynthesisedFilter() {
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
    public EPackage handlePropertyCallExp(org.eclipse.ocl.expressions.PropertyCallExp<EClassifier, EStructuralFeature> exp, EPackage sourceResult, List<EPackage> qualifierResults) {
        // TODO will this case distinction still be required once the event manager switches back to EMF notifications?
        if (exp.getReferredProperty() instanceof EReference) {
            AndFilter andFilter = EventManagerFactory.eINSTANCE.createAndFilter();
            AssociationFilter assocFilter = EventManagerFactory.eINSTANCE.createAssociationFilter();
            assocFilter.setReference(exp.getNavigationSource().eContainmentFeature());
            ClassFilter classFilter = EventManagerFactory.eINSTANCE.createClassFilter();
            classFilter.setWantedClass(exp.getSource().getType().eClass());
            andFilter.getFilters().add(assocFilter);
            andFilter.getFilters().add(classFilter);
            addFilter(andFilter);
        } else {
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
        return result;
    }

    @Override
    public EPackage handleOperationCallExp(org.eclipse.ocl.expressions.OperationCallExp<EClassifier, EOperation> exp, EPackage sourceResult, List<EPackage> qualifierResults) {

        if (exp.getReferredOperation().getName().equals("allInstances") ) {
            OCLExpression<EClassifier> typeExp = exp.getSource();
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
            classFilter.setWantedClass(typeExp.getType().eClass());
            andFilter.getFilters().add(orFilter);
            andFilter.getFilters().add(classFilter);

            addFilter(andFilter);
        } else {
            OCLExpression<EClassifier> body = InvocationBehavior.INSTANCE.getOperationBody(OCL.newInstance(), exp.getReferredOperation());
            if (body != null) {
                Set<OperationCallExp> analyzedCallsToBody = visitedOperationBodies.get(body);
                if (analyzedCallsToBody == null) {
                    analyzedCallsToBody = new HashSet<OperationCallExp>();
                    // we didn't analyze the body on behalf of the this analyzer's root expression yet; do it now: 
                    visitedOperationBodies.put(body, analyzedCallsToBody);
                    safeVisit(body);
                }
                analyzedCallsToBody.add((OperationCallExp) exp);
            }
        }
        return result;
    }

    @Override
    public EPackage visitVariableExp(VariableExp<EClassifier, EParameter> var) {
        if ( var.getName().equals(OCLParsersym.orderedTerminalSymbols[OCLParsersym.TK_self])
                && notifyNewContextElements) {
            AndFilter andFilter = EventManagerFactory.eINSTANCE.createAndFilter();
            EventTypeFilter evTypeFilter = EventManagerFactory.eINSTANCE.createEventTypeFilter();
            ClassFilter classFilter = EventManagerFactory.eINSTANCE.createClassFilter();
            classFilter.setWantedClass(var.getType().eClass());
            evTypeFilter.setEventEClass(EventManagerFactory.eINSTANCE.createElementCreateEvent().eClass());
            andFilter.getFilters().add(evTypeFilter);
            andFilter.getFilters().add(classFilter);
            addFilter(andFilter);
        }
        return result;
    }
} //FilterSynthesisImpl
