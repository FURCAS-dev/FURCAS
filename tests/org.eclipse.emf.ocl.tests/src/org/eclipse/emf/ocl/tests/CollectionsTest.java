/**
 * <copyright>
 *
 * Copyright (c) 2006 IBM Corporation and others.
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
 * $Id: CollectionsTest.java,v 1.6 2006/10/10 14:29:19 cdamus Exp $
 */

package org.eclipse.emf.ocl.tests;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ocl.expressions.ExpressionsPackage;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.helper.HelperUtil;
import org.eclipse.emf.ocl.helper.IOCLHelper;

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
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.ESTRING);
		
		try {
			OCLExpression expr = helper.createQuery(
					"Sequence{'a', 'b', 'd', 'e'}->insertAt(3, 'c')"); //$NON-NLS-1$

			List result = (List) helper.evaluate("", expr); //$NON-NLS-1$
			
			List expected = Arrays.asList(new Object[] {"a", "b", "c", "d", "e"}); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
			
			assertEquals(expected, result);
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the insertAt() operation for ordered sets.
	 */
	public void test_insertAt_orderedSet_126722() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.ESTRING);
		
		try {
			OCLExpression expr = helper.createQuery(
					"OrderedSet{'a', 'b', 'd', 'e'}->insertAt(3, 'c')"); //$NON-NLS-1$

			Set result = (Set) helper.evaluate("", expr); //$NON-NLS-1$
			
			List expected = Arrays.asList(new Object[] {"a", "b", "c", "d", "e"}); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
			
			assertEquals(expected, new java.util.ArrayList(result));
			
			// no duplicates; result is exactly equivalent (order preserved)
			
			expr = helper.createQuery(
				"OrderedSet{'a', 'b', 'c', 'd', 'e'}->insertAt(5, 'c')"); //$NON-NLS-1$

			result = (Set) helper.evaluate("", expr); //$NON-NLS-1$
			
			expected = Arrays.asList(new Object[] {"a", "b", "c", "d", "e"}); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
			
			assertEquals(expected, new java.util.ArrayList(result));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the prepend() operation for sequences.
	 */
	public void test_prepend_sequence_126722() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.ESTRING);
		
		try {
			OCLExpression expr = helper.createQuery(
					"Sequence{'a', 'b', 'd', 'e'}->prepend('c')"); //$NON-NLS-1$

			List result = (List) helper.evaluate("", expr); //$NON-NLS-1$
			
			List expected = Arrays.asList(new Object[] {"c", "a", "b", "d", "e"}); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
			
			assertEquals(expected, result);
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the prepend() operation for ordered sets.
	 */
	public void test_prepend_orderedSet_126722() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.ESTRING);
		
		try {
			OCLExpression expr = helper.createQuery(
					"OrderedSet{'a', 'b', 'd', 'e'}->prepend('c')"); //$NON-NLS-1$

			Set result = (Set) helper.evaluate("", expr); //$NON-NLS-1$
			
			List expected = Arrays.asList(new Object[] {"c", "a", "b", "d", "e"}); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
			
			assertEquals(expected, new java.util.ArrayList(result));
			
			// no duplicates; result has prepended element first
			
			expr = helper.createQuery(
				"OrderedSet{'a', 'b', 'c', 'd', 'e'}->prepend('c')"); //$NON-NLS-1$

			result = (Set) helper.evaluate("", expr); //$NON-NLS-1$
			
			expected = Arrays.asList(new Object[] {"c", "a", "b", "d", "e"}); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
			
			assertEquals(expected, new java.util.ArrayList(result));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the append() operation for sequences.
	 */
	public void test_append_sequence_126722() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.ESTRING);
		
		try {
			OCLExpression expr = helper.createQuery(
					"Sequence{'a', 'b', 'd', 'e'}->append('c')"); //$NON-NLS-1$

			List result = (List) helper.evaluate("", expr); //$NON-NLS-1$
			
			List expected = Arrays.asList(new Object[] {"a", "b", "d", "e", "c"}); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
			
			assertEquals(expected, result);
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the append() operation for ordered sets.
	 */
	public void test_append_orderedSet_126722() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.ESTRING);
		
		try {
			OCLExpression expr = helper.createQuery(
					"OrderedSet{'a', 'b', 'd', 'e'}->append('c')"); //$NON-NLS-1$

			Set result = (Set) helper.evaluate("", expr); //$NON-NLS-1$
			
			List expected = Arrays.asList(new Object[] {"a", "b", "d", "e", "c"}); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
			
			assertEquals(expected, new java.util.ArrayList(result));
			
			// no duplicates; appended element is at end
			
			expr = helper.createQuery(
				"OrderedSet{'a', 'b', 'c', 'd', 'e'}->append('c')"); //$NON-NLS-1$

			result = (Set) helper.evaluate("", expr); //$NON-NLS-1$
			
			expected = Arrays.asList(new Object[] {"a", "b", "d", "e", "c"}); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
			
			assertEquals(expected, new java.util.ArrayList(result));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the including() operation for sequences.
	 */
	public void test_including_sequence_126722() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.ESTRING);
		
		try {
			OCLExpression expr = helper.createQuery(
					"Sequence{'a', 'b', 'd', 'e'}->including('c')"); //$NON-NLS-1$

			List result = (List) helper.evaluate("", expr); //$NON-NLS-1$
			
			List expected = Arrays.asList(new Object[] {"a", "b", "d", "e", "c"}); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
			
			assertEquals(expected, result);
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the including() operation for ordered sets.
	 */
	public void test_including_orderedSet_126722() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.ESTRING);
		
		try {
			OCLExpression expr = helper.createQuery(
					"OrderedSet{'a', 'b', 'd', 'e'}->including('c')"); //$NON-NLS-1$

			Set result = (Set) helper.evaluate("", expr); //$NON-NLS-1$
			
			Set expected = new java.util.HashSet(
					Arrays.asList(new Object[] {"a", "b", "d", "e", "c"})); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
			
			assertEquals(expected, result);
			
			// no duplicates
			
			expr = helper.createQuery(
				"OrderedSet{'a', 'b', 'c', 'd', 'e'}->including('c')"); //$NON-NLS-1$

			result = (Set) helper.evaluate("", expr); //$NON-NLS-1$
			
			expected = new java.util.HashSet(
					Arrays.asList(new Object[] {"a", "b", "c", "d", "e"})); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
			
			assertEquals(expected, result);
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the excluding() operation for sequences.
	 */
	public void test_excluding_sequence_126722() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.ESTRING);
		
		try {
			OCLExpression expr = helper.createQuery(
					"Sequence{'a', 'b', 'c', 'd', 'e'}->excluding('c')"); //$NON-NLS-1$

			List result = (List) helper.evaluate("", expr); //$NON-NLS-1$
			
			List expected = Arrays.asList(new Object[] {"a", "b", "d", "e"}); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
			
			assertEquals(expected, result);
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the excluding() operation for ordered sets.
	 */
	public void test_excluding_orderedSet_126722() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.ESTRING);
		
		try {
			OCLExpression expr = helper.createQuery(
					"OrderedSet{'a', 'b', 'c', 'd', 'e'}->excluding('c')"); //$NON-NLS-1$

			Set result = (Set) helper.evaluate("", expr); //$NON-NLS-1$
			
			Set expected = new java.util.HashSet(
					Arrays.asList(new Object[] {"a", "b", "d", "e"})); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
			
			assertEquals(expected, result);
			
			// just for fun, try excluding an already excluded element
			
			expr = helper.createQuery(
				"OrderedSet{'a', 'b', 'd', 'e'}->excluding('c')"); //$NON-NLS-1$

			result = (Set) helper.evaluate("", expr); //$NON-NLS-1$
			
			expected = new java.util.HashSet(
					Arrays.asList(new Object[] {"a", "b", "d", "e"})); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
			
			assertEquals(expected, result);
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_first() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.ESTRING);
		
		try {
			assertTrue(helper.check("", //$NON-NLS-1$
					"Sequence{'a', 'b', 'c', 'd', 'e'}->first() = 'a'")); //$NON-NLS-1$

			assertTrue(helper.check("", //$NON-NLS-1$
					"OrderedSet{'a', 'b', 'c', 'd', 'e'}->first() = 'a'")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_last() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.ESTRING);
		
		try {
			assertTrue(helper.check("", //$NON-NLS-1$
					"Sequence{'a', 'b', 'c', 'd', 'e'}->last() = 'e'")); //$NON-NLS-1$

			assertTrue(helper.check("", //$NON-NLS-1$
					"OrderedSet{'a', 'b', 'c', 'd', 'e'}->last() = 'e'")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_at() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.ESTRING);
		
		try {
			assertTrue(helper.check("", //$NON-NLS-1$
					"Sequence{'a', 'b', 'c', 'd', 'e'}->at(3) = 'c'")); //$NON-NLS-1$

			assertTrue(helper.check("", //$NON-NLS-1$
					"OrderedSet{'a', 'b', 'c', 'd', 'e'}->at(3)= 'c'")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_indexOf() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.ESTRING);
		
		try {
			assertTrue(helper.check("", //$NON-NLS-1$
					"Sequence{'a', 'b', 'c', 'd', 'e'}->indexOf('c') = 3")); //$NON-NLS-1$

			assertTrue(helper.check("", //$NON-NLS-1$
					"OrderedSet{'a', 'b', 'c', 'd', 'e'}->indexOf('c')= 3")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_subsequence_suborderedset() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.ESTRING);
		
		try {
			assertTrue(helper.check("", //$NON-NLS-1$
					"Sequence{'a', 'b', 'c', 'd', 'e'}->subSequence(2, 4)" + //$NON-NLS-1$
					" = Sequence{'b', 'c', 'd'}")); //$NON-NLS-1$

			assertTrue(helper.check("", //$NON-NLS-1$
					"OrderedSet{'a', 'b', 'c', 'd', 'e'}->subOrderedSet(2, 4)" + //$NON-NLS-1$
					" = OrderedSet{'b', 'c', 'd'}")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Test the flatten() operation.  In particular, that it is not
	 * recursive (only flattens one level).
	 */
	public void test_flatten() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.ESTRING);
		
		try {
			assertTrue(helper.check("", //$NON-NLS-1$
					"Set{Sequence{'a', 'b'}, Sequence{'b', 'c', 'd'}}->flatten()" + //$NON-NLS-1$
					" = Set{'b', 'c', 'a', 'd'}")); //$NON-NLS-1$

			assertTrue(helper.check("", //$NON-NLS-1$
					"OrderedSet{Sequence{'a', 'b'}, Sequence{'b', 'c', 'd'}}->flatten()" + //$NON-NLS-1$
					" = Set{'b', 'c', 'a', 'd'}")); //$NON-NLS-1$

			assertTrue(helper.check("", //$NON-NLS-1$
					"Sequence{OrderedSet{'a', 'b', 'd'}, OrderedSet{'b', 'c', 'd'}}->flatten()" + //$NON-NLS-1$
					" = Sequence{'a', 'b', 'd', 'b', 'c', 'd'}")); //$NON-NLS-1$

			assertTrue(helper.check("", //$NON-NLS-1$
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
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.ESTRING);
		
		try {
			assertTrue(helper.check("", //$NON-NLS-1$
					"Set{'a', 'b', 'c', 'd'}->flatten()" + //$NON-NLS-1$
					" = Set{'b', 'c', 'a', 'd'}")); //$NON-NLS-1$

			assertTrue(helper.check("", //$NON-NLS-1$
					"OrderedSet{'a', 'b', 'b', 'c', 'd'}->flatten()" + //$NON-NLS-1$
					" = Set{'b', 'c', 'a', 'd'}")); //$NON-NLS-1$

			assertTrue(helper.check("", //$NON-NLS-1$
					"Sequence{'a', 'b', 'd', 'b', 'c', 'd'}->flatten()" + //$NON-NLS-1$
					" = Sequence{'a', 'b', 'd', 'b', 'c', 'd'}")); //$NON-NLS-1$

			assertTrue(helper.check("", //$NON-NLS-1$
					"Bag{'b', 'a', 'b', 'b', 'a', 'c', 'd'}->flatten()" + //$NON-NLS-1$
					" = Bag{'a', 'a', 'b', 'b', 'b', 'c', 'd'}")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_count() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.EINT);
		
		try {
			assertTrue(helper.check("", //$NON-NLS-1$
					"Sequence{1, 2, 3, 3, 4, 5}->count(3) = 2")); //$NON-NLS-1$

			assertTrue(helper.check("", //$NON-NLS-1$
					"Sequence{1, 2, 3, 3, 4, 5}->count(6) = 0")); //$NON-NLS-1$

			assertTrue(helper.check("", //$NON-NLS-1$
					"OrderedSet{1, 2, 3, 3, 4, 5}->count(3) = 1")); //$NON-NLS-1$

			assertTrue(helper.check("", //$NON-NLS-1$
					"OrderedSet{1, 2, 3, 3, 4, 5}->count(6) = 0")); //$NON-NLS-1$

			assertTrue(helper.check("", //$NON-NLS-1$
					"Set{1, 2, 3, 3, 4, 5}->count(3) = 1")); //$NON-NLS-1$

			assertTrue(helper.check("", //$NON-NLS-1$
					"Set{1, 2, 3, 3, 4, 5}->count(6) = 0")); //$NON-NLS-1$

			assertTrue(helper.check("", //$NON-NLS-1$
					"Bag{1, 2, 3, 3, 4, 5}->count(3) = 2")); //$NON-NLS-1$
			
			assertTrue(helper.check("", //$NON-NLS-1$
					"Bag{1, 2, 3, 3, 4, 5}->count(6) = 0")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_sum() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.EINT);
		
		try {
			assertTrue(helper.check("", //$NON-NLS-1$
					"Sequence{1, 2, 3, 3, 4, 5}->sum() = 18")); //$NON-NLS-1$

			assertTrue(helper.check("", //$NON-NLS-1$
					"OrderedSet{1, 2, 3, 3, 4, 5}->sum() = 15")); //$NON-NLS-1$

			assertTrue(helper.check("", //$NON-NLS-1$
					"Set{1, 2, 3, 3, 4, 5}->sum() = 15")); //$NON-NLS-1$

			assertTrue(helper.check("", //$NON-NLS-1$
					"Bag{1, 2, 3, 3, 4, 5}->sum() = 18")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_includes() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.EINT);
		
		try {
			assertTrue(helper.check("", //$NON-NLS-1$
					"Sequence{1, 2, 3, 3, 4, 5}->includes(3)")); //$NON-NLS-1$

			assertFalse(helper.check("", //$NON-NLS-1$
					"Sequence{1, 2, 3, 3, 4, 5}->includes(6)")); //$NON-NLS-1$

			assertTrue(helper.check("", //$NON-NLS-1$
					"Set{1, 2, 3, 3, 4, 5}->includes(3)")); //$NON-NLS-1$

			assertFalse(helper.check("", //$NON-NLS-1$
					"Set{1, 2, 3, 3, 4, 5}->includes(6)")); //$NON-NLS-1$

			assertTrue(helper.check("", //$NON-NLS-1$
					"OrderedSet{1, 2, 3, 3, 4, 5}->includes(3)")); //$NON-NLS-1$

			assertFalse(helper.check("", //$NON-NLS-1$
					"OrderedSet{1, 2, 3, 3, 4, 5}->includes(6)")); //$NON-NLS-1$

			assertTrue(helper.check("", //$NON-NLS-1$
					"Bag{1, 2, 3, 3, 4, 5}->includes(3)")); //$NON-NLS-1$

			assertFalse(helper.check("", //$NON-NLS-1$
					"Bag{1, 2, 3, 3, 4, 5}->includes(6)")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_includesAll() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.EINT);
		
		try {
			assertTrue(helper.check("", //$NON-NLS-1$
					"Sequence{1, 2, 3, 3, 4, 5}->includesAll(Sequence{1, 3})")); //$NON-NLS-1$

			assertFalse(helper.check("", //$NON-NLS-1$
					"Sequence{1, 2, 3, 3, 4, 5}->includesAll(Sequence{1, 6})")); //$NON-NLS-1$

			assertTrue(helper.check("", //$NON-NLS-1$
					"Set{1, 2, 3, 3, 4, 5}->includesAll(Set{1, 3})")); //$NON-NLS-1$

			assertFalse(helper.check("", //$NON-NLS-1$
					"Set{1, 2, 3, 3, 4, 5}->includesAll(Set{1, 6})")); //$NON-NLS-1$

			assertTrue(helper.check("", //$NON-NLS-1$
					"OrderedSet{1, 2, 3, 3, 4, 5}->includesAll(OrderedSet{1, 3})")); //$NON-NLS-1$

			assertFalse(helper.check("", //$NON-NLS-1$
					"OrderedSet{1, 2, 3, 3, 4, 5}->includesAll(OrderedSet{1, 6})")); //$NON-NLS-1$

			assertTrue(helper.check("", //$NON-NLS-1$
					"Bag{1, 2, 3, 3, 4, 5}->includesAll(Bag{1, 3})")); //$NON-NLS-1$

			assertFalse(helper.check("", //$NON-NLS-1$
					"Bag{1, 2, 3, 3, 4, 5}->includesAll(Bag{1, 6})")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_union() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.EINT);
		
		try {
			assertTrue(helper.check("", //$NON-NLS-1$
					"Set{1, 2, 3}->union(Set{3, 4, 5})" + //$NON-NLS-1$
					" = Set{1, 2, 3, 4, 5}")); //$NON-NLS-1$

			assertTrue(helper.check("", //$NON-NLS-1$
					"OrderedSet{1, 2, 3}->union(Set{3, 4, 5})" + //$NON-NLS-1$
					" = Set{1, 2, 3, 4, 5}")); //$NON-NLS-1$

			assertTrue(helper.check("", //$NON-NLS-1$
					"Bag{1, 2, 2, 3}->union(Set{3, 4, 5})" + //$NON-NLS-1$
					" = Bag{1, 2, 2, 3, 3, 4, 5}")); //$NON-NLS-1$

			assertTrue(helper.check("", //$NON-NLS-1$
					"Bag{1, 2, 3}->union(Bag{3, 3, 4, 5})" + //$NON-NLS-1$
					" = Bag{1, 2, 3, 3, 3, 4, 5}")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_intersection() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.EINT);
		
		try {
			assertTrue(helper.check("", //$NON-NLS-1$
					"Set{1, 2, 3}->intersection(Set{3, 4, 5})" + //$NON-NLS-1$
					" = Set{3}")); //$NON-NLS-1$

			assertTrue(helper.check("", //$NON-NLS-1$
					"OrderedSet{1, 2, 3}->intersection(Set{3, 4, 5})" + //$NON-NLS-1$
					" = Set{3}")); //$NON-NLS-1$

			assertTrue(helper.check("", //$NON-NLS-1$
					"Bag{1, 2, 2, 3, 3, 3}->intersection(Bag{3, 3, 4, 5})" + //$NON-NLS-1$
					" = Bag{3, 3}")); //$NON-NLS-1$

			assertTrue(helper.check("", //$NON-NLS-1$
					"Bag{1, 2, 2, 3, 3, 3}->intersection(Set{3, 4, 5})" + //$NON-NLS-1$
					" = Set{3}")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_difference() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.EINT);
		
		try {
			assertTrue(helper.check("", //$NON-NLS-1$
					"Set{1, 2, 3} - Set{3, 4, 5}" + //$NON-NLS-1$
					" = Set{1, 2}")); //$NON-NLS-1$

			assertTrue(helper.check("", //$NON-NLS-1$
					"OrderedSet{1, 2, 3} - Set{3, 4, 5}" + //$NON-NLS-1$
					" = Set{1, 2}")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_symmetricDifference() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.EINT);
		
		try {
			assertTrue(helper.check("", //$NON-NLS-1$
					"Set{1, 2, 3}->symmetricDifference(Set{3, 4, 5})" + //$NON-NLS-1$
					" = Set{1, 2, 4, 5}")); //$NON-NLS-1$

			assertTrue(helper.check("", //$NON-NLS-1$
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
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(ExpressionsPackage.eINSTANCE);
		
		try {
			OCLExpression expr = helper.createQuery(
					"self.eClassifiers->union(self.eSubpackages.eClassifiers->asSet())->asSet()"); //$NON-NLS-1$
			
			assertEquals(
					new java.util.HashSet(ExpressionsPackage.eINSTANCE.getEClassifiers()),
					helper.evaluate(ExpressionsPackage.eINSTANCE, expr));
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
		
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(fake);
		
		try {
			helper.createQuery(
					"self.getFakes()->union(self.getFakes().getFakes()->asSet())"); //$NON-NLS-1$
		} catch (Exception exc) {
			fail("Failed to parse or evaluate: " + exc.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests that the syntax for collection ranges is supported.
	 */
	public void test_collectionRange_152208() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.EINT);
		
		try {
			Collection result = (Collection) helper.evaluate(new Integer(1),
					"Sequence{1 .. 10}"); //$NON-NLS-1$

			for (int i = 1; i <= 10; i++) {
				assertTrue(result.contains(new Integer(i)));
			}
			
			result = (Collection) helper.evaluate(new Integer(1),
				"Sequence{1, (2+1)..(3+4), 10}"); //$NON-NLS-1$

			assertTrue(result.contains(new Integer(1)));
			for (int i = 3; i <= 7; i++) {
				assertTrue(result.contains(new Integer(i)));
			}
			assertTrue(result.contains(new Integer(10)));
			
			// try the first expression without spaces (needed a grammar change)
			result = (Collection) helper.evaluate(new Integer(1),
				"Sequence{1..10}"); //$NON-NLS-1$
		
			for (int i = 1; i <= 10; i++) {
				assertTrue(result.contains(new Integer(i)));
			}
			
			// and a negation, too (the same grammar change)
			result = (Collection) helper.evaluate(new Integer(1),
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
}
