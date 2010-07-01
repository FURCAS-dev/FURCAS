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
 * $Id: EvaluationTest.java,v 1.4 2009/11/28 17:36:04 ewillink Exp $
 */

package org.eclipse.ocl.ecore.helper.tests;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.ocl.expressions.OCLExpression;

/**
 * Tests the constraint evaluation support.
 *
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class EvaluationTest
	extends AbstractTestSuite {
	
	public void test_allInstances() {
		helper.setContext(fruit);
		
		try {
			String expr =
				"Fruit.allInstances()->select(f : Fruit | f.color = Color::black)->isEmpty()";
			
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
			
			assertTrue(evaluate(helper, aFruit, expr));
			
			// change the color of one of the fruits to black
			aFruit.eSet(fruit_color, color_black);
			
			assertFalse(evaluate(helper, aFruit, expr));
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Tests the evaluation/checking of pre-compiled expressions/constraints by
	 * the OCL Helper.
	 */
	public void test_evaluatePrecompiledInvariant_114921() {
		helper.setContext(fruit);
		
		try {
			OCLExpression<EClassifier> constraint = helper.createInvariant(
					"color <> Color::black").getSpecification().getBodyExpression();
			
			assertNotNull(constraint);
			
			EObject instance = fruitFactory.create(apple);
			instance.eSet(fruit_color, color_black);
			
			assertFalse(ocl.check(instance, constraint));
			
			instance.eSet(fruit_color, color_red);
			
			assertTrue(ocl.check(instance, constraint));
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
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
