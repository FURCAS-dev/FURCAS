/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
 * $Id: IterationManager.java,v 1.3 2011/01/30 11:07:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.library;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.values.CollectionValue;
import org.eclipse.ocl.examples.pivot.values.InvalidValue;
import org.eclipse.ocl.examples.pivot.values.Value;

public class IterationManager<ACC extends Value>
{
	private class ValueIterator
	{		// FIXME Make this a delegating value so that evalEnv can update in place
		private final VariableDeclaration variable;
		private Iterator<Value> javaIter;
		private Value value = null;

		public ValueIterator(VariableDeclaration variable) {
			this.variable = variable;
			reset();
		}
		
		public Value get() {
			return value;
		}

		public boolean hasCurrent() {
			return value != null;
		}
		
		public Value next() {
			if (!javaIter.hasNext()) {
				value = null;
			}
			else {
				value = javaIter.next();
				evaluationVisitor.getEvaluationEnvironment().replace(variable, value);
//				System.out.println(name + " = " + value);
			}
			return value;
		}

		public Value reset() {
			javaIter = collectionValue.iterator();
			return next();
		}
	}
	
	private final int depth;
	private final EvaluationVisitor evaluationVisitor;
	private final CollectionValue collectionValue;
	private final OclExpression body;
	private ACC accumulatorValue;
	private final VariableDeclaration accumulatorVariable;
	private final List<Parameter> referredIterators;
	private final List<ValueIterator> iterators;
	
	public IterationManager(EvaluationVisitor evaluationVisitor, LoopExp iteratorExp,
			CollectionValue collectionValue, ACC accumulatorValue) {
		this.depth = 0;
		this.evaluationVisitor = evaluationVisitor.createNestedVisitor();
		this.collectionValue = collectionValue;
		this.body = iteratorExp.getBody();
		this.accumulatorValue = accumulatorValue;
		if (iteratorExp instanceof IterateExp) {
			this.accumulatorVariable = ((IterateExp)iteratorExp).getResult().getRepresentedParameter();
			getEvaluationEnvironment().add(accumulatorVariable, accumulatorValue);
		}
		else {
			this.accumulatorVariable = null;
		}
		this.referredIterators = iteratorExp.getReferredIteration().getOwnedIterators();
		this.iterators = new ArrayList<ValueIterator>(referredIterators.size());
		for (Parameter referredIterator : referredIterators) {
			this.iterators.add(new ValueIterator(referredIterator));
		}
	}

	public IterationManager(IterationManager<ACC> iterationManager, Value value) {
		this.depth = iterationManager.depth+1;
		this.evaluationVisitor = iterationManager.evaluationVisitor;
		this.body = iterationManager.body;
		if (value instanceof CollectionValue) {
			this.collectionValue = (CollectionValue) value;
		}
		else {
			this.collectionValue = evaluationVisitor.getValueFactory().createSequenceValue(value);
		}
		this.accumulatorValue = iterationManager.accumulatorValue;
		this.accumulatorVariable = iterationManager.accumulatorVariable;
		this.referredIterators = iterationManager.referredIterators;
		this.iterators = new ArrayList<ValueIterator>(referredIterators.size());
		for (Parameter referredIterator : referredIterators) {
			this.iterators.add(new ValueIterator(referredIterator));
		}
	}
	
	public void advance() {			
		int curr = getNextUnfinishedIterator();				
		for (int i = 0; i < iterators.size(); i++) {
			ValueIterator iterator = iterators.get(i);			
			if (i < curr) {
				iterator.reset();
			}
			else if (i == curr) {
				iterator.next();
			}
			else {
				iterator.get();
			}
		}
	}

	public InvalidValue createInvalidValue(String string) {
		return evaluationVisitor.getValueFactory().createInvalidValue(string);
	}

	public Value get(int i) {
		return iterators.get(0).get();		
	}

	public ACC getAccumulatorValue() {
		return accumulatorValue;
	}

	public Value getBodyValue() {
		return body.accept(evaluationVisitor);
	}
	
	public CollectionValue getCollectionValue() {
		return collectionValue;
	}

	public EvaluationEnvironment getEvaluationEnvironment() {
		return evaluationVisitor.getEvaluationEnvironment();
	}

	public Value getFalse() {
		return evaluationVisitor.getValueFactory().getFalse();
	}
	
	private int getNextUnfinishedIterator() {
		int curr;
		int numIters = iterators.size();
		for (curr = 0; curr < numIters; curr++)
			if (iterators.get(curr).hasCurrent())
				break;
		return curr;
	}

	public Value getTrue() {
		return evaluationVisitor.getValueFactory().getTrue();
	}
	
	public boolean hasCurrent() {
		int curr = getNextUnfinishedIterator();				
		return curr < iterators.size();
	}
	
	public boolean isOuterIteration() {
		return depth == 0;
	}

	/**
	 * Associate a new value with the accumulator.
	 * <p>
	 * This is only used by an "iterate" where the accumulator takes on arbitrary
	 * values. Other iterations have an updating accumulator value.
	 * 
	 * @param accumulatorValue
	 */
	public void replaceAccumulator(ACC accumulatorValue) {
		this.accumulatorValue = accumulatorValue;
		if (accumulatorVariable != null) {
			getEvaluationEnvironment().replace(accumulatorVariable, accumulatorValue);
		}
	}

	@Override
	public String toString() {
		return body.eContainer().toString();
	}
}