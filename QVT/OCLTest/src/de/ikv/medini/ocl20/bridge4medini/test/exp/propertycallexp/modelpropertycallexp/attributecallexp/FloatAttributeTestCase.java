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

public class FloatAttributeTestCase extends OclInterpreterTestCase {

	private static float floatSimple1 = 1.2f;

	private static float floatOptionalSimple1 = 1.3f;

	private static float[] floatSet1 = new float[] { 1.2f, 1.3f };

	private static float[] floatOrderedSet1 = new float[] { 1.3f, 1.2f };

	private static float[] floatSequence1 = new float[] { 1.3f, 1.2f, 1.3f, 1.2f };

	private static float[] floatBag1 = new float[] { 1.2f, 1.3f, 1.2f, 1.3f };

	private static float floatSimple2 = -1.2f;

	private static float floatOptionalSimple2 = -1.3f;

	private static float[] floatSet2 = new float[] {};

	private static float[] floatOrderedSet2 = new float[] {};

	private static float[] floatSequence2 = new float[] {};

	private static float[] floatBag2 = new float[] {};

	private Object/* FloatTest */floatTest1;

	private Object/* FloatTest */floatTest2;

	public void testSimpleAttribute() throws Exception {
		List result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::FloatTest inv: self.simpleAttribute ", this.floatTest1);
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(FloatAttributeTestCase.floatSimple1, ((Double) result.get(0)).doubleValue(), 0);

		result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::FloatTest inv: self.simpleAttribute ", this.floatTest2);
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(FloatAttributeTestCase.floatSimple2, ((Double) result.get(0)).doubleValue(), 0);
	}

	public void testOptionalSimpleAttribute() throws Exception {
		List result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::FloatTest inv: self.optionalSimpleAttribute ", this.floatTest1);
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(FloatAttributeTestCase.floatOptionalSimple1, ((Double) result.get(0)).doubleValue(), 0);

		result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::FloatTest inv: self.optionalSimpleAttribute ", this.floatTest2);
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(FloatAttributeTestCase.floatOptionalSimple2, ((Double) result.get(0)).doubleValue(), 0);
	}

	public void testBagAttribute() throws Exception {
		List result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::FloatTest inv: self.bagAttribute ", this.floatTest1);
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(FloatAttributeTestCase.floatBag1.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toDoubleVector(FloatAttributeTestCase.floatBag1)));

		result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::FloatTest inv: self.bagAttribute ", this.floatTest2);
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		Assert.assertEquals(FloatAttributeTestCase.floatBag2.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toDoubleVector(FloatAttributeTestCase.floatBag2)));

	}

	public void testSetAttribute() throws Exception {
		List result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::FloatTest inv: self.setAttribute ", this.floatTest1);
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(FloatAttributeTestCase.floatSet1.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toDoubleVector(FloatAttributeTestCase.floatSet1)));

		result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::FloatTest inv: self.setAttribute ", this.floatTest2);
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		Assert.assertEquals(FloatAttributeTestCase.floatSet2.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toDoubleVector(FloatAttributeTestCase.floatSet2)));
	}

	public void testOrderedSetAttribute() throws Exception {
		List result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::FloatTest inv: self.orderedSetAttribute ", this.floatTest1);
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(FloatAttributeTestCase.floatOrderedSet1.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toDoubleVector(FloatAttributeTestCase.floatOrderedSet1)));

		result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::FloatTest inv: self.orderedSetAttribute ", this.floatTest2);
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		Assert.assertEquals(FloatAttributeTestCase.floatOrderedSet2.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toDoubleVector(FloatAttributeTestCase.floatOrderedSet2)));
	}

	public void testSequenceAttribute() throws Exception {
		List result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::FloatTest inv: self.sequenceAttribute ", this.floatTest1);
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(FloatAttributeTestCase.floatSequence1.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toDoubleVector(FloatAttributeTestCase.floatSequence1)));

		result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::FloatTest inv: self.sequenceAttribute ", this.floatTest2);
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		Assert.assertEquals(FloatAttributeTestCase.floatSequence2.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toDoubleVector(FloatAttributeTestCase.floatSequence2)));
	}

	@Override
	protected void setUp() throws Exception {

		super.setUp();

		this.floatTest1 = this.adapter.createModelElement(this.META_FloatTest);
		this.adapter.setValueForFeature(this.floatTest1, this.META_FloatTest_simpleAttribute, FloatAttributeTestCase.floatSimple1);
		this.adapter.setValueForFeature(this.floatTest1, this.META_FloatTest_optionalSimpleAttribute, FloatAttributeTestCase.floatOptionalSimple1);
		this.adapter.setValueForFeature(this.floatTest1, this.META_FloatTest_setAttribute, FloatAttributeTestCase.floatSet1);
		this.adapter.setValueForFeature(this.floatTest1, this.META_FloatTest_bagAttribute, FloatAttributeTestCase.floatBag1);
		this.adapter.setValueForFeature(this.floatTest1, this.META_FloatTest_orderedSetAttribute, FloatAttributeTestCase.floatOrderedSet1);
		this.adapter.setValueForFeature(this.floatTest1, this.META_FloatTest_sequenceAttribute, FloatAttributeTestCase.floatSequence1);

		this.floatTest2 = this.adapter.createModelElement(this.META_FloatTest);
		this.adapter.setValueForFeature(this.floatTest2, this.META_FloatTest_simpleAttribute, FloatAttributeTestCase.floatSimple2);
		this.adapter.setValueForFeature(this.floatTest2, this.META_FloatTest_optionalSimpleAttribute, FloatAttributeTestCase.floatOptionalSimple2);
		this.adapter.setValueForFeature(this.floatTest2, this.META_FloatTest_setAttribute, FloatAttributeTestCase.floatSet2);
		this.adapter.setValueForFeature(this.floatTest2, this.META_FloatTest_bagAttribute, FloatAttributeTestCase.floatBag2);
		this.adapter.setValueForFeature(this.floatTest2, this.META_FloatTest_orderedSetAttribute, FloatAttributeTestCase.floatOrderedSet2);
		this.adapter.setValueForFeature(this.floatTest2, this.META_FloatTest_sequenceAttribute, FloatAttributeTestCase.floatSequence2);

	}

	@Override
	protected void tearDown() throws Exception {
		this.adapter.delete(this.floatTest1);
		this.adapter.delete(this.floatTest2);
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
