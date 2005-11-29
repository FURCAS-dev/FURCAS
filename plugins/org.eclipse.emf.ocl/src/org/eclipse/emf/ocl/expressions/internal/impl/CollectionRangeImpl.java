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

package org.eclipse.emf.ocl.expressions.internal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.ocl.expressions.CollectionRange;
import org.eclipse.emf.ocl.expressions.ExpressionsPackage;
import org.eclipse.emf.ocl.expressions.OclExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Range</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.expressions.internal.impl.CollectionRangeImpl#getFirst <em>First</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.expressions.internal.impl.CollectionRangeImpl#getLast <em>Last</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionRangeImpl extends CollectionLiteralPartImpl implements CollectionRange {
	/**
	 * The cached value of the '{@link #getLast() <em>Last</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLast()
	 * @generated
	 * @ordered
	 */
	protected OclExpression last = null;

	/**
	 * The cached value of the '{@link #getFirst() <em>First</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirst()
	 * @generated
	 * @ordered
	 */
	protected OclExpression first = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionRangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ExpressionsPackage.eINSTANCE.getCollectionRange();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression getLast() {
		return last;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLast(OclExpression newLast, NotificationChain msgs) {
		OclExpression oldLast = last;
		last = newLast;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.COLLECTION_RANGE__LAST, oldLast, newLast);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLast(OclExpression newLast) {
		if (newLast != last) {
			NotificationChain msgs = null;
			if (last != null)
				msgs = ((InternalEObject)last).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.COLLECTION_RANGE__LAST, null, msgs);
			if (newLast != null)
				msgs = ((InternalEObject)newLast).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.COLLECTION_RANGE__LAST, null, msgs);
			msgs = basicSetLast(newLast, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.COLLECTION_RANGE__LAST, newLast, newLast));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case ExpressionsPackage.COLLECTION_RANGE__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicAdd(otherEnd, msgs);
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
				case ExpressionsPackage.COLLECTION_RANGE__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
				case ExpressionsPackage.COLLECTION_RANGE__FIRST:
					return basicSetFirst(null, msgs);
				case ExpressionsPackage.COLLECTION_RANGE__LAST:
					return basicSetLast(null, msgs);
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
	public OclExpression getFirst() {
		return first;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFirst(OclExpression newFirst, NotificationChain msgs) {
		OclExpression oldFirst = first;
		first = newFirst;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.COLLECTION_RANGE__FIRST, oldFirst, newFirst);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirst(OclExpression newFirst) {
		if (newFirst != first) {
			NotificationChain msgs = null;
			if (first != null)
				msgs = ((InternalEObject)first).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.COLLECTION_RANGE__FIRST, null, msgs);
			if (newFirst != null)
				msgs = ((InternalEObject)newFirst).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.COLLECTION_RANGE__FIRST, null, msgs);
			msgs = basicSetFirst(newFirst, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.COLLECTION_RANGE__FIRST, newFirst, newFirst));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExpressionsPackage.COLLECTION_RANGE__EANNOTATIONS:
				return getEAnnotations();
			case ExpressionsPackage.COLLECTION_RANGE__NAME:
				return getName();
			case ExpressionsPackage.COLLECTION_RANGE__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case ExpressionsPackage.COLLECTION_RANGE__FIRST:
				return getFirst();
			case ExpressionsPackage.COLLECTION_RANGE__LAST:
				return getLast();
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
			case ExpressionsPackage.COLLECTION_RANGE__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case ExpressionsPackage.COLLECTION_RANGE__NAME:
				setName((String)newValue);
				return;
			case ExpressionsPackage.COLLECTION_RANGE__TYPE:
				setType((EClassifier)newValue);
				return;
			case ExpressionsPackage.COLLECTION_RANGE__FIRST:
				setFirst((OclExpression)newValue);
				return;
			case ExpressionsPackage.COLLECTION_RANGE__LAST:
				setLast((OclExpression)newValue);
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
			case ExpressionsPackage.COLLECTION_RANGE__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case ExpressionsPackage.COLLECTION_RANGE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ExpressionsPackage.COLLECTION_RANGE__TYPE:
				setType((EClassifier)null);
				return;
			case ExpressionsPackage.COLLECTION_RANGE__FIRST:
				setFirst((OclExpression)null);
				return;
			case ExpressionsPackage.COLLECTION_RANGE__LAST:
				setLast((OclExpression)null);
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
			case ExpressionsPackage.COLLECTION_RANGE__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case ExpressionsPackage.COLLECTION_RANGE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ExpressionsPackage.COLLECTION_RANGE__TYPE:
				return type != null;
			case ExpressionsPackage.COLLECTION_RANGE__FIRST:
				return first != null;
			case ExpressionsPackage.COLLECTION_RANGE__LAST:
				return last != null;
		}
		return eDynamicIsSet(eFeature);
	}

} //CollectionRangeImpl
