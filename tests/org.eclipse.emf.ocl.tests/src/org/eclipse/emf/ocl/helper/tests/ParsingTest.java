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
	
	public void test_createQuery_125684() {
		IOCLHelper helper = HelperUtil.createOCLHelper();

		helper.setContext(fruit);
		
		try {
			// constraint-type expressions (boolean-valued) are OK
			OCLExpression expr = helper.createQuery("color <> Color::black"); //$NON-NLS-1$
			
			assertNotNull(expr);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		try {
			// as are non-booleans
			OCLExpression expr = helper.createQuery("color"); //$NON-NLS-1$
			
			assertNotNull(expr);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_createInvariant() {
		IOCLHelper helper = HelperUtil.createOCLHelper();

		helper.setContext(fruit);
		
		try {
			OCLExpression expr = helper.createInvariant("color <> Color::black"); //$NON-NLS-1$
			
			assertNotNull(expr);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_createInvariant_nonBoolean_125684() {
		IOCLHelper helper = HelperUtil.createOCLHelper();

		helper.setContext(fruit);
		
		try {
			helper.createInvariant("color"); //$NON-NLS-1$
			
			fail("Parse should not have succeeded"); //$NON-NLS-1$
		} catch (Exception e) {
			// success case
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_createPrecondition() {
		IOCLHelper helper = HelperUtil.createOCLHelper();

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
		IOCLHelper helper = HelperUtil.createOCLHelper();

		helper.setContextOperation(fruit, fruit_ripen);
		
		try {
			OCLExpression expr = helper.createPostcondition(
				"color <> self.color@pre implies self.color = color "); //$NON-NLS-1$
			
			assertNotNull(expr);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Test that the Compatibility API still requires the post-condition-like
	 * form of operation body constraints.
	 */
	public void test_createBodyCondition_185345() {
		IOCLHelper helper = HelperUtil.createOCLHelper();

		helper.setContextOperation(fruit, fruit_preferredColor);
        
        try {
            @SuppressWarnings("unused")
			OCLExpression expr = helper.createBodyCondition(
                "if true then Color::red else Color::brown endif"); //$NON-NLS-1$
            
            fail("Should have failed to parse"); //$NON-NLS-1$
        } catch (Exception e) {
            // success
            System.out.println("Got expected exception: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
		
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
		IOCLHelper helper = HelperUtil.createOCLHelper();
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
		IOCLHelper helper = HelperUtil.createOCLHelper();
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
