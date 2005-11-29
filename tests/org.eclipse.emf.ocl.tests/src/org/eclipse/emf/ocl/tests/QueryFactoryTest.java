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

package org.eclipse.emf.ocl.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;


/**
 * Tests <code>QueryFactory</code> <code>createQuery(String expr, EClassifier context)</code>,
 * using different context EClassifiers.
 *
 * @author Christian Vogt
 */
public class QueryFactoryTest
	extends AbstractTestSuite {

	public QueryFactoryTest(String name) {
		super(name);
	}
	
	public static Test suite() {
		return new TestSuite(QueryFactoryTest.class, "Query Factory Tests"); //$NON-NLS-1$
	}

	/**
	 * Tests <code>createQuery</code> with <code>EEnum</code> context.
	 */
	public void test_createQuery_EEnum() {
		EObject anApple = fruitFactory.create(apple);
		anApple.eSet(fruit_color, color_black);
		
		Query q = QueryFactory.eINSTANCE.createQuery("self = Color::green", color);//$NON-NLS-1$
		assertFalse(q.check(anApple.eGet(fruit_color)));

		anApple.eSet(fruit_color, color_green);
		assertTrue(q.check(anApple.eGet(fruit_color)));
	}
	
	/**
	 * Tests <code>createQuery</code> with <code>EClass</code> context.
	 */
	public void test_createQuery_EClass() {
		EObject anApple = fruitFactory.create(apple);
		anApple.eSet(fruit_color, color_black);
		
		Query q = QueryFactory.eINSTANCE.createQuery("self.color = Color::green", apple);//$NON-NLS-1$
		assertFalse(q.check(anApple));

		anApple.eSet(fruit_color, color_green);
		assertTrue(q.check(anApple));
	}
	
	/**
	 * Tests <code>createQuery</code> with <code>EDataType</code> context.
	 */
	public void test_createQuery_EDataType() {
		EObject anApple = fruitFactory.create(apple);
		anApple.eSet(apple_label, "");//$NON-NLS-1$
		
		Query q = QueryFactory.eINSTANCE.createQuery("self = 'Granny Smith'", apple_label.getEType());//$NON-NLS-1$
		assertFalse(q.check(anApple.eGet(apple_label)));

		anApple.eSet(apple_label, "Granny Smith");//$NON-NLS-1$
		assertTrue(q.check(anApple.eGet(apple_label)));
	}
}
