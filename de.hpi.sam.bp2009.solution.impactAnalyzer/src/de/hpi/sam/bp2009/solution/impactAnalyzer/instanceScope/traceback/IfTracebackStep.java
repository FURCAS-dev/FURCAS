package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.IfExp;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.TracebackCache;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestSet;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

public class IfTracebackStep extends AbstractTracebackStep {
    private final TracebackStepAndScopeChange thenStep;
    private final TracebackStepAndScopeChange elseStep;

    public IfTracebackStep(IfExp sourceExpression, EClass context, OperationBodyToCallMapper operationBodyToCallMapper,
            Stack<String> tupleLiteralNamesToLookFor, TracebackStepCache tracebackStepCache) {
        OCLExpression thenExpression = (OCLExpression) sourceExpression.getThenExpression();
        thenStep = createTracebackStepAndScopeChange(sourceExpression, thenExpression, context, operationBodyToCallMapper,
                tupleLiteralNamesToLookFor, tracebackStepCache);
        OCLExpression elseExpression = (OCLExpression) sourceExpression.getElseExpression();
        elseStep = createTracebackStepAndScopeChange(sourceExpression, elseExpression, context, operationBodyToCallMapper,
                tupleLiteralNamesToLookFor, tracebackStepCache);
    }

    /**
     * When a {@link IfExp} is traced back, it calls the {@link TracebackStep#traceback(AnnotatedEObject, Set, TracebackCache)}
     * function for its then-expression and its else-expression, forwarding the <code>source</code> object, the (possibly
     * modified) <code>pendingUnusedEvalRequests</code> and the <code>tracebackCache</code>.
     * 
     * @see AbstractTracebackStep#performSubsequentTraceback(AnnotatedEObject, Set, TracebackCache)
     */
    @Override
    protected Set<AnnotatedEObject> performSubsequentTraceback(AnnotatedEObject source,
            UnusedEvaluationRequestSet pendingUnusedEvalRequests, TracebackCache tracebackCache) {
        Set<AnnotatedEObject> result = new HashSet<AnnotatedEObject>();
        result.addAll(thenStep.traceback(source, pendingUnusedEvalRequests, tracebackCache));
        result.addAll(elseStep.traceback(source, pendingUnusedEvalRequests, tracebackCache));
        return result;
    }

}
