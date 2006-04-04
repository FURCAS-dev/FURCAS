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
 * $Id: SemanticException.java,v 1.1 2006/04/04 18:09:06 cdamus Exp $
 */

package org.eclipse.emf.ocl.parser;

/**
 * This exception is thrown when an error is found
 * while building the OCL AST.
 * 
 * @author Christian Vogt (cvogt)
 */
public class SemanticException
	extends ParserException {

	private static final long serialVersionUID = -7995837682564930748L;

	/**
	 * Constructor.
	 * 
	 * @param msg the exception message
	 */
	public SemanticException(String msg) {
		super(msg);
	}

}
