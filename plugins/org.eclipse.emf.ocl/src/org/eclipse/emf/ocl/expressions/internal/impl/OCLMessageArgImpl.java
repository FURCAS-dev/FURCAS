/**
 * <copyright>
 *
 * Copyright (c) 2005, 2006 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: OCLMessageArgImpl.java,v 1.1 2006/02/13 16:11:57 cdamus Exp $
 */
package org.eclipse.emf.ocl.expressions.internal.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENamedElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ocl.expressions.ExpressionsPackage;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.OCLMessageArg;
import org.eclipse.emf.ocl.expressions.UnspecifiedValueExp;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>OCL Message Arg</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.expressions.internal.impl.OCLMessageArgImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.expressions.internal.impl.OCLMessageArgImpl#getUnspecified <em>Unspecified</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OCLMessageArgImpl extends ENamedElementImpl implements OCLMessageArg {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = ""; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression expression = null;

	/**
	 * The cached value of the '{@link #getUnspecified() <em>Unspecified</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnspecified()
	 * @generated
	 * @ordered
	 */
	protected UnspecifiedValueExp unspecified = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OCLMessageArgImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.OCL_MESSAGE_ARG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression getExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpression(OCLExpression newExpression, NotificationChain msgs) {
		OCLExpression oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OCL_MESSAGE_ARG__EXPRESSION, oldExpression, newExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(OCLExpression newExpression) {
		if (newExpression != expression) {
			NotificationChain msgs = null;
			if (expression != null)
				msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.OCL_MESSAGE_ARG__EXPRESSION, null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.OCL_MESSAGE_ARG__EXPRESSION, null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OCL_MESSAGE_ARG__EXPRESSION, newExpression, newExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnspecifiedValueExp getUnspecified() {
		return unspecified;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnspecified(UnspecifiedValueExp newUnspecified, NotificationChain msgs) {
		UnspecifiedValueExp oldUnspecified = unspecified;
		unspecified = newUnspecified;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OCL_MESSAGE_ARG__UNSPECIFIED, oldUnspecified, newUnspecified);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnspecified(UnspecifiedValueExp newUnspecified) {
		if (newUnspecified != unspecified) {
			NotificationChain msgs = null;
			if (unspecified != null)
				msgs = ((InternalEObject)unspecified).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.OCL_MESSAGE_ARG__UNSPECIFIED, null, msgs);
			if (newUnspecified != null)
				msgs = ((InternalEObject)newUnspecified).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.OCL_MESSAGE_ARG__UNSPECIFIED, null, msgs);
			msgs = basicSetUnspecified(newUnspecified, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OCL_MESSAGE_ARG__UNSPECIFIED, newUnspecified, newUnspecified));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionsPackage.OCL_MESSAGE_ARG__EXPRESSION:
				return basicSetExpression(null, msgs);
			case ExpressionsPackage.OCL_MESSAGE_ARG__UNSPECIFIED:
				return basicSetUnspecified(null, msgs);
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
			case ExpressionsPackage.OCL_MESSAGE_ARG__EXPRESSION:
				return getExpression();
			case ExpressionsPackage.OCL_MESSAGE_ARG__UNSPECIFIED:
				return getUnspecified();
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
			case ExpressionsPackage.OCL_MESSAGE_ARG__EXPRESSION:
				setExpression((OCLExpression)newValue);
				return;
			case ExpressionsPackage.OCL_MESSAGE_ARG__UNSPECIFIED:
				setUnspecified((UnspecifiedValueExp)newValue);
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
			case ExpressionsPackage.OCL_MESSAGE_ARG__EXPRESSION:
				setExpression((OCLExpression)null);
				return;
			case ExpressionsPackage.OCL_MESSAGE_ARG__UNSPECIFIED:
				setUnspecified((UnspecifiedValueExp)null);
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
			case ExpressionsPackage.OCL_MESSAGE_ARG__EXPRESSION:
				return expression != null;
			case ExpressionsPackage.OCL_MESSAGE_ARG__UNSPECIFIED:
				return unspecified != null;
		}
		return super.eIsSet(featureID);
	}

} //OCLMessageArgImpl
