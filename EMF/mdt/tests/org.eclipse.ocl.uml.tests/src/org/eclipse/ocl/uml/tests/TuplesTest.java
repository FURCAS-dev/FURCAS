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
 *   Zeligsoft - Bug 238049
 *
 * </copyright>
 *
 * $Id: TuplesTest.java,v 1.7 2009/11/28 18:14:48 ewillink Exp $
 */

package org.eclipse.ocl.uml.tests;

import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.uml.TupleType;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Property;

/**
 * Tests for tuple expressions.
 *
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class TuplesTest
	extends AbstractTestSuite {
	
	/**
	 * Tests the parsing of tuple literals with part types.
	 */
	public void test_tupleLiteral_withTypes() {
		// one part
		parse("package ocltest context Fruit " +
				"inv: Tuple{a : Integer = 1} " +
				"endpackage");
		
		// multiple parts
		parse("package ocltest context Fruit " +
				"inv: Tuple{a : Integer = 1, b : String = 'foo', c : Color = Color::red} " +
				"endpackage");
	}
	
	/**
	 * Tests the parsing of tuple literals without part types.
	 */
	public void test_tupleLiteral_noTypes() {
		// one part
		parse("package ocltest context Fruit " +
				"inv: Tuple{a = 1} " +
				"endpackage");
		
		// multiple parts
		parse("package ocltest context Fruit " +
				"inv: Tuple{a = 1, b = 'foo', c = Color::red} " +
				"endpackage");
	}
	
	/**
	 * Tests the parsing of tuple literals with a mixture of explicit and
	 * implicit part types.
	 */
	public void test_tupleLiteral_mixedTypes() {
		parse("package ocltest context Fruit " +
				"inv: Tuple{a : Integer = 1, b = 'foo', c : Color = Color::red} " +
				"endpackage");
		
		parse("package ocltest context Fruit " +
				"inv: Tuple{a = 1, b : String = 'foo', c = Color::red} " +
				"endpackage");
	}
	
	/**
	 * Tests the parsing of initialization of variables of tuple type.
	 */
	public void test_tupleAssignment() {
		parse("package ocltest context Fruit " +
				"inv: let t : Tuple(a : Integer, b : String, c : Color) " +
					" = Tuple{a = 1, b = 'foo', c = Color::red} " +
					" in t " +
				"endpackage");
	}
	
	/**
	 * Tests the parsing of collections of tuple types.
	 */
	public void test_tupleCollections() {
		parse("package ocltest context Fruit " +
				"inv: let ts : Set(Tuple(a : Integer, b : String, c : Color)) " +
					" = Set{}->including(Tuple{a = 1, b = 'foo', c = Color::red}) " +
					" in ts " +
				"endpackage");
	}
	
	/**
	 * Tests the equivalence of tuples, including irrelevance of ordering of
	 * the parts
	 */
	public void test_tupleEquivalence() {
		// different value in one part
		assertEquals(Boolean.FALSE, evaluate(parse(
				"package ocltest context Fruit " +
				"inv: Tuple{a = 1, b = 'foo', c = Color::red} " +
					" = Tuple{b = 'foo', c = Color::black, a = 1} " +
				"endpackage")));
		
		// test the inequality operator
		assertEquals(Boolean.TRUE, evaluate(parse(
				"package ocltest context Fruit " +
				"inv: Tuple{a = 1, b = 'foo', c = Color::red} " +
					" <> Tuple{b = 'foo', c = Color::black, a = 1} " +
				"endpackage")));
		
		// all parts have same value
		assertEquals(Boolean.TRUE, evaluate(parse(
				"package ocltest context Fruit " +
				"inv: Tuple{a = 1, b = 'foo', c = Color::red} " +
					" = Tuple{b = 'foo', c = Color::red, a = 1} " +
				"endpackage")));
		
		// equality of collections of tuples
		assertEquals(Boolean.TRUE, evaluate(parse(
				"package ocltest context Fruit " +
				"inv: Set{Tuple{a = 1, b = 'foo'}, Tuple{a = 5, b = 'bar'}} " +
					" = Set{Tuple{b = 'bar', a = 5}, Tuple{b = 'foo', a = 1}} " +
				"endpackage")));
	}
    
    /**
     * Tests that the parser distinguishes <code>TupleType</code>s by the names
     * and types of their parts, not by the names alone.
     */
    public void test_tupleTypeDistinction_192832() {
        OCLInput doc = new OCLInput(
            "package ocltest context Fruit " +
            "def: foo : Tuple(a : String) = Tuple{a = 'foo'} " +
            "def: bar : Tuple(a : Integer) = Tuple{a = 100} " +
            "endpackage");
        
        try {
            ocl.parse(doc);
            
            helper.setContext(fruit);
            OCLExpression<Classifier> expr1 = helper.createQuery("self.foo");
            OCLExpression<Classifier> expr2 = helper.createQuery("self.bar");
            
            assertNotSame(expr1.getType(), expr2.getType());
            
            TupleType type = (TupleType) expr1.getType();
            Property a = type.getAttribute("a", null);
            assertNotNull(a);
            assertEquals(getOCLStandardLibrary().getString(), a.getType());
            
            type = (TupleType) expr2.getType();
            a = type.getAttribute("a", null);
            assertNotNull(a);
            assertEquals(getOCLStandardLibrary().getInteger(), a.getType());
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage());
        }
    }
	
	/**
	 * Tests access to tuple parts by name when all parts have the same type.
	 */
	public void test_tuplePartAccess_238049() {
        OCLExpression<Classifier> expr = parse(
            "package ocltest context Fruit " +
            "inv: Tuple{first : String = 'Roger', last : String = 'Bacon'}.first " +
            "endpackage");
    
		assertEquals("Roger", evaluate(expr));
	}
}
