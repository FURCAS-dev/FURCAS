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
    private final TracebackStepAndScopeChange step;

    public IterateTracebackStep(IterateExp sourceExpression, EClass context, OperationBodyToCallMapper operationBodyToCallMapper,
            Stack<String> tupleLiteralNamesToLookFor, TracebackStepCache tracebackStepCache) {
        super(sourceExpression);
        step = createTracebackStepAndScopeChange(sourceExpression, (OCLExpression) sourceExpression.getBody(), context,
                operationBodyToCallMapper, tupleLiteralNamesToLookFor, tracebackStepCache);
    }

    @Override
    protected Set<AnnotatedEObject> performSubsequentTraceback(AnnotatedEObject source,
            UnusedEvaluationRequestSet pendingUnusedEvalRequests, TracebackCache tracebackCache) {
        return step.traceback(source, pendingUnusedEvalRequests, tracebackCache);
    }

}
