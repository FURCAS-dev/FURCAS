/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2007 IBM Corporation and others.
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
 * $Id: BasicOCLTest.java,v 1.3 2007/03/22 21:59:21 cdamus Exp $
 */

package org.eclipse.ocl.uml.tests;

import java.io.IOException;
import java.util.Collections;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;

/**
 * Basic tests for OCL engine.
 *
 * @author Chris McGee (cbmcgee)
 * @author Christian W. Damus (cwdamus)
 */
public class BasicOCLTest
	extends AbstractTestSuite {

	public BasicOCLTest(String name) {
		super(name);
	}
	
	public static Test suite() {
		return new TestSuite(BasicOCLTest.class, "Basic Tests"); //$NON-NLS-1$
	}
    
    public void hide_test_createStandardLibrary() {
        Resource res = ocl.getEnvironment().getOCLStandardLibrary().getOclAny().eResource();
        URI oldURI = res.getURI();
        
        res.setURI(URI.createFileURI("c:/temp/oclstdlib.uml")); //$NON-NLS-1$
        try {
            res.save(Collections.EMPTY_MAP);
        } catch (IOException e) {
            fail(e.getLocalizedMessage());
        } finally {
            // restore the correct URI
            res.setURI(oldURI);
        }
    }
	
	public void testTrivialExpressions() {
		OCLExpression<Classifier> constraint = parseConstraint(
			"package uml context Class " + //$NON-NLS-1$
			"inv: true " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		Object result = evaluate(constraint);
		assertEquals(Boolean.TRUE, result);
		
		constraint = parseConstraint(
			"package uml context Class " + //$NON-NLS-1$
			"inv: false " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(constraint);
		assertEquals(Boolean.FALSE, result);
	}
	
	public void testLogicalConnectives() {
		OCLExpression<Classifier> constraint = parseConstraint(
			"package uml context Class " + //$NON-NLS-1$
			"inv: true and true " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		Object result = evaluate(constraint);
		assertEquals(Boolean.TRUE, result);
		
		constraint = parseConstraint(
			"package uml context Class " + //$NON-NLS-1$
			"inv: false or false " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(constraint);
		assertEquals(Boolean.FALSE, result);
		
		constraint = parseConstraint(
			"package uml context Class " + //$NON-NLS-1$
			"inv: true and false " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(constraint);
		assertEquals(Boolean.FALSE, result);
		
		constraint = parseConstraint(
			"package uml context Class " + //$NON-NLS-1$
			"inv: true or false " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(constraint);
		assertEquals(Boolean.TRUE, result);
		
		constraint = parseConstraint(
			"package uml context Class " + //$NON-NLS-1$
			"inv: not true " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(constraint);
		assertEquals(Boolean.FALSE, result);
		
		constraint = parseConstraint(
			"package uml context Class " + //$NON-NLS-1$
			"inv: true implies true " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(constraint);
		assertEquals(Boolean.TRUE, result);
		
		constraint = parseConstraint(
			"package uml context Class " + //$NON-NLS-1$
			"inv: true implies false " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(constraint);
		assertEquals(Boolean.FALSE, result);
		
		constraint = parseConstraint(
			"package uml context Class " + //$NON-NLS-1$
			"inv: false implies true " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(constraint);
		assertEquals(Boolean.TRUE, result);
		
		constraint = parseConstraint(
			"package uml context Class " + //$NON-NLS-1$
			"inv: false implies false " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(constraint);
		assertEquals(Boolean.TRUE, result);
	}
	
	public void testSimpleAttributeExpressions() {
		Class eCls = umlf.createClass();
		eCls.setName("bar"); //$NON-NLS-1$
		
		OCLExpression<Classifier> constraint = parseConstraint(
			"package uml context Class " + //$NON-NLS-1$
			"inv: self.name <> 'foo' " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		assertTrue(check(constraint, eCls));
		
		eCls.setName("foo"); //$NON-NLS-1$
		assertFalse(check(constraint, eCls));
	}
	
	public void testCollectionExpressions() {
		DataType eCls = umlf.createDataType();
		eCls.setName("bar"); //$NON-NLS-1$
		
		eCls.createOwnedAttribute("att1", null); //$NON-NLS-1$
		eCls.createOwnedAttribute("att2", null); //$NON-NLS-1$
		
		assertEquals(eCls.getOwnedAttributes().size(),2);
		
		OCLExpression<Classifier> constraint = parseConstraint(
			"package uml context DataType " + //$NON-NLS-1$
			"inv: self.ownedAttribute->size() = 2 " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		assertTrue(check(constraint, eCls));
		
		constraint = parseConstraint(
			"package uml context DataType " + //$NON-NLS-1$
			"inv: self.ownedAttribute->forAll(a: Property | not a.isDerived) " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		assertTrue(check(constraint, eCls));
	}
	
	public void testNonBooleansExpressions() {
		Enumeration eCls = umlf.createEnumeration();
		eCls.setName("bar"); //$NON-NLS-1$
		
		OCLExpression<Classifier> expr = parse(
			"package uml context Enumeration " + //$NON-NLS-1$
			"inv: self.name " + //$NON-NLS-1$
			"endpackage "); //$NON-NLS-1$
		
		Object result = evaluate(expr, eCls);
		assertEquals("bar", result); //$NON-NLS-1$
		
		expr = parse(
			"package uml context Enumeration " + //$NON-NLS-1$
			"inv: self " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(expr, eCls);
		assertSame(eCls, result);
	}
	
	public void testIfExpressions() {
		Class eCls = umlf.createClass();
		eCls.setName("bar"); //$NON-NLS-1$
		
		OCLExpression<Classifier> expr = parse(
			"package uml context Class " + //$NON-NLS-1$
			"inv: if self.isAbstract then name = 'bar' else name <> 'bar' endif " + //$NON-NLS-1$
			"endpackage "); //$NON-NLS-1$
		
		assertFalse(check(expr, eCls));
		
		eCls.setIsAbstract(true);
		
		assertTrue(check(expr, eCls));
		
		eCls.setName("foo"); //$NON-NLS-1$
		
		assertFalse(check(expr, eCls));
	}
	
	public void testLetExpressions() {
		DataType eCls = umlf.createDataType();
		eCls.setName("foo"); //$NON-NLS-1$
		
		OCLExpression<Classifier> expr = parse(
			"package uml context DataType " + //$NON-NLS-1$
			"inv: let feats : OrderedSet(Property) = self.ownedAttribute in " + //$NON-NLS-1$
			"  feats->isEmpty() implies name <> 'bar' " + //$NON-NLS-1$
			"endpackage "); //$NON-NLS-1$
		
		assertTrue(check(expr, eCls));
		
		eCls.setName("bar"); //$NON-NLS-1$
		
		assertFalse(check(expr, eCls));
		
		eCls.createOwnedAttribute("att1", null); //$NON-NLS-1$
		
		assertTrue(check(expr, eCls));
		
		eCls.setName("foo"); //$NON-NLS-1$
		
		assertTrue(check(expr, eCls));
	}
	
	/**
	 * Tests the support for data types as context classifiers, rather than
	 * EClasses.  The parser now supports arbitrary EClassifiers.
	 */
	public void test_dataTypeAsContext() {
		OCLExpression<Classifier> expr = parse(
			"package UMLPrimitiveTypes context \"String\" " + //$NON-NLS-1$
			"inv: self.toUpper() <> self.toLower() " + //$NON-NLS-1$
			"endpackage "); //$NON-NLS-1$
		
		assertTrue(check(expr, "anything")); //$NON-NLS-1$
		assertTrue(check(expr, "ANYTHING")); //$NON-NLS-1$
		
		expr = parse(
			"package UMLPrimitiveTypes context \"String\" " + //$NON-NLS-1$
			"inv: self.toUpper() " + //$NON-NLS-1$
			"endpackage "); //$NON-NLS-1$
		
		assertEquals("ANYTHING", evaluate(expr, "anything")); //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	/**
	 * Tests the overrides for equality of primitive values.  In OCL, reals
	 * can equal integers, but not in Java.
	 */
	public void test_equals_primitives() {
		assertTrue(check("1 = 1")); //$NON-NLS-1$
		assertTrue(check("1 = 1.0")); //$NON-NLS-1$
		assertTrue(check("1.0 = 1")); //$NON-NLS-1$
		assertTrue(check("1.0 = 1.0")); //$NON-NLS-1$
		
		assertTrue(check("'foo' = 'foo'")); //$NON-NLS-1$
		
		assertTrue(check("ocltest::Color::red = ocltest::Color::red")); //$NON-NLS-1$
		assertFalse(check("ocltest::Color::red = ocltest::Color::black")); //$NON-NLS-1$
	}
    
    public void test_evaluationEnvironment_getType_178901() {
        EvaluationEnvironment<Classifier, Operation, Property, Class, EObject>
        evalEnv = ocl.getEvaluationEnvironment();
        
        assertSame(getMetaclass("Package"), evalEnv.getType(fruitPackage)); //$NON-NLS-1$
        assertSame(getMetaclass("Class"), evalEnv.getType(fruit)); //$NON-NLS-1$
        assertSame(getOCLStandardLibrary().getString(), evalEnv.getType("foo")); //$NON-NLS-1$
        assertSame(getOCLStandardLibrary().getOclAny(), evalEnv.getType(this));
    }
}
