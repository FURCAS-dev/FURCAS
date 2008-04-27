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
 * $Id: LoopExpOperations.java,v 1.2 2008/04/27 23:16:03 cdamus Exp $
 */
package org.eclipse.ocl.expressions.operations;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.ocl.Environment;
import org.eclipse.ocl.expressions.LoopExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;

import org.eclipse.ocl.expressions.util.ExpressionsValidator;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.ocl.util.TypeUtil;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Loop Exp</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.LoopExp#checkSourceCollection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Source Collection</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.LoopExp#checkLoopVariableInit(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Loop Variable Init</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.LoopExp#checkLoopVariableType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Loop Variable Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoopExpOperations {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected LoopExpOperations() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * source.type.oclIsKindOf(CollectionType)
     * @param loopExp The receiving '<em><b>Loop Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated NOT
     */
    public static <C, PM> boolean checkSourceCollection(LoopExp<C, PM> loopExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	boolean result = true;
    	String message = null;
		
		OCLExpression<C> source = loopExp.getSource();

		if (source != null) {
			C sourceType = source.getType();
			if (!(sourceType instanceof CollectionType)) {
				result = false;
				message = OCLMessages.bind(
						OCLMessages.IteratorSource_ERROR_,
						loopExp.toString());
			}
		}
		
		if (!result) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         ExpressionsValidator.DIAGNOSTIC_SOURCE,
                         ExpressionsValidator.LOOP_EXP__SOURCE_COLLECTION,
                         message,
                         new Object [] { loopExp }));
            }
        }
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * self.iterator->forAll(initExpression->isEmpty())
     * @param loopExp The receiving '<em><b>Loop Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated NOT
     */
    public static <C, PM> boolean checkLoopVariableInit(LoopExp<C, PM> loopExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	boolean result = true;
    	String message = null;
		
		for (Variable<C, PM> loopiter : loopExp.getIterator()) {
			if (loopiter.getInitExpression() != null) {
				result = false;
				message = OCLMessages.bind(
						OCLMessages.IterateExpLoopVarInit_ERROR_,
						loopExp.toString());
				break;
			}
		}
		
		if (!result) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         ExpressionsValidator.DIAGNOSTIC_SOURCE,
                         ExpressionsValidator.LOOP_EXP__LOOP_VARIABLE_INIT,
                         message,
                         new Object [] { loopExp }));
            }
        }
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * self.iterator->forAll(type = source.type.oclAsType(CollectionType).elementType)
     * @param loopExp The receiving '<em><b>Loop Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated NOT
     */
    public static <C, PM> boolean checkLoopVariableType(LoopExp<C, PM> loopExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	boolean result = true;
    	String message = null;
		
    	Environment<?, C, ?, ?, PM, ?, ?, ?, ?, ?, ?, ?> env = OCLUtil
    			.getValidationEnvironment(loopExp, context);

    	if ((env != null) && (loopExp.getSource() != null)
				&& (loopExp.getSource().getType() instanceof CollectionType)) {
			@SuppressWarnings("unchecked")
			CollectionType<C, ?> ct = (CollectionType<C, ?>) loopExp.getSource().getType();
			C elementType = ct.getElementType();
			
			if (elementType != null) {
				for (Variable<C, PM> loopiter : loopExp.getIterator()) {
					if ((loopiter.getType() != null)
							&& !TypeUtil.exactTypeMatch(env, loopiter.getType(),
									elementType)) {
						result = false;
						message = OCLMessages.bind(
							OCLMessages.TypeConformanceIteratorExpLoopVar_ERROR_,
							loopExp.toString());
						break;
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
                         ExpressionsValidator.LOOP_EXP__LOOP_VARIABLE_TYPE,
                         message,
                         new Object [] { loopExp }));
            }
        }
        return result;
    }

} // LoopExpOperations