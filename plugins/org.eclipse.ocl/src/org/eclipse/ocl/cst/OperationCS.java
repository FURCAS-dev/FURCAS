/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: OperationCS.java,v 1.1 2007/10/11 23:04:54 cdamus Exp $
 */
package org.eclipse.ocl.cst;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.OperationCS#getPathNameCS <em>Path Name CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.OperationCS#getSimpleNameCS <em>Simple Name CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.OperationCS#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.OperationCS#getTypeCS <em>Type CS</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.cst.CSTPackage#getOperationCS()
 * @model
 * @generated
 */
public interface OperationCS extends CSTNode {
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
     * @see org.eclipse.ocl.cst.CSTPackage#getOperationCS_PathNameCS()
     * @model containment="true"
     * @generated
     */
	PathNameCS getPathNameCS();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.cst.OperationCS#getPathNameCS <em>Path Name CS</em>}' containment reference.
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
     * @see org.eclipse.ocl.cst.CSTPackage#getOperationCS_SimpleNameCS()
     * @model containment="true"
     * @generated
     */
	SimpleNameCS getSimpleNameCS();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.cst.OperationCS#getSimpleNameCS <em>Simple Name CS</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Simple Name CS</em>' containment reference.
     * @see #getSimpleNameCS()
     * @generated
     */
	void setSimpleNameCS(SimpleNameCS value);

	/**
     * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.ocl.cst.VariableCS}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Parameters</em>' containment reference list.
     * @see org.eclipse.ocl.cst.CSTPackage#getOperationCS_Parameters()
     * @model containment="true"
     * @generated
     */
	EList<VariableCS> getParameters();

	/**
     * Returns the value of the '<em><b>Type CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Type CS</em>' containment reference.
     * @see #setTypeCS(TypeCS)
     * @see org.eclipse.ocl.cst.CSTPackage#getOperationCS_TypeCS()
     * @model containment="true"
     * @generated
     */
	TypeCS getTypeCS();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.cst.OperationCS#getTypeCS <em>Type CS</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type CS</em>' containment reference.
     * @see #getTypeCS()
     * @generated
     */
	void setTypeCS(TypeCS value);

} // OperationCS
