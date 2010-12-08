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
package org.eclipse.ocl.ecore.internal.helper;

import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EnvironmentWithHiddenOpposites;
import org.eclipse.ocl.ecore.OppositePropertyCallExp;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.utilities.VisitorExtension;
import org.eclipse.ocl.helper.Choice;
import org.eclipse.ocl.helper.ChoiceKind;
import org.eclipse.ocl.helper.ConstraintKind;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.osgi.util.NLS;


public class OCLSyntaxHelper
		extends
		org.eclipse.ocl.internal.helper.OCLSyntaxHelper<EPackage, EClassifier, EOperation, EStructuralFeature,
		EEnumLiteral, EParameter, EObject,
		CallOperationAction, SendSignalAction, Constraint,
		EClass, EObject> {

	public static class Provider implements org.eclipse.ocl.helper.OCLSyntaxHelper.IProvider<EPackage, EClassifier, EOperation, EStructuralFeature,
	EEnumLiteral, EParameter, EObject,
	CallOperationAction, SendSignalAction, Constraint,
	EClass, EObject>
	{
		public org.eclipse.ocl.helper.OCLSyntaxHelper createOCLSyntaxHelper(
				Environment<EPackage, EClassifier, EOperation, EStructuralFeature,
				EEnumLiteral, EParameter, EObject,
				CallOperationAction, SendSignalAction, Constraint,
				EClass, EObject> env) {
			return new org.eclipse.ocl.ecore.internal.helper.OCLSyntaxHelper(env);
		}
	}
	
	protected class ASTVisitor
			extends
			org.eclipse.ocl.internal.helper.OCLSyntaxHelper<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>.ASTVisitor
			implements VisitorExtension<List<Choice>>{
		ASTVisitor(String text, int position, ConstraintKind constraintType) {
			super(text, position, constraintType);
		}
		
		public List<Choice> visitOppositePropertyCallExp(OppositePropertyCallExp oppositepropertycallexp) {
			return getChoices(oppositepropertycallexp, getConstraintType());
		}
	}

	@Override
	protected ASTVisitor createASTVisitor(ConstraintKind constraintType,
			String txt, int position) {
		return new ASTVisitor(txt, position, constraintType);
	}

	public OCLSyntaxHelper(
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		super(env);
	}

	/**
	 * returns the choices list of structural features for the passed eclass
	 * @param eClass the eclass to get features from 
	 * @return List oclchoices list for structural features
	 */
	protected List<Choice> getPropertyChoices(EClassifier eClass) {
		List<Choice> result = super.getPropertyChoices(eClass);
		for (Entry<String, EReference> hiddenOppositeNameAndForwardProperty : ((EnvironmentWithHiddenOpposites) getEnvironment())
			.getHiddenOppositeProperties(eClass).entrySet()) {
			result.add(createChoice(hiddenOppositeNameAndForwardProperty
				.getKey(), NLS
				.bind(OCLMessages.HiddenOppositeOf,
					getDescription(hiddenOppositeNameAndForwardProperty
						.getValue())), ChoiceKind.PROPERTY,
				hiddenOppositeNameAndForwardProperty.getValue()));
		}
		return result;
	}
	
}
