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
 * $Id: IterateIteration.java,v 1.2 2011/01/24 19:56:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.iterator;

import org.eclipse.ocl.examples.library.AbstractIteration;
import org.eclipse.ocl.examples.library.IterationManager;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.values.CollectionValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * IsUniqueIteration realizes the Collection::isUnique() library iteration.
 * 
 * @since 3.1
 */
public class IterateIteration extends AbstractIteration<CollectionValue>
{
	public static final IterateIteration INSTANCE = new IterateIteration();

	public Value evaluate(EvaluationVisitor evaluationVisitor, CollectionValue sourceVal, LoopExp iterateExp) {
		ValueFactory valueFactory = evaluationVisitor.getValueFactory();
		Variable accumulator = ((IterateExp)iterateExp).getResult();
		Value initValue = accumulator.getInitExpression().accept(evaluationVisitor);
		if (initValue.isUndefined()) {
			return initValue.toInvalidValue();
		}
		CollectionValue accumulatorValue = initValue.asCollectionValue();
		if (accumulatorValue == null) {
			return valueFactory.createInvalidValue("non-collection accumulator initalizer");
		}
		return evaluateIteration(new IterationManager<CollectionValue>(evaluationVisitor,
					iterateExp, sourceVal, accumulatorValue));
	}

	@Override
    protected Value updateAccumulator(IterationManager<CollectionValue> iterationManager) {
		Value bodyVal = iterationManager.getBodyValue();		
		if (bodyVal.isInvalid()) {
			return bodyVal;				// Invalid body is invalid
		}
		iterationManager.replaceAccumulator((CollectionValue) bodyVal);		
		return null;					// carry on
	}
}
