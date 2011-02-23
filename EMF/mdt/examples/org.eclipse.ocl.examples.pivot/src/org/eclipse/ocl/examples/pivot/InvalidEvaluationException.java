/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: InvalidEvaluationException.java,v 1.1 2011/02/21 08:37:53 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot;

import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;


/**
 * An InvalidEvaluationException is thrown when an Invalid Value arises during
 * an evaluation. It passes the prevailing EvaluationEnvironment to the handler
 * to support diagnosis of the failing context..
 */
public class InvalidEvaluationException extends EvaluationException
{
	private static final long serialVersionUID = 1L;

	protected final EvaluationEnvironment evaluationEnvironment;
	protected final OclExpression expression;
	protected final Object context;

	public InvalidEvaluationException(EvaluationEnvironment evaluationEnvironment, String message, Throwable e, OclExpression expression, Object context) {
		super(message, e);
		this.evaluationEnvironment = evaluationEnvironment;
		this.expression = expression;
		this.context = context;
	}

	public InvalidEvaluationException(EvaluationEnvironment evaluationEnvironment, InvalidValueException e) {
		super(e.getMessage(), e.getCause());
		this.evaluationEnvironment = evaluationEnvironment;
		this.expression = null;
		this.context = null;
	}
}
