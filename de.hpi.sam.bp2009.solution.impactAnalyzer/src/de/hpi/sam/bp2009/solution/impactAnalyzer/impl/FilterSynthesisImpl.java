package de.hpi.sam.bp2009.solution.impactAnalyzer.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.query2.EcoreHelper;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.impl.TypeExpImpl;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.parser.OCLParsersym;
import org.eclipse.ocl.utilities.AbstractVisitor;
import org.eclipse.ocl.utilities.PredefinedType;

import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.OrFilter;
import de.hpi.sam.bp2009.solution.eventManager.util.EventFilterFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser;
import de.hpi.sam.bp2009.solution.oclToAst.OclToAstFactory;

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
    final private Map<OCLExpression, Set<OperationCallExp>> visitedOperationBodies = new HashMap<OCLExpression, Set<OperationCallExp>>();

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
    protected FilterSynthesisImpl(OCLExpression exp, boolean notifyNewContextElements) {
        super();
        this.notifyNewContextElements = notifyNewContextElements;
        safeVisit(exp);
    }

    /**
     * Obtains the event filter for the expression passed to the constructor. When an event matches the filter, the
     * value of the expression may have changed for one or more evaluation contexts. To determine a superset of those
     * context elements for which the value may have changed, feed the event into
     * {@link ImpactAnalyzer#getContextObjects(Notification, OCLExpression, org.eclipse.emf.ecore.EClass)}.
     * @return the filter matching all relevant events 
     */
    public EventFilter getSynthesisedFilter() {
        return EventFilterFactory.getInstance().getOrFilterFor(filters.toArray(new EventFilter[filters.size()]));
    }

    /**
     * Returns all the calls to the operation whose body is <tt>operationBody</tt> that are reachable
     * from the root expression analyzed by this {@link FilterSynthesis}. If no such calls exist,
     * an empty set is returned.
     */
    public Set<OperationCallExp> getCallsOf(OCLExpression rootExpression) {
        Set<OperationCallExp> result = visitedOperationBodies.get(rootExpression);
        if (result == null) {
            result = Collections.emptySet();
        }
        return result;
    }

    @Override
    public EPackage handlePropertyCallExp(PropertyCallExp<EClassifier, EStructuralFeature> propCallExp, EPackage sourceResult, List<EPackage> qualifierResults) {
        EClass cls = (EClass) propCallExp.getSource().getType();
        addFilter(EventFilterFactory.getInstance().createFilterForStructuralFeature(cls,propCallExp.getReferredProperty() ));
        return result;
    }

    @Override
    public EPackage handleOperationCallExp(org.eclipse.ocl.expressions.OperationCallExp<EClassifier, EOperation> opCallExp, EPackage sourceResult, List<EPackage> qualifierResults) {

    	if (opCallExp.getReferredOperation().getName().equals(PredefinedType.ALL_INSTANCES_NAME) ) {
    		EClass cls = null;
    		org.eclipse.ocl.expressions.OCLExpression<EClassifier> source = opCallExp.getSource();
    		if (source instanceof TypeExpImpl){
    			cls = (EClass) ((TypeExpImpl)source).getReferredType();
    		}else {
    			cls = (EClass) source.getType();
    		}
    		addFilter(createFilterForElementInsertionOrDeletion(cls));
    	} else {
    		if (opCallExp.getOperationCode() > 0){
    			safeVisit(opCallExp.getSource());
    			for ( org.eclipse.ocl.expressions.OCLExpression<EClassifier> args: opCallExp.getArgument()){
    				safeVisit(args);
    			}               
    		} else {
    			EAnnotationOCLParser parser = OclToAstFactory.eINSTANCE.createEAnnotationOCLParser();
    			parser.convertOclAnnotation(opCallExp.getSource().getType());
    			OCLExpression body = parser.getExpressionFromAnnotationsOf(opCallExp.getReferredOperation(), "body");
    			if (body != null) {
    				Set<OperationCallExp> analyzedCallsToBody = visitedOperationBodies.get(body);
    				if (analyzedCallsToBody == null) {
    					analyzedCallsToBody = new HashSet<OperationCallExp>();
    					// we didn't analyze the body on behalf of the this analyzer's root expression yet; do it now: 
    					visitedOperationBodies.put(body, analyzedCallsToBody);
    					safeVisit(body);
    				}
    				analyzedCallsToBody.add((OperationCallExp) opCallExp);
    			}
    		}
    	}
    	return result;
    }

    @Override
    public EPackage visitVariableExp(VariableExp<EClassifier, EParameter> var) {
        if ( var.getName().equals(OCLParsersym.orderedTerminalSymbols[OCLParsersym.TK_self])
                && notifyNewContextElements) {
            EClass cls = (EClass) var.getType();
            addFilter(createFilterForElementInsertionOrDeletion(cls));
        }
        return result;
    }

    /**
     * TODO check if adding the filter is redundant to another filter already in {@link #filters}. If so, combine into one.
     * 
     * The combination of filters 
     */
    private void addFilter(EventFilter filter) {
        filters.add(filter);
    }

    /**
     * @param clazz
     * @return a filter containing a element creation or deletion filter for all sub types of the given class
     */
    private EventFilter createFilterForElementInsertionOrDeletion(EClass clazz) {
        OrFilter orFilter = EventManagerFactory.eINSTANCE.createOrFilter();
        for(EClass cls: EcoreHelper.getInstance().getAllSubclasses(clazz)){
            orFilter.getFilters().add(EventFilterFactory.getInstance().createFilterForElementInsertionOrDeletion(cls));
        }
        orFilter.getFilters().add(EventFilterFactory.getInstance().createFilterForElementInsertionOrDeletion(clazz));
        return orFilter;
    }
} //FilterSynthesisImpl
