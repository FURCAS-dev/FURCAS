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
 * $Id: AbstractIteration.java,v 1.3 2011/01/30 11:07:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.library;


import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.values.CollectionValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;
import org.eclipse.ocl.examples.pivot.values.impl.BagValueImpl;
import org.eclipse.ocl.examples.pivot.values.impl.OrderedSetValueImpl;
import org.eclipse.ocl.examples.pivot.values.impl.SequenceValueImpl;
import org.eclipse.ocl.examples.pivot.values.impl.SetValueImpl;

/**
 * AbstractIteration realises shared characteristics of library iterations.
 * 
 * @since 3.1
 */
public abstract class AbstractIteration<ACC extends Value> extends AbstractFeature implements LibraryIteration
{
	protected CollectionValue.Accumulator createAccumulationValue(ValueFactory valueFactory, boolean isOrdered, boolean isUnique) {
		if (isOrdered) {
			if (isUnique) {
				return new OrderedSetValueImpl.Accumulator(valueFactory);
			}
			else {
				return new SequenceValueImpl.Accumulator(valueFactory);
			}
		}
		else {
			if (isUnique) {
				return new SetValueImpl.Accumulator(valueFactory);
			}
			else {
				return new BagValueImpl.Accumulator(valueFactory);
			}
		}
	}

	public Value evaluate(EvaluationVisitor evaluationVisitor, Value sourceValue, CallExp callExp) {
		CollectionValue collectionValue = sourceValue.asCollectionValue();
		if (collectionValue == null) {
			return evaluationVisitor.getValueFactory().createInvalidValue("non-collection source");
		}
		else if (collectionValue.isUndefined()) {
			return sourceValue.toInvalidValue();
		}
		else {
			return evaluate(evaluationVisitor, collectionValue, (LoopExp) callExp);
		}
	}	
	
	protected Value evaluateIteration(IterationManager<ACC> iterationManager) {
		for ( ; iterationManager.hasCurrent(); iterationManager.advance()) {
			// evaluate the body of the expression in the nested environment
			Value resultVal = updateAccumulator(iterationManager);
			if (resultVal != null) {
				return resultVal;
			}
		}
		return resolveTerminalValue(iterationManager);			
	}


	/**
	 * Return the value appropriate to an iteration over all the source elements. The
	 * default implementation just returns the accumulator. Derived iterations should
	 * override.
	 * 
	 * @param iterationManager the iteration context
	 * @return
	 */
	protected Value resolveTerminalValue(IterationManager<ACC> iterationManager) {
		return iterationManager.getAccumulatorValue();		// FIXME is this safe
	}
	
	/**
	 * Update the accumulatorValue with the bodyValue resulting from the current iteration
	 * for which the iterators define the context in the environment.
	 * 
	 * @param iterationManager the iteration context
	 * @return non-null premature result of iteration, or null if complete
	 */
	protected abstract Value updateAccumulator(IterationManager<ACC> iterationManager);
}
