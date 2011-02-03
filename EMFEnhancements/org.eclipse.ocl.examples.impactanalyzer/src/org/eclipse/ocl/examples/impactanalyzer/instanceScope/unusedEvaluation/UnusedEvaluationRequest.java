/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.impactanalyzer.instanceScope.unusedEvaluation;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.IfExp;
import org.eclipse.ocl.ecore.LoopExp;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.examples.impactanalyzer.OCLFactory;
import org.eclipse.ocl.examples.impactanalyzer.deltaPropagation.PartialEvaluatorImpl;
import org.eclipse.ocl.examples.impactanalyzer.deltaPropagation.ValueNotFoundException;
import org.eclipse.ocl.examples.impactanalyzer.deltaPropagation.VariableValueNotFoundInfo;
import org.eclipse.ocl.examples.impactanalyzer.deltaPropagation.VariableValueNotFoundInfoImpl;



/**
 * A largely immutable request to perform a (partial) evaluation (see also {@link PartialEvaluatorImpl}) of an {@link OCLExpression},
 * comparing the result with a given expected result or <code>invalid</code>. If the result compares equal, this indicates that
 * the subexpression where the change occurred is not used, leading the traceback process to returning an empty set. The only
 * modification allowed to a request is setting an inferred variable's value (see
 * {@link #setInferredVariableValue(Variable, Object, UnusedEvaluationRequestFactory)}. Note that this assumes that <code>invalid</code>
 * means "unused." This is the case for the currently known unused checks, in particular computing the condition of an {@link IfExp},
 * computing the source of a {@link LoopExp} and computing the argument of an <code>-&gt;at(...)</code> {@link OperationCallExp}.
 * <p>
 * 
 * The request holds a number of <em>slots</em> for variable values inferred during the traceback process. If a new variable value
 * is inferred for which this request has a slot, the value is entered into the slot and used for the partial evaluation.
 * <p>
 * 
 * If a variable for which this request has a slot changes scope, a new request is created in which the slot is removed, because
 * we can't expect to infer the value for the right dynamic scope anymore.
 * 
 * @author Axel Uhl (D043530)
 * 
 */
public class UnusedEvaluationRequest {
    private final Map<Variable, Object> inferredVariableValues;
    private final Set<Variable> slots;
    private final OCLExpression expression;
    private final Object resultIndicatingUnused;
    private final SemanticIdentity semanticIdentity;
    private final Set<VariableExp> inevitableVariableUsages;
    
    // fields for statistical purposes
    public static int evaluations = 0;
    public static int evaluationsAbortedDueToUnknownVariable = 0;
    public static int evaluationsSucceedingAndProvingUnused = 0;
    public static int evaluationsSucceedingWithoutProvingUnused = 0;
    
    /**
     * Defines "logical" equals/hashCode as opposed to enclosing class which has default, identity-based equals/hashCode.
     * See also {@link UnusedEvaluationRequestFactory}.
     * 
     * @author Axel Uhl (D043530)
     *
     */
    class SemanticIdentity extends AbstractUnusedEvaluationRequestValue {
        protected final int hashCode;
        
        public SemanticIdentity() {
            hashCode = computeHashCode();
        }
        
        @Override
        public int hashCode() {
            return hashCode;
        }
        
        public Map<Variable, Object> getInferredVariableValues() {
            return inferredVariableValues;
        }

        public Set<Variable> getSlots() {
            return slots;
        }

        public OCLExpression getExpression() {
            return expression;
        }

        public Object getResultIndicatingUnused() {
            return resultIndicatingUnused;
        }
    }
        

    /**
     * Must not be called from anywhere except {@link UnusedEvaluationRequestFactory#getUnusedEvaluationRequest(OCLExpression, Object, Map, Set)}
     * because resulting instances need to be <em>managed</em> as their equality and hash code fall back to their identity. Hence,
     * equal objects in a given scope must be guaranteed to be identical. Such a scope is defined by the use of a
     * {@link UnusedEvaluationRequestFactory}.
     * 
     * @param expression
     *            the expression to evaluate
     * @param resultIndicatingUnused
     *            if <code>expression</code> evaluates to this result, this request will return <code>true</code> from its
     *            {@link #evaluate(OppositeEndFinder, OCL)} method; as a special case, <code>null</code> will be considered "equal"
     *            to an empty collection as the result of evaluating <code>expression</code>
     * @param inferredVariableValues
     *            may be <code>null</code>. In this case, a new {@link Map} is created internally.
     * @param slots
     *            the variables currently within their dynamic scope such that, when a value is inferred for such a variable, it
     *            is correct to assign it for use in evaluating <code>expression</code> in this request
     */
    UnusedEvaluationRequest(OCLExpression expression, Object resultIndicatingUnused,
            Map<Variable, Object> inferredVariableValues, Set<Variable> slots) {
        this(expression, resultIndicatingUnused, inferredVariableValues, slots,
                expression.accept(new FindAlwaysUsedVariablesVisitor()));
    }
    
