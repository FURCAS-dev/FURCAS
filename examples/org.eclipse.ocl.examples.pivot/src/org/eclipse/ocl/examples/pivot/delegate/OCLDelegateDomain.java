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
 * $Id: OCLDelegateDomain.java,v 1.3 2011/02/11 20:00:29 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.delegate;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironmentFactory;

/**
 * An implementation of a delegate domain for an OCL enhanced package. The domain
 * maintains an OCL facade to be shared by all delegates within the package.
 * 
 * @since 3.0
 */
public class OCLDelegateDomain implements DelegateDomain
{
	/**
	 * The EAnnotation source URI for delegate OCL annotations.
	 * <p>
	 * For an EOperation, the EAnnotation details may include
	 * <br>
	 * a <tt>body</tt> key to provide an OCL expression value that specifies <tt>body:</tt> of the operation.
	 * <br>
	 * a <tt>precondition</tt> key to provide an OCL expression value that specifies <tt>pre:</tt> for the operation.
	 * <br>
	 * a <tt>postcondition</tt> key to provide an OCL expression value that specifies <tt>post:</tt> for the operation.
	 * <p>
	 * For an EStructuralFeature, the EAnnotation details may include
	 * <br>
	 * a <tt>derivation</tt> key to provide an OCL expression value that specifies <tt>derive:</tt> for the property.
	 * <br>
	 * a <tt>initial</tt> key to provide an OCL expression value that specifies <tt>initial:</tt> for the operation.
	 * <p>
	 * For an EClassifier (EClass, EDataType), the EAnnotation details may include
	 * <br>
	 * a <tt><i>constraintName</i></tt> key to provide an OCL expression value that specifies <tt>inv <i>constraintName</i>:</tt> for the classifier.
	 * <p>
	 * Note that the delegate OCL functionality must be enabled by an EPackage Ecore annotation specifying this URI
	 * as the value of <tt>invocationDelegates</tt>, <tt>settingDelegates</tt> and <tt>validationDelegates</tt> details
	 * keys.
	 * <p>
	 * Note also that validation must be enabled by specifying an EClassifier Ecore annotation with a space separated list
	 * of invariant <tt><i>constraintName</i></tt>s as the value of the <tt>constraints</tt> details key. 
	 * <p>
	 * See <tt>/org.eclipse.ocl.ecore.tests/model/Company.ecore</tt> or <tt>http://wiki.eclipse.org/MDT/OCLinEcore</tt> for an example.
	 */
	public static final String OCL_DELEGATE_URI_LPG = org.eclipse.emf.ecore.EcorePackage.eNS_URI + "/OCL"; //$NON-NLS-1$
	public static final String OCL_DELEGATE_URI_PIVOT = org.eclipse.emf.ecore.EcorePackage.eNS_URI + "/OCL/Pivot"; //$NON-NLS-1$

	protected final String uri;
	protected final EPackage ePackage;
	protected final OCL ocl;
	
	/**
	 * Initializes me with my delegate URI and package.
	 * 
	 * @param delegateURI
	 *            the delegate namespace I handle
	 * @param ePackage
	 *            the package that I handle
	 * 
	 * @throws ParserException
	 *             if the operation's OCL body expression is invalid
	 */
	public OCLDelegateDomain(String delegateURI, EPackage ePackage) {
		this.uri = delegateURI;
		this.ePackage = ePackage;
		Resource res = ePackage.eResource();
		PivotEnvironmentFactory envFactory = null;
		if (res != null) {
			ResourceSet resourceSet = res.getResourceSet();
			if (resourceSet != null) {
				// it's a dynamic package. Use the local package registry
				EPackage.Registry packageRegistry = resourceSet.getPackageRegistry();
				envFactory = new PivotEnvironmentFactory(packageRegistry, null);
				DelegateResourceAdapter.getAdapter(res);
			}
		}
		if (envFactory == null) {
			// the shared instance uses the static package registry
			envFactory = PivotEnvironmentFactory.getGlobalRegistryInstance();
		}
		this.ocl = OCL.newInstance(envFactory);
	}

	public void dispose() {
		if (ocl != null) {
			ocl.dispose();
		}
	}

	public OCL getOCL() {
		return ocl;
	}
	
	public String getURI() {
		return uri;
	}

	@Override
	public String toString() {
		return ePackage.getName() + " : " + getURI(); //$NON-NLS-1$
	}
}
