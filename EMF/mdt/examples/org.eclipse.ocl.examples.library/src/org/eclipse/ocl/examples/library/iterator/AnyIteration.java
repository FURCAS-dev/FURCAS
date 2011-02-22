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
 * $Id: AnyIteration.java,v 1.3 2011/02/21 08:37:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.iterator;

import org.eclipse.ocl.examples.library.AbstractIteration;
import org.eclipse.ocl.examples.library.IterationManager;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.values.CollectionValue;
import org.eclipse.ocl.examples.pivot.values.CollectionValue.Accumulator;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * AnyIteration realises the Collection::any() library iteration.
 * 
 * @since 3.1
 */
public class AnyIteration extends AbstractIteration<CollectionValue.Accumulator>
{
	public static final AnyIteration INSTANCE = new AnyIteration();

	public Value evaluate(EvaluationVisitor evaluationVisitor, CollectionValue sourceVal, LoopExp iteratorExp) {
		ValueFactory valueFactory = evaluationVisitor.getValueFactory();
		Accumulator accumulatorValue = createAccumulationValue(valueFactory, true, false);
		return evaluateIteration(new IterationManager<CollectionValue.Accumulator>(evaluationVisitor,
				iteratorExp, sourceVal, accumulatorValue));
	}
	
	@Override
	protected Value resolveTerminalValue(IterationManager<CollectionValue.Accumulator> iterationManager) {
		CollectionValue.Accumulator accumulatorValue = iterationManager.getAccumulatorValue();
		if (accumulatorValue.intSize() > 0) {
			return accumulatorValue.asList().get(0);		// Normal something found result.
		}
		else {
			return iterationManager.getValueFactory().getNull();
		}
	}
	
	@Override
    protected Value updateAccumulator(IterationManager<CollectionValue.Accumulator> iterationManager) {
		CollectionValue.Accumulator accumulatorValue = iterationManager.getAccumulatorValue();
		Value bodyVal = iterationManager.getBodyValue();		
		if (bodyVal.isUndefined()) {
			return iterationManager.throwInvalidEvaluation("null body"); 	// Null body is invalid
		}
		else if (bodyVal.isFalse()) {
			return null;									// Carry on for nothing found
		}
		else if (accumulatorValue.intSize() > 0) {
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
