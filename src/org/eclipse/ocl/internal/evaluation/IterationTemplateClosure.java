/**
 * <copyright>
 *
 * Copyright (c) 2006, 2010 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Bug 297541
 *
 * </copyright>
 *
 * $Id: IterationTemplateClosure.java,v 1.5 2010/01/11 22:28:16 ewillink Exp $
 */

package org.eclipse.ocl.internal.evaluation;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;

/**
 * Instantiation of the iteration template for the <code>closure</code>
 * iterator.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class IterationTemplateClosure<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
		extends IterationTemplate<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> {
	private OCLExpression<C> body;	
	private int depth = 0;
	
	private IterationTemplateClosure(
			EvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> v,
			OCLExpression<C> body) {
		super(v);
		
		this.body = body;
	}
	
	public static<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	IterationTemplate<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> getInstance(
			EvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> v,
			OCLExpression<C> body) {
		return new IterationTemplateClosure<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>(
				v, body);
	}
	
	/**
	 * Recursively evaluates the iterator body expression.
	 */
	@Override
    protected Object evaluateResult(List<Variable<C, PM>> iterators, String resultName, Object bodyVal) {
		// If the body result is invalid then the entire expression's value
		// is invalid, because OCL does not permit invalid in a collection
		if (bodyVal == getInvalid()) {
			setDone(true);
			return getInvalid();
		}
		EvaluationEnvironment<C, O, P, CLS, E> env = getEvalEnvironment();		
		@SuppressWarnings("unchecked")
		Collection<Object> results = (Collection<Object>) env.getValueOf(resultName);
		if (depth > 0) {
			// If there is the parent is the iterator
			String iterName = iterators.get(0).getName();
			Object currObj = env.getValueOf(iterName);
			if (!results.add(currObj)) {
				return results;
			}
		}
		if (bodyVal != null) {
			try {
				depth++;
				Collection<?> bodyColl;
				if (bodyVal instanceof Collection<?>) {
					bodyColl = (Collection<?>) bodyVal;
				}
				else {
					bodyColl = Collections.singleton(bodyVal);
				}
				Object[] iteratorValues = pauseIterators(iterators);
				evaluate(bodyColl, iterators, body, resultName);
				resumeIterators(iterators, iteratorValues);
			}
			finally {
				depth--;
			}
		}
		return results;
	}
	
	/**
	 * Removes the current values of the specified iterators from the
	 * current evaluation environment, to be restored later.  This
	 * protects the recursive invocation of the template from attempting
	 * to rebind the iterator variables.
	 * 
	 * @param iterators the iterators to pause
	 * 
	 * @return the current values of the <code>iterators</code>
	 */
	private Object[] pauseIterators(List<Variable<C, PM>> iterators) {
		Object[] result = new Object[iterators.size()];
		EvaluationEnvironment<C, O, P, CLS, E> env = getEvalEnvironment();
		
		for (int i = 0, n = result.length; i < n; i++) {
			Variable<C, PM> iterDecl = iterators.get(i);
			
			result[i] = env.remove(iterDecl.getName());
		}
		
		return result;
	}
	
	/**
	 * Restores the current values of the specified iterators to the
	 * current evaluation environment.
	 * 
	 * @param iterators the iterators to resume
	 * @param values the iterator values to restore
	 */
	private void resumeIterators(List<Variable<C, PM>> iterators, Object[] values) {
		EvaluationEnvironment<C, O, P, CLS, E> env = getEvalEnvironment();
		
		for (int i = 0, n = values.length; i < n; i++) {
			Variable<C, PM> iterDecl = iterators.get(i);
			
			env.add(iterDecl.getName(), values[i]);
		}
	}
}
