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
 * $Id: IfExpOperations.java,v 1.2 2008/04/27 23:16:03 cdamus Exp $
 */
package org.eclipse.ocl.expressions.operations;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.ocl.Environment;
import org.eclipse.ocl.expressions.IfExp;
import org.eclipse.ocl.expressions.OCLExpression;

import org.eclipse.ocl.expressions.util.ExpressionsValidator;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.UMLReflection;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>If Exp</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.IfExp#checkBooleanCondition(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Boolean Condition</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.IfExp#checkIfType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check If Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfExpOperations {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IfExpOperations() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * self.condition.type.oclIsKindOf(PrimitiveType) and self.condition.type.name = 'Boolean'
     * @param ifExp The receiving '<em><b>If Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated NOT
     */
    public static <C> boolean checkBooleanCondition(IfExp<C> ifExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	boolean result = true;
    	String message = null;
    	Environment<?, C, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> env = OCLUtil
				.getValidationEnvironment(ifExp, context);
		
		if (env != null) {
			UMLReflection<?, C, ?, ?, ?, ?, ?, ?, ?, ?> uml = env.getUMLReflection();
			
			OCLExpression<C> cond = ifExp.getCondition();
			if (cond != null) {
				C type = cond.getType();
			
				if ((type == null) || !uml.isDataType(type)
						|| !("Boolean".equals(uml.getName(type)))) { //$NON-NLS-1$) {
					result = false;
					message = OCLMessages.bind(
							OCLMessages.NonBooleanIfExp_ERROR_,
							cond.toString());
				}
			}
		}
		
		if (!result) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         ExpressionsValidator.DIAGNOSTIC_SOURCE,
                         ExpressionsValidator.IF_EXP__BOOLEAN_CONDITION,
                         message,
                         new Object [] { ifExp }));
            }
        }
		
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * self.type = thenExpression.type.commonSuperType(elseExpression.type)
     * @param ifExp The receiving '<em><b>If Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated NOT
     */
    public static <C> boolean checkIfType(IfExp<C> ifExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
      	boolean result = true;
    	String message = null;
    	Environment<?, C, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> env = OCLUtil
				.getValidationEnvironment(ifExp, context);
		
		if (env != null) {
			OCLExpression<C> thenExp = ifExp.getThenExpression();
			OCLExpression<C> elseExp = ifExp.getElseExpression();
			C type = ifExp.getType();
			
			if ((type != null) && (thenExp != null) && (elseExp != null)) {
				C thenType = thenExp.getType();
				C elseType = elseExp.getType();
				
				if ((thenType != null) && (elseType != null)) {
					C thenelsetype = TypeUtil.commonSuperType(
								null,
								env,
								thenType,
								elseType);
					
					if ((thenelsetype == null) || !TypeUtil.exactTypeMatch(env, type, thenelsetype)) {
						result = false;
						message = OCLMessages.bind(
								OCLMessages.TypeConformanceIfExp_ERROR_,
								ifExp.toString());
					}
				}
			}
		}
		
		if (!result) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         ExpressionsValidator.DIAGNOSTIC_SOURCE,
                         ExpressionsValidator.IF_EXP__IF_TYPE,
                         message,
                         new Object [] { ifExp }));
            }
        }
		
        return result;
    }

} // IfExpOperations