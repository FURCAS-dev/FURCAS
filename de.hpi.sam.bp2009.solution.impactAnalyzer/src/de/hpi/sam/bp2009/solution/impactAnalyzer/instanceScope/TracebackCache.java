package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.LoopExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.VariableExp;

import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.UnusedEvaluationRequest.EvaluationResult;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.Tuple.Pair;

/**
 * During the navigation of a {@link NavigationStep} tree, starting from an {@link EObject}, navigation steps may be reached
 * several times with the same {@link EObject} at hand. To avoid endless recursion and to accelerate the computation, an object of
 * this class is passed through an evaluation of a {@link NavigationStep} tree.
 * <p>
 * 
 * In addition to remembering traceback navigation results, this cache also stores variable values inferred during the traceback.
 * Those can be used for partial evaluations, e.g., when trying to determine if a subexpression may be reached at all based on the
 * current variable values.
 * <p>
 * 
 * Variable values are valid only in a scope, called a "dynamic scope." While syntactically the variable's static scope is limited
 * to a certain {@link OCLExpression}, e.g., the {@link LetExp#getIn() in} expression of a
 * <code>let<code> expression for the variable defined by the <code>let</code> expression, the same expression may be evaluated
 * several times during the evaluation of some other expression. Each evaluation of the static scope expression represents a
 * dynamic scope for the variables whose static scope is being evaluated.
 * <p>
 * 
 * When the <code>unused</code> function is trying a partial evaluation and is missing a variable to complete the evaluation, we
 * check if the missing variable is a <code>let</code> variable. If not, the <code>unused</code> evaluation request is stored in
 * this cache together with the values of all variables known at that time, as well as the unknown variable that caused the
 * evaluation to fail. If the missing variable <em>is</em> a <code>let</code> variable, we also try to evaluate the corresponding
 * {@link Variable#getInitExpression() initialization expression}. If that fails too, we store a nested <code>unused</code>
 * evaluation request which has as its unknown variable the one from the <code>let</code> variable's initialization expression. If
 * that variable's value is inferred, the initialization expression is evaluated again. If successful (either deferred or
 * immediately), this triggers the inner request which will then have its unknown <code>let</code> variable set to the result of
 * evaluating the initialization expression.
 * <p>
 * 
 * When during traceback a variable's value is inferred, the <code>unused</code> evaluations that have this variable as their
 * unknown variable can be given another try, based on the variable values remembered, as well as the freshly-inferred value for
 * the variable whose value was formerly unknown. If the evaluation succeeds and proves that the expression for which
 * <code>unused</code> was evaluated is actually not used, the traceback can be stopped immediately and simply return an empty
 * set. If the evaluation fails again for another variable with unknown value, the procedure is repeated: the freshly-inferred
 * value is added to the known variable values for the <code>unused</code> evaluation request, and the variable whose value now is
 * unknown is remembered with the request such that when <em>it's</em> value is inferred by the traceback procedure, the
 * <code>unused</code> evaluation can be attempted again.
 * <p>
 * 
 * When the traceback function leaves an expression that is the static scope of an unknown variable, the corresponding
 * <code>unused</code> evaluation requests are canceled because we cannot hope for the traceback process to ever infer it anymore.
 * Which scopes are left when moving from one expression to the next can be a bit tricky. For example, when jumping from an
 * iterator variable expression to the {@link LoopExp}'s source expression, all kinds of in-between expressions that are containers to
 * the iterator variable expression are left as well. Therefore, the common container of the from/to expressions needs to be
 * determined, and all variables whose static scope is any of from, or any of from's direct or transitive containers that
 * are still contained (directly or transitively) in the common container of from/to, are considered out of scope.<p>
 * 
 * @author Axel Uhl (D043530)
 * 
 */
public class TracebackCache {
    /**
     * Cached values of {@link NavigationStep#navigate(Set, TracebackCache, org.eclipse.emf.common.notify.Notification)} calls,
     * keyed by the step and the <code>fromObject</code> from which navigation was computed, caching the prior results.
     */
    private final Map<Pair<NavigationStep, AnnotatedEObject>, Set<AnnotatedEObject>> navigateCache;
    
