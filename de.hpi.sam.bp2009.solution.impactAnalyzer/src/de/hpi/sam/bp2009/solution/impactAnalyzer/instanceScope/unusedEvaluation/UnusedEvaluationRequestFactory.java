package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation;

import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;

/**
 * Produces objects of type {@link UnusedEvaluationRequest} and caches them in a {@link WeakHashMap}. This factory
 * guarantees to deliver new objects only if its cache doesn't contain an equal {@link UnusedEvaluationRequest}, meaning
 * one that has an equal set of inferred variables with equal values, an equal set of variable slots, the same
 * OCL expression as well as looking for the same result that would indicate unused-ness. This equality definition
 * is implemented by the {@link UnusedEvaluationRequest#getSemanticIdentity()} object.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public class UnusedEvaluationRequestFactory {
    /**
     * Cache keys are the results of {@link UnusedEvaluationRequest#getSemanticIdentity()} and therefore will be removed from
     * this map when the enclosing {@link UnusedEvaluationRequest} has been garbage collected.
     */
    private final WeakHashMap<UnusedEvaluationRequestValue, WeakReference<UnusedEvaluationRequest>> cache;
    
    private class SemanticIdentityWithFields extends AbstractUnusedEvaluationRequestValue {
        private final Map<Variable, Object> inferredVariableValues;
        private final Set<Variable> slots;
        private final OCLExpression expression;
        private final Object resultIndicatingUnused;
        SemanticIdentityWithFields(Map<Variable, Object> inferredVariableValues, Set<Variable> slots, OCLExpression expression,
                Object resultIndicatingUnused) {
            super();
            if (inferredVariableValues == null) {
                this.inferredVariableValues = Collections.emptyMap();
            } else {
                this.inferredVariableValues = inferredVariableValues;
            }
            this.slots = slots;
            this.expression = expression;
            this.resultIndicatingUnused = resultIndicatingUnused;
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
    
    public UnusedEvaluationRequestFactory() {
        cache = new WeakHashMap<UnusedEvaluationRequestValue, WeakReference<UnusedEvaluationRequest>>();
    }
    
    public UnusedEvaluationRequest getUnusedEvaluationRequest(OCLExpression expression, Object resultIndicatingUnused,
            Map<Variable, Object> inferredVariableValues, Set<Variable> slots) {
        UnusedEvaluationRequestValue key = new SemanticIdentityWithFields(inferredVariableValues, slots, expression, resultIndicatingUnused);
        WeakReference<UnusedEvaluationRequest> weakRef = cache.get(key);
        UnusedEvaluationRequest result = null;
        if (weakRef != null) {
            result = weakRef.get();
        }
        if (result == null) {
            result = new UnusedEvaluationRequest(expression, resultIndicatingUnused, inferredVariableValues, slots);
            cache.put(result.getSemanticIdentity(), new WeakReference<UnusedEvaluationRequest>(result));
        }
        return result;
    }

}
