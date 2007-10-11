/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2007 IBM Corporation and others.
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
 * $Id: TypedASTNode.java,v 1.3 2007/10/11 23:05:05 cdamus Exp $
 */
package org.eclipse.ocl.utilities;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed AST Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.utilities.TypedASTNode#getTypeStartPosition <em>Type Start Position</em>}</li>
 *   <li>{@link org.eclipse.ocl.utilities.TypedASTNode#getTypeEndPosition <em>Type End Position</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.utilities.UtilitiesPackage#getTypedASTNode()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface TypedASTNode extends ASTNode {
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
     * @see org.eclipse.ocl.utilities.UtilitiesPackage#getTypedASTNode_TypeStartPosition()
     * @model default="-1" transient="true"
     * @generated
     */
	int getTypeStartPosition();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.utilities.TypedASTNode#getTypeStartPosition <em>Type Start Position</em>}' attribute.
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
     * @see org.eclipse.ocl.utilities.UtilitiesPackage#getTypedASTNode_TypeEndPosition()
     * @model default="-1" transient="true"
     * @generated
     */
	int getTypeEndPosition();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.utilities.TypedASTNode#getTypeEndPosition <em>Type End Position</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type End Position</em>' attribute.
     * @see #getTypeEndPosition()
     * @generated
     */
	void setTypeEndPosition(int value);

} // TypedASTNode
