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
 * $Id: CollectionsTest.java,v 1.11 2010/11/19 06:21:35 ewillink Exp $
 */

package org.eclipse.ocl.uml.tests;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.uml.TupleType;
import org.eclipse.ocl.util.Tuple;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * Tests for collection types.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class CollectionsTest
    extends AbstractTestSuite {

    /**
     * Tests the insertAt() operation for sequences.
     */
    public void test_insertAt_sequence_126722() {
        helper.setContext(getUMLString());

        try {
            OCLExpression<Classifier> expr = helper
                .createQuery("Sequence{'a', 'b', 'd', 'e'}->insertAt(3, 'c')");

            List<?> result = (List<?>) ocl.evaluate("", expr);

            List<?> expected = Arrays.asList(new Object[] {
                "a", "b", "c", "d", "e"});

            assertEquals(expected, result);
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests the insertAt() operation for ordered sets.
     */
    public void test_insertAt_orderedSet_126722() {
        helper.setContext(getUMLString());

        try {
            OCLExpression<Classifier> expr = helper
                .createQuery("OrderedSet{'a', 'b', 'd', 'e'}->insertAt(3, 'c')");

            Set<?> result = (Set<?>) ocl.evaluate("", expr);

            List<?> expected = Arrays.asList(new Object[] {
                "a", "b", "c", "d", "e"});

            assertEquals(expected, new java.util.ArrayList<Object>(result));

            // no duplicates; result is exactly equivalent (order preserved)

            expr = helper
                .createQuery("OrderedSet{'a', 'b', 'c', 'd', 'e'}->insertAt(5, 'c')");

            result = (Set<?>) ocl.evaluate("", expr);

            expected = Arrays.asList(new Object[] {"a", "b", "c", "d", "e"});

            assertEquals(expected, new java.util.ArrayList<Object>(result));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests the prepend() operation for sequences.
     */
    public void test_prepend_sequence_126722() {
        helper.setContext(getUMLString());

        try {
            OCLExpression<Classifier> expr = helper
                .createQuery("Sequence{'a', 'b', 'd', 'e'}->prepend('c')");

            List<?> result = (List<?>) ocl.evaluate("", expr);

            List<?> expected = Arrays.asList(new Object[] {
                "c", "a", "b", "d", "e"});

            assertEquals(expected, result);
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests the prepend() operation for ordered sets.
     */
    public void test_prepend_orderedSet_126722() {
        helper.setContext(getUMLString());

        try {
            OCLExpression<Classifier> expr = helper
                .createQuery("OrderedSet{'a', 'b', 'd', 'e'}->prepend('c')");

            Set<?> result = (Set<?>) ocl.evaluate("", expr);

            List<?> expected = Arrays.asList(new Object[] {
                "c", "a", "b", "d", "e"});

            assertEquals(expected, new java.util.ArrayList<Object>(result));

            // no duplicates; result has prepended element first

            expr = helper
                .createQuery("OrderedSet{'a', 'b', 'c', 'd', 'e'}->prepend('c')");

            result = (Set<?>) ocl.evaluate("", expr);

            expected = Arrays.asList(new Object[] {"c", "a", "b", "d", "e"});

            assertEquals(expected, new java.util.ArrayList<Object>(result));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests the append() operation for sequences.
     */
    public void test_append_sequence_126722() {
        helper.setContext(getUMLString());

        try {
            OCLExpression<Classifier> expr = helper
                .createQuery("Sequence{'a', 'b', 'd', 'e'}->append('c')");

            List<?> result = (List<?>) ocl.evaluate("", expr);

            List<?> expected = Arrays.asList(new Object[] {
                "a", "b", "d", "e", "c"});

            assertEquals(expected, result);
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests the append() operation for ordered sets.
     */
    public void test_append_orderedSet_126722() {
        helper.setContext(getUMLString());

        try {
            OCLExpression<Classifier> expr = helper
                .createQuery("OrderedSet{'a', 'b', 'd', 'e'}->append('c')");

            Set<?> result = (Set<?>) ocl.evaluate("", expr);

            List<?> expected = Arrays.asList(new Object[] {
                "a", "b", "d", "e", "c"});

            assertEquals(expected, new java.util.ArrayList<Object>(result));

            // no duplicates; appended element is at end

            expr = helper
                .createQuery("OrderedSet{'a', 'b', 'c', 'd', 'e'}->append('c')");

            result = (Set<?>) ocl.evaluate("", expr);

            expected = Arrays.asList(new Object[] {"a", "b", "d", "e", "c"});

            assertEquals(expected, new java.util.ArrayList<Object>(result));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests the including() operation for sequences.
     */
    public void test_including_sequence_126722() {
        helper.setContext(getUMLString());

        try {
            OCLExpression<Classifier> expr = helper
                .createQuery("Sequence{'a', 'b', 'd', 'e'}->including('c')");

            List<?> result = (List<?>) ocl.evaluate("", expr);

            List<?> expected = Arrays.asList(new Object[] {
                "a", "b", "d", "e", "c"});

            assertEquals(expected, result);
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests the including() operation for ordered sets.
     */
    public void test_including_orderedSet_126722() {
        helper.setContext(getUMLString());

        try {
            OCLExpression<Classifier> expr = helper
                .createQuery("OrderedSet{'a', 'b', 'd', 'e'}->including('c')");

            Set<?> result = (Set<?>) ocl.evaluate("", expr);

            Set<?> expected = new java.util.HashSet<Object>(Arrays
                .asList(new Object[] {"a", "b", "d", "e", "c"}));

            assertEquals(expected, result);

            // no duplicates

            expr = helper
                .createQuery("OrderedSet{'a', 'b', 'c', 'd', 'e'}->including('c')");

            result = (Set<?>) ocl.evaluate("", expr);

            expected = new java.util.HashSet<Object>(Arrays
                .asList(new Object[] {"a", "b", "c", "d", "e"}));

            assertEquals(expected, result);
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests the excluding() operation for sequences.
     */
    public void test_excluding_sequence_126722() {
        helper.setContext(getUMLString());

        try {
            OCLExpression<Classifier> expr = helper
                .createQuery("Sequence{'a', 'b', 'c', 'd', 'e'}->excluding('c')");

            List<?> result = (List<?>) ocl.evaluate("", expr);

            List<?> expected = Arrays.asList(new Object[] {"a", "b", "d", "e"});

            assertEquals(expected, result);
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests the excluding() operation for ordered sets.
     */
    public void test_excluding_orderedSet_126722() {
        helper.setContext(getUMLString());

        try {
            OCLExpression<Classifier> expr = helper
                .createQuery("OrderedSet{'a', 'b', 'c', 'd', 'e'}->excluding('c')");

            Set<?> result = (Set<?>) ocl.evaluate("", expr);

            Set<?> expected = new java.util.HashSet<Object>(Arrays
                .asList(new Object[] {"a", "b", "d", "e"}));

            assertEquals(expected, result);

            // just for fun, try excluding an already excluded element

            expr = helper
                .createQuery("OrderedSet{'a', 'b', 'd', 'e'}->excluding('c')");

            result = (Set<?>) ocl.evaluate("", expr);

            expected = new java.util.HashSet<Object>(Arrays
                .asList(new Object[] {"a", "b", "d", "e"}));

            assertEquals(expected, result);
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    public void test_first() {
        helper.setContext(getUMLString());

        try {
            assertTrue(check(helper, "",
                "Sequence{'a', 'b', 'c', 'd', 'e'}->first() = 'a'"));

            assertTrue(check(helper, "",
                "OrderedSet{'a', 'b', 'c', 'd', 'e'}->first() = 'a'"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    public void test_last() {
        helper.setContext(getUMLString());

        try {
            assertTrue(check(helper, "",
                "Sequence{'a', 'b', 'c', 'd', 'e'}->last() = 'e'"));

            assertTrue(check(helper, "",
                "OrderedSet{'a', 'b', 'c', 'd', 'e'}->last() = 'e'"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    public void test_at() {
        helper.setContext(getUMLString());

        try {
            assertTrue(check(helper, "",
                "Sequence{'a', 'b', 'c', 'd', 'e'}->at(3) = 'c'"));

            assertTrue(check(helper, "",
                "OrderedSet{'a', 'b', 'c', 'd', 'e'}->at(3)= 'c'"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    public void test_indexOf() {
        helper.setContext(getUMLString());

        try {
            assertTrue(check(helper, "",
                "Sequence{'a', 'b', 'c', 'd', 'e'}->indexOf('c') = 3"));

            assertTrue(check(helper, "",
                "OrderedSet{'a', 'b', 'c', 'd', 'e'}->indexOf('c')= 3"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    public void test_subsequence_suborderedset() {
        helper.setContext(getUMLString());

        try {
            assertTrue(check(helper, "",
                "Sequence{'a', 'b', 'c', 'd', 'e'}->subSequence(2, 4)" +
                    " = Sequence{'b', 'c', 'd'}"));

            assertTrue(check(helper, "",
                "OrderedSet{'a', 'b', 'c', 'd', 'e'}->subOrderedSet(2, 4)" +
                    " = OrderedSet{'b', 'c', 'd'}"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Test the flatten() operation. In particular, that it is not recursive
     * (only flattens one level).
     */
    public void test_flatten() {
        helper.setContext(getUMLString());

        try {
            assertTrue(check(helper, "",
                "Set{Sequence{'a', 'b'}, Sequence{'b', 'c', 'd'}}->flatten()" +
                    " = Set{'b', 'c', 'a', 'd'}"));

            assertTrue(check(helper,
                "",
                "OrderedSet{Sequence{'a', 'b'}, Sequence{'b', 'c', 'd'}}->flatten()" +
                    " = Set{'b', 'c', 'a', 'd'}"));

            assertTrue(check(helper,
                "",
                "Sequence{OrderedSet{'a', 'b', 'd'}, OrderedSet{'b', 'c', 'd'}}->flatten()" +
                    " = Sequence{'a', 'b', 'd', 'b', 'c', 'd'}"));

            assertTrue(check(helper, "",
                "Bag{Bag{'b', 'a', 'b'}, Bag{'b', 'a', 'c', 'd'}}->flatten()" +
                    " = Bag{'a', 'a', 'b', 'b', 'b', 'c', 'd'}"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Test the flatten() operation on collections not containing collections.
     */
    public void test_flatten_notNested() {
        helper.setContext(getUMLString());

        try {
            assertTrue(check(helper, "",
                "Set{'a', 'b', 'c', 'd'}->flatten()" +
                    " = Set{'b', 'c', 'a', 'd'}"));

            assertTrue(check(helper, "",
                "OrderedSet{'a', 'b', 'b', 'c', 'd'}->flatten()" +
                    " = Set{'b', 'c', 'a', 'd'}"));

            assertTrue(check(helper, "",
                "Sequence{'a', 'b', 'd', 'b', 'c', 'd'}->flatten()" +
                    " = Sequence{'a', 'b', 'd', 'b', 'c', 'd'}"));

            assertTrue(check(helper, "",
                "Bag{'b', 'a', 'b', 'b', 'a', 'c', 'd'}->flatten()" +
                    " = Bag{'a', 'a', 'b', 'b', 'b', 'c', 'd'}"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    public void test_count() {
        helper.setContext(getUMLInteger());

        try {
            assertTrue(check(helper, "",
                "Sequence{1, 2, 3, 3, 4, 5}->count(3) = 2"));

            assertTrue(check(helper, "",
                "Sequence{1, 2, 3, 3, 4, 5}->count(6) = 0"));

            assertTrue(check(helper, "",
                "OrderedSet{1, 2, 3, 3, 4, 5}->count(3) = 1"));

            assertTrue(check(helper, "",
                "OrderedSet{1, 2, 3, 3, 4, 5}->count(6) = 0"));

            assertTrue(check(helper, "",
                "Set{1, 2, 3, 3, 4, 5}->count(3) = 1"));

            assertTrue(check(helper, "",
                "Set{1, 2, 3, 3, 4, 5}->count(6) = 0"));

            assertTrue(check(helper, "",
                "Bag{1, 2, 3, 3, 4, 5}->count(3) = 2"));

            assertTrue(check(helper, "",
                "Bag{1, 2, 3, 3, 4, 5}->count(6) = 0"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    public void test_sum() {
        helper.setContext(getUMLInteger());

        try {
            assertTrue(check(helper, "",
                "Sequence{1, 2, 3, 3, 4, 5}->sum() = 18"));

            assertTrue(check(helper, "",
                "OrderedSet{1, 2, 3, 3, 4, 5}->sum() = 15"));

            assertTrue(check(helper, "",
                "Set{1, 2, 3, 3, 4, 5}->sum() = 15"));

            assertTrue(check(helper, "",
                "Bag{1, 2, 3, 3, 4, 5}->sum() = 18"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    public void test_includes() {
        helper.setContext(getUMLInteger());

        try {
            assertTrue(check(helper, "",
                "Sequence{1, 2, 3, 3, 4, 5}->includes(3)"));

            assertFalse(check(helper, "",
                "Sequence{1, 2, 3, 3, 4, 5}->includes(6)"));

            assertTrue(check(helper, "",
                "Set{1, 2, 3, 3, 4, 5}->includes(3)"));

            assertFalse(check(helper, "",
                "Set{1, 2, 3, 3, 4, 5}->includes(6)"));

            assertTrue(check(helper, "",
                "OrderedSet{1, 2, 3, 3, 4, 5}->includes(3)"));

            assertFalse(check(helper, "",
                "OrderedSet{1, 2, 3, 3, 4, 5}->includes(6)"));

            assertTrue(check(helper, "",
                "Bag{1, 2, 3, 3, 4, 5}->includes(3)"));

            assertFalse(check(helper, "",
                "Bag{1, 2, 3, 3, 4, 5}->includes(6)"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    public void test_includesAll() {
        helper.setContext(getUMLInteger());

        try {
            assertTrue(check(helper, "",
                "Sequence{1, 2, 3, 3, 4, 5}->includesAll(Sequence{1, 3})"));

            assertFalse(check(helper, "",
                "Sequence{1, 2, 3, 3, 4, 5}->includesAll(Sequence{1, 6})"));

            assertTrue(check(helper, "",
                "Set{1, 2, 3, 3, 4, 5}->includesAll(Set{1, 3})"));

            assertFalse(check(helper, "",
                "Set{1, 2, 3, 3, 4, 5}->includesAll(Set{1, 6})"));

            assertTrue(check(helper, "",
                "OrderedSet{1, 2, 3, 3, 4, 5}->includesAll(OrderedSet{1, 3})"));

            assertFalse(check(helper, "",
                "OrderedSet{1, 2, 3, 3, 4, 5}->includesAll(OrderedSet{1, 6})"));

            assertTrue(check(helper, "",
                "Bag{1, 2, 3, 3, 4, 5}->includesAll(Bag{1, 3})"));

            assertFalse(check(helper, "",
                "Bag{1, 2, 3, 3, 4, 5}->includesAll(Bag{1, 6})"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    public void test_union() {
        helper.setContext(getUMLInteger());

        try {
            assertTrue(check(helper, "",
                "Set{1, 2, 3}->union(Set{3, 4, 5})" +
                    " = Set{1, 2, 3, 4, 5}"));

            assertTrue(check(helper, "",
                "OrderedSet{1, 2, 3}->union(Set{3, 4, 5})" +
                    " = Set{1, 2, 3, 4, 5}"));

            assertTrue(check(helper, "",
                "Bag{1, 2, 2, 3}->union(Set{3, 4, 5})" +
                    " = Bag{1, 2, 2, 3, 3, 4, 5}"));

            assertTrue(check(helper, "",
                "Bag{1, 2, 3}->union(Bag{3, 3, 4, 5})" +
                    " = Bag{1, 2, 3, 3, 3, 4, 5}"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    public void test_intersection() {
        helper.setContext(getUMLInteger());

        try {
            assertTrue(check(helper, "",
                "Set{1, 2, 3}->intersection(Set{3, 4, 5})" +
                    " = Set{3}"));

            assertTrue(check(helper, "",
                "OrderedSet{1, 2, 3}->intersection(Set{3, 4, 5})" +
                    " = Set{3}"));

            assertTrue(check(helper, "",
                "Bag{1, 2, 2, 3, 3, 3}->intersection(Bag{3, 3, 4, 5})" +
                    " = Bag{3, 3}"));

            assertTrue(check(helper, "",
                "Bag{1, 2, 2, 3, 3, 3}->intersection(Set{3, 4, 5})" +
                    " = Set{3}"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    public void test_difference() {
        helper.setContext(getUMLInteger());

        try {
            assertTrue(check(helper, "",
                "Set{1, 2, 3} - Set{3, 4, 5}" +
                    " = Set{1, 2}"));

            assertTrue(check(helper, "",
                "OrderedSet{1, 2, 3} - Set{3, 4, 5}" +
                    " = Set{1, 2}"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    public void test_symmetricDifference() {
        helper.setContext(getUMLInteger());

        try {
            assertTrue(check(helper, "",
                "Set{1, 2, 3}->symmetricDifference(Set{3, 4, 5})" +
                    " = Set{1, 2, 4, 5}"));

            assertTrue(check(helper, "",
                "OrderedSet{1, 2, 3}->symmetricDifference(Set{3, 4, 5})" +
                    " = Set{1, 2, 4, 5}"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests that dot notation can be used successively to navigate multiple
     * collection-type references.
     */
    public void test_dotNavigationOfReferenceCollections_130239() {
        helper.setContext(getMetaclass("Package"));

        try {
            OCLExpression<Classifier> expr = helper
                .createQuery("self.ownedType->union(self.nestedPackage.ownedType->asSet())->asSet()");

            assertEquals(new java.util.HashSet<Type>(fruitPackage
                .getOwnedTypes()), ocl.evaluate(fruitPackage, expr));
        } catch (Exception exc) {
            fail("Failed to parse or evaluate: " + exc.getLocalizedMessage());
        }
    }

    /**
     * Tests that dot notation can be used successively to navigate multiple
     * collection-type operations.
     */
    public void test_dotNavigationOfOperationCollections_130239() {
        Package fakePkg = umlf.createPackage();
        fakePkg.setName("fake");
        Class fake = fakePkg.createOwnedClass("Fake", false);
        Operation getFakes = fake.createOwnedOperation(
            "getFakes", null, null, fake);
        getFakes.setUpper(LiteralUnlimitedNatural.UNLIMITED);
        getFakes.setIsQuery(true);

        helper.setContext(fake);

        try {
            helper
                .createQuery("self.getFakes()->union(self.getFakes().getFakes()->asSet())");
        } catch (Exception exc) {
            fail("Failed to parse or evaluate: " + exc.getLocalizedMessage());
        }
    }

    /**
     * Tests that the syntax for collection ranges is supported.
     */
    public void test_collectionRange_152208() {
        helper.setContext(getUMLInteger());

        try {
            Collection<?> result = (Collection<?>) evaluate(helper,
                new Integer(1), "Sequence{1 .. 10}");

            for (int i = 1; i <= 10; i++) {
                assertTrue(result.contains(new Integer(i)));
            }

            result = (Collection<?>) evaluate(helper, new Integer(1),
                "Sequence{1, (2+1)..(3+4), 10}");

            assertTrue(result.contains(new Integer(1)));
            for (int i = 3; i <= 7; i++) {
                assertTrue(result.contains(new Integer(i)));
            }
            assertTrue(result.contains(new Integer(10)));

            // try the first expression without spaces (needed a grammar change)
            result = (Collection<?>) evaluate(helper, new Integer(1),
                "Sequence{1..10}");

            for (int i = 1; i <= 10; i++) {
                assertTrue(result.contains(new Integer(i)));
            }

            // and a negation, too (the same grammar change)
            result = (Collection<?>) evaluate(helper, new Integer(1),
                "Sequence{-20, -10..-1, 1}");

            assertTrue(result.contains(new Integer(-20)));
            for (int i = -10; i <= -1; i++) {
                assertTrue(result.contains(new Integer(i)));
            }
            assertTrue(result.contains(new Integer(1)));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

	/**
	 * Tests that the a singleton collection range is iterable.
	 */
	public void test_collectionRange_330489() {
		helper.setContext(getUMLInteger());

		try {
			Collection<?> result = (Collection<?>) evaluate(helper,
				new Integer(1), "Sequence{1 .. 1}");
			assertEquals(1, result.size());
			assertTrue(result.contains(new Integer(1)));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
		}
	}


    /**
     * Tests the support for tuples whose parts are collections that are not
     * collection literals.
     */
    public void test_tupleWithCollectionPart_175490() {
        helper.setContext(getMetaclass("Package"));

        try {
            OCLExpression<Classifier> expr = helper
                .createQuery("Tuple{a = self.ownedType}");

            assertTrue(expr.getType() instanceof TupleType);
            TupleType tt = (TupleType) expr.getType();

            assertEquals(1, tt.getOwnedAttributes().size());
            Property part = tt.getOwnedAttribute("a", null);

            assertNotNull(part);
            assertTrue(part.getType() instanceof CollectionType<?, ?>);

            @SuppressWarnings("unchecked")
            CollectionType<Classifier, Operation> collType = (CollectionType<Classifier, Operation>) part
                .getType();
            assertSame(getMetaclass("Type"), collType.getElementType());

            Object result = ocl.evaluate(getUMLMetamodel(), expr);
            assertTrue(result instanceof Tuple<?, ?>);

            @SuppressWarnings("unchecked")
            Tuple<Operation, Property> tuple = (Tuple<Operation, Property>) result;

            assertTrue(tuple.getValue("a") instanceof Collection<?>);
            assertTrue(((Collection<?>) tuple.getValue("a")).contains(getMetaclass("Classifier")));
        } catch (Exception exc) {
            fail("Failed to parse or evaluate: " + exc.getLocalizedMessage());
        }
    }

    /**
     * Tests the support for tuples whose parts are collections that are
     * collection literals.
     */
    public void test_tupleWithCollectionLiteralPart_175490() {
        helper.setContext(getMetaclass("Package"));

        try {
            OCLExpression<Classifier> expr = helper
                .createQuery("Tuple{a = Sequence{'a', 'b', 'c'}}");

            assertTrue(expr.getType() instanceof TupleType);
            TupleType tt = (TupleType) expr.getType();

            assertEquals(1, tt.getOwnedAttributes().size());
            Property part = tt.getOwnedAttribute("a", null);

            assertNotNull(part);
            assertTrue(part.getType() instanceof CollectionType<?, ?>);

            @SuppressWarnings("unchecked")
            CollectionType<Classifier, Operation> collType = (CollectionType<Classifier, Operation>) part
                .getType();
            assertSame(getOCLStandardLibrary().getString(), collType
                .getElementType());

            Object result = ocl.evaluate(getUMLMetamodel(), expr);
            assertTrue(result instanceof Tuple<?, ?>);

            @SuppressWarnings("unchecked")
            Tuple<Operation, Property> tuple = (Tuple<Operation, Property>) result;

            assertTrue(tuple.getValue("a") instanceof Collection<?>);
            assertTrue(((Collection<?>) tuple.getValue("a")).contains("b"));
        } catch (Exception exc) {
            fail("Failed to parse or evaluate: " + exc.getLocalizedMessage());
        }
    }

    /**
     * Tests that the values of operation calls of collection type are
     * collections of the correct type.
     */
    public void test_operationValueCollectionType_183667() {
        helper.setContext(getMetaclass("Element"));

        try {
            OCLExpression<Classifier> expr = helper
                .createQuery("self.getKeywords()");

            // the UML Metamodel, itself, is an element. What are its keywords?
            Object value = ocl.evaluate(getUMLMetamodel(), expr);

            // should be a set, not an EList
            assertTrue(value instanceof Set<?>);
            assertFalse(value instanceof EList<?>);
        } catch (Exception exc) {
            fail("Failed to parse or evaluate: " + exc.getLocalizedMessage());
        }
    }

    /**
     * Tests that the values of property navigations of collection type are
     * collections of the correct type.
     */
    public void test_propertyValueCollectionType_183667() {
        helper.setContext(getMetaclass("Element"));

        try {
            OCLExpression<Classifier> expr = helper
                .createQuery("self.ownedComment");

            // the UML Metamodel, itself, is an element. What are its comments?
            Object value = ocl.evaluate(getUMLMetamodel(), expr);

            // should be a set, not an EList
            assertTrue(value instanceof Set<?>);
            assertFalse(value instanceof EList<?>);
        } catch (Exception exc) {
            fail("Failed to parse or evaluate: " + exc.getLocalizedMessage());
        }
    }
    
    /**
     * Tests that operation calls coerce collection-valued arguments to the
     * Java <code>EList</code> type.
     */
    public void test_coercionOfCollectionParameters_184789() {
        Package pkg = UMLFactory.eINSTANCE.createPackage();
        pkg.createOwnedClass("Foo", false);
        pkg.createOwnedClass("Foo", false);
        pkg.createOwnedClass("Foo", false);
        Class bar = pkg.createOwnedClass("Bar", false);
       
        helper.setContext(getMetaclass("Package"));

        try {
            OCLExpression<Classifier> expr = helper.createQuery(
                "self.excludeCollisions(ownedType)");

            Object value = ocl.evaluate(pkg, expr);

            assertEquals(Collections.singleton(bar), value);
        } catch (Exception exc) {
            fail("Failed to parse or evaluate: " + exc.getLocalizedMessage());
        }
    }
    
    /**
     * Tests that the OCL Standard Library defines the correct signature for
     * the <code>Sequence::&lt;&gt;(Sequence(T))</code> operation.
     */
    public void test_sequenceNotEqualSignature_184327() {
        helper.setContext(getUMLString());
        
        try {
            assertTrue(check(helper, "",
                    "Sequence{1, 2, 3} <> Sequence{3, 2, 1}"));

            assertFalse(check(helper, "",
                    "Sequence{1, 2, 3} <> Sequence{1, 2, 3}"));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }
}
