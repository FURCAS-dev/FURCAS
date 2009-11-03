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

import org.oslo.ocl20.semantics.OclVisitor;

import org.oslo.ocl20.semantics.bridge.Classifier;

import org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage;
import org.oslo.ocl20.semantics.model.expressions.TypeLiteralExp;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Type Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.impl.TypeLiteralExpImpl#getLiteralType <em>
 * Literal Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class TypeLiteralExpImpl extends LiteralExpImpl implements TypeLiteralExp {
	/**
	 * The cached value of the '{@link #getLiteralType() <em>Literal Type</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLiteralType()
	 * @generated
	 * @ordered
	 */
	protected Classifier literalType;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected TypeLiteralExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.TYPE_LITERAL_EXP;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Classifier getLiteralType() {
		if (literalType != null && literalType.eIsProxy()) {
			InternalEObject oldLiteralType = (InternalEObject) literalType;
			literalType = (Classifier) eResolveProxy(oldLiteralType);
			if (literalType != oldLiteralType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
					    ExpressionsPackage.TYPE_LITERAL_EXP__LITERAL_TYPE, oldLiteralType, literalType));
			}
		}
		return literalType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Classifier basicGetLiteralType() {
		return literalType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLiteralType(Classifier newLiteralType) {
		Classifier oldLiteralType = literalType;
		literalType = newLiteralType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.TYPE_LITERAL_EXP__LITERAL_TYPE,
			    oldLiteralType, literalType));
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExpressionsPackage.TYPE_LITERAL_EXP__LITERAL_TYPE:
				if (resolve)
					return getLiteralType();
				return basicGetLiteralType();
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
			case ExpressionsPackage.TYPE_LITERAL_EXP__LITERAL_TYPE:
				setLiteralType((Classifier) newValue);
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
			case ExpressionsPackage.TYPE_LITERAL_EXP__LITERAL_TYPE:
				setLiteralType((Classifier) null);
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
			case ExpressionsPackage.TYPE_LITERAL_EXP__LITERAL_TYPE:
				return literalType != null;
		}
		return super.eIsSet(featureID);
	}

} // TypeLiteralExpImpl
