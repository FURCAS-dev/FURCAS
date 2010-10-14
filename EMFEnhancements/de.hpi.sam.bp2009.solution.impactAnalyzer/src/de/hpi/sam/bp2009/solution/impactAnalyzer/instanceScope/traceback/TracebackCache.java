package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.LoopExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;

import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.ActivationOption;
import de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.ValueNotFoundException;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.NavigationStep;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequest;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestSet;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.OperationCallExpKeyedSet;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.OperationCallExpKeyedSetFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.Tuple.Triple;

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
    private final Map<Triple<TracebackStep, AnnotatedEObject, UnusedEvaluationRequestSet>, OperationCallExpKeyedSet> navigateCache;
    
    /**
     * Caches the results of {@link UnusedEvaluationRequest#evaluate(com.sap.emf.ocl.hiddenopposites.OppositeEndFinder evaluating}
     * an {@link UnusedEvaluationRequest}. The result may either be a {@link ValueNotFoundException} telling for which unknown
     * variable the request failed, or a {@link Boolean} telling if the evaluation caused unusedness to be proven.
     */
    private final Map<UnusedEvaluationRequest, Object> unusedEvaluationCache;
    
    private final ActivationOption configuration;
    
    private final UnusedEvaluationRequestFactory unusedEvaluationRequestFactory;
    
    private final OperationCallExpKeyedSetFactory operationCallExpKeyedSetFactory;
    
    public TracebackCache(ActivationOption configuration, UnusedEvaluationRequestFactory unusedEvaluationRequestFactory) {
        navigateCache = new HashMap<Triple<TracebackStep, AnnotatedEObject, UnusedEvaluationRequestSet>, OperationCallExpKeyedSet>();
        unusedEvaluationCache = new HashMap<UnusedEvaluationRequest, Object>();
        this.configuration = configuration;
        this.unusedEvaluationRequestFactory = unusedEvaluationRequestFactory;
        operationCallExpKeyedSetFactory = new OperationCallExpKeyedSetFactory(configuration.isOperationCallSelectionActive());
    }
    
    public ActivationOption getConfiguration() {
        return configuration;
    }
    
    /**
     * Looks up a previously {@link #put entered} result for the <code>step</code> where navigation
     * started at the <code>from</code> object. If not found, <code>null</code> is returned.
     */
    public OperationCallExpKeyedSet get(TracebackStep step, AnnotatedEObject from,
            UnusedEvaluationRequestSet pendingUnusedEvaluationRequests) {
        OperationCallExpKeyedSet result = navigateCache.get(new Triple<TracebackStep, AnnotatedEObject, UnusedEvaluationRequestSet>(
                step, from, pendingUnusedEvaluationRequests));
        return result;
    }
    
    public void put(TracebackStep step, AnnotatedEObject from, UnusedEvaluationRequestSet pendingUnusedEvaluationRequests,
            OperationCallExpKeyedSet result) {
        navigateCache.put(new Triple<TracebackStep, AnnotatedEObject, UnusedEvaluationRequestSet>(step, from,
                pendingUnusedEvaluationRequests), result);
    }

    /**
     * Caches the results of {@link UnusedEvaluationRequest#evaluate(com.sap.emf.ocl.hiddenopposites.OppositeEndFinder evaluating}
     * an {@link UnusedEvaluationRequest}. The result may either be a {@link ValueNotFoundException} telling for which unknown
     * variable the request failed, or a {@link Boolean} telling if the evaluation caused unusedness to be proven.
     */
    public Object getCachedEvaluationResult(UnusedEvaluationRequest request) {
        return unusedEvaluationCache.get(request);
    }

    /**
     * Caches the results of {@link UnusedEvaluationRequest#evaluate(com.sap.emf.ocl.hiddenopposites.OppositeEndFinder evaluating}
     * an {@link UnusedEvaluationRequest}. The result may either be a {@link ValueNotFoundException} telling for which unknown
     * variable the request failed, or a {@link Boolean} telling if the evaluation caused unusedness to be proven.
     */
    public void cacheEvaluationResult(UnusedEvaluationRequest request, Object evaluationResult) {
        unusedEvaluationCache.put(request, evaluationResult);
    }

    public UnusedEvaluationRequestFactory getUnusedEvaluationRequestFactory() {
        return unusedEvaluationRequestFactory;
    }

    public OperationCallExpKeyedSetFactory getOperationCallExpKeyedSetFactory() {
        return operationCallExpKeyedSetFactory;
    }
}

