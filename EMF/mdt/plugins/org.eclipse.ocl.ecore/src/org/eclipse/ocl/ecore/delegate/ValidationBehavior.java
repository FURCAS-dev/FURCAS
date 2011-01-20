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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.ExpressionInOCL;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.delegate.ValidationDelegate.Factory;
import org.eclipse.ocl.ecore.internal.OCLInvariantCacheAdapter;

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
		OCLExpression result = getCachedInvariantBody(cls, constraintName);
		if (result != null && hasNoOCLDefinition(result)) {
			result = null; // clients can find that out by asking hasUncomiledInvariantBody
		}
		return result;
	}

	/**
	 * Looks for an {@link OCLInvariantCacheAdapter} attached to
	 * <code>cls</code>. If such an adapter is found, its
	 * {@link OCLInvariantCacheAdapter#get(String) expression for constraint
	 * <code>constraintName</code>} is returned; otherwise, <code>null</code> is
	 * returned. A special expression may be returned indicating that for
	 * <code>cls</code> no OCL expression exists for the constraint named
	 * <code>constraintName</code> and that an unsuccessful attempt to obtain
	 * one has been made before. To check for this case, callers shall use
	 * {@link #hasNoOCLDefinition(OCLExpression)}. If it returns
	 * <code>true</code>, no expression could be found.
	 * @since 3.1
	 */
	public OCLExpression getCachedInvariantBody(EClassifier cls, String constraintName) {
		Adapter a = EcoreUtil.getExistingAdapter(cls, OCLInvariantCacheAdapter.class);
		if (a != null) {
			return ((OCLInvariantCacheAdapter) a).get(constraintName);
		} else {
			return null;
		}
	}
	
	/**
	 * Creates an {@link OCLInvariantCacheAdapter} for expression <code>e</code> and adds
	 * it to <code>n</code>'s adapter list so that {@link #getCachedOCLExpression(Notifier)}
	 * will return <code>e</code> when called for <code>n</code>. To achieve this, any other
	 * {@link OCLInvariantCacheAdapter} in <code>n</code>'s adapter list is removed.
	 * 
	 * @param e if <code>null</code>, the respective cache entry for <code>constraintName</code>
	 * is removed.
	 * 
	 * @since 3.1
	 */
	public void cacheInvariantBody(EClassifier cls, String constraintName, OCLExpression e) {
		Adapter adapter = EcoreUtil.getExistingAdapter(cls, OCLInvariantCacheAdapter.class);
		if (adapter == null) {
			adapter = new OCLInvariantCacheAdapter();
			cls.eAdapters().add(adapter);
		}
		if (e == null) {
			((OCLInvariantCacheAdapter) adapter).remove(constraintName);
		} else {
			((OCLInvariantCacheAdapter) adapter).put(constraintName, e);
		}
	}
	
	/**
	 * @since 3.1
	 */
	public OCLExpression getInvariant(EClassifier cls, String constraintName, OCL ocl) {
		OCLExpression result = getCachedInvariant(cls, constraintName);
		if (result != null) {
			if (hasNoOCLDefinition(result)) {
				return null;
			} else {
				return result;
			}
		}
		OCLExpression invariant = null;
		OCL.Helper helper = ocl.createOCLHelper();
		helper.setContext(cls);
		String expr = EcoreUtil.getAnnotation(cls,
			OCLDelegateDomain.OCL_DELEGATE_URI, constraintName);
		if (expr == null) {
			cacheInvariantHasNoOCLBody(cls, constraintName);
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
		cacheInvariantBody(cls, constraintName, invariant);
		return invariant;
	}
	
	private void cacheInvariantHasNoOCLBody(EClassifier cls,
			String constraintName) {
		cacheInvariantBody(cls, constraintName, new NullExpression());
	}

	public String getName() {
		return NAME;
	}

	public Class<ValidationDelegate.Factory.Registry> getRegistryClass() {
		return ValidationDelegate.Factory.Registry.class;
	}
}