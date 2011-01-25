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
 *   Zeligsoft - Bug 238050
 *
 * </copyright>
 *
 * $Id: DefExpressionTest.java,v 1.9 2009/11/28 17:41:00 ewillink Exp $
 */

package org.eclipse.ocl.ecore.tests;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.Choice;
import org.eclipse.ocl.helper.ChoiceKind;
import org.eclipse.ocl.helper.ConstraintKind;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.options.ParsingOptions;
import org.eclipse.ocl.types.SetType;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.UMLReflection;

/**
 * Tests for def expressions (additional properties and operations).
 *
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class DefExpressionTest
	extends AbstractTestSuite {
	
	/**
	 * Tests the parsing the def expression for an operation from raw text.
	 */
	public void test_defExpression_raw_operation() {
		try {
			OCLExpression<EClassifier> expr = parseDef(
				"package ocltest context Fruit " +
				"def: bestColor(c : Color) : Color = if self.color = Color::black then c else self.color endif" +
				" endpackage");
			
			Constraint constraint = (Constraint) expr.eContainer().eContainer();
			assertNotNull(constraint);
			
			assertEquals(UMLReflection.DEFINITION, constraint.getStereotype());
			
			assertSame(color, expr.getType());
			
			expr = parse(
					"package ocltest context Fruit " +
					"inv: bestColor(Color::red) = Color::red" +
					" endpackage");
			
			EObject anApple = fruitFactory.create(apple);
			anApple.eSet(fruit_color, color_black);
			
			assertTrue(ocl.check(anApple, expr));
			
			anApple.eSet(fruit_color, color_green);
			
			assertFalse(ocl.check(anApple, expr));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Tests the parsing the def expression for an operation using the helper.
	 */
	public void test_defExpression_helper_operation() {
		helper.setContext(fruit);
		
		try {
			helper.defineOperation(
					"bestColor(c : Color) : Color = " +
					"if self.color = Color::black then c else self.color endif");
			
			Constraint expr = helper.createInvariant(
					"bestColor(Color::red) = Color::red");
			
			EObject anApple = fruitFactory.create(apple);
			anApple.eSet(fruit_color, color_black);
			
			assertTrue(ocl.check(anApple, expr));
			
			anApple.eSet(fruit_color, color_green);
			
			assertFalse(ocl.check(anApple, expr));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Tests the parsing the def expression for an attribute from raw text.
	 */
	public void test_defExpression_raw_attribute() {
		try {
			OCLExpression<EClassifier> expr = parseDef(
				"package ocltest context Apple " +
				"def: fallen : Boolean = stem.oclIsUndefined()" +
				" endpackage");
			
			Constraint constraint = (Constraint) expr.eContainer().eContainer();
			assertNotNull(constraint);
			
			assertEquals(UMLReflection.DEFINITION, constraint.getStereotype());
			
			assertSame(getOCLStandardLibrary().getBoolean(), expr.getType());
			
			expr = parse(
					"package ocltest context Apple " +
					"inv: not fallen" +
					" endpackage");
			
			EObject anApple = fruitFactory.create(apple);
			anApple.eSet(apple_stem, fruitFactory.create(stem));
			
			assertTrue(ocl.check(anApple, expr));
			
			anApple.eSet(apple_stem, null);
			
			assertFalse(ocl.check(anApple, expr));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Tests the parsing the def expression for an attribute using the helper.
	 */
	public void test_defExpression_helper_attribute() {
		helper.setContext(apple);
		
		try {
			helper.defineAttribute(
					"fallen : Boolean = " +
					"stem.oclIsUndefined()");
			
			Constraint expr = helper.createInvariant("not fallen");
			
			EObject anApple = fruitFactory.create(apple);
			anApple.eSet(apple_stem, fruitFactory.create(stem));
			
			assertTrue(ocl.check(anApple, expr));
			
			anApple.eSet(apple_stem, null);
			
			assertFalse(ocl.check(anApple, expr));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Tests the parsing the def expression for a reference from raw text.
	 */
	public void test_defExpression_raw_reference() {
		try {
			OCLExpression<EClassifier> expr = parseDef(
				"package ocltest context Apple " +
				"def: otherApples : Set(Apple) = Apple.allInstances()->excluding(self)" +
				" endpackage");
			
			Constraint constraint = (Constraint) expr.eContainer().eContainer();
			assertNotNull(constraint);
			
			assertEquals(UMLReflection.DEFINITION, constraint.getStereotype());
			
			assertTrue(expr.getType() instanceof SetType<?, ?>);
			assertSame(
					((org.eclipse.ocl.ecore.SetType) expr.getType()).getElementType(),
					apple);
			
			expr = parse(
					"package ocltest context Apple " +
					"inv: self.otherApples" +
					" endpackage");
			
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
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
		}
	}
	
	public void test_defExpression_inheritance_operation() {
		helper.setContext(EcorePackage.Literals.ECLASSIFIER);
		
		try {
			helper.defineOperation(
					"allParents() : Set(EClassifier) = " +
					"if self.oclIsKindOf(EClass) then self.oclAsType(EClass)->closure(eSuperTypes) else Set{} endif");
			
			OCLExpression<EClassifier> expr = helper.createQuery("self.allParents()");
			
			Object allParents = ocl.evaluate(apple, expr);
			assertTrue(allParents instanceof Set<?>);
			assertTrue(((Set<?>) allParents).contains(fruit));
			
			allParents = ocl.evaluate(color, expr);
			assertTrue(allParents instanceof Set<?>);
			assertTrue(((Set<?>) allParents).isEmpty());
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
		}
	}
	
	public void test_defExpression_inheritance_attribute() {
		helper.setContext(EcorePackage.Literals.ECLASSIFIER);
		
		try {
			helper.defineAttribute(
					"allParents : Set(EClassifier) = " +
					"if self.oclIsKindOf(EClass) then self.oclAsType(EClass)->closure(eSuperTypes) else Set{} endif");
			
			OCLExpression<EClassifier> expr = helper.createQuery("self.allParents");
			
			Object allParents = ocl.evaluate(apple, expr);
			assertTrue(allParents instanceof Set<?>);
			assertTrue(((Set<?>) allParents).contains(fruit));
			
			allParents = ocl.evaluate(color, expr);
			assertTrue(allParents instanceof Set<?>);
			assertTrue(((Set<?>) allParents).isEmpty());
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Tests the parsing the def expression for static attributes and operations.
	 */
	public void test_defExpression_static() {
		try {
			ParsingOptions.setOption(ocl.getEnvironment(), ParsingOptions.SUPPORT_STATIC_FEATURES, true);
			try {
				ocl.parse(new OCLInput("package ocltest context Fruit " +
					"def: bestColor1() : Color = null " +
					"static def: bestColor2() : Color = null " +
					"def: goodColor1 : Color = null " +
					"static def: goodColor2 : Color = null " +
					"endpackage"));			
	            fail("Should have failed to parse the unimplemented static");
	        } catch (ParserException e) {
	            // success!
	        	assertEquals(OCLMessages.UnimplementedStatic_ERROR_, e.getMessage());
	            System.out.println("Got the expected exception: " + e.getLocalizedMessage());
	        }
			
	        ParsingOptions.setOption(ocl.getEnvironment(), ParsingOptions.SUPPORT_STATIC_FEATURES, false);
			try {
				ocl.parse(new OCLInput("package ocltest context Fruit " +
					"def: bestColor3() : Color = null " +
					"static def: bestColor4() : Color = null " +
					"endpackage"));			
	            fail("Should have failed to parse the unsupported static");
	        } catch (ParserException e) {
	            // success!
	        	assertEquals(OCLMessages.UnsupportedStatic_ERROR_, e.getMessage());
	            System.out.println("Got the expected exception: " + e.getLocalizedMessage());
	        }
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
		}
	}
	
	public void test_malformedDefExpression_attribute() {
		helper.setContext(EcorePackage.Literals.ECLASSIFIER);
		
		try {
			// non-conformant expression type
			helper.defineAttribute(
				"allParents : Set(EClassifier) = " +
				"if self.oclIsKindOf(EClass) then self.name else '' endif");
			
			fail("Should not have parsed");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		
		try {
			// missing type declaration
			helper.defineAttribute(
				"myName = " +
				"if self.oclIsKindOf(EClass) then self.name else '' endif");
			
			fail("Should not have parsed");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
	}
	
	public void test_malformedDefExpression_operation() {
		helper.setContext(EcorePackage.Literals.ECLASSIFIER);
		
		try {
			// non-conformant expression type
			helper.defineOperation(
				"allParents() : Set(EClassifier) = " +
				"if self.oclIsKindOf(EClass) then self.name else '' endif");
			
			fail("Should not have parsed");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		
		try {
			// missing type declaration
			helper.defineOperation(
				"bestName(s : String) = " +
				"if self.oclIsKindOf(EClass) then self.name else s endif");
			
			fail("Should not have parsed");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		
		try {
			// missing type declaration in parameter
			helper.defineOperation(
				"bestName(s) : String = " +
				"if self.oclIsKindOf(EClass) then self.name else s endif");
			
			fail("Should not have parsed");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
	}
	
	public void test_duplicateDefinition_attribute() {
		helper.setContext(EcorePackage.Literals.ECLASSIFIER);
		
		try {
			// same name and type as existing property
			helper.defineAttribute(
				"name : String = " +
				"if self.oclIsKindOf(EClass) then 'foo' else '' endif");
			
			fail("Should not have parsed");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		
		try {
			// same name but different type
			helper.defineAttribute(
				"eAnnotations : Set(String) = " +
				"Set{'a', 'b', 'c'}");
			
			fail("Should not have parsed");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
	}
	
	public void test_duplicateDefinition_operation() {
		helper.setContext(apple);
		
		try {
			// same signature as existing operation (note different param name)
			helper.defineOperation(
				"preferredLabel(s : String) : String = " +
				"if self.oclIsKindOf(EClass) then 'foo' else s endif");
			
			fail("Should not have parsed");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		
		try {
			// same signature as existing operation (note different return type)
			helper.defineOperation(
				"preferredLabel(s : String) : Integer = " +
				"if self.oclIsKindOf(EClass) then 0 else s.size() endif");
			
			fail("Should not have parsed");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		
		try {
			// same name but different signature is OK
			helper.defineOperation(
				"preferredLabel(text : Integer) : String = " +
				"if text > 0 then 'foo' else 'bar' endif");
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage());
		}
	}
	
	public void test_undefine_property_152018() {
		helper.setContext(EcorePackage.Literals.ECLASS);
		
		EStructuralFeature property = null;
		
		try {
			// define some additional property
			property = helper.defineAttribute(
				"other : EClass = " +
				"if eSuperTypes->notEmpty() then eSuperTypes->first() else null endif");
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage());
		}
		
		assertNotNull(property);
		
		// now, undefine this property
		ocl.getEnvironment().undefine(property);
		
		assertNull(property.eContainer());
		assertNull(property.eResource());
		
		try {
			// try to define this property again.  We should succeed
			property = helper.defineAttribute(
					"other : EClass = " +
					"if eSuperTypes->notEmpty() then eSuperTypes->first() else null endif");
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage());
		}
	}
	
	public void test_undefine_operation_152018() {
		helper.setContext(EcorePackage.Literals.ECLASS);
		
		EOperation operation = null;
		
		try {
			// define some additional property
			operation = helper.defineOperation(
				"other(x : Integer) : EClass = " +
				"if eSuperTypes->notEmpty() then eSuperTypes->at(x) else null endif");
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage());
		}
		
		assertNotNull(operation);
		
		// now, undefine this operation
		ocl.getEnvironment().undefine(operation);
		
		assertNull(operation.eContainer());
		assertNull(operation.eResource());
		
		try {
			// try to define this property again.  We should succeed
			operation = helper.defineOperation(
					"other(x : Integer) : EClass = " +
					"if eSuperTypes->size() >= x then eSuperTypes->at(x) else null endif");
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage());
		}
	}
	
	public void test_recursive_property_152018() {
		helper.setContext(EcorePackage.Literals.ECLASS);
		
		EStructuralFeature property = null;
		
		try {
			// first, attempt a definition with an invalid body
			property = helper.defineAttribute(
					"friend : EClass = " +
					"if eSuperTypes->notEmpty() then ePackage else self endif");
			
			fail("Should not have parsed");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		
		try {
			// now, attempt a correct definition.  This should not find that
			//   'other' is already defined, because it should have been
			//   undefined when we failed to parse, above
			property = helper.defineAttribute(
				"friend : EClass = " +
				"if eSuperTypes->notEmpty() then eSuperTypes->first().friend else self endif");
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage());
		}
		
		assertNotNull(property);
		
		try {
			// now, attempt to use this additional property
			helper.createInvariant(
					"not friend.oclIsUndefined() implies friend = self");
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage());
		}
	}
	
	public void test_recursive_operation_152018() {
		helper.setContext(EcorePackage.Literals.ECLASS);
		
		EOperation operation = null;
		
		try {
			// first, attempt a definition with an invalid body
			operation = helper.defineOperation(
					"friend(x : Integer) : EClass = " +
					"if eSuperTypes->size() >= x then ePackage else self endif");
			
			fail("Should not have parsed");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		
		try {
			// now, attempt a correct definition.  This should not find that
			//   'other' is already defined, because it should have been
			//   undefined when we failed to parse, above
			operation = helper.defineOperation(
				"friend(x : Integer) : EClass = " +
				"if eSuperTypes->size() >= x then eSuperTypes->at(x).friend(x) else self endif");
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage());
		}
		
		assertNotNull(operation);
		
		try {
			// now, attempt to use this additional property
			helper.createInvariant(
					"not friend(1).oclIsUndefined() implies friend(1) = self");
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage());
		}
	}
	
	public void test_defExpression_completion_operation() {
		helper.setContext(EcorePackage.Literals.ECLASSIFIER);
		
		try {
			helper.defineOperation(
					"allParents() : Set(EClassifier) = " +
					"if self.oclIsKindOf(EClass) then self.oclAsType(EClass)->closure(eSuperTypes) else Set{} endif");
			
			Collection<Choice> choices = helper.getSyntaxHelp(
					ConstraintKind.INVARIANT, "self.");
			
			assertChoice(choices, ChoiceKind.OPERATION, "allParents");
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
		}
	}
	
	public void test_defExpression_completion_attribute() {
		helper.setContext(EcorePackage.Literals.ECLASSIFIER);
		
		try {
			helper.defineAttribute(
					"allParents : Set(EClassifier) = " +
					"if self.oclIsKindOf(EClass) then self.oclAsType(EClass)->closure(eSuperTypes) else Set{} endif");
			
			Collection<Choice> choices = helper.getSyntaxHelp(
					ConstraintKind.INVARIANT, "self.");
			
			assertChoice(choices, ChoiceKind.PROPERTY, "allParents");
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
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
                "reverse : String = " +
                "Sequence{1..size()}->sortedBy(i | -i)->iterate(i; s : String = '' |" +
                " s.concat(self.substring(i, i)))");
        
            // the other representation of 'String'
            helper.setContext(ocl.getEnvironment().getOCLStandardLibrary().getString());
        
            Collection<Choice> choices = helper.getSyntaxHelp(
                ConstraintKind.INVARIANT, "self.");
        
            assertChoice(choices, ChoiceKind.PROPERTY, "reverse");
            
            OCLExpression<EClassifier> expr = helper.createQuery(
                "self.reverse");
            
            assertEquals(
                "ablE was i ere I saw elbA",
                ocl.evaluate("Able was I ere i saw Elba", expr));
            
            // verify that TypeUtil produces the correct result
            assertTrue(TypeUtil.getAttributes(ocl.getEnvironment(), ocl.getEnvironment().getOCLStandardLibrary().getString())
                .contains(feature));
            assertTrue(TypeUtil.getAttributes(ocl.getEnvironment(), EcorePackage.Literals.ESTRING)
                .contains(feature));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
        
        // now, make sure that this definition was local to the OCL that
        //   parsed it (that it is not shared via the standard library package)
        OCL localOCL = OCL.newInstance();
        OCL.Helper localHelper = localOCL.createOCLHelper();
        localHelper.setContext(ocl.getEnvironment().getOCLStandardLibrary().getString());
        
        try {
            Collection<Choice> choices = localHelper.getSyntaxHelp(
                ConstraintKind.INVARIANT, "self.");
        
            assertNotChoice(choices, ChoiceKind.PROPERTY, "reverse");
            
            localHelper.createQuery("self.reverse");
            
            fail("Should have failed to parse the undefined attribute");
        } catch (ParserException e) {
            // success!
            System.out.println("Got the expected exception: " + e.getLocalizedMessage());
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
                "reversed() : String = " +
                "Sequence{1..size()}->sortedBy(i | -i)->iterate(i; s : String = '' |" +
                " s.concat(self.substring(i, i)))");
        
            // the other representation of 'String'
            helper.setContext(ocl.getEnvironment().getOCLStandardLibrary().getString());
        
            Collection<Choice> choices = helper.getSyntaxHelp(
                ConstraintKind.INVARIANT, "self.");
        
            assertChoice(choices, ChoiceKind.OPERATION, "reversed");
            
            OCLExpression<EClassifier> expr = helper.createQuery(
                "self.reversed()");
            
            assertEquals(
                "ablE was i ere I saw elbA",
                ocl.evaluate("Able was I ere i saw Elba", expr));
            
            // verify that TypeUtil produces the correct result
            assertTrue(TypeUtil.getOperations(ocl.getEnvironment(), ocl.getEnvironment().getOCLStandardLibrary().getString())
                .contains(feature));
            assertTrue(TypeUtil.getOperations(ocl.getEnvironment(), EcorePackage.Literals.ESTRING)
                .contains(feature));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
        
        // now, make sure that this definition was local to the OCL that
        //   parsed it (that it is not shared via the standard library package)
        OCL localOCL = OCL.newInstance();
        OCL.Helper localHelper = localOCL.createOCLHelper();
        localHelper.setContext(ocl.getEnvironment().getOCLStandardLibrary().getString());
        
        try {
            Collection<Choice> choices = localHelper.getSyntaxHelp(
                ConstraintKind.INVARIANT, "self.");
        
            assertNotChoice(choices, ChoiceKind.OPERATION, "reversed");
            
            localHelper.createQuery("self.reversed()");
            
            fail("Should have failed to parse the undefined operation");
        } catch (ParserException e) {
            // success!
            System.out.println("Got the expected exception: " + e.getLocalizedMessage());
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
                "reverse : String = " +
                "Sequence{1..size()}->sortedBy(i | -i)->iterate(i; s : String = '' |" +
                " s.concat(self.substring(i, i)))");
        
            // the other representation of 'String'
            helper.setContext(EcorePackage.Literals.ESTRING);
        
            Collection<Choice> choices = helper.getSyntaxHelp(
                ConstraintKind.INVARIANT, "self.");
        
            assertChoice(choices, ChoiceKind.PROPERTY, "reverse");
            
            OCLExpression<EClassifier> expr = helper.createQuery(
                "self.reverse");
            
            assertEquals(
                "ablE was i ere I saw elbA",
                ocl.evaluate("Able was I ere i saw Elba", expr));
            
            // verify that TypeUtil produces the correct result
            assertTrue(TypeUtil.getAttributes(ocl.getEnvironment(), ocl.getEnvironment().getOCLStandardLibrary().getString())
                .contains(feature));
            assertTrue(TypeUtil.getAttributes(ocl.getEnvironment(), EcorePackage.Literals.ESTRING)
                .contains(feature));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
        
        // now, make sure that this definition was local to the OCL that
        //   parsed it (that it is not shared via the standard library package)
        OCL localOCL = OCL.newInstance();
        OCL.Helper localHelper = localOCL.createOCLHelper();
        localHelper.setContext(ocl.getEnvironment().getOCLStandardLibrary().getString());
        
        try {
            Collection<Choice> choices = localHelper.getSyntaxHelp(
                ConstraintKind.INVARIANT, "self.");
        
            assertNotChoice(choices, ChoiceKind.PROPERTY, "reverse");
            
            localHelper.createQuery("self.reverse");
            
            fail("Should have failed to parse the undefined attribute");
        } catch (ParserException e) {
            // success!
            System.out.println("Got the expected exception: " + e.getLocalizedMessage());
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
                "reversed() : String = " +
                "Sequence{1..size()}->sortedBy(i | -i)->iterate(i; s : String = '' |" +
                " s.concat(self.substring(i, i)))");
        
            // the other representation of 'String'
            helper.setContext(EcorePackage.Literals.ESTRING);
        
            Collection<Choice> choices = helper.getSyntaxHelp(
                ConstraintKind.INVARIANT, "self.");
        
            assertChoice(choices, ChoiceKind.OPERATION, "reversed");
            
            OCLExpression<EClassifier> expr = helper.createQuery(
                "self.reversed()");
            
            assertEquals(
                "ablE was i ere I saw elbA",
                ocl.evaluate("Able was I ere i saw Elba", expr));
            
            // verify that TypeUtil produces the correct result
            assertTrue(TypeUtil.getOperations(ocl.getEnvironment(), ocl.getEnvironment().getOCLStandardLibrary().getString())
                .contains(feature));
            assertTrue(TypeUtil.getOperations(ocl.getEnvironment(), EcorePackage.Literals.ESTRING)
                .contains(feature));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
        
        // now, make sure that this definition was local to the OCL that
        //   parsed it (that it is not shared via the standard library package)
        OCL localOCL = OCL.newInstance();
        OCL.Helper localHelper = localOCL.createOCLHelper();
        localHelper.setContext(ocl.getEnvironment().getOCLStandardLibrary().getString());
        
        try {
            Collection<Choice> choices = localHelper.getSyntaxHelp(
                ConstraintKind.INVARIANT, "self.");
        
            assertNotChoice(choices, ChoiceKind.OPERATION, "reversed");
            
            localHelper.createQuery("self.reversed()");
            
            fail("Should have failed to parse the undefined operation");
        } catch (ParserException e) {
            // success!
            System.out.println("Got the expected exception: " + e.getLocalizedMessage());
        }
    }
    
    /**
     * Tests that the {@link UMLReflection} API provides the correct owner of an
     * additional operation.
     */
    public void test_defExpression_operation_owner() {
        helper.setContext(fruit);
        
        try {
            EOperation o = helper.defineOperation(
                    "bestColor(c : Color) : Color = " +
                    "if self.color = Color::black then c else self.color endif");
            
            UMLReflection<?, EClassifier, ?, ?, ?, ?, ?, ?, ?, ?> uml =
                ocl.getEnvironment().getUMLReflection();
            
            // sanity check
            assertSame(fruit, uml.getOwningClassifier(fruit_ripen));
            
            // check the owner of the additional operation
            assertSame(fruit, uml.getOwningClassifier(o));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }
    
    /**
     * Tests that the {@link UMLReflection} API provides the correct owner of an
     * additional attribute.
     */
    public void test_defExpression_attribute_owner() {
        helper.setContext(fruit);
        
        try {
            EStructuralFeature p = helper.defineAttribute(
                    "isBlack : Boolean = " +
                    "color = Color::black");
            
            UMLReflection<?, EClassifier, ?, ?, ?, ?, ?, ?, ?, ?> uml =
                ocl.getEnvironment().getUMLReflection();
            
            // sanity check
            assertSame(fruit, uml.getOwningClassifier(fruit_color));
            
            // check the owner of the additional operation
            assertSame(fruit, uml.getOwningClassifier(p));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }
    
    /**
     * Tests that when we define additional operations on the <code>OclAny</code>
     * type, they can be invoked on user model types.
     */
    public void test_def_operation_OclAny_192892() {
        // define an operation on OclAny
        helper.setContext(getOCLStandardLibrary().getOclAny());
        
        try {
            helper.defineOperation("isBlack() : Boolean = true");
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
        
        // switch to context of a user model classifier
        helper.setContext(fruit);
        
        try {
            EObject instance = fruitFactory.create(apple);
            assertTrue(check(helper, instance, "self.isBlack()"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }
    
    /**
     * Tests that when we define additional attributes on the <code>OclAny</code>
     * type, they can be invoked on user model types.
     */
    public void test_def_attribute_OclAny_192892() {
        // define an operation on OclAny
        helper.setContext(getOCLStandardLibrary().getOclAny());
        
        try {
            helper.defineAttribute("isBlack : Boolean = true");
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
        
        // switch to context of a user model classifier
        helper.setContext(fruit);
        
        try {
            EObject instance = fruitFactory.create(apple);
            assertTrue(check(helper, instance, "self.isBlack"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }
	
	/**
	 * Tests def expression for an operations with multiple parameters of
	 * the same type.
	 */
	public void test_defExpression_operation_similarParams_238050() {
		helper.setContext(fruit);
		
		try {
			helper.defineOperation(
					"displayName(first : String, last : String) : String = " +
					"if self.color = Color::red then first else last endif");
			
			OCLExpression<EClassifier> expr = helper.createQuery(
					"self.displayName('Roger', 'Bacon')");
			
			EObject anApple = fruitFactory.create(apple);
			anApple.eSet(fruit_color, color_black);
			
			assertEquals("Bacon", ocl.evaluate(anApple, expr));
			
			anApple.eSet(fruit_color, color_red);
			
			assertEquals("Roger", ocl.evaluate(anApple, expr));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
		}
	}
}
