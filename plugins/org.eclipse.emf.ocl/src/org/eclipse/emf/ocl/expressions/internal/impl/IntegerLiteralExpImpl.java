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
import org.eclipse.emf.ocl.expressions.IntegerLiteralExp;
import org.eclipse.emf.ocl.expressions.OperationCallExp;
import org.eclipse.emf.ocl.expressions.PropertyCallExp;
import org.eclipse.emf.ocl.expressions.VariableDeclaration;
import org.eclipse.emf.ocl.expressions.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Integer Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.expressions.internal.impl.IntegerLiteralExpImpl#getIntegerSymbol <em>Integer Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IntegerLiteralExpImpl extends NumericLiteralExpImpl implements IntegerLiteralExp {
	/**
	 * The default value of the '{@link #getIntegerSymbol() <em>Integer Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntegerSymbol()
	 * @generated
	 * @ordered
	 */
	protected static final Integer INTEGER_SYMBOL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIntegerSymbol() <em>Integer Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntegerSymbol()
	 * @generated
	 * @ordered
	 */
	protected Integer integerSymbol = INTEGER_SYMBOL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntegerLiteralExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ExpressionsPackage.eINSTANCE.getIntegerLiteralExp();
	}

	public Object accept(Visitor v) {
		return v.visitIntegerLiteralExp(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getIntegerSymbol() {
		return integerSymbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntegerSymbol(Integer newIntegerSymbol) {
		Integer oldIntegerSymbol = integerSymbol;
		integerSymbol = newIntegerSymbol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.INTEGER_LITERAL_EXP__INTEGER_SYMBOL, oldIntegerSymbol, integerSymbol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case ExpressionsPackage.INTEGER_LITERAL_EXP__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicAdd(otherEnd, msgs);
				case ExpressionsPackage.INTEGER_LITERAL_EXP__APPLIED_PROPERTY:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, ExpressionsPackage.INTEGER_LITERAL_EXP__APPLIED_PROPERTY, msgs);
				case ExpressionsPackage.INTEGER_LITERAL_EXP__INITIALIZED_VARIABLE:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, ExpressionsPackage.INTEGER_LITERAL_EXP__INITIALIZED_VARIABLE, msgs);
				case ExpressionsPackage.INTEGER_LITERAL_EXP__PARENT_OPERATION:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, ExpressionsPackage.INTEGER_LITERAL_EXP__PARENT_OPERATION, msgs);
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
				case ExpressionsPackage.INTEGER_LITERAL_EXP__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
				case ExpressionsPackage.INTEGER_LITERAL_EXP__APPLIED_PROPERTY:
					return eBasicSetContainer(null, ExpressionsPackage.INTEGER_LITERAL_EXP__APPLIED_PROPERTY, msgs);
				case ExpressionsPackage.INTEGER_LITERAL_EXP__INITIALIZED_VARIABLE:
					return eBasicSetContainer(null, ExpressionsPackage.INTEGER_LITERAL_EXP__INITIALIZED_VARIABLE, msgs);
				case ExpressionsPackage.INTEGER_LITERAL_EXP__PARENT_OPERATION:
					return eBasicSetContainer(null, ExpressionsPackage.INTEGER_LITERAL_EXP__PARENT_OPERATION, msgs);
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
				case ExpressionsPackage.INTEGER_LITERAL_EXP__APPLIED_PROPERTY:
					return eContainer.eInverseRemove(this, ExpressionsPackage.PROPERTY_CALL_EXP__SOURCE, PropertyCallExp.class, msgs);
				case ExpressionsPackage.INTEGER_LITERAL_EXP__INITIALIZED_VARIABLE:
					return eContainer.eInverseRemove(this, ExpressionsPackage.VARIABLE_DECLARATION__INIT_EXPRESSION, VariableDeclaration.class, msgs);
				case ExpressionsPackage.INTEGER_LITERAL_EXP__PARENT_OPERATION:
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
			case ExpressionsPackage.INTEGER_LITERAL_EXP__EANNOTATIONS:
				return getEAnnotations();
			case ExpressionsPackage.INTEGER_LITERAL_EXP__NAME:
				return getName();
			case ExpressionsPackage.INTEGER_LITERAL_EXP__START_POSITION:
				return new Integer(getStartPosition());
			case ExpressionsPackage.INTEGER_LITERAL_EXP__END_POSITION:
				return new Integer(getEndPosition());
			case ExpressionsPackage.INTEGER_LITERAL_EXP__APPLIED_PROPERTY:
				return getAppliedProperty();
			case ExpressionsPackage.INTEGER_LITERAL_EXP__INITIALIZED_VARIABLE:
				return getInitializedVariable();
			case ExpressionsPackage.INTEGER_LITERAL_EXP__PARENT_OPERATION:
				return getParentOperation();
			case ExpressionsPackage.INTEGER_LITERAL_EXP__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case ExpressionsPackage.INTEGER_LITERAL_EXP__INTEGER_SYMBOL:
				return getIntegerSymbol();
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
			case ExpressionsPackage.INTEGER_LITERAL_EXP__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case ExpressionsPackage.INTEGER_LITERAL_EXP__NAME:
				setName((String)newValue);
				return;
			case ExpressionsPackage.INTEGER_LITERAL_EXP__START_POSITION:
				setStartPosition(((Integer)newValue).intValue());
				return;
			case ExpressionsPackage.INTEGER_LITERAL_EXP__END_POSITION:
				setEndPosition(((Integer)newValue).intValue());
				return;
			case ExpressionsPackage.INTEGER_LITERAL_EXP__APPLIED_PROPERTY:
				setAppliedProperty((PropertyCallExp)newValue);
				return;
			case ExpressionsPackage.INTEGER_LITERAL_EXP__INITIALIZED_VARIABLE:
				setInitializedVariable((VariableDeclaration)newValue);
				return;
			case ExpressionsPackage.INTEGER_LITERAL_EXP__PARENT_OPERATION:
				setParentOperation((OperationCallExp)newValue);
				return;
			case ExpressionsPackage.INTEGER_LITERAL_EXP__TYPE:
				setType((EClassifier)newValue);
				return;
			case ExpressionsPackage.INTEGER_LITERAL_EXP__INTEGER_SYMBOL:
				setIntegerSymbol((Integer)newValue);
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
			case ExpressionsPackage.INTEGER_LITERAL_EXP__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case ExpressionsPackage.INTEGER_LITERAL_EXP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ExpressionsPackage.INTEGER_LITERAL_EXP__START_POSITION:
				setStartPosition(START_POSITION_EDEFAULT);
				return;
			case ExpressionsPackage.INTEGER_LITERAL_EXP__END_POSITION:
				setEndPosition(END_POSITION_EDEFAULT);
				return;
			case ExpressionsPackage.INTEGER_LITERAL_EXP__APPLIED_PROPERTY:
				setAppliedProperty((PropertyCallExp)null);
				return;
			case ExpressionsPackage.INTEGER_LITERAL_EXP__INITIALIZED_VARIABLE:
				setInitializedVariable((VariableDeclaration)null);
				return;
			case ExpressionsPackage.INTEGER_LITERAL_EXP__PARENT_OPERATION:
				setParentOperation((OperationCallExp)null);
				return;
			case ExpressionsPackage.INTEGER_LITERAL_EXP__TYPE:
				setType((EClassifier)null);
				return;
			case ExpressionsPackage.INTEGER_LITERAL_EXP__INTEGER_SYMBOL:
				setIntegerSymbol(INTEGER_SYMBOL_EDEFAULT);
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
			case ExpressionsPackage.INTEGER_LITERAL_EXP__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case ExpressionsPackage.INTEGER_LITERAL_EXP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ExpressionsPackage.INTEGER_LITERAL_EXP__START_POSITION:
				return startPosition != START_POSITION_EDEFAULT;
			case ExpressionsPackage.INTEGER_LITERAL_EXP__END_POSITION:
				return endPosition != END_POSITION_EDEFAULT;
			case ExpressionsPackage.INTEGER_LITERAL_EXP__APPLIED_PROPERTY:
				return getAppliedProperty() != null;
			case ExpressionsPackage.INTEGER_LITERAL_EXP__INITIALIZED_VARIABLE:
				return getInitializedVariable() != null;
			case ExpressionsPackage.INTEGER_LITERAL_EXP__PARENT_OPERATION:
				return getParentOperation() != null;
			case ExpressionsPackage.INTEGER_LITERAL_EXP__TYPE:
				return type != null;
			case ExpressionsPackage.INTEGER_LITERAL_EXP__INTEGER_SYMBOL:
				return INTEGER_SYMBOL_EDEFAULT == null ? integerSymbol != null : !INTEGER_SYMBOL_EDEFAULT.equals(integerSymbol);
		}
		return eDynamicIsSet(eFeature);
	}

	/**
	 * @generated NOT
	 */
	public String toString() {
		return ToStringVisitorImpl.toString(this);
	}

} //IntegerLiteralExpImpl
