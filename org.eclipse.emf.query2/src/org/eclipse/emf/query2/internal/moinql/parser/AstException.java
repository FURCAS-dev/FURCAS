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
package org.eclipse.emf.query2.internal.moinql.parser;

import org.eclipse.emf.query2.exception.LocalizedBaseException;
import org.eclipse.emf.query2.exception.LocalizedBaseRuntimeException;
import org.eclipse.emf.query2.exception.LocalizedString;

/**
 * Exception to report AST errors to the outside
 */
public class AstException extends LocalizedBaseRuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * @param rootCause
	 */
	public AstException(Exception rootCause) {

		super(LPGMessages.LPG_AST_BUILDER_ERROR, rootCause.getMessage());
	}

	/**
	 * @param message
	 * @param args
	 */
	public AstException(LocalizedString message, Object... args) {

		super(message, args);
	}

	/**
	 * @param ex
	 */
	public AstException(LocalizedBaseException ex) {

		super(ex);
	}
}
