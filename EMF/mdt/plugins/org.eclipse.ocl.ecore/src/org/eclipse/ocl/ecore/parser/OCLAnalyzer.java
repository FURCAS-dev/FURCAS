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
 * $Id: OCLAnalyzer.java,v 1.1 2010/12/15 17:32:43 ewillink Exp $
 */
package org.eclipse.ocl.ecore.parser;

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
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EnvironmentWithHiddenOpposites;
import org.eclipse.ocl.ecore.OppositePropertyCallExp;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.utilities.OCLFactoryWithHiddenOpposite;
import org.eclipse.ocl.expressions.NavigationCallExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.parser.AbstractOCLParser;

/**
 * @since 3.1
 */
public class OCLAnalyzer
		extends
		org.eclipse.ocl.parser.OCLAnalyzer<EPackage, EClassifier, EOperation, EStructuralFeature,
		EEnumLiteral, EParameter, EObject,
		CallOperationAction, SendSignalAction, Constraint,
		EClass, EObject> {

	public OCLAnalyzer(AbstractOCLParser parser) {
		super(parser);
	}

	public OCLAnalyzer(
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> rootEnvironment,
			String input) {
		super(rootEnvironment, input);
	}
	
	/**
	 * Attempts to parse a <tt>simpleNameCS</tt> as a property call expression.
	 * 
	 * @param simpleNameCS
	 *            the simple name
	 * @param env
	 *            the current environment
	 * @param source
	 *            the navigation source expression, or <code>null</code> if the
	 *            source is implicit
	 * @param owner
	 *            the owner of the property to be navigated, or
	 *            <code>null</code> if the source is implicit
	 * @param simpleName
	 *            the simple name, as a string
	 * @return the parsed property call, or <code>null</code> if the simple name
	 *         does not resolve to an available property
	 * 
	 * @see #simpleNameCS(SimpleNameCS, Environment, OCLExpression)
	 */
	@Override
	protected NavigationCallExp<EClassifier, EStructuralFeature> simpleNavigationName(
			SimpleNameCS simpleNameCS,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter, EObject,
			CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject> env,
			OCLExpression<EClassifier> source, EClassifier owner, String simpleName) {
		if (simpleName == null) {
			return null;
		}
		NavigationCallExp<EClassifier, EStructuralFeature> result = null;

		EStructuralFeature property = lookupProperty(simpleNameCS, env, owner, simpleName);
		if (property != null) {
			if ((uml.getOwningClassifier(property) == null) && (property instanceof EReference)) {
				// marks a temporary property that encodes a "hidden" opposite
				result = createOppositePropertyCallExp(simpleNameCS, (EnvironmentWithHiddenOpposites)env,
					source, owner, simpleName, ((EReference) property).getEOpposite());
			} else {
				result = createPropertyCallExp(simpleNameCS, env, source,
					owner, simpleName, property);
			}
		}
		return result;
	}

	private PropertyCallExp<EClassifier, EStructuralFeature> createPropertyCallExp(
			SimpleNameCS simpleNameCS,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter, EObject,
			CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject> env,
			OCLExpression<EClassifier> source, EClassifier owner, String simpleName, EStructuralFeature property) {
		PropertyCallExp<EClassifier, EStructuralFeature> result;
		TRACE("variableExpCS", "Property: " + simpleName);//$NON-NLS-2$//$NON-NLS-1$

		result = oclFactory.createPropertyCallExp();
		initASTMapping(env, result, simpleNameCS, null);
		result.setReferredProperty(property);
		result.setType(getPropertyType(simpleNameCS, env, owner, property));

		if (source != null) {
			result.setSource(source);
		} else {
			Variable<EClassifier, EParameter> implicitSource = env
				.lookupImplicitSourceForProperty(simpleName);
			VariableExp<EClassifier, EParameter> src = createVariableExp(env, simpleNameCS,
				implicitSource);
			result.setSource(src);
		}

		initPropertyPositions(result, simpleNameCS);
		return result;
	}

	private OppositePropertyCallExp createOppositePropertyCallExp(
			SimpleNameCS simpleNameCS, EnvironmentWithHiddenOpposites env,
			OCLExpression<EClassifier> source, EClassifier owner, String simpleName, EReference property) {
		OppositePropertyCallExp result;
		TRACE("variableExpCS", "Opposite Property: " + simpleName);//$NON-NLS-2$//$NON-NLS-1$

		// The following cast is permissible because opposite property calls can only occur in
		// environments that have factories implementing OCLFactoryWithHiddenOpposite, e.g.,
		// the OCLFactory implementation for OCLEcore.
		result = ((OCLFactoryWithHiddenOpposite) oclFactory).createOppositePropertyCallExp();
		initASTMapping(env, result, simpleNameCS, null);
		result.setReferredOppositeProperty(property);
		EClassifier propertyType = env.getOppositePropertyType(owner, property);
		initASTMapping(env, propertyType, simpleNameCS, property);
		result.setType(propertyType);

		if (source != null) {
			result.setSource(source);
		} else {
			Variable<EClassifier, EParameter> implicitSource =
				env.lookupImplicitSourceForOppositeProperty(simpleName);
			VariableExp<EClassifier, EParameter> src = createVariableExp(env,
				simpleNameCS, implicitSource);
			result.setSource(src);
		}

		initPropertyPositions(result, simpleNameCS);
		return result;
	}

	/**
	 * @since 3.1
	 */
	protected EReference lookupOppositeProperty(CSTNode cstNode,
			EnvironmentWithHiddenOpposites env, EClassifier owner, String name) {
		try {
			EReference property = env.lookupOppositeProperty(owner, name);
			if (cstNode != null) {
				cstNode.setAst(property);
			}
			return property;
		} catch (LookupException e) {
			ERROR(cstNode, null, e.getMessage());
			return e.getAmbiguousMatches().isEmpty()
				? null
				: (EReference) e.getAmbiguousMatches().get(0);
		}
	}

}
