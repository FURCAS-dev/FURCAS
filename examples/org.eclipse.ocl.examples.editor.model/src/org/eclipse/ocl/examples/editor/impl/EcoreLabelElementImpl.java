/**
 * <copyright>
 * 
 * Copyright (c) 2008,2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: EcoreLabelElementImpl.java,v 1.2 2010/04/08 06:26:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.ocl.examples.editor.EcoreLabelElement;
import org.eclipse.ocl.examples.editor.EditorPackage;
import org.eclipse.ocl.examples.editor.util.TextProvider;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Label Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.editor.impl.EcoreLabelElementImpl#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.editor.impl.EcoreLabelElementImpl#getEnd <em>End</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.editor.impl.EcoreLabelElementImpl#isHideIfBlank <em>Hide If Blank</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.editor.impl.EcoreLabelElementImpl#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.editor.impl.EcoreLabelElementImpl#getSeparator <em>Separator</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.editor.impl.EcoreLabelElementImpl#getSuffix <em>Suffix</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.editor.impl.EcoreLabelElementImpl#getTextProvider <em>Text Provider</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EcoreLabelElementImpl extends AbstractLabelElementImpl implements EcoreLabelElement {
	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected EList<EReference> path;

	/**
	 * The cached value of the '{@link #getEnd() <em>End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature end;

	/**
	 * The default value of the '{@link #isHideIfBlank() <em>Hide If Blank</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHideIfBlank()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HIDE_IF_BLANK_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHideIfBlank() <em>Hide If Blank</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHideIfBlank()
	 * @generated
	 * @ordered
	 */
	protected boolean hideIfBlank = HIDE_IF_BLANK_EDEFAULT;

	/**
	 * The default value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String PREFIX_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrefix()
	 * @generated
	 * @ordered
	 */
	protected String prefix = PREFIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getSeparator() <em>Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeparator()
	 * @generated
	 * @ordered
	 */
	protected static final String SEPARATOR_EDEFAULT = " ";

	/**
	 * The cached value of the '{@link #getSeparator() <em>Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeparator()
	 * @generated
	 * @ordered
	 */
	protected String separator = SEPARATOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getSuffix() <em>Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuffix()
	 * @generated
	 * @ordered
	 */
	protected static final String SUFFIX_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getSuffix() <em>Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuffix()
	 * @generated
	 * @ordered
	 */
	protected String suffix = SUFFIX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTextProvider() <em>Text Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextProvider()
	 * @generated
	 * @ordered
	 */
	protected Class<TextProvider> textProvider;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EcoreLabelElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EditorPackage.Literals.ECORE_LABEL_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EReference> getPath() {
		if (path == null) {
			path = new EObjectResolvingEList<EReference>(EReference.class, this, EditorPackage.ECORE_LABEL_ELEMENT__PATH);
		}
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature getEnd() {
		if (end != null && end.eIsProxy()) {
			InternalEObject oldEnd = (InternalEObject)end;
			end = (EStructuralFeature)eResolveProxy(oldEnd);
			if (end != oldEnd) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EditorPackage.ECORE_LABEL_ELEMENT__END, oldEnd, end));
			}
		}
		return end;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature basicGetEnd() {
		return end;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnd(EStructuralFeature newEnd) {
		EStructuralFeature oldEnd = end;
		end = newEnd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditorPackage.ECORE_LABEL_ELEMENT__END, oldEnd, end));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHideIfBlank() {
		return hideIfBlank;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHideIfBlank(boolean newHideIfBlank) {
		boolean oldHideIfBlank = hideIfBlank;
		hideIfBlank = newHideIfBlank;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditorPackage.ECORE_LABEL_ELEMENT__HIDE_IF_BLANK, oldHideIfBlank, hideIfBlank));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrefix(String newPrefix) {
		String oldPrefix = prefix;
		prefix = newPrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditorPackage.ECORE_LABEL_ELEMENT__PREFIX, oldPrefix, prefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSeparator() {
		return separator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeparator(String newSeparator) {
		String oldSeparator = separator;
		separator = newSeparator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditorPackage.ECORE_LABEL_ELEMENT__SEPARATOR, oldSeparator, separator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSuffix() {
		return suffix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuffix(String newSuffix) {
		String oldSuffix = suffix;
		suffix = newSuffix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditorPackage.ECORE_LABEL_ELEMENT__SUFFIX, oldSuffix, suffix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Class<TextProvider> getTextProvider() {
		return textProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextProvider(Class<TextProvider> newTextProvider) {
		Class<TextProvider> oldTextProvider = textProvider;
		textProvider = newTextProvider;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditorPackage.ECORE_LABEL_ELEMENT__TEXT_PROVIDER, oldTextProvider, textProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EditorPackage.ECORE_LABEL_ELEMENT__PATH:
				return getPath();
			case EditorPackage.ECORE_LABEL_ELEMENT__END:
				if (resolve) return getEnd();
				return basicGetEnd();
			case EditorPackage.ECORE_LABEL_ELEMENT__HIDE_IF_BLANK:
				return isHideIfBlank();
			case EditorPackage.ECORE_LABEL_ELEMENT__PREFIX:
				return getPrefix();
			case EditorPackage.ECORE_LABEL_ELEMENT__SEPARATOR:
				return getSeparator();
			case EditorPackage.ECORE_LABEL_ELEMENT__SUFFIX:
				return getSuffix();
			case EditorPackage.ECORE_LABEL_ELEMENT__TEXT_PROVIDER:
				return getTextProvider();
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
			case EditorPackage.ECORE_LABEL_ELEMENT__PATH:
				getPath().clear();
				getPath().addAll((Collection<? extends EReference>)newValue);
				return;
			case EditorPackage.ECORE_LABEL_ELEMENT__END:
				setEnd((EStructuralFeature)newValue);
				return;
			case EditorPackage.ECORE_LABEL_ELEMENT__HIDE_IF_BLANK:
				setHideIfBlank((Boolean)newValue);
				return;
			case EditorPackage.ECORE_LABEL_ELEMENT__PREFIX:
				setPrefix((String)newValue);
				return;
			case EditorPackage.ECORE_LABEL_ELEMENT__SEPARATOR:
				setSeparator((String)newValue);
				return;
			case EditorPackage.ECORE_LABEL_ELEMENT__SUFFIX:
				setSuffix((String)newValue);
				return;
			case EditorPackage.ECORE_LABEL_ELEMENT__TEXT_PROVIDER:
				setTextProvider((Class<TextProvider>)newValue);
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
			case EditorPackage.ECORE_LABEL_ELEMENT__PATH:
				getPath().clear();
				return;
			case EditorPackage.ECORE_LABEL_ELEMENT__END:
				setEnd((EStructuralFeature)null);
				return;
			case EditorPackage.ECORE_LABEL_ELEMENT__HIDE_IF_BLANK:
				setHideIfBlank(HIDE_IF_BLANK_EDEFAULT);
				return;
			case EditorPackage.ECORE_LABEL_ELEMENT__PREFIX:
				setPrefix(PREFIX_EDEFAULT);
				return;
			case EditorPackage.ECORE_LABEL_ELEMENT__SEPARATOR:
				setSeparator(SEPARATOR_EDEFAULT);
				return;
			case EditorPackage.ECORE_LABEL_ELEMENT__SUFFIX:
				setSuffix(SUFFIX_EDEFAULT);
				return;
			case EditorPackage.ECORE_LABEL_ELEMENT__TEXT_PROVIDER:
				setTextProvider((Class<TextProvider>)null);
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
			case EditorPackage.ECORE_LABEL_ELEMENT__PATH:
				return path != null && !path.isEmpty();
			case EditorPackage.ECORE_LABEL_ELEMENT__END:
				return end != null;
			case EditorPackage.ECORE_LABEL_ELEMENT__HIDE_IF_BLANK:
				return hideIfBlank != HIDE_IF_BLANK_EDEFAULT;
			case EditorPackage.ECORE_LABEL_ELEMENT__PREFIX:
				return PREFIX_EDEFAULT == null ? prefix != null : !PREFIX_EDEFAULT.equals(prefix);
			case EditorPackage.ECORE_LABEL_ELEMENT__SEPARATOR:
				return SEPARATOR_EDEFAULT == null ? separator != null : !SEPARATOR_EDEFAULT.equals(separator);
			case EditorPackage.ECORE_LABEL_ELEMENT__SUFFIX:
				return SUFFIX_EDEFAULT == null ? suffix != null : !SUFFIX_EDEFAULT.equals(suffix);
			case EditorPackage.ECORE_LABEL_ELEMENT__TEXT_PROVIDER:
				return textProvider != null;
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
		result.append(" (hideIfBlank: ");
		result.append(hideIfBlank);
		result.append(", prefix: ");
		result.append(prefix);
		result.append(", separator: ");
		result.append(separator);
		result.append(", suffix: ");
		result.append(suffix);
		result.append(", textProvider: ");
		result.append(textProvider);
		result.append(')');
		return result.toString();
	}

} //LabelElementImpl
