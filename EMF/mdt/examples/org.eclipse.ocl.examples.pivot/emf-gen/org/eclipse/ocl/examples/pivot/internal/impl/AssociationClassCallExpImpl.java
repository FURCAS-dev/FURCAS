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
 * $Id: AssociationClassCallExpImpl.java,v 1.2 2011/01/24 20:42:32 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.AssociationClass;
import org.eclipse.ocl.examples.pivot.AssociationClassCallExp;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association Class Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.AssociationClassCallExpImpl#getReferredAssociationClass <em>Referred Association Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssociationClassCallExpImpl
		extends NavigationCallExpImpl
		implements AssociationClassCallExp {

	/**
	 * The cached value of the '{@link #getReferredAssociationClass() <em>Referred Association Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredAssociationClass()
	 * @generated
	 * @ordered
	 */
	protected AssociationClass referredAssociationClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssociationClassCallExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.ASSOCIATION_CLASS_CALL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationClass getReferredAssociationClass() {
		if (referredAssociationClass != null && ((EObject)referredAssociationClass).eIsProxy())
		{
			InternalEObject oldReferredAssociationClass = (InternalEObject)referredAssociationClass;
			referredAssociationClass = (AssociationClass)eResolveProxy(oldReferredAssociationClass);
			if (referredAssociationClass != oldReferredAssociationClass)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.ASSOCIATION_CLASS_CALL_EXP__REFERRED_ASSOCIATION_CLASS, oldReferredAssociationClass, referredAssociationClass));
			}
		}
		return referredAssociationClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationClass basicGetReferredAssociationClass() {
		return referredAssociationClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredAssociationClass(
			AssociationClass newReferredAssociationClass) {
		AssociationClass oldReferredAssociationClass = referredAssociationClass;
		referredAssociationClass = newReferredAssociationClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.ASSOCIATION_CLASS_CALL_EXP__REFERRED_ASSOCIATION_CLASS, oldReferredAssociationClass, referredAssociationClass));
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
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__OWNED_COMMENT:
				return getOwnedComments();
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__MONIKER:
				return getMoniker();
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__NAME:
				return getName();
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__OWNED_RULE:
				return getOwnedRules();
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__IS_STATIC:
				return isStatic();
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__OWNED_ANNOTATION:
				return getOwnedAnnotations();
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__IMPLICIT:
				return isImplicit();
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__REFERRED_FEATURE:
				return getReferredFeature();
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__IS_PRE:
				return isPre();
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__QUALIFIER:
				return getQualifiers();
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__NAVIGATION_SOURCE:
				if (resolve) return getNavigationSource();
				return basicGetNavigationSource();
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__REFERRED_ASSOCIATION_CLASS:
				if (resolve) return getReferredAssociationClass();
				return basicGetReferredAssociationClass();
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
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__MONIKER:
				setMoniker((String)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__OWNED_RULE:
				getOwnedRules().clear();
				getOwnedRules().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__SOURCE:
				setSource((OclExpression)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__IMPLICIT:
				setImplicit((Boolean)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__IS_PRE:
				setIsPre((Boolean)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__QUALIFIER:
				getQualifiers().clear();
				getQualifiers().addAll((Collection<? extends OclExpression>)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__NAVIGATION_SOURCE:
				setNavigationSource((Property)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__REFERRED_ASSOCIATION_CLASS:
				setReferredAssociationClass((AssociationClass)newValue);
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
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__MONIKER:
				setMoniker(MONIKER_EDEFAULT);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__OWNED_RULE:
				getOwnedRules().clear();
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__SOURCE:
				setSource((OclExpression)null);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__IMPLICIT:
				setImplicit(IMPLICIT_EDEFAULT);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__IS_PRE:
				setIsPre(IS_PRE_EDEFAULT);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__QUALIFIER:
				getQualifiers().clear();
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__NAVIGATION_SOURCE:
				setNavigationSource((Property)null);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__REFERRED_ASSOCIATION_CLASS:
				setReferredAssociationClass((AssociationClass)null);
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
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__MONIKER:
				return MONIKER_EDEFAULT == null ? getMoniker() != null : !MONIKER_EDEFAULT.equals(getMoniker());
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__OWNED_RULE:
				return ownedRules != null && !ownedRules.isEmpty();
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__OWNED_ANNOTATION:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__TYPE:
				return type != null;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__SOURCE:
				return source != null;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__IMPLICIT:
				return ((eFlags & IMPLICIT_EFLAG) != 0) != IMPLICIT_EDEFAULT;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__REFERRED_FEATURE:
				return getReferredFeature() != null;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__IS_PRE:
				return ((eFlags & IS_PRE_EFLAG) != 0) != IS_PRE_EDEFAULT;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__QUALIFIER:
				return qualifiers != null && !qualifiers.isEmpty();
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__NAVIGATION_SOURCE:
				return navigationSource != null;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__REFERRED_ASSOCIATION_CLASS:
				return referredAssociationClass != null;
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R, C> R accept(Visitor<R, C> visitor) {
		return visitor.visitAssociationClassCallExp(this);
	}

	@Override
	public Feature getReferredFeature()
	{
		throw new UnsupportedOperationException();		// FIXME
	}
} //AssociationClassCallExpImpl