    /**
     * During performing a traceback, the algorithm checks whether expressions affected by the original change
     * may be unused. When such an unused-check hits a {@link VariableExp} the value of which can't be determined
     * because the variable's value has not yet been inferred, the unused-check initially fails. This map stores
     * the requests that failed and whose unknown variable is still in the scope of the expression currently visited by the
     * traceback process.
     */
    private final Map<Variable, Set<UnusedEvaluationRequest>> unusedEvaluationRequests;
    
    /**
     * All expressions managed in {@link #unusedEvaluationRequests} are also entered and removed synchronously here.
     * The key used in this map is obtained by asking for {@link UnusedEvaluationRequest#getVariableScope()}.
     */
    private final Map<OCLExpression, Set<UnusedEvaluationRequest>> unusedEvaluationRequestsByStaticScope;
    
    /**
     * The variables that are in scope for the expression currently being visited by the traceback process.
     */
    private final Set<Variable> variablesInScope;
    
    /**
     * For each variable that was in scope at any time during a traceback run, this map records the current dynamic scope
     * as a linearly increasing counter for each variable. These numeric scope IDs can be used to look up variable values
     * inferred during the traceback process by a {@link VariableDefiningNavigationStep} in the {@link #knownVariableValues} map.
     */
    private final Map<Variable, Integer> dynamicScopes;
    
    /**
     * Records variable values inferred by {@link VariableDefiningNavigationStep}s during the traceback process,
     * together with the dynamic scope IDs that also appear as the values in {@link #dynamicScopes}.
     */
    private final Map<Pair<Variable, Integer>, Object> knownVariableValues;
    
    private final OperationBodyToCallMapper operationBodyToCallMapper;
    
    public TracebackCache(OperationBodyToCallMapper operationBodyToCallMapper) {
        navigateCache = new HashMap<Pair<NavigationStep, AnnotatedEObject>, Set<AnnotatedEObject>>();
        unusedEvaluationRequests = new HashMap<Variable, Set<UnusedEvaluationRequest>>();
        unusedEvaluationRequestsByStaticScope = new HashMap<OCLExpression, Set<UnusedEvaluationRequest>>();
        variablesInScope = new HashSet<Variable>();
        dynamicScopes = new HashMap<Variable, Integer>();
        knownVariableValues = new HashMap<Pair<Variable, Integer>, Object>();
        this.operationBodyToCallMapper = operationBodyToCallMapper;
    }
    
    /**
     * Looks up a previously {@link #put entered} result for the <code>step</code> where navigation
     * started at the <code>from</code> object. If not found, <code>null</code> is returned.
     */
    public Set<AnnotatedEObject> get(NavigationStep step, AnnotatedEObject from) {
        Set<AnnotatedEObject> result = navigateCache.get(new Pair<NavigationStep, AnnotatedEObject>(step, from));
        return result;
    }
    
    public void put(NavigationStep step, AnnotatedEObject from, Set<AnnotatedEObject> result) {
        navigateCache.put(new Pair<NavigationStep, AnnotatedEObject>(step, from), result);
    }

    /**
     * Updates {@link #variablesInScope} and {@link #dynamicScopes} by removing all variables that leave scope,
     * then adding all variables entering scope to {@link #variablesInScope}. For all variables entering scope,
     * their dynamic scope ID in {@link #dynamicScopes} is incremented (if there already was one contained)
     * or initialized to 0 (if non was contained yet, meaning the variable enters scope for the first time).
     * 
     * @param leaving
     *            must not be <code>null</code>
     * @param entering
     *            must not be <code>null</code>
     */
    public void scopeChange(Set<Variable> leaving, Set<Variable> entering) {
        variablesInScope.removeAll(leaving);
        variablesInScope.addAll(entering);
        for (Variable v : entering) {
            Integer dynamicScopeID = dynamicScopes.get(v);
            if (dynamicScopeID == null) {
                dynamicScopeID = 0;
            } else {
                dynamicScopeID++;
            }
            dynamicScopes.put(v, dynamicScopeID);
        }
    }
    
