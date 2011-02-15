/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.impactanalyzer.instanceScope.traceback;

import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.ocl.ecore.IteratorExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.examples.impactanalyzer.PartialEvaluatorFactory;
import org.eclipse.ocl.examples.impactanalyzer.deltaPropagation.PartialEvaluatorImpl;
import org.eclipse.ocl.examples.impactanalyzer.deltaPropagation.ValueNotFoundException;
import org.eclipse.ocl.examples.impactanalyzer.impl.OperationBodyToCallMapper;
import org.eclipse.ocl.examples.impactanalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestFactory;
import org.eclipse.ocl.examples.impactanalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestSet;
import org.eclipse.ocl.examples.impactanalyzer.util.AnnotatedEObject;
import org.eclipse.ocl.examples.impactanalyzer.util.OCLFactory;
import org.eclipse.ocl.examples.impactanalyzer.util.OperationCallExpKeyedSet;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.utilities.PredefinedType;



public class IteratorTracebackStep extends AbstractTracebackStep<IteratorExp> {
    private enum Strategy { EMPTY, MAP, PASSTHROUGH };
    private final Strategy strategy;
    private final TracebackStepAndScopeChange step;
    private final boolean checkPredicate;
    private final boolean acceptIfPredicateTrue;
    private final OppositeEndFinder oppositeEndFinder;
    private final PartialEvaluatorFactory partialEvaluatorFactory;

    public IteratorTracebackStep(IteratorExp sourceExpression, EClass context,
            OperationBodyToCallMapper operationBodyToCallMapper, Stack<String> tupleLiteralNamesToLookFor, TracebackStepCache tracebackStepCache, UnusedEvaluationRequestFactory unusedEvaluationRequestFactory, OCLFactory oclFactory) {
        super(sourceExpression, tupleLiteralNamesToLookFor, tracebackStepCache.getOppositeEndFinder(), operationBodyToCallMapper, unusedEvaluationRequestFactory, oclFactory);
        this.partialEvaluatorFactory = tracebackStepCache.getInstanceScopeAnalysis().getPartialEvaluatorFactory();
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
                requiredType = getInnermostTypeConsideringTupleLiteralsLookedFor(tupleLiteralNamesToLookFor,
                        varDecl.getType());
                if (opCode == PredefinedType.SELECT || opCode == PredefinedType.ANY) {
                    acceptIfPredicateTrue = true;
                } else {
                    acceptIfPredicateTrue = false;
                }
                checkPredicate = true;
                oppositeEndFinder = tracebackStepCache.getOppositeEndFinder();
            } else {
                requiredType = null;
                checkPredicate = false;
                acceptIfPredicateTrue = false;
                oppositeEndFinder = null;
            }
        } else if (opCode == PredefinedType.COLLECT || opCode == PredefinedType.COLLECT_NESTED) {
            strategy = Strategy.MAP;
            requiredType = null;
            checkPredicate = false;
            acceptIfPredicateTrue = false;
            step = createTracebackStepAndScopeChange(sourceExpression, (OCLExpression) sourceExpression.getBody(), context, operationBodyToCallMapper, tupleLiteralNamesToLookFor, tracebackStepCache);
            oppositeEndFinder = null;
        } else {
            // boolean or other non-class-type-result iterator
            strategy = Strategy.EMPTY;
            requiredType = null;
            checkPredicate = false;
            acceptIfPredicateTrue = false;
            step = null;
            oppositeEndFinder = null;
        }
    }

    @Override
    protected OperationCallExpKeyedSet performSubsequentTraceback(AnnotatedEObject source,
            UnusedEvaluationRequestSet pendingUnusedEvalRequests,
            org.eclipse.ocl.examples.impactanalyzer.instanceScope.traceback.TracebackCache tracebackCache,
            Notification changeEvent) {
        switch (strategy) {
        case EMPTY:
            return tracebackCache.getOperationCallExpKeyedSetFactory().emptySet();
        case MAP:
            return step.traceback(annotateEObject(source), pendingUnusedEvalRequests, tracebackCache, changeEvent);
        case PASSTHROUGH:
            boolean passedPredicate = !checkPredicate || evaluatePredicate(source.getAnnotatedObject(), changeEvent);
            if (passedPredicate) {
                return step.traceback(annotateEObject(source), pendingUnusedEvalRequests, tracebackCache, changeEvent);
            } else {
                return tracebackCache.getOperationCallExpKeyedSetFactory().emptySet();
            }
        default:
            throw new RuntimeException("Internal error: unknown traceback strategy "+strategy);
        }
    }

    private boolean evaluatePredicate(EObject sourceObject, Notification atPre) {
        Collection<EObject> sourceCollection = Collections.singleton(sourceObject);
        // evaluate whether the source object would have passed the iterator's body before the change
        boolean resultPre = acceptIfPredicateTrue;
        if (atPre != null) {
            // TODO perform the partial evaluation only if the values of all variables inevitably required by the predicate are known
            // TODO otherwise, think about using the UnusedEvaluationRequest technique to queue predicate evaluation for later
            PartialEvaluatorImpl evalPre = new PartialEvaluatorImpl(atPre, oppositeEndFinder, oclFactory);
            try {
                Object result = evalPre.evaluate(null, getExpression(), sourceCollection);
                resultPre = isSourceInResult(sourceObject, result);
            } catch (ValueNotFoundException vnfe) {
                // be conservative about undefined situations
                resultPre = acceptIfPredicateTrue;
            } catch (ClassCastException cce) {
                throw new RuntimeException("The result of the iterator expression's body is not of type Boolean.");
            }
        }
        boolean resultPost = acceptIfPredicateTrue;
        if (resultPre != acceptIfPredicateTrue) {
            // evaluate whether the source object passes the iterator's body after the change
            PartialEvaluatorImpl evalPost = partialEvaluatorFactory.createPartialEvaluator(oppositeEndFinder, oclFactory);
            try {
                Object result = evalPost.evaluate(null, getExpression(), sourceCollection);
                resultPost = isSourceInResult(sourceObject, result);
            } catch (ValueNotFoundException vnfe) {
                // be conservative about undefined situations
                resultPost = acceptIfPredicateTrue;
            } catch (ClassCastException cce) {
                throw new RuntimeException("The result of the iterator expression's body is not of type Boolean.");
            }
            // if the source object fulfills the condition before or after the change event
            // or accesses an undefined variable before or after the change event
            // it passes this navigation step
        }
        return resultPre == acceptIfPredicateTrue || resultPost == acceptIfPredicateTrue;
    }

    private boolean isSourceInResult(EObject sourceObject, Object result) {
        boolean resultPost;
        if (result instanceof Collection<?>) {
            if (((Collection<?>) result).isEmpty()) {
                resultPost = false;
            } else {
                resultPost = ((Collection<?>) result).contains(sourceObject);
            }
        } else {
            resultPost = result == sourceObject;
        }
        return resultPost;
    }

}
