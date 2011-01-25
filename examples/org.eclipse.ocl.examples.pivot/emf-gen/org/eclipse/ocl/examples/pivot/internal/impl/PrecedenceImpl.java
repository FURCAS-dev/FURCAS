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
 * $Id: PrecedenceImpl.java,v 1.2 2011/01/24 20:42:32 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.math.BigInteger;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.AssociativityKind;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Precedence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PrecedenceImpl#getAssociativity <em>Associativity</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PrecedenceImpl#getOrder <em>Order</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrecedenceImpl
		extends NamedElementImpl
		implements Precedence {

	/**
	 * The default value of the '{@link #getAssociativity() <em>Associativity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociativity()
	 * @generated
	 * @ordered
	 */
	protected static final AssociativityKind ASSOCIATIVITY_EDEFAULT = AssociativityKind.LEFT;

	/**
	 * The offset of the flags representing the value of the '{@link #getAssociativity() <em>Associativity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final int ASSOCIATIVITY_EFLAG_OFFSET = 9;

	/**
	 * The flags representing the default value of the '{@link #getAssociativity() <em>Associativity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final int ASSOCIATIVITY_EFLAG_DEFAULT = ASSOCIATIVITY_EDEFAULT.ordinal() << ASSOCIATIVITY_EFLAG_OFFSET;

	/**
	 * The array of enumeration values for '{@link AssociativityKind Associativity Kind}'
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	private static final AssociativityKind[] ASSOCIATIVITY_EFLAG_VALUES = AssociativityKind.values();

	/**
	 * The flag representing the value of the '{@link #getAssociativity() <em>Associativity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociativity()
	 * @generated
	 * @ordered
	 */
	protected static final int ASSOCIATIVITY_EFLAG = 1 << ASSOCIATIVITY_EFLAG_OFFSET;

	/**
	 * The default value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger ORDER_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrecedenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.PRECEDENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociativityKind getAssociativity() {
		return ASSOCIATIVITY_EFLAG_VALUES[(eFlags & ASSOCIATIVITY_EFLAG) >>> ASSOCIATIVITY_EFLAG_OFFSET];
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssociativity(AssociativityKind newAssociativity) {
		AssociativityKind oldAssociativity = ASSOCIATIVITY_EFLAG_VALUES[(eFlags & ASSOCIATIVITY_EFLAG) >>> ASSOCIATIVITY_EFLAG_OFFSET];
		if (newAssociativity == null) newAssociativity = ASSOCIATIVITY_EDEFAULT;
		eFlags = eFlags & ~ASSOCIATIVITY_EFLAG | newAssociativity.ordinal() << ASSOCIATIVITY_EFLAG_OFFSET;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PRECEDENCE__ASSOCIATIVITY, oldAssociativity, newAssociativity));
	}

	private BigInteger order = BigInteger.ZERO; // FIXME a) use int, b) get not volatile to work from UML.

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public BigInteger getOrder() {
		return order;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setOrder(BigInteger newOrder) {
		this.order = newOrder;
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
			case PivotPackage.PRECEDENCE__OWNED_COMMENT:
				return getOwnedComments();
			case PivotPackage.PRECEDENCE__MONIKER:
				return getMoniker();
			case PivotPackage.PRECEDENCE__NAME:
				return getName();
			case PivotPackage.PRECEDENCE__OWNED_RULE:
				return getOwnedRules();
			case PivotPackage.PRECEDENCE__IS_STATIC:
				return isStatic();
			case PivotPackage.PRECEDENCE__OWNED_ANNOTATION:
				return getOwnedAnnotations();
			case PivotPackage.PRECEDENCE__ASSOCIATIVITY:
				return getAssociativity();
			case PivotPackage.PRECEDENCE__ORDER:
				return getOrder();
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
			case PivotPackage.PRECEDENCE__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.PRECEDENCE__MONIKER:
				setMoniker((String)newValue);
				return;
			case PivotPackage.PRECEDENCE__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.PRECEDENCE__OWNED_RULE:
				getOwnedRules().clear();
				getOwnedRules().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.PRECEDENCE__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.PRECEDENCE__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case PivotPackage.PRECEDENCE__ASSOCIATIVITY:
				setAssociativity((AssociativityKind)newValue);
				return;
			case PivotPackage.PRECEDENCE__ORDER:
				setOrder((BigInteger)newValue);
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
			case PivotPackage.PRECEDENCE__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case PivotPackage.PRECEDENCE__MONIKER:
				setMoniker(MONIKER_EDEFAULT);
				return;
			case PivotPackage.PRECEDENCE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.PRECEDENCE__OWNED_RULE:
				getOwnedRules().clear();
				return;
			case PivotPackage.PRECEDENCE__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.PRECEDENCE__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.PRECEDENCE__ASSOCIATIVITY:
				setAssociativity(ASSOCIATIVITY_EDEFAULT);
				return;
			case PivotPackage.PRECEDENCE__ORDER:
				setOrder(ORDER_EDEFAULT);
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
			case PivotPackage.PRECEDENCE__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.PRECEDENCE__MONIKER:
				return MONIKER_EDEFAULT == null ? getMoniker() != null : !MONIKER_EDEFAULT.equals(getMoniker());
			case PivotPackage.PRECEDENCE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.PRECEDENCE__OWNED_RULE:
				return ownedRules != null && !ownedRules.isEmpty();
			case PivotPackage.PRECEDENCE__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.PRECEDENCE__OWNED_ANNOTATION:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.PRECEDENCE__ASSOCIATIVITY:
				return (eFlags & ASSOCIATIVITY_EFLAG) != ASSOCIATIVITY_EFLAG_DEFAULT;
			case PivotPackage.PRECEDENCE__ORDER:
				return ORDER_EDEFAULT == null ? getOrder() != null : !ORDER_EDEFAULT.equals(getOrder());
		}
		return eDynamicIsSet(featureID);
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
		return visitor.visitPrecedence(this);
	}

} //PrecedenceImpl
