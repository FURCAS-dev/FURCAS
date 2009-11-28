/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2008 IBM Corporation and others.
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
 * $Id: BasicOCLTest.java,v 1.9 2009/11/28 18:16:27 ewillink Exp $
 */

package org.eclipse.ocl.uml.tests;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.VisibilityKind;

/**
 * Basic tests for OCL engine.
 *
 * @author Chris McGee (cbmcgee)
 * @author Christian W. Damus (cwdamus)
 */
@SuppressWarnings("nls")
public class BasicOCLTest
	extends AbstractTestSuite {
    
    public void hide_test_createStandardLibrary() {
        Resource res = ocl.getEnvironment().getOCLStandardLibrary().getOclAny().eResource();
        URI oldURI = res.getURI();
        
        res.setURI(URI.createFileURI("c:/temp/oclstdlib.uml"));
        try {
            res.save(Collections.EMPTY_MAP);
        } catch (IOException e) {
            fail(e.getLocalizedMessage());
        } finally {
            // restore the correct URI
            res.setURI(oldURI);
        }
    }
    
    /**
     * Tests that the results of the <tt>oclOperations()</tt> and <tt>oclIterators()</tt>
     * methods are the same regardless of which is invoked first.
     */
    public void test_collectionsAndIteratorsAccess_222747() {
        CollectionType<Classifier, Operation> type = ocl.getEnvironment().getOCLFactory().createSetType(
                ocl.getEnvironment().getOCLStandardLibrary().getOclInvalid());
        
        Set<Operation> iterators = new java.util.HashSet<Operation>(type.oclIterators());
        Set<Operation> operations = new java.util.HashSet<Operation>(type.oclOperations());
        
        // compute the set difference
        Set<Operation> difference = new java.util.HashSet<Operation>(operations);
        difference.removeAll(iterators);
        
        assertEquals(difference.size(), operations.size());
        assertTrue(operations.size() > 0);
        assertTrue(iterators.size() > 0);
    }
	
	public void testTrivialExpressions() {
		OCLExpression<Classifier> constraint = parseConstraint(
			"package uml context Class " +
			"inv: true " +
			"endpackage");
		
		Object result = evaluate(constraint);
		assertEquals(Boolean.TRUE, result);
		
		constraint = parseConstraint(
			"package uml context Class " +
			"inv: false " +
			"endpackage");
		
		result = evaluate(constraint);
		assertEquals(Boolean.FALSE, result);
	}
	
	public void testLogicalConnectives() {
		OCLExpression<Classifier> constraint = parseConstraint(
			"package uml context Class " +
			"inv: true and true " +
			"endpackage");
		
		Object result = evaluate(constraint);
		assertEquals(Boolean.TRUE, result);
		
		constraint = parseConstraint(
			"package uml context Class " +
			"inv: false or false " +
			"endpackage");
		
		result = evaluate(constraint);
		assertEquals(Boolean.FALSE, result);
		
		constraint = parseConstraint(
			"package uml context Class " +
			"inv: true and false " +
			"endpackage");
		
		result = evaluate(constraint);
		assertEquals(Boolean.FALSE, result);
		
		constraint = parseConstraint(
			"package uml context Class " +
			"inv: true or false " +
			"endpackage");
		
		result = evaluate(constraint);
		assertEquals(Boolean.TRUE, result);
		
		constraint = parseConstraint(
			"package uml context Class " +
			"inv: not true " +
			"endpackage");
		
		result = evaluate(constraint);
		assertEquals(Boolean.FALSE, result);
		
		constraint = parseConstraint(
			"package uml context Class " +
			"inv: true implies true " +
			"endpackage");
		
		result = evaluate(constraint);
		assertEquals(Boolean.TRUE, result);
		
		constraint = parseConstraint(
			"package uml context Class " +
			"inv: true implies false " +
			"endpackage");
		
		result = evaluate(constraint);
		assertEquals(Boolean.FALSE, result);
		
		constraint = parseConstraint(
			"package uml context Class " +
			"inv: false implies true " +
			"endpackage");
		
		result = evaluate(constraint);
		assertEquals(Boolean.TRUE, result);
		
		constraint = parseConstraint(
			"package uml context Class " +
			"inv: false implies false " +
			"endpackage");
		
		result = evaluate(constraint);
		assertEquals(Boolean.TRUE, result);
	}
	
	public void testSimpleAttributeExpressions() {
		Class eCls = umlf.createClass();
		eCls.setName("bar");
		
		OCLExpression<Classifier> constraint = parseConstraint(
			"package uml context Class " +
			"inv: self.name <> 'foo' " +
			"endpackage");
		
		assertTrue(check(constraint, eCls));
		
		eCls.setName("foo");
		assertFalse(check(constraint, eCls));
	}
	
	public void testCollectionExpressions() {
		DataType eCls = umlf.createDataType();
		eCls.setName("bar");
		
		eCls.createOwnedAttribute("att1", null);
		eCls.createOwnedAttribute("att2", null);
		
		assertEquals(eCls.getOwnedAttributes().size(),2);
		
		OCLExpression<Classifier> constraint = parseConstraint(
			"package uml context DataType " +
			"inv: self.ownedAttribute->size() = 2 " +
			"endpackage");
		
		assertTrue(check(constraint, eCls));
		
		constraint = parseConstraint(
			"package uml context DataType " +
			"inv: self.ownedAttribute->forAll(a: Property | not a.isDerived) " +
			"endpackage");
		
		assertTrue(check(constraint, eCls));
	}
	
	public void testNonBooleansExpressions() {
		Enumeration eCls = umlf.createEnumeration();
		eCls.setName("bar");
		
		OCLExpression<Classifier> expr = parse(
			"package uml context Enumeration " +
			"inv: self.name " +
			"endpackage ");
		
		Object result = evaluate(expr, eCls);
		assertEquals("bar", result);
		
		expr = parse(
			"package uml context Enumeration " +
			"inv: self " +
			"endpackage");
		
		result = evaluate(expr, eCls);
		assertSame(eCls, result);
	}
	
	public void testIfExpressions() {
		Class eCls = umlf.createClass();
		eCls.setName("bar");
		
		OCLExpression<Classifier> expr = parse(
			"package uml context Class " +
			"inv: if self.isAbstract then name = 'bar' else name <> 'bar' endif " +
			"endpackage ");
		
		assertFalse(check(expr, eCls));
		
		eCls.setIsAbstract(true);
		
		assertTrue(check(expr, eCls));
		
		eCls.setName("foo");
		
		assertFalse(check(expr, eCls));
	}
	
	public void testLetExpressions() {
		DataType eCls = umlf.createDataType();
		eCls.setName("foo");
		
		OCLExpression<Classifier> expr = parse(
			"package uml context DataType " +
			"inv: let feats : OrderedSet(Property) = self.ownedAttribute in " +
			"  feats->isEmpty() implies name <> 'bar' " +
			"endpackage ");
		
		assertTrue(check(expr, eCls));
		
		eCls.setName("bar");
		
		assertFalse(check(expr, eCls));
		
		eCls.createOwnedAttribute("att1", null);
		
		assertTrue(check(expr, eCls));
		
		eCls.setName("foo");
		
		assertTrue(check(expr, eCls));
	}
	
	/**
	 * Tests the support for data types as context classifiers, rather than
	 * EClasses.  The parser now supports arbitrary EClassifiers.
	 */
	public void test_dataTypeAsContext() {
		OCLExpression<Classifier> expr = parse(
			"package UMLPrimitiveTypes context \"String\" " +
			"inv: self.toUpper() <> self.toLower() " +
			"endpackage ");
		
		assertTrue(check(expr, "anything"));
		assertTrue(check(expr, "ANYTHING"));
		
		expr = parse(
			"package UMLPrimitiveTypes context \"String\" " +
			"inv: self.toUpper() " +
			"endpackage ");
		
		assertEquals("ANYTHING", evaluate(expr, "anything"));
	}
	
	/**
	 * Tests the overrides for equality of primitive values.  In OCL, reals
	 * can equal integers, but not in Java.
	 */
	public void test_equals_primitives() {
		assertTrue(check("1 = 1"));
		assertTrue(check("1 = 1.0"));
		assertTrue(check("1.0 = 1"));
		assertTrue(check("1.0 = 1.0"));
		
		assertTrue(check("'foo' = 'foo'"));
		
		assertTrue(check("ocltest::Color::red = ocltest::Color::red"));
		assertFalse(check("ocltest::Color::red = ocltest::Color::black"));
	}
    
    public void test_evaluationEnvironment_getType_178901() {
        EvaluationEnvironment<Classifier, Operation, Property, Class, EObject>
        evalEnv = ocl.getEvaluationEnvironment();
        
        assertSame(getMetaclass("Package"), evalEnv.getType(fruitPackage));
        assertSame(getMetaclass("Class"), evalEnv.getType(fruit));
        assertSame(getOCLStandardLibrary().getString(), evalEnv.getType("foo"));
        assertSame(getOCLStandardLibrary().getOclAny(), evalEnv.getType(this));
    }
    
    /**
     * Tests the OclAny::oclIsKindOf() operation.
     */
    public void test_oclIsKindOf() {
        helper.setContext(getMetaclass("Stereotype"));
        Stereotype stereo = umlf.createStereotype();
        
        try {
            assertTrue(check(helper, stereo, "self.oclIsKindOf(Class)"));
            assertTrue(check(helper, stereo, "self.oclIsKindOf(Stereotype)"));
            assertFalse(check(helper, stereo, "self.oclIsKindOf(Connector)"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }
    
    /**
     * Tests the OclAny::oclIsTypeOf() operation.
     */
    public void test_oclIsTypeOf_196264() {
        helper.setContext(getMetaclass("Stereotype"));
        Stereotype stereo = umlf.createStereotype();
        
        try {
            assertFalse(check(helper, stereo, "self.oclIsTypeOf(Class)"));
            assertTrue(check(helper, stereo, "self.oclIsTypeOf(Stereotype)"));
            assertFalse(check(helper, stereo, "self.oclIsTypeOf(Connector)"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }
    
    /**
     * Tests that the value of an enumeration literal expression is the Java
     * enumerated type instance, not the <tt>EnumerationLiteral</tt> model element.
     */
    public void test_enumerationLiteralValue_198945() {
    	helper.setContext(getMetaclass("VisibilityKind"));
        
        try {
            assertSame(VisibilityKind.PROTECTED_LITERAL,
                evaluate(helper, VisibilityKind.PUBLIC_LITERAL, "VisibilityKind::protected"));
        } catch (ParserException e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }
}
