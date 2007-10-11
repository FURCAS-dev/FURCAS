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
 * $Id: CallingASTNode.java,v 1.3 2007/10/11 23:05:05 cdamus Exp $
 */
package org.eclipse.ocl.utilities;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Calling AST Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.utilities.CallingASTNode#getPropertyStartPosition <em>Property Start Position</em>}</li>
 *   <li>{@link org.eclipse.ocl.utilities.CallingASTNode#getPropertyEndPosition <em>Property End Position</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.utilities.UtilitiesPackage#getCallingASTNode()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface CallingASTNode extends ASTNode {
	/**
     * Returns the value of the '<em><b>Property Start Position</b></em>' attribute.
     * The default value is <code>"-1"</code>.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Start Position</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Property Start Position</em>' attribute.
     * @see #setPropertyStartPosition(int)
     * @see org.eclipse.ocl.utilities.UtilitiesPackage#getCallingASTNode_PropertyStartPosition()
     * @model default="-1" transient="true"
     * @generated
     */
	int getPropertyStartPosition();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.utilities.CallingASTNode#getPropertyStartPosition <em>Property Start Position</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Property Start Position</em>' attribute.
     * @see #getPropertyStartPosition()
     * @generated
     */
	void setPropertyStartPosition(int value);

	/**
     * Returns the value of the '<em><b>Property End Position</b></em>' attribute.
     * The default value is <code>"-1"</code>.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property End Position</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Property End Position</em>' attribute.
     * @see #setPropertyEndPosition(int)
     * @see org.eclipse.ocl.utilities.UtilitiesPackage#getCallingASTNode_PropertyEndPosition()
     * @model default="-1" transient="true"
     * @generated
     */
	int getPropertyEndPosition();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.utilities.CallingASTNode#getPropertyEndPosition <em>Property End Position</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Property End Position</em>' attribute.
     * @see #getPropertyEndPosition()
     * @generated
     */
	void setPropertyEndPosition(int value);

} // CallingASTNode
