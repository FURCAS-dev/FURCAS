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

public class LongAttributeTestCase extends OclInterpreterTestCase {

	private static long longSimple1 = 1;

	private static long longOptionalSimple1 = 2;

	private static long[] longSet1 = new long[] { 1, 2 };

	private static long[] longOrderedSet1 = new long[] { 3, 2 };

	private static long[] longSequence1 = new long[] { 3, 2, 1, 1 };

	private static long[] longBag1 = new long[] { 2, 2, 2, 3 };

	private static long longSimple2 = -1;

	private static long longOptionalSimple2 = -3;

	private static long[] longSet2 = new long[] {};

	private static long[] longOrderedSet2 = new long[] {};

	private static long[] longSequence2 = new long[] {};

	private static long[] longBag2 = new long[] {};

	private Object/* LongTest */longTest1;

	private Object/* LongTest */longTest2;

	public void testSimpleAttribute() throws Exception {
		List result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::LongTest inv: self.simpleAttribute ", this.longTest1);
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(LongAttributeTestCase.longSimple1, ((Number) result.get(0)).longValue());

		result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::LongTest inv: self.simpleAttribute ", this.longTest2);
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(LongAttributeTestCase.longSimple2, ((Number) result.get(0)).longValue());
	}

	public void testOptionalSimpleAttribute() throws Exception {
		List result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::LongTest inv: self.optionalSimpleAttribute ", this.longTest1);
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(LongAttributeTestCase.longOptionalSimple1, ((Number) result.get(0)).longValue());

		result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::LongTest inv: self.optionalSimpleAttribute ", this.longTest2);
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(LongAttributeTestCase.longOptionalSimple2, ((Number) result.get(0)).longValue());
	}

	public void testBagAttribute() throws Exception {
		List result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::LongTest inv: self.bagAttribute ", this.longTest1);
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(LongAttributeTestCase.longBag1.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toLongVector(LongAttributeTestCase.longBag1)));

		result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::LongTest inv: self.bagAttribute ", this.longTest2);
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		Assert.assertEquals(LongAttributeTestCase.longBag2.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toLongVector(LongAttributeTestCase.longBag2)));

	}

	public void testSetAttribute() throws Exception {
		List result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::LongTest inv: self.setAttribute ", this.longTest1);
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(LongAttributeTestCase.longSet1.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toLongVector(LongAttributeTestCase.longSet1)));

		result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::LongTest inv: self.setAttribute ", this.longTest2);
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		Assert.assertEquals(LongAttributeTestCase.longSet2.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toLongVector(LongAttributeTestCase.longSet2)));
	}

	public void testOrderedSetAttribute() throws Exception {
		List result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::LongTest inv: self.orderedSetAttribute ", this.longTest1);
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(LongAttributeTestCase.longOrderedSet1.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toLongVector(LongAttributeTestCase.longOrderedSet1)));

		result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::LongTest inv: self.orderedSetAttribute ", this.longTest2);
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		Assert.assertEquals(LongAttributeTestCase.longOrderedSet2.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toLongVector(LongAttributeTestCase.longOrderedSet2)));
	}

	public void testSequenceAttribute() throws Exception {
		List result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::LongTest inv: self.sequenceAttribute ", this.longTest1);
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(LongAttributeTestCase.longSequence1.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toLongVector(LongAttributeTestCase.longSequence1)));

		result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::LongTest inv: self.sequenceAttribute ", this.longTest2);
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		Assert.assertEquals(LongAttributeTestCase.longSequence2.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toLongVector(LongAttributeTestCase.longSequence2)));
	}

	@Override
	protected void setUp() throws Exception {

		super.setUp();

		this.longTest1 = this.adapter.createModelElement(this.META_LongTest);
		this.adapter.setValueForFeature(this.longTest1, this.META_LongTest_simpleAttribute, LongAttributeTestCase.longSimple1);
		this.adapter.setValueForFeature(this.longTest1, this.META_LongTest_optionalSimpleAttribute, LongAttributeTestCase.longOptionalSimple1);
		this.adapter.setValueForFeature(this.longTest1, this.META_LongTest_setAttribute, LongAttributeTestCase.longSet1);
		this.adapter.setValueForFeature(this.longTest1, this.META_LongTest_bagAttribute, LongAttributeTestCase.longBag1);
		this.adapter.setValueForFeature(this.longTest1, this.META_LongTest_orderedSetAttribute, LongAttributeTestCase.longOrderedSet1);
		this.adapter.setValueForFeature(this.longTest1, this.META_LongTest_sequenceAttribute, LongAttributeTestCase.longSequence1);

		this.longTest2 = this.adapter.createModelElement(this.META_LongTest);
		this.adapter.setValueForFeature(this.longTest2, this.META_LongTest_simpleAttribute, LongAttributeTestCase.longSimple2);
		this.adapter.setValueForFeature(this.longTest2, this.META_LongTest_optionalSimpleAttribute, LongAttributeTestCase.longOptionalSimple2);
		this.adapter.setValueForFeature(this.longTest2, this.META_LongTest_setAttribute, LongAttributeTestCase.longSet2);
		this.adapter.setValueForFeature(this.longTest2, this.META_LongTest_bagAttribute, LongAttributeTestCase.longBag2);
		this.adapter.setValueForFeature(this.longTest2, this.META_LongTest_orderedSetAttribute, LongAttributeTestCase.longOrderedSet2);
		this.adapter.setValueForFeature(this.longTest2, this.META_LongTest_sequenceAttribute, LongAttributeTestCase.longSequence2);

	}

	@Override
	protected void tearDown() throws Exception {
		this.adapter.delete(this.longTest1);
		this.adapter.delete(this.longTest2);
		super.tearDown();
	}

	Vector toLongVector(long[] doubleArray) {
		Vector result = new Vector();
		for (long element : doubleArray) {
			result.add(this.adapter.getNumber((int) element));
		}
		return result;
	}

}
