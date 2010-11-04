package de.hpi.sam.bp2009.solution.impactAnalyzer.hiddenopposites.unusedEvaluation;

import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.VariableExp;

import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequest;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestFactory;

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
public class UnusedEvaluationRequestWithHiddenOppositesFactory extends UnusedEvaluationRequestFactory {
    public UnusedEvaluationRequestWithHiddenOppositesFactory() {
        super();
    }
    
    protected UnusedEvaluationRequest createUnusedEvaluationRequest(OCLExpression expression, Object resultIndicatingUnused,
            Map<Variable, Object> inferredVariableValues, Set<Variable> slots) {
        return new UnusedEvaluationRequestWithHiddenOpposites(expression, resultIndicatingUnused, inferredVariableValues, slots);
    }

    protected UnusedEvaluationRequest createUnusedEvaluationRequest(OCLExpression expression, Object resultIndicatingUnused,
            Map<Variable, Object> inferredVariableValues, Set<Variable> slots, Set<VariableExp> inevitableVariableUsages) {
        return new UnusedEvaluationRequestWithHiddenOpposites(expression, resultIndicatingUnused, inferredVariableValues, slots, inevitableVariableUsages);
    }


}
