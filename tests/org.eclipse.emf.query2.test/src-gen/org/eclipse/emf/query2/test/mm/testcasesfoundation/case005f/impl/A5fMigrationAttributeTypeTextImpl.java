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
package org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.A5fMigrationAttributeTypeText;
import org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.Case005fPackage;

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.classbasedtexts.GeneralText;
import org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.classbasedtexts.SpecializedText;

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.textverticalizationf.TextF;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>A5f Migration Attribute Type Text</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.impl.A5fMigrationAttributeTypeTextImpl#getTranslatableText <em>Translatable Text</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.impl.A5fMigrationAttributeTypeTextImpl#getGeneralText <em>General Text</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.impl.A5fMigrationAttributeTypeTextImpl#getSpecializedText <em>Specialized Text</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class A5fMigrationAttributeTypeTextImpl extends EObjectImpl implements A5fMigrationAttributeTypeText {
	/**
	 * The cached value of the '{@link #getTranslatableText() <em>Translatable Text</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTranslatableText()
	 * @generated
	 * @ordered
	 */
	protected TextF translatableText;

	/**
	 * The cached value of the '{@link #getGeneralText() <em>General Text</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneralText()
	 * @generated
	 * @ordered
	 */
	protected GeneralText generalText;

	/**
	 * The cached value of the '{@link #getSpecializedText() <em>Specialized Text</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecializedText()
	 * @generated
	 * @ordered
	 */
	protected SpecializedText specializedText;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected A5fMigrationAttributeTypeTextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case005fPackage.Literals.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextF getTranslatableText() {
		if (translatableText != null && translatableText.eIsProxy()) {
			InternalEObject oldTranslatableText = (InternalEObject)translatableText;
			translatableText = (TextF)eResolveProxy(oldTranslatableText);
			if (translatableText != oldTranslatableText) {
				InternalEObject newTranslatableText = (InternalEObject)translatableText;
				NotificationChain msgs = oldTranslatableText.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__TRANSLATABLE_TEXT, null, null);
				if (newTranslatableText.eInternalContainer() == null) {
					msgs = newTranslatableText.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__TRANSLATABLE_TEXT, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__TRANSLATABLE_TEXT, oldTranslatableText, translatableText));
			}
		}
		return translatableText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextF basicGetTranslatableText() {
		return translatableText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTranslatableText(TextF newTranslatableText, NotificationChain msgs) {
		TextF oldTranslatableText = translatableText;
		translatableText = newTranslatableText;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__TRANSLATABLE_TEXT, oldTranslatableText, newTranslatableText);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTranslatableText(TextF newTranslatableText) {
		if (newTranslatableText != translatableText) {
			NotificationChain msgs = null;
			if (translatableText != null)
				msgs = ((InternalEObject)translatableText).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__TRANSLATABLE_TEXT, null, msgs);
			if (newTranslatableText != null)
				msgs = ((InternalEObject)newTranslatableText).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__TRANSLATABLE_TEXT, null, msgs);
			msgs = basicSetTranslatableText(newTranslatableText, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__TRANSLATABLE_TEXT, newTranslatableText, newTranslatableText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneralText getGeneralText() {
		if (generalText != null && generalText.eIsProxy()) {
			InternalEObject oldGeneralText = (InternalEObject)generalText;
			generalText = (GeneralText)eResolveProxy(oldGeneralText);
			if (generalText != oldGeneralText) {
				InternalEObject newGeneralText = (InternalEObject)generalText;
				NotificationChain msgs = oldGeneralText.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__GENERAL_TEXT, null, null);
				if (newGeneralText.eInternalContainer() == null) {
					msgs = newGeneralText.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__GENERAL_TEXT, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__GENERAL_TEXT, oldGeneralText, generalText));
			}
		}
		return generalText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneralText basicGetGeneralText() {
		return generalText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGeneralText(GeneralText newGeneralText, NotificationChain msgs) {
		GeneralText oldGeneralText = generalText;
		generalText = newGeneralText;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__GENERAL_TEXT, oldGeneralText, newGeneralText);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGeneralText(GeneralText newGeneralText) {
		if (newGeneralText != generalText) {
			NotificationChain msgs = null;
			if (generalText != null)
				msgs = ((InternalEObject)generalText).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__GENERAL_TEXT, null, msgs);
			if (newGeneralText != null)
				msgs = ((InternalEObject)newGeneralText).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__GENERAL_TEXT, null, msgs);
			msgs = basicSetGeneralText(newGeneralText, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__GENERAL_TEXT, newGeneralText, newGeneralText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecializedText getSpecializedText() {
		if (specializedText != null && specializedText.eIsProxy()) {
			InternalEObject oldSpecializedText = (InternalEObject)specializedText;
			specializedText = (SpecializedText)eResolveProxy(oldSpecializedText);
			if (specializedText != oldSpecializedText) {
				InternalEObject newSpecializedText = (InternalEObject)specializedText;
				NotificationChain msgs = oldSpecializedText.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__SPECIALIZED_TEXT, null, null);
				if (newSpecializedText.eInternalContainer() == null) {
					msgs = newSpecializedText.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__SPECIALIZED_TEXT, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__SPECIALIZED_TEXT, oldSpecializedText, specializedText));
			}
		}
		return specializedText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecializedText basicGetSpecializedText() {
		return specializedText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSpecializedText(SpecializedText newSpecializedText, NotificationChain msgs) {
		SpecializedText oldSpecializedText = specializedText;
		specializedText = newSpecializedText;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__SPECIALIZED_TEXT, oldSpecializedText, newSpecializedText);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecializedText(SpecializedText newSpecializedText) {
		if (newSpecializedText != specializedText) {
			NotificationChain msgs = null;
			if (specializedText != null)
				msgs = ((InternalEObject)specializedText).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__SPECIALIZED_TEXT, null, msgs);
			if (newSpecializedText != null)
				msgs = ((InternalEObject)newSpecializedText).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__SPECIALIZED_TEXT, null, msgs);
			msgs = basicSetSpecializedText(newSpecializedText, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__SPECIALIZED_TEXT, newSpecializedText, newSpecializedText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__TRANSLATABLE_TEXT:
				return basicSetTranslatableText(null, msgs);
			case Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__GENERAL_TEXT:
				return basicSetGeneralText(null, msgs);
			case Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__SPECIALIZED_TEXT:
				return basicSetSpecializedText(null, msgs);
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
			case Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__TRANSLATABLE_TEXT:
				if (resolve) return getTranslatableText();
				return basicGetTranslatableText();
			case Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__GENERAL_TEXT:
				if (resolve) return getGeneralText();
				return basicGetGeneralText();
			case Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__SPECIALIZED_TEXT:
				if (resolve) return getSpecializedText();
				return basicGetSpecializedText();
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
			case Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__TRANSLATABLE_TEXT:
				setTranslatableText((TextF)newValue);
				return;
			case Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__GENERAL_TEXT:
				setGeneralText((GeneralText)newValue);
				return;
			case Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__SPECIALIZED_TEXT:
				setSpecializedText((SpecializedText)newValue);
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
			case Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__TRANSLATABLE_TEXT:
				setTranslatableText((TextF)null);
				return;
			case Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__GENERAL_TEXT:
				setGeneralText((GeneralText)null);
				return;
			case Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__SPECIALIZED_TEXT:
				setSpecializedText((SpecializedText)null);
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
			case Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__TRANSLATABLE_TEXT:
				return translatableText != null;
			case Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__GENERAL_TEXT:
				return generalText != null;
			case Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__SPECIALIZED_TEXT:
				return specializedText != null;
		}
		return super.eIsSet(featureID);
	}

} //A5fMigrationAttributeTypeTextImpl
