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
 * $Id: TupleLiteralPartImpl.java,v 1.2 2011/01/24 20:42:32 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.TupleLiteralPart;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tuple Literal Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.TupleLiteralPartImpl#getInitExpression <em>Init Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TupleLiteralPartImpl
		extends VariableDeclarationImpl
		implements TupleLiteralPart {

	/**
	 * The cached value of the '{@link #getInitExpression() <em>Init Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitExpression()
	 * @generated
	 * @ordered
	 */
	protected OclExpression initExpression;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TupleLiteralPartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.TUPLE_LITERAL_PART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression getInitExpression()
	{
		if (initExpression != null && ((EObject)initExpression).eIsProxy())
		{
			InternalEObject oldInitExpression = (InternalEObject)initExpression;
			initExpression = (OclExpression)eResolveProxy(oldInitExpression);
			if (initExpression != oldInitExpression)
			{
				InternalEObject newInitExpression = (InternalEObject)initExpression;
				NotificationChain msgs = oldInitExpression.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.TUPLE_LITERAL_PART__INIT_EXPRESSION, null, null);
				if (newInitExpression.eInternalContainer() == null)
				{
					msgs = newInitExpression.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.TUPLE_LITERAL_PART__INIT_EXPRESSION, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.TUPLE_LITERAL_PART__INIT_EXPRESSION, oldInitExpression, initExpression));
			}
		}
		return initExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression basicGetInitExpression()
	{
		return initExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitExpression(OclExpression newInitExpression, NotificationChain msgs)
	{
		OclExpression oldInitExpression = initExpression;
		initExpression = newInitExpression;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.TUPLE_LITERAL_PART__INIT_EXPRESSION, oldInitExpression, newInitExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitExpression(OclExpression newInitExpression)
	{
		if (newInitExpression != initExpression)
		{
			NotificationChain msgs = null;
			if (initExpression != null)
				msgs = ((InternalEObject)initExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.TUPLE_LITERAL_PART__INIT_EXPRESSION, null, msgs);
			if (newInitExpression != null)
				msgs = ((InternalEObject)newInitExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.TUPLE_LITERAL_PART__INIT_EXPRESSION, null, msgs);
			msgs = basicSetInitExpression(newInitExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.TUPLE_LITERAL_PART__INIT_EXPRESSION, newInitExpression, newInitExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression createInitExpression(EClass eClass)
	{
		OclExpression newInitExpression = (OclExpression) create(eClass);
		setInitExpression(newInitExpression);
		return newInitExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression createInitExpression()
	{
		return createInitExpression(PivotPackage.Literals.OCL_EXPRESSION);
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
			case PivotPackage.TUPLE_LITERAL_PART__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.TUPLE_LITERAL_PART__OWNED_RULE:
				return ((InternalEList<?>)getOwnedRules()).basicRemove(otherEnd, msgs);
			case PivotPackage.TUPLE_LITERAL_PART__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotations()).basicRemove(otherEnd, msgs);
			case PivotPackage.TUPLE_LITERAL_PART__INIT_EXPRESSION:
				return basicSetInitExpression(null, msgs);
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
			case PivotPackage.TUPLE_LITERAL_PART__OWNED_COMMENT:
				return getOwnedComments();
			case PivotPackage.TUPLE_LITERAL_PART__MONIKER:
				return getMoniker();
			case PivotPackage.TUPLE_LITERAL_PART__NAME:
				return getName();
			case PivotPackage.TUPLE_LITERAL_PART__OWNED_RULE:
				return getOwnedRules();
			case PivotPackage.TUPLE_LITERAL_PART__IS_STATIC:
				return isStatic();
			case PivotPackage.TUPLE_LITERAL_PART__OWNED_ANNOTATION:
				return getOwnedAnnotations();
			case PivotPackage.TUPLE_LITERAL_PART__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.TUPLE_LITERAL_PART__INIT_EXPRESSION:
				if (resolve) return getInitExpression();
				return basicGetInitExpression();
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
			case PivotPackage.TUPLE_LITERAL_PART__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.TUPLE_LITERAL_PART__MONIKER:
				setMoniker((String)newValue);
				return;
			case PivotPackage.TUPLE_LITERAL_PART__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.TUPLE_LITERAL_PART__OWNED_RULE:
				getOwnedRules().clear();
				getOwnedRules().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.TUPLE_LITERAL_PART__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.TUPLE_LITERAL_PART__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case PivotPackage.TUPLE_LITERAL_PART__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.TUPLE_LITERAL_PART__INIT_EXPRESSION:
				setInitExpression((OclExpression)newValue);
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
			case PivotPackage.TUPLE_LITERAL_PART__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case PivotPackage.TUPLE_LITERAL_PART__MONIKER:
				setMoniker(MONIKER_EDEFAULT);
				return;
			case PivotPackage.TUPLE_LITERAL_PART__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.TUPLE_LITERAL_PART__OWNED_RULE:
				getOwnedRules().clear();
				return;
			case PivotPackage.TUPLE_LITERAL_PART__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.TUPLE_LITERAL_PART__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.TUPLE_LITERAL_PART__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.TUPLE_LITERAL_PART__INIT_EXPRESSION:
				setInitExpression((OclExpression)null);
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
			case PivotPackage.TUPLE_LITERAL_PART__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.TUPLE_LITERAL_PART__MONIKER:
				return MONIKER_EDEFAULT == null ? getMoniker() != null : !MONIKER_EDEFAULT.equals(getMoniker());
			case PivotPackage.TUPLE_LITERAL_PART__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.TUPLE_LITERAL_PART__OWNED_RULE:
				return ownedRules != null && !ownedRules.isEmpty();
			case PivotPackage.TUPLE_LITERAL_PART__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.TUPLE_LITERAL_PART__OWNED_ANNOTATION:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.TUPLE_LITERAL_PART__TYPE:
				return type != null;
			case PivotPackage.TUPLE_LITERAL_PART__INIT_EXPRESSION:
				return initExpression != null;
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R, C> R accept(Visitor<R, C> visitor) {
		return visitor.visitTupleLiteralPart(this);
	}
} //TupleLiteralPartImpl
