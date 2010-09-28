package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback;

import java.util.Stack;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.emf.ocl.oclwithhiddenopposites.expressions.OppositePropertyCallExp;

import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestSet;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.OperationCallExpKeyedSet;

public class OppositePropertyCallTracebackStep extends AbstractTracebackStep<OppositePropertyCallExp> implements TracebackStep {

    private final TracebackStepAndScopeChange nextStep;
    private final boolean isMany;
    private final EReference reference;

    public OppositePropertyCallTracebackStep(OppositePropertyCallExp sourceExpression, EClass context,
            OperationBodyToCallMapper operationBodyToCallMapper, Stack<String> tupleLiteralNamesToLookFor,
            TracebackStepCache tracebackStepCache) {
        super(sourceExpression, tupleLiteralNamesToLookFor, tracebackStepCache.getOppositeEndFinder(), operationBodyToCallMapper);
        OCLExpression source = (OCLExpression) sourceExpression.getSource();
        reference = sourceExpression.getReferredOppositeProperty();
        nextStep = createTracebackStepAndScopeChange(sourceExpression, source, context, operationBodyToCallMapper,
                tupleLiteralNamesToLookFor, tracebackStepCache);
        isMany = sourceExpression.getReferredOppositeProperty().isMany();
    }

    @Override
    protected OperationCallExpKeyedSet<AnnotatedEObject> performSubsequentTraceback(AnnotatedEObject source,
            UnusedEvaluationRequestSet pendingUnusedEvalRequests, de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.TracebackCache tracebackCache, Notification changeEvent) {
        OperationCallExpKeyedSet<AnnotatedEObject> result = new OperationCallExpKeyedSet<AnnotatedEObject>();
        Object o = source.eGet(reference);
        if (isMany) {
            if (o instanceof EList<?>) {
                @SuppressWarnings("unchecked")
                EList<EObject> refObjects = (EList<EObject>) o;
                for (EObject obj : refObjects) {
                    result.addAll(nextStep.traceback(annotateEObject(source, obj), pendingUnusedEvalRequests, tracebackCache, changeEvent));
                }
            }
        } else {
            AnnotatedEObject oSingle = annotateEObject(source, (EObject) source.eGet(reference));
            if (oSingle != null) {
                result.addAll(nextStep.traceback(oSingle, pendingUnusedEvalRequests, tracebackCache, changeEvent));
            }
        }
        return result;
    }

}
