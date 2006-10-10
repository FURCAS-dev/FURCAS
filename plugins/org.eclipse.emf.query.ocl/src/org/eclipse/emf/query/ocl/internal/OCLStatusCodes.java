/**
 * <copyright>
 *
 * Copyright (c) 2004, 2006 IBM Corporation and others.
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
 * $Id: OCLStatusCodes.java,v 1.2 2006/10/10 14:29:53 cdamus Exp $
 */

package org.eclipse.emf.query.ocl.internal;


/**
 * @author Yasser Lulu  
 */
public final class OCLStatusCodes {

	/**
	 * 
	 */
	private OCLStatusCodes() {
		super();
	}
	
	public static final int OK = 0;
	public static final int ERROR = 1;
	public static final int IGNORED_EXCEPTION_WARNING = 10;

}
