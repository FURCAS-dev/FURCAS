/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
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
 * $Id$
 */

package org.eclipse.emf.ocl.expressions.internal.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ocl.expressions.EvaluationVisitor;
import org.eclipse.emf.ocl.expressions.VariableDeclaration;
import org.eclipse.emf.ocl.parser.EvaluationEnvironment;

/**
 *
 */
public class IterationTemplateReject extends IterationTemplate {
	private IterationTemplateReject(EvaluationVisitor v) {
		super(v);
	}
	
	public static IterationTemplate getInstance(EvaluationVisitor v) {
		return new IterationTemplateReject(v);
	}
	
	protected Object evaluateResult(List iterators, String resultName, Object body) {
		EvaluationEnvironment env = getEvalEnvironment();
		// should be exactly one iterator
		String iterName = ((VariableDeclaration)iterators.get(0)).getVarName();
		Object currObj = env.getValueOf(iterName);
		Collection resultVal = (Collection)env.getValueOf(resultName);
		Boolean bodyVal = (Boolean)body;
		if (bodyVal == null)
			return resultVal;
		boolean bodyCond = bodyVal.booleanValue();
		if (!bodyCond)
			resultVal.add(currObj);
		return resultVal;
	}
}
