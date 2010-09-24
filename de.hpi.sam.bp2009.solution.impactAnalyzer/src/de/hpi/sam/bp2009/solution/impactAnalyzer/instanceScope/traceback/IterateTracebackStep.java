package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback;

import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.IterateExp;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;

public class IterateTracebackStep extends BranchingTracebackStep<IterateExp> {
    public IterateTracebackStep(IterateExp sourceExpression, EClass context, OperationBodyToCallMapper operationBodyToCallMapper,
            Stack<String> tupleLiteralNamesToLookFor, TracebackStepCache tracebackStepCache) {
        super(sourceExpression, tupleLiteralNamesToLookFor, tracebackStepCache.getOppositeEndFinder());
        getSteps().add(createTracebackStepAndScopeChange(sourceExpression, (OCLExpression) sourceExpression.getBody(), context,
                operationBodyToCallMapper, tupleLiteralNamesToLookFor, tracebackStepCache));
    }
}