    /**
     * Must not be called from anywhere except {@link UnusedEvaluationRequestFactory#getUnusedEvaluationRequest(OCLExpression, Object, Map, Set)}
     * because resulting instances need to be <em>managed</em> as their equality and hash code fall back to their identity. Hence,
     * equal objects in a given scope must be guaranteed to be identical. Such a scope is defined by the use of a
     * {@link UnusedEvaluationRequestFactory}.
     * 
     * @param expression
     *            the expression to evaluate
     * @param resultIndicatingUnused
     *            if <code>expression</code> evaluates to this result, this request will return <code>true</code> from its
     *            {@link #evaluate(OppositeEndFinder, OCL)} method; as a special case, <code>null</code> will be considered "equal"
     *            to an empty collection as the result of evaluating <code>expression</code>
     * @param inferredVariableValues
     *            may be <code>null</code>. In this case, a new {@link Map} is created internally.
     * @param slots
     *            the variables currently within their dynamic scope such that, when a value is inferred for such a variable, it
     *            is correct to assign it for use in evaluating <code>expression</code> in this request
     */
    protected UnusedEvaluationRequest(OCLExpression expression, Object resultIndicatingUnused,
            Map<Variable, Object> inferredVariableValues, Set<Variable> slots, Set<VariableExp> inevitableVariableUsages) {
        this.expression = expression;
        this.resultIndicatingUnused = resultIndicatingUnused;
        if (inferredVariableValues == null) {
            this.inferredVariableValues = Collections.emptyMap();
        } else {
            this.inferredVariableValues = inferredVariableValues;
        }
        this.slots = slots;
        this.semanticIdentity = new SemanticIdentity();
        this.inevitableVariableUsages = inevitableVariableUsages;
    }
    
    SemanticIdentity getSemanticIdentity() {
        return semanticIdentity;
    }
    
    /**
     * If this request holds {@link #slots slots} for any of the variables in <code>slotsToRemove</code>, a new request is created
     * in which all those slots are removed. For the remaining slots, the {@link #inferredVariableValues inferred variable values}
     * are copied from this request. If none of this request's slots are to be removed, this request is returned unchanged.
     */
    UnusedEvaluationRequest getRequestWithSlotsRemoved(Set<Variable> slotsToRemove, UnusedEvaluationRequestFactory unusedEvaluationRequestFactory) {
        UnusedEvaluationRequest result;
        if (slotsToRemove == null || slotsToRemove.isEmpty()) {
            result = this;
        } else {
            Set<Variable> remainingSlots = slots;
            // iterate this way because we assume slotsToRemove.size() >> slots.size()
            for (Iterator<Variable> i = slots.iterator(); i.hasNext();) {
                Variable v = i.next();
                if (slotsToRemove.contains(v)) {
                    if (remainingSlots == slots) { // copy on write/remove
                        remainingSlots = new HashSet<Variable>(slots);
                    }
                    remainingSlots.remove(v);
                }
            }
            if (remainingSlots != slots) { // it changed
                Map<Variable, Object> remainingInferredVariableValues = new HashMap<Variable, Object>();
                for (Map.Entry<Variable, Object> e : inferredVariableValues.entrySet()) {
                    if (!slotsToRemove.contains(e.getKey())) {
                        remainingInferredVariableValues.put(e.getKey(), e.getValue());
                    }
                }
                result = unusedEvaluationRequestFactory.getUnusedEvaluationRequest(expression, resultIndicatingUnused,
                        remainingInferredVariableValues, remainingSlots, inevitableVariableUsages);
            } else {
                result = this;
            }
        }
        return result;
    }
    
    public boolean hasOneOrMoreSlots() {
        return slots != null && slots.size() > 0;
    }
    
    public boolean hasSlotFor(Variable v) {
        return slots != null && slots.contains(v);
    }

