/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
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
 * $Id: ParserException.java,v 1.2 2007/01/25 18:34:33 cdamus Exp $
 */

package org.eclipse.emf.ocl.parser;


/**
 * This exception should be used whenever an exception is
 * thrown by the OCL parser.
 * 
 * @deprecated Use the {@link org.eclipse.ocl.ParserException} type,
 * instead.
 * 
 * @author Christian Vogt (cvogt)
 */
public class ParserException extends Exception {

	private static final long serialVersionUID = -4457105668114213310L;

	/**
	 * Constructor.
	 * 
	 * @param msg the exception message
	 */
	public ParserException(String msg) {
		super(msg);
	}

}
