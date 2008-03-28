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
 * $Id: CollectionLiteralExpOperations.java,v 1.1 2008/03/28 20:33:32 cdamus Exp $
 */
package org.eclipse.ocl.expressions.operations;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.ocl.expressions.CollectionLiteralExp;

import org.eclipse.ocl.expressions.util.ExpressionsValidator;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Collection Literal Exp</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.CollectionLiteralExp#checkNoCollectionInstances(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check No Collection Instances</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.CollectionLiteralExp#checkSetKind(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Set Kind</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.CollectionLiteralExp#checkSequenceKind(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Sequence Kind</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.CollectionLiteralExp#checkBagKind(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Bag Kind</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.CollectionLiteralExp#checkElementType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Element Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionLiteralExpOperations {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CollectionLiteralExpOperations() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * kind <> CollectionKind::Collection
     * @param collectionLiteralExp The receiving '<em><b>Collection Literal Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated
     */
    public static <C> boolean checkNoCollectionInstances(CollectionLiteralExp<C> collectionLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
                         ExpressionsValidator.COLLECTION_LITERAL_EXP__NO_COLLECTION_INSTANCES,
                         org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkNoCollectionInstances", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(collectionLiteralExp, context) }), //$NON-NLS-1$ //$NON-NLS-2$
                         new Object [] { collectionLiteralExp }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * kind = CollectionKind::Set implies type.oclIsKindOf(SetType)
     * @param collectionLiteralExp The receiving '<em><b>Collection Literal Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated
     */
    public static <C> boolean checkSetKind(CollectionLiteralExp<C> collectionLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
                         ExpressionsValidator.COLLECTION_LITERAL_EXP__SET_KIND,
                         org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkSetKind", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(collectionLiteralExp, context) }), //$NON-NLS-1$ //$NON-NLS-2$
                         new Object [] { collectionLiteralExp }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * kind = CollectionKind::Sequence implies type.oclIsKindOf(SequenceType)
     * @param collectionLiteralExp The receiving '<em><b>Collection Literal Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated
     */
    public static <C> boolean checkSequenceKind(CollectionLiteralExp<C> collectionLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
                         ExpressionsValidator.COLLECTION_LITERAL_EXP__SEQUENCE_KIND,
                         org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkSequenceKind", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(collectionLiteralExp, context) }), //$NON-NLS-1$ //$NON-NLS-2$
                         new Object [] { collectionLiteralExp }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * kind = CollectionKind::Bag implies type.oclIsKindOf(BagType)
     * @param collectionLiteralExp The receiving '<em><b>Collection Literal Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated
     */
    public static <C> boolean checkBagKind(CollectionLiteralExp<C> collectionLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
                         ExpressionsValidator.COLLECTION_LITERAL_EXP__BAG_KIND,
                         org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkBagKind", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(collectionLiteralExp, context) }), //$NON-NLS-1$ //$NON-NLS-2$
                         new Object [] { collectionLiteralExp }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * type.oclAsType(CollectionType).elementType = part->iterate(p; c : Classifier = OclVoid | c.commonSuperType(p.type))
     * @param collectionLiteralExp The receiving '<em><b>Collection Literal Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated
     */
    public static <C> boolean checkElementType(CollectionLiteralExp<C> collectionLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
                         ExpressionsValidator.COLLECTION_LITERAL_EXP__ELEMENT_TYPE,
                         org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkElementType", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(collectionLiteralExp, context) }), //$NON-NLS-1$ //$NON-NLS-2$
                         new Object [] { collectionLiteralExp }));
            }
            return false;
        }
        return true;
    }

} // CollectionLiteralExpOperations