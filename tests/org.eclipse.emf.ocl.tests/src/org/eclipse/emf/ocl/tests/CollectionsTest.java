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
 * $Id: CollectionsTest.java,v 1.1 2006/02/14 21:26:08 cdamus Exp $
 */

package org.eclipse.emf.ocl.tests;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EcorePackage;
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
		IOCLHelper helper = HelperUtil.createOclHelper();
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
		IOCLHelper helper = HelperUtil.createOclHelper();
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
		IOCLHelper helper = HelperUtil.createOclHelper();
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
		IOCLHelper helper = HelperUtil.createOclHelper();
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
		IOCLHelper helper = HelperUtil.createOclHelper();
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
		IOCLHelper helper = HelperUtil.createOclHelper();
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
		IOCLHelper helper = HelperUtil.createOclHelper();
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
		IOCLHelper helper = HelperUtil.createOclHelper();
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
		IOCLHelper helper = HelperUtil.createOclHelper();
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
		IOCLHelper helper = HelperUtil.createOclHelper();
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
}
