/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   C.Damus, K.Hussey, E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: OCLValidationDelegate.java,v 1.4 2011/03/01 08:47:19 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.delegate;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.EnvironmentFactory;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.InvalidEvaluationException;
import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.evaluation.ModelManager;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;
import org.eclipse.osgi.util.NLS;

/**
 * An implementation of the dynamic validation delegate API, maintaining a cache
 * of compiled constraints and invariants.
 * 
 * @since 3.0
 */
public class OCLValidationDelegate implements ValidationDelegate
{	
	protected final OCLDelegateDomain delegateDomain;
	protected final EClassifier eClassifier;
	  
	/**
	 * Initializes me with the classifier whose DelegateEClassifierAdapter delegates to me.
	 * 
	 * @param classifier
	 *            my classifier
	 */
	public OCLValidationDelegate(OCLDelegateDomain delegateDomain, EClassifier classifier) {
		this.delegateDomain = delegateDomain;
		this.eClassifier = classifier;
	}

	protected boolean check(EvaluationVisitor evaluationVisitor, String constraintName, ExpressionInOcl query) {
		if (query.getType() != evaluationVisitor.getTypeManager().getBooleanType()) {
			String message = NLS.bind(OCLMessages.ValidationConstraintIsNotBoolean_ERROR_, constraintName);
			throw new OCLDelegateException(message);
		}
		try {
			Value result = query.accept(evaluationVisitor);
			if (result.isNull()) {
				String message = NLS.bind(OCLMessages.ValidationResultIsNull_ERROR_, constraintName);
				throw new OCLDelegateException(message);
			}
			return result.asBoolean();
		} catch (InvalidValueException e) {
			String message = NLS.bind(OCLMessages.ValidationResultIsNotBoolean_ERROR_, constraintName);
			throw new OCLDelegateException(message);
		} catch (InvalidEvaluationException e) {
			String message = NLS.bind(OCLMessages.ValidationResultIsInvalid_ERROR_, constraintName);
			throw new OCLDelegateException(message);
		}
	}

	public EvaluationVisitor createEvaluationVisitor(Object object, ExpressionInOcl query) {
		EnvironmentFactory environmentFactory = delegateDomain.getEnvironmentFactory();
		Environment rootEnvironment = environmentFactory.createEnvironment();
		// can determine a more appropriate context from the context
		// variable of the expression, to account for stereotype constraints
//			context = HelperUtil.getConstraintContext(rootEnvironment, context, expression);
		EvaluationEnvironment evaluationEnvironment = createEvaluationEnvironment(object, query, environmentFactory);
//			if ((value != null) && !value.isUndefined()) {
//				expression.getContextVariable().setValue(value);
//			}
		ModelManager extents = evaluationEnvironment.createModelManager(object);

		EvaluationVisitor evaluationVisitor = environmentFactory.createEvaluationVisitor(rootEnvironment, evaluationEnvironment, extents);
		return evaluationVisitor;
	}

	public EvaluationEnvironment createEvaluationEnvironment(Object object, ExpressionInOcl query,
			EnvironmentFactory environmentFactory) {
		EvaluationEnvironment evaluationEnvironment = environmentFactory.createEvaluationEnvironment();
		TypeManager typeManager = evaluationEnvironment.getTypeManager();
		ValueFactory valueFactory = typeManager.getValueFactory();
		Value value = valueFactory.valueOf(object);
		evaluationEnvironment.add(query.getContextVariable(), value);
		return evaluationEnvironment;
	}

	protected String evaluateMessage(EvaluationVisitor evaluationVisitor, String constraintName, ExpressionInOcl query) {
		OclExpression messageExpression = query.getMessageExpression();
		if (messageExpression == null) {
			return null;
		}
		try {
			Value result = messageExpression.accept(evaluationVisitor);
			return result.asString();
		} catch (InvalidValueException e) {
			String message = NLS.bind(OCLMessages.ValidationMessageIsNotString_ERROR_, constraintName);
			throw new OCLDelegateException(message);
		}
	}

