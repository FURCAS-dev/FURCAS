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
 * $Id: PropertyCallExpImpl.java,v 1.2 2011/01/24 20:42:32 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyCallExpImpl#getReferredProperty <em>Referred Property</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyCallExpImpl
		extends NavigationCallExpImpl
		implements PropertyCallExp {

	/**
	 * The cached value of the '{@link #getReferredProperty() <em>Referred Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredProperty()
	 * @generated
	 * @ordered
	 */
	protected Property referredProperty;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyCallExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.PROPERTY_CALL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getReferredProperty() {
		if (referredProperty != null && ((EObject)referredProperty).eIsProxy())
		{
			InternalEObject oldReferredProperty = (InternalEObject)referredProperty;
			referredProperty = (Property)eResolveProxy(oldReferredProperty);
			if (referredProperty != oldReferredProperty)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY, oldReferredProperty, referredProperty));
			}
		}
		return referredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetReferredProperty() {
		return referredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredProperty(Property newReferredProperty) {
		Property oldReferredProperty = referredProperty;
		referredProperty = newReferredProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY, oldReferredProperty, referredProperty));
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
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_COMMENT:
				return getOwnedComments();
			case PivotPackage.PROPERTY_CALL_EXP__MONIKER:
				return getMoniker();
			case PivotPackage.PROPERTY_CALL_EXP__NAME:
				return getName();
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_RULE:
				return getOwnedRules();
			case PivotPackage.PROPERTY_CALL_EXP__IS_STATIC:
				return isStatic();
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_ANNOTATION:
				return getOwnedAnnotations();
			case PivotPackage.PROPERTY_CALL_EXP__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.PROPERTY_CALL_EXP__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case PivotPackage.PROPERTY_CALL_EXP__IMPLICIT:
				return isImplicit();
			case PivotPackage.PROPERTY_CALL_EXP__REFERRED_FEATURE:
				return getReferredFeature();
			case PivotPackage.PROPERTY_CALL_EXP__IS_PRE:
				return isPre();
			case PivotPackage.PROPERTY_CALL_EXP__QUALIFIER:
				return getQualifiers();
			case PivotPackage.PROPERTY_CALL_EXP__NAVIGATION_SOURCE:
				if (resolve) return getNavigationSource();
				return basicGetNavigationSource();
			case PivotPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY:
				if (resolve) return getReferredProperty();
				return basicGetReferredProperty();
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
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__MONIKER:
				setMoniker((String)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_RULE:
				getOwnedRules().clear();
				getOwnedRules().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__SOURCE:
				setSource((OclExpression)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__IMPLICIT:
				setImplicit((Boolean)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__IS_PRE:
				setIsPre((Boolean)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__QUALIFIER:
				getQualifiers().clear();
				getQualifiers().addAll((Collection<? extends OclExpression>)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__NAVIGATION_SOURCE:
				setNavigationSource((Property)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY:
				setReferredProperty((Property)newValue);
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
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case PivotPackage.PROPERTY_CALL_EXP__MONIKER:
				setMoniker(MONIKER_EDEFAULT);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_RULE:
				getOwnedRules().clear();
				return;
			case PivotPackage.PROPERTY_CALL_EXP__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.PROPERTY_CALL_EXP__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__SOURCE:
				setSource((OclExpression)null);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__IMPLICIT:
				setImplicit(IMPLICIT_EDEFAULT);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__IS_PRE:
				setIsPre(IS_PRE_EDEFAULT);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__QUALIFIER:
				getQualifiers().clear();
				return;
			case PivotPackage.PROPERTY_CALL_EXP__NAVIGATION_SOURCE:
				setNavigationSource((Property)null);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY:
				setReferredProperty((Property)null);
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
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.PROPERTY_CALL_EXP__MONIKER:
				return MONIKER_EDEFAULT == null ? getMoniker() != null : !MONIKER_EDEFAULT.equals(getMoniker());
			case PivotPackage.PROPERTY_CALL_EXP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_RULE:
				return ownedRules != null && !ownedRules.isEmpty();
			case PivotPackage.PROPERTY_CALL_EXP__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_ANNOTATION:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.PROPERTY_CALL_EXP__TYPE:
				return type != null;
			case PivotPackage.PROPERTY_CALL_EXP__SOURCE:
				return source != null;
			case PivotPackage.PROPERTY_CALL_EXP__IMPLICIT:
				return ((eFlags & IMPLICIT_EFLAG) != 0) != IMPLICIT_EDEFAULT;
			case PivotPackage.PROPERTY_CALL_EXP__REFERRED_FEATURE:
				return getReferredFeature() != null;
			case PivotPackage.PROPERTY_CALL_EXP__IS_PRE:
				return ((eFlags & IS_PRE_EFLAG) != 0) != IS_PRE_EDEFAULT;
			case PivotPackage.PROPERTY_CALL_EXP__QUALIFIER:
				return qualifiers != null && !qualifiers.isEmpty();
			case PivotPackage.PROPERTY_CALL_EXP__NAVIGATION_SOURCE:
				return navigationSource != null;
			case PivotPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY:
				return referredProperty != null;
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R, C> R accept(Visitor<R, C> visitor) {
		return visitor.visitPropertyCallExp(this);
	}

	@Override
	public Feature getReferredFeature()
	{
		return getReferredProperty();
	}
} //PropertyCallExpImpl
