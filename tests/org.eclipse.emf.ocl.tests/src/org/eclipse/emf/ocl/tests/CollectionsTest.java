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
 * $Id: CollectionsTest.java,v 1.4 2006/03/03 15:33:30 cdamus Exp $
 */

package org.eclipse.emf.ocl.tests;

import java.util.Arrays;
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
	
	/**
	 * Tests the isUnique() iterator.
	 */
	public void test_isUnique_126861() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.ESTRING);
		
		try {
			assertTrue(helper.check("", //$NON-NLS-1$
				"Sequence{'a', 'b', 'c', 'd', 'e'}->isUnique(e | e)")); //$NON-NLS-1$

			assertFalse(helper.check("", //$NON-NLS-1$
				"Sequence{'a', 'b', 'c', 'c', 'e'}->isUnique(e | e)")); //$NON-NLS-1$

			// when there are no values, they implicitly all evaluate to a
			//    different result
			assertTrue(helper.check("", //$NON-NLS-1$
				"Sequence{}->isUnique(e | e)")); //$NON-NLS-1$
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
}
