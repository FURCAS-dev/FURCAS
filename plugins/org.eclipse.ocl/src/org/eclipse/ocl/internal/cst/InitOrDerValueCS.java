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
 * $Id: InitOrDerValueCS.java,v 1.4 2007/05/10 18:59:14 cdamus Exp $
 */
package org.eclipse.ocl.internal.cst;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Init Or Der Value CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.internal.cst.InitOrDerValueCS#getInitOrDerValueCS <em>Init Or Der Value CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.internal.cst.InitOrDerValueCS#getExpressionCS <em>Expression CS</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.internal.cst.CSTPackage#getInitOrDerValueCS()
 * @model abstract="true"
 * @generated
 */
public interface InitOrDerValueCS extends CSTNode {
	/**
	 * Returns the value of the '<em><b>Init Or Der Value CS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Or Der Value CS</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init Or Der Value CS</em>' reference.
	 * @see #setInitOrDerValueCS(InitOrDerValueCS)
	 * @see org.eclipse.ocl.internal.cst.CSTPackage#getInitOrDerValueCS_InitOrDerValueCS()
	 * @model
	 * @generated
	 */
	InitOrDerValueCS getInitOrDerValueCS();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.internal.cst.InitOrDerValueCS#getInitOrDerValueCS <em>Init Or Der Value CS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init Or Der Value CS</em>' reference.
	 * @see #getInitOrDerValueCS()
	 * @generated
	 */
	void setInitOrDerValueCS(InitOrDerValueCS value);

	/**
	 * Returns the value of the '<em><b>Expression CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression CS</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression CS</em>' containment reference.
	 * @see #setExpressionCS(OCLExpressionCS)
	 * @see org.eclipse.ocl.internal.cst.CSTPackage#getInitOrDerValueCS_ExpressionCS()
	 * @model containment="true"
	 *        extendedMetaData="name='oclExpressionCS'"
	 * @generated
	 */
	OCLExpressionCS getExpressionCS();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.internal.cst.InitOrDerValueCS#getExpressionCS <em>Expression CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression CS</em>' containment reference.
	 * @see #getExpressionCS()
	 * @generated
	 */
	void setExpressionCS(OCLExpressionCS value);

} // InitOrDerValueCS
