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
 * $Id: DefExpressionTest.java,v 1.7 2009/07/27 15:30:19 ewillink Exp $
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
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.Choice;
import org.eclipse.ocl.helper.ChoiceKind;
import org.eclipse.ocl.helper.ConstraintKind;
import org.eclipse.ocl.types.SetType;
import org.eclipse.ocl.uml.OCL;
import org.eclipse.ocl.util.TypeUtil;
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
@SuppressWarnings("nls")
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
			
			assertTrue(expr.getType() instanceof SetType<?, ?>);
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
			assertTrue(oclAllParents instanceof Set<?>);
			assertTrue(((Set<?>) oclAllParents).contains(fruit));
			
			oclAllParents = ocl.evaluate(color, expr);
			assertTrue(oclAllParents instanceof Set<?>);
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
			assertTrue(oclAllParents instanceof Set<?>);
			assertTrue(((Set<?>) oclAllParents).contains(fruit));
			
			oclAllParents = ocl.evaluate(color, expr);
			assertTrue(oclAllParents instanceof Set<?>);
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
    
    /**
     * Tests the definition of additional attributes on the metamodel's
     * representation of a primitive type for which OCL has a counterpart.
     */
    public void test_defAttributeOnPrimitiveType_172782() {
        // context is the UML String primitive type
        helper.setContext(getUMLString());
        
        try {
            Property feature = helper.defineAttribute(
                "reverse : String = " + //$NON-NLS-1$
                "Sequence{1..size()}->sortedBy(i | -i)->iterate(i; s : String = '' |" + //$NON-NLS-1$
                " s.concat(self.substring(i, i)))"); //$NON-NLS-1$
            
            // the other representation of 'String'
            helper.setContext(ocl.getEnvironment().getOCLStandardLibrary().getString());
        
            Collection<Choice> choices = helper.getSyntaxHelp(
                ConstraintKind.INVARIANT, "self."); //$NON-NLS-1$
        
            assertChoice(choices, ChoiceKind.PROPERTY, "reverse"); //$NON-NLS-1$
            
            OCLExpression<Classifier> expr = helper.createQuery(
                "self.reverse"); //$NON-NLS-1$
            
            assertEquals(
                "ablE was i ere I saw elbA", //$NON-NLS-1$
                ocl.evaluate("Able was I ere i saw Elba", expr)); //$NON-NLS-1$
            
            // verify that TypeUtil produces the correct result
            assertTrue(TypeUtil.getAttributes(ocl.getEnvironment(), ocl.getEnvironment().getOCLStandardLibrary().getString())
                .contains(feature));
            assertTrue(TypeUtil.getAttributes(ocl.getEnvironment(), getUMLString())
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
        // context is the UML String primitive type
        helper.setContext(getUMLString());
        
        try {
            Operation feature = helper.defineOperation(
                "reversed() : String = " + //$NON-NLS-1$
                "Sequence{1..size()}->sortedBy(i | -i)->iterate(i; s : String = '' |" + //$NON-NLS-1$
                " s.concat(self.substring(i, i)))"); //$NON-NLS-1$
        
            // the other representation of 'String'
            helper.setContext(ocl.getEnvironment().getOCLStandardLibrary().getString());
            
            Collection<Choice> choices = helper.getSyntaxHelp(
                ConstraintKind.INVARIANT, "self."); //$NON-NLS-1$
        
            assertChoice(choices, ChoiceKind.OPERATION, "reversed"); //$NON-NLS-1$
            
            OCLExpression<Classifier> expr = helper.createQuery(
                "self.reversed()"); //$NON-NLS-1$
            
            assertEquals(
                "ablE was i ere I saw elbA", //$NON-NLS-1$
                ocl.evaluate("Able was I ere i saw Elba", expr)); //$NON-NLS-1$
            
            // verify that TypeUtil produces the correct result
            assertTrue(TypeUtil.getOperations(ocl.getEnvironment(), ocl.getEnvironment().getOCLStandardLibrary().getString())
                .contains(feature));
            assertTrue(TypeUtil.getOperations(ocl.getEnvironment(), getUMLString())
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
            Property feature = helper.defineAttribute(
                "reverse : String = " + //$NON-NLS-1$
                "Sequence{1..size()}->sortedBy(i | -i)->iterate(i; s : String = '' |" + //$NON-NLS-1$
                " s.concat(self.substring(i, i)))"); //$NON-NLS-1$
        
            // the other representation of 'String'
            helper.setContext(getUMLString());
            
            Collection<Choice> choices = helper.getSyntaxHelp(
                ConstraintKind.INVARIANT, "self."); //$NON-NLS-1$
        
            assertChoice(choices, ChoiceKind.PROPERTY, "reverse"); //$NON-NLS-1$
            
            OCLExpression<Classifier> expr = helper.createQuery(
                "self.reverse"); //$NON-NLS-1$
            
            assertEquals(
                "ablE was i ere I saw elbA", //$NON-NLS-1$
                ocl.evaluate("Able was I ere i saw Elba", expr)); //$NON-NLS-1$
            
            // verify that TypeUtil produces the correct result
            assertTrue(TypeUtil.getAttributes(ocl.getEnvironment(), ocl.getEnvironment().getOCLStandardLibrary().getString())
                .contains(feature));
            assertTrue(TypeUtil.getAttributes(ocl.getEnvironment(), getUMLString())
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
     * Tests the definition of additional attributes on an OCL pre-defined type.
     */
    public void test_defOperationOnPredefinedType_172782() {
        // context is the predefined OCL String type
        helper.setContext(ocl.getEnvironment().getOCLStandardLibrary().getString());
        
        try {
            Operation feature = helper.defineOperation(
                "reversed() : String = " + //$NON-NLS-1$
                "Sequence{1..size()}->sortedBy(i | -i)->iterate(i; s : String = '' |" + //$NON-NLS-1$
                " s.concat(self.substring(i, i)))"); //$NON-NLS-1$
        
            // the other representation of 'String'
            helper.setContext(getUMLString());
            
            Collection<Choice> choices = helper.getSyntaxHelp(
                ConstraintKind.INVARIANT, "self."); //$NON-NLS-1$
        
            assertChoice(choices, ChoiceKind.OPERATION, "reversed"); //$NON-NLS-1$
            
            OCLExpression<Classifier> expr = helper.createQuery(
                "self.reversed()"); //$NON-NLS-1$
            
            assertEquals(
                "ablE was i ere I saw elbA", //$NON-NLS-1$
                ocl.evaluate("Able was I ere i saw Elba", expr)); //$NON-NLS-1$
            
            // verify that TypeUtil produces the correct result
            assertTrue(TypeUtil.getOperations(ocl.getEnvironment(), ocl.getEnvironment().getOCLStandardLibrary().getString())
                .contains(feature));
            assertTrue(TypeUtil.getOperations(ocl.getEnvironment(), getUMLString())
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
     * Tests that the {@link UMLReflection} API provides the correct owner of an
     * additional operation.
     */
    public void test_defExpression_operation_owner() {
        helper.setContext(fruit);
        
        try {
            Operation o = helper.defineOperation(
                    "bestColor(c : Color) : Color = " + //$NON-NLS-1$
                    "if self.color = Color::black then c else self.color endif"); //$NON-NLS-1$
            
            UMLReflection<?, Classifier, ?, ?, ?, ?, ?, ?, ?, ?> uml =
                ocl.getEnvironment().getUMLReflection();
            
            // sanity check
            assertSame(fruit, uml.getOwningClassifier(fruit_ripen));
            
            // check the owner of the additional operation
            assertSame(fruit, uml.getOwningClassifier(o));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
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
                    "fallen : Boolean = " + //$NON-NLS-1$
                    "tree.oclIsUndefined()"); //$NON-NLS-1$
            
            UMLReflection<?, Classifier, ?, ?, ?, ?, ?, ?, ?, ?> uml =
                ocl.getEnvironment().getUMLReflection();
            
            // sanity check
            assertSame(apple, uml.getOwningClassifier(apple_label));
            
            // check the owner of the additional operation
            assertSame(apple, uml.getOwningClassifier(p));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
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
            helper.defineOperation("isBlack() : Boolean = true"); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
        
        // switch to context of a user model classifier
        helper.setContext(fruit);
        
        try {
            InstanceSpecification anApple = instantiate(instancePackage, apple);
            assertTrue(check(helper, anApple, "self.isBlack()")); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
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
            helper.defineAttribute("isBlack : Boolean = true"); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
        
        // switch to context of a user model classifier
        helper.setContext(fruit);
        
        try {
            InstanceSpecification anApple = instantiate(instancePackage, apple);
            assertTrue(check(helper, anApple, "self.isBlack")); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
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
