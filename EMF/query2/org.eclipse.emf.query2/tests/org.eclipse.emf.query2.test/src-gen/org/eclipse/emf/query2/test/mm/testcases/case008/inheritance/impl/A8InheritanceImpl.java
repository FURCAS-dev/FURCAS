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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.A8Inheritance;
import org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.InheritancePackage;
import org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SubStructure1;
import org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SubStructure2;
import org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SuperStructure1;
import org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SuperStructure2;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>A8 Inheritance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.A8InheritanceImpl#getManySuperStructure1 <em>Many Super Structure1</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.A8InheritanceImpl#getOneSuperStructure1 <em>One Super Structure1</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.A8InheritanceImpl#getOneSuperStructure2 <em>One Super Structure2</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.A8InheritanceImpl#getOneSubStructure1 <em>One Sub Structure1</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.A8InheritanceImpl#getOneSubStructure2 <em>One Sub Structure2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class A8InheritanceImpl extends EObjectImpl implements A8Inheritance {
	/**
	 * The cached value of the '{@link #getManySuperStructure1() <em>Many Super Structure1</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManySuperStructure1()
	 * @generated
	 * @ordered
	 */
	protected EList<SuperStructure1> manySuperStructure1;

	/**
	 * The cached value of the '{@link #getOneSuperStructure1() <em>One Super Structure1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOneSuperStructure1()
	 * @generated
	 * @ordered
	 */
	protected SuperStructure1 oneSuperStructure1;

	/**
	 * The cached value of the '{@link #getOneSuperStructure2() <em>One Super Structure2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOneSuperStructure2()
	 * @generated
	 * @ordered
	 */
	protected SuperStructure2 oneSuperStructure2;

	/**
	 * The cached value of the '{@link #getOneSubStructure1() <em>One Sub Structure1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOneSubStructure1()
	 * @generated
	 * @ordered
	 */
	protected SubStructure1 oneSubStructure1;

	/**
	 * The cached value of the '{@link #getOneSubStructure2() <em>One Sub Structure2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOneSubStructure2()
	 * @generated
	 * @ordered
	 */
	protected SubStructure2 oneSubStructure2;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected A8InheritanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InheritancePackage.Literals.A8_INHERITANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SuperStructure1> getManySuperStructure1() {
		if (manySuperStructure1 == null) {
			manySuperStructure1 = new EObjectContainmentEList.Resolving<SuperStructure1>(SuperStructure1.class, this, InheritancePackage.A8_INHERITANCE__MANY_SUPER_STRUCTURE1);
		}
		return manySuperStructure1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SuperStructure1 getOneSuperStructure1() {
		if (oneSuperStructure1 != null && oneSuperStructure1.eIsProxy()) {
			InternalEObject oldOneSuperStructure1 = (InternalEObject)oneSuperStructure1;
			oneSuperStructure1 = (SuperStructure1)eResolveProxy(oldOneSuperStructure1);
			if (oneSuperStructure1 != oldOneSuperStructure1) {
				InternalEObject newOneSuperStructure1 = (InternalEObject)oneSuperStructure1;
				NotificationChain msgs = oldOneSuperStructure1.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InheritancePackage.A8_INHERITANCE__ONE_SUPER_STRUCTURE1, null, null);
				if (newOneSuperStructure1.eInternalContainer() == null) {
					msgs = newOneSuperStructure1.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InheritancePackage.A8_INHERITANCE__ONE_SUPER_STRUCTURE1, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, InheritancePackage.A8_INHERITANCE__ONE_SUPER_STRUCTURE1, oldOneSuperStructure1, oneSuperStructure1));
			}
		}
		return oneSuperStructure1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SuperStructure1 basicGetOneSuperStructure1() {
		return oneSuperStructure1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOneSuperStructure1(SuperStructure1 newOneSuperStructure1, NotificationChain msgs) {
		SuperStructure1 oldOneSuperStructure1 = oneSuperStructure1;
		oneSuperStructure1 = newOneSuperStructure1;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InheritancePackage.A8_INHERITANCE__ONE_SUPER_STRUCTURE1, oldOneSuperStructure1, newOneSuperStructure1);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOneSuperStructure1(SuperStructure1 newOneSuperStructure1) {
		if (newOneSuperStructure1 != oneSuperStructure1) {
			NotificationChain msgs = null;
			if (oneSuperStructure1 != null)
				msgs = ((InternalEObject)oneSuperStructure1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InheritancePackage.A8_INHERITANCE__ONE_SUPER_STRUCTURE1, null, msgs);
			if (newOneSuperStructure1 != null)
				msgs = ((InternalEObject)newOneSuperStructure1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InheritancePackage.A8_INHERITANCE__ONE_SUPER_STRUCTURE1, null, msgs);
			msgs = basicSetOneSuperStructure1(newOneSuperStructure1, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InheritancePackage.A8_INHERITANCE__ONE_SUPER_STRUCTURE1, newOneSuperStructure1, newOneSuperStructure1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SuperStructure2 getOneSuperStructure2() {
		if (oneSuperStructure2 != null && oneSuperStructure2.eIsProxy()) {
			InternalEObject oldOneSuperStructure2 = (InternalEObject)oneSuperStructure2;
			oneSuperStructure2 = (SuperStructure2)eResolveProxy(oldOneSuperStructure2);
			if (oneSuperStructure2 != oldOneSuperStructure2) {
				InternalEObject newOneSuperStructure2 = (InternalEObject)oneSuperStructure2;
				NotificationChain msgs = oldOneSuperStructure2.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InheritancePackage.A8_INHERITANCE__ONE_SUPER_STRUCTURE2, null, null);
				if (newOneSuperStructure2.eInternalContainer() == null) {
					msgs = newOneSuperStructure2.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InheritancePackage.A8_INHERITANCE__ONE_SUPER_STRUCTURE2, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, InheritancePackage.A8_INHERITANCE__ONE_SUPER_STRUCTURE2, oldOneSuperStructure2, oneSuperStructure2));
			}
		}
		return oneSuperStructure2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SuperStructure2 basicGetOneSuperStructure2() {
		return oneSuperStructure2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOneSuperStructure2(SuperStructure2 newOneSuperStructure2, NotificationChain msgs) {
		SuperStructure2 oldOneSuperStructure2 = oneSuperStructure2;
		oneSuperStructure2 = newOneSuperStructure2;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InheritancePackage.A8_INHERITANCE__ONE_SUPER_STRUCTURE2, oldOneSuperStructure2, newOneSuperStructure2);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOneSuperStructure2(SuperStructure2 newOneSuperStructure2) {
		if (newOneSuperStructure2 != oneSuperStructure2) {
			NotificationChain msgs = null;
			if (oneSuperStructure2 != null)
				msgs = ((InternalEObject)oneSuperStructure2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InheritancePackage.A8_INHERITANCE__ONE_SUPER_STRUCTURE2, null, msgs);
			if (newOneSuperStructure2 != null)
				msgs = ((InternalEObject)newOneSuperStructure2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InheritancePackage.A8_INHERITANCE__ONE_SUPER_STRUCTURE2, null, msgs);
			msgs = basicSetOneSuperStructure2(newOneSuperStructure2, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InheritancePackage.A8_INHERITANCE__ONE_SUPER_STRUCTURE2, newOneSuperStructure2, newOneSuperStructure2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubStructure1 getOneSubStructure1() {
		if (oneSubStructure1 != null && oneSubStructure1.eIsProxy()) {
			InternalEObject oldOneSubStructure1 = (InternalEObject)oneSubStructure1;
			oneSubStructure1 = (SubStructure1)eResolveProxy(oldOneSubStructure1);
			if (oneSubStructure1 != oldOneSubStructure1) {
				InternalEObject newOneSubStructure1 = (InternalEObject)oneSubStructure1;
				NotificationChain msgs = oldOneSubStructure1.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InheritancePackage.A8_INHERITANCE__ONE_SUB_STRUCTURE1, null, null);
				if (newOneSubStructure1.eInternalContainer() == null) {
					msgs = newOneSubStructure1.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InheritancePackage.A8_INHERITANCE__ONE_SUB_STRUCTURE1, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, InheritancePackage.A8_INHERITANCE__ONE_SUB_STRUCTURE1, oldOneSubStructure1, oneSubStructure1));
			}
		}
		return oneSubStructure1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubStructure1 basicGetOneSubStructure1() {
		return oneSubStructure1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOneSubStructure1(SubStructure1 newOneSubStructure1, NotificationChain msgs) {
		SubStructure1 oldOneSubStructure1 = oneSubStructure1;
		oneSubStructure1 = newOneSubStructure1;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InheritancePackage.A8_INHERITANCE__ONE_SUB_STRUCTURE1, oldOneSubStructure1, newOneSubStructure1);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOneSubStructure1(SubStructure1 newOneSubStructure1) {
		if (newOneSubStructure1 != oneSubStructure1) {
			NotificationChain msgs = null;
			if (oneSubStructure1 != null)
				msgs = ((InternalEObject)oneSubStructure1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InheritancePackage.A8_INHERITANCE__ONE_SUB_STRUCTURE1, null, msgs);
			if (newOneSubStructure1 != null)
				msgs = ((InternalEObject)newOneSubStructure1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InheritancePackage.A8_INHERITANCE__ONE_SUB_STRUCTURE1, null, msgs);
			msgs = basicSetOneSubStructure1(newOneSubStructure1, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InheritancePackage.A8_INHERITANCE__ONE_SUB_STRUCTURE1, newOneSubStructure1, newOneSubStructure1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubStructure2 getOneSubStructure2() {
		if (oneSubStructure2 != null && oneSubStructure2.eIsProxy()) {
			InternalEObject oldOneSubStructure2 = (InternalEObject)oneSubStructure2;
			oneSubStructure2 = (SubStructure2)eResolveProxy(oldOneSubStructure2);
			if (oneSubStructure2 != oldOneSubStructure2) {
				InternalEObject newOneSubStructure2 = (InternalEObject)oneSubStructure2;
				NotificationChain msgs = oldOneSubStructure2.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InheritancePackage.A8_INHERITANCE__ONE_SUB_STRUCTURE2, null, null);
				if (newOneSubStructure2.eInternalContainer() == null) {
					msgs = newOneSubStructure2.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InheritancePackage.A8_INHERITANCE__ONE_SUB_STRUCTURE2, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, InheritancePackage.A8_INHERITANCE__ONE_SUB_STRUCTURE2, oldOneSubStructure2, oneSubStructure2));
			}
		}
		return oneSubStructure2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubStructure2 basicGetOneSubStructure2() {
		return oneSubStructure2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOneSubStructure2(SubStructure2 newOneSubStructure2, NotificationChain msgs) {
		SubStructure2 oldOneSubStructure2 = oneSubStructure2;
		oneSubStructure2 = newOneSubStructure2;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InheritancePackage.A8_INHERITANCE__ONE_SUB_STRUCTURE2, oldOneSubStructure2, newOneSubStructure2);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOneSubStructure2(SubStructure2 newOneSubStructure2) {
		if (newOneSubStructure2 != oneSubStructure2) {
			NotificationChain msgs = null;
			if (oneSubStructure2 != null)
				msgs = ((InternalEObject)oneSubStructure2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InheritancePackage.A8_INHERITANCE__ONE_SUB_STRUCTURE2, null, msgs);
			if (newOneSubStructure2 != null)
				msgs = ((InternalEObject)newOneSubStructure2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InheritancePackage.A8_INHERITANCE__ONE_SUB_STRUCTURE2, null, msgs);
			msgs = basicSetOneSubStructure2(newOneSubStructure2, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InheritancePackage.A8_INHERITANCE__ONE_SUB_STRUCTURE2, newOneSubStructure2, newOneSubStructure2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InheritancePackage.A8_INHERITANCE__MANY_SUPER_STRUCTURE1:
				return ((InternalEList<?>)getManySuperStructure1()).basicRemove(otherEnd, msgs);
			case InheritancePackage.A8_INHERITANCE__ONE_SUPER_STRUCTURE1:
				return basicSetOneSuperStructure1(null, msgs);
			case InheritancePackage.A8_INHERITANCE__ONE_SUPER_STRUCTURE2:
				return basicSetOneSuperStructure2(null, msgs);
			case InheritancePackage.A8_INHERITANCE__ONE_SUB_STRUCTURE1:
				return basicSetOneSubStructure1(null, msgs);
			case InheritancePackage.A8_INHERITANCE__ONE_SUB_STRUCTURE2:
				return basicSetOneSubStructure2(null, msgs);
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
			case InheritancePackage.A8_INHERITANCE__MANY_SUPER_STRUCTURE1:
				return getManySuperStructure1();
			case InheritancePackage.A8_INHERITANCE__ONE_SUPER_STRUCTURE1:
				if (resolve) return getOneSuperStructure1();
				return basicGetOneSuperStructure1();
			case InheritancePackage.A8_INHERITANCE__ONE_SUPER_STRUCTURE2:
				if (resolve) return getOneSuperStructure2();
				return basicGetOneSuperStructure2();
			case InheritancePackage.A8_INHERITANCE__ONE_SUB_STRUCTURE1:
				if (resolve) return getOneSubStructure1();
				return basicGetOneSubStructure1();
			case InheritancePackage.A8_INHERITANCE__ONE_SUB_STRUCTURE2:
				if (resolve) return getOneSubStructure2();
				return basicGetOneSubStructure2();
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
			case InheritancePackage.A8_INHERITANCE__MANY_SUPER_STRUCTURE1:
				getManySuperStructure1().clear();
				getManySuperStructure1().addAll((Collection<? extends SuperStructure1>)newValue);
				return;
			case InheritancePackage.A8_INHERITANCE__ONE_SUPER_STRUCTURE1:
				setOneSuperStructure1((SuperStructure1)newValue);
				return;
			case InheritancePackage.A8_INHERITANCE__ONE_SUPER_STRUCTURE2:
				setOneSuperStructure2((SuperStructure2)newValue);
				return;
			case InheritancePackage.A8_INHERITANCE__ONE_SUB_STRUCTURE1:
				setOneSubStructure1((SubStructure1)newValue);
				return;
			case InheritancePackage.A8_INHERITANCE__ONE_SUB_STRUCTURE2:
				setOneSubStructure2((SubStructure2)newValue);
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
			case InheritancePackage.A8_INHERITANCE__MANY_SUPER_STRUCTURE1:
				getManySuperStructure1().clear();
				return;
			case InheritancePackage.A8_INHERITANCE__ONE_SUPER_STRUCTURE1:
				setOneSuperStructure1((SuperStructure1)null);
				return;
			case InheritancePackage.A8_INHERITANCE__ONE_SUPER_STRUCTURE2:
				setOneSuperStructure2((SuperStructure2)null);
				return;
			case InheritancePackage.A8_INHERITANCE__ONE_SUB_STRUCTURE1:
				setOneSubStructure1((SubStructure1)null);
				return;
			case InheritancePackage.A8_INHERITANCE__ONE_SUB_STRUCTURE2:
				setOneSubStructure2((SubStructure2)null);
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
			case InheritancePackage.A8_INHERITANCE__MANY_SUPER_STRUCTURE1:
				return manySuperStructure1 != null && !manySuperStructure1.isEmpty();
			case InheritancePackage.A8_INHERITANCE__ONE_SUPER_STRUCTURE1:
				return oneSuperStructure1 != null;
			case InheritancePackage.A8_INHERITANCE__ONE_SUPER_STRUCTURE2:
				return oneSuperStructure2 != null;
			case InheritancePackage.A8_INHERITANCE__ONE_SUB_STRUCTURE1:
				return oneSubStructure1 != null;
			case InheritancePackage.A8_INHERITANCE__ONE_SUB_STRUCTURE2:
				return oneSubStructure2 != null;
		}
		return super.eIsSet(featureID);
	}

} //A8InheritanceImpl
