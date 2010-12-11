/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.impl;

import com.sap.furcas.metamodel.FURCAS.TCS.QueryByIdentifierPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Query By Identifier PArg</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.QueryByIdentifierPArgImpl#getQueryByIdentifier <em>Query By Identifier</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.QueryByIdentifierPArgImpl#getFeature <em>Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QueryByIdentifierPArgImpl extends PropertyArgImpl implements QueryByIdentifierPArg {
    /**
     * The default value of the '{@link #getQueryByIdentifier() <em>Query By Identifier</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getQueryByIdentifier()
     * @generated
     * @ordered
     */
    protected static final String QUERY_BY_IDENTIFIER_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getQueryByIdentifier() <em>Query By Identifier</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getQueryByIdentifier()
     * @generated
     * @ordered
     */
    protected String queryByIdentifier = QUERY_BY_IDENTIFIER_EDEFAULT;

    /**
     * The default value of the '{@link #getFeature() <em>Feature</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFeature()
     * @generated
     * @ordered
     */
    protected static final String FEATURE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getFeature() <em>Feature</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFeature()
     * @generated
     * @ordered
     */
    protected String feature = FEATURE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected QueryByIdentifierPArgImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return TCSPackage.Literals.QUERY_BY_IDENTIFIER_PARG;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getQueryByIdentifier() {
        return queryByIdentifier;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setQueryByIdentifier(String newQueryByIdentifier) {
        String oldQueryByIdentifier = queryByIdentifier;
        queryByIdentifier = newQueryByIdentifier;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.QUERY_BY_IDENTIFIER_PARG__QUERY_BY_IDENTIFIER, oldQueryByIdentifier, queryByIdentifier));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getFeature() {
        return feature;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFeature(String newFeature) {
        String oldFeature = feature;
        feature = newFeature;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.QUERY_BY_IDENTIFIER_PARG__FEATURE, oldFeature, feature));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case TCSPackage.QUERY_BY_IDENTIFIER_PARG__QUERY_BY_IDENTIFIER:
                return getQueryByIdentifier();
            case TCSPackage.QUERY_BY_IDENTIFIER_PARG__FEATURE:
                return getFeature();
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
            case TCSPackage.QUERY_BY_IDENTIFIER_PARG__QUERY_BY_IDENTIFIER:
                setQueryByIdentifier((String)newValue);
                return;
            case TCSPackage.QUERY_BY_IDENTIFIER_PARG__FEATURE:
                setFeature((String)newValue);
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
            case TCSPackage.QUERY_BY_IDENTIFIER_PARG__QUERY_BY_IDENTIFIER:
                setQueryByIdentifier(QUERY_BY_IDENTIFIER_EDEFAULT);
                return;
            case TCSPackage.QUERY_BY_IDENTIFIER_PARG__FEATURE:
                setFeature(FEATURE_EDEFAULT);
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
            case TCSPackage.QUERY_BY_IDENTIFIER_PARG__QUERY_BY_IDENTIFIER:
                return QUERY_BY_IDENTIFIER_EDEFAULT == null ? queryByIdentifier != null : !QUERY_BY_IDENTIFIER_EDEFAULT.equals(queryByIdentifier);
            case TCSPackage.QUERY_BY_IDENTIFIER_PARG__FEATURE:
                return FEATURE_EDEFAULT == null ? feature != null : !FEATURE_EDEFAULT.equals(feature);
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
        result.append(" (queryByIdentifier: ");
        result.append(queryByIdentifier);
        result.append(", feature: ");
        result.append(feature);
        result.append(')');
        return result.toString();
    }

} //QueryByIdentifierPArgImpl
