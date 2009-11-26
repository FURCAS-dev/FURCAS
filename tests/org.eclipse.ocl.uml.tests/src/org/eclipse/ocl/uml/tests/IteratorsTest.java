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
 * $Id: IteratorsTest.java,v 1.9 2009/11/26 20:46:38 ewillink Exp $
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
        helper.setContext(getMetaclass("Package")); //$NON-NLS-1$

        try {
            String[] expected = {"pkg2", "bob", "pkg3"}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

            // complete form
            assertJumble(
                expected,
                (String) evaluate(helper, pkg1,
                    "nestedPackage->iterate(p : Package; s : String = '' | s.concat(p.name))")); //$NON-NLS-1$

            // shorter form
            assertJumble(
                expected,
                (String) evaluate(helper, pkg1,
                    "nestedPackage->iterate(p; s : String = '' | s.concat(p.name))")); //$NON-NLS-1$

            // shortest form
            assertJumble(expected, (String) evaluate(helper, pkg1,
                "nestedPackage->iterate(s : String = ''| s.concat(name))")); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
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
        helper.setContext(getMetaclass("Package")); //$NON-NLS-1$

        try {
            Set<Package> expected = new java.util.LinkedHashSet<Package>();
            expected.add(pkg2);
            expected.add(pkg3);

            // complete form
            assertEquals(expected, evaluate(helper, pkg1,
                "nestedPackage->select(p : Package | p.name <> 'bob')")); //$NON-NLS-1$

            // shorter form
            assertEquals(expected, evaluate(helper, pkg1,
                "nestedPackage->select(p | p.name <> 'bob')")); //$NON-NLS-1$

            // shortest form
            assertEquals(expected, evaluate(helper, pkg1,
                "nestedPackage->select(name <> 'bob')")); //$NON-NLS-1$

            assertEquals(new java.util.LinkedHashSet<Package>(pkg1
                .getNestedPackages()), evaluate(helper, pkg1,
                "nestedPackage->select(true)")); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    /**
     * Tests the reject() iterator.
     */
    public void test_reject() {
        helper.setContext(getMetaclass("Package")); //$NON-NLS-1$

        try {
            Set<Package> expected = new java.util.LinkedHashSet<Package>();
            expected.add(pkg2);
            expected.add(pkg3);

            // complete form
            assertEquals(expected, evaluate(helper, pkg1,
                "nestedPackage->reject(p : Package | p.name = 'bob')")); //$NON-NLS-1$

            // shorter form
            assertEquals(expected, evaluate(helper, pkg1,
                "nestedPackage->reject(p | p.name = 'bob')")); //$NON-NLS-1$

            // shortest form
            assertEquals(expected, evaluate(helper, pkg1,
                "nestedPackage->reject(name = 'bob')")); //$NON-NLS-1$

            assertTrue(((Collection<?>) evaluate(helper, pkg1,
                "nestedPackage->reject(true)")).isEmpty()); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    /**
     * Tests the any() iterator.
     */
    public void test_any() {
        helper.setContext(getMetaclass("Package")); //$NON-NLS-1$

        try {
            // complete form
            assertSame(bob, evaluate(helper, pkg1,
                "nestedPackage->any(p : Package | p.name = 'bob')")); //$NON-NLS-1$

            // shorter form
            assertSame(bob, evaluate(helper, pkg1,
                "nestedPackage->any(p | p.name = 'bob')")); //$NON-NLS-1$

            // shortest form
            assertSame(bob, evaluate(helper, pkg1,
                "nestedPackage->any(name = 'bob')")); //$NON-NLS-1$

            // negative
            assertNotSame(bob, evaluate(helper, pkg1,
                "nestedPackage->any(name = 'pkg2')")); //$NON-NLS-1$

            assertNotNull(evaluate(helper, pkg1, "nestedPackage->any(true)")); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    /**
     * Tests the isUnique() iterator.
     */
    public void test_isUnique_126861() {
        helper.setContext(getMetaclass("Package")); //$NON-NLS-1$

        try {
            assertTrue(check(helper, pkg1,
                "Sequence{'a', 'b', 'c', 'd', 'e'}->isUnique(e | e)")); //$NON-NLS-1$

            assertFalse(check(helper, pkg1,
                "Sequence{'a', 'b', 'c', 'c', 'e'}->isUnique(e | e)")); //$NON-NLS-1$

            // when there are no values, they implicitly all evaluate to a
            // different result
            assertTrue(check(helper, pkg1, "Sequence{}->isUnique(e | e)")); //$NON-NLS-1$

            assertNotNull(evaluate(helper, pkg1,
                "nestedPackage->isUnique(name)")); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    /**
     * Tests the exists() iterator.
     */
    public void test_exists() {
        helper.setContext(getMetaclass("Package")); //$NON-NLS-1$

        try {
            assertTrue(check(helper, pkg1,
                "Sequence{'a', 'b', 'c', 'd', 'e'}->exists(e | e = 'c')")); //$NON-NLS-1$

            assertTrue(check(helper, pkg1,
                "Sequence{'a', 'b', 'c', 'c', 'e'}->exists(e | e = 'c')")); //$NON-NLS-1$

            assertFalse(check(helper, pkg1,
                "Sequence{'a', 'b', 'd', 'e'}->exists(e | e = 'c')")); //$NON-NLS-1$

            // when there are no values, they the desired result implictly
            // does not occur
            assertFalse(check(helper, pkg1, "Sequence{}->exists(e | e = 'c')")); //$NON-NLS-1$

            assertTrue(check(helper, pkg1, "nestedPackage->exists(true)")); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    /**
     * Tests the forAll() iterator.
     */
    public void test_forAll() {
        helper.setContext(getMetaclass("Package")); //$NON-NLS-1$

        try {
            assertFalse(check(helper, pkg1,
                "Sequence{'a', 'b', 'c', 'd', 'e'}->forAll(e | e = 'c')")); //$NON-NLS-1$

            assertFalse(check(helper, pkg1,
                "Sequence{'a', 'b', 'd', 'e'}->forAll(e | e = 'c')")); //$NON-NLS-1$

            assertTrue(check(helper, pkg1,
                "Sequence{'c', 'c', 'c', 'c'}->forAll(e | e = 'c')")); //$NON-NLS-1$

            assertTrue(check(helper, pkg1, "Sequence{'c'}->forAll(e | e = 'c')")); //$NON-NLS-1$

            // when there are no values, they implicitly all evaluate to the
            // desired result
            assertTrue(check(helper, pkg1, "Sequence{}->forAll(e | e = 'c')")); //$NON-NLS-1$

            assertTrue(check(helper, pkg1, "nestedPackage->forAll(true)")); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    /**
     * Tests the one() iterator.
     */
    public void test_one() {
        helper.setContext(getMetaclass("Package")); //$NON-NLS-1$

        try {
            assertTrue(check(helper, pkg1,
                "Sequence{'a', 'b', 'c', 'd', 'e'}->one(e | e = 'c')")); //$NON-NLS-1$

            assertFalse(check(helper, pkg1,
                "Sequence{'a', 'b', 'c', 'c', 'e'}->one(e | e = 'c')")); //$NON-NLS-1$

            assertFalse(check(helper, pkg1,
                "Sequence{'a', 'b', 'd', 'e'}->one(e | e = 'c')")); //$NON-NLS-1$

            assertTrue(check(helper, pkg1, "Sequence{'a'}->one(true)")); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    /**
     * Tests the collect() iterator.
     */
    public void test_collect() {
        helper.setContext(getMetaclass("Package")); //$NON-NLS-1$

        try {
            Collection<Object> expected = CollectionUtil.createNewBag();
            expected.add("pkg2"); //$NON-NLS-1$
            expected.add("bob"); //$NON-NLS-1$
            expected.add("pkg3"); //$NON-NLS-1$

            // complete form
            assertEquals(expected, evaluate(helper, pkg1,
                "nestedPackage->collect(p : Package | p.name)")); //$NON-NLS-1$

            // shorter form
            assertEquals(expected, evaluate(helper, pkg1,
                "nestedPackage->collect(p | p.name)")); //$NON-NLS-1$

            // yet shorter form
            assertEquals(expected, evaluate(helper, pkg1,
                "nestedPackage->collect(name)")); //$NON-NLS-1$

            // shortest form
            assertEquals(expected, evaluate(helper, pkg1, "nestedPackage.name")); //$NON-NLS-1$

            // flattening of nested collections
            expected.clear();
            expected.add(jim);
            expected.add(pkg4);
            expected.add(pkg5);

            assertEquals(expected, evaluate(helper, pkg1,
                "nestedPackage.nestedPackage")); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    /**
     * Tests that parsing fails, in the case of an unknown property in a
     * collection navigation, with an appropriate parse failure, not a
     * <code>ClassCastException</code>.
     */
    public void test_implicitCollect_unknownAttribute_232669() {
        helper.setContext(getMetaclass("Package")); //$NON-NLS-1$

        try {
            // this shouldn't parse, anyway
        	helper.createInvariant("nestedPackage.unknownAttribute"); //$NON-NLS-1$

            fail("Should not have parsed"); //$NON-NLS-1$
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
        helper.setContext(getMetaclass("Package")); //$NON-NLS-1$

        try {
            Collection<Object> expected = CollectionUtil.createNewBag();
            expected.add("pkg2"); //$NON-NLS-1$
            expected.add("bob"); //$NON-NLS-1$
            expected.add("pkg3"); //$NON-NLS-1$

            // complete form
            assertEquals(expected, evaluate(helper, pkg1,
                "nestedPackage->collectNested(p : Package | p.name)")); //$NON-NLS-1$

            // shorter form
            assertEquals(expected, evaluate(helper, pkg1,
                "nestedPackage->collectNested(p | p.name)")); //$NON-NLS-1$

            // shortest form
            assertEquals(expected, evaluate(helper, pkg1,
                "nestedPackage->collectNested(name)")); //$NON-NLS-1$

            // nested collections not flattened
            expected.clear();
            expected.add(Collections.singleton(jim));
            expected.add(Collections.EMPTY_SET);
            expected.add(new java.util.HashSet<Object>(Arrays
                .asList(new Object[] {pkg4, pkg5})));

            assertEquals(expected, evaluate(helper, pkg1,
                "nestedPackage->collectNested(nestedPackage)")); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    /**
     * Tests the sortedBy() iterator.
     */
    public void test_sortedBy() {
        helper.setContext(getMetaclass("Package")); //$NON-NLS-1$

        try {
            LinkedHashSet<Package> expectedSet = new LinkedHashSet<Package>();
            expectedSet.add(bob);
            expectedSet.add(pkg2);
            expectedSet.add(pkg3);

            // complete form
            assertEquals(expectedSet, evaluate(helper, pkg1,
                "nestedPackage->sortedBy(p : Package | p.name)")); //$NON-NLS-1$

            // shorter form
            assertEquals(expectedSet, evaluate(helper, pkg1,
                "nestedPackage->sortedBy(p | p.name)")); //$NON-NLS-1$

            // shortest form
            assertEquals(expectedSet, evaluate(helper, pkg1,
                "nestedPackage->sortedBy(name)")); //$NON-NLS-1$

            List<String> expected = new java.util.ArrayList<String>();
            expected.add("a"); //$NON-NLS-1$
            expected.add("b"); //$NON-NLS-1$
            expected.add("c"); //$NON-NLS-1$
            expected.add("d"); //$NON-NLS-1$
            expected.add("e"); //$NON-NLS-1$

            assertEquals(expected, evaluate(helper, pkg1,
                "Bag{'d', 'b', 'e', 'a', 'c'}->sortedBy(e | e)")); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    /**
     * Tests the closure() iterator.
     */
    public void test_closure() {
        helper.setContext(getMetaclass("Package")); //$NON-NLS-1$

        try {
            Set<Package> expected = new java.util.HashSet<Package>();
            expected.add(pkg1);
            expected.add(pkg3);
            expected.add(pkg5);
            // closure does not include self (george)

            assertEquals(expected, evaluate(helper, george,
                "self->closure(nestingPackage)")); //$NON-NLS-1$

            expected.remove(pkg1); // closure does not include self (pkg1)
            expected.add(pkg2);
            expected.add(jim);
            expected.add(bob);
            expected.add(pkg4);
            expected.add(george);

            assertEquals(expected, evaluate(helper, pkg1,
                "self->closure(nestedPackage)")); //$NON-NLS-1$

            // empty closure
            expected.clear();
            assertEquals(expected, evaluate(helper, pkg1,
                "self->closure(nestingPackage)")); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    /**
     * Tests that the closure() iterator handles cycles.
     */
    public void test_closure_cycles() {
        Class packageMetaclass = (Class) getMetaclass("Package"); //$NON-NLS-1$
        Property nestedPackage = packageMetaclass.getAttribute(
            "nestedPackage", packageMetaclass); //$NON-NLS-1$
        Property nestingPackage = packageMetaclass.getAttribute(
            "nestingPackage", packageMetaclass); //$NON-NLS-1$

        helper.setContext(getMetaclass("Property")); //$NON-NLS-1$

        try {
            Set<Property> expected = new java.util.HashSet<Property>();
            expected.add(nestedPackage);
            expected.add(nestingPackage);
            // cyclic closure *does* include self

            assertEquals(expected, evaluate(helper, nestingPackage,
                "self->closure(opposite)")); //$NON-NLS-1$

            assertEquals(expected, evaluate(helper, nestedPackage,
                "self->closure(opposite)")); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    /**
     * Tests parsing the closure of operation calls.
     */
    public void test_closure_operations() {
        Package fakePkg = umlf.createPackage();
        fakePkg.setName("fake"); //$NON-NLS-1$
        Class fake = fakePkg.createOwnedClass("Fake", false); //$NON-NLS-1$
        Operation getFakes = fake.createOwnedOperation("getFakes", //$NON-NLS-1$
            null, null, fake);
        getFakes.setUpper(LiteralUnlimitedNatural.UNLIMITED);
        getFakes.setIsQuery(true);

        helper.setContext(fake);

        try {
            helper.createQuery("self->closure(getFakes())"); //$NON-NLS-1$
        } catch (Exception exc) {
            fail("Failed to parse or evaluate: " + exc.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    /**
     * Tests the validation of the closure() iterator.
     */
    public void test_closureValidation() {
        helper.setContext(getMetaclass("Package")); //$NON-NLS-1$

        try {
            // non-recursive reference
            helper.createQuery("self->closure(eClassifiers)"); //$NON-NLS-1$

            fail("Validation should have failed"); //$NON-NLS-1$
        } catch (ParserException e) {
            // success
            System.out
                .println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    /**
     * Tests the validation of the closure() iterator for conformance of the
     * body type with the iterator variable (source element) type.
     */
    public void test_closureValidation_typeConformance_154695() {
        Package fakePkg = umlf.createPackage();
        fakePkg.setName("fake"); //$NON-NLS-1$
        Class fake = fakePkg.createOwnedClass("Fake", false); //$NON-NLS-1$
        Operation getFakes = fake.createOwnedOperation("getFakes", //$NON-NLS-1$
            null, null, fake);
        getFakes.setUpper(LiteralUnlimitedNatural.UNLIMITED);
        getFakes.setIsQuery(true);

        // subclass the Fake class
        Class subFake = fakePkg.createOwnedClass("Subfake", false); //$NON-NLS-1$
        subFake.createGeneralization(fake);

        // get sub-fakes from a fake
        Operation getSubFakes = fake.createOwnedOperation("getSubFakes", //$NON-NLS-1$
            null, null, subFake);
        getSubFakes.setUpper(LiteralUnlimitedNatural.UNLIMITED);
        getSubFakes.setIsQuery(true);

        helper.setContext(subFake);

        try {
            // this should not parse because the result of the closure
            // expression
            // is more general than the iterator variable, so cannot be
            // assigned recursively
            helper.createQuery("self->closure(getFakes())"); //$NON-NLS-1$
            fail("Validation should have failed"); //$NON-NLS-1$
        } catch (ParserException e) {
            // success
            System.out
                .println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }

        helper.setContext(fake);

        try {
            // this should parse OK because the result of the closure expression
            // is more specific than the iterator variable, so it can be
            // assigned recursively
            helper.createQuery("self->closure(getSubFakes())"); //$NON-NLS-1$
        } catch (Exception exc) {
            fail("Failed to parse or evaluate: " + exc.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    public void test_forAll_invalidBody_142518() {
        helper.setContext(getMetaclass("Package")); //$NON-NLS-1$

        try {
            Object result = evaluate(helper, EcorePackage.eINSTANCE,
                "let b:Boolean = null in Bag{1, 2, 3}->forAll(b and b)"); //$NON-NLS-1$

            assertInvalid(result);

            // check that the "check" API interprets invalid as a constraint
            // violation
            assertFalse(check(helper, EcorePackage.eINSTANCE,
                "let b:Boolean = null in Bag{1}->forAll(b and b)")); //$NON-NLS-1$

            // same deal for a null value (in the forAll case)
            result = evaluate(helper, EcorePackage.eINSTANCE,
                "Bag{1, 2, 3}->forAll(null.oclAsType(Boolean))"); //$NON-NLS-1$

            assertInvalid(result);
        } catch (Exception exc) {
            fail("Failed to parse or evaluate: " + exc.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    public void test_exists_invalidBody_142518() {
        helper.setContext(getMetaclass("Package")); //$NON-NLS-1$

        try {
            Object result = evaluate(helper, EcorePackage.eINSTANCE,
                "let b:Boolean = null in Bag{1, 2, 3}->exists(b and b)"); //$NON-NLS-1$

            assertInvalid(result);

            // same deal for a null value (in the exists case)
            result = evaluate(helper, EcorePackage.eINSTANCE,
                "Bag{1, 2, 3}->exists(null.oclAsType(Boolean))"); //$NON-NLS-1$

            assertInvalid(result);
        } catch (Exception exc) {
            fail("Failed to parse or evaluate: " + exc.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    public void test_one_invalidBody_142518() {
        helper.setContext(getMetaclass("Package")); //$NON-NLS-1$

        try {
            Object result = evaluate(helper, EcorePackage.eINSTANCE,
                "let b:Boolean = null in Bag{1, 2, 3}->one(b and b)"); //$NON-NLS-1$

            assertInvalid(result);

            // same deal for a null value (in the one case)
            result = evaluate(helper, EcorePackage.eINSTANCE,
                "Bag{1, 2, 3}->one(null.oclAsType(Boolean))"); //$NON-NLS-1$

            assertInvalid(result);
        } catch (Exception exc) {
            fail("Failed to parse or evaluate: " + exc.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    public void test_any_invalidBody_142518() {
        helper.setContext(getMetaclass("Package")); //$NON-NLS-1$

        try {
            Object result = evaluate(helper, EcorePackage.eINSTANCE,
                "let b:Boolean = null in Bag{1, 2, 3}->any(b and b)"); //$NON-NLS-1$

            assertInvalid(result);

            // same deal for a null value (in the any case)
            result = evaluate(helper, EcorePackage.eINSTANCE,
                "Bag{1, 2, 3}->any(null.oclAsType(Boolean))"); //$NON-NLS-1$

            assertInvalid(result);
        } catch (Exception exc) {
            fail("Failed to parse or evaluate: " + exc.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    public void test_select_invalidBody_142518() {
        helper.setContext(getMetaclass("Package")); //$NON-NLS-1$

        try {
            Object result = evaluate(helper, EcorePackage.eINSTANCE,
                "let b:Boolean = null in Bag{1, 2, 3}->select(b and b)"); //$NON-NLS-1$

            assertInvalid(result);

            // same deal for a null value (in the exists case)
            result = evaluate(helper, EcorePackage.eINSTANCE,
                "Bag{1, 2, 3}->select(null.oclAsType(Boolean))"); //$NON-NLS-1$

            assertInvalid(result);
        } catch (Exception exc) {
            fail("Failed to parse or evaluate: " + exc.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    public void test_reject_invalidBody_142518() {
        helper.setContext(getMetaclass("Package")); //$NON-NLS-1$

        try {
            Object result = evaluate(helper, EcorePackage.eINSTANCE,
                "let b:Boolean = null in Bag{1, 2, 3}->reject(b and b)"); //$NON-NLS-1$

            assertInvalid(result);

            // same deal for a null value (in the exists case)
            result = evaluate(helper, EcorePackage.eINSTANCE,
                "Bag{1, 2, 3}->reject(null.oclAsType(Boolean))"); //$NON-NLS-1$

            assertInvalid(result);
        } catch (Exception exc) {
            fail("Failed to parse or evaluate: " + exc.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    /**
     * Tests that when the body of an iterator results in invalid, the
     * isUnique iterator expression treats it like any other value.
     */
    public void test_isUnique_invalidBody_142518() {
        helper.setContext(getMetaclass("Package")); //$NON-NLS-1$

        try {
            // invalid supports the = operation
            Object result = evaluate(helper, EcorePackage.eINSTANCE,
                "let b:Boolean = null in Bag{1, 2, 3}->isUnique(b and b)"); //$NON-NLS-1$

            assertEquals(Boolean.FALSE, result);

            result = evaluate(helper, EcorePackage.eINSTANCE,
                "let b:Boolean = null in Bag{1, 2, 3}->isUnique(null)"); //$NON-NLS-1$

            assertEquals(Boolean.FALSE, result);
        } catch (Exception exc) {
            fail("Failed to parse or evaluate: " + exc.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    public void test_collect_invalidBody_142518() {
        helper.setContext(getMetaclass("Package")); //$NON-NLS-1$

        try {
            Object result = evaluate(helper, EcorePackage.eINSTANCE,
                "let b:Boolean = null in Bag{1, 2, 3}->collect(b and b)"); //$NON-NLS-1$

            assertInvalid(result);

            // in the case of a null value, null is allowed in a collection, so
            // it does not result in invalid
            result = evaluate(helper, EcorePackage.eINSTANCE,
                "let b:Boolean = null in Bag{1, 2, 3}->collect(null)"); //$NON-NLS-1$

            assertTrue(result instanceof Collection<?>);

            Collection<?> collResult = (Collection<?>) result;
            assertEquals(3, collResult.size());
            for (Iterator<?> iter = collResult.iterator(); iter.hasNext();) {
                assertNull(iter.next());
            }
        } catch (Exception exc) {
            fail("Failed to parse or evaluate: " + exc.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    public void test_collectNested_invalidBody_142518() {
        helper.setContext(getMetaclass("Package")); //$NON-NLS-1$

        try {
            Object result = evaluate(helper, EcorePackage.eINSTANCE,
                "let b:Boolean = null in Bag{1, 2, 3}->collectNested(b and b)"); //$NON-NLS-1$

            assertInvalid(result);

            // in the case of a null value, null is allowed in a collection, so
            // it does not result in invalid
            result = evaluate(
                helper,
                EcorePackage.eINSTANCE,
                "let b:Boolean = null in Bag{1, 2, 3}->collectNested(e | if e = 2 then null else Set{e} endif)"); //$NON-NLS-1$

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
            fail("Failed to parse or evaluate: " + exc.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    public void test_closure_invalidBody_142518() {
        helper.setContext(getMetaclass("Package")); //$NON-NLS-1$

        try {
            Object result = evaluate(helper, getUMLMetamodel(),
                "let c : Type = invalid in ownedType->closure(c)"); //$NON-NLS-1$

            assertInvalid(result);

            // in the case of a null value, null is allowed in a collection, so
            // it does not result in invalid
            result = evaluate(helper, getUMLMetamodel(),
                "let c : Set(Type) = Set{null} in ownedType->closure(c)"); //$NON-NLS-1$

            assertTrue(result instanceof Collection<?>);

            Collection<?> collResult = (Collection<?>) result;
            assertTrue(collResult.isEmpty());
        } catch (Exception exc) {
            fail("Failed to parse or evaluate: " + exc.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

	/**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    public void test_sortedBy_invalidBody_142518() {
        helper.setContext(getMetaclass("Package")); //$NON-NLS-1$

        try {
            Object result = evaluate(helper, EcorePackage.eINSTANCE,
                "let s : String = null in Bag{1, 2, 3}->sortedBy(s.size())"); //$NON-NLS-1$

            assertInvalid(result);

            // same deal for null values
            result = evaluate(helper, EcorePackage.eINSTANCE,
                "Bag{1, 2, 3}->sortedBy(null.oclAsType(Integer))"); //$NON-NLS-1$

            assertInvalid(result);
        } catch (Exception exc) {
            fail("Failed to parse or evaluate: " + exc.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    /**
     * Tests that the generic iterate() iterator returns invalid when the
     * source collection is null or invalid.
     */
    public void test_iterateWithNullSource_143996() {
        helper.setContext(getMetaclass("Package")); //$NON-NLS-1$

        try {
            assertInvalid(evaluate(helper, pkg1,
                "let e : Collection(Package) = null in e->iterate(" + //$NON-NLS-1$
                    "p : Package; s : String = '' | s.concat(p.name))")); //$NON-NLS-1$

            assertInvalid(evaluate(helper, pkg1,
                "let e : Collection(Package) = invalid in e->iterate(" + //$NON-NLS-1$
                    "p : Package; s : String = '' | s.concat(p.name))")); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    /**
     * Tests that the exists() iterator return invalid when the source
     * collection is null or invalid.
     */
    public void test_existsWithNullSource_143996() {
        helper.setContext(getMetaclass("Package")); //$NON-NLS-1$

        try {
            assertInvalid(evaluate(helper, pkg1,
                "let e : Collection(Package) = null in e->exists(" + //$NON-NLS-1$
                    "p : Package | p.name = 'bob')")); //$NON-NLS-1$

            assertInvalid(evaluate(helper, pkg1,
                "let e : Collection(Package) = invalid in e->exists(" + //$NON-NLS-1$
                    "p : Package | p.name = 'bob')")); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
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
        pkg1.setName("pkg1"); //$NON-NLS-1$

        pkg2 = pkg1.createNestedPackage("pkg2"); //$NON-NLS-1$
        jim = pkg2.createNestedPackage("jim"); //$NON-NLS-1$
        bob = pkg1.createNestedPackage("bob"); //$NON-NLS-1$
        pkg3 = pkg1.createNestedPackage("pkg3"); //$NON-NLS-1$
        pkg4 = pkg3.createNestedPackage("pkg4"); //$NON-NLS-1$
        pkg5 = pkg3.createNestedPackage("pkg5"); //$NON-NLS-1$
        george = pkg5.createNestedPackage("george"); //$NON-NLS-1$
    }
}
