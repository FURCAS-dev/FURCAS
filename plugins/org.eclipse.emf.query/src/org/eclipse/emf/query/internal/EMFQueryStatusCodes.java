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
public final class EMFQueryStatusCodes {

	private EMFQueryStatusCodes() {
		//private
	}

	/** Code indicating no trouble. */
	public static final int OK = 0;
	/** Code indicating that an exception was ignored. */
	public static final int IGNORED_EXCEPTION_WARNING = 10;
}
