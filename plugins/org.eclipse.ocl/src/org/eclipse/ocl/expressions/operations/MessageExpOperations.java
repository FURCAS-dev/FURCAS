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
 * $Id: MessageExpOperations.java,v 1.2 2008/04/27 23:16:03 cdamus Exp $
 */
package org.eclipse.ocl.expressions.operations;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.ocl.Environment;
import org.eclipse.ocl.expressions.MessageExp;
import org.eclipse.ocl.expressions.OCLExpression;

import org.eclipse.ocl.expressions.util.ExpressionsValidator;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.UMLReflection;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Message Exp</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.MessageExp#checkOperationArguments(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Operation Arguments</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.MessageExp#checkSignalArguments(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Signal Arguments</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.MessageExp#checkTargetDefinesOperation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Target Defines Operation</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.MessageExp#checkHasOperationOrSignal(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Has Operation Or Signal</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.MessageExp#checkTargetNotCollection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Target Not Collection</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MessageExpOperations {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MessageExpOperations() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * calledOperation->notEmpty() implies
     * argument->forall (a | a.type.conformsTo
     * (self.calledOperation.operation.ownedParameter->
     * select( kind = ParameterDirectionKind::in )
     * ->at (argument->indexOf (a)).type))
     * @param messageExp The receiving '<em><b>Message Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated NOT
     */
    public static <C, COA, SSA> boolean checkOperationArguments(MessageExp<C, COA, SSA> messageExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	boolean result = true;
    	String message = null;
    	Environment<?, C, Object, ?, ?, ?, ?, COA, SSA, ?, ?, ?> env = OCLUtil
				.getValidationEnvironment(messageExp, context);
		
		if (env != null) {
			UMLReflection<?, C, Object, ?, ?, ?, ?, COA, SSA, ?> uml = env.getUMLReflection();
			
			if (messageExp.getCalledOperation() == null) {
				return true;
			}
			
			Object operation = uml.getOperation(messageExp.getCalledOperation());
			if (operation == null) {
				return true;
			}
			
			List<?> parameters = uml.getParameters(operation);
			
			List<OCLExpression<C>> arguments = messageExp.getArgument();
			
			if (arguments.size() != parameters.size()) {
				result = false;
				message = OCLMessages.bind(OCLMessages.MessageArgumentCount_ERROR_,
								uml.getName(messageExp.getType()));
			} else {
				// check type conformance against parameters
				Iterator<?> paramsIter = parameters.iterator();
				Iterator<OCLExpression<C>> argsIter =
					arguments.iterator();
				while (paramsIter.hasNext()) {
					Object param = paramsIter.next();
					OCLExpression<C> arg = argsIter.next();
					
					if (!TypeUtil.compatibleTypeMatch(env, arg.getType(), uml.getOCLType(param))) {
						result = false;
						message = OCLMessages.bind(OCLMessages.MessageArgConformance_ERROR_,
									uml.getName(param), arg.toString());
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
                         ExpressionsValidator.MESSAGE_EXP__OPERATION_ARGUMENTS,
                         message,
                         new Object [] { messageExp }));
            }
        }
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * sentSignal->notEmpty() implies
     * argument->forall (a | a.type.conformsTo
     * (self.sentSignal.signal.ownedAttribute
     * ->at (argument->indexOf (a)).type))
     * @param messageExp The receiving '<em><b>Message Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated NOT
     */
    public static <C, COA, SSA> boolean checkSignalArguments(MessageExp<C, COA, SSA> messageExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	boolean result = true;
    	String message = null;
    	Environment<?, C, ?, ?, ?, ?, ?, COA, SSA, ?, ?, ?> env = OCLUtil
				.getValidationEnvironment(messageExp, context);
		
		if (env != null) {
			UMLReflection<?, C, ?, ?, ?, ?, ?, COA, SSA, ?> uml = env.getUMLReflection();
			
			if (messageExp.getSentSignal() == null) {
				return true;
			}
			
			C signal = uml.getSignal(messageExp.getSentSignal());
			if (signal == null) {
				return true;
			}
			
			List<?> attributes = uml.getAttributes(signal);
			
			List<OCLExpression<C>> arguments = messageExp.getArgument();
			
			if (arguments.size() != attributes.size()) {
				result = false;
				message = OCLMessages.bind(OCLMessages.MessageArgumentCount_ERROR_,
								uml.getName(messageExp.getType()));
			} else {
				// check type conformance against attributes
				Iterator<?> attrsIter = attributes.iterator();
				Iterator<OCLExpression<C>> argsIter =
					arguments.iterator();
				while (attrsIter.hasNext()) {
					Object attr = attrsIter.next();
					OCLExpression<C> arg = argsIter.next();
					
					if (!TypeUtil.compatibleTypeMatch(env, arg.getType(), uml.getOCLType(attr))) {
						result = false;
						message = OCLMessages.bind(OCLMessages.MessageArgConformance_ERROR_,
									uml.getName(attr), arg.toString());
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
                         ExpressionsValidator.MESSAGE_EXP__SIGNAL_ARGUMENTS,
                         message,
                         new Object [] { messageExp }));
            }
        }
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * calledOperation->notEmpty() implies
     * target.type.allOperations()->includes(calledOperation.operation)
     * @param messageExp The receiving '<em><b>Message Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated NOT
     */
    public static <C, COA, SSA> boolean checkTargetDefinesOperation(MessageExp<C, COA, SSA> messageExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	boolean result = true;
    	Environment<?, C, Object, ?, ?, ?, ?, COA, SSA, ?, ?, ?> env = OCLUtil
				.getValidationEnvironment(messageExp, context);
		
		if (env != null) {
			UMLReflection<?, C, Object, ?, ?, ?, ?, COA, SSA, ?> uml = env.getUMLReflection();
			
			if (messageExp.getTarget() == null) {
				return true;
			}
			if (messageExp.getTarget().getType() == null) {
				return true;
			}
			
			if (messageExp.getCalledOperation() == null) {
				return true;
			}
			
			Object operation = uml.getOperation(messageExp.getCalledOperation());
			if (operation == null) {
				return true;
			}
			
			String name = uml.getName(operation);
			List<OCLExpression<C>> arguments = messageExp.getArgument();
			
			Object operation1 = env.lookupOperation(messageExp.getTarget()
					.getType(), name, arguments);
			
			if (operation1 != operation) {
				result = false;
			}
		}
		
		if (!result) {
            if (diagnostics != null) {
            	// TODO: Specific message
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         ExpressionsValidator.DIAGNOSTIC_SOURCE,
                         ExpressionsValidator.MESSAGE_EXP__TARGET_DEFINES_OPERATION,
                         org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkTargetDefinesOperation", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(messageExp, context) }), //$NON-NLS-1$ //$NON-NLS-2$
                         new Object [] { messageExp }));
            }
        }
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * calledOperation->size() + sentSignal->size() = 1
     * @param messageExp The receiving '<em><b>Message Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated NOT
     */
    public static <C, COA, SSA> boolean checkHasOperationOrSignal(MessageExp<C, COA, SSA> messageExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	boolean result = true;
    	String message = null;
		
		if (messageExp.getCalledOperation() == null
				&& messageExp.getSentSignal() == null) {
			result = false;
			message = OCLMessages.UnrecognizedMessageType_ERROR_;
		}
		if (messageExp.getCalledOperation() != null
				&& messageExp.getSentSignal() != null) {
			result = false;
			message = OCLMessages.AmbiguousMessageType_ERROR_;
		}
		
		if (!result) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         ExpressionsValidator.DIAGNOSTIC_SOURCE,
                         ExpressionsValidator.MESSAGE_EXP__HAS_OPERATION_OR_SIGNAL,
                         message,
                         new Object [] { messageExp }));
            }
        }
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * not target.type.oclIsKindOf(CollectionType)
     * @param messageExp The receiving '<em><b>Message Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated NOT
     */
    public static <C, COA, SSA> boolean checkTargetNotCollection(MessageExp<C, COA, SSA> messageExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	boolean result = true;
		
    	OCLExpression<C> target = messageExp.getTarget();
		if ((target != null) && (target.getType() instanceof CollectionType)) {
			result = false;
		}
		
		if (!result) {
            if (diagnostics != null) {
            	// TODO: Specific message
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         ExpressionsValidator.DIAGNOSTIC_SOURCE,
                         ExpressionsValidator.MESSAGE_EXP__TARGET_NOT_COLLECTION,
                         org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkTargetNotCollection", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(messageExp, context) }), //$NON-NLS-1$ //$NON-NLS-2$
                         new Object [] { messageExp }));
            }
        }
        return result;
    }

} // MessageExpOperations