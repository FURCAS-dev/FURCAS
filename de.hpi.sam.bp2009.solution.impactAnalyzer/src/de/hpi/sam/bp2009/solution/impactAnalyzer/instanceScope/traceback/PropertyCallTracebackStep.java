package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.PropertyCallExp;
import org.eclipse.ocl.ecore.TupleType;

import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.TracebackCache;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestSet;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

public class PropertyCallTracebackStep extends AbstractTracebackStep {

    private final TracebackStepAndScopeChange nextStep;
    private final PropertyCallExp sourceExpression;
    private final OppositeEndFinder oppositeEndFinder;

    public PropertyCallTracebackStep(PropertyCallExp sourceExpression, EClass context,
            OperationBodyToCallMapper operationBodyToCallMapper, Stack<String> tupleLiteralNamesToLookFor,
            TracebackStepCache tracebackStepCache) {
        super(sourceExpression);
        this.sourceExpression = sourceExpression;
        this.oppositeEndFinder = tracebackStepCache.getOppositeEndFinder();
        OCLExpression source = (OCLExpression) sourceExpression.getSource();
        if (source.getType() instanceof TupleType) {
            Stack<String> clone = cloneWithTypeCheck(tupleLiteralNamesToLookFor);
            clone.push(source.getName());
        }
        // TODO context change necessary?
        nextStep = createTracebackStepAndScopeChange(sourceExpression, source, context, operationBodyToCallMapper,
                tupleLiteralNamesToLookFor, tracebackStepCache);

    }

    @Override
    protected Set<AnnotatedEObject> performSubsequentTraceback(AnnotatedEObject source,
            UnusedEvaluationRequestSet pendingUnusedEvalRequests, TracebackCache tracebackCache) {
        
        Set<AnnotatedEObject> result = new HashSet<AnnotatedEObject>();
        if (sourceExpression.getSource().getType() instanceof TupleType) {
            result.addAll(nextStep.traceback(source, pendingUnusedEvalRequests, tracebackCache));
        } else {
            EStructuralFeature feature = sourceExpression.getReferredProperty();
            if (feature instanceof EAttribute){
                // TODO ensure that an EAttribute could never be reached.
                throw new IllegalArgumentException("An EAttribute should never be reached while traceback.");
            } else if (feature instanceof EReference) {
                EReference ref = (EReference) feature;
                if (ref.getEOpposite() != null){
                    if (ref.isMany()){
                        Object o = source.eGet(ref);
                        if (o instanceof EList<?>){
                            @SuppressWarnings("unchecked")
                            EList<EObject>refObjects = (EList<EObject>) source.eGet(ref);
                            for (EObject obj : refObjects){
                                result.addAll(nextStep.traceback(new AnnotatedEObject(obj), pendingUnusedEvalRequests, tracebackCache));
                            }
                        }
                    } else {
                        AnnotatedEObject o = new AnnotatedEObject((EObject) source.eGet(ref));
                        result.addAll(nextStep.traceback(o, pendingUnusedEvalRequests, tracebackCache));
                    }
                } else if (ref.isContainment()){
                    AnnotatedEObject container = new AnnotatedEObject(source.eContainer());
                    result.addAll(nextStep.traceback(container, pendingUnusedEvalRequests, tracebackCache));
                } else {
                    Collection<EObject> opposite = oppositeEndFinder.navigateOppositePropertyWithBackwardScope(ref, source);
                    // TODO context has changed. Must PendingUnusedEvalRequests be changed for each object?
                    for (EObject o : opposite){
                        result.addAll(nextStep.traceback(new AnnotatedEObject(o), pendingUnusedEvalRequests, tracebackCache));
                    }
                }
            }
        }        
        return result;
    }

    private Stack<String> cloneWithTypeCheck(Stack<String> tupleLiteralNamesToLookFor) {
        Object clone = tupleLiteralNamesToLookFor.clone();
        if (clone instanceof Stack<?>) {
            @SuppressWarnings("unchecked")
            Stack<String> newTupleStack = (Stack<String>) clone;
            return newTupleStack;
        } else {
            throw new ClassCastException("Cloning an instance of Stack<String> didn't return an instance of the same type.");
        }
    }

}
