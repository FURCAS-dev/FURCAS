package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback;

import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.ecore.CollectionItem;
import org.eclipse.ocl.ecore.CollectionLiteralExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.expressions.CollectionLiteralPart;

import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

/**
 * When a {@link CollectionLiteralExp} is traced back, it calls the
 * {@link TracebackStep#traceback(AnnotatedEObject, Set, de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.TracebackCache, Notification)} function for the item of those parts, which are
 * instance of {@link CollectionItem}, forwarding the <code>source</code> object, the (possibly modified)
 * <code>pendingUnusedEvalRequests</code> and the <code>tracebackCache</code>.
 * 
 * @see AbstractTracebackStep#performSubsequentTraceback(AnnotatedEObject, Set, de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.TracebackCache, Notification)
 */
public class CollectionLiteralTracebackStep extends BranchingTracebackStep<CollectionLiteralExp> {
    public CollectionLiteralTracebackStep(CollectionLiteralExp sourceExpression, EClass context,
            OperationBodyToCallMapper operationBodyToCallMapper, Stack<String> tupleLiteralNamesToLookFor, TracebackStepCache tracebackStepCache) {
        super(sourceExpression, tupleLiteralNamesToLookFor, tracebackStepCache.getOppositeEndFinder());
        for (CollectionLiteralPart<EClassifier> part : ((CollectionLiteralExp) sourceExpression).getPart()) {
            if (part instanceof CollectionItem) {
                OCLExpression item = (OCLExpression) ((CollectionItem) part).getItem();
                getSteps().add(createTracebackStepAndScopeChange(sourceExpression, item, context, operationBodyToCallMapper,
                        tupleLiteralNamesToLookFor, tracebackStepCache));
            }
        }
    }
}
