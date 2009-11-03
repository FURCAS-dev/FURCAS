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

public class StaticBooleanAttributeTestCase extends OclInterpreterTestCase {

	private static boolean booleanSimple1 = true;

	private static boolean booleanOptionalSimple1 = true;

	private static boolean[] booleanSet1 = new boolean[] { true, false };

	private static boolean[] booleanOrderedSet1 = new boolean[] { true, false };

	private static boolean[] booleanSequence1 = new boolean[] { true, false, true, false };

	private static boolean[] booleanBag1 = new boolean[] { true, false, true, false };

	private Object/* StaticBooleanTestClass */staticBooleanTestClass;

	public void testSimpleAttribute() throws Exception {
		if (!this.adapter.supportStaticFeatures()) {
			return;
		}
		List result = this.adapter.evaluate("TestMetaModel::PrimitiveTypesStaticTests::StaticBooleanTest::simpleAttribute");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(StaticBooleanAttributeTestCase.booleanSimple1, ((Boolean) result.get(0)).booleanValue());

	}

	public void testOptionalSimpleAttribute() throws Exception {
		if (!this.adapter.supportStaticFeatures()) {
			return;
		}
		List result = this.adapter.evaluate("TestMetaModel::PrimitiveTypesStaticTests::StaticBooleanTest::optionalSimpleAttribute ");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(StaticBooleanAttributeTestCase.booleanOptionalSimple1, ((Boolean) result.get(0)).booleanValue());

	}

	public void testBagAttribute() throws Exception {
		if (!this.adapter.supportStaticFeatures()) {
			return;
		}
		List result = this.adapter.evaluate("TestMetaModel::PrimitiveTypesStaticTests::StaticBooleanTest::bagAttribute ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Vector resultExpected = new Vector();
		resultExpected.add(new Boolean(true));
		resultExpected.add(new Boolean(false));
		Assert.assertEquals(StaticBooleanAttributeTestCase.booleanBag1.length, result1.size());
		Assert.assertTrue(result1.containsAll(new Vector(resultExpected)));

	}

	public void testSetAttribute() throws Exception {
		if (!this.adapter.supportStaticFeatures()) {
			return;
		}
		List result = this.adapter.evaluate("TestMetaModel::PrimitiveTypesStaticTests::StaticBooleanTest::setAttribute ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Vector resultExpected = new Vector();
		resultExpected.add(new Boolean(true));
		resultExpected.add(new Boolean(false));
		Assert.assertEquals(StaticBooleanAttributeTestCase.booleanSet1.length, result1.size());
		Assert.assertTrue(result1.containsAll(new Vector(resultExpected)));
	}

	public void testOrderedSetAttribute() throws Exception {
		if (!this.adapter.supportStaticFeatures()) {
			return;
		}
		List result = this.adapter.evaluate("TestMetaModel::PrimitiveTypesStaticTests::StaticBooleanTest::orderedSetAttribute ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Vector resultExpected = new Vector();
		resultExpected.add(new Boolean(true));
		resultExpected.add(new Boolean(false));
		Assert.assertEquals(StaticBooleanAttributeTestCase.booleanOrderedSet1.length, result1.size());
		Assert.assertTrue(result1.containsAll(new Vector(resultExpected)));
	}

	public void testSequenceAttribute() throws Exception {
		if (!this.adapter.supportStaticFeatures()) {
			return;
		}
		List result = this.adapter.evaluate("TestMetaModel::PrimitiveTypesStaticTests::StaticBooleanTest::sequenceAttribute ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Vector resultExpected = new Vector();
		resultExpected.add(new Boolean(true));
		resultExpected.add(new Boolean(false));
		Assert.assertEquals(StaticBooleanAttributeTestCase.booleanSequence1.length, result1.size());
		Assert.assertTrue(result1.containsAll(new Vector(resultExpected)));
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		this.adapter.setValueForStaticFeature(this.META_StaticBooleanTest, this.META_StaticBooleanTest_simpleAttribute, new Boolean(StaticBooleanAttributeTestCase.booleanSimple1));
		this.adapter.setValueForStaticFeature(this.META_StaticBooleanTest, this.META_StaticBooleanTest_optionalSimpleAttribute, new Boolean(StaticBooleanAttributeTestCase.booleanOptionalSimple1));
		this.adapter.setValueForStaticFeature(this.META_StaticBooleanTest, this.META_StaticBooleanTest_setAttribute, StaticBooleanAttributeTestCase.booleanSet1);
		this.adapter.setValueForStaticFeature(this.META_StaticBooleanTest, this.META_StaticBooleanTest_bagAttribute, StaticBooleanAttributeTestCase.booleanBag1);
		this.adapter.setValueForStaticFeature(this.META_StaticBooleanTest, this.META_StaticBooleanTest_orderedSetAttribute, StaticBooleanAttributeTestCase.booleanOrderedSet1);
		this.adapter.setValueForStaticFeature(this.META_StaticBooleanTest, this.META_StaticBooleanTest_sequenceAttribute, StaticBooleanAttributeTestCase.booleanSequence1);

	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
