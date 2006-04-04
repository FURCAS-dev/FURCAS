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
 * $Id: DefExpressionTest.java,v 1.1 2006/04/04 18:08:40 cdamus Exp $
 */

package org.eclipse.emf.ocl.tests;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.helper.ChoiceType;
import org.eclipse.emf.ocl.helper.ConstraintType;
import org.eclipse.emf.ocl.helper.HelperUtil;
import org.eclipse.emf.ocl.helper.IOCLHelper;
import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;
import org.eclipse.emf.ocl.types.SetType;
import org.eclipse.emf.ocl.types.impl.TypeUtil;
import org.eclipse.emf.ocl.types.util.Types;
import org.eclipse.emf.ocl.uml.Constraint;

/**
 * Tests for def expressions (additional properties and operations).
 *
 * @author Christian W. Damus (cdamus)
 */
public class DefExpressionTest
	extends AbstractTestSuite {
	
	public DefExpressionTest(String name) {
		super(name);
	}
	
	public static Test suite() {
		return new TestSuite(DefExpressionTest.class, "Def Expression Tests"); //$NON-NLS-1$
	}
	
	/**
	 * Tests the parsing the def expression for an operation from raw text.
	 */
	public void test_defExpression_raw_operation() {
		try {
			OCLExpression expr = parseDef(
				"package ocltest context Fruit " + //$NON-NLS-1$
				"def: bestColor(c : Color) : Color = if self.color = Color::black then c else self.color endif" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
			
			Constraint constraint = (Constraint) expr.eContainer();
			assertNotNull(constraint);
			
			assertEquals(Constraint.DEFINITION, constraint.getStereotype());
			
			assertSame(color, expr.getType());
			
			expr = parse(
					"package ocltest context Fruit " + //$NON-NLS-1$
					"inv: bestColor(Color::red) = Color::red" + //$NON-NLS-1$
					" endpackage"); //$NON-NLS-1$
			
			Query query = QueryFactory.eINSTANCE.createQuery(expr);
			
			EObject anApple = fruitFactory.create(apple);
			anApple.eSet(fruit_color, color_black);
			
			assertTrue(query.check(anApple));
			
			anApple.eSet(fruit_color, color_green);
			
			assertFalse(query.check(anApple));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the parsing the def expression for an operation using the helper.
	 */
	public void test_defExpression_helper_operation() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(fruit);
		
		try {
			helper.define(
					"bestColor(c : Color) : Color = " + //$NON-NLS-1$
					"if self.color = Color::black then c else self.color endif"); //$NON-NLS-1$
			
			OCLExpression expr = helper.createInvariant("bestColor(Color::red) = Color::red"); //$NON-NLS-1$
			
			EObject anApple = fruitFactory.create(apple);
			anApple.eSet(fruit_color, color_black);
			
			assertTrue(helper.check(anApple, expr));
			
			anApple.eSet(fruit_color, color_green);
			
			assertFalse(helper.check(anApple, expr));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the parsing the def expression for an attribute from raw text.
	 */
	public void test_defExpression_raw_attribute() {
		try {
			OCLExpression expr = parseDef(
				"package ocltest context Apple " + //$NON-NLS-1$
				"def: fallen : Boolean = stem.oclIsUndefined()" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
			
			Constraint constraint = (Constraint) expr.eContainer();
			assertNotNull(constraint);
			
			assertEquals(Constraint.DEFINITION, constraint.getStereotype());
			
			assertSame(Types.OCL_BOOLEAN, expr.getType());
			
			expr = parse(
					"package ocltest context Apple " + //$NON-NLS-1$
					"inv: not fallen" + //$NON-NLS-1$
					" endpackage"); //$NON-NLS-1$
			
			Query query = QueryFactory.eINSTANCE.createQuery(expr);
			
			EObject anApple = fruitFactory.create(apple);
			anApple.eSet(apple_stem, fruitFactory.create(stem));
			
			assertTrue(query.check(anApple));
			
			anApple.eSet(apple_stem, null);
			
			assertFalse(query.check(anApple));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the parsing the def expression for an attribute using the helper.
	 */
	public void test_defExpression_helper_attribute() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(apple);
		
		try {
			helper.define(
					"fallen : Boolean = " + //$NON-NLS-1$
					"stem.oclIsUndefined()"); //$NON-NLS-1$
			
			OCLExpression expr = helper.createInvariant("not fallen"); //$NON-NLS-1$
			
			EObject anApple = fruitFactory.create(apple);
			anApple.eSet(apple_stem, fruitFactory.create(stem));
			
			assertTrue(helper.check(anApple, expr));
			
			anApple.eSet(apple_stem, null);
			
			assertFalse(helper.check(anApple, expr));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the parsing the def expression for a reference from raw text.
	 */
	public void test_defExpression_raw_reference() {
		try {
			OCLExpression expr = parseDef(
				"package ocltest context Apple " + //$NON-NLS-1$
				"def: otherApples : Set(Apple) = Apple.allInstances()->excluding(self)" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
			
			Constraint constraint = (Constraint) expr.eContainer();
			assertNotNull(constraint);
			
			assertEquals(Constraint.DEFINITION, constraint.getStereotype());
			
			assertTrue(expr.getType() instanceof SetType);
			assertSame(((SetType) expr.getType()).getElementType(), apple);
			
			expr = parse(
					"package ocltest context Apple " + //$NON-NLS-1$
					"inv: self.otherApples" + //$NON-NLS-1$
					" endpackage"); //$NON-NLS-1$
			
			Query query = QueryFactory.eINSTANCE.createQuery(expr);
			
			EObject anApple = fruitFactory.create(apple);
			EObject anotherApple = fruitFactory.create(apple);
			Map extentMap = new java.util.HashMap();
			Set allApples = new java.util.HashSet();
			allApples.add(anApple);
			allApples.add(anotherApple);
			extentMap.put(apple, allApples);
			query.setExtentMap(extentMap);
			
			Object otherApples = query.evaluate(anApple);
			
			assertEquals(Collections.singleton(anotherApple), otherApples);
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_defExpression_inheritance_operation() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.ECLASSIFIER);
		
		try {
			helper.define(
					"allParents() : Set(EClassifier) = " + //$NON-NLS-1$
					"if self.oclIsKindOf(EClass) then self.oclAsType(EClass)->closure(eSuperTypes) else Set{} endif"); //$NON-NLS-1$
			
			OCLExpression expr = helper.createQuery("self.allParents()"); //$NON-NLS-1$
			
			Object allParents = helper.evaluate(apple, expr);
			assertTrue(allParents instanceof Set);
			assertTrue(((Set) allParents).contains(fruit));
			
			allParents = helper.evaluate(color, expr);
			assertTrue(allParents instanceof Set);
			assertTrue(((Set) allParents).isEmpty());
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_defExpression_inheritance_attribute() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.ECLASSIFIER);
		
		try {
			helper.define(
					"allParents : Set(EClassifier) = " + //$NON-NLS-1$
					"if self.oclIsKindOf(EClass) then self.oclAsType(EClass)->closure(eSuperTypes) else Set{} endif"); //$NON-NLS-1$
			
			OCLExpression expr = helper.createQuery("self.allParents"); //$NON-NLS-1$
			
			Object allParents = helper.evaluate(apple, expr);
			assertTrue(allParents instanceof Set);
			assertTrue(((Set) allParents).contains(fruit));
			
			allParents = helper.evaluate(color, expr);
			assertTrue(allParents instanceof Set);
			assertTrue(((Set) allParents).isEmpty());
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_malformedDefExpression_attribute() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.ECLASSIFIER);
		
		try {
			// non-conformant expression type
			helper.define(
				"allParents : Set(EClassifier) = " + //$NON-NLS-1$
				"if self.oclIsKindOf(EClass) then self.name else '' endif"); //$NON-NLS-1$
			
			fail("Should not have parsed"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		try {
			// missing type declaration
			helper.define(
				"myName = " + //$NON-NLS-1$
				"if self.oclIsKindOf(EClass) then self.name else '' endif"); //$NON-NLS-1$
			
			fail("Should not have parsed"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_malformedDefExpression_operation() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.ECLASSIFIER);
		
		try {
			// non-conformant expression type
			helper.define(
				"allParents() : Set(EClassifier) = " + //$NON-NLS-1$
				"if self.oclIsKindOf(EClass) then self.name else '' endif"); //$NON-NLS-1$
			
			fail("Should not have parsed"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		try {
			// missing type declaration
			helper.define(
				"bestName(s : String) = " + //$NON-NLS-1$
				"if self.oclIsKindOf(EClass) then self.name else s endif"); //$NON-NLS-1$
			
			fail("Should not have parsed"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		try {
			// missing type declaration in parameter
			helper.define(
				"bestName(s) : String = " + //$NON-NLS-1$
				"if self.oclIsKindOf(EClass) then self.name else s endif"); //$NON-NLS-1$
			
			fail("Should not have parsed"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_duplicateDefinition_attribute() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.ECLASSIFIER);
		
		try {
			// same name and type as existing property
			helper.define(
				"name : String = " + //$NON-NLS-1$
				"if self.oclIsKindOf(EClass) then 'foo' else '' endif"); //$NON-NLS-1$
			
			fail("Should not have parsed"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		try {
			// same name but different type
			helper.define(
				"eAnnotations : Set(String) = " + //$NON-NLS-1$
				"Set{'a', 'b', 'c'}"); //$NON-NLS-1$
			
			fail("Should not have parsed"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_duplicateDefinition_operation() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(apple);
		
		try {
			// same signature as existing operation (note different param name)
			helper.define(
				"preferredLabel(s : String) : String = " + //$NON-NLS-1$
				"if self.oclIsKindOf(EClass) then 'foo' else s endif"); //$NON-NLS-1$
			
			fail("Should not have parsed"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		try {
			// same signature as existing operation (note different return type)
			helper.define(
				"preferredLabel(s : String) : Integer = " + //$NON-NLS-1$
				"if self.oclIsKindOf(EClass) then 0 else s.size() endif"); //$NON-NLS-1$
			
			fail("Should not have parsed"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		try {
			// same name but different signature is OK
			helper.define(
				"preferredLabel(text : Integer) : String = " + //$NON-NLS-1$
				"if text > 0 then 'foo' else 'bar' endif"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_defExpression_completion_operation() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.ECLASSIFIER);
		
		try {
			helper.define(
					"allParents() : Set(EClassifier) = " + //$NON-NLS-1$
					"if self.oclIsKindOf(EClass) then self.oclAsType(EClass)->closure(eSuperTypes) else Set{} endif"); //$NON-NLS-1$
			
			Collection choices = helper.getSyntaxHelp(
					ConstraintType.INVARIANT, "self."); //$NON-NLS-1$
			
			assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "allParents"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_defExpression_completion_attribute() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.ECLASSIFIER);
		
		try {
			helper.define(
					"allParents : Set(EClassifier) = " + //$NON-NLS-1$
					"if self.oclIsKindOf(EClass) then self.oclAsType(EClass)->closure(eSuperTypes) else Set{} endif"); //$NON-NLS-1$
			
			Collection choices = helper.getSyntaxHelp(
					ConstraintType.INVARIANT, "self."); //$NON-NLS-1$
			
			assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "allParents"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	//
	// test framework
	//
	
	protected void tearDown() throws Exception {
		super.tearDown();
		
		for (Iterator iter = fruitPackage.getEClassifiers().iterator(); iter.hasNext();) {
			TypeUtil.undefineAdditionalFeatures((EClassifier) iter.next());
		}
		
		for (Iterator iter = EcorePackage.eINSTANCE.getEClassifiers().iterator(); iter.hasNext();) {
			TypeUtil.undefineAdditionalFeatures((EClassifier) iter.next());
		}
	}
}
