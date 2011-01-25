/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: CollectionRangeImpl.java,v 1.2 2011/01/24 20:42:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.CollectionRange;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Range</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CollectionRangeImpl#getFirst <em>First</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CollectionRangeImpl#getLast <em>Last</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionRangeImpl
		extends CollectionLiteralPartImpl
		implements CollectionRange {

	/**
	 * The cached value of the '{@link #getFirst() <em>First</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirst()
	 * @generated
	 * @ordered
	 */
	protected OclExpression first;

	/**
	 * The cached value of the '{@link #getLast() <em>Last</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLast()
	 * @generated
	 * @ordered
	 */
	protected OclExpression last;

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
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.COLLECTION_RANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression getFirst() {
		if (first != null && ((EObject)first).eIsProxy())
		{
			InternalEObject oldFirst = (InternalEObject)first;
			first = (OclExpression)eResolveProxy(oldFirst);
			if (first != oldFirst)
			{
				InternalEObject newFirst = (InternalEObject)first;
				NotificationChain msgs = oldFirst.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.COLLECTION_RANGE__FIRST, null, null);
				if (newFirst.eInternalContainer() == null)
				{
					msgs = newFirst.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.COLLECTION_RANGE__FIRST, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.COLLECTION_RANGE__FIRST, oldFirst, first));
			}
		}
		return first;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression basicGetFirst() {
		return first;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFirst(OclExpression newFirst,
			NotificationChain msgs) {
		OclExpression oldFirst = first;
		first = newFirst;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.COLLECTION_RANGE__FIRST, oldFirst, newFirst);
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
		if (newFirst != first)
		{
			NotificationChain msgs = null;
			if (first != null)
				msgs = ((InternalEObject)first).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.COLLECTION_RANGE__FIRST, null, msgs);
			if (newFirst != null)
				msgs = ((InternalEObject)newFirst).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.COLLECTION_RANGE__FIRST, null, msgs);
			msgs = basicSetFirst(newFirst, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.COLLECTION_RANGE__FIRST, newFirst, newFirst));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression createFirst(EClass eClass) {
		OclExpression newFirst = (OclExpression) create(eClass);
		setFirst(newFirst);
		return newFirst;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression createFirst() {
		return createFirst(PivotPackage.Literals.OCL_EXPRESSION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression getLast() {
		if (last != null && ((EObject)last).eIsProxy())
		{
			InternalEObject oldLast = (InternalEObject)last;
			last = (OclExpression)eResolveProxy(oldLast);
			if (last != oldLast)
			{
				InternalEObject newLast = (InternalEObject)last;
				NotificationChain msgs = oldLast.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.COLLECTION_RANGE__LAST, null, null);
				if (newLast.eInternalContainer() == null)
				{
					msgs = newLast.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.COLLECTION_RANGE__LAST, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.COLLECTION_RANGE__LAST, oldLast, last));
			}
		}
		return last;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression basicGetLast() {
		return last;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLast(OclExpression newLast,
			NotificationChain msgs) {
		OclExpression oldLast = last;
		last = newLast;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.COLLECTION_RANGE__LAST, oldLast, newLast);
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
		if (newLast != last)
		{
			NotificationChain msgs = null;
			if (last != null)
				msgs = ((InternalEObject)last).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.COLLECTION_RANGE__LAST, null, msgs);
			if (newLast != null)
				msgs = ((InternalEObject)newLast).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.COLLECTION_RANGE__LAST, null, msgs);
			msgs = basicSetLast(newLast, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.COLLECTION_RANGE__LAST, newLast, newLast));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression createLast(EClass eClass) {
		OclExpression newLast = (OclExpression) create(eClass);
		setLast(newLast);
		return newLast;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression createLast() {
		return createLast(PivotPackage.Literals.OCL_EXPRESSION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case PivotPackage.COLLECTION_RANGE__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.COLLECTION_RANGE__OWNED_RULE:
				return ((InternalEList<?>)getOwnedRules()).basicRemove(otherEnd, msgs);
			case PivotPackage.COLLECTION_RANGE__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotations()).basicRemove(otherEnd, msgs);
			case PivotPackage.COLLECTION_RANGE__FIRST:
				return basicSetFirst(null, msgs);
			case PivotPackage.COLLECTION_RANGE__LAST:
				return basicSetLast(null, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
			case PivotPackage.COLLECTION_RANGE__OWNED_COMMENT:
				return getOwnedComments();
			case PivotPackage.COLLECTION_RANGE__MONIKER:
				return getMoniker();
			case PivotPackage.COLLECTION_RANGE__NAME:
				return getName();
			case PivotPackage.COLLECTION_RANGE__OWNED_RULE:
				return getOwnedRules();
			case PivotPackage.COLLECTION_RANGE__IS_STATIC:
				return isStatic();
			case PivotPackage.COLLECTION_RANGE__OWNED_ANNOTATION:
				return getOwnedAnnotations();
			case PivotPackage.COLLECTION_RANGE__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.COLLECTION_RANGE__FIRST:
				if (resolve) return getFirst();
				return basicGetFirst();
			case PivotPackage.COLLECTION_RANGE__LAST:
				if (resolve) return getLast();
				return basicGetLast();
		}
		return eDynamicGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
			case PivotPackage.COLLECTION_RANGE__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.COLLECTION_RANGE__MONIKER:
				setMoniker((String)newValue);
				return;
			case PivotPackage.COLLECTION_RANGE__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.COLLECTION_RANGE__OWNED_RULE:
				getOwnedRules().clear();
				getOwnedRules().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.COLLECTION_RANGE__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.COLLECTION_RANGE__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case PivotPackage.COLLECTION_RANGE__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.COLLECTION_RANGE__FIRST:
				setFirst((OclExpression)newValue);
				return;
			case PivotPackage.COLLECTION_RANGE__LAST:
				setLast((OclExpression)newValue);
				return;
		}
		eDynamicSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID)
		{
			case PivotPackage.COLLECTION_RANGE__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case PivotPackage.COLLECTION_RANGE__MONIKER:
				setMoniker(MONIKER_EDEFAULT);
				return;
			case PivotPackage.COLLECTION_RANGE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.COLLECTION_RANGE__OWNED_RULE:
				getOwnedRules().clear();
				return;
			case PivotPackage.COLLECTION_RANGE__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.COLLECTION_RANGE__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.COLLECTION_RANGE__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.COLLECTION_RANGE__FIRST:
				setFirst((OclExpression)null);
				return;
			case PivotPackage.COLLECTION_RANGE__LAST:
				setLast((OclExpression)null);
				return;
		}
		eDynamicUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
			case PivotPackage.COLLECTION_RANGE__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.COLLECTION_RANGE__MONIKER:
				return MONIKER_EDEFAULT == null ? getMoniker() != null : !MONIKER_EDEFAULT.equals(getMoniker());
			case PivotPackage.COLLECTION_RANGE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.COLLECTION_RANGE__OWNED_RULE:
				return ownedRules != null && !ownedRules.isEmpty();
			case PivotPackage.COLLECTION_RANGE__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.COLLECTION_RANGE__OWNED_ANNOTATION:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.COLLECTION_RANGE__TYPE:
				return type != null;
			case PivotPackage.COLLECTION_RANGE__FIRST:
				return first != null;
			case PivotPackage.COLLECTION_RANGE__LAST:
				return last != null;
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R, C> R accept(Visitor<R, C> visitor) {
		return visitor.visitCollectionRange(this);
	}
} //CollectionRangeImpl
