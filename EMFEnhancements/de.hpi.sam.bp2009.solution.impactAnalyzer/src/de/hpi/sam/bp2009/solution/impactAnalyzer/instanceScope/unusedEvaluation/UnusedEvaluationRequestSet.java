package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.Variable;

import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.ValueNotFoundException;
import de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.VariableValueNotFoundInfo;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.TracebackCache;

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
        public String toString() {
            return "[unused: "+provedUnused+", newRequestSet: "+newRequestSet+"]";
        }
    }

    /**
     * Keys requests to evaluate an OCL expression to check whether a changed subexpression is not used.
     * Key is the variable whose value was unknown the last time the expression was to be evaluated.
     * See also {@link ValueNotFoundException}.
     */
    private final Map<Variable, Set<UnusedEvaluationRequest>> requests;

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
    public UnusedEvaluationRequestSet createReducedSet(Set<Variable> variablesThatLeaveOrEnterScope, UnusedEvaluationRequestFactory unusedEvaluationRequestFactory) {
        UnusedEvaluationRequestSet result = this;
        if (!requests.isEmpty() && !variablesThatLeaveOrEnterScope.isEmpty()) {
            boolean changed = false;
            Map<Variable, Set<UnusedEvaluationRequest>> remainingRequestsUpdated = new HashMap<Variable, Set<UnusedEvaluationRequest>>();
            for (Map.Entry<Variable, Set<UnusedEvaluationRequest>> e : requests.entrySet()) {
                if (!variablesThatLeaveOrEnterScope.contains(e.getKey())) {
                    // the request did not become obsolete due to its unknown variable
                    boolean setChanged = false;
                    UnusedEvaluationRequest[] newSet = new UnusedEvaluationRequest[e.getValue().size()];
                    int newSetIndex = 0;
                    for (UnusedEvaluationRequest request : e.getValue()) {
                        UnusedEvaluationRequest newRequest = request.getRequestWithSlotsRemoved(variablesThatLeaveOrEnterScope,
                                unusedEvaluationRequestFactory);
                        if (newRequest != request) {
                            changed = true;
                            setChanged = true;
                        }
                        if (!newRequest.hasOneOrMoreSlots()) {
                            throw new RuntimeException(
                                    "Internal error: an UnusedEvaluationRequest whose unknown variable is still in scope "
                                            + "claims to have lost all its slots; the slot for the unknown variable should, however, still be there.");
                        }
                        newSet[newSetIndex++] = newRequest;
                    }
                    if (setChanged) {
                        Set<UnusedEvaluationRequest> newSetAsSet = new HashSet<UnusedEvaluationRequest>();
                        for (int i=0; i<newSetIndex; i++) {
                            newSetAsSet.add(newSet[i]);
                        }
                        remainingRequestsUpdated.put(e.getKey(), newSetAsSet);
                    } else {
                        remainingRequestsUpdated.put(e.getKey(), e.getValue());
                    }
                } else {
                    changed = true; // the request got dropped
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
     * @param oclFactory TODO
     * 
     * @return a result that tells whether unusedness could be proven and which tells the potentially transformed
     * next {@link UnusedEvaluationRequestSet} which may be this unchanged object in case no request had a slot for
     * the variable inferred, or a new set which contains the re-organized and possibly cloned requests.
     */
    public UnusedEvaluationResult setVariable(Variable variable, EObject value, OppositeEndFinder oppositeEndFinder,
            de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.TracebackCache tracebackCache, OCLFactory oclFactory) {
        UnusedEvaluationResult result;
        boolean changed = false;
        Map<Variable, Set<UnusedEvaluationRequest>> newRequestSet = new HashMap<Variable, Set<UnusedEvaluationRequest>>();
        // enter variable value into those requests that have a slot for it
        for (Map.Entry<Variable, Set<UnusedEvaluationRequest>> e : requests.entrySet()) {
            UnusedEvaluationRequest[] newSet = new UnusedEvaluationRequest[e.getValue().size()];
            int newSetIndex = 0;
            boolean setChanged = false;
            for (UnusedEvaluationRequest request : e.getValue()) {
                UnusedEvaluationRequest clonedRequest = request.setInferredVariableValue(variable, value,
                        tracebackCache.getUnusedEvaluationRequestFactory());
                newSet[newSetIndex++] = clonedRequest;
                if (clonedRequest != request) {
                    changed = true;
                    setChanged = true;
                }
            }
            if (!setChanged) {
                newRequestSet.put(e.getKey(), e.getValue());
            } else {
                Set<UnusedEvaluationRequest> set = new HashSet<UnusedEvaluationRequest>();
                for (int i=0; i<newSetIndex; i++) {
                    set.add(newSet[i]);
                }
                newRequestSet.put(e.getKey(), set);
            }
        }
        // now re-evaluate those that previously failed because variable was unknown
        Collection<UnusedEvaluationRequest> triggered = newRequestSet.get(variable);
        if (triggered != null) {
            newRequestSet.remove(variable);
            changed = true;
            UnusedEvaluationRequestSet nextSet = new UnusedEvaluationRequestSet(newRequestSet);
            UnusedEvaluationResult preResult = evaluate(triggered, oppositeEndFinder, tracebackCache, oclFactory);
            result = new UnusedEvaluationResult(preResult.hasProvenUnused(), nextSet.merge(preResult.getNewRequestSet()));
        } else {
            result = new UnusedEvaluationResult(/* provedUnused */ false, changed ? new UnusedEvaluationRequestSet(newRequestSet) : this);
        }
        return result;
    }

    /**
     * Evaluates the <code>requestsToEvaluate</code>. If any of them returns <code>true</code> from its
     * {@link UnusedEvaluationRequest#evaluate(OppositeEndFinder, OCL)} method, a result will be returned that returns
     * <code>true</code> from its {@link UnusedEvaluationResult#hasProvenUnused()} method. Otherwise, that result's method will
     * return <code>false</code>. If any request's evaluation failed for an unknown variable, the request will be added to a new
     * {@link UnusedEvaluationRequestSet} which is part of this method's result (see
     * {@link UnusedEvaluationResult#getNewRequestSet()}), keyed by the unknown {@link Variable}.
     * 
     * @param requestsToEvaluate
     *            may be <code>null</code> which will immediately cause the result to be a combination of <code>false</code> and a
     *            new, empty {@link UnusedEvaluationRequestSet}.
     */
    public static UnusedEvaluationResult evaluate(Collection<UnusedEvaluationRequest> requestsToEvaluate,
            OppositeEndFinder oppositeEndFinder, TracebackCache tracebackCache, OCLFactory oclFactory) {
        UnusedEvaluationResult result = null;
        Map<Variable, Set<UnusedEvaluationRequest>> newRequestSet = null;
        if (requestsToEvaluate != null) {
            newRequestSet = new HashMap<Variable, Set<UnusedEvaluationRequest>>(2);
            for (UnusedEvaluationRequest request : requestsToEvaluate) {
                Object evaluationResult = tracebackCache.getCachedEvaluationResult(request);
                if (evaluationResult == null) {
                    evaluationResult = request.checkValuePresentForAllRequiredVariables();
                    if (evaluationResult == null) { // all inevitably required variables defined
                        try {
                            evaluationResult = request.evaluate(oppositeEndFinder, oclFactory);
                        } catch (ValueNotFoundException vnfe) {
                            evaluationResult = vnfe;
                        }
                    }
                    tracebackCache.cacheEvaluationResult(request, evaluationResult);
                }
                if (evaluationResult instanceof VariableValueNotFoundInfo) {
                    // re-add the request, but this time for the now unknown variable
                    Variable unknownVariable = (Variable) ((VariableValueNotFoundInfo) evaluationResult).getVariableExp()
                            .getReferredVariable();
                    Set<UnusedEvaluationRequest> newSet = newRequestSet.get(unknownVariable);
                    if (newSet == null) {
                        newSet = new HashSet<UnusedEvaluationRequest>();
                        newRequestSet.put(unknownVariable, newSet);
                    }
                    newSet.add(request);
                } else {
                    // must be boolean, indicating result of successful evaluation
                    if ((Boolean) evaluationResult) {
                        result = new UnusedEvaluationResult(/* provedUnused */true, /* newRequestSet */null);
                        break;
                    } else {
                        //  else, simply don't add the resolved request anymore because it was unable to prove unused
                    }
                }
            }
        }
        if (result == null) {
            result = new UnusedEvaluationResult(/* provedUnused */false, newRequestSet == null || newRequestSet.isEmpty() ? null
                    : new UnusedEvaluationRequestSet(newRequestSet));
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
        if (other == null || other.requests.isEmpty()) {
            if (requests.isEmpty()) {
                return null;
            } else {
                return this;
            }
        } else if (requests.isEmpty()) {
            return other;
        } else {
            Map<Variable, Set<UnusedEvaluationRequest>> newRequests = new HashMap<Variable, Set<UnusedEvaluationRequest>>(
                    requests);
            for (Map.Entry<Variable, Set<UnusedEvaluationRequest>> e : other.requests.entrySet()) {
                if (!e.getValue().isEmpty()) {
                    Set<UnusedEvaluationRequest> set = newRequests.get(e.getKey());
                    if (set == null || set.isEmpty()) {
                        set = e.getValue();
                    } else {
                        Set<UnusedEvaluationRequest> newSet = new HashSet<UnusedEvaluationRequest>(set.size() + 1);
                        newSet.addAll(set);
                        newSet.addAll(e.getValue());
                        set = newSet;
                    }
                    newRequests.put(e.getKey(), set);
                }
            }
            return new UnusedEvaluationRequestSet(newRequests);
        }
    }
    
    public String toString() {
        StringBuilder result = new StringBuilder("requests by unknown variable: [");
        boolean firstVariable = true;
        for (Map.Entry<Variable, Set<UnusedEvaluationRequest>> e : requests.entrySet()) {
            if (!firstVariable) {
                result.append(", ");
            } else {
                firstVariable = false;
            }
            result.append(e.getKey().getName());
            result.append(": [");
            boolean first = true;
            for (UnusedEvaluationRequest request : e.getValue()) {
                if (!first) {
                    result.append(",");
                } else {
                    first = false;
                }
                result.append(request);
            }
            result.append("]");
        }
        result.append("]");
        return result.toString();
    }
}
