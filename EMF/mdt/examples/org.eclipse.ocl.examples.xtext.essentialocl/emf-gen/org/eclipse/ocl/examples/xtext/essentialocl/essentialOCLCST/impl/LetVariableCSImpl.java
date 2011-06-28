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
 * $Id: LetVariableCSImpl.java,v 1.2 2011/01/24 21:31:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetVariableCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.util.EssentialOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.LetVariableCSImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.LetVariableCSImpl#getLetExpression <em>Let Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LetVariableCSImpl extends VariableCSImpl implements LetVariableCS {
	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected OperatorCS parent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LetVariableCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EssentialOCLCSTPackage.Literals.LET_VARIABLE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorCS getParent()
	{
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(OperatorCS newParent)
	{
		OperatorCS oldParent = parent;
		parent = newParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSTPackage.LET_VARIABLE_CS__PARENT, oldParent, parent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LetExpCS getLetExpression()
	{
		if (eContainerFeatureID() != EssentialOCLCSTPackage.LET_VARIABLE_CS__LET_EXPRESSION) return null;
		return (LetExpCS)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLetExpression(LetExpCS newLetExpression, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newLetExpression, EssentialOCLCSTPackage.LET_VARIABLE_CS__LET_EXPRESSION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLetExpression(LetExpCS newLetExpression)
	{
		if (newLetExpression != eInternalContainer() || (eContainerFeatureID() != EssentialOCLCSTPackage.LET_VARIABLE_CS__LET_EXPRESSION && newLetExpression != null))
		{
			if (EcoreUtil.isAncestor(this, newLetExpression))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newLetExpression != null)
				msgs = ((InternalEObject)newLetExpression).eInverseAdd(this, EssentialOCLCSTPackage.LET_EXP_CS__VARIABLE, LetExpCS.class, msgs);
			msgs = basicSetLetExpression(newLetExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSTPackage.LET_VARIABLE_CS__LET_EXPRESSION, newLetExpression, newLetExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case EssentialOCLCSTPackage.LET_VARIABLE_CS__LET_EXPRESSION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetLetExpression((LetExpCS)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case EssentialOCLCSTPackage.LET_VARIABLE_CS__LET_EXPRESSION:
				return basicSetLetExpression(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
	{
		switch (eContainerFeatureID())
		{
			case EssentialOCLCSTPackage.LET_VARIABLE_CS__LET_EXPRESSION:
				return eInternalContainer().eInverseRemove(this, EssentialOCLCSTPackage.LET_EXP_CS__VARIABLE, LetExpCS.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case EssentialOCLCSTPackage.LET_VARIABLE_CS__PARENT:
				return getParent();
			case EssentialOCLCSTPackage.LET_VARIABLE_CS__LET_EXPRESSION:
				return getLetExpression();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case EssentialOCLCSTPackage.LET_VARIABLE_CS__PARENT:
				setParent((OperatorCS)newValue);
				return;
			case EssentialOCLCSTPackage.LET_VARIABLE_CS__LET_EXPRESSION:
				setLetExpression((LetExpCS)newValue);
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
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case EssentialOCLCSTPackage.LET_VARIABLE_CS__PARENT:
				setParent((OperatorCS)null);
				return;
			case EssentialOCLCSTPackage.LET_VARIABLE_CS__LET_EXPRESSION:
				setLetExpression((LetExpCS)null);
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
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case EssentialOCLCSTPackage.LET_VARIABLE_CS__PARENT:
				return parent != null;
			case EssentialOCLCSTPackage.LET_VARIABLE_CS__LET_EXPRESSION:
				return getLetExpression() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
	{
		if (baseClass == ExpCS.class)
		{
			switch (derivedFeatureID)
			{
				case EssentialOCLCSTPackage.LET_VARIABLE_CS__PARENT: return EssentialOCLCSTPackage.EXP_CS__PARENT;
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
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
	{
		if (baseClass == ExpCS.class)
		{
			switch (baseFeatureID)
			{
				case EssentialOCLCSTPackage.EXP_CS__PARENT: return EssentialOCLCSTPackage.LET_VARIABLE_CS__PARENT;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		return (R) visitor.getAdapter(EssentialOCLCSVisitor.class).visitLetVariableCS(this);
	}
} //VariableCSImpl
