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
import java.util.Map;

import org.eclipse.emf.ocl.expressions.EvaluationVisitor;
import org.eclipse.emf.ocl.expressions.VariableDeclaration;
import org.eclipse.emf.ocl.parser.EvaluationEnvironment;

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
		String iterName = ((VariableDeclaration)iterators.get(0)).getVarName();
		Object iterVal = env.getValueOf(iterName);
		resultVal.put(iterVal, bodyVal);
		return resultVal;
	}
}
