/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: IterationTemplateOne.java,v 1.3 2007/02/14 14:45:40 cdamus Exp $
 */

package org.eclipse.emf.ocl.expressions.impl;

import java.util.List;

import org.eclipse.emf.ocl.expressions.EvaluationVisitor;
import org.eclipse.emf.ocl.parser.EvaluationEnvironment;
import org.eclipse.emf.ocl.types.util.Types;

/**
 *
 */
public class IterationTemplateOne
	extends IterationTemplate {

	private IterationTemplateOne(EvaluationVisitor v) {
		super(v);
	}

	public static IterationTemplate getInstance(EvaluationVisitor v) {
		return new IterationTemplateOne(v);
	}

	protected Object evaluateResult(List iterators, String resultName,
		Object body) {
		EvaluationEnvironment env = getEvalEnvironment();
		// should be exactly one iterator
		//		String iterName = ((VariableDeclaration)iterators.get(0)).getVarName();
		//		Object currObj = env.getValueOf(iterName);
		Boolean resultVal = (Boolean) env.getValueOf(resultName);

		// If the body result is undefined then the entire expression's value
		// is invalid
		if ((body == null) || (body == Types.OCL_INVALID)) {
			setDone(true);
			return Types.OCL_INVALID;
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
