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
 * $Id: DefExpressionTest.java,v 1.10 2009/11/28 18:04:24 ewillink Exp $
 */

package org.eclipse.ocl.uml.tests;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.Choice;
import org.eclipse.ocl.helper.ChoiceKind;
import org.eclipse.ocl.helper.ConstraintKind;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.options.ParsingOptions;
import org.eclipse.ocl.types.SetType;
import org.eclipse.ocl.uml.OCL;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.State;

/**
 * Tests for def expressions (additional properties and operations).
 *
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class DefExpressionTest
	extends AbstractTestSuite {
	
	Resource instanceResource;
	Package instancePackage;
	
	/**
	 * Tests the parsing the def expression for an operation from raw text.
	 */
	public void test_defExpression_raw_operation() {
		try {
			OCLExpression<Classifier> expr = parseDef(
				"package ocltest context Fruit " +
				"def: bestColor(c : Color) : Color = " +
				"if self.color = Color::black then c else self.color endif" +
				" endpackage");
			
			Constraint constraint = (Constraint) expr.eContainer().eContainer();
			assertNotNull(constraint);
			
			assertEquals(UMLReflection.DEFINITION, getStereotype(constraint));
			
			assertSame(color, expr.getType());
			
			expr = parse(
					"package ocltest context Fruit " +
					"inv: bestColor(Color::red) = Color::red" +
					" endpackage");
			
			InstanceSpecification anApple = instantiate(instancePackage, apple);
			setValue(anApple, fruit_color, color_black);
			
			assertTrue(ocl.check(anApple, expr));
			
			setValue(anApple, fruit_color, color_green);
			
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
			
			InstanceSpecification anApple = instantiate(instancePackage, apple);
			setValue(anApple, fruit_color, color_black);
			
			assertTrue(ocl.check(anApple, expr));
			
			setValue(anApple, fruit_color, color_green);
			
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
			OCLExpression<Classifier> expr = parseDef(
				"package ocltest context Apple " +
				"def: fallen : Boolean = tree.oclIsUndefined()" +
				" endpackage");
			
			Constraint constraint = (Constraint) expr.eContainer().eContainer();
			assertNotNull(constraint);
			
			assertEquals(UMLReflection.DEFINITION, getStereotype(constraint));
			
			assertSame(getOCLStandardLibrary().getBoolean(), expr.getType());
			
			expr = parse(
					"package ocltest context Apple " +
					"inv: not fallen" +
					" endpackage");
			
			InstanceSpecification anApple = instantiate(instancePackage, apple);
			setValue(anApple, apple_tree, instantiate(instancePackage, tree));
			
			assertTrue(ocl.check(anApple, expr));
			
			setValue(anApple, apple_tree, null);
			
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
					"tree.oclIsUndefined()");
			
			Constraint expr = helper.createInvariant("not fallen");
			
			InstanceSpecification anApple = instantiate(instancePackage, apple);
			setValue(anApple, apple_tree, instantiate(instancePackage, tree));
			
			assertTrue(ocl.check(anApple, expr));
			
			setValue(anApple, apple_tree, null);
			
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
			OCLExpression<Classifier> expr = parseDef(
				"package ocltest context Apple " +
				"def: otherApples : Set(Apple) = Apple.allInstances()->excluding(self)" +
				" endpackage");
			
			Constraint constraint = (Constraint) expr.eContainer().eContainer();
			assertNotNull(constraint);
			
			assertEquals(UMLReflection.DEFINITION, getStereotype(constraint));
			
			assertTrue(expr.getType() instanceof SetType<?, ?>);
			assertSame(
					((org.eclipse.ocl.uml.SetType) expr.getType()).getElementType(),
					apple);
			
			expr = parse(
					"package ocltest context Apple " +
					"inv: self.otherApples" +
					" endpackage");
			
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
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
		}
	}
	
	public void test_defExpression_inheritance_operation() {
		helper.setContext(getMetaclass("Classifier"));
		
		try {
			helper.defineOperation(
					"oclAllParents() : Set(Classifier) = " +
					"self->closure(generalization.general)");
			
			OCLExpression<Classifier> expr = helper.createQuery("self.oclAllParents()");
			
			Object oclAllParents = ocl.evaluate(apple, expr);
			assertTrue(oclAllParents instanceof Set<?>);
			assertTrue(((Set<?>) oclAllParents).contains(fruit));
			
			oclAllParents = ocl.evaluate(color, expr);
			assertTrue(oclAllParents instanceof Set<?>);
			assertTrue(((Set<?>) oclAllParents).isEmpty());
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
		}
	}
	
	public void test_defExpression_inheritance_attribute() {
		helper.setContext(getMetaclass("Classifier"));
		
		try {
			helper.defineAttribute(
					"oclAllParents : Set(Classifier) = " +
					"self->closure(generalization.general)");
			
			OCLExpression<Classifier> expr = helper.createQuery("self.oclAllParents");
			
			Object oclAllParents = ocl.evaluate(apple, expr);
			assertTrue(oclAllParents instanceof Set<?>);
			assertTrue(((Set<?>) oclAllParents).contains(fruit));
			
			oclAllParents = ocl.evaluate(color, expr);
			assertTrue(oclAllParents instanceof Set<?>);
			assertTrue(((Set<?>) oclAllParents).isEmpty());
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Tests the parsing the def expression for static attributes and operations.
	 */
	public void test_defExpression_static() {
		try {
			Environment<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint, Class, EObject> env = ocl.getEnvironment();
			UMLReflection<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint> umlReflection = env.getUMLReflection();

			ParsingOptions.setOption(ocl.getEnvironment(), ParsingOptions.SUPPORT_STATIC_FEATURES, true);
			parseDef("package ocltest context Fruit " +
				"def: bestColor1() : Color = null " +
				"static def: bestColor2() : Color = null " +
				"def: goodColor1 : Color = null " +
				"static def: goodColor2 : Color = null " +
				"endpackage");			
			Operation operation1 = env.lookupOperation(fruit, "bestColor1", null);
			assertNotNull(operation1);
			assertEquals(false, umlReflection.isStatic(operation1));
			Operation operation2 = env.lookupOperation(fruit, "bestColor2", null);			
			assertNotNull(operation2);
			assertEquals(true, umlReflection.isStatic(operation2));
			Property property1 = env.lookupProperty(fruit, "goodColor1");			
			assertNotNull(property1);
			assertEquals(false, umlReflection.isStatic(property1));
			Property property2 = env.lookupProperty(fruit, "goodColor2");			
			assertNotNull(property2);
			assertEquals(true, umlReflection.isStatic(property2));
			
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
		helper.setContext(getMetaclass("Classifier"));
		
		try {
			// non-conformant expression type
			helper.defineAttribute(
				"oclAllParents : Set(Classifier) = " +
				"self.name");
			
			fail("Should not have parsed");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		
		try {
			// missing type declaration
			helper.defineAttribute(
				"myName = " +
				"self.name");
			
			fail("Should not have parsed");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
	}
	
	public void test_malformedDefExpression_operation() {
		helper.setContext(getMetaclass("Classifier"));
		
		try {
			// non-conformant expression type
			helper.defineOperation(
				"oclAllParents() : Set(Classifier) = " +
				"self.name");
			
			fail("Should not have parsed");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		
		try {
			// missing type declaration
			helper.defineOperation(
				"bestName(s : String) = " +
				"if self.oclIsKindOf(Class) then self.name else s endif");
			
			fail("Should not have parsed");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		
		try {
			// missing type declaration in parameter
			helper.defineOperation(
				"bestName(s) : String = " +
				"if self.oclIsKindOf(Class) then self.name else s endif");
			
			fail("Should not have parsed");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
	}
	
	public void test_duplicateDefinition_attribute() {
		helper.setContext(getMetaclass("Classifier"));
		
		try {
			// same name and type as existing property
			helper.defineAttribute(
				"name : String = " +
				"if self.oclIsKindOf(Class) then 'foo' else '' endif");
			
			fail("Should not have parsed");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		
		try {
			// same name but different type
			helper.defineAttribute(
				"generalization : Set(String) = " +
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
				"if s.oclIsUndefined() then 'foo' else s endif");
			
			fail("Should not have parsed");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		
		try {
			// same signature as existing operation (note different return type)
			helper.defineOperation(
				"preferredLabel(s : String) : Integer = " +
				"if s.oclIsUndefined() then 0 else s.size() endif");
			
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
		helper.setContext(getMetaclass("Classifier"));
		
		Property property = null;
		
		try {
			// define some additional property
			property = helper.defineAttribute(
				"other : Classifier = " +
				"if general->notEmpty() then general->asSequence()->first() else null endif");
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
					"other : Classifier = " +
					"if general->notEmpty() then general->asSequence()->first() else null endif");
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage());
		}
	}
	
	public void test_undefine_operation_152018() {
		helper.setContext(getMetaclass("Classifier"));
		
		Operation operation = null;
		
		try {
			// define some additional property
			operation = helper.defineOperation(
				"other(x : Integer) : Classifier = " +
				"if general->size() >= x then general->asSequence()->at(x) else null endif");
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
					"other(x : Integer) : Classifier = " +
					"if general->size() >= x then general->asSequence()->at(x) else null endif");
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage());
		}
	}
	
	public void test_recursive_property_152018() {
		helper.setContext(getMetaclass("Classifier"));
		
		Property property = null;
		
		try {
			// first, attempt a definition with an invalid body
			property = helper.defineAttribute(
					"friend : Classifier = " +
					"if general->notEmpty() then getNearestPackage() else self endif");
			
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
				"friend : Classifier = " +
				"if general->notEmpty() then general->asSequence()->first().friend else self endif");
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
		helper.setContext(getMetaclass("Classifier"));
		
		Operation operation = null;
		
		try {
			// first, attempt a definition with an invalid body
			operation = helper.defineOperation(
					"friend(x : Integer) : Classifier = " +
					"if general->size() >= x then getNearestPackage() else self endif");
			
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
				"friend(x : Integer) : Classifier = " +
				"if general->size() >= x then general->asSequence()->at(x).friend(x) else self endif");
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
		helper.setContext(getMetaclass("Classifier"));
		
		try {
			helper.defineOperation(
					"oclAllParents() : Set(Classifier) = " +
					"self->closure(generalization.general)");
			
			Collection<Choice> choices = helper.getSyntaxHelp(
					ConstraintKind.INVARIANT, "self.");
			
			assertChoice(choices, ChoiceKind.OPERATION, "oclAllParents");
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
		}
	}
	
	public void test_defExpression_completion_attribute() {
		helper.setContext(getMetaclass("Classifier"));
		
		try {
			helper.defineAttribute(
					"oclAllParents : Set(Classifier) = " +
					"self->closure(generalization.general)");
			
			Collection<Choice> choices = helper.getSyntaxHelp(
					ConstraintKind.INVARIANT, "self.");
			
			assertChoice(choices, ChoiceKind.PROPERTY, "oclAllParents");
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
		}
	}
    
    /**
     * Tests the definition of additional attributes on the metamodel's
     * representation of a primitive type for which OCL has a counterpart.
     */
    public void test_defAttributeOnPrimitiveType_172782() {
        // context is the UML String primitive type
        helper.setContext(getUMLString());
        
        try {
            Property feature = helper.defineAttribute(
                "reverse : String = " +
                "Sequence{1..size()}->sortedBy(i | -i)->iterate(i; s : String = '' |" +
                " s.concat(self.substring(i, i)))");
            
            // the other representation of 'String'
            helper.setContext(ocl.getEnvironment().getOCLStandardLibrary().getString());
        
            Collection<Choice> choices = helper.getSyntaxHelp(
                ConstraintKind.INVARIANT, "self.");
        
            assertChoice(choices, ChoiceKind.PROPERTY, "reverse");
            
            OCLExpression<Classifier> expr = helper.createQuery(
                "self.reverse");
            
            assertEquals(
                "ablE was i ere I saw elbA",
                ocl.evaluate("Able was I ere i saw Elba", expr));
            
            // verify that TypeUtil produces the correct result
            assertTrue(TypeUtil.getAttributes(ocl.getEnvironment(), ocl.getEnvironment().getOCLStandardLibrary().getString())
                .contains(feature));
            assertTrue(TypeUtil.getAttributes(ocl.getEnvironment(), getUMLString())
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
        // context is the UML String primitive type
        helper.setContext(getUMLString());
        
        try {
            Operation feature = helper.defineOperation(
                "reversed() : String = " +
                "Sequence{1..size()}->sortedBy(i | -i)->iterate(i; s : String = '' |" +
                " s.concat(self.substring(i, i)))");
        
            // the other representation of 'String'
            helper.setContext(ocl.getEnvironment().getOCLStandardLibrary().getString());
            
            Collection<Choice> choices = helper.getSyntaxHelp(
                ConstraintKind.INVARIANT, "self.");
        
            assertChoice(choices, ChoiceKind.OPERATION, "reversed");
            
            OCLExpression<Classifier> expr = helper.createQuery(
                "self.reversed()");
            
            assertEquals(
                "ablE was i ere I saw elbA",
                ocl.evaluate("Able was I ere i saw Elba", expr));
            
            // verify that TypeUtil produces the correct result
            assertTrue(TypeUtil.getOperations(ocl.getEnvironment(), ocl.getEnvironment().getOCLStandardLibrary().getString())
                .contains(feature));
            assertTrue(TypeUtil.getOperations(ocl.getEnvironment(), getUMLString())
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
            Property feature = helper.defineAttribute(
                "reverse : String = " +
                "Sequence{1..size()}->sortedBy(i | -i)->iterate(i; s : String = '' |" +
                " s.concat(self.substring(i, i)))");
        
            // the other representation of 'String'
            helper.setContext(getUMLString());
            
            Collection<Choice> choices = helper.getSyntaxHelp(
                ConstraintKind.INVARIANT, "self.");
        
            assertChoice(choices, ChoiceKind.PROPERTY, "reverse");
            
            OCLExpression<Classifier> expr = helper.createQuery(
                "self.reverse");
            
            assertEquals(
                "ablE was i ere I saw elbA",
                ocl.evaluate("Able was I ere i saw Elba", expr));
            
            // verify that TypeUtil produces the correct result
            assertTrue(TypeUtil.getAttributes(ocl.getEnvironment(), ocl.getEnvironment().getOCLStandardLibrary().getString())
                .contains(feature));
            assertTrue(TypeUtil.getAttributes(ocl.getEnvironment(), getUMLString())
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
     * Tests the definition of additional attributes on an OCL pre-defined type.
     */
    public void test_defOperationOnPredefinedType_172782() {
        // context is the predefined OCL String type
        helper.setContext(ocl.getEnvironment().getOCLStandardLibrary().getString());
        
        try {
            Operation feature = helper.defineOperation(
                "reversed() : String = " +
                "Sequence{1..size()}->sortedBy(i | -i)->iterate(i; s : String = '' |" +
                " s.concat(self.substring(i, i)))");
        
            // the other representation of 'String'
            helper.setContext(getUMLString());
            
            Collection<Choice> choices = helper.getSyntaxHelp(
                ConstraintKind.INVARIANT, "self.");
        
            assertChoice(choices, ChoiceKind.OPERATION, "reversed");
            
            OCLExpression<Classifier> expr = helper.createQuery(
                "self.reversed()");
            
            assertEquals(
                "ablE was i ere I saw elbA",
                ocl.evaluate("Able was I ere i saw Elba", expr));
            
            // verify that TypeUtil produces the correct result
            assertTrue(TypeUtil.getOperations(ocl.getEnvironment(), ocl.getEnvironment().getOCLStandardLibrary().getString())
                .contains(feature));
            assertTrue(TypeUtil.getOperations(ocl.getEnvironment(), getUMLString())
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
            Operation o = helper.defineOperation(
                    "bestColor(c : Color) : Color = " +
                    "if self.color = Color::black then c else self.color endif");
            
            UMLReflection<?, Classifier, ?, ?, ?, ?, ?, ?, ?, ?> uml =
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
        helper.setContext(apple);
        
        try {
            Property p = helper.defineAttribute(
                    "fallen : Boolean = " +
                    "tree.oclIsUndefined()");
            
            UMLReflection<?, Classifier, ?, ?, ?, ?, ?, ?, ?, ?> uml =
                ocl.getEnvironment().getUMLReflection();
            
            // sanity check
            assertSame(apple, uml.getOwningClassifier(apple_label));
            
            // check the owner of the additional operation
            assertSame(apple, uml.getOwningClassifier(p));
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
            InstanceSpecification anApple = instantiate(instancePackage, apple);
            assertTrue(check(helper, anApple, "self.isBlack()"));
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
            InstanceSpecification anApple = instantiate(instancePackage, apple);
            assertTrue(check(helper, anApple, "self.isBlack"));
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
			
			OCLExpression<Classifier> expr = helper.createQuery(
					"self.displayName('Roger', 'Bacon')");
			
			InstanceSpecification anApple = instantiate(instancePackage, apple);
			setValue(anApple, fruit_color, color_black);
			
			assertEquals("Bacon", ocl.evaluate(anApple, expr));
			
			setValue(anApple, fruit_color, color_red);
			
			assertEquals("Roger", ocl.evaluate(anApple, expr));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
		}
	}
	
	//
	// Test framework
	//
	
	@Override
	protected void setUp() {
		super.setUp();
		
		instanceResource = resourceSet.createResource(
				URI.createFileURI("/tmp/instances.uml"));
		
		instancePackage = umlf.createPackage();
		instancePackage.setName("instances");
		instanceResource.getContents().add(instancePackage);
	}
}
