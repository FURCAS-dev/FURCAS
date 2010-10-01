package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestSet;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.OperationCallExpKeyedSet;

public class BranchingTracebackStep<E extends OCLExpression> extends AbstractTracebackStep<E> {

    private final Set<TracebackStepAndScopeChange> steps;

    public BranchingTracebackStep(E sourceExpression, Stack<String> tupleLiteralNamesToLookFor, OppositeEndFinder oppositeEndFinder, OperationBodyToCallMapper operationBodyToCallMapper, UnusedEvaluationRequestFactory unusedEvaluationRequestFactory) {
        super(sourceExpression, tupleLiteralNamesToLookFor, oppositeEndFinder, operationBodyToCallMapper, unusedEvaluationRequestFactory);
        steps = new HashSet<TracebackStepAndScopeChange>();
    }

    @Override
    protected OperationCallExpKeyedSet<AnnotatedEObject> performSubsequentTraceback(AnnotatedEObject source,
            UnusedEvaluationRequestSet pendingUnusedEvalRequests, de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.TracebackCache tracebackCache, Notification changeEvent) {
        OperationCallExpKeyedSet<AnnotatedEObject> result = new OperationCallExpKeyedSet<AnnotatedEObject>(tracebackCache.getConfiguration().isOperationCallSelectionActive());
        for (TracebackStepAndScopeChange step : steps) {
            result.addAll(step.traceback(annotateEObject(source), pendingUnusedEvalRequests, tracebackCache, changeEvent));
        }
        return result;
    }

    protected Set<TracebackStepAndScopeChange> getSteps() {
        return steps;
    }

}
