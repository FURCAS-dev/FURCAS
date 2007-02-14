/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2006 IBM Corporation and others.
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

package org.eclipse.emf.ocl.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.util.ExpressionsUtil;
import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;

/**
 * Tests the {@link ExpressionsUtil} class.
 *
 * @author Christian W. Damus (cdamus)
 */
public class ExpressionsUtilTest
	extends AbstractTestSuite {

	public ExpressionsUtilTest(String name) {
		super(name);
	}
	
	public static Test suite() {
		return new TestSuite(ExpressionsUtilTest.class, "Expressions Utilities Tests"); //$NON-NLS-1$
	}
	
	/**
	 * Tests the <code>createQuery</code> method success path.
	 */
	public void test_createQuery_125684() {
		try {
			//  try a constraint-type expression (boolean-valued)
			OCLExpression query = ExpressionsUtil.createQuery(
				apple, "self.color <> Color::black", true); //$NON-NLS-1$
			
			assertNotNull(query);
			
			EObject anApple = fruitFactory.create(apple);
			anApple.eSet(fruit_color, color_black);
			
			Query q = QueryFactory.eINSTANCE.createQuery(query);
			assertFalse(q.check(anApple));
			
			anApple.eSet(fruit_color, color_green);
			assertTrue(q.check(anApple));
			
			// next, try a non-boolean expression
			query = ExpressionsUtil.createQuery(
				apple, "self.color", true); //$NON-NLS-1$
			
			assertNotNull(query);
			
			q = QueryFactory.eINSTANCE.createQuery(query);
			assertSame(color_green, q.evaluate(anApple));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the <code>createInvariant</code> method success path.
	 */
	public void test_createInvariant() {
		try {
			OCLExpression constraint = ExpressionsUtil.createInvariant(
				apple, "self.color <> Color::black", true); //$NON-NLS-1$
			
			assertNotNull(constraint);
			
			EObject anApple = fruitFactory.create(apple);
			anApple.eSet(fruit_color, color_black);
			
			Query q = QueryFactory.eINSTANCE.createQuery(constraint);
			assertFalse(q.check(anApple));
			
			anApple.eSet(fruit_color, color_green);
			assertTrue(q.check(anApple));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests that the <code>createInvariant</code> method asserts boolean type.
	 */
	public void test_createInvariant_nonBoolean_125684() {
		try {
			ExpressionsUtil.createInvariant(
					apple, "self.color", true); //$NON-NLS-1$
			
			fail("Validation should have failed"); //$NON-NLS-1$
		} catch (Exception e) {
			// success case
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the <code>createPrecondition</code> method success path.
	 */
	public void test_createPrecondition() {
		try {
			OCLExpression constraint = ExpressionsUtil.createPrecondition(
				fruit_ripen, "color <> self.color", true); //$NON-NLS-1$
			
			assertNotNull(constraint);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the <code>createPostcondition</code> method success path.
	 */
	public void test_createPostcondition() {
		try {
			OCLExpression constraint = ExpressionsUtil.createPostcondition(
				fruit_ripen, "self.color <> self.color@pre", true); //$NON-NLS-1$
			
			assertNotNull(constraint);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the <code>createBodyCondition</code> method success path.
	 */
	public void test_createBodyCondition() {
		try {
			OCLExpression constraint = ExpressionsUtil.createBodyCondition(
				fruit_preferredColor,
				"result = (if self.color = Color::green then Color::red else Color::brown endif)", //$NON-NLS-1$
				true);
			
			assertNotNull(constraint);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
}
