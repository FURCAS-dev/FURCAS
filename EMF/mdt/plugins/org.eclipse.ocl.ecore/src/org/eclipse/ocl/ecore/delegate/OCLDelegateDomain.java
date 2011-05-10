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
 * $Id: OCLDelegateDomain.java,v 1.4 2011/05/10 21:18:33 auhl Exp $
 */
package org.eclipse.ocl.ecore.delegate;

import java.lang.reflect.Constructor;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.EnvironmentFactory;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OppositePropertyCallExp;
import org.eclipse.ocl.ecore.opposites.EcoreEnvironmentFactoryWithHiddenOpposites;

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
	 * For an EPackage, the EAnnotation details may include
	 * <br>
	 * an {@link #KEY_FOR_ENVIRONMENT_FACTORY_CLASS environmentFactoryClass} key whose value is the fully qualified
	 * class name for the {@link EnvironmentFactory}. If no key is specified either the {@link EcoreEnvironmentFactory}
	 * or {@link EcoreEnvironmentFactoryWithHiddenOpposites} class are used.
	 * <br>
	 * a {@link #OCL_DELEGATES_USE_HIDDEN_OPPOSITES_KEY hiddenOpposites} key that may have a <tt>true</tt> value to
	 * use the {@link EcoreEnvironmentFactoryWithHiddenOpposites} class rather than the {@link EcoreEnvironmentFactory}
	 * when no {@link #KEY_FOR_ENVIRONMENT_FACTORY_CLASS environmentFactoryClass} key is specified.
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
	 * If the EPackage annotation with source {@link #OCL_DELEGATE_URI} has a detail using this key,
	 * the value is the fully qualified name of the class to be used as the {@link EnvironmentFactory}
	 * for parsing and evaluation for OCL constrinats defined in the EPackage. The class must have a
	 * a constructor that takes a single {@link EPackage.Registry} argument.
	 * 
	 * @since 3.1
	 */
	public static final String KEY_FOR_ENVIRONMENT_FACTORY_CLASS = "environmentFactoryClass"; //$NON-NLS-1$
	
	/**
	 * If the EPackage annotation with source {@link #OCL_DELEGATE_URI} has a detail using this key with a
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
		EPackage.Registry packageRegistry = null;
		if (res != null) {
			ResourceSet resourceSet = res.getResourceSet();
			if (resourceSet != null) {
				// it's a dynamic package. Use the local package registry
				packageRegistry = resourceSet.getPackageRegistry();
			}
		}
		if (packageRegistry == null) {			// Deprecated compatibility
			packageRegistry = EPackage.Registry.INSTANCE;
		}
		EcoreEnvironmentFactory envFactory = null;
		EAnnotation eAnnotation = ePackage.getEAnnotation(OCL_DELEGATE_URI);
		if (eAnnotation != null) {
			EMap<String, String> details = eAnnotation.getDetails();
			String clsName = details.get(KEY_FOR_ENVIRONMENT_FACTORY_CLASS);
			if (clsName != null) {
				ClassLoader classLoader = ePackage.getClass().getClassLoader();
				try {
					Class<?> cls = classLoader.loadClass(clsName);
					Constructor<?> con = cls.getConstructor(EPackage.Registry.class);
					envFactory = (EcoreEnvironmentFactory) con.newInstance(packageRegistry);
				} catch (Exception e) {
					throw new WrappedException(
						"Error instantiating " + KEY_FOR_ENVIRONMENT_FACTORY_CLASS + " " + clsName + //$NON-NLS-1$ //$NON-NLS-2$
							": " + e.getMessage(), e); //$NON-NLS-1$
				}
			} else {
				String value = details.get(OCL_DELEGATES_USE_HIDDEN_OPPOSITES_KEY);
				if (value != null && Boolean.valueOf(value)) {
					envFactory = new EcoreEnvironmentFactoryWithHiddenOpposites(
						packageRegistry);
				}
			}
		}
		if (envFactory == null) {
			envFactory = new EcoreEnvironmentFactory(packageRegistry);
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

	public String toString() {
		return ePackage.getName() + " : " + getURI(); //$NON-NLS-1$
	}
}
