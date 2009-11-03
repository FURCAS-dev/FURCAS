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

public class StaticDoubleAttributeTestCase extends OclInterpreterTestCase {

	private static double doubleSimple1 = 1.2;

	private static double doubleOptionalSimple1 = 1.3;

	private static double[] doubleSet1 = new double[] { 1.2, 1.3 };

	private static double[] doubleOrderedSet1 = new double[] { 1.3, 1.2 };

	private static double[] doubleSequence1 = new double[] { 1.3, 1.2, 1.3, 1.2 };

	private static double[] doubleBag1 = new double[] { 1.2, 1.3, 1.2, 1.3 };

	private Object/* StaticDoubleTestClass */staticDoubleTestClass;

	public void testSimpleAttribute() throws Exception {
		if (!this.adapter.supportStaticFeatures()) {
			return;
		}
		// TODO luckup List result = null;
		// try {
		// result = adapter.evaluate("context TestMetaModel::PrimitiveTypesStaticTests::StaticDoubleTest inv: StaticDoubleTest::simpleAttribute = 0");
		//			
		// } catch (OclException e) {
		// fail(e.message + "\n" + e.stackTrace);
		// }
		List result = this.adapter.evaluate("TestMetaModel::PrimitiveTypesStaticTests::StaticDoubleTest::simpleAttribute");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(StaticDoubleAttributeTestCase.doubleSimple1, ((Double) result.get(0)).doubleValue(), 0);
	}

	public void testOptionalSimpleAttribute() throws Exception {
		if (!this.adapter.supportStaticFeatures()) {
			return;
		}
		List result = this.adapter.evaluate("TestMetaModel::PrimitiveTypesStaticTests::StaticDoubleTest::optionalSimpleAttribute ");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(StaticDoubleAttributeTestCase.doubleOptionalSimple1, ((Double) result.get(0)).doubleValue(), 0);
	}

	public void testBagAttribute() throws Exception {
		if (!this.adapter.supportStaticFeatures()) {
			return;
		}
		List result = this.adapter.evaluate("TestMetaModel::PrimitiveTypesStaticTests::StaticDoubleTest::bagAttribute ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(StaticDoubleAttributeTestCase.doubleBag1.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toDoubleVector(StaticDoubleAttributeTestCase.doubleBag1)));
	}

	public void testSetAttribute() throws Exception {
		if (!this.adapter.supportStaticFeatures()) {
			return;
		}
		List result = this.adapter.evaluate("TestMetaModel::PrimitiveTypesStaticTests::StaticDoubleTest::setAttribute ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(StaticDoubleAttributeTestCase.doubleSet1.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toDoubleVector(StaticDoubleAttributeTestCase.doubleSet1)));
	}

	public void testOrderedSetAttribute() throws Exception {
		if (!this.adapter.supportStaticFeatures()) {
			return;
		}
		List result = this.adapter.evaluate("TestMetaModel::PrimitiveTypesStaticTests::StaticDoubleTest::orderedSetAttribute ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(StaticDoubleAttributeTestCase.doubleOrderedSet1.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toDoubleVector(StaticDoubleAttributeTestCase.doubleOrderedSet1)));
	}

	public void testSequenceAttribute() throws Exception {
		if (!this.adapter.supportStaticFeatures()) {
			return;
		}
		List result = this.adapter.evaluate("TestMetaModel::PrimitiveTypesStaticTests::StaticDoubleTest::sequenceAttribute ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(StaticDoubleAttributeTestCase.doubleSequence1.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toDoubleVector(StaticDoubleAttributeTestCase.doubleSequence1)));
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.adapter.setValueForStaticFeature(this.META_StaticDoubleTest, this.META_StaticDoubleTest_simpleAttribute, StaticDoubleAttributeTestCase.doubleSimple1);
		this.adapter.setValueForStaticFeature(this.META_StaticDoubleTest, this.META_StaticDoubleTest_optionalSimpleAttribute, StaticDoubleAttributeTestCase.doubleOptionalSimple1);
		this.adapter.setValueForStaticFeature(this.META_StaticDoubleTest, this.META_StaticDoubleTest_setAttribute, StaticDoubleAttributeTestCase.doubleSet1);
		this.adapter.setValueForStaticFeature(this.META_StaticDoubleTest, this.META_StaticDoubleTest_bagAttribute, StaticDoubleAttributeTestCase.doubleBag1);
		this.adapter.setValueForStaticFeature(this.META_StaticDoubleTest, this.META_StaticDoubleTest_orderedSetAttribute, StaticDoubleAttributeTestCase.doubleOrderedSet1);
		this.adapter.setValueForStaticFeature(this.META_StaticDoubleTest, this.META_StaticDoubleTest_sequenceAttribute, StaticDoubleAttributeTestCase.doubleSequence1);
	}

	@Override
	protected void tearDown() throws Exception {
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
