/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 207365
 * 
 * </copyright>
 *
 * $Id: NavigationCallExpImpl.java,v 1.5 2008/10/12 01:12:32 cdamus Exp $
 */
package org.eclipse.ocl.uml.impl;

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
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.uml.NavigationCallExp;
import org.eclipse.ocl.uml.UMLPackage;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Navigation Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.uml.impl.NavigationCallExpImpl#getQualifier <em>Qualifier</em>}</li>
 *   <li>{@link org.eclipse.ocl.uml.impl.NavigationCallExpImpl#getNavigationSource <em>Navigation Source</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("restriction")
public abstract class NavigationCallExpImpl
		extends FeatureCallExpImpl
		implements NavigationCallExp {

	/**
	 * The cached value of the '{@link #getQualifier() <em>Qualifier</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifier()
	 * @generated
	 * @ordered
	 */
	protected EList<OCLExpression<Classifier>> qualifier;

	/**
	 * The cached value of the '{@link #getNavigationSource() <em>Navigation Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNavigationSource()
	 * @generated
	 * @ordered
	 */
	protected Property navigationSource;

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
		return UMLPackage.Literals.NAVIGATION_CALL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OCLExpression<Classifier>> getQualifier() {
		if (qualifier == null) {
			qualifier = new EObjectContainmentEList<OCLExpression<Classifier>>(
				OCLExpression.class, this,
				UMLPackage.NAVIGATION_CALL_EXP__QUALIFIER);
		}
		return qualifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getNavigationSource() {
		if (navigationSource != null && ((EObject) navigationSource).eIsProxy()) {
			InternalEObject oldNavigationSource = (InternalEObject) navigationSource;
			navigationSource = (Property) eResolveProxy(oldNavigationSource);
			if (navigationSource != oldNavigationSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						UMLPackage.NAVIGATION_CALL_EXP__NAVIGATION_SOURCE,
						oldNavigationSource, navigationSource));
			}
		}
		return navigationSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetNavigationSource() {
		return navigationSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public void setNavigationSource(Property newNavigationSource) {
		Property oldNavigationSource = navigationSource;
		navigationSource = newNavigationSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.NAVIGATION_CALL_EXP__NAVIGATION_SOURCE,
				oldNavigationSource, navigationSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLPackage.NAVIGATION_CALL_EXP__QUALIFIER :
				return ((InternalEList<?>) getQualifier()).basicRemove(
					otherEnd, msgs);
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
			case UMLPackage.NAVIGATION_CALL_EXP__QUALIFIER :
				return getQualifier();
			case UMLPackage.NAVIGATION_CALL_EXP__NAVIGATION_SOURCE :
				if (resolve)
					return getNavigationSource();
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
			case UMLPackage.NAVIGATION_CALL_EXP__QUALIFIER :
				getQualifier().clear();
				getQualifier().addAll(
					(Collection<? extends OCLExpression<Classifier>>) newValue);
				return;
			case UMLPackage.NAVIGATION_CALL_EXP__NAVIGATION_SOURCE :
				setNavigationSource((Property) newValue);
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
			case UMLPackage.NAVIGATION_CALL_EXP__QUALIFIER :
				getQualifier().clear();
				return;
			case UMLPackage.NAVIGATION_CALL_EXP__NAVIGATION_SOURCE :
				setNavigationSource((Property) null);
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
			case UMLPackage.NAVIGATION_CALL_EXP__QUALIFIER :
				return qualifier != null && !qualifier.isEmpty();
			case UMLPackage.NAVIGATION_CALL_EXP__NAVIGATION_SOURCE :
				return navigationSource != null;
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
		if (baseClass == org.eclipse.ocl.expressions.NavigationCallExp.class) {
			switch (derivedFeatureID) {
				case UMLPackage.NAVIGATION_CALL_EXP__QUALIFIER :
					return ExpressionsPackage.NAVIGATION_CALL_EXP__QUALIFIER;
				case UMLPackage.NAVIGATION_CALL_EXP__NAVIGATION_SOURCE :
					return ExpressionsPackage.NAVIGATION_CALL_EXP__NAVIGATION_SOURCE;
				default :
					return -1;
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
		if (baseClass == org.eclipse.ocl.expressions.NavigationCallExp.class) {
			switch (baseFeatureID) {
				case ExpressionsPackage.NAVIGATION_CALL_EXP__QUALIFIER :
					return UMLPackage.NAVIGATION_CALL_EXP__QUALIFIER;
				case ExpressionsPackage.NAVIGATION_CALL_EXP__NAVIGATION_SOURCE :
					return UMLPackage.NAVIGATION_CALL_EXP__NAVIGATION_SOURCE;
				default :
					return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //NavigationCallExpImpl
