/**
 * <copyright>
 *
 * Copyright (c) 2010 SAP AG and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Axel Uhl - Initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.ocl.ecore.parser;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OppositePropertyCallExp;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.utilities.VisitorExtension;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.UMLReflection;


/**
 * @since 3.1
 */
public class ValidationVisitor
		extends
		org.eclipse.ocl.parser.ValidationVisitor<
		EPackage, EClassifier, EOperation, EStructuralFeature,
		EEnumLiteral, EParameter, EObject,
		CallOperationAction, SendSignalAction, Constraint,
		EClass, EObject>
		implements VisitorExtension<Boolean> {
	

	public ValidationVisitor(
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> environment) {
		super(environment);
	}

	/**
	 * Callback for an PropertyCallExp visit. Well-formedness rule: The
	 * type of the PropertyCallExp is the type of the referred
	 * EStructuralFeature.
	 * 
	 * @param pc the property call expression
	 * @return Boolean -- true if validated
	 * @since 3.1
	 */
	public Boolean visitOppositePropertyCallExp(OppositePropertyCallExp pc) {
		EStructuralFeature property = pc.getReferredOppositeProperty();
		OCLExpression<EClassifier> source = pc.getSource();
		EClassifier type = pc.getType();

		if (property == null) {
			String message = OCLMessages.bind(
					OCLMessages.NullProperty_ERROR_,
					pc.toString());
			return validatorError(pc, message, "visitOppositePropertyCallExp");//$NON-NLS-1$
		}
		
		if (source == null) {
			String message = OCLMessages.bind(
					OCLMessages.NullNavigationSource_ERROR_,
					pc.toString());
			return validatorError(pc, message, "visitOppositePropertyCallExp");//$NON-NLS-1$
		}
		if (type == null) {
			String message = OCLMessages.bind(
					OCLMessages.NullNavigationType_ERROR_,
					pc.toString());
			return validatorError(pc, message, "visitOppositePropertyCallExp");//$NON-NLS-1$
		}
		
		List<OCLExpression<EClassifier>> qualifiers = pc.getQualifier();
		if (!qualifiers.isEmpty()) {
			// navigation qualifiers must conform to expected qualifier types
			List<EStructuralFeature> expectedQualifierTypes = uml.getQualifiers(property);
			
			if (expectedQualifierTypes.size() != qualifiers.size()) {
				String message = OCLMessages.bind(
						OCLMessages.MismatchedQualifiers_ERROR_,
						pc.toString());
				return validatorError(pc, message, "visitOppositePropertyCallExp");//$NON-NLS-1$
			} else {
				Iterator<EStructuralFeature> eiter = expectedQualifierTypes.iterator();
				Iterator<OCLExpression<EClassifier>> qiter = qualifiers.iterator();
				
				while (eiter.hasNext()) {
					EClassifier expectedType = getOCLType(eiter.next());
					OCLExpression<EClassifier> qualifier = qiter.next();
					
					EClassifier qualifierType = qualifier.getType();
					
					if ((TypeUtil.getRelationship(env, qualifierType, expectedType)
							& UMLReflection.SUBTYPE) == 0) {
						
						String message = OCLMessages.bind(
								OCLMessages.MismatchedQualifiers_ERROR_,
								pc.toString());
						return validatorError(pc, message, "visitPropertyCallExp");//$NON-NLS-1$
					}
				}
			}
		}
		
		if (visitFeatureCallExp(pc)) {
            return Boolean.TRUE;
        }
		
		source.accept(this);

		EClassifier refType = TypeUtil.getPropertyType(env, source.getType(), property);
		
		if (!pc.getQualifier().isEmpty() && (refType instanceof CollectionType<?, ?>)) {
			// qualifying the navigation results in a non-collection
			//    type
			@SuppressWarnings("unchecked")
			CollectionType<EClassifier, EOperation> ct = (CollectionType<EClassifier, EOperation>) refType;
			
			refType = ct.getElementType();
		}
		
		return Boolean.valueOf(TypeUtil.exactTypeMatch(env, refType, type));
	}
}
