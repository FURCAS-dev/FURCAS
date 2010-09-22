package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback;

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.IteratorExp;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.TracebackCache;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestSet;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

public class IteratorTracebackStep extends AbstractTracebackStep {

    private final TracebackStepAndScopeChange subSequentStep;

    public IteratorTracebackStep(IteratorExp sourceExpression, EClass context,
            OperationBodyToCallMapper operationBodyToCallMapper, String[] tupleLiteralNamesToLookFor,
            TracebackStepCache tracebackStepCache) {
        String iteratorExpName = sourceExpression.getName();
        if ("select".equals(iteratorExpName) || "reject".equals(iteratorExpName) || "sortedBy".equals(iteratorExpName)
                || "any".equals(iteratorExpName)) {
            OCLExpression source = (OCLExpression) sourceExpression.getSource();
            subSequentStep = createTracebackStepAndScopeChange(sourceExpression, source, context, operationBodyToCallMapper, tupleLiteralNamesToLookFor, tracebackStepCache);
        } else {
            if ("collect".equals(iteratorExpName) || "collectNested".equals(iteratorExpName)) {
                OCLExpression body = (OCLExpression) sourceExpression.getBody();
                subSequentStep = createTracebackStepAndScopeChange(sourceExpression, body, context, operationBodyToCallMapper, tupleLiteralNamesToLookFor, tracebackStepCache);
            } else {
                // iterator with boolean result
                subSequentStep = null;
            }
        }
    }

    /**
     * When a {@link IteratorExp} is traced back, it calls the
     * {@link TracebackStep#traceback(AnnotatedEObject, Set, TracebackCache)} function for its source-expression, when the
     * iterator name equals 'select', 'reject', 'any' or 'sortedBy', forwarding the <code>source</code> object, the (possibly
     * modified) <code>pendingUnusedEvalRequests</code> and the <code>tracebackCache</code>.
     * 
     * When the iterator name equals either 'collect' or 'collectNested', the {@link IteratorExp} is traced back by calling the
     * {@link TracebackStep#traceback(AnnotatedEObject, Set, TracebackCache)} function for its body-expression, forwarding the
     * <code>source</code> object, the (possibly modified) <code>pendingUnusedEvalRequests</code> and the
     * <code>tracebackCache</code>.
     * 
     * In all other cases an empty set is returned.
     * 
     * @see AbstractTracebackStep#performSubsequentTraceback(AnnotatedEObject, Set, TracebackCache)
     */
    @Override
    protected Set<AnnotatedEObject> performSubsequentTraceback(AnnotatedEObject source,
            UnusedEvaluationRequestSet pendingUnusedEvalRequests, TracebackCache tracebackCache) {
        if (subSequentStep == null) {
            // iterator with boolean result
            return Collections.emptySet();
        } else {
            return subSequentStep.traceback(source, pendingUnusedEvalRequests, tracebackCache);
        }
    }

}
