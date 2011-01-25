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
 * $Id: MessageTypeImpl.java,v 1.2 2011/01/24 20:42:32 ewillink Exp $
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
import org.eclipse.ocl.examples.pivot.MessageType;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Signal;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.MessageTypeImpl#getReferredSignal <em>Referred Signal</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.MessageTypeImpl#getReferredOperation <em>Referred Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MessageTypeImpl
		extends TypeImpl
		implements MessageType {

	/**
	 * The cached value of the '{@link #getReferredSignal() <em>Referred Signal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredSignal()
	 * @generated
	 * @ordered
	 */
	protected Signal referredSignal;

	/**
	 * The cached value of the '{@link #getReferredOperation() <em>Referred Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredOperation()
	 * @generated
	 * @ordered
	 */
	protected Operation referredOperation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MessageTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.MESSAGE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Signal getReferredSignal() {
		if (referredSignal != null && ((EObject)referredSignal).eIsProxy())
		{
			InternalEObject oldReferredSignal = (InternalEObject)referredSignal;
			referredSignal = (Signal)eResolveProxy(oldReferredSignal);
			if (referredSignal != oldReferredSignal)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.MESSAGE_TYPE__REFERRED_SIGNAL, oldReferredSignal, referredSignal));
			}
		}
		return referredSignal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Signal basicGetReferredSignal() {
		return referredSignal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredSignal(Signal newReferredSignal) {
		Signal oldReferredSignal = referredSignal;
		referredSignal = newReferredSignal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.MESSAGE_TYPE__REFERRED_SIGNAL, oldReferredSignal, referredSignal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getReferredOperation() {
		if (referredOperation != null && ((EObject)referredOperation).eIsProxy())
		{
			InternalEObject oldReferredOperation = (InternalEObject)referredOperation;
			referredOperation = (Operation)eResolveProxy(oldReferredOperation);
			if (referredOperation != oldReferredOperation)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.MESSAGE_TYPE__REFERRED_OPERATION, oldReferredOperation, referredOperation));
			}
		}
		return referredOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetReferredOperation() {
		return referredOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredOperation(Operation newReferredOperation) {
		Operation oldReferredOperation = referredOperation;
		referredOperation = newReferredOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.MESSAGE_TYPE__REFERRED_OPERATION, oldReferredOperation, referredOperation));
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
			case PivotPackage.MESSAGE_TYPE__OWNED_COMMENT:
				return getOwnedComments();
			case PivotPackage.MESSAGE_TYPE__MONIKER:
				return getMoniker();
			case PivotPackage.MESSAGE_TYPE__NAME:
				return getName();
			case PivotPackage.MESSAGE_TYPE__OWNED_RULE:
				return getOwnedRules();
			case PivotPackage.MESSAGE_TYPE__IS_STATIC:
				return isStatic();
			case PivotPackage.MESSAGE_TYPE__OWNED_ANNOTATION:
				return getOwnedAnnotations();
			case PivotPackage.MESSAGE_TYPE__OWNING_TEMPLATE_PARAMETER:
				if (resolve) return getOwningTemplateParameter();
				return basicGetOwningTemplateParameter();
			case PivotPackage.MESSAGE_TYPE__TEMPLATE_PARAMETER:
				if (resolve) return getTemplateParameter();
				return basicGetTemplateParameter();
			case PivotPackage.MESSAGE_TYPE__TEMPLATE_BINDING:
				return getTemplateBindings();
			case PivotPackage.MESSAGE_TYPE__OWNED_TEMPLATE_SIGNATURE:
				if (resolve) return getOwnedTemplateSignature();
				return basicGetOwnedTemplateSignature();
			case PivotPackage.MESSAGE_TYPE__PACKAGE:
				if (resolve) return getPackage();
				return basicGetPackage();
			case PivotPackage.MESSAGE_TYPE__INSTANCE_CLASS_NAME:
				return getInstanceClassName();
			case PivotPackage.MESSAGE_TYPE__REFERRED_SIGNAL:
				if (resolve) return getReferredSignal();
				return basicGetReferredSignal();
			case PivotPackage.MESSAGE_TYPE__REFERRED_OPERATION:
				if (resolve) return getReferredOperation();
				return basicGetReferredOperation();
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
			case PivotPackage.MESSAGE_TYPE__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.MESSAGE_TYPE__MONIKER:
				setMoniker((String)newValue);
				return;
			case PivotPackage.MESSAGE_TYPE__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.MESSAGE_TYPE__OWNED_RULE:
				getOwnedRules().clear();
				getOwnedRules().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.MESSAGE_TYPE__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.MESSAGE_TYPE__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case PivotPackage.MESSAGE_TYPE__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.MESSAGE_TYPE__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.MESSAGE_TYPE__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				getTemplateBindings().addAll((Collection<? extends TemplateBinding>)newValue);
				return;
			case PivotPackage.MESSAGE_TYPE__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)newValue);
				return;
			case PivotPackage.MESSAGE_TYPE__PACKAGE:
				setPackage((org.eclipse.ocl.examples.pivot.Package)newValue);
				return;
			case PivotPackage.MESSAGE_TYPE__INSTANCE_CLASS_NAME:
				setInstanceClassName((String)newValue);
				return;
			case PivotPackage.MESSAGE_TYPE__REFERRED_SIGNAL:
				setReferredSignal((Signal)newValue);
				return;
			case PivotPackage.MESSAGE_TYPE__REFERRED_OPERATION:
				setReferredOperation((Operation)newValue);
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
			case PivotPackage.MESSAGE_TYPE__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case PivotPackage.MESSAGE_TYPE__MONIKER:
				setMoniker(MONIKER_EDEFAULT);
				return;
			case PivotPackage.MESSAGE_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.MESSAGE_TYPE__OWNED_RULE:
				getOwnedRules().clear();
				return;
			case PivotPackage.MESSAGE_TYPE__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.MESSAGE_TYPE__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.MESSAGE_TYPE__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.MESSAGE_TYPE__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.MESSAGE_TYPE__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				return;
			case PivotPackage.MESSAGE_TYPE__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)null);
				return;
			case PivotPackage.MESSAGE_TYPE__PACKAGE:
				setPackage((org.eclipse.ocl.examples.pivot.Package)null);
				return;
			case PivotPackage.MESSAGE_TYPE__INSTANCE_CLASS_NAME:
				setInstanceClassName(INSTANCE_CLASS_NAME_EDEFAULT);
				return;
			case PivotPackage.MESSAGE_TYPE__REFERRED_SIGNAL:
				setReferredSignal((Signal)null);
				return;
			case PivotPackage.MESSAGE_TYPE__REFERRED_OPERATION:
				setReferredOperation((Operation)null);
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
			case PivotPackage.MESSAGE_TYPE__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.MESSAGE_TYPE__MONIKER:
				return MONIKER_EDEFAULT == null ? getMoniker() != null : !MONIKER_EDEFAULT.equals(getMoniker());
			case PivotPackage.MESSAGE_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.MESSAGE_TYPE__OWNED_RULE:
				return ownedRules != null && !ownedRules.isEmpty();
			case PivotPackage.MESSAGE_TYPE__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.MESSAGE_TYPE__OWNED_ANNOTATION:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.MESSAGE_TYPE__OWNING_TEMPLATE_PARAMETER:
				return basicGetOwningTemplateParameter() != null;
			case PivotPackage.MESSAGE_TYPE__TEMPLATE_PARAMETER:
				return isSetTemplateParameter();
			case PivotPackage.MESSAGE_TYPE__TEMPLATE_BINDING:
				return templateBindings != null && !templateBindings.isEmpty();
			case PivotPackage.MESSAGE_TYPE__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case PivotPackage.MESSAGE_TYPE__PACKAGE:
				return basicGetPackage() != null;
			case PivotPackage.MESSAGE_TYPE__INSTANCE_CLASS_NAME:
				return INSTANCE_CLASS_NAME_EDEFAULT == null ? instanceClassName != null : !INSTANCE_CLASS_NAME_EDEFAULT.equals(instanceClassName);
			case PivotPackage.MESSAGE_TYPE__REFERRED_SIGNAL:
				return referredSignal != null;
			case PivotPackage.MESSAGE_TYPE__REFERRED_OPERATION:
				return referredOperation != null;
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R, C> R accept(Visitor<R, C> visitor) {
		return visitor.visitMessageType(this);
	}
} //MessageTypeImpl
