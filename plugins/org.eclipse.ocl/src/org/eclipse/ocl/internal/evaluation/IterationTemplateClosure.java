/**
 * <copyright>
 *
 * Copyright (c) 2006, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: IterationTemplateClosure.java,v 1.2 2007/10/11 23:05:05 cdamus Exp $
 */

package org.eclipse.ocl.internal.evaluation;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.util.CollectionUtil;


/**
 * Instantiation of the iteration template for the <code>closure</code>
 * iterator.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class IterationTemplateClosure<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
		extends IterationTemplate<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> {
	private OCLExpression<C> body;
	
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
		EvaluationEnvironment<C, O, P, CLS, E> env = getEvalEnvironment();
		
		@SuppressWarnings("unchecked")
		Set<Object> currVal = (Set<Object>) env.getValueOf(resultName);
		
		// If the body result is invalid then the entire expression's value
		// is invalid, because OCL does not permit OclInvalid in a collection
		if (bodyVal == getOclInvalid()) {
			setDone(true);
			return getOclInvalid();
		}
		
		Collection<Object> newResults = CollectionUtil.createNewSet();
		
		if (bodyVal instanceof Collection) {
			Collection<?> bodyColl = (Collection<?>) bodyVal;
			
			for (Object next : bodyColl) {
				if ((next != null) && currVal.add(next)) {
					newResults.add(next);
				}
			}
		} else if ((bodyVal != null) && currVal.add(bodyVal)) {
			newResults.add(bodyVal);
		}
		
		if (!newResults.isEmpty()) {
			// recurse over the new results
			Object[] iteratorValues = pauseIterators(iterators);
			evaluate(newResults, iterators, body, resultName);
			resumeIterators(iterators, iteratorValues);
		}
		
		return currVal;
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
