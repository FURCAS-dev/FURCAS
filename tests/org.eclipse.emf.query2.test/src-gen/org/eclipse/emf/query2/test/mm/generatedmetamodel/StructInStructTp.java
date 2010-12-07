/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query2.test.mm.generatedmetamodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Struct In Struct Tp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.StructInStructTp#getField1 <em>Field1</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.StructInStructTp#getField2 <em>Field2</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.GeneratedmetamodelPackage#getStructInStructTp()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/metamodel/generatedmetamodel[1.0.0]' metaObject='generatedmetamodel.StructInStructTp' metaObjectMofId='47D14F96E271D7D0EC5111DCC6478000600FE800' isStructureType='true'"
 * @generated
 */
public interface StructInStructTp extends EObject {
	/**
	 * Returns the value of the '<em><b>Field1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Field1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field1</em>' attribute.
	 * @see #setField1(int)
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.GeneratedmetamodelPackage#getStructInStructTp_Field1()
	 * @model required="true"
	 * @generated
	 */
	int getField1();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.StructInStructTp#getField1 <em>Field1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field1</em>' attribute.
	 * @see #getField1()
	 * @generated
	 */
	void setField1(int value);

	/**
	 * Returns the value of the '<em><b>Field2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Field2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field2</em>' attribute.
	 * @see #setField2(String)
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.GeneratedmetamodelPackage#getStructInStructTp_Field2()
	 * @model required="true"
	 * @generated
	 */
	String getField2();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.StructInStructTp#getField2 <em>Field2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field2</em>' attribute.
	 * @see #getField2()
	 * @generated
	 */
	void setField2(String value);

} // StructInStructTp
