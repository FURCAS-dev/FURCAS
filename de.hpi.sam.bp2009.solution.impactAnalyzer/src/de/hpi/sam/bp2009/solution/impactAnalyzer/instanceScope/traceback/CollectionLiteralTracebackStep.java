package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.ecore.CollectionItem;
import org.eclipse.ocl.ecore.CollectionLiteralExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.expressions.CollectionLiteralPart;

import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.TracebackCache;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestSet;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

public class CollectionLiteralTracebackStep extends AbstractTracebackStep {

    private final Set<TracebackStepAndScopeChange> subSequentSteps;

    public CollectionLiteralTracebackStep(OCLExpression sourceExpression, EClass context,
            OperationBodyToCallMapper operationBodyToCallMapper, Stack<String> tupleLiteralNamesToLookFor, TracebackStepCache tracebackStepCache) {
        super(sourceExpression);
        subSequentSteps = new HashSet<TracebackStepAndScopeChange>();
        for (CollectionLiteralPart<EClassifier> part : ((CollectionLiteralExp) sourceExpression).getPart()) {
            if (part instanceof CollectionItem) {
                OCLExpression item = (OCLExpression) ((CollectionItem) part).getItem();
                subSequentSteps.add(createTracebackStepAndScopeChange(sourceExpression, item, context, operationBodyToCallMapper,
                        tupleLiteralNamesToLookFor, tracebackStepCache));
            }
        }
    }

    /**
     * When a {@link CollectionLiteralExp} is traced back, it calls the
     * {@link TracebackStep#traceback(AnnotatedEObject, Set, TracebackCache)} function for the item of those parts, which are
     * instance of {@link CollectionItem}, forwarding the <code>source</code> object, the (possibly modified)
     * <code>pendingUnusedEvalRequests</code> and the <code>tracebackCache</code>.
     * 
     * @see AbstractTracebackStep#performSubsequentTraceback(AnnotatedEObject, Set, TracebackCache)
     */
    @Override
    protected Set<AnnotatedEObject> performSubsequentTraceback(AnnotatedEObject source,
            UnusedEvaluationRequestSet pendingUnusedEvalRequests, TracebackCache tracebackCache) {
        Set<AnnotatedEObject> result = new HashSet<AnnotatedEObject>();
        for (TracebackStepAndScopeChange step : subSequentSteps) {
            result.addAll(step.traceback(source, pendingUnusedEvalRequests, tracebackCache));
        }
        return result;
    }

}
