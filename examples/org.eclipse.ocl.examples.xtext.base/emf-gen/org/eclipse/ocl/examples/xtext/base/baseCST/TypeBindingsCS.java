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
 * $Id: TypeBindingsCS.java,v 1.2 2010/05/24 08:59:31 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.base.baseCST;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Bindings CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS#getBoundDocument <em>Bound Document</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS#getBindings <em>Bindings</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS#getNested <em>Nested</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getTypeBindingsCS()
 * @model
 * @generated
 */
public interface TypeBindingsCS extends ElementCS {
	/**
	 * Returns the value of the '<em><b>Bound Document</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bound Document</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bound Document</em>' reference.
	 * @see #setBoundDocument(BoundDocumentCS)
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getTypeBindingsCS_BoundDocument()
	 * @model resolveProxies="false"
	 * @generated
	 */
	BoundDocumentCS getBoundDocument();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS#getBoundDocument <em>Bound Document</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bound Document</em>' reference.
	 * @see #getBoundDocument()
	 * @generated
	 */
	void setBoundDocument(BoundDocumentCS value);

	/**
	 * Returns the value of the '<em><b>Bindings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bindings</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bindings</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getTypeBindingsCS_Bindings()
	 * @model containment="true"
	 * @generated
	 */
	EList<TypeBindingCS> getBindings();

	/**
	 * Returns the value of the '<em><b>Nested</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nested</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nested</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getTypeBindingsCS_Nested()
	 * @model containment="true"
	 * @generated
	 */
	EList<TypeBindingsCS> getNested();

} // TypeBindingsCS
