/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2007 IBM Corporation and others.
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
 * $Id: TuplesTest.java,v 1.2 2007/02/14 14:46:16 cdamus Exp $
 */

package org.eclipse.ocl.uml.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Tests for tuple expressions.
 *
 * @author Christian W. Damus (cdamus)
 */
public class TuplesTest
	extends AbstractTestSuite {
	
	public TuplesTest(String name) {
		super(name);
	}
	
	public static Test suite() {
		return new TestSuite(TuplesTest.class, "Tuple Tests"); //$NON-NLS-1$
	}
	
	/**
	 * Tests the parsing of tuple literals with part types.
	 */
	public void test_tupleLiteral_withTypes() {
		// one part
		parse("package ocltest context Fruit " + //$NON-NLS-1$
				"inv: Tuple{a : Integer = 1} " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
		
		// multiple parts
		parse("package ocltest context Fruit " + //$NON-NLS-1$
				"inv: Tuple{a : Integer = 1, b : String = 'foo', c : Color = Color::red} " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
	}
	
	/**
	 * Tests the parsing of tuple literals without part types.
	 */
	public void test_tupleLiteral_noTypes() {
		// one part
		parse("package ocltest context Fruit " + //$NON-NLS-1$
				"inv: Tuple{a = 1} " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
		
		// multiple parts
		parse("package ocltest context Fruit " + //$NON-NLS-1$
				"inv: Tuple{a = 1, b = 'foo', c = Color::red} " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
	}
	
	/**
	 * Tests the parsing of tuple literals with a mixture of explicit and
	 * implicit part types.
	 */
	public void test_tupleLiteral_mixedTypes() {
		parse("package ocltest context Fruit " + //$NON-NLS-1$
				"inv: Tuple{a : Integer = 1, b = 'foo', c : Color = Color::red} " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
		
		parse("package ocltest context Fruit " + //$NON-NLS-1$
				"inv: Tuple{a = 1, b : String = 'foo', c = Color::red} " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
	}
	
	/**
	 * Tests the parsing of initialization of variables of tuple type.
	 */
	public void test_tupleAssignment() {
		parse("package ocltest context Fruit " + //$NON-NLS-1$
				"inv: let t : Tuple(a : Integer, b : String, c : Color) " + //$NON-NLS-1$
					" = Tuple{a = 1, b = 'foo', c = Color::red} " + //$NON-NLS-1$
					" in t " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
	}
	
	/**
	 * Tests the parsing of collections of tuple types.
	 */
	public void test_tupleCollections() {
		parse("package ocltest context Fruit " + //$NON-NLS-1$
				"inv: let ts : Set(Tuple(a : Integer, b : String, c : Color)) " + //$NON-NLS-1$
					" = Set{}->including(Tuple{a = 1, b = 'foo', c = Color::red}) " + //$NON-NLS-1$
					" in ts " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
	}
	
	/**
	 * Tests the equivalence of tuples, including irrelevance of ordering of
	 * the parts
	 */
	public void test_tupleEquivalence() {
		// different value in one part
		assertEquals(Boolean.FALSE, evaluate(parse(
				"package ocltest context Fruit " + //$NON-NLS-1$
				"inv: Tuple{a = 1, b = 'foo', c = Color::red} " + //$NON-NLS-1$
					" = Tuple{b = 'foo', c = Color::black, a = 1} " + //$NON-NLS-1$
				"endpackage"))); //$NON-NLS-1$
		
		// test the inequality operator
		assertEquals(Boolean.TRUE, evaluate(parse(
				"package ocltest context Fruit " + //$NON-NLS-1$
				"inv: Tuple{a = 1, b = 'foo', c = Color::red} " + //$NON-NLS-1$
					" <> Tuple{b = 'foo', c = Color::black, a = 1} " + //$NON-NLS-1$
				"endpackage"))); //$NON-NLS-1$
		
		// all parts have same value
		assertEquals(Boolean.TRUE, evaluate(parse(
				"package ocltest context Fruit " + //$NON-NLS-1$
				"inv: Tuple{a = 1, b = 'foo', c = Color::red} " + //$NON-NLS-1$
					" = Tuple{b = 'foo', c = Color::red, a = 1} " + //$NON-NLS-1$
				"endpackage"))); //$NON-NLS-1$
		
		// equality of collections of tuples
		assertEquals(Boolean.TRUE, evaluate(parse(
				"package ocltest context Fruit " + //$NON-NLS-1$
				"inv: Set{Tuple{a = 1, b = 'foo'}, Tuple{a = 5, b = 'bar'}} " + //$NON-NLS-1$
					" = Set{Tuple{b = 'bar', a = 5}, Tuple{b = 'foo', a = 1}} " + //$NON-NLS-1$
				"endpackage"))); //$NON-NLS-1$
	}
}
