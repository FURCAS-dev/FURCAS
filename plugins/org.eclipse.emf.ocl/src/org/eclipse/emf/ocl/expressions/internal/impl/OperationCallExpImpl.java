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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.ocl.expressions.ExpressionsPackage;
import org.eclipse.emf.ocl.expressions.OclExpression;
import org.eclipse.emf.ocl.expressions.OperationCallExp;
import org.eclipse.emf.ocl.expressions.PropertyCallExp;
import org.eclipse.emf.ocl.expressions.VariableDeclaration;
import org.eclipse.emf.ocl.expressions.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.expressions.internal.impl.OperationCallExpImpl#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.expressions.internal.impl.OperationCallExpImpl#getReferredOperation <em>Referred Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationCallExpImpl extends ModelPropertyCallExpImpl implements OperationCallExp {
	
	private int operationCode;
	
	/**
	 * The opertion code is a constant code for the operation, that can be
	 * used by an evaluator for efficiency.
	 * The operation codes are defined in PrimitiveTypeImpl, CollectionTypeImpl,
	 * and AnyTypeImpl.
	 * @return the opcode
	 */
	public int getOperationCode() {
		return operationCode;
	}
	
	
	/**
	 * The opertion code is a constant code for the operation, that can be
	 * used by an evaluator for efficiency.
	 * The operation codes are defined in PrimitiveTypeImpl, CollectionTypeImpl,
	 * and AnyTypeImpl.
	 * @param opValue
	 */
	public void setOperationCode(int opValue) {
		operationCode = opValue;
	}

	/**
	 * The cached value of the '{@link #getReferredOperation() <em>Referred Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredOperation()
	 * @generated
	 * @ordered
	 */
	protected EOperation referredOperation = null;

	/**
	 * The cached value of the '{@link #getArguments() <em>Arguments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArguments()
	 * @generated
	 * @ordered
	 */
	protected EList arguments = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationCallExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ExpressionsPackage.eINSTANCE.getOperationCallExp();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReferredOperation() {
		if (referredOperation != null && referredOperation.eIsProxy()) {
			EOperation oldReferredOperation = referredOperation;
			referredOperation = (EOperation)eResolveProxy((InternalEObject)referredOperation);
			if (referredOperation != oldReferredOperation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.OPERATION_CALL_EXP__REFERRED_OPERATION, oldReferredOperation, referredOperation));
			}
		}
		return referredOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation basicGetReferredOperation() {
		return referredOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredOperation(EOperation newReferredOperation) {
		EOperation oldReferredOperation = referredOperation;
		referredOperation = newReferredOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OPERATION_CALL_EXP__REFERRED_OPERATION, oldReferredOperation, referredOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getArguments() {
		if (arguments == null) {
			arguments = new EObjectContainmentWithInverseEList(OclExpression.class, this, ExpressionsPackage.OPERATION_CALL_EXP__ARGUMENTS, ExpressionsPackage.OCL_EXPRESSION__PARENT_OPERATION);
		}
		return arguments;
	}

	public Object accept(Visitor v) {
		return v.visitOperationCallExp(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case ExpressionsPackage.OPERATION_CALL_EXP__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicAdd(otherEnd, msgs);
				case ExpressionsPackage.OPERATION_CALL_EXP__APPLIED_PROPERTY:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, ExpressionsPackage.OPERATION_CALL_EXP__APPLIED_PROPERTY, msgs);
				case ExpressionsPackage.OPERATION_CALL_EXP__INITIALIZED_VARIABLE:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, ExpressionsPackage.OPERATION_CALL_EXP__INITIALIZED_VARIABLE, msgs);
				case ExpressionsPackage.OPERATION_CALL_EXP__PARENT_OPERATION:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, ExpressionsPackage.OPERATION_CALL_EXP__PARENT_OPERATION, msgs);
				case ExpressionsPackage.OPERATION_CALL_EXP__SOURCE:
					if (source != null)
						msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.OPERATION_CALL_EXP__SOURCE, null, msgs);
					return basicSetSource((OclExpression)otherEnd, msgs);
				case ExpressionsPackage.OPERATION_CALL_EXP__ARGUMENTS:
					return ((InternalEList)getArguments()).basicAdd(otherEnd, msgs);
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
				case ExpressionsPackage.OPERATION_CALL_EXP__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
				case ExpressionsPackage.OPERATION_CALL_EXP__APPLIED_PROPERTY:
					return eBasicSetContainer(null, ExpressionsPackage.OPERATION_CALL_EXP__APPLIED_PROPERTY, msgs);
				case ExpressionsPackage.OPERATION_CALL_EXP__INITIALIZED_VARIABLE:
					return eBasicSetContainer(null, ExpressionsPackage.OPERATION_CALL_EXP__INITIALIZED_VARIABLE, msgs);
				case ExpressionsPackage.OPERATION_CALL_EXP__PARENT_OPERATION:
					return eBasicSetContainer(null, ExpressionsPackage.OPERATION_CALL_EXP__PARENT_OPERATION, msgs);
				case ExpressionsPackage.OPERATION_CALL_EXP__SOURCE:
					return basicSetSource(null, msgs);
				case ExpressionsPackage.OPERATION_CALL_EXP__ARGUMENTS:
					return ((InternalEList)getArguments()).basicRemove(otherEnd, msgs);
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
				case ExpressionsPackage.OPERATION_CALL_EXP__APPLIED_PROPERTY:
					return eContainer.eInverseRemove(this, ExpressionsPackage.PROPERTY_CALL_EXP__SOURCE, PropertyCallExp.class, msgs);
				case ExpressionsPackage.OPERATION_CALL_EXP__INITIALIZED_VARIABLE:
					return eContainer.eInverseRemove(this, ExpressionsPackage.VARIABLE_DECLARATION__INIT_EXPRESSION, VariableDeclaration.class, msgs);
				case ExpressionsPackage.OPERATION_CALL_EXP__PARENT_OPERATION:
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
			case ExpressionsPackage.OPERATION_CALL_EXP__EANNOTATIONS:
				return getEAnnotations();
			case ExpressionsPackage.OPERATION_CALL_EXP__NAME:
				return getName();
			case ExpressionsPackage.OPERATION_CALL_EXP__START_POSITION:
				return new Integer(getStartPosition());
			case ExpressionsPackage.OPERATION_CALL_EXP__END_POSITION:
				return new Integer(getEndPosition());
			case ExpressionsPackage.OPERATION_CALL_EXP__APPLIED_PROPERTY:
				return getAppliedProperty();
			case ExpressionsPackage.OPERATION_CALL_EXP__INITIALIZED_VARIABLE:
				return getInitializedVariable();
			case ExpressionsPackage.OPERATION_CALL_EXP__PARENT_OPERATION:
				return getParentOperation();
			case ExpressionsPackage.OPERATION_CALL_EXP__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case ExpressionsPackage.OPERATION_CALL_EXP__PROPERTY_START_POSITION:
				return new Integer(getPropertyStartPosition());
			case ExpressionsPackage.OPERATION_CALL_EXP__PROPERTY_END_POSITION:
				return new Integer(getPropertyEndPosition());
			case ExpressionsPackage.OPERATION_CALL_EXP__SOURCE:
				return getSource();
			case ExpressionsPackage.OPERATION_CALL_EXP__MARKED_PRE:
				return isMarkedPre() ? Boolean.TRUE : Boolean.FALSE;
			case ExpressionsPackage.OPERATION_CALL_EXP__ARGUMENTS:
				return getArguments();
			case ExpressionsPackage.OPERATION_CALL_EXP__REFERRED_OPERATION:
				if (resolve) return getReferredOperation();
				return basicGetReferredOperation();
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
			case ExpressionsPackage.OPERATION_CALL_EXP__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case ExpressionsPackage.OPERATION_CALL_EXP__NAME:
				setName((String)newValue);
				return;
			case ExpressionsPackage.OPERATION_CALL_EXP__START_POSITION:
				setStartPosition(((Integer)newValue).intValue());
				return;
			case ExpressionsPackage.OPERATION_CALL_EXP__END_POSITION:
				setEndPosition(((Integer)newValue).intValue());
				return;
			case ExpressionsPackage.OPERATION_CALL_EXP__APPLIED_PROPERTY:
				setAppliedProperty((PropertyCallExp)newValue);
				return;
			case ExpressionsPackage.OPERATION_CALL_EXP__INITIALIZED_VARIABLE:
				setInitializedVariable((VariableDeclaration)newValue);
				return;
			case ExpressionsPackage.OPERATION_CALL_EXP__PARENT_OPERATION:
				setParentOperation((OperationCallExp)newValue);
				return;
			case ExpressionsPackage.OPERATION_CALL_EXP__TYPE:
				setType((EClassifier)newValue);
				return;
			case ExpressionsPackage.OPERATION_CALL_EXP__PROPERTY_START_POSITION:
				setPropertyStartPosition(((Integer)newValue).intValue());
				return;
			case ExpressionsPackage.OPERATION_CALL_EXP__PROPERTY_END_POSITION:
				setPropertyEndPosition(((Integer)newValue).intValue());
				return;
			case ExpressionsPackage.OPERATION_CALL_EXP__SOURCE:
				setSource((OclExpression)newValue);
				return;
			case ExpressionsPackage.OPERATION_CALL_EXP__MARKED_PRE:
				setMarkedPre(((Boolean)newValue).booleanValue());
				return;
			case ExpressionsPackage.OPERATION_CALL_EXP__ARGUMENTS:
				getArguments().clear();
				getArguments().addAll((Collection)newValue);
				return;
			case ExpressionsPackage.OPERATION_CALL_EXP__REFERRED_OPERATION:
				setReferredOperation((EOperation)newValue);
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
			case ExpressionsPackage.OPERATION_CALL_EXP__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case ExpressionsPackage.OPERATION_CALL_EXP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ExpressionsPackage.OPERATION_CALL_EXP__START_POSITION:
				setStartPosition(START_POSITION_EDEFAULT);
				return;
			case ExpressionsPackage.OPERATION_CALL_EXP__END_POSITION:
				setEndPosition(END_POSITION_EDEFAULT);
				return;
			case ExpressionsPackage.OPERATION_CALL_EXP__APPLIED_PROPERTY:
				setAppliedProperty((PropertyCallExp)null);
				return;
			case ExpressionsPackage.OPERATION_CALL_EXP__INITIALIZED_VARIABLE:
				setInitializedVariable((VariableDeclaration)null);
				return;
			case ExpressionsPackage.OPERATION_CALL_EXP__PARENT_OPERATION:
				setParentOperation((OperationCallExp)null);
				return;
			case ExpressionsPackage.OPERATION_CALL_EXP__TYPE:
				setType((EClassifier)null);
				return;
			case ExpressionsPackage.OPERATION_CALL_EXP__PROPERTY_START_POSITION:
				setPropertyStartPosition(PROPERTY_START_POSITION_EDEFAULT);
				return;
			case ExpressionsPackage.OPERATION_CALL_EXP__PROPERTY_END_POSITION:
				setPropertyEndPosition(PROPERTY_END_POSITION_EDEFAULT);
				return;
			case ExpressionsPackage.OPERATION_CALL_EXP__SOURCE:
				setSource((OclExpression)null);
				return;
			case ExpressionsPackage.OPERATION_CALL_EXP__MARKED_PRE:
				setMarkedPre(MARKED_PRE_EDEFAULT);
				return;
			case ExpressionsPackage.OPERATION_CALL_EXP__ARGUMENTS:
				getArguments().clear();
				return;
			case ExpressionsPackage.OPERATION_CALL_EXP__REFERRED_OPERATION:
				setReferredOperation((EOperation)null);
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
			case ExpressionsPackage.OPERATION_CALL_EXP__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case ExpressionsPackage.OPERATION_CALL_EXP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ExpressionsPackage.OPERATION_CALL_EXP__START_POSITION:
				return startPosition != START_POSITION_EDEFAULT;
			case ExpressionsPackage.OPERATION_CALL_EXP__END_POSITION:
				return endPosition != END_POSITION_EDEFAULT;
			case ExpressionsPackage.OPERATION_CALL_EXP__APPLIED_PROPERTY:
				return getAppliedProperty() != null;
			case ExpressionsPackage.OPERATION_CALL_EXP__INITIALIZED_VARIABLE:
				return getInitializedVariable() != null;
			case ExpressionsPackage.OPERATION_CALL_EXP__PARENT_OPERATION:
				return getParentOperation() != null;
			case ExpressionsPackage.OPERATION_CALL_EXP__TYPE:
				return type != null;
			case ExpressionsPackage.OPERATION_CALL_EXP__PROPERTY_START_POSITION:
				return propertyStartPosition != PROPERTY_START_POSITION_EDEFAULT;
			case ExpressionsPackage.OPERATION_CALL_EXP__PROPERTY_END_POSITION:
				return propertyEndPosition != PROPERTY_END_POSITION_EDEFAULT;
			case ExpressionsPackage.OPERATION_CALL_EXP__SOURCE:
				return source != null;
			case ExpressionsPackage.OPERATION_CALL_EXP__MARKED_PRE:
				return ((eFlags & MARKED_PRE_EFLAG) != 0) != MARKED_PRE_EDEFAULT;
			case ExpressionsPackage.OPERATION_CALL_EXP__ARGUMENTS:
				return arguments != null && !arguments.isEmpty();
			case ExpressionsPackage.OPERATION_CALL_EXP__REFERRED_OPERATION:
				return referredOperation != null;
		}
		return eDynamicIsSet(eFeature);
	}

} //OperationCallExpImpl
