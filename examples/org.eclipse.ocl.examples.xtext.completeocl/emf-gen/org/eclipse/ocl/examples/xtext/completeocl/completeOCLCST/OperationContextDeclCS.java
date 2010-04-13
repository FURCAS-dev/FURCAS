/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: OperationContextDeclCS.java,v 1.1 2010/04/13 06:38:25 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST;

import org.eclipse.emf.common.util.EList;

import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Context Decl CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS#getPres <em>Pres</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS#getPosts <em>Posts</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS#getBodies <em>Bodies</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage#getOperationContextDeclCS()
 * @model
 * @generated
 */
public interface OperationContextDeclCS extends ContextDeclCS {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage#getOperationContextDeclCS_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<VariableCS> getParameters();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(TypeCS)
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage#getOperationContextDeclCS_Type()
	 * @model containment="true"
	 * @generated
	 */
	TypeCS getType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(TypeCS value);

	/**
	 * Returns the value of the '<em><b>Pres</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PreCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pres</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pres</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage#getOperationContextDeclCS_Pres()
	 * @model containment="true"
	 * @generated
	 */
	EList<PreCS> getPres();

	/**
	 * Returns the value of the '<em><b>Posts</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PostCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Posts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Posts</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage#getOperationContextDeclCS_Posts()
	 * @model containment="true"
	 * @generated
	 */
	EList<PostCS> getPosts();

	/**
	 * Returns the value of the '<em><b>Bodies</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.BodyCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bodies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bodies</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage#getOperationContextDeclCS_Bodies()
	 * @model containment="true"
	 * @generated
	 */
	EList<BodyCS> getBodies();

} // OperationContextDeclCS
