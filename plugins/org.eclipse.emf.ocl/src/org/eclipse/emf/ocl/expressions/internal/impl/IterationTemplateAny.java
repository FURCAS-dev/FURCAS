/******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.emf.ocl.expressions.internal.impl;

import java.util.List;

import org.eclipse.emf.ocl.expressions.EvaluationVisitor;
import org.eclipse.emf.ocl.expressions.VariableDeclaration;
import org.eclipse.emf.ocl.parser.EvaluationEnvironment;

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
	
	protected Object evaluateResult(List iterators, String resultName, Object bodyVal) {
		EvaluationEnvironment env = getEvalEnvironment();
		// should be exactly one iterator
		String iterName = ((VariableDeclaration)iterators.get(0)).getVarName();
		Object currObj = env.getValueOf(iterName);
		Object resultVal = null;
		
		// if body evaluation is undefined then the result is undefined
		if (bodyVal == null)
			return null;
		boolean bodyCond = ((Boolean)bodyVal).booleanValue();
		if (bodyCond) {
			resultVal = currObj;
			setDone(true);
		}
		return resultVal;
	}
}
