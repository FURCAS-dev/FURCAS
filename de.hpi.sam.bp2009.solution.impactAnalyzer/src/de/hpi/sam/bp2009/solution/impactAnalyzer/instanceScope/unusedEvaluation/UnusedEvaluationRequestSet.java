package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.Variable;

import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;

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
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((requests == null) ? 0 : requests.hashCode());
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
        if (!(obj instanceof UnusedEvaluationRequestSet)) {
            return false;
        }
        UnusedEvaluationRequestSet other = (UnusedEvaluationRequestSet) obj;
        if (requests == null) {
            if (other.requests != null) {
                return false;
            }
        } else if (!requests.equals(other.requests)) {
            return false;
        }
        return true;
    }

    /**
     * Computes a new set of {@link UnusedEvaluationRequest}s by copying all those {@link #requests requests} not keyed by a
     * variable that entered or left scope. Those requests whose unknown variable left or entered scope can't be inferred anymore
     * along this traceback chain. Therefore, we can remove their corresponding requests.
     * <p>
     * 
     * For all remaining requests, we remove the slots for any variable contained in <code>variablesThatLeavOrEnterScope</code>.
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
                    if (newRequest != request) {
                        changed = true;
                        setChanged = true;
                    }
                    if (!newRequest.hasOneOrMoreSlots()) {
                        throw new RuntimeException("Internal error: an UnusedEvaluationRequest whose unknown variable is still in scope "+
                        "claims to have lost all its slots; the slot for the unknown variable should, however, still be there.");
                    }
                    newSet.add(newRequest);
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
     * Announces that the value for a variable was inferred. All contained {@link UnusedEvaluationRequest}s that have a slot for
     * this variable are cloned and the value inferred is stored in the cloned request. If the variable is the unknown variable
     * for any of the requests managed by this set, the request is re-evaluated. If the request evaluates to <code>false</code>,
     * it is silently removed from the new request set returned. If the request evaluates to <code>true</code>, further evaluation
     * is aborted immediately, and the method just returns the fact that one of the requests evaluated to <code>true</code>. If
     * the request evaluation fails due to an unknown variable, the request is returned in the
     * {@link UnusedEvaluationResult#getNewRequestSet() new request set} keyed by the now unknown variable.
     * 
     * @return a result that tells whether unusedness could be proven and which tells the potentially transformed
     * next {@link UnusedEvaluationRequestSet} which may be this unchanged object in case no request had a slot for
     * the variable inferred, or a new set which contains the re-organized and possibly cloned requests.
     */
    public UnusedEvaluationResult setVariable(Variable variable, EObject value, OppositeEndFinder oppositeEndFinder) {
        UnusedEvaluationResult result;
        boolean changed = false;
        Map<Variable, Set<UnusedEvaluationRequest>> newRequestSet = new HashMap<Variable, Set<UnusedEvaluationRequest>>();
        // enter variable value into those requests that have a slot for it
        for (Map.Entry<Variable, Set<UnusedEvaluationRequest>> e : requests.entrySet()) {
            Set<UnusedEvaluationRequest> set = new HashSet<UnusedEvaluationRequest>();
            newRequestSet.put(e.getKey(), set);
            for (UnusedEvaluationRequest request : e.getValue()) {
                UnusedEvaluationRequest clonedRequest = request.setInferredVariableValue(variable, value);
                set.add(clonedRequest);
                if (clonedRequest != request) {
                    changed = true;
                }
            }
        }
        // now re-evaluate those that previously failed because variable was unknown
        Set<UnusedEvaluationRequest> triggered = newRequestSet.get(variable);
        if (triggered != null) {
            newRequestSet.remove(variable);
            changed = true;
            UnusedEvaluationRequestSet nextSet = new UnusedEvaluationRequestSet(newRequestSet);
            UnusedEvaluationResult preResult = evaluate(triggered, oppositeEndFinder);
            result = new UnusedEvaluationResult(preResult.hasProvenUnused(), nextSet.merge(preResult.getNewRequestSet()));
        } else {
            result = new UnusedEvaluationResult(/* provedUnused */ false, changed ? new UnusedEvaluationRequestSet(newRequestSet) : this);
        }
        return result;
    }

    /**
     * Evaluates the <code>requestsToEvaluate</code>. If any of them returns <code>true</code> from its
     * {@link UnusedEvaluationRequest#evaluate(OppositeEndFinder)} method, a result will be returned that returns
     * <code>true</code> from its {@link UnusedEvaluationResult#hasProvenUnused()} method. Otherwise, that result's method will
     * return <code>false</code>. If any request's evaluation failed for an unknown variable, the request will be added to a new
     * {@link UnusedEvaluationRequestSet} which is part of this method's result (see
     * {@link UnusedEvaluationResult#getNewRequestSet()}), keyed by the unknown {@link Variable}.
     * 
     * @param requestsToEvaluate
     *            may be <code>null</code> which will immediately cause the result to be a combination of <code>false</code> and a
     *            new, empty {@link UnusedEvaluationRequestSet}.
     */
    public static UnusedEvaluationResult evaluate(Set<UnusedEvaluationRequest> requestsToEvaluate,
            OppositeEndFinder oppositeEndFinder) {
        UnusedEvaluationResult result = null;
        Map<Variable, Set<UnusedEvaluationRequest>> newRequestSet = new HashMap<Variable, Set<UnusedEvaluationRequest>>();
        if (requestsToEvaluate != null) {
            for (UnusedEvaluationRequest request : requestsToEvaluate) {
                try {
                    if (request.evaluate(oppositeEndFinder)) {
                        result = new UnusedEvaluationResult(/* provedUnused */true, /* newRequestSet */null);
                        break;
                    }
                    // else, simply don't add the resolved request anymore because it was unable to prove unused
                } catch (ValueNotFoundException vnfe) {
                    // re-add the request, but this time for the now unknown variable
                    Variable unknownVariable = (Variable) vnfe.getVariableExp().getReferredVariable();
                    Set<UnusedEvaluationRequest> newSet = newRequestSet.get(unknownVariable);
                    if (newSet == null) {
                        newSet = new HashSet<UnusedEvaluationRequest>();
                        newRequestSet.put(unknownVariable, newSet);
                    }
                    newSet.add(request);
                }
            }
        }
        if (result == null) {
            result = new UnusedEvaluationResult(/* provedUnused */ false, new UnusedEvaluationRequestSet(newRequestSet));
        }
        return result;
    }
    
    /**
     * Produces a new instance of this class whose {@link #requests} map holds the combined sets of {@link UnusedEvaluationRequest}s
     * from this and the <code>other</code> set.
     * 
     * @param other may be <code>null</code>, which makes the method return <code>this</code> unchanged
     */
    public UnusedEvaluationRequestSet merge(UnusedEvaluationRequestSet other) {
        if (other == null) {
            return this;
        } else {
            Map<Variable, Set<UnusedEvaluationRequest>> newRequests = new HashMap<Variable, Set<UnusedEvaluationRequest>>(
                    requests);
            for (Map.Entry<Variable, Set<UnusedEvaluationRequest>> e : other.requests.entrySet()) {
                Set<UnusedEvaluationRequest> set = newRequests.get(e.getKey());
                if (set == null) {
                    set = e.getValue();
                } else {
                    set = new HashSet<UnusedEvaluationRequest>(set);
                    set.addAll(e.getValue());
                }
                newRequests.put(e.getKey(), set);
            }
            return new UnusedEvaluationRequestSet(newRequests);
        }
    }
}
