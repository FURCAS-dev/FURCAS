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
package org.eclipse.emf.query2.test.mm.testcases.case004;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>A4</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getOnePrimitive <em>One Primitive</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getOnePrimitiveOptional <em>One Primitive Optional</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getOnePrimitiveNotChangeable <em>One Primitive Not Changeable</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyPrimitive <em>Many Primitive</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyPrimitiveDouble <em>Many Primitive Double</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyPrimitiveUnique <em>Many Primitive Unique</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyPrimitiveOptional <em>Many Primitive Optional</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyPrimitiveNotChangeable <em>Many Primitive Not Changeable</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyPrimitiveOrdered <em>Many Primitive Ordered</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyPrimitiveOrderedUnique <em>Many Primitive Ordered Unique</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyPrimitiveOrderedNotChangeable <em>Many Primitive Ordered Not Changeable</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getOneBChangeable <em>One BChangeable</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getOneBNotChangeable <em>One BNot Changeable</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getOneBOptional <em>One BOptional</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyBs <em>Many Bs</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyBsUnique <em>Many Bs Unique</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyBsNotUnique <em>Many Bs Not Unique</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyBsOrdered <em>Many Bs Ordered</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyBsOrderedUnique <em>Many Bs Ordered Unique</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyBsNotOrdered <em>Many Bs Not Ordered</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyBsNotChangeable <em>Many Bs Not Changeable</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getA4()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case004.A4' metaObjectMofId='45F120A5BFE73C9EE91342E2330BAC6ECFF5FD7B' isStructureType='false' ova='oneBChangeable,oneBNotChangeable,oneBOptional,manyBs,manyBsUnique,manyBsNotUnique,manyBsOrdered,manyBsOrderedUnique,manyBsNotOrdered,manyBsNotChangeable'"
 * @generated
 */
public interface A4 extends EObject {
	/**
	 * Returns the value of the '<em><b>One Primitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>One Primitive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>One Primitive</em>' attribute.
	 * @see #setOnePrimitive(String)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getA4_OnePrimitive()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getOnePrimitive();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getOnePrimitive <em>One Primitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>One Primitive</em>' attribute.
	 * @see #getOnePrimitive()
	 * @generated
	 */
	void setOnePrimitive(String value);

	/**
	 * Returns the value of the '<em><b>One Primitive Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>One Primitive Optional</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>One Primitive Optional</em>' attribute.
	 * @see #setOnePrimitiveOptional(String)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getA4_OnePrimitiveOptional()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	String getOnePrimitiveOptional();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getOnePrimitiveOptional <em>One Primitive Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>One Primitive Optional</em>' attribute.
	 * @see #getOnePrimitiveOptional()
	 * @generated
	 */
	void setOnePrimitiveOptional(String value);

	/**
	 * Returns the value of the '<em><b>One Primitive Not Changeable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>One Primitive Not Changeable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>One Primitive Not Changeable</em>' attribute.
	 * @see #setOnePrimitiveNotChangeable(String)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getA4_OnePrimitiveNotChangeable()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getOnePrimitiveNotChangeable();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getOnePrimitiveNotChangeable <em>One Primitive Not Changeable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>One Primitive Not Changeable</em>' attribute.
	 * @see #getOnePrimitiveNotChangeable()
	 * @generated
	 */
	void setOnePrimitiveNotChangeable(String value);

	/**
	 * Returns the value of the '<em><b>Many Primitive</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Many Primitive</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Many Primitive</em>' attribute list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getA4_ManyPrimitive()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	EList<String> getManyPrimitive();

	/**
	 * Returns the value of the '<em><b>Many Primitive Double</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Double}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Many Primitive Double</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Many Primitive Double</em>' attribute list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getA4_ManyPrimitiveDouble()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	EList<Double> getManyPrimitiveDouble();

	/**
	 * Returns the value of the '<em><b>Many Primitive Unique</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Many Primitive Unique</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Many Primitive Unique</em>' attribute list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getA4_ManyPrimitiveUnique()
	 * @model ordered="false"
	 * @generated
	 */
	EList<String> getManyPrimitiveUnique();

	/**
	 * Returns the value of the '<em><b>Many Primitive Optional</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Many Primitive Optional</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Many Primitive Optional</em>' attribute list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getA4_ManyPrimitiveOptional()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	EList<String> getManyPrimitiveOptional();

	/**
	 * Returns the value of the '<em><b>Many Primitive Not Changeable</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Many Primitive Not Changeable</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Many Primitive Not Changeable</em>' attribute list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getA4_ManyPrimitiveNotChangeable()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	EList<String> getManyPrimitiveNotChangeable();

	/**
	 * Returns the value of the '<em><b>Many Primitive Ordered</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Many Primitive Ordered</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Many Primitive Ordered</em>' attribute list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getA4_ManyPrimitiveOrdered()
	 * @model unique="false" required="true"
	 * @generated
	 */
	EList<String> getManyPrimitiveOrdered();

	/**
	 * Returns the value of the '<em><b>Many Primitive Ordered Unique</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Many Primitive Ordered Unique</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Many Primitive Ordered Unique</em>' attribute list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getA4_ManyPrimitiveOrderedUnique()
	 * @model
	 * @generated
	 */
	EList<String> getManyPrimitiveOrderedUnique();

