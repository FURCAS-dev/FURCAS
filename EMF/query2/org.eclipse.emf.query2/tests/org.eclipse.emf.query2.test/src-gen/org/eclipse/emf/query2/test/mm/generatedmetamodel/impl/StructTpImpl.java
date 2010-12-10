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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.query2.test.mm.generatedmetamodel.GeneratedmetamodelPackage;
import org.eclipse.emf.query2.test.mm.generatedmetamodel.StructInStructTp;
import org.eclipse.emf.query2.test.mm.generatedmetamodel.StructTp;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Struct Tp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.StructTpImpl#getField1 <em>Field1</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.StructTpImpl#getField2 <em>Field2</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.impl.StructTpImpl#getField3 <em>Field3</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StructTpImpl extends EObjectImpl implements StructTp {
	/**
	 * The default value of the '{@link #getField1() <em>Field1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getField1()
	 * @generated
	 * @ordered
	 */
	protected static final int FIELD1_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getField1() <em>Field1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getField1()
	 * @generated
	 * @ordered
	 */
	protected int field1 = FIELD1_EDEFAULT;

	/**
	 * The default value of the '{@link #getField2() <em>Field2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getField2()
	 * @generated
	 * @ordered
	 */
	protected static final String FIELD2_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getField2() <em>Field2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getField2()
	 * @generated
	 * @ordered
	 */
	protected String field2 = FIELD2_EDEFAULT;

	/**
	 * The cached value of the '{@link #getField3() <em>Field3</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getField3()
	 * @generated
	 * @ordered
	 */
	protected StructInStructTp field3;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StructTpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratedmetamodelPackage.eINSTANCE.getStructTp();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getField1() {
		return field1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setField1(int newField1) {
		int oldField1 = field1;
		field1 = newField1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.STRUCT_TP__FIELD1, oldField1, field1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getField2() {
		return field2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setField2(String newField2) {
		String oldField2 = field2;
		field2 = newField2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.STRUCT_TP__FIELD2, oldField2, field2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructInStructTp getField3() {
		if (field3 != null && field3.eIsProxy()) {
			InternalEObject oldField3 = (InternalEObject)field3;
			field3 = (StructInStructTp)eResolveProxy(oldField3);
			if (field3 != oldField3) {
				InternalEObject newField3 = (InternalEObject)field3;
				NotificationChain msgs = oldField3.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.STRUCT_TP__FIELD3, null, null);
				if (newField3.eInternalContainer() == null) {
					msgs = newField3.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.STRUCT_TP__FIELD3, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedmetamodelPackage.STRUCT_TP__FIELD3, oldField3, field3));
			}
		}
		return field3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructInStructTp basicGetField3() {
		return field3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetField3(StructInStructTp newField3, NotificationChain msgs) {
		StructInStructTp oldField3 = field3;
		field3 = newField3;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.STRUCT_TP__FIELD3, oldField3, newField3);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setField3(StructInStructTp newField3) {
		if (newField3 != field3) {
			NotificationChain msgs = null;
			if (field3 != null)
				msgs = ((InternalEObject)field3).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.STRUCT_TP__FIELD3, null, msgs);
			if (newField3 != null)
				msgs = ((InternalEObject)newField3).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneratedmetamodelPackage.STRUCT_TP__FIELD3, null, msgs);
			msgs = basicSetField3(newField3, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedmetamodelPackage.STRUCT_TP__FIELD3, newField3, newField3));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneratedmetamodelPackage.STRUCT_TP__FIELD3:
				return basicSetField3(null, msgs);
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
			case GeneratedmetamodelPackage.STRUCT_TP__FIELD1:
				return getField1();
			case GeneratedmetamodelPackage.STRUCT_TP__FIELD2:
				return getField2();
			case GeneratedmetamodelPackage.STRUCT_TP__FIELD3:
				if (resolve) return getField3();
				return basicGetField3();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GeneratedmetamodelPackage.STRUCT_TP__FIELD1:
				setField1((Integer)newValue);
				return;
			case GeneratedmetamodelPackage.STRUCT_TP__FIELD2:
				setField2((String)newValue);
				return;
			case GeneratedmetamodelPackage.STRUCT_TP__FIELD3:
				setField3((StructInStructTp)newValue);
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
			case GeneratedmetamodelPackage.STRUCT_TP__FIELD1:
				setField1(FIELD1_EDEFAULT);
				return;
			case GeneratedmetamodelPackage.STRUCT_TP__FIELD2:
				setField2(FIELD2_EDEFAULT);
				return;
			case GeneratedmetamodelPackage.STRUCT_TP__FIELD3:
				setField3((StructInStructTp)null);
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
			case GeneratedmetamodelPackage.STRUCT_TP__FIELD1:
				return field1 != FIELD1_EDEFAULT;
			case GeneratedmetamodelPackage.STRUCT_TP__FIELD2:
				return FIELD2_EDEFAULT == null ? field2 != null : !FIELD2_EDEFAULT.equals(field2);
			case GeneratedmetamodelPackage.STRUCT_TP__FIELD3:
				return field3 != null;
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
		result.append(" (Field1: ");
		result.append(field1);
		result.append(", Field2: ");
		result.append(field2);
		result.append(')');
		return result.toString();
	}

} //StructTpImpl
