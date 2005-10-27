/******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.emf.ocl.expressions.internal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.ocl.expressions.ExpressionsPackage;
import org.eclipse.emf.ocl.expressions.IterateExp;
import org.eclipse.emf.ocl.expressions.OclExpression;
import org.eclipse.emf.ocl.expressions.OperationCallExp;
import org.eclipse.emf.ocl.expressions.PropertyCallExp;
import org.eclipse.emf.ocl.expressions.VariableDeclaration;
import org.eclipse.emf.ocl.expressions.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iterate Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.expressions.internal.impl.IterateExpImpl#getResult <em>Result</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IterateExpImpl extends LoopExpImpl implements IterateExp {
	/**
	 * The cached value of the '{@link #getResult() <em>Result</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected VariableDeclaration result = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IterateExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ExpressionsPackage.eINSTANCE.getIterateExp();
	}

	public Object accept(Visitor v) {
		return v.visitIterateExp(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration getResult() {
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResult(VariableDeclaration newResult, NotificationChain msgs) {
		VariableDeclaration oldResult = result;
		result = newResult;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.ITERATE_EXP__RESULT, oldResult, newResult);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResult(VariableDeclaration newResult) {
		if (newResult != result) {
			NotificationChain msgs = null;
			if (result != null)
				msgs = ((InternalEObject)result).eInverseRemove(this, ExpressionsPackage.VARIABLE_DECLARATION__BASE_EXP, VariableDeclaration.class, msgs);
			if (newResult != null)
				msgs = ((InternalEObject)newResult).eInverseAdd(this, ExpressionsPackage.VARIABLE_DECLARATION__BASE_EXP, VariableDeclaration.class, msgs);
			msgs = basicSetResult(newResult, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.ITERATE_EXP__RESULT, newResult, newResult));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case ExpressionsPackage.ITERATE_EXP__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicAdd(otherEnd, msgs);
				case ExpressionsPackage.ITERATE_EXP__APPLIED_PROPERTY:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, ExpressionsPackage.ITERATE_EXP__APPLIED_PROPERTY, msgs);
				case ExpressionsPackage.ITERATE_EXP__INITIALIZED_VARIABLE:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, ExpressionsPackage.ITERATE_EXP__INITIALIZED_VARIABLE, msgs);
				case ExpressionsPackage.ITERATE_EXP__PARENT_OPERATION:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, ExpressionsPackage.ITERATE_EXP__PARENT_OPERATION, msgs);
				case ExpressionsPackage.ITERATE_EXP__SOURCE:
					if (source != null)
						msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.ITERATE_EXP__SOURCE, null, msgs);
					return basicSetSource((OclExpression)otherEnd, msgs);
				case ExpressionsPackage.ITERATE_EXP__ITERATORS:
					return ((InternalEList)getIterators()).basicAdd(otherEnd, msgs);
				case ExpressionsPackage.ITERATE_EXP__RESULT:
					if (result != null)
						msgs = ((InternalEObject)result).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.ITERATE_EXP__RESULT, null, msgs);
					return basicSetResult((VariableDeclaration)otherEnd, msgs);
				default:
					return eDynamicInverseAdd(otherEnd, featureID, baseClass, msgs);
			}
		}
		if (eContainer != null)
			msgs = eBasicRemoveFromContainer(msgs);
		return eBasicSetContainer(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case ExpressionsPackage.ITERATE_EXP__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
				case ExpressionsPackage.ITERATE_EXP__APPLIED_PROPERTY:
					return eBasicSetContainer(null, ExpressionsPackage.ITERATE_EXP__APPLIED_PROPERTY, msgs);
				case ExpressionsPackage.ITERATE_EXP__INITIALIZED_VARIABLE:
					return eBasicSetContainer(null, ExpressionsPackage.ITERATE_EXP__INITIALIZED_VARIABLE, msgs);
				case ExpressionsPackage.ITERATE_EXP__PARENT_OPERATION:
					return eBasicSetContainer(null, ExpressionsPackage.ITERATE_EXP__PARENT_OPERATION, msgs);
				case ExpressionsPackage.ITERATE_EXP__SOURCE:
					return basicSetSource(null, msgs);
				case ExpressionsPackage.ITERATE_EXP__BODY:
					return basicSetBody(null, msgs);
				case ExpressionsPackage.ITERATE_EXP__ITERATORS:
					return ((InternalEList)getIterators()).basicRemove(otherEnd, msgs);
				case ExpressionsPackage.ITERATE_EXP__RESULT:
					return basicSetResult(null, msgs);
				default:
					return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
			}
		}
		return eBasicSetContainer(null, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainer(NotificationChain msgs) {
		if (eContainerFeatureID >= 0) {
			switch (eContainerFeatureID) {
				case ExpressionsPackage.ITERATE_EXP__APPLIED_PROPERTY:
					return eContainer.eInverseRemove(this, ExpressionsPackage.PROPERTY_CALL_EXP__SOURCE, PropertyCallExp.class, msgs);
				case ExpressionsPackage.ITERATE_EXP__INITIALIZED_VARIABLE:
					return eContainer.eInverseRemove(this, ExpressionsPackage.VARIABLE_DECLARATION__INIT_EXPRESSION, VariableDeclaration.class, msgs);
				case ExpressionsPackage.ITERATE_EXP__PARENT_OPERATION:
					return eContainer.eInverseRemove(this, ExpressionsPackage.OPERATION_CALL_EXP__ARGUMENTS, OperationCallExp.class, msgs);
				default:
					return eDynamicBasicRemoveFromContainer(msgs);
			}
		}
		return eContainer.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - eContainerFeatureID, null, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExpressionsPackage.ITERATE_EXP__EANNOTATIONS:
				return getEAnnotations();
			case ExpressionsPackage.ITERATE_EXP__NAME:
				return getName();
			case ExpressionsPackage.ITERATE_EXP__START_POSITION:
				return new Integer(getStartPosition());
			case ExpressionsPackage.ITERATE_EXP__END_POSITION:
				return new Integer(getEndPosition());
			case ExpressionsPackage.ITERATE_EXP__APPLIED_PROPERTY:
				return getAppliedProperty();
			case ExpressionsPackage.ITERATE_EXP__INITIALIZED_VARIABLE:
				return getInitializedVariable();
			case ExpressionsPackage.ITERATE_EXP__PARENT_OPERATION:
				return getParentOperation();
			case ExpressionsPackage.ITERATE_EXP__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case ExpressionsPackage.ITERATE_EXP__PROPERTY_START_POSITION:
				return new Integer(getPropertyStartPosition());
			case ExpressionsPackage.ITERATE_EXP__PROPERTY_END_POSITION:
				return new Integer(getPropertyEndPosition());
			case ExpressionsPackage.ITERATE_EXP__SOURCE:
				return getSource();
			case ExpressionsPackage.ITERATE_EXP__BODY:
				return getBody();
			case ExpressionsPackage.ITERATE_EXP__ITERATORS:
				return getIterators();
			case ExpressionsPackage.ITERATE_EXP__RESULT:
				return getResult();
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExpressionsPackage.ITERATE_EXP__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case ExpressionsPackage.ITERATE_EXP__NAME:
				setName((String)newValue);
				return;
			case ExpressionsPackage.ITERATE_EXP__START_POSITION:
				setStartPosition(((Integer)newValue).intValue());
				return;
			case ExpressionsPackage.ITERATE_EXP__END_POSITION:
				setEndPosition(((Integer)newValue).intValue());
				return;
			case ExpressionsPackage.ITERATE_EXP__APPLIED_PROPERTY:
				setAppliedProperty((PropertyCallExp)newValue);
				return;
			case ExpressionsPackage.ITERATE_EXP__INITIALIZED_VARIABLE:
				setInitializedVariable((VariableDeclaration)newValue);
				return;
			case ExpressionsPackage.ITERATE_EXP__PARENT_OPERATION:
				setParentOperation((OperationCallExp)newValue);
				return;
			case ExpressionsPackage.ITERATE_EXP__TYPE:
				setType((EClassifier)newValue);
				return;
			case ExpressionsPackage.ITERATE_EXP__PROPERTY_START_POSITION:
				setPropertyStartPosition(((Integer)newValue).intValue());
				return;
			case ExpressionsPackage.ITERATE_EXP__PROPERTY_END_POSITION:
				setPropertyEndPosition(((Integer)newValue).intValue());
				return;
			case ExpressionsPackage.ITERATE_EXP__SOURCE:
				setSource((OclExpression)newValue);
				return;
			case ExpressionsPackage.ITERATE_EXP__BODY:
				setBody((OclExpression)newValue);
				return;
			case ExpressionsPackage.ITERATE_EXP__ITERATORS:
				getIterators().clear();
				getIterators().addAll((Collection)newValue);
				return;
			case ExpressionsPackage.ITERATE_EXP__RESULT:
				setResult((VariableDeclaration)newValue);
				return;
		}
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExpressionsPackage.ITERATE_EXP__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case ExpressionsPackage.ITERATE_EXP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ExpressionsPackage.ITERATE_EXP__START_POSITION:
				setStartPosition(START_POSITION_EDEFAULT);
				return;
			case ExpressionsPackage.ITERATE_EXP__END_POSITION:
				setEndPosition(END_POSITION_EDEFAULT);
				return;
			case ExpressionsPackage.ITERATE_EXP__APPLIED_PROPERTY:
				setAppliedProperty((PropertyCallExp)null);
				return;
			case ExpressionsPackage.ITERATE_EXP__INITIALIZED_VARIABLE:
				setInitializedVariable((VariableDeclaration)null);
				return;
			case ExpressionsPackage.ITERATE_EXP__PARENT_OPERATION:
				setParentOperation((OperationCallExp)null);
				return;
			case ExpressionsPackage.ITERATE_EXP__TYPE:
				setType((EClassifier)null);
				return;
			case ExpressionsPackage.ITERATE_EXP__PROPERTY_START_POSITION:
				setPropertyStartPosition(PROPERTY_START_POSITION_EDEFAULT);
				return;
			case ExpressionsPackage.ITERATE_EXP__PROPERTY_END_POSITION:
				setPropertyEndPosition(PROPERTY_END_POSITION_EDEFAULT);
				return;
			case ExpressionsPackage.ITERATE_EXP__SOURCE:
				setSource((OclExpression)null);
				return;
			case ExpressionsPackage.ITERATE_EXP__BODY:
				setBody((OclExpression)null);
				return;
			case ExpressionsPackage.ITERATE_EXP__ITERATORS:
				getIterators().clear();
				return;
			case ExpressionsPackage.ITERATE_EXP__RESULT:
				setResult((VariableDeclaration)null);
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExpressionsPackage.ITERATE_EXP__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case ExpressionsPackage.ITERATE_EXP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ExpressionsPackage.ITERATE_EXP__START_POSITION:
				return startPosition != START_POSITION_EDEFAULT;
			case ExpressionsPackage.ITERATE_EXP__END_POSITION:
				return endPosition != END_POSITION_EDEFAULT;
			case ExpressionsPackage.ITERATE_EXP__APPLIED_PROPERTY:
				return getAppliedProperty() != null;
			case ExpressionsPackage.ITERATE_EXP__INITIALIZED_VARIABLE:
				return getInitializedVariable() != null;
			case ExpressionsPackage.ITERATE_EXP__PARENT_OPERATION:
				return getParentOperation() != null;
			case ExpressionsPackage.ITERATE_EXP__TYPE:
				return type != null;
			case ExpressionsPackage.ITERATE_EXP__PROPERTY_START_POSITION:
				return propertyStartPosition != PROPERTY_START_POSITION_EDEFAULT;
			case ExpressionsPackage.ITERATE_EXP__PROPERTY_END_POSITION:
				return propertyEndPosition != PROPERTY_END_POSITION_EDEFAULT;
			case ExpressionsPackage.ITERATE_EXP__SOURCE:
				return source != null;
			case ExpressionsPackage.ITERATE_EXP__BODY:
				return body != null;
			case ExpressionsPackage.ITERATE_EXP__ITERATORS:
				return iterators != null && !iterators.isEmpty();
			case ExpressionsPackage.ITERATE_EXP__RESULT:
				return result != null;
		}
		return eDynamicIsSet(eFeature);
	}

} //IterateExpImpl
