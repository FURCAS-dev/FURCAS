/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: ClassCSImpl.java,v 1.2 2011/01/24 20:59:32 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.baseCST.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ClassCSImpl#getOwnedSuperType <em>Owned Super Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ClassCSImpl#getOwnedOperation <em>Owned Operation</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ClassCSImpl#getOwnedProperty <em>Owned Property</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ClassCSImpl#getOwnedMetaType <em>Owned Meta Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassCSImpl extends ClassifierCSImpl implements ClassCS {
	/**
	 * The cached value of the '{@link #getOwnedSuperType() <em>Owned Super Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSuperType()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedRefCS> ownedSuperType;

	/**
	 * The cached value of the '{@link #getOwnedOperation() <em>Owned Operation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedOperation()
	 * @generated
	 * @ordered
	 */
	protected EList<OperationCS> ownedOperation;

	/**
	 * The cached value of the '{@link #getOwnedProperty() <em>Owned Property</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedProperty()
	 * @generated
	 * @ordered
	 */
	protected EList<StructuralFeatureCS> ownedProperty;

	/**
	 * The cached value of the '{@link #getOwnedMetaType() <em>Owned Meta Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMetaType()
	 * @generated
	 * @ordered
	 */
	protected TypedRefCS ownedMetaType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BaseCSTPackage.Literals.CLASS_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypedRefCS> getOwnedSuperType() {
		if (ownedSuperType == null)
		{
			ownedSuperType = new EObjectContainmentEList.Unsettable<TypedRefCS>(TypedRefCS.class, this, BaseCSTPackage.CLASS_CS__OWNED_SUPER_TYPE);
		}
		return ownedSuperType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetOwnedSuperType() {
		if (ownedSuperType != null) ((InternalEList.Unsettable<?>)ownedSuperType).unset();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwnedSuperType() {
		return ownedSuperType != null && ((InternalEList.Unsettable<?>)ownedSuperType).isSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OperationCS> getOwnedOperation() {
		if (ownedOperation == null)
		{
			ownedOperation = new EObjectContainmentWithInverseEList<OperationCS>(OperationCS.class, this, BaseCSTPackage.CLASS_CS__OWNED_OPERATION, BaseCSTPackage.OPERATION_CS__OWNING_CLASS);
		}
		return ownedOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StructuralFeatureCS> getOwnedProperty() {
		if (ownedProperty == null)
		{
			ownedProperty = new EObjectContainmentWithInverseEList<StructuralFeatureCS>(StructuralFeatureCS.class, this, BaseCSTPackage.CLASS_CS__OWNED_PROPERTY, BaseCSTPackage.STRUCTURAL_FEATURE_CS__OWNER);
		}
		return ownedProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedRefCS getOwnedMetaType()
	{
		return ownedMetaType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedMetaType(TypedRefCS newOwnedMetaType, NotificationChain msgs)
	{
		TypedRefCS oldOwnedMetaType = ownedMetaType;
		ownedMetaType = newOwnedMetaType;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BaseCSTPackage.CLASS_CS__OWNED_META_TYPE, oldOwnedMetaType, newOwnedMetaType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedMetaType(TypedRefCS newOwnedMetaType)
	{
		if (newOwnedMetaType != ownedMetaType)
		{
			NotificationChain msgs = null;
			if (ownedMetaType != null)
				msgs = ((InternalEObject)ownedMetaType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BaseCSTPackage.CLASS_CS__OWNED_META_TYPE, null, msgs);
			if (newOwnedMetaType != null)
				msgs = ((InternalEObject)newOwnedMetaType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BaseCSTPackage.CLASS_CS__OWNED_META_TYPE, null, msgs);
			msgs = basicSetOwnedMetaType(newOwnedMetaType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSTPackage.CLASS_CS__OWNED_META_TYPE, newOwnedMetaType, newOwnedMetaType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case BaseCSTPackage.CLASS_CS__OWNED_OPERATION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedOperation()).basicAdd(otherEnd, msgs);
			case BaseCSTPackage.CLASS_CS__OWNED_PROPERTY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedProperty()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case BaseCSTPackage.CLASS_CS__OWNED_SUPER_TYPE:
				return ((InternalEList<?>)getOwnedSuperType()).basicRemove(otherEnd, msgs);
			case BaseCSTPackage.CLASS_CS__OWNED_OPERATION:
				return ((InternalEList<?>)getOwnedOperation()).basicRemove(otherEnd, msgs);
			case BaseCSTPackage.CLASS_CS__OWNED_PROPERTY:
				return ((InternalEList<?>)getOwnedProperty()).basicRemove(otherEnd, msgs);
			case BaseCSTPackage.CLASS_CS__OWNED_META_TYPE:
				return basicSetOwnedMetaType(null, msgs);
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
		switch (featureID)
		{
			case BaseCSTPackage.CLASS_CS__OWNED_SUPER_TYPE:
				return getOwnedSuperType();
			case BaseCSTPackage.CLASS_CS__OWNED_OPERATION:
				return getOwnedOperation();
			case BaseCSTPackage.CLASS_CS__OWNED_PROPERTY:
				return getOwnedProperty();
			case BaseCSTPackage.CLASS_CS__OWNED_META_TYPE:
				return getOwnedMetaType();
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
		switch (featureID)
		{
			case BaseCSTPackage.CLASS_CS__OWNED_SUPER_TYPE:
				getOwnedSuperType().clear();
				getOwnedSuperType().addAll((Collection<? extends TypedRefCS>)newValue);
				return;
			case BaseCSTPackage.CLASS_CS__OWNED_OPERATION:
				getOwnedOperation().clear();
				getOwnedOperation().addAll((Collection<? extends OperationCS>)newValue);
				return;
			case BaseCSTPackage.CLASS_CS__OWNED_PROPERTY:
				getOwnedProperty().clear();
				getOwnedProperty().addAll((Collection<? extends StructuralFeatureCS>)newValue);
				return;
			case BaseCSTPackage.CLASS_CS__OWNED_META_TYPE:
				setOwnedMetaType((TypedRefCS)newValue);
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
		switch (featureID)
		{
			case BaseCSTPackage.CLASS_CS__OWNED_SUPER_TYPE:
				unsetOwnedSuperType();
				return;
			case BaseCSTPackage.CLASS_CS__OWNED_OPERATION:
				getOwnedOperation().clear();
				return;
			case BaseCSTPackage.CLASS_CS__OWNED_PROPERTY:
				getOwnedProperty().clear();
				return;
			case BaseCSTPackage.CLASS_CS__OWNED_META_TYPE:
				setOwnedMetaType((TypedRefCS)null);
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
		switch (featureID)
		{
			case BaseCSTPackage.CLASS_CS__OWNED_SUPER_TYPE:
				return isSetOwnedSuperType();
			case BaseCSTPackage.CLASS_CS__OWNED_OPERATION:
				return ownedOperation != null && !ownedOperation.isEmpty();
			case BaseCSTPackage.CLASS_CS__OWNED_PROPERTY:
				return ownedProperty != null && !ownedProperty.isEmpty();
			case BaseCSTPackage.CLASS_CS__OWNED_META_TYPE:
				return ownedMetaType != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public <R, C> R accept(BaseCSVisitor<R, C> visitor) {
		return visitor.visitClassCS(this);
	}
} //ClassCSImpl
