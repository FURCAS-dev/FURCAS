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
 * $Id: VariableExpOperations.java,v 1.2 2008/04/27 23:16:03 cdamus Exp $
 */
package org.eclipse.ocl.expressions.operations;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.ocl.Environment;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.VariableExp;

import org.eclipse.ocl.expressions.util.ExpressionsValidator;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.ocl.util.TypeUtil;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Variable Exp</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.VariableExp#checkVarType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Var Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableExpOperations {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected VariableExpOperations() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * type = referredVariable.type
     * @param variableExp The receiving '<em><b>Variable Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated NOT
     */
    public static <C, PM> boolean checkVarType(VariableExp<C, PM> variableExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	boolean result = true;
    	String message = null;
    	Environment<?, C, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> env = OCLUtil
				.getValidationEnvironment(variableExp, context);
		
		if (env != null) {
			Variable<C, PM> var = variableExp.getReferredVariable();
			C type = variableExp.getType();
			
			if ((var != null) && (type != null) && (var.getType() != null)) {
				if (!TypeUtil.exactTypeMatch(env, var.getType(), type)) {
					result = false;
					message = OCLMessages.bind(
							OCLMessages.VariableTypeMismatch_ERROR_,
							var.getName());
				}
			}
		}
		
		if (!result) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         ExpressionsValidator.DIAGNOSTIC_SOURCE,
                         ExpressionsValidator.VARIABLE_EXP__VAR_TYPE,
                         message,
                         new Object [] { variableExp }));
            }
        }
        return result;
    }

} // VariableExpOperations