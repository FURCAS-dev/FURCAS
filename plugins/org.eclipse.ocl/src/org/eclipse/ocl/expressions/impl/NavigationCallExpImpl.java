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
 * $Id: NavigationCallExpImpl.java,v 1.4 2007/10/11 23:04:55 cdamus Exp $
 */
package org.eclipse.ocl.expressions.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.NavigationCallExp;
import org.eclipse.ocl.expressions.OCLExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Navigation Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.impl.NavigationCallExpImpl#getQualifier <em>Qualifier</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.impl.NavigationCallExpImpl#getNavigationSource <em>Navigation Source</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class NavigationCallExpImpl<C, P> extends FeatureCallExpImpl<C> implements NavigationCallExp<C, P> {
	/**
     * The cached value of the '{@link #getQualifier() <em>Qualifier</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getQualifier()
     * @generated
     * @ordered
     */
	protected EList<OCLExpression<C>> qualifier;

	/**
     * The cached value of the '{@link #getNavigationSource() <em>Navigation Source</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getNavigationSource()
     * @generated
     * @ordered
     */
	protected P navigationSource;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected NavigationCallExpImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExpressionsPackage.Literals.NAVIGATION_CALL_EXP;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<OCLExpression<C>> getQualifier() {
        if (qualifier == null) {
            qualifier = new EObjectContainmentEList<OCLExpression<C>>(OCLExpression.class, this, ExpressionsPackage.NAVIGATION_CALL_EXP__QUALIFIER);
        }
        return qualifier;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
	public P getNavigationSource() {
        if (navigationSource != null && ((EObject)navigationSource).eIsProxy()) {
            InternalEObject oldNavigationSource = (InternalEObject)navigationSource;
            navigationSource = (P)eResolveProxy(oldNavigationSource);
            if (navigationSource != oldNavigationSource) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.NAVIGATION_CALL_EXP__NAVIGATION_SOURCE, oldNavigationSource, navigationSource));
            }
        }
        return navigationSource;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public P basicGetNavigationSource() {
        return navigationSource;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setNavigationSource(P newNavigationSource) {
        P oldNavigationSource = navigationSource;
        navigationSource = newNavigationSource;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.NAVIGATION_CALL_EXP__NAVIGATION_SOURCE, oldNavigationSource, navigationSource));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ExpressionsPackage.NAVIGATION_CALL_EXP__QUALIFIER:
                return ((InternalEList<?>)getQualifier()).basicRemove(otherEnd, msgs);
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
            case ExpressionsPackage.NAVIGATION_CALL_EXP__QUALIFIER:
                return getQualifier();
            case ExpressionsPackage.NAVIGATION_CALL_EXP__NAVIGATION_SOURCE:
                if (resolve) return getNavigationSource();
                return basicGetNavigationSource();
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
            case ExpressionsPackage.NAVIGATION_CALL_EXP__QUALIFIER:
                getQualifier().clear();
                getQualifier().addAll((Collection<? extends OCLExpression<C>>)newValue);
                return;
            case ExpressionsPackage.NAVIGATION_CALL_EXP__NAVIGATION_SOURCE:
                setNavigationSource((P)newValue);
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
            case ExpressionsPackage.NAVIGATION_CALL_EXP__QUALIFIER:
                getQualifier().clear();
                return;
            case ExpressionsPackage.NAVIGATION_CALL_EXP__NAVIGATION_SOURCE:
                setNavigationSource((P)null);
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
            case ExpressionsPackage.NAVIGATION_CALL_EXP__QUALIFIER:
                return qualifier != null && !qualifier.isEmpty();
            case ExpressionsPackage.NAVIGATION_CALL_EXP__NAVIGATION_SOURCE:
                return navigationSource != null;
        }
        return super.eIsSet(featureID);
    }

} //NavigationCallExpImpl
