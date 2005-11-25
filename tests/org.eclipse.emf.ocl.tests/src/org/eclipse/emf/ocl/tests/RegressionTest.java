/******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.emf.ocl.tests;

import java.util.Collections;
import java.util.Set;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ocl.expressions.OclExpression;
import org.eclipse.emf.ocl.expressions.util.EvalEnvironment;
import org.eclipse.emf.ocl.helper.HelperUtil;
import org.eclipse.emf.ocl.helper.IOclHelper;
import org.eclipse.emf.ocl.parser.EcoreEnvironmentFactory;
import org.eclipse.emf.ocl.parser.EvaluationEnvironment;
import org.eclipse.emf.ocl.types.BagType;
import org.eclipse.emf.ocl.types.OrderedSetType;
import org.eclipse.emf.ocl.types.SequenceType;
import org.eclipse.emf.ocl.types.SetType;
import org.eclipse.emf.ocl.types.internal.impl.AnyTypeImpl;

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
			OclExpression constraint = parseConstraint(
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
			OclExpression constraint = parseConstraint(
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
			OclExpression constraint = parseConstraint(
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
			OclExpression constraint = parseConstraint(
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
		OclExpression constraint = parseConstraintUnvalidated(
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
		OclExpression constraint = parseConstraintUnvalidated(
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
		OclExpression expr = parse(
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
		OclExpression expr = parse(
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
		OclExpression expr = parse(
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
		OclExpression expr = parse(
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
		OclExpression expr = parse(
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
		OclExpression expr = parse(
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
		OclExpression expr = parse(
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
		OclExpression expr = parse(
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
		OclExpression expr = parse(
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
		OclExpression expr = parse(
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
		OclExpression expr = parse(
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
		OclExpression expr = parse(
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
		OclExpression expr = parse(
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
		OclExpression expr = parse(
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
				"body: x" + //$NON-NLS-1$
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
			"body: x" + //$NON-NLS-1$
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
				"body: x" + //$NON-NLS-1$
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
			"body: x" + //$NON-NLS-1$
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
				"body: x" + //$NON-NLS-1$
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
			"body: x" + //$NON-NLS-1$
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
				"body: x" + //$NON-NLS-1$
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
			"body: x" + //$NON-NLS-1$
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
	public void test_allInstances_OclVoid_RATLC00538079() {
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
		IOclHelper helper = HelperUtil.createOclHelper();

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
		IOclHelper helper = HelperUtil.createOclHelper();

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
	
	/**
	 * Tests the delegation of operation evaluation to the Evaluation Environment
	 * for the <code>oclIsTypeOf</code> operation.
	 */
	public void test_canEvaluateOverrideOperation_bugzilla117542() {
		// add a RoundFruit EClass to the fruit package
		EClassifier roundFruit = EcoreFactory.eINSTANCE.createEClass();
		roundFruit.setName("RoundFruit");
		fruitPackage.getEClassifiers().add(roundFruit);

		EObject aFruit = fruitFactory.create(apple);

		IOclHelper helper = HelperUtil.createOclHelper(new TestEnvironmentFactory());
		helper.setContext(apple);

		Object value = null;
		try {
			value = helper.evaluate(aFruit, "self.oclIsTypeOf(RoundFruit)");
		} catch (Exception e) {
			fail("Unexpected error: " + e.getLocalizedMessage());
		}

		assertNotNull(value);
		assertTrue(value instanceof Boolean && ((Boolean)value).booleanValue());

		// clean up
		fruitPackage.getEClassifiers().remove(roundFruit);
	}

	/**
	 * Tests the delegation of operation evaluation to the Evaluation Environment
	 * for the <code>oclIsTypeOf</code> operation. But then because the type to be
	 * compared to is not a special case (Apple), an UnsupportedOperationException
	 * is thrown which delegates the evaluation back to the evaluation visitor.
	 */
	public void test_canEvaluateUnsupportedOperation_bugzilla117542() {
		EObject aFruit = fruitFactory.create(apple);

		IOclHelper helper = HelperUtil.createOclHelper(new TestEnvironmentFactory());
		helper.setContext(apple);

		Object value = null;
		try {
			value = helper.evaluate(aFruit, "self.oclIsTypeOf(Apple)");
		} catch (Exception e) {
			fail("Unexpected error: " + e.getLocalizedMessage());
		}

		assertNotNull(value);
		assertTrue(value instanceof Boolean && ((Boolean)value).booleanValue());
	}
	
	/**
	 * Environment Factory which specifies the use of the TestEvaluationEnvironment.
	 */
	private class TestEnvironmentFactory extends EcoreEnvironmentFactory {
		public EvaluationEnvironment createEvaluationEnvironment() {
			return new TestEvaluationEnvironment();
		}
	}
	
	/**
	 * Evaluation Environment which provides support for evaluating operations.
	 */
	private class TestEvaluationEnvironment extends EvalEnvironment {
		
		/**
		 * Can evaluate the <code>oclIsTypeOf</code> operation.
		 */
		public boolean canEvaluate(EOperation operation, int opcode) {
			if (opcode == AnyTypeImpl.OCL_IS_TYPE_OF) {
				return true;
			}
			return false;
		}

		/**
		 * Evaluates the <code>oclIsTypeOf</code> operation.
		 */
		public Object evaluate(EOperation operation, int opcode, Object target, Object[] args)
				throws UnsupportedOperationException {
			// apples are round fruits!
			if (opcode == AnyTypeImpl.OCL_IS_TYPE_OF
					&& args.length == 1
					&& args[0] instanceof EClassifier
					&& target instanceof EObject
					&& ((EObject)target).eClass().equals(apple)
					&& "RoundFruit".equals(((EClassifier)args[0]).getName())) {
				return Boolean.TRUE;
			}
			throw new UnsupportedOperationException();
		}
	}
}
