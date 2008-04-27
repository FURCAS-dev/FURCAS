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
 * $Id: CollectionRangeOperations.java,v 1.2 2008/04/27 23:16:03 cdamus Exp $
 */
package org.eclipse.ocl.expressions.operations;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.expressions.CollectionRange;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.util.ExpressionsValidator;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.ocl.util.TypeUtil;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Collection Range</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.CollectionRange#checkRangeType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Range Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionRangeOperations {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CollectionRangeOperations() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * type = first.type.commonSuperType(last.type)
     * @param collectionRange The receiving '<em><b>Collection Range</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated NOT
     */
    public static <C> boolean checkRangeType(CollectionRange<C> collectionRange, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	boolean result = true;
    	Environment<?, C, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> env = OCLUtil
				.getValidationEnvironment(collectionRange, context);
		
		if (env != null) {
			C type = collectionRange.getType();
			OCLExpression<C> first = collectionRange.getFirst();
			OCLExpression<C> last = collectionRange.getLast();

			if ((type != null) && (first.getType() != null)
					&& (last.getType() != null)) {
				C partsType = TypeUtil.commonSuperType(null, env, first
						.getType(), last.getType());

				result = (partsType != null)
						&& TypeUtil.exactTypeMatch(env, partsType, type);
			}
		}
		
        if (!result) {
            if (diagnostics != null) {
            	// TODO: Specific message
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         ExpressionsValidator.DIAGNOSTIC_SOURCE,
                         ExpressionsValidator.COLLECTION_RANGE__RANGE_TYPE,
                         org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkRangeType", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(collectionRange, context) }), //$NON-NLS-1$ //$NON-NLS-2$
                         new Object [] { collectionRange }));
            }
        }
        return result;
    }

} // CollectionRangeOperations