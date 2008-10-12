/**
 * <copyright>
 * 
 * Copyright (c) 2008 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 207365
 * 
 * </copyright>
 *
 * $Id: StringLiteralExpOperations.java,v 1.3 2008/10/12 01:09:49 cdamus Exp $
 */
package org.eclipse.ocl.expressions.operations;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.expressions.StringLiteralExp;
import org.eclipse.ocl.expressions.util.ExpressionsValidator;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.util.OCLUtil;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>String Literal Exp</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.StringLiteralExp#checkStringType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check String Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StringLiteralExpOperations
		extends OCLExpressionOperations {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * self.type.name = 'String'
     * @param stringLiteralExp The receiving '<em><b>String Literal Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated NOT
     */
    public static <C> boolean checkStringType(StringLiteralExp<C> stringLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	boolean result = true;
    	Environment<?, C, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> env = OCLUtil
				.getValidationEnvironment(stringLiteralExp, context);
    	
    	if (env != null) {
	    	C type = stringLiteralExp.getType();
	    	
			result = (type != null) && ("String".equals(env.getUMLReflection().getName(type))); //$NON-NLS-1$
    	}
    	
        if (!result) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         ExpressionsValidator.DIAGNOSTIC_SOURCE,
                         ExpressionsValidator.STRING_LITERAL_EXP__STRING_TYPE,
                         OCLMessages.TypeConformanceStringLiteral_ERROR_,
                         new Object [] { stringLiteralExp }));
            }
        }
        
        return result;
    }

} // StringLiteralExpOperations