    /**
     * Based on the current dynamic scopes {see {@link #dynamicScopes}) for all variables currently in scope
     * (see {@link #variablesInScope}) for which their value for the current dynamic scope is known, puts
     * an entry into the resulting map associating the value known with the variable. 
     */
    public Map<Variable, Object> getKnownValuesOfVariablesInCurrentScope() {
        Map<Variable, Object> result = new HashMap<Variable, Object>();
        for (Variable variableInScope : variablesInScope) {
            Pair<Variable, Integer> scope = new Pair<Variable, Integer>(variableInScope, dynamicScopes.get(variableInScope));
            if (knownVariableValues.containsKey(scope)) { // allow for null values!
                result.put(variableInScope, knownVariableValues.get(scope));
            }
        }
        return result;
    }

    /**
     * When the traceback process has inferred a variable value because it reached a {@link VariableExp} of a non-collection
     * variable, it calls this method. This may trigger the re-evaluation of those {@link UnusedEvaluationRequest} requests whose
     * unknown variable's value just became known by this. This method re-evaluates those requests. Those that don't succeed in
     * their evaluation produce a subsequent {@link UnusedEvaluationRequest} which is entered into
     * {@link #unusedEvaluationRequests} while removing the unsuccessful request. Those that succeed have either shown that the
     * subexpression they were investigating was unused. If this happens for any of the requests triggered by a call to this
     * method, this method returns <code>true</code>. Or the request couldn't prove that the subexpression was unused. In this
     * case, the request is simply removed from {@link #unusedEvaluationRequests}.
     * 
     * @return <code>true</code>, if the inferred variable value lead to the successful evaluation of any of the stored
     *         {@link UnusedEvaluationRequest}s such that it proved that the expression where the change occurred is not used;
     *         <code>false</code> otherwise.
     */
    public boolean setVariableValueAndCheckIfUnused(VariableExp variable, AnnotatedEObject fromObject,
            OppositeEndFinder oppositeEndFinder) {
        boolean result = false;
        Set<UnusedEvaluationRequest> requests = unusedEvaluationRequests.remove(variable);
        Set<UnusedEvaluationRequest> newRequests = new HashSet<UnusedEvaluationRequest>();
        if (requests != null) {
            for (UnusedEvaluationRequest request : requests) {
                EvaluationResult evalResult = request.evaluate(fromObject, oppositeEndFinder, operationBodyToCallMapper);
                if (!evalResult.wasSuccessful()) {
                    newRequests.add(evalResult.getNextEvaluationRequest());
                } else {
                    if (evalResult.isUnused()) {
                        result = true;
                    }
                }
                removeUnusedEvaluationRequestFromMapByScope(request);
            }
            for (UnusedEvaluationRequest newRequest : newRequests) {
                addUnusedNavigationRequest(newRequest);
            }
        }
        return result;
    }

    private void removeUnusedEvaluationRequestFromMapByScope(UnusedEvaluationRequest request) {
        Set<UnusedEvaluationRequest> requestsByScope = unusedEvaluationRequestsByStaticScope.get(request.getVariableScope());
        requestsByScope.remove(request);
        if (requestsByScope.isEmpty()) {
            unusedEvaluationRequestsByStaticScope.remove(request.getVariableScope());
        }
    }

    private void addUnusedNavigationRequest(UnusedEvaluationRequest newRequest) {
        addUnusedEvaluationRequestByVariable(newRequest);
        addUnusedEvaluationRequestByScope(newRequest);
    }

    private void addUnusedEvaluationRequestByScope(UnusedEvaluationRequest newRequest) {
        Set<UnusedEvaluationRequest> s2 = unusedEvaluationRequestsByStaticScope.get(newRequest.getVariableScope());
        if (s2 == null) {
            s2 = new HashSet<UnusedEvaluationRequest>();
            unusedEvaluationRequestsByStaticScope.put(newRequest.getVariableScope(), s2);
        }
        s2.add(newRequest);
    }

    private void addUnusedEvaluationRequestByVariable(UnusedEvaluationRequest newRequest) {
        Set<UnusedEvaluationRequest> s1 = unusedEvaluationRequests.get(newRequest.getUnknownVariable());
        if (s1 == null) {
            s1 = new HashSet<UnusedEvaluationRequest>();
            unusedEvaluationRequests.put(newRequest.getUnknownVariable(), s1);
        }
        s1.add(newRequest);
    }
}

