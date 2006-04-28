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
 * $Id: MessageTypeImpl.java,v 1.5 2006/04/28 14:46:28 cdamus Exp $
 */

package org.eclipse.emf.ocl.types.impl;

import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ocl.internal.l10n.OCLMessages;
import org.eclipse.emf.ocl.internal.parser.OCLParser;
import org.eclipse.emf.ocl.parser.SemanticException;
import org.eclipse.emf.ocl.types.MessageType;
import org.eclipse.emf.ocl.types.TypesPackage;
import org.eclipse.emf.ocl.types.util.Types;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.types.impl.MessageTypeImpl#getReferredOperation <em>Referred Operation</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.types.impl.MessageTypeImpl#getReferredSignal <em>Referred Signal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MessageTypeImpl extends EClassImpl implements MessageType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = ""; //$NON-NLS-1$
	
	public static final MessageType INSTANCE = new MessageTypeImpl("OclMessage"); //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getReferredSignal() <em>Referred Signal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredSignal()
	 * @generated
	 * @ordered
	 */
	protected EClass referredSignal = null;

	/**
	 * The cached value of the '{@link #getReferredOperation() <em>Referred Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredOperation()
	 * @generated
	 * @ordered
	 */
	protected EOperation referredOperation = null;
	
	/*
	 * Operations for MessageType
	 */
	private static EList operations = null;

	/**
	 * Initialiaze Operations defined on MessageType
	 */
	protected static EList createOperations() {
		if (operations == null) {
			operations = new BasicEList();
			
			operations.add(TypeUtil.createUnaryOperation(Types.OCL_BOOLEAN,
					HAS_RETURNED_NAME));
			operations.add(TypeUtil.createUnaryOperation(AnyTypeImpl.OCL_T,
					RESULT_NAME));
			operations.add(TypeUtil.createUnaryOperation(Types.OCL_BOOLEAN,
					IS_SIGNAL_SENT_NAME));
			operations.add(TypeUtil.createUnaryOperation(Types.OCL_BOOLEAN,
					IS_OPERATION_CALL_NAME));
			
			operations.addAll(AnyTypeImpl.createAnyOperations());
		}
		
		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MessageTypeImpl() {
		super();
	}

	protected MessageTypeImpl(String name) {
		this();
		setName(name);
	}
	
	public String getName() {
		if (name == null) {
			ENamedElement elem = (getReferredOperation() != null)?
					(ENamedElement) getReferredOperation() :
						(ENamedElement) getReferredSignal();
			
			if (elem == null) {
				name = "OclMessage(?)"; //$NON-NLS-1$
			} else {
				name = "OclMessage(" + elem.getName() + ')'; //$NON-NLS-1$
			}
		}
		
		return super.getName();
	}

	/**
	 * Creates the type for the messages representing invocation of the
	 * specified behavioralFeature.
	 * 
	 * @param behavioralFeature either an {@link EOperation} or an
	 *     {@link EClass} representing a received signal
	 * 
	 * @return the message type
	 */
	protected static MessageType createMessageType(ENamedElement behavioralFeature) {
		MessageType result = new MessageTypeImpl();
		EList properties = result.getEStructuralFeatures();
		EList typedElements;
		
		if (behavioralFeature instanceof EOperation) {
			EOperation operation = (EOperation) behavioralFeature;
			result.setReferredOperation(operation);
			typedElements = operation.getEParameters();
		} else if (behavioralFeature instanceof EClass) {
			EClass signal = (EClass) behavioralFeature;
			result.setReferredSignal(signal);
			typedElements = signal.getEAllStructuralFeatures();
		} else {
			typedElements = ECollections.EMPTY_ELIST;
		}
		
		for (Iterator iter = typedElements.iterator(); iter.hasNext();) {
			ETypedElement next = (ETypedElement) iter.next();
			properties.add(TypeUtil.createProperty(next));
		}
		
		return result;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return TypesPackage.Literals.MESSAGE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferredSignal() {
		if (referredSignal != null && referredSignal.eIsProxy()) {
			InternalEObject oldReferredSignal = (InternalEObject)referredSignal;
			referredSignal = (EClass)eResolveProxy(oldReferredSignal);
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
	public EClass basicGetReferredSignal() {
		return referredSignal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredSignal(EClass newReferredSignal) {
		EClass oldReferredSignal = referredSignal;
		referredSignal = newReferredSignal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.MESSAGE_TYPE__REFERRED_SIGNAL, oldReferredSignal, referredSignal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList getOperations() {
		if (operations == null) {
			return createOperations();
		}
		
		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getOperationNameFor(int opcode) {
		switch (opcode) {
		case HAS_RETURNED:
			return HAS_RETURNED_NAME;
		case RESULT:
			return RESULT_NAME;
		case IS_SIGNAL_SENT:
			return IS_SIGNAL_SENT_NAME;
		case IS_OPERATION_CALL:
			return IS_OPERATION_CALL_NAME;
		}
		
		return AnyTypeImpl.getOperationName(opcode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getOperationCodeFor(String operName) {
		if (HAS_RETURNED_NAME.equals(operName)) return HAS_RETURNED;
		if (RESULT_NAME.equals(operName)) return RESULT;
		if (IS_SIGNAL_SENT_NAME.equals(operName)) return IS_SIGNAL_SENT;
		if (IS_OPERATION_CALL_NAME.equals(operName)) return IS_OPERATION_CALL;

		return AnyTypeImpl.getOperationCode(operName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EClassifier getResultTypeFor(EClassifier ownerType, int opcode, EList args) throws SemanticException {
		switch (opcode) {
		case HAS_RETURNED:
		case IS_SIGNAL_SENT:
		case IS_OPERATION_CALL:
			return Types.OCL_BOOLEAN;
		case RESULT:
			return (getReferredOperation() == null)?
					Types.INVALID : getReferredOperation().getEType();
		}
		
		return AnyTypeImpl.getResultType(ownerType, opcode, args);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getRelationshipTo(EClassifier type) {

		if (this == type)
			return SAME_TYPE;
		
		if (type instanceof MessageType) {
			MessageType other = (MessageType) type;

			if ((getReferredOperation() != null)
					&& (getReferredOperation() == other.getReferredOperation())) {
				return SAME_TYPE;
			} else if ((getReferredSignal() != null)
					&& (getReferredSignal() == other.getReferredSignal())) {
				return SAME_TYPE;
			} else if (this == Types.OCL_MESSAGE) {
				return STRICT_SUPERTYPE;
			}
		}
		
		if (type == Types.OCL_MESSAGE)
			return STRICT_SUBTYPE;
		
		return UNRELATED_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EClassifier getCommonSupertype(EClassifier type) throws SemanticException {
		if (this == type) {
			return this;
		}
		
		if (type instanceof MessageType) {
			return Types.OCL_MESSAGE;
		}

		String message = OCLMessages.bind(
				OCLMessages.TypeMismatch_ERROR_,
				this.getName(),
				TypeUtil.getName(type));
		OCLParser.ERR(message);
		
		// don't get this far
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TypesPackage.MESSAGE_TYPE__REFERRED_OPERATION:
				setReferredOperation((EOperation)newValue);
				return;
			case TypesPackage.MESSAGE_TYPE__REFERRED_SIGNAL:
				setReferredSignal((EClass)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case TypesPackage.MESSAGE_TYPE__REFERRED_OPERATION:
				setReferredOperation((EOperation)null);
				return;
			case TypesPackage.MESSAGE_TYPE__REFERRED_SIGNAL:
				setReferredSignal((EClass)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TypesPackage.MESSAGE_TYPE__REFERRED_OPERATION:
				return referredOperation != null;
			case TypesPackage.MESSAGE_TYPE__REFERRED_SIGNAL:
				return referredSignal != null;
		}
		return super.eIsSet(featureID);
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
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.MESSAGE_TYPE__REFERRED_OPERATION, oldReferredOperation, referredOperation));
	}

} //MessageTypeImpl
