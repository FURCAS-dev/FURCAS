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
 * $Id: ParsingTest.java,v 1.2 2007/02/14 14:45:48 cdamus Exp $
 */

package org.eclipse.ocl.ecore.helper.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.expressions.OCLExpression;

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
		helper.setContext(fruit);
		
		try {
			// constraint-type expressions (boolean-valued) are OK
			OCLExpression<EClassifier> expr = helper.createQuery("color <> Color::black"); //$NON-NLS-1$
			
			assertNotNull(expr);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		try {
			// as are non-booleans
			OCLExpression<EClassifier> expr = helper.createQuery("color"); //$NON-NLS-1$
			
			assertNotNull(expr);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_createInvariant() {
		helper.setContext(fruit);
		
		try {
			Constraint constraint = helper.createInvariant("color <> Color::black"); //$NON-NLS-1$
			
			assertNotNull(constraint);
			assertNotNull(constraint.getSpecification().getBodyExpression());
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_createInvariant_nonBoolean_125684() {
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
		helper.setOperationContext(fruit, fruit_ripen);
		
		try {
			Constraint constraint = helper.createPrecondition(
				"color <> Color::black"); //$NON-NLS-1$
			
			assertNotNull(constraint);
			assertNotNull(constraint.getSpecification().getBodyExpression());
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_createPostcondition() {
		helper.setOperationContext(fruit, fruit_ripen);
		
		try {
			Constraint constraint = helper.createPostcondition(
				"color <> self.color@pre implies self.color = color "); //$NON-NLS-1$
			
			assertNotNull(constraint);
			assertNotNull(constraint.getSpecification().getBodyExpression());
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_createBodyCondition() {
		helper.setOperationContext(fruit, fruit_preferredColor);
		
		try {
			Constraint constraint = helper.createBodyCondition(
				"result = (if true then Color::red else Color::brown endif)"); //$NON-NLS-1$
			
			assertNotNull(constraint);
			assertNotNull(constraint.getSpecification().getBodyExpression());
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the support for data types as context classifiers, rather than
	 * EClasses.  The parser now supports arbitrary EClassifiers.
	 */
	public void test_dataTypeAsContext() {
		helper.setContext(ecore.getEString());
		
		try {
			final String constraint = "self.toUpper() <> self.toLower()"; //$NON-NLS-1$
			
			assertTrue(check(helper, "anything", constraint)); //$NON-NLS-1$
			assertTrue(check(helper, "ANYTHING", constraint)); //$NON-NLS-1$
			
			assertEquals("ANYTHING", //$NON-NLS-1$
				evaluate(helper, "anything", "self.toUpper()")); //$NON-NLS-1$ //$NON-NLS-2$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the support for data types as context classifiers by inference from
	 * the context object.
	 */
	public void test_dataTypeAsContext_inferred() {
        EcoreEnvironment env =
            (EcoreEnvironment) EcoreEnvironmentFactory.INSTANCE.createInstanceContext(
                ocl.getEnvironment(), "anything"); // inferred type is EString //$NON-NLS-1$
		
        helper.setContext(env.getContextClassifier());
        
		try {
			final String constraint = "self.toUpper() <> self.toLower()"; //$NON-NLS-1$
			
			assertTrue(check(helper, "anything", constraint)); //$NON-NLS-1$
			assertTrue(check(helper, "ANYTHING", constraint)); //$NON-NLS-1$
			
			assertEquals("ANYTHING", //$NON-NLS-1$
				evaluate(helper, "anything", "self.toUpper()")); //$NON-NLS-1$ //$NON-NLS-2$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
}
