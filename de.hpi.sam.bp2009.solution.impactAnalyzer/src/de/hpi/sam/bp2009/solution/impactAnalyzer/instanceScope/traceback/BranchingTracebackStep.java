package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.OperationCallExpKeyedSetImpl;

public class BranchingTracebackStep<E extends OCLExpression> extends AbstractTracebackStep<E> {

    private final Set<TracebackStepAndScopeChange> steps;

    public BranchingTracebackStep(E sourceExpression, Stack<String> tupleLiteralNamesToLookFor, OppositeEndFinder oppositeEndFinder, OperationBodyToCallMapper operationBodyToCallMapper, UnusedEvaluationRequestFactory unusedEvaluationRequestFactory) {
        super(sourceExpression, tupleLiteralNamesToLookFor, oppositeEndFinder, operationBodyToCallMapper, unusedEvaluationRequestFactory);
        steps = new HashSet<TracebackStepAndScopeChange>();
    }

    @Override
    protected OperationCallExpKeyedSet performSubsequentTraceback(AnnotatedEObject source,
            UnusedEvaluationRequestSet pendingUnusedEvalRequests, de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.TracebackCache tracebackCache, Notification changeEvent) {
        List<OperationCallExpKeyedSet> results = new ArrayList<OperationCallExpKeyedSet>(steps.size());
        OperationCallExpKeyedSet result;
        int nonEmptyCount = 0;
        int singleNonEmptyIndex = -1;
        int i = 0;
        for (TracebackStepAndScopeChange step : steps) {
            OperationCallExpKeyedSet next = step.traceback(annotateEObject(source), pendingUnusedEvalRequests, tracebackCache, changeEvent);
            results.add(next);
            if (nonEmptyCount <= 1 && !next.isEmpty()) {
                if (nonEmptyCount == 0) {
                    singleNonEmptyIndex = i;
                }
                nonEmptyCount++;
            }
            i++;
        }
        if (nonEmptyCount == 0) {
            result = OperationCallExpKeyedSetImpl.emptySet();
        } else if (nonEmptyCount == 1) {
            result = results.get(singleNonEmptyIndex);
        } else {
            result = new OperationCallExpKeyedSetImpl(results);
        }
        return result;
    }

    protected Set<TracebackStepAndScopeChange> getSteps() {
        return steps;
    }

}
