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
 * $Id: MessageExpImpl.java,v 1.2 2011/01/24 20:42:32 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.CallOperationAction;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.MessageExp;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.SendSignalAction;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.MessageExpImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.MessageExpImpl#getArguments <em>Argument</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.MessageExpImpl#getCalledOperation <em>Called Operation</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.MessageExpImpl#getSentSignal <em>Sent Signal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MessageExpImpl
		extends OclExpressionImpl
		implements MessageExp {

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected OclExpression target;

	/**
	 * The cached value of the '{@link #getArguments() <em>Argument</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<OclExpression> arguments;

	/**
	 * The cached value of the '{@link #getCalledOperation() <em>Called Operation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCalledOperation()
	 * @generated
	 * @ordered
	 */
	protected CallOperationAction calledOperation;

	/**
	 * The cached value of the '{@link #getSentSignal() <em>Sent Signal</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSentSignal()
	 * @generated
	 * @ordered
	 */
	protected SendSignalAction sentSignal;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MessageExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.MESSAGE_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclExpression getTarget() {
		if (target != null && ((EObject)target).eIsProxy())
		{
			InternalEObject oldTarget = (InternalEObject)target;
			target = (OclExpression)eResolveProxy(oldTarget);
			if (target != oldTarget)
			{
				InternalEObject newTarget = (InternalEObject)target;
				NotificationChain msgs = oldTarget.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.MESSAGE_EXP__TARGET, null, null);
				if (newTarget.eInternalContainer() == null)
				{
					msgs = newTarget.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.MESSAGE_EXP__TARGET, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.MESSAGE_EXP__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(OclExpression newTarget,
			NotificationChain msgs) {
		OclExpression oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.MESSAGE_EXP__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(OclExpression newTarget) {
		if (newTarget != target)
		{
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.MESSAGE_EXP__TARGET, null, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.MESSAGE_EXP__TARGET, null, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.MESSAGE_EXP__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression createTarget(EClass eClass) {
		OclExpression newTarget = (OclExpression) create(eClass);
		setTarget(newTarget);
		return newTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression createTarget() {
		return createTarget(PivotPackage.Literals.OCL_EXPRESSION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OclExpression> getArguments() {
		if (arguments == null)
		{
			arguments = new EObjectContainmentEList.Resolving<OclExpression>(OclExpression.class, this, PivotPackage.MESSAGE_EXP__ARGUMENT);
		}
		return arguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression createArgument(EClass eClass) {
		OclExpression newArgument = (OclExpression) create(eClass);
		getArguments().add(newArgument);
		return newArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression createArgument() {
		return createArgument(PivotPackage.Literals.OCL_EXPRESSION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallOperationAction getCalledOperation() {
		if (calledOperation != null && ((EObject)calledOperation).eIsProxy())
		{
			InternalEObject oldCalledOperation = (InternalEObject)calledOperation;
			calledOperation = (CallOperationAction)eResolveProxy(oldCalledOperation);
			if (calledOperation != oldCalledOperation)
			{
				InternalEObject newCalledOperation = (InternalEObject)calledOperation;
				NotificationChain msgs = oldCalledOperation.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.MESSAGE_EXP__CALLED_OPERATION, null, null);
				if (newCalledOperation.eInternalContainer() == null)
				{
					msgs = newCalledOperation.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.MESSAGE_EXP__CALLED_OPERATION, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.MESSAGE_EXP__CALLED_OPERATION, oldCalledOperation, calledOperation));
			}
		}
		return calledOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallOperationAction basicGetCalledOperation() {
		return calledOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCalledOperation(
			CallOperationAction newCalledOperation, NotificationChain msgs) {
		CallOperationAction oldCalledOperation = calledOperation;
		calledOperation = newCalledOperation;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.MESSAGE_EXP__CALLED_OPERATION, oldCalledOperation, newCalledOperation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCalledOperation(CallOperationAction newCalledOperation) {
		if (newCalledOperation != calledOperation)
		{
			NotificationChain msgs = null;
			if (calledOperation != null)
				msgs = ((InternalEObject)calledOperation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.MESSAGE_EXP__CALLED_OPERATION, null, msgs);
			if (newCalledOperation != null)
				msgs = ((InternalEObject)newCalledOperation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.MESSAGE_EXP__CALLED_OPERATION, null, msgs);
			msgs = basicSetCalledOperation(newCalledOperation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.MESSAGE_EXP__CALLED_OPERATION, newCalledOperation, newCalledOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallOperationAction createCalledOperation() {
		CallOperationAction newCalledOperation = (CallOperationAction) create(PivotPackage.Literals.CALL_OPERATION_ACTION);
		setCalledOperation(newCalledOperation);
		return newCalledOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SendSignalAction getSentSignal() {
		if (sentSignal != null && ((EObject)sentSignal).eIsProxy())
		{
			InternalEObject oldSentSignal = (InternalEObject)sentSignal;
			sentSignal = (SendSignalAction)eResolveProxy(oldSentSignal);
			if (sentSignal != oldSentSignal)
			{
				InternalEObject newSentSignal = (InternalEObject)sentSignal;
				NotificationChain msgs = oldSentSignal.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.MESSAGE_EXP__SENT_SIGNAL, null, null);
				if (newSentSignal.eInternalContainer() == null)
				{
					msgs = newSentSignal.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.MESSAGE_EXP__SENT_SIGNAL, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.MESSAGE_EXP__SENT_SIGNAL, oldSentSignal, sentSignal));
			}
		}
		return sentSignal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SendSignalAction basicGetSentSignal() {
		return sentSignal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSentSignal(SendSignalAction newSentSignal,
			NotificationChain msgs) {
		SendSignalAction oldSentSignal = sentSignal;
		sentSignal = newSentSignal;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.MESSAGE_EXP__SENT_SIGNAL, oldSentSignal, newSentSignal);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSentSignal(SendSignalAction newSentSignal) {
		if (newSentSignal != sentSignal)
		{
			NotificationChain msgs = null;
			if (sentSignal != null)
				msgs = ((InternalEObject)sentSignal).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.MESSAGE_EXP__SENT_SIGNAL, null, msgs);
			if (newSentSignal != null)
				msgs = ((InternalEObject)newSentSignal).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.MESSAGE_EXP__SENT_SIGNAL, null, msgs);
			msgs = basicSetSentSignal(newSentSignal, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.MESSAGE_EXP__SENT_SIGNAL, newSentSignal, newSentSignal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SendSignalAction createSentSignal() {
		SendSignalAction newSentSignal = (SendSignalAction) create(PivotPackage.Literals.SEND_SIGNAL_ACTION);
		setSentSignal(newSentSignal);
		return newSentSignal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case PivotPackage.MESSAGE_EXP__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.MESSAGE_EXP__OWNED_RULE:
				return ((InternalEList<?>)getOwnedRules()).basicRemove(otherEnd, msgs);
			case PivotPackage.MESSAGE_EXP__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotations()).basicRemove(otherEnd, msgs);
			case PivotPackage.MESSAGE_EXP__TARGET:
				return basicSetTarget(null, msgs);
			case PivotPackage.MESSAGE_EXP__ARGUMENT:
				return ((InternalEList<?>)getArguments()).basicRemove(otherEnd, msgs);
			case PivotPackage.MESSAGE_EXP__CALLED_OPERATION:
				return basicSetCalledOperation(null, msgs);
			case PivotPackage.MESSAGE_EXP__SENT_SIGNAL:
				return basicSetSentSignal(null, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
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
			case PivotPackage.MESSAGE_EXP__OWNED_COMMENT:
				return getOwnedComments();
			case PivotPackage.MESSAGE_EXP__MONIKER:
				return getMoniker();
			case PivotPackage.MESSAGE_EXP__NAME:
				return getName();
			case PivotPackage.MESSAGE_EXP__OWNED_RULE:
				return getOwnedRules();
			case PivotPackage.MESSAGE_EXP__IS_STATIC:
				return isStatic();
			case PivotPackage.MESSAGE_EXP__OWNED_ANNOTATION:
				return getOwnedAnnotations();
			case PivotPackage.MESSAGE_EXP__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.MESSAGE_EXP__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case PivotPackage.MESSAGE_EXP__ARGUMENT:
				return getArguments();
			case PivotPackage.MESSAGE_EXP__CALLED_OPERATION:
				if (resolve) return getCalledOperation();
				return basicGetCalledOperation();
			case PivotPackage.MESSAGE_EXP__SENT_SIGNAL:
				if (resolve) return getSentSignal();
				return basicGetSentSignal();
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
			case PivotPackage.MESSAGE_EXP__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.MESSAGE_EXP__MONIKER:
				setMoniker((String)newValue);
				return;
			case PivotPackage.MESSAGE_EXP__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.MESSAGE_EXP__OWNED_RULE:
				getOwnedRules().clear();
				getOwnedRules().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.MESSAGE_EXP__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.MESSAGE_EXP__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case PivotPackage.MESSAGE_EXP__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.MESSAGE_EXP__TARGET:
				setTarget((OclExpression)newValue);
				return;
			case PivotPackage.MESSAGE_EXP__ARGUMENT:
				getArguments().clear();
				getArguments().addAll((Collection<? extends OclExpression>)newValue);
				return;
			case PivotPackage.MESSAGE_EXP__CALLED_OPERATION:
				setCalledOperation((CallOperationAction)newValue);
				return;
			case PivotPackage.MESSAGE_EXP__SENT_SIGNAL:
				setSentSignal((SendSignalAction)newValue);
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
			case PivotPackage.MESSAGE_EXP__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case PivotPackage.MESSAGE_EXP__MONIKER:
				setMoniker(MONIKER_EDEFAULT);
				return;
			case PivotPackage.MESSAGE_EXP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.MESSAGE_EXP__OWNED_RULE:
				getOwnedRules().clear();
				return;
			case PivotPackage.MESSAGE_EXP__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.MESSAGE_EXP__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.MESSAGE_EXP__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.MESSAGE_EXP__TARGET:
				setTarget((OclExpression)null);
				return;
			case PivotPackage.MESSAGE_EXP__ARGUMENT:
				getArguments().clear();
				return;
			case PivotPackage.MESSAGE_EXP__CALLED_OPERATION:
				setCalledOperation((CallOperationAction)null);
				return;
			case PivotPackage.MESSAGE_EXP__SENT_SIGNAL:
				setSentSignal((SendSignalAction)null);
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
			case PivotPackage.MESSAGE_EXP__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.MESSAGE_EXP__MONIKER:
				return MONIKER_EDEFAULT == null ? getMoniker() != null : !MONIKER_EDEFAULT.equals(getMoniker());
			case PivotPackage.MESSAGE_EXP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.MESSAGE_EXP__OWNED_RULE:
				return ownedRules != null && !ownedRules.isEmpty();
			case PivotPackage.MESSAGE_EXP__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.MESSAGE_EXP__OWNED_ANNOTATION:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.MESSAGE_EXP__TYPE:
				return type != null;
			case PivotPackage.MESSAGE_EXP__TARGET:
				return target != null;
			case PivotPackage.MESSAGE_EXP__ARGUMENT:
				return arguments != null && !arguments.isEmpty();
			case PivotPackage.MESSAGE_EXP__CALLED_OPERATION:
				return calledOperation != null;
			case PivotPackage.MESSAGE_EXP__SENT_SIGNAL:
				return sentSignal != null;
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R, C> R accept(Visitor<R, C> visitor) {
		return visitor.visitMessageExp(this);
	}
} //MessageExpImpl
