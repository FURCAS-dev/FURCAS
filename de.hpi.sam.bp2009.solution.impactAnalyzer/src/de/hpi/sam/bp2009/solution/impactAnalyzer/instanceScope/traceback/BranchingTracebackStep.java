package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestSet;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

public class BranchingTracebackStep extends AbstractTracebackStep {

    private final Set<TracebackStepAndScopeChange> steps;

    public BranchingTracebackStep(OCLExpression sourceExpression) {
        super(sourceExpression);
        steps = new HashSet<TracebackStepAndScopeChange>();
    }

    @Override
    protected Set<AnnotatedEObject> performSubsequentTraceback(AnnotatedEObject source,
            UnusedEvaluationRequestSet pendingUnusedEvalRequests, de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.TracebackCache tracebackCache, Notification changeEvent) {
        Set<AnnotatedEObject> result = new HashSet<AnnotatedEObject>();
        for (TracebackStepAndScopeChange step : steps) {
            result.addAll(step.traceback(source, pendingUnusedEvalRequests, tracebackCache, changeEvent));
        }
        return result;
    }

    protected Set<TracebackStepAndScopeChange> getSteps() {
        return steps;
    }

}
