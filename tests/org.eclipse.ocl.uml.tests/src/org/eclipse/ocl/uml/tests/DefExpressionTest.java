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
 * $Id: DefExpressionTest.java,v 1.1 2007/01/25 18:41:54 cdamus Exp $
 */

package org.eclipse.ocl.uml.tests;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.Choice;
import org.eclipse.ocl.helper.ChoiceKind;
import org.eclipse.ocl.helper.ConstraintKind;
import org.eclipse.ocl.types.SetType;
import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;

/**
 * Tests for def expressions (additional properties and operations).
 *
 * @author Christian W. Damus (cdamus)
 */
public class DefExpressionTest
	extends AbstractTestSuite {
	
	private Resource instanceResource;
	private Package instancePackage;
	
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
			OCLExpression<Classifier> expr = parseDef(
				"package ocltest context Fruit " + //$NON-NLS-1$
				"def: bestColor(c : Color) : Color = " + //$NON-NLS-1$
				"if self.color = Color::black then c else self.color endif" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
			
			Constraint constraint = (Constraint) expr.eContainer().eContainer();
			assertNotNull(constraint);
			
			assertEquals(UMLReflection.DEFINITION, getStereotype(constraint));
			
			assertSame(color, expr.getType());
			
			expr = parse(
					"package ocltest context Fruit " + //$NON-NLS-1$
					"inv: bestColor(Color::red) = Color::red" + //$NON-NLS-1$
					" endpackage"); //$NON-NLS-1$
			
			InstanceSpecification anApple = instantiate(instancePackage, apple);
			setValue(anApple, fruit_color, color_black);
			
			assertTrue(ocl.check(anApple, expr));
			
			setValue(anApple, fruit_color, color_green);
			
			assertFalse(ocl.check(anApple, expr));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the parsing the def expression for an operation using the helper.
	 */
	public void test_defExpression_helper_operation() {
		helper.setContext(fruit);
		
		try {
			helper.defineOperation(
					"bestColor(c : Color) : Color = " + //$NON-NLS-1$
					"if self.color = Color::black then c else self.color endif"); //$NON-NLS-1$
			
			Constraint expr = helper.createInvariant(
					"bestColor(Color::red) = Color::red"); //$NON-NLS-1$
			
			InstanceSpecification anApple = instantiate(instancePackage, apple);
			setValue(anApple, fruit_color, color_black);
			
			assertTrue(ocl.check(anApple, expr));
			
			setValue(anApple, fruit_color, color_green);
			
			assertFalse(ocl.check(anApple, expr));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the parsing the def expression for an attribute from raw text.
	 */
	public void test_defExpression_raw_attribute() {
		try {
			OCLExpression<Classifier> expr = parseDef(
				"package ocltest context Apple " + //$NON-NLS-1$
				"def: fallen : Boolean = tree.oclIsUndefined()" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
			
			Constraint constraint = (Constraint) expr.eContainer().eContainer();
			assertNotNull(constraint);
			
			assertEquals(UMLReflection.DEFINITION, getStereotype(constraint));
			
			assertSame(getOCLStandardLibrary().getBoolean(), expr.getType());
			
			expr = parse(
					"package ocltest context Apple " + //$NON-NLS-1$
					"inv: not fallen" + //$NON-NLS-1$
					" endpackage"); //$NON-NLS-1$
			
			InstanceSpecification anApple = instantiate(instancePackage, apple);
			setValue(anApple, apple_tree, instantiate(instancePackage, tree));
			
			assertTrue(ocl.check(anApple, expr));
			
			setValue(anApple, apple_tree, null);
			
			assertFalse(ocl.check(anApple, expr));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the parsing the def expression for an attribute using the helper.
	 */
	public void test_defExpression_helper_attribute() {
		helper.setContext(apple);
		
		try {
			helper.defineAttribute(
					"fallen : Boolean = " + //$NON-NLS-1$
					"tree.oclIsUndefined()"); //$NON-NLS-1$
			
			Constraint expr = helper.createInvariant("not fallen"); //$NON-NLS-1$
			
			InstanceSpecification anApple = instantiate(instancePackage, apple);
			setValue(anApple, apple_tree, instantiate(instancePackage, tree));
			
			assertTrue(ocl.check(anApple, expr));
			
			setValue(anApple, apple_tree, null);
			
			assertFalse(ocl.check(anApple, expr));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the parsing the def expression for a reference from raw text.
	 */
	public void test_defExpression_raw_reference() {
		try {
			OCLExpression<Classifier> expr = parseDef(
				"package ocltest context Apple " + //$NON-NLS-1$
				"def: otherApples : Set(Apple) = Apple.allInstances()->excluding(self)" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
			
			Constraint constraint = (Constraint) expr.eContainer().eContainer();
			assertNotNull(constraint);
			
			assertEquals(UMLReflection.DEFINITION, getStereotype(constraint));
			
			assertTrue(expr.getType() instanceof SetType);
			assertSame(
					((org.eclipse.ocl.uml.SetType) expr.getType()).getElementType(),
					apple);
			
			expr = parse(
					"package ocltest context Apple " + //$NON-NLS-1$
					"inv: self.otherApples" + //$NON-NLS-1$
					" endpackage"); //$NON-NLS-1$
			
			InstanceSpecification anApple = instantiate(instancePackage, apple);
			InstanceSpecification anotherApple = instantiate(instancePackage, apple);
			Map<Class, Set<InstanceSpecification>> extentMap =
				new java.util.HashMap<Class, Set<InstanceSpecification>>();
			Set<InstanceSpecification> allApples = new java.util.HashSet<InstanceSpecification>();
			allApples.add(anApple);
			allApples.add(anotherApple);
			extentMap.put(apple, allApples);
			ocl.setExtentMap(extentMap);
			
			Object otherApples = ocl.evaluate(anApple, expr);
			
			assertEquals(Collections.singleton(anotherApple), otherApples);
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_defExpression_inheritance_operation() {
		helper.setContext(getMetaclass("Classifier")); //$NON-NLS-1$
		
		try {
			helper.defineOperation(
					"oclAllParents() : Set(Classifier) = " + //$NON-NLS-1$
					"self->closure(generalization.general)"); //$NON-NLS-1$
			
			OCLExpression<Classifier> expr = helper.createQuery("self.oclAllParents()"); //$NON-NLS-1$
			
			Object oclAllParents = ocl.evaluate(apple, expr);
			assertTrue(oclAllParents instanceof Set);
			assertTrue(((Set<?>) oclAllParents).contains(fruit));
			
			oclAllParents = ocl.evaluate(color, expr);
			assertTrue(oclAllParents instanceof Set);
			assertTrue(((Set<?>) oclAllParents).isEmpty());
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_defExpression_inheritance_attribute() {
		helper.setContext(getMetaclass("Classifier")); //$NON-NLS-1$
		
		try {
			helper.defineAttribute(
					"oclAllParents : Set(Classifier) = " + //$NON-NLS-1$
					"self->closure(generalization.general)"); //$NON-NLS-1$
			
			OCLExpression<Classifier> expr = helper.createQuery("self.oclAllParents"); //$NON-NLS-1$
			
			Object oclAllParents = ocl.evaluate(apple, expr);
			assertTrue(oclAllParents instanceof Set);
			assertTrue(((Set<?>) oclAllParents).contains(fruit));
			
			oclAllParents = ocl.evaluate(color, expr);
			assertTrue(oclAllParents instanceof Set);
			assertTrue(((Set<?>) oclAllParents).isEmpty());
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_malformedDefExpression_attribute() {
		helper.setContext(getMetaclass("Classifier")); //$NON-NLS-1$
		
		try {
			// non-conformant expression type
			helper.defineAttribute(
				"oclAllParents : Set(Classifier) = " + //$NON-NLS-1$
				"self.name"); //$NON-NLS-1$
			
			fail("Should not have parsed"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		try {
			// missing type declaration
			helper.defineAttribute(
				"myName = " + //$NON-NLS-1$
				"self.name"); //$NON-NLS-1$
			
			fail("Should not have parsed"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_malformedDefExpression_operation() {
		helper.setContext(getMetaclass("Classifier")); //$NON-NLS-1$
		
		try {
			// non-conformant expression type
			helper.defineOperation(
				"oclAllParents() : Set(Classifier) = " + //$NON-NLS-1$
				"self.name"); //$NON-NLS-1$
			
			fail("Should not have parsed"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		try {
			// missing type declaration
			helper.defineOperation(
				"bestName(s : String) = " + //$NON-NLS-1$
				"if self.oclIsKindOf(Class) then self.name else s endif"); //$NON-NLS-1$
			
			fail("Should not have parsed"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		try {
			// missing type declaration in parameter
			helper.defineOperation(
				"bestName(s) : String = " + //$NON-NLS-1$
				"if self.oclIsKindOf(Class) then self.name else s endif"); //$NON-NLS-1$
			
			fail("Should not have parsed"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_duplicateDefinition_attribute() {
		helper.setContext(getMetaclass("Classifier")); //$NON-NLS-1$
		
		try {
			// same name and type as existing property
			helper.defineAttribute(
				"name : String = " + //$NON-NLS-1$
				"if self.oclIsKindOf(Class) then 'foo' else '' endif"); //$NON-NLS-1$
			
			fail("Should not have parsed"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		try {
			// same name but different type
			helper.defineAttribute(
				"generalization : Set(String) = " + //$NON-NLS-1$
				"Set{'a', 'b', 'c'}"); //$NON-NLS-1$
			
			fail("Should not have parsed"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_duplicateDefinition_operation() {
		helper.setContext(apple);
		
		try {
			// same signature as existing operation (note different param name)
			helper.defineOperation(
				"preferredLabel(s : String) : String = " + //$NON-NLS-1$
				"if s.oclIsUndefined() then 'foo' else s endif"); //$NON-NLS-1$
			
			fail("Should not have parsed"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		try {
			// same signature as existing operation (note different return type)
			helper.defineOperation(
				"preferredLabel(s : String) : Integer = " + //$NON-NLS-1$
				"if s.oclIsUndefined() then 0 else s.size() endif"); //$NON-NLS-1$
			
			fail("Should not have parsed"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		try {
			// same name but different signature is OK
			helper.defineOperation(
				"preferredLabel(text : Integer) : String = " + //$NON-NLS-1$
				"if text > 0 then 'foo' else 'bar' endif"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_undefine_property_152018() {
		helper.setContext(getMetaclass("Classifier")); //$NON-NLS-1$
		
		Property property = null;
		
		try {
			// define some additional property
			property = helper.defineAttribute(
				"other : Classifier = " + //$NON-NLS-1$
				"if general->notEmpty() then general->asSequence()->first() else null endif"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		assertNotNull(property);
		
		// now, undefine this property
		ocl.getEnvironment().undefine(property);
		
		assertNull(property.eContainer());
		assertNull(property.eResource());
		
		try {
			// try to define this property again.  We should succeed
			property = helper.defineAttribute(
					"other : Classifier = " + //$NON-NLS-1$
					"if general->notEmpty() then general->asSequence()->first() else null endif"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_undefine_operation_152018() {
		helper.setContext(getMetaclass("Classifier")); //$NON-NLS-1$
		
		Operation operation = null;
		
		try {
			// define some additional property
			operation = helper.defineOperation(
				"other(x : Integer) : Classifier = " + //$NON-NLS-1$
				"if general->size() >= x then general->asSequence()->at(x) else null endif"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		assertNotNull(operation);
		
		// now, undefine this operation
		ocl.getEnvironment().undefine(operation);
		
		assertNull(operation.eContainer());
		assertNull(operation.eResource());
		
		try {
			// try to define this property again.  We should succeed
			operation = helper.defineOperation(
					"other(x : Integer) : Classifier = " + //$NON-NLS-1$
					"if general->size() >= x then general->asSequence()->at(x) else null endif"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_recursive_property_152018() {
		helper.setContext(getMetaclass("Classifier")); //$NON-NLS-1$
		
		Property property = null;
		
		try {
			// first, attempt a definition with an invalid body
			property = helper.defineAttribute(
					"friend : Classifier = " + //$NON-NLS-1$
					"if general->notEmpty() then getNearestPackage() else self endif"); //$NON-NLS-1$
			
			fail("Should not have parsed"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		try {
			// now, attempt a correct definition.  This should not find that
			//   'other' is already defined, because it should have been
			//   undefined when we failed to parse, above
			property = helper.defineAttribute(
				"friend : Classifier = " + //$NON-NLS-1$
				"if general->notEmpty() then general->asSequence()->first().friend else self endif"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		assertNotNull(property);
		
		try {
			// now, attempt to use this additional property
			helper.createInvariant(
					"not friend.oclIsUndefined() implies friend = self"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_recursive_operation_152018() {
		helper.setContext(getMetaclass("Classifier")); //$NON-NLS-1$
		
		Operation operation = null;
		
		try {
			// first, attempt a definition with an invalid body
			operation = helper.defineOperation(
					"friend(x : Integer) : Classifier = " + //$NON-NLS-1$
					"if general->size() >= x then getNearestPackage() else self endif"); //$NON-NLS-1$
			
			fail("Should not have parsed"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		try {
			// now, attempt a correct definition.  This should not find that
			//   'other' is already defined, because it should have been
			//   undefined when we failed to parse, above
			operation = helper.defineOperation(
				"friend(x : Integer) : Classifier = " + //$NON-NLS-1$
				"if general->size() >= x then general->asSequence()->at(x).friend(x) else self endif"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		assertNotNull(operation);
		
		try {
			// now, attempt to use this additional property
			helper.createInvariant(
					"not friend(1).oclIsUndefined() implies friend(1) = self"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_defExpression_completion_operation() {
		helper.setContext(getMetaclass("Classifier")); //$NON-NLS-1$
		
		try {
			helper.defineOperation(
					"oclAllParents() : Set(Classifier) = " + //$NON-NLS-1$
					"self->closure(generalization.general)"); //$NON-NLS-1$
			
			Collection<Choice> choices = helper.getSyntaxHelp(
					ConstraintKind.INVARIANT, "self."); //$NON-NLS-1$
			
			assertChoice(choices, ChoiceKind.OPERATION, "oclAllParents"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_defExpression_completion_attribute() {
		helper.setContext(getMetaclass("Classifier")); //$NON-NLS-1$
		
		try {
			helper.defineAttribute(
					"oclAllParents : Set(Classifier) = " + //$NON-NLS-1$
					"self->closure(generalization.general)"); //$NON-NLS-1$
			
			Collection<Choice> choices = helper.getSyntaxHelp(
					ConstraintKind.INVARIANT, "self."); //$NON-NLS-1$
			
			assertChoice(choices, ChoiceKind.PROPERTY, "oclAllParents"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	//
	// Test framework
	//
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		instanceResource = resourceSet.createResource(
				URI.createFileURI("/tmp/instances.uml")); //$NON-NLS-1$
		
		instancePackage = umlf.createPackage();
		instancePackage.setName("instances"); //$NON-NLS-1$
		instanceResource.getContents().add(instancePackage);
	}
	
	@Override
	protected void tearDown() throws Exception {
		instancePackage = null;
		instanceResource.unload();
		resourceSet.getResources().remove(instanceResource);
		
		super.tearDown();
	}
}
