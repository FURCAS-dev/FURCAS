/**
 * <copyright>
 *
 * Copyright (c) 2005, 2006 IBM Corporation and others.
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
 * $Id: RegressionTest.java,v 1.3 2007/05/03 22:04:28 cdamus Exp $
 */

package org.eclipse.ocl.uml.tests;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.uml.BagType;
import org.eclipse.ocl.uml.CollectionType;
import org.eclipse.ocl.uml.OrderedSetType;
import org.eclipse.ocl.uml.SequenceType;
import org.eclipse.ocl.uml.SetType;
import org.eclipse.ocl.uml.TupleType;
import org.eclipse.ocl.uml.UMLFactory;
import org.eclipse.ocl.util.Tuple;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

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
		Package epackage = umlf.createPackage();
		epackage.setName("MyPackage"); //$NON-NLS-1$
		fruitPackage.eResource().getContents().add(epackage);
		
		Class eclass = epackage.createOwnedClass("MyType", false); //$NON-NLS-1$
		
		// "context" is an OCL reserved word
		eclass.createOwnedAttribute("context", getUMLString()); //$NON-NLS-1$
		
		try {
			parseConstraint(
				"package MyPackage context MyType " + //$NON-NLS-1$
				"inv: self.\"context\"->notEmpty() " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
		} finally {
			EcoreUtil.remove(epackage);
		}
	}
	
	/**
	 * Tests the "..." escape syntax for whitespace.  Regression test for
	 * RATLC00527509.
	 */
	public void test_quoteWhitespace_RATLC00527509() {
		Package epackage = umlf.createPackage();
		epackage.setName("MyPackage"); //$NON-NLS-1$
		fruitPackage.eResource().getContents().add(epackage);
		
		Class eclass = epackage.createOwnedClass("MyType", false); //$NON-NLS-1$
		
		// "context" is an OCL reserved word
		eclass.createOwnedAttribute("an attribute", getUMLString()); //$NON-NLS-1$
		
		try {
			parseConstraint(
				"package MyPackage context MyType " + //$NON-NLS-1$
				"inv: self.\"an attribute\"->notEmpty() " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
		} finally {
			EcoreUtil.remove(epackage);
		}
	}
	
	/**
	 * Tests the \" escape syntax for double-quotes.  Regression test for
	 * RATLC00527509.
	 */
	public void test_quoteQuote_RATLC00527509() {
		Package epackage = umlf.createPackage();
		epackage.setName("MyPackage"); //$NON-NLS-1$
		fruitPackage.eResource().getContents().add(epackage);
		
		Class eclass = epackage.createOwnedClass("MyType", false); //$NON-NLS-1$
		
		// "context" is an OCL reserved word
		eclass.createOwnedAttribute("an\"attribute", getUMLString()); //$NON-NLS-1$
		
		try {
			// try first to parse within surrounding double-quotes
			parseConstraint(
				"package MyPackage context MyType " + //$NON-NLS-1$
				"inv: self.\"an\\\"attribute\"->notEmpty() " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$

			AssertionFailedError err = null;
			
			try {
				// also try to parse without the surrounding double-quotes.
				//   This is not allowed
				parseConstraint(
					"package MyPackage context MyType " + //$NON-NLS-1$
					"inv: self.an\\\"attribute->notEmpty() " + //$NON-NLS-1$
					"endpackage"); //$NON-NLS-1$
			} catch (AssertionFailedError e) {
				// success
				err = e;
				System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
			}
			
			assertNotNull("Should not have parsed.", err); //$NON-NLS-1$
		} finally {
			EcoreUtil.remove(epackage);
		}
	}
	
	/**
	 * Tests the support for international characters.  Regression test for
	 * RATLC01080816.
	 */
	public void test_internationalCharacters_RATLC01080816() {
		Package epackage = umlf.createPackage();
		epackage.setName("MyPackage"); //$NON-NLS-1$
		fruitPackage.eResource().getContents().add(epackage);
		
		Class eclass = epackage.createOwnedClass("MyType", false); //$NON-NLS-1$
		
		// "context" is an OCL reserved word
		eclass.createOwnedAttribute("\u0160\u01d6\u0429\u0639", getUMLString()); //$NON-NLS-1$
		
		try {
			// try these characters in the attribute name and string literal
			parseConstraint(
				"package MyPackage context MyType " + //$NON-NLS-1$
				"inv: self.\u0160\u01d6\u0429\u0639 <> '\u0160\u01d6\u0429\u0639' " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
		} finally {
			EcoreUtil.remove(epackage);
		}
	}
	
	/**
	 * Tests support for oclIsKindOf() and oclAsType() to cast between
	 * classifiers that are not related, but where their subtypes may be
	 * conformant.
	 */
	public void test_oclIsKindOf_RATLC01087664() {
		Package epackage = umlf.createPackage();
		epackage.setName("MyPackage"); //$NON-NLS-1$
		fruitPackage.eResource().getContents().add(epackage);
		
		// create three classes.  A and B are unrelated, but C extends
		//   both.  Therefore, it is possible to cast a variable of type
		//   A to type B where the run-time type is C
		Class a = epackage.createOwnedClass("A", false); //$NON-NLS-1$
		Class b = epackage.createOwnedClass("B", false); //$NON-NLS-1$
		
		Class c = epackage.createOwnedClass("C", false); //$NON-NLS-1$
		c.createGeneralization(a);
		c.createGeneralization(b);
		
		Property attrA = a.createOwnedAttribute("a", getUMLBoolean()); //$NON-NLS-1$
		Property attrB = b.createOwnedAttribute("b", getUMLBoolean()); //$NON-NLS-1$
		
		try {
			OCLExpression<Classifier> constraint = parseConstraint(
				"package MyPackage context A " + //$NON-NLS-1$
				"inv: self.oclIsKindOf(B) implies (self.oclAsType(B).b <> self.a) " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
			
			InstanceSpecification eobj = instantiate(epackage, c);
			setValue(eobj, attrA, Boolean.TRUE);
			setValue(eobj, attrB, Boolean.TRUE);
			
			assertFalse("Should have failed the check", check(constraint, eobj)); //$NON-NLS-1$
			
			setValue(eobj, attrB, Boolean.FALSE);
			
			assertTrue("Should not have failed the check", check(constraint, eobj)); //$NON-NLS-1$
		} finally {
			EcoreUtil.remove(epackage);
		}
	}
	
	/**
	 * Tests support for short-circuiting AND operator.
	 */
	public void test_shortcircuitAnd_RATLC00536528() {
		Package epackage = umlf.createPackage();
		epackage.setName("MyPackage"); //$NON-NLS-1$
		fruitPackage.eResource().getContents().add(epackage);
		
		Class a = epackage.createOwnedClass("A", false); //$NON-NLS-1$
		Class b = epackage.createOwnedClass("B", false); //$NON-NLS-1$
		b.createGeneralization(a);
		
		Property attrA = a.createOwnedAttribute("a", getUMLBoolean()); //$NON-NLS-1$
		Property attrB = b.createOwnedAttribute("b", getUMLBoolean()); //$NON-NLS-1$
		
		try {
			OCLExpression<Classifier> constraint = parseConstraint(
				"package MyPackage context A " + //$NON-NLS-1$
				"inv: self.oclIsKindOf(B) and self.oclAsType(B).b " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
			
			// create an A
			InstanceSpecification eobj = instantiate(epackage, a);
			setValue(eobj, attrA, Boolean.TRUE);
			
			// this would fail with an NPE on the access to '.b' when
			//    'self.oclAsType(B)' evaluates to null, if we didn't short-circuit
			assertFalse("Should have failed the check", check(constraint, eobj)); //$NON-NLS-1$
			
			// create a B this time
			eobj = instantiate(epackage, b);
			setValue(eobj, attrA, Boolean.TRUE);
			setValue(eobj, attrB, Boolean.TRUE);
			
			assertTrue("Should not have failed the check", check(constraint, eobj)); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		} finally {
			EcoreUtil.remove(epackage);
		}
	}
	
	/**
	 * Tests support for short-circuiting OR operator.
	 */
	public void test_shortcircuitOr_RATLC00536528() {
		Package epackage = umlf.createPackage();
		epackage.setName("MyPackage"); //$NON-NLS-1$
		fruitPackage.eResource().getContents().add(epackage);
		
		Class a = epackage.createOwnedClass("A", false); //$NON-NLS-1$
		Class b = epackage.createOwnedClass("B", false); //$NON-NLS-1$
		b.createGeneralization(a);
		
		Property attrA = a.createOwnedAttribute("a", getUMLBoolean()); //$NON-NLS-1$
		Property attrB = b.createOwnedAttribute("b", getUMLBoolean()); //$NON-NLS-1$
		
		try {
			OCLExpression<Classifier> constraint = parseConstraint(
				"package MyPackage context A " + //$NON-NLS-1$
				"inv: (not self.oclIsKindOf(B)) or self.oclAsType(B).b " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
			
			// create an A
			InstanceSpecification eobj = instantiate(epackage, a);
			setValue(eobj, attrA, Boolean.TRUE);
			
			// this would fail with an NPE on the access to '.b' when
			//    'self.oclAsType(B)' evaluates to null, if we didn't short-circuit
			assertTrue("Should not have failed the check", check(constraint, eobj)); //$NON-NLS-1$
			
			// create a B this time
			eobj = instantiate(epackage, b);
			setValue(eobj, attrA, Boolean.TRUE);
			setValue(eobj, attrB, Boolean.TRUE);
			
			assertTrue("Should not have failed the check", check(constraint, eobj)); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		} finally {
			EcoreUtil.remove(epackage);
		}
	}
	
	/**
	 * Tests support for short-circuiting IMPLIES operator.
	 */
	public void test_shortcircuitImplies_RATLC00536528() {
		Package epackage = umlf.createPackage();
		epackage.setName("MyPackage"); //$NON-NLS-1$
		fruitPackage.eResource().getContents().add(epackage);
		
		Class a = epackage.createOwnedClass("A", false); //$NON-NLS-1$
		Class b = epackage.createOwnedClass("B", false); //$NON-NLS-1$
		b.createGeneralization(a);
		
		Property attrA = a.createOwnedAttribute("a", getUMLBoolean()); //$NON-NLS-1$
		Property attrB = b.createOwnedAttribute("b", getUMLBoolean()); //$NON-NLS-1$
		
		try {
			OCLExpression<Classifier> constraint = parseConstraint(
				"package MyPackage context A " + //$NON-NLS-1$
				"inv: self.oclIsKindOf(B) implies self.oclAsType(B).b " + //$NON-NLS-1$
				"endpackage "); //$NON-NLS-1$
			
			// create an A
			InstanceSpecification eobj = instantiate(epackage, a);
			setValue(eobj, attrA, Boolean.TRUE);
			
			// this would fail with an NPE on the access to '.b' when
			//    'self.oclAsType(B)' evaluates to null, if we didn't short-circuit
			assertTrue("Should not have failed the check", check(constraint, eobj)); //$NON-NLS-1$
			
			// create a B this time
			eobj = instantiate(epackage, b);
			setValue(eobj, attrA, Boolean.TRUE);
			setValue(eobj, attrB, Boolean.FALSE);
			
			assertFalse("Should have failed the check", check(constraint, eobj)); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		} finally {
			EcoreUtil.remove(epackage);
		}
	}
	
	/**
	 * Tests that we correctly parse the <tt>oclIsNew</tt> operation in
	 * invariant constraints, but that validation reports a suitable error.
	 */
	public void test_oclIsNew_invariant_RATLC00529981() {
		OCLExpression<Classifier> constraint = parseConstraintUnvalidated(
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
		OCLExpression<Classifier> constraint = parseConstraintUnvalidated(
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
		OCLExpression<Classifier> expr = parse(
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
		OCLExpression<Classifier> expr = parse(
			"package ocltest context Fruit " + //$NON-NLS-1$
			"inv: 'AlPHaBet'.toUpper() " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		Object value = evaluate(expr);
		
		assertEquals("ALPHABET", value); //$NON-NLS-1$
	}
	
	/**
	 * Tests that references that have multiplicity, are unique, and
	 * are ordered are rendered as OCL sets.  Incidentally tests access to
	 * static properties.
	 */
	public void test_referenceMultiplicity_orderedSet_RATLC00538035() {
		OCLExpression<Classifier> expr = parse(
			"package ocltest context Fruit " + //$NON-NLS-1$
			"inv: FruitUtil.orderedSet" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		// check that the result type is an ordered set type
		assertTrue(
			"Not an ordered set type", //$NON-NLS-1$
			expr.getType() instanceof OrderedSetType);
	}
	
	/**
	 * Tests that references that have multiplicity, are unique, and
	 * are unordered are rendered as OCL sets.  Incidentally tests access to
	 * static properties.
	 */
	public void test_referenceMultiplicity_set_RATLC00538035() {
		OCLExpression<Classifier> expr = parse(
			"package ocltest context Fruit " + //$NON-NLS-1$
			"inv: FruitUtil.set" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		// check that the result type is a set type
		assertTrue(
			"Not a set type", //$NON-NLS-1$
			(expr.getType() instanceof SetType)
				&& !(expr.getType() instanceof OrderedSetType));
	}
	
	/**
	 * Tests that references that have multiplicity, are non-unique, and
	 * are ordered are rendered as OCL sequences.  Incidentally tests access to
	 * static properties.
	 */
	public void test_referenceMultiplicity_sequence_RATLC00538035() {
		OCLExpression<Classifier> expr = parse(
			"package ocltest context Fruit " + //$NON-NLS-1$
			"inv: FruitUtil.sequence" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		// check that the result type is a sequence set type
		assertTrue(
			"Not a sequence type", //$NON-NLS-1$
			expr.getType() instanceof SequenceType);
	}
	
	/**
	 * Tests that references that have multiplicity, are non-unique, and
	 * are unordered are rendered as OCL bags.  Incidentally tests access to
	 * static properties.
	 */
	public void test_referenceMultiplicity_bag_RATLC00538035() {
		OCLExpression<Classifier> expr = parse(
			"package ocltest context Fruit " + //$NON-NLS-1$
			"inv: FruitUtil.bag" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		// check that the result type is a bag set type
		assertTrue(
			"Not a bag type", //$NON-NLS-1$
			expr.getType() instanceof BagType);
	}
	
	/**
	 * Tests that operation parameters that have multiplicity, are unique, and
	 * are ordered are rendered as OCL sets.  Incidentally tests access to
	 * static operations.
	 */
	public void test_parameterMultiplicity_orderedSet_RATLC00538035() {
		OCLExpression<Classifier> expr = parse(
			"package ocltest context Fruit " + //$NON-NLS-1$
			"inv: FruitUtil.processOrderedSet(FruitUtil.orderedSet)" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		// now also check that the result type is an ordered set type
		assertTrue(
			"Not an ordered set type", //$NON-NLS-1$
			expr.getType() instanceof OrderedSetType);
	}
	
	/**
	 * Tests that operation parameters that have multiplicity, are unique, and
	 * are unordered are rendered as OCL sets.  Incidentally tests access to
	 * static operations.
	 */
	public void test_parameterMultiplicity_set_RATLC00538035() {
		OCLExpression<Classifier> expr = parse(
			"package ocltest context Fruit " + //$NON-NLS-1$
			"inv: FruitUtil.processSet(FruitUtil.set)" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		// now also check that the result type is a set type
		assertTrue(
			"Not a set type", //$NON-NLS-1$
			(expr.getType() instanceof SetType)
				&& !(expr.getType() instanceof OrderedSetType));
	}
	
	/**
	 * Tests that operation parameters that have multiplicity, are non-unique, and
	 * are ordered are rendered as OCL sequences.  Incidentally tests access to
	 * static operations.
	 */
	public void test_parameterMultiplicity_sequence_RATLC00538035() {
		OCLExpression<Classifier> expr = parse(
			"package ocltest context Fruit " + //$NON-NLS-1$
			"inv: FruitUtil.processSequence(FruitUtil.sequence)" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		// now also check that the result type is a sequence type
		assertTrue(
			"Not a sequence type", //$NON-NLS-1$
			expr.getType() instanceof SequenceType);
	}
	
	/**
	 * Tests that operation parameters that have multiplicity, are non-unique, and
	 * are unordered are rendered as OCL bags.  Incidentally tests access to
	 * static operations.
	 */
	public void test_parameterMultiplicity_bag_RATLC00538035() {
		OCLExpression<Classifier> expr = parse(
			"package ocltest context Fruit " + //$NON-NLS-1$
			"inv: FruitUtil.processBag(FruitUtil.bag)" + //$NON-NLS-1$
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
		OCLExpression<Classifier> expr = parse(
			"package ocltest context Fruit " + //$NON-NLS-1$
			"inv: FruitUtil.processOrderedSet(FruitUtil.processOrderedSet(FruitUtil.orderedSet))" + //$NON-NLS-1$
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
		OCLExpression<Classifier> expr = parse(
			"package ocltest context Fruit " + //$NON-NLS-1$
			"inv: FruitUtil.processSet(FruitUtil.processSet(FruitUtil.set))" + //$NON-NLS-1$
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
		OCLExpression<Classifier> expr = parse(
			"package ocltest context Fruit " + //$NON-NLS-1$
			"inv: FruitUtil.processSequence(FruitUtil.processSequence(FruitUtil.sequence))" + //$NON-NLS-1$
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
		OCLExpression<Classifier> expr = parse(
			"package ocltest context Fruit " + //$NON-NLS-1$
			"inv: FruitUtil.processBag(FruitUtil.processBag(FruitUtil.bag))" + //$NON-NLS-1$
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
		
		Set<EnumerationLiteral> expected = new java.util.HashSet<EnumerationLiteral>(
				color.getOwnedLiterals());
		
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
			"inv: UMLPrimitiveTypes::\"String\".allInstances() " + //$NON-NLS-1$
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
		Package epackage = umlf.createPackage();
		epackage.setName("MyPackage"); //$NON-NLS-1$
		fruitPackage.eResource().getContents().add(epackage);
		
		// Library1
		//  - Library2
		//    - Writer1
		//    - Writer2
		Class libraryClass = epackage.createOwnedClass("Library", false); //$NON-NLS-1$
		
		Class writerClass = epackage.createOwnedClass("Writer", false); //$NON-NLS-1$

		Property branchesRef = libraryClass.createOwnedAttribute("branches", libraryClass); //$NON-NLS-1$
		branchesRef.setUpper(LiteralUnlimitedNatural.UNLIMITED);
		branchesRef.setIsOrdered(true);
		
		Property writersRef = libraryClass.createOwnedAttribute("writers", writerClass); //$NON-NLS-1$
		writersRef.setUpper(LiteralUnlimitedNatural.UNLIMITED);
		writersRef.setIsOrdered(true);
		
		Property writerName = writerClass.createOwnedAttribute("name", getUMLString()); //$NON-NLS-1$

		// create our test instance
		InstanceSpecification library1 = instantiate(epackage, libraryClass);
		InstanceSpecification library2 = instantiate(epackage, libraryClass);
		InstanceSpecification writer1 = instantiate(epackage, writerClass);
		InstanceSpecification writer2 = instantiate(epackage, writerClass);
		
		setValue(writer1, writerName, "Joe"); //$NON-NLS-1$
		setValue(writer2, writerName, "Jane"); //$NON-NLS-1$
		
		addValue(library1, branchesRef, library2);
		addValue(library2, writersRef, writer1);
		addValue(library2, writersRef, writer2);
		
		// parse expression
		try {
			OCLExpression<Classifier> expr = parse(
					"package MyPackage context Library " + //$NON-NLS-1$
					"inv: branches->collect(writers->collect(w : Writer | w))->flatten()" + //$NON-NLS-1$
					"endpackage"); //$NON-NLS-1$
					
			@SuppressWarnings("unchecked")
			List<InstanceSpecification> result =
				(List<InstanceSpecification>) evaluate(expr, library1);
			
			assertTrue(result.size() == 2);
			assertTrue(getValue(result.get(0), writerName).equals("Joe")); //$NON-NLS-1$
			assertTrue(getValue(result.get(1), writerName).equals("Jane")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		} finally {
			EcoreUtil.remove(epackage);
		}
	}
	
	/**
	 * Tests the collection product() operation.
	 */
	public void test_product_126336() {
		helper.setContext(getUMLString());
		
		Set<Tuple<Operation, Property>> product = null;
		
		try {
			OCLExpression<Classifier> expr = helper.createQuery(
					"Set{'foo', 'bar'}->product(Sequence{1, 2, 3})"); //$NON-NLS-1$

			Classifier resultType = expr.getType();
			assertTrue(resultType instanceof CollectionType);
			
			Classifier elementType = ((CollectionType) resultType).getElementType();
			
			assertTrue(elementType instanceof TupleType);
			TupleType tupleType = (TupleType) elementType;
			
			assertEquals(2, tupleType.oclProperties().size());
			
			@SuppressWarnings("unchecked")
			Set<Tuple<Operation, Property>> resultValue =
				(Set<Tuple<Operation, Property>>) ocl.evaluate("", expr); //$NON-NLS-1$
			product = resultValue;
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
		
		for (Tuple<Operation, Property> tuple : product) {
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
		Package fakePkg = umlf.createPackage();
		fakePkg.setName("fake"); //$NON-NLS-1$
		Class fake = fakePkg.createOwnedClass("Fake", false); //$NON-NLS-1$
		Property eattr = fake.createOwnedAttribute("e", getUMLInteger()); //$NON-NLS-1$
		eattr.setUpper(1);  // not a collection
		
		InstanceSpecification aFake = instantiate(fakePkg, fake);
		setValue(aFake, eattr, new Integer(7));
		
		helper.setContext(fake);
		
		try {
			OCLExpression<Classifier> expr = helper.createQuery("self.e->sum()"); //$NON-NLS-1$
			
			// convert to string and re-parse
			String toStringResult = expr.toString();
			expr = helper.createQuery(toStringResult);
			
			assertEquals(getValue(aFake, eattr), ocl.evaluate(aFake, expr));
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
				"inv: null.oclAsType(Apple).tree " + //$NON-NLS-1$
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
				"package ocltest context Fruit " + //$NON-NLS-1$
				"inv: FruitUtil.processOrderedSet(1) = 0 " + //$NON-NLS-1$
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
		Package pkg = umlf.createPackage();
		Class a = pkg.createOwnedClass("A", false); //$NON-NLS-1$
		Class b = pkg.createOwnedClass("B", false); //$NON-NLS-1$
		Class c = pkg.createOwnedClass("C", false); //$NON-NLS-1$
		c.createGeneralization(b);
		
		a.createOwnedAttribute("b", b); //$NON-NLS-1$
		a.createOwnedAttribute("c", c); //$NON-NLS-1$
		
		Operation foo1 = a.createOwnedOperation("foo", //$NON-NLS-1$
				new BasicEList<String>(Collections.singleton("c")), //$NON-NLS-1$
				new BasicEList<Type>(Collections.singleton((Type) c)),
				getUMLBoolean());
		foo1.setIsQuery(true);
		Operation foo2 = a.createOwnedOperation("foo", //$NON-NLS-1$
				new BasicEList<String>(Collections.singleton("b")), //$NON-NLS-1$
				new BasicEList<Type>(Collections.singleton((Type) b)),
				getUMLBoolean());
		foo2.setIsQuery(true);
		
		helper.setContext(a);
		
		try {
			OCLExpression<Classifier> expr = helper.createQuery("self.foo(c)"); //$NON-NLS-1$
			
			assertTrue(expr instanceof OperationCallExp);
			OperationCallExp<Classifier, Operation> oc =
				(OperationCallExp<Classifier, Operation>) expr;
			
			// foo1's parameter type is c
			assertSame(foo1, oc.getReferredOperation());
			
			expr = helper.createQuery("self.foo(b)"); //$NON-NLS-1$
			
			assertTrue(expr instanceof OperationCallExp);
			oc = (OperationCallExp<Classifier, Operation>) expr;
			
			// we matched foo1 because it was the first operation matching b
			//    (we skipped the foo having parameter type c)
			assertSame(foo2, oc.getReferredOperation());
			
			expr = helper.createQuery("self.foo(b.oclAsType(C))"); //$NON-NLS-1$
			
			assertTrue(expr instanceof OperationCallExp);
			oc = (OperationCallExp<Classifier, Operation>) expr;
			
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
		Package level1 = umlf.createPackage();
		level1.setName("level1"); //$NON-NLS-1$
		Package level2 = level1.createNestedPackage("level2"); //$NON-NLS-1$
		
		Enumeration enum1 = level1.createOwnedEnumeration("Enum1"); //$NON-NLS-1$
		
		enum1.createOwnedLiteral("Enum1Literal1"); //$NON-NLS-1$
		
		Class class1 = level2.createOwnedClass("Class1", false); //$NON-NLS-1$

		class1.createOwnedAttribute("attr1", enum1); //$NON-NLS-1$
		
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
		org.eclipse.ocl.uml.Variable var =
			UMLFactory.eINSTANCE.createVariable();
		
		assertEquals("\"<null>\"", var.toString()); //$NON-NLS-1$
		
		VariableExp<Classifier, Parameter> exp =
			UMLFactory.eINSTANCE.createVariableExp();
		exp.setReferredVariable(var);
		
		assertEquals("\"<null>\"", exp.toString()); //$NON-NLS-1$
		
		var.setName("foo"); //$NON-NLS-1$
		
		assertEquals("foo", var.toString()); //$NON-NLS-1$
		assertEquals("foo", exp.toString()); //$NON-NLS-1$
		
		// recreate to avoid caching of names
		
		var = UMLFactory.eINSTANCE.createVariable();
		var.setName("foo"); //$NON-NLS-1$
		var.setType(getUMLString());
		
		exp = UMLFactory.eINSTANCE.createVariableExp();
		exp.setReferredVariable(var);
		
		assertEquals("foo : String", var.toString()); //$NON-NLS-1$
		assertEquals("foo", exp.toString()); //$NON-NLS-1$
	}
}
