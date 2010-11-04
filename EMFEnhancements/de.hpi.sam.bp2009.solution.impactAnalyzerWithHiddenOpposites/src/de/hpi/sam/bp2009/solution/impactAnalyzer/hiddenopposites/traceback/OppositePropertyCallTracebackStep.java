package de.hpi.sam.bp2009.solution.impactAnalyzer.hiddenopposites.traceback;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.emf.ocl.oclwithhiddenopposites.expressions.OppositePropertyCallExp;

import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.AbstractTracebackStep;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.TracebackStep;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.TracebackStepCache;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestSet;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.OperationCallExpKeyedSet;

public class OppositePropertyCallTracebackStep extends AbstractTracebackStep<OppositePropertyCallExp> implements TracebackStep {

    private final TracebackStepAndScopeChange nextStep;
    private final boolean isMany;
    private final EReference reference;

    public OppositePropertyCallTracebackStep(OppositePropertyCallExp sourceExpression, EClass context,
            OperationBodyToCallMapper operationBodyToCallMapper, Stack<String> tupleLiteralNamesToLookFor,
            TracebackStepCache tracebackStepCache, UnusedEvaluationRequestFactory unusedEvaluationRequestFactory, OCLFactory oclFactory) {
        super(sourceExpression, tupleLiteralNamesToLookFor, tracebackStepCache.getOppositeEndFinder(), operationBodyToCallMapper, unusedEvaluationRequestFactory, oclFactory);
        OCLExpression source = (OCLExpression) sourceExpression.getSource();
        reference = sourceExpression.getReferredOppositeProperty();
        nextStep = createTracebackStepAndScopeChange(sourceExpression, source, context, operationBodyToCallMapper,
                tupleLiteralNamesToLookFor, tracebackStepCache);
        isMany = sourceExpression.getReferredOppositeProperty().isMany();
    }

    @Override
    protected OperationCallExpKeyedSet performSubsequentTraceback(AnnotatedEObject source,
            UnusedEvaluationRequestSet pendingUnusedEvalRequests, de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.TracebackCache tracebackCache, Notification changeEvent) {
        OperationCallExpKeyedSet result;
        List<OperationCallExpKeyedSet> resultList = new LinkedList<OperationCallExpKeyedSet>();
        Object o = source.eGet(reference);
        if (isMany) {
            if (o instanceof EList<?>) {
                @SuppressWarnings("unchecked")
                EList<EObject> refObjects = (EList<EObject>) o;
                for (EObject obj : refObjects) {
                    resultList.add(nextStep.traceback(annotateEObject(source, obj), pendingUnusedEvalRequests, tracebackCache, changeEvent));
                }
                result = tracebackCache.getOperationCallExpKeyedSetFactory().createOperationCallExpKeyedSet(resultList);
            } else {
                result = tracebackCache.getOperationCallExpKeyedSetFactory().emptySet();
            }
        } else {
            AnnotatedEObject oSingle = annotateEObject(source, (EObject) source.eGet(reference));
            if (oSingle != null) {
                result = nextStep.traceback(oSingle, pendingUnusedEvalRequests, tracebackCache, changeEvent);
            } else {
                result = tracebackCache.getOperationCallExpKeyedSetFactory().emptySet();
            }
        }
        return result;
    }

}
