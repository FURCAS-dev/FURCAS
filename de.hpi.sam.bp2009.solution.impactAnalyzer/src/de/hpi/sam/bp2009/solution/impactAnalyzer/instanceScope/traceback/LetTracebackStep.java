package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback;

import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.TracebackCache;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestSet;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

public class LetTracebackStep extends AbstractTracebackStep {

    private final TracebackStep inExpressionStep;

    public LetTracebackStep(LetExp sourceExpression, EClass context, OperationBodyToCallMapper operationBodyToCallMapper,
            String[] tupleLiteralNamesToLookFor, TracebackStepCache tracebackStepCache) {
        
        inExpressionStep = tracebackStepCache.createStep((OCLExpression) ((LetExp) sourceExpression).getIn(),
                context, operationBodyToCallMapper, tupleLiteralNamesToLookFor);
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
            UnusedEvaluationRequestSet pendingUnusedEvalRequests, TracebackCache tracebackCache) {
        return inExpressionStep.traceback(source, pendingUnusedEvalRequests, tracebackCache);
    }
}
