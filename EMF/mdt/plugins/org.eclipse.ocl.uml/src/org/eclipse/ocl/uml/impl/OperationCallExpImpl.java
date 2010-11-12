/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2009 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 207365
 * 
 * </copyright>
 *
 * $Id: OperationCallExpImpl.java,v 1.9 2010/04/23 05:52:14 ewillink Exp $
 */
package org.eclipse.ocl.uml.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.operations.OperationCallExpOperations;
import org.eclipse.ocl.uml.OperationCallExp;
import org.eclipse.ocl.uml.UMLPackage;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.Visitor;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Operation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.uml.impl.OperationCallExpImpl#getArgument <em>Argument</em>}</li>
 *   <li>{@link org.eclipse.ocl.uml.impl.OperationCallExpImpl#getReferredOperation <em>Referred Operation</em>}</li>
 *   <li>{@link org.eclipse.ocl.uml.impl.OperationCallExpImpl#getOperationCode <em>Operation Code</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("restriction")
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
	protected EList<OCLExpression<Classifier>> argument;

	/**
	 * The cached value of the '{@link #getReferredOperation() <em>Referred Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredOperation()
	 * @generated
	 * @ordered
	 */
	protected Operation referredOperation;

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
		return UMLPackage.Literals.OPERATION_CALL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OCLExpression<Classifier>> getArgument() {
		if (argument == null) {
			argument = new EObjectContainmentEList<OCLExpression<Classifier>>(
				OCLExpression.class, this,
				UMLPackage.OPERATION_CALL_EXP__ARGUMENT);
		}
		return argument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getReferredOperation() {
		if (referredOperation != null
			&& ((EObject) referredOperation).eIsProxy()) {
			InternalEObject oldReferredOperation = (InternalEObject) referredOperation;
			referredOperation = (Operation) eResolveProxy(oldReferredOperation);
			if (referredOperation != oldReferredOperation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						UMLPackage.OPERATION_CALL_EXP__REFERRED_OPERATION,
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
	public Operation basicGetReferredOperation() {
		return referredOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public void setReferredOperation(Operation newReferredOperation) {
		Operation oldReferredOperation = referredOperation;
		referredOperation = newReferredOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.OPERATION_CALL_EXP__REFERRED_OPERATION,
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
				Environment<?, Classifier, Operation, ?, ?, ?, ?, ?, ?, ?, ?, ?> env = Environment.Registry.INSTANCE
					.getEnvironmentFor(getSource());
				Classifier type = getSource().getType();

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
	 * @generated
	 */
	public boolean checkArgumentsConform(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return OperationCallExpOperations.checkArgumentsConform(this,
			diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
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
			case UMLPackage.OPERATION_CALL_EXP__ARGUMENT :
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
			case UMLPackage.OPERATION_CALL_EXP__ARGUMENT :
				return getArgument();
			case UMLPackage.OPERATION_CALL_EXP__REFERRED_OPERATION :
				if (resolve)
					return getReferredOperation();
				return basicGetReferredOperation();
			case UMLPackage.OPERATION_CALL_EXP__OPERATION_CODE :
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
			case UMLPackage.OPERATION_CALL_EXP__ARGUMENT :
				getArgument().clear();
				getArgument().addAll(
					(Collection<? extends OCLExpression<Classifier>>) newValue);
				return;
			case UMLPackage.OPERATION_CALL_EXP__REFERRED_OPERATION :
				setReferredOperation((Operation) newValue);
				return;
			case UMLPackage.OPERATION_CALL_EXP__OPERATION_CODE :
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
			case UMLPackage.OPERATION_CALL_EXP__ARGUMENT :
				getArgument().clear();
				return;
			case UMLPackage.OPERATION_CALL_EXP__REFERRED_OPERATION :
				setReferredOperation((Operation) null);
				return;
			case UMLPackage.OPERATION_CALL_EXP__OPERATION_CODE :
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
			case UMLPackage.OPERATION_CALL_EXP__ARGUMENT :
				return argument != null && !argument.isEmpty();
			case UMLPackage.OPERATION_CALL_EXP__REFERRED_OPERATION :
				return referredOperation != null;
			case UMLPackage.OPERATION_CALL_EXP__OPERATION_CODE :
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
				case UMLPackage.OPERATION_CALL_EXP__ARGUMENT :
					return ExpressionsPackage.OPERATION_CALL_EXP__ARGUMENT;
				case UMLPackage.OPERATION_CALL_EXP__REFERRED_OPERATION :
					return ExpressionsPackage.OPERATION_CALL_EXP__REFERRED_OPERATION;
				case UMLPackage.OPERATION_CALL_EXP__OPERATION_CODE :
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
					return UMLPackage.OPERATION_CALL_EXP__ARGUMENT;
				case ExpressionsPackage.OPERATION_CALL_EXP__REFERRED_OPERATION :
					return UMLPackage.OPERATION_CALL_EXP__REFERRED_OPERATION;
				case ExpressionsPackage.OPERATION_CALL_EXP__OPERATION_CODE :
					return UMLPackage.OPERATION_CALL_EXP__OPERATION_CODE;
				default :
					return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <T, U extends Visitor<T, ?, ?, ?, ?, ?, ?, ?, ?, ?>> T accept(U v) {
		return ((Visitor<T, Classifier, Operation, ?, ?, ?, ?, ?, ?, ?>) v)
			.visitOperationCallExp(this);
	}

} //OperationCallExpImpl
