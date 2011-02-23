/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.impactanalyzer.util;

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
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.util.ToStringVisitor;
import org.eclipse.ocl.utilities.Visitable;

public class HighlightingToStringVisitor extends ToStringVisitor<EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> {

    private OCLExpression expressionToHighlight;

    protected HighlightingToStringVisitor(
            Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
            OCLExpression expressionToHighlight) {
        super(env);
        this.expressionToHighlight = expressionToHighlight;
    }

    public static HighlightingToStringVisitor getInstance(EObject element, OCLExpression expressionToHighlight) {
        Environment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> environment = Environment.Registry.INSTANCE.getEnvironmentFor(element);
        @SuppressWarnings("unchecked")
        Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> typedEnvironment = (Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>) environment;
        return new HighlightingToStringVisitor(typedEnvironment, expressionToHighlight);
    }

    @Override
    protected String safeVisit(Visitable v) {
        String result = (v == null)? null : v.accept(this);
        if (v == expressionToHighlight) {
            result = ">>>"+result+"<<<";
        }
        return result;
    }
    
}
