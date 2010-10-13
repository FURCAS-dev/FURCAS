/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query2.internal.shared;

import org.eclipse.emf.query2.exception.LocalizedBaseRuntimeException;
import org.eclipse.emf.query2.exception.LocalizedString;

/**
 */
final public class BugException extends LocalizedBaseRuntimeException {

	private static final long serialVersionUID = -5627045929224860616L;

	/**
	 * @param message
	 */
	public BugException(LocalizedString message, Object... args) {

		super(message, args);
	}

	/**
	 * @param message
	 */
	public BugException(Throwable cause, LocalizedString message, Object... args) {

		super(cause, message, args);

	}

}
