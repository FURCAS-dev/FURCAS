package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback;

import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.IfExp;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

/**
 * When a {@link IfExp} is traced back, it calls the {@link TracebackStep#traceback(AnnotatedEObject, Set, de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.TracebackCache, Notification)}
 * function for its then-expression and its else-expression, forwarding the <code>source</code> object, the (possibly
 * modified) <code>pendingUnusedEvalRequests</code> and the <code>tracebackCache</code>.
 * 
 * @see AbstractTracebackStep#performSubsequentTraceback(AnnotatedEObject, Set, de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.TracebackCache, Notification)
 */
public class IfTracebackStep extends BranchingTracebackStep<IfExp> {
    public IfTracebackStep(IfExp sourceExpression, EClass context, OperationBodyToCallMapper operationBodyToCallMapper,
            Stack<String> tupleLiteralNamesToLookFor, TracebackStepCache tracebackStepCache) {
        super(sourceExpression, tupleLiteralNamesToLookFor, tracebackStepCache.getOppositeEndFinder());
        OCLExpression thenExpression = (OCLExpression) sourceExpression.getThenExpression();
        getSteps().add(createTracebackStepAndScopeChange(sourceExpression, thenExpression, context, operationBodyToCallMapper,
                tupleLiteralNamesToLookFor, tracebackStepCache));
        OCLExpression elseExpression = (OCLExpression) sourceExpression.getElseExpression();
        getSteps().add(createTracebackStepAndScopeChange(sourceExpression, elseExpression, context, operationBodyToCallMapper,
                tupleLiteralNamesToLookFor, tracebackStepCache));
    }
}