/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2010 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 207365
 *   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - Bug 297666
 * 
 * </copyright>
 *
 * $Id: InvalidType.java,v 1.6 2010/02/09 10:32:33 asanchez Exp $
 */
package org.eclipse.ocl.types;

import org.eclipse.ocl.utilities.PredefinedType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invalid Type</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.ocl.types.TypesPackage#getInvalidType()
 * @model
 * @generated
 */
public interface InvalidType<O>
		extends PredefinedType<O> {

	String SINGLETON_NAME = "OclInvalid"; //$NON-NLS-1$

} // InvalidType
