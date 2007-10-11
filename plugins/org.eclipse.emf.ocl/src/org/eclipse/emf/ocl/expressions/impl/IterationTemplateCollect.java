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
 * $Id: IterationTemplateCollect.java,v 1.5 2007/10/11 23:05:16 cdamus Exp $
 */

package org.eclipse.emf.ocl.expressions.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ocl.expressions.EvaluationVisitor;
import org.eclipse.emf.ocl.parser.EvaluationEnvironment;
import org.eclipse.emf.ocl.types.util.Types;

/**
 *
 */
public class IterationTemplateCollect extends IterationTemplate {
	private IterationTemplateCollect(EvaluationVisitor v) {
		super(v);
	}
	
	public static IterationTemplate getInstance(EvaluationVisitor v) {
		return new IterationTemplateCollect(v);
	}
	
	@Override
    protected Object evaluateResult(List iterators, String resultName, Object bodyVal) {
		EvaluationEnvironment env = getEvalEnvironment();
		Collection currVal = (Collection)env.getValueOf(resultName);
		
		// If the body result is invalid then the entire expression's value
		// is invalid, because OCL does not permit OclInvalid in a collection
		if (bodyVal == Types.OCL_INVALID) {
			setDone(true);
			return Types.OCL_INVALID;
		}
		
		if (bodyVal instanceof Collection) {
			Collection bodyColl = (Collection)bodyVal;
			currVal.addAll(bodyColl);
		}
		else
			currVal.add(bodyVal);
		return currVal;
	}
}
