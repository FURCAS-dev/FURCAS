/**
 * <copyright>
 *
 * Copyright (c) 2006 IBM Corporation and others.
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
 * $Id: IterationTemplateClosure.java,v 1.3 2007/10/11 23:05:17 cdamus Exp $
 */

package org.eclipse.emf.ocl.expressions.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ocl.expressions.EvaluationVisitor;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.Variable;
import org.eclipse.emf.ocl.parser.EvaluationEnvironment;
import org.eclipse.emf.ocl.types.impl.CollectionTypeImpl;
import org.eclipse.emf.ocl.types.util.Types;

/**
 * Instantiation of the iteration template for the <code>closure</code>
 * iterator.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class IterationTemplateClosure extends IterationTemplate {
	private OCLExpression body;
	
	private IterationTemplateClosure(EvaluationVisitor v, OCLExpression body) {
		super(v);
		
		this.body = body;
	}
	
	public static IterationTemplate getInstance(EvaluationVisitor v, OCLExpression body) {
		return new IterationTemplateClosure(v, body);
	}
	
	/**
	 * Recursively evaluates the iterator body expression.
	 */
	@Override
    protected Object evaluateResult(List iterators, String resultName, Object bodyVal) {
		EvaluationEnvironment env = getEvalEnvironment();
		Set currVal = (Set) env.getValueOf(resultName);
		
		// If the body result is invalid then the entire expression's value
		// is invalid, because OCL does not permit OclInvalid in a collection
		if (bodyVal == Types.OCL_INVALID) {
			setDone(true);
			return Types.OCL_INVALID;
		}
		
		Collection newResults = CollectionTypeImpl.createNewSet();
		
		if (bodyVal instanceof Collection) {
			Collection bodyColl = (Collection) bodyVal;
			
			for (Iterator iter = bodyColl.iterator(); iter.hasNext();) {
				Object next = iter.next();
				
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
	private Object[] pauseIterators(List iterators) {
		Object[] result = new Object[iterators.size()];
		EvaluationEnvironment env = getEvalEnvironment();
		
		for (int i = 0, n = result.length; i < n; i++) {
			Variable iterDecl = (Variable) iterators.get(i);
			
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
	private void resumeIterators(List iterators, Object[] values) {
		EvaluationEnvironment env = getEvalEnvironment();
		
		for (int i = 0, n = values.length; i < n; i++) {
			Variable iterDecl = (Variable) iterators.get(i);
			
			env.add(iterDecl.getName(), values[i]);
		}
	}
}
