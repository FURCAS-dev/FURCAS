/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: EcoreEnvironmentTest.java,v 1.9 2007/06/06 18:56:54 cdamus Exp $
 */

package org.eclipse.emf.ocl.tests;

import java.util.List;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ocl.helper.ChoiceType;
import org.eclipse.emf.ocl.helper.ConstraintType;
import org.eclipse.emf.ocl.helper.HelperUtil;
import org.eclipse.emf.ocl.helper.IOCLHelper;
import org.eclipse.emf.ocl.parser.EcoreEnvironmentFactory;

/**
 * Tests the {@link ExpressionsUtil} class.
 *
 * @author Christian Vogt (cvogt)
 */
public class EcoreEnvironmentTest
	extends AbstractTestSuite {

	public EcoreEnvironmentTest(String name) {
		super(name);
	}
	
	public static Test suite() {
		return new TestSuite(EcoreEnvironmentTest.class, "Ecore Environment Tests"); //$NON-NLS-1$
	}

	/**
	 * Tests the default EcoreEnvironment which uses the global package registry.
	 */
	public void test_globalEPackageRegistry_lookup() {
		IOCLHelper helper = HelperUtil.createOCLHelper(EcoreEnvironmentFactory.ECORE_INSTANCE);
		
		// add a context which we won't use
		helper.setContext(EcorePackage.eINSTANCE.getEClassifier());

		final String EXPRESSION = "ocltest::Color::"; //$NON-NLS-1$

		// choices should be returned
		List choices = helper.getSyntaxHelp(ConstraintType.INVARIANT, EXPRESSION);
		assertNotNull(choices);
		assertFalse(choices.isEmpty());
		assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "green"); //$NON-NLS-1$
		
		// remove the package from the global registry
		EPackage.Registry.INSTANCE.remove(fruitPackage.getNsURI());

		// registry no longer contains the fruit package
		// no choices should be returned
		choices = helper.getSyntaxHelp(ConstraintType.INVARIANT, EXPRESSION); 
		assertNotNull(choices);
		assertTrue(choices.isEmpty());
	}

	/**
	 * Tests the use of a custom package registry with the EcoreEnvironment.
	 */
	public void test_customEPackageRegistry_lookup() {
		EPackage.Registry registry = new EPackageRegistryImpl();

		IOCLHelper helper = HelperUtil.createOCLHelper(new EcoreEnvironmentFactory(registry));
		
		// add a context which we won't use
		helper.setContext(EcorePackage.eINSTANCE.getEClassifier());

		final String EXPRESSION = "ocltest::Color::"; //$NON-NLS-1$

		// registry is empty, no choices should be returned
		List choices = helper.getSyntaxHelp(ConstraintType.INVARIANT, EXPRESSION); 
		assertNotNull(choices);
		assertTrue(choices.isEmpty());
		
		// add the fruit package to the registry
		registry.put(fruitPackage.getNsURI(), fruitPackage);

		// choices should now be returned
		choices = helper.getSyntaxHelp(ConstraintType.INVARIANT, EXPRESSION);
		assertNotNull(choices);
		assertFalse(choices.isEmpty());
		assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "green"); //$NON-NLS-1$
	}
	
	//
	// Framework methods
	//
	
	protected void tearDown() throws Exception {
		// deregister the fruit package so that it won't confuse the global registry
		EPackage.Registry.INSTANCE.remove(fruitPackage.getNsURI());
		
		// let the next test's setup recreate the package
		fruitPackage = null;
		
		super.tearDown();
	}
}
