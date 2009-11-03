/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.expressions.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.oslo.ocl20.semantics.OclVisitor;

import org.oslo.ocl20.semantics.bridge.Operation;

import org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage;
import org.oslo.ocl20.semantics.model.expressions.OclExpression;
import org.oslo.ocl20.semantics.model.expressions.OperationCallExp;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Operation Call Exp</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.oslo.ocl20.semantics.model.expressions.impl.OperationCallExpImpl#getReferredOperation
 * <em>Referred Operation</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.impl.OperationCallExpImpl#getArguments <em>
 * Arguments</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class OperationCallExpImpl extends ModelPropertyCallExpImpl implements OperationCallExp {
	/**
	 * The cached value of the '{@link #getReferredOperation() <em>Referred Operation</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getReferredOperation()
	 * @generated
	 * @ordered
	 */
	protected Operation referredOperation;

	/**
	 * The cached value of the '{@link #getArguments() <em>Arguments</em>}' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getArguments()
	 * @generated
	 * @ordered
	 */
	protected EList arguments;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected OperationCallExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.OPERATION_CALL_EXP;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Operation getReferredOperation() {
		if (referredOperation != null && referredOperation.eIsProxy()) {
			InternalEObject oldReferredOperation = (InternalEObject) referredOperation;
			referredOperation = (Operation) eResolveProxy(oldReferredOperation);
			if (referredOperation != oldReferredOperation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
					    ExpressionsPackage.OPERATION_CALL_EXP__REFERRED_OPERATION, oldReferredOperation,
					    referredOperation));
			}
		}
		return referredOperation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Operation basicGetReferredOperation() {
		return referredOperation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setReferredOperation(Operation newReferredOperation) {
		Operation oldReferredOperation = referredOperation;
		referredOperation = newReferredOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
			    ExpressionsPackage.OPERATION_CALL_EXP__REFERRED_OPERATION, oldReferredOperation, referredOperation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList getArguments() {
		if (arguments == null) {
			arguments = new EObjectContainmentWithInverseEList(OclExpression.class, this,
			    ExpressionsPackage.OPERATION_CALL_EXP__ARGUMENTS, ExpressionsPackage.OCL_EXPRESSION__OPERATION_CALL_EXP);
		}
		return arguments;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object accept(OclVisitor visitor, Object data) {
		return ((OclVisitor) visitor).visit(this, data);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionsPackage.OPERATION_CALL_EXP__ARGUMENTS:
				return ((InternalEList) getArguments()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionsPackage.OPERATION_CALL_EXP__ARGUMENTS:
				return ((InternalEList) getArguments()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExpressionsPackage.OPERATION_CALL_EXP__REFERRED_OPERATION:
				if (resolve)
					return getReferredOperation();
				return basicGetReferredOperation();
			case ExpressionsPackage.OPERATION_CALL_EXP__ARGUMENTS:
				return getArguments();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExpressionsPackage.OPERATION_CALL_EXP__REFERRED_OPERATION:
				setReferredOperation((Operation) newValue);
				return;
			case ExpressionsPackage.OPERATION_CALL_EXP__ARGUMENTS:
				getArguments().clear();
				getArguments().addAll((Collection) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case ExpressionsPackage.OPERATION_CALL_EXP__REFERRED_OPERATION:
				setReferredOperation((Operation) null);
				return;
			case ExpressionsPackage.OPERATION_CALL_EXP__ARGUMENTS:
				getArguments().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ExpressionsPackage.OPERATION_CALL_EXP__REFERRED_OPERATION:
				return referredOperation != null;
			case ExpressionsPackage.OPERATION_CALL_EXP__ARGUMENTS:
				return arguments != null && !arguments.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // OperationCallExpImpl
