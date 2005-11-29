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
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.ocl.expressions.ExpressionsPackage;
import org.eclipse.emf.ocl.expressions.OclExpression;
import org.eclipse.emf.ocl.expressions.OperationCallExp;
import org.eclipse.emf.ocl.expressions.PropertyCallExp;
import org.eclipse.emf.ocl.expressions.VariableDeclaration;

import org.eclipse.emf.ocl.internal.utilities.CallingAstNode;
import org.eclipse.emf.ocl.internal.utilities.UtilitiesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.expressions.internal.impl.PropertyCallExpImpl#getPropertyStartPosition <em>Property Start Position</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.expressions.internal.impl.PropertyCallExpImpl#getPropertyEndPosition <em>Property End Position</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.expressions.internal.impl.PropertyCallExpImpl#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PropertyCallExpImpl extends OclExpressionImpl implements PropertyCallExp {
	/**
	 * The default value of the '{@link #getPropertyStartPosition() <em>Property Start Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyStartPosition()
	 * @generated
	 * @ordered
	 */
	protected static final int PROPERTY_START_POSITION_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getPropertyStartPosition() <em>Property Start Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyStartPosition()
	 * @generated
	 * @ordered
	 */
	protected int propertyStartPosition = PROPERTY_START_POSITION_EDEFAULT;

	/**
	 * The default value of the '{@link #getPropertyEndPosition() <em>Property End Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyEndPosition()
	 * @generated
	 * @ordered
	 */
	protected static final int PROPERTY_END_POSITION_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getPropertyEndPosition() <em>Property End Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyEndPosition()
	 * @generated
	 * @ordered
	 */
	protected int propertyEndPosition = PROPERTY_END_POSITION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected OclExpression source = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyCallExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ExpressionsPackage.eINSTANCE.getPropertyCallExp();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPropertyStartPosition() {
		return propertyStartPosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyStartPosition(int newPropertyStartPosition) {
		int oldPropertyStartPosition = propertyStartPosition;
		propertyStartPosition = newPropertyStartPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.PROPERTY_CALL_EXP__PROPERTY_START_POSITION, oldPropertyStartPosition, propertyStartPosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPropertyEndPosition() {
		return propertyEndPosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyEndPosition(int newPropertyEndPosition) {
		int oldPropertyEndPosition = propertyEndPosition;
		propertyEndPosition = newPropertyEndPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.PROPERTY_CALL_EXP__PROPERTY_END_POSITION, oldPropertyEndPosition, propertyEndPosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(OclExpression newSource, NotificationChain msgs) {
		OclExpression oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.PROPERTY_CALL_EXP__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(OclExpression newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY, OclExpression.class, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY, OclExpression.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.PROPERTY_CALL_EXP__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case ExpressionsPackage.PROPERTY_CALL_EXP__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicAdd(otherEnd, msgs);
				case ExpressionsPackage.PROPERTY_CALL_EXP__APPLIED_PROPERTY:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, ExpressionsPackage.PROPERTY_CALL_EXP__APPLIED_PROPERTY, msgs);
				case ExpressionsPackage.PROPERTY_CALL_EXP__INITIALIZED_VARIABLE:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, ExpressionsPackage.PROPERTY_CALL_EXP__INITIALIZED_VARIABLE, msgs);
				case ExpressionsPackage.PROPERTY_CALL_EXP__PARENT_OPERATION:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, ExpressionsPackage.PROPERTY_CALL_EXP__PARENT_OPERATION, msgs);
				case ExpressionsPackage.PROPERTY_CALL_EXP__SOURCE:
					if (source != null)
						msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.PROPERTY_CALL_EXP__SOURCE, null, msgs);
					return basicSetSource((OclExpression)otherEnd, msgs);
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
				case ExpressionsPackage.PROPERTY_CALL_EXP__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
				case ExpressionsPackage.PROPERTY_CALL_EXP__APPLIED_PROPERTY:
					return eBasicSetContainer(null, ExpressionsPackage.PROPERTY_CALL_EXP__APPLIED_PROPERTY, msgs);
				case ExpressionsPackage.PROPERTY_CALL_EXP__INITIALIZED_VARIABLE:
					return eBasicSetContainer(null, ExpressionsPackage.PROPERTY_CALL_EXP__INITIALIZED_VARIABLE, msgs);
				case ExpressionsPackage.PROPERTY_CALL_EXP__PARENT_OPERATION:
					return eBasicSetContainer(null, ExpressionsPackage.PROPERTY_CALL_EXP__PARENT_OPERATION, msgs);
				case ExpressionsPackage.PROPERTY_CALL_EXP__SOURCE:
					return basicSetSource(null, msgs);
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
				case ExpressionsPackage.PROPERTY_CALL_EXP__APPLIED_PROPERTY:
					return eContainer.eInverseRemove(this, ExpressionsPackage.PROPERTY_CALL_EXP__SOURCE, PropertyCallExp.class, msgs);
				case ExpressionsPackage.PROPERTY_CALL_EXP__INITIALIZED_VARIABLE:
					return eContainer.eInverseRemove(this, ExpressionsPackage.VARIABLE_DECLARATION__INIT_EXPRESSION, VariableDeclaration.class, msgs);
				case ExpressionsPackage.PROPERTY_CALL_EXP__PARENT_OPERATION:
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
			case ExpressionsPackage.PROPERTY_CALL_EXP__EANNOTATIONS:
				return getEAnnotations();
			case ExpressionsPackage.PROPERTY_CALL_EXP__NAME:
				return getName();
			case ExpressionsPackage.PROPERTY_CALL_EXP__START_POSITION:
				return new Integer(getStartPosition());
			case ExpressionsPackage.PROPERTY_CALL_EXP__END_POSITION:
				return new Integer(getEndPosition());
			case ExpressionsPackage.PROPERTY_CALL_EXP__APPLIED_PROPERTY:
				return getAppliedProperty();
			case ExpressionsPackage.PROPERTY_CALL_EXP__INITIALIZED_VARIABLE:
				return getInitializedVariable();
			case ExpressionsPackage.PROPERTY_CALL_EXP__PARENT_OPERATION:
				return getParentOperation();
			case ExpressionsPackage.PROPERTY_CALL_EXP__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case ExpressionsPackage.PROPERTY_CALL_EXP__PROPERTY_START_POSITION:
				return new Integer(getPropertyStartPosition());
			case ExpressionsPackage.PROPERTY_CALL_EXP__PROPERTY_END_POSITION:
				return new Integer(getPropertyEndPosition());
			case ExpressionsPackage.PROPERTY_CALL_EXP__SOURCE:
				return getSource();
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
			case ExpressionsPackage.PROPERTY_CALL_EXP__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case ExpressionsPackage.PROPERTY_CALL_EXP__NAME:
				setName((String)newValue);
				return;
			case ExpressionsPackage.PROPERTY_CALL_EXP__START_POSITION:
				setStartPosition(((Integer)newValue).intValue());
				return;
			case ExpressionsPackage.PROPERTY_CALL_EXP__END_POSITION:
				setEndPosition(((Integer)newValue).intValue());
				return;
			case ExpressionsPackage.PROPERTY_CALL_EXP__APPLIED_PROPERTY:
				setAppliedProperty((PropertyCallExp)newValue);
				return;
			case ExpressionsPackage.PROPERTY_CALL_EXP__INITIALIZED_VARIABLE:
				setInitializedVariable((VariableDeclaration)newValue);
				return;
			case ExpressionsPackage.PROPERTY_CALL_EXP__PARENT_OPERATION:
				setParentOperation((OperationCallExp)newValue);
				return;
			case ExpressionsPackage.PROPERTY_CALL_EXP__TYPE:
				setType((EClassifier)newValue);
				return;
			case ExpressionsPackage.PROPERTY_CALL_EXP__PROPERTY_START_POSITION:
				setPropertyStartPosition(((Integer)newValue).intValue());
				return;
			case ExpressionsPackage.PROPERTY_CALL_EXP__PROPERTY_END_POSITION:
				setPropertyEndPosition(((Integer)newValue).intValue());
				return;
			case ExpressionsPackage.PROPERTY_CALL_EXP__SOURCE:
				setSource((OclExpression)newValue);
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
			case ExpressionsPackage.PROPERTY_CALL_EXP__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case ExpressionsPackage.PROPERTY_CALL_EXP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ExpressionsPackage.PROPERTY_CALL_EXP__START_POSITION:
				setStartPosition(START_POSITION_EDEFAULT);
				return;
			case ExpressionsPackage.PROPERTY_CALL_EXP__END_POSITION:
				setEndPosition(END_POSITION_EDEFAULT);
				return;
			case ExpressionsPackage.PROPERTY_CALL_EXP__APPLIED_PROPERTY:
				setAppliedProperty((PropertyCallExp)null);
				return;
			case ExpressionsPackage.PROPERTY_CALL_EXP__INITIALIZED_VARIABLE:
				setInitializedVariable((VariableDeclaration)null);
				return;
			case ExpressionsPackage.PROPERTY_CALL_EXP__PARENT_OPERATION:
				setParentOperation((OperationCallExp)null);
				return;
			case ExpressionsPackage.PROPERTY_CALL_EXP__TYPE:
				setType((EClassifier)null);
				return;
			case ExpressionsPackage.PROPERTY_CALL_EXP__PROPERTY_START_POSITION:
				setPropertyStartPosition(PROPERTY_START_POSITION_EDEFAULT);
				return;
			case ExpressionsPackage.PROPERTY_CALL_EXP__PROPERTY_END_POSITION:
				setPropertyEndPosition(PROPERTY_END_POSITION_EDEFAULT);
				return;
			case ExpressionsPackage.PROPERTY_CALL_EXP__SOURCE:
				setSource((OclExpression)null);
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
			case ExpressionsPackage.PROPERTY_CALL_EXP__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case ExpressionsPackage.PROPERTY_CALL_EXP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ExpressionsPackage.PROPERTY_CALL_EXP__START_POSITION:
				return startPosition != START_POSITION_EDEFAULT;
			case ExpressionsPackage.PROPERTY_CALL_EXP__END_POSITION:
				return endPosition != END_POSITION_EDEFAULT;
			case ExpressionsPackage.PROPERTY_CALL_EXP__APPLIED_PROPERTY:
				return getAppliedProperty() != null;
			case ExpressionsPackage.PROPERTY_CALL_EXP__INITIALIZED_VARIABLE:
				return getInitializedVariable() != null;
			case ExpressionsPackage.PROPERTY_CALL_EXP__PARENT_OPERATION:
				return getParentOperation() != null;
			case ExpressionsPackage.PROPERTY_CALL_EXP__TYPE:
				return type != null;
			case ExpressionsPackage.PROPERTY_CALL_EXP__PROPERTY_START_POSITION:
				return propertyStartPosition != PROPERTY_START_POSITION_EDEFAULT;
			case ExpressionsPackage.PROPERTY_CALL_EXP__PROPERTY_END_POSITION:
				return propertyEndPosition != PROPERTY_END_POSITION_EDEFAULT;
			case ExpressionsPackage.PROPERTY_CALL_EXP__SOURCE:
				return source != null;
		}
		return eDynamicIsSet(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass) {
		if (baseClass == CallingAstNode.class) {
			switch (derivedFeatureID) {
				case ExpressionsPackage.PROPERTY_CALL_EXP__PROPERTY_START_POSITION: return UtilitiesPackage.CALLING_AST_NODE__PROPERTY_START_POSITION;
				case ExpressionsPackage.PROPERTY_CALL_EXP__PROPERTY_END_POSITION: return UtilitiesPackage.CALLING_AST_NODE__PROPERTY_END_POSITION;
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
		if (baseClass == CallingAstNode.class) {
			switch (baseFeatureID) {
				case UtilitiesPackage.CALLING_AST_NODE__PROPERTY_START_POSITION: return ExpressionsPackage.PROPERTY_CALL_EXP__PROPERTY_START_POSITION;
				case UtilitiesPackage.CALLING_AST_NODE__PROPERTY_END_POSITION: return ExpressionsPackage.PROPERTY_CALL_EXP__PROPERTY_END_POSITION;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (propertyStartPosition: "); //$NON-NLS-1$
		result.append(propertyStartPosition);
		result.append(", propertyEndPosition: "); //$NON-NLS-1$
		result.append(propertyEndPosition);
		result.append(')');
		return result.toString();
	}

} //PropertyCallExpImpl
