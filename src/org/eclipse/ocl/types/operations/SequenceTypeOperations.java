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
 * $Id: SequenceTypeOperations.java,v 1.3 2008/05/05 16:47:41 cdamus Exp $
 */
package org.eclipse.ocl.types.operations;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.ocl.Environment;
import org.eclipse.ocl.types.SequenceType;

import org.eclipse.ocl.types.util.TypesValidator;
import org.eclipse.ocl.util.OCLUtil;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Sequence Type</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.types.SequenceType#checkCollectionTypeName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Collection Type Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SequenceTypeOperations extends CollectionTypeOperations {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SequenceTypeOperations() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * self.name = 'Sequence(' + self.elementType.name + ')'
     * @param sequenceType The receiving '<em><b>Sequence Type</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated NOT
     */
    public static <C, O> boolean checkCollectionTypeName(SequenceType<C, O> sequenceType, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	boolean result = true;
    	Environment<?, C, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> env = OCLUtil
    			.getValidationEnvironment(sequenceType, context);
    	
    	if (env != null) {
    		String name = sequenceType.getName();
    		C elementType = sequenceType.getElementType();
    		
    		if (elementType != null) {
    			String elementTypeName = env.getUMLReflection().getName(elementType);
    			
    			result = ("Sequence(" + elementTypeName + ")").equals(name); //$NON-NLS-1$ //$NON-NLS-2$
    		}
    	}
    	
        if (!result) {
            if (diagnostics != null) {
            	// TODO: Specific message
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         TypesValidator.DIAGNOSTIC_SOURCE,
                         TypesValidator.SEQUENCE_TYPE__COLLECTION_TYPE_NAME,
                         org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkCollectionTypeName", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(sequenceType, context) }), //$NON-NLS-1$ //$NON-NLS-2$
                         new Object [] { sequenceType }));
            }
        }
        return result;
    }

} // SequenceTypeOperations