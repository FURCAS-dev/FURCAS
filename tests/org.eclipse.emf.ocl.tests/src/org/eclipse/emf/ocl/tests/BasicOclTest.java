/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
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
 * $Id$
 */

package org.eclipse.emf.ocl.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;

import org.eclipse.emf.ocl.expressions.OclExpression;

/**
 * Basic tests for OCL engine.
 *
 * @author Chris McGee (cbmcgee)
 * @author Christian W. Damus (cwdamus)
 */
public class BasicOclTest
	extends AbstractTestSuite {

	public BasicOclTest(String name) {
		super(name);
	}
	
	public static Test suite() {
		return new TestSuite(BasicOclTest.class, "Basic Tests"); //$NON-NLS-1$
	}
	
	public void testTrivialOclExpressions() {
		OclExpression constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: true " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		Object result = evaluate(constraint);
		assertEquals(Boolean.TRUE, result);
		
		constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: false " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(constraint);
		assertEquals(Boolean.FALSE, result);
	}
	
	public void testLogicalConnectives() {
		OclExpression constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: true and true " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		Object result = evaluate(constraint);
		assertEquals(Boolean.TRUE, result);
		
		constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: false or false " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(constraint);
		assertEquals(Boolean.FALSE, result);
		
		constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: true and false " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(constraint);
		assertEquals(Boolean.FALSE, result);
		
		constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: true or false " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(constraint);
		assertEquals(Boolean.TRUE, result);
		
		constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: not true " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(constraint);
		assertEquals(Boolean.FALSE, result);
		
		constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: true implies true " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(constraint);
		assertEquals(Boolean.TRUE, result);
		
		constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: true implies false " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(constraint);
		assertEquals(Boolean.FALSE, result);
		
		constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: false implies true " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(constraint);
		assertEquals(Boolean.TRUE, result);
		
		constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: false implies false " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(constraint);
		assertEquals(Boolean.TRUE, result);
	}
	
	public void testSimpleAttributeExpressions() {
		EClass eCls = EcoreFactory.eINSTANCE.createEClass();
		eCls.setName("bar"); //$NON-NLS-1$
		
		OclExpression constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: self.name <> 'foo' " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		assertTrue(check(constraint, eCls));
		
		eCls.setName("foo"); //$NON-NLS-1$
		assertFalse(check(constraint, eCls));
	}
	
	public void testCollectionOclExpressions() {
		EClass eCls = EcoreFactory.eINSTANCE.createEClass();
		eCls.setName("bar"); //$NON-NLS-1$
		
		EAttribute eAttr = EcoreFactory.eINSTANCE.createEAttribute();
		eAttr.setName("att1"); //$NON-NLS-1$
		eCls.getEAttributes().add(eAttr);
		eAttr = EcoreFactory.eINSTANCE.createEAttribute();
		eAttr.setName("att2"); //$NON-NLS-1$
		eCls.getEAttributes().add(eAttr);
		
		assertEquals(eCls.getEAttributes().size(),2);
		
		OclExpression constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: self.eAttributes->size() = 2 " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		assertTrue(check(constraint, eCls));
		
		constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: self.eAttributes->forAll(a: EAttribute | not a.derived) " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		assertTrue(check(constraint, eCls));
	}
	
	public void testNonBooleanOclExpressions() {
		EClass eCls = EcoreFactory.eINSTANCE.createEClass();
		eCls.setName("bar"); //$NON-NLS-1$
		
		OclExpression expr = parse(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: self.name " + //$NON-NLS-1$
			"endpackage "); //$NON-NLS-1$
		
		Object result = evaluate(expr, eCls);
		assertEquals("bar", result); //$NON-NLS-1$
		
		expr = parse(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: self " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(expr, eCls);
		assertSame(eCls, result);
	}
	
	public void testIfExpressions() {
		EClass eCls = EcoreFactory.eINSTANCE.createEClass();
		eCls.setName("bar"); //$NON-NLS-1$
		
		OclExpression expr = parse(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: if self.abstract then name = 'bar' else name <> 'bar' endif " + //$NON-NLS-1$
			"endpackage "); //$NON-NLS-1$
		
		assertFalse(check(expr, eCls));
		
		eCls.setAbstract(true);
		
		assertTrue(check(expr, eCls));
		
		eCls.setName("foo"); //$NON-NLS-1$
		
		assertFalse(check(expr, eCls));
	}
	
	public void testLetExpressions() {
		EClass eCls = EcoreFactory.eINSTANCE.createEClass();
		eCls.setName("foo"); //$NON-NLS-1$
		
		OclExpression expr = parse(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: let feats : OrderedSet(EStructuralFeature) = self.eAllStructuralFeatures in " + //$NON-NLS-1$
			"  feats->isEmpty() implies name <> 'bar' " + //$NON-NLS-1$
			"endpackage "); //$NON-NLS-1$
		
		assertTrue(check(expr, eCls));
		
		eCls.setName("bar"); //$NON-NLS-1$
		
		assertFalse(check(expr, eCls));
		
		eCls.getEStructuralFeatures().add(EcoreFactory.eINSTANCE.createEAttribute());
		
		assertTrue(check(expr, eCls));
		
		eCls.setName("foo"); //$NON-NLS-1$
		
		assertTrue(check(expr, eCls));
	}
	
	/**
	 * Tests the support for data types as context classifiers, rather than
	 * EClasses.  The parser now supports arbitrary EClassifiers.
	 */
	public void test_dataTypeAsContext() {
		OclExpression expr = parse(
			"package ecore context EString " + //$NON-NLS-1$
			"inv: self.toUpper() <> self.toLower() " + //$NON-NLS-1$
			"endpackage "); //$NON-NLS-1$
		
		assertTrue(check(expr, "anything")); //$NON-NLS-1$
		assertTrue(check(expr, "ANYTHING")); //$NON-NLS-1$
		
		expr = parse(
			"package ecore context EString " + //$NON-NLS-1$
			"inv: self.toUpper() " + //$NON-NLS-1$
			"endpackage "); //$NON-NLS-1$
		
		assertEquals("ANYTHING", evaluate(expr, "anything")); //$NON-NLS-1$ //$NON-NLS-2$
	}
}
