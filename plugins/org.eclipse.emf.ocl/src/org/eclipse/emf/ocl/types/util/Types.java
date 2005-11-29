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
 * $Id$
 */

package org.eclipse.emf.ocl.types.util;

import org.eclipse.emf.ocl.types.VoidType;
import org.eclipse.emf.ocl.types.internal.impl.VoidTypeImpl;

/**
 * A collection of global static types.
 */
public class Types {
	/**
	 * The shared type object representing OclVoid.
	 */
	public static VoidType OCL_VOID = new VoidTypeImpl("OclVoid"); //$NON-NLS-1$

	private Types() {
		super();
	}
}
