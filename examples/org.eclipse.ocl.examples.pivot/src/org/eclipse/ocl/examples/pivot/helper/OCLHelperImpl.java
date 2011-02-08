/**
 * <copyright>
 *
 * Copyright (c) 2007,2011 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: OCLHelperImpl.java,v 1.4 2011/02/08 17:51:47 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.helper;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.SemanticException;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.OCLUtil;
import org.eclipse.ocl.examples.pivot.PivotEnvironment;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationContext;
import org.eclipse.ocl.examples.pivot.model.OclMetaModel;
import org.eclipse.ocl.examples.pivot.util.Pivotable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.utilities.TypeManagerResourceAdapter;

/**
 * Implementation of the {@link OclMetaModel.Helper} convenience interface.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class OCLHelperImpl extends OCLBaseHelperImpl
{
	private static final Logger logger = Logger.getLogger(OCLHelperImpl.class);

	public OCLHelperImpl(OCL ocl) {
		super(ocl);
    }

	public ExpressionInOcl createQuery(String expression) throws ParserException {
		PivotEnvironment environment = (PivotEnvironment) getEnvironment();
		environment.getProblemHandler().beginParse();
		// FIXME Share with PivotUtil.resolveSpecification
		TypeManager typeManager = environment.getTypeManager();
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(PivotUtil.INTERNAL_URI);
		TypeManagerResourceAdapter.getAdapter(resource, typeManager);
		if (resource instanceof EvaluationContext) {
			((EvaluationContext)resource).setEnvironment(environment);
			((EvaluationContext)resource).setSpecificationContext(environment.getContextClassifier());
		}
		String string = expression;
		InputStream inputStream = new ByteArrayInputStream(string.getBytes());
		try {
			resource.load(inputStream, null);
		} catch (IOException e) {
			throw new ParserException("Failed to load expression", e);
		}
		OCLUtil.checkForErrors(((PivotEnvironment) getEnvironment()).getProblemHandler());
		checkResourceErrors("Errors in '" + expression + "'", resource);
		List<EObject> contents = resource.getContents();
		int size = contents.size();
		if (size == 0) {
			return null;
		}
		if (size > 1) {
			logger.warn("Extra returns ignored");
		}
		EObject csObject = contents.get(0);
		if (csObject instanceof Pivotable) {
			Element pivotElement = ((Pivotable)csObject).getPivot();
			if (pivotElement instanceof ExpressionInOcl) {
				return (ExpressionInOcl) pivotElement;
			}
		}
		logger.warn("Non-expression ignored");
		return null;
	}

	public ExpressionInOcl createInvariant(String expression) throws ParserException {
		return createSpecification(expression);
	}

	public ExpressionInOcl createPrecondition(String expression)
			throws ParserException {
		return createSpecification(expression);
	}

	public ExpressionInOcl createPostcondition(String expression)
			throws ParserException {
		return createSpecification(expression);
	}

	public ExpressionInOcl createBodyCondition(String expression)
			throws ParserException {
		return createSpecification(expression);
	}

	public static void checkResourceErrors(String message, Resource resource) throws ParserException {
		List<Resource.Diagnostic> errors = resource.getErrors();
		if (errors.size() > 0) {
			StringBuffer s = new StringBuffer();
			s.append(message);
			for (Resource.Diagnostic conversionError : errors) {
				s.append("\n");
				s.append(conversionError.getMessage());
			}
			throw new SemanticException(s.toString());
		}
	}

	public ExpressionInOcl createDerivedValueExpression(String expression)
			throws ParserException {
		return createSpecification(expression);
	}

	protected ExpressionInOcl createSpecification(String expression) throws ParserException {
		PivotEnvironment environment = (PivotEnvironment) getEnvironment();
		TypeManager typeManager = environment.getTypeManager();
		// FIXME Share with PivotUtil.resolveSpecification
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(PivotUtil.INTERNAL_URI);
		TypeManagerResourceAdapter.getAdapter(resource, typeManager);
		if (resource instanceof EvaluationContext) {
			((EvaluationContext)resource).setSpecificationContext(environment.getContextClassifier());
			((EvaluationContext)resource).setEnvironment(environment);
		}
		String string = expression;
		InputStream inputStream = new ByteArrayInputStream(string.getBytes());
		try {
			resource.load(inputStream, null);
		} catch (IOException e) {
			throw new ParserException("Failed to load expression", e);
		}
		checkResourceErrors("Errors in '" + expression + "'", resource);
		List<EObject> contents = resource.getContents();
		int size = contents.size();
		if (size == 0) {
			return null;
		}
		if (size > 1) {
			logger.warn("Extra returns ignored");
		}
		EObject csObject = contents.get(0);
		if (csObject instanceof Pivotable) {
			Element pivotElement = ((Pivotable)csObject).getPivot();
			if (pivotElement instanceof ExpressionInOcl) {
				return (ExpressionInOcl) pivotElement;
//				Constraint constraint = PivotFactory.eINSTANCE.createConstraint();
//				constraint.setStereotype("inv");
//				constraint.setSpecification((ExpressionInOcl) pivotElement);
//				return constraint;
			}
		}
		logger.warn("Non-expression ignored");
		return null;
	}
}
