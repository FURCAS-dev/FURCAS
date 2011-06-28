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
 * $Id: DecoratedNamedExpCSImpl.java,v 1.2 2011/01/24 21:31:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.examples.pivot.NamedElement;

import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.DecoratedNamedExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NamedExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SimpleNamedExpCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Decorated Named Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.DecoratedNamedExpCSImpl#getNamedExp <em>Named Exp</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DecoratedNamedExpCSImpl extends ExpCSImpl implements DecoratedNamedExpCS
{
	/**
	 * The cached value of the '{@link #getNamedExp() <em>Named Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamedExp()
	 * @generated
	 * @ordered
	 */
	protected NamedExpCS namedExp;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DecoratedNamedExpCSImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return EssentialOCLCSTPackage.Literals.DECORATED_NAMED_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedExpCS getNamedExp()
	{
		return namedExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNamedExp(NamedExpCS newNamedExp, NotificationChain msgs)
	{
		NamedExpCS oldNamedExp = namedExp;
		namedExp = newNamedExp;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EssentialOCLCSTPackage.DECORATED_NAMED_EXP_CS__NAMED_EXP, oldNamedExp, newNamedExp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamedExp(NamedExpCS newNamedExp)
	{
		if (newNamedExp != namedExp)
		{
			NotificationChain msgs = null;
			if (namedExp != null)
				msgs = ((InternalEObject)namedExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSTPackage.DECORATED_NAMED_EXP_CS__NAMED_EXP, null, msgs);
			if (newNamedExp != null)
				msgs = ((InternalEObject)newNamedExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSTPackage.DECORATED_NAMED_EXP_CS__NAMED_EXP, null, msgs);
			msgs = basicSetNamedExp(newNamedExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSTPackage.DECORATED_NAMED_EXP_CS__NAMED_EXP, newNamedExp, newNamedExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public NamedElement getNamedElement() {
		SimpleNamedExpCS simpleNamedExp = getSimpleNamedExp();
		return simpleNamedExp != null ? simpleNamedExp.getNamedElement() : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SimpleNamedExpCS getSimpleNamedExp()
	{
		NamedExpCS namedExp = getNamedExp();
		return namedExp != null ? namedExp.getSimpleNamedExp() : null;
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
			case EssentialOCLCSTPackage.DECORATED_NAMED_EXP_CS__NAMED_EXP:
				return basicSetNamedExp(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case EssentialOCLCSTPackage.DECORATED_NAMED_EXP_CS__NAMED_EXP:
				return getNamedExp();
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
			case EssentialOCLCSTPackage.DECORATED_NAMED_EXP_CS__NAMED_EXP:
				setNamedExp((NamedExpCS)newValue);
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
			case EssentialOCLCSTPackage.DECORATED_NAMED_EXP_CS__NAMED_EXP:
				setNamedExp((NamedExpCS)null);
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
			case EssentialOCLCSTPackage.DECORATED_NAMED_EXP_CS__NAMED_EXP:
				return namedExp != null;
		}
		return super.eIsSet(featureID);
	}

} //DecoratedNamedExpCSImpl
