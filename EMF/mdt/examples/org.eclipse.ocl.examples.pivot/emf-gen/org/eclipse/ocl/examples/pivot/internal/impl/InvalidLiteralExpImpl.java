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
 * $Id: InvalidLiteralExpImpl.java,v 1.2 2011/01/24 20:42:33 ewillink Exp $
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
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invalid Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.InvalidLiteralExpImpl#getObject <em>Object</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.InvalidLiteralExpImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.InvalidLiteralExpImpl#getReason <em>Reason</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.InvalidLiteralExpImpl#getThrowable <em>Throwable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InvalidLiteralExpImpl
		extends LiteralExpImpl
		implements InvalidLiteralExp {

	/**
	 * The default value of the '{@link #getObject() <em>Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObject()
	 * @generated
	 * @ordered
	 */
	protected static final Object OBJECT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getObject() <em>Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObject()
	 * @generated
	 * @ordered
	 */
	protected Object object = OBJECT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected OclExpression expression;

	/**
	 * The default value of the '{@link #getReason() <em>Reason</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReason()
	 * @generated
	 * @ordered
	 */
	protected static final String REASON_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReason() <em>Reason</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReason()
	 * @generated
	 * @ordered
	 */
	protected String reason = REASON_EDEFAULT;

	/**
	 * The default value of the '{@link #getThrowable() <em>Throwable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThrowable()
	 * @generated
	 * @ordered
	 */
	protected static final Throwable THROWABLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getThrowable() <em>Throwable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThrowable()
	 * @generated
	 * @ordered
	 */
	protected Throwable throwable = THROWABLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InvalidLiteralExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.INVALID_LITERAL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getObject() {
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObject(Object newObject) {
		Object oldObject = object;
		object = newObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.INVALID_LITERAL_EXP__OBJECT, oldObject, object));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression getExpression() {
		if (expression != null && ((EObject)expression).eIsProxy())
		{
			InternalEObject oldExpression = (InternalEObject)expression;
			expression = (OclExpression)eResolveProxy(oldExpression);
			if (expression != oldExpression)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.INVALID_LITERAL_EXP__EXPRESSION, oldExpression, expression));
			}
		}
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression basicGetExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(OclExpression newExpression) {
		OclExpression oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.INVALID_LITERAL_EXP__EXPRESSION, oldExpression, expression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReason(String newReason) {
		String oldReason = reason;
		reason = newReason;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.INVALID_LITERAL_EXP__REASON, oldReason, reason));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Throwable getThrowable() {
		return throwable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThrowable(Throwable newThrowable) {
		Throwable oldThrowable = throwable;
		throwable = newThrowable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.INVALID_LITERAL_EXP__THROWABLE, oldThrowable, throwable));
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
			case PivotPackage.INVALID_LITERAL_EXP__OWNED_COMMENT:
				return getOwnedComments();
			case PivotPackage.INVALID_LITERAL_EXP__MONIKER:
				return getMoniker();
			case PivotPackage.INVALID_LITERAL_EXP__NAME:
				return getName();
			case PivotPackage.INVALID_LITERAL_EXP__OWNED_RULE:
				return getOwnedRules();
			case PivotPackage.INVALID_LITERAL_EXP__IS_STATIC:
				return isStatic();
			case PivotPackage.INVALID_LITERAL_EXP__OWNED_ANNOTATION:
				return getOwnedAnnotations();
			case PivotPackage.INVALID_LITERAL_EXP__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.INVALID_LITERAL_EXP__OBJECT:
				return getObject();
			case PivotPackage.INVALID_LITERAL_EXP__EXPRESSION:
				if (resolve) return getExpression();
				return basicGetExpression();
			case PivotPackage.INVALID_LITERAL_EXP__REASON:
				return getReason();
			case PivotPackage.INVALID_LITERAL_EXP__THROWABLE:
				return getThrowable();
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
			case PivotPackage.INVALID_LITERAL_EXP__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.INVALID_LITERAL_EXP__MONIKER:
				setMoniker((String)newValue);
				return;
			case PivotPackage.INVALID_LITERAL_EXP__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.INVALID_LITERAL_EXP__OWNED_RULE:
				getOwnedRules().clear();
				getOwnedRules().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.INVALID_LITERAL_EXP__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.INVALID_LITERAL_EXP__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case PivotPackage.INVALID_LITERAL_EXP__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.INVALID_LITERAL_EXP__OBJECT:
				setObject(newValue);
				return;
			case PivotPackage.INVALID_LITERAL_EXP__EXPRESSION:
				setExpression((OclExpression)newValue);
				return;
			case PivotPackage.INVALID_LITERAL_EXP__REASON:
				setReason((String)newValue);
				return;
			case PivotPackage.INVALID_LITERAL_EXP__THROWABLE:
				setThrowable((Throwable)newValue);
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
			case PivotPackage.INVALID_LITERAL_EXP__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case PivotPackage.INVALID_LITERAL_EXP__MONIKER:
				setMoniker(MONIKER_EDEFAULT);
				return;
			case PivotPackage.INVALID_LITERAL_EXP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.INVALID_LITERAL_EXP__OWNED_RULE:
				getOwnedRules().clear();
				return;
			case PivotPackage.INVALID_LITERAL_EXP__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.INVALID_LITERAL_EXP__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.INVALID_LITERAL_EXP__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.INVALID_LITERAL_EXP__OBJECT:
				setObject(OBJECT_EDEFAULT);
				return;
			case PivotPackage.INVALID_LITERAL_EXP__EXPRESSION:
				setExpression((OclExpression)null);
				return;
			case PivotPackage.INVALID_LITERAL_EXP__REASON:
				setReason(REASON_EDEFAULT);
				return;
			case PivotPackage.INVALID_LITERAL_EXP__THROWABLE:
				setThrowable(THROWABLE_EDEFAULT);
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
			case PivotPackage.INVALID_LITERAL_EXP__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.INVALID_LITERAL_EXP__MONIKER:
				return MONIKER_EDEFAULT == null ? getMoniker() != null : !MONIKER_EDEFAULT.equals(getMoniker());
			case PivotPackage.INVALID_LITERAL_EXP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.INVALID_LITERAL_EXP__OWNED_RULE:
				return ownedRules != null && !ownedRules.isEmpty();
			case PivotPackage.INVALID_LITERAL_EXP__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.INVALID_LITERAL_EXP__OWNED_ANNOTATION:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.INVALID_LITERAL_EXP__TYPE:
				return type != null;
			case PivotPackage.INVALID_LITERAL_EXP__OBJECT:
				return OBJECT_EDEFAULT == null ? object != null : !OBJECT_EDEFAULT.equals(object);
			case PivotPackage.INVALID_LITERAL_EXP__EXPRESSION:
				return expression != null;
			case PivotPackage.INVALID_LITERAL_EXP__REASON:
				return REASON_EDEFAULT == null ? reason != null : !REASON_EDEFAULT.equals(reason);
			case PivotPackage.INVALID_LITERAL_EXP__THROWABLE:
				return THROWABLE_EDEFAULT == null ? throwable != null : !THROWABLE_EDEFAULT.equals(throwable);
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public <R, C> R accept(Visitor<R, C> visitor) {
		return visitor.visitInvalidLiteralExp(this);
	}
} //InvalidLiteralExpImpl
