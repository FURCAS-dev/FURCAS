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
 * $Id: ClassifierContextDeclCS.java,v 1.1 2010/04/13 06:38:26 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST;

import org.eclipse.emf.common.util.EList;

import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SimpleNameCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Classifier Context Decl CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS#getSelfName <em>Self Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS#getInvs <em>Invs</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS#getDefs <em>Defs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage#getClassifierContextDeclCS()
 * @model
 * @generated
 */
public interface ClassifierContextDeclCS extends ContextDeclCS {
	/**
	 * Returns the value of the '<em><b>Self Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Self Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Self Name</em>' containment reference.
	 * @see #setSelfName(SimpleNameCS)
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage#getClassifierContextDeclCS_SelfName()
	 * @model containment="true"
	 * @generated
	 */
	SimpleNameCS getSelfName();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS#getSelfName <em>Self Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Self Name</em>' containment reference.
	 * @see #getSelfName()
	 * @generated
	 */
	void setSelfName(SimpleNameCS value);

	/**
	 * Returns the value of the '<em><b>Invs</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.InvCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invs</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage#getClassifierContextDeclCS_Invs()
	 * @model containment="true"
	 * @generated
	 */
	EList<InvCS> getInvs();

	/**
	 * Returns the value of the '<em><b>Defs</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defs</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage#getClassifierContextDeclCS_Defs()
	 * @model containment="true"
	 * @generated
	 */
	EList<DefCS> getDefs();

} // ClassifierContextDeclCS
