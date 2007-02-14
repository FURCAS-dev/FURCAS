/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: CollectionTypeCSImpl.java,v 1.2 2007/02/14 14:46:06 cdamus Exp $
 */
package org.eclipse.ocl.internal.cst.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.ocl.internal.cst.CSTPackage;
import org.eclipse.ocl.internal.cst.CollectionTypeCS;
import org.eclipse.ocl.internal.cst.CollectionTypeIdentifierEnum;
import org.eclipse.ocl.internal.cst.TypeCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Type CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.internal.cst.impl.CollectionTypeCSImpl#getCollectionTypeIdentifier <em>Collection Type Identifier</em>}</li>
 *   <li>{@link org.eclipse.ocl.internal.cst.impl.CollectionTypeCSImpl#getTypeCS <em>Type CS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionTypeCSImpl extends TypeCSImpl implements CollectionTypeCS {
	/**
     * The default value of the '{@link #getCollectionTypeIdentifier() <em>Collection Type Identifier</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getCollectionTypeIdentifier()
     * @generated
     * @ordered
     */
	protected static final CollectionTypeIdentifierEnum COLLECTION_TYPE_IDENTIFIER_EDEFAULT = CollectionTypeIdentifierEnum.SET_LITERAL;

	/**
     * The cached value of the '{@link #getCollectionTypeIdentifier() <em>Collection Type Identifier</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getCollectionTypeIdentifier()
     * @generated
     * @ordered
     */
	protected CollectionTypeIdentifierEnum collectionTypeIdentifier = COLLECTION_TYPE_IDENTIFIER_EDEFAULT;

	/**
     * The cached value of the '{@link #getTypeCS() <em>Type CS</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTypeCS()
     * @generated
     * @ordered
     */
	protected TypeCS typeCS = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected CollectionTypeCSImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return CSTPackage.Literals.COLLECTION_TYPE_CS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public CollectionTypeIdentifierEnum getCollectionTypeIdentifier() {
        return collectionTypeIdentifier;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setCollectionTypeIdentifier(CollectionTypeIdentifierEnum newCollectionTypeIdentifier) {
        CollectionTypeIdentifierEnum oldCollectionTypeIdentifier = collectionTypeIdentifier;
        collectionTypeIdentifier = newCollectionTypeIdentifier == null ? COLLECTION_TYPE_IDENTIFIER_EDEFAULT : newCollectionTypeIdentifier;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.COLLECTION_TYPE_CS__COLLECTION_TYPE_IDENTIFIER, oldCollectionTypeIdentifier, collectionTypeIdentifier));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TypeCS getTypeCS() {
        if (typeCS != null && typeCS.eIsProxy()) {
            InternalEObject oldTypeCS = (InternalEObject)typeCS;
            typeCS = (TypeCS)eResolveProxy(oldTypeCS);
            if (typeCS != oldTypeCS) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CSTPackage.COLLECTION_TYPE_CS__TYPE_CS, oldTypeCS, typeCS));
            }
        }
        return typeCS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TypeCS basicGetTypeCS() {
        return typeCS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTypeCS(TypeCS newTypeCS) {
        TypeCS oldTypeCS = typeCS;
        typeCS = newTypeCS;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.COLLECTION_TYPE_CS__TYPE_CS, oldTypeCS, typeCS));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case CSTPackage.COLLECTION_TYPE_CS__COLLECTION_TYPE_IDENTIFIER:
                return getCollectionTypeIdentifier();
            case CSTPackage.COLLECTION_TYPE_CS__TYPE_CS:
                if (resolve) return getTypeCS();
                return basicGetTypeCS();
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
            case CSTPackage.COLLECTION_TYPE_CS__COLLECTION_TYPE_IDENTIFIER:
                setCollectionTypeIdentifier((CollectionTypeIdentifierEnum)newValue);
                return;
            case CSTPackage.COLLECTION_TYPE_CS__TYPE_CS:
                setTypeCS((TypeCS)newValue);
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
            case CSTPackage.COLLECTION_TYPE_CS__COLLECTION_TYPE_IDENTIFIER:
                setCollectionTypeIdentifier(COLLECTION_TYPE_IDENTIFIER_EDEFAULT);
                return;
            case CSTPackage.COLLECTION_TYPE_CS__TYPE_CS:
                setTypeCS((TypeCS)null);
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
            case CSTPackage.COLLECTION_TYPE_CS__COLLECTION_TYPE_IDENTIFIER:
                return collectionTypeIdentifier != COLLECTION_TYPE_IDENTIFIER_EDEFAULT;
            case CSTPackage.COLLECTION_TYPE_CS__TYPE_CS:
                return typeCS != null;
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
        result.append(" (collectionTypeIdentifier: "); //$NON-NLS-1$
        result.append(collectionTypeIdentifier);
        result.append(')');
        return result.toString();
    }

} //CollectionTypeCSImpl
