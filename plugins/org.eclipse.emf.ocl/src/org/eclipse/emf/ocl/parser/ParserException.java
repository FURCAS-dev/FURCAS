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
 * $Id: ParserException.java,v 1.1 2006/04/04 18:09:06 cdamus Exp $
 */

package org.eclipse.emf.ocl.parser;


/**
 * This exception should be used whenever an exception is
 * thrown by the OCL parser.
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
