/**
 * <copyright>
 *
 * Copyright (c) 2006, 2007 IBM Corporation and others.
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
 * $Id: Visitable.java,v 1.2 2007/01/25 18:34:39 cdamus Exp $
 */
package org.eclipse.emf.ocl.utilities;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ocl.expressions.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Visitable</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @deprecated Use the {@link org.eclipse.ocl.utilities.Visitable} interface,
 * instead.
 * 
 * @see org.eclipse.emf.ocl.utilities.UtilitiesPackage#getVisitable()
 * @model
 * @generated
 */
public interface Visitable extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = ""; //$NON-NLS-1$

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model vDataType="org.eclipse.emf.ocl.expressions.Visitor"
	 * @generated
	 */
	Object accept(Visitor v);

} // Visitable
