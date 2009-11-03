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

public class StaticLongAttributeTestCase extends OclInterpreterTestCase {

	private static long longSimple1 = 1;

	private static long longOptionalSimple1 = 3;

	private static long[] longSet1 = new long[] { 2, 3 };

	private static long[] longOrderedSet1 = new long[] { 3, 2, 4 };

	private static long[] longSequence1 = new long[] { 3, 2, 3, 2 };

	private static long[] longBag1 = new long[] { 2, 3, 2, 3 };

	private Object/* StaticLongTestClass */staticLongTestClass;

	public void testSimpleAttribute() throws Exception {
		if (!this.adapter.supportStaticFeatures()) {
			return;
		}
		List result = this.adapter.evaluate("TestMetaModel::PrimitiveTypesStaticTests::StaticLongTest::simpleAttribute");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(StaticLongAttributeTestCase.longSimple1, ((Long) result.get(0)).longValue());
	}

	public void testOptionalSimpleAttribute() throws Exception {
		if (!this.adapter.supportStaticFeatures()) {
			return;
		}
		List result = this.adapter.evaluate("TestMetaModel::PrimitiveTypesStaticTests::StaticLongTest::optionalSimpleAttribute ");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(StaticLongAttributeTestCase.longOptionalSimple1, ((Long) result.get(0)).longValue());
	}

	public void testBagAttribute() throws Exception {
		if (!this.adapter.supportStaticFeatures()) {
			return;
		}
		List result = this.adapter.evaluate("TestMetaModel::PrimitiveTypesStaticTests::StaticLongTest::bagAttribute ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(StaticLongAttributeTestCase.longBag1.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toLongVector(StaticLongAttributeTestCase.longBag1)));
	}

	public void testSetAttribute() throws Exception {
		if (!this.adapter.supportStaticFeatures()) {
			return;
		}
		List result = this.adapter.evaluate("TestMetaModel::PrimitiveTypesStaticTests::StaticLongTest::setAttribute ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(StaticLongAttributeTestCase.longSet1.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toLongVector(StaticLongAttributeTestCase.longSet1)));
	}

	public void testOrderedSetAttribute() throws Exception {
		if (!this.adapter.supportStaticFeatures()) {
			return;
		}
		List result = this.adapter.evaluate("TestMetaModel::PrimitiveTypesStaticTests::StaticLongTest::orderedSetAttribute ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(StaticLongAttributeTestCase.longOrderedSet1.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toLongVector(StaticLongAttributeTestCase.longOrderedSet1)));
	}

	public void testSequenceAttribute() throws Exception {
		if (!this.adapter.supportStaticFeatures()) {
			return;
		}
		List result = this.adapter.evaluate("TestMetaModel::PrimitiveTypesStaticTests::StaticLongTest::sequenceAttribute ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(StaticLongAttributeTestCase.longSequence1.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toLongVector(StaticLongAttributeTestCase.longSequence1)));
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		this.adapter.setValueForStaticFeature(this.META_StaticLongTest, this.META_StaticLongTest_simpleAttribute, new Long(StaticLongAttributeTestCase.longSimple1));
		this.adapter.setValueForStaticFeature(this.META_StaticLongTest, this.META_StaticLongTest_optionalSimpleAttribute, new Long(StaticLongAttributeTestCase.longOptionalSimple1));
		this.adapter.setValueForStaticFeature(this.META_StaticLongTest, this.META_StaticLongTest_setAttribute, StaticLongAttributeTestCase.longSet1);
		this.adapter.setValueForStaticFeature(this.META_StaticLongTest, this.META_StaticLongTest_bagAttribute, StaticLongAttributeTestCase.longBag1);
		this.adapter.setValueForStaticFeature(this.META_StaticLongTest, this.META_StaticLongTest_orderedSetAttribute, StaticLongAttributeTestCase.longOrderedSet1);
		this.adapter.setValueForStaticFeature(this.META_StaticLongTest, this.META_StaticLongTest_sequenceAttribute, StaticLongAttributeTestCase.longSequence1);

	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	Vector toLongVector(long[] doubleArray) {
		Vector result = new Vector();
		for (long element : doubleArray) {
			result.add(new Long(element));
		}
		return result;
	}

}
