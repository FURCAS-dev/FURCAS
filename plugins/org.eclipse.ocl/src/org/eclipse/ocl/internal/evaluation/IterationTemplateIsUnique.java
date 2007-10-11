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
 * $Id: IterationTemplateIsUnique.java,v 1.2 2007/10/11 23:05:05 cdamus Exp $
 */

package org.eclipse.ocl.internal.evaluation;

import java.util.List;
import java.util.Set;

import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.expressions.Variable;

/**
 *
 */
public class IterationTemplateIsUnique<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
		extends IterationTemplate<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> {
	
	private IterationTemplateIsUnique(
			EvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> v) {
		super(v);
	}
	
	public static<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	IterationTemplate<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> getInstance(
			EvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> v) {
		return new IterationTemplateIsUnique<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>(v);
	}
	
	@Override
    protected Object evaluateResult(List<Variable<C, PM>> iterators, String resultName, Object bodyVal) {
		EvaluationEnvironment<C, O, P, CLS, E> env = getEvalEnvironment();
		
		@SuppressWarnings("unchecked")
		Set<Object> currVal = (Set<Object>) env.getValueOf(resultName);
		if (currVal.contains(bodyVal)) {
			setDone(true);
		}
		else
			currVal.add(bodyVal);
		return currVal;
	}
}
