/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
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
 * $Id: ParsingTest.java,v 1.3 2009/10/07 20:42:31 ewillink Exp $
 */

package org.eclipse.ocl.uml.helper.tests;

import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.uml.UMLEnvironment;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;

/**
 * Tests the constraint parsing support.
 *
 * @author Christian W. Damus (cdamus)
 */
public class ParsingTest
	extends AbstractTestSuite {
	
	public void test_createQuery_125684() {
		helper.setContext(fruit);
		
		try {
			// constraint-type expressions (boolean-valued) are OK
			OCLExpression<Classifier> expr = helper.createQuery(
					"color <> Color::black"); //$NON-NLS-1$
			
			assertNotNull(expr);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		try {
			// as are non-booleans
			OCLExpression<Classifier> expr = helper.createQuery("color"); //$NON-NLS-1$
			
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
			assertNotNull(getBodyExpression(constraint));
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
			assertNotNull(getBodyExpression(constraint));
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
			assertNotNull(getBodyExpression(constraint));
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
			assertNotNull(getBodyExpression(constraint));
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the support for data types as context classifiers, rather than
	 * EClasses.  The parser now supports arbitrary EClassifiers.
	 */
	public void test_dataTypeAsContext() {
		helper.setContext(getUMLString());
		
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
        UMLEnvironment env =
            (UMLEnvironment) ocl.getEnvironment().getFactory().createInstanceContext(
                ocl.getEnvironment(), "anything"); // inferred type is String //$NON-NLS-1$
        
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
