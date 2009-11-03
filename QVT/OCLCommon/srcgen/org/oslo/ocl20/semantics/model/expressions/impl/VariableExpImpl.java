/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.expressions.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.oslo.ocl20.semantics.OclVisitor;

import org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage;
import org.oslo.ocl20.semantics.model.expressions.VariableDeclaration;
import org.oslo.ocl20.semantics.model.expressions.VariableExp;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Variable Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.impl.VariableExpImpl#getReferredVariable
 * <em>Referred Variable</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class VariableExpImpl extends OclExpressionImpl implements VariableExp {
	/**
	 * The cached value of the '{@link #getReferredVariable() <em>Referred Variable</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getReferredVariable()
	 * @generated
	 * @ordered
	 */
	protected VariableDeclaration referredVariable;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected VariableExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.VARIABLE_EXP;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VariableDeclaration getReferredVariable() {
		if (referredVariable != null && referredVariable.eIsProxy()) {
			InternalEObject oldReferredVariable = (InternalEObject) referredVariable;
			referredVariable = (VariableDeclaration) eResolveProxy(oldReferredVariable);
			if (referredVariable != oldReferredVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
					    ExpressionsPackage.VARIABLE_EXP__REFERRED_VARIABLE, oldReferredVariable, referredVariable));
			}
		}
		return referredVariable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VariableDeclaration basicGetReferredVariable() {
		return referredVariable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetReferredVariable(VariableDeclaration newReferredVariable, NotificationChain msgs) {
		VariableDeclaration oldReferredVariable = referredVariable;
		referredVariable = newReferredVariable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
			    ExpressionsPackage.VARIABLE_EXP__REFERRED_VARIABLE, oldReferredVariable, newReferredVariable);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setReferredVariable(VariableDeclaration newReferredVariable) {
		if (newReferredVariable != referredVariable) {
			NotificationChain msgs = null;
			if (referredVariable != null)
				msgs = ((InternalEObject) referredVariable).eInverseRemove(this,
				    ExpressionsPackage.VARIABLE_DECLARATION__VARIABLE_EXPS, VariableDeclaration.class, msgs);
			if (newReferredVariable != null)
				msgs = ((InternalEObject) newReferredVariable).eInverseAdd(this,
				    ExpressionsPackage.VARIABLE_DECLARATION__VARIABLE_EXPS, VariableDeclaration.class, msgs);
			msgs = basicSetReferredVariable(newReferredVariable, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.VARIABLE_EXP__REFERRED_VARIABLE,
			    newReferredVariable, newReferredVariable));
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
			case ExpressionsPackage.VARIABLE_EXP__REFERRED_VARIABLE:
				if (referredVariable != null)
					msgs = ((InternalEObject) referredVariable).eInverseRemove(this,
					    ExpressionsPackage.VARIABLE_DECLARATION__VARIABLE_EXPS, VariableDeclaration.class, msgs);
				return basicSetReferredVariable((VariableDeclaration) otherEnd, msgs);
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
			case ExpressionsPackage.VARIABLE_EXP__REFERRED_VARIABLE:
				return basicSetReferredVariable(null, msgs);
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
			case ExpressionsPackage.VARIABLE_EXP__REFERRED_VARIABLE:
				if (resolve)
					return getReferredVariable();
				return basicGetReferredVariable();
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
			case ExpressionsPackage.VARIABLE_EXP__REFERRED_VARIABLE:
				setReferredVariable((VariableDeclaration) newValue);
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
			case ExpressionsPackage.VARIABLE_EXP__REFERRED_VARIABLE:
				setReferredVariable((VariableDeclaration) null);
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
			case ExpressionsPackage.VARIABLE_EXP__REFERRED_VARIABLE:
				return referredVariable != null;
		}
		return super.eIsSet(featureID);
	}

} // VariableExpImpl
