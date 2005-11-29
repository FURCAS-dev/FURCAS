/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
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
 * $Id$
 */

package org.eclipse.emf.ocl.uml.internal.impl;

import org.eclipse.emf.ocl.uml.Operation;
import org.eclipse.emf.ocl.uml.UmlPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EOperationImpl;

import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.uml.internal.impl.OperationImpl#isQuery <em>Query</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationImpl extends EOperationImpl implements Operation {
	/**
	 * The default value of the '{@link #isQuery() <em>Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isQuery()
	 * @generated
	 * @ordered
	 */
	protected static final boolean QUERY_EDEFAULT = true;

	/**
	 * The flag representing the value of the '{@link #isQuery() <em>Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isQuery()
	 * @generated
	 * @ordered
	 */
	protected static final int QUERY_EFLAG = 1 << 8;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationImpl() {
		super();
		eFlags |= QUERY_EFLAG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UmlPackage.eINSTANCE.getOperation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isQuery() {
		return (eFlags & QUERY_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuery(boolean newQuery) {
		boolean oldQuery = (eFlags & QUERY_EFLAG) != 0;
		if (newQuery) eFlags |= QUERY_EFLAG; else eFlags &= ~QUERY_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlPackage.OPERATION__QUERY, oldQuery, newQuery));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case UmlPackage.OPERATION__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicAdd(otherEnd, msgs);
				case UmlPackage.OPERATION__ECONTAINING_CLASS:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, UmlPackage.OPERATION__ECONTAINING_CLASS, msgs);
				case UmlPackage.OPERATION__EPARAMETERS:
					return ((InternalEList)getEParameters()).basicAdd(otherEnd, msgs);
				default:
					return eDynamicInverseAdd(otherEnd, featureID, baseClass, msgs);
			}
		}
		if (eContainer != null)
			msgs = eBasicRemoveFromContainer(msgs);
		return eBasicSetContainer(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case UmlPackage.OPERATION__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
				case UmlPackage.OPERATION__ECONTAINING_CLASS:
					return eBasicSetContainer(null, UmlPackage.OPERATION__ECONTAINING_CLASS, msgs);
				case UmlPackage.OPERATION__EPARAMETERS:
					return ((InternalEList)getEParameters()).basicRemove(otherEnd, msgs);
				default:
					return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
			}
		}
		return eBasicSetContainer(null, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainer(NotificationChain msgs) {
		if (eContainerFeatureID >= 0) {
			switch (eContainerFeatureID) {
				case UmlPackage.OPERATION__ECONTAINING_CLASS:
					return eContainer.eInverseRemove(this, EcorePackage.ECLASS__EOPERATIONS, EClass.class, msgs);
				default:
					return eDynamicBasicRemoveFromContainer(msgs);
			}
		}
		return eContainer.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - eContainerFeatureID, null, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case UmlPackage.OPERATION__EANNOTATIONS:
				return getEAnnotations();
			case UmlPackage.OPERATION__NAME:
				return getName();
			case UmlPackage.OPERATION__ORDERED:
				return isOrdered() ? Boolean.TRUE : Boolean.FALSE;
			case UmlPackage.OPERATION__UNIQUE:
				return isUnique() ? Boolean.TRUE : Boolean.FALSE;
			case UmlPackage.OPERATION__LOWER_BOUND:
				return new Integer(getLowerBound());
			case UmlPackage.OPERATION__UPPER_BOUND:
				return new Integer(getUpperBound());
			case UmlPackage.OPERATION__MANY:
				return isMany() ? Boolean.TRUE : Boolean.FALSE;
			case UmlPackage.OPERATION__REQUIRED:
				return isRequired() ? Boolean.TRUE : Boolean.FALSE;
			case UmlPackage.OPERATION__ETYPE:
				if (resolve) return getEType();
				return basicGetEType();
			case UmlPackage.OPERATION__ECONTAINING_CLASS:
				return getEContainingClass();
			case UmlPackage.OPERATION__EPARAMETERS:
				return getEParameters();
			case UmlPackage.OPERATION__EEXCEPTIONS:
				return getEExceptions();
			case UmlPackage.OPERATION__QUERY:
				return isQuery() ? Boolean.TRUE : Boolean.FALSE;
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case UmlPackage.OPERATION__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case UmlPackage.OPERATION__NAME:
				setName((String)newValue);
				return;
			case UmlPackage.OPERATION__ORDERED:
				setOrdered(((Boolean)newValue).booleanValue());
				return;
			case UmlPackage.OPERATION__UNIQUE:
				setUnique(((Boolean)newValue).booleanValue());
				return;
			case UmlPackage.OPERATION__LOWER_BOUND:
				setLowerBound(((Integer)newValue).intValue());
				return;
			case UmlPackage.OPERATION__UPPER_BOUND:
				setUpperBound(((Integer)newValue).intValue());
				return;
			case UmlPackage.OPERATION__ETYPE:
				setEType((EClassifier)newValue);
				return;
			case UmlPackage.OPERATION__EPARAMETERS:
				getEParameters().clear();
				getEParameters().addAll((Collection)newValue);
				return;
			case UmlPackage.OPERATION__EEXCEPTIONS:
				getEExceptions().clear();
				getEExceptions().addAll((Collection)newValue);
				return;
			case UmlPackage.OPERATION__QUERY:
				setQuery(((Boolean)newValue).booleanValue());
				return;
		}
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case UmlPackage.OPERATION__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case UmlPackage.OPERATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UmlPackage.OPERATION__ORDERED:
				setOrdered(ORDERED_EDEFAULT);
				return;
			case UmlPackage.OPERATION__UNIQUE:
				setUnique(UNIQUE_EDEFAULT);
				return;
			case UmlPackage.OPERATION__LOWER_BOUND:
				setLowerBound(LOWER_BOUND_EDEFAULT);
				return;
			case UmlPackage.OPERATION__UPPER_BOUND:
				setUpperBound(UPPER_BOUND_EDEFAULT);
				return;
			case UmlPackage.OPERATION__ETYPE:
				setEType((EClassifier)null);
				return;
			case UmlPackage.OPERATION__EPARAMETERS:
				getEParameters().clear();
				return;
			case UmlPackage.OPERATION__EEXCEPTIONS:
				getEExceptions().clear();
				return;
			case UmlPackage.OPERATION__QUERY:
				setQuery(QUERY_EDEFAULT);
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case UmlPackage.OPERATION__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case UmlPackage.OPERATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UmlPackage.OPERATION__ORDERED:
				return ((eFlags & ORDERED_EFLAG) != 0) != ORDERED_EDEFAULT;
			case UmlPackage.OPERATION__UNIQUE:
				return ((eFlags & UNIQUE_EFLAG) != 0) != UNIQUE_EDEFAULT;
			case UmlPackage.OPERATION__LOWER_BOUND:
				return lowerBound != LOWER_BOUND_EDEFAULT;
			case UmlPackage.OPERATION__UPPER_BOUND:
				return upperBound != UPPER_BOUND_EDEFAULT;
			case UmlPackage.OPERATION__MANY:
				return isMany() != MANY_EDEFAULT;
			case UmlPackage.OPERATION__REQUIRED:
				return isRequired() != REQUIRED_EDEFAULT;
			case UmlPackage.OPERATION__ETYPE:
				return eType != null;
			case UmlPackage.OPERATION__ECONTAINING_CLASS:
				return getEContainingClass() != null;
			case UmlPackage.OPERATION__EPARAMETERS:
				return eParameters != null && !eParameters.isEmpty();
			case UmlPackage.OPERATION__EEXCEPTIONS:
				return eExceptions != null && !eExceptions.isEmpty();
			case UmlPackage.OPERATION__QUERY:
				return ((eFlags & QUERY_EFLAG) != 0) != QUERY_EDEFAULT;
		}
		return eDynamicIsSet(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (query: "); //$NON-NLS-1$
		result.append((eFlags & QUERY_EFLAG) != 0);
		result.append(')');
		return result.toString();
	}

} //OperationImpl
