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
 * $Id: CollectionItemOperations.java,v 1.2 2008/04/27 23:16:03 cdamus Exp $
 */
package org.eclipse.ocl.expressions.operations;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.ocl.Environment;
import org.eclipse.ocl.expressions.CollectionItem;
import org.eclipse.ocl.expressions.OCLExpression;

import org.eclipse.ocl.expressions.util.ExpressionsValidator;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.ocl.util.TypeUtil;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Collection Item</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.CollectionItem#checkItemType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Item Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionItemOperations {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CollectionItemOperations() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * type = item.type
     * @param collectionItem The receiving '<em><b>Collection Item</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated NOT
     */
    public static <C> boolean checkItemType(CollectionItem<C> collectionItem, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	boolean result = true;
    	Environment<?, C, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> env = OCLUtil
    		.getValidationEnvironment(collectionItem, context);
    	
    	if (env != null) {
	    	OCLExpression<C> item = collectionItem.getItem();
	    	C type = collectionItem.getType();
	    	
	    	if ((item != null) && (item.getType() != null) && (type != null)) {
	    		result = TypeUtil.exactTypeMatch(env, type, item.getType());
	    	}
    	}
    	
        // Ensure that you remove @generated or mark it @generated NOT
        if (!result) {
        	// TODO: Specific error message
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         ExpressionsValidator.DIAGNOSTIC_SOURCE,
                         ExpressionsValidator.COLLECTION_ITEM__ITEM_TYPE,
                         org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkItemType", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(collectionItem, context) }), //$NON-NLS-1$ //$NON-NLS-2$
                         new Object [] { collectionItem }));
            }
        }
        return result;
    }

} // CollectionItemOperations