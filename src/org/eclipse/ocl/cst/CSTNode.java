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
 * $Id: CSTNode.java,v 1.1 2007/10/11 23:04:54 cdamus Exp $
 */
package org.eclipse.ocl.cst;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.CSTNode#getStartOffset <em>Start Offset</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.CSTNode#getEndOffset <em>End Offset</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.cst.CSTPackage#getCSTNode()
 * @model abstract="true"
 * @generated
 */
public interface CSTNode extends EObject {
	/**
     * Returns the value of the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Start Offset</em>' attribute.
     * @see #setStartOffset(int)
     * @see org.eclipse.ocl.cst.CSTPackage#getCSTNode_StartOffset()
     * @model
     * @generated
     */
	int getStartOffset();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.cst.CSTNode#getStartOffset <em>Start Offset</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Start Offset</em>' attribute.
     * @see #getStartOffset()
     * @generated
     */
	void setStartOffset(int value);

	/**
     * Returns the value of the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>End Offset</em>' attribute.
     * @see #setEndOffset(int)
     * @see org.eclipse.ocl.cst.CSTPackage#getCSTNode_EndOffset()
     * @model
     * @generated
     */
	int getEndOffset();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.cst.CSTNode#getEndOffset <em>End Offset</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>End Offset</em>' attribute.
     * @see #getEndOffset()
     * @generated
     */
	void setEndOffset(int value);

} // CSTNode
