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

import java.util.List;

import org.eclipse.emf.ocl.expressions.EvaluationVisitor;
import org.eclipse.emf.ocl.internal.utilities.impl.Bag;
import org.eclipse.emf.ocl.parser.EvaluationEnvironment;

/**
 *
 */
public final class IterationTemplateCollectNested extends IterationTemplate {
	private IterationTemplateCollectNested(EvaluationVisitor v) {
		super(v);
	}
	
	public static IterationTemplate getInstance(EvaluationVisitor v) {
		return new IterationTemplateCollectNested(v);
	}
	
	protected Object evaluateResult(List iterators, String resultName, Object bodyVal) {
		EvaluationEnvironment env = getEvalEnvironment();
		Bag currVal = (Bag)env.getValueOf(resultName);
		currVal.add(bodyVal);
		return currVal;
	}
}
