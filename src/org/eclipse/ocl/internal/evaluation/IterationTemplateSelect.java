/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
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
 * $Id: IterationTemplateSelect.java,v 1.5 2010/02/03 19:54:13 ewillink Exp $
 */

package org.eclipse.ocl.internal.evaluation;

import java.util.Collection;
import java.util.List;

import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.expressions.Variable;

/**
 *
 */
public class IterationTemplateSelect<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
		extends IterationTemplate<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> {

	private IterationTemplateSelect(
			EvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> v) {
		super(v);
	}

	public static<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	IterationTemplate<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> getInstance(
			EvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> v) {
		return new IterationTemplateSelect<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>(v);
	}

	@Override
    protected Object evaluateResult(List<Variable<C, PM>> iterators, String resultName, Object body) {
		EvaluationEnvironment<C, O, P, CLS, E> env = getEvalEnvironment();
		
		// should be exactly one iterator
		String iterName = iterators.get(0).getName();
		Object currObj = env.getValueOf(iterName);
		
		@SuppressWarnings("unchecked")
		Collection<Object> resultVal = (Collection<Object>) env.getValueOf(resultName);
		
		// check for undefined result:
		// the current result value cannot be true since the short-circuit
		// "isDone" mechanism below would have caused the evaluation to stop.
		// If the body result is undefined then the entire expression's value
		// is invalid
		if ((body == null) || (body == getInvalid())) {
			setDone(true);
			return getInvalid();
		}
		
		Boolean bodyVal = (Boolean)body;
		boolean bodyCond = bodyVal.booleanValue();
		if (bodyCond)
			resultVal.add(currObj);
		return resultVal;
	}
}
