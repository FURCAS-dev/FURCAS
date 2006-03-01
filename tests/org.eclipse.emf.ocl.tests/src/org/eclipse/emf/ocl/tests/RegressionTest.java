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

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.helper.HelperUtil;
import org.eclipse.emf.ocl.helper.IOCLHelper;
import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;
import org.eclipse.emf.ocl.types.BagType;
import org.eclipse.emf.ocl.types.CollectionType;
import org.eclipse.emf.ocl.types.OrderedSetType;
import org.eclipse.emf.ocl.types.SequenceType;
import org.eclipse.emf.ocl.types.SetType;
import org.eclipse.emf.ocl.types.TupleType;

/**
 * Regression tests for specific RATLC defects.
 *
 * @author Christian W. Damus (cdamus)
 */
public class RegressionTest
	extends AbstractTestSuite {

	public RegressionTest(String name) {
		super(name);
	}
	
	public static Test suite() {
		return new TestSuite(RegressionTest.class, "Regression Tests"); //$NON-NLS-1$
	}
	
	/**
	 * Tests the "..." escape syntax for reserved words.  Regression test for
	 * RATLC00527506.
	 */
	public void test_quoteReservedWords_RATLC00527506() {
		EPackage epackage = EcoreFactory.eINSTANCE.createEPackage();
		epackage.setName("MyPackage"); //$NON-NLS-1$
		epackage.setNsPrefix("mypkg"); //$NON-NLS-1$
		epackage.setNsURI("http:///mypkg.ecore"); //$NON-NLS-1$
		EPackage.Registry.INSTANCE.put(epackage.getNsURI(), epackage);
		
		EClass eclass = EcoreFactory.eINSTANCE.createEClass();
		eclass.setName("MyType"); //$NON-NLS-1$
		epackage.getEClassifiers().add(eclass);
		
		// "context" is an OCL reserved word
		EAttribute eattr = EcoreFactory.eINSTANCE.createEAttribute();
		eattr.setName("context"); //$NON-NLS-1$
		eattr.setEType(EcorePackage.eINSTANCE.getEString());
		eclass.getEStructuralFeatures().add(eattr);
		
		try {
			parseConstraint(
				"package mypkg context MyType " + //$NON-NLS-1$
				"inv: self.\"context\"->notEmpty() " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
		} finally {
			EPackage.Registry.INSTANCE.remove(epackage.getNsURI());
		}
	}
	
	/**
	 * Tests the "..." escape syntax for whitespace.  Regression test for
	 * RATLC00527509.
	 */
	public void test_quoteWhitespace_RATLC00527509() {
		EPackage epackage = EcoreFactory.eINSTANCE.createEPackage();
		epackage.setName("MyPackage"); //$NON-NLS-1$
		epackage.setNsPrefix("mypkg"); //$NON-NLS-1$
		epackage.setNsURI("http:///mypkg.ecore"); //$NON-NLS-1$
		EPackage.Registry.INSTANCE.put(epackage.getNsURI(), epackage);
		
		EClass eclass = EcoreFactory.eINSTANCE.createEClass();
		eclass.setName("MyType"); //$NON-NLS-1$
		epackage.getEClassifiers().add(eclass);
		
		EAttribute eattr = EcoreFactory.eINSTANCE.createEAttribute();
		eattr.setName("an attribute"); //$NON-NLS-1$
		eattr.setEType(EcorePackage.eINSTANCE.getEString());
		eclass.getEStructuralFeatures().add(eattr);
		
		try {
			parseConstraint(
				"package mypkg context MyType " + //$NON-NLS-1$
				"inv: self.\"an attribute\"->notEmpty() " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
		} finally {
			EPackage.Registry.INSTANCE.remove(epackage.getNsURI());
		}
	}
	
	/**
	 * Tests the \" escape syntax for double-quotes.  Regression test for
	 * RATLC00527509.
	 */
	public void test_quoteQuote_RATLC00527509() {
		EPackage epackage = EcoreFactory.eINSTANCE.createEPackage();
		epackage.setName("MyPackage"); //$NON-NLS-1$
		epackage.setNsPrefix("mypkg"); //$NON-NLS-1$
		epackage.setNsURI("http:///mypkg.ecore"); //$NON-NLS-1$
		EPackage.Registry.INSTANCE.put(epackage.getNsURI(), epackage);
		
		EClass eclass = EcoreFactory.eINSTANCE.createEClass();
		eclass.setName("MyType"); //$NON-NLS-1$
		epackage.getEClassifiers().add(eclass);
		
		EAttribute eattr = EcoreFactory.eINSTANCE.createEAttribute();
		eattr.setName("an\"attribute"); //$NON-NLS-1$
		eattr.setEType(EcorePackage.eINSTANCE.getEString());
		eclass.getEStructuralFeatures().add(eattr);
		
		try {
			// try first to parse within surrounding double-quotes
			parseConstraint(
				"package mypkg context MyType " + //$NON-NLS-1$
				"inv: self.\"an\\\"attribute\"->notEmpty() " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$

			AssertionFailedError err = null;
			
			try {
				// also try to parse without the surrounding double-quotes.
				//   This is not allowed
				parseConstraint(
					"package ecore context EClass " + //$NON-NLS-1$
					"inv: self.an\\\"attribute->notEmpty() " + //$NON-NLS-1$
					"endpackage"); //$NON-NLS-1$
			} catch (AssertionFailedError e) {
				// success
				err = e;
				System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
			}
			
			assertNotNull("Should not have parsed.", err); //$NON-NLS-1$
		} finally {
			EPackage.Registry.INSTANCE.remove(epackage.getNsURI());
		}
	}
	
	/**
	 * Tests the support for international characters.  Regression test for
	 * RATLC01080816.
	 */
	public void test_internationalCharacters_RATLC01080816() {
		EPackage epackage = EcoreFactory.eINSTANCE.createEPackage();
		epackage.setName("MyPackage"); //$NON-NLS-1$
		epackage.setNsPrefix("mypkg"); //$NON-NLS-1$
		epackage.setNsURI("http:///mypkg.ecore"); //$NON-NLS-1$
		EPackage.Registry.INSTANCE.put(epackage.getNsURI(), epackage);
		
		EClass eclass = EcoreFactory.eINSTANCE.createEClass();
		eclass.setName("MyType"); //$NON-NLS-1$
		epackage.getEClassifiers().add(eclass);
		
		EAttribute eattr = EcoreFactory.eINSTANCE.createEAttribute();
		// try some extended latin, cyrillic, and arabic
		eattr.setName("\u0160\u01d6\u0429\u0639"); //$NON-NLS-1$
		eattr.setEType(EcorePackage.eINSTANCE.getEString());
		eclass.getEStructuralFeatures().add(eattr);
		
		try {
			// try these characters in the attribute name and string literal
			parseConstraint(
				"package mypkg context MyType " + //$NON-NLS-1$
				"inv: self.\u0160\u01d6\u0429\u0639 <> '\u0160\u01d6\u0429\u0639' " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
		} finally {
			EPackage.Registry.INSTANCE.remove(epackage.getNsURI());
		}
	}
	
	/**
	 * Tests support for oclIsKindOf() and oclAsType() to cast between
	 * classifiers that are not related, but where their subtypes may be
	 * conformant.
	 */
	public void test_oclIsKindOf_RATLC01087664() {
		EPackage epackage = EcoreFactory.eINSTANCE.createEPackage();
		epackage.setName("MyPackage"); //$NON-NLS-1$
		epackage.setNsPrefix("mypkg"); //$NON-NLS-1$
		epackage.setNsURI("http:///mypkg.ecore"); //$NON-NLS-1$
		EPackage.Registry.INSTANCE.put(epackage.getNsURI(), epackage);
		
		// create three classes.  A and B are unrelated, but C extends
		//   both.  Therefore, it is possible to cast a variable of type
		//   A to type B where the run-time type is C
		EClass a = EcoreFactory.eINSTANCE.createEClass();
		a.setName("A"); //$NON-NLS-1$
		epackage.getEClassifiers().add(a);
		
		EClass b = EcoreFactory.eINSTANCE.createEClass();
		b.setName("B"); //$NON-NLS-1$
		epackage.getEClassifiers().add(b);
		
		EClass c = EcoreFactory.eINSTANCE.createEClass();
		c.setName("C"); //$NON-NLS-1$
		epackage.getEClassifiers().add(c);
		c.getESuperTypes().add(a);
		c.getESuperTypes().add(b);
		
		EAttribute attrA = EcoreFactory.eINSTANCE.createEAttribute();
		attrA.setName("a"); //$NON-NLS-1$
		attrA.setEType(EcorePackage.eINSTANCE.getEBoolean());
		a.getEStructuralFeatures().add(attrA);
		
		EAttribute attrB = EcoreFactory.eINSTANCE.createEAttribute();
		attrB.setName("b"); //$NON-NLS-1$
		attrB.setEType(EcorePackage.eINSTANCE.getEBoolean());
		b.getEStructuralFeatures().add(attrB);
		
		try {
			OCLExpression constraint = parseConstraint(
				"package mypkg context A " + //$NON-NLS-1$
				"inv: self.oclIsKindOf(B) implies (self.oclAsType(B).b <> self.a) " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
			
			EObject eobj = epackage.getEFactoryInstance().create(c);
			eobj.eSet(attrA, Boolean.TRUE);
			eobj.eSet(attrB, Boolean.TRUE);
			
			assertFalse("Should have failed the check", check(constraint, eobj)); //$NON-NLS-1$
			
			eobj.eSet(attrB, Boolean.FALSE);
			
			assertTrue("Should not have failed the check", check(constraint, eobj)); //$NON-NLS-1$
		} finally {
			EPackage.Registry.INSTANCE.remove(epackage.getNsURI());
		}
	}
	
	/**
	 * Tests support for short-circuiting AND operator.
	 */
	public void test_shortcircuitAnd_RATLC00536528() {
		EPackage epackage = EcoreFactory.eINSTANCE.createEPackage();
		epackage.setName("MyPackage"); //$NON-NLS-1$
		epackage.setNsPrefix("mypkg"); //$NON-NLS-1$
		epackage.setNsURI("http:///mypkg.ecore"); //$NON-NLS-1$
		EPackage.Registry.INSTANCE.put(epackage.getNsURI(), epackage);
		
		EClass a = EcoreFactory.eINSTANCE.createEClass();
		a.setName("A"); //$NON-NLS-1$
		epackage.getEClassifiers().add(a);
		
		EClass b = EcoreFactory.eINSTANCE.createEClass();
		b.setName("B"); //$NON-NLS-1$
		epackage.getEClassifiers().add(b);
		b.getESuperTypes().add(a);
		
		EAttribute attrA = EcoreFactory.eINSTANCE.createEAttribute();
		attrA.setName("a"); //$NON-NLS-1$
		attrA.setEType(EcorePackage.eINSTANCE.getEBoolean());
		a.getEStructuralFeatures().add(attrA);
		
		EAttribute attrB = EcoreFactory.eINSTANCE.createEAttribute();
		attrB.setName("b"); //$NON-NLS-1$
		attrB.setEType(EcorePackage.eINSTANCE.getEBoolean());
		b.getEStructuralFeatures().add(attrB);
		
		try {
			OCLExpression constraint = parseConstraint(
				"package mypkg context A " + //$NON-NLS-1$
				"inv: self.oclIsKindOf(B) and self.oclAsType(B).b " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
			
			// create an A
			EObject eobj = epackage.getEFactoryInstance().create(a);
			eobj.eSet(attrA, Boolean.TRUE);
			
			// this would fail with an NPE on the access to '.b' when
			//    'self.oclAsType(B)' evaluates to null, if we didn't short-circuit
			assertFalse("Should have failed the check", check(constraint, eobj)); //$NON-NLS-1$
			
			// create a B this time
			eobj = epackage.getEFactoryInstance().create(b);
			eobj.eSet(attrA, Boolean.TRUE);
			eobj.eSet(attrB, Boolean.TRUE);
			
			assertTrue("Should not have failed the check", check(constraint, eobj)); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		} finally {
			EPackage.Registry.INSTANCE.remove(epackage.getNsURI());
		}
	}
	
	/**
	 * Tests support for short-circuiting OR operator.
	 */
	public void test_shortcircuitOr_RATLC00536528() {
		EPackage epackage = EcoreFactory.eINSTANCE.createEPackage();
		epackage.setName("MyPackage"); //$NON-NLS-1$
		epackage.setNsPrefix("mypkg"); //$NON-NLS-1$
		epackage.setNsURI("http:///mypkg.ecore"); //$NON-NLS-1$
		EPackage.Registry.INSTANCE.put(epackage.getNsURI(), epackage);
		
		EClass a = EcoreFactory.eINSTANCE.createEClass();
		a.setName("A"); //$NON-NLS-1$
		epackage.getEClassifiers().add(a);
		
		EClass b = EcoreFactory.eINSTANCE.createEClass();
		b.setName("B"); //$NON-NLS-1$
		epackage.getEClassifiers().add(b);
		b.getESuperTypes().add(a);
		
		EAttribute attrA = EcoreFactory.eINSTANCE.createEAttribute();
		attrA.setName("a"); //$NON-NLS-1$
		attrA.setEType(EcorePackage.eINSTANCE.getEBoolean());
		a.getEStructuralFeatures().add(attrA);
		
		EAttribute attrB = EcoreFactory.eINSTANCE.createEAttribute();
		attrB.setName("b"); //$NON-NLS-1$
		attrB.setEType(EcorePackage.eINSTANCE.getEBoolean());
		b.getEStructuralFeatures().add(attrB);
		
		try {
			OCLExpression constraint = parseConstraint(
				"package mypkg context A " + //$NON-NLS-1$
				"inv: (not self.oclIsKindOf(B)) or self.oclAsType(B).b " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
			
			// create an A
			EObject eobj = epackage.getEFactoryInstance().create(a);
			eobj.eSet(attrA, Boolean.TRUE);
			
			// this would fail with an NPE on the access to '.b' when
			//    'self.oclAsType(B)' evaluates to null, if we didn't short-circuit
			assertTrue("Should not have failed the check", check(constraint, eobj)); //$NON-NLS-1$
			
			// create a B this time
			eobj = epackage.getEFactoryInstance().create(b);
			eobj.eSet(attrA, Boolean.TRUE);
			eobj.eSet(attrB, Boolean.TRUE);
			
			assertTrue("Should not have failed the check", check(constraint, eobj)); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		} finally {
			EPackage.Registry.INSTANCE.remove(epackage.getNsURI());
		}
	}
	
	/**
	 * Tests support for short-circuiting IMPLIES operator.
	 */
	public void test_shortcircuitImplies_RATLC00536528() {
		EPackage epackage = EcoreFactory.eINSTANCE.createEPackage();
		epackage.setName("MyPackage"); //$NON-NLS-1$
		epackage.setNsPrefix("mypkg"); //$NON-NLS-1$
		epackage.setNsURI("http:///mypkg.ecore"); //$NON-NLS-1$
		EPackage.Registry.INSTANCE.put(epackage.getNsURI(), epackage);
		
		EClass a = EcoreFactory.eINSTANCE.createEClass();
		a.setName("A"); //$NON-NLS-1$
		epackage.getEClassifiers().add(a);
		
		EClass b = EcoreFactory.eINSTANCE.createEClass();
		b.setName("B"); //$NON-NLS-1$
		epackage.getEClassifiers().add(b);
		b.getESuperTypes().add(a);
		
		EAttribute attrA = EcoreFactory.eINSTANCE.createEAttribute();
		attrA.setName("a"); //$NON-NLS-1$
		attrA.setEType(EcorePackage.eINSTANCE.getEBoolean());
		a.getEStructuralFeatures().add(attrA);
		
		EAttribute attrB = EcoreFactory.eINSTANCE.createEAttribute();
		attrB.setName("b"); //$NON-NLS-1$
		attrB.setEType(EcorePackage.eINSTANCE.getEBoolean());
		b.getEStructuralFeatures().add(attrB);
		
		try {
			OCLExpression constraint = parseConstraint(
				"package mypkg context A " + //$NON-NLS-1$
				"inv: self.oclIsKindOf(B) implies self.oclAsType(B).b " + //$NON-NLS-1$
				"endpackage "); //$NON-NLS-1$
			
			// create an A
			EObject eobj = epackage.getEFactoryInstance().create(a);
			eobj.eSet(attrA, Boolean.TRUE);
			
			// this would fail with an NPE on the access to '.b' when
			//    'self.oclAsType(B)' evaluates to null, if we didn't short-circuit
			assertTrue("Should not have failed the check", check(constraint, eobj)); //$NON-NLS-1$
			
			// create a B this time
			eobj = epackage.getEFactoryInstance().create(b);
			eobj.eSet(attrA, Boolean.TRUE);
			eobj.eSet(attrB, Boolean.FALSE);
			
			assertFalse("Should have failed the check", check(constraint, eobj)); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		} finally {
			EPackage.Registry.INSTANCE.remove(epackage.getNsURI());
		}
	}
	
	/**
	 * Tests that we correctly parse the <tt>oclIsNew</tt> operation in
	 * invariant constraints, but that validation reports a suitable error.
	 */
	public void test_oclIsNew_invariant_RATLC00529981() {
		OCLExpression constraint = parseConstraintUnvalidated(
			"package ocltest context Fruit " + //$NON-NLS-1$
			"inv: color.oclIsNew() " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		AssertionFailedError err = null;
		
		try {
			validate(constraint);
		} catch (AssertionFailedError e) {
			// success
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		assertNotNull("Should not have succeeded in validating illegal oclIsNew", err); //$NON-NLS-1$
	}
	
	/**
	 * Tests that we correctly parse the <tt>oclIsNew</tt> operation in
	 * precondition constraints, but that validation reports a suitable error.
	 */
	public void test_oclIsNew_precondition_RATLC00529981() {
		OCLExpression constraint = parseConstraintUnvalidated(
			"package ocltest context Fruit::ripen(c : Color) : Boolean " + //$NON-NLS-1$
			"pre: c.oclIsNew() implies c <> Color::black " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		AssertionFailedError err = null;
		
		try {
			validate(constraint);
		} catch (AssertionFailedError e) {
			// success
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		assertNotNull("Should not have succeeded in validating illegal oclIsNew", err); //$NON-NLS-1$
	}
	
	/**
	 * Tests that we correctly parse the <tt>oclIsNew</tt> operation in
	 * postcondition constraints, and that validation reports no errors.
	 */
	public void test_oclIsNew_postcondition_RATLC00529981() {
		parseConstraint(
			"package ocltest context Fruit::ripen(c : Color) : Boolean " + //$NON-NLS-1$
			"post: color.oclIsNew() implies color <> Color::black " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
	}
	
	/**
	 * Tests that we correctly parse and evaluate the <tt>toLower</tt> operation
	 * on OCL string values.
	 */
	public void test_toLower_RATLC00529981() {
		OCLExpression expr = parse(
			"package ocltest context Fruit " + //$NON-NLS-1$
			"inv: 'AlPHaBet'.toLower() " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		Object value = evaluate(expr);
		
		assertEquals("alphabet", value); //$NON-NLS-1$
	}
	
	/**
	 * Tests that we correctly parse and evaluate the <tt>toUpper</tt> operation
	 * on OCL string values.
	 */
	public void test_toUpper_RATLC00529981() {
		OCLExpression expr = parse(
			"package ocltest context Fruit " + //$NON-NLS-1$
			"inv: 'AlPHaBet'.toUpper() " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		Object value = evaluate(expr);
		
		assertEquals("ALPHABET", value); //$NON-NLS-1$
	}
	
	/**
	 * Tests that references that have multiplicity, are unique, and
	 * are ordered are rendered as OCL sets.
	 */
	public void test_referenceMultiplicity_orderedSet_RATLC00538035() {
		OCLExpression expr = parse(
			"package ocltest context FruitUtil " + //$NON-NLS-1$
			"inv: self.orderedSet" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		// check that the result type is an ordered set type
		assertTrue(
			"Not an ordered set type", //$NON-NLS-1$
			expr.getType() instanceof OrderedSetType);
	}
	
	/**
	 * Tests that references that have multiplicity, are unique, and
	 * are unordered are rendered as OCL sets.
	 */
	public void test_referenceMultiplicity_set_RATLC00538035() {
		OCLExpression expr = parse(
			"package ocltest context FruitUtil " + //$NON-NLS-1$
			"inv: self.set" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		// check that the result type is a set type
		assertTrue(
			"Not a set type", //$NON-NLS-1$
			(expr.getType() instanceof SetType)
				&& !(expr.getType() instanceof OrderedSetType));
	}
	
	/**
	 * Tests that references that have multiplicity, are non-unique, and
	 * are ordered are rendered as OCL sequences.
	 */
	public void test_referenceMultiplicity_sequence_RATLC00538035() {
		OCLExpression expr = parse(
			"package ocltest context FruitUtil " + //$NON-NLS-1$
			"inv: self.sequence" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		// check that the result type is a sequence set type
		assertTrue(
			"Not a sequence type", //$NON-NLS-1$
			expr.getType() instanceof SequenceType);
	}
	
	/**
	 * Tests that references that have multiplicity, are non-unique, and
	 * are unordered are rendered as OCL bags.
	 */
	public void test_referenceMultiplicity_bag_RATLC00538035() {
		OCLExpression expr = parse(
			"package ocltest context FruitUtil " + //$NON-NLS-1$
			"inv: self.bag" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		// check that the result type is a bag set type
		assertTrue(
			"Not a bag type", //$NON-NLS-1$
			expr.getType() instanceof BagType);
	}
	
	/**
	 * Tests that operation parameters that have multiplicity, are unique, and
	 * are ordered are rendered as OCL sets.
	 */
	public void test_parameterMultiplicity_orderedSet_RATLC00538035() {
		OCLExpression expr = parse(
			"package ocltest context FruitUtil " + //$NON-NLS-1$
			"inv: self.processOrderedSet(self.orderedSet)" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		// now also check that the result type is an ordered set type
		assertTrue(
			"Not an ordered set type", //$NON-NLS-1$
			expr.getType() instanceof OrderedSetType);
	}
	
	/**
	 * Tests that operation parameters that have multiplicity, are unique, and
	 * are unordered are rendered as OCL sets.
	 */
	public void test_parameterMultiplicity_set_RATLC00538035() {
		OCLExpression expr = parse(
			"package ocltest context FruitUtil " + //$NON-NLS-1$
			"inv: self.processSet(self.set)" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		// now also check that the result type is a set type
		assertTrue(
			"Not a set type", //$NON-NLS-1$
			(expr.getType() instanceof SetType)
				&& !(expr.getType() instanceof OrderedSetType));
	}
	
	/**
	 * Tests that operation parameters that have multiplicity, are non-unique, and
	 * are ordered are rendered as OCL sequences.
	 */
	public void test_parameterMultiplicity_sequence_RATLC00538035() {
		OCLExpression expr = parse(
			"package ocltest context FruitUtil " + //$NON-NLS-1$
			"inv: self.processSequence(self.sequence)" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		// now also check that the result type is a sequence type
		assertTrue(
			"Not a sequence type", //$NON-NLS-1$
			expr.getType() instanceof SequenceType);
	}
	
	/**
	 * Tests that operation parameters that have multiplicity, are non-unique, and
	 * are unordered are rendered as OCL bags.
	 */
	public void test_parameterMultiplicity_bag_RATLC00538035() {
		OCLExpression expr = parse(
			"package ocltest context FruitUtil " + //$NON-NLS-1$
			"inv: self.processBag(self.bag)" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		// now also check that the result type is a bag type
		assertTrue(
			"Not a bag type", //$NON-NLS-1$
			expr.getType() instanceof BagType);
	}
	
	/**
	 * Tests that operations that have multiplicity, are unique, and
	 * are ordered are rendered as OCL sets.
	 */
	public void test_operationMultiplicity_orderedSet_RATLC00538035() {
		OCLExpression expr = parse(
			"package ocltest context FruitUtil " + //$NON-NLS-1$
			"inv: self.processOrderedSet(self.processOrderedSet(self.orderedSet))" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		// now also check that the result type is an ordered set type
		assertTrue(
			"Not an ordered set type", //$NON-NLS-1$
			expr.getType() instanceof OrderedSetType);
	}
	
	/**
	 * Tests that operations that have multiplicity, are unique, and
	 * are unordered are rendered as OCL sets.
	 */
	public void test_operationMultiplicity_set_RATLC00538035() {
		OCLExpression expr = parse(
			"package ocltest context FruitUtil " + //$NON-NLS-1$
			"inv: self.processSet(self.processSet(self.set))" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		// now also check that the result type is a set type
		assertTrue(
			"Not a set type", //$NON-NLS-1$
			(expr.getType() instanceof SetType)
				&& !(expr.getType() instanceof OrderedSetType));
	}
	
	/**
	 * Tests that operations that have multiplicity, are non-unique, and
	 * are ordered are rendered as OCL sequences.
	 */
	public void test_operationMultiplicity_sequence_RATLC00538035() {
		OCLExpression expr = parse(
			"package ocltest context FruitUtil " + //$NON-NLS-1$
			"inv: self.processSequence(self.processSequence(self.sequence))" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		// now also check that the result type is a sequence type
		assertTrue(
			"Not a sequence type", //$NON-NLS-1$
			expr.getType() instanceof SequenceType);
	}
	
	/**
	 * Tests that operations that have multiplicity, are non-unique, and
	 * are unordered are rendered as OCL bags.
	 */
	public void test_operationMultiplicity_bag_RATLC00538035() {
		OCLExpression expr = parse(
			"package ocltest context FruitUtil " + //$NON-NLS-1$
			"inv: self.processBag(self.processBag(self.bag))" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		// now also check that the result type is a bag type
		assertTrue(
			"Not a bag type", //$NON-NLS-1$
			expr.getType() instanceof BagType);
	}
	
	/**
	 * Tests that the operation context parsing matches ordered set types
	 * correctly in the parameters, result type, and body expression type.
	 */
	public void test_operationContext_orderedSet_RATLC00538035() {
		AssertionFailedError err = null;
		
		// this should not work
		try {
			parse(
				"package ocltest context " + //$NON-NLS-1$
				"FruitUtil::processOrderedSet(x : Fruit) : Fruit " + //$NON-NLS-1$
				"body: result = x" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
		} catch (AssertionFailedError e) {
			// this is expected (success case)
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		assertNotNull("Parse should have failed", err); //$NON-NLS-1$
		
		// this should work
		parse(
			"package ocltest context " + //$NON-NLS-1$
			"FruitUtil::processOrderedSet(x : OrderedSet(Fruit)) : OrderedSet(Fruit) " + //$NON-NLS-1$
			"body: result = x" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
	}
	
	/**
	 * Tests that the operation context parsing matches set types
	 * correctly in the parameters, result type, and body expression type.
	 */
	public void test_operationContext_set_RATLC00538035() {
		AssertionFailedError err = null;
		
		// this should not work
		try {
			parse(
				"package ocltest context " + //$NON-NLS-1$
				"FruitUtil::processSet(x : Fruit) : Fruit " + //$NON-NLS-1$
				"body: result = x" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
		} catch (AssertionFailedError e) {
			// this is expected (success case)
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		assertNotNull("Parse should have failed", err); //$NON-NLS-1$
		
		// this should work
		parse(
			"package ocltest context " + //$NON-NLS-1$
			"FruitUtil::processSet(x : Set(Fruit)) : Set(Fruit) " + //$NON-NLS-1$
			"body: result = x" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
	}
	
	/**
	 * Tests that the operation context parsing matches sequence types
	 * correctly in the parameters, result type, and body expression type.
	 */
	public void test_operationContext_sequence_RATLC00538035() {
		AssertionFailedError err = null;
		
		// this should not work
		try {
			parse(
				"package ocltest context " + //$NON-NLS-1$
				"FruitUtil::processSequence(x : Fruit) : Fruit " + //$NON-NLS-1$
				"body: result = x" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
		} catch (AssertionFailedError e) {
			// this is expected (success case)
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		assertNotNull("Parse should have failed", err); //$NON-NLS-1$
		
		// this should work
		parse(
			"package ocltest context " + //$NON-NLS-1$
			"FruitUtil::processSequence(x : Sequence(Fruit)) : Sequence(Fruit) " + //$NON-NLS-1$
			"body: result = x" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
	}
	
	/**
	 * Tests that the operation context parsing matches bag types
	 * correctly in the parameters, result type, and body expression type.
	 */
	public void test_operationContext_bag_RATLC00538035() {
		AssertionFailedError err = null;
		
		// this should not work
		try {
			parse(
				"package ocltest context " + //$NON-NLS-1$
				"FruitUtil::processBag(x : Fruit) : Fruit " + //$NON-NLS-1$
				"body: result = x" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
		} catch (AssertionFailedError e) {
			// this is expected (success case)
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		assertNotNull("Parse should have failed", err); //$NON-NLS-1$
		
		// this should work
		parse(
			"package ocltest context " + //$NON-NLS-1$
			"FruitUtil::processBag(x : Bag(Fruit)) : Bag(Fruit) " + //$NON-NLS-1$
			"body: result = x" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that <code>allInstances()</code> works as
	 * expected on enumerations.
	 */
	public void test_allInstances_enumeration_RATLC00538079() {
		Object result = evaluate(parse(
			"package ocltest context Fruit " + //$NON-NLS-1$
			"inv: Color.allInstances() " + //$NON-NLS-1$
			" endpackage")); //$NON-NLS-1$
		
		Set expected = new java.util.HashSet(color.getELiterals());
		
		assertEquals(expected, result);
	}
	
	/**
	 * Regression test to check that <code>allInstances()</code> works as
	 * expected on the <code>OclVoid</code> type.
	 */
	public void test_allInstances_voidType_RATLC00538079() {
		Object result = evaluate(parse(
			"package ocltest context Fruit " + //$NON-NLS-1$
			"inv: OclVoid.allInstances() " + //$NON-NLS-1$
			" endpackage")); //$NON-NLS-1$
		
		Set expected = new java.util.HashSet();
		expected.add(null);
		
		assertEquals(expected, result);
	}
	
	/**
	 * Regression test to check that <code>allInstances()</code> works as
	 * expected on primitive types.
	 */
	public void test_allInstances_primitive_RATLC00538079() {
		Object result = evaluate(parse(
			"package ocltest context Fruit " + //$NON-NLS-1$
			"inv: ecore::EMap.allInstances() " + //$NON-NLS-1$
			" endpackage")); //$NON-NLS-1$
		
		assertEquals(Collections.EMPTY_SET, result);
	}
	
	/**
	 * Regression test for the problem of extra closing parentheses allowing
	 * garbage expressions to appear to parse correctly.  This test tests
	 * the core parser.
	 */
	public void test_closingParentheses_core() {
		AssertionFailedError err = null;
		
		// this should not work
		try {
			parse(
				"package ocltest context Fruit " + //$NON-NLS-1$
				"inv: self)garbage " + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
		} catch (AssertionFailedError e) {
			// this is expected (success case)
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		assertNotNull("Parse should have failed", err); //$NON-NLS-1$
	}
	
	/**
	 * Regression test for the problem of extra closing parentheses allowing
	 * garbage expressions to appear to parse correctly.  This test tests
	 * the OCL helper.
	 */
	public void test_closingParentheses_helper() {
		IOCLHelper helper = HelperUtil.createOCLHelper();

		helper.setContext(fruit);
		
		try {
			// this should not work
			helper.createInvariant("self)garbage"); //$NON-NLS-1$
			
			fail("Parse should have failed"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Regression test for the problem of extra closing parentheses allowing
	 * garbage expressions to appear to parse correctly.  This test tests
	 * the OCL helper with a precondition instead of an invariant.
	 */
	public void test_closingParentheses_helper_precondition() {
		IOCLHelper helper = HelperUtil.createOCLHelper();

		helper.setContextOperation(fruit, fruit_ripen);
		
		try {
			// this should not work
			helper.createPrecondition("self)garbage"); //$NON-NLS-1$
			
			fail("Parse should have failed"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_operationBodyBoolean_116251() {
		AssertionFailedError err = null;
		
		// this should not work
		try {
			parseConstraint(
				"package ocltest context " + //$NON-NLS-1$
				"FruitUtil::processBag(x : Bag(Fruit)) : Bag(Fruit) " + //$NON-NLS-1$
				"body: x->asSet()->asBag()" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
		} catch (AssertionFailedError e) {
			// this is expected (success case)
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		assertNotNull("Parse should have failed", err); //$NON-NLS-1$
		
		// this should work
		parseConstraint(
			"package ocltest context " + //$NON-NLS-1$
			"FruitUtil::processBag(x : Bag(Fruit)) : Bag(Fruit) " + //$NON-NLS-1$
			"body: result = x->asSet()->asBag()" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		// as should this
		parseConstraint(
			"package ocltest context " + //$NON-NLS-1$
			"FruitUtil::processBag(x : Bag(Fruit)) : Bag(Fruit) " + //$NON-NLS-1$
			"body: x->asSet()->asBag() = result" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		// and this (allow any number of lets to wrap the expression)
		parseConstraint(
			"package ocltest context " + //$NON-NLS-1$
			"FruitUtil::processBag(x : Bag(Fruit)) : Bag(Fruit) " + //$NON-NLS-1$
			"body: let set : Set(Fruit) = x->asSet() in" + //$NON-NLS-1$
			" let bag : Bag(Fruit) = set->asBag() in" + //$NON-NLS-1$
			" result = bag" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		// this should not work, however, because it has the result in the
		//    body expression part of the constraint
		err = null;
		try {
			parseConstraint(
				"package ocltest context " + //$NON-NLS-1$
				"FruitUtil::processBag(x : Bag(Fruit)) : Bag(Fruit) " + //$NON-NLS-1$
				"body: result = result->asSet()->union(x)->asBag()" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
		} catch (AssertionFailedError e) {
			// this is expected (success case)
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		assertNotNull("Parse should have failed", err); //$NON-NLS-1$
	}
	
	/**
	 * When resolving unqualified property calls in an inner scope (such as in a loop
	 * expression), the OCL language specification requires that the lookup of the
	 * implicit target of the property call start with the innermost iterator variable
	 * (whether explicitly or implicitly defined) and work outwards until it finds a
	 * match).
	 */
	public void test_innerScopeFeatureResolution_bugzilla113355() {
		EPackage epackage = EcoreFactory.eINSTANCE.createEPackage();
		epackage.setName("MyPackage"); //$NON-NLS-1$
		epackage.setNsPrefix("mypkg"); //$NON-NLS-1$
		epackage.setNsURI("http:///mypkg.ecore"); //$NON-NLS-1$
		EPackage.Registry.INSTANCE.put(epackage.getNsURI(), epackage);
		
		// Library1
		//  - Library2
		//    - Writer1
		//    - Writer2
		EClass libraryClass = EcoreFactory.eINSTANCE.createEClass();
		libraryClass.setName("Library"); //$NON-NLS-1$
		epackage.getEClassifiers().add(libraryClass);

		EClass writerClass = EcoreFactory.eINSTANCE.createEClass();
		writerClass.setName("Writer"); //$NON-NLS-1$
		epackage.getEClassifiers().add(writerClass);

		EReference branchesRef = EcoreFactory.eINSTANCE.createEReference();
		branchesRef.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
		branchesRef.setName("branches"); //$NON-NLS-1$
		branchesRef.setEType(libraryClass);
		
		EReference writersRef = EcoreFactory.eINSTANCE.createEReference();
		writersRef.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
		writersRef.setName("writers"); //$NON-NLS-1$
		writersRef.setEType(writerClass);
		
		EAttribute writerName = EcoreFactory.eINSTANCE.createEAttribute();
		writerName.setName("name"); //$NON-NLS-1$
		writerName.setEType(EcorePackage.eINSTANCE.getEString());

		libraryClass.getEStructuralFeatures().add(branchesRef);
		libraryClass.getEStructuralFeatures().add(writersRef);
		writerClass.getEStructuralFeatures().add(writerName);

		EFactory efactory = epackage.getEFactoryInstance();
		
		// create our test instance
		EObject library1 = efactory.create(libraryClass);
		EObject library2 = efactory.create(libraryClass);
		EObject writer1 = efactory.create(writerClass);
		EObject writer2 = efactory.create(writerClass);
		
		writer1.eSet(writerName, "Joe"); //$NON-NLS-1$
		writer2.eSet(writerName, "Jane"); //$NON-NLS-1$
		
		EList branches = new BasicEList();
		branches.add(library2);
		EList writers = new BasicEList();
		writers.add(writer1);
		writers.add(writer2);
		
		library1.eSet(branchesRef, branches);
		library2.eSet(writersRef, writers);
		
		// parse expression
		try {
			OCLExpression expr = parse(
					"package mypkg context Library " + //$NON-NLS-1$
					"inv: branches->collect(writers->collect(w : Writer | w))->flatten()" + //$NON-NLS-1$
					"endpackage"); //$NON-NLS-1$
					
			List result = (List)evaluate(expr, library1);
			assertTrue(result.size() == 2);
			assertTrue(((EObject)result.get(0)).eGet(writerName).equals("Joe")); //$NON-NLS-1$
			assertTrue(((EObject)result.get(1)).eGet(writerName).equals("Jane")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		} finally {
			EPackage.Registry.INSTANCE.remove(epackage.getNsURI());
		}
	}
	
	/**
	 * Tests the Query API's select() and reject() methods.
	 */
	public void test_querySelectReject_126694() {
		OCLExpression expr = parse(
				"package ocltest context Fruit " + //$NON-NLS-1$
				"inv: color <> Color::black " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
		
		Query query = QueryFactory.eINSTANCE.createQuery(expr);
		
		List allFruits = new java.util.ArrayList();
		
		EObject other = fruitFactory.create(apple);
		other.eSet(fruit_color, color_red);
		allFruits.add(other);
		
		EObject blackFruit = fruitFactory.create(apple);
		blackFruit.eSet(fruit_color, color_black);
		allFruits.add(blackFruit);
		
		other = fruitFactory.create(apple);
		other.eSet(fruit_color, color_green);
		allFruits.add(other);
		
		List expectedSelection = new java.util.ArrayList(allFruits);
		expectedSelection.remove(blackFruit);
		
		List expectedRejection = Collections.singletonList(blackFruit);
		
		assertEquals(expectedRejection, query.reject(allFruits));
		assertEquals(expectedSelection, query.select(allFruits));
	}
	
	/**
	 * Tests the collection product() operation.
	 */
	public void test_product_126336() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.ESTRING);
		
		Set product = null;
		EAttribute first = null;
		EAttribute second = null;
		
		try {
			OCLExpression expr = helper.createQuery(
					"Set{'foo', 'bar'}->product(Sequence{1, 2, 3})"); //$NON-NLS-1$

			EClassifier resultType = expr.getType();
			assertTrue(resultType instanceof CollectionType);
			
			EClassifier elementType = ((CollectionType) resultType).getElementType();
			
			assertTrue(elementType instanceof TupleType);
			TupleType tupleType = (TupleType) elementType;
			
			assertEquals(2, tupleType.getEAttributes().size());
			first = (EAttribute) tupleType.getEAttributes().get(0);
			second = (EAttribute) tupleType.getEAttributes().get(1);
					
			product = (Set) helper.evaluate("", expr); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		assertNotNull(product);
		
		// got as many product tuples as required (2 x 3)
		assertEquals(6, product.size());
		
		Map expectedTuples = new java.util.HashMap();
		Set values = new java.util.HashSet();
		values.add(new Integer(1));
		values.add(new Integer(2));
		values.add(new Integer(3));
		
		expectedTuples.put("foo", new java.util.HashSet(values)); //$NON-NLS-1$
		expectedTuples.put("bar", new java.util.HashSet(values)); //$NON-NLS-1$
		
		for (Iterator iter = product.iterator(); iter.hasNext();) {
			EObject tuple = (EObject) iter.next();
			
			values = (Set) expectedTuples.get(tuple.eGet(first));
			
			// every "first" value must hit
			assertNotNull(values);
			
			// every "second" must remove a different mapping
			assertTrue(values.remove(tuple.eGet(second)));
		}
	}
}
