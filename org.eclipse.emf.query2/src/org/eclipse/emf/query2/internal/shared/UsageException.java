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
 *
 */
public class UsageException extends LocalizedBaseRuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * @param cause
	 * @param message
	 * @param args
	 */
	public UsageException(Throwable cause, LocalizedString message, Object... args) {

		super(cause, message, args);
	}

	/**
	 * @param message
	 * @param args
	 */
	public UsageException(LocalizedString message, Object... args) {

		super(message, args);
	}
}
