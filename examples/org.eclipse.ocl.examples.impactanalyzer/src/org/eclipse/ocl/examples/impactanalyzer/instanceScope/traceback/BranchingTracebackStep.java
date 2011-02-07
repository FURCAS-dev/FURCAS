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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.examples.impactanalyzer.OCLFactory;
import org.eclipse.ocl.examples.impactanalyzer.impl.OperationBodyToCallMapper;
import org.eclipse.ocl.examples.impactanalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestFactory;
import org.eclipse.ocl.examples.impactanalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestSet;
import org.eclipse.ocl.examples.impactanalyzer.util.AnnotatedEObject;
import org.eclipse.ocl.examples.impactanalyzer.util.OperationCallExpKeyedSet;



public class BranchingTracebackStep<E extends OCLExpression> extends AbstractTracebackStep<E> {

    private final Set<TracebackStepAndScopeChange> steps;

    public BranchingTracebackStep(E sourceExpression, Stack<String> tupleLiteralNamesToLookFor, OppositeEndFinder oppositeEndFinder, OperationBodyToCallMapper operationBodyToCallMapper, UnusedEvaluationRequestFactory unusedEvaluationRequestFactory, OCLFactory oclFactory) {
        super(sourceExpression, tupleLiteralNamesToLookFor, oppositeEndFinder, operationBodyToCallMapper, unusedEvaluationRequestFactory, oclFactory);
        steps = new HashSet<TracebackStepAndScopeChange>();
    }

    @Override
    protected OperationCallExpKeyedSet performSubsequentTraceback(AnnotatedEObject source,
            UnusedEvaluationRequestSet pendingUnusedEvalRequests, org.eclipse.ocl.examples.impactanalyzer.instanceScope.traceback.TracebackCache tracebackCache, Notification changeEvent) {
        List<OperationCallExpKeyedSet> results = new ArrayList<OperationCallExpKeyedSet>(steps.size());
        OperationCallExpKeyedSet result;
        int nonEmptyCount = 0;
        int singleNonEmptyIndex = -1;
        int i = 0;
        for (TracebackStepAndScopeChange step : steps) {
            OperationCallExpKeyedSet next = step.traceback(annotateEObject(source), pendingUnusedEvalRequests, tracebackCache, changeEvent);
            if (nonEmptyCount <= 1 && !next.isEmpty()) {
                if (nonEmptyCount == 0) {
                    singleNonEmptyIndex = i;
                }
                nonEmptyCount++;
            }
            if (!next.isEmpty()) {
                results.add(next);
                i++;
            }
        }
        if (nonEmptyCount == 0) {
            result = tracebackCache.getOperationCallExpKeyedSetFactory().emptySet();
        } else if (nonEmptyCount == 1) {
            result = results.get(singleNonEmptyIndex);
        } else {
            result = tracebackCache.getOperationCallExpKeyedSetFactory().createOperationCallExpKeyedSet(results);
        }
        return result;
    }

    protected Set<TracebackStepAndScopeChange> getSteps() {
        return steps;
    }

}
