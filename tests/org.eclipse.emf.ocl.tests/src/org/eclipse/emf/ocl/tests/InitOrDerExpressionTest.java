/**
 * <copyright>
 *
 * Copyright (c) 2006 IBM Corporation and others.
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
 * $Id: InitOrDerExpressionTest.java,v 1.2 2007/10/11 23:05:08 cdamus Exp $
 */

package org.eclipse.emf.ocl.tests;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.helper.HelperUtil;
import org.eclipse.emf.ocl.helper.IOCLHelper;
import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;
import org.eclipse.emf.ocl.types.SetType;
import org.eclipse.emf.ocl.types.util.Types;
import org.eclipse.emf.ocl.uml.Constraint;

/**
 * Tests for def expressions (additional properties and operations).
 *
 * @author Christian W. Damus (cdamus)
 */
public class InitOrDerExpressionTest
	extends AbstractTestSuite {
	
	private EClass banana;
	
	private Set allApples;
	private Map extents;
	
	private EObject aFruit;
	private EObject anApple;
	private EObject anotherApple;
	
	public InitOrDerExpressionTest(String name) {
		super(name);
	}
	
	public static Test suite() {
		return new TestSuite(InitOrDerExpressionTest.class, "Initial and Derivation Expression Tests"); //$NON-NLS-1$
	}
	
	/**
	 * Tests the parsing the init expression for an attribute from raw text.
	 */
	public void test_defExpression_raw_init_attribute() {
		try {
			OCLExpression expr = parseDef(
				"package ocltest context Fruit::name : String " + //$NON-NLS-1$
				"init: ''" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
			
			Constraint constraint = (Constraint) expr.eContainer();
			assertNotNull(constraint);
			
			assertEquals(Constraint.INITIAL, constraint.getStereotype());
			assertSame(Types.OCL_STRING, expr.getType());
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the parsing the derive expression for an attribute from raw text.
	 */
	public void test_defExpression_raw_derive_attribute() {
		try {
			OCLExpression expr = parseDef(
				"package ocltest context Fruit::name : String " + //$NON-NLS-1$
				"derive: if self.oclIsKindOf(Apple) then 'apple' else 'unknown fruit' endif" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
			
			Constraint constraint = (Constraint) expr.eContainer();
			assertNotNull(constraint);
			
			assertEquals(Constraint.DERIVATION, constraint.getStereotype());
			
			assertSame(Types.OCL_STRING, expr.getType());
			
			expr = parse(
					"package ocltest context Fruit " + //$NON-NLS-1$
					"inv: name" + //$NON-NLS-1$
					" endpackage"); //$NON-NLS-1$
			
			Query query = QueryFactory.eINSTANCE.createQuery(expr);
			
			assertEquals("unknown fruit", query.evaluate(aFruit)); //$NON-NLS-1$
			
			assertEquals("apple", query.evaluate(anApple)); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	
	/**
	 * Tests the parsing the init expression for a reference from raw text.
	 */
	public void test_defExpression_raw_init_reference() {
		try {
			OCLExpression expr = parseDef(
				"package ocltest context Fruit::relatedFruits : Set(Fruit) " + //$NON-NLS-1$
				"init: Set{self}" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
			
			Constraint constraint = (Constraint) expr.eContainer();
			assertNotNull(constraint);
			
			assertEquals(Constraint.INITIAL, constraint.getStereotype());
			assertTrue(expr.getType() instanceof SetType);
			assertSame(fruit, ((SetType) expr.getType()).getElementType());
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the parsing the derive expression for a reference from raw text.
	 */
	public void test_defExpression_raw_derive_reference() {
		try {
			OCLExpression expr = parseDef(
				"package ocltest context Fruit::relatedFruits : Set(Fruit) " + //$NON-NLS-1$
				"derive: if self.oclIsKindOf(Apple) then " + //$NON-NLS-1$
					"Apple.allInstances()->excluding(self.oclAsType(Apple)) " + //$NON-NLS-1$
					"else Fruit.allInstances()->excluding(self) endif" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
			
			Constraint constraint = (Constraint) expr.eContainer();
			assertNotNull(constraint);
			
			assertEquals(Constraint.DERIVATION, constraint.getStereotype());
			
			assertTrue(expr.getType() instanceof SetType);
			assertSame(fruit, ((SetType) expr.getType()).getElementType());
			
			expr = parse(
					"package ocltest context Fruit " + //$NON-NLS-1$
					"inv: relatedFruits" + //$NON-NLS-1$
					" endpackage"); //$NON-NLS-1$
			
			Query query = QueryFactory.eINSTANCE.createQuery(expr);
			query.setExtentMap(extents);
			
			assertEquals(allApples, query.evaluate(aFruit));
			
			assertEquals(Collections.singleton(anotherApple), query.evaluate(anApple));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	
	/**
	 * Tests the parsing the init expression for an attribute using the helper.
	 */
	public void test_defExpression_helper_init_attribute() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContextProperty(fruit, fruit.getEStructuralFeature("name")); //$NON-NLS-1$
		
		try {
			OCLExpression expr = helper.createInitialValueExpression("''"); //$NON-NLS-1$
			
			Constraint constraint = (Constraint) expr.eContainer();
			assertNotNull(constraint);
			
			assertEquals(Constraint.INITIAL, constraint.getStereotype());
			assertSame(Types.OCL_STRING, expr.getType());
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the parsing the derive expression for an attribute using the helper.
	 */
	public void test_defExpression_helper_derive_attribute() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContextProperty(fruit, fruit.getEStructuralFeature("name")); //$NON-NLS-1$
		
		try {
			OCLExpression expr = helper.createDerivedValueExpression(
				"if self.oclIsKindOf(Apple) then 'apple' else 'unknown fruit' endif"); //$NON-NLS-1$
			
			Constraint constraint = (Constraint) expr.eContainer();
			assertNotNull(constraint);
			
			assertEquals(Constraint.DERIVATION, constraint.getStereotype());
			
			assertSame(Types.OCL_STRING, expr.getType());
			
			expr = helper.createQuery("name"); //$NON-NLS-1$
			
			assertEquals("unknown fruit", helper.evaluate(aFruit, expr)); //$NON-NLS-1$
			
			assertEquals("apple", helper.evaluate(anApple, expr)); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	
	/**
	 * Tests the parsing the init expression for a reference using the helper.
	 */
	public void test_defExpression_helper_init_reference() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContextProperty(fruit, fruit.getEStructuralFeature("relatedFruits")); //$NON-NLS-1$
		
		try {
			OCLExpression expr = helper.createInitialValueExpression("Set{self}"); //$NON-NLS-1$
			
			Constraint constraint = (Constraint) expr.eContainer();
			assertNotNull(constraint);
			
			assertEquals(Constraint.INITIAL, constraint.getStereotype());
			assertTrue(expr.getType() instanceof SetType);
			assertSame(fruit, ((SetType) expr.getType()).getElementType());
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the parsing the derive expression for a reference using the helper.
	 */
	public void test_defExpression_helper_derive_reference() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContextProperty(fruit, fruit.getEStructuralFeature("relatedFruits")); //$NON-NLS-1$
		
		try {
			OCLExpression expr = helper.createDerivedValueExpression(
				"if self.oclIsKindOf(Apple) then " + //$NON-NLS-1$
					"Apple.allInstances()->excluding(self.oclAsType(Apple)) " + //$NON-NLS-1$
					"else Fruit.allInstances()->excluding(self) endif"); //$NON-NLS-1$
			
			Constraint constraint = (Constraint) expr.eContainer();
			assertNotNull(constraint);
			
			assertEquals(Constraint.DERIVATION, constraint.getStereotype());
			
			assertTrue(expr.getType() instanceof SetType);
			assertSame(fruit, ((SetType) expr.getType()).getElementType());
			
			expr = helper.createQuery("relatedFruits"); //$NON-NLS-1$
			
			assertEquals(allApples, helper.evaluate(aFruit, expr));
			
			assertEquals(Collections.singleton(anotherApple), helper.evaluate(anApple, expr));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_malformedInitExpression() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContextProperty(fruit, fruit.getEStructuralFeature("relatedFruits")); //$NON-NLS-1$
		
		try {
			helper.createInitialValueExpression(
				"if self.oclIsKindOf(Apple) then 'apple' else 'fruit' endif"); //$NON-NLS-1$
			
			fail("Should not have parsed"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_malformedDeriveExpression() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContextProperty(fruit, fruit.getEStructuralFeature("relatedFruits")); //$NON-NLS-1$
		
		try {
			helper.createDerivedValueExpression(
				"if self.oclIsKindOf(Apple) then 'apple' else 'fruit' endif"); //$NON-NLS-1$
			
			fail("Should not have parsed"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_bothInitAndDeriveExpressions() {
		try {
			parseDef(
				"package ocltest context Fruit::name : String " + //$NON-NLS-1$
				"init: 'not a fruit' " + //$NON-NLS-1$
				"derive: if self.oclIsKindOf(Apple) then 'apple' else 'unknown fruit' endif " + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
			
			// either order is OK
			parseDef(
				"package ocltest context Fruit::name : String " + //$NON-NLS-1$
				"derive: if self.oclIsKindOf(Apple) then 'apple' else 'unknown fruit' endif " + //$NON-NLS-1$
				"init: 'not a fruit' " + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Should not have failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_tooManyInitAndDeriveExpressions() {
		AssertionFailedError err = null;
		
		try {
			parseDef(
				"package ocltest context Fruit::name : String " + //$NON-NLS-1$
				"init: 'not a fruit' " + //$NON-NLS-1$
				"init: 'not a fruit' " + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
		} catch (AssertionFailedError e) {
			// success
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		assertNotNull("Should not have successfully parsed", err); //$NON-NLS-1$
		err = null;
		
		try {
			parseDef(
				"package ocltest context Fruit::name : String " + //$NON-NLS-1$
				"derive: if self.oclIsKindOf(Apple) then 'apple' else 'unknown fruit' endif " + //$NON-NLS-1$
				"derive: if self.oclIsKindOf(Apple) then 'apple' else 'unknown fruit' endif " + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
		} catch (AssertionFailedError e) {
			// success
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		assertNotNull("Should not have successfully parsed", err); //$NON-NLS-1$
		err = null;
		
		try {
			parseDef(
				"package ocltest context Fruit::name : String " + //$NON-NLS-1$
				"init: 'not a fruit' " + //$NON-NLS-1$
				"derive: if self.oclIsKindOf(Apple) then 'apple' else 'unknown fruit' endif " + //$NON-NLS-1$
				"init: 'not a fruit' " + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
		} catch (AssertionFailedError e) {
			// success
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		assertNotNull("Should not have successfully parsed", err); //$NON-NLS-1$
		err = null;
		
		try {
			parseDef(
				"package ocltest context Fruit::name : String " + //$NON-NLS-1$
				"derive: if self.oclIsKindOf(Apple) then 'apple' else 'unknown fruit' endif " + //$NON-NLS-1$
				"init: 'not a fruit' " + //$NON-NLS-1$
				"derive: if self.oclIsKindOf(Apple) then 'apple' else 'unknown fruit' endif " + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
		} catch (AssertionFailedError e) {
			// success
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		assertNotNull("Should not have successfully parsed", err); //$NON-NLS-1$
		err = null;
	}
	
	//
	// Framework methods
	//
	
	@Override
    protected void setUp() throws Exception {
		super.setUp();
		
		banana = EcoreFactory.eINSTANCE.createEClass();
		banana.setName("Banana"); //$NON-NLS-1$
		banana.getESuperTypes().add(fruit);
		fruitPackage.getEClassifiers().add(banana);
		
		aFruit = fruitFactory.create(banana);
		
		anApple = fruitFactory.create(apple);
		anotherApple = fruitFactory.create(apple);
		
		allApples = new java.util.HashSet();
		allApples.add(anApple);
		allApples.add(anotherApple);
		
		extents = new java.util.HashMap();
		extents.put(apple, allApples);
		extents.put(banana, Collections.singleton(aFruit));
		
		Set allFruits = new java.util.HashSet();
		allFruits.addAll(allApples);
		allFruits.add(aFruit);
		extents.put(fruit, allFruits);
		
		// for evaluation in the helper, to find all instances of an EClass
		Resource res = new ResourceImpl();
		res.getContents().addAll(allFruits);
	}
	
	@Override
    protected void tearDown() throws Exception {
		extents = null;
		allApples = null;
		
		fruitPackage.getEClassifiers().remove(banana);
		banana = null;
		
		super.tearDown();
	}
}
