/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2007 IBM Corporation and others.
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
 * $Id: MessageType.java,v 1.5 2008/03/28 20:33:34 cdamus Exp $
 */
package org.eclipse.ocl.types;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.utilities.PredefinedType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.types.MessageType#getReferredOperation <em>Referred Operation</em>}</li>
 *   <li>{@link org.eclipse.ocl.types.MessageType#getReferredSignal <em>Referred Signal</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.types.TypesPackage#getMessageType()
 * @model
 * @generated
 */
public interface MessageType<C, O, P> extends PredefinedType<O> {
	String SINGLETON_NAME = "OclMessage"; //$NON-NLS-1$

	/**
     * Returns the value of the '<em><b>Referred Operation</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Operation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Referred Operation</em>' reference.
     * @see #setReferredOperation(Object)
     * @see org.eclipse.ocl.types.TypesPackage#getMessageType_ReferredOperation()
     * @model kind="reference"
     * @generated
     */
	O getReferredOperation();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.types.MessageType#getReferredOperation <em>Referred Operation</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Referred Operation</em>' reference.
     * @see #getReferredOperation()
     * @generated
     */
	void setReferredOperation(O value);

	/**
     * Returns the value of the '<em><b>Referred Signal</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Signal</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Referred Signal</em>' reference.
     * @see #setReferredSignal(Object)
     * @see org.eclipse.ocl.types.TypesPackage#getMessageType_ReferredSignal()
     * @model kind="reference"
     * @generated
     */
	C getReferredSignal();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.types.MessageType#getReferredSignal <em>Referred Signal</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Referred Signal</em>' reference.
     * @see #getReferredSignal()
     * @generated
     */
	void setReferredSignal(C value);

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * referredOperation->size() + referredSignal->size() = 1
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @model
     * @generated
     */
    boolean checkExclusiveSignature(DiagnosticChain diagnostics, Map<Object, Object> context);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * referredOperation->size()=1 implies
     * Set{1..self.ownedAttribute->size()}->forAll(i | self.ownedAttribute.at(i).cmpSlots(
     * referredOperation.ownedParameter.asProperty()->at(i))
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @model
     * @generated
     */
    boolean checkOperationParameters(DiagnosticChain diagnostics, Map<Object, Object> context);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * referredSignal->size() = 1 implies
     * Set{1..self.ownedAttribute->size()}->forAll(i | self.ownedAttribute.asOrderedSet().at(i).cmpSlots(
     * referredSignal.ownedAttribute.asOrderedSet()->at(i))
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @model
     * @generated
     */
    boolean checkSignalAttributes(DiagnosticChain diagnostics, Map<Object, Object> context);

    /**
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @model
     * @generated
     */
	EList<P> oclProperties();

} // MessageType
