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
 * $Id: ComparisonTest.java,v 1.3 2006/04/11 17:18:33 cdamus Exp $
 */

package org.eclipse.emf.ocl.tests;

import java.util.LinkedHashSet;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ocl.helper.HelperUtil;
import org.eclipse.emf.ocl.helper.IOCLHelper;

/**
 * Tests for comparison (&lt;, &lt;=, &gt;=, &gt;) expressions.
 *
 * @author Christian W. Damus (cdamus)
 */
public class ComparisonTest
	extends AbstractTestSuite {

	private EPackage pkg;
	private EClass thingType;
	private EAttribute values;
	private EDataType valueType;
	
	private EObject thing;
	
	public ComparisonTest(String name) {
		super(name);
	}
	
	public static Test suite() {
		return new TestSuite(ComparisonTest.class, "Comparison/Ordering Tests"); //$NON-NLS-1$
	}
	
	/**
	 * Tests the &lt; operator.
	 */
	public void test_lessThan() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(thingType);
		
		try {
			// primitives
			assertTrue(helper.check(thing, "1 < 2")); //$NON-NLS-1$
			assertFalse(helper.check(thing, "21 < 2")); //$NON-NLS-1$
			assertTrue(helper.check(thing, "1 < 2.0")); //$NON-NLS-1$
			assertFalse(helper.check(thing, "21 < 2.0")); //$NON-NLS-1$
			assertTrue(helper.check(thing, "1.0 < 2")); //$NON-NLS-1$
			assertFalse(helper.check(thing, "21.0 < 2")); //$NON-NLS-1$
			assertTrue(helper.check(thing, "1.0 < 2.0")); //$NON-NLS-1$
			assertFalse(helper.check(thing, "21.0 < 2.0")); //$NON-NLS-1$
			assertTrue(helper.check(thing, "'a' < 'b'")); //$NON-NLS-1$
			assertFalse(helper.check(thing, "'ba' < 'b'")); //$NON-NLS-1$

			List valuesList = (List) thing.eGet(values);
			valuesList.add(new Value("a")); //$NON-NLS-1$
			valuesList.add(new Value("b")); //$NON-NLS-1$
			
			assertTrue(helper.check(thing,
				"values->at(1) < values->at(2)")); //$NON-NLS-1$

			assertFalse(helper.check(thing,
				"values->at(2) < values->at(1)")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the &lt;= operator.
	 */
	public void test_lessThanOrEqual() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(thingType);
		
		try {
			// primitives
			assertTrue(helper.check(thing, "1 <= 2")); //$NON-NLS-1$
			assertTrue(helper.check(thing, "1 <= 1")); //$NON-NLS-1$
			assertFalse(helper.check(thing, "21 <= 2")); //$NON-NLS-1$
			assertTrue(helper.check(thing, "1 <= 2.0")); //$NON-NLS-1$
			assertTrue(helper.check(thing, "1 <= 1.0")); //$NON-NLS-1$
			assertFalse(helper.check(thing, "21 <= 2.0")); //$NON-NLS-1$
			assertTrue(helper.check(thing, "1.0 <= 2")); //$NON-NLS-1$
			assertTrue(helper.check(thing, "1.0 <= 1")); //$NON-NLS-1$
			assertFalse(helper.check(thing, "21.0 <= 2")); //$NON-NLS-1$
			assertTrue(helper.check(thing, "1.0 <= 2.0")); //$NON-NLS-1$
			assertTrue(helper.check(thing, "1.0 <= 1.0")); //$NON-NLS-1$
			assertFalse(helper.check(thing, "21.0 <= 2.0")); //$NON-NLS-1$
			assertTrue(helper.check(thing, "'a' <= 'b'")); //$NON-NLS-1$
			assertTrue(helper.check(thing, "'a' <= 'a'")); //$NON-NLS-1$
			assertFalse(helper.check(thing, "'ba' <= 'b'")); //$NON-NLS-1$

			List valuesList = (List) thing.eGet(values);
			valuesList.add(new Value("a")); //$NON-NLS-1$
			valuesList.add(new Value("b")); //$NON-NLS-1$
			
			assertTrue(helper.check(thing,
				"values->at(1) <= values->at(2)")); //$NON-NLS-1$

			assertTrue(helper.check(thing,
				"values->at(1) <= values->at(1)")); //$NON-NLS-1$

			assertFalse(helper.check(thing,
				"values->at(2) <= values->at(1)")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the &gt; operator.
	 */
	public void test_greaterThan() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(thingType);
		
		try {
			// primitives
			assertTrue(helper.check(thing, "2 > 1")); //$NON-NLS-1$
			assertFalse(helper.check(thing, "2 > 21")); //$NON-NLS-1$
			assertTrue(helper.check(thing, "2 > 1.0")); //$NON-NLS-1$
			assertFalse(helper.check(thing, "2 > 21.0")); //$NON-NLS-1$
			assertTrue(helper.check(thing, "2.0 > 1")); //$NON-NLS-1$
			assertFalse(helper.check(thing, "2.0 > 21")); //$NON-NLS-1$
			assertTrue(helper.check(thing, "2.0 > 1.0")); //$NON-NLS-1$
			assertFalse(helper.check(thing, "2.0 > 21.0")); //$NON-NLS-1$
			assertTrue(helper.check(thing, "'b' > 'a'")); //$NON-NLS-1$
			assertFalse(helper.check(thing, "'a' > 'b'")); //$NON-NLS-1$

			List valuesList = (List) thing.eGet(values);
			valuesList.add(new Value("b")); //$NON-NLS-1$
			valuesList.add(new Value("a")); //$NON-NLS-1$
			
			assertTrue(helper.check(thing,
				"values->at(1) > values->at(2)")); //$NON-NLS-1$

			assertFalse(helper.check(thing,
				"values->at(2) > values->at(1)")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the &gt;= operator.
	 */
	public void test_greaterThanOrEqual() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(thingType);
		
		try {
			// primitives
			assertTrue(helper.check(thing, "2 >= 1")); //$NON-NLS-1$
			assertTrue(helper.check(thing, "2 >= 2")); //$NON-NLS-1$
			assertFalse(helper.check(thing, "2 >= 21")); //$NON-NLS-1$
			assertTrue(helper.check(thing, "2 >= 1.0")); //$NON-NLS-1$
			assertTrue(helper.check(thing, "2 >= 2.0")); //$NON-NLS-1$
			assertFalse(helper.check(thing, "2 >= 21.0")); //$NON-NLS-1$
			assertTrue(helper.check(thing, "2.0 >= 1")); //$NON-NLS-1$
			assertTrue(helper.check(thing, "2.0 >= 2")); //$NON-NLS-1$
			assertFalse(helper.check(thing, "2.0 >= 21")); //$NON-NLS-1$
			assertTrue(helper.check(thing, "2.0 >= 1.0")); //$NON-NLS-1$
			assertTrue(helper.check(thing, "2.0 >= 2.0")); //$NON-NLS-1$
			assertFalse(helper.check(thing, "2.0 >= 21.0")); //$NON-NLS-1$
			assertTrue(helper.check(thing, "'b' >= 'a'")); //$NON-NLS-1$
			assertTrue(helper.check(thing, "'b' >= 'b'")); //$NON-NLS-1$
			assertFalse(helper.check(thing, "'a' >= 'b'")); //$NON-NLS-1$

			List valuesList = (List) thing.eGet(values);
			valuesList.add(new Value("b")); //$NON-NLS-1$
			valuesList.add(new Value("a")); //$NON-NLS-1$
			
			assertTrue(helper.check(thing,
				"values->at(1) >= values->at(2)")); //$NON-NLS-1$

			assertTrue(helper.check(thing,
				"values->at(1) >= values->at(1)")); //$NON-NLS-1$

			assertFalse(helper.check(thing,
				"values->at(2) >= values->at(1)")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the sortedby iterator.
	 */
	public void test_sortedBy() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(thingType);
		
		try {
			List valuesList = (List) thing.eGet(values);
			valuesList.add(new Value("b")); //$NON-NLS-1$
			valuesList.add(new Value("c")); //$NON-NLS-1$
			valuesList.add(new Value("a")); //$NON-NLS-1$
			
			LinkedHashSet expected = new LinkedHashSet();
			expected.add(valuesList.get(2));
			expected.add(valuesList.get(0));
			expected.add(valuesList.get(1));
			
			assertEquals(expected, helper.evaluate(thing,
				"values->sortedBy(e | e)")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the <code>=</code> and <code>&lt;&gt;</code> operators for the
	 * Invalid type.
	 */
	public void test_invalid_equality() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(thingType);
		
		try {
			assertFalse(helper.check(thing, "OclInvalid = 'a'")); //$NON-NLS-1$
			assertTrue(helper.check(thing, "OclInvalid <> 'a'")); //$NON-NLS-1$
			assertTrue(helper.check(thing, "OclInvalid = OclInvalid")); //$NON-NLS-1$
			assertFalse(helper.check(thing, "OclInvalid <> OclInvalid")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the <code>=</code> and <code>&lt;&gt;</code> operators for the
	 * OclVoid type.
	 */
	public void test_void_equality() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(thingType);
		
		try {
			assertFalse(helper.check(thing, "null = 'a'")); //$NON-NLS-1$
			assertTrue(helper.check(thing, "null <> 'a'")); //$NON-NLS-1$
			assertTrue(helper.check(thing, "null = null")); //$NON-NLS-1$
			assertFalse(helper.check(thing, "null <> null")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests evaluation of the arithmetic operations on integers.
	 */
	public void test_integerArithmetic() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(thingType);
		
		try {
			assertEquals(new Integer(1), helper.evaluate(thing, "3 - 2")); //$NON-NLS-1$
			assertEquals(new Integer(3), helper.evaluate(thing, "1 + 2")); //$NON-NLS-1$
			assertEquals(new Double(2.0), helper.evaluate(thing, "6 / 3")); //$NON-NLS-1$
			assertEquals(new Integer(6), helper.evaluate(thing, "2 * 3")); //$NON-NLS-1$
			assertEquals(new Integer(-1), helper.evaluate(thing, "- 1")); //$NON-NLS-1$
			assertEquals(new Integer(3), helper.evaluate(thing, "(2 - 5).abs()")); //$NON-NLS-1$
			assertEquals(new Integer(3), helper.evaluate(thing, "3.max(2)")); //$NON-NLS-1$
			assertEquals(new Integer(2), helper.evaluate(thing, "3.min(2)")); //$NON-NLS-1$
			assertEquals(new Integer(3), helper.evaluate(thing, "7.div(2)")); //$NON-NLS-1$
			assertEquals(new Integer(1), helper.evaluate(thing, "7.mod(2)")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests evaluation of the arithmetic operations on reals.
	 */
	public void test_realArithmetic() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(thingType);
		
		try {
			assertEquals(new Double(1.0), helper.evaluate(thing, "3.0 - 2.0")); //$NON-NLS-1$
			assertEquals(new Double(3.0), helper.evaluate(thing, "1.0 + 2.0")); //$NON-NLS-1$
			assertEquals(new Double(2.0), helper.evaluate(thing, "6.0 / 3.0")); //$NON-NLS-1$
			assertEquals(new Double(6.0), helper.evaluate(thing, "2.0 * 3.0")); //$NON-NLS-1$
			assertEquals(new Double(-1.0), helper.evaluate(thing, "- 1.0")); //$NON-NLS-1$
			assertEquals(new Double(3.0), helper.evaluate(thing, "(2.0 - 5.0).abs()")); //$NON-NLS-1$
			assertEquals(new Double(3.0), helper.evaluate(thing, "3.0.max(2.0)")); //$NON-NLS-1$
			assertEquals(new Double(2.0), helper.evaluate(thing, "3.0.min(2.0)")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests evaluation of the arithmetic operations on integers, with real
	 * arguments.
	 */
	public void test_mixedArithmetic() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(thingType);
		
		try {
			assertEquals(new Double(1.0), helper.evaluate(thing, "3 - 2.0")); //$NON-NLS-1$
			assertEquals(new Double(3.0), helper.evaluate(thing, "1 + 2.0")); //$NON-NLS-1$
			assertEquals(new Double(2.0), helper.evaluate(thing, "6 / 3.0")); //$NON-NLS-1$
			assertEquals(new Double(6.0), helper.evaluate(thing, "2 * 3.0")); //$NON-NLS-1$
			assertEquals(new Double(3.0), helper.evaluate(thing, "3.max(2.0)")); //$NON-NLS-1$
			assertEquals(new Double(2.0), helper.evaluate(thing, "3.min(2.0)")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	//
	// Framework methods
	//
	
	protected void setUp() throws Exception {
		super.setUp();
		
		pkg = EcoreFactory.eINSTANCE.createEPackage();
		pkg.setName("pkg"); //$NON-NLS-1$
		
		EFactory factory = EcoreFactory.eINSTANCE.createEFactory();
		pkg.setEFactoryInstance(factory);
		
		valueType = EcoreFactory.eINSTANCE.createEDataType();
		valueType.setName("Value"); //$NON-NLS-1$
		valueType.setInstanceClass(Value.class);
		pkg.getEClassifiers().add(valueType);
		
		thingType = EcoreFactory.eINSTANCE.createEClass();
		thingType.setName("Thing"); //$NON-NLS-1$
		pkg.getEClassifiers().add(thingType);
		
		values = EcoreFactory.eINSTANCE.createEAttribute();
		values.setName("values"); //$NON-NLS-1$
		values.setEType(valueType);
		values.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
		thingType.getEStructuralFeatures().add(values);
		
		thing = factory.create(thingType);
	}
	
	private static class Value implements Comparable {
		private final String value;
		
		Value(String value) {
			this.value = value;
		}
		
		public int compareTo(Object arg0) {
			return value.compareTo(((Value) arg0).value);
		}

		public int hashCode() {
			final int PRIME = 31;
			int result = 1;
			result = PRIME * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}

		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final Value other = (Value) obj;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}
	}
}
