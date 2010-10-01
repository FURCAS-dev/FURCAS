package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback;

import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.BooleanLiteralExp;
import org.eclipse.ocl.ecore.EnumLiteralExp;
import org.eclipse.ocl.ecore.IntegerLiteralExp;
import org.eclipse.ocl.ecore.InvalidLiteralExp;
import org.eclipse.ocl.ecore.NullLiteralExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.RealLiteralExp;
import org.eclipse.ocl.ecore.StringLiteralExp;
import org.eclipse.ocl.ecore.UnlimitedNaturalLiteralExp;

import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestSet;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.OperationCallExpKeyedSet;

public class EmptyTracebackStep extends AbstractTracebackStep<OCLExpression> {

    public EmptyTracebackStep(OCLExpression sourceExpression, EClass context,
            OperationBodyToCallMapper operationBodyToCallMapper, Stack<String> tupleLiteralNamesToLookFor, TracebackStepCache tracebackStepCache, UnusedEvaluationRequestFactory unusedEvaluationRequestFactory) {
        super(sourceExpression, tupleLiteralNamesToLookFor, tracebackStepCache.getOppositeEndFinder(), operationBodyToCallMapper, unusedEvaluationRequestFactory);
    }

    /**
     * When an {@link IntegerLiteralExp} or an {@link UnlimitedNaturalLiteralExp} or a {@link StringLiteralExp} or a
     * {@link RealLiteralExp} or an {@link EnumLiteralExp} or a {@link BooleanLiteralExp} or a {@link NullLiteralExp} or an
     * {@link InvalidLiteralExp} is traced back, an empty set is returned.
     * 
     * @see AbstractTracebackStep#performSubsequentTraceback(AnnotatedEObject, Set, de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.TracebackCache, Notification)
     */
    @Override
    protected OperationCallExpKeyedSet<AnnotatedEObject> performSubsequentTraceback(AnnotatedEObject source,
            UnusedEvaluationRequestSet pendingUnusedEvalRequests, de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.TracebackCache tracebackCache, Notification changeEvent) {
        return OperationCallExpKeyedSet.emptySet(tracebackCache.getConfiguration().isOperationCallSelectionActive());
    }

}
