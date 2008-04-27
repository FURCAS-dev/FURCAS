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
 * $Id: PropertyCallExpOperations.java,v 1.2 2008/04/27 23:16:03 cdamus Exp $
 */
package org.eclipse.ocl.expressions.operations;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.ocl.Environment;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.PropertyCallExp;

import org.eclipse.ocl.expressions.util.ExpressionsValidator;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.ocl.util.TypeUtil;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Property Call Exp</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.PropertyCallExp#checkPropertyType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Property Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyCallExpOperations {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PropertyCallExpOperations() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * type = referredProperty.type
     * @param propertyCallExp The receiving '<em><b>Property Call Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated NOT
     */
    public static <C, P> boolean checkPropertyType(PropertyCallExp<C, P> propertyCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	boolean result = true;
    	Environment<?, C, ?, P, ?, ?, ?, ?, ?, ?, ?, ?> env = OCLUtil
				.getValidationEnvironment(propertyCallExp, context);
		
		if (env != null) {
			P property = propertyCallExp.getReferredProperty();
			OCLExpression<C> source = propertyCallExp.getSource();
			C type = propertyCallExp.getType();
			
			if ((property != null) && (source != null)) {
				C refType = TypeUtil.getPropertyType(env, source.getType(), property);
			
				if (!TypeUtil.exactTypeMatch(env, refType, type)) {
					result = false;
				}
			}
		}
		
		if (!result) {
            if (diagnostics != null) {
            	// TODO: Specific message
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         ExpressionsValidator.DIAGNOSTIC_SOURCE,
                         ExpressionsValidator.PROPERTY_CALL_EXP__PROPERTY_TYPE,
                         org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkPropertyType", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(propertyCallExp, context) }), //$NON-NLS-1$ //$NON-NLS-2$
                         new Object [] { propertyCallExp }));
            }
        }
        return result;
    }

} // PropertyCallExpOperations