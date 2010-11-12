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

import java.util.HashSet;
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
import org.eclipse.ocl.EvaluationVisitorImpl;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.TypeExp;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.utilities.PredefinedType;

public class MappingEvaluationVisitor extends EvaluationVisitorImpl<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> {

    private boolean isNotMapped = false; ;
    private Object query2Result;

    public MappingEvaluationVisitor(
            Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
            EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> evalEnv,
            Map<? extends EClass, ? extends Set<? extends EObject>> extentMap) {
        super(env, evalEnv, extentMap);
    }
    
    public MappingEvaluationVisitor(MappingEvaluationVisitor mapEvalVisitor){
        super(mapEvalVisitor.getEnvironment(), mapEvalVisitor.getEvaluationEnvironment(), mapEvalVisitor.getExtentMap());
    }

    @Override
    public Object visitExpression(OCLExpression<EClassifier> expression) {
        try {
            if (couldBeMapped()){
                return expression.accept(getVisitor());
            }else{
                return super.visitExpression(expression);
            }
        }
        catch (RuntimeException e) {
            isNotMapped = true;
            // failure to evaluate results in invalid
            return super.visitExpression(expression);
        }
        // TODO Check if expression has a self variable, if so there must be a context, this should be replaced by allInstances
    }

    public boolean couldBeMapped() {
        return !isNotMapped;
    }

    @Override
    public Object visitOperationCallExp(OperationCallExp<EClassifier, EOperation> oc) {
        if(couldBeMapped()){
            if(oc.getOperationCode() == PredefinedType.ALL_INSTANCES){
                Set<EObject> contextObjects = new HashSet<EObject>();
                // TODO clarify how this should work during partial evaluation where VariableExp should be used instead of variable name
                Object self = getEvaluationEnvironment().getValueOf(EcoreEnvironment.SELF_VARIABLE_NAME);
                if (self != null && self instanceof EObject) {
                    contextObjects.add((EObject) self);
                } else {
                    throw new RuntimeException("Need a valid context element even for allInstances() because we need to derive a query scope.");
                }
                OCLExpression<EClassifier> ocSource = oc.getSource();

                EClassifier ocType=null;
                if (ocSource instanceof TypeExp){
                    ocType = (EClassifier) ((TypeExp<EClassifier>) ocSource).getReferredType();
                }
                /*
                 * the expression must have the form allInstances()->IteratorExp(body)
                 * otherwise traverse the AST from beginning
                 */
                if (oc.eContainer()instanceof IteratorExp && oc.eContainer() != null){
                    IteratorExp<EClassifier, EParameter> itExp = (org.eclipse.ocl.ecore.IteratorExp) oc.eContainer();
                    OCLExpression<EClassifier> body = itExp.getBody();
                    query2Result = new Query2().buildMqlQuery(contextObjects, ocType, body, itExp, this); 
                    if (query2Result == null){
                        //if the query2 fail traverse the AST from beginning
                        isNotMapped = true;
                        return visitExpression((org.eclipse.ocl.ecore.OCLExpression)oc.eContainer());}
                    else
                        return query2Result;

                }else{
                    // if the expression has another form, traverse the AST from beginning
                    isNotMapped=true;
                    return visitExpression((org.eclipse.ocl.ecore.OCLExpression) oc.eContainer());
                }

            }else{
                //if there isn't any allInstances()
                isNotMapped=true;
                OCLExpression<EClassifier> oclExp = (org.eclipse.ocl.ecore.OCLExpression) oc.eContainer();
                return visitExpression(oclExp);
            }
        }
        else{
            return super.visitOperationCallExp(oc);           
        }
    }

    @Override
    public Object visitIteratorExp(IteratorExp<EClassifier, EParameter> itExp) {
        if(couldBeMapped()){
            switch (OCLStandardLibraryUtil.getOperationCode(itExp.getName())) {
            
            case PredefinedType.EXISTS:
            case PredefinedType.FOR_ALL:
            case PredefinedType.SELECT:
            case PredefinedType.COLLECT:
            case PredefinedType.COLLECT_NESTED:
            case PredefinedType.ANY:
                if (itExp.getSource() instanceof OperationCallExp)
                    return visitOperationCallExp((org.eclipse.ocl.ecore.OperationCallExp) itExp.getSource());
                else
                    return super.visitIteratorExp(itExp);
            default:
                return super.visitIteratorExp(itExp);
            }
        }
        else{
            return super.visitIteratorExp(itExp);
        }
    }
    
}
