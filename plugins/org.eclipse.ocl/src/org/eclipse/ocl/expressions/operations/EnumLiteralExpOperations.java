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
 * $Id: EnumLiteralExpOperations.java,v 1.2 2008/04/27 23:16:03 cdamus Exp $
 */
package org.eclipse.ocl.expressions.operations;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.ocl.Environment;
import org.eclipse.ocl.expressions.EnumLiteralExp;

import org.eclipse.ocl.expressions.util.ExpressionsValidator;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.UMLReflection;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Enum Literal Exp</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.EnumLiteralExp#checkEnumType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Enum Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnumLiteralExpOperations {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EnumLiteralExpOperations() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * self.type = referredEnumLiteral.enumeration
     * @param enumLiteralExp The receiving '<em><b>Enum Literal Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated NOT
     */
    public static <C, EL> boolean checkEnumType(EnumLiteralExp<C, EL> enumLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		EL l = enumLiteralExp.getReferredEnumLiteral();
		C type = enumLiteralExp.getType();
		boolean result = true;
		String message = null;
		
    	Environment<?, C, ?, ?, EL, ?, ?, ?, ?, ?, ?, ?> env = OCLUtil
				.getValidationEnvironment(enumLiteralExp, context);
		
		if ((env != null) && (type != null)) {
			UMLReflection<?, C, ?, ?, EL, ?, ?, ?, ?, ?> uml = env.getUMLReflection();
			
			if (!uml.isEnumeration(type)
					|| !TypeUtil.exactTypeMatch(env, uml.getEnumeration(l),
							type)) {
				result = false;
				message = OCLMessages.bind(
						OCLMessages.IllegalEnumLiteral_ERROR_,
						enumLiteralExp.toString());
			}
		}
		
        if (!result) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         ExpressionsValidator.DIAGNOSTIC_SOURCE,
                         ExpressionsValidator.ENUM_LITERAL_EXP__ENUM_TYPE,
                         message,
                         new Object [] { enumLiteralExp }));
            }
        }
        
        return result;
    }

} // EnumLiteralExpOperations