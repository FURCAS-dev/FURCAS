/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: CompatibilityEnvironmentFactory.java,v 1.4 2009/07/27 15:28:57 ewillink Exp $
 */
package org.eclipse.emf.ocl.internal.parser;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ocl.expressions.Variable;
import org.eclipse.emf.ocl.parser.EcoreEnvironment;
import org.eclipse.emf.ocl.parser.EnvironmentFactory;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;

/**
 * 
 *
 * @author Christian W. Damus (cdamus)
 */
public class CompatibilityEnvironmentFactory extends EcoreEnvironmentFactory {
	static final CompatibilityEnvironmentFactory INSTANCE =
		new CompatibilityEnvironmentFactory(EnvironmentFactory.ECORE_INSTANCE);
	
	private final EnvironmentFactory oldStyle;
	
	CompatibilityEnvironmentFactory(EnvironmentFactory oldStyle) {
		this.oldStyle = oldStyle;
	}

    @Override
    public org.eclipse.ocl.Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>
    createPackageContext(
            org.eclipse.ocl.Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent,
            List<String> pathname) {
        return CompatibilityUtil.getCompatibilityEnvironment(
                parent,
                oldStyle.createPackageContext(pathname),
                this);
    }

	@Override
	public org.eclipse.ocl.Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>
	createClassifierContext(
			org.eclipse.ocl.Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent,
			EClassifier context) {
		
		org.eclipse.emf.ocl.parser.Environment classifierEnv =
			oldStyle.createClassifierContext(context);
		Variable selfVar = classifierEnv.getSelfVariable();
		
		org.eclipse.emf.ocl.parser.Environment newOldStyle =
			oldStyle.createEnvironment(CompatibilityUtil.getCompatibilityEnvironment(parent));
		
		newOldStyle.addElement(selfVar.getName(), selfVar, true);
		newOldStyle.setSelfVariable(selfVar);
		
		return CompatibilityUtil.getCompatibilityEnvironment(
				parent,
				newOldStyle,
				this);
	}
	
	@Override
	public org.eclipse.ocl.Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>
	createOperationContext(
			org.eclipse.ocl.Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent,
			EOperation operation) {
		
		org.eclipse.emf.ocl.parser.Environment operationEnv =
			oldStyle.createOperationContext(parent.getContextClassifier(), operation);
		Variable selfVar = operationEnv.getSelfVariable();
		
		org.eclipse.emf.ocl.parser.Environment newOldStyle =
			oldStyle.createEnvironment(CompatibilityUtil.getCompatibilityEnvironment(parent));
		if (newOldStyle instanceof EcoreEnvironment) {
			((EcoreEnvironment) newOldStyle).setContextOperation(operation);
		}
		
		newOldStyle.addElement(selfVar.getName(), selfVar, true);
		newOldStyle.setSelfVariable(selfVar);
		
		for (EParameter parm : operation.getEParameters()) {
			newOldStyle.addElement(
					parm.getName(),
					operationEnv.lookupLocal(parm.getName()),
					true);
		}
		
		return CompatibilityUtil.getCompatibilityEnvironment(
				parent,
				newOldStyle,
				this);
	}
	
	@Override
	public org.eclipse.ocl.Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createAttributeContext(
			org.eclipse.ocl.Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent,
			EStructuralFeature property) {
		
		org.eclipse.emf.ocl.parser.Environment propertyEnv =
			oldStyle.createPropertyContext(parent.getContextClassifier(), property);
		Variable selfVar = propertyEnv.getSelfVariable();
		
		org.eclipse.emf.ocl.parser.Environment newOldStyle =
			oldStyle.createEnvironment(CompatibilityUtil.getCompatibilityEnvironment(parent));
		if (newOldStyle instanceof EcoreEnvironment) {
			((EcoreEnvironment) newOldStyle).setContextProperty(property);
		}
		
		newOldStyle.addElement(selfVar.getName(), selfVar, true);
		newOldStyle.setSelfVariable(selfVar);
		
		return CompatibilityUtil.getCompatibilityEnvironment(
				parent,
				newOldStyle,
				this);
	}

    @Override
    public org.eclipse.ocl.Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createEnvironment() {
        return CompatibilityUtil.getCompatibilityEnvironment(
            null,
            oldStyle.createPackageContext(Collections.singletonList("ecore")), //$NON-NLS-1$
            this);
    }
    
	@Override
	public org.eclipse.ocl.Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createEnvironment(
			org.eclipse.ocl.Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent) {
		return CompatibilityUtil.getCompatibilityEnvironment(
				parent,
				oldStyle.createEnvironment(
						CompatibilityUtil.getCompatibilityEnvironment(parent)),
				this);
	}
	
	@Override
	public EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject>
	createEvaluationEnvironment() {
		return new CompatibilityEvaluationEnvironment(oldStyle.createEvaluationEnvironment());
	}
}
