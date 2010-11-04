package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback;

import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.IterateExp;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestFactory;

public class IterateTracebackStep extends BranchingTracebackStep<IterateExp> {
    public IterateTracebackStep(IterateExp sourceExpression, EClass context, OperationBodyToCallMapper operationBodyToCallMapper,
            Stack<String> tupleLiteralNamesToLookFor, TracebackStepCache tracebackStepCache, UnusedEvaluationRequestFactory unusedEvaluationRequestFactory, OCLFactory oclFactory) {
        super(sourceExpression, tupleLiteralNamesToLookFor, tracebackStepCache.getOppositeEndFinder(), operationBodyToCallMapper, unusedEvaluationRequestFactory, oclFactory);
        getSteps().add(createTracebackStepAndScopeChange(sourceExpression, (OCLExpression) sourceExpression.getBody(), context,
                operationBodyToCallMapper, tupleLiteralNamesToLookFor, tracebackStepCache));
    }
}
