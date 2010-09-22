package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback;

import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.IterateExp;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.TracebackCache;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestSet;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

public class IterateTracebackStep extends AbstractTracebackStep {

    private final TracebackStepAndScopeChange bodyExpressionStep;

    public IterateTracebackStep(IterateExp sourceExpression, EClass context, OperationBodyToCallMapper operationBodyToCallMapper,
            Stack<String> tupleLiteralNamesToLookFor, TracebackStepCache tracebackStepCache) {

        OCLExpression bodyExpression = (OCLExpression) sourceExpression.getBody();
        bodyExpressionStep = createTracebackStepAndScopeChange(sourceExpression, bodyExpression, context,
                operationBodyToCallMapper, tupleLiteralNamesToLookFor, tracebackStepCache);
    }

    /**
     * When a {@link IterateExp} is traced back, it calls the
     * {@link TracebackStep#traceback(AnnotatedEObject, Set, TracebackCache)} function for its body-expression, forwarding the
     * <code>source</code> object, the (possibly modified) <code>pendingUnusedEvalRequests</code> and the
     * <code>tracebackCache</code>.
     * 
     * @see AbstractTracebackStep#performSubsequentTraceback(AnnotatedEObject, Set, TracebackCache)
     */
    @Override
    protected Set<AnnotatedEObject> performSubsequentTraceback(AnnotatedEObject source,
            UnusedEvaluationRequestSet pendingUnusedEvalRequests, TracebackCache tracebackCache) {
        return bodyExpressionStep.traceback(source, pendingUnusedEvalRequests, tracebackCache);
    }

}
