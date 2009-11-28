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
 *
 * </copyright>
 *
 * $Id: IteratorsTest.java,v 1.9 2009/11/28 17:51:06 ewillink Exp $
 */

package org.eclipse.ocl.ecore.tests;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.ParserException;

/**
 * Tests for iterator expressions.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class IteratorsTest
    extends AbstractTestSuite {

    EPackage pkg1;
    EPackage pkg2;
    EPackage pkg3;
    EPackage pkg4;
    EPackage pkg5;
    EPackage jim;
    EPackage bob;
    EPackage george;

    /**
     * Tests the generic iterate() iterator.
     */
    public void test_iterate_143996() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);

        try {
            String expected = "pkg2bobpkg3";

            // complete form
            assertEquals(
                expected,
                evaluate(helper, pkg1,
                    "eSubpackages->iterate(p : EPackage; s : String = '' | s.concat(p.name))"));

            // shorter form
            assertEquals(expected, evaluate(helper, pkg1,
                "eSubpackages->iterate(p; s : String = '' | s.concat(p.name))"));

            // shortest form
            assertEquals(expected, evaluate(helper, pkg1,
                "eSubpackages->iterate(s : String = ''| s.concat(name))"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests the select() iterator.
     */
    public void test_select() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);

        try {
            Set<EPackage> expected = new java.util.LinkedHashSet<EPackage>();
            expected.add(pkg2);
            expected.add(pkg3);

            // complete form
            assertEquals(expected, evaluate(helper, pkg1,
                "eSubpackages->select(p : EPackage | p.name <> 'bob')"));

            // shorter form
            assertEquals(expected, evaluate(helper, pkg1,
                "eSubpackages->select(p | p.name <> 'bob')"));

            // shortest form
            assertEquals(expected, evaluate(helper, pkg1,
                "eSubpackages->select(name <> 'bob')"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests the reject() iterator.
     */
    public void test_reject() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);

        try {
            Set<EPackage> expected = new java.util.LinkedHashSet<EPackage>();
            expected.add(pkg2);
            expected.add(pkg3);

            // complete form
            assertEquals(expected, evaluate(helper, pkg1,
                "eSubpackages->reject(p : EPackage | p.name = 'bob')"));

            // shorter form
            assertEquals(expected, evaluate(helper, pkg1,
                "eSubpackages->reject(p | p.name = 'bob')"));

            // shortest form
            assertEquals(expected, evaluate(helper, pkg1,
                "eSubpackages->reject(name = 'bob')"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests the any() iterator.
     */
    public void test_any() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);

        try {
            // complete form
            assertSame(bob, evaluate(helper, pkg1,
                "eSubpackages->any(p : EPackage | p.name = 'bob')"));

            // shorter form
            assertSame(bob, evaluate(helper, pkg1,
                "eSubpackages->any(p | p.name = 'bob')"));

            // shortest form
            assertSame(bob, evaluate(helper, pkg1,
                "eSubpackages->any(name = 'bob')"));

            // negative
            assertNotSame(bob, evaluate(helper, pkg1,
                "eSubpackages->any(name = 'pkg2')"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests the isUnique() iterator.
     */
    public void test_isUnique_126861() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);

        try {
            assertTrue(check(helper, pkg1,
                "Sequence{'a', 'b', 'c', 'd', 'e'}->isUnique(e | e)"));

            assertFalse(check(helper, pkg1,
                "Sequence{'a', 'b', 'c', 'c', 'e'}->isUnique(e | e)"));

            // when there are no values, they implicitly all evaluate to a
            // different result
            assertTrue(check(helper, pkg1, "Sequence{}->isUnique(e | e)"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests the exists() iterator.
     */
    public void test_exists() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);

        try {
            assertTrue(check(helper, pkg1,
                "Sequence{'a', 'b', 'c', 'd', 'e'}->exists(e | e = 'c')"));

            assertTrue(check(helper, pkg1,
                "Sequence{'a', 'b', 'c', 'c', 'e'}->exists(e | e = 'c')"));

            assertFalse(check(helper, pkg1,
                "Sequence{'a', 'b', 'd', 'e'}->exists(e | e = 'c')"));

            // when there are no values, they the desired result implictly
            // does not occur
            assertFalse(check(helper, pkg1, "Sequence{}->exists(e | e = 'c')"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests the forAll() iterator.
     */
    public void test_forAll() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);

        try {
            assertFalse(check(helper, pkg1,
                "Sequence{'a', 'b', 'c', 'd', 'e'}->forAll(e | e = 'c')"));

            assertFalse(check(helper, pkg1,
                "Sequence{'a', 'b', 'd', 'e'}->forAll(e | e = 'c')"));

            assertTrue(check(helper, pkg1,
                "Sequence{'c', 'c', 'c', 'c'}->forAll(e | e = 'c')"));

            assertTrue(check(helper, pkg1, "Sequence{'c'}->forAll(e | e = 'c')"));

            // when there are no values, they implicitly all evaluate to the
            // desired result
            assertTrue(check(helper, pkg1, "Sequence{}->forAll(e | e = 'c')"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests the one() iterator.
     */
    public void test_one() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);

        try {
            assertTrue(check(helper, pkg1,
                "Sequence{'a', 'b', 'c', 'd', 'e'}->one(e | e = 'c')"));

            assertFalse(check(helper, pkg1,
                "Sequence{'a', 'b', 'c', 'c', 'e'}->one(e | e = 'c')"));

            assertFalse(check(helper, pkg1,
                "Sequence{'a', 'b', 'd', 'e'}->one(e | e = 'c')"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests the collect() iterator.
     */
    public void test_collect() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);

        try {
            List<Object> expected = new java.util.ArrayList<Object>();
            expected.add("pkg2");
            expected.add("bob");
            expected.add("pkg3");

            // complete form
            assertEquals(expected, evaluate(helper, pkg1,
                "eSubpackages->collect(p : EPackage | p.name)"));

            // shorter form
            assertEquals(expected, evaluate(helper, pkg1,
                "eSubpackages->collect(p | p.name)"));

            // yet shorter form
            assertEquals(expected, evaluate(helper, pkg1,
                "eSubpackages->collect(name)"));

            // shortest form
            assertEquals(expected, evaluate(helper, pkg1, "eSubpackages.name"));

            // flattening of nested collections
            expected.clear();
            expected.add(jim);
            expected.add(pkg4);
            expected.add(pkg5);

            assertEquals(expected, evaluate(helper, pkg1,
                "eSubpackages.eSubpackages"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests that parsing fails, in the case of an unknown property in a
     * collection navigation, with an appropriate parse failure, not a
     * <code>ClassCastException</code>.
     */
    public void test_implicitCollect_unknownAttribute_232669() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);

        try {
            // this shouldn't parse, anyway
            helper.createInvariant("eSubpackages.unknownAttribute");

            fail("Should not have parsed");
        } catch (ParserException e) {
        	// should have a diagnostic describing the problem if it is a
        	// "normal" parse failure
        	assertNoException(getDiagnostic(), ClassCastException.class);
        }
   }

    /**
     * Tests that parsing fails, in the case of an unknown operation in a
     * collection navigation, with an appropriate parse failure, not a
     * <code>ClassCastException</code>.
     */
    public void test_implicitCollect_unknownOperation_232669() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);

        try {
            // this shouldn't parse, anyway
        	helper.createInvariant("eSubpackages.unknownOperation(self)");

            fail("Should not have parsed");
        } catch (ParserException e) {
        	// should have a diagnostic describing the problem if it is a
        	// "normal" parse failure
        	assertNoException(getDiagnostic(), ClassCastException.class);
        }
   }

    /**
     * Tests that the collect() iterator correctly flattens its result.
     */
    public void test_collect_flattens_217461() {
        helper.setContext(EcorePackage.Literals.ESTRING);
        String self = "foo";
        
        try {
            List<String> expected = new java.util.ArrayList<String>(3);
            expected.add("THIS AND");
            expected.add("THAT");
            expected.add("THE OTHER");

            assertEquals(expected, evaluate(helper, self,
                "Sequence{Sequence{'this and', 'that'}, Sequence{'the other'}}->collect(s : Sequence(String) | s.toUpper())"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests that the collect() iterator correctly deals with empty collections.
     */
    public void test_collect_empty_217461() {
        helper.setContext(EcorePackage.Literals.ESTRING);
        String self = "foo";
        
        try {
            List<String> expected = Collections.emptyList();

            assertEquals(expected, evaluate(helper, self,
                "let c : Sequence(OrderedSet(String)) = Sequence{} in c->collect(s : OrderedSet(String) | s.toUpper())"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests the collectNested() iterator.
     */
    public void test_collectNested() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);

        try {
            List<Object> expected = new java.util.ArrayList<Object>();
            expected.add("pkg2");
            expected.add("bob");
            expected.add("pkg3");

            // complete form
            assertEquals(expected, evaluate(helper, pkg1,
                "eSubpackages->collectNested(p : EPackage | p.name)"));

            // shorter form
            assertEquals(expected, evaluate(helper, pkg1,
                "eSubpackages->collectNested(p | p.name)"));

            // shortest form
            assertEquals(expected, evaluate(helper, pkg1,
                "eSubpackages->collectNested(name)"));

            // nested collections not flattened
            expected.clear();
            expected.add(Collections.singleton(jim));
            expected.add(Collections.EMPTY_SET);
            expected.add(new java.util.HashSet<Object>(Arrays
                .asList(new Object[] {pkg4, pkg5})));

            assertEquals(expected, evaluate(helper, pkg1,
                "eSubpackages->collectNested(eSubpackages)"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests the sortedBy() iterator.
     */
    public void test_sortedBy() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);

        try {
            LinkedHashSet<EPackage> expectedSet = new LinkedHashSet<EPackage>();
            expectedSet.add(bob);
            expectedSet.add(pkg2);
            expectedSet.add(pkg3);

            // complete form
            assertEquals(expectedSet, evaluate(helper, pkg1,
                "eSubpackages->sortedBy(p : EPackage | p.name)"));

            // shorter form
            assertEquals(expectedSet, evaluate(helper, pkg1,
                "eSubpackages->sortedBy(p | p.name)"));

            // shortest form
            assertEquals(expectedSet, evaluate(helper, pkg1,
                "eSubpackages->sortedBy(name)"));

            List<String> expected = new java.util.ArrayList<String>();
            expected.add("a");
            expected.add("b");
            expected.add("c");
            expected.add("d");
            expected.add("e");

            assertEquals(expected, evaluate(helper, pkg1,
                "Bag{'d', 'b', 'e', 'a', 'c'}->sortedBy(e | e)"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests the closure() iterator.
     */
    public void test_closure() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);

        try {
            Set<EPackage> expected = new java.util.HashSet<EPackage>();
            expected.add(pkg1);
            expected.add(pkg3);
            expected.add(pkg5);
            // closure does not include self (george)

            assertEquals(expected, evaluate(helper, george,
                "self->closure(eSuperPackage)"));

            expected.remove(pkg1); // closure does not include self (pkg1)
            expected.add(pkg2);
            expected.add(jim);
            expected.add(bob);
            expected.add(pkg4);
            expected.add(george);

            assertEquals(expected, evaluate(helper, pkg1,
                "self->closure(eSubpackages)"));

            // empty closure
            expected.clear();
            assertEquals(expected, evaluate(helper, pkg1,
                "self->closure(eSuperPackage)"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests that the closure() iterator handles cycles.
     */
    public void test_closure_cycles() {
        helper.setContext(EcorePackage.Literals.EREFERENCE);

        try {
            Set<EReference> expected = new java.util.HashSet<EReference>();
            expected.add(EcorePackage.Literals.EPACKAGE__ESUBPACKAGES);
            expected.add(EcorePackage.Literals.EPACKAGE__ESUPER_PACKAGE);
            // cyclic closure *does* include self

            assertEquals(expected, evaluate(helper,
                EcorePackage.Literals.EPACKAGE__ESUPER_PACKAGE,
                "self->closure(eOpposite)"));

            assertEquals(expected, evaluate(helper,
                EcorePackage.Literals.EPACKAGE__ESUBPACKAGES,
                "self->closure(eOpposite)"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests parsing the closure of operation calls.
     */
    public void test_closure_operations() {
        EPackage fakePkg = EcoreFactory.eINSTANCE.createEPackage();
        fakePkg.setName("fake");
        EClass fake = EcoreFactory.eINSTANCE.createEClass();
        fake.setName("Fake");
        fakePkg.getEClassifiers().add(fake);
        EOperation getFakes = EcoreFactory.eINSTANCE.createEOperation();
        getFakes.setName("getFakes");
        getFakes.setEType(fake);
        getFakes.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
        fake.getEOperations().add(getFakes);

        helper.setContext(fake);

        try {
            helper.createQuery("self->closure(getFakes())");
        } catch (Exception exc) {
            fail("Failed to parse or evaluate: " + exc.getLocalizedMessage());
        }
    }

    /**
     * Tests the validation of the closure() iterator.
     */
    public void test_closureValidation() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);

        try {
            // non-recursive reference
            helper.createQuery("self->closure(eClassifiers)");

            fail("Validation should have failed");
        } catch (ParserException e) {
            // success
            System.out
                .println("Got expected error: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests the validation of the closure() iterator for conformance of the
     * body type with the iterator variable (source element) type.
     */
    public void test_closureValidation_typeConformance_154695() {
        EPackage fakePkg = EcoreFactory.eINSTANCE.createEPackage();
        fakePkg.setName("fake");
        EClass fake = EcoreFactory.eINSTANCE.createEClass();
        fake.setName("Fake");
        fakePkg.getEClassifiers().add(fake);
        EOperation getFakes = EcoreFactory.eINSTANCE.createEOperation();
        getFakes.setName("getFakes");
        getFakes.setEType(fake);
        getFakes.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
        fake.getEOperations().add(getFakes);

        // subclass the Fake class
        EClass subFake = EcoreFactory.eINSTANCE.createEClass();
        subFake.setName("Subfake");
        fakePkg.getEClassifiers().add(subFake);
        subFake.getESuperTypes().add(fake);

        // get sub-fakes from a fake
        EOperation getSubFakes = EcoreFactory.eINSTANCE.createEOperation();
        getSubFakes.setName("getSubFakes");
        getSubFakes.setEType(subFake);
        getSubFakes.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
        fake.getEOperations().add(getSubFakes);

        helper.setContext(subFake);

        try {
            // this should not parse because the result of the closure
            // expression
            // is more general than the iterator variable, so cannot be
            // assigned recursively
            helper.createQuery("self->closure(getFakes())");
            fail("Validation should have failed");
        } catch (ParserException e) {
            // success
            System.out
                .println("Got expected error: " + e.getLocalizedMessage());
        }

        helper.setContext(fake);

        try {
            // this should parse OK because the result of the closure expression
            // is more specific than the iterator variable, so it can be
            // assigned recursively
            helper.createQuery("self->closure(getSubFakes())");
        } catch (Exception exc) {
            fail("Failed to parse or evaluate: " + exc.getLocalizedMessage());
        }
    }

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    public void test_forAll_invalidBody_142518() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);

        try {
            Object result = evaluate(helper, EcorePackage.eINSTANCE,
                "let b:Boolean = null in Bag{1, 2, 3}->forAll(b and b)");

            assertInvalid(result);

            // check that the "check" API interprets invalid as a constraint
            // violation
            assertFalse(check(helper, EcorePackage.eINSTANCE,
                "let b:Boolean = null in Bag{1}->forAll(b and b)"));

            // same deal for a null value (in the forAll case)
            result = evaluate(helper, EcorePackage.eINSTANCE,
                "Bag{1, 2, 3}->forAll(null.oclAsType(Boolean))");

            assertInvalid(result);
        } catch (Exception exc) {
            fail("Failed to parse or evaluate: " + exc.getLocalizedMessage());
        }
    }

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    public void test_exists_invalidBody_142518() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);

        try {
            Object result = evaluate(helper, EcorePackage.eINSTANCE,
                "let b:Boolean = null in Bag{1, 2, 3}->exists(b and b)");

            assertInvalid(result);

            // same deal for a null value (in the exists case)
            result = evaluate(helper, EcorePackage.eINSTANCE,
                "Bag{1, 2, 3}->exists(null.oclAsType(Boolean))");

            assertInvalid(result);
        } catch (Exception exc) {
            fail("Failed to parse or evaluate: " + exc.getLocalizedMessage());
        }
    }

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    public void test_one_invalidBody_142518() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);

        try {
            Object result = evaluate(helper, EcorePackage.eINSTANCE,
                "let b:Boolean = null in Bag{1, 2, 3}->one(b and b)");

            assertInvalid(result);

            // same deal for a null value (in the one case)
            result = evaluate(helper, EcorePackage.eINSTANCE,
                "Bag{1, 2, 3}->one(null.oclAsType(Boolean))");

            assertInvalid(result);
        } catch (Exception exc) {
            fail("Failed to parse or evaluate: " + exc.getLocalizedMessage());
        }
    }

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    public void test_any_invalidBody_142518() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);

        try {
            Object result = evaluate(helper, EcorePackage.eINSTANCE,
                "let b:Boolean = null in Bag{1, 2, 3}->any(b and b)");

            assertInvalid(result);

            // same deal for a null value (in the any case)
            result = evaluate(helper, EcorePackage.eINSTANCE,
                "Bag{1, 2, 3}->any(null.oclAsType(Boolean))");

            assertInvalid(result);
        } catch (Exception exc) {
            fail("Failed to parse or evaluate: " + exc.getLocalizedMessage());
        }
    }

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    public void test_select_invalidBody_142518() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);

        try {
            Object result = evaluate(helper, EcorePackage.eINSTANCE,
                "let b:Boolean = null in Bag{1, 2, 3}->select(b and b)");

            assertInvalid(result);

            // same deal for a null value (in the exists case)
            result = evaluate(helper, EcorePackage.eINSTANCE,
                "Bag{1, 2, 3}->select(null.oclAsType(Boolean))");

            assertInvalid(result);
        } catch (Exception exc) {
            fail("Failed to parse or evaluate: " + exc.getLocalizedMessage());
        }
    }

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    public void test_reject_invalidBody_142518() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);

        try {
            Object result = evaluate(helper, EcorePackage.eINSTANCE,
                "let b:Boolean = null in Bag{1, 2, 3}->reject(b and b)");

            assertInvalid(result);

            // same deal for a null value (in the exists case)
            result = evaluate(helper, EcorePackage.eINSTANCE,
                "Bag{1, 2, 3}->reject(null.oclAsType(Boolean))");

            assertInvalid(result);
        } catch (Exception exc) {
            fail("Failed to parse or evaluate: " + exc.getLocalizedMessage());
        }
    }

    /**
     * Tests that when the body of an iterator results in invalid, the
     * isUnique iterator expression treats it like any other value.
     */
    public void test_isUnique_invalidBody_142518() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);

        try {
            // invalid supports the = operation
            Object result = evaluate(helper, EcorePackage.eINSTANCE,
                "let b:Boolean = null in Bag{1, 2, 3}->isUnique(b and b)");

            assertEquals(Boolean.FALSE, result);

            result = evaluate(helper, EcorePackage.eINSTANCE,
                "let b:Boolean = null in Bag{1, 2, 3}->isUnique(null)");

            assertEquals(Boolean.FALSE, result);
        } catch (Exception exc) {
            fail("Failed to parse or evaluate: " + exc.getLocalizedMessage());
        }
    }

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    public void test_collect_invalidBody_142518() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);

        try {
            Object result = evaluate(helper, EcorePackage.eINSTANCE,
                "let b:Boolean = null in Bag{1, 2, 3}->collect(b and b)");

            assertInvalid(result);

            // in the case of a null value, null is allowed in a collection, so
            // it does not result in invalid
            result = evaluate(helper, EcorePackage.eINSTANCE,
                "let b:Boolean = null in Bag{1, 2, 3}->collect(null)");

            assertTrue(result instanceof Collection<?>);

            Collection<?> collResult = (Collection<?>) result;
            assertEquals(3, collResult.size());
            for (Iterator<?> iter = collResult.iterator(); iter.hasNext();) {
                assertNull(iter.next());
            }
        } catch (Exception exc) {
            fail("Failed to parse or evaluate: " + exc.getLocalizedMessage());
        }
    }

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    public void test_collectNested_invalidBody_142518() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);

        try {
            Object result = evaluate(helper, EcorePackage.eINSTANCE,
                "let b:Boolean = null in Bag{1, 2, 3}->collectNested(b and b)");

            assertInvalid(result);

            // in the case of a null value, null is allowed in a collection, so
            // it does not result in invalid
            result = evaluate(
                helper,
                EcorePackage.eINSTANCE,
                "let b:Boolean = null in Bag{1, 2, 3}->collectNested(e | if e = 2 then null else Set{e} endif)");

            assertTrue(result instanceof Collection<?>);

            Collection<?> collResult = (Collection<?>) result;
            assertEquals(3, collResult.size());
            for (Iterator<?> iter = collResult.iterator(); iter.hasNext();) {
                Object next = iter.next();
                assertTrue((next == null)
                    || next.equals(Collections.singleton(new Integer(1)))
                    || next.equals(Collections.singleton(new Integer(3))));
            }
        } catch (Exception exc) {
            fail("Failed to parse or evaluate: " + exc.getLocalizedMessage());
        }
    }

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    public void test_closure_invalidBody_142518() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);

        try {
            Object result = evaluate(helper, EcorePackage.eINSTANCE,
                "let c : EClassifier = invalid in eClassifiers->closure(c)");

            assertInvalid(result);

            // in the case of a null value, null is allowed in a collection, so
            // it does not result in invalid
            result = evaluate(helper, EcorePackage.eINSTANCE,
                "let c : Set(EClassifier) = Set{null} in eClassifiers->closure(c)");

            assertTrue(result instanceof Collection<?>);

            Collection<?> collResult = (Collection<?>) result;
            assertTrue(collResult.isEmpty());
        } catch (Exception exc) {
            fail("Failed to parse or evaluate: " + exc.getLocalizedMessage());
        }
    }

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    public void test_sortedBy_invalidBody_142518() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);

        try {
            Object result = evaluate(helper, EcorePackage.eINSTANCE,
                "let s : String = null in Bag{1, 2, 3}->sortedBy(s.size())");

            assertInvalid(result);

            // same deal for null values
            result = evaluate(helper, EcorePackage.eINSTANCE,
                "Bag{1, 2, 3}->sortedBy(null.oclAsType(Integer))");

            assertInvalid(result);
        } catch (Exception exc) {
            fail("Failed to parse or evaluate: " + exc.getLocalizedMessage());
        }
    }

    /**
     * Tests that the generic iterate() iterator returns invalid when the
     * source collection is null or invalid.
     */
    public void test_iterateWithNullSource_143996() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);

        try {
            assertInvalid(evaluate(helper, pkg1,
                "let e : Collection(EPackage) = null in e->iterate(" +
                    "p : EPackage; s : String = '' | s.concat(p.name))"));

            assertInvalid(evaluate(helper, pkg1,
                "let e : Collection(EPackage) = invalid in e->iterate(" +
                    "p : EPackage; s : String = '' | s.concat(p.name))"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests that the exists() iterator return invalid when the source
     * collection is null or invalid.
     */
    public void test_existsWithNullSource_143996() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);

        try {
            assertInvalid(evaluate(helper, pkg1,
                "let e : Collection(EPackage) = null in e->exists(" +
                    "p : EPackage | p.name = 'bob')"));

            assertInvalid(evaluate(helper, pkg1,
                "let e : Collection(EPackage) = invalid in e->exists(" +
                    "p : EPackage | p.name = 'bob')"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests the exists iterator with multiple iterator variables.
     */
    public void test_exists_multipleIteratorVariables() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);

        try {
            assertTrue(check(helper, pkg1,
                "Sequence{1, 2, 3, 4}->exists(e1, e2 | e1 = e2)"));

            assertFalse(check(helper, pkg1,
                "Sequence{1, 2, 3, 4}->exists(e1, e2 | (e1 + e2) = 0)"));

            // when there are no values, the the desired result implictly
            // does not occur
            assertFalse(check(helper, pkg1,
                "Sequence{}->exists(e1, e2 | e1 = e2)"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests the forAll iterator with multiple iterator variables.
     */
    public void test_forAll_multipleIteratorVariables() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);

        try {
            assertFalse(check(helper, pkg1,
                "Sequence{1, 2, 3, 4}->forAll(e1, e2 | e1 = e2)"));

            assertTrue(check(helper, pkg1,
                "Sequence{1, 2, 3, 4}->forAll(e1, e2 | (e1 + e2) > e1)"));

            // when there are no values, the the desired result implictly occurs
            assertTrue(check(helper, pkg1,
                "Sequence{}->forAll(e1, e2 | e1 = e2)"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests the validation the number of iterator variables for iterators that
     * do not support multiple variables.
     */
    public void test_invalidMultipleIteratorVariables() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);

        try {
            helper.createQuery("Sequence{'a', 'b', 'c'}->exists(e1, e2, e3 |" +
                " e1 = e2)");

            fail("Parse should have failed");
        } catch (ParserException e) {
            // success
            System.out
                .println("Got expected error: " + e.getLocalizedMessage());
        }

        try {
            helper.createQuery("Sequence{'a', 'b', 'c'}->forAll(e1, e2, e3 |" +
                " e1 = e2)");

            fail("Parse should have failed");
        } catch (ParserException e) {
            // success
            System.out
                .println("Got expected error: " + e.getLocalizedMessage());
        }

        try {
            helper.createQuery("Sequence{'a', 'b', 'c'}->collect(e1, e2 |" +
                " Tuple{a : String = e1, b : String = e2})");

            fail("Parse should have failed");
        } catch (ParserException e) {
            // success
            System.out
                .println("Got expected error: " + e.getLocalizedMessage());
        }

        try {
            helper.createQuery("Sequence{'a', 'b', 'c'}->any(e1, e2 |" +
                " e1 = e2)");

            fail("Parse should have failed");
        } catch (ParserException e) {
            // success
            System.out
                .println("Got expected error: " + e.getLocalizedMessage());
        }

        try {
            helper.createQuery("Sequence{'a', 'b', 'c'}->one(e1, e2 |" +
                " e1 = e2)");

            fail("Parse should have failed");
        } catch (ParserException e) {
            // success
            System.out
                .println("Got expected error: " + e.getLocalizedMessage());
        }

        try {
            helper.createQuery("Sequence{'a', 'b', 'c'}->select(e1, e2 |" +
                " e1 = e2)");

            fail("Parse should have failed");
        } catch (ParserException e) {
            // success
            System.out
                .println("Got expected error: " + e.getLocalizedMessage());
        }

        try {
            helper.createQuery("Sequence{'a', 'b', 'c'}->reject(e1, e2 |" +
                " e1 = e2)");

            fail("v should have failed");
        } catch (ParserException e) {
            // success
            System.out
                .println("Got expected error: " + e.getLocalizedMessage());
        }

        try {
            helper.createQuery("Sequence{'a', 'b', 'c'}->isUnique(e1, e2 |" +
                " e1 = e2)");

            fail("Parse should have failed");
        } catch (ParserException e) {
            // success
            System.out
                .println("Got expected error: " + e.getLocalizedMessage());
        }
    }
    
    /**
     * Test to check the validation of the <tt>sortedBy</tt> iterator, that
     * the body expression type has a <tt>&lt;</tt> operation.
     */
    public void test_sortedByRequiresComparability_192729() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);
        
        try {
            // should fail to parse because EClassifier does not define '<'
            helper.createQuery("eClassifiers->sortedBy(e | e)");
            fail("Should have failed to parse");
        } catch (ParserException e) {
            // success
            System.out.println("Got expected exception: " + e.getLocalizedMessage());
        }
        
        try {
            // should parse because String defines '<'
            helper.createQuery("eClassifiers->sortedBy(e | e.name)");
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
        
        helper.setContext(EcorePackage.Literals.EDATE);
        try {
            // EDate defines '<' by having a Comparable instance class
            helper.createQuery(
                "let dates : Sequence(EDate) = Sequence{} in dates->sortedBy(e | e)");
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    //
    // Framework methods
    //

    @Override
    protected void setUp() {
        super.setUp();

        // need a metamodel that has a reflexive EReference.
        // Ecore will do nicely. Create the following structure:
        // pkg1
        // pkg2
        // jim
        // bob
        // pkg3
        // pkg4
        // pkg5
        // george

        pkg1 = EcoreFactory.eINSTANCE.createEPackage();
        pkg1.setName("pkg1");

        pkg2 = EcoreFactory.eINSTANCE.createEPackage();
        pkg2.setName("pkg2");
        pkg1.getESubpackages().add(pkg2);

        jim = EcoreFactory.eINSTANCE.createEPackage();
        jim.setName("jim");
        pkg2.getESubpackages().add(jim);

        bob = EcoreFactory.eINSTANCE.createEPackage();
        bob.setName("bob");
        pkg1.getESubpackages().add(bob);

        pkg3 = EcoreFactory.eINSTANCE.createEPackage();
        pkg3.setName("pkg3");
        pkg1.getESubpackages().add(pkg3);

        pkg4 = EcoreFactory.eINSTANCE.createEPackage();
        pkg4.setName("pkg4");
        pkg3.getESubpackages().add(pkg4);

        pkg5 = EcoreFactory.eINSTANCE.createEPackage();
        pkg5.setName("pkg5");
        pkg3.getESubpackages().add(pkg5);

        george = EcoreFactory.eINSTANCE.createEPackage();
        george.setName("george");
        pkg5.getESubpackages().add(george);
    }
}
