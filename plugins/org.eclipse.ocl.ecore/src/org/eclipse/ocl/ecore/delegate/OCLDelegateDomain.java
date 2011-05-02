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
 * $Id: OCLDelegateDomain.java,v 1.3 2010/05/03 09:32:49 ewillink Exp $
 */
package org.eclipse.ocl.ecore.delegate;

import java.lang.reflect.Constructor;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OppositePropertyCallExp;
import org.eclipse.ocl.ecore.opposites.EcoreEnvironmentFactoryWithHiddenOpposites;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;

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
	public static final String OCL_DELEGATE_URI = org.eclipse.emf.ecore.EcorePackage.eNS_URI + "/OCL"; //$NON-NLS-1$
	 /**
	 * If the annotation with source {@link #OCL_DELEGATE_URI} has a detail using this key with a
	 * class name the {@link EcoreEnvironmentFactory} loaded by this name is used
	 * (default {@link EcoreEnvironmentFactory})
	 * 
	 * @since 3.1
	 */
	public static final String KEY_FOR_OPPOSITE_END_FINDER_CLASS = "oppositeEndFinderClass"; //$NON-NLS-1$
	/**
	 * If the annotation with source {@link #OCL_DELEGATE_URI} has a detail using this key with a
	 * value of "true", the {@link EcoreEnvironmentFactoryWithHiddenOpposites} is used instead of
	 * the default {@link EcoreEnvironmentFactory}, making the OCL environment used by the delegates
	 * support "hidden opposites" and the {@link OppositePropertyCallExp}.
	 * 
	 * @since 3.1
	 */
	public static final String OCL_DELEGATES_USE_HIDDEN_OPPOSITES_KEY = "hiddenOpposites"; //$NON-NLS-1$
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
		ResourceSet resourceSet = res.getResourceSet();
		EcoreEnvironmentFactory envFactory;
		
		
		if (res != null && resourceSet != null) {
			// it's a dynamic package. Use the local package registry
			EPackage.Registry packageRegistry = resourceSet.getPackageRegistry();
			
			OppositeEndFinder finder = getDefinedOppositeEndFinder(ePackage, packageRegistry);

			if(finder != null){
				envFactory  = new EcoreEnvironmentFactoryWithHiddenOpposites(packageRegistry, finder);
			}
			else if(useHiddenOpposites(ePackage)){
				envFactory  = new EcoreEnvironmentFactoryWithHiddenOpposites(packageRegistry);
			}
			else{
				envFactory = new EcoreEnvironmentFactory(packageRegistry);
			}


			DelegateResourceAdapter.getAdapter(res);
		} else {
			OppositeEndFinder finder = getDefinedOppositeEndFinder(ePackage, EPackage.Registry.INSTANCE);

			// the shared instance uses the static package registry
			if(finder != null){
				envFactory  = new EcoreEnvironmentFactoryWithHiddenOpposites(finder);
			}
			else if(useHiddenOpposites(ePackage)){
				envFactory  = EcoreEnvironmentFactoryWithHiddenOpposites.INSTANCE;
			}
			else{
				envFactory = EcoreEnvironmentFactory.INSTANCE;
			}

		}
		this.ocl = OCL.newInstance(envFactory);
	}

	/**
	 * Reads the user/defined EcoreEnvironmentFactory from the annotation of the {@link EPackage}
	 * @param ePackage to read the {@link EAnnotation annotations} from
	 * @param registry to serve as param for the {@link OppositeEndFinder} constructor
	 * @return the defined {@link OppositeEndFinder} or null
	 */
	@SuppressWarnings("unchecked")
	private OppositeEndFinder getDefinedOppositeEndFinder(EPackage ePackage, EPackage.Registry registry) {
		OppositeEndFinder finder = null;
		// get cls-name for user-defined EcoreEnviromentFactory implementation
		EAnnotation eAnnotation = ePackage.getEAnnotation(OCL_DELEGATE_URI);
		String clsName = null;
		if (eAnnotation != null) {
			clsName = eAnnotation.getDetails().get(KEY_FOR_OPPOSITE_END_FINDER_CLASS);
		}
		if(clsName == null){
			return null;
		}
		Class<? extends OppositeEndFinder> cls;
		try {
			cls = (Class<? extends OppositeEndFinder>) ePackage.getClass().getClassLoader().loadClass(clsName);
			Constructor<? extends OppositeEndFinder> con = cls.getConstructor(EPackage.Registry.class);
			finder = con.newInstance(registry);
		} catch (Exception e) {
			/*...*/
			e.printStackTrace();
		}
		return finder;
	}
	
	private boolean useHiddenOpposites(EPackage ePackage) {
		EAnnotation ea = ePackage.getEAnnotation(OCL_DELEGATE_URI);
		if (ea != null) {
			String value = ea.getDetails().get(OCL_DELEGATES_USE_HIDDEN_OPPOSITES_KEY);
			if (value != null && Boolean.valueOf(value)) {
				return true;
			}
		}
		return false;
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

	public String toString() {
		return ePackage.getName() + " : " + getURI(); //$NON-NLS-1$
	}
}
