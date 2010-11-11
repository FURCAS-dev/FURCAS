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
package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback;

import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

/**
 * When a {@link LetExp} is traced back, it calls the {@link TracebackStep#traceback(AnnotatedEObject, Set, de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.TracebackCache, Notification)}
 * function for its in-expression, forwarding the <code>source</code> object, the (possibly modified)
 * <code>pendingUnusedEvalRequests</code> and the <code>tracebackCache</code>.
 * 
 * @see AbstractTracebackStep#performSubsequentTraceback(AnnotatedEObject, Set, de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.TracebackCache, Notification)
 */
public class LetTracebackStep extends BranchingTracebackStep<LetExp> {

    public LetTracebackStep(LetExp sourceExpression, EClass context, OperationBodyToCallMapper operationBodyToCallMapper,
            Stack<String> tupleLiteralNamesToLookFor, TracebackStepCache tracebackStepCache, UnusedEvaluationRequestFactory unusedEvaluationRequestFactory, OCLFactory oclFactory) {
        super(sourceExpression, tupleLiteralNamesToLookFor, tracebackStepCache.getOppositeEndFinder(), operationBodyToCallMapper, unusedEvaluationRequestFactory, oclFactory);
        getSteps().add(createTracebackStepAndScopeChange(sourceExpression, (OCLExpression) ((LetExp) sourceExpression).getIn(),
                context, operationBodyToCallMapper, tupleLiteralNamesToLookFor, tracebackStepCache));
    }
}
