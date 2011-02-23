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
package org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.InheritancePackage;
import org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SubStructure2;
import org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SuperStructure2;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub Structure2</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.SubStructure2Impl#getSuperField1From2 <em>Super Field1 From2</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.SubStructure2Impl#getSubField1 <em>Sub Field1</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.SubStructure2Impl#getSubField2 <em>Sub Field2</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.SubStructure2Impl#getSubField3 <em>Sub Field3</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.SubStructure2Impl#getSubField4 <em>Sub Field4</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.SubStructure2Impl#getSubField5 <em>Sub Field5</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubStructure2Impl extends SuperStructure1Impl implements SubStructure2 {
	/**
	 * The default value of the '{@link #getSuperField1From2() <em>Super Field1 From2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperField1From2()
	 * @generated
	 * @ordered
	 */
	protected static final String SUPER_FIELD1_FROM2_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSuperField1From2() <em>Super Field1 From2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperField1From2()
	 * @generated
	 * @ordered
	 */
	protected String superField1From2 = SUPER_FIELD1_FROM2_EDEFAULT;

	/**
	 * The default value of the '{@link #getSubField1() <em>Sub Field1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubField1()
	 * @generated
	 * @ordered
	 */
	protected static final double SUB_FIELD1_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getSubField1() <em>Sub Field1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubField1()
	 * @generated
	 * @ordered
	 */
	protected double subField1 = SUB_FIELD1_EDEFAULT;

	/**
	 * The default value of the '{@link #getSubField2() <em>Sub Field2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubField2()
	 * @generated
	 * @ordered
	 */
	protected static final String SUB_FIELD2_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSubField2() <em>Sub Field2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubField2()
	 * @generated
	 * @ordered
	 */
	protected String subField2 = SUB_FIELD2_EDEFAULT;

	/**
	 * The default value of the '{@link #getSubField3() <em>Sub Field3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubField3()
	 * @generated
	 * @ordered
	 */
	protected static final String SUB_FIELD3_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSubField3() <em>Sub Field3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubField3()
	 * @generated
	 * @ordered
	 */
	protected String subField3 = SUB_FIELD3_EDEFAULT;

	/**
	 * The default value of the '{@link #getSubField4() <em>Sub Field4</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubField4()
	 * @generated
	 * @ordered
	 */
	protected static final String SUB_FIELD4_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSubField4() <em>Sub Field4</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubField4()
	 * @generated
	 * @ordered
	 */
	protected String subField4 = SUB_FIELD4_EDEFAULT;

	/**
	 * The default value of the '{@link #getSubField5() <em>Sub Field5</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubField5()
	 * @generated
	 * @ordered
	 */
	protected static final String SUB_FIELD5_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSubField5() <em>Sub Field5</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubField5()
	 * @generated
	 * @ordered
	 */
	protected String subField5 = SUB_FIELD5_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubStructure2Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InheritancePackage.Literals.SUB_STRUCTURE2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSuperField1From2() {
		return superField1From2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperField1From2(String newSuperField1From2) {
		String oldSuperField1From2 = superField1From2;
		superField1From2 = newSuperField1From2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InheritancePackage.SUB_STRUCTURE2__SUPER_FIELD1_FROM2, oldSuperField1From2, superField1From2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSubField1() {
		return subField1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubField1(double newSubField1) {
		double oldSubField1 = subField1;
		subField1 = newSubField1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InheritancePackage.SUB_STRUCTURE2__SUB_FIELD1, oldSubField1, subField1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSubField2() {
		return subField2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubField2(String newSubField2) {
		String oldSubField2 = subField2;
		subField2 = newSubField2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InheritancePackage.SUB_STRUCTURE2__SUB_FIELD2, oldSubField2, subField2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSubField3() {
		return subField3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubField3(String newSubField3) {
		String oldSubField3 = subField3;
		subField3 = newSubField3;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InheritancePackage.SUB_STRUCTURE2__SUB_FIELD3, oldSubField3, subField3));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSubField4() {
		return subField4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubField4(String newSubField4) {
		String oldSubField4 = subField4;
		subField4 = newSubField4;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InheritancePackage.SUB_STRUCTURE2__SUB_FIELD4, oldSubField4, subField4));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSubField5() {
		return subField5;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubField5(String newSubField5) {
		String oldSubField5 = subField5;
		subField5 = newSubField5;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InheritancePackage.SUB_STRUCTURE2__SUB_FIELD5, oldSubField5, subField5));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InheritancePackage.SUB_STRUCTURE2__SUPER_FIELD1_FROM2:
				return getSuperField1From2();
			case InheritancePackage.SUB_STRUCTURE2__SUB_FIELD1:
				return getSubField1();
			case InheritancePackage.SUB_STRUCTURE2__SUB_FIELD2:
				return getSubField2();
			case InheritancePackage.SUB_STRUCTURE2__SUB_FIELD3:
				return getSubField3();
			case InheritancePackage.SUB_STRUCTURE2__SUB_FIELD4:
				return getSubField4();
			case InheritancePackage.SUB_STRUCTURE2__SUB_FIELD5:
				return getSubField5();
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
			case InheritancePackage.SUB_STRUCTURE2__SUPER_FIELD1_FROM2:
				setSuperField1From2((String)newValue);
				return;
			case InheritancePackage.SUB_STRUCTURE2__SUB_FIELD1:
				setSubField1((Double)newValue);
				return;
			case InheritancePackage.SUB_STRUCTURE2__SUB_FIELD2:
				setSubField2((String)newValue);
				return;
			case InheritancePackage.SUB_STRUCTURE2__SUB_FIELD3:
				setSubField3((String)newValue);
				return;
			case InheritancePackage.SUB_STRUCTURE2__SUB_FIELD4:
				setSubField4((String)newValue);
				return;
			case InheritancePackage.SUB_STRUCTURE2__SUB_FIELD5:
				setSubField5((String)newValue);
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
			case InheritancePackage.SUB_STRUCTURE2__SUPER_FIELD1_FROM2:
				setSuperField1From2(SUPER_FIELD1_FROM2_EDEFAULT);
				return;
			case InheritancePackage.SUB_STRUCTURE2__SUB_FIELD1:
				setSubField1(SUB_FIELD1_EDEFAULT);
				return;
			case InheritancePackage.SUB_STRUCTURE2__SUB_FIELD2:
				setSubField2(SUB_FIELD2_EDEFAULT);
				return;
			case InheritancePackage.SUB_STRUCTURE2__SUB_FIELD3:
				setSubField3(SUB_FIELD3_EDEFAULT);
				return;
			case InheritancePackage.SUB_STRUCTURE2__SUB_FIELD4:
				setSubField4(SUB_FIELD4_EDEFAULT);
				return;
			case InheritancePackage.SUB_STRUCTURE2__SUB_FIELD5:
				setSubField5(SUB_FIELD5_EDEFAULT);
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
			case InheritancePackage.SUB_STRUCTURE2__SUPER_FIELD1_FROM2:
				return SUPER_FIELD1_FROM2_EDEFAULT == null ? superField1From2 != null : !SUPER_FIELD1_FROM2_EDEFAULT.equals(superField1From2);
			case InheritancePackage.SUB_STRUCTURE2__SUB_FIELD1:
				return subField1 != SUB_FIELD1_EDEFAULT;
			case InheritancePackage.SUB_STRUCTURE2__SUB_FIELD2:
				return SUB_FIELD2_EDEFAULT == null ? subField2 != null : !SUB_FIELD2_EDEFAULT.equals(subField2);
			case InheritancePackage.SUB_STRUCTURE2__SUB_FIELD3:
				return SUB_FIELD3_EDEFAULT == null ? subField3 != null : !SUB_FIELD3_EDEFAULT.equals(subField3);
			case InheritancePackage.SUB_STRUCTURE2__SUB_FIELD4:
				return SUB_FIELD4_EDEFAULT == null ? subField4 != null : !SUB_FIELD4_EDEFAULT.equals(subField4);
			case InheritancePackage.SUB_STRUCTURE2__SUB_FIELD5:
				return SUB_FIELD5_EDEFAULT == null ? subField5 != null : !SUB_FIELD5_EDEFAULT.equals(subField5);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == SuperStructure2.class) {
			switch (derivedFeatureID) {
				case InheritancePackage.SUB_STRUCTURE2__SUPER_FIELD1_FROM2: return InheritancePackage.SUPER_STRUCTURE2__SUPER_FIELD1_FROM2;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == SuperStructure2.class) {
			switch (baseFeatureID) {
				case InheritancePackage.SUPER_STRUCTURE2__SUPER_FIELD1_FROM2: return InheritancePackage.SUB_STRUCTURE2__SUPER_FIELD1_FROM2;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (superField1From2: "); //$NON-NLS-1$
		result.append(superField1From2);
		result.append(", subField1: "); //$NON-NLS-1$
		result.append(subField1);
		result.append(", subField2: "); //$NON-NLS-1$
		result.append(subField2);
		result.append(", subField3: "); //$NON-NLS-1$
		result.append(subField3);
		result.append(", subField4: "); //$NON-NLS-1$
		result.append(subField4);
		result.append(", subField5: "); //$NON-NLS-1$
		result.append(subField5);
		result.append(')');
		return result.toString();
	}

} //SubStructure2Impl
