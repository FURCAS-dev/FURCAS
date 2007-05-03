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
 * $Id: BasicOCLTest.java,v 1.2 2007/05/03 12:59:25 cdamus Exp $
 */

package org.eclipse.ocl.ecore.tests;

import java.io.IOException;
import java.util.Collections;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.expressions.OCLExpression;

/**
 * Basic tests for OCL engine.
 *
 * @author Chris McGee (cbmcgee)
 * @author Christian W. Damus (cwdamus)
 */
public class BasicOCLTest
	extends AbstractTestSuite {

	public BasicOCLTest(String name) {
		super(name);
	}
	
	public static Test suite() {
		return new TestSuite(BasicOCLTest.class, "Basic Tests"); //$NON-NLS-1$
	}
    
    public void hide_test_createStandardLibrary() {
        Resource res = ocl.getEnvironment().getOCLStandardLibrary().getOclAny().eResource();
        URI oldURI = res.getURI();
        
        res.setURI(URI.createFileURI("c:/temp/oclstdlib.ecore")); //$NON-NLS-1$
        try {
            res.save(Collections.EMPTY_MAP);
        } catch (IOException e) {
            fail(e.getLocalizedMessage());
        } finally {
            // restore the correct URI
            res.setURI(oldURI);
        }
    }
	
	public void testTrivialExpressions() {
		OCLExpression<EClassifier> constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: true " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		Object result = evaluate(constraint);
		assertEquals(Boolean.TRUE, result);
		
		constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: false " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(constraint);
		assertEquals(Boolean.FALSE, result);
	}
	
	public void testLogicalConnectives() {
		OCLExpression<EClassifier> constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: true and true " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		Object result = evaluate(constraint);
		assertEquals(Boolean.TRUE, result);
		
		constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: false or false " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(constraint);
		assertEquals(Boolean.FALSE, result);
		
		constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: true and false " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(constraint);
		assertEquals(Boolean.FALSE, result);
		
		constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: true or false " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(constraint);
		assertEquals(Boolean.TRUE, result);
		
		constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: not true " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(constraint);
		assertEquals(Boolean.FALSE, result);
		
		constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: true implies true " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(constraint);
		assertEquals(Boolean.TRUE, result);
		
		constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: true implies false " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(constraint);
		assertEquals(Boolean.FALSE, result);
		
		constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: false implies true " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(constraint);
		assertEquals(Boolean.TRUE, result);
		
		constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: false implies false " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(constraint);
		assertEquals(Boolean.TRUE, result);
	}
	
	public void testSimpleAttributeExpressions() {
		EClass eCls = EcoreFactory.eINSTANCE.createEClass();
		eCls.setName("bar"); //$NON-NLS-1$
		
		OCLExpression<EClassifier> constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: self.name <> 'foo' " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		assertTrue(check(constraint, eCls));
		
		eCls.setName("foo"); //$NON-NLS-1$
		assertFalse(check(constraint, eCls));
	}
	
	public void testCollectionExpressions() {
		EClass eCls = EcoreFactory.eINSTANCE.createEClass();
		eCls.setName("bar"); //$NON-NLS-1$
		
		EAttribute eAttr = EcoreFactory.eINSTANCE.createEAttribute();
		eAttr.setName("att1"); //$NON-NLS-1$
		eCls.getEStructuralFeatures().add(eAttr);
		eAttr = EcoreFactory.eINSTANCE.createEAttribute();
		eAttr.setName("att2"); //$NON-NLS-1$
		eCls.getEStructuralFeatures().add(eAttr);
		
		assertEquals(eCls.getEAttributes().size(),2);
		
		OCLExpression<EClassifier> constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: self.eAttributes->size() = 2 " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		assertTrue(check(constraint, eCls));
		
		constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: self.eAttributes->forAll(a: EAttribute | not a.derived) " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		assertTrue(check(constraint, eCls));
	}
	
	public void testNonBooleansExpressions() {
		EClass eCls = EcoreFactory.eINSTANCE.createEClass();
		eCls.setName("bar"); //$NON-NLS-1$
		
		OCLExpression<EClassifier> expr = parse(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: self.name " + //$NON-NLS-1$
			"endpackage "); //$NON-NLS-1$
		
		Object result = evaluate(expr, eCls);
		assertEquals("bar", result); //$NON-NLS-1$
		
		expr = parse(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: self " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(expr, eCls);
		assertSame(eCls, result);
	}
	
	public void testIfExpressions() {
		EClass eCls = EcoreFactory.eINSTANCE.createEClass();
		eCls.setName("bar"); //$NON-NLS-1$
		
		OCLExpression<EClassifier> expr = parse(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: if self.abstract then name = 'bar' else name <> 'bar' endif " + //$NON-NLS-1$
			"endpackage "); //$NON-NLS-1$
		
		assertFalse(check(expr, eCls));
		
		eCls.setAbstract(true);
		
		assertTrue(check(expr, eCls));
		
		eCls.setName("foo"); //$NON-NLS-1$
		
		assertFalse(check(expr, eCls));
	}
	
	public void testLetExpressions() {
		EClass eCls = EcoreFactory.eINSTANCE.createEClass();
		eCls.setName("foo"); //$NON-NLS-1$
		
		OCLExpression<EClassifier> expr = parse(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: let feats : OrderedSet(EStructuralFeature) = self.eAllStructuralFeatures in " + //$NON-NLS-1$
			"  feats->isEmpty() implies name <> 'bar' " + //$NON-NLS-1$
			"endpackage "); //$NON-NLS-1$
		
		assertTrue(check(expr, eCls));
		
		eCls.setName("bar"); //$NON-NLS-1$
		
		assertFalse(check(expr, eCls));
		
		eCls.getEStructuralFeatures().add(EcoreFactory.eINSTANCE.createEAttribute());
		
		assertTrue(check(expr, eCls));
		
		eCls.setName("foo"); //$NON-NLS-1$
		
		assertTrue(check(expr, eCls));
	}
	
	/**
	 * Tests the support for data types as context classifiers, rather than
	 * EClasses.  The parser now supports arbitrary EClassifiers.
	 */
	public void test_dataTypeAsContext() {
		OCLExpression<EClassifier> expr = parse(
			"package ecore context EString " + //$NON-NLS-1$
			"inv: self.toUpper() <> self.toLower() " + //$NON-NLS-1$
			"endpackage "); //$NON-NLS-1$
		
		assertTrue(check(expr, "anything")); //$NON-NLS-1$
		assertTrue(check(expr, "ANYTHING")); //$NON-NLS-1$
		
		expr = parse(
			"package ecore context EString " + //$NON-NLS-1$
			"inv: self.toUpper() " + //$NON-NLS-1$
			"endpackage "); //$NON-NLS-1$
		
		assertEquals("ANYTHING", evaluate(expr, "anything")); //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	/**
	 * Tests the overrides for equality of primitive values.  In OCL, reals
	 * can equal integers, but not in Java.
	 */
	public void test_equals_primitives() {
		assertTrue(check("1 = 1")); //$NON-NLS-1$
		assertTrue(check("1 = 1.0")); //$NON-NLS-1$
		assertTrue(check("1.0 = 1")); //$NON-NLS-1$
		assertTrue(check("1.0 = 1.0")); //$NON-NLS-1$
		
		assertTrue(check("'foo' = 'foo'")); //$NON-NLS-1$
		
		assertTrue(check("ocltest::Color::red = ocltest::Color::red")); //$NON-NLS-1$
		assertFalse(check("ocltest::Color::red = ocltest::Color::black")); //$NON-NLS-1$
	}
    
	/**
	 * Tests backslashes in strings and the non-standard escape for
	 * double-quotes in the double-quote syntax that is non-standard, anyway.
	 */
    public void test_backslashes_184948() {
        helper.setContext(EcorePackage.Literals.ESTRING);
        String self = ""; //$NON-NLS-1$
        
        try {
            assertEquals("str\\ning", //$NON-NLS-1$
                evaluate(helper, self, "'str\\ning'")); //$NON-NLS-1$
            
            assertEquals("str\\(ing", //$NON-NLS-1$
                evaluate(helper, self, "'str\\(ing'")); //$NON-NLS-1$
            
            assertEquals("string", //$NON-NLS-1$
                evaluate(helper, self, "let \"s\\\"g\" : String = 'string' in " + //$NON-NLS-1$
                    "\"s\\\"g\"")); //$NON-NLS-1$
        } catch (ParserException e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
    
    /**
     * Test non-standard doubled single-quote syntax for embedding single-quotes
     * in string literals.
     */
    public void test_stringEscapes_184948() {
        helper.setContext(EcorePackage.Literals.ESTRING);
        String self = ""; //$NON-NLS-1$
        
        try {
            assertEquals("str'ing", //$NON-NLS-1$
                evaluate(helper, self, "'str''ing'")); //$NON-NLS-1$
            
            assertEquals("", //$NON-NLS-1$
                evaluate(helper, self, "''")); //$NON-NLS-1$
            
            assertEquals("'", //$NON-NLS-1$
                evaluate(helper, self, "''''")); //$NON-NLS-1$
        } catch (ParserException e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
}
