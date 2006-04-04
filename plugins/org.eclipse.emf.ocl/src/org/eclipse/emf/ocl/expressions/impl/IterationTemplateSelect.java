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
 * $Id: IterationTemplateSelect.java,v 1.1 2006/04/04 18:09:03 cdamus Exp $
 */

package org.eclipse.emf.ocl.expressions.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ocl.expressions.EvaluationVisitor;
import org.eclipse.emf.ocl.expressions.Variable;
import org.eclipse.emf.ocl.parser.EvaluationEnvironment;

/**
 *
 */
public final class IterationTemplateSelect extends IterationTemplate {
	private IterationTemplateSelect(EvaluationVisitor v) {
		super(v);
	}
	
	public static IterationTemplate getInstance(EvaluationVisitor v) {
		return new IterationTemplateSelect(v);
	}
	
	protected Object evaluateResult(List iterators, String resultName, Object body) {
		EvaluationEnvironment env = getEvalEnvironment();
		// should be exactly one iterator
		String iterName = ((Variable)iterators.get(0)).getName();
		Object currObj = env.getValueOf(iterName);
		Collection resultVal = (Collection)env.getValueOf(resultName);
		Boolean bodyVal = (Boolean)body;
		if (bodyVal == null)
			return resultVal;
		boolean bodyCond = bodyVal.booleanValue();
		if (bodyCond)
			resultVal.add(currObj);
		return resultVal;
	}
}
