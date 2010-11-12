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
 * $Id: DetailCS.java,v 1.2 2010/08/17 18:53:39 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.base.baseCST;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Detail CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.DetailCS#getIdName <em>Id Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.DetailCS#getStringName <em>String Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.DetailCS#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getDetailCS()
 * @model
 * @generated
 */
public interface DetailCS extends ElementCS {
	/**
	 * Returns the value of the '<em><b>Id Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id Name</em>' attribute.
	 * @see #setIdName(String)
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getDetailCS_IdName()
	 * @model
	 * @generated
	 */
	String getIdName();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.DetailCS#getIdName <em>Id Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id Name</em>' attribute.
	 * @see #getIdName()
	 * @generated
	 */
	void setIdName(String value);

	/**
	 * Returns the value of the '<em><b>String Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String Name</em>' attribute.
	 * @see #setStringName(String)
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getDetailCS_StringName()
	 * @model
	 * @generated
	 */
	String getStringName();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.DetailCS#getStringName <em>String Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>String Name</em>' attribute.
	 * @see #getStringName()
	 * @generated
	 */
	void setStringName(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute list.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getDetailCS_Value()
	 * @model
	 * @generated
	 */
	EList<String> getValue();

} // DetailCS
