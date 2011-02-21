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
 * $Id: EvaluationException.java,v 1.1 2011/02/21 08:37:53 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot;


public abstract class EvaluationException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	protected EvaluationException(String message) {
		super(message);
	}

	protected EvaluationException(Throwable cause) {
		super(cause);
	}

	protected EvaluationException(String message, Throwable cause) {
		super(message, cause);
	}
}
