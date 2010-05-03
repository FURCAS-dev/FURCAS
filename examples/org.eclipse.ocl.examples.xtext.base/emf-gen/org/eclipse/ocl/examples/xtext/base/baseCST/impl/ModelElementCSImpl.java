/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: ModelElementCSImpl.java,v 1.1 2010/05/03 05:25:38 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.base.baseCST.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Element CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ModelElementCSImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ModelElementCSImpl#getOriginalObject <em>Original Object</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ModelElementCSImpl#getOriginalXmiId <em>Original Xmi Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ModelElementCSImpl extends ElementCSImpl implements ModelElementCS {
	/**
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<AnnotationElementCS> annotations;

	/**
	 * The cached value of the '{@link #getOriginalObject() <em>Original Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalObject()
	 * @generated
	 * @ordered
	 */
	protected EObject originalObject;

	/**
	 * The default value of the '{@link #getOriginalXmiId() <em>Original Xmi Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalXmiId()
	 * @generated
	 * @ordered
	 */
	protected static final String ORIGINAL_XMI_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOriginalXmiId() <em>Original Xmi Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalXmiId()
	 * @generated
	 * @ordered
	 */
	protected String originalXmiId = ORIGINAL_XMI_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelElementCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BaseCSTPackage.Literals.MODEL_ELEMENT_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AnnotationElementCS> getAnnotations() {
		if (annotations == null) {
			annotations = new EObjectContainmentEList<AnnotationElementCS>(AnnotationElementCS.class, this, BaseCSTPackage.MODEL_ELEMENT_CS__ANNOTATIONS);
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getOriginalObject() {
		if (originalObject != null && originalObject.eIsProxy()) {
			InternalEObject oldOriginalObject = (InternalEObject)originalObject;
			originalObject = eResolveProxy(oldOriginalObject);
			if (originalObject != oldOriginalObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BaseCSTPackage.MODEL_ELEMENT_CS__ORIGINAL_OBJECT, oldOriginalObject, originalObject));
			}
		}
		return originalObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetOriginalObject() {
		return originalObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalObject(EObject newOriginalObject) {
		EObject oldOriginalObject = originalObject;
		originalObject = newOriginalObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSTPackage.MODEL_ELEMENT_CS__ORIGINAL_OBJECT, oldOriginalObject, originalObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOriginalXmiId() {
		return originalXmiId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalXmiId(String newOriginalXmiId) {
		String oldOriginalXmiId = originalXmiId;
		originalXmiId = newOriginalXmiId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSTPackage.MODEL_ELEMENT_CS__ORIGINAL_XMI_ID, oldOriginalXmiId, originalXmiId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BaseCSTPackage.MODEL_ELEMENT_CS__ANNOTATIONS:
				return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
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
			case BaseCSTPackage.MODEL_ELEMENT_CS__ANNOTATIONS:
				return getAnnotations();
			case BaseCSTPackage.MODEL_ELEMENT_CS__ORIGINAL_OBJECT:
				if (resolve) return getOriginalObject();
				return basicGetOriginalObject();
			case BaseCSTPackage.MODEL_ELEMENT_CS__ORIGINAL_XMI_ID:
				return getOriginalXmiId();
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
			case BaseCSTPackage.MODEL_ELEMENT_CS__ANNOTATIONS:
				getAnnotations().clear();
				getAnnotations().addAll((Collection<? extends AnnotationElementCS>)newValue);
				return;
			case BaseCSTPackage.MODEL_ELEMENT_CS__ORIGINAL_OBJECT:
				setOriginalObject((EObject)newValue);
				return;
			case BaseCSTPackage.MODEL_ELEMENT_CS__ORIGINAL_XMI_ID:
				setOriginalXmiId((String)newValue);
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
			case BaseCSTPackage.MODEL_ELEMENT_CS__ANNOTATIONS:
				getAnnotations().clear();
				return;
			case BaseCSTPackage.MODEL_ELEMENT_CS__ORIGINAL_OBJECT:
				setOriginalObject((EObject)null);
				return;
			case BaseCSTPackage.MODEL_ELEMENT_CS__ORIGINAL_XMI_ID:
				setOriginalXmiId(ORIGINAL_XMI_ID_EDEFAULT);
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
			case BaseCSTPackage.MODEL_ELEMENT_CS__ANNOTATIONS:
				return annotations != null && !annotations.isEmpty();
			case BaseCSTPackage.MODEL_ELEMENT_CS__ORIGINAL_OBJECT:
				return originalObject != null;
			case BaseCSTPackage.MODEL_ELEMENT_CS__ORIGINAL_XMI_ID:
				return ORIGINAL_XMI_ID_EDEFAULT == null ? originalXmiId != null : !ORIGINAL_XMI_ID_EDEFAULT.equals(originalXmiId);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}
} //ModelElementCSImpl
