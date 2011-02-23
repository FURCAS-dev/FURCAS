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

import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.ecore.CollectionItem;
import org.eclipse.ocl.ecore.CollectionLiteralExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.examples.impactanalyzer.impl.OperationBodyToCallMapper;
import org.eclipse.ocl.examples.impactanalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestFactory;
import org.eclipse.ocl.examples.impactanalyzer.util.AnnotatedEObject;
import org.eclipse.ocl.examples.impactanalyzer.util.OCLFactory;
import org.eclipse.ocl.expressions.CollectionLiteralPart;


/**
 * When a {@link CollectionLiteralExp} is traced back, it calls the
 * {@link TracebackStep#traceback(AnnotatedEObject, Set, org.eclipse.ocl.examples.impactanalyzer.instanceScope.traceback.TracebackCache, Notification)} function for the item of those parts, which are
 * instance of {@link CollectionItem}, forwarding the <code>source</code> object, the (possibly modified)
 * <code>pendingUnusedEvalRequests</code> and the <code>tracebackCache</code>.
 * 
 * @see AbstractTracebackStep#performSubsequentTraceback(AnnotatedEObject, Set, org.eclipse.ocl.examples.impactanalyzer.instanceScope.traceback.TracebackCache, Notification)
 */
public class CollectionLiteralTracebackStep extends BranchingTracebackStep<CollectionLiteralExp> {
    public CollectionLiteralTracebackStep(CollectionLiteralExp sourceExpression, EClass context,
            OperationBodyToCallMapper operationBodyToCallMapper, Stack<String> tupleLiteralNamesToLookFor, TracebackStepCache tracebackStepCache, UnusedEvaluationRequestFactory unusedEvaluationRequestFactory, OCLFactory oclFactory) {
        super(sourceExpression, tupleLiteralNamesToLookFor, tracebackStepCache.getOppositeEndFinder(), operationBodyToCallMapper, unusedEvaluationRequestFactory, oclFactory);
        for (CollectionLiteralPart<EClassifier> part : ((CollectionLiteralExp) sourceExpression).getPart()) {
            if (part instanceof CollectionItem) {
                OCLExpression item = (OCLExpression) ((CollectionItem) part).getItem();
                getSteps().add(createTracebackStepAndScopeChange(sourceExpression, item, context, operationBodyToCallMapper,
                        tupleLiteralNamesToLookFor, tracebackStepCache));
            }
        }
    }
}
