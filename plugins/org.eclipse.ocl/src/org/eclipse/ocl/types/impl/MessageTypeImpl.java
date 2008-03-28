/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2008 IBM Corporation and others.
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
 * $Id: MessageTypeImpl.java,v 1.6 2008/03/28 20:33:33 cdamus Exp $
 */
package org.eclipse.ocl.types.impl;

import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.types.MessageType;
import org.eclipse.ocl.types.TypesPackage;
import org.eclipse.ocl.types.operations.MessageTypeOperations;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.UMLReflection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.types.impl.MessageTypeImpl#getReferredOperation <em>Referred Operation</em>}</li>
 *   <li>{@link org.eclipse.ocl.types.impl.MessageTypeImpl#getReferredSignal <em>Referred Signal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MessageTypeImpl<C, O, P> extends EObjectImpl implements MessageType<C, O, P> {
	/**
     * The cached value of the '{@link #getReferredOperation() <em>Referred Operation</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getReferredOperation()
     * @generated
     * @ordered
     */
	protected O referredOperation;

	/**
     * The cached value of the '{@link #getReferredSignal() <em>Referred Signal</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getReferredSignal()
     * @generated
     * @ordered
     */
	protected C referredSignal;

	private EList<O> operations;
	private EList<P> properties;
	
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected MessageTypeImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return TypesPackage.Literals.MESSAGE_TYPE;
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getName() {
		return SINGLETON_NAME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<O> oclOperations() {
		if (operations == null) {
			Environment<?, ?, O, ?, ?, ?, ?, ?, ?, ?, ?, ?> env =
				Environment.Registry.INSTANCE.getEnvironmentFor(this);
			
			operations = new BasicEList<O>(
					OCLStandardLibraryUtil.createMessageTypeOperations(env));
		}
		
		return operations;
	}

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean checkExclusiveSignature(DiagnosticChain diagnostics, Map<Object, Object> context) {
        return MessageTypeOperations.checkExclusiveSignature(this, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean checkOperationParameters(DiagnosticChain diagnostics, Map<Object, Object> context) {
        return MessageTypeOperations.checkOperationParameters(this, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean checkSignalAttributes(DiagnosticChain diagnostics, Map<Object, Object> context) {
        return MessageTypeOperations.checkSignalAttributes(this, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
	public O getReferredOperation() {
        if (referredOperation != null && ((EObject)referredOperation).eIsProxy()) {
            InternalEObject oldReferredOperation = (InternalEObject)referredOperation;
            referredOperation = (O)eResolveProxy(oldReferredOperation);
            if (referredOperation != oldReferredOperation) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, TypesPackage.MESSAGE_TYPE__REFERRED_OPERATION, oldReferredOperation, referredOperation));
            }
        }
        return referredOperation;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public O basicGetReferredOperation() {
        return referredOperation;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setReferredOperation(O newReferredOperation) {
        O oldReferredOperation = referredOperation;
        referredOperation = newReferredOperation;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.MESSAGE_TYPE__REFERRED_OPERATION, oldReferredOperation, referredOperation));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
	public C getReferredSignal() {
        if (referredSignal != null && ((EObject)referredSignal).eIsProxy()) {
            InternalEObject oldReferredSignal = (InternalEObject)referredSignal;
            referredSignal = (C)eResolveProxy(oldReferredSignal);
            if (referredSignal != oldReferredSignal) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, TypesPackage.MESSAGE_TYPE__REFERRED_SIGNAL, oldReferredSignal, referredSignal));
            }
        }
        return referredSignal;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public C basicGetReferredSignal() {
        return referredSignal;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setReferredSignal(C newReferredSignal) {
        C oldReferredSignal = referredSignal;
        referredSignal = newReferredSignal;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.MESSAGE_TYPE__REFERRED_SIGNAL, oldReferredSignal, referredSignal));
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public EList<P> oclProperties() {
		if (properties == null) {
			properties = new BasicEList<P>();
			
			Environment<?, C, O, P, ?, ?, ?, ?, ?, ?, ?, ?> env =
				Environment.Registry.INSTANCE.getEnvironmentFor(this);
			
            UMLReflection<?, C, O, P, ?, ?, ?, ?, ?, ?> uml = env.getUMLReflection();

			EList<?> typedElements;
			if (getReferredOperation() != null) {
				typedElements = new BasicEList(uml.getParameters(getReferredOperation()));
			} else if (getReferredSignal() != null) {
				typedElements = new BasicEList(uml.getAttributes(getReferredSignal()));
			} else {
				typedElements = ECollections.EMPTY_ELIST;
			}
			
			for (Object next : typedElements) {
				properties.add(uml.createProperty(uml.getName(next),
				        TypeUtil.resolveType(env, uml.getOCLType(next))));
			}
		}
		
		return properties;
	}

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case TypesPackage.MESSAGE_TYPE__REFERRED_OPERATION:
                if (resolve) return getReferredOperation();
                return basicGetReferredOperation();
            case TypesPackage.MESSAGE_TYPE__REFERRED_SIGNAL:
                if (resolve) return getReferredSignal();
                return basicGetReferredSignal();
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
            case TypesPackage.MESSAGE_TYPE__REFERRED_OPERATION:
                setReferredOperation((O)newValue);
                return;
            case TypesPackage.MESSAGE_TYPE__REFERRED_SIGNAL:
                setReferredSignal((C)newValue);
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
            case TypesPackage.MESSAGE_TYPE__REFERRED_OPERATION:
                setReferredOperation((O)null);
                return;
            case TypesPackage.MESSAGE_TYPE__REFERRED_SIGNAL:
                setReferredSignal((C)null);
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
            case TypesPackage.MESSAGE_TYPE__REFERRED_OPERATION:
                return referredOperation != null;
            case TypesPackage.MESSAGE_TYPE__REFERRED_SIGNAL:
                return referredSignal != null;
        }
        return super.eIsSet(featureID);
    }

} //MessageTypeImpl
