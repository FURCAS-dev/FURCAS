/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2008 IBM Corporation and others.
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
 * $Id: TuplesTest.java,v 1.4 2008/03/26 21:17:48 cdamus Exp $
 */

package org.eclipse.ocl.ecore.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ecore.TupleType;
import org.eclipse.ocl.expressions.OCLExpression;

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
	
	/**
	 * Tests that the parser distinguishes <code>TupleType</code>s by the names
	 * and types of their parts, not by the names alone.
	 */
	public void test_tupleTypeDistinction_192832() {
	    OCLInput doc = new OCLInput(
	        "package ocltest context Fruit " + //$NON-NLS-1$
            "def: foo : Tuple(a : String) = Tuple{a = 'foo'} " + //$NON-NLS-1$
            "def: bar : Tuple(a : Integer) = Tuple{a = 100} " + //$NON-NLS-1$
            "endpackage"); //$NON-NLS-1$
	    
	    try {
    	    ocl.parse(doc);
    	    
    	    helper.setContext(fruit);
    	    OCLExpression<EClassifier> expr1 = helper.createQuery("self.foo"); //$NON-NLS-1$
    	    OCLExpression<EClassifier> expr2 = helper.createQuery("self.bar"); //$NON-NLS-1$
            
    	    assertNotSame(expr1.getType(), expr2.getType());
    	    
    	    TupleType type = (TupleType) expr1.getType();
    	    EStructuralFeature a = type.getEStructuralFeature("a"); //$NON-NLS-1$
    	    assertNotNull(a);
    	    assertEquals(getOCLStandardLibrary().getString(), a.getEType());
            
            type = (TupleType) expr2.getType();
            a = type.getEStructuralFeature("a"); //$NON-NLS-1$
            assertNotNull(a);
            assertEquals(getOCLStandardLibrary().getInteger(), a.getEType());
	    } catch (Exception e) {
	        fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
	    }
	}

	/**
	 * Tests that TupleTypes are Ecore EDataTypes as well as EClasses.
	 */
	public void test_tupleTypesAreEDataTypes_222287() {
        OCLExpression<EClassifier> expr = parse(
                "package ocltest context Fruit " + //$NON-NLS-1$
                "inv: Tuple{a = 1, b = 'foo', c = Color::red} " + //$NON-NLS-1$
                "endpackage"); //$NON-NLS-1$
        
        assertTrue(EcorePackage.Literals.ECLASS.isSuperTypeOf(
                expr.getType().eClass()));
        assertTrue(expr.getType() instanceof EClass);
        assertTrue(EcorePackage.Literals.EDATA_TYPE.isSuperTypeOf(
                expr.getType().eClass()));
        assertTrue(expr.getType() instanceof EDataType);
	}
}
