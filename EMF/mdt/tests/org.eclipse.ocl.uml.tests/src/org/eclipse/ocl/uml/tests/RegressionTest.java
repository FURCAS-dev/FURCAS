/**
 * <copyright>
 *
 * Copyright (c) 2005, 2008 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 248869
 *
 * </copyright>
 *
 * $Id: RegressionTest.java,v 1.13 2009/12/18 06:32:29 ewillink Exp $
 */

package org.eclipse.ocl.uml.tests;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.AssertionFailedError;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.uml.BagType;
import org.eclipse.ocl.uml.CollectionType;
import org.eclipse.ocl.uml.OCL;
import org.eclipse.ocl.uml.OrderedSetType;
import org.eclipse.ocl.uml.SequenceType;
import org.eclipse.ocl.uml.SetType;
import org.eclipse.ocl.uml.TupleType;
import org.eclipse.ocl.uml.UMLEnvironmentFactory;
import org.eclipse.ocl.uml.UMLFactory;
import org.eclipse.ocl.util.Tuple;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.resource.UMLResource;

/**
 * Regression tests for specific RATLC defects.
 *
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class RegressionTest
	extends AbstractTestSuite {
	
	/**
	 * Tests the "..." escape syntax for reserved words.  Regression test for
	 * RATLC00527506.
	 */
	public void test_quoteReservedWords_RATLC00527506() {
        expectModified = true;
		Package epackage = umlf.createPackage();
		epackage.setName("MyPackage");
		fruitPackage.eResource().getContents().add(epackage);
		
		Class eclass = epackage.createOwnedClass("MyType", false);
		
		// "context" is an OCL reserved word
		eclass.createOwnedAttribute("context", getUMLString());
		
		try {
			parseConstraint(
				"package MyPackage context MyType " +
				"inv: self.\"context\"->notEmpty() " +
				"endpackage");
		} finally {
			EcoreUtil.remove(epackage);
		}
	}
	
	/**
	 * Tests the "..." escape syntax for whitespace.  Regression test for
	 * RATLC00527509.
	 */
	public void test_quoteWhitespace_RATLC00527509() {
        expectModified = true;
		Package epackage = umlf.createPackage();
		epackage.setName("MyPackage");
		fruitPackage.eResource().getContents().add(epackage);
		
		Class eclass = epackage.createOwnedClass("MyType", false);
		
		// "context" is an OCL reserved word
		eclass.createOwnedAttribute("an attribute", getUMLString());
		
		try {
			parseConstraint(
				"package MyPackage context MyType " +
				"inv: self.\"an attribute\"->notEmpty() " +
				"endpackage");
		} finally {
			EcoreUtil.remove(epackage);
		}
	}
	
	/**
	 * Tests the \" escape syntax for double-quotes.  Regression test for
	 * RATLC00527509.
	 */
	public void test_quoteQuote_RATLC00527509() {
        expectModified = true;
		Package epackage = umlf.createPackage();
		epackage.setName("MyPackage");
		fruitPackage.eResource().getContents().add(epackage);
		
		Class eclass = epackage.createOwnedClass("MyType", false);
		
		// "context" is an OCL reserved word
		eclass.createOwnedAttribute("an\"attribute", getUMLString());
		
		try {
			// try first to parse within surrounding double-quotes
			parseConstraint(
				"package MyPackage context MyType " +
				"inv: self.\"an\\\"attribute\"->notEmpty() " +
				"endpackage");

			AssertionFailedError err = null;
			
			try {
				// also try to parse without the surrounding double-quotes.
				//   This is not allowed
				parseConstraint(
					"package MyPackage context MyType " +
					"inv: self.an\\\"attribute->notEmpty() " +
					"endpackage");
			} catch (AssertionFailedError e) {
				// success
				err = e;
				System.out.println("Got expected error: " + e.getLocalizedMessage());
			}
			
			assertNotNull("Should not have parsed.", err);
		} finally {
			EcoreUtil.remove(epackage);
		}
	}
	
	/**
	 * Tests the support for international characters.  Regression test for
	 * RATLC01080816.
	 */
	public void test_internationalCharacters_RATLC01080816() {
        expectModified = true;
		Package epackage = umlf.createPackage();
		epackage.setName("MyPackage");
		fruitPackage.eResource().getContents().add(epackage);
		
		Class eclass = epackage.createOwnedClass("MyType", false);
		
		// "context" is an OCL reserved word
		eclass.createOwnedAttribute("\u0160\u01d6\u0429\u0639", getUMLString());
		
		try {
			// try these characters in the attribute name and string literal
			parseConstraint(
				"package MyPackage context MyType " +
				"inv: self.\u0160\u01d6\u0429\u0639 <> '\u0160\u01d6\u0429\u0639' " +
				"endpackage");
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
        expectModified = true;
		Package epackage = umlf.createPackage();
		epackage.setName("MyPackage");
		fruitPackage.eResource().getContents().add(epackage);
		
		// create three classes.  A and B are unrelated, but C extends
		//   both.  Therefore, it is possible to cast a variable of type
		//   A to type B where the run-time type is C
		Class a = epackage.createOwnedClass("A", false);
		Class b = epackage.createOwnedClass("B", false);
		
		Class c = epackage.createOwnedClass("C", false);
		c.createGeneralization(a);
		c.createGeneralization(b);
		
		Property attrA = a.createOwnedAttribute("a", getUMLBoolean());
		Property attrB = b.createOwnedAttribute("b", getUMLBoolean());
		
		try {
			OCLExpression<Classifier> constraint = parseConstraint(
				"package MyPackage context A " +
				"inv: self.oclIsKindOf(B) implies (self.oclAsType(B).b <> self.a) " +
				"endpackage");
			
			InstanceSpecification eobj = instantiate(epackage, c);
			setValue(eobj, attrA, Boolean.TRUE);
			setValue(eobj, attrB, Boolean.TRUE);
			
			assertFalse("Should have failed the check", check(constraint, eobj));
			
			setValue(eobj, attrB, Boolean.FALSE);
			
			assertTrue("Should not have failed the check", check(constraint, eobj));
		} finally {
			EcoreUtil.remove(epackage);
		}
	}
	
	/**
	 * Tests support for short-circuiting AND operator.
	 */
	public void test_shortcircuitAnd_RATLC00536528() {
        expectModified = true;
		Package epackage = umlf.createPackage();
		epackage.setName("MyPackage");
		fruitPackage.eResource().getContents().add(epackage);
		
		Class a = epackage.createOwnedClass("A", false);
		Class b = epackage.createOwnedClass("B", false);
		b.createGeneralization(a);
		
		Property attrA = a.createOwnedAttribute("a", getUMLBoolean());
		Property attrB = b.createOwnedAttribute("b", getUMLBoolean());
		
		try {
			OCLExpression<Classifier> constraint = parseConstraint(
				"package MyPackage context A " +
				"inv: self.oclIsKindOf(B) and self.oclAsType(B).b " +
				"endpackage");
			
			// create an A
			InstanceSpecification eobj = instantiate(epackage, a);
			setValue(eobj, attrA, Boolean.TRUE);
			
			// this would fail with an NPE on the access to '.b' when
			//    'self.oclAsType(B)' evaluates to null, if we didn't short-circuit
			assertFalse("Should have failed the check", check(constraint, eobj));
			
			// create a B this time
			eobj = instantiate(epackage, b);
			setValue(eobj, attrA, Boolean.TRUE);
			setValue(eobj, attrB, Boolean.TRUE);
			
			assertTrue("Should not have failed the check", check(constraint, eobj));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
		} finally {
			EcoreUtil.remove(epackage);
		}
	}
	
	/**
	 * Tests support for short-circuiting OR operator.
	 */
	public void test_shortcircuitOr_RATLC00536528() {
        expectModified = true;
		Package epackage = umlf.createPackage();
		epackage.setName("MyPackage");
		fruitPackage.eResource().getContents().add(epackage);
		
		Class a = epackage.createOwnedClass("A", false);
		Class b = epackage.createOwnedClass("B", false);
		b.createGeneralization(a);
		
		Property attrA = a.createOwnedAttribute("a", getUMLBoolean());
		Property attrB = b.createOwnedAttribute("b", getUMLBoolean());
		
		try {
			OCLExpression<Classifier> constraint = parseConstraint(
				"package MyPackage context A " +
				"inv: (not self.oclIsKindOf(B)) or self.oclAsType(B).b " +
				"endpackage");
			
			// create an A
			InstanceSpecification eobj = instantiate(epackage, a);
			setValue(eobj, attrA, Boolean.TRUE);
			
			// this would fail with an NPE on the access to '.b' when
			//    'self.oclAsType(B)' evaluates to null, if we didn't short-circuit
			assertTrue("Should not have failed the check", check(constraint, eobj));
			
			// create a B this time
			eobj = instantiate(epackage, b);
			setValue(eobj, attrA, Boolean.TRUE);
			setValue(eobj, attrB, Boolean.TRUE);
			
			assertTrue("Should not have failed the check", check(constraint, eobj));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
		} finally {
			EcoreUtil.remove(epackage);
		}
	}
	
	/**
	 * Tests support for short-circuiting IMPLIES operator.
	 */
	public void test_shortcircuitImplies_RATLC00536528() {
        expectModified = true;
		Package epackage = umlf.createPackage();
		epackage.setName("MyPackage");
		fruitPackage.eResource().getContents().add(epackage);
		
		Class a = epackage.createOwnedClass("A", false);
		Class b = epackage.createOwnedClass("B", false);
		b.createGeneralization(a);
		
		Property attrA = a.createOwnedAttribute("a", getUMLBoolean());
		Property attrB = b.createOwnedAttribute("b", getUMLBoolean());
		
		try {
			OCLExpression<Classifier> constraint = parseConstraint(
				"package MyPackage context A " +
				"inv: self.oclIsKindOf(B) implies self.oclAsType(B).b " +
				"endpackage ");
			
			// create an A
			InstanceSpecification eobj = instantiate(epackage, a);
			setValue(eobj, attrA, Boolean.TRUE);
			
			// this would fail with an NPE on the access to '.b' when
			//    'self.oclAsType(B)' evaluates to null, if we didn't short-circuit
			assertTrue("Should not have failed the check", check(constraint, eobj));
			
			// create a B this time
			eobj = instantiate(epackage, b);
			setValue(eobj, attrA, Boolean.TRUE);
			setValue(eobj, attrB, Boolean.FALSE);
			
			assertFalse("Should have failed the check", check(constraint, eobj));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
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
			"package ocltest context Fruit " +
			"inv: color.oclIsNew() " +
			"endpackage");
		
		AssertionFailedError err = null;
		
		try {
			validate(constraint);
		} catch (AssertionFailedError e) {
			// success
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		
		assertNotNull("Should not have succeeded in validating illegal oclIsNew", err);
	}
	
	/**
	 * Tests that we correctly parse the <tt>oclIsNew</tt> operation in
	 * precondition constraints, but that validation reports a suitable error.
	 */
	public void test_oclIsNew_precondition_RATLC00529981() {
		OCLExpression<Classifier> constraint = parseConstraintUnvalidated(
			"package ocltest context Fruit::ripen(c : Color) : Boolean " +
			"pre: c.oclIsNew() implies c <> Color::black " +
			"endpackage");
		
		AssertionFailedError err = null;
		
		try {
			validate(constraint);
		} catch (AssertionFailedError e) {
			// success
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		
		assertNotNull("Should not have succeeded in validating illegal oclIsNew", err);
	}
	
	/**
	 * Tests that we correctly parse the <tt>oclIsNew</tt> operation in
	 * postcondition constraints, and that validation reports no errors.
	 */
	public void test_oclIsNew_postcondition_RATLC00529981() {
		parseConstraint(
			"package ocltest context Fruit::ripen(c : Color) : Boolean " +
			"post: color.oclIsNew() implies color <> Color::black " +
			"endpackage");
	}
	
	/**
	 * Tests that we correctly parse and evaluate the <tt>toLower</tt> operation
	 * on OCL string values.
	 */
	public void test_toLower_RATLC00529981() {
		OCLExpression<Classifier> expr = parse(
			"package ocltest context Fruit " +
			"inv: 'AlPHaBet'.toLower() " +
			"endpackage");
		
		Object value = evaluate(expr);
		
		assertEquals("alphabet", value);
	}
	
	/**
	 * Tests that we correctly parse and evaluate the <tt>toUpper</tt> operation
	 * on OCL string values.
	 */
	public void test_toUpper_RATLC00529981() {
		OCLExpression<Classifier> expr = parse(
			"package ocltest context Fruit " +
			"inv: 'AlPHaBet'.toUpper() " +
			"endpackage");
		
		Object value = evaluate(expr);
		
		assertEquals("ALPHABET", value);
	}
	
	/**
	 * Tests that references that have multiplicity, are unique, and
	 * are ordered are rendered as OCL sets.  Incidentally tests access to
	 * static properties.
	 */
	public void test_referenceMultiplicity_orderedSet_RATLC00538035() {
		OCLExpression<Classifier> expr = parse(
			"package ocltest context Fruit " +
			"inv: FruitUtil.orderedSet" +
			" endpackage");
		
		// check that the result type is an ordered set type
		assertTrue(
			"Not an ordered set type",
			expr.getType() instanceof OrderedSetType);
	}
	
	/**
	 * Tests that references that have multiplicity, are unique, and
	 * are unordered are rendered as OCL sets.  Incidentally tests access to
	 * static properties.
	 */
	public void test_referenceMultiplicity_set_RATLC00538035() {
		OCLExpression<Classifier> expr = parse(
			"package ocltest context Fruit " +
			"inv: FruitUtil.set" +
			" endpackage");
		
		// check that the result type is a set type
		assertTrue(
			"Not a set type",
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
			"package ocltest context Fruit " +
			"inv: FruitUtil.sequence" +
			" endpackage");
		
		// check that the result type is a sequence set type
		assertTrue(
			"Not a sequence type",
			expr.getType() instanceof SequenceType);
	}
	
	/**
	 * Tests that references that have multiplicity, are non-unique, and
	 * are unordered are rendered as OCL bags.  Incidentally tests access to
	 * static properties.
	 */
	public void test_referenceMultiplicity_bag_RATLC00538035() {
		OCLExpression<Classifier> expr = parse(
			"package ocltest context Fruit " +
			"inv: FruitUtil.bag" +
			" endpackage");
		
		// check that the result type is a bag set type
		assertTrue(
			"Not a bag type",
			expr.getType() instanceof BagType);
	}
	
	/**
	 * Tests that operation parameters that have multiplicity, are unique, and
	 * are ordered are rendered as OCL sets.  Incidentally tests access to
	 * static operations.
	 */
	public void test_parameterMultiplicity_orderedSet_RATLC00538035() {
		OCLExpression<Classifier> expr = parse(
			"package ocltest context Fruit " +
			"inv: FruitUtil.processOrderedSet(FruitUtil.orderedSet)" +
			" endpackage");
		
		// now also check that the result type is an ordered set type
		assertTrue(
			"Not an ordered set type",
			expr.getType() instanceof OrderedSetType);
	}
	
	/**
	 * Tests that operation parameters that have multiplicity, are unique, and
	 * are unordered are rendered as OCL sets.  Incidentally tests access to
	 * static operations.
	 */
	public void test_parameterMultiplicity_set_RATLC00538035() {
		OCLExpression<Classifier> expr = parse(
			"package ocltest context Fruit " +
			"inv: FruitUtil.processSet(FruitUtil.set)" +
			" endpackage");
		
		// now also check that the result type is a set type
		assertTrue(
			"Not a set type",
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
			"package ocltest context Fruit " +
			"inv: FruitUtil.processSequence(FruitUtil.sequence)" +
			" endpackage");
		
		// now also check that the result type is a sequence type
		assertTrue(
			"Not a sequence type",
			expr.getType() instanceof SequenceType);
	}
	
	/**
	 * Tests that operation parameters that have multiplicity, are non-unique, and
	 * are unordered are rendered as OCL bags.  Incidentally tests access to
	 * static operations.
	 */
	public void test_parameterMultiplicity_bag_RATLC00538035() {
		OCLExpression<Classifier> expr = parse(
			"package ocltest context Fruit " +
			"inv: FruitUtil.processBag(FruitUtil.bag)" +
			" endpackage");
		
		// now also check that the result type is a bag type
		assertTrue(
			"Not a bag type",
			expr.getType() instanceof BagType);
	}
	
	/**
	 * Tests that operations that have multiplicity, are unique, and
	 * are ordered are rendered as OCL sets.
	 */
	public void test_operationMultiplicity_orderedSet_RATLC00538035() {
		OCLExpression<Classifier> expr = parse(
			"package ocltest context Fruit " +
			"inv: FruitUtil.processOrderedSet(FruitUtil.processOrderedSet(FruitUtil.orderedSet))" +
			" endpackage");
		
		// now also check that the result type is an ordered set type
		assertTrue(
			"Not an ordered set type",
			expr.getType() instanceof OrderedSetType);
	}
	
	/**
	 * Tests that operations that have multiplicity, are unique, and
	 * are unordered are rendered as OCL sets.
	 */
	public void test_operationMultiplicity_set_RATLC00538035() {
		OCLExpression<Classifier> expr = parse(
			"package ocltest context Fruit " +
			"inv: FruitUtil.processSet(FruitUtil.processSet(FruitUtil.set))" +
			" endpackage");
		
		// now also check that the result type is a set type
		assertTrue(
			"Not a set type",
			(expr.getType() instanceof SetType)
				&& !(expr.getType() instanceof OrderedSetType));
	}
	
	/**
	 * Tests that operations that have multiplicity, are non-unique, and
	 * are ordered are rendered as OCL sequences.
	 */
	public void test_operationMultiplicity_sequence_RATLC00538035() {
		OCLExpression<Classifier> expr = parse(
			"package ocltest context Fruit " +
			"inv: FruitUtil.processSequence(FruitUtil.processSequence(FruitUtil.sequence))" +
			" endpackage");
		
		// now also check that the result type is a sequence type
		assertTrue(
			"Not a sequence type",
			expr.getType() instanceof SequenceType);
	}
	
	/**
	 * Tests that operations that have multiplicity, are non-unique, and
	 * are unordered are rendered as OCL bags.
	 */
	public void test_operationMultiplicity_bag_RATLC00538035() {
		OCLExpression<Classifier> expr = parse(
			"package ocltest context Fruit " +
			"inv: FruitUtil.processBag(FruitUtil.processBag(FruitUtil.bag))" +
			" endpackage");
		
		// now also check that the result type is a bag type
		assertTrue(
			"Not a bag type",
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
				"package ocltest context " +
				"FruitUtil::processOrderedSet(x : Fruit) : Fruit " +
				"body: result = x" +
				" endpackage");
		} catch (AssertionFailedError e) {
			// this is expected (success case)
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		assertNotNull("Parse should have failed", err);
		
		// this should work
		parse(
			"package ocltest context " +
			"FruitUtil::processOrderedSet(x : OrderedSet(Fruit)) : OrderedSet(Fruit) " +
			"body: result = x" +
			" endpackage");
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
				"package ocltest context " +
				"FruitUtil::processSet(x : Fruit) : Fruit " +
				"body: result = x" +
				" endpackage");
		} catch (AssertionFailedError e) {
			// this is expected (success case)
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		assertNotNull("Parse should have failed", err);
		
		// this should work
		parse(
			"package ocltest context " +
			"FruitUtil::processSet(x : Set(Fruit)) : Set(Fruit) " +
			"body: result = x" +
			" endpackage");
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
				"package ocltest context " +
				"FruitUtil::processSequence(x : Fruit) : Fruit " +
				"body: result = x" +
				" endpackage");
		} catch (AssertionFailedError e) {
			// this is expected (success case)
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		assertNotNull("Parse should have failed", err);
		
		// this should work
		parse(
			"package ocltest context " +
			"FruitUtil::processSequence(x : Sequence(Fruit)) : Sequence(Fruit) " +
			"body: result = x" +
			" endpackage");
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
				"package ocltest context " +
				"FruitUtil::processBag(x : Fruit) : Fruit " +
				"body: result = x" +
				" endpackage");
		} catch (AssertionFailedError e) {
			// this is expected (success case)
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		assertNotNull("Parse should have failed", err);
		
		// this should work
		parse(
			"package ocltest context " +
			"FruitUtil::processBag(x : Bag(Fruit)) : Bag(Fruit) " +
			"body: result = x" +
			" endpackage");
	}
	
	/**
	 * Regression test to check that <code>allInstances()</code> works as
	 * expected on enumerations.
	 */
	public void test_allInstances_enumeration_RATLC00538079() {
		Object result = evaluate(parse(
			"package ocltest context Fruit " +
			"inv: Color.allInstances() " +
			" endpackage"));
		
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
			"package ocltest context Fruit " +
			"inv: OclVoid.allInstances() " +
			" endpackage"));
		
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
			"package ocltest context Fruit " +
			"inv: UMLPrimitiveTypes::\"String\".allInstances() " +
			" endpackage"));
		
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
				"package ocltest context Fruit " +
				"inv: self)garbage " +
				" endpackage");
		} catch (AssertionFailedError e) {
			// this is expected (success case)
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		assertNotNull("Parse should have failed", err);
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
			helper.createInvariant("self)garbage");
			
			fail("Parse should have failed");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
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
			helper.createPrecondition("self)garbage");
			
			fail("Parse should have failed");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
	}
	
	public void test_operationBodyBoolean_116251() {
		AssertionFailedError err = null;
		
		// this should work
		parseConstraint(
			"package ocltest context " +
			"FruitUtil::processBag(x : Bag(Fruit)) : Bag(Fruit) " +
			"body: result = x->asSet()->asBag()" +
			" endpackage");
		
		// as should this
		parseConstraint(
			"package ocltest context " +
			"FruitUtil::processBag(x : Bag(Fruit)) : Bag(Fruit) " +
			"body: x->asSet()->asBag() = result" +
			" endpackage");
		
		// and this (allow any number of lets to wrap the expression)
		parseConstraint(
			"package ocltest context " +
			"FruitUtil::processBag(x : Bag(Fruit)) : Bag(Fruit) " +
			"body: let set : Set(Fruit) = x->asSet() in" +
			" let bag : Bag(Fruit) = set->asBag() in" +
			" result = bag" +
			" endpackage");
		
		// this should not work, however, because it has the result in the
		//    body expression part of the constraint
		err = null;
		try {
			parseConstraint(
				"package ocltest context " +
				"FruitUtil::processBag(x : Bag(Fruit)) : Bag(Fruit) " +
				"body: result = result->asSet()->union(x)->asBag()" +
				" endpackage");
		} catch (AssertionFailedError e) {
			// this is expected (success case)
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		assertNotNull("Parse should have failed", err);
	}
	
	/**
	 * When resolving unqualified property calls in an inner scope (such as in a loop
	 * expression), the OCL language specification requires that the lookup of the
	 * implicit target of the property call start with the innermost iterator variable
	 * (whether explicitly or implicitly defined) and work outwards until it finds a
	 * match).
	 */
	public void test_innerScopeFeatureResolution_bugzilla113355() {
        expectModified = true;
		Package epackage = umlf.createPackage();
		epackage.setName("MyPackage");
		fruitPackage.eResource().getContents().add(epackage);
		
		// Library1
		//  - Library2
		//    - Writer1
		//    - Writer2
		Class libraryClass = epackage.createOwnedClass("Library", false);
		
		Class writerClass = epackage.createOwnedClass("Writer", false);

		Property branchesRef = libraryClass.createOwnedAttribute("branches", libraryClass);
		branchesRef.setUpper(LiteralUnlimitedNatural.UNLIMITED);
		branchesRef.setIsOrdered(true);
		
		Property writersRef = libraryClass.createOwnedAttribute("writers", writerClass);
		writersRef.setUpper(LiteralUnlimitedNatural.UNLIMITED);
		writersRef.setIsOrdered(true);
		
		Property writerName = writerClass.createOwnedAttribute("name", getUMLString());

		// create our test instance
		InstanceSpecification library1 = instantiate(epackage, libraryClass);
		InstanceSpecification library2 = instantiate(epackage, libraryClass);
		InstanceSpecification writer1 = instantiate(epackage, writerClass);
		InstanceSpecification writer2 = instantiate(epackage, writerClass);
		
		setValue(writer1, writerName, "Joe");
		setValue(writer2, writerName, "Jane");
		
		addValue(library1, branchesRef, library2);
		addValue(library2, writersRef, writer1);
		addValue(library2, writersRef, writer2);
		
		// parse expression
		try {
			OCLExpression<Classifier> expr = parse(
					"package MyPackage context Library " +
					"inv: branches->collect(writers->collect(w : Writer | w))->flatten()" +
					"endpackage");
					
			@SuppressWarnings("unchecked")
			List<InstanceSpecification> result =
				(List<InstanceSpecification>) evaluate(expr, library1);
			
			assertTrue(result.size() == 2);
			assertTrue(getValue(result.get(0), writerName).equals("Joe"));
			assertTrue(getValue(result.get(1), writerName).equals("Jane"));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
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
					"Set{'foo', 'bar'}->product(Sequence{1, 2, 3})");

			Classifier resultType = expr.getType();
			assertTrue(resultType instanceof CollectionType);
			
			Classifier elementType = ((CollectionType) resultType).getElementType();
			
			assertTrue(elementType instanceof TupleType);
			TupleType tupleType = (TupleType) elementType;
			
			assertEquals(2, tupleType.oclProperties().size());
			
			@SuppressWarnings("unchecked")
			Set<Tuple<Operation, Property>> resultValue =
				(Set<Tuple<Operation, Property>>) ocl.evaluate("", expr);
			product = resultValue;
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
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
		
		expectedTuples.put("foo", new java.util.HashSet<Integer>(values));
		expectedTuples.put("bar", new java.util.HashSet<Integer>(values));
		
		for (Tuple<Operation, Property> tuple : product) {
			values = expectedTuples.get(tuple.getValue("first"));
			
			// every "first" value must hit
			assertNotNull(values);
			
			// every "second" must remove a different mapping
			assertTrue(values.remove(tuple.getValue("second")));
		}
	}
	
	/**
	 * Test that the conversion of an expression to string and re-parsing works
	 * as expected.  Use the particular iteration expression described in the
	 * referenced bugzilla.
	 */
	public void test_iterationToString_126454() {
		Package fakePkg = umlf.createPackage();
		fakePkg.setName("fake");
		Class fake = fakePkg.createOwnedClass("Fake", false);
		Property eattr = fake.createOwnedAttribute("e", getUMLInteger());
		eattr.setUpper(1);  // not a collection
		
		InstanceSpecification aFake = instantiate(fakePkg, fake);
		setValue(aFake, eattr, new Integer(7));
		
		helper.setContext(fake);
		
		try {
			OCLExpression<Classifier> expr = helper.createQuery("self.e->sum()");
			
			// convert to string and re-parse
			String toStringResult = expr.toString();
			expr = helper.createQuery(toStringResult);
			
			assertEquals(getValue(aFake, eattr), ocl.evaluate(aFake, expr));
		} catch (Exception exc) {
			fail("Failed to parse or evaluate: " + exc.getLocalizedMessage());
		}
	}
	
	/**
	 * Test the OclVoid literal 'null'.
	 */
	public void test_null() {
		Object result = evaluate(parse(
				"package ocltest context Fruit " +
				"inv: null.oclIsTypeOf(OclVoid) " +
				" endpackage"));
			
		assertEquals(Boolean.TRUE, result);
			
		result = evaluate(parse(
				"package ocltest context Fruit " +
				"inv: null.oclIsUndefined() " +
				" endpackage"));
			
		assertEquals(Boolean.TRUE, result);
			
		result = evaluate(parse(
				"package ocltest context Fruit " +
				"inv: null.oclIsInvalid() " +
				" endpackage"));
			
		assertEquals(Boolean.FALSE, result);
		
		result = evaluate(parse(
				"package ocltest context Fruit " +
				"inv: null.oclAsType(Integer) " +
				" endpackage"));
			
		assertNull(result);
	}
	
	/**
	 * Test the OclInvalid type and its literal 'invalid'.
	 */
	public void test_oclInvalid() {
		Object result = evaluate(parse(
			"package ocltest context Fruit " +
			"inv: invalid.oclIsTypeOf(OclInvalid) " +
			" endpackage"));
		
		assertEquals(Boolean.TRUE, result);
		
		result = evaluate(parse(
				"package ocltest context Fruit " +
				"inv: invalid.oclIsUndefined() " +
				" endpackage"));
			
		assertEquals(Boolean.TRUE, result);
			
		result = evaluate(parse(
				"package ocltest context Fruit " +
				"inv: invalid.oclIsInvalid() " +
				" endpackage"));
			
		assertEquals(Boolean.TRUE, result);
		
		result = evaluate(parse(
				"package ocltest context Fruit " +
				"inv: invalid.oclAsType(Integer) " +
				" endpackage"));
			
		assertInvalid(result);
		
		result = evaluate(parse(
				"package ocltest context Fruit " +
				"inv: null.oclAsType(Apple).color " +
				" endpackage"));
		
		// feature calls on null result in invalid
		assertInvalid(result);
		
		result = evaluate(parse(
				"package ocltest context Fruit " +
				"inv: null.oclAsType(Apple).tree " +
				" endpackage"));
		
		// feature calls on null result in invalid
		assertInvalid(result);
		
		result = evaluate(parse(
				"package ocltest context Fruit " +
				"inv: null.oclAsType(Apple).preferredLabel('foo') " +
				" endpackage"));
		
		// feature calls on null result in invalid
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
				"package ocltest context Fruit " +
				"inv: FruitUtil.processOrderedSet(1) = 0 " +
				" endpackage");
		} catch (AssertionFailedError e) {
			// this is expected (success case)
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		assertNotNull("Parse should have failed", err);
	}
	
	/**
	 * Tests that matching operations finds the first match, but that
	 * casting via oclAsType() can direct the parser to the best match.
	 */
	@SuppressWarnings("unchecked")
	public void test_operationSignatureMatching() {
		Package pkg = umlf.createPackage();
		Class a = pkg.createOwnedClass("A", false);
		Class b = pkg.createOwnedClass("B", false);
		Class c = pkg.createOwnedClass("C", false);
		c.createGeneralization(b);
		
		a.createOwnedAttribute("b", b);
		a.createOwnedAttribute("c", c);
		
		Operation foo1 = a.createOwnedOperation("foo",
				new BasicEList<String>(Collections.singleton("c")),
				new BasicEList<Type>(Collections.singleton((Type) c)),
				getUMLBoolean());
		foo1.setIsQuery(true);
		Operation foo2 = a.createOwnedOperation("foo",
				new BasicEList<String>(Collections.singleton("b")),
				new BasicEList<Type>(Collections.singleton((Type) b)),
				getUMLBoolean());
		foo2.setIsQuery(true);
		
		helper.setContext(a);
		
		try {
			OCLExpression<Classifier> expr = helper.createQuery("self.foo(c)");
			
			assertTrue(expr instanceof OperationCallExp<?, ?>);
			OperationCallExp<Classifier, Operation> oc =
				(OperationCallExp<Classifier, Operation>) expr;
			
			// foo1's parameter type is c
			assertSame(foo1, oc.getReferredOperation());
			
			expr = helper.createQuery("self.foo(b)");
			
			assertTrue(expr instanceof OperationCallExp<?, ?>);
			oc = (OperationCallExp<Classifier, Operation>) expr;
			
			// we matched foo1 because it was the first operation matching b
			//    (we skipped the foo having parameter type c)
			assertSame(foo2, oc.getReferredOperation());
			
			expr = helper.createQuery("self.foo(b.oclAsType(C))");
			
			assertTrue(expr instanceof OperationCallExp<?, ?>);
			oc = (OperationCallExp<Classifier, Operation>) expr;
			
			// coerced the arg to type C to find the correct foo
			assertSame(foo1, oc.getReferredOperation());
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage());
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
				"package ocltest context Fruit " +
				"inv: Apple.allInstances()->collect(preferredLabel())" +
				" endpackage");
		} catch (AssertionFailedError e) {
			// this is expected (success case)
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		assertNotNull("Parse should have failed", err);
		
		// this should work
		parse(
			"package ocltest context Fruit " +
			"inv: Apple.allInstances()->collect(preferredLabel('foo'))" +
			" endpackage");
		
		// and this
		parse(
			"package ocltest context Apple " +
			"inv: preferredLabel('foo')" +
			" endpackage");
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
		level1.setName("level1");
		Package level2 = level1.createNestedPackage("level2");
		
		Enumeration enum1 = level1.createOwnedEnumeration("Enum1");
		
		enum1.createOwnedLiteral("Enum1Literal1");
		
		Class class1 = level2.createOwnedClass("Class1", false);

		class1.createOwnedAttribute("attr1", enum1);
		
		helper.setContext(class1);
		
		try {
			helper.createInvariant("attr1 = Enum1::Enum1Literal1");
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * The Hebrew (Israel) locale on SuSe Linux likes to use character 0xB4
	 * (acute accent) as a single quotation mark.  Should also, then, support
	 * the back-quote (grave accent), as well.
	 */
	public void test_hebrew_singleQuote_135321() {
//		checkForUTF8Encoding();
		
		parse(
				// English locale style
				"package ocltest context Apple " +
				"inv: preferredLabel('foo')" +
				" endpackage");
		
/*		parse( FIXME Bug 291310 rewrite for OCL 2.3 and reintroduce when build is UTF-8.
				// SuSe Linux in Hebrew Local
				"package ocltest context Apple " +
				"inv: preferredLabel(´foo´)" +
				" endpackage");
		
		parse(
				// I've seen this before (esp. in text export from MS Word)
				"package ocltest context Apple " +
				"inv: preferredLabel(`foo´)" +
				" endpackage"); */
	}
	
	/**
	 * Test that we don't get a <code>null</code> string from an OCL expression
	 * that contains a reference to a variable that has no name.
	 */
	public void test_nullVariableName_143386() {
		org.eclipse.ocl.uml.Variable var =
			UMLFactory.eINSTANCE.createVariable();
		
		assertEquals("\"<null>\"", var.toString());
		
		VariableExp<Classifier, Parameter> exp =
			UMLFactory.eINSTANCE.createVariableExp();
		exp.setReferredVariable(var);
		
		assertEquals("\"<null>\"", exp.toString());
		
		var.setName("foo");
		
		assertEquals("foo", var.toString());
		assertEquals("foo", exp.toString());
		
		// recreate to avoid caching of names
		
		var = UMLFactory.eINSTANCE.createVariable();
		var.setName("foo");
		var.setType(getUMLString());
		
		exp = UMLFactory.eINSTANCE.createVariableExp();
		exp.setReferredVariable(var);
		
		assertEquals("foo : String", var.toString());
		assertEquals("foo", exp.toString());
	}
    
    /**
     * Tests that we don't get NPEs from getting the names of collection types
     * that do not (yet) have element types.
     */
    public void test_nameOfCollectionTypeWithoutElementType() {
        org.eclipse.ocl.types.CollectionType<?, ?> collType =
            ocl.getEnvironment().getOCLFactory().createCollectionType(
                CollectionKind.BAG_LITERAL, null);
        
        collType.getName();
    }
    
    /**
     * Tests that disposing an OCL instance correctly disposes the resource
     * created by the type resolver.  This is crucial for cleaning up the
     * CacheAdapter in UML.
     */
    public void test_dispose_resourceOwnedByOCL_213045() {
        helper.setContext(getMetaclass("Action"));
        
        try {
            Constraint constraint = helper.createInvariant("self.owner <> null");
            
            Resource res = constraint.eResource();
            assertSame(ocl.getEnvironment().getTypeResolver().getResource(), res);
            
            Adapter adapter = new AdapterImpl();
            constraint.getSpecification().eAdapters().add(adapter);
            
            assertSame(constraint.getSpecification(), adapter.getTarget());
            
            ocl.dispose();
            
            assertFalse(res.isLoaded());
            assertNull(constraint.eResource());
            assertNull(adapter.getTarget());
        } catch (ParserException e) {
            fail("Should not have failed to parse: " + e.getLocalizedMessage());
        }
    }
    
    /**
     * Tests that disposing an OCL instance does not dispose the resource
     * created by a user.  This is crucial for cleaning up the
     * CacheAdapter in UML.
     */
    public void test_dispose_resourceOwnedByClient_213045() {
        UMLEnvironmentFactory factory = (UMLEnvironmentFactory) ocl.getEnvironment().getFactory();
        ocl.dispose();
        
        Resource res = UMLResource.Factory.INSTANCE.createResource(
            URI.createURI("foo://foo"));
        
        ocl = OCL.newInstance(factory.loadEnvironment(res));
        helper = ocl.createOCLHelper();
        
        helper.setContext(getMetaclass("Action"));
        
        try {
            Constraint constraint = helper.createInvariant("self.owner <> null");
            
            assertSame(res, constraint.eResource());
            
            Adapter adapter = new AdapterImpl();
            constraint.getSpecification().eAdapters().add(adapter);
            
            assertSame(constraint.getSpecification(), adapter.getTarget());
            
            ocl.dispose();
            
            assertTrue(res.isLoaded());
            assertSame(res, constraint.eResource());
            assertSame(constraint.getSpecification(), adapter.getTarget());
        } catch (ParserException e) {
            fail("Should not have failed to parse: " + e.getLocalizedMessage());
        }
    }
}
