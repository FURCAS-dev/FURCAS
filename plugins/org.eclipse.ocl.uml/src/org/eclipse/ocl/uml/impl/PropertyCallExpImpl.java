/**
 * <copyright>
 * 
 * Copyright (c) 2007 IBM Corporation and others.
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
 * $Id: PropertyCallExpImpl.java,v 1.2 2007/10/11 23:05:22 cdamus Exp $
 */
package org.eclipse.ocl.uml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.uml.PropertyCallExp;
import org.eclipse.ocl.uml.UMLPackage;
import org.eclipse.ocl.utilities.Visitor;
import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.uml.impl.PropertyCallExpImpl#getReferredProperty <em>Referred Property</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("restriction")
public class PropertyCallExpImpl extends NavigationCallExpImpl implements PropertyCallExp {
	/**
     * The cached value of the '{@link #getReferredProperty() <em>Referred Property</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getReferredProperty()
     * @generated
     * @ordered
     */
	protected Property referredProperty;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PropertyCallExpImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return UMLPackage.Literals.PROPERTY_CALL_EXP;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
	public Property getReferredProperty() {
        if (referredProperty != null && ((EObject)referredProperty).eIsProxy()) {
            InternalEObject oldReferredProperty = (InternalEObject)referredProperty;
            referredProperty = (Property)eResolveProxy(oldReferredProperty);
            if (referredProperty != oldReferredProperty) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY, oldReferredProperty, referredProperty));
            }
        }
        return referredProperty;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Property basicGetReferredProperty() {
        return referredProperty;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */

	public void setReferredProperty(Property newReferredProperty) {
        Property oldReferredProperty = referredProperty;
        referredProperty = newReferredProperty;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, UMLPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY, oldReferredProperty, referredProperty));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case UMLPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY:
                if (resolve) return getReferredProperty();
                return basicGetReferredProperty();
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
            case UMLPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY:
                setReferredProperty((Property)newValue);
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
            case UMLPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY:
                setReferredProperty((Property)null);
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
            case UMLPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY:
                return referredProperty != null;
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
        if (baseClass == org.eclipse.ocl.expressions.PropertyCallExp.class) {
            switch (derivedFeatureID) {
                case UMLPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY: return ExpressionsPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY;
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
        if (baseClass == org.eclipse.ocl.expressions.PropertyCallExp.class) {
            switch (baseFeatureID) {
                case ExpressionsPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY: return UMLPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
    public <T, U extends Visitor<T, ?, ?, ?, ?, ?, ?, ?, ?, ?>> T accept(U v) {
		return v.visitPropertyCallExp(this);
	}

} //PropertyCallExpImpl
