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
import org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS;

import org.oslo.ocl20.syntax.ast.impl.VisitableImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ocl Expression AS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.expressions.impl.OclExpressionASImpl#getIsMarkedPre <em>Is Marked Pre</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.expressions.impl.OclExpressionASImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.expressions.impl.OclExpressionASImpl#getIfExpAS <em>If Exp AS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OclExpressionASImpl extends VisitableImpl implements OclExpressionAS {
	/**
	 * The default value of the '{@link #getIsMarkedPre() <em>Is Marked Pre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsMarkedPre()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean IS_MARKED_PRE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIsMarkedPre() <em>Is Marked Pre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsMarkedPre()
	 * @generated
	 * @ordered
	 */
	protected Boolean isMarkedPre = IS_MARKED_PRE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected OclExpressionAS parent;

	/**
	 * The cached value of the '{@link #getIfExpAS() <em>If Exp AS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIfExpAS()
	 * @generated
	 * @ordered
	 */
	protected IfExpAS ifExpAS;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OclExpressionASImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.OCL_EXPRESSION_AS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getIsMarkedPre() {
		return isMarkedPre;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsMarkedPre(Boolean newIsMarkedPre) {
		Boolean oldIsMarkedPre = isMarkedPre;
		isMarkedPre = newIsMarkedPre;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OCL_EXPRESSION_AS__IS_MARKED_PRE, oldIsMarkedPre, isMarkedPre));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpressionAS getParent() {
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject)parent;
			parent = (OclExpressionAS)eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.OCL_EXPRESSION_AS__PARENT, oldParent, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpressionAS basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(OclExpressionAS newParent) {
		OclExpressionAS oldParent = parent;
		parent = newParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OCL_EXPRESSION_AS__PARENT, oldParent, parent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfExpAS getIfExpAS() {
		if (ifExpAS != null && ifExpAS.eIsProxy()) {
			InternalEObject oldIfExpAS = (InternalEObject)ifExpAS;
			ifExpAS = (IfExpAS)eResolveProxy(oldIfExpAS);
			if (ifExpAS != oldIfExpAS) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.OCL_EXPRESSION_AS__IF_EXP_AS, oldIfExpAS, ifExpAS));
			}
		}
		return ifExpAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfExpAS basicGetIfExpAS() {
		return ifExpAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIfExpAS(IfExpAS newIfExpAS, NotificationChain msgs) {
		IfExpAS oldIfExpAS = ifExpAS;
		ifExpAS = newIfExpAS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OCL_EXPRESSION_AS__IF_EXP_AS, oldIfExpAS, newIfExpAS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIfExpAS(IfExpAS newIfExpAS) {
		if (newIfExpAS != ifExpAS) {
			NotificationChain msgs = null;
			if (ifExpAS != null)
				msgs = ((InternalEObject)ifExpAS).eInverseRemove(this, ExpressionsPackage.IF_EXP_AS__ELSE_EXPRESSION, IfExpAS.class, msgs);
			if (newIfExpAS != null)
				msgs = ((InternalEObject)newIfExpAS).eInverseAdd(this, ExpressionsPackage.IF_EXP_AS__ELSE_EXPRESSION, IfExpAS.class, msgs);
			msgs = basicSetIfExpAS(newIfExpAS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OCL_EXPRESSION_AS__IF_EXP_AS, newIfExpAS, newIfExpAS));
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionsPackage.OCL_EXPRESSION_AS__IF_EXP_AS:
				if (ifExpAS != null)
					msgs = ((InternalEObject)ifExpAS).eInverseRemove(this, ExpressionsPackage.IF_EXP_AS__ELSE_EXPRESSION, IfExpAS.class, msgs);
				return basicSetIfExpAS((IfExpAS)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionsPackage.OCL_EXPRESSION_AS__IF_EXP_AS:
				return basicSetIfExpAS(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExpressionsPackage.OCL_EXPRESSION_AS__IS_MARKED_PRE:
				return getIsMarkedPre();
			case ExpressionsPackage.OCL_EXPRESSION_AS__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case ExpressionsPackage.OCL_EXPRESSION_AS__IF_EXP_AS:
				if (resolve) return getIfExpAS();
				return basicGetIfExpAS();
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
			case ExpressionsPackage.OCL_EXPRESSION_AS__IS_MARKED_PRE:
				setIsMarkedPre((Boolean)newValue);
				return;
			case ExpressionsPackage.OCL_EXPRESSION_AS__PARENT:
				setParent((OclExpressionAS)newValue);
				return;
			case ExpressionsPackage.OCL_EXPRESSION_AS__IF_EXP_AS:
				setIfExpAS((IfExpAS)newValue);
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
			case ExpressionsPackage.OCL_EXPRESSION_AS__IS_MARKED_PRE:
				setIsMarkedPre(IS_MARKED_PRE_EDEFAULT);
				return;
			case ExpressionsPackage.OCL_EXPRESSION_AS__PARENT:
				setParent((OclExpressionAS)null);
				return;
			case ExpressionsPackage.OCL_EXPRESSION_AS__IF_EXP_AS:
				setIfExpAS((IfExpAS)null);
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
			case ExpressionsPackage.OCL_EXPRESSION_AS__IS_MARKED_PRE:
				return IS_MARKED_PRE_EDEFAULT == null ? isMarkedPre != null : !IS_MARKED_PRE_EDEFAULT.equals(isMarkedPre);
			case ExpressionsPackage.OCL_EXPRESSION_AS__PARENT:
				return parent != null;
			case ExpressionsPackage.OCL_EXPRESSION_AS__IF_EXP_AS:
				return ifExpAS != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isMarkedPre: ");
		result.append(isMarkedPre);
		result.append(')');
		return result.toString();
	}

} //OclExpressionASImpl
