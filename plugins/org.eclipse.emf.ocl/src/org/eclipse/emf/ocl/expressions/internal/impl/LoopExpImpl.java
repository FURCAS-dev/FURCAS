/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
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
 * $Id$
 */

package org.eclipse.emf.ocl.expressions.internal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.ocl.expressions.ExpressionsPackage;
import org.eclipse.emf.ocl.expressions.LoopExp;
import org.eclipse.emf.ocl.expressions.OclExpression;
import org.eclipse.emf.ocl.expressions.OperationCallExp;
import org.eclipse.emf.ocl.expressions.PropertyCallExp;
import org.eclipse.emf.ocl.expressions.VariableDeclaration;
import org.eclipse.emf.ocl.expressions.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.expressions.internal.impl.LoopExpImpl#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.expressions.internal.impl.LoopExpImpl#getIterators <em>Iterators</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoopExpImpl extends PropertyCallExpImpl implements LoopExp {
	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected OclExpression body = null;

	/**
	 * The cached value of the '{@link #getIterators() <em>Iterators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterators()
	 * @generated
	 * @ordered
	 */
	protected EList iterators = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoopExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ExpressionsPackage.eINSTANCE.getLoopExp();
	}

	public Object accept(Visitor v) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression getBody() {
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBody(OclExpression newBody, NotificationChain msgs) {
		OclExpression oldBody = body;
		body = newBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.LOOP_EXP__BODY, oldBody, newBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBody(OclExpression newBody) {
		if (newBody != body) {
			NotificationChain msgs = null;
			if (body != null)
				msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.LOOP_EXP__BODY, null, msgs);
			if (newBody != null)
				msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.LOOP_EXP__BODY, null, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.LOOP_EXP__BODY, newBody, newBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getIterators() {
		if (iterators == null) {
			iterators = new EObjectContainmentWithInverseEList(VariableDeclaration.class, this, ExpressionsPackage.LOOP_EXP__ITERATORS, ExpressionsPackage.VARIABLE_DECLARATION__LOOP_EXPR);
		}
		return iterators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case ExpressionsPackage.LOOP_EXP__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicAdd(otherEnd, msgs);
				case ExpressionsPackage.LOOP_EXP__APPLIED_PROPERTY:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, ExpressionsPackage.LOOP_EXP__APPLIED_PROPERTY, msgs);
				case ExpressionsPackage.LOOP_EXP__INITIALIZED_VARIABLE:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, ExpressionsPackage.LOOP_EXP__INITIALIZED_VARIABLE, msgs);
				case ExpressionsPackage.LOOP_EXP__PARENT_OPERATION:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, ExpressionsPackage.LOOP_EXP__PARENT_OPERATION, msgs);
				case ExpressionsPackage.LOOP_EXP__SOURCE:
					if (source != null)
						msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.LOOP_EXP__SOURCE, null, msgs);
					return basicSetSource((OclExpression)otherEnd, msgs);
				case ExpressionsPackage.LOOP_EXP__ITERATORS:
					return ((InternalEList)getIterators()).basicAdd(otherEnd, msgs);
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
				case ExpressionsPackage.LOOP_EXP__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
				case ExpressionsPackage.LOOP_EXP__APPLIED_PROPERTY:
					return eBasicSetContainer(null, ExpressionsPackage.LOOP_EXP__APPLIED_PROPERTY, msgs);
				case ExpressionsPackage.LOOP_EXP__INITIALIZED_VARIABLE:
					return eBasicSetContainer(null, ExpressionsPackage.LOOP_EXP__INITIALIZED_VARIABLE, msgs);
				case ExpressionsPackage.LOOP_EXP__PARENT_OPERATION:
					return eBasicSetContainer(null, ExpressionsPackage.LOOP_EXP__PARENT_OPERATION, msgs);
				case ExpressionsPackage.LOOP_EXP__SOURCE:
					return basicSetSource(null, msgs);
				case ExpressionsPackage.LOOP_EXP__BODY:
					return basicSetBody(null, msgs);
				case ExpressionsPackage.LOOP_EXP__ITERATORS:
					return ((InternalEList)getIterators()).basicRemove(otherEnd, msgs);
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
				case ExpressionsPackage.LOOP_EXP__APPLIED_PROPERTY:
					return eContainer.eInverseRemove(this, ExpressionsPackage.PROPERTY_CALL_EXP__SOURCE, PropertyCallExp.class, msgs);
				case ExpressionsPackage.LOOP_EXP__INITIALIZED_VARIABLE:
					return eContainer.eInverseRemove(this, ExpressionsPackage.VARIABLE_DECLARATION__INIT_EXPRESSION, VariableDeclaration.class, msgs);
				case ExpressionsPackage.LOOP_EXP__PARENT_OPERATION:
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
			case ExpressionsPackage.LOOP_EXP__EANNOTATIONS:
				return getEAnnotations();
			case ExpressionsPackage.LOOP_EXP__NAME:
				return getName();
			case ExpressionsPackage.LOOP_EXP__START_POSITION:
				return new Integer(getStartPosition());
			case ExpressionsPackage.LOOP_EXP__END_POSITION:
				return new Integer(getEndPosition());
			case ExpressionsPackage.LOOP_EXP__APPLIED_PROPERTY:
				return getAppliedProperty();
			case ExpressionsPackage.LOOP_EXP__INITIALIZED_VARIABLE:
				return getInitializedVariable();
			case ExpressionsPackage.LOOP_EXP__PARENT_OPERATION:
				return getParentOperation();
			case ExpressionsPackage.LOOP_EXP__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case ExpressionsPackage.LOOP_EXP__PROPERTY_START_POSITION:
				return new Integer(getPropertyStartPosition());
			case ExpressionsPackage.LOOP_EXP__PROPERTY_END_POSITION:
				return new Integer(getPropertyEndPosition());
			case ExpressionsPackage.LOOP_EXP__SOURCE:
				return getSource();
			case ExpressionsPackage.LOOP_EXP__BODY:
				return getBody();
			case ExpressionsPackage.LOOP_EXP__ITERATORS:
				return getIterators();
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
			case ExpressionsPackage.LOOP_EXP__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case ExpressionsPackage.LOOP_EXP__NAME:
				setName((String)newValue);
				return;
			case ExpressionsPackage.LOOP_EXP__START_POSITION:
				setStartPosition(((Integer)newValue).intValue());
				return;
			case ExpressionsPackage.LOOP_EXP__END_POSITION:
				setEndPosition(((Integer)newValue).intValue());
				return;
			case ExpressionsPackage.LOOP_EXP__APPLIED_PROPERTY:
				setAppliedProperty((PropertyCallExp)newValue);
				return;
			case ExpressionsPackage.LOOP_EXP__INITIALIZED_VARIABLE:
				setInitializedVariable((VariableDeclaration)newValue);
				return;
			case ExpressionsPackage.LOOP_EXP__PARENT_OPERATION:
				setParentOperation((OperationCallExp)newValue);
				return;
			case ExpressionsPackage.LOOP_EXP__TYPE:
				setType((EClassifier)newValue);
				return;
			case ExpressionsPackage.LOOP_EXP__PROPERTY_START_POSITION:
				setPropertyStartPosition(((Integer)newValue).intValue());
				return;
			case ExpressionsPackage.LOOP_EXP__PROPERTY_END_POSITION:
				setPropertyEndPosition(((Integer)newValue).intValue());
				return;
			case ExpressionsPackage.LOOP_EXP__SOURCE:
				setSource((OclExpression)newValue);
				return;
			case ExpressionsPackage.LOOP_EXP__BODY:
				setBody((OclExpression)newValue);
				return;
			case ExpressionsPackage.LOOP_EXP__ITERATORS:
				getIterators().clear();
				getIterators().addAll((Collection)newValue);
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
			case ExpressionsPackage.LOOP_EXP__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case ExpressionsPackage.LOOP_EXP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ExpressionsPackage.LOOP_EXP__START_POSITION:
				setStartPosition(START_POSITION_EDEFAULT);
				return;
			case ExpressionsPackage.LOOP_EXP__END_POSITION:
				setEndPosition(END_POSITION_EDEFAULT);
				return;
			case ExpressionsPackage.LOOP_EXP__APPLIED_PROPERTY:
				setAppliedProperty((PropertyCallExp)null);
				return;
			case ExpressionsPackage.LOOP_EXP__INITIALIZED_VARIABLE:
				setInitializedVariable((VariableDeclaration)null);
				return;
			case ExpressionsPackage.LOOP_EXP__PARENT_OPERATION:
				setParentOperation((OperationCallExp)null);
				return;
			case ExpressionsPackage.LOOP_EXP__TYPE:
				setType((EClassifier)null);
				return;
			case ExpressionsPackage.LOOP_EXP__PROPERTY_START_POSITION:
				setPropertyStartPosition(PROPERTY_START_POSITION_EDEFAULT);
				return;
			case ExpressionsPackage.LOOP_EXP__PROPERTY_END_POSITION:
				setPropertyEndPosition(PROPERTY_END_POSITION_EDEFAULT);
				return;
			case ExpressionsPackage.LOOP_EXP__SOURCE:
				setSource((OclExpression)null);
				return;
			case ExpressionsPackage.LOOP_EXP__BODY:
				setBody((OclExpression)null);
				return;
			case ExpressionsPackage.LOOP_EXP__ITERATORS:
				getIterators().clear();
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
			case ExpressionsPackage.LOOP_EXP__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case ExpressionsPackage.LOOP_EXP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ExpressionsPackage.LOOP_EXP__START_POSITION:
				return startPosition != START_POSITION_EDEFAULT;
			case ExpressionsPackage.LOOP_EXP__END_POSITION:
				return endPosition != END_POSITION_EDEFAULT;
			case ExpressionsPackage.LOOP_EXP__APPLIED_PROPERTY:
				return getAppliedProperty() != null;
			case ExpressionsPackage.LOOP_EXP__INITIALIZED_VARIABLE:
				return getInitializedVariable() != null;
			case ExpressionsPackage.LOOP_EXP__PARENT_OPERATION:
				return getParentOperation() != null;
			case ExpressionsPackage.LOOP_EXP__TYPE:
				return type != null;
			case ExpressionsPackage.LOOP_EXP__PROPERTY_START_POSITION:
				return propertyStartPosition != PROPERTY_START_POSITION_EDEFAULT;
			case ExpressionsPackage.LOOP_EXP__PROPERTY_END_POSITION:
				return propertyEndPosition != PROPERTY_END_POSITION_EDEFAULT;
			case ExpressionsPackage.LOOP_EXP__SOURCE:
				return source != null;
			case ExpressionsPackage.LOOP_EXP__BODY:
				return body != null;
			case ExpressionsPackage.LOOP_EXP__ITERATORS:
				return iterators != null && !iterators.isEmpty();
		}
		return eDynamicIsSet(eFeature);
	}

} //LoopExpImpl
