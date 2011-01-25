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
 * $Id: TypedMultiplicityElementImpl.java,v 1.2 2011/01/24 20:42:33 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.MultiplicityElement;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedMultiplicityElement;
import org.eclipse.ocl.examples.pivot.internal.operations.MultiplicityElementOperations;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Typed Multiplicity Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.TypedMultiplicityElementImpl#isOrdered <em>Is Ordered</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.TypedMultiplicityElementImpl#isUnique <em>Is Unique</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.TypedMultiplicityElementImpl#getLower <em>Lower</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.TypedMultiplicityElementImpl#getUpper <em>Upper</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TypedMultiplicityElementImpl
		extends TypedElementImpl
		implements TypedMultiplicityElement {

	/**
	 * The default value of the '{@link #isOrdered() <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOrdered()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ORDERED_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isOrdered() <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOrdered()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_ORDERED_EFLAG = 1 << 9;

	/**
	 * The default value of the '{@link #isUnique() <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnique()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_UNIQUE_EDEFAULT = true;

	/**
	 * The flag representing the value of the '{@link #isUnique() <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnique()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_UNIQUE_EFLAG = 1 << 10;

	/**
	 * The default value of the '{@link #getLower() <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLower()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger LOWER_EDEFAULT = new BigInteger("1"); //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getLower() <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLower()
	 * @generated
	 * @ordered
	 */
	protected BigInteger lower = LOWER_EDEFAULT;

	/**
	 * The default value of the '{@link #getUpper() <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpper()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger UPPER_EDEFAULT = new BigInteger("1"); //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getUpper() <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpper()
	 * @generated
	 * @ordered
	 */
	protected BigInteger upper = UPPER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypedMultiplicityElementImpl() {
		super();
		eFlags |= IS_UNIQUE_EFLAG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.TYPED_MULTIPLICITY_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOrdered() {
		return (eFlags & IS_ORDERED_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsOrdered(boolean newIsOrdered) {
		boolean oldIsOrdered = (eFlags & IS_ORDERED_EFLAG) != 0;
		if (newIsOrdered) eFlags |= IS_ORDERED_EFLAG; else eFlags &= ~IS_ORDERED_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.TYPED_MULTIPLICITY_ELEMENT__IS_ORDERED, oldIsOrdered, newIsOrdered));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUnique() {
		return (eFlags & IS_UNIQUE_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsUnique(boolean newIsUnique) {
		boolean oldIsUnique = (eFlags & IS_UNIQUE_EFLAG) != 0;
		if (newIsUnique) eFlags |= IS_UNIQUE_EFLAG; else eFlags &= ~IS_UNIQUE_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.TYPED_MULTIPLICITY_ELEMENT__IS_UNIQUE, oldIsUnique, newIsUnique));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getLower() {
		return lower;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLower(BigInteger newLower) {
		BigInteger oldLower = lower;
		lower = newLower;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.TYPED_MULTIPLICITY_ELEMENT__LOWER, oldLower, lower));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getUpper() {
		return upper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpper(BigInteger newUpper) {
		BigInteger oldUpper = upper;
		upper = newUpper;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.TYPED_MULTIPLICITY_ELEMENT__UPPER, oldUpper, upper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLowerGe0(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return MultiplicityElementOperations.validateLowerGe0(this, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUpperGeLower(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return MultiplicityElementOperations.validateUpperGeLower(this, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger lowerBound() {
		return MultiplicityElementOperations.lowerBound(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger upperBound() {
		return MultiplicityElementOperations.upperBound(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMultivalued() {
		return MultiplicityElementOperations.isMultivalued(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean includesCardinality(BigInteger C) {
		return MultiplicityElementOperations.includesCardinality(this, C);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean includesMultiplicity(MultiplicityElement M) {
		return MultiplicityElementOperations.includesMultiplicity(this, M);
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
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__OWNED_COMMENT:
				return getOwnedComments();
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__MONIKER:
				return getMoniker();
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__NAME:
				return getName();
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__OWNED_RULE:
				return getOwnedRules();
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__IS_STATIC:
				return isStatic();
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__OWNED_ANNOTATION:
				return getOwnedAnnotations();
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__IS_ORDERED:
				return isOrdered();
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__IS_UNIQUE:
				return isUnique();
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__LOWER:
				return getLower();
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__UPPER:
				return getUpper();
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
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__MONIKER:
				setMoniker((String)newValue);
				return;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__OWNED_RULE:
				getOwnedRules().clear();
				getOwnedRules().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__IS_ORDERED:
				setIsOrdered((Boolean)newValue);
				return;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__IS_UNIQUE:
				setIsUnique((Boolean)newValue);
				return;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__LOWER:
				setLower((BigInteger)newValue);
				return;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__UPPER:
				setUpper((BigInteger)newValue);
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
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__MONIKER:
				setMoniker(MONIKER_EDEFAULT);
				return;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__OWNED_RULE:
				getOwnedRules().clear();
				return;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__IS_ORDERED:
				setIsOrdered(IS_ORDERED_EDEFAULT);
				return;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__IS_UNIQUE:
				setIsUnique(IS_UNIQUE_EDEFAULT);
				return;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__LOWER:
				setLower(LOWER_EDEFAULT);
				return;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__UPPER:
				setUpper(UPPER_EDEFAULT);
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
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__MONIKER:
				return MONIKER_EDEFAULT == null ? getMoniker() != null : !MONIKER_EDEFAULT.equals(getMoniker());
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__OWNED_RULE:
				return ownedRules != null && !ownedRules.isEmpty();
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__OWNED_ANNOTATION:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__TYPE:
				return type != null;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__IS_ORDERED:
				return ((eFlags & IS_ORDERED_EFLAG) != 0) != IS_ORDERED_EDEFAULT;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__IS_UNIQUE:
				return ((eFlags & IS_UNIQUE_EFLAG) != 0) != IS_UNIQUE_EDEFAULT;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__LOWER:
				return LOWER_EDEFAULT == null ? lower != null : !LOWER_EDEFAULT.equals(lower);
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__UPPER:
				return UPPER_EDEFAULT == null ? upper != null : !UPPER_EDEFAULT.equals(upper);
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == MultiplicityElement.class)
		{
			switch (derivedFeatureID)
			{
				case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__IS_ORDERED: return PivotPackage.MULTIPLICITY_ELEMENT__IS_ORDERED;
				case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__IS_UNIQUE: return PivotPackage.MULTIPLICITY_ELEMENT__IS_UNIQUE;
				case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__LOWER: return PivotPackage.MULTIPLICITY_ELEMENT__LOWER;
				case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__UPPER: return PivotPackage.MULTIPLICITY_ELEMENT__UPPER;
				default: return -1;
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
		if (baseClass == MultiplicityElement.class)
		{
			switch (baseFeatureID)
			{
				case PivotPackage.MULTIPLICITY_ELEMENT__IS_ORDERED: return PivotPackage.TYPED_MULTIPLICITY_ELEMENT__IS_ORDERED;
				case PivotPackage.MULTIPLICITY_ELEMENT__IS_UNIQUE: return PivotPackage.TYPED_MULTIPLICITY_ELEMENT__IS_UNIQUE;
				case PivotPackage.MULTIPLICITY_ELEMENT__LOWER: return PivotPackage.TYPED_MULTIPLICITY_ELEMENT__LOWER;
				case PivotPackage.MULTIPLICITY_ELEMENT__UPPER: return PivotPackage.TYPED_MULTIPLICITY_ELEMENT__UPPER;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == MultiplicityElement.class)
		{
			switch (baseOperationID)
			{
				case PivotPackage.MULTIPLICITY_ELEMENT___VALIDATE_LOWER_GE0__DIAGNOSTICCHAIN_MAP: return PivotPackage.TYPED_MULTIPLICITY_ELEMENT___VALIDATE_LOWER_GE0__DIAGNOSTICCHAIN_MAP;
				case PivotPackage.MULTIPLICITY_ELEMENT___VALIDATE_UPPER_GE_LOWER__DIAGNOSTICCHAIN_MAP: return PivotPackage.TYPED_MULTIPLICITY_ELEMENT___VALIDATE_UPPER_GE_LOWER__DIAGNOSTICCHAIN_MAP;
				case PivotPackage.MULTIPLICITY_ELEMENT___LOWER_BOUND: return PivotPackage.TYPED_MULTIPLICITY_ELEMENT___LOWER_BOUND;
				case PivotPackage.MULTIPLICITY_ELEMENT___UPPER_BOUND: return PivotPackage.TYPED_MULTIPLICITY_ELEMENT___UPPER_BOUND;
				case PivotPackage.MULTIPLICITY_ELEMENT___IS_MULTIVALUED: return PivotPackage.TYPED_MULTIPLICITY_ELEMENT___IS_MULTIVALUED;
				case PivotPackage.MULTIPLICITY_ELEMENT___INCLUDES_CARDINALITY__BIGINTEGER: return PivotPackage.TYPED_MULTIPLICITY_ELEMENT___INCLUDES_CARDINALITY__BIGINTEGER;
				case PivotPackage.MULTIPLICITY_ELEMENT___INCLUDES_MULTIPLICITY__MULTIPLICITYELEMENT: return PivotPackage.TYPED_MULTIPLICITY_ELEMENT___INCLUDES_MULTIPLICITY__MULTIPLICITYELEMENT;
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments)
			throws InvocationTargetException {
		switch (operationID)
		{
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT___HAS_MONIKER:
				return hasMoniker();
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT___VALIDATE_LOWER_GE0__DIAGNOSTICCHAIN_MAP:
				return validateLowerGe0((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT___VALIDATE_UPPER_GE_LOWER__DIAGNOSTICCHAIN_MAP:
				return validateUpperGeLower((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT___LOWER_BOUND:
				return lowerBound();
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT___UPPER_BOUND:
				return upperBound();
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT___IS_MULTIVALUED:
				return isMultivalued();
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT___INCLUDES_CARDINALITY__BIGINTEGER:
				return includesCardinality((BigInteger)arguments.get(0));
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT___INCLUDES_MULTIPLICITY__MULTIPLICITYELEMENT:
				return includesMultiplicity((MultiplicityElement)arguments.get(0));
		}
		return eDynamicInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public <R, C> R accept(Visitor<R, C> visitor) {
		return visitor.visitTypedMultiplicityElement(this);
	}
} //TypedMultiplicityElementImpl
