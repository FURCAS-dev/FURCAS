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
 * $Id: TypeParameterCSImpl.java,v 1.1 2010/04/13 06:44:11 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeParameterCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeRefCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Parameter CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.TypeParameterCSImpl#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.TypeParameterCSImpl#getSuper <em>Super</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeParameterCSImpl extends TypeCSImpl implements TypeParameterCS {
	/**
	 * The cached value of the '{@link #getExtends() <em>Extends</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtends()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeRefCS> extends_;

	/**
	 * The cached value of the '{@link #getSuper() <em>Super</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuper()
	 * @generated
	 * @ordered
	 */
	protected TypeRefCS super_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeParameterCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OCLinEcoreCSTPackage.Literals.TYPE_PARAMETER_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypeRefCS> getExtends() {
		if (extends_ == null) {
			extends_ = new EObjectContainmentEList<TypeRefCS>(TypeRefCS.class, this, OCLinEcoreCSTPackage.TYPE_PARAMETER_CS__EXTENDS);
		}
		return extends_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeRefCS getSuper() {
		return super_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSuper(TypeRefCS newSuper, NotificationChain msgs) {
		TypeRefCS oldSuper = super_;
		super_ = newSuper;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OCLinEcoreCSTPackage.TYPE_PARAMETER_CS__SUPER, oldSuper, newSuper);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuper(TypeRefCS newSuper) {
		if (newSuper != super_) {
			NotificationChain msgs = null;
			if (super_ != null)
				msgs = ((InternalEObject)super_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OCLinEcoreCSTPackage.TYPE_PARAMETER_CS__SUPER, null, msgs);
			if (newSuper != null)
				msgs = ((InternalEObject)newSuper).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OCLinEcoreCSTPackage.TYPE_PARAMETER_CS__SUPER, null, msgs);
			msgs = basicSetSuper(newSuper, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLinEcoreCSTPackage.TYPE_PARAMETER_CS__SUPER, newSuper, newSuper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OCLinEcoreCSTPackage.TYPE_PARAMETER_CS__EXTENDS:
				return ((InternalEList<?>)getExtends()).basicRemove(otherEnd, msgs);
			case OCLinEcoreCSTPackage.TYPE_PARAMETER_CS__SUPER:
				return basicSetSuper(null, msgs);
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
			case OCLinEcoreCSTPackage.TYPE_PARAMETER_CS__EXTENDS:
				return getExtends();
			case OCLinEcoreCSTPackage.TYPE_PARAMETER_CS__SUPER:
				return getSuper();
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
			case OCLinEcoreCSTPackage.TYPE_PARAMETER_CS__EXTENDS:
				getExtends().clear();
				getExtends().addAll((Collection<? extends TypeRefCS>)newValue);
				return;
			case OCLinEcoreCSTPackage.TYPE_PARAMETER_CS__SUPER:
				setSuper((TypeRefCS)newValue);
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
			case OCLinEcoreCSTPackage.TYPE_PARAMETER_CS__EXTENDS:
				getExtends().clear();
				return;
			case OCLinEcoreCSTPackage.TYPE_PARAMETER_CS__SUPER:
				setSuper((TypeRefCS)null);
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
			case OCLinEcoreCSTPackage.TYPE_PARAMETER_CS__EXTENDS:
				return extends_ != null && !extends_.isEmpty();
			case OCLinEcoreCSTPackage.TYPE_PARAMETER_CS__SUPER:
				return super_ != null;
		}
		return super.eIsSet(featureID);
	}

} //TypeParameterCSImpl
