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
 * $Id: InitOrDerExpressionTest.java,v 1.5 2009/10/07 20:39:27 ewillink Exp $
 */

package org.eclipse.ocl.ecore.tests;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import junit.framework.AssertionFailedError;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SetType;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.utilities.UMLReflection;

/**
 * Tests for def expressions (additional properties and operations).
 *
 * @author Christian W. Damus (cdamus)
 */
public class InitOrDerExpressionTest
	extends AbstractTestSuite {
	
	EClass banana;	
	Set<EObject> allApples;
	Map<EClass, Set<EObject>> extents;	
	EObject aFruit;
	EObject anApple;
	EObject anotherApple;
	
	/**
	 * Tests the parsing the init expression for an attribute from raw text.
	 */
	public void test_init_attribute_raw() {
		try {
			OCLExpression<EClassifier> expr = parseDef(
				"package ocltest context Fruit::name : String " + //$NON-NLS-1$
				"init: ''" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
			
			Constraint constraint = (Constraint) expr.eContainer().eContainer();
			assertNotNull(constraint);
			
			assertEquals(UMLReflection.INITIAL, constraint.getStereotype());
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
			OCLExpression<EClassifier> expr = parseDef(
				"package ocltest context Fruit::name : String " + //$NON-NLS-1$
				"derive: if self.oclIsKindOf(Apple) then 'apple' else 'unknown fruit' endif" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
			
			Constraint constraint = (Constraint) expr.eContainer().eContainer();
			assertNotNull(constraint);
			
			assertEquals(UMLReflection.DERIVATION, constraint.getStereotype());
			
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
			OCLExpression<EClassifier> expr = parseDef(
				"package ocltest context Fruit::relatedFruits : Set(Fruit) " + //$NON-NLS-1$
				"init: Set{self}" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
			
			Constraint constraint = (Constraint) expr.eContainer().eContainer();
			assertNotNull(constraint);
			
			assertEquals(UMLReflection.INITIAL, constraint.getStereotype());
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
			OCLExpression<EClassifier> expr = parseDef(
				"package ocltest context Fruit::relatedFruits : Set(Fruit) " + //$NON-NLS-1$
				"derive: if self.oclIsKindOf(Apple) then " + //$NON-NLS-1$
					"Apple.allInstances()->excluding(self.oclAsType(Apple)) " + //$NON-NLS-1$
					"else Fruit.allInstances()->excluding(self) endif" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
			
			Constraint constraint = (Constraint) expr.eContainer().eContainer();
			assertNotNull(constraint);
			
			assertEquals(UMLReflection.DERIVATION, constraint.getStereotype());
			
			assertTrue(expr.getType() instanceof SetType);
			assertSame(fruit, ((SetType) expr.getType()).getElementType());
			
			expr = parse(
					"package ocltest context Fruit " + //$NON-NLS-1$
					"inv: relatedFruits" + //$NON-NLS-1$
					" endpackage"); //$NON-NLS-1$
			
			ocl.setExtentMap(extents);
			
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
		helper.setAttributeContext(fruit, fruit.getEStructuralFeature("name")); //$NON-NLS-1$
		
		try {
			Constraint constraint = helper.createInitialValueExpression("''"); //$NON-NLS-1$
			
			assertNotNull(constraint);
			
			assertEquals(UMLReflection.INITIAL, constraint.getStereotype());
			assertSame(getOCLStandardLibrary().getString(), constraint.getSpecification().getBodyExpression().getType());
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the parsing the derive expression for an attribute using the helper.
	 */
	public void test_derive_attribute_helper() {
		helper.setAttributeContext(fruit, fruit.getEStructuralFeature("name")); //$NON-NLS-1$
		
		try {
			Constraint constraint = helper.createDerivedValueExpression(
				"if self.oclIsKindOf(Apple) then 'apple' else 'unknown fruit' endif"); //$NON-NLS-1$
			
			assertNotNull(constraint);
			
			assertEquals(UMLReflection.DERIVATION, constraint.getStereotype());
			
			assertSame(getOCLStandardLibrary().getString(), constraint.getSpecification().getBodyExpression().getType());
			
			OCLExpression<EClassifier> expr = helper.createQuery("name"); //$NON-NLS-1$
			
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
		helper.setAttributeContext(fruit, fruit.getEStructuralFeature("relatedFruits")); //$NON-NLS-1$
		
		try {
			Constraint constraint = helper.createInitialValueExpression("Set{self}"); //$NON-NLS-1$
			
			assertNotNull(constraint);
			OCLExpression<EClassifier> expr = constraint.getSpecification().getBodyExpression();
			
			assertEquals(UMLReflection.INITIAL, constraint.getStereotype());
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
		helper.setAttributeContext(fruit, fruit.getEStructuralFeature("relatedFruits")); //$NON-NLS-1$
		
		try {
			Constraint constraint = helper.createDerivedValueExpression(
				"if self.oclIsKindOf(Apple) then " + //$NON-NLS-1$
					"Apple.allInstances()->excluding(self.oclAsType(Apple)) " + //$NON-NLS-1$
					"else Fruit.allInstances()->excluding(self) endif"); //$NON-NLS-1$
			
			assertNotNull(constraint);
			OCLExpression<EClassifier> expr = constraint.getSpecification().getBodyExpression();
			
			assertEquals(UMLReflection.DERIVATION, constraint.getStereotype());
			
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
		helper.setAttributeContext(fruit, fruit.getEStructuralFeature("relatedFruits")); //$NON-NLS-1$
		
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
		helper.setAttributeContext(fruit, fruit.getEStructuralFeature("relatedFruits")); //$NON-NLS-1$
		
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
    protected void setUp() {
		super.setUp();
		expectModified = true;
		banana = EcoreFactory.eINSTANCE.createEClass();
		banana.setName("Banana"); //$NON-NLS-1$
		banana.getESuperTypes().add(fruit);
		fruitPackage.getEClassifiers().add(banana);
		
		aFruit = fruitFactory.create(banana);
		
		anApple = fruitFactory.create(apple);
		anotherApple = fruitFactory.create(apple);
		
		allApples = new java.util.HashSet<EObject>();
		allApples.add(anApple);
		allApples.add(anotherApple);
		
		extents = new java.util.HashMap<EClass, Set<EObject>>();
		extents.put(apple, allApples);
		extents.put(banana, Collections.singleton(aFruit));
		
		Set<EObject> allFruits = new java.util.HashSet<EObject>();
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
