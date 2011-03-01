/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
 * $Id: SpecificationCSImpl.java,v 1.1 2011/03/01 08:47:48 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.baseCST.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.SpecificationCS;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specification CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.SpecificationCSImpl#getExprString <em>Expr String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpecificationCSImpl extends MonikeredElementCSImpl implements SpecificationCS
{
	/**
	 * The default value of the '{@link #getExprString() <em>Expr String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExprString()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPR_STRING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExprString() <em>Expr String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExprString()
	 * @generated
	 * @ordered
	 */
	protected String exprString = EXPR_STRING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpecificationCSImpl()
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
		return BaseCSTPackage.Literals.SPECIFICATION_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExprString()
	{
		return exprString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExprString(String newExprString)
	{
		String oldExprString = exprString;
		exprString = newExprString;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSTPackage.SPECIFICATION_CS__EXPR_STRING, oldExprString, exprString));
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
			case BaseCSTPackage.SPECIFICATION_CS__EXPR_STRING:
				return getExprString();
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
			case BaseCSTPackage.SPECIFICATION_CS__EXPR_STRING:
				setExprString((String)newValue);
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
			case BaseCSTPackage.SPECIFICATION_CS__EXPR_STRING:
				setExprString(EXPR_STRING_EDEFAULT);
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
			case BaseCSTPackage.SPECIFICATION_CS__EXPR_STRING:
				return EXPR_STRING_EDEFAULT == null ? exprString != null : !EXPR_STRING_EDEFAULT.equals(exprString);
		}
		return super.eIsSet(featureID);
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
	public <R, C> R accept(BaseCSVisitor<R, C> visitor) {
		return visitor.visitSpecificationCS(this);
	}

} //SpecificationCSImpl
