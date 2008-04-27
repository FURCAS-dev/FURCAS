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
 * $Id: IterateExpOperations.java,v 1.2 2008/04/27 23:16:03 cdamus Exp $
 */
package org.eclipse.ocl.expressions.operations;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.ocl.Environment;
import org.eclipse.ocl.expressions.IterateExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;

import org.eclipse.ocl.expressions.util.ExpressionsValidator;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.ocl.util.TypeUtil;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Iterate Exp</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.IterateExp#checkIterateType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Iterate Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.IterateExp#checkBodyType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Body Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.IterateExp#checkResultInit(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Result Init</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IterateExpOperations extends LoopExpOperations {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IterateExpOperations() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * type = result.type
     * @param iterateExp The receiving '<em><b>Iterate Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated NOT
     */
    public static <C, PM> boolean checkIterateType(IterateExp<C, PM> iterateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	boolean result = true;
    	String message = null;
    	Environment<?, C, ?, ?, PM, ?, ?, ?, ?, ?, ?, ?> env = OCLUtil
				.getValidationEnvironment(iterateExp, context);
		
		Variable<C, PM> vd = iterateExp.getResult();
		C type = iterateExp.getType();

		if ((vd != null) && (type != null) && (vd.getType() != null)) {
			if (!TypeUtil.exactTypeMatch(env, type, vd.getType())) {
				result = false;
				message = OCLMessages.bind(
						OCLMessages.TypeConformanceIterateExp_ERROR_,
						iterateExp.toString());
			}
		}
		
		if (!result) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         ExpressionsValidator.DIAGNOSTIC_SOURCE,
                         ExpressionsValidator.ITERATE_EXP__ITERATE_TYPE,
                         message,
                         new Object [] { iterateExp }));
            }
        }
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * body.type.conformsTo(result.type)
     * @param iterateExp The receiving '<em><b>Iterate Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated NOT
     */
    public static <C, PM> boolean checkBodyType(IterateExp<C, PM> iterateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	boolean result = true;
    	String message = null;
    	Environment<?, C, ?, ?, PM, ?, ?, ?, ?, ?, ?, ?> env = OCLUtil
				.getValidationEnvironment(iterateExp, context);
		
		Variable<C, PM> vd = iterateExp.getResult();
		OCLExpression<C> body = iterateExp.getBody();

		if ((vd != null) && (body != null) && (vd.getType() != null) && (body.getType() != null)) {
			if (!TypeUtil.compatibleTypeMatch(env, body.getType(), vd.getType())) {
				result = false;
				message = OCLMessages.bind(
						OCLMessages.TypeConformanceIterateExpBody_ERROR_,
						iterateExp.toString());
			}
		}
		
		if (!result) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         ExpressionsValidator.DIAGNOSTIC_SOURCE,
                         ExpressionsValidator.ITERATE_EXP__BODY_TYPE,
                         message,
                         new Object [] { iterateExp }));
            }
        }
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * self.result.initExpression->size() = 1
     * @param iterateExp The receiving '<em><b>Iterate Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated NOT
     */
    public static <C, PM> boolean checkResultInit(IterateExp<C, PM> iterateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	boolean result = true;
    	String message = null;
		
		Variable<C, PM> vd = iterateExp.getResult();

		if ((vd != null) && (vd.getInitExpression() == null)) {
			result = false;
			message = OCLMessages.bind(
					OCLMessages.MissingInitIterateExp_ERROR_,
					iterateExp.toString());
		}
		
		if (!result) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         ExpressionsValidator.DIAGNOSTIC_SOURCE,
                         ExpressionsValidator.ITERATE_EXP__RESULT_INIT,
                         message,
                         new Object [] { iterateExp }));
            }
        }
        return result;
    }

} // IterateExpOperations