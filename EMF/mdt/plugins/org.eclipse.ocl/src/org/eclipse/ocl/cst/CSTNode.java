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
 * $Id: CSTNode.java,v 1.5 2009/12/27 15:49:50 asanchez Exp $
 */
package org.eclipse.ocl.cst;

import lpg.runtime.IToken;

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
 *   <li>{@link org.eclipse.ocl.cst.CSTNode#getStartToken <em>Start Token</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.CSTNode#getEndToken <em>End Token</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.CSTNode#getAst <em>Ast</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.cst.CSTPackage#getCSTNode()
 * @model abstract="true"
 * @generated
 */
public interface CSTNode
		extends EObject {

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

	/**
	 * Returns the value of the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Token</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Token</em>' attribute.
	 * @see #setStartToken(IToken)
	 * @see org.eclipse.ocl.cst.CSTPackage#getCSTNode_StartToken()
	 * @model dataType="org.eclipse.ocl.cst.IToken" transient="true" ordered="false"
	 * @generated
	 */
	IToken getStartToken();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.cst.CSTNode#getStartToken <em>Start Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Token</em>' attribute.
	 * @see #getStartToken()
	 * @generated
	 */
	void setStartToken(IToken value);

	/**
	 * Returns the value of the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Token</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Token</em>' attribute.
	 * @see #setEndToken(IToken)
	 * @see org.eclipse.ocl.cst.CSTPackage#getCSTNode_EndToken()
	 * @model dataType="org.eclipse.ocl.cst.IToken" transient="true" ordered="false"
	 * @generated
	 */
	IToken getEndToken();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.cst.CSTNode#getEndToken <em>End Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Token</em>' attribute.
	 * @see #getEndToken()
	 * @generated
	 */
	void setEndToken(IToken value);

	/**
	 * Returns the value of the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ast</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ast</em>' attribute.
	 * @see #setAst(Object)
	 * @see org.eclipse.ocl.cst.CSTPackage#getCSTNode_Ast()
	 * @model transient="true" ordered="false"
	 * @generated
	 */
	Object getAst();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.cst.CSTNode#getAst <em>Ast</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ast</em>' attribute.
	 * @see #getAst()
	 * @generated
	 */
	void setAst(Object value);

} // CSTNode
