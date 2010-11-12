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
package de.hpi.sam.bp2009.solution.oclToMqlMapping.impl;

import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.EvaluationHaltedException;
import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.utilities.ExpressionInOCL;

public class MappingOCL extends OCL {

    protected MappingOCL(MappingOCLEnvironmentFactory instance) {
        super(instance);
    }

    protected MappingOCL(
            Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
        super(env);
    }

    public static MappingOCL newInstance() {
        return new MappingOCL(MappingOCLEnvironmentFactory.INSTANCE);
    }

    public static MappingOCL newInstance(
            Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
        return new MappingOCL(env);
    }

    public Object evaluate(Object context, OCLExpression expression) {
        // can determine a more appropriate context from the context
        // variable of the expression, to account for stereotype constraints
        context = getConstraintContext(getEnvironment(), context, expression);
        EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> localEvalEnv = getEvaluationEnvironment();
        localEvalEnv.add(Environment.SELF_VARIABLE_NAME, context);
        Map<EClass, ? extends Set<? extends EObject>> extents = getExtentMap();
        if (extents == null) {
            // let the evaluation environment create one
            extents = localEvalEnv.createExtentMap(context);
        }

        EvaluationVisitor<?, EClassifier, EOperation, EStructuralFeature, ?, ?, ?, ?, ?, Constraint, EClass, EObject> evalVisitor = new MappingEvaluationVisitor(
                getEnvironment(), localEvalEnv, extents);

        Object result = null;
        try {
            result = evalVisitor.visitExpression((org.eclipse.ocl.expressions.OCLExpression<EClassifier>) expression);
        } catch (EvaluationHaltedException e) {
            result = getEnvironment().getOCLStandardLibrary().getInvalid();
        } finally {
            localEvalEnv.remove(Environment.SELF_VARIABLE_NAME);
        }
        return result;
    }

    private Object getConstraintContext(
            Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
            Object element, OCLExpression expr) {

        Object result = element;

        if (expr.eContainer() instanceof ExpressionInOCL) {
            ExpressionInOCL<EClassifier, EParameter> specification = (org.eclipse.ocl.ecore.ExpressionInOCL) expr.eContainer();

            Variable<EClassifier, EParameter> contextVariable = specification.getContextVariable();
            if (contextVariable != null) {
                EClassifier contextClassifier = contextVariable.getType();
                if ((contextClassifier != null) && env.getUMLReflection().isStereotype(contextClassifier)) {
                    Object application = env.getUMLReflection().getStereotypeApplication(element, contextClassifier);
                    if (application != null) {
                        result = application;
                    }
                }
            }
        }
        return result;
    }
}
