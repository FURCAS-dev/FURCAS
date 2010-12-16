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
 * $Id: TracingEvaluationVisitor.java,v 1.1 2010/12/15 17:32:44 ewillink Exp $
 */
package org.eclipse.ocl.ecore.internal.evaluation;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OppositePropertyCallExp;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.utilities.VisitorExtension;


public class TracingEvaluationVisitor
		extends
		org.eclipse.ocl.internal.evaluation.TracingEvaluationVisitor<
		EPackage, EClassifier, EOperation, EStructuralFeature,
		EEnumLiteral, EParameter, EObject,
		CallOperationAction, SendSignalAction, Constraint,
		EClass, EObject>
		implements VisitorExtension<Object> {

	public TracingEvaluationVisitor(EvaluationVisitor<
			EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter, EObject,
			CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject> decorated) {
		super(decorated);
	}

    /**
     * Delegates to my decorated visitor.
     * @since 3.1
     */
    @SuppressWarnings("unchecked")
	public Object visitOppositePropertyCallExp(OppositePropertyCallExp callExp) {
    	if (getDelegate() instanceof VisitorExtension) {
    		return ((VisitorExtension<Object>) getDelegate()).visitOppositePropertyCallExp(callExp);
    	} else {
    		return null;
    	}
    }
}
