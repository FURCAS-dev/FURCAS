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
package org.eclipse.ocl.examples.impactanalyzer.deltaPropagation;

import org.eclipse.ocl.ecore.OCLExpression;

public abstract class DeltaPropagationStrategyWithTargetExpressionAndPartialEvaluator extends
        DeltaPropagationStrategyWithTargetExpression {
    private final PartialEvaluatorImpl evaluator;

    protected DeltaPropagationStrategyWithTargetExpressionAndPartialEvaluator(OCLExpression propagatesTo, PartialEvaluatorImpl evaluator) {
        super(propagatesTo);
        this.evaluator = evaluator;
    }
    
    protected PartialEvaluatorImpl getEvaluator() {
        return evaluator;
    }

}
