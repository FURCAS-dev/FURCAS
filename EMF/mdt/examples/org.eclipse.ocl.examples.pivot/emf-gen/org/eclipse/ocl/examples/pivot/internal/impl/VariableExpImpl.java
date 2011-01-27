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
 * $Id: VariableExpImpl.java,v 1.2 2011/01/24 20:42:33 ewillink Exp $
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
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.VariableExpImpl#getReferredVariable <em>Referred Variable</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.VariableExpImpl#isImplicit <em>Implicit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableExpImpl
		extends OclExpressionImpl
		implements VariableExp {

	/**
	 * The cached value of the '{@link #getReferredVariable() <em>Referred Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredVariable()
	 * @generated
	 * @ordered
	 */
	protected VariableDeclaration referredVariable;

	/**
	 * The default value of the '{@link #isImplicit() <em>Implicit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImplicit()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IMPLICIT_EDEFAULT = false;
	/**
	 * The flag representing the value of the '{@link #isImplicit() <em>Implicit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImplicit()
	 * @generated
	 * @ordered
	 */
	protected static final int IMPLICIT_EFLAG = 1 << 9;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.VARIABLE_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration getReferredVariable() {
		if (referredVariable != null && ((EObject)referredVariable).eIsProxy())
		{
			InternalEObject oldReferredVariable = (InternalEObject)referredVariable;
			referredVariable = (VariableDeclaration)eResolveProxy(oldReferredVariable);
			if (referredVariable != oldReferredVariable)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.VARIABLE_EXP__REFERRED_VARIABLE, oldReferredVariable, referredVariable));
			}
		}
		return referredVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration basicGetReferredVariable() {
		return referredVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredVariable(VariableDeclaration newReferredVariable) {
		VariableDeclaration oldReferredVariable = referredVariable;
		referredVariable = newReferredVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.VARIABLE_EXP__REFERRED_VARIABLE, oldReferredVariable, referredVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isImplicit()
	{
		return (eFlags & IMPLICIT_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplicit(boolean newImplicit)
	{
		boolean oldImplicit = (eFlags & IMPLICIT_EFLAG) != 0;
		if (newImplicit) eFlags |= IMPLICIT_EFLAG; else eFlags &= ~IMPLICIT_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.VARIABLE_EXP__IMPLICIT, oldImplicit, newImplicit));
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
			case PivotPackage.VARIABLE_EXP__OWNED_COMMENT:
				return getOwnedComments();
			case PivotPackage.VARIABLE_EXP__MONIKER:
				return getMoniker();
			case PivotPackage.VARIABLE_EXP__NAME:
				return getName();
			case PivotPackage.VARIABLE_EXP__OWNED_RULE:
				return getOwnedRules();
			case PivotPackage.VARIABLE_EXP__IS_STATIC:
				return isStatic();
			case PivotPackage.VARIABLE_EXP__OWNED_ANNOTATION:
				return getOwnedAnnotations();
			case PivotPackage.VARIABLE_EXP__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.VARIABLE_EXP__REFERRED_VARIABLE:
				if (resolve) return getReferredVariable();
				return basicGetReferredVariable();
			case PivotPackage.VARIABLE_EXP__IMPLICIT:
				return isImplicit();
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
			case PivotPackage.VARIABLE_EXP__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.VARIABLE_EXP__MONIKER:
				setMoniker((String)newValue);
				return;
			case PivotPackage.VARIABLE_EXP__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.VARIABLE_EXP__OWNED_RULE:
				getOwnedRules().clear();
				getOwnedRules().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.VARIABLE_EXP__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.VARIABLE_EXP__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case PivotPackage.VARIABLE_EXP__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.VARIABLE_EXP__REFERRED_VARIABLE:
				setReferredVariable((VariableDeclaration)newValue);
				return;
			case PivotPackage.VARIABLE_EXP__IMPLICIT:
				setImplicit((Boolean)newValue);
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
			case PivotPackage.VARIABLE_EXP__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case PivotPackage.VARIABLE_EXP__MONIKER:
				setMoniker(MONIKER_EDEFAULT);
				return;
			case PivotPackage.VARIABLE_EXP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.VARIABLE_EXP__OWNED_RULE:
				getOwnedRules().clear();
				return;
			case PivotPackage.VARIABLE_EXP__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.VARIABLE_EXP__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.VARIABLE_EXP__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.VARIABLE_EXP__REFERRED_VARIABLE:
				setReferredVariable((VariableDeclaration)null);
				return;
			case PivotPackage.VARIABLE_EXP__IMPLICIT:
				setImplicit(IMPLICIT_EDEFAULT);
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
			case PivotPackage.VARIABLE_EXP__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.VARIABLE_EXP__MONIKER:
				return MONIKER_EDEFAULT == null ? getMoniker() != null : !MONIKER_EDEFAULT.equals(getMoniker());
			case PivotPackage.VARIABLE_EXP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.VARIABLE_EXP__OWNED_RULE:
				return ownedRules != null && !ownedRules.isEmpty();
			case PivotPackage.VARIABLE_EXP__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.VARIABLE_EXP__OWNED_ANNOTATION:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.VARIABLE_EXP__TYPE:
				return type != null;
			case PivotPackage.VARIABLE_EXP__REFERRED_VARIABLE:
				return referredVariable != null;
			case PivotPackage.VARIABLE_EXP__IMPLICIT:
				return ((eFlags & IMPLICIT_EFLAG) != 0) != IMPLICIT_EDEFAULT;
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString()
	{
		return super.toString();
	}

	@Override
	public <R, C> R accept(Visitor<R, C> visitor) {
		return visitor.visitVariableExp(this);
	}

} //VariableExpImpl
