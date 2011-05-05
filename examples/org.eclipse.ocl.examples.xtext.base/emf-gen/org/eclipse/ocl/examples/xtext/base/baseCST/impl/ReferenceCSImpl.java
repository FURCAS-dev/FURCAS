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
 * $Id: ReferenceCSImpl.java,v 1.3 2011/05/05 17:53:02 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.baseCST.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ReferenceCSImpl#getOpposite <em>Opposite</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ReferenceCSImpl#getKeys <em>Keys</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceCSImpl extends StructuralFeatureCSImpl implements ReferenceCS
{
	/**
	 * The cached value of the '{@link #getOpposite() <em>Opposite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpposite()
	 * @generated
	 * @ordered
	 */
	protected Property opposite;

	/**
	 * The cached value of the '{@link #getKeys() <em>Keys</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeys()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> keys;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceCSImpl()
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
		return BaseCSTPackage.Literals.REFERENCE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getOpposite()
	{
		if (opposite != null && ((EObject)opposite).eIsProxy())
		{
			InternalEObject oldOpposite = (InternalEObject)opposite;
			opposite = (Property)eResolveProxy(oldOpposite);
			if (opposite != oldOpposite)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BaseCSTPackage.REFERENCE_CS__OPPOSITE, oldOpposite, opposite));
			}
		}
		return opposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetOpposite()
	{
		return opposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOpposite(Property newOpposite)
	{
		Property oldOpposite = opposite;
		opposite = newOpposite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSTPackage.REFERENCE_CS__OPPOSITE, oldOpposite, opposite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getKeys()
	{
		if (keys == null)
		{
			keys = new EObjectResolvingEList<Property>(Property.class, this, BaseCSTPackage.REFERENCE_CS__KEYS);
		}
		return keys;
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
			case BaseCSTPackage.REFERENCE_CS__OPPOSITE:
				if (resolve) return getOpposite();
				return basicGetOpposite();
			case BaseCSTPackage.REFERENCE_CS__KEYS:
				return getKeys();
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
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case BaseCSTPackage.REFERENCE_CS__OPPOSITE:
				setOpposite((Property)newValue);
				return;
			case BaseCSTPackage.REFERENCE_CS__KEYS:
				getKeys().clear();
				getKeys().addAll((Collection<? extends Property>)newValue);
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
			case BaseCSTPackage.REFERENCE_CS__OPPOSITE:
				setOpposite((Property)null);
				return;
			case BaseCSTPackage.REFERENCE_CS__KEYS:
				getKeys().clear();
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
			case BaseCSTPackage.REFERENCE_CS__OPPOSITE:
				return opposite != null;
			case BaseCSTPackage.REFERENCE_CS__KEYS:
				return keys != null && !keys.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public <R, C> R accept(BaseCSVisitor<R, C> visitor) {
		return visitor.visitReferenceCS(this);
	}

} //ReferenceCSImpl
