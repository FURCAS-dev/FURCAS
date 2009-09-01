/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2009 IBM Corporation, Zeligsoft Inc., Open Canarias S.L. and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 244946
 *   Adolfo Sanchez-Barbudo Herrera - Bug 260403
 *
 * </copyright>
 *
 * $Id: CollectionsTest.java,v 1.14 2009/09/01 20:10:53 ewillink Exp $
 */

package org.eclipse.ocl.ecore.tests;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.TypeResolver;
import org.eclipse.ocl.ecore.TupleType;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.expressions.ExpressionsFactory;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.util.Tuple;
import org.eclipse.ocl.util.TypeUtil;

/**
 * Tests for collection types.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class CollectionsTest
		extends AbstractTestSuite {

	public CollectionsTest(String name) {
		super(name);
	}

	public static Test suite() {
		return new TestSuite(CollectionsTest.class, "Collection Type Tests"); //$NON-NLS-1$
	}

	/**
	 * Tests the insertAt() operation for sequences.
	 */
	public void test_insertAt_sequence_126722() {
		helper.setContext(EcorePackage.Literals.ESTRING);

		try {
			OCLExpression<EClassifier> expr = helper
				.createQuery("Sequence{'a', 'b', 'd', 'e'}->insertAt(3, 'c')"); //$NON-NLS-1$

			List<?> result = (List<?>) ocl.evaluate("", expr); //$NON-NLS-1$

			List<?> expected = Arrays.asList(new Object[]{
				"a", "b", "c", "d", "e"}); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$

			assertEquals(expected, result);
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Tests the insertAt() operation for ordered sets.
	 */
	public void test_insertAt_orderedSet_126722() {
		helper.setContext(EcorePackage.Literals.ESTRING);

		try {
			OCLExpression<EClassifier> expr = helper
				.createQuery("OrderedSet{'a', 'b', 'd', 'e'}->insertAt(3, 'c')"); //$NON-NLS-1$

			Set<?> result = (Set<?>) ocl.evaluate("", expr); //$NON-NLS-1$

			List<?> expected = Arrays.asList(new Object[]{
				"a", "b", "c", "d", "e"}); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$

			assertEquals(expected, new java.util.ArrayList<Object>(result));

			// no duplicates; result is exactly equivalent (order preserved)

			expr = helper
				.createQuery("OrderedSet{'a', 'b', 'c', 'd', 'e'}->insertAt(5, 'c')"); //$NON-NLS-1$

			result = (Set<?>) ocl.evaluate("", expr); //$NON-NLS-1$

			expected = Arrays.asList(new Object[]{"a", "b", "c", "d", "e"}); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$

			assertEquals(expected, new java.util.ArrayList<Object>(result));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Tests the prepend() operation for sequences.
	 */
	public void test_prepend_sequence_126722() {
		helper.setContext(EcorePackage.Literals.ESTRING);

		try {
			OCLExpression<EClassifier> expr = helper
				.createQuery("Sequence{'a', 'b', 'd', 'e'}->prepend('c')"); //$NON-NLS-1$

			List<?> result = (List<?>) ocl.evaluate("", expr); //$NON-NLS-1$

			List<?> expected = Arrays.asList(new Object[]{
				"c", "a", "b", "d", "e"}); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$

			assertEquals(expected, result);
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Tests the prepend() operation for ordered sets.
	 */
	public void test_prepend_orderedSet_126722() {
		helper.setContext(EcorePackage.Literals.ESTRING);

		try {
			OCLExpression<EClassifier> expr = helper
				.createQuery("OrderedSet{'a', 'b', 'd', 'e'}->prepend('c')"); //$NON-NLS-1$

			Set<?> result = (Set<?>) ocl.evaluate("", expr); //$NON-NLS-1$

			List<?> expected = Arrays.asList(new Object[]{
				"c", "a", "b", "d", "e"}); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$

			assertEquals(expected, new java.util.ArrayList<Object>(result));

			// no duplicates; result has prepended element first

			expr = helper
				.createQuery("OrderedSet{'a', 'b', 'c', 'd', 'e'}->prepend('c')"); //$NON-NLS-1$

			result = (Set<?>) ocl.evaluate("", expr); //$NON-NLS-1$

			expected = Arrays.asList(new Object[]{"c", "a", "b", "d", "e"}); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$

			assertEquals(expected, new java.util.ArrayList<Object>(result));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Tests the append() operation for sequences.
	 */
	public void test_append_sequence_126722() {
		helper.setContext(EcorePackage.Literals.ESTRING);

		try {
			OCLExpression<EClassifier> expr = helper
				.createQuery("Sequence{'a', 'b', 'd', 'e'}->append('c')"); //$NON-NLS-1$

			List<?> result = (List<?>) ocl.evaluate("", expr); //$NON-NLS-1$

			List<?> expected = Arrays.asList(new Object[]{
				"a", "b", "d", "e", "c"}); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$

			assertEquals(expected, result);
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Tests the append() operation for ordered sets.
	 */
	public void test_append_orderedSet_126722() {
		helper.setContext(EcorePackage.Literals.ESTRING);

		try {
			OCLExpression<EClassifier> expr = helper
				.createQuery("OrderedSet{'a', 'b', 'd', 'e'}->append('c')"); //$NON-NLS-1$

			Set<?> result = (Set<?>) ocl.evaluate("", expr); //$NON-NLS-1$

			List<?> expected = Arrays.asList(new Object[]{
				"a", "b", "d", "e", "c"}); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$

			assertEquals(expected, new java.util.ArrayList<Object>(result));

			// no duplicates; appended element is at end

			expr = helper
				.createQuery("OrderedSet{'a', 'b', 'c', 'd', 'e'}->append('c')"); //$NON-NLS-1$

			result = (Set<?>) ocl.evaluate("", expr); //$NON-NLS-1$

			expected = Arrays.asList(new Object[]{"a", "b", "d", "e", "c"}); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$

			assertEquals(expected, new java.util.ArrayList<Object>(result));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Tests the including() operation for sequences.
	 */
	public void test_including_sequence_126722() {
		helper.setContext(EcorePackage.Literals.ESTRING);

		try {
			OCLExpression<EClassifier> expr = helper
				.createQuery("Sequence{'a', 'b', 'd', 'e'}->including('c')"); //$NON-NLS-1$

			List<?> result = (List<?>) ocl.evaluate("", expr); //$NON-NLS-1$

			List<?> expected = Arrays.asList(new Object[]{
				"a", "b", "d", "e", "c"}); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$

			assertEquals(expected, result);
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Tests the including() operation for ordered sets.
	 */
	public void test_including_orderedSet_126722() {
		helper.setContext(EcorePackage.Literals.ESTRING);

		try {
			OCLExpression<EClassifier> expr = helper
				.createQuery("OrderedSet{'a', 'b', 'd', 'e'}->including('c')"); //$NON-NLS-1$

			Set<?> result = (Set<?>) ocl.evaluate("", expr); //$NON-NLS-1$

			Set<?> expected = new java.util.HashSet<Object>(Arrays
				.asList(new Object[]{"a", "b", "d", "e", "c"})); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$

			assertEquals(expected, result);

			// no duplicates

			expr = helper
				.createQuery("OrderedSet{'a', 'b', 'c', 'd', 'e'}->including('c')"); //$NON-NLS-1$

			result = (Set<?>) ocl.evaluate("", expr); //$NON-NLS-1$

			expected = new java.util.HashSet<Object>(Arrays
				.asList(new Object[]{"a", "b", "c", "d", "e"})); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$

			assertEquals(expected, result);
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Tests the excluding() operation for sequences.
	 */
	public void test_excluding_sequence_126722() {
		helper.setContext(EcorePackage.Literals.ESTRING);

		try {
			OCLExpression<EClassifier> expr = helper
				.createQuery("Sequence{'a', 'b', 'c', 'd', 'e'}->excluding('c')"); //$NON-NLS-1$

			List<?> result = (List<?>) ocl.evaluate("", expr); //$NON-NLS-1$

			List<?> expected = Arrays.asList(new Object[]{"a", "b", "d", "e"}); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$

			assertEquals(expected, result);
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Tests the excluding() operation for ordered sets.
	 */
	public void test_excluding_orderedSet_126722() {
		helper.setContext(EcorePackage.Literals.ESTRING);

		try {
			OCLExpression<EClassifier> expr = helper
				.createQuery("OrderedSet{'a', 'b', 'c', 'd', 'e'}->excluding('c')"); //$NON-NLS-1$

			Set<?> result = (Set<?>) ocl.evaluate("", expr); //$NON-NLS-1$

			Set<?> expected = new java.util.HashSet<Object>(Arrays
				.asList(new Object[]{"a", "b", "d", "e"})); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$

			assertEquals(expected, result);

			// just for fun, try excluding an already excluded element

			expr = helper
				.createQuery("OrderedSet{'a', 'b', 'd', 'e'}->excluding('c')"); //$NON-NLS-1$

			result = (Set<?>) ocl.evaluate("", expr); //$NON-NLS-1$

			expected = new java.util.HashSet<Object>(Arrays
				.asList(new Object[]{"a", "b", "d", "e"})); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$

			assertEquals(expected, result);
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	public void test_first() {
		helper.setContext(EcorePackage.Literals.ESTRING);

		try {
			assertTrue(check(helper, "", //$NON-NLS-1$
				"Sequence{'a', 'b', 'c', 'd', 'e'}->first() = 'a'")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"OrderedSet{'a', 'b', 'c', 'd', 'e'}->first() = 'a'")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	public void test_last() {
		helper.setContext(EcorePackage.Literals.ESTRING);

		try {
			assertTrue(check(helper, "", //$NON-NLS-1$
				"Sequence{'a', 'b', 'c', 'd', 'e'}->last() = 'e'")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"OrderedSet{'a', 'b', 'c', 'd', 'e'}->last() = 'e'")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	public void test_at() {
		helper.setContext(EcorePackage.Literals.ESTRING);

		try {
			assertTrue(check(helper, "", //$NON-NLS-1$
				"Sequence{'a', 'b', 'c', 'd', 'e'}->at(3) = 'c'")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"OrderedSet{'a', 'b', 'c', 'd', 'e'}->at(3)= 'c'")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	public void test_indexOf() {
		helper.setContext(EcorePackage.Literals.ESTRING);

		try {
			assertTrue(check(helper, "", //$NON-NLS-1$
				"Sequence{'a', 'b', 'c', 'd', 'e'}->indexOf('c') = 3")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"OrderedSet{'a', 'b', 'c', 'd', 'e'}->indexOf('c')= 3")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	public void test_subsequence_suborderedset() {
		helper.setContext(EcorePackage.Literals.ESTRING);

		try {
			assertTrue(check(helper, "", //$NON-NLS-1$
				"Sequence{'a', 'b', 'c', 'd', 'e'}->subSequence(2, 4)" + //$NON-NLS-1$
					" = Sequence{'b', 'c', 'd'}")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"OrderedSet{'a', 'b', 'c', 'd', 'e'}->subOrderedSet(2, 4)" + //$NON-NLS-1$
					" = OrderedSet{'b', 'c', 'd'}")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Test the flatten() operation on a single level of collection nesting.
	 */
	public void test_flatten() {
		helper.setContext(EcorePackage.Literals.ESTRING);

		try {
			assertTrue(check(helper, "", //$NON-NLS-1$
				"Set{Sequence{'a', 'b'}, Sequence{'b', 'c', 'd'}}->flatten()" + //$NON-NLS-1$
					" = Set{'b', 'c', 'a', 'd'}")); //$NON-NLS-1$

			assertTrue(check(helper,
				"", //$NON-NLS-1$
				"OrderedSet{Sequence{'a', 'b'}, Sequence{'b', 'c', 'd'}}->flatten()" + //$NON-NLS-1$
					" = Set{'b', 'c', 'a', 'd'}")); //$NON-NLS-1$

			assertTrue(check(helper,
				"", //$NON-NLS-1$
				"Sequence{OrderedSet{'a', 'b', 'd'}, OrderedSet{'b', 'c', 'd'}}->flatten()" + //$NON-NLS-1$
					" = Sequence{'a', 'b', 'd', 'b', 'c', 'd'}")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"Bag{Bag{'b', 'a', 'b'}, Bag{'b', 'a', 'c', 'd'}}->flatten()" + //$NON-NLS-1$
					" = Bag{'a', 'a', 'b', 'b', 'b', 'c', 'd'}")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Test the flatten() operation on collections not containing collections.
	 */
	public void test_flatten_notNested() {
		helper.setContext(EcorePackage.Literals.ESTRING);

		try {
			assertTrue(check(helper, "", //$NON-NLS-1$
				"Set{'a', 'b', 'c', 'd'}->flatten()" + //$NON-NLS-1$
					" = Set{'b', 'c', 'a', 'd'}")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"OrderedSet{'a', 'b', 'b', 'c', 'd'}->flatten()" + //$NON-NLS-1$
					" = Set{'b', 'c', 'a', 'd'}")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"Sequence{'a', 'b', 'd', 'b', 'c', 'd'}->flatten()" + //$NON-NLS-1$
					" = Sequence{'a', 'b', 'd', 'b', 'c', 'd'}")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"Bag{'b', 'a', 'b', 'b', 'a', 'c', 'd'}->flatten()" + //$NON-NLS-1$
					" = Bag{'a', 'a', 'b', 'b', 'b', 'c', 'd'}")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Tests the flatten() operation on an empty source collection.
	 */
	public void test_flatten_emptySource_195252() {
		helper.setContext(EcorePackage.Literals.ESTRING);

		try {
			assertTrue(check(helper, "", //$NON-NLS-1$
				"Set{}->flatten()" + //$NON-NLS-1$
					" = Set{}")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"OrderedSet{}->flatten()" + //$NON-NLS-1$
					" = Set{}")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"Sequence{}->flatten()" + //$NON-NLS-1$
					" = Sequence{}")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"Bag{}->flatten()" + //$NON-NLS-1$
					" = Bag{}")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Tests the flatten() operation on a source collection that contains empty
	 * collections.
	 */
	public void test_flatten_emptyChildren() {
		helper.setContext(EcorePackage.Literals.ESTRING);

		try {
			assertTrue(check(helper, "", //$NON-NLS-1$
				"Set{Set{}, Set{}}->flatten()" + //$NON-NLS-1$
					" = Set{}")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"OrderedSet{OrderedSet{}, OrderedSet{}}->flatten()" + //$NON-NLS-1$
					" = Set{}")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"Sequence{Sequence{}, Sequence{}}->flatten()" + //$NON-NLS-1$
					" = Sequence{}")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"Bag{Bag{}, Bag{}}->flatten()" + //$NON-NLS-1$
					" = Bag{}")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Test that the flatten() operation is recursive.
	 */
	public void test_flatten_recursive_217461() {
		helper.setContext(EcorePackage.Literals.ESTRING);

		try {
			assertTrue(check(helper,
				"", //$NON-NLS-1$
				"Set{Sequence{Set{'a'}, Set{'b'}}, Sequence{Set{'b', 'c'}, Set{'d'}}}->flatten()" + //$NON-NLS-1$
					" = Set{'b', 'c', 'a', 'd'}")); //$NON-NLS-1$

			assertTrue(check(helper,
				"", //$NON-NLS-1$
				"OrderedSet{Sequence{Set{'a'}, Set{'b'}}, Sequence{Set{'b', 'c'}, Set{'d'}}}->flatten()" + //$NON-NLS-1$
					" = Set{'b', 'c', 'a', 'd'}")); //$NON-NLS-1$

			assertTrue(check(helper,
				"", //$NON-NLS-1$
				"Sequence{OrderedSet{Sequence{'a', 'b'}, Sequence{'d'}}, OrderedSet{Sequence{'b', 'c'}, Sequence{'d'}}}->flatten()" + //$NON-NLS-1$
					" = Sequence{'a', 'b', 'd', 'b', 'c', 'd'}")); //$NON-NLS-1$

			assertTrue(check(helper,
				"", //$NON-NLS-1$
				"Bag{Bag{Set{'b', 'a'}, Set{'b'}}, Bag{Set{'b', 'a'}, Set{'c', 'd'}}}->flatten()" + //$NON-NLS-1$
					" = Bag{'a', 'a', 'b', 'b', 'b', 'c', 'd'}")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Tests the flatten() operation on a source collection that contains empty
	 * collections at a greater level of nesting than the first.
	 */
	public void test_flatten_emptyChildrenRecursive_217461() {
		helper.setContext(EcorePackage.Literals.ESTRING);

		try {
			assertTrue(check(helper, "", //$NON-NLS-1$
				"Set{Set{Sequence{}}, Set{Sequence{}, Sequence{}}}->flatten()" + //$NON-NLS-1$
					" = Set{}")); //$NON-NLS-1$

			assertTrue(check(helper,
				"", //$NON-NLS-1$
				"OrderedSet{OrderedSet{Sequence{}, Sequence{}}, OrderedSet{Sequence{}, Sequence{}}}->flatten()" + //$NON-NLS-1$
					" = Set{}")); //$NON-NLS-1$

			assertTrue(check(helper,
				"", //$NON-NLS-1$
				"Sequence{Sequence{Sequence{}, Sequence{}}, Sequence{Sequence{}, Sequence{}}}->flatten()" + //$NON-NLS-1$
					" = Sequence{}")); //$NON-NLS-1$

			assertTrue(check(helper,
				"", //$NON-NLS-1$
				"Bag{Bag{Sequence{}, Sequence{}}, Bag{Sequence{}, Sequence{}}}->flatten()" + //$NON-NLS-1$
					" = Bag{}")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	public void test_count() {
		helper.setContext(EcorePackage.Literals.EINT);

		try {
			assertTrue(check(helper, "", //$NON-NLS-1$
				"Sequence{1, 2, 3, 3, 4, 5}->count(3) = 2")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"Sequence{1, 2, 3, 3, 4, 5}->count(6) = 0")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"OrderedSet{1, 2, 3, 3, 4, 5}->count(3) = 1")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"OrderedSet{1, 2, 3, 3, 4, 5}->count(6) = 0")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"Set{1, 2, 3, 3, 4, 5}->count(3) = 1")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"Set{1, 2, 3, 3, 4, 5}->count(6) = 0")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"Bag{1, 2, 3, 3, 4, 5}->count(3) = 2")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"Bag{1, 2, 3, 3, 4, 5}->count(6) = 0")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	public void test_sum() {
		helper.setContext(EcorePackage.Literals.EINT);

		try {
			assertTrue(check(helper, "", //$NON-NLS-1$
				"Sequence{1, 2, 3, 3, 4, 5}->sum() = 18")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"OrderedSet{1, 2, 3, 3, 4, 5}->sum() = 15")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"Set{1, 2, 3, 3, 4, 5}->sum() = 15")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"Bag{1, 2, 3, 3, 4, 5}->sum() = 18")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Tests that the sum() iterator returns integer zero for an empty
	 * collection of integers.
	 */
	public void test_sum_emptyIntegerCollection_204753() {
		helper.setContext(EcorePackage.Literals.EINT);

		Integer zero = new Integer(0);

		try {
			assertEquals(zero, evaluate(helper, "", //$NON-NLS-1$
				"let s : Sequence(Integer) = Sequence{} in s->sum()")); //$NON-NLS-1$

			assertEquals(zero, evaluate(helper, "", //$NON-NLS-1$
				"let s : OrderedSet(Integer) = OrderedSet{} in s->sum()")); //$NON-NLS-1$

			assertEquals(zero, evaluate(helper, "", //$NON-NLS-1$
				"let s : Set(Integer) = Set{} in s->sum()")); //$NON-NLS-1$

			assertEquals(zero, evaluate(helper, "", //$NON-NLS-1$
				"let s : Bag(Integer) = Bag{} in s->sum()")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Tests that the sum() iterator returns integer zero for an empty
	 * collection of reals.
	 */
	public void test_sum_emptyRealCollection_204753() {
		helper.setContext(EcorePackage.Literals.EINT);

		Double zero = new Double(0.0);

		try {
			assertEquals(zero, evaluate(helper, "", //$NON-NLS-1$
				"let s : Sequence(Real) = Sequence{} in s->sum()")); //$NON-NLS-1$

			assertEquals(zero, evaluate(helper, "", //$NON-NLS-1$
				"let s : OrderedSet(Real) = OrderedSet{} in s->sum()")); //$NON-NLS-1$

			assertEquals(zero, evaluate(helper, "", //$NON-NLS-1$
				"let s : Set(Real) = Set{} in s->sum()")); //$NON-NLS-1$

			assertEquals(zero, evaluate(helper, "", //$NON-NLS-1$
				"let s : Bag(Real) = Bag{} in s->sum()")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	public void test_includes() {
		helper.setContext(EcorePackage.Literals.EINT);

		try {
			assertTrue(check(helper, "", //$NON-NLS-1$
				"Sequence{1, 2, 3, 3, 4, 5}->includes(3)")); //$NON-NLS-1$

			assertFalse(check(helper, "", //$NON-NLS-1$
				"Sequence{1, 2, 3, 3, 4, 5}->includes(6)")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"Set{1, 2, 3, 3, 4, 5}->includes(3)")); //$NON-NLS-1$

			assertFalse(check(helper, "", //$NON-NLS-1$
				"Set{1, 2, 3, 3, 4, 5}->includes(6)")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"OrderedSet{1, 2, 3, 3, 4, 5}->includes(3)")); //$NON-NLS-1$

			assertFalse(check(helper, "", //$NON-NLS-1$
				"OrderedSet{1, 2, 3, 3, 4, 5}->includes(6)")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"Bag{1, 2, 3, 3, 4, 5}->includes(3)")); //$NON-NLS-1$

			assertFalse(check(helper, "", //$NON-NLS-1$
				"Bag{1, 2, 3, 3, 4, 5}->includes(6)")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	public void test_includesAll() {
		helper.setContext(EcorePackage.Literals.EINT);

		try {
			assertTrue(check(helper, "", //$NON-NLS-1$
				"Sequence{1, 2, 3, 3, 4, 5}->includesAll(Sequence{1, 3})")); //$NON-NLS-1$

			assertFalse(check(helper, "", //$NON-NLS-1$
				"Sequence{1, 2, 3, 3, 4, 5}->includesAll(Sequence{1, 6})")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"Set{1, 2, 3, 3, 4, 5}->includesAll(Set{1, 3})")); //$NON-NLS-1$

			assertFalse(check(helper, "", //$NON-NLS-1$
				"Set{1, 2, 3, 3, 4, 5}->includesAll(Set{1, 6})")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"OrderedSet{1, 2, 3, 3, 4, 5}->includesAll(OrderedSet{1, 3})")); //$NON-NLS-1$

			assertFalse(check(helper, "", //$NON-NLS-1$
				"OrderedSet{1, 2, 3, 3, 4, 5}->includesAll(OrderedSet{1, 6})")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"Bag{1, 2, 3, 3, 4, 5}->includesAll(Bag{1, 3})")); //$NON-NLS-1$

			assertFalse(check(helper, "", //$NON-NLS-1$
				"Bag{1, 2, 3, 3, 4, 5}->includesAll(Bag{1, 6})")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	public void test_union() {
		helper.setContext(EcorePackage.Literals.EINT);

		try {
			assertTrue(check(helper, "", //$NON-NLS-1$
				"Set{1, 2, 3}->union(Set{3, 4, 5})" + //$NON-NLS-1$
					" = Set{1, 2, 3, 4, 5}")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"OrderedSet{1, 2, 3}->union(Set{3, 4, 5})" + //$NON-NLS-1$
					" = Set{1, 2, 3, 4, 5}")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"Bag{1, 2, 2, 3}->union(Set{3, 4, 5})" + //$NON-NLS-1$
					" = Bag{1, 2, 2, 3, 3, 4, 5}")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"Bag{1, 2, 3}->union(Bag{3, 3, 4, 5})" + //$NON-NLS-1$
					" = Bag{1, 2, 3, 3, 3, 4, 5}")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	public void test_intersection() {
		helper.setContext(EcorePackage.Literals.EINT);

		try {
			assertTrue(check(helper, "", //$NON-NLS-1$
				"Set{1, 2, 3}->intersection(Set{3, 4, 5})" + //$NON-NLS-1$
					" = Set{3}")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"OrderedSet{1, 2, 3}->intersection(Set{3, 4, 5})" + //$NON-NLS-1$
					" = Set{3}")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"Bag{1, 2, 2, 3, 3, 3}->intersection(Bag{3, 3, 4, 5})" + //$NON-NLS-1$
					" = Bag{3, 3}")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"Bag{1, 2, 2, 3, 3, 3}->intersection(Set{3, 4, 5})" + //$NON-NLS-1$
					" = Set{3}")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	public void test_difference() {
		helper.setContext(EcorePackage.Literals.EINT);

		try {
			assertTrue(check(helper, "", //$NON-NLS-1$
				"Set{1, 2, 3} - Set{3, 4, 5}" + //$NON-NLS-1$
					" = Set{1, 2}")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"OrderedSet{1, 2, 3} - Set{3, 4, 5}" + //$NON-NLS-1$
					" = Set{1, 2}")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	public void test_symmetricDifference() {
		helper.setContext(EcorePackage.Literals.EINT);

		try {
			assertTrue(check(helper, "", //$NON-NLS-1$
				"Set{1, 2, 3}->symmetricDifference(Set{3, 4, 5})" + //$NON-NLS-1$
					" = Set{1, 2, 4, 5}")); //$NON-NLS-1$

			assertTrue(check(helper, "", //$NON-NLS-1$
				"OrderedSet{1, 2, 3}->symmetricDifference(Set{3, 4, 5})" + //$NON-NLS-1$
					" = Set{1, 2, 4, 5}")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Tests that dot notation can be used successively to navigate multiple
	 * collection-type references.
	 */
	public void test_dotNavigationOfReferenceCollections_130239() {
		helper.setContext(EcorePackage.Literals.EPACKAGE);

		try {
			OCLExpression<EClassifier> expr = helper
				.createQuery("self.eClassifiers->union(self.eSubpackages.eClassifiers->asSet())->asSet()"); //$NON-NLS-1$

			assertEquals(new java.util.HashSet<EClassifier>(
				ExpressionsPackage.eINSTANCE.getEClassifiers()), ocl.evaluate(
				ExpressionsPackage.eINSTANCE, expr));
		} catch (Exception exc) {
			fail("Failed to parse or evaluate: " + exc.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Tests that dot notation can be used successively to navigate multiple
	 * collection-type operations.
	 */
	public void test_dotNavigationOfOperationCollections_130239() {
		EPackage fakePkg = EcoreFactory.eINSTANCE.createEPackage();
		fakePkg.setName("fake"); //$NON-NLS-1$
		EClass fake = EcoreFactory.eINSTANCE.createEClass();
		fake.setName("Fake"); //$NON-NLS-1$
		fakePkg.getEClassifiers().add(fake);
		EOperation getFakes = EcoreFactory.eINSTANCE.createEOperation();
		getFakes.setName("getFakes"); //$NON-NLS-1$
		getFakes.setEType(fake);
		getFakes.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
		fake.getEOperations().add(getFakes);

		helper.setContext(fake);

		try {
			helper
				.createQuery("self.getFakes()->union(self.getFakes().getFakes()->asSet())"); //$NON-NLS-1$
		} catch (Exception exc) {
			fail("Failed to parse or evaluate: " + exc.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Tests that the syntax for collection ranges is supported.
	 */
	public void test_collectionRange_152208() {
		helper.setContext(EcorePackage.Literals.EINT);

		try {
			Collection<?> result = (Collection<?>) evaluate(helper,
				new Integer(1), "Sequence{1 .. 10}"); //$NON-NLS-1$

			for (int i = 1; i <= 10; i++) {
				assertTrue(result.contains(new Integer(i)));
			}

			result = (Collection<?>) evaluate(helper, new Integer(1),
				"Sequence{1, (2+1)..(3+4), 10}"); //$NON-NLS-1$

			assertTrue(result.contains(new Integer(1)));
			for (int i = 3; i <= 7; i++) {
				assertTrue(result.contains(new Integer(i)));
			}
			assertTrue(result.contains(new Integer(10)));

			// try the first expression without spaces (needed a grammar change)
			result = (Collection<?>) evaluate(helper, new Integer(1),
				"Sequence{1..10}"); //$NON-NLS-1$

			for (int i = 1; i <= 10; i++) {
				assertTrue(result.contains(new Integer(i)));
			}

			// and a negation, too (the same grammar change)
			result = (Collection<?>) evaluate(helper, new Integer(1),
				"Sequence{-20, -10..-1, 1}"); //$NON-NLS-1$

			assertTrue(result.contains(new Integer(-20)));
			for (int i = -10; i <= -1; i++) {
				assertTrue(result.contains(new Integer(i)));
			}
			assertTrue(result.contains(new Integer(1)));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Tests the support for tuples whose parts are collections that are not
	 * collection literals.
	 */
	public void test_tupleWithCollectionPart_175490() {
		helper.setContext(EcorePackage.Literals.EPACKAGE);

		try {
			OCLExpression<EClassifier> expr = helper
				.createQuery("Tuple{a = self.eClassifiers}"); //$NON-NLS-1$

			assertTrue(expr.getType() instanceof TupleType);
			TupleType tt = (TupleType) expr.getType();

			assertEquals(1, tt.getEStructuralFeatures().size());
			EStructuralFeature part = tt.getEStructuralFeature("a"); //$NON-NLS-1$

			assertNotNull(part);
			assertTrue(part.getEType() instanceof CollectionType);

			@SuppressWarnings("unchecked")
			CollectionType<EClassifier, EOperation> collType = (CollectionType<EClassifier, EOperation>) part
				.getEType();
			assertSame(EcorePackage.Literals.ECLASSIFIER, collType
				.getElementType());

			Object result = ocl.evaluate(EcorePackage.eINSTANCE, expr);
			assertTrue(result instanceof Tuple);

			@SuppressWarnings("unchecked")
			Tuple<EOperation, EStructuralFeature> tuple = (Tuple<EOperation, EStructuralFeature>) result;

			assertTrue(tuple.getValue("a") instanceof Collection); //$NON-NLS-1$
			assertTrue(((Collection<?>) tuple.getValue("a")).contains(EcorePackage.Literals.ECLASSIFIER)); //$NON-NLS-1$
		} catch (Exception exc) {
			fail("Failed to parse or evaluate: " + exc.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Tests the support for tuples whose parts are collections that are
	 * collection literals.
	 */
	public void test_tupleWithCollectionLiteralPart_175490() {
		helper.setContext(EcorePackage.Literals.EPACKAGE);

		try {
			OCLExpression<EClassifier> expr = helper
				.createQuery("Tuple{a = Sequence{'a', 'b', 'c'}}"); //$NON-NLS-1$

			assertTrue(expr.getType() instanceof TupleType);
			TupleType tt = (TupleType) expr.getType();

			assertEquals(1, tt.getEStructuralFeatures().size());
			EStructuralFeature part = tt.getEStructuralFeature("a"); //$NON-NLS-1$

			assertNotNull(part);
			assertTrue(part.getEType() instanceof CollectionType);

			@SuppressWarnings("unchecked")
			CollectionType<EClassifier, EOperation> collType = (CollectionType<EClassifier, EOperation>) part
				.getEType();
			assertSame(getOCLStandardLibrary().getString(), collType
				.getElementType());

			Object result = ocl.evaluate(EcorePackage.eINSTANCE, expr);
			assertTrue(result instanceof Tuple);

			@SuppressWarnings("unchecked")
			Tuple<EOperation, EStructuralFeature> tuple = (Tuple<EOperation, EStructuralFeature>) result;

			assertTrue(tuple.getValue("a") instanceof Collection); //$NON-NLS-1$
			assertTrue(((Collection<?>) tuple.getValue("a")).contains("b")); //$NON-NLS-1$ //$NON-NLS-2$
		} catch (Exception exc) {
			fail("Failed to parse or evaluate: " + exc.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Tests that passing OclInvalid to a collection operation results in
	 * OclInvalid, not a ClassCastException.
	 */
	public void test_passOclInvalidToCollectionOperation_183144() {
		helper.setContext(EcorePackage.Literals.EPACKAGE);

		Variable<EClassifier, EParameter> var = ExpressionsFactory.eINSTANCE
			.createVariable();
		var.setName("var"); //$NON-NLS-1$
		var.setType(TypeUtil.resolveSetType(ocl.getEnvironment(),
			getOCLStandardLibrary().getString()));

		ocl.getEnvironment().addElement(var.getName(), var, true);

		try {
			OCLExpression<EClassifier> expr = helper
				.createQuery("Set{'a', 'b', 'c'}->union(var)"); //$NON-NLS-1$

			ocl.getEvaluationEnvironment().add("var", getInvalid()); //$NON-NLS-1$
			Object result = ocl.evaluate(EcorePackage.eINSTANCE, expr);
			assertInvalid(result);
		} catch (Exception exc) {
			fail("Failed to parse or evaluate: " + exc.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Tests that passing null to a collection operation (for which null is not
	 * appropriate) results in OclInvalid, not a NullPointerException. For
	 * example, <code>includes(null)</code> is OK but <code>union(null)</code>
	 * is not.
	 */
	public void test_passNullToCollectionOperation_183144() {
		helper.setContext(EcorePackage.Literals.EPACKAGE);

		Variable<EClassifier, EParameter> var = ExpressionsFactory.eINSTANCE
			.createVariable();
		var.setName("var"); //$NON-NLS-1$
		var.setType(TypeUtil.resolveSetType(ocl.getEnvironment(),
			getOCLStandardLibrary().getString()));

		ocl.getEnvironment().addElement(var.getName(), var, true);

		try {
			OCLExpression<EClassifier> expr = helper
				.createQuery("Set{'a', 'b', 'c'}->union(var)"); //$NON-NLS-1$

			ocl.getEvaluationEnvironment().add("var", null); //$NON-NLS-1$
			Object result = ocl.evaluate(EcorePackage.eINSTANCE, expr);
			assertInvalid(result);

			expr = helper.createQuery("Set{'a', 'b', 'c'}->includes(null)"); //$NON-NLS-1$
			result = ocl.evaluate(EcorePackage.eINSTANCE, expr);
			assertEquals(Boolean.FALSE, result);
		} catch (Exception exc) {
			fail("Failed to parse or evaluate: " + exc.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Tests that the OCL Standard Library defines the correct signature for the
	 * <code>Sequence::&lt;&gt;(Sequence(T))</code> operation.
	 */
	public void test_sequenceNotEqualSignature_184327() {
		helper.setContext(EcorePackage.Literals.ESTRING);

		try {
			assertTrue(check(helper, "", //$NON-NLS-1$
				"Sequence{1, 2, 3} <> Sequence{3, 2, 1}")); //$NON-NLS-1$

			assertFalse(check(helper, "", //$NON-NLS-1$
				"Sequence{1, 2, 3} <> Sequence{1, 2, 3}")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Tests that evaluating an EEList-typed operation call does not result in a
	 * scalar value.
	 */
	public void test_valueOfOperationTypedByEEList_202611() {
		helper.setContext(EcorePackage.Literals.EPACKAGE);

		try {
			OCLExpression<EClassifier> expr = helper
				.createQuery("self.eContents()"); //$NON-NLS-1$
			assertTrue(expr.getType() instanceof CollectionType);

			CollectionType<?, ?> actualType = (CollectionType<?, ?>) expr
				.getType();

			// should be a Sequence(OclAny)
			assertSame(CollectionKind.SEQUENCE_LITERAL, actualType.getKind());
			// assertSame(getOCLStandardLibrary().getOclAny(),
			// actualType.getElementType());

			// should be the right value
			Object value = ocl.evaluate(EcorePackage.eINSTANCE, expr);
			assertEquals(EcorePackage.eINSTANCE.eContents(), value);
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Tests that generic collection types (those whose element type is
	 * <tt>T</tt>) resolve correctly to the OCL Standard Library types.
	 */
	public void test_resolutionOfGenericCollectionTypes_222581() {
		TypeResolver<EClassifier, EOperation, EStructuralFeature> resolver = ocl
			.getEnvironment().getTypeResolver();
		Resource resource = resolver.getResource();

		OCLStandardLibrary<EClassifier> stdlib = ocl.getEnvironment()
			.getOCLStandardLibrary();
		EClassifier t = stdlib.getT();

		CollectionType<EClassifier, EOperation> collectionType;

		collectionType = resolver.resolveCollectionType(
			CollectionKind.SET_LITERAL, t);
		assertNotSame(resource, collectionType.eResource());
		assertSame(stdlib.getSet(), collectionType);

		collectionType = resolver.resolveCollectionType(
			CollectionKind.ORDERED_SET_LITERAL, t);
		assertNotSame(resource, collectionType.eResource());
		assertSame(stdlib.getOrderedSet(), collectionType);

		collectionType = resolver.resolveCollectionType(
			CollectionKind.SEQUENCE_LITERAL, t);
		assertNotSame(resource, collectionType.eResource());
		assertSame(stdlib.getSequence(), collectionType);

		collectionType = resolver.resolveCollectionType(
			CollectionKind.BAG_LITERAL, t);
		assertNotSame(resource, collectionType.eResource());
		assertSame(stdlib.getBag(), collectionType);

		collectionType = resolver.resolveCollectionType(
			CollectionKind.COLLECTION_LITERAL, t);
		assertNotSame(resource, collectionType.eResource());
		assertSame(stdlib.getCollection(), collectionType);
	}

	/**
	 * Tests that an invalid "at" index results in OclInvalid, not null.
	 */
	public void test_invalidAtIndex_orderedSet_244946() {
		helper.setContext(EcorePackage.Literals.ESTRING);

		try {
			assertInvalid(evaluate(helper, "", //$NON-NLS-1$
				"OrderedSet{1, 2, 3}->at(0)")); //$NON-NLS-1$

			assertInvalid(evaluate(helper, "", //$NON-NLS-1$
				"OrderedSet{1, 2, 3}->at(4)")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Tests that an invalid "at" index results in OclInvalid, not null.
	 */
	public void test_invalidAtIndex_sequence_244946() {
		helper.setContext(EcorePackage.Literals.ESTRING);

		try {
			assertInvalid(evaluate(helper, "", //$NON-NLS-1$
				"Sequence{1, 2, 3}->at(0)")); //$NON-NLS-1$

			assertInvalid(evaluate(helper, "", //$NON-NLS-1$
				"Sequence{1, 2, 3}->at(4)")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Tests that an invalid "insertAt" index results in OclInvalid, not null.
	 */
	public void test_invalidInsertAtIndex_orderedSet_244946() {
		helper.setContext(EcorePackage.Literals.ESTRING);

		try {
			// this is OK, as it effectively appends
			assertTrue(check(helper, "", //$NON-NLS-1$
				"OrderedSet{1, 2, 3}->insertAt(4, 4) = OrderedSet{1, 2, 3, 4}")); //$NON-NLS-1$
			// and this prepends
			assertTrue(check(helper, "", //$NON-NLS-1$
				"OrderedSet{1, 2, 3}->insertAt(1, 0) = OrderedSet{0, 1, 2, 3}")); //$NON-NLS-1$

			// this is not
			assertInvalid(evaluate(helper, "", //$NON-NLS-1$
				"OrderedSet{1, 2, 3}->insertAt(5, 5)")); //$NON-NLS-1$
			assertInvalid(evaluate(helper, "", //$NON-NLS-1$
				"OrderedSet{1, 2, 3}->insertAt(0, 0)")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Tests that an invalid "insertAt" index results in OclInvalid, not null.
	 */
	public void test_invalidInsertAtIndex_sequence_244946() {
		helper.setContext(EcorePackage.Literals.ESTRING);

		try {
			// this is OK, as it effectively appends
			assertTrue(check(helper, "", //$NON-NLS-1$
				"Sequence{1, 2, 3}->insertAt(4, 4) = Sequence{1, 2, 3, 4}")); //$NON-NLS-1$
			// and this prepends
			assertTrue(check(helper, "", //$NON-NLS-1$
				"Sequence{1, 2, 3}->insertAt(1, 0) = Sequence{0, 1, 2, 3}")); //$NON-NLS-1$

			// this is not
			assertInvalid(evaluate(helper, "", //$NON-NLS-1$
				"Sequence{1, 2, 3}->insertAt(5, 5)")); //$NON-NLS-1$
			assertInvalid(evaluate(helper, "", //$NON-NLS-1$
				"Sequence{1, 2, 3}->insertAt(0, 0)")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Tests that an invalid "subOrderedSet" range results in OclInvalid, not
	 * null.
	 */
	public void test_invalidSubOrderedSetRange_244946() {
		helper.setContext(EcorePackage.Literals.ESTRING);

		try {
			assertInvalid(evaluate(helper, "", //$NON-NLS-1$
				"OrderedSet{1, 2, 3}->subOrderedSet(0, 2)")); //$NON-NLS-1$

			assertInvalid(evaluate(helper, "", //$NON-NLS-1$
				"OrderedSet{1, 2, 3}->subOrderedSet(2, 4)")); //$NON-NLS-1$

			assertInvalid(evaluate(helper, "", //$NON-NLS-1$
				"OrderedSet{1, 2, 3}->subOrderedSet(2, 1)")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Tests that an invalid "subSequence" range results in OclInvalid, not
	 * null.
	 */
	public void test_invalidSubSequenceRange_244946() {
		helper.setContext(EcorePackage.Literals.ESTRING);

		try {
			assertInvalid(evaluate(helper, "", //$NON-NLS-1$
				"Sequence{1, 2, 3}->subSequence(0, 2)")); //$NON-NLS-1$

			assertInvalid(evaluate(helper, "", //$NON-NLS-1$
				"Sequence{1, 2, 3}->subSequence(2, 4)")); //$NON-NLS-1$

			assertInvalid(evaluate(helper, "", //$NON-NLS-1$
				"Sequence{1, 2, 3}->subSequence(2, 1)")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Test to check the collections which are declared as OclAny type.
	 */
	public void test_oclAnyCollections_260403() {

		try {
			assertTrue(check("let aSeq : Sequence(OclAny) = Sequence {'aString'} in" + //$NON-NLS-1$
				" aSeq->including(10) = Sequence {'aString',10}")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
}
