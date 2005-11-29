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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.ocl.expressions.AssociationEndCallExp;
import org.eclipse.emf.ocl.expressions.ExpressionsPackage;
import org.eclipse.emf.ocl.expressions.OclExpression;
import org.eclipse.emf.ocl.expressions.OperationCallExp;
import org.eclipse.emf.ocl.expressions.PropertyCallExp;
import org.eclipse.emf.ocl.expressions.VariableDeclaration;
import org.eclipse.emf.ocl.expressions.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association End Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.expressions.internal.impl.AssociationEndCallExpImpl#getReferredAssociationEnd <em>Referred Association End</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssociationEndCallExpImpl extends NavigationCallExpImpl implements AssociationEndCallExp {
	/**
	 * The cached value of the '{@link #getReferredAssociationEnd() <em>Referred Association End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredAssociationEnd()
	 * @generated
	 * @ordered
	 */
	protected EReference referredAssociationEnd = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssociationEndCallExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ExpressionsPackage.eINSTANCE.getAssociationEndCallExp();
	}

	/**
	 * Accept a visitor
	 * @param v the visitor to accept
	 */
	public Object accept(Visitor v) {
		return v.visitAssociationEndCallExp(this);
	}
		

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferredAssociationEnd() {
		if (referredAssociationEnd != null && referredAssociationEnd.eIsProxy()) {
			EReference oldReferredAssociationEnd = referredAssociationEnd;
			referredAssociationEnd = (EReference)eResolveProxy((InternalEObject)referredAssociationEnd);
			if (referredAssociationEnd != oldReferredAssociationEnd) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.ASSOCIATION_END_CALL_EXP__REFERRED_ASSOCIATION_END, oldReferredAssociationEnd, referredAssociationEnd));
			}
		}
		return referredAssociationEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetReferredAssociationEnd() {
		return referredAssociationEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredAssociationEnd(EReference newReferredAssociationEnd) {
		EReference oldReferredAssociationEnd = referredAssociationEnd;
		referredAssociationEnd = newReferredAssociationEnd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.ASSOCIATION_END_CALL_EXP__REFERRED_ASSOCIATION_END, oldReferredAssociationEnd, referredAssociationEnd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicAdd(otherEnd, msgs);
				case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__APPLIED_PROPERTY:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, ExpressionsPackage.ASSOCIATION_END_CALL_EXP__APPLIED_PROPERTY, msgs);
				case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__INITIALIZED_VARIABLE:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, ExpressionsPackage.ASSOCIATION_END_CALL_EXP__INITIALIZED_VARIABLE, msgs);
				case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__PARENT_OPERATION:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, ExpressionsPackage.ASSOCIATION_END_CALL_EXP__PARENT_OPERATION, msgs);
				case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__SOURCE:
					if (source != null)
						msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.ASSOCIATION_END_CALL_EXP__SOURCE, null, msgs);
					return basicSetSource((OclExpression)otherEnd, msgs);
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
				case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
				case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__APPLIED_PROPERTY:
					return eBasicSetContainer(null, ExpressionsPackage.ASSOCIATION_END_CALL_EXP__APPLIED_PROPERTY, msgs);
				case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__INITIALIZED_VARIABLE:
					return eBasicSetContainer(null, ExpressionsPackage.ASSOCIATION_END_CALL_EXP__INITIALIZED_VARIABLE, msgs);
				case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__PARENT_OPERATION:
					return eBasicSetContainer(null, ExpressionsPackage.ASSOCIATION_END_CALL_EXP__PARENT_OPERATION, msgs);
				case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__SOURCE:
					return basicSetSource(null, msgs);
				case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__QUALIFIERS:
					return ((InternalEList)getQualifiers()).basicRemove(otherEnd, msgs);
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
				case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__APPLIED_PROPERTY:
					return eContainer.eInverseRemove(this, ExpressionsPackage.PROPERTY_CALL_EXP__SOURCE, PropertyCallExp.class, msgs);
				case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__INITIALIZED_VARIABLE:
					return eContainer.eInverseRemove(this, ExpressionsPackage.VARIABLE_DECLARATION__INIT_EXPRESSION, VariableDeclaration.class, msgs);
				case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__PARENT_OPERATION:
					return eContainer.eInverseRemove(this, ExpressionsPackage.OPERATION_CALL_EXP__ARGUMENTS, OperationCallExp.class, msgs);
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
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__EANNOTATIONS:
				return getEAnnotations();
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__NAME:
				return getName();
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__START_POSITION:
				return new Integer(getStartPosition());
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__END_POSITION:
				return new Integer(getEndPosition());
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__APPLIED_PROPERTY:
				return getAppliedProperty();
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__INITIALIZED_VARIABLE:
				return getInitializedVariable();
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__PARENT_OPERATION:
				return getParentOperation();
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__PROPERTY_START_POSITION:
				return new Integer(getPropertyStartPosition());
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__PROPERTY_END_POSITION:
				return new Integer(getPropertyEndPosition());
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__SOURCE:
				return getSource();
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__MARKED_PRE:
				return isMarkedPre() ? Boolean.TRUE : Boolean.FALSE;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__QUALIFIERS:
				return getQualifiers();
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__NAVIGATION_SOURCE:
				if (resolve) return getNavigationSource();
				return basicGetNavigationSource();
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__REFERRED_ASSOCIATION_END:
				if (resolve) return getReferredAssociationEnd();
				return basicGetReferredAssociationEnd();
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
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__NAME:
				setName((String)newValue);
				return;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__START_POSITION:
				setStartPosition(((Integer)newValue).intValue());
				return;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__END_POSITION:
				setEndPosition(((Integer)newValue).intValue());
				return;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__APPLIED_PROPERTY:
				setAppliedProperty((PropertyCallExp)newValue);
				return;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__INITIALIZED_VARIABLE:
				setInitializedVariable((VariableDeclaration)newValue);
				return;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__PARENT_OPERATION:
				setParentOperation((OperationCallExp)newValue);
				return;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__TYPE:
				setType((EClassifier)newValue);
				return;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__PROPERTY_START_POSITION:
				setPropertyStartPosition(((Integer)newValue).intValue());
				return;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__PROPERTY_END_POSITION:
				setPropertyEndPosition(((Integer)newValue).intValue());
				return;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__SOURCE:
				setSource((OclExpression)newValue);
				return;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__MARKED_PRE:
				setMarkedPre(((Boolean)newValue).booleanValue());
				return;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__QUALIFIERS:
				getQualifiers().clear();
				getQualifiers().addAll((Collection)newValue);
				return;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__NAVIGATION_SOURCE:
				setNavigationSource((EReference)newValue);
				return;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__REFERRED_ASSOCIATION_END:
				setReferredAssociationEnd((EReference)newValue);
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
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__START_POSITION:
				setStartPosition(START_POSITION_EDEFAULT);
				return;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__END_POSITION:
				setEndPosition(END_POSITION_EDEFAULT);
				return;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__APPLIED_PROPERTY:
				setAppliedProperty((PropertyCallExp)null);
				return;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__INITIALIZED_VARIABLE:
				setInitializedVariable((VariableDeclaration)null);
				return;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__PARENT_OPERATION:
				setParentOperation((OperationCallExp)null);
				return;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__TYPE:
				setType((EClassifier)null);
				return;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__PROPERTY_START_POSITION:
				setPropertyStartPosition(PROPERTY_START_POSITION_EDEFAULT);
				return;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__PROPERTY_END_POSITION:
				setPropertyEndPosition(PROPERTY_END_POSITION_EDEFAULT);
				return;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__SOURCE:
				setSource((OclExpression)null);
				return;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__MARKED_PRE:
				setMarkedPre(MARKED_PRE_EDEFAULT);
				return;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__QUALIFIERS:
				getQualifiers().clear();
				return;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__NAVIGATION_SOURCE:
				setNavigationSource((EReference)null);
				return;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__REFERRED_ASSOCIATION_END:
				setReferredAssociationEnd((EReference)null);
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
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__START_POSITION:
				return startPosition != START_POSITION_EDEFAULT;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__END_POSITION:
				return endPosition != END_POSITION_EDEFAULT;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__APPLIED_PROPERTY:
				return getAppliedProperty() != null;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__INITIALIZED_VARIABLE:
				return getInitializedVariable() != null;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__PARENT_OPERATION:
				return getParentOperation() != null;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__TYPE:
				return type != null;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__PROPERTY_START_POSITION:
				return propertyStartPosition != PROPERTY_START_POSITION_EDEFAULT;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__PROPERTY_END_POSITION:
				return propertyEndPosition != PROPERTY_END_POSITION_EDEFAULT;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__SOURCE:
				return source != null;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__MARKED_PRE:
				return ((eFlags & MARKED_PRE_EFLAG) != 0) != MARKED_PRE_EDEFAULT;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__QUALIFIERS:
				return qualifiers != null && !qualifiers.isEmpty();
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__NAVIGATION_SOURCE:
				return navigationSource != null;
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__REFERRED_ASSOCIATION_END:
				return referredAssociationEnd != null;
		}
		return eDynamicIsSet(eFeature);
	}

	/**
	 * @generated NOT
	 */
	public String toString() {
		return ToStringVisitorImpl.toString(this);
	}

} //AssociationEndCallExpImpl
