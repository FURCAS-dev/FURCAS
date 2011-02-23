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
import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OppositePropertyCallExp;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.examples.impactanalyzer.impl.OperationBodyToCallMapper;
import org.eclipse.ocl.examples.impactanalyzer.instanceScope.InstanceScopeAnalysis;
import org.eclipse.ocl.examples.impactanalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestFactory;
import org.eclipse.ocl.examples.impactanalyzer.util.OCLFactory;


public class TracebackStepCacheWithHiddenOpposites extends TracebackStepCache {
    public TracebackStepCacheWithHiddenOpposites(OppositeEndFinder oppositeEndFinder, InstanceScopeAnalysis instanceScopeAnalysis) {
        super(oppositeEndFinder, new UnusedEvaluationRequestFactory(), instanceScopeAnalysis);
    }

    @Override
    protected TracebackStep createStep(OCLExpression sourceExpression, EClass context,
            OperationBodyToCallMapper operationBodyToCallMapper, Stack<String> tupleLiteralNamesToLookFor, OCLFactory oclFactory) {
        TracebackStep result;
        switch (sourceExpression.eClass().getClassifierID()) {
        case EcorePackage.OPPOSITE_PROPERTY_CALL_EXP:
            result = new OppositePropertyCallTracebackStep((OppositePropertyCallExp) sourceExpression, context, operationBodyToCallMapper, tupleLiteralNamesToLookFor, this, getUnusedEvaluationRequestFactory(), oclFactory);
            break;
        default:
            result = super.createStep(sourceExpression, context, operationBodyToCallMapper, tupleLiteralNamesToLookFor, oclFactory);
        }
        return result;
    }
}
