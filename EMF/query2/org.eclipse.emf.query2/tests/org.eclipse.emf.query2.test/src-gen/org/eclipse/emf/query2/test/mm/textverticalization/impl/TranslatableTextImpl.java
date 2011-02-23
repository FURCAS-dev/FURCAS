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
package org.eclipse.emf.query2.test.mm.textverticalization.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.query2.test.mm.textverticalization.TextverticalizationPackage;
import org.eclipse.emf.query2.test.mm.textverticalization.TranslatableText;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Translatable Text</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.textverticalization.impl.TranslatableTextImpl#getMaxWidth <em>Max Width</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.textverticalization.impl.TranslatableTextImpl#getOriginalText <em>Original Text</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.textverticalization.impl.TranslatableTextImpl#getResType <em>Res Type</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.textverticalization.impl.TranslatableTextImpl#isTranslate <em>Translate</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.textverticalization.impl.TranslatableTextImpl#getTransUnitId <em>Trans Unit Id</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.textverticalization.impl.TranslatableTextImpl#getResName <em>Res Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TranslatableTextImpl extends EObjectImpl implements TranslatableText {
	/**
	 * The default value of the '{@link #getMaxWidth() <em>Max Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxWidth()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_WIDTH_EDEFAULT = 255;

	/**
	 * The cached value of the '{@link #getMaxWidth() <em>Max Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxWidth()
	 * @generated
	 * @ordered
	 */
	protected int maxWidth = MAX_WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getOriginalText() <em>Original Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalText()
	 * @generated
	 * @ordered
	 */
	protected static final String ORIGINAL_TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOriginalText() <em>Original Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalText()
	 * @generated
	 * @ordered
	 */
	protected String originalText = ORIGINAL_TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getResType() <em>Res Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResType()
	 * @generated
	 * @ordered
	 */
	protected static final String RES_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResType() <em>Res Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResType()
	 * @generated
	 * @ordered
	 */
	protected String resType = RES_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #isTranslate() <em>Translate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTranslate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TRANSLATE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isTranslate() <em>Translate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTranslate()
	 * @generated
	 * @ordered
	 */
	protected boolean translate = TRANSLATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransUnitId() <em>Trans Unit Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransUnitId()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANS_UNIT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransUnitId() <em>Trans Unit Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransUnitId()
	 * @generated
	 * @ordered
	 */
	protected String transUnitId = TRANS_UNIT_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getResName() <em>Res Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResName()
	 * @generated
	 * @ordered
	 */
	protected static final String RES_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResName() <em>Res Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResName()
	 * @generated
	 * @ordered
	 */
	protected String resName = RES_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TranslatableTextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TextverticalizationPackage.Literals.TRANSLATABLE_TEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxWidth() {
		return maxWidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxWidth(int newMaxWidth) {
		int oldMaxWidth = maxWidth;
		maxWidth = newMaxWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TextverticalizationPackage.TRANSLATABLE_TEXT__MAX_WIDTH, oldMaxWidth, maxWidth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOriginalText() {
		return originalText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalText(String newOriginalText) {
		String oldOriginalText = originalText;
		originalText = newOriginalText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TextverticalizationPackage.TRANSLATABLE_TEXT__ORIGINAL_TEXT, oldOriginalText, originalText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResType() {
		return resType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResType(String newResType) {
		String oldResType = resType;
		resType = newResType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TextverticalizationPackage.TRANSLATABLE_TEXT__RES_TYPE, oldResType, resType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTranslate() {
		return translate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTranslate(boolean newTranslate) {
		boolean oldTranslate = translate;
		translate = newTranslate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TextverticalizationPackage.TRANSLATABLE_TEXT__TRANSLATE, oldTranslate, translate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransUnitId() {
		return transUnitId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransUnitId(String newTransUnitId) {
		String oldTransUnitId = transUnitId;
		transUnitId = newTransUnitId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TextverticalizationPackage.TRANSLATABLE_TEXT__TRANS_UNIT_ID, oldTransUnitId, transUnitId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResName() {
		return resName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResName(String newResName) {
		String oldResName = resName;
		resName = newResName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TextverticalizationPackage.TRANSLATABLE_TEXT__RES_NAME, oldResName, resName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TextverticalizationPackage.TRANSLATABLE_TEXT__MAX_WIDTH:
				return getMaxWidth();
			case TextverticalizationPackage.TRANSLATABLE_TEXT__ORIGINAL_TEXT:
				return getOriginalText();
			case TextverticalizationPackage.TRANSLATABLE_TEXT__RES_TYPE:
				return getResType();
			case TextverticalizationPackage.TRANSLATABLE_TEXT__TRANSLATE:
				return isTranslate();
			case TextverticalizationPackage.TRANSLATABLE_TEXT__TRANS_UNIT_ID:
				return getTransUnitId();
			case TextverticalizationPackage.TRANSLATABLE_TEXT__RES_NAME:
				return getResName();
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
			case TextverticalizationPackage.TRANSLATABLE_TEXT__MAX_WIDTH:
				setMaxWidth((Integer)newValue);
				return;
			case TextverticalizationPackage.TRANSLATABLE_TEXT__ORIGINAL_TEXT:
				setOriginalText((String)newValue);
				return;
			case TextverticalizationPackage.TRANSLATABLE_TEXT__RES_TYPE:
				setResType((String)newValue);
				return;
			case TextverticalizationPackage.TRANSLATABLE_TEXT__TRANSLATE:
				setTranslate((Boolean)newValue);
				return;
			case TextverticalizationPackage.TRANSLATABLE_TEXT__TRANS_UNIT_ID:
				setTransUnitId((String)newValue);
				return;
			case TextverticalizationPackage.TRANSLATABLE_TEXT__RES_NAME:
				setResName((String)newValue);
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
			case TextverticalizationPackage.TRANSLATABLE_TEXT__MAX_WIDTH:
				setMaxWidth(MAX_WIDTH_EDEFAULT);
				return;
			case TextverticalizationPackage.TRANSLATABLE_TEXT__ORIGINAL_TEXT:
				setOriginalText(ORIGINAL_TEXT_EDEFAULT);
				return;
			case TextverticalizationPackage.TRANSLATABLE_TEXT__RES_TYPE:
				setResType(RES_TYPE_EDEFAULT);
				return;
			case TextverticalizationPackage.TRANSLATABLE_TEXT__TRANSLATE:
				setTranslate(TRANSLATE_EDEFAULT);
				return;
			case TextverticalizationPackage.TRANSLATABLE_TEXT__TRANS_UNIT_ID:
				setTransUnitId(TRANS_UNIT_ID_EDEFAULT);
				return;
			case TextverticalizationPackage.TRANSLATABLE_TEXT__RES_NAME:
				setResName(RES_NAME_EDEFAULT);
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
			case TextverticalizationPackage.TRANSLATABLE_TEXT__MAX_WIDTH:
				return maxWidth != MAX_WIDTH_EDEFAULT;
			case TextverticalizationPackage.TRANSLATABLE_TEXT__ORIGINAL_TEXT:
				return ORIGINAL_TEXT_EDEFAULT == null ? originalText != null : !ORIGINAL_TEXT_EDEFAULT.equals(originalText);
			case TextverticalizationPackage.TRANSLATABLE_TEXT__RES_TYPE:
				return RES_TYPE_EDEFAULT == null ? resType != null : !RES_TYPE_EDEFAULT.equals(resType);
			case TextverticalizationPackage.TRANSLATABLE_TEXT__TRANSLATE:
				return translate != TRANSLATE_EDEFAULT;
			case TextverticalizationPackage.TRANSLATABLE_TEXT__TRANS_UNIT_ID:
				return TRANS_UNIT_ID_EDEFAULT == null ? transUnitId != null : !TRANS_UNIT_ID_EDEFAULT.equals(transUnitId);
			case TextverticalizationPackage.TRANSLATABLE_TEXT__RES_NAME:
				return RES_NAME_EDEFAULT == null ? resName != null : !RES_NAME_EDEFAULT.equals(resName);
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
		result.append(" (maxWidth: "); //$NON-NLS-1$
		result.append(maxWidth);
		result.append(", originalText: "); //$NON-NLS-1$
		result.append(originalText);
		result.append(", resType: "); //$NON-NLS-1$
		result.append(resType);
		result.append(", translate: "); //$NON-NLS-1$
		result.append(translate);
		result.append(", transUnitId: "); //$NON-NLS-1$
		result.append(transUnitId);
		result.append(", resName: "); //$NON-NLS-1$
		result.append(resName);
		result.append(')');
		return result.toString();
	}

} //TranslatableTextImpl
