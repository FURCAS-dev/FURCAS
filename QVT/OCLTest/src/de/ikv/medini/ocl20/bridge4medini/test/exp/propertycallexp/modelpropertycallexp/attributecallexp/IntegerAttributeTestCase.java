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

public class IntegerAttributeTestCase extends OclInterpreterTestCase {

	private static int intSimple1 = 1;

	private static int intOptionalSimple1 = 2;

	private static int[] intSet1 = new int[] { 1, 2 };

	private static int[] intOrderedSet1 = new int[] { 3, 2 };

	private static int[] intSequence1 = new int[] { 3, 2, 1, 1 };

	private static int[] intBag1 = new int[] { 2, 2, 2, 3 };

	private static int intSimple2 = -1;

	private static int intOptionalSimple2 = -3;

	private static int[] intSet2 = new int[] {};

	private static int[] intOrderedSet2 = new int[] {};

	private static int[] intSequence2 = new int[] {};

	private static int[] intBag2 = new int[] {};

	private Object/* IntegerTest */intTest1;

	private Object/* IntegerTest */intTest2;

	public void testSimpleAttribute() throws Exception {
		List result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::IntegerTest inv: self.simpleAttribute ", this.intTest1);
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(IntegerAttributeTestCase.intSimple1, ((Number) result.get(0)).longValue());

		result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::IntegerTest inv: self.simpleAttribute ", this.intTest2);
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(IntegerAttributeTestCase.intSimple2, ((Number) result.get(0)).longValue());
	}

	public void testOptionalSimpleAttribute() throws Exception {
		List result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::IntegerTest inv: self.optionalSimpleAttribute ", this.intTest1);
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(IntegerAttributeTestCase.intOptionalSimple1, ((Number) result.get(0)).longValue());

		result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::IntegerTest inv: self.optionalSimpleAttribute ", this.intTest2);
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(IntegerAttributeTestCase.intOptionalSimple2, ((Number) result.get(0)).longValue());
	}

	public void testBagAttribute() throws Exception {
		List result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::IntegerTest inv: self.bagAttribute ", this.intTest1);
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(IntegerAttributeTestCase.intBag1.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toLongVector(IntegerAttributeTestCase.intBag1)));

		result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::IntegerTest inv: self.bagAttribute ", this.intTest2);
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		Assert.assertEquals(IntegerAttributeTestCase.intBag2.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toLongVector(IntegerAttributeTestCase.intBag2)));

	}

	public void testSetAttribute() throws Exception {
		List result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::IntegerTest inv: self.setAttribute ", this.intTest1);
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(IntegerAttributeTestCase.intSet1.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toLongVector(IntegerAttributeTestCase.intSet1)));

		result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::IntegerTest inv: self.setAttribute ", this.intTest2);
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		Assert.assertEquals(IntegerAttributeTestCase.intSet2.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toLongVector(IntegerAttributeTestCase.intSet2)));
	}

	public void testOrderedSetAttribute() throws Exception {
		List result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::IntegerTest inv: self.orderedSetAttribute ", this.intTest1);
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(IntegerAttributeTestCase.intOrderedSet1.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toLongVector(IntegerAttributeTestCase.intOrderedSet1)));

		result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::IntegerTest inv: self.orderedSetAttribute ", this.intTest2);
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		Assert.assertEquals(IntegerAttributeTestCase.intOrderedSet2.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toLongVector(IntegerAttributeTestCase.intOrderedSet2)));
	}

	public void testSequenceAttribute() throws Exception {
		List result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::IntegerTest inv: self.sequenceAttribute ", this.intTest1);
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(IntegerAttributeTestCase.intSequence1.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toLongVector(IntegerAttributeTestCase.intSequence1)));

		result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::IntegerTest inv: self.sequenceAttribute ", this.intTest2);
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		Assert.assertEquals(IntegerAttributeTestCase.intSequence2.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toLongVector(IntegerAttributeTestCase.intSequence2)));
	}

	@Override
	protected void setUp() throws Exception {

		super.setUp();

		this.intTest1 = this.adapter.createModelElement(this.META_IntegerTest);
		this.adapter.setValueForFeature(this.intTest1, this.META_IntegerTest_simpleAttribute, IntegerAttributeTestCase.intSimple1);
		this.adapter.setValueForFeature(this.intTest1, this.META_IntegerTest_optionalSimpleAttribute, IntegerAttributeTestCase.intOptionalSimple1);
		this.adapter.setValueForFeature(this.intTest1, this.META_IntegerTest_setAttribute, IntegerAttributeTestCase.intSet1);
		this.adapter.setValueForFeature(this.intTest1, this.META_IntegerTest_bagAttribute, IntegerAttributeTestCase.intBag1);
		this.adapter.setValueForFeature(this.intTest1, this.META_IntegerTest_orderedSetAttribute, IntegerAttributeTestCase.intOrderedSet1);
		this.adapter.setValueForFeature(this.intTest1, this.META_IntegerTest_sequenceAttribute, IntegerAttributeTestCase.intSequence1);

		this.intTest2 = this.adapter.createModelElement(this.META_IntegerTest);
		this.adapter.setValueForFeature(this.intTest2, this.META_IntegerTest_simpleAttribute, IntegerAttributeTestCase.intSimple2);
		this.adapter.setValueForFeature(this.intTest2, this.META_IntegerTest_optionalSimpleAttribute, IntegerAttributeTestCase.intOptionalSimple2);
		this.adapter.setValueForFeature(this.intTest2, this.META_IntegerTest_setAttribute, IntegerAttributeTestCase.intSet2);
		this.adapter.setValueForFeature(this.intTest2, this.META_IntegerTest_bagAttribute, IntegerAttributeTestCase.intBag2);
		this.adapter.setValueForFeature(this.intTest2, this.META_IntegerTest_orderedSetAttribute, IntegerAttributeTestCase.intOrderedSet2);
		this.adapter.setValueForFeature(this.intTest2, this.META_IntegerTest_sequenceAttribute, IntegerAttributeTestCase.intSequence2);

	}

	@Override
	protected void tearDown() throws Exception {
		this.adapter.delete(this.intTest1);
		this.adapter.delete(this.intTest2);
		super.tearDown();
	}

	Vector toLongVector(int[] doubleArray) {
		Vector result = new Vector();
		for (int element : doubleArray) {
			result.add(this.adapter.getNumber(element));
		}
		return result;
	}

}
