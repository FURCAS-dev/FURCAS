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
 * $Id: CSTNode.java,v 1.2 2007/02/14 14:46:02 cdamus Exp $
 */
package org.eclipse.ocl.internal.cst;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.internal.cst.CSTNode#getStartOffset <em>Start Offset</em>}</li>
 *   <li>{@link org.eclipse.ocl.internal.cst.CSTNode#getEndOffset <em>End Offset</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.internal.cst.CSTPackage#getCSTNode()
 * @model abstract="true"
 * @generated
 */
public interface CSTNode extends EObject {
	/**
     * Returns the value of the '<em><b>Start Offset</b></em>' attribute.
     * The default value is <code>"0"</code>.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Start Offset</em>' attribute.
     * @see #setStartOffset(int)
     * @see org.eclipse.ocl.internal.cst.CSTPackage#getCSTNode_StartOffset()
     * @model default="0"
     * @generated
     */
	int getStartOffset();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.internal.cst.CSTNode#getStartOffset <em>Start Offset</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Start Offset</em>' attribute.
     * @see #getStartOffset()
     * @generated
     */
	void setStartOffset(int value);

	/**
     * Returns the value of the '<em><b>End Offset</b></em>' attribute.
     * The default value is <code>"0"</code>.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>End Offset</em>' attribute.
     * @see #setEndOffset(int)
     * @see org.eclipse.ocl.internal.cst.CSTPackage#getCSTNode_EndOffset()
     * @model default="0"
     * @generated
     */
	int getEndOffset();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.internal.cst.CSTNode#getEndOffset <em>End Offset</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>End Offset</em>' attribute.
     * @see #getEndOffset()
     * @generated
     */
	void setEndOffset(int value);

} // CSTNode
