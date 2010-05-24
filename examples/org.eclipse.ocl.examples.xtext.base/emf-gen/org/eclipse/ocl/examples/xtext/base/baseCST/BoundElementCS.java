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
 * $Id: BoundElementCS.java,v 1.3 2010/05/24 08:59:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.baseCST;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bound Element CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.BoundElementCS#getBindings <em>Bindings</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.BoundElementCS#getBinds <em>Binds</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getBoundElementCS()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface BoundElementCS<T extends NamedElementCS> extends NamedElementCS {
	/**
	 * Returns the value of the '<em><b>Bindings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bindings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bindings</em>' reference.
	 * @see #setBindings(TypeBindingsCS)
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getBoundElementCS_Bindings()
	 * @model resolveProxies="false" transient="true"
	 * @generated
	 */
	TypeBindingsCS getBindings();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.BoundElementCS#getBindings <em>Bindings</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bindings</em>' reference.
	 * @see #getBindings()
	 * @generated
	 */
	void setBindings(TypeBindingsCS value);

	/**
	 * Returns the value of the '<em><b>Binds</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binds</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binds</em>' reference.
	 * @see #setBinds(NamedElementCS)
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getBoundElementCS_Binds()
	 * @model derived="true"
	 * @generated
	 */
	T getBinds();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.BoundElementCS#getBinds <em>Binds</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binds</em>' reference.
	 * @see #getBinds()
	 * @generated
	 */
	void setBinds(T value);

} // BoundElementCS
