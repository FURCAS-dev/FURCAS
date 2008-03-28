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
 * $Id: LoopExpOperations.java,v 1.1 2008/03/28 20:33:32 cdamus Exp $
 */
package org.eclipse.ocl.expressions.operations;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.ocl.expressions.LoopExp;

import org.eclipse.ocl.expressions.util.ExpressionsValidator;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Loop Exp</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.LoopExp#checkSourceCollection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Source Collection</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.LoopExp#checkLoopVariableInit(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Loop Variable Init</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.LoopExp#checkLoopVariableType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Loop Variable Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoopExpOperations {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected LoopExpOperations() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * source.type.oclIsKindOf(CollectionType)
     * @param loopExp The receiving '<em><b>Loop Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated
     */
    public static <C, PM> boolean checkSourceCollection(LoopExp<C, PM> loopExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
                         ExpressionsValidator.LOOP_EXP__SOURCE_COLLECTION,
                         org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkSourceCollection", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(loopExp, context) }), //$NON-NLS-1$ //$NON-NLS-2$
                         new Object [] { loopExp }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * self.iterator->forAll(initExpression->isEmpty())
     * @param loopExp The receiving '<em><b>Loop Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated
     */
    public static <C, PM> boolean checkLoopVariableInit(LoopExp<C, PM> loopExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
                         ExpressionsValidator.LOOP_EXP__LOOP_VARIABLE_INIT,
                         org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkLoopVariableInit", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(loopExp, context) }), //$NON-NLS-1$ //$NON-NLS-2$
                         new Object [] { loopExp }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * self.iterator->forAll(type = source.type.oclAsType(CollectionType).elementType)
     * @param loopExp The receiving '<em><b>Loop Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated
     */
    public static <C, PM> boolean checkLoopVariableType(LoopExp<C, PM> loopExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
                         ExpressionsValidator.LOOP_EXP__LOOP_VARIABLE_TYPE,
                         org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkLoopVariableType", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(loopExp, context) }), //$NON-NLS-1$ //$NON-NLS-2$
                         new Object [] { loopExp }));
            }
            return false;
        }
        return true;
    }

} // LoopExpOperations