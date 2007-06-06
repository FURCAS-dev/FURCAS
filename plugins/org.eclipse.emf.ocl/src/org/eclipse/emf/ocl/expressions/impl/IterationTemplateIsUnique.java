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
 * $Id: IterationTemplateIsUnique.java,v 1.3 2007/06/06 18:56:37 cdamus Exp $
 */

package org.eclipse.emf.ocl.expressions.impl;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ocl.expressions.EvaluationVisitor;
import org.eclipse.emf.ocl.parser.EvaluationEnvironment;

/**
 *
 */
public class IterationTemplateIsUnique extends IterationTemplate {
	private IterationTemplateIsUnique(EvaluationVisitor v) {
		super(v);
	}
	
	public static IterationTemplate getInstance(EvaluationVisitor v) {
		return new IterationTemplateIsUnique(v);
	}
	
	protected Object evaluateResult(List iterators, String resultName, Object bodyVal) {
		EvaluationEnvironment env = getEvalEnvironment();
		Set currVal = (Set)env.getValueOf(resultName);
		if (currVal.contains(bodyVal)) {
			setDone(true);
		}
		else
			currVal.add(bodyVal);
		return currVal;
	}
}
