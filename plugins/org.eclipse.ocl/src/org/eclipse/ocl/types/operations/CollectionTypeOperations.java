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
 * $Id: CollectionTypeOperations.java,v 1.1 2008/03/28 20:33:33 cdamus Exp $
 */
package org.eclipse.ocl.types.operations;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.ocl.types.CollectionType;

import org.eclipse.ocl.types.util.TypesValidator;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Collection Type</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.types.CollectionType#checkCollectionTypeName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Collection Type Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.types.CollectionType#checkNoInvalidValues(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check No Invalid Values</em>}</li>
 *   <li>{@link org.eclipse.ocl.types.CollectionType#oclIterators() <em>Ocl Iterators</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionTypeOperations {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CollectionTypeOperations() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * self.name = 'Collection(' + self.elementType.name + ')'
     * @param collectionType The receiving '<em><b>Collection Type</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated
     */
    public static <C, O> boolean checkCollectionTypeName(CollectionType<C, O> collectionType, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
                         TypesValidator.COLLECTION_TYPE__COLLECTION_TYPE_NAME,
                         org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkCollectionTypeName", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(collectionType, context) }), //$NON-NLS-1$ //$NON-NLS-2$
                         new Object [] { collectionType }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * self->forAll(not oclIsInvalid())
     * @param collectionType The receiving '<em><b>Collection Type</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated
     */
    public static <C, O> boolean checkNoInvalidValues(CollectionType<C, O> collectionType, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
                         TypesValidator.COLLECTION_TYPE__NO_INVALID_VALUES,
                         org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkNoInvalidValues", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(collectionType, context) }), //$NON-NLS-1$ //$NON-NLS-2$
                         new Object [] { collectionType }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static <C, O> EList<Object> oclIterators(CollectionType<C, O> collectionType) {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
    }

} // CollectionTypeOperations