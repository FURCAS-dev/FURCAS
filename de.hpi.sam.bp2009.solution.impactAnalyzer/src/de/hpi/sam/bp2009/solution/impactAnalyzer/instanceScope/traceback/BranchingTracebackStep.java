package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestSet;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

public class BranchingTracebackStep<E extends OCLExpression> extends AbstractTracebackStep<E> {

    private final Set<TracebackStepAndScopeChange> steps;

    public BranchingTracebackStep(E sourceExpression, Stack<String> tupleLiteralNamesToLookFor, OppositeEndFinder oppositeEndFinder) {
        super(sourceExpression, tupleLiteralNamesToLookFor, oppositeEndFinder);
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
