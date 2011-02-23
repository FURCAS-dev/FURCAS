/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: DataType.java,v 1.3 2011/02/15 10:38:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * DataType is an abstract class that acts as a common superclass for different kinds of data types.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.DataType#isSerializable <em>Is Serializable</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.DataType#getBehavioralType <em>Behavioral Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getDataType()
 * @model
 * @generated
 */
public interface DataType
		extends org.eclipse.ocl.examples.pivot.Class {

	/**
	 * Returns the value of the '<em><b>Is Serializable</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Serializable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Serializable</em>' attribute.
	 * @see #setIsSerializable(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getDataType_IsSerializable()
	 * @model default="true" dataType="org.eclipse.ocl.examples.pivot.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isSerializable();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.DataType#isSerializable <em>Is Serializable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Serializable</em>' attribute.
	 * @see #isSerializable()
	 * @generated
	 */
	void setIsSerializable(boolean value);

	/**
	 * Returns the value of the '<em><b>Behavioral Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavioral Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavioral Type</em>' reference.
	 * @see #setBehavioralType(Type)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getDataType_BehavioralType()
	 * @model ordered="false"
	 * @generated
	 */
	Type getBehavioralType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.DataType#getBehavioralType <em>Behavioral Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Behavioral Type</em>' reference.
	 * @see #getBehavioralType()
	 * @generated
	 */
	void setBehavioralType(Type value);
} // DataType
