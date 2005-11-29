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
 * $Id$
 */

package org.eclipse.emf.ocl.internal.utilities;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Ast Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.internal.utilities.TypedAstNode#getTypeStartPosition <em>Type Start Position</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.internal.utilities.TypedAstNode#getTypeEndPosition <em>Type End Position</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.ocl.internal.utilities.UtilitiesPackage#getTypedAstNode()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface TypedAstNode extends AstNode {
	/**
	 * Returns the value of the '<em><b>Type Start Position</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Start Position</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Start Position</em>' attribute.
	 * @see #setTypeStartPosition(int)
	 * @see org.eclipse.emf.ocl.internal.utilities.UtilitiesPackage#getTypedAstNode_TypeStartPosition()
	 * @model default="-1" transient="true"
	 * @generated
	 */
	int getTypeStartPosition();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.internal.utilities.TypedAstNode#getTypeStartPosition <em>Type Start Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Start Position</em>' attribute.
	 * @see #getTypeStartPosition()
	 * @generated
	 */
	void setTypeStartPosition(int value);

	/**
	 * Returns the value of the '<em><b>Type End Position</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type End Position</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type End Position</em>' attribute.
	 * @see #setTypeEndPosition(int)
	 * @see org.eclipse.emf.ocl.internal.utilities.UtilitiesPackage#getTypedAstNode_TypeEndPosition()
	 * @model default="-1" transient="true"
	 * @generated
	 */
	int getTypeEndPosition();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.internal.utilities.TypedAstNode#getTypeEndPosition <em>Type End Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type End Position</em>' attribute.
	 * @see #getTypeEndPosition()
	 * @generated
	 */
	void setTypeEndPosition(int value);

} // TypedAstNode
