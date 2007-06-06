/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2007 IBM Corporation and others.
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
 * $Id: IterationTemplateSortedBy.java,v 1.4 2007/06/06 18:56:37 cdamus Exp $
 */

package org.eclipse.emf.ocl.expressions.impl;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ocl.expressions.EvaluationVisitor;
import org.eclipse.emf.ocl.expressions.Variable;
import org.eclipse.emf.ocl.parser.EvaluationEnvironment;
import org.eclipse.emf.ocl.types.util.Types;

/**
 *
 */
public class IterationTemplateSortedBy extends IterationTemplate {
	private IterationTemplateSortedBy(EvaluationVisitor v) {
		super(v);
	}
	
	public static IterationTemplate getInstance(EvaluationVisitor v) {
		return new IterationTemplateSortedBy(v);
	}
	
	protected Object evaluateResult(List iterators, String resultName, Object bodyVal) {
		EvaluationEnvironment env = getEvalEnvironment();
		Map resultVal = (Map)env.getValueOf(resultName);
		// must have exactly one iterator
		String iterName = ((Variable)iterators.get(0)).getName();
		Object iterVal = env.getValueOf(iterName);
		
		// check for undefined result:
		// the current result value cannot be true since the short-circuit
		// "isDone" mechanism below would have caused the evaluation to stop.
		// If the body result is undefined then the entire expression's value
		// is invalid
		if ((bodyVal == null) || (bodyVal == Types.OCL_INVALID)) {
			setDone(true);
			return Types.OCL_INVALID;
		}
		
		resultVal.put(iterVal, bodyVal);
		return resultVal;
	}
}
