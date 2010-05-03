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
 * $Id: WildcardTypeRefCS.java,v 1.1 2010/05/03 05:24:57 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.baseCST;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Wildcard Type Ref CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.WildcardTypeRefCS#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.WildcardTypeRefCS#getSuper <em>Super</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getWildcardTypeRefCS()
 * @model
 * @generated
 */
public interface WildcardTypeRefCS extends TypeRefCS {
	/**
	 * Returns the value of the '<em><b>Extends</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends</em>' containment reference.
	 * @see #setExtends(TypedRefCS)
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getWildcardTypeRefCS_Extends()
	 * @model containment="true"
	 * @generated
	 */
	TypedRefCS getExtends();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.WildcardTypeRefCS#getExtends <em>Extends</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extends</em>' containment reference.
	 * @see #getExtends()
	 * @generated
	 */
	void setExtends(TypedRefCS value);

	/**
	 * Returns the value of the '<em><b>Super</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super</em>' containment reference.
	 * @see #setSuper(TypedRefCS)
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getWildcardTypeRefCS_Super()
	 * @model containment="true"
	 * @generated
	 */
	TypedRefCS getSuper();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.WildcardTypeRefCS#getSuper <em>Super</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super</em>' containment reference.
	 * @see #getSuper()
	 * @generated
	 */
	void setSuper(TypedRefCS value);

} // WildcardTypeRefCS
