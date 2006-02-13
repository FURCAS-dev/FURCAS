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
 * $Id$
 */

package org.eclipse.emf.ocl.helper.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.helper.HelperUtil;
import org.eclipse.emf.ocl.helper.IOCLHelper;

/**
 * Tests the constraint parsing support.
 *
 * @author Christian W. Damus (cdamus)
 */
public class ParsingTest
	extends AbstractTestSuite {

	/**
	 * Initializes me with my name.
	 */
	public ParsingTest(String name) {
		super(name);
	}
	
	public static Test suite() {
		return new TestSuite(ParsingTest.class, "Constraint Parsing Tests"); //$NON-NLS-1$
	}
	
	public void test_createInvariant() {
		IOCLHelper helper = HelperUtil.createOclHelper();

		helper.setContext(fruit);
		
		try {
			OCLExpression expr = helper.createInvariant("color <> Color::black"); //$NON-NLS-1$
			
			assertNotNull(expr);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_createPrecondition() {
		IOCLHelper helper = HelperUtil.createOclHelper();

		helper.setContextOperation(fruit, fruit_ripen);
		
		try {
			OCLExpression expr = helper.createPrecondition(
				"color <> Color::black"); //$NON-NLS-1$
			
			assertNotNull(expr);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_createPostcondition() {
		IOCLHelper helper = HelperUtil.createOclHelper();

		helper.setContextOperation(fruit, fruit_ripen);
		
		try {
			OCLExpression expr = helper.createPostcondition(
				"color <> self.color@pre implies self.color = color "); //$NON-NLS-1$
			
			assertNotNull(expr);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_createBodyCondition() {
		IOCLHelper helper = HelperUtil.createOclHelper();

		helper.setContextOperation(fruit, fruit_preferredColor);
		
		try {
			OCLExpression expr = helper.createBodyCondition(
				"result = (if true then Color::red else Color::brown endif)"); //$NON-NLS-1$
			
			assertNotNull(expr);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the support for data types as context classifiers, rather than
	 * EClasses.  The parser now supports arbitrary EClassifiers.
	 */
	public void test_dataTypeAsContext() {
		IOCLHelper helper = HelperUtil.createOclHelper();
		helper.setContext(ecore.getEString());
		
		try {
			final String constraint = "self.toUpper() <> self.toLower()"; //$NON-NLS-1$
			
			assertTrue(helper.check("anything", constraint)); //$NON-NLS-1$
			assertTrue(helper.check("ANYTHING", constraint)); //$NON-NLS-1$
			
			assertEquals("ANYTHING", //$NON-NLS-1$
				helper.evaluate("anything", "self.toUpper()")); //$NON-NLS-1$ //$NON-NLS-2$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the support for data types as context classifiers by inference from
	 * the context object.
	 */
	public void test_dataTypeAsContext_inferred() {
		IOCLHelper helper = HelperUtil.createOclHelper();
		helper.setContext("anything"); // inferred type is EString //$NON-NLS-1$
		
		try {
			final String constraint = "self.toUpper() <> self.toLower()"; //$NON-NLS-1$
			
			assertTrue(helper.check("anything", constraint)); //$NON-NLS-1$
			assertTrue(helper.check("ANYTHING", constraint)); //$NON-NLS-1$
			
			assertEquals("ANYTHING", //$NON-NLS-1$
				helper.evaluate("anything", "self.toUpper()")); //$NON-NLS-1$ //$NON-NLS-2$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
}
