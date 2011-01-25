/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: PivotResource.java,v 1.2 2011/01/24 20:42:33 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.utilities;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.ocl.examples.pivot.PivotPackage;

/**
 * The resource associated with the '<em><b>pivot</b></em>' package.
 */
public interface PivotResource extends XMIResource
{
	/**
	 * The factory for '<em><b>pivot</b></em>' resources.
	 */
	public interface Factory extends Resource.Factory
	{
		public static final Factory INSTANCE = new PivotResourceFactoryImpl();
	}

	/**
	 * The file extension for '<em><b>pivot</b></em>' resources.
	 */
	public static final String FILE_EXTENSION = "pivot"; //$NON-NLS-1$

	/**
	 * The default encoding for '<em><b>pivot</b></em>' resources.
	 */
	public static final String DEFAULT_ENCODING = "UTF-8"; //$NON-NLS-1$

	public static final String CONTENT_TYPE = PivotPackage.eCONTENT_TYPE;
}