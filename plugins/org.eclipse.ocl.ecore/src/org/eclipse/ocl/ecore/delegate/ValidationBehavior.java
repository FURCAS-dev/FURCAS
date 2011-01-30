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
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: ValidationBehavior.java,v 1.3 2011/01/23 22:18:53 auhl Exp $
 */
package org.eclipse.ocl.ecore.delegate;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.ExpressionInOCL;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.delegate.ValidationDelegate.Factory;

/**
 * @since 3.0
 */
public class ValidationBehavior extends AbstractDelegatedBehavior<EClassifier, EValidator.ValidationDelegate.Registry, ValidationDelegate.Factory>
{
	public static final ValidationBehavior INSTANCE = new ValidationBehavior();
	public static final String NAME = "validationDelegates"; //$NON-NLS-1$

	public ValidationDelegate.Factory getDefaultFactory() {
		return (Factory) ValidationDelegate.Factory.Registry.INSTANCE.getValidationDelegate(getName());
	}

	public EValidator.ValidationDelegate.Registry getDefaultRegistry() {
		return ValidationDelegate.Factory.Registry.INSTANCE;
	}

	public EPackage getEPackage(EClassifier eClassifier) {
		return eClassifier.getEPackage();
	}

	public ValidationDelegate.Factory getFactory(DelegateDomain delegateDomain, EClassifier eClassifier) {
		EValidator.ValidationDelegate.Registry registry = DelegateResourceSetAdapter.getRegistry(
			eClassifier, ValidationDelegate.Registry.class, getDefaultRegistry());
	    return (ValidationDelegate.Factory) registry.getValidationDelegate(delegateDomain.getURI());
	}

	public Class<ValidationDelegate.Factory> getFactoryClass() {
		return ValidationDelegate.Factory.class;
	}
	
	/**
	 * @since 3.1
	 */
	public OCLExpression getInvariant(EModelElement cls, String constraintName, OCL ocl) {
		OCLExpression result = getCachedExpression(cls, constraintName);
		if (result != null) {
			return result;
		}
		OCLExpression invariant = null;
		Constraint constraint = null;
		try {
			OCL.Helper helper = ocl.createOCLHelper();
			if (!(cls instanceof EClassifier)) {
				return null;
			}
			helper.setContext((EClassifier) cls);
			String expr = EcoreUtil.getAnnotation(cls, OCLDelegateDomain.OCL_DELEGATE_URI, constraintName);
			if (expr == null) {
				return null;
			}
			try {
				constraint = helper.createInvariant(expr);
			} catch (ParserException e) {
				throw new OCLDelegateException(e.getLocalizedMessage(), e);
			}
			if (constraint == null) {
				return null;
			}
			ExpressionInOCL specification = (ExpressionInOCL) constraint.getSpecification();
			if (specification == null) {
				return null;
			}
			invariant = (OCLExpression) specification.getBodyExpression();
			return invariant;
		}
		finally {
			cacheExpression(cls, constraint, constraintName);
		}
	}
	
	public String getName() {
		return NAME;
	}

	public Class<ValidationDelegate.Factory.Registry> getRegistryClass() {
		return ValidationDelegate.Factory.Registry.class;
	}
}