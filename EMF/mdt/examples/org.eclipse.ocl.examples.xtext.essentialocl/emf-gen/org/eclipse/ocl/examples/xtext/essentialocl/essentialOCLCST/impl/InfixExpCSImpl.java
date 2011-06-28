/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: InfixExpCSImpl.java,v 1.3 2011/01/24 21:31:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BinaryOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InfixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.util.EssentialOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Expression CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.InfixExpCSImpl#getOwnedExpression <em>Owned Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.InfixExpCSImpl#getOwnedOperator <em>Owned Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InfixExpCSImpl extends ExpCSImpl implements InfixExpCS {
	/**
	 * The cached value of the '{@link #getOwnedExpression() <em>Owned Expression</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedExpression()
	 * @generated
	 * @ordered
	 */
	protected EList<ExpCS> ownedExpression;
	/**
	 * The cached value of the '{@link #getOwnedOperator() <em>Owned Operator</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedOperator()
	 * @generated
	 * @ordered
	 */
	protected EList<BinaryOperatorCS> ownedOperator;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InfixExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EssentialOCLCSTPackage.Literals.INFIX_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExpCS> getOwnedExpression()
	{
		if (ownedExpression == null)
		{
			ownedExpression = new EObjectContainmentEList<ExpCS>(ExpCS.class, this, EssentialOCLCSTPackage.INFIX_EXP_CS__OWNED_EXPRESSION);
		}
		return ownedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BinaryOperatorCS> getOwnedOperator()
	{
		if (ownedOperator == null)
		{
			ownedOperator = new EObjectContainmentEList<BinaryOperatorCS>(BinaryOperatorCS.class, this, EssentialOCLCSTPackage.INFIX_EXP_CS__OWNED_OPERATOR);
		}
		return ownedOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case EssentialOCLCSTPackage.INFIX_EXP_CS__OWNED_EXPRESSION:
				return ((InternalEList<?>)getOwnedExpression()).basicRemove(otherEnd, msgs);
			case EssentialOCLCSTPackage.INFIX_EXP_CS__OWNED_OPERATOR:
				return ((InternalEList<?>)getOwnedOperator()).basicRemove(otherEnd, msgs);
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
		switch (featureID)
		{
			case EssentialOCLCSTPackage.INFIX_EXP_CS__OWNED_EXPRESSION:
				return getOwnedExpression();
			case EssentialOCLCSTPackage.INFIX_EXP_CS__OWNED_OPERATOR:
				return getOwnedOperator();
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
		switch (featureID)
		{
			case EssentialOCLCSTPackage.INFIX_EXP_CS__OWNED_EXPRESSION:
				getOwnedExpression().clear();
				getOwnedExpression().addAll((Collection<? extends ExpCS>)newValue);
				return;
			case EssentialOCLCSTPackage.INFIX_EXP_CS__OWNED_OPERATOR:
				getOwnedOperator().clear();
				getOwnedOperator().addAll((Collection<? extends BinaryOperatorCS>)newValue);
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
		switch (featureID)
		{
			case EssentialOCLCSTPackage.INFIX_EXP_CS__OWNED_EXPRESSION:
				getOwnedExpression().clear();
				return;
			case EssentialOCLCSTPackage.INFIX_EXP_CS__OWNED_OPERATOR:
				getOwnedOperator().clear();
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
		switch (featureID)
		{
			case EssentialOCLCSTPackage.INFIX_EXP_CS__OWNED_EXPRESSION:
				return ownedExpression != null && !ownedExpression.isEmpty();
			case EssentialOCLCSTPackage.INFIX_EXP_CS__OWNED_OPERATOR:
				return ownedOperator != null && !ownedOperator.isEmpty();
		}
		return super.eIsSet(featureID);
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

	@SuppressWarnings("unchecked")
	@Override
	public <R, C> R accept(BaseCSVisitor<R, C> visitor) {
		return (R) visitor.getAdapter(EssentialOCLCSVisitor.class).visitInfixExpCS(this);
	}
} //BinaryExpressionCSImpl
