package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation;

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
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;

import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.PartialEvaluator;
import de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.ValueNotFoundException;

/**
 * A largely immutable request to perform a (partial) evaluation (see also {@link PartialEvaluator}) of an {@link OCLExpression},
 * comparing the result with a given expected result. If the result compares equal, this indicates that the subexpression where
 * the change occurred is not used, leading the traceback process to returning an empty set. The only modification allowed to
 * a request is setting an inferred variable's value (see {@link #setInferredVariableValue(Variable, Object)}.
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

    public UnusedEvaluationRequest(OCLExpression expression, Object resultIndicatingUnused, Map<Variable, Object> inferredVariableValues, Set<Variable> slots) {
        this.expression = expression;
        this.resultIndicatingUnused = resultIndicatingUnused;
        this.inferredVariableValues = inferredVariableValues;
        this.slots = slots;
    }
    
    /**
     * If this request holds {@link #slots slots} for any of the variables in <code>slotsToRemove</code>, a new request is created
     * in which all those slots are removed. For the remaining slots, the {@link #inferredVariableValues inferred variable values}
     * are copied from this request. If none of this request's slots are to be removed, this request is returned unchanged.
     */
    public UnusedEvaluationRequest getRequestWithSlotsRemoved(Set<Variable> slotsToRemove) {
        UnusedEvaluationRequest result;
        Set<Variable> remainingSlots = new HashSet<Variable>(slots);
        // iterate this way because we assume slotsToRemove.size() >> slots.size()
        for (Iterator<Variable> i=remainingSlots.iterator(); i.hasNext(); ) {
            Variable v = i.next();
            if (slotsToRemove.contains(v)) {
                i.remove();
            }
        }
        if (remainingSlots.size() < slots.size()) { // it changed
            Map<Variable, Object> remainingInferredVariableValues = new HashMap<Variable, Object>();
            for (Map.Entry<Variable, Object> e : inferredVariableValues.entrySet()) {
                if (remainingSlots.contains(e.getKey())) {
                    remainingInferredVariableValues.put(e.getKey(), e.getValue());
                }
            }
            result = new UnusedEvaluationRequest(expression, resultIndicatingUnused, remainingInferredVariableValues,
                    remainingSlots);
        } else {
            result = this;
        }
        return result;
    }
    
    public boolean hasOneOrMoreSlots() {
        return slots != null && slots.size() > 0;
    }
    
    public boolean hasSlotFor(Variable v) {
        return slots != null && slots.contains(v);
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((expression == null) ? 0 : expression.hashCode());
        result = prime * result + ((inferredVariableValues == null) ? 0 : inferredVariableValues.hashCode());
        result = prime * result + ((resultIndicatingUnused == null) ? 0 : resultIndicatingUnused.hashCode());
        result = prime * result + ((slots == null) ? 0 : slots.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof UnusedEvaluationRequest)) {
            return false;
        }
        UnusedEvaluationRequest other = (UnusedEvaluationRequest) obj;
        if (expression == null) {
            if (other.expression != null) {
                return false;
            }
        } else if (!expression.equals(other.expression)) {
            return false;
        }
        if (inferredVariableValues == null) {
            if (other.inferredVariableValues != null) {
                return false;
            }
        } else if (!inferredVariableValues.equals(other.inferredVariableValues)) {
            return false;
        }
        if (resultIndicatingUnused == null) {
            if (other.resultIndicatingUnused != null) {
                return false;
            }
        } else if (!resultIndicatingUnused.equals(other.resultIndicatingUnused)) {
            return false;
        }
        if (slots == null) {
            if (other.slots != null) {
                return false;
            }
        } else if (!slots.equals(other.slots)) {
            return false;
        }
        return true;
    }

    /**
     * Sets the value for a variable just inferred. If this request doesn't have a slot for the variable whose
     * value was inferred, the request is not updated by this call.
     */
    UnusedEvaluationRequest setInferredVariableValue(Variable variable, Object value) {
        UnusedEvaluationRequest result;
        if (slots.contains(variable)) {
            if (inferredVariableValues.containsKey(variable)) {
                throw new RuntimeException("Internal error: inferred two different values for variable "+variable+
                        " in what should have been the same dynamic scope: "+
                        inferredVariableValues.get(variable)+" vs. "+value);
            }
            Map<Variable, Object> newInferredVariableValues = new HashMap<Variable, Object>(inferredVariableValues);
            newInferredVariableValues.put(variable, value);
            result = new UnusedEvaluationRequest(expression, resultIndicatingUnused, newInferredVariableValues, slots);
        } else {
            result = this;
        }
        return result;
    }

    /**
     * Tries a partial evaluation of the {@link #expression} by setting the variable values inferred so far
     * (see {@link #inferredVariableValues}) in the evaluation environment. If this succeeds, the result is compared
     * to {@link #resultIndicatingUnused}. If successful, <code>true</code> is returned. If evaluation fails for an
     * unknown variable, the {@link ValueNotFoundException} is simply passed through.
     */
    public boolean evaluate(OppositeEndFinder oppositeEndFinder) throws ValueNotFoundException {
        PartialEvaluator evaluator = new PartialEvaluator(oppositeEndFinder);
        EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> env = evaluator.getOcl().getEvaluationEnvironment();
        for (Map.Entry<Variable, Object> e : inferredVariableValues.entrySet()) {
            env.add(e.getKey().getName(), e.getValue());
        }
        Object result = evaluator.evaluate(/* context */ null, expression);
        return ((result == null && resultIndicatingUnused == null) ||
                (result != null && result.equals(resultIndicatingUnused)));
    }
}
