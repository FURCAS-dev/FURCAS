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
 * $Id: AbstractOCLDelegateFactory.java,v 1.5 2011/05/30 16:09:57 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.delegate;

import org.eclipse.emf.ecore.EPackage;

/**
 * Partial implementation of a factory of OCL delegates for Ecore features.
 * 
 * @since 3.0
 */
public abstract class AbstractOCLDelegateFactory
{
	protected final String delegateURI;

	/**
	 * Construct a factory for an unknown delegate domain; often the global factory.
	 */
	protected AbstractOCLDelegateFactory() {
		this.delegateURI = OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT;
	}

	protected OCLDelegateDomain getDelegateDomain(EPackage ePackage) {
		DelegateEPackageAdapter ePackageAdapter = DelegateEPackageAdapter.getAdapter(ePackage);
		OCLDelegateDomain delegateDomain = (OCLDelegateDomain) ePackageAdapter.getDelegateDomain(delegateURI);
		return delegateDomain;
	}

	/**
	 * @nooverride This is not intended to be overridden by clients.
	 */
	public String getURI() {
		return delegateURI;
	}
}
