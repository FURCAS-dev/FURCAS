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
 * $Id: MessageExpOperations.java,v 1.1 2008/03/28 20:33:32 cdamus Exp $
 */
package org.eclipse.ocl.expressions.operations;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.ocl.expressions.MessageExp;

import org.eclipse.ocl.expressions.util.ExpressionsValidator;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Message Exp</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.MessageExp#checkOperationArguments(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Operation Arguments</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.MessageExp#checkSignalArguments(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Signal Arguments</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.MessageExp#checkTargetDefinesOperation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Target Defines Operation</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.MessageExp#checkHasOperationOrSignal(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Has Operation Or Signal</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.MessageExp#checkTargetNotCollection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Target Not Collection</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MessageExpOperations {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MessageExpOperations() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * calledOperation->notEmpty() implies
     * argument->forall (a | a.type.conformsTo
     * (self.calledOperation.operation.ownedParameter->
     * select( kind = ParameterDirectionKind::in )
     * ->at (argument->indexOf (a)).type))
     * @param messageExp The receiving '<em><b>Message Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated
     */
    public static <C, COA, SSA> boolean checkOperationArguments(MessageExp<C, COA, SSA> messageExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         ExpressionsValidator.DIAGNOSTIC_SOURCE,
                         ExpressionsValidator.MESSAGE_EXP__OPERATION_ARGUMENTS,
                         org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkOperationArguments", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(messageExp, context) }), //$NON-NLS-1$ //$NON-NLS-2$
                         new Object [] { messageExp }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * sentSignal->notEmpty() implies
     * argument->forall (a | a.type.conformsTo
     * (self.sentSignal.signal.ownedAttribute
     * ->at (argument->indexOf (a)).type))
     * @param messageExp The receiving '<em><b>Message Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated
     */
    public static <C, COA, SSA> boolean checkSignalArguments(MessageExp<C, COA, SSA> messageExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         ExpressionsValidator.DIAGNOSTIC_SOURCE,
                         ExpressionsValidator.MESSAGE_EXP__SIGNAL_ARGUMENTS,
                         org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkSignalArguments", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(messageExp, context) }), //$NON-NLS-1$ //$NON-NLS-2$
                         new Object [] { messageExp }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * calledOperation->notEmpty() implies
     * target.type.allOperations()->includes(calledOperation.operation)
     * @param messageExp The receiving '<em><b>Message Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated
     */
    public static <C, COA, SSA> boolean checkTargetDefinesOperation(MessageExp<C, COA, SSA> messageExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         ExpressionsValidator.DIAGNOSTIC_SOURCE,
                         ExpressionsValidator.MESSAGE_EXP__TARGET_DEFINES_OPERATION,
                         org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkTargetDefinesOperation", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(messageExp, context) }), //$NON-NLS-1$ //$NON-NLS-2$
                         new Object [] { messageExp }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * calledOperation->size() + sentSignal->size() = 1
     * @param messageExp The receiving '<em><b>Message Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated
     */
    public static <C, COA, SSA> boolean checkHasOperationOrSignal(MessageExp<C, COA, SSA> messageExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         ExpressionsValidator.DIAGNOSTIC_SOURCE,
                         ExpressionsValidator.MESSAGE_EXP__HAS_OPERATION_OR_SIGNAL,
                         org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkHasOperationOrSignal", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(messageExp, context) }), //$NON-NLS-1$ //$NON-NLS-2$
                         new Object [] { messageExp }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * not target.type.oclIsKindOf(CollectionType)
     * @param messageExp The receiving '<em><b>Message Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated
     */
    public static <C, COA, SSA> boolean checkTargetNotCollection(MessageExp<C, COA, SSA> messageExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         ExpressionsValidator.DIAGNOSTIC_SOURCE,
                         ExpressionsValidator.MESSAGE_EXP__TARGET_NOT_COLLECTION,
                         org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkTargetNotCollection", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(messageExp, context) }), //$NON-NLS-1$ //$NON-NLS-2$
                         new Object [] { messageExp }));
            }
            return false;
        }
        return true;
    }

} // MessageExpOperations