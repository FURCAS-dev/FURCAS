/**
 * <copyright>
 *
 * Copyright (c) 2009,2010 SAP AG and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Axel Uhl - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: VisitorExtension.java,v 1.1 2010/12/15 17:32:44 ewillink Exp $
 */
package org.eclipse.ocl.ecore.utilities;

import org.eclipse.ocl.ecore.OppositePropertyCallExp;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Visitor Extension</b></em>'.
 * @since 3.1
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.ocl.utilities.UtilitiesPackage#getVisitorExtension()
 * @model interface="true" abstract="true"
 */
public interface VisitorExtension<T> {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model callExpRequired="true"
	 * @generated
	 */
	T visitOppositePropertyCallExp(OppositePropertyCallExp callExp);

} // VisitorExtension
