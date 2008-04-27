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
 * $Id: TupleLiteralExpOperations.java,v 1.2 2008/04/27 23:16:03 cdamus Exp $
 */
package org.eclipse.ocl.expressions.operations;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.ocl.Environment;
import org.eclipse.ocl.expressions.TupleLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralPart;

import org.eclipse.ocl.expressions.util.ExpressionsValidator;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.types.TupleType;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.ocl.utilities.UMLReflection;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Tuple Literal Exp</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.TupleLiteralExp#checkTupleType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Tuple Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.TupleLiteralExp#checkPartsUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Parts Unique</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TupleLiteralExpOperations {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TupleLiteralExpOperations() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * type.oclIsKindOf (TupleType)
     * and
     * part->forAll (tlep |
     * type.oclAsType (TupleType).allProperties()->exists (tp | tlep.attribute = tp))
     * and
     * part->size() = type.oclAsType (TupleType).allProperties()->size()
     * @param tupleLiteralExp The receiving '<em><b>Tuple Literal Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated NOT
     */
    public static <C, P> boolean checkTupleType(TupleLiteralExp<C, P> tupleLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	boolean result = true;
    	String message = null;
    	Environment<?, C, ?, P, ?, ?, ?, ?, ?, ?, ?, ?> env = OCLUtil
				.getValidationEnvironment(tupleLiteralExp, context);
		
		if (env != null) {
			UMLReflection<?, C, ?, P, ?, ?, ?, ?, ?, ?> uml = env.getUMLReflection();
			C type = tupleLiteralExp.getType();
			if (!(type instanceof TupleType)) {
				result = false;
				message = OCLMessages.bind(
								OCLMessages.TypeConformanceTupleLiteralExp_ERROR_,
								tupleLiteralExp.toString());
			} else {
				// The fields of the tuple are the properties of the EClass.
	
				List<TupleLiteralPart<C, P>> tp = tupleLiteralExp.getPart();
				List<P> attributes = uml.getAttributes(type);
				
				if (tp.size() != attributes.size()) {
					result = false;
					message = OCLMessages.bind(
									OCLMessages.TypeConformanceTupleLiteralExpParts_ERROR_,
									tupleLiteralExp.toString());
				} else {
					// Match each property with a tuple part
					for (TupleLiteralPart<C, P> part : tp) {
						if ((part.getAttribute() == null)
								|| (uml.getOwningClassifier(part.getAttribute()) != type)) {
							result = false;
							message = OCLMessages.bind(
									OCLMessages.TupleLiteralExpressionPart_ERROR_,
									part.getName(),
									tupleLiteralExp.toString());
							break;
						}
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
                         ExpressionsValidator.TUPLE_LITERAL_EXP__TUPLE_TYPE,
                         message,
                         new Object [] { tupleLiteralExp }));
            }
        }
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * part->isUnique (attribute.name)
     * @param tupleLiteralExp The receiving '<em><b>Tuple Literal Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated NOT
     */
    public static <C, P> boolean checkPartsUnique(TupleLiteralExp<C, P> tupleLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	boolean result = true;
    	String message = null;

		Set<String> names = new java.util.HashSet<String>();
		
		// Match each property with a tuple part
		for (TupleLiteralPart<C, P> part : tupleLiteralExp.getPart()) {
			String name = part.getName();
			if (!names.add(name)) {
				result = false;
				message = OCLMessages.bind(
						OCLMessages.TupleDuplicateName_ERROR_,
						name, tupleLiteralExp.toString());
			}
		}
		
        if (!result) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         ExpressionsValidator.DIAGNOSTIC_SOURCE,
                         ExpressionsValidator.TUPLE_LITERAL_EXP__PARTS_UNIQUE,
                         message,
                         new Object [] { tupleLiteralExp }));
            }
        }
        return result;
    }

} // TupleLiteralExpOperations