package de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.notify.Notification;
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
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.NavigationCallExp;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.PropertyCallExp;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.TupleType;
import org.eclipse.ocl.ecore.TypeExp;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.delegate.InvocationBehavior;
import org.eclipse.ocl.ecore.impl.TypeExpImpl;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.utilities.AbstractVisitor;
import org.eclipse.ocl.utilities.PredefinedType;

import com.sap.emf.ocl.util.OclHelper;

import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;

/**
 * Collects the relevant events for a single {@link OCLExpression} recursively. The analyzer can be parameterized during
 * construction such that it either registers for creation events on the context type or not. Registering for element
 * creation on the context type is useful for invariants / constraints because when a new element is created, validating
 * the constraint may be useful. For other use cases, registering for element creation may not be so useful. For
 * example, when a type inferencer defines its rules using OCL, it only wants to receive <em>update</em> events after
 * the element has been fully initialized from those {@link OCLExpression}. In those cases, some framework may be responsible
 * for the initial evaluation of those {@link OCLExpression}s on new element, and therefore, context element creation events
 * are not of interest.
 * 
 * @author Tobias Hoppe
 * @author Axel Uhl
 */
public class FilterSynthesisImpl extends AbstractVisitor<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint>
implements OperationBodyToCallMapper {

    final private boolean notifyNewContextElements;
    /**
     * For each {@link OCLExpression} analyzed, stores the filters to merge into the resulting filter 
     */
    final protected Set<EventFilter> filters = new HashSet<EventFilter>();

    /**
     * For each operation body analyzed, stores the calls to the operation that were visited
     */
    final private Map<OCLExpression, Set<OperationCallExp>> visitedOperationBodies = new LinkedHashMap<OCLExpression, Set<OperationCallExp>>();
 
    private final Map<EAttribute, Set<PropertyCallExp>> attributeCallExpressions = new HashMap<EAttribute, Set<PropertyCallExp>>();
    protected final Map<EReference, Set<NavigationCallExp>> associationEndCallExpressions = new HashMap<EReference, Set<NavigationCallExp>>();
    private final Set<OCLExpression> visitedExpressions = new HashSet<OCLExpression>();
    private final Map<EClassifier, Set<OperationCallExp>> allInstancesCalls = new HashMap<EClassifier, Set<OperationCallExp>>();
    private final Stack<OCLExpression> visitedOperationBodyStack = new Stack<OCLExpression>();
    private final Map<OCLExpression, Set<Variable>> selfVariablesUsedInBody = new HashMap<OCLExpression, Set<Variable>>();
    private final Map<OCLExpression, Set<Variable>> parameterVariablesUsedInBody = new HashMap<OCLExpression, Set<Variable>>();
    private final OCL ocl;
 
    /**
     * @param expression The {@link OCLExpression} the filter should be created for. 
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
    public FilterSynthesisImpl(OCLExpression expression, boolean notifyNewContextElements, OCL ocl) {
        super();
        this.notifyNewContextElements = notifyNewContextElements;
        this.ocl = ocl;
        walk(expression);
    }

    @Override
    public EPackage handlePropertyCallExp(org.eclipse.ocl.expressions.PropertyCallExp<EClassifier, EStructuralFeature> propCallExp, EPackage sourceResult, List<EPackage> qualifierResults) {
        EClass cls = (EClass) propCallExp.getSource().getType();
        EStructuralFeature property = propCallExp.getReferredProperty();
        if (cls instanceof TupleType){
            // ignore TupleTypes, because the tuple parts were already handled
            // no filters to add to the result
            return result;
        }
        if (property instanceof EAttribute){
            filters.add(EventManagerFactory.eINSTANCE.createFilterForEAttribute( cls, (EAttribute) property));
            EAttribute refAttr = (EAttribute)property;
            Set<PropertyCallExp> set = attributeCallExpressions.get(refAttr);
            if (set==null) {
                set = new HashSet<PropertyCallExp>();
                attributeCallExpressions.put(refAttr, set);
            }
            set.add((PropertyCallExp) propCallExp);
            
        } else if (propCallExp.getReferredProperty() instanceof EReference){
            filters.add(EventManagerFactory.eINSTANCE.createFilterForEReference(cls, (EReference) property));
            EReference refRef = (EReference) property;
            Set<NavigationCallExp> set = associationEndCallExpressions.get(refRef);
            if (set==null) {
                set = new HashSet<NavigationCallExp>();
                associationEndCallExpressions.put(refRef, set);
            }
            set.add((PropertyCallExp) propCallExp);
        } else {
            throw new RuntimeException("Unhandled subclass of EStructuralFeature.");
        }
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
            filters.add(createFilterForElementInsertionOrDeletion(cls));
            EClassifier classifier = ((TypeExp) opCallExp.getSource()).getReferredType();
            Set<OperationCallExp> set = allInstancesCalls.get(classifier);
            if (set == null) {
                set = new HashSet<OperationCallExp>();
                allInstancesCalls.put(classifier, set);
            }
            set.add((OperationCallExp) opCallExp);
        } else {
            if (opCallExp.getOperationCode() > 0){
                // standard library operation: nothing to do
            } else {
                // handle self defined operation
                OCLExpression body = getOperationBody(opCallExp.getReferredOperation());
                if (body != null) {
                    Set<OperationCallExp> analyzedCallsToBody = visitedOperationBodies.get(body);
                    if (analyzedCallsToBody == null) {
                        analyzedCallsToBody = new HashSet<OperationCallExp>();
                        // we didn't analyze the body on behalf of the this analyzer's root expression yet; do it now.
                        // Important: add opCallExp before visiting the body; during analyzing the body we may need to know
                        // the call/body relationship, e.g., for self and param analysis as well as error reporting
                        analyzedCallsToBody.add((OperationCallExp) opCallExp);
                        visitedOperationBodies.put(body, analyzedCallsToBody);
                        visitedOperationBodyStack.push(body);
                        walk(body);
                        visitedOperationBodyStack.pop();
                    } else {
                        analyzedCallsToBody.add((OperationCallExp) opCallExp);
                    }
                }
            }
        }
        return result;
    }

    @Override
    public EPackage visitVariableExp(VariableExp<EClassifier, EParameter> var) {
        EOperation operation = null;
        if (!visitedOperationBodyStack.isEmpty()) {
            OCLExpression body = visitedOperationBodyStack.peek();
            operation = visitedOperationBodies.get(body).iterator().next().getReferredOperation();
            // TODO also record non-operation self variables because they are always in scope for outermost expression
            if (var.getName().equals(Environment.SELF_VARIABLE_NAME)) {
                addSelfUsageForBody(var, body);
            } else {
                for (EParameter param : operation.getEParameters()) {
                    if (var.getName().equals(param.getName())) {
                        Set<Variable> paramSet = parameterVariablesUsedInBody.get(body);
                        if (paramSet == null) {
                            paramSet = new HashSet<Variable>();
                            parameterVariablesUsedInBody.put(body, paramSet);
                        }
                        paramSet.add((Variable) var.getReferredVariable());
                        break;
                    }
                }
            }
        } else {
            if (var.getName().equals(Environment.SELF_VARIABLE_NAME)) {
                // self used outside of operation body; associate with root expression as "body"
                addSelfUsageForBody(var, OclHelper.getRootExpression(var));
            }
            if (notifyNewContextElements && var.getName().equals(Environment.SELF_VARIABLE_NAME)) {
                EClass cls = (EClass) var.getType();
                filters.add(createFilterForElementInsertionOrDeletion(cls));
            }
        }
        return result;
    }

    private void addSelfUsageForBody(VariableExp<EClassifier, EParameter> var, OCLExpression body) {
        Set<Variable> selfSet = selfVariablesUsedInBody.get(body);
        if (selfSet == null) {
            selfSet = new HashSet<Variable>();
            selfVariablesUsedInBody.put(body, selfSet);
        }
        selfSet.add((Variable) var.getReferredVariable());
    }

    /**
     * Returns all the calls to the operation whose body is <tt>operationBodyExpression</tt> that are reachable from the root
     * expression analyzed by this {@link FilterSynthesis}. If no such calls exist, an empty set is returned.
     */
    public Set<OperationCallExp> getCallsOf(OCLExpression operationBodyExpression) {
        Set<OperationCallExp> result = visitedOperationBodies.get(operationBodyExpression);
        if (result == null) {
            result = Collections.emptySet();
        }
        return result;
    }

    /**
     * Obtains the event filter for the expression passed to the constructor. When an event matches the filter, the
     * value of the expression may have changed for one or more evaluation contexts. To determine a superset of those
     * context elements for which the value may have changed, feed the event into
     * {@link ImpactAnalyzer#getContextObjects(Notification)}.
     * @return the filter matching all relevant events 
     */
    public EventFilter getSynthesisedFilter() {
        return EventManagerFactory.eINSTANCE.createOrFilterFor(filters.toArray(new EventFilter[filters.size()]));
    }

    /**
     * Looks up if the {@link OCLExpression} that is called by the given {@link OperationCallExp} has already been visited. 
     * @param call The {@link OperationCallExp} to look for
     * @return the {@link OCLExpression} that defines the body of the called operation
     */
    public OCLExpression getBodyForCall(OperationCallExp call){
        for (Entry<OCLExpression, Set<OperationCallExp>> entry : visitedOperationBodies.entrySet()){
            if (entry.getValue().contains(call)){
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     * Always returns a non-<tt>null</tt> set
     */
    public Set<PropertyCallExp> getAttributeCallExpressions(EAttribute a) {
        Set<PropertyCallExp> result;
        Set<PropertyCallExp> lookup = attributeCallExpressions.get(a);
        if (lookup == null) {
            result = Collections.emptySet();
        } else {
            result = Collections.unmodifiableSet(attributeCallExpressions.get(a));
        }
        return result;
    }

    /**
     * Always returns a non-<tt>null</tt> set
     */
    public Set<NavigationCallExp> getAssociationEndCallExpressions(EReference a) {
        Set<NavigationCallExp> result;
        Set<NavigationCallExp> lookup = associationEndCallExpressions.get(a);
        if (lookup == null) {
            result = Collections.emptySet();
        } else {
            result = Collections.unmodifiableSet(associationEndCallExpressions.get(a));
        }
        return result;
    }

    /**
     * Always returns a non-<tt>null</tt> set. Finds all occurrences of an <tt>allInstances</tt> call on a type expression for the
     * classifier <tt>c</tt> (but not for its generalizations) in the expression analyzed by this visitor.
     */
    public Set<OperationCallExp> getAllInstancesCallsFor(EClassifier c) {
        Set<OperationCallExp> result = allInstancesCalls.get(c);
        if (result == null) {
            result = Collections.emptySet();
        }
        return result;
    }

    /**
     * @param clazz
     * @return a filter containing a element creation or deletion filter for all sub types of the given class
     */
    private EventFilter createFilterForElementInsertionOrDeletion(EClass clazz) {
        return EventManagerFactory.eINSTANCE.createFilterForElementInsertionOrDeletion(clazz);
    }
    
    private void walk(OCLExpression expression) {
        if (!visitedExpressions.contains(expression)) {
            visitedExpressions.add(expression);
            safeVisit(expression);   
        }
    }

    public Set<Variable> getSelfVariablesUsedInBody(OCLExpression body) {
        Set<Variable> result = selfVariablesUsedInBody.get(body);
        if (result == null) {
            result = Collections.emptySet();
        }
        return result;
    }

    public Set<Variable> getParameterVariablesUsedInBody(OCLExpression body) {
        Set<Variable> result = parameterVariablesUsedInBody.get(body);
        if (result == null) {
            result = Collections.emptySet();
        }
        return result;
    }

    public OCLExpression getOperationBody(EOperation operation) {
        OCLExpression body = InvocationBehavior.INSTANCE.getOperationBody(ocl, operation);
        return body;
    }

} //FilterSynthesisImpl
