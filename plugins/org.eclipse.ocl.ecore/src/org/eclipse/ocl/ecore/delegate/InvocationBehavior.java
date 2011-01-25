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
 * $Id: InvocationBehavior.java,v 1.4 2011/01/23 22:18:53 auhl Exp $
 */
package org.eclipse.ocl.ecore.delegate;


import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EOperation.Internal.InvocationDelegate;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.ExpressionInOCL;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;

/**
 * @since 3.0
 */
public class InvocationBehavior extends AbstractDelegatedBehavior<EOperation, InvocationDelegate.Factory.Registry, InvocationDelegate.Factory>
{
	public static final InvocationBehavior INSTANCE = new InvocationBehavior();
	public static final String BODY_CONSTRAINT_KEY = "body"; //$NON-NLS-1$
	public static final String NAME = "invocationDelegates"; //$NON-NLS-1$

	public boolean appliesTo(EOperation operation) {
      	String annotation = EcoreUtil.getAnnotation(operation, OCLDelegateDomain.OCL_DELEGATE_URI, BODY_CONSTRAINT_KEY);
		return annotation != null;
	}
	
	/**
	 * Creates an {@link OCLExpressionCacheAdapter} for expression <code>e</code> and adds
	 * it to <code>operation</code>'s adapter list so that {@link #getCachedOCLExpression(Notifier)}
	 * will return <code>e</code> when called for <code>operation</code>. To achieve this, any other
	 * {@link OCLExpressionCacheAdapter} in <code>operation</code>'s adapter list is removed.
	 * 
	 * @param e if <code>null</code>, any existing cache entry is removed and no new entry
	 * is created. {@link #getCachedOCLExpression(Notifier)} will then return <code>null</code>. 
	 * 
	 * @since 3.1
	 */
	public void cacheOCLExpression(EOperation operation, OCLExpression e) {
		ExpressionCacheAdapter.cacheOCLExpression(operation, e);
	}

	/**
	 * Looks for an {@link OCLExpressionCacheAdapter} attached to <code>operation</code>.
	 * If such an adapter is found, its cached expression is returned. The cached expression
	 * may be a reserved expression indicating that no OCL expression exists and that an
	 * unsuccessful attempt to obtain one has been made before.
	 * {@link #isNoOCLDefinition(OCLExpression)} should be used to check for the reserved expression.
	 * null is returned if no cached expression is available.
	 * 
	 * @since 3.1
	 */
	public OCLExpression getCachedOCLExpression(EOperation operation) {
		return ExpressionCacheAdapter.getCachedOCLExpression(operation);
	}

	public InvocationDelegate.Factory getDefaultFactory() {
		return InvocationDelegate.Factory.Registry.INSTANCE.getFactory(getName());
	}

	public InvocationDelegate.Factory.Registry getDefaultRegistry() {
		return InvocationDelegate.Factory.Registry.INSTANCE;
	}

	public EPackage getEPackage(EOperation eOperation) {
		return eOperation.getEContainingClass().getEPackage();
	}

	public InvocationDelegate.Factory getFactory(DelegateDomain delegateDomain, EOperation eOperation) {
		InvocationDelegate.Factory.Registry registry = DelegateResourceSetAdapter.getRegistry(
			eOperation, getRegistryClass(), getDefaultRegistry());
	    return registry.getFactory(delegateDomain.getURI());
	}

	public Class<InvocationDelegate.Factory> getFactoryClass() {
		return InvocationDelegate.Factory.class;
	}
	
	public String getName() {
		return NAME;
	}

	/**
	 * Return the operation body associated with operation, if necessary using
	 * <code>ocl</code> to create the relevant parsing environment for a textual
	 * definition.
	 */
	public OCLExpression getOperationBody(OCL ocl, EOperation operation) {
		OCLExpression result = ExpressionCacheAdapter.getCachedOCLExpression(operation);
		if (result != null) {
			return result != NO_OCL_DEFINITION ? result : null;
		}
		String expr = EcoreUtil.getAnnotation(operation, OCLDelegateDomain.OCL_DELEGATE_URI, BODY_CONSTRAINT_KEY);
		if (expr == null) {
			ExpressionCacheAdapter.cacheOCLExpression(operation, NO_OCL_DEFINITION);
			return null;
		}
		EClass context = operation.getEContainingClass();
		OCL.Helper helper = ocl.createOCLHelper();
		helper.setOperationContext(context, operation);
		Constraint constraint;
		try {
			constraint = helper.createBodyCondition(expr);
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
		OCLExpression body = (OCLExpression) specification.getBodyExpression();
		ExpressionCacheAdapter.cacheOCLExpression(operation, body);
		return body;
	}

	public Class<InvocationDelegate.Factory.Registry> getRegistryClass() {
		return InvocationDelegate.Factory.Registry.class;
	}
	
	/**
	 * Tells if there is a textual expression for the <code>operation</code> in an
	 * annotation that can be compiled by {@link #getOperationBody(OCL, EOperation)}. Probing
	 * this saves callers the more expensive construction of an {@link OCL} object.
	 * @since 3.1
	 */
	public boolean hasCompileableOperationBody(EOperation operation) {
		return EcoreUtil.getAnnotation(operation, OCLDelegateDomain.OCL_DELEGATE_URI, BODY_CONSTRAINT_KEY) != null;
	}
}