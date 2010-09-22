package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.ocl.ecore.Variable;

import de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.ValueNotFoundException;

public class UnusedEvaluationRequestSet {
    /**
     * Keys requests to evaluate an OCL expression to check whether a changed subexpression is not used.
     * Key is the variable whose value was unknown the last time the expression was to be evaluated.
     * See also {@link ValueNotFoundException}.
     */
    private final Map<Variable, Set<UnusedEvaluationRequest>> requests;

    public UnusedEvaluationRequestSet() {
        this.requests = new HashMap<Variable, Set<UnusedEvaluationRequest>>();
    }
    
    private UnusedEvaluationRequestSet(Map<Variable, Set<UnusedEvaluationRequest>> requests) {
        this.requests = requests;
    }
    
    /**
     * Computes a new set of {@link UnusedEvaluationRequest}s by copying all those {@link #requests requests}
     * not keyed by a variable that entered or left scope. Those requests whose unknown variable left or entered
     * scope can't be inferred anymore along this traceback chain. Therefore, we can remove their corresponding
     * requests.<p>
     * 
     * For all remaining requests, we remove their 
     * @param variablesThatLeaveOrEnterScope
     * @return
     */
    public UnusedEvaluationRequestSet createReducedSet(Set<Variable> variablesThatLeaveOrEnterScope) {
        UnusedEvaluationRequestSet result;
        boolean changed = false;
        Map<Variable, Set<UnusedEvaluationRequest>> remainingRequests = new HashMap<Variable, Set<UnusedEvaluationRequest>>();
        for (Map.Entry<Variable, Set<UnusedEvaluationRequest>> e : requests.entrySet()) {
            if (!variablesThatLeaveOrEnterScope.contains(e.getKey())) {
                remainingRequests.put(e.getKey(), e.getValue());
            } else {
                changed = true;
            }
        }
        Map<Variable, Set<UnusedEvaluationRequest>> remainingRequestsUpdated = new HashMap<Variable, Set<UnusedEvaluationRequest>>();
        for (Map.Entry<Variable, Set<UnusedEvaluationRequest>> e : remainingRequests.entrySet()) {
            boolean setChanged = false;
            Set<UnusedEvaluationRequest> newSet = new HashSet<UnusedEvaluationRequest>();
            for (UnusedEvaluationRequest request : e.getValue()) {
                UnusedEvaluationRequest newRequest = request.getRequestWithSlotsRemoved(variablesThatLeaveOrEnterScope);
                newSet.add(newRequest);
                if (newRequest != request) {
                    changed = true;
                    setChanged = true;
                }
            }
            if (setChanged) {
                remainingRequestsUpdated.put(e.getKey(), newSet);
            } else {
                remainingRequestsUpdated.put(e.getKey(), e.getValue());
            }
        }
        if (changed) {
            result = new UnusedEvaluationRequestSet(remainingRequestsUpdated);
        } else {
            result = this;
        }
        return result;
    }
}
