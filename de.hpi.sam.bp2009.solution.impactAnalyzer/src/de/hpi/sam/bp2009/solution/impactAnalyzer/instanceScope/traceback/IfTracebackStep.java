package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback;

import java.util.HashSet;
import java.util.Set;

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
            String[] tupleLiteralNamesToLookFor, TracebackStepCache tracebackStepCache) {
        OCLExpression thenExpression = (OCLExpression) sourceExpression.getThenExpression();
        thenStep = createTracebackStepAndScopeChange(sourceExpression, thenExpression, context, operationBodyToCallMapper,
                tupleLiteralNamesToLookFor, tracebackStepCache);
        OCLExpression elseExpression = (OCLExpression) sourceExpression.getElseExpression();
        elseStep = createTracebackStepAndScopeChange(sourceExpression, elseExpression, context, operationBodyToCallMapper,
                tupleLiteralNamesToLookFor, tracebackStepCache);
    }

    @Override
    protected Set<AnnotatedEObject> performSubsequentTraceback(AnnotatedEObject source,
            UnusedEvaluationRequestSet pendingUnusedEvalRequests, TracebackCache tracebackCache) {
        Set<AnnotatedEObject> result = new HashSet<AnnotatedEObject>();
        result.addAll(thenStep.traceback(source, pendingUnusedEvalRequests, tracebackCache));
        result.addAll(elseStep.traceback(source, pendingUnusedEvalRequests, tracebackCache));
        return result;
    }

}
