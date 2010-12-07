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
 * $Id: OCLDebugOptions.java,v 1.2 2006/10/10 14:29:53 cdamus Exp $
 */

package org.eclipse.emf.query.ocl.internal;


/**
 * @author Yasser Lulu  
 */
public final class OCLDebugOptions {
	private OCLDebugOptions() {
		super();
	}
	
	public static final String DEBUG = OCLPlugin.getPlugin().getSymbolicName() + "/debug"; //$NON-NLS-1$

	public static final String EXCEPTIONS_CATCHING = DEBUG + "/exceptions/catching"; //$NON-NLS-1$
	public static final String EXCEPTIONS_THROWING = DEBUG + "/exceptions/throwing"; //$NON-NLS-1$

	public static final String METHODS_ENTERING = DEBUG + "/methods/entering"; //$NON-NLS-1$
	public static final String METHODS_EXITING = DEBUG + "/methods/exiting"; //$NON-NLS-1$

}