    /**
     * Sets the value for a variable just inferred. If this request doesn't have a slot for the variable whose
     * value was inferred, the request is not updated by this call.
     */
    UnusedEvaluationRequest setInferredVariableValue(Variable variable, Object value, UnusedEvaluationRequestFactory unusedEvaluationRequestFactory) {
        UnusedEvaluationRequest result;
        if (slots.contains(variable)) {
            if (inferredVariableValues.containsKey(variable) && inferredVariableValues.get(variable) != value) {
                throw new RuntimeException("Internal error: inferred two different values for variable "+variable+
                        " in what should have been the same dynamic scope: "+
                        inferredVariableValues.get(variable)+" vs. "+value);
            }
            Map<Variable, Object> newInferredVariableValues = new HashMap<Variable, Object>(inferredVariableValues);
            newInferredVariableValues.put(variable, value);
            result = unusedEvaluationRequestFactory.getUnusedEvaluationRequest(expression, resultIndicatingUnused,
                    newInferredVariableValues, slots, inevitableVariableUsages);
        } else {
            result = this;
        }
        return result;
    }

    /**
     * Tries a partial evaluation of the {@link #expression} by setting the variable values inferred so far
     * (see {@link #inferredVariableValues}) in the evaluation environment. If this succeeds, the result is compared
     * to {@link #resultIndicatingUnused}. If successful, <code>true</code> is returned. If evaluation fails for an
     * unknown variable, the {@link ValueNotFoundException} is simply passed through.<p>
     * 
     * Callers should call {@link #checkValuePresentForAllRequiredVariables()} before to see if it makes sense
     * at all to attempt an evaluation or if a {@link ValueNotFoundException} would inevitably result. This
     * saves the effort for a failing partial evaluation.
     */
    public boolean evaluate(OppositeEndFinder oppositeEndFinder, OCLFactory oclFactory) throws ValueNotFoundException {
        // use an evaluator that doesn't even try to perform an allInstances() call because it likely would
        // cost more than it saves
        PartialEvaluatorNoAllInstances evaluator = createPartialEvaluatorNoAllInstances(oppositeEndFinder, oclFactory);
        EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> env = evaluator.getOcl()
                .getEvaluationEnvironment();
        Object context = null;
        for (Map.Entry<Variable, Object> e : inferredVariableValues.entrySet()) {
            // if "self" then use as context variable; this will set self in evaluator
            if (e.getKey().getName().equals(EcoreEnvironment.SELF_VARIABLE_NAME)) {
                context = e.getValue();
            } else {
                env.add(e.getKey().getName(), e.getValue());
            }
        }
        Object result;
        try {
            evaluations++;
            result = evaluator.evaluate(context, expression);
        } catch (ValueNotFoundException vfne) {
            evaluationsAbortedDueToUnknownVariable++;
            throw vfne;
        } catch (NoAllInstancesDuringEvaluationForUnusedCheck ex) {
            result = ex;
        }
        boolean unused = !(result instanceof NoAllInstancesDuringEvaluationForUnusedCheck) &&
               ((result == null && resultIndicatingUnused == null) ||
                result == evaluator.getOcl().getEnvironment().getOCLStandardLibrary().getInvalid() ||
                (result != null &&
                        // asking for empty collection is encoded by asking for null
                        (result instanceof Collection<?> && resultIndicatingUnused == null && ((Collection<?>) result).isEmpty()) ||
                        result.equals(resultIndicatingUnused)));
        if (unused) {
            evaluationsSucceedingAndProvingUnused++;
        } else {
            evaluationsSucceedingWithoutProvingUnused++;
        }
        return unused;
    }

    protected PartialEvaluatorNoAllInstances createPartialEvaluatorNoAllInstances(OppositeEndFinder oppositeEndFinder,
            OCLFactory oclFactory) {
        return new PartialEvaluatorNoAllInstances(oclFactory);
    }
    
    /**
     * Returns a {@link VariableValueNotFoundInfo} if any of the variables inevitably required by the {@link #expression} are not
     * (yet) defined and thus saves a fruitless evaluation cycle, <code>null</code> otherwise.
     */
    VariableValueNotFoundInfo checkValuePresentForAllRequiredVariables() {
        for (VariableExp inevitableVariableUse : inevitableVariableUsages) {
            if (!inferredVariableValues.containsKey(inevitableVariableUse.getReferredVariable())) {
                return new VariableValueNotFoundInfoImpl(inevitableVariableUse.getReferredVariable().getName(), inevitableVariableUse);
            }
        }
        return null;
    }
    
    public String toString() {
        StringBuilder result = new StringBuilder("[" + expression + " = "+resultIndicatingUnused + "] with variables [");
        boolean first = true;
        for (Variable slot : slots) {
            if (!first) {
                result.append(",");
            } else {
                first = false;
            }
            result.append(slot.getName());
            result.append("=");
            if (inferredVariableValues.containsKey(slot)) {
                result.append(inferredVariableValues.get(slot));
            } else {
                result.append("?");
            }
        }
        result.append("]");
        return result.toString();
    }
}
