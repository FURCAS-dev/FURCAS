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
 * $Id: IteratorExpOperations.java,v 1.2 2008/04/27 23:16:03 cdamus Exp $
 */
package org.eclipse.ocl.expressions.operations;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.ocl.Environment;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.OCLExpression;

import org.eclipse.ocl.expressions.util.ExpressionsValidator;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.types.BagType;
import org.eclipse.ocl.types.OrderedSetType;
import org.eclipse.ocl.types.PrimitiveType;
import org.eclipse.ocl.types.SequenceType;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.PredefinedType;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Iterator Exp</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.IteratorExp#checkBooleanType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Boolean Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.IteratorExp#checkCollectType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Collect Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.IteratorExp#checkSelectRejectType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Select Reject Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.IteratorExp#checkBooleanBodyType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Boolean Body Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IteratorExpOperations extends LoopExpOperations {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IteratorExpOperations() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * name = 'exists' or name = 'forAll' or name = 'isUnique'
     * implies type.oclIsKindOf(PrimitiveType) and type.name = 'Boolean'
     * @param iteratorExp The receiving '<em><b>Iterator Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated NOT
     */
    public static <C, PM> boolean checkBooleanType(IteratorExp<C, PM> iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	boolean result = true;
    	String message = null;
		
    	Environment<?, C, ?, ?, PM, ?, ?, ?, ?, ?, ?, ?> env = OCLUtil
    			.getValidationEnvironment(iteratorExp, context);
		C type = iteratorExp.getType();

    	if (env != null) {
    		String name = iteratorExp.getName();
			int opcode = OCLStandardLibraryUtil.getOperationCode(name);
			
    		switch (opcode) {
    		case PredefinedType.FOR_ALL:
    		case PredefinedType.EXISTS:
    		case PredefinedType.IS_UNIQUE:
    			if (!(type instanceof PrimitiveType)
						|| !"Boolean".equals(env.getUMLReflection() //$NON-NLS-1$
								.getName(type))) {
    				result = false;
    				message = OCLMessages.bind(
    						OCLMessages.TypeConformanceIteratorResult_ERROR_,
    						iteratorExp.toString());
    			}
    		}
    	}
    	
		if (!result) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         ExpressionsValidator.DIAGNOSTIC_SOURCE,
                         ExpressionsValidator.ITERATOR_EXP__BOOLEAN_TYPE,
                         message,
                         new Object [] { iteratorExp }));
            }
        }
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * name = 'collect' implies
     * if source.type.oclIsKindOf(SequenceType) then
     * type = expression.type.collectionType->select(oclIsTypeOf(SequenceType))->first()
     * else
     * type = expression.type.collectionType->select(oclIsTypeOf(BagType))->first()
     * endif
     * @param iteratorExp The receiving '<em><b>Iterator Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated NOT
     */
    public static <C, PM> boolean checkCollectType(IteratorExp<C, PM> iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	boolean result = true;
    	String message = null;
		
    	Environment<?, C, ?, ?, PM, ?, ?, ?, ?, ?, ?, ?> env = OCLUtil
    			.getValidationEnvironment(iteratorExp, context);
		C type = iteratorExp.getType();

    	OCLExpression<C> source = iteratorExp.getSource();
    	if ((env != null) && (source != null) && (source.getType() != null)) {
    		String name = iteratorExp.getName();
			int opcode = OCLStandardLibraryUtil.getOperationCode(name);
			
    		switch (opcode) {
    		case PredefinedType.COLLECT:
				if ((source.getType() instanceof SequenceType)
						|| (source.getType() instanceof OrderedSetType)) {
					if (!(type instanceof SequenceType)) {
						result = false;
						message = OCLMessages.bind(
								OCLMessages.TypeConformanceCollectSequence_ERROR_,
								iteratorExp.toString());
					}
				} else if (!(type instanceof BagType)) {
					result = false;
					message = OCLMessages.bind(
							OCLMessages.TypeConformanceCollectBag_ERROR_,
							iteratorExp.toString());
				}
				break;
    		}
    	}
    	
		if (!result) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         ExpressionsValidator.DIAGNOSTIC_SOURCE,
                         ExpressionsValidator.ITERATOR_EXP__COLLECT_TYPE,
                         message,
                         new Object [] { iteratorExp }));
            }
        }
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * name = 'select' or name = 'reject' implies type = source.type
     * @param iteratorExp The receiving '<em><b>Iterator Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated NOT
     */
    public static <C, PM> boolean checkSelectRejectType(IteratorExp<C, PM> iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	boolean result = true;
    	String message = null;
		
    	Environment<?, C, ?, ?, PM, ?, ?, ?, ?, ?, ?, ?> env = OCLUtil
    			.getValidationEnvironment(iteratorExp, context);
		C type = iteratorExp.getType();

    	OCLExpression<C> source = iteratorExp.getSource();
    	if ((env != null) && (source != null) && (source.getType() != null)) {
    		String name = iteratorExp.getName();
			int opcode = OCLStandardLibraryUtil.getOperationCode(name);
			
    		switch (opcode) {
    		case PredefinedType.SELECT:
    		case PredefinedType.REJECT:
    			if (!TypeUtil.exactTypeMatch(env, type, source.getType())) {
    				result = false;
    				message = OCLMessages.bind(
    						OCLMessages.TypeConformanceSelectReject_ERROR_,
    						iteratorExp.toString());
    			}
    			break;
    		}
    	}
    	
		if (!result) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         ExpressionsValidator.DIAGNOSTIC_SOURCE,
                         ExpressionsValidator.ITERATOR_EXP__SELECT_REJECT_TYPE,
                         message,
                         new Object [] { iteratorExp }));
            }
        }
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * name = 'exists' or name = 'forAll' or name = 'select' or name = 'reject'
     * implies body.type.name = 'Boolean'
     * @param iteratorExp The receiving '<em><b>Iterator Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated NOT
     */
    public static <C, PM> boolean checkBooleanBodyType(IteratorExp<C, PM> iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	boolean result = true;
    	String message = null;
		
    	Environment<?, C, ?, ?, PM, ?, ?, ?, ?, ?, ?, ?> env = OCLUtil
    			.getValidationEnvironment(iteratorExp, context);
    	OCLExpression<C> body = iteratorExp.getBody();

    	if ((env != null) && (body != null)) {
    		C type = body.getType();
    		
    		String name = iteratorExp.getName();
			int opcode = OCLStandardLibraryUtil.getOperationCode(name);
			
    		switch (opcode) {
    		case PredefinedType.SELECT:
    		case PredefinedType.REJECT:
    		case PredefinedType.FOR_ALL:
    		case PredefinedType.ANY:
    		case PredefinedType.EXISTS:
    		case PredefinedType.ONE:
    			if (!(type instanceof PrimitiveType)
						|| !"Boolean".equals(env.getUMLReflection() //$NON-NLS-1$
								.getName(type))) {
    				result = false;
    				message = OCLMessages.bind(
    						OCLMessages.TypeConformanceIteratorBodyBoolean_ERROR_,
    						iteratorExp.toString());
    			}
    			break;
    		}
    	}
    	
		if (!result) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         ExpressionsValidator.DIAGNOSTIC_SOURCE,
                         ExpressionsValidator.ITERATOR_EXP__BOOLEAN_BODY_TYPE,
                         message,
                         new Object [] { iteratorExp }));
            }
        }
        return result;
    }

} // IteratorExpOperations