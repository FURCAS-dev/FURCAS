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
 * $Id: CollectionLiteralExpCSImpl.java,v 1.2 2010/05/03 05:37:49 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Literal Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CollectionLiteralExpCSImpl#getTypeCS <em>Type CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CollectionLiteralExpCSImpl#getCollectionLiteralParts <em>Collection Literal Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionLiteralExpCSImpl extends LiteralExpCSImpl implements CollectionLiteralExpCS {
	/**
	 * The cached value of the '{@link #getTypeCS() <em>Type CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeCS()
	 * @generated
	 * @ordered
	 */
	protected CollectionTypeCS typeCS;
	/**
	 * The cached value of the '{@link #getCollectionLiteralParts() <em>Collection Literal Parts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollectionLiteralParts()
	 * @generated
	 * @ordered
	 */
	protected EList<CollectionLiteralPartCS> collectionLiteralParts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionLiteralExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EssentialOCLCSTPackage.Literals.COLLECTION_LITERAL_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionTypeCS getTypeCS() {
		return typeCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTypeCS(CollectionTypeCS newTypeCS, NotificationChain msgs) {
		CollectionTypeCS oldTypeCS = typeCS;
		typeCS = newTypeCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EssentialOCLCSTPackage.COLLECTION_LITERAL_EXP_CS__TYPE_CS, oldTypeCS, newTypeCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeCS(CollectionTypeCS newTypeCS) {
		if (newTypeCS != typeCS) {
			NotificationChain msgs = null;
			if (typeCS != null)
				msgs = ((InternalEObject)typeCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSTPackage.COLLECTION_LITERAL_EXP_CS__TYPE_CS, null, msgs);
			if (newTypeCS != null)
				msgs = ((InternalEObject)newTypeCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSTPackage.COLLECTION_LITERAL_EXP_CS__TYPE_CS, null, msgs);
			msgs = basicSetTypeCS(newTypeCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSTPackage.COLLECTION_LITERAL_EXP_CS__TYPE_CS, newTypeCS, newTypeCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CollectionLiteralPartCS> getCollectionLiteralParts() {
		if (collectionLiteralParts == null) {
			collectionLiteralParts = new EObjectContainmentEList<CollectionLiteralPartCS>(CollectionLiteralPartCS.class, this, EssentialOCLCSTPackage.COLLECTION_LITERAL_EXP_CS__COLLECTION_LITERAL_PARTS);
		}
		return collectionLiteralParts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EssentialOCLCSTPackage.COLLECTION_LITERAL_EXP_CS__TYPE_CS:
				return basicSetTypeCS(null, msgs);
			case EssentialOCLCSTPackage.COLLECTION_LITERAL_EXP_CS__COLLECTION_LITERAL_PARTS:
				return ((InternalEList<?>)getCollectionLiteralParts()).basicRemove(otherEnd, msgs);
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
			case EssentialOCLCSTPackage.COLLECTION_LITERAL_EXP_CS__TYPE_CS:
				return getTypeCS();
			case EssentialOCLCSTPackage.COLLECTION_LITERAL_EXP_CS__COLLECTION_LITERAL_PARTS:
				return getCollectionLiteralParts();
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
			case EssentialOCLCSTPackage.COLLECTION_LITERAL_EXP_CS__TYPE_CS:
				setTypeCS((CollectionTypeCS)newValue);
				return;
			case EssentialOCLCSTPackage.COLLECTION_LITERAL_EXP_CS__COLLECTION_LITERAL_PARTS:
				getCollectionLiteralParts().clear();
				getCollectionLiteralParts().addAll((Collection<? extends CollectionLiteralPartCS>)newValue);
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
			case EssentialOCLCSTPackage.COLLECTION_LITERAL_EXP_CS__TYPE_CS:
				setTypeCS((CollectionTypeCS)null);
				return;
			case EssentialOCLCSTPackage.COLLECTION_LITERAL_EXP_CS__COLLECTION_LITERAL_PARTS:
				getCollectionLiteralParts().clear();
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
			case EssentialOCLCSTPackage.COLLECTION_LITERAL_EXP_CS__TYPE_CS:
				return typeCS != null;
			case EssentialOCLCSTPackage.COLLECTION_LITERAL_EXP_CS__COLLECTION_LITERAL_PARTS:
				return collectionLiteralParts != null && !collectionLiteralParts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CollectionLiteralExpCSImpl
