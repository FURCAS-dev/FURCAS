/**
 * <copyright>
 *
 * Copyright (c) 2009,2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: IterateIteration.java,v 1.5 2011/05/07 16:41:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.iterator;

import org.eclipse.ocl.examples.library.AbstractIteration;
import org.eclipse.ocl.examples.library.IterationManager;
import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.pivot.values.CollectionValue;
import org.eclipse.ocl.examples.pivot.values.Value;

/**
 * IsUniqueIteration realizes the Collection::isUnique() library iteration.
 * 
 * @since 3.1
 */
public class IterateIteration extends AbstractIteration<Value>
{
	public static final IterateIteration INSTANCE = new IterateIteration();

	public Value evaluate(EvaluationVisitor evaluationVisitor, CollectionValue sourceVal, LoopExp iterateExp) throws InvalidValueException {
		Variable accumulator = ((IterateExp)iterateExp).getResult();
		Value initValue = accumulator.getInitExpression().accept(evaluationVisitor);
		if (initValue.isUndefined()) {
			return evaluationVisitor.throwInvalidEvaluation(null, iterateExp, initValue, EvaluatorMessages.UndefinedInitialiser);
		}
//		CollectionValue accumulatorValue = initValue.asCollectionValue();
		return evaluateIteration(new IterationManager<Value>(evaluationVisitor,
				iterateExp, sourceVal, initValue));
	}

	@Override
    protected Value updateAccumulator(IterationManager<Value> iterationManager) {
		Value bodyVal = iterationManager.getBodyValue();		
		iterationManager.replaceAccumulator(bodyVal);		
		return null;					// carry on
	}
}
