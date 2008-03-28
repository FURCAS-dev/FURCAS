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
 * $Id: TupleLiteralExpOperations.java,v 1.1 2008/03/28 20:33:32 cdamus Exp $
 */
package org.eclipse.ocl.expressions.operations;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.ocl.expressions.TupleLiteralExp;

import org.eclipse.ocl.expressions.util.ExpressionsValidator;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Tuple Literal Exp</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.TupleLiteralExp#checkTupleType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Tuple Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.TupleLiteralExp#checkPartsUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Parts Unique</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TupleLiteralExpOperations {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TupleLiteralExpOperations() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * type.oclIsKindOf (TupleType)
     * and
     * part->forAll (tlep |
     * type.oclAsType (TupleType).allProperties()->exists (tp | tlep.attribute = tp))
     * and
     * part->size() = type.oclAsType (TupleType).allProperties()->size()
     * @param tupleLiteralExp The receiving '<em><b>Tuple Literal Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated
     */
    public static <C, P> boolean checkTupleType(TupleLiteralExp<C, P> tupleLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
                         ExpressionsValidator.TUPLE_LITERAL_EXP__TUPLE_TYPE,
                         org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkTupleType", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(tupleLiteralExp, context) }), //$NON-NLS-1$ //$NON-NLS-2$
                         new Object [] { tupleLiteralExp }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * part->isUnique (attribute.name)
     * @param tupleLiteralExp The receiving '<em><b>Tuple Literal Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated
     */
    public static <C, P> boolean checkPartsUnique(TupleLiteralExp<C, P> tupleLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
                         ExpressionsValidator.TUPLE_LITERAL_EXP__PARTS_UNIQUE,
                         org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkPartsUnique", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(tupleLiteralExp, context) }), //$NON-NLS-1$ //$NON-NLS-2$
                         new Object [] { tupleLiteralExp }));
            }
            return false;
        }
        return true;
    }

} // TupleLiteralExpOperations