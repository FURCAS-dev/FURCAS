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
 * $Id: OCLSettingDelegateFactory.java,v 1.2 2010/04/08 06:27:21 ewillink Exp $
 */
package de.hpi.sam.bp2009.solution.oclToAst.delegate;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.delegate.DelegateResourceSetAdapter;
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomain;

import de.hpi.sam.bp2009.solution.scopeProvider.ProjectDependencyQueryContextProvider;

/**
 * Factory for OCL derived-attribute setting delegates.
 * 
 * @since 3.0
 */
public class OCLSettingDelegateFactory extends org.eclipse.ocl.ecore.delegate.OCLSettingDelegateFactory

{
    public OCLSettingDelegateFactory() {}
    public OCLSettingDelegateFactory(OCLDelegateDomain delegateDomain) {
        super(delegateDomain);
    }
    public EStructuralFeature.Internal.SettingDelegate createSettingDelegate(EStructuralFeature structuralFeature) {
        EPackage ePackage = structuralFeature.getEContainingClass().getEPackage();
        new ProjectDependencyQueryContextProvider().apply(getDelegateDomain(ePackage).getOCL());
        return new OCLSettingDelegateForAnnotations(getDelegateDomain(ePackage), structuralFeature);
    }

    /**
     * The Global variant of the Factory delegates to a local ResourceSet factory if one
     * can be located at the EStructuralFeature.Internal.SettingDelegate.Factory.Registry
     * by the DelegateResourceSetAdapter.
     */
    public static class Global extends OCLSettingDelegateFactory
    {

        public EStructuralFeature.Internal.SettingDelegate createSettingDelegate(EStructuralFeature structuralFeature) {
            EStructuralFeature.Internal.SettingDelegate.Factory.Registry localRegistry = DelegateResourceSetAdapter.getRegistry(
                    structuralFeature, EStructuralFeature.Internal.SettingDelegate.Factory.Registry.class, null);
            if (localRegistry != null) {
                EStructuralFeature.Internal.SettingDelegate.Factory factory = localRegistry.getFactory(delegateURI);
                if (factory != null) {
                    return factory.createSettingDelegate(structuralFeature);
                }
            }
            return super.createSettingDelegate(structuralFeature);
        }	
    }
}
