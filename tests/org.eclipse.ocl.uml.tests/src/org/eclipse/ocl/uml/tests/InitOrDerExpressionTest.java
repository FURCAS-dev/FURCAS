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
 * $Id: InitOrDerExpressionTest.java,v 1.1 2007/01/25 18:41:55 cdamus Exp $
 */

package org.eclipse.ocl.uml.tests;

import java.util.Collections;
import java.util.Set;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.uml.SetType;
import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.InstanceSpecification;

/**
 * Tests for def expressions (additional properties and operations).
 *
 * @author Christian W. Damus (cdamus)
 */
public class InitOrDerExpressionTest
	extends AbstractTestSuite {
	
	private Class banana;
	
	private Set<EObject> allApples;
	
	private InstanceSpecification aFruit;
	private InstanceSpecification anApple;
	private InstanceSpecification anotherApple;
	
	public InitOrDerExpressionTest(String name) {
		super(name);
	}
	
	public static Test suite() {
		return new TestSuite(InitOrDerExpressionTest.class, "Initial and Derivation Expression Tests"); //$NON-NLS-1$
	}
	
	/**
	 * Tests the parsing the init expression for an attribute from raw text.
	 */
	public void test_init_attribute_raw() {
		try {
			OCLExpression<Classifier> expr = parseDef(
				"package ocltest context Fruit::name : String " + //$NON-NLS-1$
				"init: ''" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
			
			Constraint constraint = (Constraint) expr.eContainer().eContainer();
			assertNotNull(constraint);
			
			assertEquals(UMLReflection.INITIAL, getStereotype(constraint));
			assertSame(getOCLStandardLibrary().getString(), expr.getType());
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the parsing the derive expression for an attribute from raw text.
	 */
	public void test_derive_attribute_raw() {
		try {
			OCLExpression<Classifier> expr = parseDef(
				"package ocltest context Fruit::name : String " + //$NON-NLS-1$
				"derive: if self.oclIsKindOf(Apple) then 'apple' else 'unknown fruit' endif" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
			
			Constraint constraint = (Constraint) expr.eContainer().eContainer();
			assertNotNull(constraint);
			
			assertEquals(UMLReflection.DERIVATION, getStereotype(constraint));
			
			assertSame(getOCLStandardLibrary().getString(), expr.getType());
			
			expr = parse(
					"package ocltest context Fruit " + //$NON-NLS-1$
					"inv: name" + //$NON-NLS-1$
					" endpackage"); //$NON-NLS-1$
			
			assertEquals("unknown fruit", ocl.evaluate(aFruit, expr)); //$NON-NLS-1$
			
			assertEquals("apple", ocl.evaluate(anApple, expr)); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	
	/**
	 * Tests the parsing the init expression for a reference from raw text.
	 */
	public void test_init_reference_raw() {
		try {
			OCLExpression<Classifier> expr = parseDef(
				"package ocltest context Fruit::relatedFruits : Set(Fruit) " + //$NON-NLS-1$
				"init: Set{self}" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
			
			Constraint constraint = (Constraint) expr.eContainer().eContainer();
			assertNotNull(constraint);
			
			assertEquals(UMLReflection.INITIAL, getStereotype(constraint));
			assertTrue(expr.getType() instanceof SetType);
			assertSame(fruit, ((SetType) expr.getType()).getElementType());
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the parsing the derive expression for a reference from raw text.
	 */
	public void test_derive_reference_raw() {
		try {
			OCLExpression<Classifier> expr = parseDef(
				"package ocltest context Fruit::relatedFruits : Set(Fruit) " + //$NON-NLS-1$
				"derive: if self.oclIsKindOf(Apple) then " + //$NON-NLS-1$
					"Apple.allInstances()->excluding(self.oclAsType(Apple)) " + //$NON-NLS-1$
					"else Fruit.allInstances()->excluding(self) endif" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
			
			Constraint constraint = (Constraint) expr.eContainer().eContainer();
			assertNotNull(constraint);
			
			assertEquals(UMLReflection.DERIVATION, getStereotype(constraint));
			
			assertTrue(expr.getType() instanceof SetType);
			assertSame(fruit, ((SetType) expr.getType()).getElementType());
			
			expr = parse(
					"package ocltest context Fruit " + //$NON-NLS-1$
					"inv: relatedFruits" + //$NON-NLS-1$
					" endpackage"); //$NON-NLS-1$
			
			assertEquals(allApples, ocl.evaluate(aFruit, expr));
			
			assertEquals(Collections.singleton(anotherApple),
					ocl.evaluate(anApple, expr));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	
	/**
	 * Tests the parsing the init expression for an attribute using the helper.
	 */
	public void test_init_attribute_helper() {
		helper.setAttributeContext(fruit, fruit.getOwnedAttribute("name", null)); //$NON-NLS-1$
		
		try {
			Constraint constraint = helper.createInitialValueExpression("''"); //$NON-NLS-1$
			
			assertNotNull(constraint);
			
			assertEquals(UMLReflection.INITIAL, getStereotype(constraint));
			assertSame(getOCLStandardLibrary().getString(), getBodyExpression(constraint).getType());
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the parsing the derive expression for an attribute using the helper.
	 */
	public void test_derive_attribute_helper() {
		helper.setAttributeContext(fruit, fruit.getOwnedAttribute("name", null)); //$NON-NLS-1$
		
		try {
			Constraint constraint = helper.createDerivedValueExpression(
				"if self.oclIsKindOf(Apple) then 'apple' else 'unknown fruit' endif"); //$NON-NLS-1$
			
			assertNotNull(constraint);
			
			assertEquals(UMLReflection.DERIVATION, getStereotype(constraint));
			
			assertSame(getOCLStandardLibrary().getString(), getBodyExpression(constraint).getType());
			
			OCLExpression<Classifier> expr = helper.createQuery("name"); //$NON-NLS-1$
			
			assertEquals("unknown fruit", ocl.evaluate(aFruit, expr)); //$NON-NLS-1$
			
			assertEquals("apple", ocl.evaluate(anApple, expr)); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	
	/**
	 * Tests the parsing the init expression for a reference using the helper.
	 */
	public void test_init_reference_helper() {
		helper.setAttributeContext(fruit, fruit.getOwnedAttribute("relatedFruits", null)); //$NON-NLS-1$
		
		try {
			Constraint constraint = helper.createInitialValueExpression("Set{self}"); //$NON-NLS-1$
			
			assertNotNull(constraint);
			OCLExpression<Classifier> expr = getBodyExpression(constraint);
			
			assertEquals(UMLReflection.INITIAL, getStereotype(constraint));
			assertTrue(expr.getType() instanceof SetType);
			assertSame(fruit, ((SetType) expr.getType()).getElementType());
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the parsing the derive expression for a reference using the helper.
	 */
	public void test_derive_reference_helper() {
		helper.setAttributeContext(fruit, fruit.getOwnedAttribute("relatedFruits", null)); //$NON-NLS-1$
		
		try {
			Constraint constraint = helper.createDerivedValueExpression(
				"if self.oclIsKindOf(Apple) then " + //$NON-NLS-1$
					"Apple.allInstances()->excluding(self.oclAsType(Apple)) " + //$NON-NLS-1$
					"else Fruit.allInstances()->excluding(self) endif"); //$NON-NLS-1$
			
			assertNotNull(constraint);
			OCLExpression<Classifier> expr = getBodyExpression(constraint);
			
			assertEquals(UMLReflection.DERIVATION, getStereotype(constraint));
			
			assertTrue(expr.getType() instanceof SetType);
			assertSame(fruit, ((SetType) expr.getType()).getElementType());
			
			expr = helper.createQuery("relatedFruits"); //$NON-NLS-1$
			
			assertEquals(allApples, ocl.evaluate(aFruit, expr));
			
			assertEquals(Collections.singleton(anotherApple), ocl.evaluate(anApple, expr));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_malformedInitExpression() {
		helper.setAttributeContext(fruit, fruit.getOwnedAttribute("relatedFruits", null)); //$NON-NLS-1$
		
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
		helper.setAttributeContext(fruit, fruit.getOwnedAttribute("relatedFruits", null)); //$NON-NLS-1$
		
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
	
	protected void setUp() throws Exception {
		super.setUp();
		
		banana = fruitPackage.createOwnedClass("Banana", false); //$NON-NLS-1$
		banana.createGeneralization(fruit);
		
		aFruit = instantiate(fruitPackage, banana);
		
		anApple = instantiate(fruitPackage, apple);
		anotherApple = instantiate(fruitPackage, apple);
		
		allApples = new java.util.HashSet<EObject>();
		allApples.add(anApple);
		allApples.add(anotherApple);
	}
	
	protected void tearDown() throws Exception {
		allApples = null;
		
		fruitPackage.getOwnedTypes().remove(banana);
		fruitPackage.getPackagedElements().remove(aFruit);
		fruitPackage.getPackagedElements().remove(anApple);
		fruitPackage.getPackagedElements().remove(anotherApple);
		
		banana = null;
		
		super.tearDown();
	}
}
