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
 * $Id: LabelBehaviorImpl.java,v 1.2 2010/04/08 06:26:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.editor.AbstractLabelElement;
import org.eclipse.ocl.examples.editor.EditorPackage;
import org.eclipse.ocl.examples.editor.LabelBehavior;
import org.eclipse.ocl.examples.editor.util.FormatProvider;
import org.eclipse.ocl.examples.editor.util.ImageProvider;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Label Behavior</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.editor.impl.LabelBehaviorImpl#getImage <em>Image</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.editor.impl.LabelBehaviorImpl#getImageProvider <em>Image Provider</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.editor.impl.LabelBehaviorImpl#getFormat <em>Format</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.editor.impl.LabelBehaviorImpl#getFormatProvider <em>Format Provider</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.editor.impl.LabelBehaviorImpl#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LabelBehaviorImpl extends BehaviorImpl implements LabelBehavior {
	/**
	 * The default value of the '{@link #getImage() <em>Image</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImage()
	 * @generated
	 * @ordered
	 */
	protected static final String IMAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImage() <em>Image</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImage()
	 * @generated
	 * @ordered
	 */
	protected String image = IMAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getImageProvider() <em>Image Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageProvider()
	 * @generated
	 * @ordered
	 */
	protected Class<ImageProvider> imageProvider;

	/**
	 * The default value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String FORMAT_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected String format = FORMAT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFormatProvider() <em>Format Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormatProvider()
	 * @generated
	 * @ordered
	 */
	protected Class<FormatProvider> formatProvider;

	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractLabelElement> elements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LabelBehaviorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EditorPackage.Literals.LABEL_BEHAVIOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImage() {
		return image;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImage(String newImage) {
		String oldImage = image;
		image = newImage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditorPackage.LABEL_BEHAVIOR__IMAGE, oldImage, image));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Class<ImageProvider> getImageProvider() {
		return imageProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImageProvider(Class<ImageProvider> newImageProvider) {
		Class<ImageProvider> oldImageProvider = imageProvider;
		imageProvider = newImageProvider;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditorPackage.LABEL_BEHAVIOR__IMAGE_PROVIDER, oldImageProvider, imageProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormat(String newFormat) {
		String oldFormat = format;
		format = newFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditorPackage.LABEL_BEHAVIOR__FORMAT, oldFormat, format));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Class<FormatProvider> getFormatProvider() {
		return formatProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormatProvider(Class<FormatProvider> newFormatProvider) {
		Class<FormatProvider> oldFormatProvider = formatProvider;
		formatProvider = newFormatProvider;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditorPackage.LABEL_BEHAVIOR__FORMAT_PROVIDER, oldFormatProvider, formatProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractLabelElement> getElements() {
		if (elements == null) {
			elements = new EObjectContainmentEList<AbstractLabelElement>(AbstractLabelElement.class, this, EditorPackage.LABEL_BEHAVIOR__ELEMENTS);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EditorPackage.LABEL_BEHAVIOR__ELEMENTS:
				return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
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
			case EditorPackage.LABEL_BEHAVIOR__IMAGE:
				return getImage();
			case EditorPackage.LABEL_BEHAVIOR__IMAGE_PROVIDER:
				return getImageProvider();
			case EditorPackage.LABEL_BEHAVIOR__FORMAT:
				return getFormat();
			case EditorPackage.LABEL_BEHAVIOR__FORMAT_PROVIDER:
				return getFormatProvider();
			case EditorPackage.LABEL_BEHAVIOR__ELEMENTS:
				return getElements();
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
			case EditorPackage.LABEL_BEHAVIOR__IMAGE:
				setImage((String)newValue);
				return;
			case EditorPackage.LABEL_BEHAVIOR__IMAGE_PROVIDER:
				setImageProvider((Class<ImageProvider>)newValue);
				return;
			case EditorPackage.LABEL_BEHAVIOR__FORMAT:
				setFormat((String)newValue);
				return;
			case EditorPackage.LABEL_BEHAVIOR__FORMAT_PROVIDER:
				setFormatProvider((Class<FormatProvider>)newValue);
				return;
			case EditorPackage.LABEL_BEHAVIOR__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends AbstractLabelElement>)newValue);
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
			case EditorPackage.LABEL_BEHAVIOR__IMAGE:
				setImage(IMAGE_EDEFAULT);
				return;
			case EditorPackage.LABEL_BEHAVIOR__IMAGE_PROVIDER:
				setImageProvider((Class<ImageProvider>)null);
				return;
			case EditorPackage.LABEL_BEHAVIOR__FORMAT:
				setFormat(FORMAT_EDEFAULT);
				return;
			case EditorPackage.LABEL_BEHAVIOR__FORMAT_PROVIDER:
				setFormatProvider((Class<FormatProvider>)null);
				return;
			case EditorPackage.LABEL_BEHAVIOR__ELEMENTS:
				getElements().clear();
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
			case EditorPackage.LABEL_BEHAVIOR__IMAGE:
				return IMAGE_EDEFAULT == null ? image != null : !IMAGE_EDEFAULT.equals(image);
			case EditorPackage.LABEL_BEHAVIOR__IMAGE_PROVIDER:
				return imageProvider != null;
			case EditorPackage.LABEL_BEHAVIOR__FORMAT:
				return FORMAT_EDEFAULT == null ? format != null : !FORMAT_EDEFAULT.equals(format);
			case EditorPackage.LABEL_BEHAVIOR__FORMAT_PROVIDER:
				return formatProvider != null;
			case EditorPackage.LABEL_BEHAVIOR__ELEMENTS:
				return elements != null && !elements.isEmpty();
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
		result.append(" (image: ");
		result.append(image);
		result.append(", imageProvider: ");
		result.append(imageProvider);
		result.append(", format: ");
		result.append(format);
		result.append(", formatProvider: ");
		result.append(formatProvider);
		result.append(')');
		return result.toString();
	}

} //LabelBehaviorImpl
