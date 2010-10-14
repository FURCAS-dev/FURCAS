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
 * $Id: ParsingTest.java,v 1.5 2009/11/28 17:37:01 ewillink Exp $
 */

package org.eclipse.ocl.ecore.helper.tests;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.expressions.OCLExpression;

/**
 * Tests the constraint parsing support.
 *
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class ParsingTest
	extends AbstractTestSuite {
	
	public void test_createQuery_125684() {
		helper.setContext(fruit);
		
		try {
			// constraint-type expressions (boolean-valued) are OK
			OCLExpression<EClassifier> expr = helper.createQuery("color <> Color::black");
			
			assertNotNull(expr);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
		
		try {
			// as are non-booleans
			OCLExpression<EClassifier> expr = helper.createQuery("color");
			
			assertNotNull(expr);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	public void test_createInvariant() {
		helper.setContext(fruit);
		
		try {
			Constraint constraint = helper.createInvariant("color <> Color::black");
			
			assertNotNull(constraint);
			assertNotNull(constraint.getSpecification().getBodyExpression());
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	public void test_createInvariant_nonBoolean_125684() {
		helper.setContext(fruit);
		
		try {
			helper.createInvariant("color");
			
			fail("Parse should not have succeeded");
		} catch (Exception e) {
			// success case
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
	}
	
	public void test_createPrecondition() {
		helper.setOperationContext(fruit, fruit_ripen);
		
		try {
			Constraint constraint = helper.createPrecondition(
				"color <> Color::black");
			
			assertNotNull(constraint);
			assertNotNull(constraint.getSpecification().getBodyExpression());
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	public void test_createPostcondition() {
		helper.setOperationContext(fruit, fruit_ripen);
		
		try {
			Constraint constraint = helper.createPostcondition(
				"color <> self.color@pre implies self.color = color ");
			
			assertNotNull(constraint);
			assertNotNull(constraint.getSpecification().getBodyExpression());
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	public void test_createBodyCondition() {
		helper.setOperationContext(fruit, fruit_preferredColor);
		
		try {
			Constraint constraint = helper.createBodyCondition(
				"result = (if true then Color::red else Color::brown endif)");
			
			assertNotNull(constraint);
			assertNotNull(constraint.getSpecification().getBodyExpression());
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Tests the support for data types as context classifiers, rather than
	 * EClasses.  The parser now supports arbitrary EClassifiers.
	 */
	public void test_dataTypeAsContext() {
		helper.setContext(ecore.getEString());
		
		try {
			final String constraint = "self.toUpper() <> self.toLower()";
			
			assertTrue(check(helper, "anything", constraint));
			assertTrue(check(helper, "ANYTHING", constraint));
			
			assertEquals("ANYTHING",
				evaluate(helper, "anything", "self.toUpper()"));
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Tests the support for data types as context classifiers by inference from
	 * the context object.
	 */
	public void test_dataTypeAsContext_inferred() {
        EcoreEnvironment env =
            (EcoreEnvironment) EcoreEnvironmentFactory.INSTANCE.createInstanceContext(
                ocl.getEnvironment(), "anything"); // inferred type is EString
		
        helper.setContext(env.getContextClassifier());
        
		try {
			final String constraint = "self.toUpper() <> self.toLower()";
			
			assertTrue(check(helper, "anything", constraint));
			assertTrue(check(helper, "ANYTHING", constraint));
			
			assertEquals("ANYTHING",
				evaluate(helper, "anything", "self.toUpper()"));
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
}
