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
package com.sap.emf.ocl.hiddenopposites;

import java.util.Collection;
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
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.util.CollectionUtil;

import com.sap.emf.ocl.oclwithhiddenopposites.expressions.OppositePropertyCallExp;

public class EvaluationVisitorWithHiddenOppositesImpl
        extends
        EvaluationVisitorImpl<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>
        implements EvaluationVisitorWithHiddenOpposites {

    public EvaluationVisitorWithHiddenOppositesImpl(
            Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
            EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> evalEnv,
            Map<? extends EClass, ? extends Set<? extends EObject>> extentMap) {
        super(env, evalEnv, extentMap);
    }

    public Object visitOppositePropertyCallExp(OppositePropertyCallExp opce) {
        EStructuralFeature property = opce.getReferredOppositeProperty();
        OCLExpression<EClassifier> source = opce.getSource();
        // evaluate source
        Object context = source.accept(getVisitor());
        // if source is undefined, result is OclInvalid
        if (isUndefined(context)) {
            return getInvalid();
        }
        Object result = getEvaluationEnvironment().navigateOppositeProperty(property, context);
        if ((opce.getType() instanceof CollectionType<?, ?>) && !(result instanceof Collection<?>)) {
            // this was an XSD "unspecified multiplicity". Now that we know what
            // the multiplicity is, we can coerce it to a collection value
            @SuppressWarnings("unchecked")
            CollectionKind kind = ((CollectionType<EClassifier, EOperation>) opce.getType()).getKind();
            Collection<Object> collection = CollectionUtil.createNewCollection(kind);
            if (result != null) {
                collection.add(result);
            }
            result = collection;
        }

        return result;
    }

    @Override
    public EvaluationEnvironmentWithHiddenOpposites getEvaluationEnvironment() {
        return (EvaluationEnvironmentWithHiddenOpposites) super.getEvaluationEnvironment();
    }

}
