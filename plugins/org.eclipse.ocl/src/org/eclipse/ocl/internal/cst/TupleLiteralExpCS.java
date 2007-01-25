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
 * $Id: TupleLiteralExpCS.java,v 1.1 2007/01/25 18:24:34 cdamus Exp $
 */
package org.eclipse.ocl.internal.cst;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tuple Literal Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.internal.cst.TupleLiteralExpCS#getVariables <em>Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.internal.cst.CSTPackage#getTupleLiteralExpCS()
 * @model
 * @generated
 */
public interface TupleLiteralExpCS extends LiteralExpCS {
	/**
     * Returns the value of the '<em><b>Variables</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.ocl.internal.cst.VariableCS}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Variables</em>' reference list.
     * @see org.eclipse.ocl.internal.cst.CSTPackage#getTupleLiteralExpCS_Variables()
     * @model type="org.eclipse.ocl.internal.cst.VariableCS"
     * @generated
     */
	EList<VariableCS> getVariables();

} // TupleLiteralExpCS
