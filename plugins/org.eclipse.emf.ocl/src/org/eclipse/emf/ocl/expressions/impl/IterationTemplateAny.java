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
 * $Id: IterationTemplateAny.java,v 1.5 2007/10/11 23:05:17 cdamus Exp $
 */

package org.eclipse.emf.ocl.expressions.impl;

import java.util.List;

import org.eclipse.emf.ocl.expressions.EvaluationVisitor;
import org.eclipse.emf.ocl.expressions.Variable;
import org.eclipse.emf.ocl.parser.EvaluationEnvironment;
import org.eclipse.emf.ocl.types.util.Types;

/**
 *
 */
public class IterationTemplateAny extends IterationTemplate {
	private IterationTemplateAny(EvaluationVisitor v) {
		super(v);
	}
	
	public static IterationTemplate getInstance(EvaluationVisitor v) {
		return new IterationTemplateAny(v);
	}
	
	@Override
    protected Object evaluateResult(List iterators, String resultName, Object bodyVal) {
		EvaluationEnvironment env = getEvalEnvironment();
		// should be exactly one iterator
		String iterName = ((Variable)iterators.get(0)).getName();
		Object currObj = env.getValueOf(iterName);
		Object resultVal = null;
		
		// If the body result is undefined then the entire expression's value
		// is invalid
		if ((bodyVal == null) || (bodyVal == Types.OCL_INVALID)) {
			setDone(true);
			return Types.OCL_INVALID;
		}
		
		boolean bodyCond = ((Boolean)bodyVal).booleanValue();
		if (bodyCond) {
			resultVal = currObj;
			setDone(true);
		}
		return resultVal;
	}
}
