package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.Variable;

import de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.ValueNotFoundException;

public class UnusedEvaluationRequestSet {
    /**
     * If the result says that {@link #hasProvenUnused() unused was proven}, there won't be a {@link #getNewRequestSet() new request set}
     * delivered. Otherwise, the new request set delivered by {@link #getNewRequestSet()} is the request set updated by setting
     * a variable value in the remaining {@link UnusedEvaluationRequest}s as well as having removed those requests that were
     * evaluated due to the variable inference and that returned <code>false</code>. Those requests whose evaluation was triggered
     * by the variable inference but which failed due to another unknown variable are entered again, this time with the now
     * unknown variable as key.
     * 
     * @author Axel Uhl (D043530)
     *
     */
    public static class UnusedEvaluationResult {
        private final boolean provedUnused;
        private final UnusedEvaluationRequestSet newRequestSet;
        private UnusedEvaluationResult(boolean provedUnused, UnusedEvaluationRequestSet newRequestSet) {
            this.provedUnused = provedUnused;
            this.newRequestSet = newRequestSet;
        }
        public boolean hasProvenUnused() {
            return provedUnused;
        }
        public UnusedEvaluationRequestSet getNewRequestSet() {
            return newRequestSet;
        }
    }
    
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
        UnusedEvaluationRequestSet result = this;
        if (!requests.isEmpty()) {
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
        }
        return result;
    }

    /**
     * Announces that the value for a variable was inferred. For all contained {@link UnusedEvaluationRequest}s that have a slot
     * for this variable, the value is stored in the request. If the variable is the unknown variable for any of the requests
     * managed by this set, the request is re-evaluated. If the request evaluates to <code>false</code>, it is silently removed
     * from the new request set returned. If the request evaluates to <code>true</code>, further evaluation is aborted
     * immediately, and the method just returns the fact that one of the requests evaluated to <code>true</code>. If the request
     * evaluation fails due to an unknown variable, the request is returned in the
     * {@link UnusedEvaluationResult#getNewRequestSet() new request set} keyed by the now unknown variable.
     */
    public UnusedEvaluationResult setVariable(Variable variable, EObject value) {
        // TODO Implement UnusedEvaluationRequestSet.setVariable(...)
        return null;
    }
}
