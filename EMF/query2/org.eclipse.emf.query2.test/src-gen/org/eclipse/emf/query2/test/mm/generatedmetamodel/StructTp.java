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
 * A representation of the model object '<em><b>Struct Tp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.StructTp#getField1 <em>Field1</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.StructTp#getField2 <em>Field2</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.StructTp#getField3 <em>Field3</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.GeneratedmetamodelPackage#getStructTp()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/metamodel/generatedmetamodel[1.0.0]' metaObject='generatedmetamodel.StructTp' metaObjectMofId='47D14F97E27B26A0EC5111DCCC8B8000600FE800' isStructureType='true'"
 * @generated
 */
public interface StructTp extends EObject {
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
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.GeneratedmetamodelPackage#getStructTp_Field1()
	 * @model required="true"
	 * @generated
	 */
	int getField1();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.StructTp#getField1 <em>Field1</em>}' attribute.
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
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.GeneratedmetamodelPackage#getStructTp_Field2()
	 * @model required="true"
	 * @generated
	 */
	String getField2();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.StructTp#getField2 <em>Field2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field2</em>' attribute.
	 * @see #getField2()
	 * @generated
	 */
	void setField2(String value);

	/**
	 * Returns the value of the '<em><b>Field3</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Field3</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field3</em>' containment reference.
	 * @see #setField3(StructInStructTp)
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.GeneratedmetamodelPackage#getStructTp_Field3()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	StructInStructTp getField3();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.StructTp#getField3 <em>Field3</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field3</em>' containment reference.
	 * @see #getField3()
	 * @generated
	 */
	void setField3(StructInStructTp value);

} // StructTp
