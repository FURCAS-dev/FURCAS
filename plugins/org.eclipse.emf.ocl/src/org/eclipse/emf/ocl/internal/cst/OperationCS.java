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
 * $Id: OperationCS.java,v 1.1 2006/04/04 18:09:02 cdamus Exp $
 */
package org.eclipse.emf.ocl.internal.cst;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.OperationCS#getPathNameCS <em>Path Name CS</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.OperationCS#getSimpleNameCS <em>Simple Name CS</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.OperationCS#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.OperationCS#getTypeCS <em>Type CS</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getOperationCS()
 * @model
 * @generated
 */
public interface OperationCS extends CSTNode {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = ""; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Path Name CS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path Name CS</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path Name CS</em>' reference.
	 * @see #setPathNameCS(PathNameCS)
	 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getOperationCS_PathNameCS()
	 * @model
	 * @generated
	 */
	PathNameCS getPathNameCS();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.internal.cst.OperationCS#getPathNameCS <em>Path Name CS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path Name CS</em>' reference.
	 * @see #getPathNameCS()
	 * @generated
	 */
	void setPathNameCS(PathNameCS value);

	/**
	 * Returns the value of the '<em><b>Simple Name CS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Name CS</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Name CS</em>' reference.
	 * @see #setSimpleNameCS(SimpleNameCS)
	 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getOperationCS_SimpleNameCS()
	 * @model
	 * @generated
	 */
	SimpleNameCS getSimpleNameCS();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.internal.cst.OperationCS#getSimpleNameCS <em>Simple Name CS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Name CS</em>' reference.
	 * @see #getSimpleNameCS()
	 * @generated
	 */
	void setSimpleNameCS(SimpleNameCS value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ocl.internal.cst.VariableCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' reference list.
	 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getOperationCS_Parameters()
	 * @model type="org.eclipse.emf.ocl.internal.cst.VariableCS"
	 * @generated
	 */
	EList getParameters();

	/**
	 * Returns the value of the '<em><b>Type CS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type CS</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type CS</em>' reference.
	 * @see #setTypeCS(TypeCS)
	 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getOperationCS_TypeCS()
	 * @model
	 * @generated
	 */
	TypeCS getTypeCS();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.internal.cst.OperationCS#getTypeCS <em>Type CS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type CS</em>' reference.
	 * @see #getTypeCS()
	 * @generated
	 */
	void setTypeCS(TypeCS value);

} // OperationCS
