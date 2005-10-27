/******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.emf.ocl.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ocl.expressions.OclExpression;
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
	 * Tests the <code>createInvariant</code> method success path.
	 */
	public void test_createInvariant() {
		try {
			OclExpression constraint = ExpressionsUtil.createInvariant(
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
	 * Tests the <code>createPrecondition</code> method success path.
	 */
	public void test_createPrecondition() {
		try {
			OclExpression constraint = ExpressionsUtil.createPrecondition(
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
			OclExpression constraint = ExpressionsUtil.createPostcondition(
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
			OclExpression constraint = ExpressionsUtil.createBodyCondition(
				fruit_preferredColor,
				"if self.color = Color::green then Color::red else Color::brown endif", //$NON-NLS-1$
				true);
			
			assertNotNull(constraint);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
}
