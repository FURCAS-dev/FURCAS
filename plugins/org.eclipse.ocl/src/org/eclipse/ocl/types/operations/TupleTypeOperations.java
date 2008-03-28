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
 * $Id: TupleTypeOperations.java,v 1.1 2008/03/28 20:33:33 cdamus Exp $
 */
package org.eclipse.ocl.types.operations;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.ocl.types.TupleType;

import org.eclipse.ocl.types.util.TypesValidator;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Tuple Type</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.types.TupleType#checkTupleTypeName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Tuple Type Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.types.TupleType#checkPartNamesUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Part Names Unique</em>}</li>
 *   <li>{@link org.eclipse.ocl.types.TupleType#checkFeaturesOnlyProperties(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Features Only Properties</em>}</li>
 *   <li>{@link org.eclipse.ocl.types.TupleType#oclProperties() <em>Ocl Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TupleTypeOperations {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TupleTypeOperations() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * name =
     * 'Tuple('.concat (
     * Sequence{1..allProperties()->size()}->iterate (pn; s: String = '' |
     * let p: Property = allProperties()->at (pn) in (
     * s.concat (
     * (if (pn>1) then ',' else '' endif)
     * .concat (p.name).concat (': ')
     * .concat (p.type.name)
     * )
     * )
     * )
     * ).concat (')')
     * @param tupleType The receiving '<em><b>Tuple Type</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated
     */
    public static <O, P> boolean checkTupleTypeName(TupleType<O, P> tupleType, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
                         TypesValidator.TUPLE_TYPE__TUPLE_TYPE_NAME,
                         org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkTupleTypeName", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(tupleType, context) }), //$NON-NLS-1$ //$NON-NLS-2$
                         new Object [] { tupleType }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * true
     * @param tupleType The receiving '<em><b>Tuple Type</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated
     */
    public static <O, P> boolean checkPartNamesUnique(TupleType<O, P> tupleType, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
                         TypesValidator.TUPLE_TYPE__PART_NAMES_UNIQUE,
                         org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkPartNamesUnique", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(tupleType, context) }), //$NON-NLS-1$ //$NON-NLS-2$
                         new Object [] { tupleType }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * feature->forAll (f | f.oclIsTypeOf(Property))
     * @param tupleType The receiving '<em><b>Tuple Type</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated
     */
    public static <O, P> boolean checkFeaturesOnlyProperties(TupleType<O, P> tupleType, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
                         TypesValidator.TUPLE_TYPE__FEATURES_ONLY_PROPERTIES,
                         org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkFeaturesOnlyProperties", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(tupleType, context) }), //$NON-NLS-1$ //$NON-NLS-2$
                         new Object [] { tupleType }));
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
    public static <O, P> EList<P> oclProperties(TupleType<O, P>  tupleType) {
        return tupleType.oclProperties();
    }

} // TupleTypeOperations