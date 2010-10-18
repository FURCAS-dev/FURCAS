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

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.A5fMigrationAttributeTypeTranslatableText;
import org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.Case005fPackage;

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.structurebasedtexts.GeneralTranslatableText;
import org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.structurebasedtexts.SpecializedTranslatableText;

import org.eclipse.emf.query2.test.mm.textverticalization.TranslatableText;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>A5f Migration Attribute Type Translatable Text</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.impl.A5fMigrationAttributeTypeTranslatableTextImpl#getTranslatableText <em>Translatable Text</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.impl.A5fMigrationAttributeTypeTranslatableTextImpl#getGeneralTranslatableText <em>General Translatable Text</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.impl.A5fMigrationAttributeTypeTranslatableTextImpl#getSpecializedTranslatableText <em>Specialized Translatable Text</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class A5fMigrationAttributeTypeTranslatableTextImpl extends EObjectImpl implements A5fMigrationAttributeTypeTranslatableText {
	/**
	 * The cached value of the '{@link #getTranslatableText() <em>Translatable Text</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTranslatableText()
	 * @generated
	 * @ordered
	 */
	protected TranslatableText translatableText;

	/**
	 * The cached value of the '{@link #getGeneralTranslatableText() <em>General Translatable Text</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneralTranslatableText()
	 * @generated
	 * @ordered
	 */
	protected GeneralTranslatableText generalTranslatableText;

	/**
	 * The cached value of the '{@link #getSpecializedTranslatableText() <em>Specialized Translatable Text</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecializedTranslatableText()
	 * @generated
	 * @ordered
	 */
	protected SpecializedTranslatableText specializedTranslatableText;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected A5fMigrationAttributeTypeTranslatableTextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case005fPackage.Literals.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TranslatableText getTranslatableText() {
		if (translatableText != null && translatableText.eIsProxy()) {
			InternalEObject oldTranslatableText = (InternalEObject)translatableText;
			translatableText = (TranslatableText)eResolveProxy(oldTranslatableText);
			if (translatableText != oldTranslatableText) {
				InternalEObject newTranslatableText = (InternalEObject)translatableText;
				NotificationChain msgs = oldTranslatableText.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__TRANSLATABLE_TEXT, null, null);
				if (newTranslatableText.eInternalContainer() == null) {
					msgs = newTranslatableText.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__TRANSLATABLE_TEXT, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__TRANSLATABLE_TEXT, oldTranslatableText, translatableText));
			}
		}
		return translatableText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TranslatableText basicGetTranslatableText() {
		return translatableText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTranslatableText(TranslatableText newTranslatableText, NotificationChain msgs) {
		TranslatableText oldTranslatableText = translatableText;
		translatableText = newTranslatableText;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__TRANSLATABLE_TEXT, oldTranslatableText, newTranslatableText);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTranslatableText(TranslatableText newTranslatableText) {
		if (newTranslatableText != translatableText) {
			NotificationChain msgs = null;
			if (translatableText != null)
				msgs = ((InternalEObject)translatableText).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__TRANSLATABLE_TEXT, null, msgs);
			if (newTranslatableText != null)
				msgs = ((InternalEObject)newTranslatableText).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__TRANSLATABLE_TEXT, null, msgs);
			msgs = basicSetTranslatableText(newTranslatableText, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__TRANSLATABLE_TEXT, newTranslatableText, newTranslatableText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneralTranslatableText getGeneralTranslatableText() {
		if (generalTranslatableText != null && generalTranslatableText.eIsProxy()) {
			InternalEObject oldGeneralTranslatableText = (InternalEObject)generalTranslatableText;
			generalTranslatableText = (GeneralTranslatableText)eResolveProxy(oldGeneralTranslatableText);
			if (generalTranslatableText != oldGeneralTranslatableText) {
				InternalEObject newGeneralTranslatableText = (InternalEObject)generalTranslatableText;
				NotificationChain msgs = oldGeneralTranslatableText.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__GENERAL_TRANSLATABLE_TEXT, null, null);
				if (newGeneralTranslatableText.eInternalContainer() == null) {
					msgs = newGeneralTranslatableText.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__GENERAL_TRANSLATABLE_TEXT, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__GENERAL_TRANSLATABLE_TEXT, oldGeneralTranslatableText, generalTranslatableText));
			}
		}
		return generalTranslatableText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneralTranslatableText basicGetGeneralTranslatableText() {
		return generalTranslatableText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGeneralTranslatableText(GeneralTranslatableText newGeneralTranslatableText, NotificationChain msgs) {
		GeneralTranslatableText oldGeneralTranslatableText = generalTranslatableText;
		generalTranslatableText = newGeneralTranslatableText;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__GENERAL_TRANSLATABLE_TEXT, oldGeneralTranslatableText, newGeneralTranslatableText);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGeneralTranslatableText(GeneralTranslatableText newGeneralTranslatableText) {
		if (newGeneralTranslatableText != generalTranslatableText) {
			NotificationChain msgs = null;
			if (generalTranslatableText != null)
				msgs = ((InternalEObject)generalTranslatableText).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__GENERAL_TRANSLATABLE_TEXT, null, msgs);
			if (newGeneralTranslatableText != null)
				msgs = ((InternalEObject)newGeneralTranslatableText).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__GENERAL_TRANSLATABLE_TEXT, null, msgs);
			msgs = basicSetGeneralTranslatableText(newGeneralTranslatableText, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__GENERAL_TRANSLATABLE_TEXT, newGeneralTranslatableText, newGeneralTranslatableText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecializedTranslatableText getSpecializedTranslatableText() {
		if (specializedTranslatableText != null && specializedTranslatableText.eIsProxy()) {
			InternalEObject oldSpecializedTranslatableText = (InternalEObject)specializedTranslatableText;
			specializedTranslatableText = (SpecializedTranslatableText)eResolveProxy(oldSpecializedTranslatableText);
			if (specializedTranslatableText != oldSpecializedTranslatableText) {
				InternalEObject newSpecializedTranslatableText = (InternalEObject)specializedTranslatableText;
				NotificationChain msgs = oldSpecializedTranslatableText.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__SPECIALIZED_TRANSLATABLE_TEXT, null, null);
				if (newSpecializedTranslatableText.eInternalContainer() == null) {
					msgs = newSpecializedTranslatableText.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__SPECIALIZED_TRANSLATABLE_TEXT, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__SPECIALIZED_TRANSLATABLE_TEXT, oldSpecializedTranslatableText, specializedTranslatableText));
			}
		}
		return specializedTranslatableText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecializedTranslatableText basicGetSpecializedTranslatableText() {
		return specializedTranslatableText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSpecializedTranslatableText(SpecializedTranslatableText newSpecializedTranslatableText, NotificationChain msgs) {
		SpecializedTranslatableText oldSpecializedTranslatableText = specializedTranslatableText;
		specializedTranslatableText = newSpecializedTranslatableText;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__SPECIALIZED_TRANSLATABLE_TEXT, oldSpecializedTranslatableText, newSpecializedTranslatableText);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecializedTranslatableText(SpecializedTranslatableText newSpecializedTranslatableText) {
		if (newSpecializedTranslatableText != specializedTranslatableText) {
			NotificationChain msgs = null;
			if (specializedTranslatableText != null)
				msgs = ((InternalEObject)specializedTranslatableText).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__SPECIALIZED_TRANSLATABLE_TEXT, null, msgs);
			if (newSpecializedTranslatableText != null)
				msgs = ((InternalEObject)newSpecializedTranslatableText).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__SPECIALIZED_TRANSLATABLE_TEXT, null, msgs);
			msgs = basicSetSpecializedTranslatableText(newSpecializedTranslatableText, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__SPECIALIZED_TRANSLATABLE_TEXT, newSpecializedTranslatableText, newSpecializedTranslatableText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__TRANSLATABLE_TEXT:
				return basicSetTranslatableText(null, msgs);
			case Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__GENERAL_TRANSLATABLE_TEXT:
				return basicSetGeneralTranslatableText(null, msgs);
			case Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__SPECIALIZED_TRANSLATABLE_TEXT:
				return basicSetSpecializedTranslatableText(null, msgs);
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
			case Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__TRANSLATABLE_TEXT:
				if (resolve) return getTranslatableText();
				return basicGetTranslatableText();
			case Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__GENERAL_TRANSLATABLE_TEXT:
				if (resolve) return getGeneralTranslatableText();
				return basicGetGeneralTranslatableText();
			case Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__SPECIALIZED_TRANSLATABLE_TEXT:
				if (resolve) return getSpecializedTranslatableText();
				return basicGetSpecializedTranslatableText();
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
			case Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__TRANSLATABLE_TEXT:
				setTranslatableText((TranslatableText)newValue);
				return;
			case Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__GENERAL_TRANSLATABLE_TEXT:
				setGeneralTranslatableText((GeneralTranslatableText)newValue);
				return;
			case Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__SPECIALIZED_TRANSLATABLE_TEXT:
				setSpecializedTranslatableText((SpecializedTranslatableText)newValue);
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
			case Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__TRANSLATABLE_TEXT:
				setTranslatableText((TranslatableText)null);
				return;
			case Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__GENERAL_TRANSLATABLE_TEXT:
				setGeneralTranslatableText((GeneralTranslatableText)null);
				return;
			case Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__SPECIALIZED_TRANSLATABLE_TEXT:
				setSpecializedTranslatableText((SpecializedTranslatableText)null);
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
			case Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__TRANSLATABLE_TEXT:
				return translatableText != null;
			case Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__GENERAL_TRANSLATABLE_TEXT:
				return generalTranslatableText != null;
			case Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__SPECIALIZED_TRANSLATABLE_TEXT:
				return specializedTranslatableText != null;
		}
		return super.eIsSet(featureID);
	}

} //A5fMigrationAttributeTypeTranslatableTextImpl
