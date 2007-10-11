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
 * $Id: TypeTypeImpl.java,v 1.5 2007/10/11 23:04:56 cdamus Exp $
 */
package org.eclipse.ocl.types.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.types.TypeType;
import org.eclipse.ocl.types.TypesPackage;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.types.impl.TypeTypeImpl#getReferredType <em>Referred Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeTypeImpl<C, O> extends EObjectImpl implements TypeType<C, O> {
	/**
     * The cached value of the '{@link #getReferredType() <em>Referred Type</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getReferredType()
     * @generated
     * @ordered
     */
	protected C referredType;

	private String name;
	private EList<O> operations;
	
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected TypeTypeImpl() {
        super();
    }

	protected TypeTypeImpl(C type) {
		this.referredType = type;
	}
	
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return TypesPackage.Literals.TYPE_TYPE;
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getName() {
		if (name == null) {
			Environment<?, ?, O, ?, ?, ?, ?, ?, ?, ?, ?, ?> env =
				Environment.Registry.INSTANCE.getEnvironmentFor(this);
			
			name = env.getUMLReflection().getName(getReferredType());
		}
		
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<O> oclOperations() {
		if (operations == null) {
			Environment<?, ?, O, ?, ?, ?, ?, ?, ?, ?, ?, ?> env =
				Environment.Registry.INSTANCE.getEnvironmentFor(this);
			
			operations = new BasicEList<O>(
					OCLStandardLibraryUtil.createTypeTypeOperations(env));
		}
		
		return operations;
	}

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
	public C getReferredType() {
        if (referredType != null && ((EObject)referredType).eIsProxy()) {
            InternalEObject oldReferredType = (InternalEObject)referredType;
            referredType = (C)eResolveProxy(oldReferredType);
            if (referredType != oldReferredType) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, TypesPackage.TYPE_TYPE__REFERRED_TYPE, oldReferredType, referredType));
            }
        }
        return referredType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public C basicGetReferredType() {
        return referredType;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setReferredType(C newReferredType) {
        C oldReferredType = referredType;
        referredType = newReferredType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.TYPE_TYPE__REFERRED_TYPE, oldReferredType, referredType));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case TypesPackage.TYPE_TYPE__REFERRED_TYPE:
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
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case TypesPackage.TYPE_TYPE__REFERRED_TYPE:
                setReferredType((C)newValue);
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
            case TypesPackage.TYPE_TYPE__REFERRED_TYPE:
                setReferredType((C)null);
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
            case TypesPackage.TYPE_TYPE__REFERRED_TYPE:
                return referredType != null;
        }
        return super.eIsSet(featureID);
    }

} //TypeTypeImpl