	/**
	 * Returns the value of the '<em><b>Many Primitive Ordered Not Changeable</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Many Primitive Ordered Not Changeable</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Many Primitive Ordered Not Changeable</em>' attribute list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getA4_ManyPrimitiveOrderedNotChangeable()
	 * @model unique="false" required="true"
	 * @generated
	 */
	EList<String> getManyPrimitiveOrderedNotChangeable();

	/**
	 * Returns the value of the '<em><b>One BChangeable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>One BChangeable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>One BChangeable</em>' containment reference.
	 * @see #setOneBChangeable(B4)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getA4_OneBChangeable()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='45F120A59E053A7CCB9140B33D738C63376B7BDB'"
	 * @generated
	 */
	B4 getOneBChangeable();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getOneBChangeable <em>One BChangeable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>One BChangeable</em>' containment reference.
	 * @see #getOneBChangeable()
	 * @generated
	 */
	void setOneBChangeable(B4 value);

	/**
	 * Returns the value of the '<em><b>One BNot Changeable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>One BNot Changeable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>One BNot Changeable</em>' containment reference.
	 * @see #setOneBNotChangeable(B4)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getA4_OneBNotChangeable()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='45F120A5EB2E83B38E4644363B9CAE099F6033F7'"
	 * @generated
	 */
	B4 getOneBNotChangeable();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getOneBNotChangeable <em>One BNot Changeable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>One BNot Changeable</em>' containment reference.
	 * @see #getOneBNotChangeable()
	 * @generated
	 */
	void setOneBNotChangeable(B4 value);

	/**
	 * Returns the value of the '<em><b>One BOptional</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>One BOptional</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>One BOptional</em>' containment reference.
	 * @see #setOneBOptional(B4)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getA4_OneBOptional()
	 * @model containment="true" resolveProxies="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='45F120A551FC35AC82334CAF1519B5ED9DDD2096'"
	 * @generated
	 */
	B4 getOneBOptional();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getOneBOptional <em>One BOptional</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>One BOptional</em>' containment reference.
	 * @see #getOneBOptional()
	 * @generated
	 */
	void setOneBOptional(B4 value);

	/**
	 * Returns the value of the '<em><b>Many Bs</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.testcases.case004.B4}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Many Bs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Many Bs</em>' containment reference list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getA4_ManyBs()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='45F120A57DA8BB49CF5B47983FA1A45F5E91D2DE'"
	 * @generated
	 */
	EList<B4> getManyBs();

	/**
	 * Returns the value of the '<em><b>Many Bs Unique</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.testcases.case004.B4}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Many Bs Unique</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Many Bs Unique</em>' containment reference list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getA4_ManyBsUnique()
	 * @model containment="true" resolveProxies="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='45F120A565D45E9A88DD4BA315E19173DF06DF60'"
	 * @generated
	 */
	EList<B4> getManyBsUnique();

	/**
	 * Returns the value of the '<em><b>Many Bs Not Unique</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.testcases.case004.B4}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Many Bs Not Unique</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Many Bs Not Unique</em>' containment reference list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getA4_ManyBsNotUnique()
	 * @model containment="true" resolveProxies="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='45F120A5693C70876E9E495D119EF9800F569335'"
	 * @generated
	 */
	EList<B4> getManyBsNotUnique();

	/**
	 * Returns the value of the '<em><b>Many Bs Ordered</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.testcases.case004.B4}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Many Bs Ordered</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Many Bs Ordered</em>' containment reference list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getA4_ManyBsOrdered()
	 * @model containment="true" resolveProxies="true"
	 *        annotation="http://sap.com/MOIN ovaMofId='45F120A543274D5F28604E88142CF00FFE5DBC62'"
	 * @generated
	 */
	EList<B4> getManyBsOrdered();

	/**
	 * Returns the value of the '<em><b>Many Bs Ordered Unique</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.testcases.case004.B4}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Many Bs Ordered Unique</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Many Bs Ordered Unique</em>' containment reference list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getA4_ManyBsOrderedUnique()
	 * @model containment="true" resolveProxies="true"
	 *        annotation="http://sap.com/MOIN ovaMofId='48074A15595702700C7E11DDA61E001558C93B47'"
	 * @generated
	 */
	EList<B4> getManyBsOrderedUnique();

	/**
	 * Returns the value of the '<em><b>Many Bs Not Ordered</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.testcases.case004.B4}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Many Bs Not Ordered</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Many Bs Not Ordered</em>' containment reference list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getA4_ManyBsNotOrdered()
	 * @model containment="true" resolveProxies="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='45F120A5227DAD86E98C4A3F2D48AD7E8D700E98'"
	 * @generated
	 */
	EList<B4> getManyBsNotOrdered();

	/**
	 * Returns the value of the '<em><b>Many Bs Not Changeable</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.testcases.case004.B4}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Many Bs Not Changeable</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Many Bs Not Changeable</em>' containment reference list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getA4_ManyBsNotChangeable()
	 * @model containment="true" resolveProxies="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='45F120A51D4A8A489392435B217AD4287C995D41'"
	 * @generated
	 */
	EList<B4> getManyBsNotChangeable();

} // A4
