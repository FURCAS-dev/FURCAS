/**
 * <copyright>
 * 
 * Copyright (c) 2008 IBM Corporation and others.
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
 * $Id: MessageTypeOperations.java,v 1.2 2008/04/27 23:16:03 cdamus Exp $
 */
package org.eclipse.ocl.types.operations;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.ocl.types.MessageType;

import org.eclipse.ocl.types.util.TypesValidator;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Message Type</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.types.MessageType#checkExclusiveSignature(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Exclusive Signature</em>}</li>
 *   <li>{@link org.eclipse.ocl.types.MessageType#checkOperationParameters(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Operation Parameters</em>}</li>
 *   <li>{@link org.eclipse.ocl.types.MessageType#checkSignalAttributes(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Signal Attributes</em>}</li>
 *   <li>{@link org.eclipse.ocl.types.MessageType#oclProperties() <em>Ocl Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MessageTypeOperations {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MessageTypeOperations() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * referredOperation->size() + referredSignal->size() = 1
     * @param messageType The receiving '<em><b>Message Type</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated NOT
     */
    public static <C, O, P> boolean checkExclusiveSignature(MessageType<C, O, P> messageType, DiagnosticChain diagnostics, Map<Object, Object> context) {
        O oper = messageType.getReferredOperation();
        C sig = messageType.getReferredSignal();
        
    	boolean result = ((oper != null) && (sig == null))
				|| ((oper == null) && (sig != null));
    	
    	if (!result) {
            if (diagnostics != null) {
            	// Specific message
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         TypesValidator.DIAGNOSTIC_SOURCE,
                         TypesValidator.MESSAGE_TYPE__EXCLUSIVE_SIGNATURE,
                         org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkExclusiveSignature", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(messageType, context) }), //$NON-NLS-1$ //$NON-NLS-2$
                         new Object [] { messageType }));
            }
        }
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * referredOperation->size()=1 implies
     * Set{1..self.ownedAttribute->size()}->forAll(i | self.ownedAttribute.at(i).cmpSlots(
     * referredOperation.ownedParameter.asProperty()->at(i))
     * @param messageType The receiving '<em><b>Message Type</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated
     */
    public static <C, O, P> boolean checkOperationParameters(MessageType<C, O, P> messageType, DiagnosticChain diagnostics, Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         TypesValidator.DIAGNOSTIC_SOURCE,
                         TypesValidator.MESSAGE_TYPE__OPERATION_PARAMETERS,
                         org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkOperationParameters", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(messageType, context) }), //$NON-NLS-1$ //$NON-NLS-2$
                         new Object [] { messageType }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * referredSignal->size() = 1 implies
     * Set{1..self.ownedAttribute->size()}->forAll(i | self.ownedAttribute.asOrderedSet().at(i).cmpSlots(
     * referredSignal.ownedAttribute.asOrderedSet()->at(i))
     * @param messageType The receiving '<em><b>Message Type</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated
     */
    public static <C, O, P> boolean checkSignalAttributes(MessageType<C, O, P> messageType, DiagnosticChain diagnostics, Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         TypesValidator.DIAGNOSTIC_SOURCE,
                         TypesValidator.MESSAGE_TYPE__SIGNAL_ATTRIBUTES,
                         org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkSignalAttributes", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(messageType, context) }), //$NON-NLS-1$ //$NON-NLS-2$
                         new Object [] { messageType }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public static <C, O, P> EList<P> oclProperties(MessageType<C, O, P> messageType) {
        return messageType.oclProperties();
    }

} // MessageTypeOperations