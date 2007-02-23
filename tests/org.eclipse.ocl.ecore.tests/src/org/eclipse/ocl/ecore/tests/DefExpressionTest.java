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
 * $Id: DefExpressionTest.java,v 1.3 2007/02/23 22:06:03 cdamus Exp $
 */

package org.eclipse.ocl.ecore.tests;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.Choice;
import org.eclipse.ocl.helper.ChoiceKind;
import org.eclipse.ocl.helper.ConstraintKind;
import org.eclipse.ocl.types.SetType;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.UMLReflection;

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
			OCLExpression<EClassifier> expr = parseDef(
				"package ocltest context Fruit " + //$NON-NLS-1$
				"def: bestColor(c : Color) : Color = if self.color = Color::black then c else self.color endif" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
			
			Constraint constraint = (Constraint) expr.eContainer().eContainer();
			assertNotNull(constraint);
			
			assertEquals(UMLReflection.DEFINITION, constraint.getStereotype());
			
			assertSame(color, expr.getType());
			
			expr = parse(
					"package ocltest context Fruit " + //$NON-NLS-1$
					"inv: bestColor(Color::red) = Color::red" + //$NON-NLS-1$
					" endpackage"); //$NON-NLS-1$
			
			EObject anApple = fruitFactory.create(apple);
			anApple.eSet(fruit_color, color_black);
			
			assertTrue(ocl.check(anApple, expr));
			
			anApple.eSet(fruit_color, color_green);
			
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
			
			EObject anApple = fruitFactory.create(apple);
			anApple.eSet(fruit_color, color_black);
			
			assertTrue(ocl.check(anApple, expr));
			
			anApple.eSet(fruit_color, color_green);
			
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
			OCLExpression<EClassifier> expr = parseDef(
				"package ocltest context Apple " + //$NON-NLS-1$
				"def: fallen : Boolean = stem.oclIsUndefined()" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
			
			Constraint constraint = (Constraint) expr.eContainer().eContainer();
			assertNotNull(constraint);
			
			assertEquals(UMLReflection.DEFINITION, constraint.getStereotype());
			
			assertSame(getOCLStandardLibrary().getBoolean(), expr.getType());
			
			expr = parse(
					"package ocltest context Apple " + //$NON-NLS-1$
					"inv: not fallen" + //$NON-NLS-1$
					" endpackage"); //$NON-NLS-1$
			
			EObject anApple = fruitFactory.create(apple);
			anApple.eSet(apple_stem, fruitFactory.create(stem));
			
			assertTrue(ocl.check(anApple, expr));
			
			anApple.eSet(apple_stem, null);
			
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
					"stem.oclIsUndefined()"); //$NON-NLS-1$
			
			Constraint expr = helper.createInvariant("not fallen"); //$NON-NLS-1$
			
			EObject anApple = fruitFactory.create(apple);
			anApple.eSet(apple_stem, fruitFactory.create(stem));
			
			assertTrue(ocl.check(anApple, expr));
			
			anApple.eSet(apple_stem, null);
			
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
			OCLExpression<EClassifier> expr = parseDef(
				"package ocltest context Apple " + //$NON-NLS-1$
				"def: otherApples : Set(Apple) = Apple.allInstances()->excluding(self)" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
			
			Constraint constraint = (Constraint) expr.eContainer().eContainer();
			assertNotNull(constraint);
			
			assertEquals(UMLReflection.DEFINITION, constraint.getStereotype());
			
			assertTrue(expr.getType() instanceof SetType);
			assertSame(
					((org.eclipse.ocl.ecore.SetType) expr.getType()).getElementType(),
					apple);
			
			expr = parse(
					"package ocltest context Apple " + //$NON-NLS-1$
					"inv: self.otherApples" + //$NON-NLS-1$
					" endpackage"); //$NON-NLS-1$
			
			EObject anApple = fruitFactory.create(apple);
			EObject anotherApple = fruitFactory.create(apple);
			Map<EClass, Set<EObject>> extentMap = new java.util.HashMap<EClass, Set<EObject>>();
			Set<EObject> allApples = new java.util.HashSet<EObject>();
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
		helper.setContext(EcorePackage.Literals.ECLASSIFIER);
		
		try {
			helper.defineOperation(
					"allParents() : Set(EClassifier) = " + //$NON-NLS-1$
					"if self.oclIsKindOf(EClass) then self.oclAsType(EClass)->closure(eSuperTypes) else Set{} endif"); //$NON-NLS-1$
			
			OCLExpression<EClassifier> expr = helper.createQuery("self.allParents()"); //$NON-NLS-1$
			
			Object allParents = ocl.evaluate(apple, expr);
			assertTrue(allParents instanceof Set);
			assertTrue(((Set<?>) allParents).contains(fruit));
			
			allParents = ocl.evaluate(color, expr);
			assertTrue(allParents instanceof Set);
			assertTrue(((Set<?>) allParents).isEmpty());
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_defExpression_inheritance_attribute() {
		helper.setContext(EcorePackage.Literals.ECLASSIFIER);
		
		try {
			helper.defineAttribute(
					"allParents : Set(EClassifier) = " + //$NON-NLS-1$
					"if self.oclIsKindOf(EClass) then self.oclAsType(EClass)->closure(eSuperTypes) else Set{} endif"); //$NON-NLS-1$
			
			OCLExpression<EClassifier> expr = helper.createQuery("self.allParents"); //$NON-NLS-1$
			
			Object allParents = ocl.evaluate(apple, expr);
			assertTrue(allParents instanceof Set);
			assertTrue(((Set<?>) allParents).contains(fruit));
			
			allParents = ocl.evaluate(color, expr);
			assertTrue(allParents instanceof Set);
			assertTrue(((Set<?>) allParents).isEmpty());
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_malformedDefExpression_attribute() {
		helper.setContext(EcorePackage.Literals.ECLASSIFIER);
		
		try {
			// non-conformant expression type
			helper.defineAttribute(
				"allParents : Set(EClassifier) = " + //$NON-NLS-1$
				"if self.oclIsKindOf(EClass) then self.name else '' endif"); //$NON-NLS-1$
			
			fail("Should not have parsed"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		try {
			// missing type declaration
			helper.defineAttribute(
				"myName = " + //$NON-NLS-1$
				"if self.oclIsKindOf(EClass) then self.name else '' endif"); //$NON-NLS-1$
			
			fail("Should not have parsed"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_malformedDefExpression_operation() {
		helper.setContext(EcorePackage.Literals.ECLASSIFIER);
		
		try {
			// non-conformant expression type
			helper.defineOperation(
				"allParents() : Set(EClassifier) = " + //$NON-NLS-1$
				"if self.oclIsKindOf(EClass) then self.name else '' endif"); //$NON-NLS-1$
			
			fail("Should not have parsed"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		try {
			// missing type declaration
			helper.defineOperation(
				"bestName(s : String) = " + //$NON-NLS-1$
				"if self.oclIsKindOf(EClass) then self.name else s endif"); //$NON-NLS-1$
			
			fail("Should not have parsed"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		try {
			// missing type declaration in parameter
			helper.defineOperation(
				"bestName(s) : String = " + //$NON-NLS-1$
				"if self.oclIsKindOf(EClass) then self.name else s endif"); //$NON-NLS-1$
			
			fail("Should not have parsed"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_duplicateDefinition_attribute() {
		helper.setContext(EcorePackage.Literals.ECLASSIFIER);
		
		try {
			// same name and type as existing property
			helper.defineAttribute(
				"name : String = " + //$NON-NLS-1$
				"if self.oclIsKindOf(EClass) then 'foo' else '' endif"); //$NON-NLS-1$
			
			fail("Should not have parsed"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		try {
			// same name but different type
			helper.defineAttribute(
				"eAnnotations : Set(String) = " + //$NON-NLS-1$
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
				"if self.oclIsKindOf(EClass) then 'foo' else s endif"); //$NON-NLS-1$
			
			fail("Should not have parsed"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		try {
			// same signature as existing operation (note different return type)
			helper.defineOperation(
				"preferredLabel(s : String) : Integer = " + //$NON-NLS-1$
				"if self.oclIsKindOf(EClass) then 0 else s.size() endif"); //$NON-NLS-1$
			
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
		helper.setContext(EcorePackage.Literals.ECLASS);
		
		EStructuralFeature property = null;
		
		try {
			// define some additional property
			property = helper.defineAttribute(
				"other : EClass = " + //$NON-NLS-1$
				"if eSuperTypes->notEmpty() then eSuperTypes->first() else null endif"); //$NON-NLS-1$
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
					"other : EClass = " + //$NON-NLS-1$
					"if eSuperTypes->notEmpty() then eSuperTypes->first() else null endif"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_undefine_operation_152018() {
		helper.setContext(EcorePackage.Literals.ECLASS);
		
		EOperation operation = null;
		
		try {
			// define some additional property
			operation = helper.defineOperation(
				"other(x : Integer) : EClass = " + //$NON-NLS-1$
				"if eSuperTypes->notEmpty() then eSuperTypes->at(x) else null endif"); //$NON-NLS-1$
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
					"other(x : Integer) : EClass = " + //$NON-NLS-1$
					"if eSuperTypes->size() >= x then eSuperTypes->at(x) else null endif"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_recursive_property_152018() {
		helper.setContext(EcorePackage.Literals.ECLASS);
		
		EStructuralFeature property = null;
		
		try {
			// first, attempt a definition with an invalid body
			property = helper.defineAttribute(
					"friend : EClass = " + //$NON-NLS-1$
					"if eSuperTypes->notEmpty() then ePackage else self endif"); //$NON-NLS-1$
			
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
				"friend : EClass = " + //$NON-NLS-1$
				"if eSuperTypes->notEmpty() then eSuperTypes->first().friend else self endif"); //$NON-NLS-1$
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
		helper.setContext(EcorePackage.Literals.ECLASS);
		
		EOperation operation = null;
		
		try {
			// first, attempt a definition with an invalid body
			operation = helper.defineOperation(
					"friend(x : Integer) : EClass = " + //$NON-NLS-1$
					"if eSuperTypes->size() >= x then ePackage else self endif"); //$NON-NLS-1$
			
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
				"friend(x : Integer) : EClass = " + //$NON-NLS-1$
				"if eSuperTypes->size() >= x then eSuperTypes->at(x).friend(x) else self endif"); //$NON-NLS-1$
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
		helper.setContext(EcorePackage.Literals.ECLASSIFIER);
		
		try {
			helper.defineOperation(
					"allParents() : Set(EClassifier) = " + //$NON-NLS-1$
					"if self.oclIsKindOf(EClass) then self.oclAsType(EClass)->closure(eSuperTypes) else Set{} endif"); //$NON-NLS-1$
			
			Collection<Choice> choices = helper.getSyntaxHelp(
					ConstraintKind.INVARIANT, "self."); //$NON-NLS-1$
			
			assertChoice(choices, ChoiceKind.OPERATION, "allParents"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_defExpression_completion_attribute() {
		helper.setContext(EcorePackage.Literals.ECLASSIFIER);
		
		try {
			helper.defineAttribute(
					"allParents : Set(EClassifier) = " + //$NON-NLS-1$
					"if self.oclIsKindOf(EClass) then self.oclAsType(EClass)->closure(eSuperTypes) else Set{} endif"); //$NON-NLS-1$
			
			Collection<Choice> choices = helper.getSyntaxHelp(
					ConstraintKind.INVARIANT, "self."); //$NON-NLS-1$
			
			assertChoice(choices, ChoiceKind.PROPERTY, "allParents"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
    
    /**
     * Tests the definition of additional attributes on the metamodel's
     * representation of a primitive type for which OCL has a counterpart.
     */
    public void test_defAttributeOnPrimitiveType_172782() {
        // context is the Ecore metamodel's EString data type
        helper.setContext(EcorePackage.Literals.ESTRING);
        
        try {
            EStructuralFeature feature = helper.defineAttribute(
                "reverse : String = " + //$NON-NLS-1$
                "Sequence{1..size()}->sortedBy(i | -i)->iterate(i; s : String = '' |" + //$NON-NLS-1$
                " s.concat(self.substring(i, i)))"); //$NON-NLS-1$
        
            // the other representation of 'String'
            helper.setContext(ocl.getEnvironment().getOCLStandardLibrary().getString());
        
            Collection<Choice> choices = helper.getSyntaxHelp(
                ConstraintKind.INVARIANT, "self."); //$NON-NLS-1$
        
            assertChoice(choices, ChoiceKind.PROPERTY, "reverse"); //$NON-NLS-1$
            
            OCLExpression<EClassifier> expr = helper.createQuery(
                "self.reverse"); //$NON-NLS-1$
            
            assertEquals(
                "ablE was i ere I saw elbA", //$NON-NLS-1$
                ocl.evaluate("Able was I ere i saw Elba", expr)); //$NON-NLS-1$
            
            // verify that TypeUtil produces the correct result
            assertTrue(TypeUtil.getAttributes(ocl.getEnvironment(), ocl.getEnvironment().getOCLStandardLibrary().getString())
                .contains(feature));
            assertTrue(TypeUtil.getAttributes(ocl.getEnvironment(), EcorePackage.Literals.ESTRING)
                .contains(feature));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
        
        // now, make sure that this definition was local to the OCL that
        //   parsed it (that it is not shared via the standard library package)
        OCL localOCL = OCL.newInstance();
        OCL.Helper localHelper = localOCL.createOCLHelper();
        localHelper.setContext(ocl.getEnvironment().getOCLStandardLibrary().getString());
        
        try {
            Collection<Choice> choices = localHelper.getSyntaxHelp(
                ConstraintKind.INVARIANT, "self."); //$NON-NLS-1$
        
            assertNotChoice(choices, ChoiceKind.PROPERTY, "reverse"); //$NON-NLS-1$
            
            localHelper.createQuery("self.reverse"); //$NON-NLS-1$
            
            fail("Should have failed to parse the undefined attribute"); //$NON-NLS-1$
        } catch (ParserException e) {
            // success!
            System.out.println("Got the expected exception: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
    
    /**
     * Tests the definition of additional operations on the metamodel's
     * representation of a primitive type for which OCL has a counterpart.
     */
    public void test_defOperationOnPrimitiveType_172782() {
        // context is the Ecore metamodel's EString data type
        helper.setContext(EcorePackage.Literals.ESTRING);
        
        try {
            EOperation feature = helper.defineOperation(
                "reversed() : String = " + //$NON-NLS-1$
                "Sequence{1..size()}->sortedBy(i | -i)->iterate(i; s : String = '' |" + //$NON-NLS-1$
                " s.concat(self.substring(i, i)))"); //$NON-NLS-1$
        
            // the other representation of 'String'
            helper.setContext(ocl.getEnvironment().getOCLStandardLibrary().getString());
        
            Collection<Choice> choices = helper.getSyntaxHelp(
                ConstraintKind.INVARIANT, "self."); //$NON-NLS-1$
        
            assertChoice(choices, ChoiceKind.OPERATION, "reversed"); //$NON-NLS-1$
            
            OCLExpression<EClassifier> expr = helper.createQuery(
                "self.reversed()"); //$NON-NLS-1$
            
            assertEquals(
                "ablE was i ere I saw elbA", //$NON-NLS-1$
                ocl.evaluate("Able was I ere i saw Elba", expr)); //$NON-NLS-1$
            
            // verify that TypeUtil produces the correct result
            assertTrue(TypeUtil.getOperations(ocl.getEnvironment(), ocl.getEnvironment().getOCLStandardLibrary().getString())
                .contains(feature));
            assertTrue(TypeUtil.getOperations(ocl.getEnvironment(), EcorePackage.Literals.ESTRING)
                .contains(feature));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
        
        // now, make sure that this definition was local to the OCL that
        //   parsed it (that it is not shared via the standard library package)
        OCL localOCL = OCL.newInstance();
        OCL.Helper localHelper = localOCL.createOCLHelper();
        localHelper.setContext(ocl.getEnvironment().getOCLStandardLibrary().getString());
        
        try {
            Collection<Choice> choices = localHelper.getSyntaxHelp(
                ConstraintKind.INVARIANT, "self."); //$NON-NLS-1$
        
            assertNotChoice(choices, ChoiceKind.OPERATION, "reversed"); //$NON-NLS-1$
            
            localHelper.createQuery("self.reversed()"); //$NON-NLS-1$
            
            fail("Should have failed to parse the undefined operation"); //$NON-NLS-1$
        } catch (ParserException e) {
            // success!
            System.out.println("Got the expected exception: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
    
    /**
     * Tests the definition of additional attributes on an OCL pre-defined type.
     */
    public void test_defAttributeOnPredefinedType_172782() {
        // context is the predefined OCL String type
        helper.setContext(ocl.getEnvironment().getOCLStandardLibrary().getString());
        
        try {
            EStructuralFeature feature = helper.defineAttribute(
                "reverse : String = " + //$NON-NLS-1$
                "Sequence{1..size()}->sortedBy(i | -i)->iterate(i; s : String = '' |" + //$NON-NLS-1$
                " s.concat(self.substring(i, i)))"); //$NON-NLS-1$
        
            // the other representation of 'String'
            helper.setContext(EcorePackage.Literals.ESTRING);
        
            Collection<Choice> choices = helper.getSyntaxHelp(
                ConstraintKind.INVARIANT, "self."); //$NON-NLS-1$
        
            assertChoice(choices, ChoiceKind.PROPERTY, "reverse"); //$NON-NLS-1$
            
            OCLExpression<EClassifier> expr = helper.createQuery(
                "self.reverse"); //$NON-NLS-1$
            
            assertEquals(
                "ablE was i ere I saw elbA", //$NON-NLS-1$
                ocl.evaluate("Able was I ere i saw Elba", expr)); //$NON-NLS-1$
            
            // verify that TypeUtil produces the correct result
            assertTrue(TypeUtil.getAttributes(ocl.getEnvironment(), ocl.getEnvironment().getOCLStandardLibrary().getString())
                .contains(feature));
            assertTrue(TypeUtil.getAttributes(ocl.getEnvironment(), EcorePackage.Literals.ESTRING)
                .contains(feature));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
        
        // now, make sure that this definition was local to the OCL that
        //   parsed it (that it is not shared via the standard library package)
        OCL localOCL = OCL.newInstance();
        OCL.Helper localHelper = localOCL.createOCLHelper();
        localHelper.setContext(ocl.getEnvironment().getOCLStandardLibrary().getString());
        
        try {
            Collection<Choice> choices = localHelper.getSyntaxHelp(
                ConstraintKind.INVARIANT, "self."); //$NON-NLS-1$
        
            assertNotChoice(choices, ChoiceKind.PROPERTY, "reverse"); //$NON-NLS-1$
            
            localHelper.createQuery("self.reverse"); //$NON-NLS-1$
            
            fail("Should have failed to parse the undefined attribute"); //$NON-NLS-1$
        } catch (ParserException e) {
            // success!
            System.out.println("Got the expected exception: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
    
    /**
     * Tests the definition of additional operations on an OCL pre-defined type.
     */
    public void test_defOperationOnPredefinedType_172782() {
        // context is the predefined OCL String type
        helper.setContext(ocl.getEnvironment().getOCLStandardLibrary().getString());
        
        try {
            EOperation feature = helper.defineOperation(
                "reversed() : String = " + //$NON-NLS-1$
                "Sequence{1..size()}->sortedBy(i | -i)->iterate(i; s : String = '' |" + //$NON-NLS-1$
                " s.concat(self.substring(i, i)))"); //$NON-NLS-1$
        
            // the other representation of 'String'
            helper.setContext(EcorePackage.Literals.ESTRING);
        
            Collection<Choice> choices = helper.getSyntaxHelp(
                ConstraintKind.INVARIANT, "self."); //$NON-NLS-1$
        
            assertChoice(choices, ChoiceKind.OPERATION, "reversed"); //$NON-NLS-1$
            
            OCLExpression<EClassifier> expr = helper.createQuery(
                "self.reversed()"); //$NON-NLS-1$
            
            assertEquals(
                "ablE was i ere I saw elbA", //$NON-NLS-1$
                ocl.evaluate("Able was I ere i saw Elba", expr)); //$NON-NLS-1$
            
            // verify that TypeUtil produces the correct result
            assertTrue(TypeUtil.getOperations(ocl.getEnvironment(), ocl.getEnvironment().getOCLStandardLibrary().getString())
                .contains(feature));
            assertTrue(TypeUtil.getOperations(ocl.getEnvironment(), EcorePackage.Literals.ESTRING)
                .contains(feature));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
        
        // now, make sure that this definition was local to the OCL that
        //   parsed it (that it is not shared via the standard library package)
        OCL localOCL = OCL.newInstance();
        OCL.Helper localHelper = localOCL.createOCLHelper();
        localHelper.setContext(ocl.getEnvironment().getOCLStandardLibrary().getString());
        
        try {
            Collection<Choice> choices = localHelper.getSyntaxHelp(
                ConstraintKind.INVARIANT, "self."); //$NON-NLS-1$
        
            assertNotChoice(choices, ChoiceKind.OPERATION, "reversed"); //$NON-NLS-1$
            
            localHelper.createQuery("self.reversed()"); //$NON-NLS-1$
            
            fail("Should have failed to parse the undefined operation"); //$NON-NLS-1$
        } catch (ParserException e) {
            // success!
            System.out.println("Got the expected exception: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
}
