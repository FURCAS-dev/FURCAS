/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: EcoreEnvironmentTest.java,v 1.1 2007/01/25 18:32:34 cdamus Exp $
 */

package org.eclipse.ocl.ecore.tests;

import java.util.List;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.helper.Choice;
import org.eclipse.ocl.helper.ChoiceKind;
import org.eclipse.ocl.helper.ConstraintKind;
import org.eclipse.ocl.helper.OCLHelper;

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
		// add a context which we won't use
		helper.setContext(EcorePackage.eINSTANCE.getEClassifier());

		final String EXPRESSION = "ocltest::Color::"; //$NON-NLS-1$

		// choices should be returned
		List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, EXPRESSION);
		assertNotNull(choices);
		assertFalse(choices.isEmpty());
		assertChoice(choices, ChoiceKind.ENUMERATION_LITERAL, "green"); //$NON-NLS-1$
		
		// remove the package from the global registry
		EPackage.Registry.INSTANCE.remove(fruitPackage.getNsURI());

		// registry no longer contains the fruit package
		// no choices should be returned
		choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, EXPRESSION); 
		assertNotNull(choices);
		assertTrue(choices.isEmpty());
	}

	/**
	 * Tests the use of a custom package registry with the EcoreEnvironment.
	 */
	public void test_customEPackageRegistry_lookup() {
		EPackage.Registry registry = new EPackageRegistryImpl();

		ocl = OCL.newInstance(new EcoreEnvironmentFactory(registry));
		OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper =
			ocl.createOCLHelper();
		
		// add a context which we won't use
		helper.setContext(EcorePackage.eINSTANCE.getEClassifier());

		final String EXPRESSION = "ocltest::Color::"; //$NON-NLS-1$

		// registry is empty, no choices should be returned
		List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, EXPRESSION); 
		assertNotNull(choices);
		assertTrue(choices.isEmpty());
		
		// add the fruit package to the registry
		registry.put(fruitPackage.getNsURI(), fruitPackage);

		// choices should now be returned
		choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, EXPRESSION);
		assertNotNull(choices);
		assertFalse(choices.isEmpty());
		assertChoice(choices, ChoiceKind.ENUMERATION_LITERAL, "green"); //$NON-NLS-1$
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
