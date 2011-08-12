/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.impl;

import com.sap.furcas.metamodel.FURCAS.TCS.ReferenceByPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference By PArg</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ReferenceByPArgImpl#getReferenceBy <em>Reference By</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceByPArgImpl extends PropertyArgImpl implements ReferenceByPArg {
    /**
     * The default value of the '{@link #getReferenceBy() <em>Reference By</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReferenceBy()
     * @generated
     * @ordered
     */
    protected static final String REFERENCE_BY_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getReferenceBy() <em>Reference By</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReferenceBy()
     * @generated
     * @ordered
     */
    protected String referenceBy = REFERENCE_BY_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ReferenceByPArgImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return TCSPackage.Literals.REFERENCE_BY_PARG;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getReferenceBy() {
        return referenceBy;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setReferenceBy(String newReferenceBy) {
        String oldReferenceBy = referenceBy;
        referenceBy = newReferenceBy;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.REFERENCE_BY_PARG__REFERENCE_BY, oldReferenceBy, referenceBy));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case TCSPackage.REFERENCE_BY_PARG__REFERENCE_BY:
                return getReferenceBy();
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
            case TCSPackage.REFERENCE_BY_PARG__REFERENCE_BY:
                setReferenceBy((String)newValue);
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
            case TCSPackage.REFERENCE_BY_PARG__REFERENCE_BY:
                setReferenceBy(REFERENCE_BY_EDEFAULT);
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
            case TCSPackage.REFERENCE_BY_PARG__REFERENCE_BY:
                return REFERENCE_BY_EDEFAULT == null ? referenceBy != null : !REFERENCE_BY_EDEFAULT.equals(referenceBy);
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
        result.append(" (referenceBy: ");
        result.append(referenceBy);
        result.append(')');
        return result.toString();
    }

} //ReferenceByPArgImpl
