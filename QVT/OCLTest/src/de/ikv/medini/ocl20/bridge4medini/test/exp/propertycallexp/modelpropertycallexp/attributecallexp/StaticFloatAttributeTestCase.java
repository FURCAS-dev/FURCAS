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

public class StaticFloatAttributeTestCase extends OclInterpreterTestCase {

	private static float floatSimple1 = 1.25f;

	private static float floatOptionalSimple1 = 1.5f;

	private static float[] floatSet1 = new float[] { 1.2f, 1.3f };

	private static float[] floatOrderedSet1 = new float[] { 1.3f, 1.2f };

	private static float[] floatSequence1 = new float[] { 1.3f, 1.2f, 1.3f, 1.2f };

	private static float[] floatBag1 = new float[] { 1.2f, 1.3f, 1.2f, 1.3f };

	private Object/* StaticFloatTestClass */staticFloatTestClass;

	public void testSimpleAttribute() throws Exception {
		if (!this.adapter.supportStaticFeatures()) {
			return;
		}
		List result = this.adapter.evaluate("TestMetaModel::PrimitiveTypesStaticTests::StaticFloatTest::simpleAttribute");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(StaticFloatAttributeTestCase.floatSimple1, ((Double) result.get(0)).doubleValue(), 0);
	}

	public void testOptionalSimpleAttribute() throws Exception {
		if (!this.adapter.supportStaticFeatures()) {
			return;
		}
		List result = this.adapter.evaluate("TestMetaModel::PrimitiveTypesStaticTests::StaticFloatTest::optionalSimpleAttribute ");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(StaticFloatAttributeTestCase.floatOptionalSimple1, ((Double) result.get(0)).doubleValue(), 0);
	}

	public void testBagAttribute() throws Exception {
		if (!this.adapter.supportStaticFeatures()) {
			return;
		}
		List result = this.adapter.evaluate("TestMetaModel::PrimitiveTypesStaticTests::StaticFloatTest::bagAttribute ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(StaticFloatAttributeTestCase.floatBag1.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toDoubleVector(StaticFloatAttributeTestCase.floatBag1)));
	}

	public void testSetAttribute() throws Exception {
		if (!this.adapter.supportStaticFeatures()) {
			return;
		}
		List result = this.adapter.evaluate("TestMetaModel::PrimitiveTypesStaticTests::StaticFloatTest::setAttribute ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(StaticFloatAttributeTestCase.floatSet1.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toDoubleVector(StaticFloatAttributeTestCase.floatSet1)));
	}

	public void testOrderedSetAttribute() throws Exception {
		if (!this.adapter.supportStaticFeatures()) {
			return;
		}
		List result = this.adapter.evaluate("TestMetaModel::PrimitiveTypesStaticTests::StaticFloatTest::orderedSetAttribute ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(StaticFloatAttributeTestCase.floatOrderedSet1.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toDoubleVector(StaticFloatAttributeTestCase.floatOrderedSet1)));
	}

	public void testSequenceAttribute() throws Exception {
		if (!this.adapter.supportStaticFeatures()) {
			return;
		}
		List result = this.adapter.evaluate("TestMetaModel::PrimitiveTypesStaticTests::StaticFloatTest::sequenceAttribute ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(StaticFloatAttributeTestCase.floatSequence1.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toDoubleVector(StaticFloatAttributeTestCase.floatSequence1)));
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		this.adapter.setValueForStaticFeature(this.META_StaticFloatTest, this.META_StaticFloatTest_simpleAttribute, new Float(StaticFloatAttributeTestCase.floatSimple1));
		this.adapter.setValueForStaticFeature(this.META_StaticFloatTest, this.META_StaticFloatTest_optionalSimpleAttribute, new Float(StaticFloatAttributeTestCase.floatOptionalSimple1));
		this.adapter.setValueForStaticFeature(this.META_StaticFloatTest, this.META_StaticFloatTest_setAttribute, StaticFloatAttributeTestCase.floatSet1);
		this.adapter.setValueForStaticFeature(this.META_StaticFloatTest, this.META_StaticFloatTest_bagAttribute, StaticFloatAttributeTestCase.floatBag1);
		this.adapter.setValueForStaticFeature(this.META_StaticFloatTest, this.META_StaticFloatTest_orderedSetAttribute, StaticFloatAttributeTestCase.floatOrderedSet1);
		this.adapter.setValueForStaticFeature(this.META_StaticFloatTest, this.META_StaticFloatTest_sequenceAttribute, StaticFloatAttributeTestCase.floatSequence1);

	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	Vector toDoubleVector(float[] floatArray) {
		Vector result = new Vector();
		for (float element : floatArray) {
			result.add(new Double(element));
		}
		return result;
	}

}
