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
 * $Id: ValidationBehavior.java,v 1.2 2010/04/08 06:27:21 ewillink Exp $
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
import org.eclipse.ocl.ecore.internal.OCLEcorePlugin;

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
	 * Return any operation body already in the cache, saving the caller the overhead
	 * of setting up the redundant parsing environment needed for {@link getOperationBody}
	 * 
	 * @since 3.1
	 */
	public OCLExpression getCachedInvariant(EClassifier cls, String constraintName) {
		OCLEcorePlugin pluginInstance = OCLEcorePlugin.getInstance();
		OCLExpression result = pluginInstance.getCachedInvariantBody(cls, constraintName);
		if (result == null) {
			result = getCachedExpression(cls, constraintName);
			if (result != null) {
				pluginInstance.cacheInvariantBody(cls, constraintName, result);
			}
		} else if (pluginInstance.featureHasNonOCLDefinition(result)) {
			result = null; // clients can find that out by asking hasUncomiledInvariantBody
		}
		return result;
	}
	
	/**
	 * Tells if there is an uncompiled body expression for the <code>cls</code> type's
	 * constraint named <code>constraintName</code> in an
	 * annotation that can be compiled by {@link #getInvariant(EModelElement, String, OCL)}. Probing
	 * this saves callers the more expensive construction of an {@link OCL} object.
	 * @since 3.1
	 */
	public boolean hasUncompiledInvariantBody(EClassifier cls, String constraintName) {
		return EcoreUtil.getAnnotation(cls, OCLDelegateDomain.OCL_DELEGATE_URI, constraintName) != null;
	}
	
	/**
	 * @since 3.1
	 */
	public OCLExpression getInvariant(EClassifier cls, String constraintName, OCL ocl) {
		OCLExpression result = getCachedInvariant(cls, constraintName);
		if (result != null) {
			return result;
		}
		OCLExpression invariant = null;
		OCL.Helper helper = ocl.createOCLHelper();
		helper.setContext(cls);
		OCLEcorePlugin pluginInstance = OCLEcorePlugin.getInstance();
		String expr = EcoreUtil.getAnnotation(cls,
			OCLDelegateDomain.OCL_DELEGATE_URI, constraintName);
		if (expr == null) {
			pluginInstance.cacheInvariantHasNoOCLBody(cls, constraintName);
			return null;
		}
		Constraint constraint;
		try {
			constraint = helper.createInvariant(expr);
		} catch (ParserException e) {
			throw new OCLDelegateException(e.getLocalizedMessage(), e);
		}
		if (constraint == null) {
			return null;
		}
		ExpressionInOCL specification = (ExpressionInOCL) constraint
			.getSpecification();
		if (specification == null) {
			return null;
		}
		invariant = (OCLExpression) specification.getBodyExpression();
		pluginInstance.cacheInvariantBody(cls, constraintName, invariant);
		return invariant;
	}
	
	public String getName() {
		return NAME;
	}

	public Class<ValidationDelegate.Factory.Registry> getRegistryClass() {
		return ValidationDelegate.Factory.Registry.class;
	}
}