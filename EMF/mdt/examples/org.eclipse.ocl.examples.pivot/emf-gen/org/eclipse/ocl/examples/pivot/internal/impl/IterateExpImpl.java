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
 * $Id: IterateExpImpl.java,v 1.2 2011/01/24 20:42:32 ewillink Exp $
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
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iterate Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.IterateExpImpl#getResult <em>Result</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IterateExpImpl extends LoopExpImpl implements IterateExp
{
	/**
	 * The cached value of the '{@link #getResult() <em>Result</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected Variable result;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IterateExpImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return PivotPackage.Literals.ITERATE_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getResult()
	{
		if (result != null && ((EObject)result).eIsProxy())
		{
			InternalEObject oldResult = (InternalEObject)result;
			result = (Variable)eResolveProxy(oldResult);
			if (result != oldResult)
			{
				InternalEObject newResult = (InternalEObject)result;
				NotificationChain msgs = oldResult.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.ITERATE_EXP__RESULT, null, null);
				if (newResult.eInternalContainer() == null)
				{
					msgs = newResult.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.ITERATE_EXP__RESULT, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.ITERATE_EXP__RESULT, oldResult, result));
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetResult()
	{
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResult(Variable newResult, NotificationChain msgs)
	{
		Variable oldResult = result;
		result = newResult;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.ITERATE_EXP__RESULT, oldResult, newResult);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResult(Variable newResult)
	{
		if (newResult != result)
		{
			NotificationChain msgs = null;
			if (result != null)
				msgs = ((InternalEObject)result).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.ITERATE_EXP__RESULT, null, msgs);
			if (newResult != null)
				msgs = ((InternalEObject)newResult).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.ITERATE_EXP__RESULT, null, msgs);
			msgs = basicSetResult(newResult, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.ITERATE_EXP__RESULT, newResult, newResult));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable createResult()
	{
		Variable newResult = (Variable) create(PivotPackage.Literals.VARIABLE);
		setResult(newResult);
		return newResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case PivotPackage.ITERATE_EXP__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.ITERATE_EXP__OWNED_RULE:
				return ((InternalEList<?>)getOwnedRules()).basicRemove(otherEnd, msgs);
			case PivotPackage.ITERATE_EXP__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotations()).basicRemove(otherEnd, msgs);
			case PivotPackage.ITERATE_EXP__SOURCE:
				return basicSetSource(null, msgs);
			case PivotPackage.ITERATE_EXP__BODY:
				return basicSetBody(null, msgs);
			case PivotPackage.ITERATE_EXP__ITERATOR:
				return ((InternalEList<?>)getIterators()).basicRemove(otherEnd, msgs);
			case PivotPackage.ITERATE_EXP__RESULT:
				return basicSetResult(null, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case PivotPackage.ITERATE_EXP__OWNED_COMMENT:
				return getOwnedComments();
			case PivotPackage.ITERATE_EXP__MONIKER:
				return getMoniker();
			case PivotPackage.ITERATE_EXP__NAME:
				return getName();
			case PivotPackage.ITERATE_EXP__OWNED_RULE:
				return getOwnedRules();
			case PivotPackage.ITERATE_EXP__IS_STATIC:
				return isStatic();
			case PivotPackage.ITERATE_EXP__OWNED_ANNOTATION:
				return getOwnedAnnotations();
			case PivotPackage.ITERATE_EXP__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.ITERATE_EXP__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case PivotPackage.ITERATE_EXP__IMPLICIT:
				return isImplicit();
			case PivotPackage.ITERATE_EXP__REFERRED_FEATURE:
				return getReferredFeature();
			case PivotPackage.ITERATE_EXP__BODY:
				if (resolve) return getBody();
				return basicGetBody();
			case PivotPackage.ITERATE_EXP__ITERATOR:
				return getIterators();
			case PivotPackage.ITERATE_EXP__REFERRED_ITERATION:
				if (resolve) return getReferredIteration();
				return basicGetReferredIteration();
			case PivotPackage.ITERATE_EXP__RESULT:
				if (resolve) return getResult();
				return basicGetResult();
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
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case PivotPackage.ITERATE_EXP__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.ITERATE_EXP__MONIKER:
				setMoniker((String)newValue);
				return;
			case PivotPackage.ITERATE_EXP__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.ITERATE_EXP__OWNED_RULE:
				getOwnedRules().clear();
				getOwnedRules().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.ITERATE_EXP__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.ITERATE_EXP__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case PivotPackage.ITERATE_EXP__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.ITERATE_EXP__SOURCE:
				setSource((OclExpression)newValue);
				return;
			case PivotPackage.ITERATE_EXP__IMPLICIT:
				setImplicit((Boolean)newValue);
				return;
			case PivotPackage.ITERATE_EXP__BODY:
				setBody((OclExpression)newValue);
				return;
			case PivotPackage.ITERATE_EXP__ITERATOR:
				getIterators().clear();
				getIterators().addAll((Collection<? extends Variable>)newValue);
				return;
			case PivotPackage.ITERATE_EXP__REFERRED_ITERATION:
				setReferredIteration((Iteration)newValue);
				return;
			case PivotPackage.ITERATE_EXP__RESULT:
				setResult((Variable)newValue);
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
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case PivotPackage.ITERATE_EXP__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case PivotPackage.ITERATE_EXP__MONIKER:
				setMoniker(MONIKER_EDEFAULT);
				return;
			case PivotPackage.ITERATE_EXP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.ITERATE_EXP__OWNED_RULE:
				getOwnedRules().clear();
				return;
			case PivotPackage.ITERATE_EXP__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.ITERATE_EXP__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.ITERATE_EXP__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.ITERATE_EXP__SOURCE:
				setSource((OclExpression)null);
				return;
			case PivotPackage.ITERATE_EXP__IMPLICIT:
				setImplicit(IMPLICIT_EDEFAULT);
				return;
			case PivotPackage.ITERATE_EXP__BODY:
				setBody((OclExpression)null);
				return;
			case PivotPackage.ITERATE_EXP__ITERATOR:
				getIterators().clear();
				return;
			case PivotPackage.ITERATE_EXP__REFERRED_ITERATION:
				setReferredIteration((Iteration)null);
				return;
			case PivotPackage.ITERATE_EXP__RESULT:
				setResult((Variable)null);
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
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case PivotPackage.ITERATE_EXP__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.ITERATE_EXP__MONIKER:
				return MONIKER_EDEFAULT == null ? getMoniker() != null : !MONIKER_EDEFAULT.equals(getMoniker());
			case PivotPackage.ITERATE_EXP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.ITERATE_EXP__OWNED_RULE:
				return ownedRules != null && !ownedRules.isEmpty();
			case PivotPackage.ITERATE_EXP__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.ITERATE_EXP__OWNED_ANNOTATION:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.ITERATE_EXP__TYPE:
				return type != null;
			case PivotPackage.ITERATE_EXP__SOURCE:
				return source != null;
			case PivotPackage.ITERATE_EXP__IMPLICIT:
				return ((eFlags & IMPLICIT_EFLAG) != 0) != IMPLICIT_EDEFAULT;
			case PivotPackage.ITERATE_EXP__REFERRED_FEATURE:
				return getReferredFeature() != null;
			case PivotPackage.ITERATE_EXP__BODY:
				return body != null;
			case PivotPackage.ITERATE_EXP__ITERATOR:
				return iterators != null && !iterators.isEmpty();
			case PivotPackage.ITERATE_EXP__REFERRED_ITERATION:
				return referredIteration != null;
			case PivotPackage.ITERATE_EXP__RESULT:
				return result != null;
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R, C> R accept(Visitor<R, C> visitor) {
		return visitor.visitIterateExp(this);
	}

} //IterateExpImpl
