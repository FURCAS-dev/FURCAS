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
 * $Id: InvalidValueException.java,v 1.1 2011/02/21 08:37:53 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot;

import org.eclipse.ocl.examples.pivot.values.Value;

/**
 * An InvalidValueException is thrown when an Invalid Value arises during
 * an evaluation, and when no EvaluationEnvironment is available to support
 * throwing an InvalidEvaluationException. When such an environment is
 * available the InvalidValueException is rethrown as an 
 * InvalidEvaluationException.
 */
public class InvalidValueException extends Exception
{
	private static final long serialVersionUID = 1L;

	public InvalidValueException(String message) {
		super(message);
	}

	public InvalidValueException(String message, Throwable e) {
		super(message, e);
	}

	public InvalidValueException(String message, Value value) {
		super(message);
	}

	public InvalidValueException(Throwable e) {
		super(e);
	}
}
