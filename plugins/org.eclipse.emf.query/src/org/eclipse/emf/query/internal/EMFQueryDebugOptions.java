/**
 * <copyright>
 *
 * Copyright (c) 2002, 2006 IBM Corporation and others.
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
 * $Id$
 */

package org.eclipse.emf.query.internal;

/** 
 * @author Yasser Lulu 
 */
public final class EMFQueryDebugOptions {

	private EMFQueryDebugOptions() {
		//private
	}

	/** Root of the plug-in's tracing options. */
	public static final String DEBUG = EMFQueryPlugin.getPlugin()
		.getBundle().getSymbolicName()
		+ "/debug"; //$NON-NLS-1$
	/** Option to trace caught exceptions. */
	public static final String EXCEPTIONS_CATCHING = DEBUG
		+ "/exceptions/catching"; //$NON-NLS-1$
	/** Option to trace thrown exceptions. */
	public static final String EXCEPTIONS_THROWING = DEBUG
		+ "/exceptions/throwing"; //$NON-NLS-1$
	/** Option to trace method entrances. */
	public static final String METHODS_ENTERING = DEBUG + "/methods/entering"; //$NON-NLS-1$
	/** Option to trace method exits. */
	public static final String METHODS_EXITING = DEBUG + "/methods/exiting"; //$NON-NLS-1$   	

}
