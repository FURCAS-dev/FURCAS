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
 * $Id: IsUniqueIteration.java,v 1.3 2011/02/21 08:37:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.iterator;

import org.eclipse.ocl.examples.library.AbstractIteration;
import org.eclipse.ocl.examples.library.IterationManager;
import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.values.CollectionValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * IsUniqueIteration realises the Collection::isUnique() library iteration.
 * 
 * @since 3.1
 */
public class IsUniqueIteration extends AbstractIteration<CollectionValue.Accumulator>
{
	public static final IsUniqueIteration INSTANCE = new IsUniqueIteration();

	public Value evaluate(EvaluationVisitor evaluationVisitor, CollectionValue sourceVal, LoopExp iteratorExp) {
		ValueFactory valueFactory = evaluationVisitor.getValueFactory();
		CollectionValue.Accumulator accumulatorValue = createAccumulationValue(valueFactory, true, false);
		return evaluateIteration(new IterationManager<CollectionValue.Accumulator>(evaluationVisitor,
				iteratorExp, sourceVal, accumulatorValue));
	}
	
	@Override
	protected Value resolveTerminalValue(IterationManager<CollectionValue.Accumulator> iterationManager) {
		return iterationManager.getTrue();
	}
	
	@Override
    protected Value updateAccumulator(IterationManager<CollectionValue.Accumulator> iterationManager) {
		CollectionValue.Accumulator accumulatorValue = iterationManager.getAccumulatorValue();
		Value bodyVal = iterationManager.getBodyValue();		
		try {
			if (accumulatorValue.includes(bodyVal).isTrue()) {
				return iterationManager.getFalse();		// Abort after second find
			}
			else {
				accumulatorValue.add(bodyVal);
				return null;						// Carry on after first find
			}
		} catch (InvalidValueException e) {
			return iterationManager.throwInvalidEvaluation(e);
		}
	}
}
