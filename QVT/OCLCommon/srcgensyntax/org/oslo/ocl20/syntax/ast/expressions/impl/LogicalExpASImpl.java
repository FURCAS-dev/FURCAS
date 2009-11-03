/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.expressions.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.oslo.ocl20.syntax.ast.Visitor;

import org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage;
import org.oslo.ocl20.syntax.ast.expressions.IfExpAS;
import org.oslo.ocl20.syntax.ast.expressions.LogicalExpAS;
import org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Logical Exp AS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.expressions.impl.LogicalExpASImpl#getRightOperand <em>Right Operand</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.expressions.impl.LogicalExpASImpl#getLeftOperand <em>Left Operand</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class LogicalExpASImpl extends OclExpressionASImpl implements LogicalExpAS {
	/**
	 * The cached value of the '{@link #getRightOperand() <em>Right Operand</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightOperand()
	 * @generated
	 * @ordered
	 */
	protected OclExpressionAS rightOperand;

	/**
	 * The cached value of the '{@link #getLeftOperand() <em>Left Operand</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftOperand()
	 * @generated
	 * @ordered
	 */
	protected OclExpressionAS leftOperand;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LogicalExpASImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.LOGICAL_EXP_AS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpressionAS getRightOperand() {
		if (rightOperand != null && rightOperand.eIsProxy()) {
			InternalEObject oldRightOperand = (InternalEObject)rightOperand;
			rightOperand = (OclExpressionAS)eResolveProxy(oldRightOperand);
			if (rightOperand != oldRightOperand) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.LOGICAL_EXP_AS__RIGHT_OPERAND, oldRightOperand, rightOperand));
			}
		}
		return rightOperand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpressionAS basicGetRightOperand() {
		return rightOperand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRightOperand(OclExpressionAS newRightOperand) {
		OclExpressionAS oldRightOperand = rightOperand;
		rightOperand = newRightOperand;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.LOGICAL_EXP_AS__RIGHT_OPERAND, oldRightOperand, rightOperand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpressionAS getLeftOperand() {
		if (leftOperand != null && leftOperand.eIsProxy()) {
			InternalEObject oldLeftOperand = (InternalEObject)leftOperand;
			leftOperand = (OclExpressionAS)eResolveProxy(oldLeftOperand);
			if (leftOperand != oldLeftOperand) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.LOGICAL_EXP_AS__LEFT_OPERAND, oldLeftOperand, leftOperand));
			}
		}
		return leftOperand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpressionAS basicGetLeftOperand() {
		return leftOperand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftOperand(OclExpressionAS newLeftOperand) {
		OclExpressionAS oldLeftOperand = leftOperand;
		leftOperand = newLeftOperand;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.LOGICAL_EXP_AS__LEFT_OPERAND, oldLeftOperand, leftOperand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object accept(Visitor visitor, Object data) {
		return ((org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserVisitorImpl)visitor).visit(this,data);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExpressionsPackage.LOGICAL_EXP_AS__RIGHT_OPERAND:
				if (resolve) return getRightOperand();
				return basicGetRightOperand();
			case ExpressionsPackage.LOGICAL_EXP_AS__LEFT_OPERAND:
				if (resolve) return getLeftOperand();
				return basicGetLeftOperand();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExpressionsPackage.LOGICAL_EXP_AS__RIGHT_OPERAND:
				setRightOperand((OclExpressionAS)newValue);
				return;
			case ExpressionsPackage.LOGICAL_EXP_AS__LEFT_OPERAND:
				setLeftOperand((OclExpressionAS)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case ExpressionsPackage.LOGICAL_EXP_AS__RIGHT_OPERAND:
				setRightOperand((OclExpressionAS)null);
				return;
			case ExpressionsPackage.LOGICAL_EXP_AS__LEFT_OPERAND:
				setLeftOperand((OclExpressionAS)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ExpressionsPackage.LOGICAL_EXP_AS__RIGHT_OPERAND:
				return rightOperand != null;
			case ExpressionsPackage.LOGICAL_EXP_AS__LEFT_OPERAND:
				return leftOperand != null;
		}
		return super.eIsSet(featureID);
	}

} //LogicalExpASImpl
