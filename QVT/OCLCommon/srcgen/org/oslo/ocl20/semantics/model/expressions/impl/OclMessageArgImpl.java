/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.expressions.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage;
import org.oslo.ocl20.semantics.model.expressions.OclExpression;
import org.oslo.ocl20.semantics.model.expressions.OclMessageArg;
import org.oslo.ocl20.semantics.model.expressions.UnspecifiedValueExp;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Ocl Message Arg</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.impl.OclMessageArgImpl#getExpression <em>
 * Expression</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.impl.OclMessageArgImpl#getUnspecified <em>
 * Unspecified</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class OclMessageArgImpl extends EObjectImpl implements OclMessageArg {
	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected OclExpression expression;

	/**
	 * The cached value of the '{@link #getUnspecified() <em>Unspecified</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUnspecified()
	 * @generated
	 * @ordered
	 */
	protected UnspecifiedValueExp unspecified;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected OclMessageArgImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.OCL_MESSAGE_ARG;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OclExpression getExpression() {
		if (expression != null && expression.eIsProxy()) {
			InternalEObject oldExpression = (InternalEObject) expression;
			expression = (OclExpression) eResolveProxy(oldExpression);
			if (expression != oldExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
					    ExpressionsPackage.OCL_MESSAGE_ARG__EXPRESSION, oldExpression, expression));
			}
		}
		return expression;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OclExpression basicGetExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setExpression(OclExpression newExpression) {
		OclExpression oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OCL_MESSAGE_ARG__EXPRESSION,
			    oldExpression, expression));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UnspecifiedValueExp getUnspecified() {
		if (unspecified != null && unspecified.eIsProxy()) {
			InternalEObject oldUnspecified = (InternalEObject) unspecified;
			unspecified = (UnspecifiedValueExp) eResolveProxy(oldUnspecified);
			if (unspecified != oldUnspecified) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
					    ExpressionsPackage.OCL_MESSAGE_ARG__UNSPECIFIED, oldUnspecified, unspecified));
			}
		}
		return unspecified;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UnspecifiedValueExp basicGetUnspecified() {
		return unspecified;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setUnspecified(UnspecifiedValueExp newUnspecified) {
		UnspecifiedValueExp oldUnspecified = unspecified;
		unspecified = newUnspecified;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OCL_MESSAGE_ARG__UNSPECIFIED,
			    oldUnspecified, unspecified));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExpressionsPackage.OCL_MESSAGE_ARG__EXPRESSION:
				if (resolve)
					return getExpression();
				return basicGetExpression();
			case ExpressionsPackage.OCL_MESSAGE_ARG__UNSPECIFIED:
				if (resolve)
					return getUnspecified();
				return basicGetUnspecified();
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
			case ExpressionsPackage.OCL_MESSAGE_ARG__EXPRESSION:
				setExpression((OclExpression) newValue);
				return;
			case ExpressionsPackage.OCL_MESSAGE_ARG__UNSPECIFIED:
				setUnspecified((UnspecifiedValueExp) newValue);
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
			case ExpressionsPackage.OCL_MESSAGE_ARG__EXPRESSION:
				setExpression((OclExpression) null);
				return;
			case ExpressionsPackage.OCL_MESSAGE_ARG__UNSPECIFIED:
				setUnspecified((UnspecifiedValueExp) null);
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
			case ExpressionsPackage.OCL_MESSAGE_ARG__EXPRESSION:
				return expression != null;
			case ExpressionsPackage.OCL_MESSAGE_ARG__UNSPECIFIED:
				return unspecified != null;
		}
		return super.eIsSet(featureID);
	}

} // OclMessageArgImpl
