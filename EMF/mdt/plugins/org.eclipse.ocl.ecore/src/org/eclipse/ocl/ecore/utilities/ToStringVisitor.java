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
package org.eclipse.ocl.ecore.utilities;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OppositePropertyCallExp;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.utilities.TypedElement;


/**
 * @since 3.1
 */
public class ToStringVisitor
		extends
		org.eclipse.ocl.util.ToStringVisitor<
		EClassifier, EOperation, EStructuralFeature,
		EEnumLiteral, EParameter, EObject,
		CallOperationAction, SendSignalAction, Constraint>
		implements VisitorExtension<String> {
    protected ToStringVisitor(
			Environment<?, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, ?, ?> env) {
		super(env);
	}

	/**
	 * Obtains an instance of the <tt>toString()</tt> visitor for the specified
	 * expression or other typed element.
	 * 
	 * @param element an OCL expression or other typed element such as a variable
	 * 
	 * @return the corresponding instance
	 */
	public static ToStringVisitor getInstance(TypedElement<EClassifier> element) {
		Environment<?, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, ?, ?> env =
			Environment.Registry.INSTANCE.getEnvironmentFor(element);
		return new ToStringVisitor(env);
	}
	
	/**
	 * @since 3.1
	 */
    protected String handleOppositePropertyCallExp(
    		OppositePropertyCallExp callExp, String sourceResult) {
    	EStructuralFeature property = callExp.getReferredOppositeProperty();

        if (sourceResult == null) {
			// if we are the qualifier of an association class call, then
			//   we just return our name, because our source is null (implied)
			return "oppositeOf(" + getName(property) + ")";   //$NON-NLS-1$//$NON-NLS-2$
		}
		
		StringBuffer result = new StringBuffer(
			maybeAtPre(callExp, sourceResult + ".oppositeOf(" + getName(property) + ")"));//$NON-NLS-1$ //$NON-NLS-2$
		
		return result.toString();
    }

	public String visitOppositePropertyCallExp(
			OppositePropertyCallExp callExp) {
        String sourceResult = safeVisit(callExp.getSource());
        return handleOppositePropertyCallExp(callExp, sourceResult);
	}
}
