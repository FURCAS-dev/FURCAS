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
 * $Id: InitOrDerExpressionTest.java,v 1.5 2009/11/28 18:10:10 ewillink Exp $
 */

package org.eclipse.ocl.uml.tests;

import java.util.Collections;
import java.util.Set;

import junit.framework.AssertionFailedError;

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
@SuppressWarnings("nls")
public class InitOrDerExpressionTest
	extends AbstractTestSuite {
	
	Class banana;
	Set<EObject> allApples;	
	InstanceSpecification aFruit;
	InstanceSpecification anApple;
	InstanceSpecification anotherApple;
	
	/**
	 * Tests the parsing the init expression for an attribute from raw text.
	 */
	public void test_init_attribute_raw() {
		try {
			OCLExpression<Classifier> expr = parseDef(
				"package ocltest context Fruit::name : String " +
				"init: ''" +
				" endpackage");
			
			Constraint constraint = (Constraint) expr.eContainer().eContainer();
			assertNotNull(constraint);
			
			assertEquals(UMLReflection.INITIAL, getStereotype(constraint));
			assertSame(getOCLStandardLibrary().getString(), expr.getType());
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Tests the parsing the derive expression for an attribute from raw text.
	 */
	public void test_derive_attribute_raw() {
		try {
			OCLExpression<Classifier> expr = parseDef(
				"package ocltest context Fruit::name : String " +
				"derive: if self.oclIsKindOf(Apple) then 'apple' else 'unknown fruit' endif" +
				" endpackage");
			
			Constraint constraint = (Constraint) expr.eContainer().eContainer();
			assertNotNull(constraint);
			
			assertEquals(UMLReflection.DERIVATION, getStereotype(constraint));
			
			assertSame(getOCLStandardLibrary().getString(), expr.getType());
			
			expr = parse(
					"package ocltest context Fruit " +
					"inv: name" +
					" endpackage");
			
			assertEquals("unknown fruit", ocl.evaluate(aFruit, expr));
			
			assertEquals("apple", ocl.evaluate(anApple, expr));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
		}
	}
	
	
	/**
	 * Tests the parsing the init expression for a reference from raw text.
	 */
	public void test_init_reference_raw() {
		try {
			OCLExpression<Classifier> expr = parseDef(
				"package ocltest context Fruit::relatedFruits : Set(Fruit) " +
				"init: Set{self}" +
				" endpackage");
			
			Constraint constraint = (Constraint) expr.eContainer().eContainer();
			assertNotNull(constraint);
			
			assertEquals(UMLReflection.INITIAL, getStereotype(constraint));
			assertTrue(expr.getType() instanceof SetType);
			assertSame(fruit, ((SetType) expr.getType()).getElementType());
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Tests the parsing the derive expression for a reference from raw text.
	 */
	public void test_derive_reference_raw() {
		try {
			OCLExpression<Classifier> expr = parseDef(
				"package ocltest context Fruit::relatedFruits : Set(Fruit) " +
				"derive: if self.oclIsKindOf(Apple) then " +
					"Apple.allInstances()->excluding(self.oclAsType(Apple)) " +
					"else Fruit.allInstances()->excluding(self) endif" +
				" endpackage");
			
			Constraint constraint = (Constraint) expr.eContainer().eContainer();
			assertNotNull(constraint);
			
			assertEquals(UMLReflection.DERIVATION, getStereotype(constraint));
			
			assertTrue(expr.getType() instanceof SetType);
			assertSame(fruit, ((SetType) expr.getType()).getElementType());
			
			expr = parse(
					"package ocltest context Fruit " +
					"inv: relatedFruits" +
					" endpackage");
			
			assertEquals(allApples, ocl.evaluate(aFruit, expr));
			
			assertEquals(Collections.singleton(anotherApple),
					ocl.evaluate(anApple, expr));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
		}
	}
	
	
	/**
	 * Tests the parsing the init expression for an attribute using the helper.
	 */
	public void test_init_attribute_helper() {
		helper.setAttributeContext(fruit, fruit.getOwnedAttribute("name", null));
		
		try {
			Constraint constraint = helper.createInitialValueExpression("''");
			
			assertNotNull(constraint);
			
			assertEquals(UMLReflection.INITIAL, getStereotype(constraint));
			assertSame(getOCLStandardLibrary().getString(), getBodyExpression(constraint).getType());
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Tests the parsing the derive expression for an attribute using the helper.
	 */
	public void test_derive_attribute_helper() {
		helper.setAttributeContext(fruit, fruit.getOwnedAttribute("name", null));
		
		try {
			Constraint constraint = helper.createDerivedValueExpression(
				"if self.oclIsKindOf(Apple) then 'apple' else 'unknown fruit' endif");
			
			assertNotNull(constraint);
			
			assertEquals(UMLReflection.DERIVATION, getStereotype(constraint));
			
			assertSame(getOCLStandardLibrary().getString(), getBodyExpression(constraint).getType());
			
			OCLExpression<Classifier> expr = helper.createQuery("name");
			
			assertEquals("unknown fruit", ocl.evaluate(aFruit, expr));
			
			assertEquals("apple", ocl.evaluate(anApple, expr));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
		}
	}
	
	
	/**
	 * Tests the parsing the init expression for a reference using the helper.
	 */
	public void test_init_reference_helper() {
		helper.setAttributeContext(fruit, fruit.getOwnedAttribute("relatedFruits", null));
		
		try {
			Constraint constraint = helper.createInitialValueExpression("Set{self}");
			
			assertNotNull(constraint);
			OCLExpression<Classifier> expr = getBodyExpression(constraint);
			
			assertEquals(UMLReflection.INITIAL, getStereotype(constraint));
			assertTrue(expr.getType() instanceof SetType);
			assertSame(fruit, ((SetType) expr.getType()).getElementType());
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Tests the parsing the derive expression for a reference using the helper.
	 */
	public void test_derive_reference_helper() {
		helper.setAttributeContext(fruit, fruit.getOwnedAttribute("relatedFruits", null));
		
		try {
			Constraint constraint = helper.createDerivedValueExpression(
				"if self.oclIsKindOf(Apple) then " +
					"Apple.allInstances()->excluding(self.oclAsType(Apple)) " +
					"else Fruit.allInstances()->excluding(self) endif");
			
			assertNotNull(constraint);
			OCLExpression<Classifier> expr = getBodyExpression(constraint);
			
			assertEquals(UMLReflection.DERIVATION, getStereotype(constraint));
			
			assertTrue(expr.getType() instanceof SetType);
			assertSame(fruit, ((SetType) expr.getType()).getElementType());
			
			expr = helper.createQuery("relatedFruits");
			
			assertEquals(allApples, ocl.evaluate(aFruit, expr));
			
			assertEquals(Collections.singleton(anotherApple), ocl.evaluate(anApple, expr));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
		}
	}
	
	public void test_malformedInitExpression() {
		helper.setAttributeContext(fruit, fruit.getOwnedAttribute("relatedFruits", null));
		
		try {
			helper.createInitialValueExpression(
				"if self.oclIsKindOf(Apple) then 'apple' else 'fruit' endif");
			
			fail("Should not have parsed");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
	}
	
	public void test_malformedDeriveExpression() {
		helper.setAttributeContext(fruit, fruit.getOwnedAttribute("relatedFruits", null));
		
		try {
			helper.createDerivedValueExpression(
				"if self.oclIsKindOf(Apple) then 'apple' else 'fruit' endif");
			
			fail("Should not have parsed");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
	}
	
	public void test_bothInitAndDeriveExpressions() {
		try {
			parseDef(
				"package ocltest context Fruit::name : String " +
				"init: 'not a fruit' " +
				"derive: if self.oclIsKindOf(Apple) then 'apple' else 'unknown fruit' endif " +
				" endpackage");
			
			// either order is OK
			parseDef(
				"package ocltest context Fruit::name : String " +
				"derive: if self.oclIsKindOf(Apple) then 'apple' else 'unknown fruit' endif " +
				"init: 'not a fruit' " +
				" endpackage");
		} catch (Exception e) {
			fail("Should not have failed to parse: " + e.getLocalizedMessage());
		}
	}
	
	public void test_tooManyInitAndDeriveExpressions() {
		AssertionFailedError err = null;
		
		try {
			parseDef(
				"package ocltest context Fruit::name : String " +
				"init: 'not a fruit' " +
				"init: 'not a fruit' " +
				" endpackage");
		} catch (AssertionFailedError e) {
			// success
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		
		assertNotNull("Should not have successfully parsed", err);
		err = null;
		
		try {
			parseDef(
				"package ocltest context Fruit::name : String " +
				"derive: if self.oclIsKindOf(Apple) then 'apple' else 'unknown fruit' endif " +
				"derive: if self.oclIsKindOf(Apple) then 'apple' else 'unknown fruit' endif " +
				" endpackage");
		} catch (AssertionFailedError e) {
			// success
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		
		assertNotNull("Should not have successfully parsed", err);
		err = null;
		
		try {
			parseDef(
				"package ocltest context Fruit::name : String " +
				"init: 'not a fruit' " +
				"derive: if self.oclIsKindOf(Apple) then 'apple' else 'unknown fruit' endif " +
				"init: 'not a fruit' " +
				" endpackage");
		} catch (AssertionFailedError e) {
			// success
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		
		assertNotNull("Should not have successfully parsed", err);
		err = null;
		
		try {
			parseDef(
				"package ocltest context Fruit::name : String " +
				"derive: if self.oclIsKindOf(Apple) then 'apple' else 'unknown fruit' endif " +
				"init: 'not a fruit' " +
				"derive: if self.oclIsKindOf(Apple) then 'apple' else 'unknown fruit' endif " +
				" endpackage");
		} catch (AssertionFailedError e) {
			// success
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		
		assertNotNull("Should not have successfully parsed", err);
		err = null;
	}
	
	//
	// Framework methods
	//
	
	@Override
    protected void setUp() {
		super.setUp();
		
		banana = fruitPackage.createOwnedClass("Banana", false);
		banana.createGeneralization(fruit);
		
		aFruit = instantiate(fruitPackage, banana);
		
		anApple = instantiate(fruitPackage, apple);
		anotherApple = instantiate(fruitPackage, apple);
		
		allApples = new java.util.HashSet<EObject>();
		allApples.add(anApple);
		allApples.add(anotherApple);
		expectModified = true;
	}
}
