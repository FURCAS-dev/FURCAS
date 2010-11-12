/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.utilities;

import org.eclipse.ocl.expressions.OppositePropertyCallExp;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Visitor With Hidden Opposite</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.ocl.utilities.UtilitiesPackage#getVisitorWithHiddenOpposite()
 * @model interface="true" abstract="true"
 * @since 3.1
 */
public interface VisitorWithHiddenOpposite<T, C, O, P, EL, PM, S, COA, SSA, CT>
		extends Visitor<T, C, O, P, EL, PM, S, COA, SSA, CT> {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model callExpRequired="true"
	 * @generated
	 */
	T visitOppositePropertyCallExp(OppositePropertyCallExp<C, P> callExp);

} // VisitorWithHiddenOpposite
