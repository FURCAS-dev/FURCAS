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
 * $Id: SendSignalActionImpl.java,v 1.2 2011/01/24 20:42:33 ewillink Exp $
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
import org.eclipse.ocl.examples.pivot.SendSignalAction;
import org.eclipse.ocl.examples.pivot.Signal;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Send Signal Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.SendSignalActionImpl#getSignal <em>Signal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SendSignalActionImpl
		extends NamedElementImpl
		implements SendSignalAction {

	/**
	 * The cached value of the '{@link #getSignal() <em>Signal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignal()
	 * @generated
	 * @ordered
	 */
	protected Signal signal;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SendSignalActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.SEND_SIGNAL_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Signal getSignal() {
		if (signal != null && ((EObject)signal).eIsProxy())
		{
			InternalEObject oldSignal = (InternalEObject)signal;
			signal = (Signal)eResolveProxy(oldSignal);
			if (signal != oldSignal)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.SEND_SIGNAL_ACTION__SIGNAL, oldSignal, signal));
			}
		}
		return signal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Signal basicGetSignal() {
		return signal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSignal(Signal newSignal) {
		Signal oldSignal = signal;
		signal = newSignal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.SEND_SIGNAL_ACTION__SIGNAL, oldSignal, signal));
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
			case PivotPackage.SEND_SIGNAL_ACTION__OWNED_COMMENT:
				return getOwnedComments();
			case PivotPackage.SEND_SIGNAL_ACTION__MONIKER:
				return getMoniker();
			case PivotPackage.SEND_SIGNAL_ACTION__NAME:
				return getName();
			case PivotPackage.SEND_SIGNAL_ACTION__OWNED_RULE:
				return getOwnedRules();
			case PivotPackage.SEND_SIGNAL_ACTION__IS_STATIC:
				return isStatic();
			case PivotPackage.SEND_SIGNAL_ACTION__OWNED_ANNOTATION:
				return getOwnedAnnotations();
			case PivotPackage.SEND_SIGNAL_ACTION__SIGNAL:
				if (resolve) return getSignal();
				return basicGetSignal();
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
			case PivotPackage.SEND_SIGNAL_ACTION__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.SEND_SIGNAL_ACTION__MONIKER:
				setMoniker((String)newValue);
				return;
			case PivotPackage.SEND_SIGNAL_ACTION__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.SEND_SIGNAL_ACTION__OWNED_RULE:
				getOwnedRules().clear();
				getOwnedRules().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.SEND_SIGNAL_ACTION__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.SEND_SIGNAL_ACTION__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case PivotPackage.SEND_SIGNAL_ACTION__SIGNAL:
				setSignal((Signal)newValue);
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
			case PivotPackage.SEND_SIGNAL_ACTION__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case PivotPackage.SEND_SIGNAL_ACTION__MONIKER:
				setMoniker(MONIKER_EDEFAULT);
				return;
			case PivotPackage.SEND_SIGNAL_ACTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.SEND_SIGNAL_ACTION__OWNED_RULE:
				getOwnedRules().clear();
				return;
			case PivotPackage.SEND_SIGNAL_ACTION__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.SEND_SIGNAL_ACTION__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.SEND_SIGNAL_ACTION__SIGNAL:
				setSignal((Signal)null);
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
			case PivotPackage.SEND_SIGNAL_ACTION__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.SEND_SIGNAL_ACTION__MONIKER:
				return MONIKER_EDEFAULT == null ? getMoniker() != null : !MONIKER_EDEFAULT.equals(getMoniker());
			case PivotPackage.SEND_SIGNAL_ACTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.SEND_SIGNAL_ACTION__OWNED_RULE:
				return ownedRules != null && !ownedRules.isEmpty();
			case PivotPackage.SEND_SIGNAL_ACTION__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.SEND_SIGNAL_ACTION__OWNED_ANNOTATION:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.SEND_SIGNAL_ACTION__SIGNAL:
				return signal != null;
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R, C> R accept(Visitor<R, C> visitor) {
		return visitor.visitSendSignalAction(this);
	}
} //SendSignalActionImpl
