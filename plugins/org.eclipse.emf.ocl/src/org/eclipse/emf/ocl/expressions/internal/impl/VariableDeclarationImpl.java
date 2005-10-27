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
import org.eclipse.emf.ecore.impl.ENamedElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.ocl.expressions.ExpressionsPackage;
import org.eclipse.emf.ocl.expressions.IterateExp;
import org.eclipse.emf.ocl.expressions.LoopExp;
import org.eclipse.emf.ocl.expressions.OclExpression;
import org.eclipse.emf.ocl.expressions.VariableDeclaration;
import org.eclipse.emf.ocl.expressions.Visitor;
import org.eclipse.emf.ocl.internal.utilities.AstNode;
import org.eclipse.emf.ocl.internal.utilities.TypedAstNode;
import org.eclipse.emf.ocl.internal.utilities.UtilitiesPackage;
import org.eclipse.emf.ocl.internal.utilities.Visitable;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Variable Declaration</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.expressions.internal.impl.VariableDeclarationImpl#getStartPosition <em>Start Position</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.expressions.internal.impl.VariableDeclarationImpl#getEndPosition <em>End Position</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.expressions.internal.impl.VariableDeclarationImpl#getTypeStartPosition <em>Type Start Position</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.expressions.internal.impl.VariableDeclarationImpl#getTypeEndPosition <em>Type End Position</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.expressions.internal.impl.VariableDeclarationImpl#getVarName <em>Var Name</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.expressions.internal.impl.VariableDeclarationImpl#getLoopExpr <em>Loop Expr</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.expressions.internal.impl.VariableDeclarationImpl#getInitExpression <em>Init Expression</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.expressions.internal.impl.VariableDeclarationImpl#getBaseExp <em>Base Exp</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.expressions.internal.impl.VariableDeclarationImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableDeclarationImpl
	extends ENamedElementImpl
	implements VariableDeclaration {

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
	 * The default value of the '{@link #getTypeStartPosition() <em>Type Start Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeStartPosition()
	 * @generated
	 * @ordered
	 */
	protected static final int TYPE_START_POSITION_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getTypeStartPosition() <em>Type Start Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeStartPosition()
	 * @generated
	 * @ordered
	 */
	protected int typeStartPosition = TYPE_START_POSITION_EDEFAULT;

	/**
	 * The default value of the '{@link #getTypeEndPosition() <em>Type End Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeEndPosition()
	 * @generated
	 * @ordered
	 */
	protected static final int TYPE_END_POSITION_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getTypeEndPosition() <em>Type End Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeEndPosition()
	 * @generated
	 * @ordered
	 */
	protected int typeEndPosition = TYPE_END_POSITION_EDEFAULT;

	/**
	 * The default value of the '{@link #getVarName() <em>Var Name</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getVarName()
	 * @generated @ordered
	 */
	protected static final String VAR_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVarName() <em>Var Name</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getVarName()
	 * @generated @ordered
	 */
	protected String varName = VAR_NAME_EDEFAULT;

	/**
	 * The cached value of the '
	 * {@link #getInitExpression() <em>Init Expression</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInitExpression()
	 * @generated @ordered
	 */
	protected OclExpression initExpression = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getType()
	 * @generated @ordered
	 */
	protected EClassifier type = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ExpressionsPackage.eINSTANCE.getVariableDeclaration();
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.VARIABLE_DECLARATION__START_POSITION, oldStartPosition, startPosition));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.VARIABLE_DECLARATION__END_POSITION, oldEndPosition, endPosition));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getVarName() {
		return varName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setVarName(String newVarName) {
		String oldVarName = varName;
		varName = newVarName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.VARIABLE_DECLARATION__VAR_NAME, oldVarName, varName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LoopExp getLoopExpr() {
		if (eContainerFeatureID != ExpressionsPackage.VARIABLE_DECLARATION__LOOP_EXPR) return null;
		return (LoopExp)eContainer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoopExpr(LoopExp newLoopExpr) {
		if (newLoopExpr != eContainer || (eContainerFeatureID != ExpressionsPackage.VARIABLE_DECLARATION__LOOP_EXPR && newLoopExpr != null)) {
			if (EcoreUtil.isAncestor(this, newLoopExpr))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eContainer != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newLoopExpr != null)
				msgs = ((InternalEObject)newLoopExpr).eInverseAdd(this, ExpressionsPackage.LOOP_EXP__ITERATORS, LoopExp.class, msgs);
			msgs = eBasicSetContainer((InternalEObject)newLoopExpr, ExpressionsPackage.VARIABLE_DECLARATION__LOOP_EXPR, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.VARIABLE_DECLARATION__LOOP_EXPR, newLoopExpr, newLoopExpr));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression getInitExpression() {
		return initExpression;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitExpression(OclExpression newInitExpression, NotificationChain msgs) {
		OclExpression oldInitExpression = initExpression;
		initExpression = newInitExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.VARIABLE_DECLARATION__INIT_EXPRESSION, oldInitExpression, newInitExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitExpression(OclExpression newInitExpression) {
		if (newInitExpression != initExpression) {
			NotificationChain msgs = null;
			if (initExpression != null)
				msgs = ((InternalEObject)initExpression).eInverseRemove(this, ExpressionsPackage.OCL_EXPRESSION__INITIALIZED_VARIABLE, OclExpression.class, msgs);
			if (newInitExpression != null)
				msgs = ((InternalEObject)newInitExpression).eInverseAdd(this, ExpressionsPackage.OCL_EXPRESSION__INITIALIZED_VARIABLE, OclExpression.class, msgs);
			msgs = basicSetInitExpression(newInitExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.VARIABLE_DECLARATION__INIT_EXPRESSION, newInitExpression, newInitExpression));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IterateExp getBaseExp() {
		if (eContainerFeatureID != ExpressionsPackage.VARIABLE_DECLARATION__BASE_EXP) return null;
		return (IterateExp)eContainer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseExp(IterateExp newBaseExp) {
		if (newBaseExp != eContainer || (eContainerFeatureID != ExpressionsPackage.VARIABLE_DECLARATION__BASE_EXP && newBaseExp != null)) {
			if (EcoreUtil.isAncestor(this, newBaseExp))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eContainer != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newBaseExp != null)
				msgs = ((InternalEObject)newBaseExp).eInverseAdd(this, ExpressionsPackage.ITERATE_EXP__RESULT, IterateExp.class, msgs);
			msgs = eBasicSetContainer((InternalEObject)newBaseExp, ExpressionsPackage.VARIABLE_DECLARATION__BASE_EXP, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.VARIABLE_DECLARATION__BASE_EXP, newBaseExp, newBaseExp));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifier getType() {
		if (type != null && type.eIsProxy()) {
			EClassifier oldType = type;
			type = (EClassifier)eResolveProxy((InternalEObject)type);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.VARIABLE_DECLARATION__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifier basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(EClassifier newType) {
		EClassifier oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.VARIABLE_DECLARATION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTypeStartPosition() {
		return typeStartPosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeStartPosition(int newTypeStartPosition) {
		int oldTypeStartPosition = typeStartPosition;
		typeStartPosition = newTypeStartPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.VARIABLE_DECLARATION__TYPE_START_POSITION, oldTypeStartPosition, typeStartPosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTypeEndPosition() {
		return typeEndPosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeEndPosition(int newTypeEndPosition) {
		int oldTypeEndPosition = typeEndPosition;
		typeEndPosition = newTypeEndPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.VARIABLE_DECLARATION__TYPE_END_POSITION, oldTypeEndPosition, typeEndPosition));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case ExpressionsPackage.VARIABLE_DECLARATION__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicAdd(otherEnd, msgs);
				case ExpressionsPackage.VARIABLE_DECLARATION__LOOP_EXPR:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, ExpressionsPackage.VARIABLE_DECLARATION__LOOP_EXPR, msgs);
				case ExpressionsPackage.VARIABLE_DECLARATION__INIT_EXPRESSION:
					if (initExpression != null)
						msgs = ((InternalEObject)initExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.VARIABLE_DECLARATION__INIT_EXPRESSION, null, msgs);
					return basicSetInitExpression((OclExpression)otherEnd, msgs);
				case ExpressionsPackage.VARIABLE_DECLARATION__BASE_EXP:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, ExpressionsPackage.VARIABLE_DECLARATION__BASE_EXP, msgs);
				default:
					return eDynamicInverseAdd(otherEnd, featureID, baseClass, msgs);
			}
		}
		if (eContainer != null)
			msgs = eBasicRemoveFromContainer(msgs);
		return eBasicSetContainer(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case ExpressionsPackage.VARIABLE_DECLARATION__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
				case ExpressionsPackage.VARIABLE_DECLARATION__LOOP_EXPR:
					return eBasicSetContainer(null, ExpressionsPackage.VARIABLE_DECLARATION__LOOP_EXPR, msgs);
				case ExpressionsPackage.VARIABLE_DECLARATION__INIT_EXPRESSION:
					return basicSetInitExpression(null, msgs);
				case ExpressionsPackage.VARIABLE_DECLARATION__BASE_EXP:
					return eBasicSetContainer(null, ExpressionsPackage.VARIABLE_DECLARATION__BASE_EXP, msgs);
				default:
					return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
			}
		}
		return eBasicSetContainer(null, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainer(NotificationChain msgs) {
		if (eContainerFeatureID >= 0) {
			switch (eContainerFeatureID) {
				case ExpressionsPackage.VARIABLE_DECLARATION__LOOP_EXPR:
					return eContainer.eInverseRemove(this, ExpressionsPackage.LOOP_EXP__ITERATORS, LoopExp.class, msgs);
				case ExpressionsPackage.VARIABLE_DECLARATION__BASE_EXP:
					return eContainer.eInverseRemove(this, ExpressionsPackage.ITERATE_EXP__RESULT, IterateExp.class, msgs);
				default:
					return eDynamicBasicRemoveFromContainer(msgs);
			}
		}
		return eContainer.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - eContainerFeatureID, null, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExpressionsPackage.VARIABLE_DECLARATION__EANNOTATIONS:
				return getEAnnotations();
			case ExpressionsPackage.VARIABLE_DECLARATION__NAME:
				return getName();
			case ExpressionsPackage.VARIABLE_DECLARATION__START_POSITION:
				return new Integer(getStartPosition());
			case ExpressionsPackage.VARIABLE_DECLARATION__END_POSITION:
				return new Integer(getEndPosition());
			case ExpressionsPackage.VARIABLE_DECLARATION__TYPE_START_POSITION:
				return new Integer(getTypeStartPosition());
			case ExpressionsPackage.VARIABLE_DECLARATION__TYPE_END_POSITION:
				return new Integer(getTypeEndPosition());
			case ExpressionsPackage.VARIABLE_DECLARATION__VAR_NAME:
				return getVarName();
			case ExpressionsPackage.VARIABLE_DECLARATION__LOOP_EXPR:
				return getLoopExpr();
			case ExpressionsPackage.VARIABLE_DECLARATION__INIT_EXPRESSION:
				return getInitExpression();
			case ExpressionsPackage.VARIABLE_DECLARATION__BASE_EXP:
				return getBaseExp();
			case ExpressionsPackage.VARIABLE_DECLARATION__TYPE:
				if (resolve) return getType();
				return basicGetType();
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExpressionsPackage.VARIABLE_DECLARATION__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case ExpressionsPackage.VARIABLE_DECLARATION__NAME:
				setName((String)newValue);
				return;
			case ExpressionsPackage.VARIABLE_DECLARATION__START_POSITION:
				setStartPosition(((Integer)newValue).intValue());
				return;
			case ExpressionsPackage.VARIABLE_DECLARATION__END_POSITION:
				setEndPosition(((Integer)newValue).intValue());
				return;
			case ExpressionsPackage.VARIABLE_DECLARATION__TYPE_START_POSITION:
				setTypeStartPosition(((Integer)newValue).intValue());
				return;
			case ExpressionsPackage.VARIABLE_DECLARATION__TYPE_END_POSITION:
				setTypeEndPosition(((Integer)newValue).intValue());
				return;
			case ExpressionsPackage.VARIABLE_DECLARATION__VAR_NAME:
				setVarName((String)newValue);
				return;
			case ExpressionsPackage.VARIABLE_DECLARATION__LOOP_EXPR:
				setLoopExpr((LoopExp)newValue);
				return;
			case ExpressionsPackage.VARIABLE_DECLARATION__INIT_EXPRESSION:
				setInitExpression((OclExpression)newValue);
				return;
			case ExpressionsPackage.VARIABLE_DECLARATION__BASE_EXP:
				setBaseExp((IterateExp)newValue);
				return;
			case ExpressionsPackage.VARIABLE_DECLARATION__TYPE:
				setType((EClassifier)newValue);
				return;
		}
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExpressionsPackage.VARIABLE_DECLARATION__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case ExpressionsPackage.VARIABLE_DECLARATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ExpressionsPackage.VARIABLE_DECLARATION__START_POSITION:
				setStartPosition(START_POSITION_EDEFAULT);
				return;
			case ExpressionsPackage.VARIABLE_DECLARATION__END_POSITION:
				setEndPosition(END_POSITION_EDEFAULT);
				return;
			case ExpressionsPackage.VARIABLE_DECLARATION__TYPE_START_POSITION:
				setTypeStartPosition(TYPE_START_POSITION_EDEFAULT);
				return;
			case ExpressionsPackage.VARIABLE_DECLARATION__TYPE_END_POSITION:
				setTypeEndPosition(TYPE_END_POSITION_EDEFAULT);
				return;
			case ExpressionsPackage.VARIABLE_DECLARATION__VAR_NAME:
				setVarName(VAR_NAME_EDEFAULT);
				return;
			case ExpressionsPackage.VARIABLE_DECLARATION__LOOP_EXPR:
				setLoopExpr((LoopExp)null);
				return;
			case ExpressionsPackage.VARIABLE_DECLARATION__INIT_EXPRESSION:
				setInitExpression((OclExpression)null);
				return;
			case ExpressionsPackage.VARIABLE_DECLARATION__BASE_EXP:
				setBaseExp((IterateExp)null);
				return;
			case ExpressionsPackage.VARIABLE_DECLARATION__TYPE:
				setType((EClassifier)null);
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExpressionsPackage.VARIABLE_DECLARATION__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case ExpressionsPackage.VARIABLE_DECLARATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ExpressionsPackage.VARIABLE_DECLARATION__START_POSITION:
				return startPosition != START_POSITION_EDEFAULT;
			case ExpressionsPackage.VARIABLE_DECLARATION__END_POSITION:
				return endPosition != END_POSITION_EDEFAULT;
			case ExpressionsPackage.VARIABLE_DECLARATION__TYPE_START_POSITION:
				return typeStartPosition != TYPE_START_POSITION_EDEFAULT;
			case ExpressionsPackage.VARIABLE_DECLARATION__TYPE_END_POSITION:
				return typeEndPosition != TYPE_END_POSITION_EDEFAULT;
			case ExpressionsPackage.VARIABLE_DECLARATION__VAR_NAME:
				return VAR_NAME_EDEFAULT == null ? varName != null : !VAR_NAME_EDEFAULT.equals(varName);
			case ExpressionsPackage.VARIABLE_DECLARATION__LOOP_EXPR:
				return getLoopExpr() != null;
			case ExpressionsPackage.VARIABLE_DECLARATION__INIT_EXPRESSION:
				return initExpression != null;
			case ExpressionsPackage.VARIABLE_DECLARATION__BASE_EXP:
				return getBaseExp() != null;
			case ExpressionsPackage.VARIABLE_DECLARATION__TYPE:
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
				case ExpressionsPackage.VARIABLE_DECLARATION__START_POSITION: return UtilitiesPackage.AST_NODE__START_POSITION;
				case ExpressionsPackage.VARIABLE_DECLARATION__END_POSITION: return UtilitiesPackage.AST_NODE__END_POSITION;
				default: return -1;
			}
		}
		if (baseClass == TypedAstNode.class) {
			switch (derivedFeatureID) {
				case ExpressionsPackage.VARIABLE_DECLARATION__TYPE_START_POSITION: return UtilitiesPackage.TYPED_AST_NODE__TYPE_START_POSITION;
				case ExpressionsPackage.VARIABLE_DECLARATION__TYPE_END_POSITION: return UtilitiesPackage.TYPED_AST_NODE__TYPE_END_POSITION;
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
				case UtilitiesPackage.AST_NODE__START_POSITION: return ExpressionsPackage.VARIABLE_DECLARATION__START_POSITION;
				case UtilitiesPackage.AST_NODE__END_POSITION: return ExpressionsPackage.VARIABLE_DECLARATION__END_POSITION;
				default: return -1;
			}
		}
		if (baseClass == TypedAstNode.class) {
			switch (baseFeatureID) {
				case UtilitiesPackage.TYPED_AST_NODE__TYPE_START_POSITION: return ExpressionsPackage.VARIABLE_DECLARATION__TYPE_START_POSITION;
				case UtilitiesPackage.TYPED_AST_NODE__TYPE_END_POSITION: return ExpressionsPackage.VARIABLE_DECLARATION__TYPE_END_POSITION;
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

	public Object accept(Visitor v) {
		return v.visitVariableDeclaration(this);
	}

} //VariableDeclarationImpl
