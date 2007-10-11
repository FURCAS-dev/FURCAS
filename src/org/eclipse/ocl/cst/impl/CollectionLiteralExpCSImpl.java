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
 * $Id: CollectionLiteralExpCSImpl.java,v 1.1 2007/10/11 23:05:02 cdamus Exp $
 */
package org.eclipse.ocl.cst.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.ocl.cst.CollectionLiteralExpCS;
import org.eclipse.ocl.cst.CollectionLiteralPartCS;
import org.eclipse.ocl.cst.CollectionTypeIdentifierEnum;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Literal Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.impl.CollectionLiteralExpCSImpl#getCollectionType <em>Collection Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.impl.CollectionLiteralExpCSImpl#getCollectionLiteralParts <em>Collection Literal Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionLiteralExpCSImpl extends LiteralExpCSImpl implements CollectionLiteralExpCS {
	/**
     * The default value of the '{@link #getCollectionType() <em>Collection Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getCollectionType()
     * @generated
     * @ordered
     */
	protected static final CollectionTypeIdentifierEnum COLLECTION_TYPE_EDEFAULT = CollectionTypeIdentifierEnum.SET_LITERAL;

	/**
     * The cached value of the '{@link #getCollectionType() <em>Collection Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getCollectionType()
     * @generated
     * @ordered
     */
	protected CollectionTypeIdentifierEnum collectionType = COLLECTION_TYPE_EDEFAULT;

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
        return CSTPackage.Literals.COLLECTION_LITERAL_EXP_CS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public CollectionTypeIdentifierEnum getCollectionType() {
        return collectionType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setCollectionType(CollectionTypeIdentifierEnum newCollectionType) {
        CollectionTypeIdentifierEnum oldCollectionType = collectionType;
        collectionType = newCollectionType == null ? COLLECTION_TYPE_EDEFAULT : newCollectionType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.COLLECTION_LITERAL_EXP_CS__COLLECTION_TYPE, oldCollectionType, collectionType));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<CollectionLiteralPartCS> getCollectionLiteralParts() {
        if (collectionLiteralParts == null) {
            collectionLiteralParts = new EObjectContainmentEList<CollectionLiteralPartCS>(CollectionLiteralPartCS.class, this, CSTPackage.COLLECTION_LITERAL_EXP_CS__COLLECTION_LITERAL_PARTS);
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
            case CSTPackage.COLLECTION_LITERAL_EXP_CS__COLLECTION_LITERAL_PARTS:
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
            case CSTPackage.COLLECTION_LITERAL_EXP_CS__COLLECTION_TYPE:
                return getCollectionType();
            case CSTPackage.COLLECTION_LITERAL_EXP_CS__COLLECTION_LITERAL_PARTS:
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
            case CSTPackage.COLLECTION_LITERAL_EXP_CS__COLLECTION_TYPE:
                setCollectionType((CollectionTypeIdentifierEnum)newValue);
                return;
            case CSTPackage.COLLECTION_LITERAL_EXP_CS__COLLECTION_LITERAL_PARTS:
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
            case CSTPackage.COLLECTION_LITERAL_EXP_CS__COLLECTION_TYPE:
                setCollectionType(COLLECTION_TYPE_EDEFAULT);
                return;
            case CSTPackage.COLLECTION_LITERAL_EXP_CS__COLLECTION_LITERAL_PARTS:
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
            case CSTPackage.COLLECTION_LITERAL_EXP_CS__COLLECTION_TYPE:
                return collectionType != COLLECTION_TYPE_EDEFAULT;
            case CSTPackage.COLLECTION_LITERAL_EXP_CS__COLLECTION_LITERAL_PARTS:
                return collectionLiteralParts != null && !collectionLiteralParts.isEmpty();
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
        result.append(" (collectionType: "); //$NON-NLS-1$
        result.append(collectionType);
        result.append(')');
        return result.toString();
    }

} //CollectionLiteralExpCSImpl
