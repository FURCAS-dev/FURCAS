package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback;

import java.util.HashMap;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.TracebackCache;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequest;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

public class LetTracebackStep extends AbstractTracebackStep {

    private static final String IN_EXPRESSION_STEP = "inExpressionStep";

    public LetTracebackStep(LetExp sourceExpression, EClass context, OperationBodyToCallMapper operationBodyToCallMapper,
            String[] tupleLiteralNamesToLookFor, TracebackStepCache tracebackStepCache) {
        
        TracebackStep inExpressionStep = tracebackStepCache.createStep((OCLExpression) ((LetExp) sourceExpression).getIn(),
                context, operationBodyToCallMapper, tupleLiteralNamesToLookFor);
        
        nextSteps = new HashMap<String, TracebackStep>();
        nextSteps.put(IN_EXPRESSION_STEP, inExpressionStep);
    }

    /**
     * When a {@link LetExp} is traced back, it calls the {@link TracebackStep#traceback(AnnotatedEObject, Set, TracebackCache)}
     * function for its in-expression, forwarding the <code>source</code> object, the (possibly modified)
     * <code>pendingUnusedEvalRequests</code> and the <code>tracebackCache</code>.
     * 
     * @see AbstractTracebackStep#performSubsequentTraceback(AnnotatedEObject, Set, TracebackCache)
     */
    @Override
    protected Set<AnnotatedEObject> performSubsequentTraceback(AnnotatedEObject source,
            Set<UnusedEvaluationRequest> pendingUnusedEvalRequests, TracebackCache tracebackCache) {
        TracebackStep nextStep = nextSteps.get(IN_EXPRESSION_STEP);
        return nextStep.traceback(source, pendingUnusedEvalRequests, tracebackCache);
    }
}
