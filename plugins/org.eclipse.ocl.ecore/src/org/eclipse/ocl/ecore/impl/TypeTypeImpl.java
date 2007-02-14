/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 * 
 * </copyright>
 *
 * $Id: TypeTypeImpl.java,v 1.2 2007/02/14 13:42:02 cdamus Exp $
 */
package org.eclipse.ocl.ecore.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EClassifierImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.ecore.TypeType;
import org.eclipse.ocl.ecore.internal.OCLStandardLibraryImpl;

import org.eclipse.ocl.types.TypesPackage;

import org.eclipse.ocl.utilities.PredefinedType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.ecore.impl.TypeTypeImpl#getReferredType <em>Referred Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeTypeImpl extends EClassifierImpl implements TypeType {
    private EList<EOperation> operations;
    
    /**
     * The cached value of the '{@link #getReferredType() <em>Referred Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReferredType()
     * @generated
     * @ordered
     */
    protected EClassifier referredType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TypeTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    protected TypeTypeImpl(EClassifier referredType) {
        this();
        
        this.referredType = referredType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return EcorePackage.Literals.TYPE_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EClassifier getReferredType() {
        if (referredType != null && ((EObject)referredType).eIsProxy()) {
            InternalEObject oldReferredType = (InternalEObject)referredType;
            referredType = (EClassifier)eResolveProxy(oldReferredType);
            if (referredType != oldReferredType) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, EcorePackage.TYPE_TYPE__REFERRED_TYPE, oldReferredType, referredType));
            }
        }
        return referredType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClassifier basicGetReferredType() {
        return referredType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public String getName() {
        if (name == null) {
            name = SINGLETON_NAME;
        }
        
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public EList<EOperation> oclOperations() {
        if (operations == null) {
            TypeType prototype =
                (TypeType) OCLStandardLibraryImpl.INSTANCE.getOclType();
            
            if (prototype == this) {
                // I *am* the standard library type!
                operations = OCLStandardLibraryImpl.getExistingOperations(this);
            } else {
                // the prototype defines my operations for me
                operations = prototype.oclOperations();
            }
        }
        
        return operations;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case EcorePackage.TYPE_TYPE__REFERRED_TYPE:
                if (resolve) return getReferredType();
                return basicGetReferredType();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case EcorePackage.TYPE_TYPE__REFERRED_TYPE:
                return referredType != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
        if (baseClass == PredefinedType.class) {
            switch (derivedFeatureID) {
                default: return -1;
            }
        }
        if (baseClass == org.eclipse.ocl.types.TypeType.class) {
            switch (derivedFeatureID) {
                case EcorePackage.TYPE_TYPE__REFERRED_TYPE: return TypesPackage.TYPE_TYPE__REFERRED_TYPE;
                default: return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
        if (baseClass == PredefinedType.class) {
            switch (baseFeatureID) {
                default: return -1;
            }
        }
        if (baseClass == org.eclipse.ocl.types.TypeType.class) {
            switch (baseFeatureID) {
                case TypesPackage.TYPE_TYPE__REFERRED_TYPE: return EcorePackage.TYPE_TYPE__REFERRED_TYPE;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} //TypeTypeImpl
