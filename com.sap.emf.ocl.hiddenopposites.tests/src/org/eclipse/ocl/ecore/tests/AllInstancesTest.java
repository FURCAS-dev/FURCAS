/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2008 IBM Corporation, Zeligsoft Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - bug 238049
 *
 * </copyright>
 *
 * $Id: TuplesTest.java,v 1.7 2009/11/28 17:52:57 ewillink Exp $
 */

package org.eclipse.ocl.ecore.tests;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.expressions.OCLExpression;

/**
 * Tests for allInstances() expressions.
 *
 * @author Axel Uhl
 */
@SuppressWarnings("nls")
public class AllInstancesTest extends AbstractTestSuite {
	
	/**
	 * Tests the parsing of tuple literals with part types.
	 */
	public void testSimpleAllInstances() {
		// one part
		OCLExpression<EClassifier> e = parse("package ocltest context Fruit " +
				"inv: Fruit.allInstances()->size() = 1 endpackage");
		Resource r = resourceSet.getResources().iterator().next();
		EObject apple1 = fruitFactory.create(apple);
		r.getContents().add(fruitFactory.create(apple));
		expectModified = true;
		assertTrue((Boolean) evaluate(e, apple1));
	}
	
	/**
	 * Tests the parsing of tuple literals with part types.
	 */
	public void testAllInstancesWithAddingAnInstanceAfterFirstEvaluation() {
		// one part
		OCLExpression<EClassifier> e = parse("package ocltest context Fruit " +
				"inv: Fruit.allInstances()->size() = 1 endpackage");
		Resource r = resourceSet.getResources().iterator().next();
		EObject apple1 = fruitFactory.create(apple);
		r.getContents().add(apple1);
		expectModified = true;
		assertTrue((Boolean) evaluate(e, apple1));
		EObject apple2 = fruitFactory.create(apple);
		r.getContents().add(apple2);
		// should be 2 now
		assertFalse((Boolean) evaluate(e, apple2));
	}
	
}
