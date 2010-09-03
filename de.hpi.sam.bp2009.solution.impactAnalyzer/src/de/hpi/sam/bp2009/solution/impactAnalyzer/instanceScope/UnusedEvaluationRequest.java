package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;

import de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.ValueNotFoundException;

/**
 * Represents a request to (re-)evaluate the <code>unused</code> function which for an {@link OCLExpression} tries to
 * prove that it isn't used under a given set of variable values. The variable values held by this request are set
 * in the {@link EvaluationEnvironment} before any partial evaluation is started.<p>
 * 
 * An evaluation request exists because in an attempt to evaluate the <code>unused</code> function, a variable value
 * was not known. This {@link Variable} is remembered by this evaluation request. When the variable's value is
 * inferred, the request can be executed, providing the value inferred which will then be added to the
 * {@link EvaluationEnvironment} for any OCL evaluation as well.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public class UnusedEvaluationRequest {
    private final Map<Variable, Object> knownVariableValues;
    private final Variable unknownVariable;
    private final OCLExpression expressionToCheckIfUnused;
    private final OCLExpression rootExpression;
    
    /**
     * The result of an attempt to evaluate an {@link UnusedEvaluationRequest}. If {@link #wasSuccessful() successful},
     * then the {@link #isUnused()} method tells if the {@link UnusedEvaluationRequest#expressionToCheckIfUnused} is unused.
     * If not successful, a variable was missing for performing some evaluation, and a {@link #getNextEvaluationRequest() next
     * evaluation request} can be obtained which uses the same {@link UnusedEvaluationRequest#expressionToCheckIfUnused} and
     * {@link UnusedEvaluationRequest#rootExpression}, but has a different {@link UnusedEvaluationRequest#unknownVariable},
     * and whose {@link UnusedEvaluationRequest#knownVariableValues} map is extended by the variable whose inference triggered
     * the evaluation.
     * 
     * @author Axel Uhl (D043530)
     *
     */
    public static class EvaluationResult {
        private final boolean unused;
        private final UnusedEvaluationRequest nextRequest;
        
        public EvaluationResult(boolean unused, UnusedEvaluationRequest nextRequest) {
            this.unused = unused;
            this.nextRequest = nextRequest;
        }

        public boolean wasSuccessful() {
            return nextRequest == null;
        }
        
        public boolean isUnused() {
            return unused;
        }
        
        public UnusedEvaluationRequest getNextEvaluationRequest() {
            return nextRequest;
        }
    }
    
    public UnusedEvaluationRequest(Map<Variable, Object> knownVariableValues, Variable unknownVariable,
            OCLExpression expressionToCheckIfUnused, OCLExpression rootExpression) {
        this.knownVariableValues = knownVariableValues;
        this.unknownVariable = unknownVariable;
        this.expressionToCheckIfUnused = expressionToCheckIfUnused;
        this.rootExpression = rootExpression;
    }
    
    /**
     * Returns an unmodifiable version of the mapping of variables and their known values to be used for evaluating
     * the <code>unused</code> function.
     */
    public Map<Variable, Object> getKnownVariableValues() {
        return Collections.unmodifiableMap(knownVariableValues);
    }

    public Variable getUnknownVariable() {
        return unknownVariable;
    }
    
    public EvaluationResult evaluate(Object valueForFormerlyUnknownVariable) {
        EvaluationResult result;
        Map<Variable, Object> newKnownVariables = new HashMap<Variable, Object>(knownVariableValues);
        newKnownVariables.put(unknownVariable, valueForFormerlyUnknownVariable);
        try {
            boolean unused = computeUnknown(expressionToCheckIfUnused, expressionToCheckIfUnused, newKnownVariables);
            result = new EvaluationResult(unused, /* no next request; evaluation was successful */ null);
        } catch (ValueNotFoundException e) {
            UnusedEvaluationRequest nextRequest = new UnusedEvaluationRequest(newKnownVariables, (Variable) e.getVariableExp()
                    .getReferredVariable(), expressionToCheckIfUnused, rootExpression);
            result = new EvaluationResult(false, nextRequest);
        }
        return result;
    }

    private boolean computeUnknown(OCLExpression expressionToCheckIfUnused2, OCLExpression expressionToCheckIfUnused3,
            Map<Variable, Object> newKnownVariables) {
        // TODO implement UnusedEvaluationRequest.computeUnknown
        return false;
    }
}
