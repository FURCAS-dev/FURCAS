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
 * $Id: AbstractOCLDelegateFactory.java,v 1.4 2011/05/07 05:53:44 ewillink Exp $
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
	protected OCLDelegateDomain delegateDomain;

	/**
	 * Construct a factory for an unknown delegate domain; often the global factory.
	 */
	protected AbstractOCLDelegateFactory() {
		this.delegateURI = OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT;
		this.delegateDomain = null;
	}

	protected OCLDelegateDomain getDelegateDomain(EPackage ePackage) {
		if (delegateDomain == null) {
			DelegateEPackageAdapter ePackageAdapter = DelegateEPackageAdapter.getAdapter(ePackage);
			delegateDomain = (OCLDelegateDomain) ePackageAdapter.getDelegateDomain(delegateURI);
		}
		return delegateDomain;
	}

	/**
	 * @nooverride This is not intended to be overridden by clients.
	 */
	public String getURI() {
		return delegateURI;
	}
}
