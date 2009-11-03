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

public class DoubleAttributeTestCase extends OclInterpreterTestCase {

	private static double doubleSimple1 = 1.2;

	private static double doubleOptionalSimple1 = 1.3;

	private static double[] doubleSet1 = new double[] { 1.2, 1.3 };

	private static double[] doubleOrderedSet1 = new double[] { 1.3, 1.2 };

	private static double[] doubleSequence1 = new double[] { 1.3, 1.2, 1.3, 1.2 };

	private static double[] doubleBag1 = new double[] { 1.2, 1.3, 1.2, 1.3 };

	private static double doubleSimple2 = -1.2;

	private static double doubleOptionalSimple2 = -1.3;

	private static double[] doubleSet2 = new double[] {};

	private static double[] doubleOrderedSet2 = new double[] {};

	private static double[] doubleSequence2 = new double[] {};

	private static double[] doubleBag2 = new double[] {};

	private Object/* DoubleTest */doubleTest1;

	private Object/* DoubleTest */doubleTest2;

	public void testSimpleAttribute() throws Exception {
		List result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::DoubleTest inv: self.simpleAttribute ", this.doubleTest1);
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(DoubleAttributeTestCase.doubleSimple1, ((Double) result.get(0)).doubleValue(), 0);

		result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::DoubleTest inv: self.simpleAttribute ", this.doubleTest2);
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(DoubleAttributeTestCase.doubleSimple2, ((Double) result.get(0)).doubleValue(), 0);
	}

	public void testOptionalSimpleAttribute() throws Exception {
		List result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::DoubleTest inv: self.optionalSimpleAttribute ", this.doubleTest1);
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(DoubleAttributeTestCase.doubleOptionalSimple1, ((Double) result.get(0)).doubleValue(), 0);

		result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::DoubleTest inv: self.optionalSimpleAttribute ", this.doubleTest2);
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(DoubleAttributeTestCase.doubleOptionalSimple2, ((Double) result.get(0)).doubleValue(), 0);
	}

	public void testBagAttribute() throws Exception {
		List result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::DoubleTest inv: self.bagAttribute ", this.doubleTest1);
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(DoubleAttributeTestCase.doubleBag1.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toDoubleVector(DoubleAttributeTestCase.doubleBag1)));

		result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::DoubleTest inv: self.bagAttribute ", this.doubleTest2);
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		Assert.assertEquals(DoubleAttributeTestCase.doubleBag2.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toDoubleVector(DoubleAttributeTestCase.doubleBag2)));

	}

	public void testSetAttribute() throws Exception {
		List result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::DoubleTest inv: self.setAttribute ", this.doubleTest1);
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(DoubleAttributeTestCase.doubleSet1.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toDoubleVector(DoubleAttributeTestCase.doubleSet1)));

		result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::DoubleTest inv: self.setAttribute ", this.doubleTest2);
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		Assert.assertEquals(DoubleAttributeTestCase.doubleSet2.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toDoubleVector(DoubleAttributeTestCase.doubleSet2)));
	}

	public void testOrderedSetAttribute() throws Exception {
		List result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::DoubleTest inv: self.orderedSetAttribute ", this.doubleTest1);
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(DoubleAttributeTestCase.doubleOrderedSet1.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toDoubleVector(DoubleAttributeTestCase.doubleOrderedSet1)));

		result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::DoubleTest inv: self.orderedSetAttribute ", this.doubleTest2);
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		Assert.assertEquals(DoubleAttributeTestCase.doubleOrderedSet2.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toDoubleVector(DoubleAttributeTestCase.doubleOrderedSet2)));
	}

	public void testSequenceAttribute() throws Exception {
		List result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::DoubleTest inv: self.sequenceAttribute ", this.doubleTest1);
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(DoubleAttributeTestCase.doubleSequence1.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toDoubleVector(DoubleAttributeTestCase.doubleSequence1)));

		result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::DoubleTest inv: self.sequenceAttribute ", this.doubleTest2);
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		Assert.assertEquals(DoubleAttributeTestCase.doubleSequence2.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toDoubleVector(DoubleAttributeTestCase.doubleSequence2)));
	}

	@Override
	protected void setUp() throws Exception {

		super.setUp();

		this.doubleTest1 = this.adapter.createModelElement(this.META_DoubleTest);
		this.adapter.setValueForFeature(this.doubleTest1, this.META_DoubleTest_simpleAttribute, DoubleAttributeTestCase.doubleSimple1);
		this.adapter.setValueForFeature(this.doubleTest1, this.META_DoubleTest_optionalSimpleAttribute, DoubleAttributeTestCase.doubleOptionalSimple1);
		this.adapter.setValueForFeature(this.doubleTest1, this.META_DoubleTest_setAttribute, DoubleAttributeTestCase.doubleSet1);
		this.adapter.setValueForFeature(this.doubleTest1, this.META_DoubleTest_bagAttribute, DoubleAttributeTestCase.doubleBag1);
		this.adapter.setValueForFeature(this.doubleTest1, this.META_DoubleTest_orderedSetAttribute, DoubleAttributeTestCase.doubleOrderedSet1);
		this.adapter.setValueForFeature(this.doubleTest1, this.META_DoubleTest_sequenceAttribute, DoubleAttributeTestCase.doubleSequence1);

		this.doubleTest2 = this.adapter.createModelElement(this.META_DoubleTest);
		this.adapter.setValueForFeature(this.doubleTest2, this.META_DoubleTest_simpleAttribute, DoubleAttributeTestCase.doubleSimple2);
		this.adapter.setValueForFeature(this.doubleTest2, this.META_DoubleTest_optionalSimpleAttribute, DoubleAttributeTestCase.doubleOptionalSimple2);
		this.adapter.setValueForFeature(this.doubleTest2, this.META_DoubleTest_setAttribute, DoubleAttributeTestCase.doubleSet2);
		this.adapter.setValueForFeature(this.doubleTest2, this.META_DoubleTest_bagAttribute, DoubleAttributeTestCase.doubleBag2);
		this.adapter.setValueForFeature(this.doubleTest2, this.META_DoubleTest_orderedSetAttribute, DoubleAttributeTestCase.doubleOrderedSet2);
		this.adapter.setValueForFeature(this.doubleTest2, this.META_DoubleTest_sequenceAttribute, DoubleAttributeTestCase.doubleSequence2);

	}

	@Override
	protected void tearDown() throws Exception {
		this.adapter.delete(this.doubleTest1);
		this.adapter.delete(this.doubleTest2);
		super.tearDown();
	}

	Vector toDoubleVector(double[] doubleArray) {
		Vector result = new Vector();
		for (double element : doubleArray) {
			result.add(new Double(element));
		}
		return result;
	}

}
