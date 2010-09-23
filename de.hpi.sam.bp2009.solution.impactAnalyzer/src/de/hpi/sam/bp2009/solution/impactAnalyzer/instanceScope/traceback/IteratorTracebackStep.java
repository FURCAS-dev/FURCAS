package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.ocl.ecore.IteratorExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.utilities.PredefinedType;

import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.PartialEvaluator;
import de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.ValueNotFoundException;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestSet;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

public class IteratorTracebackStep extends AbstractTracebackStep {
    private enum Strategy { EMPTY, MAP, PASSTHROUGH };
    private final Strategy strategy;
    private final TracebackStepAndScopeChange step;
    private final IteratorExp predicateExpressionToCheck;
    private final boolean acceptIfPredicateTrue;
    private final OppositeEndFinder oppositeEndFinder;

    public IteratorTracebackStep(IteratorExp sourceExpression, EClass context,
            OperationBodyToCallMapper operationBodyToCallMapper, Stack<String> tupleLiteralNamesToLookFor, TracebackStepCache tracebackStepCache) {
        super(sourceExpression, tupleLiteralNamesToLookFor);
        String name = sourceExpression.getName();
        int opCode = OCLStandardLibraryUtil.getOperationCode(name);
        if (opCode == PredefinedType.SELECT || opCode == PredefinedType.REJECT || opCode == PredefinedType.SORTED_BY
                || opCode == PredefinedType.ANY) {
            strategy = Strategy.PASSTHROUGH;
            step = createTracebackStepAndScopeChange(sourceExpression, (OCLExpression) sourceExpression.getSource(), context,
                    operationBodyToCallMapper, tupleLiteralNamesToLookFor, tracebackStepCache);
            if (opCode == PredefinedType.SELECT || opCode == PredefinedType.REJECT || opCode == PredefinedType.ANY) {
                // evaluate predicate before checking how it goes on
                org.eclipse.ocl.expressions.Variable<EClassifier, EParameter> varDecl = sourceExpression.getIterator().get(0);
                // TODO what about tuple types here?
                requiredType = getInnermostClass(varDecl.getType());
                if (opCode == PredefinedType.SELECT || opCode == PredefinedType.ANY) {
                    acceptIfPredicateTrue = true;
                } else {
                    acceptIfPredicateTrue = false;
                }
                predicateExpressionToCheck = sourceExpression;
                oppositeEndFinder = tracebackStepCache.getOppositeEndFinder();
            } else {
                requiredType = null;
                predicateExpressionToCheck = null;
                acceptIfPredicateTrue = false;
                oppositeEndFinder = null;
            }
        } else if (opCode == PredefinedType.COLLECT || opCode == PredefinedType.COLLECT_NESTED) {
            strategy = Strategy.MAP;
            requiredType = null;
            predicateExpressionToCheck = null;
            acceptIfPredicateTrue = false;
            step = createTracebackStepAndScopeChange(sourceExpression, (OCLExpression) sourceExpression.getBody(), context, operationBodyToCallMapper, tupleLiteralNamesToLookFor, tracebackStepCache);
            oppositeEndFinder = null;
        } else {
            // boolean or other non-class-type-result iterator
            strategy = Strategy.EMPTY;
            requiredType = null;
            predicateExpressionToCheck = null;
            acceptIfPredicateTrue = false;
            step = null;
            oppositeEndFinder = null;
        }
    }

    @Override
    protected Set<AnnotatedEObject> performSubsequentTraceback(AnnotatedEObject source,
            UnusedEvaluationRequestSet pendingUnusedEvalRequests, de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.TracebackCache tracebackCache, Notification changeEvent) {
        Notification atPre = null; // FIXME needs to be passed as argument
        switch (strategy) {
        case EMPTY:
            return Collections.emptySet();
        case MAP:
            return step.traceback(source, pendingUnusedEvalRequests, tracebackCache, changeEvent);
        case PASSTHROUGH:
            Set<EObject> sourceValue = new LinkedHashSet<EObject>(1);
            sourceValue.add(source.getAnnotatedObject());
            boolean passedPredicate = evaluatePredicate(sourceValue, atPre);
            if (passedPredicate) {
                return step.traceback(source, pendingUnusedEvalRequests, tracebackCache, changeEvent);
            } else {
                return Collections.emptySet();
            }
        default:
            throw new RuntimeException("Internal error: unknown traceback strategy "+strategy);
        }
    }

    private boolean evaluatePredicate(Collection<EObject> sourceObjects, Notification atPre) {
        if (predicateExpressionToCheck == null) {
            return true;
        } else {
            // evaluate whether the source object would have passed the iterator's body before the change
            boolean resultPre = acceptIfPredicateTrue;
            if (!(atPre == null)) {
                PartialEvaluator evalPre = new PartialEvaluator(atPre, oppositeEndFinder);
                try {
                    Object result = evalPre.evaluate(null, predicateExpressionToCheck, sourceObjects);
                    resultPre = sourceObjects.contains(result);
                } catch (ValueNotFoundException vnfe) {
                    // be conservative about undefined situations
                    resultPre = acceptIfPredicateTrue;
                } catch (ClassCastException cce) {
                    throw new RuntimeException("The result of the iterator expression's body is not of type Boolean.");
                }
            }
            // evaluate whether the source object passes the iterator's body after the change

            PartialEvaluator evalPost = new PartialEvaluator();
            boolean resultPost;
            try {
                Object result = evalPost.evaluate(null, predicateExpressionToCheck, sourceObjects);
                resultPost = sourceObjects.contains(result);
            } catch (ValueNotFoundException vnfe) {
                // be conservative about undefined situations
                resultPost = acceptIfPredicateTrue;
            } catch (ClassCastException cce) {
                throw new RuntimeException("The result of the iterator expression's body is not of type Boolean.");
            }
            // if the source object fulfills the condition before or after the change event
            // or accesses an undefined variable before or after the change event
            // it passes this navigation step
            return resultPre == acceptIfPredicateTrue || resultPost == acceptIfPredicateTrue;
        }
    }

}
