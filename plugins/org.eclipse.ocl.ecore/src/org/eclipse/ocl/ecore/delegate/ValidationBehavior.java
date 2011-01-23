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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
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

/**
 * @since 3.0
 */
public class ValidationBehavior extends AbstractDelegatedBehavior<EClassifier, EValidator.ValidationDelegate.Registry, ValidationDelegate.Factory>
{
	public static final ValidationBehavior INSTANCE = new ValidationBehavior();
	public static final String NAME = "validationDelegates"; //$NON-NLS-1$

	/**
	 * Caches the OCL invariants of an {@link EClassifier}. Adding this cache
	 * doesn't {@link Notification#isTouch() "change"} the Ecore object to which it
	 * is attached.
	 * 
	 * @since 3.1
	 */
	protected static class InvariantCacheAdapter extends AdapterImpl
	{
		private final Map<String, OCLExpression> invariants = new HashMap<String, OCLExpression>();
		
		/**
		 * Returns the {@link OCLExpression} representing the abstract syntax of the constraint named
		 * <code>constraintName</code> if previously cached using {@link #put(String, OCLExpression)};
		 * <code>null</code> otherwise.
		 */
		public OCLExpression get(String constraintName) {
			return invariants.get(constraintName);
		}

		@Override
		public boolean isAdapterForType(Object type) {
			return type == InvariantCacheAdapter.class;
		}
				
		public void put(String constraintName, OCLExpression expression) {
			invariants.put(constraintName, expression);
		}
		
		/**
		 * Removes any cache entry for the constraint named <code>constraintName</code> and
		 * returns any expression previously cached under that constraint name if any, or
		 * <code>null</code> otherwise.
		 */
		public OCLExpression remove(String constraintName) {
			return invariants.remove(constraintName);
		}
	}
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
	public void cacheOCLExpression(EClassifier cls, String constraintName, OCLExpression e) {
		Adapter adapter = EcoreUtil.getExistingAdapter(cls, InvariantCacheAdapter.class);
		if (adapter == null) {
			if (e == null) {
				return;
			}
			adapter = new InvariantCacheAdapter();
			cls.eAdapters().add(adapter);
		}
		if (e == null) {
			((InvariantCacheAdapter) adapter).remove(constraintName);
		} else {
			((InvariantCacheAdapter) adapter).put(constraintName, e);
		}
	}

	/**
	 * Looks for an {@link OCLInvariantCacheAdapter} attached to <code>cls</code>.
	 * If such an adapter is found, a cached expression for <code>constraintName</code> is returned.
	 * The cached expression may be a reserved expression indicating that no OCL expression exists
	 * and that an unsuccessful attempt to obtain one has been made before.
	 * {@link #isNoOCLDefinition(OCLExpression)} should be used to check for the reserved expression.
	 * null is returned if no cached expression is available.
	 * 
	 * @since 3.1
	 */
	public OCLExpression getCachedOCLExpression(EClassifier cls, String constraintName) {
		Adapter a = EcoreUtil.getExistingAdapter(cls, InvariantCacheAdapter.class);
		if (a != null) {
			return ((InvariantCacheAdapter) a).get(constraintName);
		} else {
			return null;
		}
	}
	
	/**
	 * @since 3.1
	 */
	public OCLExpression getInvariant(EClassifier cls, String constraintName, OCL ocl) {
		OCLExpression result = getCachedOCLExpression(cls, constraintName);
		if (result != null) {
			return result != NO_OCL_DEFINITION ? result : null;
		}
		OCL.Helper helper = ocl.createOCLHelper();
		helper.setContext(cls);
		String expr = EcoreUtil.getAnnotation(cls,
			OCLDelegateDomain.OCL_DELEGATE_URI, constraintName);
		if (expr == null) {
			cacheOCLExpression(cls, constraintName, NO_OCL_DEFINITION);
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
		ExpressionInOCL specification = (ExpressionInOCL) constraint.getSpecification();
		if (specification == null) {
			return null;
		}
		OCLExpression invariant = (OCLExpression) specification.getBodyExpression();
		cacheOCLExpression(cls, constraintName, invariant);
		return invariant;
	}

	public String getName() {
		return NAME;
	}

	public Class<ValidationDelegate.Factory.Registry> getRegistryClass() {
		return ValidationDelegate.Factory.Registry.class;
	}
}