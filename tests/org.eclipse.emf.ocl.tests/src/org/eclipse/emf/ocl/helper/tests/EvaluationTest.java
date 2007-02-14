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

package org.eclipse.emf.ocl.helper.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.helper.HelperUtil;
import org.eclipse.emf.ocl.helper.IOCLHelper;

/**
 * Tests the constraint evaluation support.
 *
 * @author Christian W. Damus (cdamus)
 */
public class EvaluationTest
	extends AbstractTestSuite {

	/**
	 * Initializes me with my name.
	 */
	public EvaluationTest(String name) {
		super(name);
	}
	
	public static Test suite() {
		return new TestSuite(EvaluationTest.class, "Constraint Evaluation Tests"); //$NON-NLS-1$
	}
	
	public void test_allInstances() {
		IOCLHelper helper = HelperUtil.createOCLHelper();

		helper.setContext(fruit);
		
		try {
			String expr =
				"Fruit.allInstances()->select(f : Fruit | f.color = Color::black)->isEmpty()"; //$NON-NLS-1$
			
			Resource res = new ResourceImpl();
			
			// add some fruits to the resource.  Note that these fruits are
			//   not direct instances of the Fruit class that we are constraining
			EObject aFruit = fruitFactory.create(apple);
			aFruit.eSet(fruit_color, color_red);
			res.getContents().add(aFruit);
			
			aFruit = fruitFactory.create(apple);
			aFruit.eSet(fruit_color, color_yellow);
			res.getContents().add(aFruit);
			
			aFruit = fruitFactory.create(apple);
			aFruit.eSet(fruit_color, color_orange);
			res.getContents().add(aFruit);
			
			aFruit = fruitFactory.create(apple);
			aFruit.eSet(fruit_color, color_pink);
			res.getContents().add(aFruit);
			
			aFruit = fruitFactory.create(apple);
			aFruit.eSet(fruit_color, color_green);
			res.getContents().add(aFruit);
			
			assertTrue(helper.evaluate(aFruit, expr));
			
			// change the color of one of the fruits to black
			aFruit.eSet(fruit_color, color_black);
			
			assertFalse(helper.evaluate(aFruit, expr));
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the evaluation/checking of pre-compiled expressions/constraints by
	 * the OCL Helper.
	 */
	public void test_evaluatePrecompiledInvariant_114921() {
		IOCLHelper helper = HelperUtil.createOCLHelper();

		helper.setContext(fruit);
		
		try {
			OCLExpression constraint = helper.createInvariant(
					"color <> Color::black"); //$NON-NLS-1$
			
			assertNotNull(constraint);
			
			EObject instance = fruitFactory.create(apple);
			instance.eSet(fruit_color, color_black);
			
			assertFalse(helper.check(instance, constraint));
			
			instance.eSet(fruit_color, color_red);
			
			assertTrue(helper.check(instance, constraint));
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	//
	// Fixture methods
	//
	
	/**
	 * Asserts that the specified <code>object</code> is a {@link Boolean}
	 * that is <code>true</code>.
	 * 
	 * @param object an object
	 */
	void assertTrue(Object object) {
		assertNotNull(object);
		assertSame(Boolean.class, object.getClass());
		assertTrue(((Boolean) object).booleanValue());
	}
	
	/**
	 * Asserts that the specified <code>object</code> is a {@link Boolean}
	 * that is <code>false</code>.
	 * 
	 * @param object an object
	 */
	void assertFalse(Object object) {
		assertNotNull(object);
		assertSame(Boolean.class, object.getClass());
		assertFalse(((Boolean) object).booleanValue());
	}
}
