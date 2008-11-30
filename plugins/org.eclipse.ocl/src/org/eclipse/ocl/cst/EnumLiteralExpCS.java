/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2008 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 243976
 *
 * </copyright>
 *
 * $Id: EnumLiteralExpCS.java,v 1.3 2008/11/30 22:11:38 cdamus Exp $
 */
package org.eclipse.ocl.cst;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Literal Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.EnumLiteralExpCS#getPathNameCS <em>Path Name CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.EnumLiteralExpCS#getSimpleNameCS <em>Simple Name CS</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.cst.CSTPackage#getEnumLiteralExpCS()
 * @model
 * @generated
 * @noimplement This interface is not intended to be implemented by clients.
 * @noextend This interface is not intended to be extended by clients.
 */
public interface EnumLiteralExpCS
		extends LiteralExpCS {

	/**
	 * Returns the value of the '<em><b>Path Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path Name CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path Name CS</em>' containment reference.
	 * @see #setPathNameCS(PathNameCS)
	 * @see org.eclipse.ocl.cst.CSTPackage#getEnumLiteralExpCS_PathNameCS()
	 * @model containment="true"
	 * @generated
	 */
	PathNameCS getPathNameCS();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.cst.EnumLiteralExpCS#getPathNameCS <em>Path Name CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path Name CS</em>' containment reference.
	 * @see #getPathNameCS()
	 * @generated
	 */
	void setPathNameCS(PathNameCS value);

	/**
	 * Returns the value of the '<em><b>Simple Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Name CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Name CS</em>' containment reference.
	 * @see #setSimpleNameCS(SimpleNameCS)
	 * @see org.eclipse.ocl.cst.CSTPackage#getEnumLiteralExpCS_SimpleNameCS()
	 * @model containment="true"
	 * @generated
	 */
	SimpleNameCS getSimpleNameCS();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.cst.EnumLiteralExpCS#getSimpleNameCS <em>Simple Name CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Name CS</em>' containment reference.
	 * @see #getSimpleNameCS()
	 * @generated
	 */
	void setSimpleNameCS(SimpleNameCS value);

} // EnumLiteralExpCS
