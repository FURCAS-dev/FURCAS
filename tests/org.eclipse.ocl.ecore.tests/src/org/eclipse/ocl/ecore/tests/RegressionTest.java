/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
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
 * $Id: RegressionTest.java,v 1.7 2007/10/11 23:04:44 cdamus Exp $
 */

package org.eclipse.ocl.ecore.tests;

import java.util.Collections;
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
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ecore.BagType;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OrderedSetType;
import org.eclipse.ocl.ecore.SequenceType;
import org.eclipse.ocl.ecore.SetType;
import org.eclipse.ocl.ecore.TupleType;
import org.eclipse.ocl.expressions.BooleanLiteralExp;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.expressions.LetExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.util.Tuple;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.UMLReflection;

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
			OCLExpression<EClassifier> constraint = parseConstraint(
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
			OCLExpression<EClassifier> constraint = parseConstraint(
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
			OCLExpression<EClassifier> constraint = parseConstraint(
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
			OCLExpression<EClassifier> constraint = parseConstraint(
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
		OCLExpression<EClassifier> constraint = parseConstraintUnvalidated(
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
		OCLExpression<EClassifier> constraint = parseConstraintUnvalidated(
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
		OCLExpression<EClassifier> expr = parse(
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
		OCLExpression<EClassifier> expr = parse(
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
		OCLExpression<EClassifier> expr = parse(
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
		OCLExpression<EClassifier> expr = parse(
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
		OCLExpression<EClassifier> expr = parse(
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
		OCLExpression<EClassifier> expr = parse(
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
		OCLExpression<EClassifier> expr = parse(
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
		OCLExpression<EClassifier> expr = parse(
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
		OCLExpression<EClassifier> expr = parse(
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
		OCLExpression<EClassifier> expr = parse(
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
		OCLExpression<EClassifier> expr = parse(
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
		OCLExpression<EClassifier> expr = parse(
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
		OCLExpression<EClassifier> expr = parse(
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
		OCLExpression<EClassifier> expr = parse(
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
		
		Set<EEnumLiteral> expected = new java.util.HashSet<EEnumLiteral>(
				color.getELiterals());
		
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
		
		Set<Object> expected = new java.util.HashSet<Object>();
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
		helper.setOperationContext(fruit, fruit_ripen);
		
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
		
		EList<EObject> branches = new BasicEList<EObject>();
		branches.add(library2);
		EList<EObject> writers = new BasicEList<EObject>();
		writers.add(writer1);
		writers.add(writer2);
		
		library1.eSet(branchesRef, branches);
		library2.eSet(writersRef, writers);
		
		// parse expression
		try {
			OCLExpression<EClassifier> expr = parse(
					"package mypkg context Library " + //$NON-NLS-1$
					"inv: branches->collect(writers->collect(w : Writer | w))->flatten()" + //$NON-NLS-1$
					"endpackage"); //$NON-NLS-1$
					
			@SuppressWarnings("unchecked")
			List<EObject> result = (List<EObject>)evaluate(expr, library1);
			
			assertTrue(result.size() == 2);
			assertTrue(result.get(0).eGet(writerName).equals("Joe")); //$NON-NLS-1$
			assertTrue(result.get(1).eGet(writerName).equals("Jane")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		} finally {
			EPackage.Registry.INSTANCE.remove(epackage.getNsURI());
		}
	}
	
	/**
	 * Tests the collection product() operation.
	 */
	public void test_product_126336() {
		helper.setContext(EcorePackage.Literals.ESTRING);
		
		Set<Tuple<EOperation, EStructuralFeature>> product = null;
		
		try {
			OCLExpression<EClassifier> expr = helper.createQuery(
					"Set{'foo', 'bar'}->product(Sequence{1, 2, 3})"); //$NON-NLS-1$

			EClassifier resultType = expr.getType();
			assertTrue(resultType instanceof CollectionType);
			
			EClassifier elementType = ((CollectionType) resultType).getElementType();
			
			assertTrue(elementType instanceof TupleType);
			TupleType tupleType = (TupleType) elementType;
			
			assertEquals(2, tupleType.getEAttributes().size());
			
			@SuppressWarnings("unchecked")
			Set<Tuple<EOperation, EStructuralFeature>> evalResult =
				(Set<Tuple<EOperation, EStructuralFeature>>) ocl.evaluate("", expr); //$NON-NLS-1$
			product = evalResult;
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		assertNotNull(product);
		
		// got as many product tuples as required (2 x 3)
		assertEquals(6, product.size());
		
		Map<String, Set<Integer>> expectedTuples =
			new java.util.HashMap<String, Set<Integer>>();
		Set<Integer> values = new java.util.HashSet<Integer>();
		values.add(1);
		values.add(2);
		values.add(3);
		
		expectedTuples.put("foo", new java.util.HashSet<Integer>(values)); //$NON-NLS-1$
		expectedTuples.put("bar", new java.util.HashSet<Integer>(values)); //$NON-NLS-1$
		
		for (Tuple<EOperation, EStructuralFeature> tuple : product) {
			values = expectedTuples.get(tuple.getValue("first")); //$NON-NLS-1$
			
			// every "first" value must hit
			assertNotNull(values);
			
			// every "second" must remove a different mapping
			assertTrue(values.remove(tuple.getValue("second"))); //$NON-NLS-1$
		}
	}
	
	/**
	 * Test that the conversion of an expression to string and re-parsing works
	 * as expected.  Use the particular iteration expression described in the
	 * referenced bugzilla.
	 */
	public void test_iterationToString_126454() {
		EPackage fakePkg = EcoreFactory.eINSTANCE.createEPackage();
		fakePkg.setName("fake"); //$NON-NLS-1$
		EClass fake = EcoreFactory.eINSTANCE.createEClass();
		fake.setName("Fake"); //$NON-NLS-1$
		fakePkg.getEClassifiers().add(fake);
		EAttribute eattr = EcoreFactory.eINSTANCE.createEAttribute();
		eattr.setName("e"); //$NON-NLS-1$
		eattr.setEType(EcorePackage.Literals.EINT);
		eattr.setUpperBound(1);  // not a collection
		fake.getEStructuralFeatures().add(eattr);
		
		EObject aFake = fakePkg.getEFactoryInstance().create(fake);
		aFake.eSet(eattr, new Integer(7));
		
		helper.setContext(fake);
		
		try {
			OCLExpression<EClassifier> expr = helper.createQuery("self.e->sum()"); //$NON-NLS-1$
			
			// convert to string and re-parse
			String toStringResult = expr.toString();
			expr = helper.createQuery(toStringResult);
			
			assertEquals(aFake.eGet(eattr), ocl.evaluate(aFake, expr));
		} catch (Exception exc) {
			fail("Failed to parse or evaluate: " + exc.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Test the OclVoid literal 'null'.
	 */
	public void test_null() {
		Object result = evaluate(parse(
				"package ocltest context Fruit " + //$NON-NLS-1$
				"inv: null.oclIsTypeOf(OclVoid) " + //$NON-NLS-1$
				" endpackage")); //$NON-NLS-1$
			
		assertEquals(Boolean.TRUE, result);
			
		result = evaluate(parse(
				"package ocltest context Fruit " + //$NON-NLS-1$
				"inv: null.oclIsUndefined() " + //$NON-NLS-1$
				" endpackage")); //$NON-NLS-1$
			
		assertEquals(Boolean.TRUE, result);
			
		result = evaluate(parse(
				"package ocltest context Fruit " + //$NON-NLS-1$
				"inv: null.oclIsInvalid() " + //$NON-NLS-1$
				" endpackage")); //$NON-NLS-1$
			
		assertEquals(Boolean.FALSE, result);
		
		result = evaluate(parse(
				"package ocltest context Fruit " + //$NON-NLS-1$
				"inv: null.oclAsType(Integer) " + //$NON-NLS-1$
				" endpackage")); //$NON-NLS-1$
			
		assertNull(result);
	}
	
	/**
	 * Test the Invalid type and its literal 'OclInvalid'.
	 */
	public void test_oclInvalid() {
		Object result = evaluate(parse(
			"package ocltest context Fruit " + //$NON-NLS-1$
			"inv: OclInvalid.oclIsTypeOf(Invalid) " + //$NON-NLS-1$
			" endpackage")); //$NON-NLS-1$
		
		assertEquals(Boolean.TRUE, result);
		
		result = evaluate(parse(
				"package ocltest context Fruit " + //$NON-NLS-1$
				"inv: OclInvalid.oclIsUndefined() " + //$NON-NLS-1$
				" endpackage")); //$NON-NLS-1$
			
		assertEquals(Boolean.TRUE, result);
			
		result = evaluate(parse(
				"package ocltest context Fruit " + //$NON-NLS-1$
				"inv: OclInvalid.oclIsInvalid() " + //$NON-NLS-1$
				" endpackage")); //$NON-NLS-1$
			
		assertEquals(Boolean.TRUE, result);
		
		result = evaluate(parse(
				"package ocltest context Fruit " + //$NON-NLS-1$
				"inv: OclInvalid.oclAsType(Integer) " + //$NON-NLS-1$
				" endpackage")); //$NON-NLS-1$
			
		assertInvalid(result);
		
		result = evaluate(parse(
				"package ocltest context Fruit " + //$NON-NLS-1$
				"inv: null.oclAsType(Apple).color " + //$NON-NLS-1$
				" endpackage")); //$NON-NLS-1$
		
		// feature calls on null result in OclInvalid
		assertInvalid(result);
		
		result = evaluate(parse(
				"package ocltest context Fruit " + //$NON-NLS-1$
				"inv: null.oclAsType(Apple).stem " + //$NON-NLS-1$
				" endpackage")); //$NON-NLS-1$
		
		// feature calls on null result in OclInvalid
		assertInvalid(result);
		
		result = evaluate(parse(
				"package ocltest context Fruit " + //$NON-NLS-1$
				"inv: null.oclAsType(Apple).preferredLabel('foo') " + //$NON-NLS-1$
				" endpackage")); //$NON-NLS-1$
		
		// feature calls on null result in OclInvalid
		assertInvalid(result);
	}
	
	/**
	 * Tests that we report an error on failing to find an operation matching
	 * a call.  Moreover, the error is in parsing, not in validating.
	 */
	public void test_operationNotFound() {
		AssertionFailedError err = null;
		
		// this should not work (failure in parse, not validation)
		try {
			parseUnvalidated(
				"package ocltest context FruitUtil " + //$NON-NLS-1$
				"inv: self.processOrderedSet(1) = 0 " + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
		} catch (AssertionFailedError e) {
			// this is expected (success case)
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		assertNotNull("Parse should have failed", err); //$NON-NLS-1$
	}
	
	/**
	 * Tests that matching operations finds the first match, but that
	 * casting via oclAsType() can direct the parser to the best match.
	 */
	public void test_operationSignatureMatching() {
		EPackage pkg = EcoreFactory.eINSTANCE.createEPackage();
		EClass a = EcoreFactory.eINSTANCE.createEClass();
		a.setName("A"); //$NON-NLS-1$
		pkg.getEClassifiers().add(a);
		EClass b = EcoreFactory.eINSTANCE.createEClass();
		b.setName("B"); //$NON-NLS-1$
		pkg.getEClassifiers().add(b);
		EClass c = EcoreFactory.eINSTANCE.createEClass();
		c.setName("C"); //$NON-NLS-1$
		c.getESuperTypes().add(b);
		pkg.getEClassifiers().add(c);
		
		EReference ref = EcoreFactory.eINSTANCE.createEReference();
		ref.setEType(b);
		ref.setName("b"); //$NON-NLS-1$
		a.getEStructuralFeatures().add(ref);
		ref = EcoreFactory.eINSTANCE.createEReference();
		ref.setEType(c);
		ref.setName("c"); //$NON-NLS-1$
		a.getEStructuralFeatures().add(ref);
		
		EOperation foo1 = EcoreFactory.eINSTANCE.createEOperation();
		foo1.setName("foo"); //$NON-NLS-1$
		foo1.setEType(EcorePackage.Literals.EBOOLEAN);
		EParameter param = EcoreFactory.eINSTANCE.createEParameter();
		param.setEType(c);
		foo1.getEParameters().add(param);
		a.getEOperations().add(foo1);
		
		EOperation foo2 = EcoreFactory.eINSTANCE.createEOperation();
		foo2.setName("foo"); //$NON-NLS-1$
		foo2.setEType(EcorePackage.Literals.EBOOLEAN);
		param = EcoreFactory.eINSTANCE.createEParameter();
		param.setEType(b);
		foo2.getEParameters().add(param);
		a.getEOperations().add(foo2);
		
		helper.setContext(a);
		
		try {
			OCLExpression<EClassifier> expr = helper.createQuery("self.foo(c)"); //$NON-NLS-1$
			
			assertTrue(expr instanceof OperationCallExp);
			OperationCallExp<EClassifier, EOperation> oc =
				(OperationCallExp<EClassifier, EOperation>) expr;
			
			// foo1's parameter type is c
			assertSame(foo1, oc.getReferredOperation());
			
			expr = helper.createQuery("self.foo(b)"); //$NON-NLS-1$
			
			assertTrue(expr instanceof OperationCallExp);
			oc = (OperationCallExp<EClassifier, EOperation>) expr;
			
			// we matched foo1 because it was the first operation matching b
			//    (we skipped the foo having parameter type c)
			assertSame(foo2, oc.getReferredOperation());
			
			expr = helper.createQuery("self.foo(b.oclAsType(C))"); //$NON-NLS-1$
			
			assertTrue(expr instanceof OperationCallExp);
			oc = (OperationCallExp<EClassifier, EOperation>) expr;
			
			// coerced the arg to type C to find the correct foo
			assertSame(foo1, oc.getReferredOperation());
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests that looking up an operation call on an implicit source works
	 * and fails gracefully when it doesn't.  Test the case where the implicit
	 * source is not self.
	 */
	public void test_operationImplicitSource() {
		AssertionFailedError err = null;
		
		// this should not work
		try {
			parse(
				"package ocltest context Fruit " + //$NON-NLS-1$
				"inv: Apple.allInstances()->collect(preferredLabel())" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
		} catch (AssertionFailedError e) {
			// this is expected (success case)
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		assertNotNull("Parse should have failed", err); //$NON-NLS-1$
		
		// this should work
		parse(
			"package ocltest context Fruit " + //$NON-NLS-1$
			"inv: Apple.allInstances()->collect(preferredLabel('foo'))" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		// and this
		parse(
			"package ocltest context Apple " + //$NON-NLS-1$
			"inv: preferredLabel('foo')" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
	}
	
	/**
	 * Tests resolution of nested packages where the root package has a
	 * namespace prefix that differs from the name (in particular, by being
	 * some dot-separated root name).
	 */
	public void test_nestedPackages_129769() {
		EPackage rootPackage = EcoreFactory.eINSTANCE.createEPackage();
		rootPackage.setName("foo"); //$NON-NLS-1$
		rootPackage.setNsPrefix("a.b.c.foo"); //$NON-NLS-1$
		rootPackage.setNsURI("http:///foo.ecore"); //$NON-NLS-1$
		
		EClass a = EcoreFactory.eINSTANCE.createEClass();
		a.setName("A"); //$NON-NLS-1$
		rootPackage.getEClassifiers().add(a);
		
		EPackage nestedPackage = EcoreFactory.eINSTANCE.createEPackage();
		nestedPackage.setName("bar"); //$NON-NLS-1$
		nestedPackage.setNsPrefix("a.b.c.foo.bar"); //$NON-NLS-1$
		nestedPackage.setNsURI("http:///foo/bar.ecore"); //$NON-NLS-1$
		
		rootPackage.getESubpackages().add(nestedPackage);
		
		EClass b = EcoreFactory.eINSTANCE.createEClass();
		b.setName("B"); //$NON-NLS-1$
		nestedPackage.getEClassifiers().add(b);
		
		EPackage.Registry reg = new EPackageRegistryImpl(EPackage.Registry.INSTANCE);
		reg.put(rootPackage.getNsURI(), rootPackage);
		reg.put(nestedPackage.getNsURI(), nestedPackage);
		EcoreEnvironmentFactory ef = new EcoreEnvironmentFactory(reg);
		
		ocl = OCL.newInstance(ef);
		helper = ocl.createOCLHelper();
		helper.setContext(b);
		
		try {
			// look up by name
			helper.createInvariant("not self.oclIsKindOf(foo::A)"); //$NON-NLS-1$
			
			// for compatibility, NS prefix also works
			helper.createInvariant("not self.oclIsKindOf(a::b::c::foo::A)"); //$NON-NLS-1$
		
			helper.setContext(a);
		
			// look-up relative to context package
			helper.createInvariant("not self.oclIsKindOf(bar::B)"); //$NON-NLS-1$
			
			// absolute look-up by name
			helper.createInvariant("not self.oclIsKindOf(foo::bar::B)"); //$NON-NLS-1$
			
			// and by NS prefix
			helper.createInvariant("not self.oclIsKindOf(a::b::c::foo::bar::B)"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests that EClassifier sameness is tested using equality rather than
	 * identity, on the understanding that usually EClasses implement equality
	 * as identity, except for clients such as Bugzilla 126145.
	 */
	@SuppressWarnings("deprecation")
	public void test_typeEquality_126145() {
		class EqualsEClass extends EClassImpl {
			private int key;
			
			EqualsEClass(int key) {
				this.key = key;
			}
			
			@Override
            public boolean equals(Object o) {
				return (o instanceof EqualsEClass)
					&& (key == ((EqualsEClass) o).key);
			}
		}
		
		EPackage epackage = EcoreFactory.eINSTANCE.createEPackage();
		epackage.setName("foo"); //$NON-NLS-1$
		
		EClass a = new EqualsEClass(1);
		a.setName("A"); //$NON-NLS-1$
		epackage.getEClassifiers().add(a);
		
		EClass b = new EqualsEClass(1); // same key as a, so b.equals(a)
		b.setName("B"); //$NON-NLS-1$
		epackage.getEClassifiers().add(b);
		
		EClass c = new EqualsEClass(2);
		c.setName("C"); //$NON-NLS-1$
		epackage.getEClassifiers().add(b);
		
		EReference ref = EcoreFactory.eINSTANCE.createEReference();
		ref.setName("a"); //$NON-NLS-1$
		ref.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
		ref.setOrdered(false);
		ref.setUnique(true);
		ref.setEType(a);
		c.getEStructuralFeatures().add(ref);
		ref = EcoreFactory.eINSTANCE.createEReference();
		ref.setName("b"); //$NON-NLS-1$
		ref.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
		ref.setOrdered(false);
		ref.setUnique(true);
		ref.setEType(b);
		c.getEStructuralFeatures().add(ref);
		
		helper.setContext(c);
		OCLExpression<EClassifier> expr = null;
		
		try {
			expr = helper.createQuery("a->union(b)"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		assertNotNull(expr);
		
		EClassifier type = expr.getType();
		
		assertTrue(type instanceof CollectionType);
		
		type = ((CollectionType) type).getElementType();
		
		// verify that the common supertype is a/b, which are considered by
		//    OCL to be the same type
		assertEquals(a, type);
		assertEquals(b, type);
		
		EcoreEnvironment env = (EcoreEnvironment) ocl.getEnvironment();
		
		assertEquals(UMLReflection.SAME_TYPE, TypeUtil.getRelationship(env, a, b));
		assertEquals(UMLReflection.SAME_TYPE, TypeUtil.getRelationship(env, b, a));
		
		try {
			assertEquals(a, TypeUtil.commonSuperType(env, a, b));
			assertEquals(b, TypeUtil.commonSuperType(env, a, b));
			assertEquals(a, TypeUtil.commonSuperType(env, b, a));
			assertEquals(b, TypeUtil.commonSuperType(env, b, a));
		} catch (Exception e) {
			fail("No common super type: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests referencing an element in an enclosing package using an unqualified name.
	 * 
	 * <ul>
	 * <li>EPackage level1<ul>
	 *   <li>EEnum Enum1<ul>
	 *     <li>EEnumLiteral Enum1Literal1</li></ul></li>
	 *   <li>EPackage level2<ul>
	 *     <li>EClass Class1<ul>
	 *       <li>EAttribute attr1 : Enum1</li></ul></li></ul></li></ul></li>
	 * </ul> 
	 * <pre>
	 *     context: Class1
	 *     expression: attr1 = Enum1::Enum1Literal1
	 * </pre>
	 */
	public void test_enclosingPackage_unqualifiedName() {
		EPackage level1 = EcoreFactory.eINSTANCE.createEPackage();
		level1.setName("level1"); //$NON-NLS-1$
		EPackage level2 = EcoreFactory.eINSTANCE.createEPackage();
		level2.setName("level2"); //$NON-NLS-1$
		
		level1.getESubpackages().add(level2);
		
		EEnum enum1 = EcoreFactory.eINSTANCE.createEEnum();
		enum1.setName("Enum1"); //$NON-NLS-1$
		
		EEnumLiteral enum1Literal1 = EcoreFactory.eINSTANCE.createEEnumLiteral();
		enum1Literal1.setName("Enum1Literal1"); //$NON-NLS-1$
		
		enum1.getELiterals().add(enum1Literal1);
		
		EClass class1 = EcoreFactory.eINSTANCE.createEClass();
		class1.setName("Class1"); //$NON-NLS-1$

		EAttribute attr1 = EcoreFactory.eINSTANCE.createEAttribute();
		attr1.setName("attr1"); //$NON-NLS-1$
		attr1.setEType(enum1);

		class1.getEStructuralFeatures().add(attr1);
		
		level1.getEClassifiers().add(enum1);
		level2.getEClassifiers().add(class1);
		
		helper.setContext(class1);
		
		try {
			helper.createInvariant("attr1 = Enum1::Enum1Literal1"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * The Hebrew (Israel) locale on SuSe Linux likes to use character 0xB4
	 * (acute accent) as a single quotation mark.  Should also, then, support
	 * the back-quote (grave accent), as well.
	 */
	public void test_hebrew_singleQuote_135321() {
		parse(
				// English locale style
				"package ocltest context Apple " + //$NON-NLS-1$
				"inv: preferredLabel('foo')" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
		
		parse(
				// SuSe Linux in Hebrew Local
				"package ocltest context Apple " + //$NON-NLS-1$
				"inv: preferredLabel(´foo´)" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
		
		parse(
				// I've seen this before (esp. in text export from MS Word)
				"package ocltest context Apple " + //$NON-NLS-1$
				"inv: preferredLabel(`foo´)" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
	}
	
	/**
	 * Test that we don't get a <code>null</code> string from an OCL expression
	 * that contains a reference to a variable that has no name.
	 */
	public void test_nullVariableName_143386() {
		org.eclipse.ocl.ecore.Variable var =
			(org.eclipse.ocl.ecore.Variable) oclFactory.<EClassifier, EParameter>createVariable();
		
		assertEquals("\"<null>\"", var.toString()); //$NON-NLS-1$
		
		VariableExp<EClassifier, EParameter> exp =
			oclFactory.createVariableExp();
		exp.setReferredVariable(var);
		
		assertEquals("\"<null>\"", exp.toString()); //$NON-NLS-1$
		
		var.setName("foo"); //$NON-NLS-1$
		
		assertEquals("foo", var.toString()); //$NON-NLS-1$
		assertEquals("foo", exp.toString()); //$NON-NLS-1$
		
		var.setEType(getOCLStandardLibrary().getString());
		
		assertEquals("foo : String", var.toString()); //$NON-NLS-1$
		assertEquals("foo", exp.toString()); //$NON-NLS-1$
	}
    
    /**
     * Regression test for the case of Let expression declaring multiple
     * variables that is well-formed.
     */
    public void test_letWithMultipleVariables_bug164503() {
        OCLExpression<EClassifier> expr = parse(
            "package ocltest context Fruit " + //$NON-NLS-1$
            " inv: let s : String = '', i : Set(Integer) = Set{1}, n : UnlimitedNatural = * in true" + //$NON-NLS-1$
            " endpackage"); //$NON-NLS-1$
        
        // verify the structure of the nested let expression
        
        // first level let is the String variable
        assertTrue(expr instanceof LetExp);
        LetExp<EClassifier, ?> letExp = (LetExp<EClassifier, ?>) expr;
        Variable<EClassifier, ?> var = letExp.getVariable();
        assertEquals("s", var.getName()); //$NON-NLS-1$
        assertSame(getOCLStandardLibrary().getString(), var.getType());
        
        // second level is the Set(Integer)
        assertTrue(letExp.getIn() instanceof LetExp);
        letExp = (LetExp<EClassifier, ?>) letExp.getIn();
        var = letExp.getVariable();
        assertEquals("i", var.getName()); //$NON-NLS-1$
        assertTrue(var.getType() instanceof SetType);
        
        // third level is the UnlimitedNatural
        assertTrue(letExp.getIn() instanceof LetExp);
        letExp = (LetExp<EClassifier, ?>) letExp.getIn();
        var = letExp.getVariable();
        assertEquals("n", var.getName()); //$NON-NLS-1$
        assertSame(getOCLStandardLibrary().getUnlimitedNatural(), var.getType());
        
        // now we have a real "in"
        assertTrue(letExp.getIn() instanceof BooleanLiteralExp);
    }
    
    /**
     * Regression test for the case of Let expression declaring multiple
     * variables that is ill-formed, that we don't fail parsing with a runtime
     * exception.
     */
    public void test_letWithMultipleVariables_illFormed_bug164503() {
        
        try {
            parse(
                "package ocltest context Fruit " + //$NON-NLS-1$
                " inv: let s : String = '', i : Set(Integer) in true" + //$NON-NLS-1$
                " endpackage"); //$NON-NLS-1$
            
            fail("Should have failed to parse or validate"); //$NON-NLS-1$
        } catch (AssertionFailedError e) {
            // success
            System.out.println("Got the expected exception: " + e.getLocalizedMessage()); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Parse failed with run-time exception: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
    
    /**
     * Tests that, where a path name includes two or more components
     * having the same name, the PathNameCS does not remove duplicates.
     */
    public void test_repeatedNamesInPath_176308() {
        EPackage rootpkg = EcoreFactory.eINSTANCE.createEPackage();
        rootpkg.setName("rootpkg"); //$NON-NLS-1$
        EPackage first = EcoreFactory.eINSTANCE.createEPackage();
        first.setName("repeated"); //$NON-NLS-1$
        EPackage second = EcoreFactory.eINSTANCE.createEPackage();
        second.setName("repeated"); //$NON-NLS-1$
        
        rootpkg.getESubpackages().add(first);
        first.getESubpackages().add(second);
        
        EEnum enum1 = EcoreFactory.eINSTANCE.createEEnum();
        enum1.setName("Enum1"); //$NON-NLS-1$
        
        EEnumLiteral enum1Literal1 = EcoreFactory.eINSTANCE.createEEnumLiteral();
        enum1Literal1.setName("Enum1Literal1"); //$NON-NLS-1$
        
        enum1.getELiterals().add(enum1Literal1);
        
        second.getEClassifiers().add(enum1);
        
        EClass dummy = EcoreFactory.eINSTANCE.createEClass();
        dummy.setName("Dummy"); //$NON-NLS-1$
        rootpkg.getEClassifiers().add(dummy);
        
        EAttribute attr1 = EcoreFactory.eINSTANCE.createEAttribute();
        attr1.setName("attr1"); //$NON-NLS-1$
        attr1.setEType(enum1);
        dummy.getEStructuralFeatures().add(attr1);
        
        helper.setContext(dummy);
        
        try {
            // should not attempt to look up "repeated::Enum1"
            helper.createInvariant(
                "attr1 = repeated::repeated::Enum1::Enum1Literal1"); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
    
    /**
     * Tests that dollar signs are supported in string literals and in
     * element names.
     */
    public void test_dollarSignInStrings_163542() {
        EPackage rootpkg = EcoreFactory.eINSTANCE.createEPackage();
        rootpkg.setName("rootpkg"); //$NON-NLS-1$
        rootpkg.setNsURI("http:///rootpkg.ecore"); //$NON-NLS-1$
        
        EClass superclass = EcoreFactory.eINSTANCE.createEClass();
        superclass.setName("Superclass"); //$NON-NLS-1$
        EClass subclass = EcoreFactory.eINSTANCE.createEClass();
        subclass.setName("Sub$Class"); //$NON-NLS-1$
        subclass.getESuperTypes().add(superclass);
        
        rootpkg.getEClassifiers().add(superclass);
        rootpkg.getEClassifiers().add(subclass);
        
        EAttribute attr1 = EcoreFactory.eINSTANCE.createEAttribute();
        attr1.setName("attr$1"); //$NON-NLS-1$
        attr1.setEType(EcorePackage.Literals.ESTRING);
        superclass.getEStructuralFeatures().add(attr1);
        
        EPackage.Registry.INSTANCE.put(rootpkg.getNsURI(), rootpkg);
        
        try {
            // parse dollar sign in comments, element names, and string literals
            ocl.parse(new OCLInput(
                "package rootpkg context Superclass\n" + //$NON-NLS-1$
                "-- this comment has a $ in it\n" + //$NON-NLS-1$
                "inv: attr$1 = 'dollar$sign' implies self.oclIsKindOf(Sub$Class)\n" + //$NON-NLS-1$
                "endpackage")); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        } finally {
            EPackage.Registry.INSTANCE.remove(rootpkg.getNsURI());
        }
    }
    
    /**
     * Tests that we don't get NPEs from getting the names of collection types
     * that do not (yet) have element types.
     */
    public void test_nameOfCollectionTypeWithoutElementType() {
        org.eclipse.ocl.types.CollectionType<?, ?> collType = oclFactory.createCollectionType(
            CollectionKind.BAG_LITERAL, null);
        
        collType.getName();
    }
}
