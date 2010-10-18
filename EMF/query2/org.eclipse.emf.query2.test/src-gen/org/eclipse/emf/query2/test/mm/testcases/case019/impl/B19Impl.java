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
package org.eclipse.emf.query2.test.mm.testcases.case019.impl;

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

import org.eclipse.emf.query2.test.mm.testcases.case019.B19;
import org.eclipse.emf.query2.test.mm.testcases.case019.Case019Package;

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case004f.ButtonTextF;
import org.eclipse.emf.query2.test.mm.testcasesfoundation.case004f.ShortTranslatableTextF;
import org.eclipse.emf.query2.test.mm.testcasesfoundation.case004f.VeryShortTranslatableTextF;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>B19</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case019.impl.B19Impl#getTranslatableTextShort1 <em>Translatable Text Short1</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case019.impl.B19Impl#getTranslatableTextVeryShort1 <em>Translatable Text Very Short1</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case019.impl.B19Impl#getTranslatableButtons <em>Translatable Buttons</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class B19Impl extends EObjectImpl implements B19 {
	/**
	 * The cached value of the '{@link #getTranslatableTextShort1() <em>Translatable Text Short1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTranslatableTextShort1()
	 * @generated
	 * @ordered
	 */
	protected ShortTranslatableTextF translatableTextShort1;

	/**
	 * The cached value of the '{@link #getTranslatableTextVeryShort1() <em>Translatable Text Very Short1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTranslatableTextVeryShort1()
	 * @generated
	 * @ordered
	 */
	protected VeryShortTranslatableTextF translatableTextVeryShort1;

	/**
	 * The cached value of the '{@link #getTranslatableButtons() <em>Translatable Buttons</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTranslatableButtons()
	 * @generated
	 * @ordered
	 */
	protected EList<ButtonTextF> translatableButtons;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected B19Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case019Package.Literals.B19;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShortTranslatableTextF getTranslatableTextShort1() {
		if (translatableTextShort1 != null && translatableTextShort1.eIsProxy()) {
			InternalEObject oldTranslatableTextShort1 = (InternalEObject)translatableTextShort1;
			translatableTextShort1 = (ShortTranslatableTextF)eResolveProxy(oldTranslatableTextShort1);
			if (translatableTextShort1 != oldTranslatableTextShort1) {
				InternalEObject newTranslatableTextShort1 = (InternalEObject)translatableTextShort1;
				NotificationChain msgs = oldTranslatableTextShort1.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case019Package.B19__TRANSLATABLE_TEXT_SHORT1, null, null);
				if (newTranslatableTextShort1.eInternalContainer() == null) {
					msgs = newTranslatableTextShort1.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case019Package.B19__TRANSLATABLE_TEXT_SHORT1, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case019Package.B19__TRANSLATABLE_TEXT_SHORT1, oldTranslatableTextShort1, translatableTextShort1));
			}
		}
		return translatableTextShort1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShortTranslatableTextF basicGetTranslatableTextShort1() {
		return translatableTextShort1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTranslatableTextShort1(ShortTranslatableTextF newTranslatableTextShort1, NotificationChain msgs) {
		ShortTranslatableTextF oldTranslatableTextShort1 = translatableTextShort1;
		translatableTextShort1 = newTranslatableTextShort1;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Case019Package.B19__TRANSLATABLE_TEXT_SHORT1, oldTranslatableTextShort1, newTranslatableTextShort1);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTranslatableTextShort1(ShortTranslatableTextF newTranslatableTextShort1) {
		if (newTranslatableTextShort1 != translatableTextShort1) {
			NotificationChain msgs = null;
			if (translatableTextShort1 != null)
				msgs = ((InternalEObject)translatableTextShort1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case019Package.B19__TRANSLATABLE_TEXT_SHORT1, null, msgs);
			if (newTranslatableTextShort1 != null)
				msgs = ((InternalEObject)newTranslatableTextShort1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case019Package.B19__TRANSLATABLE_TEXT_SHORT1, null, msgs);
			msgs = basicSetTranslatableTextShort1(newTranslatableTextShort1, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case019Package.B19__TRANSLATABLE_TEXT_SHORT1, newTranslatableTextShort1, newTranslatableTextShort1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VeryShortTranslatableTextF getTranslatableTextVeryShort1() {
		if (translatableTextVeryShort1 != null && translatableTextVeryShort1.eIsProxy()) {
			InternalEObject oldTranslatableTextVeryShort1 = (InternalEObject)translatableTextVeryShort1;
			translatableTextVeryShort1 = (VeryShortTranslatableTextF)eResolveProxy(oldTranslatableTextVeryShort1);
			if (translatableTextVeryShort1 != oldTranslatableTextVeryShort1) {
				InternalEObject newTranslatableTextVeryShort1 = (InternalEObject)translatableTextVeryShort1;
				NotificationChain msgs = oldTranslatableTextVeryShort1.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case019Package.B19__TRANSLATABLE_TEXT_VERY_SHORT1, null, null);
				if (newTranslatableTextVeryShort1.eInternalContainer() == null) {
					msgs = newTranslatableTextVeryShort1.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case019Package.B19__TRANSLATABLE_TEXT_VERY_SHORT1, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case019Package.B19__TRANSLATABLE_TEXT_VERY_SHORT1, oldTranslatableTextVeryShort1, translatableTextVeryShort1));
			}
		}
		return translatableTextVeryShort1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VeryShortTranslatableTextF basicGetTranslatableTextVeryShort1() {
		return translatableTextVeryShort1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTranslatableTextVeryShort1(VeryShortTranslatableTextF newTranslatableTextVeryShort1, NotificationChain msgs) {
		VeryShortTranslatableTextF oldTranslatableTextVeryShort1 = translatableTextVeryShort1;
		translatableTextVeryShort1 = newTranslatableTextVeryShort1;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Case019Package.B19__TRANSLATABLE_TEXT_VERY_SHORT1, oldTranslatableTextVeryShort1, newTranslatableTextVeryShort1);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTranslatableTextVeryShort1(VeryShortTranslatableTextF newTranslatableTextVeryShort1) {
		if (newTranslatableTextVeryShort1 != translatableTextVeryShort1) {
			NotificationChain msgs = null;
			if (translatableTextVeryShort1 != null)
				msgs = ((InternalEObject)translatableTextVeryShort1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case019Package.B19__TRANSLATABLE_TEXT_VERY_SHORT1, null, msgs);
			if (newTranslatableTextVeryShort1 != null)
				msgs = ((InternalEObject)newTranslatableTextVeryShort1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case019Package.B19__TRANSLATABLE_TEXT_VERY_SHORT1, null, msgs);
			msgs = basicSetTranslatableTextVeryShort1(newTranslatableTextVeryShort1, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case019Package.B19__TRANSLATABLE_TEXT_VERY_SHORT1, newTranslatableTextVeryShort1, newTranslatableTextVeryShort1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ButtonTextF> getTranslatableButtons() {
		if (translatableButtons == null) {
			translatableButtons = new EObjectContainmentEList.Resolving<ButtonTextF>(ButtonTextF.class, this, Case019Package.B19__TRANSLATABLE_BUTTONS);
		}
		return translatableButtons;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Case019Package.B19__TRANSLATABLE_TEXT_SHORT1:
				return basicSetTranslatableTextShort1(null, msgs);
			case Case019Package.B19__TRANSLATABLE_TEXT_VERY_SHORT1:
				return basicSetTranslatableTextVeryShort1(null, msgs);
			case Case019Package.B19__TRANSLATABLE_BUTTONS:
				return ((InternalEList<?>)getTranslatableButtons()).basicRemove(otherEnd, msgs);
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
			case Case019Package.B19__TRANSLATABLE_TEXT_SHORT1:
				if (resolve) return getTranslatableTextShort1();
				return basicGetTranslatableTextShort1();
			case Case019Package.B19__TRANSLATABLE_TEXT_VERY_SHORT1:
				if (resolve) return getTranslatableTextVeryShort1();
				return basicGetTranslatableTextVeryShort1();
			case Case019Package.B19__TRANSLATABLE_BUTTONS:
				return getTranslatableButtons();
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
			case Case019Package.B19__TRANSLATABLE_TEXT_SHORT1:
				setTranslatableTextShort1((ShortTranslatableTextF)newValue);
				return;
			case Case019Package.B19__TRANSLATABLE_TEXT_VERY_SHORT1:
				setTranslatableTextVeryShort1((VeryShortTranslatableTextF)newValue);
				return;
			case Case019Package.B19__TRANSLATABLE_BUTTONS:
				getTranslatableButtons().clear();
				getTranslatableButtons().addAll((Collection<? extends ButtonTextF>)newValue);
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
			case Case019Package.B19__TRANSLATABLE_TEXT_SHORT1:
				setTranslatableTextShort1((ShortTranslatableTextF)null);
				return;
			case Case019Package.B19__TRANSLATABLE_TEXT_VERY_SHORT1:
				setTranslatableTextVeryShort1((VeryShortTranslatableTextF)null);
				return;
			case Case019Package.B19__TRANSLATABLE_BUTTONS:
				getTranslatableButtons().clear();
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
			case Case019Package.B19__TRANSLATABLE_TEXT_SHORT1:
				return translatableTextShort1 != null;
			case Case019Package.B19__TRANSLATABLE_TEXT_VERY_SHORT1:
				return translatableTextVeryShort1 != null;
			case Case019Package.B19__TRANSLATABLE_BUTTONS:
				return translatableButtons != null && !translatableButtons.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //B19Impl
