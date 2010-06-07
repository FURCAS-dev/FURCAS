/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2009 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bugs 248869, 207365
 *
 * </copyright>
 *
 * $Id: OperationCallExpImpl.java,v 1.13 2010/04/23 05:52:39 ewillink Exp $
 */
package org.eclipse.ocl.ecore.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.operations.OperationCallExpOperations;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.ecore.impl.OperationCallExpImpl#getArgument <em>Argument</em>}</li>
 *   <li>{@link org.eclipse.ocl.ecore.impl.OperationCallExpImpl#getReferredOperation <em>Referred Operation</em>}</li>
 *   <li>{@link org.eclipse.ocl.ecore.impl.OperationCallExpImpl#getOperationCode <em>Operation Code</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationCallExpImpl
		extends FeatureCallExpImpl
		implements OperationCallExp {

	/**
	 * The cached value of the '{@link #getArgument() <em>Argument</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgument()
	 * @generated
	 * @ordered
	 */
	protected EList<OCLExpression<EClassifier>> argument;

	/**
	 * The cached value of the '{@link #getReferredOperation() <em>Referred Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredOperation()
	 * @generated
	 * @ordered
	 */
	protected EOperation referredOperation;

	/**
	 * The default value of the '{@link #getOperationCode() <em>Operation Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationCode()
	 * @generated
	 * @ordered
	 */
	protected static final int OPERATION_CODE_EDEFAULT = 0;

	private int operationCode = -1;

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
	@Override
	protected EClass eStaticClass() {
		return EcorePackage.Literals.OPERATION_CALL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OCLExpression<EClassifier>> getArgument() {
		if (argument == null) {
			argument = new EObjectContainmentEList<OCLExpression<EClassifier>>(
				OCLExpression.class, this,
				EcorePackage.OPERATION_CALL_EXP__ARGUMENT);
		}
		return argument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReferredOperation() {
		if (referredOperation != null
			&& ((EObject) referredOperation).eIsProxy()) {
			InternalEObject oldReferredOperation = (InternalEObject) referredOperation;
			referredOperation = (EOperation) eResolveProxy(oldReferredOperation);
			if (referredOperation != oldReferredOperation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						EcorePackage.OPERATION_CALL_EXP__REFERRED_OPERATION,
						oldReferredOperation, referredOperation));
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
			eNotify(new ENotificationImpl(this, Notification.SET,
				EcorePackage.OPERATION_CALL_EXP__REFERRED_OPERATION,
				oldReferredOperation, referredOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getOperationCode() {
		if (operationCode < 0) {
			if ((getSource() != null) && (getReferredOperation() != null)) {
				Environment<?, EClassifier, EOperation, ?, ?, ?, ?, ?, ?, ?, ?, ?> env = Environment.Registry.INSTANCE
					.getEnvironmentFor(getSource());
				EClassifier type = getSource().getType();

				if (env != null) {
					String operName = getReferredOperation().getName();

					if (type instanceof PredefinedType<?>) {
						operationCode = OCLStandardLibraryUtil
							.getOperationCode(operName);
					} else if (TypeUtil.isOclAnyOperation(env,
						getReferredOperation())) {
						// not a predefined type?  Model types have the AnyType
						//    operations (except in the case that a model type
						//    defines the corresponding operation)
						operationCode = OCLStandardLibraryUtil
							.getOclAnyOperationCode(operName);
					}
				}
			} else {
				operationCode = 0;
			}
		}

		return operationCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setOperationCode(int newOperationCode) {
		operationCode = newOperationCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean checkArgumentsConform(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return OperationCallExpOperations.checkArgumentsConform(this,
			diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean checkArgumentCount(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return OperationCallExpOperations.checkArgumentCount(this, diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EcorePackage.OPERATION_CALL_EXP__ARGUMENT :
				return ((InternalEList<?>) getArgument()).basicRemove(otherEnd,
					msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EcorePackage.OPERATION_CALL_EXP__ARGUMENT :
				return getArgument();
			case EcorePackage.OPERATION_CALL_EXP__REFERRED_OPERATION :
				if (resolve)
					return getReferredOperation();
				return basicGetReferredOperation();
			case EcorePackage.OPERATION_CALL_EXP__OPERATION_CODE :
				return getOperationCode();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EcorePackage.OPERATION_CALL_EXP__ARGUMENT :
				getArgument().clear();
				getArgument()
					.addAll(
						(Collection<? extends OCLExpression<EClassifier>>) newValue);
				return;
			case EcorePackage.OPERATION_CALL_EXP__REFERRED_OPERATION :
				setReferredOperation((EOperation) newValue);
				return;
			case EcorePackage.OPERATION_CALL_EXP__OPERATION_CODE :
				setOperationCode((Integer) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EcorePackage.OPERATION_CALL_EXP__ARGUMENT :
				getArgument().clear();
				return;
			case EcorePackage.OPERATION_CALL_EXP__REFERRED_OPERATION :
				setReferredOperation((EOperation) null);
				return;
			case EcorePackage.OPERATION_CALL_EXP__OPERATION_CODE :
				setOperationCode(OPERATION_CODE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EcorePackage.OPERATION_CALL_EXP__ARGUMENT :
				return argument != null && !argument.isEmpty();
			case EcorePackage.OPERATION_CALL_EXP__REFERRED_OPERATION :
				return referredOperation != null;
			case EcorePackage.OPERATION_CALL_EXP__OPERATION_CODE :
				return getOperationCode() != OPERATION_CODE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == org.eclipse.ocl.expressions.OperationCallExp.class) {
			switch (derivedFeatureID) {
				case EcorePackage.OPERATION_CALL_EXP__ARGUMENT :
					return ExpressionsPackage.OPERATION_CALL_EXP__ARGUMENT;
				case EcorePackage.OPERATION_CALL_EXP__REFERRED_OPERATION :
					return ExpressionsPackage.OPERATION_CALL_EXP__REFERRED_OPERATION;
				case EcorePackage.OPERATION_CALL_EXP__OPERATION_CODE :
					return ExpressionsPackage.OPERATION_CALL_EXP__OPERATION_CODE;
				default :
					return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == org.eclipse.ocl.expressions.OperationCallExp.class) {
			switch (baseFeatureID) {
				case ExpressionsPackage.OPERATION_CALL_EXP__ARGUMENT :
					return EcorePackage.OPERATION_CALL_EXP__ARGUMENT;
				case ExpressionsPackage.OPERATION_CALL_EXP__REFERRED_OPERATION :
					return EcorePackage.OPERATION_CALL_EXP__REFERRED_OPERATION;
				case ExpressionsPackage.OPERATION_CALL_EXP__OPERATION_CODE :
					return EcorePackage.OPERATION_CALL_EXP__OPERATION_CODE;
				default :
					return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * @generated NOT
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <T, U extends Visitor<T, ?, ?, ?, ?, ?, ?, ?, ?, ?>> T accept(U v) {
		return ((Visitor<T, EClassifier, EOperation, ?, ?, ?, ?, ?, ?, ?>) v)
			.visitOperationCallExp(this);
	}

} //OperationCallExpImpl
