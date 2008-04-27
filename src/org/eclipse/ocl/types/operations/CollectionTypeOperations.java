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
 * $Id: CollectionTypeOperations.java,v 1.2 2008/04/27 23:16:03 cdamus Exp $
 */
package org.eclipse.ocl.types.operations;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.ocl.Environment;
import org.eclipse.ocl.types.CollectionType;

import org.eclipse.ocl.types.util.TypesValidator;
import org.eclipse.ocl.util.OCLUtil;

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
     * @generated NOT
     */
    public static <C, O> boolean checkCollectionTypeName(CollectionType<C, O> collectionType, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	boolean result = true;
    	Environment<?, C, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> env = OCLUtil
    			.getValidationEnvironment(collectionType, context);
    	
    	if (env != null) {
    		String name = collectionType.getName();
    		C elementType = collectionType.getElementType();
    		
    		if (elementType != null) {
    			String elementTypeName = env.getUMLReflection().getName(elementType);
    			
    			result = ("Collection(" + elementTypeName + ")").equals(name); //$NON-NLS-1$ //$NON-NLS-2$
    		}
    	}
    	
        if (!result) {
            if (diagnostics != null) {
            	// TODO: Specific message
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         TypesValidator.DIAGNOSTIC_SOURCE,
                         TypesValidator.COLLECTION_TYPE__COLLECTION_TYPE_NAME,
                         org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkCollectionTypeName", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(collectionType, context) }), //$NON-NLS-1$ //$NON-NLS-2$
                         new Object [] { collectionType }));
            }
        }
        return result;
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
     * @generated NOT
     */
    public static <C, O> boolean checkNoInvalidValues(CollectionType<C, O> collectionType, DiagnosticChain diagnostics, Map<Object, Object> context) {
        // This constraint is not implementable in this context.  It is an M1
    	// constraint defined (in error) on an M2 class
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
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public static <C, O> EList<O> oclIterators(CollectionType<C, O> collectionType) {
        return collectionType.oclIterators();
    }

} // CollectionTypeOperations