	@Override
	public String toString() {
		return "<" + delegateDomain.getURI() + ":validate> " + eClassifier.getEPackage().getName() + "::" + eClassifier.getName(); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	public boolean validate(EClass eClass, EObject eObject,
			Map<Object, Object> context, EOperation invariant, String expression) {
		TypeManager typeManager = delegateDomain.getTypeManager();
		Operation operation = delegateDomain.getPivot(Operation.class, invariant);
		ExpressionInOcl query = InvocationBehavior.INSTANCE.getExpressionInOcl(typeManager, operation);
		EvaluationVisitor evaluationVisitor = createEvaluationVisitor(eObject, query);
		return check(evaluationVisitor, invariant.getName(), query);
	}

	public boolean validate(EClass eClass, EObject eObject,
			Map<Object, Object> context, String constraintName, String expression) {
		TypeManager typeManager = delegateDomain.getTypeManager();
		Type type = delegateDomain.getPivot(Type.class, eClass);
		Constraint constraint = ValidationBehavior.INSTANCE.getConstraint(
			typeManager, eClass, constraintName);
		if (constraint == null) {
			String message = NLS.bind(OCLMessages.MissingBodyForInvocationDelegate_ERROR_, type);
			throw new OCLDelegateException(message);
		}
		ExpressionInOcl query = ValidationBehavior.INSTANCE.getExpressionInOcl(typeManager, type, constraint);
		if (query == null) {
			String message = NLS.bind(OCLMessages.MissingBodyForInvocationDelegate_ERROR_, type);
			throw new OCLDelegateException(message);
		}
		EvaluationVisitor evaluationVisitor = createEvaluationVisitor(eObject, query);
		return check(evaluationVisitor, constraintName, query);
	}

	public boolean validate(EDataType eDataType, Object value,
			Map<Object, Object> context, String constraintName, String expression) {
		TypeManager typeManager = delegateDomain.getTypeManager();
		Type type = delegateDomain.getPivot(Type.class, eDataType);
		Constraint constraint = ValidationBehavior.INSTANCE.getConstraint(
			typeManager, eDataType, constraintName);
		if (constraint == null) {
			String message = NLS.bind(OCLMessages.MissingBodyForInvocationDelegate_ERROR_, type);
			throw new OCLDelegateException(message);
		}
		ExpressionInOcl query = ValidationBehavior.INSTANCE.getExpressionInOcl(typeManager, type, constraint);
		if (query == null) {
			String message = NLS.bind(OCLMessages.MissingBodyForInvocationDelegate_ERROR_, type);
			throw new OCLDelegateException(message);
		}
		EvaluationVisitor evaluationVisitor = createEvaluationVisitor(value, query);
		if (check(evaluationVisitor, constraintName, query)) {
			return true;
		}
		return false;
	}

	public boolean validate(EClass eClass, EObject eObject,
			DiagnosticChain diagnostics, Map<Object, Object> context,
			String constraintName, String expression, int severity, String source, int code) {
		TypeManager typeManager = delegateDomain.getTypeManager();
		Type type = delegateDomain.getPivot(Type.class, eClass);
		Constraint constraint = ValidationBehavior.INSTANCE.getConstraint(
			typeManager, eClass, constraintName);
		if (constraint == null) {
			String message = NLS.bind(OCLMessages.MissingBodyForInvocationDelegate_ERROR_, type);
			throw new OCLDelegateException(message);
		}
		ExpressionInOcl query = ValidationBehavior.INSTANCE.getExpressionInOcl(typeManager, type, constraint);
		if (query == null) {
			String message = NLS.bind(OCLMessages.MissingBodyForInvocationDelegate_ERROR_, type);
			throw new OCLDelegateException(message);
		}
		EvaluationVisitor evaluationVisitor = createEvaluationVisitor(eObject, query);
		if (check(evaluationVisitor, constraintName, query)) {
			return true;
		}
		String message = evaluateMessage(evaluationVisitor, constraintName, query);
		if (message == null) {
			Object objectLabel = EObjectValidator.getObjectLabel(eObject, context);
			message = NLS.bind(OCLMessages.ValidationConstraintIsNotSatisfied_ERROR_, constraintName, objectLabel);
		}
	    diagnostics.add(new BasicDiagnostic(severity, source, code, message, new Object [] { eObject }));
		return false;
	}

	public boolean validate(EDataType eDataType, Object value,
			DiagnosticChain diagnostics, Map<Object, Object> context,
			String constraintName, String expression, int severity, String source, int code) {
		TypeManager typeManager = delegateDomain.getTypeManager();
		Type type = delegateDomain.getPivot(Type.class, eDataType);
		Constraint constraint = ValidationBehavior.INSTANCE.getConstraint(
			typeManager, eDataType, constraintName);
		if (constraint == null) {
			String message = NLS.bind(OCLMessages.MissingBodyForInvocationDelegate_ERROR_, type);
			throw new OCLDelegateException(message);
		}
		ExpressionInOcl query = ValidationBehavior.INSTANCE.getExpressionInOcl(typeManager, type, constraint);
		if (query == null) {
			String message = NLS.bind(OCLMessages.MissingBodyForInvocationDelegate_ERROR_, type);
			throw new OCLDelegateException(message);
		}
		EvaluationVisitor evaluationVisitor = createEvaluationVisitor(value, query);
		if (check(evaluationVisitor, constraintName, query)) {
			return true;
		}
		String message = evaluateMessage(evaluationVisitor, constraintName, query);
		if (message == null) {
			Object objectLabel = EObjectValidator.getValueLabel(eDataType, value, context);
			message = NLS.bind(OCLMessages.ValidationConstraintIsNotSatisfied_ERROR_, constraintName, objectLabel);
		}
	    diagnostics.add(new BasicDiagnostic(severity, source, code, message, new Object [] { value }));
		return false;
	}
}
