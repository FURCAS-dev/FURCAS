/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: OperationCallExpImpl.java,v 1.6 2007/10/11 23:05:16 cdamus Exp $
 */

package org.eclipse.emf.ocl.expressions.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ocl.expressions.ExpressionsPackage;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.OperationCallExp;
import org.eclipse.emf.ocl.expressions.Visitor;
import org.eclipse.emf.ocl.types.impl.AnyTypeImpl;
import org.eclipse.emf.ocl.utilities.PredefinedType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.expressions.impl.OperationCallExpImpl#getArgument <em>Argument</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.expressions.impl.OperationCallExpImpl#getReferredOperation <em>Referred Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationCallExpImpl extends FeatureCallExpImpl implements OperationCallExp {
	
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final String copyright = ""; //$NON-NLS-1$

	/**
     * The cached value of the '{@link #getArgument() <em>Argument</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getArgument()
     * @generated
     * @ordered
     */
	protected EList argument;

	private int operationCode = -1;
	
	/**
	 * The opertion code is a constant code for the operation, that can be
	 * used by an evaluator for efficiency.
	 * The operation codes are defined in PrimitiveTypeImpl, CollectionTypeImpl,
	 * and AnyTypeImpl.
	 * @return the opcode
	 */
	public int getOperationCode() {
		if (operationCode < 0) {
			if (getSource() != null) {
				EClassifier type = getSource().getType();

				if (getReferredOperation() != null) {
					String operName = getReferredOperation().getName();
					
					if ((type instanceof PredefinedType) && (getReferredOperation() != null)) {
						operationCode = ((PredefinedType) type).getOperationCodeFor(operName);
					} else {
						// not a predefined type?  Model types have the AnyType operations
						operationCode = AnyTypeImpl.getOperationCode(operName);
					}
				}
			} else {
				operationCode = 0;
			}
		}
		
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
	protected EOperation referredOperation;

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
        return ExpressionsPackage.Literals.OPERATION_CALL_EXP;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList getArgument() {
        if (argument == null) {
            argument = new EObjectContainmentEList(OCLExpression.class, this, ExpressionsPackage.OPERATION_CALL_EXP__ARGUMENT);
        }
        return argument;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EOperation getReferredOperation() {
        if (referredOperation != null && referredOperation.eIsProxy()) {
            InternalEObject oldReferredOperation = (InternalEObject)referredOperation;
            referredOperation = (EOperation)eResolveProxy(oldReferredOperation);
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
	@Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ExpressionsPackage.OPERATION_CALL_EXP__ARGUMENT:
                return ((InternalEList)getArgument()).basicRemove(otherEnd, msgs);
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
            case ExpressionsPackage.OPERATION_CALL_EXP__ARGUMENT:
                return getArgument();
            case ExpressionsPackage.OPERATION_CALL_EXP__REFERRED_OPERATION:
                if (resolve) return getReferredOperation();
                return basicGetReferredOperation();
        }
        return super.eGet(featureID, resolve, coreType);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ExpressionsPackage.OPERATION_CALL_EXP__ARGUMENT:
                getArgument().clear();
                getArgument().addAll((Collection)newValue);
                return;
            case ExpressionsPackage.OPERATION_CALL_EXP__REFERRED_OPERATION:
                setReferredOperation((EOperation)newValue);
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
            case ExpressionsPackage.OPERATION_CALL_EXP__ARGUMENT:
                getArgument().clear();
                return;
            case ExpressionsPackage.OPERATION_CALL_EXP__REFERRED_OPERATION:
                setReferredOperation((EOperation)null);
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
            case ExpressionsPackage.OPERATION_CALL_EXP__ARGUMENT:
                return argument != null && !argument.isEmpty();
            case ExpressionsPackage.OPERATION_CALL_EXP__REFERRED_OPERATION:
                return referredOperation != null;
        }
        return super.eIsSet(featureID);
    }

	@Override
    public Object accept(Visitor v) {
		return v.visitOperationCallExp(this);
	}

} //OperationCallExpImpl
