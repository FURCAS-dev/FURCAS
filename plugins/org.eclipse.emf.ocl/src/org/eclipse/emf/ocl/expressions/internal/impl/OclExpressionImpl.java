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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENamedElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.ocl.expressions.ExpressionsPackage;
import org.eclipse.emf.ocl.expressions.OclExpression;
import org.eclipse.emf.ocl.expressions.OperationCallExp;
import org.eclipse.emf.ocl.expressions.PropertyCallExp;
import org.eclipse.emf.ocl.expressions.VariableDeclaration;
import org.eclipse.emf.ocl.expressions.Visitor;
import org.eclipse.emf.ocl.internal.utilities.AstNode;
import org.eclipse.emf.ocl.internal.utilities.UtilitiesPackage;
import org.eclipse.emf.ocl.internal.utilities.Visitable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ocl Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.expressions.internal.impl.OclExpressionImpl#getStartPosition <em>Start Position</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.expressions.internal.impl.OclExpressionImpl#getEndPosition <em>End Position</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.expressions.internal.impl.OclExpressionImpl#getAppliedProperty <em>Applied Property</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.expressions.internal.impl.OclExpressionImpl#getInitializedVariable <em>Initialized Variable</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.expressions.internal.impl.OclExpressionImpl#getParentOperation <em>Parent Operation</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.expressions.internal.impl.OclExpressionImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class OclExpressionImpl extends ENamedElementImpl implements OclExpression {
	/**
	 * The default value of the '{@link #getStartPosition() <em>Start Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartPosition()
	 * @generated
	 * @ordered
	 */
	protected static final int START_POSITION_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getStartPosition() <em>Start Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartPosition()
	 * @generated
	 * @ordered
	 */
	protected int startPosition = START_POSITION_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndPosition() <em>End Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndPosition()
	 * @generated
	 * @ordered
	 */
	protected static final int END_POSITION_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getEndPosition() <em>End Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndPosition()
	 * @generated
	 * @ordered
	 */
	protected int endPosition = END_POSITION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EClassifier type = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OclExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ExpressionsPackage.eINSTANCE.getOclExpression();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStartPosition() {
		return startPosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartPosition(int newStartPosition) {
		int oldStartPosition = startPosition;
		startPosition = newStartPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OCL_EXPRESSION__START_POSITION, oldStartPosition, startPosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEndPosition() {
		return endPosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndPosition(int newEndPosition) {
		int oldEndPosition = endPosition;
		endPosition = newEndPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OCL_EXPRESSION__END_POSITION, oldEndPosition, endPosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyCallExp getAppliedProperty() {
		if (eContainerFeatureID != ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY) return null;
		return (PropertyCallExp)eContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAppliedProperty(PropertyCallExp newAppliedProperty) {
		if (newAppliedProperty != eContainer || (eContainerFeatureID != ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY && newAppliedProperty != null)) {
			if (EcoreUtil.isAncestor(this, newAppliedProperty))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eContainer != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newAppliedProperty != null)
				msgs = ((InternalEObject)newAppliedProperty).eInverseAdd(this, ExpressionsPackage.PROPERTY_CALL_EXP__SOURCE, PropertyCallExp.class, msgs);
			msgs = eBasicSetContainer((InternalEObject)newAppliedProperty, ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY, newAppliedProperty, newAppliedProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration getInitializedVariable() {
		if (eContainerFeatureID != ExpressionsPackage.OCL_EXPRESSION__INITIALIZED_VARIABLE) return null;
		return (VariableDeclaration)eContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitializedVariable(VariableDeclaration newInitializedVariable) {
		if (newInitializedVariable != eContainer || (eContainerFeatureID != ExpressionsPackage.OCL_EXPRESSION__INITIALIZED_VARIABLE && newInitializedVariable != null)) {
			if (EcoreUtil.isAncestor(this, newInitializedVariable))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eContainer != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newInitializedVariable != null)
				msgs = ((InternalEObject)newInitializedVariable).eInverseAdd(this, ExpressionsPackage.VARIABLE_DECLARATION__INIT_EXPRESSION, VariableDeclaration.class, msgs);
			msgs = eBasicSetContainer((InternalEObject)newInitializedVariable, ExpressionsPackage.OCL_EXPRESSION__INITIALIZED_VARIABLE, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OCL_EXPRESSION__INITIALIZED_VARIABLE, newInitializedVariable, newInitializedVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationCallExp getParentOperation() {
		if (eContainerFeatureID != ExpressionsPackage.OCL_EXPRESSION__PARENT_OPERATION) return null;
		return (OperationCallExp)eContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentOperation(OperationCallExp newParentOperation) {
		if (newParentOperation != eContainer || (eContainerFeatureID != ExpressionsPackage.OCL_EXPRESSION__PARENT_OPERATION && newParentOperation != null)) {
			if (EcoreUtil.isAncestor(this, newParentOperation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eContainer != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentOperation != null)
				msgs = ((InternalEObject)newParentOperation).eInverseAdd(this, ExpressionsPackage.OPERATION_CALL_EXP__ARGUMENTS, OperationCallExp.class, msgs);
			msgs = eBasicSetContainer((InternalEObject)newParentOperation, ExpressionsPackage.OCL_EXPRESSION__PARENT_OPERATION, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OCL_EXPRESSION__PARENT_OPERATION, newParentOperation, newParentOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifier getType() {
		if (type != null && type.eIsProxy()) {
			EClassifier oldType = type;
			type = (EClassifier)eResolveProxy((InternalEObject)type);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.OCL_EXPRESSION__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifier basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(EClassifier newType) {
		EClassifier oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OCL_EXPRESSION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object accept(Visitor v) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case ExpressionsPackage.OCL_EXPRESSION__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicAdd(otherEnd, msgs);
				case ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY, msgs);
				case ExpressionsPackage.OCL_EXPRESSION__INITIALIZED_VARIABLE:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, ExpressionsPackage.OCL_EXPRESSION__INITIALIZED_VARIABLE, msgs);
				case ExpressionsPackage.OCL_EXPRESSION__PARENT_OPERATION:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, ExpressionsPackage.OCL_EXPRESSION__PARENT_OPERATION, msgs);
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
				case ExpressionsPackage.OCL_EXPRESSION__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
				case ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY:
					return eBasicSetContainer(null, ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY, msgs);
				case ExpressionsPackage.OCL_EXPRESSION__INITIALIZED_VARIABLE:
					return eBasicSetContainer(null, ExpressionsPackage.OCL_EXPRESSION__INITIALIZED_VARIABLE, msgs);
				case ExpressionsPackage.OCL_EXPRESSION__PARENT_OPERATION:
					return eBasicSetContainer(null, ExpressionsPackage.OCL_EXPRESSION__PARENT_OPERATION, msgs);
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
				case ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY:
					return eContainer.eInverseRemove(this, ExpressionsPackage.PROPERTY_CALL_EXP__SOURCE, PropertyCallExp.class, msgs);
				case ExpressionsPackage.OCL_EXPRESSION__INITIALIZED_VARIABLE:
					return eContainer.eInverseRemove(this, ExpressionsPackage.VARIABLE_DECLARATION__INIT_EXPRESSION, VariableDeclaration.class, msgs);
				case ExpressionsPackage.OCL_EXPRESSION__PARENT_OPERATION:
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
			case ExpressionsPackage.OCL_EXPRESSION__EANNOTATIONS:
				return getEAnnotations();
			case ExpressionsPackage.OCL_EXPRESSION__NAME:
				return getName();
			case ExpressionsPackage.OCL_EXPRESSION__START_POSITION:
				return new Integer(getStartPosition());
			case ExpressionsPackage.OCL_EXPRESSION__END_POSITION:
				return new Integer(getEndPosition());
			case ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY:
				return getAppliedProperty();
			case ExpressionsPackage.OCL_EXPRESSION__INITIALIZED_VARIABLE:
				return getInitializedVariable();
			case ExpressionsPackage.OCL_EXPRESSION__PARENT_OPERATION:
				return getParentOperation();
			case ExpressionsPackage.OCL_EXPRESSION__TYPE:
				if (resolve) return getType();
				return basicGetType();
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
			case ExpressionsPackage.OCL_EXPRESSION__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__NAME:
				setName((String)newValue);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__START_POSITION:
				setStartPosition(((Integer)newValue).intValue());
				return;
			case ExpressionsPackage.OCL_EXPRESSION__END_POSITION:
				setEndPosition(((Integer)newValue).intValue());
				return;
			case ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY:
				setAppliedProperty((PropertyCallExp)newValue);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__INITIALIZED_VARIABLE:
				setInitializedVariable((VariableDeclaration)newValue);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__PARENT_OPERATION:
				setParentOperation((OperationCallExp)newValue);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__TYPE:
				setType((EClassifier)newValue);
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
			case ExpressionsPackage.OCL_EXPRESSION__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case ExpressionsPackage.OCL_EXPRESSION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__START_POSITION:
				setStartPosition(START_POSITION_EDEFAULT);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__END_POSITION:
				setEndPosition(END_POSITION_EDEFAULT);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY:
				setAppliedProperty((PropertyCallExp)null);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__INITIALIZED_VARIABLE:
				setInitializedVariable((VariableDeclaration)null);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__PARENT_OPERATION:
				setParentOperation((OperationCallExp)null);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__TYPE:
				setType((EClassifier)null);
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
			case ExpressionsPackage.OCL_EXPRESSION__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case ExpressionsPackage.OCL_EXPRESSION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ExpressionsPackage.OCL_EXPRESSION__START_POSITION:
				return startPosition != START_POSITION_EDEFAULT;
			case ExpressionsPackage.OCL_EXPRESSION__END_POSITION:
				return endPosition != END_POSITION_EDEFAULT;
			case ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY:
				return getAppliedProperty() != null;
			case ExpressionsPackage.OCL_EXPRESSION__INITIALIZED_VARIABLE:
				return getInitializedVariable() != null;
			case ExpressionsPackage.OCL_EXPRESSION__PARENT_OPERATION:
				return getParentOperation() != null;
			case ExpressionsPackage.OCL_EXPRESSION__TYPE:
				return type != null;
		}
		return eDynamicIsSet(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass) {
		if (baseClass == Visitable.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == AstNode.class) {
			switch (derivedFeatureID) {
				case ExpressionsPackage.OCL_EXPRESSION__START_POSITION: return UtilitiesPackage.AST_NODE__START_POSITION;
				case ExpressionsPackage.OCL_EXPRESSION__END_POSITION: return UtilitiesPackage.AST_NODE__END_POSITION;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class baseClass) {
		if (baseClass == Visitable.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == AstNode.class) {
			switch (baseFeatureID) {
				case UtilitiesPackage.AST_NODE__START_POSITION: return ExpressionsPackage.OCL_EXPRESSION__START_POSITION;
				case UtilitiesPackage.AST_NODE__END_POSITION: return ExpressionsPackage.OCL_EXPRESSION__END_POSITION;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * @generated NOT
	 */
	public String toString() {
		return ToStringVisitorImpl.toString(this);
	}

} //OclExpressionImpl
