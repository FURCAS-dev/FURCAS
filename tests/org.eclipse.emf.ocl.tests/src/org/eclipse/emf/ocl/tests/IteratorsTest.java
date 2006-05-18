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
 * $Id: IteratorsTest.java,v 1.2 2006/05/18 19:55:41 cdamus Exp $
 */

package org.eclipse.emf.ocl.tests;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
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
import org.eclipse.emf.ocl.helper.HelperUtil;
import org.eclipse.emf.ocl.helper.IOCLHelper;
import org.eclipse.emf.ocl.helper.OCLParsingException;
import org.eclipse.emf.ocl.types.util.Types;

/**
 * Tests for iterator expressions.
 *
 * @author Christian W. Damus (cdamus)
 */
public class IteratorsTest
	extends AbstractTestSuite {

	private EPackage pkg1;
	private EPackage pkg2;
	private EPackage pkg3;
	private EPackage pkg4;
	private EPackage pkg5;
	private EPackage jim;
	private EPackage bob;
	private EPackage george;
	
	public IteratorsTest(String name) {
		super(name);
	}
	
	public static Test suite() {
		return new TestSuite(IteratorsTest.class, "Iterator Tests"); //$NON-NLS-1$
	}
	
	/**
	 * Tests the select() iterator.
	 */
	public void test_select() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.EPACKAGE);
		
		try {
			Set expected = new java.util.LinkedHashSet();
			expected.add(pkg2);
			expected.add(pkg3);
			
			// complete form
			assertEquals(expected, helper.evaluate(pkg1,
				"eSubpackages->select(p : EPackage | p.name <> 'bob')")); //$NON-NLS-1$

			// shorter form
			assertEquals(expected, helper.evaluate(pkg1,
				"eSubpackages->select(p | p.name <> 'bob')")); //$NON-NLS-1$

			// shortest form
			assertEquals(expected, helper.evaluate(pkg1,
				"eSubpackages->select(name <> 'bob')")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the reject() iterator.
	 */
	public void test_reject() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.EPACKAGE);
		
		try {
			Set expected = new java.util.LinkedHashSet();
			expected.add(pkg2);
			expected.add(pkg3);
			
			// complete form
			assertEquals(expected, helper.evaluate(pkg1,
				"eSubpackages->reject(p : EPackage | p.name = 'bob')")); //$NON-NLS-1$

			// shorter form
			assertEquals(expected, helper.evaluate(pkg1,
				"eSubpackages->reject(p | p.name = 'bob')")); //$NON-NLS-1$

			// shortest form
			assertEquals(expected, helper.evaluate(pkg1,
				"eSubpackages->reject(name = 'bob')")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the any() iterator.
	 */
	public void test_any() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.EPACKAGE);
		
		try {
			// complete form
			assertSame(bob, helper.evaluate(pkg1,
				"eSubpackages->any(p : EPackage | p.name = 'bob')")); //$NON-NLS-1$

			// shorter form
			assertSame(bob, helper.evaluate(pkg1,
				"eSubpackages->any(p | p.name = 'bob')")); //$NON-NLS-1$

			// shortest form
			assertSame(bob, helper.evaluate(pkg1,
				"eSubpackages->any(name = 'bob')")); //$NON-NLS-1$
			
			// negative
			assertNotSame(bob, helper.evaluate(pkg1,
				"eSubpackages->any(name = 'pkg2')")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the isUnique() iterator.
	 */
	public void test_isUnique_126861() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.EPACKAGE);
		
		try {
			assertTrue(helper.check(pkg1,
				"Sequence{'a', 'b', 'c', 'd', 'e'}->isUnique(e | e)")); //$NON-NLS-1$

			assertFalse(helper.check(pkg1,
				"Sequence{'a', 'b', 'c', 'c', 'e'}->isUnique(e | e)")); //$NON-NLS-1$

			// when there are no values, they implicitly all evaluate to a
			//    different result
			assertTrue(helper.check(pkg1,
				"Sequence{}->isUnique(e | e)")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the exists() iterator.
	 */
	public void test_exists() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.EPACKAGE);
		
		try {
			assertTrue(helper.check(pkg1,
				"Sequence{'a', 'b', 'c', 'd', 'e'}->exists(e | e = 'c')")); //$NON-NLS-1$

			assertTrue(helper.check(pkg1,
				"Sequence{'a', 'b', 'c', 'c', 'e'}->exists(e | e = 'c')")); //$NON-NLS-1$

			assertFalse(helper.check(pkg1,
				"Sequence{'a', 'b', 'd', 'e'}->exists(e | e = 'c')")); //$NON-NLS-1$

			// when there are no values, they the desired result implictly
			//    does not occur
			assertFalse(helper.check(pkg1,
				"Sequence{}->exists(e | e = 'c')")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the forAll() iterator.
	 */
	public void test_forAll() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.EPACKAGE);
		
		try {
			assertFalse(helper.check(pkg1,
				"Sequence{'a', 'b', 'c', 'd', 'e'}->forAll(e | e = 'c')")); //$NON-NLS-1$

			assertFalse(helper.check(pkg1,
				"Sequence{'a', 'b', 'd', 'e'}->forAll(e | e = 'c')")); //$NON-NLS-1$

			assertTrue(helper.check(pkg1,
				"Sequence{'c', 'c', 'c', 'c'}->forAll(e | e = 'c')")); //$NON-NLS-1$

			assertTrue(helper.check(pkg1,
				"Sequence{'c'}->forAll(e | e = 'c')")); //$NON-NLS-1$

			// when there are no values, they implicitly all evaluate to the
			//    desired result
			assertTrue(helper.check(pkg1,
				"Sequence{}->forAll(e | e = 'c')")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the one() iterator.
	 */
	public void test_one() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.EPACKAGE);
		
		try {
			assertTrue(helper.check(pkg1,
				"Sequence{'a', 'b', 'c', 'd', 'e'}->one(e | e = 'c')")); //$NON-NLS-1$

			assertFalse(helper.check(pkg1,
				"Sequence{'a', 'b', 'c', 'c', 'e'}->one(e | e = 'c')")); //$NON-NLS-1$

			assertFalse(helper.check(pkg1,
				"Sequence{'a', 'b', 'd', 'e'}->one(e | e = 'c')")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the collect() iterator.
	 */
	public void test_collect() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.EPACKAGE);
		
		try {
			List expected = new java.util.ArrayList();
			expected.add("pkg2"); //$NON-NLS-1$
			expected.add("bob"); //$NON-NLS-1$
			expected.add("pkg3"); //$NON-NLS-1$
			
			// complete form
			assertEquals(expected, helper.evaluate(pkg1,
				"eSubpackages->collect(p : EPackage | p.name)")); //$NON-NLS-1$

			// shorter form
			assertEquals(expected, helper.evaluate(pkg1,
				"eSubpackages->collect(p | p.name)")); //$NON-NLS-1$

			// yet shorter form
			assertEquals(expected, helper.evaluate(pkg1,
				"eSubpackages->collect(name)")); //$NON-NLS-1$

			// shortest form
			assertEquals(expected, helper.evaluate(pkg1,
				"eSubpackages.name")); //$NON-NLS-1$
			
			// flattening of nested collections
			expected.clear();
			expected.add(jim);
			expected.add(pkg4);
			expected.add(pkg5);
			
			assertEquals(expected, helper.evaluate(pkg1,
				"eSubpackages.eSubpackages")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the collectNested() iterator.
	 */
	public void test_collectNested() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.EPACKAGE);
		
		try {
			List expected = new java.util.ArrayList();
			expected.add("pkg2"); //$NON-NLS-1$
			expected.add("bob"); //$NON-NLS-1$
			expected.add("pkg3"); //$NON-NLS-1$
			
			// complete form
			assertEquals(expected, helper.evaluate(pkg1,
				"eSubpackages->collectNested(p : EPackage | p.name)")); //$NON-NLS-1$

			// shorter form
			assertEquals(expected, helper.evaluate(pkg1,
				"eSubpackages->collectNested(p | p.name)")); //$NON-NLS-1$

			// shortest form
			assertEquals(expected, helper.evaluate(pkg1,
				"eSubpackages->collectNested(name)")); //$NON-NLS-1$

			// nested collections not flattened
			expected.clear();
			expected.add(Collections.singletonList(jim));
			expected.add(Collections.EMPTY_LIST);
			expected.add(Arrays.asList(new Object[] {pkg4, pkg5}));
			
			assertEquals(expected, helper.evaluate(pkg1,
				"eSubpackages->collectNested(eSubpackages)")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the sortedBy() iterator.
	 */
	public void test_sortedBy() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.EPACKAGE);
		
		try {
			LinkedHashSet expectedSet = new LinkedHashSet();
			expectedSet.add(bob);
			expectedSet.add(pkg2);
			expectedSet.add(pkg3);
			
			// complete form
			assertEquals(expectedSet, helper.evaluate(pkg1,
				"eSubpackages->sortedBy(p : EPackage | p.name)")); //$NON-NLS-1$

			// shorter form
			assertEquals(expectedSet, helper.evaluate(pkg1,
				"eSubpackages->sortedBy(p | p.name)")); //$NON-NLS-1$

			// shortest form
			assertEquals(expectedSet, helper.evaluate(pkg1,
				"eSubpackages->sortedBy(name)")); //$NON-NLS-1$
			
			List expected = new java.util.ArrayList();
			expected.add("a"); //$NON-NLS-1$
			expected.add("b"); //$NON-NLS-1$
			expected.add("c"); //$NON-NLS-1$
			expected.add("d"); //$NON-NLS-1$
			expected.add("e"); //$NON-NLS-1$
			
			assertEquals(expected, helper.evaluate(pkg1,
				"Bag{'d', 'b', 'e', 'a', 'c'}->sortedBy(e | e)")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the closure() iterator.
	 */
	public void test_closure() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.EPACKAGE);
		
		try {
			Set expected = new java.util.HashSet();
			expected.add(pkg1);
			expected.add(pkg3);
			expected.add(pkg5);
			// closure does not include self (george)
			
			assertEquals(expected, helper.evaluate(george,
				"self->closure(eSuperPackage)")); //$NON-NLS-1$
			
			expected.remove(pkg1); // closure does not include self (pkg1)
			expected.add(pkg2);
			expected.add(jim);
			expected.add(bob);
			expected.add(pkg4);
			expected.add(george);
			
			assertEquals(expected, helper.evaluate(pkg1,
				"self->closure(eSubpackages)")); //$NON-NLS-1$
			
			// empty closure
			expected.clear();
			assertEquals(expected, helper.evaluate(pkg1,
				"self->closure(eSuperPackage)")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests that the closure() iterator handles cycles.
	 */
	public void test_closure_cycles() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.EREFERENCE);
		
		try {
			Set expected = new java.util.HashSet();
			expected.add(EcorePackage.Literals.EPACKAGE__ESUBPACKAGES);
			expected.add(EcorePackage.Literals.EPACKAGE__ESUPER_PACKAGE);
			// cyclic closure *does* include self
			
			assertEquals(expected, helper.evaluate(
				EcorePackage.Literals.EPACKAGE__ESUPER_PACKAGE,
				"self->closure(eOpposite)")); //$NON-NLS-1$
			
			assertEquals(expected, helper.evaluate(
				EcorePackage.Literals.EPACKAGE__ESUBPACKAGES,
				"self->closure(eOpposite)")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests parsing the closure of operation calls.
	 */
	public void test_closure_operations() {
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
					"self->closure(getFakes())"); //$NON-NLS-1$
		} catch (Exception exc) {
			fail("Failed to parse or evaluate: " + exc.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the validation of the closure() iterator.
	 */
	public void test_closureValidation() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.EPACKAGE);
		
		try {
			// non-recursive reference
			helper.createQuery(
				"self->closure(eClassifiers)"); //$NON-NLS-1$
			
			fail("Validation should have failed"); //$NON-NLS-1$
		} catch (OCLParsingException e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests that when the body of an iterator results in OclInvalid, the entire 
	 * iterator expression's value is OclInvalid.
	 */
	public void test_forAll_invalidBody_142518() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.EPACKAGE);
		
		try {
			Object result = helper.evaluate(EcorePackage.eINSTANCE,
				"let b:Boolean = null in Bag{1, 2, 3}->forAll(b and b)"); //$NON-NLS-1$
			
			assertSame(Types.OCL_INVALID, result);
			
			// check that the "check" API interprets OclInvalid as a constraint violation
			assertFalse(helper.check(EcorePackage.eINSTANCE,
				"let b:Boolean = null in Bag{1}->forAll(b and b)")); //$NON-NLS-1$
			
			// same deal for a null value (in the forAll case)
			result = helper.evaluate(EcorePackage.eINSTANCE,
				"Bag{1, 2, 3}->forAll(null.oclAsType(Boolean))"); //$NON-NLS-1$
			
			assertSame(Types.OCL_INVALID, result);
		} catch (Exception exc) {
			fail("Failed to parse or evaluate: " + exc.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests that when the body of an iterator results in OclInvalid, the entire 
	 * iterator expression's value is OclInvalid.
	 */
	public void test_exists_invalidBody_142518() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.EPACKAGE);
		
		try {
			Object result = helper.evaluate(EcorePackage.eINSTANCE,
				"let b:Boolean = null in Bag{1, 2, 3}->exists(b and b)"); //$NON-NLS-1$
			
			assertSame(Types.OCL_INVALID, result);
			
			// same deal for a null value (in the exists case)
			result = helper.evaluate(EcorePackage.eINSTANCE,
				"Bag{1, 2, 3}->exists(null.oclAsType(Boolean))"); //$NON-NLS-1$
			
			assertSame(Types.OCL_INVALID, result);
		} catch (Exception exc) {
			fail("Failed to parse or evaluate: " + exc.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests that when the body of an iterator results in OclInvalid, the entire 
	 * iterator expression's value is OclInvalid.
	 */
	public void test_one_invalidBody_142518() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.EPACKAGE);
		
		try {
			Object result = helper.evaluate(EcorePackage.eINSTANCE,
				"let b:Boolean = null in Bag{1, 2, 3}->one(b and b)"); //$NON-NLS-1$
			
			assertSame(Types.OCL_INVALID, result);
			
			// same deal for a null value (in the one case)
			result = helper.evaluate(EcorePackage.eINSTANCE,
				"Bag{1, 2, 3}->one(null.oclAsType(Boolean))"); //$NON-NLS-1$
			
			assertSame(Types.OCL_INVALID, result);
		} catch (Exception exc) {
			fail("Failed to parse or evaluate: " + exc.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests that when the body of an iterator results in OclInvalid, the entire 
	 * iterator expression's value is OclInvalid.
	 */
	public void test_any_invalidBody_142518() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.EPACKAGE);
		
		try {
			Object result = helper.evaluate(EcorePackage.eINSTANCE,
				"let b:Boolean = null in Bag{1, 2, 3}->any(b and b)"); //$NON-NLS-1$
			
			assertSame(Types.OCL_INVALID, result);
			
			// same deal for a null value (in the any case)
			result = helper.evaluate(EcorePackage.eINSTANCE,
				"Bag{1, 2, 3}->any(null.oclAsType(Boolean))"); //$NON-NLS-1$
			
			assertSame(Types.OCL_INVALID, result);
		} catch (Exception exc) {
			fail("Failed to parse or evaluate: " + exc.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests that when the body of an iterator results in OclInvalid, the entire 
	 * iterator expression's value is OclInvalid.
	 */
	public void test_select_invalidBody_142518() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.EPACKAGE);
		
		try {
			Object result = helper.evaluate(EcorePackage.eINSTANCE,
				"let b:Boolean = null in Bag{1, 2, 3}->select(b and b)"); //$NON-NLS-1$
			
			assertSame(Types.OCL_INVALID, result);
			
			// same deal for a null value (in the exists case)
			result = helper.evaluate(EcorePackage.eINSTANCE,
				"Bag{1, 2, 3}->select(null.oclAsType(Boolean))"); //$NON-NLS-1$
			
			assertSame(Types.OCL_INVALID, result);
		} catch (Exception exc) {
			fail("Failed to parse or evaluate: " + exc.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests that when the body of an iterator results in OclInvalid, the entire 
	 * iterator expression's value is OclInvalid.
	 */
	public void test_reject_invalidBody_142518() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.EPACKAGE);
		
		try {
			Object result = helper.evaluate(EcorePackage.eINSTANCE,
				"let b:Boolean = null in Bag{1, 2, 3}->reject(b and b)"); //$NON-NLS-1$
			
			assertSame(Types.OCL_INVALID, result);
			
			// same deal for a null value (in the exists case)
			result = helper.evaluate(EcorePackage.eINSTANCE,
				"Bag{1, 2, 3}->reject(null.oclAsType(Boolean))"); //$NON-NLS-1$
			
			assertSame(Types.OCL_INVALID, result);
		} catch (Exception exc) {
			fail("Failed to parse or evaluate: " + exc.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests that when the body of an iterator results in OclInvalid, the isUnique 
	 * iterator expression treats it like any other value.
	 */
	public void test_isUnique_invalidBody_142518() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.EPACKAGE);
		
		try {
			// OclInvalid supports the = operation
			Object result = helper.evaluate(EcorePackage.eINSTANCE,
				"let b:Boolean = null in Bag{1, 2, 3}->isUnique(b and b)"); //$NON-NLS-1$
			
			assertEquals(Boolean.FALSE, result);
			
			result = helper.evaluate(EcorePackage.eINSTANCE,
				"let b:Boolean = null in Bag{1, 2, 3}->isUnique(null)"); //$NON-NLS-1$
		
			assertEquals(Boolean.FALSE, result);
		} catch (Exception exc) {
			fail("Failed to parse or evaluate: " + exc.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests that when the body of an iterator results in OclInvalid, the entire 
	 * iterator expression's value is OclInvalid.
	 */
	public void test_collect_invalidBody_142518() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.EPACKAGE);
		
		try {
			Object result = helper.evaluate(EcorePackage.eINSTANCE,
				"let b:Boolean = null in Bag{1, 2, 3}->collect(b and b)"); //$NON-NLS-1$
			
			assertSame(Types.OCL_INVALID, result);
			
			// in the case of a null value, null is allowed in a collection, so
			//    it does not result in OclInvalid
			result = helper.evaluate(EcorePackage.eINSTANCE,
				"let b:Boolean = null in Bag{1, 2, 3}->collect(null)"); //$NON-NLS-1$
		
			assertTrue(result instanceof Collection);
			
			Collection collResult = (Collection) result;
			assertEquals(3, collResult.size());
			for (Iterator iter = collResult.iterator(); iter.hasNext();) {
				assertNull(iter.next());
			}
		} catch (Exception exc) {
			fail("Failed to parse or evaluate: " + exc.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests that when the body of an iterator results in OclInvalid, the entire 
	 * iterator expression's value is OclInvalid.
	 */
	public void test_collectNested_invalidBody_142518() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.EPACKAGE);
		
		try {
			Object result = helper.evaluate(EcorePackage.eINSTANCE,
				"let b:Boolean = null in Bag{1, 2, 3}->collectNested(b and b)"); //$NON-NLS-1$
			
			assertSame(Types.OCL_INVALID, result);
			
			// in the case of a null value, null is allowed in a collection, so
			//    it does not result in OclInvalid
			result = helper.evaluate(EcorePackage.eINSTANCE,
				"let b:Boolean = null in Bag{1, 2, 3}->collectNested(e | if e = 2 then null else Set{e} endif)"); //$NON-NLS-1$
		
			assertTrue(result instanceof Collection);
			
			Collection collResult = (Collection) result;
			assertEquals(3, collResult.size());
			for (Iterator iter = collResult.iterator(); iter.hasNext();) {
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
	 * Tests that when the body of an iterator results in OclInvalid, the entire 
	 * iterator expression's value is OclInvalid.
	 */
	public void test_closure_invalidBody_142518() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.EPACKAGE);
		
		try {
			Object result = helper.evaluate(EcorePackage.eINSTANCE,
				"let b:Boolean = null in eClassifiers->closure(c | b implies c.name.size() > 0)"); //$NON-NLS-1$
			
			assertSame(Types.OCL_INVALID, result);
			
			// in the case of a null value, null is allowed in a collection, so
			//    it does not result in OclInvalid
			result = helper.evaluate(EcorePackage.eINSTANCE,
				"let c : Set(EClassifier) = Set{null} in eClassifiers->closure(c)"); //$NON-NLS-1$
		
			assertTrue(result instanceof Collection);
			
			Collection collResult = (Collection) result;
			assertTrue(collResult.isEmpty());
		} catch (Exception exc) {
			fail("Failed to parse or evaluate: " + exc.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests that when the body of an iterator results in OclInvalid, the entire 
	 * iterator expression's value is OclInvalid.
	 */
	public void test_sortedBy_invalidBody_142518() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.EPACKAGE);
		
		try {
			Object result = helper.evaluate(EcorePackage.eINSTANCE,
				"let s : String = null in Bag{1, 2, 3}->sortedBy(s.size())"); //$NON-NLS-1$
			
			assertSame(Types.OCL_INVALID, result);
			
			// same deal for null values
			result = helper.evaluate(EcorePackage.eINSTANCE,
				"Bag{1, 2, 3}->sortedBy(null.oclAsType(Integer))"); //$NON-NLS-1$
		
			assertSame(Types.OCL_INVALID, result);
		} catch (Exception exc) {
			fail("Failed to parse or evaluate: " + exc.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	//
	// Framework methods
	//
	
	protected void setUp() throws Exception {
		super.setUp();
		
		// need a metamodel that has a reflexive EReference.
		//   Ecore will do nicely.  Create the following structure:
		// pkg1
		//   pkg2
		//     jim
		//   bob
		//   pkg3
		//     pkg4
		//     pkg5
		//       george
		
		pkg1 = EcoreFactory.eINSTANCE.createEPackage();
		pkg1.setName("pkg1"); //$NON-NLS-1$
		
		pkg2 = EcoreFactory.eINSTANCE.createEPackage();
		pkg2.setName("pkg2"); //$NON-NLS-1$
		pkg1.getESubpackages().add(pkg2);
		
		jim = EcoreFactory.eINSTANCE.createEPackage();
		jim.setName("jim"); //$NON-NLS-1$
		pkg2.getESubpackages().add(jim);
		
		bob = EcoreFactory.eINSTANCE.createEPackage();
		bob.setName("bob"); //$NON-NLS-1$
		pkg1.getESubpackages().add(bob);
		
		pkg3 = EcoreFactory.eINSTANCE.createEPackage();
		pkg3.setName("pkg3"); //$NON-NLS-1$
		pkg1.getESubpackages().add(pkg3);
		
		pkg4 = EcoreFactory.eINSTANCE.createEPackage();
		pkg4.setName("pkg4"); //$NON-NLS-1$
		pkg3.getESubpackages().add(pkg4);
		
		pkg5 = EcoreFactory.eINSTANCE.createEPackage();
		pkg5.setName("pkg5"); //$NON-NLS-1$
		pkg3.getESubpackages().add(pkg5);
		
		george = EcoreFactory.eINSTANCE.createEPackage();
		george.setName("george"); //$NON-NLS-1$
		pkg5.getESubpackages().add(george);
	}
}
