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
 * $Id: OCLInvocationDelegateFactory.java,v 1.2 2010/04/08 06:27:21 ewillink Exp $
 */
package de.hpi.sam.bp2009.solution.oclToAst.delegate;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.ecore.delegate.DelegateResourceSetAdapter;
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomain;

import de.hpi.sam.bp2009.solution.scopeProvider.ProjectDependencyQueryContextProvider;

/**
 * Factory for OCL operation-invocation delegates.
 * 
 * @since 3.0
 */
public class OCLInvocationDelegateFactory extends org.eclipse.ocl.ecore.delegate.OCLInvocationDelegateFactory
implements EOperation.Internal.InvocationDelegate.Factory {

    public OCLInvocationDelegateFactory() {}

    public OCLInvocationDelegateFactory(OCLDelegateDomain delegateDomain) {
        super(delegateDomain);
    }

    public EOperation.Internal.InvocationDelegate createInvocationDelegate(EOperation operation) {
        EPackage ePackage = operation.getEContainingClass().getEPackage();
        new ProjectDependencyQueryContextProvider().apply(getDelegateDomain(ePackage).getOCL());
        return new OCLInvocationDelegateForAnnotations(getDelegateDomain(ePackage), operation);
    }

    /**
     * The Global variant of the Factory delegates to a local ResourceSet factory if one
     * can be located at the EOperation.Internal.InvocationDelegate.Factory.Registry
     * by the DelegateResourceSetAdapter.
     */
    public static class Global extends OCLInvocationDelegateFactory
    {
        public EOperation.Internal.InvocationDelegate createInvocationDelegate(EOperation operation) {
            EOperation.Internal.InvocationDelegate.Factory.Registry localRegistry = DelegateResourceSetAdapter.getRegistry(
                    operation, EOperation.Internal.InvocationDelegate.Factory.Registry.class, null);
            if (localRegistry != null) {
                EOperation.Internal.InvocationDelegate.Factory factory = localRegistry.getFactory(delegateURI);
                if (factory != null) {
                    return factory.createInvocationDelegate(operation);
                }
            }
            return super.createInvocationDelegate(operation);
        }	
    }
}
