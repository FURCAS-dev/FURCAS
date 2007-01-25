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
 * $Id: CollectionLiteralPartCS.java,v 1.1 2007/01/25 18:24:33 cdamus Exp $
 */
package org.eclipse.ocl.internal.cst;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Literal Part CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.internal.cst.CollectionLiteralPartCS#getExpressionCS <em>Expression CS</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.internal.cst.CSTPackage#getCollectionLiteralPartCS()
 * @model
 * @generated
 */
public interface CollectionLiteralPartCS extends CSTNode {
	/**
     * Returns the value of the '<em><b>Expression CS</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression CS</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Expression CS</em>' reference.
     * @see #setExpressionCS(OCLExpressionCS)
     * @see org.eclipse.ocl.internal.cst.CSTPackage#getCollectionLiteralPartCS_ExpressionCS()
     * @model extendedMetaData="name='oclExpressionCS'"
     * @generated
     */
	OCLExpressionCS getExpressionCS();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.internal.cst.CollectionLiteralPartCS#getExpressionCS <em>Expression CS</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Expression CS</em>' reference.
     * @see #getExpressionCS()
     * @generated
     */
	void setExpressionCS(OCLExpressionCS value);

} // CollectionLiteralPartCS
