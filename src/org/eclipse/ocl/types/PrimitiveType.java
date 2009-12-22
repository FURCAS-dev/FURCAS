/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2008 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 207365
 * 
 * </copyright>
 *
 * $Id: PrimitiveType.java,v 1.5 2009/12/22 18:52:41 ewillink Exp $
 */
package org.eclipse.ocl.types;

import org.eclipse.ocl.utilities.PredefinedType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Type</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.ocl.types.TypesPackage#getPrimitiveType()
 * @model
 * @generated
 */
public interface PrimitiveType<O>
		extends PredefinedType<O> {

	String BOOLEAN_NAME = "Boolean"; //$NON-NLS-1$

	String STRING_NAME = "String"; //$NON-NLS-1$

	String INTEGER_NAME = "Integer"; //$NON-NLS-1$

	String UNLIMITED_NATURAL_NAME = "UnlimitedNatural"; //$NON-NLS-1$

	String REAL_NAME = "Real"; //$NON-NLS-1$
} // PrimitiveType
