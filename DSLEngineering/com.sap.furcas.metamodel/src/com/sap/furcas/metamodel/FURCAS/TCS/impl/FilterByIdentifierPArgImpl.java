/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.impl;

import com.sap.furcas.metamodel.FURCAS.TCS.FilterByIdentifierPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Filter By Identifier PArg</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.FilterByIdentifierPArgImpl#getFilter <em>Filter</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.FilterByIdentifierPArgImpl#getCriterion <em>Criterion</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FilterByIdentifierPArgImpl extends PropertyArgImpl implements FilterByIdentifierPArg {
    /**
     * The default value of the '{@link #getFilter() <em>Filter</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFilter()
     * @generated
     * @ordered
     */
    protected static final String FILTER_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getFilter() <em>Filter</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFilter()
     * @generated
     * @ordered
     */
    protected String filter = FILTER_EDEFAULT;

    /**
     * The default value of the '{@link #getCriterion() <em>Criterion</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCriterion()
     * @generated
     * @ordered
     */
    protected static final String CRITERION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCriterion() <em>Criterion</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCriterion()
     * @generated
     * @ordered
     */
    protected String criterion = CRITERION_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FilterByIdentifierPArgImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return TCSPackage.Literals.FILTER_BY_IDENTIFIER_PARG;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getFilter() {
        return filter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFilter(String newFilter) {
        String oldFilter = filter;
        filter = newFilter;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.FILTER_BY_IDENTIFIER_PARG__FILTER, oldFilter, filter));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getCriterion() {
        return criterion;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCriterion(String newCriterion) {
        String oldCriterion = criterion;
        criterion = newCriterion;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.FILTER_BY_IDENTIFIER_PARG__CRITERION, oldCriterion, criterion));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case TCSPackage.FILTER_BY_IDENTIFIER_PARG__FILTER:
                return getFilter();
            case TCSPackage.FILTER_BY_IDENTIFIER_PARG__CRITERION:
                return getCriterion();
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
            case TCSPackage.FILTER_BY_IDENTIFIER_PARG__FILTER:
                setFilter((String)newValue);
                return;
            case TCSPackage.FILTER_BY_IDENTIFIER_PARG__CRITERION:
                setCriterion((String)newValue);
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
            case TCSPackage.FILTER_BY_IDENTIFIER_PARG__FILTER:
                setFilter(FILTER_EDEFAULT);
                return;
            case TCSPackage.FILTER_BY_IDENTIFIER_PARG__CRITERION:
                setCriterion(CRITERION_EDEFAULT);
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
            case TCSPackage.FILTER_BY_IDENTIFIER_PARG__FILTER:
                return FILTER_EDEFAULT == null ? filter != null : !FILTER_EDEFAULT.equals(filter);
            case TCSPackage.FILTER_BY_IDENTIFIER_PARG__CRITERION:
                return CRITERION_EDEFAULT == null ? criterion != null : !CRITERION_EDEFAULT.equals(criterion);
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
        result.append(" (filter: ");
        result.append(filter);
        result.append(", criterion: ");
        result.append(criterion);
        result.append(')');
        return result.toString();
    }

} //FilterByIdentifierPArgImpl
