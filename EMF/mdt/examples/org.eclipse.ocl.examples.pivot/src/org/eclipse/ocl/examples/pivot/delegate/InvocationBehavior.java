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
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: InvocationBehavior.java,v 1.3 2011/02/11 20:00:29 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.delegate;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EOperation.Internal.InvocationDelegate;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.UMLReflection;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.osgi.util.NLS;

/**
 * @since 3.0
 */
public class InvocationBehavior extends AbstractDelegatedBehavior<EOperation, InvocationDelegate.Factory.Registry, InvocationDelegate.Factory>
{
	public static final InvocationBehavior INSTANCE = new InvocationBehavior();
	public static final String BODY_CONSTRAINT_KEY = "body"; //$NON-NLS-1$
	public static final String NAME = "invocationDelegates"; //$NON-NLS-1$

//	public boolean appliesTo(EOperation operation) {
//      	String annotation = EcoreUtil.getAnnotation(operation, OCLDelegateDomain.OCL_DELEGATE_URI, BODY_CONSTRAINT_KEY);
//		return annotation != null;
//	}

	public InvocationDelegate.Factory getDefaultFactory() {
		return InvocationDelegate.Factory.Registry.INSTANCE.getFactory(getName());
	}

	public InvocationDelegate.Factory.Registry getDefaultRegistry() {
		return InvocationDelegate.Factory.Registry.INSTANCE;
	}

	public EPackage getEPackage(EOperation eOperation) {
		return eOperation.getEContainingClass().getEPackage();
	}

	/**
	 * Return the operation body associated with operation, if necessary using
	 * <code>ocl</code> to create the relevant parsing environment for a textual
	 * definition.
	 * @throws OCLDelegateException 
	 */
	public ExpressionInOcl getExpressionInOcl(TypeManager typeManager, Operation operation) throws OCLDelegateException {
		Constraint constraint = getConstraintForStereotype(operation, UMLReflection.BODY);
		if (constraint != null) {
			ExpressionInOcl expressionInOcl = getExpressionInOcl(typeManager, operation, constraint);
			if (expressionInOcl != null) {
				return expressionInOcl;
			}
		}
		String message = NLS.bind(OCLMessages.MissingBodyForInvocationDelegate_ERROR_, operation);
		throw new OCLDelegateException(message);
	}

	@Override
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

	public Class<InvocationDelegate.Factory.Registry> getRegistryClass() {
		return InvocationDelegate.Factory.Registry.class;
	}
}