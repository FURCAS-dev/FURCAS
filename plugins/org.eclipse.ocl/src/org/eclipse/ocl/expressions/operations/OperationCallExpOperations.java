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
 * $Id: OperationCallExpOperations.java,v 1.1 2008/03/28 20:33:32 cdamus Exp $
 */
package org.eclipse.ocl.expressions.operations;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.ocl.expressions.OperationCallExp;

import org.eclipse.ocl.expressions.util.ExpressionsValidator;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Operation Call Exp</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.OperationCallExp#checkArgumentsConform(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Arguments Conform</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.OperationCallExp#checkArgumentCount(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Argument Count</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationCallExpOperations {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected OperationCallExpOperations() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * arguments->forall (a | a.type.conformsTo
     * (self.refParams->at (arguments->indexOf (a)).type))
     * @param operationCallExp The receiving '<em><b>Operation Call Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated
     */
    public static <C, O> boolean checkArgumentsConform(OperationCallExp<C, O> operationCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
                         ExpressionsValidator.OPERATION_CALL_EXP__ARGUMENTS_CONFORM,
                         org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkArgumentsConform", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(operationCallExp, context) }), //$NON-NLS-1$ //$NON-NLS-2$
                         new Object [] { operationCallExp }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * arguments->size() = refParams->size()
     * @param operationCallExp The receiving '<em><b>Operation Call Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated
     */
    public static <C, O> boolean checkArgumentCount(OperationCallExp<C, O> operationCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
                         ExpressionsValidator.OPERATION_CALL_EXP__ARGUMENT_COUNT,
                         org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkArgumentCount", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(operationCallExp, context) }), //$NON-NLS-1$ //$NON-NLS-2$
                         new Object [] { operationCallExp }));
            }
            return false;
        }
        return true;
    }

} // OperationCallExpOperations