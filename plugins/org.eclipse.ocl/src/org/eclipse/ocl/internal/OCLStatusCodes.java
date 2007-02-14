/**
 * <copyright>
 *
 * Copyright (c) 2004, 2007 IBM Corporation and others.
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
 * $Id: OCLStatusCodes.java,v 1.2 2007/02/14 14:46:07 cdamus Exp $
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

	public static final int USERMODELSUPPORT_MISSING_NSURI = 20;
	public static final int USERMODELSUPPORT_MISSING_CLASS = 21;
	public static final int USERMODELSUPPORT_UNRESOLVED_NSURI = 22;
	public static final int USERMODELSUPPORT_FACTORY_FAILED = 23;
}
