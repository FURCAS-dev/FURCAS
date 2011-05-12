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
 * $Id: MonikeredElementImpl.java,v 1.5 2011/05/12 06:07:29 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.MonikeredElement;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.internal.operations.MonikeredElementOperations;
import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.ocl.examples.pivot.utilities.Abstract2Moniker;
import org.eclipse.ocl.examples.pivot.utilities.Pivot2Moniker;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Monikered Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.MonikeredElementImpl#getMoniker <em>Moniker</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class MonikeredElementImpl
		extends ElementImpl
		implements MonikeredElement {

	/**
	 * The default value of the '{@link #getMoniker() <em>Moniker</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMoniker()
	 * @generated
	 * @ordered
	 */
	protected static final String MONIKER_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MonikeredElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.MONIKERED_ELEMENT;
	}

	private String moniker = MONIKER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getMoniker() {
		if (eIsProxy()) {
			throw new IllegalStateException("Unresolved proxy for " + eClass().getName() + ": " + eProxyURI()); 
		}
		if (moniker == null) {
			String moniker = Pivot2Moniker.toString(this);
			setMoniker(moniker);
		}
		return moniker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setMoniker(String newMoniker) {
		if (Abstract2Moniker.TRACE_MONIKERS.isActive()) {
			Abstract2Moniker.TRACE_MONIKERS.println(eClass().getName() + " ==> " + newMoniker);
		}
		moniker = newMoniker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasMoniker() {
		return moniker != MONIKER_EDEFAULT;
	}

	/**
	 * The moniker may be reset for test purposes. It should always recompute the
	 * same value.
	 * @generated NOT
	 */
	public void resetMoniker() {
		moniker = MONIKER_EDEFAULT;
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
			case PivotPackage.MONIKERED_ELEMENT__OWNED_COMMENT:
				return getOwnedComments();
			case PivotPackage.MONIKERED_ELEMENT__MONIKER:
				return getMoniker();
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
			case PivotPackage.MONIKERED_ELEMENT__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.MONIKERED_ELEMENT__MONIKER:
				setMoniker((String)newValue);
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
			case PivotPackage.MONIKERED_ELEMENT__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case PivotPackage.MONIKERED_ELEMENT__MONIKER:
				setMoniker(MONIKER_EDEFAULT);
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
			case PivotPackage.MONIKERED_ELEMENT__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.MONIKERED_ELEMENT__MONIKER:
				return MONIKER_EDEFAULT == null ? getMoniker() != null : !MONIKER_EDEFAULT.equals(getMoniker());
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments)
			throws InvocationTargetException {
		switch (operationID)
		{
			case PivotPackage.MONIKERED_ELEMENT___HAS_MONIKER:
				return hasMoniker();
		}
		return eDynamicInvoke(operationID, arguments);
	}

	@Override
	public <R, C> R accept(Visitor<R, C> visitor) {
		return visitor.visitMonikeredElement(this);
	}
} //MonikeredElementImpl
