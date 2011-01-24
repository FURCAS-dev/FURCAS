/**
 * <copyright>
 *
 * Copyright (c) 2009,2010 E.D.Willink and others.
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
 * $Id: OneIteration.java,v 1.2 2011/01/24 19:56:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.iterator;

import org.eclipse.ocl.examples.library.AbstractIteration;
import org.eclipse.ocl.examples.library.IterationManager;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.values.CollectionValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * OneIteration realises the Collection::one() library iteration.
 * 
 * @since 3.1
 */
public class OneIteration extends AbstractIteration<CollectionValue.Accumulator>
{
	public static final OneIteration INSTANCE = new OneIteration();

	public Value evaluate(EvaluationVisitor evaluationVisitor, CollectionValue sourceVal, LoopExp iteratorExp) {
		ValueFactory valueFactory = evaluationVisitor.getValueFactory();
		CollectionValue.Accumulator accumulatorValue = createAccumulationValue(valueFactory, true, false);
		return evaluateIteration(new IterationManager<CollectionValue.Accumulator>(evaluationVisitor,
				iteratorExp, sourceVal, accumulatorValue));
	}
	
	@Override
	protected Value resolveTerminalValue(IterationManager<CollectionValue.Accumulator> iterationManager) {
		CollectionValue.Accumulator accumulatorValue = iterationManager.getAccumulatorValue();
		return accumulatorValue.notEmpty();
	}
	
	@Override
    protected Value updateAccumulator(IterationManager<CollectionValue.Accumulator> iterationManager) {
		CollectionValue.Accumulator accumulatorValue = iterationManager.getAccumulatorValue();
		Value bodyVal = iterationManager.getBodyValue();		
		if (bodyVal.isUndefined()) {
			return bodyVal.toInvalidValue();				// Null body is invalid
		}
		else if (bodyVal.isFalse()) {
			return null;									// Carry on for nothing found
		}
		else if (accumulatorValue.notEmpty().isTrue()) {
			return iterationManager.getFalse();				// Abort after second find
		}
		else {
			// should be exactly one iterator
			Value value = iterationManager.get(0);		
			accumulatorValue.add(value);
			return null;									// Carry on after first find
		}
	}
}
