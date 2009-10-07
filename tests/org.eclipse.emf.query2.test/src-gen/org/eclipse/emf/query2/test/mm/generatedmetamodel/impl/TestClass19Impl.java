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
package org.eclipse.emf.query2.test.mm.generatedmetamodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.query2.test.mm.generatedmetamodel.EnumTp;
import org.eclipse.emf.query2.test.mm.generatedmetamodel.GeneratedmetamodelPackage;
import org.eclipse.emf.query2.test.mm.generatedmetamodel.StructTp;
import org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass0;
import org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass1;
import org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass10;
import org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass11;
import org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass12;
import org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass13;
import org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass14;
import org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass15;
import org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass16;
import org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass17;
import org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass18;
import org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass19;
import org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass2;
import org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass3;
import org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass4;
import org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass5;
import org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass6;
import org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass7;
import org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass8;
import org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass9;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Class19</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrString0 <em>Attr String0</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrStringMultiValued0 <em>Attr String Multi Valued0</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrInt0 <em>Attr Int0</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrDouble0 <em>Attr Double0</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrString1 <em>Attr String1</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrStringMultiValued1 <em>Attr String Multi Valued1</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrInt1 <em>Attr Int1</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrDouble1 <em>Attr Double1</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrString2 <em>Attr String2</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrStringMultiValued2 <em>Attr String Multi Valued2</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrInt2 <em>Attr Int2</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrDouble2 <em>Attr Double2</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrString3 <em>Attr String3</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrStringMultiValued3 <em>Attr String Multi Valued3</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrInt3 <em>Attr Int3</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrDouble3 <em>Attr Double3</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrString4 <em>Attr String4</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrStringMultiValued4 <em>Attr String Multi Valued4</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrInt4 <em>Attr Int4</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrDouble4 <em>Attr Double4</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrString5 <em>Attr String5</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrStringMultiValued5 <em>Attr String Multi Valued5</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrInt5 <em>Attr Int5</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrDouble5 <em>Attr Double5</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrString6 <em>Attr String6</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrStringMultiValued6 <em>Attr String Multi Valued6</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrInt6 <em>Attr Int6</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrDouble6 <em>Attr Double6</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrString7 <em>Attr String7</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrStringMultiValued7 <em>Attr String Multi Valued7</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrInt7 <em>Attr Int7</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrDouble7 <em>Attr Double7</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrString8 <em>Attr String8</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrStringMultiValued8 <em>Attr String Multi Valued8</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrInt8 <em>Attr Int8</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrDouble8 <em>Attr Double8</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrString9 <em>Attr String9</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrStringMultiValued9 <em>Attr String Multi Valued9</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrInt9 <em>Attr Int9</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrDouble9 <em>Attr Double9</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrObjectValued0 <em>Attr Object Valued0</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrObjectValued1 <em>Attr Object Valued1</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrObjectValued2 <em>Attr Object Valued2</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrObjectValued3 <em>Attr Object Valued3</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrObjectValued4 <em>Attr Object Valued4</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrObjectValued5 <em>Attr Object Valued5</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrObjectValued6 <em>Attr Object Valued6</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrObjectValued7 <em>Attr Object Valued7</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrObjectValued8 <em>Attr Object Valued8</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrObjectValued9 <em>Attr Object Valued9</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrStruct <em>Attr Struct</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getAttrEnum <em>Attr Enum</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getReference19x0 <em>Reference19x0</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getReference19x1 <em>Reference19x1</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getReference19x2 <em>Reference19x2</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getReference19x3 <em>Reference19x3</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getReference19x4 <em>Reference19x4</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getReference19x5 <em>Reference19x5</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getReference19x6 <em>Reference19x6</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getReference19x7 <em>Reference19x7</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getReference19x8 <em>Reference19x8</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getReference19x9 <em>Reference19x9</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getReference19x10 <em>Reference19x10</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getReference19x11 <em>Reference19x11</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getReference19x12 <em>Reference19x12</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getReference19x13 <em>Reference19x13</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getReference19x14 <em>Reference19x14</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getReference19x15 <em>Reference19x15</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getReference19x16 <em>Reference19x16</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getReference19x17 <em>Reference19x17</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getReference19x18 <em>Reference19x18</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getReference19xRefElement <em>Reference19x Ref Element</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.TestClass19Impl#getReference19Composite <em>Reference19 Composite</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TestClass19Impl extends EObjectImpl implements TestClass19 {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttrString0() <em>Attr String0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrString0()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTR_STRING0_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttrString0() <em>Attr String0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrString0()
	 * @generated
	 * @ordered
	 */
	protected String attrString0 = ATTR_STRING0_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAttrStringMultiValued0() <em>Attr String Multi Valued0</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrStringMultiValued0()
	 * @generated
	 * @ordered
	 */
	protected EList<String> attrStringMultiValued0;

	/**
	 * The default value of the '{@link #getAttrInt0() <em>Attr Int0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrInt0()
	 * @generated
	 * @ordered
	 */
	protected static final int ATTR_INT0_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAttrInt0() <em>Attr Int0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrInt0()
	 * @generated
	 * @ordered
	 */
	protected int attrInt0 = ATTR_INT0_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttrDouble0() <em>Attr Double0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrDouble0()
	 * @generated
	 * @ordered
	 */
	protected static final double ATTR_DOUBLE0_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAttrDouble0() <em>Attr Double0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrDouble0()
	 * @generated
	 * @ordered
	 */
	protected double attrDouble0 = ATTR_DOUBLE0_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttrString1() <em>Attr String1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrString1()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTR_STRING1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttrString1() <em>Attr String1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrString1()
	 * @generated
	 * @ordered
	 */
	protected String attrString1 = ATTR_STRING1_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAttrStringMultiValued1() <em>Attr String Multi Valued1</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrStringMultiValued1()
	 * @generated
	 * @ordered
	 */
	protected EList<String> attrStringMultiValued1;

	/**
	 * The default value of the '{@link #getAttrInt1() <em>Attr Int1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrInt1()
	 * @generated
	 * @ordered
	 */
	protected static final int ATTR_INT1_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAttrInt1() <em>Attr Int1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrInt1()
	 * @generated
	 * @ordered
	 */
	protected int attrInt1 = ATTR_INT1_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttrDouble1() <em>Attr Double1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrDouble1()
	 * @generated
	 * @ordered
	 */
	protected static final double ATTR_DOUBLE1_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAttrDouble1() <em>Attr Double1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrDouble1()
	 * @generated
	 * @ordered
	 */
	protected double attrDouble1 = ATTR_DOUBLE1_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttrString2() <em>Attr String2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrString2()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTR_STRING2_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttrString2() <em>Attr String2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrString2()
	 * @generated
	 * @ordered
	 */
	protected String attrString2 = ATTR_STRING2_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAttrStringMultiValued2() <em>Attr String Multi Valued2</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrStringMultiValued2()
	 * @generated
	 * @ordered
	 */
	protected EList<String> attrStringMultiValued2;

	/**
	 * The default value of the '{@link #getAttrInt2() <em>Attr Int2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrInt2()
	 * @generated
	 * @ordered
	 */
	protected static final int ATTR_INT2_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAttrInt2() <em>Attr Int2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrInt2()
	 * @generated
	 * @ordered
	 */
	protected int attrInt2 = ATTR_INT2_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttrDouble2() <em>Attr Double2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrDouble2()
	 * @generated
	 * @ordered
	 */
	protected static final double ATTR_DOUBLE2_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAttrDouble2() <em>Attr Double2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrDouble2()
	 * @generated
	 * @ordered
	 */
	protected double attrDouble2 = ATTR_DOUBLE2_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttrString3() <em>Attr String3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrString3()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTR_STRING3_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttrString3() <em>Attr String3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrString3()
	 * @generated
	 * @ordered
	 */
	protected String attrString3 = ATTR_STRING3_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAttrStringMultiValued3() <em>Attr String Multi Valued3</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrStringMultiValued3()
	 * @generated
	 * @ordered
	 */
	protected EList<String> attrStringMultiValued3;

	/**
	 * The default value of the '{@link #getAttrInt3() <em>Attr Int3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrInt3()
	 * @generated
	 * @ordered
	 */
	protected static final int ATTR_INT3_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAttrInt3() <em>Attr Int3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrInt3()
	 * @generated
	 * @ordered
	 */
	protected int attrInt3 = ATTR_INT3_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttrDouble3() <em>Attr Double3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrDouble3()
	 * @generated
	 * @ordered
	 */
	protected static final double ATTR_DOUBLE3_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAttrDouble3() <em>Attr Double3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrDouble3()
	 * @generated
	 * @ordered
	 */
	protected double attrDouble3 = ATTR_DOUBLE3_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttrString4() <em>Attr String4</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrString4()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTR_STRING4_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttrString4() <em>Attr String4</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrString4()
	 * @generated
	 * @ordered
	 */
	protected String attrString4 = ATTR_STRING4_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAttrStringMultiValued4() <em>Attr String Multi Valued4</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrStringMultiValued4()
	 * @generated
	 * @ordered
	 */
	protected EList<String> attrStringMultiValued4;

	/**
	 * The default value of the '{@link #getAttrInt4() <em>Attr Int4</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrInt4()
	 * @generated
	 * @ordered
	 */
	protected static final int ATTR_INT4_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAttrInt4() <em>Attr Int4</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrInt4()
	 * @generated
	 * @ordered
	 */
	protected int attrInt4 = ATTR_INT4_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttrDouble4() <em>Attr Double4</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrDouble4()
	 * @generated
	 * @ordered
	 */
	protected static final double ATTR_DOUBLE4_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAttrDouble4() <em>Attr Double4</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrDouble4()
	 * @generated
	 * @ordered
	 */
	protected double attrDouble4 = ATTR_DOUBLE4_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttrString5() <em>Attr String5</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrString5()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTR_STRING5_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttrString5() <em>Attr String5</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrString5()
	 * @generated
	 * @ordered
	 */
	protected String attrString5 = ATTR_STRING5_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAttrStringMultiValued5() <em>Attr String Multi Valued5</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrStringMultiValued5()
	 * @generated
	 * @ordered
	 */
	protected EList<String> attrStringMultiValued5;

	/**
	 * The default value of the '{@link #getAttrInt5() <em>Attr Int5</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrInt5()
	 * @generated
	 * @ordered
	 */
	protected static final int ATTR_INT5_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAttrInt5() <em>Attr Int5</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrInt5()
	 * @generated
	 * @ordered
	 */
	protected int attrInt5 = ATTR_INT5_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttrDouble5() <em>Attr Double5</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrDouble5()
	 * @generated
	 * @ordered
	 */
	protected static final double ATTR_DOUBLE5_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAttrDouble5() <em>Attr Double5</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrDouble5()
	 * @generated
	 * @ordered
	 */
	protected double attrDouble5 = ATTR_DOUBLE5_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttrString6() <em>Attr String6</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrString6()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTR_STRING6_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttrString6() <em>Attr String6</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrString6()
	 * @generated
	 * @ordered
	 */
	protected String attrString6 = ATTR_STRING6_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAttrStringMultiValued6() <em>Attr String Multi Valued6</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrStringMultiValued6()
	 * @generated
	 * @ordered
	 */
	protected EList<String> attrStringMultiValued6;

	/**
	 * The default value of the '{@link #getAttrInt6() <em>Attr Int6</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrInt6()
	 * @generated
	 * @ordered
	 */
	protected static final int ATTR_INT6_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAttrInt6() <em>Attr Int6</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrInt6()
	 * @generated
	 * @ordered
	 */
	protected int attrInt6 = ATTR_INT6_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttrDouble6() <em>Attr Double6</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrDouble6()
	 * @generated
	 * @ordered
	 */
	protected static final double ATTR_DOUBLE6_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAttrDouble6() <em>Attr Double6</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrDouble6()
	 * @generated
	 * @ordered
	 */
	protected double attrDouble6 = ATTR_DOUBLE6_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttrString7() <em>Attr String7</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrString7()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTR_STRING7_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttrString7() <em>Attr String7</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrString7()
	 * @generated
	 * @ordered
	 */
	protected String attrString7 = ATTR_STRING7_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAttrStringMultiValued7() <em>Attr String Multi Valued7</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrStringMultiValued7()
	 * @generated
	 * @ordered
	 */
	protected EList<String> attrStringMultiValued7;

	/**
	 * The default value of the '{@link #getAttrInt7() <em>Attr Int7</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrInt7()
	 * @generated
	 * @ordered
	 */
	protected static final int ATTR_INT7_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAttrInt7() <em>Attr Int7</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrInt7()
	 * @generated
	 * @ordered
	 */
	protected int attrInt7 = ATTR_INT7_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttrDouble7() <em>Attr Double7</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrDouble7()
	 * @generated
	 * @ordered
	 */
	protected static final double ATTR_DOUBLE7_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAttrDouble7() <em>Attr Double7</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrDouble7()
	 * @generated
	 * @ordered
	 */
	protected double attrDouble7 = ATTR_DOUBLE7_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttrString8() <em>Attr String8</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrString8()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTR_STRING8_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttrString8() <em>Attr String8</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrString8()
	 * @generated
	 * @ordered
	 */
	protected String attrString8 = ATTR_STRING8_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAttrStringMultiValued8() <em>Attr String Multi Valued8</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrStringMultiValued8()
	 * @generated
	 * @ordered
	 */
	protected EList<String> attrStringMultiValued8;

	/**
	 * The default value of the '{@link #getAttrInt8() <em>Attr Int8</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrInt8()
	 * @generated
	 * @ordered
	 */
	protected static final int ATTR_INT8_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAttrInt8() <em>Attr Int8</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrInt8()
	 * @generated
	 * @ordered
	 */
	protected int attrInt8 = ATTR_INT8_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttrDouble8() <em>Attr Double8</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrDouble8()
	 * @generated
	 * @ordered
	 */
	protected static final double ATTR_DOUBLE8_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAttrDouble8() <em>Attr Double8</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrDouble8()
	 * @generated
	 * @ordered
	 */
	protected double attrDouble8 = ATTR_DOUBLE8_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttrString9() <em>Attr String9</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrString9()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTR_STRING9_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttrString9() <em>Attr String9</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrString9()
	 * @generated
	 * @ordered
	 */
	protected String attrString9 = ATTR_STRING9_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAttrStringMultiValued9() <em>Attr String Multi Valued9</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrStringMultiValued9()
	 * @generated
	 * @ordered
	 */
	protected EList<String> attrStringMultiValued9;

	/**
	 * The default value of the '{@link #getAttrInt9() <em>Attr Int9</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrInt9()
	 * @generated
	 * @ordered
	 */
	protected static final int ATTR_INT9_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAttrInt9() <em>Attr Int9</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrInt9()
	 * @generated
	 * @ordered
	 */
	protected int attrInt9 = ATTR_INT9_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttrDouble9() <em>Attr Double9</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrDouble9()
	 * @generated
	 * @ordered
	 */
	protected static final double ATTR_DOUBLE9_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAttrDouble9() <em>Attr Double9</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrDouble9()
	 * @generated
	 * @ordered
	 */
	protected double attrDouble9 = ATTR_DOUBLE9_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAttrObjectValued0() <em>Attr Object Valued0</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrObjectValued0()
	 * @generated
	 * @ordered
	 */
	protected TestClass0 attrObjectValued0;

	/**
	 * The cached value of the '{@link #getAttrObjectValued1() <em>Attr Object Valued1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrObjectValued1()
	 * @generated
	 * @ordered
	 */
	protected TestClass1 attrObjectValued1;

	/**
	 * The cached value of the '{@link #getAttrObjectValued2() <em>Attr Object Valued2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrObjectValued2()
	 * @generated
	 * @ordered
	 */
	protected TestClass2 attrObjectValued2;

	/**
	 * The cached value of the '{@link #getAttrObjectValued3() <em>Attr Object Valued3</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrObjectValued3()
	 * @generated
	 * @ordered
	 */
	protected TestClass3 attrObjectValued3;

	/**
	 * The cached value of the '{@link #getAttrObjectValued4() <em>Attr Object Valued4</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrObjectValued4()
	 * @generated
	 * @ordered
	 */
	protected TestClass4 attrObjectValued4;

	/**
	 * The cached value of the '{@link #getAttrObjectValued5() <em>Attr Object Valued5</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrObjectValued5()
	 * @generated
	 * @ordered
	 */
	protected TestClass5 attrObjectValued5;

	/**
	 * The cached value of the '{@link #getAttrObjectValued6() <em>Attr Object Valued6</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrObjectValued6()
	 * @generated
	 * @ordered
	 */
	protected TestClass6 attrObjectValued6;

	/**
	 * The cached value of the '{@link #getAttrObjectValued7() <em>Attr Object Valued7</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrObjectValued7()
	 * @generated
	 * @ordered
	 */
	protected TestClass7 attrObjectValued7;

	/**
	 * The cached value of the '{@link #getAttrObjectValued8() <em>Attr Object Valued8</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrObjectValued8()
	 * @generated
	 * @ordered
	 */
	protected TestClass8 attrObjectValued8;

	/**
	 * The cached value of the '{@link #getAttrObjectValued9() <em>Attr Object Valued9</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrObjectValued9()
	 * @generated
	 * @ordered
	 */
	protected TestClass9 attrObjectValued9;

	/**
	 * The cached value of the '{@link #getAttrStruct() <em>Attr Struct</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrStruct()
	 * @generated
	 * @ordered
	 */
	protected StructTp attrStruct;

	/**
	 * The default value of the '{@link #getAttrEnum() <em>Attr Enum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrEnum()
	 * @generated
	 * @ordered
	 */
	protected static final EnumTp ATTR_ENUM_EDEFAULT = EnumTp.LABEL1;

	/**
	 * The cached value of the '{@link #getAttrEnum() <em>Attr Enum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrEnum()
	 * @generated
	 * @ordered
	 */
	protected EnumTp attrEnum = ATTR_ENUM_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReference19x0() <em>Reference19x0</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference19x0()
	 * @generated
	 * @ordered
	 */
	protected EList<TestClass0> reference19x0;

	/**
	 * The cached value of the '{@link #getReference19x1() <em>Reference19x1</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference19x1()
	 * @generated
	 * @ordered
	 */
	protected EList<TestClass1> reference19x1;

	/**
	 * The cached value of the '{@link #getReference19x2() <em>Reference19x2</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference19x2()
	 * @generated
	 * @ordered
	 */
	protected EList<TestClass2> reference19x2;

	/**
	 * The cached value of the '{@link #getReference19x3() <em>Reference19x3</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference19x3()
	 * @generated
	 * @ordered
	 */
	protected EList<TestClass3> reference19x3;

	/**
	 * The cached value of the '{@link #getReference19x4() <em>Reference19x4</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference19x4()
	 * @generated
	 * @ordered
	 */
	protected EList<TestClass4> reference19x4;

	/**
	 * The cached value of the '{@link #getReference19x5() <em>Reference19x5</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference19x5()
	 * @generated
	 * @ordered
	 */
	protected EList<TestClass5> reference19x5;

	/**
	 * The cached value of the '{@link #getReference19x6() <em>Reference19x6</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference19x6()
	 * @generated
	 * @ordered
	 */
	protected EList<TestClass6> reference19x6;

	/**
	 * The cached value of the '{@link #getReference19x7() <em>Reference19x7</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference19x7()
	 * @generated
	 * @ordered
	 */
	protected EList<TestClass7> reference19x7;

	/**
	 * The cached value of the '{@link #getReference19x8() <em>Reference19x8</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference19x8()
	 * @generated
	 * @ordered
	 */
	protected EList<TestClass8> reference19x8;

	/**
	 * The cached value of the '{@link #getReference19x9() <em>Reference19x9</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference19x9()
	 * @generated
	 * @ordered
	 */
	protected EList<TestClass9> reference19x9;

	/**
	 * The cached value of the '{@link #getReference19x10() <em>Reference19x10</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference19x10()
	 * @generated
	 * @ordered
	 */
	protected EList<TestClass10> reference19x10;

	/**
	 * The cached value of the '{@link #getReference19x11() <em>Reference19x11</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference19x11()
	 * @generated
	 * @ordered
	 */
	protected EList<TestClass11> reference19x11;

	/**
	 * The cached value of the '{@link #getReference19x12() <em>Reference19x12</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference19x12()
	 * @generated
	 * @ordered
	 */
	protected EList<TestClass12> reference19x12;

	/**
	 * The cached value of the '{@link #getReference19x13() <em>Reference19x13</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference19x13()
	 * @generated
	 * @ordered
	 */
	protected EList<TestClass13> reference19x13;

	/**
	 * The cached value of the '{@link #getReference19x14() <em>Reference19x14</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference19x14()
	 * @generated
	 * @ordered
	 */
	protected EList<TestClass14> reference19x14;

	/**
	 * The cached value of the '{@link #getReference19x15() <em>Reference19x15</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference19x15()
	 * @generated
	 * @ordered
	 */
	protected EList<TestClass15> reference19x15;

	/**
	 * The cached value of the '{@link #getReference19x16() <em>Reference19x16</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference19x16()
	 * @generated
	 * @ordered
	 */
	protected EList<TestClass16> reference19x16;

	/**
	 * The cached value of the '{@link #getReference19x17() <em>Reference19x17</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference19x17()
	 * @generated
	 * @ordered
	 */
	protected EList<TestClass17> reference19x17;

	/**
	 * The cached value of the '{@link #getReference19x18() <em>Reference19x18</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference19x18()
	 * @generated
	 * @ordered
	 */
	protected EList<TestClass18> reference19x18;

	/**
	 * The cached value of the '{@link #getReference19xRefElement() <em>Reference19x Ref Element</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference19xRefElement()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> reference19xRefElement;

	/**
	 * The cached value of the '{@link #getReference19Composite() <em>Reference19 Composite</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference19Composite()
	 * @generated
	 * @ordered
	 */
	protected EList<TestClass19> reference19Composite;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestClass19Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratedmetamodelPackage.eINSTANCE.getTestClass19();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAttrString0() {
		return attrString0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrString0(String newAttrString0) {
		String oldAttrString0 = attrString0;
		attrString0 = newAttrString0;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING0, oldAttrString0, attrString0));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getAttrStringMultiValued0() {
		if (attrStringMultiValued0 == null) {
			attrStringMultiValued0 = new EDataTypeEList<String>(String.class, this, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED0);
		}
		return attrStringMultiValued0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAttrInt0() {
		return attrInt0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrInt0(int newAttrInt0) {
		int oldAttrInt0 = attrInt0;
		attrInt0 = newAttrInt0;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT0, oldAttrInt0, attrInt0));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAttrDouble0() {
		return attrDouble0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrDouble0(double newAttrDouble0) {
		double oldAttrDouble0 = attrDouble0;
		attrDouble0 = newAttrDouble0;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE0, oldAttrDouble0, attrDouble0));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAttrString1() {
		return attrString1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrString1(String newAttrString1) {
		String oldAttrString1 = attrString1;
		attrString1 = newAttrString1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING1, oldAttrString1, attrString1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getAttrStringMultiValued1() {
		if (attrStringMultiValued1 == null) {
			attrStringMultiValued1 = new EDataTypeEList<String>(String.class, this, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED1);
		}
		return attrStringMultiValued1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAttrInt1() {
		return attrInt1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrInt1(int newAttrInt1) {
		int oldAttrInt1 = attrInt1;
		attrInt1 = newAttrInt1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT1, oldAttrInt1, attrInt1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAttrDouble1() {
		return attrDouble1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrDouble1(double newAttrDouble1) {
		double oldAttrDouble1 = attrDouble1;
		attrDouble1 = newAttrDouble1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE1, oldAttrDouble1, attrDouble1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAttrString2() {
		return attrString2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrString2(String newAttrString2) {
		String oldAttrString2 = attrString2;
		attrString2 = newAttrString2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING2, oldAttrString2, attrString2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getAttrStringMultiValued2() {
		if (attrStringMultiValued2 == null) {
			attrStringMultiValued2 = new EDataTypeEList<String>(String.class, this, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED2);
		}
		return attrStringMultiValued2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAttrInt2() {
		return attrInt2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrInt2(int newAttrInt2) {
		int oldAttrInt2 = attrInt2;
		attrInt2 = newAttrInt2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT2, oldAttrInt2, attrInt2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAttrDouble2() {
		return attrDouble2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrDouble2(double newAttrDouble2) {
		double oldAttrDouble2 = attrDouble2;
		attrDouble2 = newAttrDouble2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE2, oldAttrDouble2, attrDouble2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAttrString3() {
		return attrString3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrString3(String newAttrString3) {
		String oldAttrString3 = attrString3;
		attrString3 = newAttrString3;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING3, oldAttrString3, attrString3));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getAttrStringMultiValued3() {
		if (attrStringMultiValued3 == null) {
			attrStringMultiValued3 = new EDataTypeEList<String>(String.class, this, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED3);
		}
		return attrStringMultiValued3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAttrInt3() {
		return attrInt3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrInt3(int newAttrInt3) {
		int oldAttrInt3 = attrInt3;
		attrInt3 = newAttrInt3;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT3, oldAttrInt3, attrInt3));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAttrDouble3() {
		return attrDouble3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrDouble3(double newAttrDouble3) {
		double oldAttrDouble3 = attrDouble3;
		attrDouble3 = newAttrDouble3;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE3, oldAttrDouble3, attrDouble3));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAttrString4() {
		return attrString4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrString4(String newAttrString4) {
		String oldAttrString4 = attrString4;
		attrString4 = newAttrString4;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING4, oldAttrString4, attrString4));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getAttrStringMultiValued4() {
		if (attrStringMultiValued4 == null) {
			attrStringMultiValued4 = new EDataTypeEList<String>(String.class, this, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED4);
		}
		return attrStringMultiValued4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAttrInt4() {
		return attrInt4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrInt4(int newAttrInt4) {
		int oldAttrInt4 = attrInt4;
		attrInt4 = newAttrInt4;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT4, oldAttrInt4, attrInt4));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAttrDouble4() {
		return attrDouble4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrDouble4(double newAttrDouble4) {
		double oldAttrDouble4 = attrDouble4;
		attrDouble4 = newAttrDouble4;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE4, oldAttrDouble4, attrDouble4));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAttrString5() {
		return attrString5;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrString5(String newAttrString5) {
		String oldAttrString5 = attrString5;
		attrString5 = newAttrString5;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING5, oldAttrString5, attrString5));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getAttrStringMultiValued5() {
		if (attrStringMultiValued5 == null) {
			attrStringMultiValued5 = new EDataTypeEList<String>(String.class, this, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED5);
		}
		return attrStringMultiValued5;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAttrInt5() {
		return attrInt5;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrInt5(int newAttrInt5) {
		int oldAttrInt5 = attrInt5;
		attrInt5 = newAttrInt5;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT5, oldAttrInt5, attrInt5));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAttrDouble5() {
		return attrDouble5;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrDouble5(double newAttrDouble5) {
		double oldAttrDouble5 = attrDouble5;
		attrDouble5 = newAttrDouble5;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE5, oldAttrDouble5, attrDouble5));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAttrString6() {
		return attrString6;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrString6(String newAttrString6) {
		String oldAttrString6 = attrString6;
		attrString6 = newAttrString6;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING6, oldAttrString6, attrString6));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getAttrStringMultiValued6() {
		if (attrStringMultiValued6 == null) {
			attrStringMultiValued6 = new EDataTypeEList<String>(String.class, this, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED6);
		}
		return attrStringMultiValued6;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAttrInt6() {
		return attrInt6;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrInt6(int newAttrInt6) {
		int oldAttrInt6 = attrInt6;
		attrInt6 = newAttrInt6;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT6, oldAttrInt6, attrInt6));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAttrDouble6() {
		return attrDouble6;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrDouble6(double newAttrDouble6) {
		double oldAttrDouble6 = attrDouble6;
		attrDouble6 = newAttrDouble6;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE6, oldAttrDouble6, attrDouble6));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAttrString7() {
		return attrString7;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrString7(String newAttrString7) {
		String oldAttrString7 = attrString7;
		attrString7 = newAttrString7;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING7, oldAttrString7, attrString7));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getAttrStringMultiValued7() {
		if (attrStringMultiValued7 == null) {
			attrStringMultiValued7 = new EDataTypeEList<String>(String.class, this, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED7);
		}
		return attrStringMultiValued7;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAttrInt7() {
		return attrInt7;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrInt7(int newAttrInt7) {
		int oldAttrInt7 = attrInt7;
		attrInt7 = newAttrInt7;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT7, oldAttrInt7, attrInt7));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAttrDouble7() {
		return attrDouble7;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrDouble7(double newAttrDouble7) {
		double oldAttrDouble7 = attrDouble7;
		attrDouble7 = newAttrDouble7;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE7, oldAttrDouble7, attrDouble7));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAttrString8() {
		return attrString8;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrString8(String newAttrString8) {
		String oldAttrString8 = attrString8;
		attrString8 = newAttrString8;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING8, oldAttrString8, attrString8));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getAttrStringMultiValued8() {
		if (attrStringMultiValued8 == null) {
			attrStringMultiValued8 = new EDataTypeEList<String>(String.class, this, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED8);
		}
		return attrStringMultiValued8;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAttrInt8() {
		return attrInt8;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrInt8(int newAttrInt8) {
		int oldAttrInt8 = attrInt8;
		attrInt8 = newAttrInt8;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT8, oldAttrInt8, attrInt8));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAttrDouble8() {
		return attrDouble8;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrDouble8(double newAttrDouble8) {
		double oldAttrDouble8 = attrDouble8;
		attrDouble8 = newAttrDouble8;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE8, oldAttrDouble8, attrDouble8));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAttrString9() {
		return attrString9;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrString9(String newAttrString9) {
		String oldAttrString9 = attrString9;
		attrString9 = newAttrString9;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING9, oldAttrString9, attrString9));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getAttrStringMultiValued9() {
		if (attrStringMultiValued9 == null) {
			attrStringMultiValued9 = new EDataTypeEList<String>(String.class, this, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED9);
		}
		return attrStringMultiValued9;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAttrInt9() {
		return attrInt9;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrInt9(int newAttrInt9) {
		int oldAttrInt9 = attrInt9;
		attrInt9 = newAttrInt9;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT9, oldAttrInt9, attrInt9));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAttrDouble9() {
		return attrDouble9;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrDouble9(double newAttrDouble9) {
		double oldAttrDouble9 = attrDouble9;
		attrDouble9 = newAttrDouble9;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE9, oldAttrDouble9, attrDouble9));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass0 getAttrObjectValued0() {
		if (attrObjectValued0 != null && attrObjectValued0.eIsProxy()) {
			InternalEObject oldAttrObjectValued0 = (InternalEObject)attrObjectValued0;
			attrObjectValued0 = (TestClass0)eResolveProxy(oldAttrObjectValued0);
			if (attrObjectValued0 != oldAttrObjectValued0) {
				InternalEObject newAttrObjectValued0 = (InternalEObject)attrObjectValued0;
				NotificationChain msgs = oldAttrObjectValued0.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED0, null, null);
				if (newAttrObjectValued0.eInternalContainer() == null) {
					msgs = newAttrObjectValued0.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED0, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED0, oldAttrObjectValued0, attrObjectValued0));
			}
		}
		return attrObjectValued0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass0 basicGetAttrObjectValued0() {
		return attrObjectValued0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAttrObjectValued0(TestClass0 newAttrObjectValued0, NotificationChain msgs) {
		TestClass0 oldAttrObjectValued0 = attrObjectValued0;
		attrObjectValued0 = newAttrObjectValued0;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED0, oldAttrObjectValued0, newAttrObjectValued0);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrObjectValued0(TestClass0 newAttrObjectValued0) {
		if (newAttrObjectValued0 != attrObjectValued0) {
			NotificationChain msgs = null;
			if (attrObjectValued0 != null)
				msgs = ((InternalEObject)attrObjectValued0).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED0, null, msgs);
			if (newAttrObjectValued0 != null)
				msgs = ((InternalEObject)newAttrObjectValued0).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED0, null, msgs);
			msgs = basicSetAttrObjectValued0(newAttrObjectValued0, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED0, newAttrObjectValued0, newAttrObjectValued0));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass1 getAttrObjectValued1() {
		if (attrObjectValued1 != null && attrObjectValued1.eIsProxy()) {
			InternalEObject oldAttrObjectValued1 = (InternalEObject)attrObjectValued1;
			attrObjectValued1 = (TestClass1)eResolveProxy(oldAttrObjectValued1);
			if (attrObjectValued1 != oldAttrObjectValued1) {
				InternalEObject newAttrObjectValued1 = (InternalEObject)attrObjectValued1;
				NotificationChain msgs = oldAttrObjectValued1.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED1, null, null);
				if (newAttrObjectValued1.eInternalContainer() == null) {
					msgs = newAttrObjectValued1.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED1, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED1, oldAttrObjectValued1, attrObjectValued1));
			}
		}
		return attrObjectValued1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass1 basicGetAttrObjectValued1() {
		return attrObjectValued1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAttrObjectValued1(TestClass1 newAttrObjectValued1, NotificationChain msgs) {
		TestClass1 oldAttrObjectValued1 = attrObjectValued1;
		attrObjectValued1 = newAttrObjectValued1;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED1, oldAttrObjectValued1, newAttrObjectValued1);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrObjectValued1(TestClass1 newAttrObjectValued1) {
		if (newAttrObjectValued1 != attrObjectValued1) {
			NotificationChain msgs = null;
			if (attrObjectValued1 != null)
				msgs = ((InternalEObject)attrObjectValued1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED1, null, msgs);
			if (newAttrObjectValued1 != null)
				msgs = ((InternalEObject)newAttrObjectValued1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED1, null, msgs);
			msgs = basicSetAttrObjectValued1(newAttrObjectValued1, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED1, newAttrObjectValued1, newAttrObjectValued1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass2 getAttrObjectValued2() {
		if (attrObjectValued2 != null && attrObjectValued2.eIsProxy()) {
			InternalEObject oldAttrObjectValued2 = (InternalEObject)attrObjectValued2;
			attrObjectValued2 = (TestClass2)eResolveProxy(oldAttrObjectValued2);
			if (attrObjectValued2 != oldAttrObjectValued2) {
				InternalEObject newAttrObjectValued2 = (InternalEObject)attrObjectValued2;
				NotificationChain msgs = oldAttrObjectValued2.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED2, null, null);
				if (newAttrObjectValued2.eInternalContainer() == null) {
					msgs = newAttrObjectValued2.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED2, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED2, oldAttrObjectValued2, attrObjectValued2));
			}
		}
		return attrObjectValued2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass2 basicGetAttrObjectValued2() {
		return attrObjectValued2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAttrObjectValued2(TestClass2 newAttrObjectValued2, NotificationChain msgs) {
		TestClass2 oldAttrObjectValued2 = attrObjectValued2;
		attrObjectValued2 = newAttrObjectValued2;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED2, oldAttrObjectValued2, newAttrObjectValued2);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrObjectValued2(TestClass2 newAttrObjectValued2) {
		if (newAttrObjectValued2 != attrObjectValued2) {
			NotificationChain msgs = null;
			if (attrObjectValued2 != null)
				msgs = ((InternalEObject)attrObjectValued2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED2, null, msgs);
			if (newAttrObjectValued2 != null)
				msgs = ((InternalEObject)newAttrObjectValued2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED2, null, msgs);
			msgs = basicSetAttrObjectValued2(newAttrObjectValued2, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED2, newAttrObjectValued2, newAttrObjectValued2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass3 getAttrObjectValued3() {
		if (attrObjectValued3 != null && attrObjectValued3.eIsProxy()) {
			InternalEObject oldAttrObjectValued3 = (InternalEObject)attrObjectValued3;
			attrObjectValued3 = (TestClass3)eResolveProxy(oldAttrObjectValued3);
			if (attrObjectValued3 != oldAttrObjectValued3) {
				InternalEObject newAttrObjectValued3 = (InternalEObject)attrObjectValued3;
				NotificationChain msgs = oldAttrObjectValued3.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED3, null, null);
				if (newAttrObjectValued3.eInternalContainer() == null) {
					msgs = newAttrObjectValued3.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED3, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED3, oldAttrObjectValued3, attrObjectValued3));
			}
		}
		return attrObjectValued3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass3 basicGetAttrObjectValued3() {
		return attrObjectValued3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAttrObjectValued3(TestClass3 newAttrObjectValued3, NotificationChain msgs) {
		TestClass3 oldAttrObjectValued3 = attrObjectValued3;
		attrObjectValued3 = newAttrObjectValued3;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED3, oldAttrObjectValued3, newAttrObjectValued3);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrObjectValued3(TestClass3 newAttrObjectValued3) {
		if (newAttrObjectValued3 != attrObjectValued3) {
			NotificationChain msgs = null;
			if (attrObjectValued3 != null)
				msgs = ((InternalEObject)attrObjectValued3).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED3, null, msgs);
			if (newAttrObjectValued3 != null)
				msgs = ((InternalEObject)newAttrObjectValued3).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED3, null, msgs);
			msgs = basicSetAttrObjectValued3(newAttrObjectValued3, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED3, newAttrObjectValued3, newAttrObjectValued3));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass4 getAttrObjectValued4() {
		if (attrObjectValued4 != null && attrObjectValued4.eIsProxy()) {
			InternalEObject oldAttrObjectValued4 = (InternalEObject)attrObjectValued4;
			attrObjectValued4 = (TestClass4)eResolveProxy(oldAttrObjectValued4);
			if (attrObjectValued4 != oldAttrObjectValued4) {
				InternalEObject newAttrObjectValued4 = (InternalEObject)attrObjectValued4;
				NotificationChain msgs = oldAttrObjectValued4.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED4, null, null);
				if (newAttrObjectValued4.eInternalContainer() == null) {
					msgs = newAttrObjectValued4.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED4, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED4, oldAttrObjectValued4, attrObjectValued4));
			}
		}
		return attrObjectValued4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass4 basicGetAttrObjectValued4() {
		return attrObjectValued4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAttrObjectValued4(TestClass4 newAttrObjectValued4, NotificationChain msgs) {
		TestClass4 oldAttrObjectValued4 = attrObjectValued4;
		attrObjectValued4 = newAttrObjectValued4;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED4, oldAttrObjectValued4, newAttrObjectValued4);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrObjectValued4(TestClass4 newAttrObjectValued4) {
		if (newAttrObjectValued4 != attrObjectValued4) {
			NotificationChain msgs = null;
			if (attrObjectValued4 != null)
				msgs = ((InternalEObject)attrObjectValued4).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED4, null, msgs);
			if (newAttrObjectValued4 != null)
				msgs = ((InternalEObject)newAttrObjectValued4).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED4, null, msgs);
			msgs = basicSetAttrObjectValued4(newAttrObjectValued4, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED4, newAttrObjectValued4, newAttrObjectValued4));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass5 getAttrObjectValued5() {
		if (attrObjectValued5 != null && attrObjectValued5.eIsProxy()) {
			InternalEObject oldAttrObjectValued5 = (InternalEObject)attrObjectValued5;
			attrObjectValued5 = (TestClass5)eResolveProxy(oldAttrObjectValued5);
			if (attrObjectValued5 != oldAttrObjectValued5) {
				InternalEObject newAttrObjectValued5 = (InternalEObject)attrObjectValued5;
				NotificationChain msgs = oldAttrObjectValued5.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED5, null, null);
				if (newAttrObjectValued5.eInternalContainer() == null) {
					msgs = newAttrObjectValued5.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED5, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED5, oldAttrObjectValued5, attrObjectValued5));
			}
		}
		return attrObjectValued5;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass5 basicGetAttrObjectValued5() {
		return attrObjectValued5;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAttrObjectValued5(TestClass5 newAttrObjectValued5, NotificationChain msgs) {
		TestClass5 oldAttrObjectValued5 = attrObjectValued5;
		attrObjectValued5 = newAttrObjectValued5;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED5, oldAttrObjectValued5, newAttrObjectValued5);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrObjectValued5(TestClass5 newAttrObjectValued5) {
		if (newAttrObjectValued5 != attrObjectValued5) {
			NotificationChain msgs = null;
			if (attrObjectValued5 != null)
				msgs = ((InternalEObject)attrObjectValued5).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED5, null, msgs);
			if (newAttrObjectValued5 != null)
				msgs = ((InternalEObject)newAttrObjectValued5).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED5, null, msgs);
			msgs = basicSetAttrObjectValued5(newAttrObjectValued5, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED5, newAttrObjectValued5, newAttrObjectValued5));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass6 getAttrObjectValued6() {
		if (attrObjectValued6 != null && attrObjectValued6.eIsProxy()) {
			InternalEObject oldAttrObjectValued6 = (InternalEObject)attrObjectValued6;
			attrObjectValued6 = (TestClass6)eResolveProxy(oldAttrObjectValued6);
			if (attrObjectValued6 != oldAttrObjectValued6) {
				InternalEObject newAttrObjectValued6 = (InternalEObject)attrObjectValued6;
				NotificationChain msgs = oldAttrObjectValued6.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED6, null, null);
				if (newAttrObjectValued6.eInternalContainer() == null) {
					msgs = newAttrObjectValued6.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED6, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED6, oldAttrObjectValued6, attrObjectValued6));
			}
		}
		return attrObjectValued6;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass6 basicGetAttrObjectValued6() {
		return attrObjectValued6;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAttrObjectValued6(TestClass6 newAttrObjectValued6, NotificationChain msgs) {
		TestClass6 oldAttrObjectValued6 = attrObjectValued6;
		attrObjectValued6 = newAttrObjectValued6;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED6, oldAttrObjectValued6, newAttrObjectValued6);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrObjectValued6(TestClass6 newAttrObjectValued6) {
		if (newAttrObjectValued6 != attrObjectValued6) {
			NotificationChain msgs = null;
			if (attrObjectValued6 != null)
				msgs = ((InternalEObject)attrObjectValued6).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED6, null, msgs);
			if (newAttrObjectValued6 != null)
				msgs = ((InternalEObject)newAttrObjectValued6).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED6, null, msgs);
			msgs = basicSetAttrObjectValued6(newAttrObjectValued6, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED6, newAttrObjectValued6, newAttrObjectValued6));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass7 getAttrObjectValued7() {
		if (attrObjectValued7 != null && attrObjectValued7.eIsProxy()) {
			InternalEObject oldAttrObjectValued7 = (InternalEObject)attrObjectValued7;
			attrObjectValued7 = (TestClass7)eResolveProxy(oldAttrObjectValued7);
			if (attrObjectValued7 != oldAttrObjectValued7) {
				InternalEObject newAttrObjectValued7 = (InternalEObject)attrObjectValued7;
				NotificationChain msgs = oldAttrObjectValued7.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED7, null, null);
				if (newAttrObjectValued7.eInternalContainer() == null) {
					msgs = newAttrObjectValued7.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED7, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED7, oldAttrObjectValued7, attrObjectValued7));
			}
		}
		return attrObjectValued7;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass7 basicGetAttrObjectValued7() {
		return attrObjectValued7;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAttrObjectValued7(TestClass7 newAttrObjectValued7, NotificationChain msgs) {
		TestClass7 oldAttrObjectValued7 = attrObjectValued7;
		attrObjectValued7 = newAttrObjectValued7;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED7, oldAttrObjectValued7, newAttrObjectValued7);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrObjectValued7(TestClass7 newAttrObjectValued7) {
		if (newAttrObjectValued7 != attrObjectValued7) {
			NotificationChain msgs = null;
			if (attrObjectValued7 != null)
				msgs = ((InternalEObject)attrObjectValued7).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED7, null, msgs);
			if (newAttrObjectValued7 != null)
				msgs = ((InternalEObject)newAttrObjectValued7).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED7, null, msgs);
			msgs = basicSetAttrObjectValued7(newAttrObjectValued7, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED7, newAttrObjectValued7, newAttrObjectValued7));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass8 getAttrObjectValued8() {
		if (attrObjectValued8 != null && attrObjectValued8.eIsProxy()) {
			InternalEObject oldAttrObjectValued8 = (InternalEObject)attrObjectValued8;
			attrObjectValued8 = (TestClass8)eResolveProxy(oldAttrObjectValued8);
			if (attrObjectValued8 != oldAttrObjectValued8) {
				InternalEObject newAttrObjectValued8 = (InternalEObject)attrObjectValued8;
				NotificationChain msgs = oldAttrObjectValued8.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED8, null, null);
				if (newAttrObjectValued8.eInternalContainer() == null) {
					msgs = newAttrObjectValued8.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED8, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED8, oldAttrObjectValued8, attrObjectValued8));
			}
		}
		return attrObjectValued8;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass8 basicGetAttrObjectValued8() {
		return attrObjectValued8;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAttrObjectValued8(TestClass8 newAttrObjectValued8, NotificationChain msgs) {
		TestClass8 oldAttrObjectValued8 = attrObjectValued8;
		attrObjectValued8 = newAttrObjectValued8;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED8, oldAttrObjectValued8, newAttrObjectValued8);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrObjectValued8(TestClass8 newAttrObjectValued8) {
		if (newAttrObjectValued8 != attrObjectValued8) {
			NotificationChain msgs = null;
			if (attrObjectValued8 != null)
				msgs = ((InternalEObject)attrObjectValued8).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED8, null, msgs);
			if (newAttrObjectValued8 != null)
				msgs = ((InternalEObject)newAttrObjectValued8).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED8, null, msgs);
			msgs = basicSetAttrObjectValued8(newAttrObjectValued8, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED8, newAttrObjectValued8, newAttrObjectValued8));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass9 getAttrObjectValued9() {
		if (attrObjectValued9 != null && attrObjectValued9.eIsProxy()) {
			InternalEObject oldAttrObjectValued9 = (InternalEObject)attrObjectValued9;
			attrObjectValued9 = (TestClass9)eResolveProxy(oldAttrObjectValued9);
			if (attrObjectValued9 != oldAttrObjectValued9) {
				InternalEObject newAttrObjectValued9 = (InternalEObject)attrObjectValued9;
				NotificationChain msgs = oldAttrObjectValued9.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED9, null, null);
				if (newAttrObjectValued9.eInternalContainer() == null) {
					msgs = newAttrObjectValued9.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED9, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED9, oldAttrObjectValued9, attrObjectValued9));
			}
		}
		return attrObjectValued9;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass9 basicGetAttrObjectValued9() {
		return attrObjectValued9;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAttrObjectValued9(TestClass9 newAttrObjectValued9, NotificationChain msgs) {
		TestClass9 oldAttrObjectValued9 = attrObjectValued9;
		attrObjectValued9 = newAttrObjectValued9;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED9, oldAttrObjectValued9, newAttrObjectValued9);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrObjectValued9(TestClass9 newAttrObjectValued9) {
		if (newAttrObjectValued9 != attrObjectValued9) {
			NotificationChain msgs = null;
			if (attrObjectValued9 != null)
				msgs = ((InternalEObject)attrObjectValued9).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED9, null, msgs);
			if (newAttrObjectValued9 != null)
				msgs = ((InternalEObject)newAttrObjectValued9).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED9, null, msgs);
			msgs = basicSetAttrObjectValued9(newAttrObjectValued9, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED9, newAttrObjectValued9, newAttrObjectValued9));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructTp getAttrStruct() {
		if (attrStruct != null && attrStruct.eIsProxy()) {
			InternalEObject oldAttrStruct = (InternalEObject)attrStruct;
			attrStruct = (StructTp)eResolveProxy(oldAttrStruct);
			if (attrStruct != oldAttrStruct) {
				InternalEObject newAttrStruct = (InternalEObject)attrStruct;
				NotificationChain msgs = oldAttrStruct.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRUCT, null, null);
				if (newAttrStruct.eInternalContainer() == null) {
					msgs = newAttrStruct.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRUCT, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRUCT, oldAttrStruct, attrStruct));
			}
		}
		return attrStruct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructTp basicGetAttrStruct() {
		return attrStruct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAttrStruct(StructTp newAttrStruct, NotificationChain msgs) {
		StructTp oldAttrStruct = attrStruct;
		attrStruct = newAttrStruct;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRUCT, oldAttrStruct, newAttrStruct);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrStruct(StructTp newAttrStruct) {
		if (newAttrStruct != attrStruct) {
			NotificationChain msgs = null;
			if (attrStruct != null)
				msgs = ((InternalEObject)attrStruct).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRUCT, null, msgs);
			if (newAttrStruct != null)
				msgs = ((InternalEObject)newAttrStruct).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRUCT, null, msgs);
			msgs = basicSetAttrStruct(newAttrStruct, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRUCT, newAttrStruct, newAttrStruct));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumTp getAttrEnum() {
		return attrEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrEnum(EnumTp newAttrEnum) {
		EnumTp oldAttrEnum = attrEnum;
		attrEnum = newAttrEnum == null ? ATTR_ENUM_EDEFAULT : newAttrEnum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.TEST_CLASS19__ATTR_ENUM, oldAttrEnum, attrEnum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestClass0> getReference19x0() {
		if (reference19x0 == null) {
			reference19x0 = new EObjectResolvingEList<TestClass0>(TestClass0.class, this, GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X0);
		}
		return reference19x0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestClass1> getReference19x1() {
		if (reference19x1 == null) {
			reference19x1 = new EObjectResolvingEList<TestClass1>(TestClass1.class, this, GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X1);
		}
		return reference19x1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestClass2> getReference19x2() {
		if (reference19x2 == null) {
			reference19x2 = new EObjectResolvingEList<TestClass2>(TestClass2.class, this, GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X2);
		}
		return reference19x2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestClass3> getReference19x3() {
		if (reference19x3 == null) {
			reference19x3 = new EObjectResolvingEList<TestClass3>(TestClass3.class, this, GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X3);
		}
		return reference19x3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestClass4> getReference19x4() {
		if (reference19x4 == null) {
			reference19x4 = new EObjectResolvingEList<TestClass4>(TestClass4.class, this, GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X4);
		}
		return reference19x4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestClass5> getReference19x5() {
		if (reference19x5 == null) {
			reference19x5 = new EObjectResolvingEList<TestClass5>(TestClass5.class, this, GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X5);
		}
		return reference19x5;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestClass6> getReference19x6() {
		if (reference19x6 == null) {
			reference19x6 = new EObjectResolvingEList<TestClass6>(TestClass6.class, this, GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X6);
		}
		return reference19x6;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestClass7> getReference19x7() {
		if (reference19x7 == null) {
			reference19x7 = new EObjectResolvingEList<TestClass7>(TestClass7.class, this, GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X7);
		}
		return reference19x7;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestClass8> getReference19x8() {
		if (reference19x8 == null) {
			reference19x8 = new EObjectResolvingEList<TestClass8>(TestClass8.class, this, GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X8);
		}
		return reference19x8;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestClass9> getReference19x9() {
		if (reference19x9 == null) {
			reference19x9 = new EObjectResolvingEList<TestClass9>(TestClass9.class, this, GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X9);
		}
		return reference19x9;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestClass10> getReference19x10() {
		if (reference19x10 == null) {
			reference19x10 = new EObjectResolvingEList<TestClass10>(TestClass10.class, this, GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X10);
		}
		return reference19x10;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestClass11> getReference19x11() {
		if (reference19x11 == null) {
			reference19x11 = new EObjectResolvingEList<TestClass11>(TestClass11.class, this, GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X11);
		}
		return reference19x11;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestClass12> getReference19x12() {
		if (reference19x12 == null) {
			reference19x12 = new EObjectResolvingEList<TestClass12>(TestClass12.class, this, GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X12);
		}
		return reference19x12;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestClass13> getReference19x13() {
		if (reference19x13 == null) {
			reference19x13 = new EObjectResolvingEList<TestClass13>(TestClass13.class, this, GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X13);
		}
		return reference19x13;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestClass14> getReference19x14() {
		if (reference19x14 == null) {
			reference19x14 = new EObjectResolvingEList<TestClass14>(TestClass14.class, this, GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X14);
		}
		return reference19x14;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestClass15> getReference19x15() {
		if (reference19x15 == null) {
			reference19x15 = new EObjectResolvingEList<TestClass15>(TestClass15.class, this, GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X15);
		}
		return reference19x15;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestClass16> getReference19x16() {
		if (reference19x16 == null) {
			reference19x16 = new EObjectResolvingEList<TestClass16>(TestClass16.class, this, GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X16);
		}
		return reference19x16;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestClass17> getReference19x17() {
		if (reference19x17 == null) {
			reference19x17 = new EObjectResolvingEList<TestClass17>(TestClass17.class, this, GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X17);
		}
		return reference19x17;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestClass18> getReference19x18() {
		if (reference19x18 == null) {
			reference19x18 = new EObjectResolvingEList<TestClass18>(TestClass18.class, this, GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X18);
		}
		return reference19x18;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getReference19xRefElement() {
		if (reference19xRefElement == null) {
			reference19xRefElement = new EObjectResolvingEList<EObject>(EObject.class, this, GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X_REF_ELEMENT);
		}
		return reference19xRefElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestClass19> getReference19Composite() {
		if (reference19Composite == null) {
			reference19Composite = new EObjectContainmentEList.Resolving<TestClass19>(TestClass19.class, this, GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19_COMPOSITE);
		}
		return reference19Composite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED0:
				return basicSetAttrObjectValued0(null, msgs);
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED1:
				return basicSetAttrObjectValued1(null, msgs);
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED2:
				return basicSetAttrObjectValued2(null, msgs);
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED3:
				return basicSetAttrObjectValued3(null, msgs);
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED4:
				return basicSetAttrObjectValued4(null, msgs);
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED5:
				return basicSetAttrObjectValued5(null, msgs);
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED6:
				return basicSetAttrObjectValued6(null, msgs);
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED7:
				return basicSetAttrObjectValued7(null, msgs);
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED8:
				return basicSetAttrObjectValued8(null, msgs);
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED9:
				return basicSetAttrObjectValued9(null, msgs);
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRUCT:
				return basicSetAttrStruct(null, msgs);
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19_COMPOSITE:
				return ((InternalEList<?>)getReference19Composite()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneratedmetamodelPackage.TEST_CLASS19__NAME:
				return getName();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING0:
				return getAttrString0();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED0:
				return getAttrStringMultiValued0();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT0:
				return getAttrInt0();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE0:
				return getAttrDouble0();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING1:
				return getAttrString1();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED1:
				return getAttrStringMultiValued1();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT1:
				return getAttrInt1();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE1:
				return getAttrDouble1();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING2:
				return getAttrString2();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED2:
				return getAttrStringMultiValued2();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT2:
				return getAttrInt2();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE2:
				return getAttrDouble2();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING3:
				return getAttrString3();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED3:
				return getAttrStringMultiValued3();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT3:
				return getAttrInt3();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE3:
				return getAttrDouble3();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING4:
				return getAttrString4();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED4:
				return getAttrStringMultiValued4();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT4:
				return getAttrInt4();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE4:
				return getAttrDouble4();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING5:
				return getAttrString5();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED5:
				return getAttrStringMultiValued5();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT5:
				return getAttrInt5();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE5:
				return getAttrDouble5();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING6:
				return getAttrString6();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED6:
				return getAttrStringMultiValued6();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT6:
				return getAttrInt6();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE6:
				return getAttrDouble6();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING7:
				return getAttrString7();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED7:
				return getAttrStringMultiValued7();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT7:
				return getAttrInt7();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE7:
				return getAttrDouble7();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING8:
				return getAttrString8();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED8:
				return getAttrStringMultiValued8();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT8:
				return getAttrInt8();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE8:
				return getAttrDouble8();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING9:
				return getAttrString9();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED9:
				return getAttrStringMultiValued9();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT9:
				return getAttrInt9();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE9:
				return getAttrDouble9();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED0:
				if (resolve) return getAttrObjectValued0();
				return basicGetAttrObjectValued0();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED1:
				if (resolve) return getAttrObjectValued1();
				return basicGetAttrObjectValued1();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED2:
				if (resolve) return getAttrObjectValued2();
				return basicGetAttrObjectValued2();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED3:
				if (resolve) return getAttrObjectValued3();
				return basicGetAttrObjectValued3();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED4:
				if (resolve) return getAttrObjectValued4();
				return basicGetAttrObjectValued4();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED5:
				if (resolve) return getAttrObjectValued5();
				return basicGetAttrObjectValued5();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED6:
				if (resolve) return getAttrObjectValued6();
				return basicGetAttrObjectValued6();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED7:
				if (resolve) return getAttrObjectValued7();
				return basicGetAttrObjectValued7();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED8:
				if (resolve) return getAttrObjectValued8();
				return basicGetAttrObjectValued8();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED9:
				if (resolve) return getAttrObjectValued9();
				return basicGetAttrObjectValued9();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRUCT:
				if (resolve) return getAttrStruct();
				return basicGetAttrStruct();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_ENUM:
				return getAttrEnum();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X0:
				return getReference19x0();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X1:
				return getReference19x1();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X2:
				return getReference19x2();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X3:
				return getReference19x3();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X4:
				return getReference19x4();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X5:
				return getReference19x5();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X6:
				return getReference19x6();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X7:
				return getReference19x7();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X8:
				return getReference19x8();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X9:
				return getReference19x9();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X10:
				return getReference19x10();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X11:
				return getReference19x11();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X12:
				return getReference19x12();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X13:
				return getReference19x13();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X14:
				return getReference19x14();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X15:
				return getReference19x15();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X16:
				return getReference19x16();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X17:
				return getReference19x17();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X18:
				return getReference19x18();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X_REF_ELEMENT:
				return getReference19xRefElement();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19_COMPOSITE:
				return getReference19Composite();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GeneratedmetamodelPackage.TEST_CLASS19__NAME:
				setName((String)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING0:
				setAttrString0((String)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED0:
				getAttrStringMultiValued0().clear();
				getAttrStringMultiValued0().addAll((Collection<? extends String>)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT0:
				setAttrInt0((Integer)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE0:
				setAttrDouble0((Double)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING1:
				setAttrString1((String)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED1:
				getAttrStringMultiValued1().clear();
				getAttrStringMultiValued1().addAll((Collection<? extends String>)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT1:
				setAttrInt1((Integer)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE1:
				setAttrDouble1((Double)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING2:
				setAttrString2((String)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED2:
				getAttrStringMultiValued2().clear();
				getAttrStringMultiValued2().addAll((Collection<? extends String>)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT2:
				setAttrInt2((Integer)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE2:
				setAttrDouble2((Double)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING3:
				setAttrString3((String)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED3:
				getAttrStringMultiValued3().clear();
				getAttrStringMultiValued3().addAll((Collection<? extends String>)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT3:
				setAttrInt3((Integer)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE3:
				setAttrDouble3((Double)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING4:
				setAttrString4((String)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED4:
				getAttrStringMultiValued4().clear();
				getAttrStringMultiValued4().addAll((Collection<? extends String>)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT4:
				setAttrInt4((Integer)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE4:
				setAttrDouble4((Double)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING5:
				setAttrString5((String)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED5:
				getAttrStringMultiValued5().clear();
				getAttrStringMultiValued5().addAll((Collection<? extends String>)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT5:
				setAttrInt5((Integer)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE5:
				setAttrDouble5((Double)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING6:
				setAttrString6((String)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED6:
				getAttrStringMultiValued6().clear();
				getAttrStringMultiValued6().addAll((Collection<? extends String>)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT6:
				setAttrInt6((Integer)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE6:
				setAttrDouble6((Double)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING7:
				setAttrString7((String)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED7:
				getAttrStringMultiValued7().clear();
				getAttrStringMultiValued7().addAll((Collection<? extends String>)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT7:
				setAttrInt7((Integer)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE7:
				setAttrDouble7((Double)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING8:
				setAttrString8((String)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED8:
				getAttrStringMultiValued8().clear();
				getAttrStringMultiValued8().addAll((Collection<? extends String>)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT8:
				setAttrInt8((Integer)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE8:
				setAttrDouble8((Double)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING9:
				setAttrString9((String)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED9:
				getAttrStringMultiValued9().clear();
				getAttrStringMultiValued9().addAll((Collection<? extends String>)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT9:
				setAttrInt9((Integer)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE9:
				setAttrDouble9((Double)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED0:
				setAttrObjectValued0((TestClass0)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED1:
				setAttrObjectValued1((TestClass1)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED2:
				setAttrObjectValued2((TestClass2)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED3:
				setAttrObjectValued3((TestClass3)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED4:
				setAttrObjectValued4((TestClass4)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED5:
				setAttrObjectValued5((TestClass5)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED6:
				setAttrObjectValued6((TestClass6)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED7:
				setAttrObjectValued7((TestClass7)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED8:
				setAttrObjectValued8((TestClass8)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED9:
				setAttrObjectValued9((TestClass9)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRUCT:
				setAttrStruct((StructTp)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_ENUM:
				setAttrEnum((EnumTp)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X0:
				getReference19x0().clear();
				getReference19x0().addAll((Collection<? extends TestClass0>)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X1:
				getReference19x1().clear();
				getReference19x1().addAll((Collection<? extends TestClass1>)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X2:
				getReference19x2().clear();
				getReference19x2().addAll((Collection<? extends TestClass2>)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X3:
				getReference19x3().clear();
				getReference19x3().addAll((Collection<? extends TestClass3>)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X4:
				getReference19x4().clear();
				getReference19x4().addAll((Collection<? extends TestClass4>)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X5:
				getReference19x5().clear();
				getReference19x5().addAll((Collection<? extends TestClass5>)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X6:
				getReference19x6().clear();
				getReference19x6().addAll((Collection<? extends TestClass6>)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X7:
				getReference19x7().clear();
				getReference19x7().addAll((Collection<? extends TestClass7>)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X8:
				getReference19x8().clear();
				getReference19x8().addAll((Collection<? extends TestClass8>)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X9:
				getReference19x9().clear();
				getReference19x9().addAll((Collection<? extends TestClass9>)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X10:
				getReference19x10().clear();
				getReference19x10().addAll((Collection<? extends TestClass10>)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X11:
				getReference19x11().clear();
				getReference19x11().addAll((Collection<? extends TestClass11>)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X12:
				getReference19x12().clear();
				getReference19x12().addAll((Collection<? extends TestClass12>)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X13:
				getReference19x13().clear();
				getReference19x13().addAll((Collection<? extends TestClass13>)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X14:
				getReference19x14().clear();
				getReference19x14().addAll((Collection<? extends TestClass14>)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X15:
				getReference19x15().clear();
				getReference19x15().addAll((Collection<? extends TestClass15>)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X16:
				getReference19x16().clear();
				getReference19x16().addAll((Collection<? extends TestClass16>)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X17:
				getReference19x17().clear();
				getReference19x17().addAll((Collection<? extends TestClass17>)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X18:
				getReference19x18().clear();
				getReference19x18().addAll((Collection<? extends TestClass18>)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X_REF_ELEMENT:
				getReference19xRefElement().clear();
				getReference19xRefElement().addAll((Collection<? extends EObject>)newValue);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19_COMPOSITE:
				getReference19Composite().clear();
				getReference19Composite().addAll((Collection<? extends TestClass19>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GeneratedmetamodelPackage.TEST_CLASS19__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING0:
				setAttrString0(ATTR_STRING0_EDEFAULT);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED0:
				getAttrStringMultiValued0().clear();
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT0:
				setAttrInt0(ATTR_INT0_EDEFAULT);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE0:
				setAttrDouble0(ATTR_DOUBLE0_EDEFAULT);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING1:
				setAttrString1(ATTR_STRING1_EDEFAULT);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED1:
				getAttrStringMultiValued1().clear();
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT1:
				setAttrInt1(ATTR_INT1_EDEFAULT);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE1:
				setAttrDouble1(ATTR_DOUBLE1_EDEFAULT);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING2:
				setAttrString2(ATTR_STRING2_EDEFAULT);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED2:
				getAttrStringMultiValued2().clear();
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT2:
				setAttrInt2(ATTR_INT2_EDEFAULT);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE2:
				setAttrDouble2(ATTR_DOUBLE2_EDEFAULT);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING3:
				setAttrString3(ATTR_STRING3_EDEFAULT);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED3:
				getAttrStringMultiValued3().clear();
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT3:
				setAttrInt3(ATTR_INT3_EDEFAULT);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE3:
				setAttrDouble3(ATTR_DOUBLE3_EDEFAULT);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING4:
				setAttrString4(ATTR_STRING4_EDEFAULT);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED4:
				getAttrStringMultiValued4().clear();
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT4:
				setAttrInt4(ATTR_INT4_EDEFAULT);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE4:
				setAttrDouble4(ATTR_DOUBLE4_EDEFAULT);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING5:
				setAttrString5(ATTR_STRING5_EDEFAULT);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED5:
				getAttrStringMultiValued5().clear();
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT5:
				setAttrInt5(ATTR_INT5_EDEFAULT);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE5:
				setAttrDouble5(ATTR_DOUBLE5_EDEFAULT);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING6:
				setAttrString6(ATTR_STRING6_EDEFAULT);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED6:
				getAttrStringMultiValued6().clear();
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT6:
				setAttrInt6(ATTR_INT6_EDEFAULT);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE6:
				setAttrDouble6(ATTR_DOUBLE6_EDEFAULT);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING7:
				setAttrString7(ATTR_STRING7_EDEFAULT);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED7:
				getAttrStringMultiValued7().clear();
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT7:
				setAttrInt7(ATTR_INT7_EDEFAULT);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE7:
				setAttrDouble7(ATTR_DOUBLE7_EDEFAULT);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING8:
				setAttrString8(ATTR_STRING8_EDEFAULT);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED8:
				getAttrStringMultiValued8().clear();
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT8:
				setAttrInt8(ATTR_INT8_EDEFAULT);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE8:
				setAttrDouble8(ATTR_DOUBLE8_EDEFAULT);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING9:
				setAttrString9(ATTR_STRING9_EDEFAULT);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED9:
				getAttrStringMultiValued9().clear();
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT9:
				setAttrInt9(ATTR_INT9_EDEFAULT);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE9:
				setAttrDouble9(ATTR_DOUBLE9_EDEFAULT);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED0:
				setAttrObjectValued0((TestClass0)null);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED1:
				setAttrObjectValued1((TestClass1)null);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED2:
				setAttrObjectValued2((TestClass2)null);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED3:
				setAttrObjectValued3((TestClass3)null);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED4:
				setAttrObjectValued4((TestClass4)null);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED5:
				setAttrObjectValued5((TestClass5)null);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED6:
				setAttrObjectValued6((TestClass6)null);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED7:
				setAttrObjectValued7((TestClass7)null);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED8:
				setAttrObjectValued8((TestClass8)null);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED9:
				setAttrObjectValued9((TestClass9)null);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRUCT:
				setAttrStruct((StructTp)null);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_ENUM:
				setAttrEnum(ATTR_ENUM_EDEFAULT);
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X0:
				getReference19x0().clear();
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X1:
				getReference19x1().clear();
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X2:
				getReference19x2().clear();
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X3:
				getReference19x3().clear();
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X4:
				getReference19x4().clear();
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X5:
				getReference19x5().clear();
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X6:
				getReference19x6().clear();
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X7:
				getReference19x7().clear();
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X8:
				getReference19x8().clear();
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X9:
				getReference19x9().clear();
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X10:
				getReference19x10().clear();
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X11:
				getReference19x11().clear();
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X12:
				getReference19x12().clear();
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X13:
				getReference19x13().clear();
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X14:
				getReference19x14().clear();
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X15:
				getReference19x15().clear();
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X16:
				getReference19x16().clear();
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X17:
				getReference19x17().clear();
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X18:
				getReference19x18().clear();
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X_REF_ELEMENT:
				getReference19xRefElement().clear();
				return;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19_COMPOSITE:
				getReference19Composite().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GeneratedmetamodelPackage.TEST_CLASS19__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING0:
				return ATTR_STRING0_EDEFAULT == null ? attrString0 != null : !ATTR_STRING0_EDEFAULT.equals(attrString0);
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED0:
				return attrStringMultiValued0 != null && !attrStringMultiValued0.isEmpty();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT0:
				return attrInt0 != ATTR_INT0_EDEFAULT;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE0:
				return attrDouble0 != ATTR_DOUBLE0_EDEFAULT;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING1:
				return ATTR_STRING1_EDEFAULT == null ? attrString1 != null : !ATTR_STRING1_EDEFAULT.equals(attrString1);
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED1:
				return attrStringMultiValued1 != null && !attrStringMultiValued1.isEmpty();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT1:
				return attrInt1 != ATTR_INT1_EDEFAULT;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE1:
				return attrDouble1 != ATTR_DOUBLE1_EDEFAULT;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING2:
				return ATTR_STRING2_EDEFAULT == null ? attrString2 != null : !ATTR_STRING2_EDEFAULT.equals(attrString2);
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED2:
				return attrStringMultiValued2 != null && !attrStringMultiValued2.isEmpty();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT2:
				return attrInt2 != ATTR_INT2_EDEFAULT;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE2:
				return attrDouble2 != ATTR_DOUBLE2_EDEFAULT;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING3:
				return ATTR_STRING3_EDEFAULT == null ? attrString3 != null : !ATTR_STRING3_EDEFAULT.equals(attrString3);
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED3:
				return attrStringMultiValued3 != null && !attrStringMultiValued3.isEmpty();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT3:
				return attrInt3 != ATTR_INT3_EDEFAULT;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE3:
				return attrDouble3 != ATTR_DOUBLE3_EDEFAULT;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING4:
				return ATTR_STRING4_EDEFAULT == null ? attrString4 != null : !ATTR_STRING4_EDEFAULT.equals(attrString4);
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED4:
				return attrStringMultiValued4 != null && !attrStringMultiValued4.isEmpty();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT4:
				return attrInt4 != ATTR_INT4_EDEFAULT;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE4:
				return attrDouble4 != ATTR_DOUBLE4_EDEFAULT;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING5:
				return ATTR_STRING5_EDEFAULT == null ? attrString5 != null : !ATTR_STRING5_EDEFAULT.equals(attrString5);
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED5:
				return attrStringMultiValued5 != null && !attrStringMultiValued5.isEmpty();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT5:
				return attrInt5 != ATTR_INT5_EDEFAULT;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE5:
				return attrDouble5 != ATTR_DOUBLE5_EDEFAULT;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING6:
				return ATTR_STRING6_EDEFAULT == null ? attrString6 != null : !ATTR_STRING6_EDEFAULT.equals(attrString6);
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED6:
				return attrStringMultiValued6 != null && !attrStringMultiValued6.isEmpty();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT6:
				return attrInt6 != ATTR_INT6_EDEFAULT;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE6:
				return attrDouble6 != ATTR_DOUBLE6_EDEFAULT;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING7:
				return ATTR_STRING7_EDEFAULT == null ? attrString7 != null : !ATTR_STRING7_EDEFAULT.equals(attrString7);
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED7:
				return attrStringMultiValued7 != null && !attrStringMultiValued7.isEmpty();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT7:
				return attrInt7 != ATTR_INT7_EDEFAULT;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE7:
				return attrDouble7 != ATTR_DOUBLE7_EDEFAULT;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING8:
				return ATTR_STRING8_EDEFAULT == null ? attrString8 != null : !ATTR_STRING8_EDEFAULT.equals(attrString8);
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED8:
				return attrStringMultiValued8 != null && !attrStringMultiValued8.isEmpty();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT8:
				return attrInt8 != ATTR_INT8_EDEFAULT;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE8:
				return attrDouble8 != ATTR_DOUBLE8_EDEFAULT;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING9:
				return ATTR_STRING9_EDEFAULT == null ? attrString9 != null : !ATTR_STRING9_EDEFAULT.equals(attrString9);
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRING_MULTI_VALUED9:
				return attrStringMultiValued9 != null && !attrStringMultiValued9.isEmpty();
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_INT9:
				return attrInt9 != ATTR_INT9_EDEFAULT;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_DOUBLE9:
				return attrDouble9 != ATTR_DOUBLE9_EDEFAULT;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED0:
				return attrObjectValued0 != null;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED1:
				return attrObjectValued1 != null;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED2:
				return attrObjectValued2 != null;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED3:
				return attrObjectValued3 != null;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED4:
				return attrObjectValued4 != null;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED5:
				return attrObjectValued5 != null;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED6:
				return attrObjectValued6 != null;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED7:
				return attrObjectValued7 != null;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED8:
				return attrObjectValued8 != null;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_OBJECT_VALUED9:
				return attrObjectValued9 != null;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_STRUCT:
				return attrStruct != null;
			case GeneratedmetamodelPackage.TEST_CLASS19__ATTR_ENUM:
				return attrEnum != ATTR_ENUM_EDEFAULT;
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X0:
				return reference19x0 != null && !reference19x0.isEmpty();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X1:
				return reference19x1 != null && !reference19x1.isEmpty();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X2:
				return reference19x2 != null && !reference19x2.isEmpty();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X3:
				return reference19x3 != null && !reference19x3.isEmpty();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X4:
				return reference19x4 != null && !reference19x4.isEmpty();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X5:
				return reference19x5 != null && !reference19x5.isEmpty();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X6:
				return reference19x6 != null && !reference19x6.isEmpty();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X7:
				return reference19x7 != null && !reference19x7.isEmpty();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X8:
				return reference19x8 != null && !reference19x8.isEmpty();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X9:
				return reference19x9 != null && !reference19x9.isEmpty();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X10:
				return reference19x10 != null && !reference19x10.isEmpty();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X11:
				return reference19x11 != null && !reference19x11.isEmpty();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X12:
				return reference19x12 != null && !reference19x12.isEmpty();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X13:
				return reference19x13 != null && !reference19x13.isEmpty();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X14:
				return reference19x14 != null && !reference19x14.isEmpty();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X15:
				return reference19x15 != null && !reference19x15.isEmpty();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X16:
				return reference19x16 != null && !reference19x16.isEmpty();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X17:
				return reference19x17 != null && !reference19x17.isEmpty();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X18:
				return reference19x18 != null && !reference19x18.isEmpty();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19X_REF_ELEMENT:
				return reference19xRefElement != null && !reference19xRefElement.isEmpty();
			case GeneratedmetamodelPackage.TEST_CLASS19__REFERENCE19_COMPOSITE:
				return reference19Composite != null && !reference19Composite.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", attrString0: ");
		result.append(attrString0);
		result.append(", attrStringMultiValued0: ");
		result.append(attrStringMultiValued0);
		result.append(", attrInt0: ");
		result.append(attrInt0);
		result.append(", attrDouble0: ");
		result.append(attrDouble0);
		result.append(", attrString1: ");
		result.append(attrString1);
		result.append(", attrStringMultiValued1: ");
		result.append(attrStringMultiValued1);
		result.append(", attrInt1: ");
		result.append(attrInt1);
		result.append(", attrDouble1: ");
		result.append(attrDouble1);
		result.append(", attrString2: ");
		result.append(attrString2);
		result.append(", attrStringMultiValued2: ");
		result.append(attrStringMultiValued2);
		result.append(", attrInt2: ");
		result.append(attrInt2);
		result.append(", attrDouble2: ");
		result.append(attrDouble2);
		result.append(", attrString3: ");
		result.append(attrString3);
		result.append(", attrStringMultiValued3: ");
		result.append(attrStringMultiValued3);
		result.append(", attrInt3: ");
		result.append(attrInt3);
		result.append(", attrDouble3: ");
		result.append(attrDouble3);
		result.append(", attrString4: ");
		result.append(attrString4);
		result.append(", attrStringMultiValued4: ");
		result.append(attrStringMultiValued4);
		result.append(", attrInt4: ");
		result.append(attrInt4);
		result.append(", attrDouble4: ");
		result.append(attrDouble4);
		result.append(", attrString5: ");
		result.append(attrString5);
		result.append(", attrStringMultiValued5: ");
		result.append(attrStringMultiValued5);
		result.append(", attrInt5: ");
		result.append(attrInt5);
		result.append(", attrDouble5: ");
		result.append(attrDouble5);
		result.append(", attrString6: ");
		result.append(attrString6);
		result.append(", attrStringMultiValued6: ");
		result.append(attrStringMultiValued6);
		result.append(", attrInt6: ");
		result.append(attrInt6);
		result.append(", attrDouble6: ");
		result.append(attrDouble6);
		result.append(", attrString7: ");
		result.append(attrString7);
		result.append(", attrStringMultiValued7: ");
		result.append(attrStringMultiValued7);
		result.append(", attrInt7: ");
		result.append(attrInt7);
		result.append(", attrDouble7: ");
		result.append(attrDouble7);
		result.append(", attrString8: ");
		result.append(attrString8);
		result.append(", attrStringMultiValued8: ");
		result.append(attrStringMultiValued8);
		result.append(", attrInt8: ");
		result.append(attrInt8);
		result.append(", attrDouble8: ");
		result.append(attrDouble8);
		result.append(", attrString9: ");
		result.append(attrString9);
		result.append(", attrStringMultiValued9: ");
		result.append(attrStringMultiValued9);
		result.append(", attrInt9: ");
		result.append(attrInt9);
		result.append(", attrDouble9: ");
		result.append(attrDouble9);
		result.append(", attrEnum: ");
		result.append(attrEnum);
		result.append(')');
		return result.toString();
	}

} //TestClass19Impl
