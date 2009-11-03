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
import org.oslo.ocl20.semantics.model.expressions.IterateExp;
import org.oslo.ocl20.semantics.model.expressions.VariableDeclaration;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Iterate Exp</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.impl.IterateExpImpl#getResult <em>Result
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class IterateExpImpl extends LoopExpImpl implements IterateExp {
	/**
	 * The cached value of the '{@link #getResult() <em>Result</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected VariableDeclaration result;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected IterateExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.ITERATE_EXP;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VariableDeclaration getResult() {
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetResult(VariableDeclaration newResult, NotificationChain msgs) {
		VariableDeclaration oldResult = result;
		result = newResult;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
			    ExpressionsPackage.ITERATE_EXP__RESULT, oldResult, newResult);
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
	public void setResult(VariableDeclaration newResult) {
		if (newResult != result) {
			NotificationChain msgs = null;
			if (result != null)
				msgs = ((InternalEObject) result).eInverseRemove(this,
				    ExpressionsPackage.VARIABLE_DECLARATION__BASE_EXP, VariableDeclaration.class, msgs);
			if (newResult != null)
				msgs = ((InternalEObject) newResult).eInverseAdd(this,
				    ExpressionsPackage.VARIABLE_DECLARATION__BASE_EXP, VariableDeclaration.class, msgs);
			msgs = basicSetResult(newResult, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.ITERATE_EXP__RESULT, newResult,
			    newResult));
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
			case ExpressionsPackage.ITERATE_EXP__RESULT:
				if (result != null)
					msgs = ((InternalEObject) result).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					        - ExpressionsPackage.ITERATE_EXP__RESULT, null, msgs);
				return basicSetResult((VariableDeclaration) otherEnd, msgs);
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
			case ExpressionsPackage.ITERATE_EXP__RESULT:
				return basicSetResult(null, msgs);
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
			case ExpressionsPackage.ITERATE_EXP__RESULT:
				return getResult();
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
			case ExpressionsPackage.ITERATE_EXP__RESULT:
				setResult((VariableDeclaration) newValue);
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
			case ExpressionsPackage.ITERATE_EXP__RESULT:
				setResult((VariableDeclaration) null);
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
			case ExpressionsPackage.ITERATE_EXP__RESULT:
				return result != null;
		}
		return super.eIsSet(featureID);
	}

} // IterateExpImpl
