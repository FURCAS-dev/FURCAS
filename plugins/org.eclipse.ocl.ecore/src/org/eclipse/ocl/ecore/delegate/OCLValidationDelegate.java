/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
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
 * $Id: OCLValidationDelegate.java,v 1.2 2010/04/08 06:27:21 ewillink Exp $
 */
package org.eclipse.ocl.ecore.delegate;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.helper.ConstraintKind;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.types.OCLStandardLibrary;
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

	protected boolean check(Object object, String constraint, OCLExpression query) {
		OCL ocl = delegateDomain.getOCL();
		OCLStandardLibrary<EClassifier> stdlib = ocl.getEnvironment().getOCLStandardLibrary();
		if (query.getType() != stdlib.getBoolean()) {
			String message = NLS.bind(OCLMessages.ValidationConstraintIsNotBoolean_ERROR_, constraint);
			throw new OCLDelegateException(message);
		}
		Object result = ocl.evaluate(object, query);
		if (ocl.isInvalid(result)) {
			String message = NLS.bind(OCLMessages.ValidationResultIsInvalid_ERROR_, constraint);
			throw new OCLDelegateException(message);
		}
		if ((result == null) /* || ocl.isInvalid(result) */) {
			String message = NLS.bind(OCLMessages.ValidationResultIsNull_ERROR_, constraint);
			throw new OCLDelegateException(message);
		}
		if (!(result instanceof Boolean)) {
			String message = NLS.bind(OCLMessages.ValidationResultIsNotBoolean_ERROR_, constraint);
			throw new OCLDelegateException(message);
		}		
		return Boolean.TRUE.equals(result);
	}

	protected OCLExpression createQuery(String expression) {
		OCL ocl = delegateDomain.getOCL();
		Helper helper = ocl.createOCLHelper();
		helper.setContext(eClassifier);
		try {
			return helper.createQuery(/*(String)*/expression);
		} catch (ParserException e) {
			throw new OCLDelegateException(e.getLocalizedMessage(), e);
		}
	}

	private Constraint createConstraint(EOperation context, String expression) {
		OCL ocl = delegateDomain.getOCL();
		Helper helper = ocl.createOCLHelper();
		helper.setOperationContext((EClassifier) context.eContainer(), context);
		try {
			return helper.createConstraint(ConstraintKind.BODYCONDITION, /*(String)*/expression);
		} catch (ParserException e) {
			throw new OCLDelegateException(e.getLocalizedMessage(), e);
		}
	}

	private Constraint createConstraint(EClassifier eClassifier, String expression) {
		OCL ocl = delegateDomain.getOCL();
		Helper helper = ocl.createOCLHelper();
		helper.setContext(eClassifier);
		try {
			return helper.createConstraint(ConstraintKind.INVARIANT, /*(String)*/expression);
		} catch (ParserException e) {
			throw new OCLDelegateException(e.getLocalizedMessage(), e);
		}
	}

	public String toString() {
		return "<" + delegateDomain.getURI() + ":validate> " + eClassifier.getEPackage().getName() + "::" + eClassifier.getName(); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	public boolean validate(EClass eClass, EObject eObject,
			Map<Object, Object> context, EOperation invariant, String expression) {
		OCLExpression query = ValidationBehavior.INSTANCE.getCachedExpression(invariant, InvocationBehavior.BODY_CONSTRAINT_KEY);
		if (query == null) {
			Constraint constraint = createConstraint(invariant, expression);
			ValidationBehavior.INSTANCE.cacheExpression(invariant, constraint, InvocationBehavior.BODY_CONSTRAINT_KEY);
			query = (OCLExpression) constraint.getSpecification()
				.getBodyExpression();
		}
		return check(eObject, invariant.getName(), query);
	}

	public boolean validate(EClass eClass, EObject eObject,
			Map<Object, Object> context, String constraint, String expression) {
		OCLExpression query = ValidationBehavior.INSTANCE.getCachedExpression(
			eClass, constraint);
		if (query == null) {
			Constraint constraintAST = createConstraint(eClass, expression);
			ValidationBehavior.INSTANCE.cacheExpression(eClass, constraintAST, constraint);
			query = (OCLExpression) constraintAST.getSpecification()
				.getBodyExpression();
		}
		return check(eObject, constraint, query);
	}

	public boolean validate(EDataType eDataType, Object value,
			Map<Object, Object> context, String constraint, String expression) {
		OCLExpression query = ValidationBehavior.INSTANCE.getCachedExpression(
			eDataType, constraint);
		if (query == null) {
			Constraint constraintAST = createConstraint(eDataType, expression);
			ValidationBehavior.INSTANCE.cacheExpression(eDataType,
				constraintAST, constraint);
			query = (OCLExpression) constraintAST.getSpecification()
				.getBodyExpression();
		}
		return check(value, constraint, query);
	}
}
