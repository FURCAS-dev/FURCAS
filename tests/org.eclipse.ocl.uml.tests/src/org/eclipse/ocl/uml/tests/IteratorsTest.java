/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2009 IBM Corporation and others.
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
 * $Id: IteratorsTest.java,v 1.10 2009/11/28 18:09:22 ewillink Exp $
 */

package org.eclipse.ocl.uml.tests;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.util.CollectionUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;

/**
 * Tests for iterator expressions.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class IteratorsTest
    extends AbstractTestSuite {

	Package pkg1;
	Package pkg2;
	Package pkg3;
	Package pkg4;
	Package pkg5;
	Package jim;
	Package bob;
	Package george;

    /**
     * Tests the generic iterate() iterator.
     */
    public void test_iterate_143996() {
        helper.setContext(getMetaclass("Package"));

        try {
            String[] expected = {"pkg2", "bob", "pkg3"};

            // complete form
            assertJumble(
                expected,
                (String) evaluate(helper, pkg1,
                    "nestedPackage->iterate(p : Package; s : String = '' | s.concat(p.name))"));

            // shorter form
            assertJumble(
                expected,
                (String) evaluate(helper, pkg1,
                    "nestedPackage->iterate(p; s : String = '' | s.concat(p.name))"));

            // shortest form
            assertJumble(expected, (String) evaluate(helper, pkg1,
                "nestedPackage->iterate(s : String = ''| s.concat(name))"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    private void assertJumble(String[] substrings, String jumble) {
        for (String sub : substrings) {
            assertTrue(jumble.contains(sub));
        }
    }

    /**
     * Tests the select() iterator.
     */
    public void test_select() {
        helper.setContext(getMetaclass("Package"));

        try {
            Set<Package> expected = new java.util.LinkedHashSet<Package>();
            expected.add(pkg2);
            expected.add(pkg3);

            // complete form
            assertEquals(expected, evaluate(helper, pkg1,
                "nestedPackage->select(p : Package | p.name <> 'bob')"));

            // shorter form
            assertEquals(expected, evaluate(helper, pkg1,
                "nestedPackage->select(p | p.name <> 'bob')"));

            // shortest form
            assertEquals(expected, evaluate(helper, pkg1,
                "nestedPackage->select(name <> 'bob')"));

            assertEquals(new java.util.LinkedHashSet<Package>(pkg1
                .getNestedPackages()), evaluate(helper, pkg1,
                "nestedPackage->select(true)"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests the reject() iterator.
     */
    public void test_reject() {
        helper.setContext(getMetaclass("Package"));

        try {
            Set<Package> expected = new java.util.LinkedHashSet<Package>();
            expected.add(pkg2);
            expected.add(pkg3);

            // complete form
            assertEquals(expected, evaluate(helper, pkg1,
                "nestedPackage->reject(p : Package | p.name = 'bob')"));

            // shorter form
            assertEquals(expected, evaluate(helper, pkg1,
                "nestedPackage->reject(p | p.name = 'bob')"));

            // shortest form
            assertEquals(expected, evaluate(helper, pkg1,
                "nestedPackage->reject(name = 'bob')"));

            assertTrue(((Collection<?>) evaluate(helper, pkg1,
                "nestedPackage->reject(true)")).isEmpty());
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests the any() iterator.
     */
    public void test_any() {
        helper.setContext(getMetaclass("Package"));

        try {
            // complete form
            assertSame(bob, evaluate(helper, pkg1,
                "nestedPackage->any(p : Package | p.name = 'bob')"));

            // shorter form
            assertSame(bob, evaluate(helper, pkg1,
                "nestedPackage->any(p | p.name = 'bob')"));

            // shortest form
            assertSame(bob, evaluate(helper, pkg1,
                "nestedPackage->any(name = 'bob')"));

            // negative
            assertNotSame(bob, evaluate(helper, pkg1,
                "nestedPackage->any(name = 'pkg2')"));

            assertNotNull(evaluate(helper, pkg1, "nestedPackage->any(true)"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests the isUnique() iterator.
     */
    public void test_isUnique_126861() {
        helper.setContext(getMetaclass("Package"));

        try {
            assertTrue(check(helper, pkg1,
                "Sequence{'a', 'b', 'c', 'd', 'e'}->isUnique(e | e)"));

            assertFalse(check(helper, pkg1,
                "Sequence{'a', 'b', 'c', 'c', 'e'}->isUnique(e | e)"));

            // when there are no values, they implicitly all evaluate to a
            // different result
            assertTrue(check(helper, pkg1, "Sequence{}->isUnique(e | e)"));

            assertNotNull(evaluate(helper, pkg1,
                "nestedPackage->isUnique(name)"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests the exists() iterator.
     */
    public void test_exists() {
        helper.setContext(getMetaclass("Package"));

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

            assertTrue(check(helper, pkg1, "nestedPackage->exists(true)"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests the forAll() iterator.
     */
    public void test_forAll() {
        helper.setContext(getMetaclass("Package"));

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

            assertTrue(check(helper, pkg1, "nestedPackage->forAll(true)"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests the one() iterator.
     */
    public void test_one() {
        helper.setContext(getMetaclass("Package"));

        try {
            assertTrue(check(helper, pkg1,
                "Sequence{'a', 'b', 'c', 'd', 'e'}->one(e | e = 'c')"));

            assertFalse(check(helper, pkg1,
                "Sequence{'a', 'b', 'c', 'c', 'e'}->one(e | e = 'c')"));

            assertFalse(check(helper, pkg1,
                "Sequence{'a', 'b', 'd', 'e'}->one(e | e = 'c')"));

            assertTrue(check(helper, pkg1, "Sequence{'a'}->one(true)"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests the collect() iterator.
     */
    public void test_collect() {
        helper.setContext(getMetaclass("Package"));

        try {
            Collection<Object> expected = CollectionUtil.createNewBag();
            expected.add("pkg2");
            expected.add("bob");
            expected.add("pkg3");

            // complete form
            assertEquals(expected, evaluate(helper, pkg1,
                "nestedPackage->collect(p : Package | p.name)"));

            // shorter form
            assertEquals(expected, evaluate(helper, pkg1,
                "nestedPackage->collect(p | p.name)"));

            // yet shorter form
            assertEquals(expected, evaluate(helper, pkg1,
                "nestedPackage->collect(name)"));

            // shortest form
            assertEquals(expected, evaluate(helper, pkg1, "nestedPackage.name"));

            // flattening of nested collections
            expected.clear();
            expected.add(jim);
            expected.add(pkg4);
            expected.add(pkg5);

            assertEquals(expected, evaluate(helper, pkg1,
                "nestedPackage.nestedPackage"));
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
        helper.setContext(getMetaclass("Package"));

        try {
            // this shouldn't parse, anyway
        	helper.createInvariant("nestedPackage.unknownAttribute");

            fail("Should not have parsed");
        } catch (ParserException e) {
        	// should have a diagnostic describing the problem if it is a
        	// "normal" parse failure
        	assertNoException(getDiagnostic(), ClassCastException.class);
        }
   }

    /**
     * Tests the collectNested() iterator.
     */
    public void test_collectNested() {
        helper.setContext(getMetaclass("Package"));

        try {
            Collection<Object> expected = CollectionUtil.createNewBag();
            expected.add("pkg2");
            expected.add("bob");
            expected.add("pkg3");

            // complete form
            assertEquals(expected, evaluate(helper, pkg1,
                "nestedPackage->collectNested(p : Package | p.name)"));

            // shorter form
            assertEquals(expected, evaluate(helper, pkg1,
                "nestedPackage->collectNested(p | p.name)"));

            // shortest form
            assertEquals(expected, evaluate(helper, pkg1,
                "nestedPackage->collectNested(name)"));

            // nested collections not flattened
            expected.clear();
            expected.add(Collections.singleton(jim));
            expected.add(Collections.EMPTY_SET);
            expected.add(new java.util.HashSet<Object>(Arrays
                .asList(new Object[] {pkg4, pkg5})));

            assertEquals(expected, evaluate(helper, pkg1,
                "nestedPackage->collectNested(nestedPackage)"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests the sortedBy() iterator.
     */
    public void test_sortedBy() {
        helper.setContext(getMetaclass("Package"));

        try {
            LinkedHashSet<Package> expectedSet = new LinkedHashSet<Package>();
            expectedSet.add(bob);
            expectedSet.add(pkg2);
            expectedSet.add(pkg3);

            // complete form
            assertEquals(expectedSet, evaluate(helper, pkg1,
                "nestedPackage->sortedBy(p : Package | p.name)"));

            // shorter form
            assertEquals(expectedSet, evaluate(helper, pkg1,
                "nestedPackage->sortedBy(p | p.name)"));

            // shortest form
            assertEquals(expectedSet, evaluate(helper, pkg1,
                "nestedPackage->sortedBy(name)"));

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
        helper.setContext(getMetaclass("Package"));

        try {
            Set<Package> expected = new java.util.HashSet<Package>();
            expected.add(pkg1);
            expected.add(pkg3);
            expected.add(pkg5);
            // closure does not include self (george)

            assertEquals(expected, evaluate(helper, george,
                "self->closure(nestingPackage)"));

            expected.remove(pkg1); // closure does not include self (pkg1)
            expected.add(pkg2);
            expected.add(jim);
            expected.add(bob);
            expected.add(pkg4);
            expected.add(george);

            assertEquals(expected, evaluate(helper, pkg1,
                "self->closure(nestedPackage)"));

            // empty closure
            expected.clear();
            assertEquals(expected, evaluate(helper, pkg1,
                "self->closure(nestingPackage)"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests that the closure() iterator handles cycles.
     */
    public void test_closure_cycles() {
        Class packageMetaclass = (Class) getMetaclass("Package");
        Property nestedPackage = packageMetaclass.getAttribute(
            "nestedPackage", packageMetaclass);
        Property nestingPackage = packageMetaclass.getAttribute(
            "nestingPackage", packageMetaclass);

        helper.setContext(getMetaclass("Property"));

        try {
            Set<Property> expected = new java.util.HashSet<Property>();
            expected.add(nestedPackage);
            expected.add(nestingPackage);
            // cyclic closure *does* include self

            assertEquals(expected, evaluate(helper, nestingPackage,
                "self->closure(opposite)"));

            assertEquals(expected, evaluate(helper, nestedPackage,
                "self->closure(opposite)"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests parsing the closure of operation calls.
     */
    public void test_closure_operations() {
        Package fakePkg = umlf.createPackage();
        fakePkg.setName("fake");
        Class fake = fakePkg.createOwnedClass("Fake", false);
        Operation getFakes = fake.createOwnedOperation("getFakes",
            null, null, fake);
        getFakes.setUpper(LiteralUnlimitedNatural.UNLIMITED);
        getFakes.setIsQuery(true);

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
        helper.setContext(getMetaclass("Package"));

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
        Package fakePkg = umlf.createPackage();
        fakePkg.setName("fake");
        Class fake = fakePkg.createOwnedClass("Fake", false);
        Operation getFakes = fake.createOwnedOperation("getFakes",
            null, null, fake);
        getFakes.setUpper(LiteralUnlimitedNatural.UNLIMITED);
        getFakes.setIsQuery(true);

        // subclass the Fake class
        Class subFake = fakePkg.createOwnedClass("Subfake", false);
        subFake.createGeneralization(fake);

        // get sub-fakes from a fake
        Operation getSubFakes = fake.createOwnedOperation("getSubFakes",
            null, null, subFake);
        getSubFakes.setUpper(LiteralUnlimitedNatural.UNLIMITED);
        getSubFakes.setIsQuery(true);

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
        helper.setContext(getMetaclass("Package"));

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
        helper.setContext(getMetaclass("Package"));

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
        helper.setContext(getMetaclass("Package"));

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
        helper.setContext(getMetaclass("Package"));

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
        helper.setContext(getMetaclass("Package"));

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
        helper.setContext(getMetaclass("Package"));

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
        helper.setContext(getMetaclass("Package"));

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
        helper.setContext(getMetaclass("Package"));

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
        helper.setContext(getMetaclass("Package"));

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
        helper.setContext(getMetaclass("Package"));

        try {
            Object result = evaluate(helper, getUMLMetamodel(),
                "let c : Type = invalid in ownedType->closure(c)");

            assertInvalid(result);

            // in the case of a null value, null is allowed in a collection, so
            // it does not result in invalid
            result = evaluate(helper, getUMLMetamodel(),
                "let c : Set(Type) = Set{null} in ownedType->closure(c)");

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
        helper.setContext(getMetaclass("Package"));

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
        helper.setContext(getMetaclass("Package"));

        try {
            assertInvalid(evaluate(helper, pkg1,
                "let e : Collection(Package) = null in e->iterate(" +
                    "p : Package; s : String = '' | s.concat(p.name))"));

            assertInvalid(evaluate(helper, pkg1,
                "let e : Collection(Package) = invalid in e->iterate(" +
                    "p : Package; s : String = '' | s.concat(p.name))"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests that the exists() iterator return invalid when the source
     * collection is null or invalid.
     */
    public void test_existsWithNullSource_143996() {
        helper.setContext(getMetaclass("Package"));

        try {
            assertInvalid(evaluate(helper, pkg1,
                "let e : Collection(Package) = null in e->exists(" +
                    "p : Package | p.name = 'bob')"));

            assertInvalid(evaluate(helper, pkg1,
                "let e : Collection(Package) = invalid in e->exists(" +
                    "p : Package | p.name = 'bob')"));
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

        pkg1 = umlf.createPackage();
        pkg1.setName("pkg1");

        pkg2 = pkg1.createNestedPackage("pkg2");
        jim = pkg2.createNestedPackage("jim");
        bob = pkg1.createNestedPackage("bob");
        pkg3 = pkg1.createNestedPackage("pkg3");
        pkg4 = pkg3.createNestedPackage("pkg4");
        pkg5 = pkg3.createNestedPackage("pkg5");
        george = pkg5.createNestedPackage("george");
    }
}
