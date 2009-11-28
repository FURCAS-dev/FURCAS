/**
 * <copyright>
 * 
 * Copyright (c) 2008, 2009 IBM Corporation, Open Canarias S.L. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Adolfo Sanchez-Barbudo Herrera - Bug 260403
 *
 * </copyright>
 *
 * $$
 */

package org.eclipse.ocl.ecore.tests;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.options.ParsingOptions;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.UMLReflection;

/**
 * Tests for parsing options.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class ParsingOptionsTest
		extends AbstractTestSuite {

	/**
	 * Tests the implicit root class option for access to operations.
	 */
	public void test_implicitRootClass_option_operations() {
		helper.setContext(apple);
		final String text = "not self.eIsProxy()";

		// parse without the option
		try {
			helper.createInvariant(text);
			fail("Should not have successfully parsed.");
		} catch (ParserException e) {
			// success
			System.out
				.println("Got expected exception: " + e.getLocalizedMessage());
		}

		ParsingOptions.setOption(ocl.getEnvironment(), ParsingOptions
			.implicitRootClass(ocl.getEnvironment()),
			EcorePackage.Literals.EOBJECT);

		// parse with the option
		try {
			Constraint constraint = helper.createInvariant(text);

			// try evaluation

			EObject anApple = fruitPackage.getEFactoryInstance().create(apple);
			assertTrue(ocl.check(anApple, constraint));

			((InternalEObject) anApple).eSetProxyURI(URI
				.createURI("http://foo#proxy"));
			assertFalse(ocl.check(anApple, constraint));
		} catch (ParserException e) {
			fail("Should not have failed to parse:" + e.getLocalizedMessage());
		}
	}

	/**
	 * Tests the implicit root class option for access to attributes.
	 */
	public void test_implicitRootClass_option_attributes() {
		helper.setContext(EcorePackage.Literals.EPACKAGE);
		final String text = "self.relatedFruits->isEmpty()";

		// parse without the option
		try {
			helper.createInvariant(text);
			fail("Should not have successfully parsed.");
		} catch (ParserException e) {
			// success
			System.out
				.println("Got expected exception: " + e.getLocalizedMessage());
		}

		ParsingOptions.setOption(ocl.getEnvironment(), ParsingOptions
			.implicitRootClass(ocl.getEnvironment()), apple); // don't try this
																// at home!

		// parse with the option
		try {
			helper.createInvariant(text);
		} catch (ParserException e) {
			fail("Should not have failed to parse:" + e.getLocalizedMessage());
		}
	}

	/**
	 * Tests the implicit root class option for testing common supertype.
	 */
	public void test_implicitRootClass_option_commonSupertype() {
		// without the option
		assertSame(ocl.getEnvironment().getOCLStandardLibrary().getOclAny(),
			TypeUtil.commonSuperType(null, ocl.getEnvironment(), apple, stem));

		ParsingOptions.setOption(ocl.getEnvironment(), ParsingOptions
			.implicitRootClass(ocl.getEnvironment()),
			EcorePackage.Literals.EOBJECT);

		// with the option
		assertSame(EcorePackage.Literals.EOBJECT, TypeUtil.commonSuperType(
			null, ocl.getEnvironment(), apple, stem));
	}

	/**
	 * Tests the implicit root class option for testing type conformance.
	 */
	public void test_implicitRootClass_option_getRelationship() {
		// without the option
		assertEquals(UMLReflection.UNRELATED_TYPE, TypeUtil.getRelationship(ocl
			.getEnvironment(), EcorePackage.Literals.EOBJECT, apple));
		assertEquals(UMLReflection.UNRELATED_TYPE, TypeUtil.getRelationship(ocl
			.getEnvironment(), apple, EcorePackage.Literals.EOBJECT));

		ParsingOptions.setOption(ocl.getEnvironment(), ParsingOptions
			.implicitRootClass(ocl.getEnvironment()),
			EcorePackage.Literals.EOBJECT);

		// with the option
		assertEquals(UMLReflection.STRICT_SUPERTYPE, TypeUtil.getRelationship(
			ocl.getEnvironment(), EcorePackage.Literals.EOBJECT, apple));
		assertEquals(UMLReflection.STRICT_SUBTYPE, TypeUtil.getRelationship(ocl
			.getEnvironment(), apple, EcorePackage.Literals.EOBJECT));
	}

}
