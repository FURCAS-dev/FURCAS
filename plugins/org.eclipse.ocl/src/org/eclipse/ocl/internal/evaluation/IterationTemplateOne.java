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
 * $Id: IterationTemplateOne.java,v 1.2 2007/10/11 23:05:05 cdamus Exp $
 */

package org.eclipse.ocl.internal.evaluation;

import java.util.List;

import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.expressions.Variable;

/**
 *
 */
public class IterationTemplateOne<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
		extends IterationTemplate<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> {

	private IterationTemplateOne(
			EvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> v) {
		super(v);
	}

	public static<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	IterationTemplate<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	getInstance(EvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> v) {
		return new IterationTemplateOne<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>(v);
	}

	@Override
    protected Object evaluateResult(List<Variable<C, PM>> iterators, String resultName,
		Object body) {
		EvaluationEnvironment<C, O, P, CLS, E> env = getEvalEnvironment();
		// should be exactly one iterator
		//		String iterName = ((VariableDeclaration)iterators.get(0)).getVarName();
		//		Object currObj = env.getValueOf(iterName);
		Boolean resultVal = (Boolean) env.getValueOf(resultName);

		// If the body result is undefined then the entire expression's value
		// is invalid
		if ((body == null) || (body == getOclInvalid())) {
			setDone(true);
			return getOclInvalid();
		}
		
		Boolean bodyVal = (Boolean) body;

		boolean bodyCond = bodyVal.booleanValue();
		if (bodyCond) {
			if (!foundOne) {
				// if this is the first element satsifying the body condition
				// make a note of it.
				foundOne = true;
				return Boolean.TRUE;
			} else {
				// this is the second satisfying element.  The result is false
				// and we can stop iterating.
				setDone(true);
				return Boolean.FALSE;
			}
		}
		return resultVal.booleanValue() ? Boolean.TRUE : Boolean.FALSE;
	}

	private boolean foundOne = false;
}