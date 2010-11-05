/**
 * <copyright>
 *
 * Copyright (c) 2004, 2009 IBM Corporation, Borland Software Corporation, and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Radek Dvorak - Bug 261128
 *
 * </copyright>
 *
 * $Id: OCLStatusCodes.java,v 1.3 2009/01/31 19:47:15 cdamus Exp $
 */

package org.eclipse.ocl.internal;


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
	public static final int EVALUATION_HALTED = 11;	

	public static final int USERMODELSUPPORT_MISSING_NSURI = 20;
	public static final int USERMODELSUPPORT_MISSING_CLASS = 21;
	public static final int USERMODELSUPPORT_UNRESOLVED_NSURI = 22;
	public static final int USERMODELSUPPORT_FACTORY_FAILED = 23;
}
