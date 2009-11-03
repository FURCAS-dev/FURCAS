/*******************************************************************************
 * Copyright (c) 2008 ikv++ technologies ag and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     ikv++ technologies ag - initial API and implementation
 *******************************************************************************/

package de.ikv.medini.ocl20.bridge4medini.test.exp.propertycallexp.modelpropertycallexp.attributecallexp;

import java.util.Collection;
import java.util.List;
import java.util.Vector;

import junit.framework.Assert;

import de.ikv.medini.ocl20.bridge4medini.test.OclInterpreterTestCase;

public class StaticIntegerAttributeTestCase extends OclInterpreterTestCase {

	private static int integerSimple1 = 1;

	private static int integerOptionalSimple1 = 3;

	private static int[] integerSet1 = new int[] { 2, 3 };

	private static int[] integerOrderedSet1 = new int[] { 3, 2, 4 };

	private static int[] integerSequence1 = new int[] { 3, 2, 3, 2 };

	private static int[] integerBag1 = new int[] { 2, 3, 2, 3 };

	private Object/* StaticIntegerTestClass */staticIntegerTestClass;

	public void testSimpleAttribute() throws Exception {
		if (!this.adapter.supportStaticFeatures()) {
			return;
		}
		List result = this.adapter.evaluate("TestMetaModel::PrimitiveTypesStaticTests::StaticIntegerTest::simpleAttribute");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(StaticIntegerAttributeTestCase.integerSimple1, ((Long) result.get(0)).longValue());
	}

	public void testOptionalSimpleAttribute() throws Exception {
		if (!this.adapter.supportStaticFeatures()) {
			return;
		}
		List result = this.adapter.evaluate("TestMetaModel::PrimitiveTypesStaticTests::StaticIntegerTest::optionalSimpleAttribute ");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(StaticIntegerAttributeTestCase.integerOptionalSimple1, ((Long) result.get(0)).longValue());
	}

	public void testBagAttribute() throws Exception {
		if (!this.adapter.supportStaticFeatures()) {
			return;
		}
		List result = this.adapter.evaluate("TestMetaModel::PrimitiveTypesStaticTests::StaticIntegerTest::bagAttribute ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(StaticIntegerAttributeTestCase.integerBag1.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toLongVector(StaticIntegerAttributeTestCase.integerBag1)));
	}

	public void testSetAttribute() throws Exception {
		if (!this.adapter.supportStaticFeatures()) {
			return;
		}
		List result = this.adapter.evaluate("TestMetaModel::PrimitiveTypesStaticTests::StaticIntegerTest::setAttribute ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(StaticIntegerAttributeTestCase.integerSet1.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toLongVector(StaticIntegerAttributeTestCase.integerSet1)));
	}

	public void testOrderedSetAttribute() throws Exception {
		if (!this.adapter.supportStaticFeatures()) {
			return;
		}
		List result = this.adapter.evaluate("TestMetaModel::PrimitiveTypesStaticTests::StaticIntegerTest::orderedSetAttribute ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(StaticIntegerAttributeTestCase.integerOrderedSet1.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toLongVector(StaticIntegerAttributeTestCase.integerOrderedSet1)));
	}

	public void testSequenceAttribute() throws Exception {
		if (!this.adapter.supportStaticFeatures()) {
			return;
		}
		List result = this.adapter.evaluate("TestMetaModel::PrimitiveTypesStaticTests::StaticIntegerTest::sequenceAttribute ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(StaticIntegerAttributeTestCase.integerSequence1.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toLongVector(StaticIntegerAttributeTestCase.integerSequence1)));
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		this.adapter.setValueForStaticFeature(this.META_StaticIntegerTest, this.META_StaticIntegerTest_simpleAttribute, new Integer(StaticIntegerAttributeTestCase.integerSimple1));
		this.adapter.setValueForStaticFeature(this.META_StaticIntegerTest, this.META_StaticIntegerTest_optionalSimpleAttribute, new Integer(StaticIntegerAttributeTestCase.integerOptionalSimple1));
		this.adapter.setValueForStaticFeature(this.META_StaticIntegerTest, this.META_StaticIntegerTest_setAttribute, StaticIntegerAttributeTestCase.integerSet1);
		this.adapter.setValueForStaticFeature(this.META_StaticIntegerTest, this.META_StaticIntegerTest_bagAttribute, StaticIntegerAttributeTestCase.integerBag1);
		this.adapter.setValueForStaticFeature(this.META_StaticIntegerTest, this.META_StaticIntegerTest_orderedSetAttribute, StaticIntegerAttributeTestCase.integerOrderedSet1);
		this.adapter.setValueForStaticFeature(this.META_StaticIntegerTest, this.META_StaticIntegerTest_sequenceAttribute, StaticIntegerAttributeTestCase.integerSequence1);

	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	Vector toLongVector(int[] doubleArray) {
		Vector result = new Vector();
		for (int element : doubleArray) {
			result.add(new Long(element));
		}
		return result;
	}

}
