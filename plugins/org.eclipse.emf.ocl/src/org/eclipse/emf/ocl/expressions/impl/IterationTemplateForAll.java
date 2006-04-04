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
 * $Id: IterationTemplateForAll.java,v 1.1 2006/04/04 18:09:04 cdamus Exp $
 */

package org.eclipse.emf.ocl.expressions.impl;

import java.util.List;

import org.eclipse.emf.ocl.expressions.EvaluationVisitor;
import org.eclipse.emf.ocl.parser.EvaluationEnvironment;

/**
 *
 */
public final class IterationTemplateForAll extends IterationTemplate {
	private IterationTemplateForAll(EvaluationVisitor v) {
		super(v);
	}
	
	public static IterationTemplate getInstance(EvaluationVisitor v) {
		return new IterationTemplateForAll(v);
	}
	
	protected Object evaluateResult(List iterators, String resultName, Object body) {
		EvaluationEnvironment env = getEvalEnvironment();
		Boolean currVal = (Boolean)env.getValueOf(resultName);
		Boolean bodyVal = (Boolean)body;
		// check for undefined result:
		// the current result value cannot be false since the short-circuit
		// "isDone" mechanism below would have caused the evaluation to stop.
		// If the body result is undefined then regardless of whether the
		// current result is true or undefined the new result will be undefined
		// but we must keep evaluating because it is still possible that it
		// could be false.
		if (body == null)
			return null;
		boolean resultVal = currVal.booleanValue() && bodyVal.booleanValue();
		if (!resultVal)
			setDone(true);
		return resultVal ? Boolean.TRUE : Boolean.FALSE;
	}
}
