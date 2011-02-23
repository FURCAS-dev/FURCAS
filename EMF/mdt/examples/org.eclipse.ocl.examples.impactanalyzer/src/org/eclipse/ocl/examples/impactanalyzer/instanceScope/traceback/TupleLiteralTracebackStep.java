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

import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.TupleLiteralExp;
import org.eclipse.ocl.examples.impactanalyzer.impl.OperationBodyToCallMapper;
import org.eclipse.ocl.examples.impactanalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestFactory;
import org.eclipse.ocl.examples.impactanalyzer.util.OCLFactory;
import org.eclipse.ocl.expressions.TupleLiteralPart;


public class TupleLiteralTracebackStep extends BranchingTracebackStep<TupleLiteralExp> {

    public TupleLiteralTracebackStep(TupleLiteralExp sourceExpression, EClass context,
            OperationBodyToCallMapper operationBodyToCallMapper, Stack<String> tupleLiteralNamesToLookFor, TracebackStepCache tracebackStepCache, UnusedEvaluationRequestFactory unusedEvaluationRequestFactory, OCLFactory oclFactory) {
        super(sourceExpression, tupleLiteralNamesToLookFor, tracebackStepCache.getOppositeEndFinder(), operationBodyToCallMapper, unusedEvaluationRequestFactory, oclFactory);
        if (tupleLiteralNamesToLookFor != null && !tupleLiteralNamesToLookFor.isEmpty()) {
            String partName = tupleLiteralNamesToLookFor.peek();
            for (TupleLiteralPart<EClassifier, EStructuralFeature> part : sourceExpression.getPart()) {
                if (part.getName().equals(partName)) {
                    Stack<String> clonedTupleLiteralNamesToLookFor = cloneWithTypeCheck(tupleLiteralNamesToLookFor);
                    clonedTupleLiteralNamesToLookFor.pop();
                    getSteps().add(
                            createTracebackStepAndScopeChange(sourceExpression, (OCLExpression) part.getValue(), context,
                                    operationBodyToCallMapper, clonedTupleLiteralNamesToLookFor, tracebackStepCache));
                    break;
                }
            }
        }
        if (getSteps().isEmpty()) {
            throw new RuntimeException("Internal error regarding tuple literal and tuple access nesting: couldn't find requested part "+
                    tupleLiteralNamesToLookFor.peek()+" in tuple parts "+sourceExpression.getPart());
        }
    }
}
