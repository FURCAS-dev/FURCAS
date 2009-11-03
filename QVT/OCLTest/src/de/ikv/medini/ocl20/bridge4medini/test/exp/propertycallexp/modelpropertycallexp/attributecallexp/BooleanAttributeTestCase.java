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

import java.util.List;

import junit.framework.Assert;

import de.ikv.medini.ocl20.bridge4medini.test.OclInterpreterTestCase;

public class BooleanAttributeTestCase extends OclInterpreterTestCase {

	private static boolean booleanSimple1 = true;

	private static boolean booleanOptionalSimple1 = true;

	private static boolean[] booleanSet1 = new boolean[] { true, false };

	private static boolean[] booleanOrderedSet1 = new boolean[] { true, false };

	private static boolean[] booleanSequence1 = new boolean[] { true, false, true, false };

	private static boolean[] booleanBag1 = new boolean[] { true, false, true, false };

	private static boolean booleanSimple2 = false;

	private static boolean booleanOptionalSimple2 = false;

	private static boolean[] booleanSet2 = new boolean[] { false, true };

	private static boolean[] booleanOrderedSet2 = new boolean[] { false, true };

	private static boolean[] booleanSequence2 = new boolean[] { false, true, false, true };

	private static boolean[] booleanBag2 = new boolean[] { false, true, false, true };

	private/* BooleanTest */Object booleanTest1;

	private/* BooleanTest */Object booleanTest2;

	// TODO TODOMWA remove this

	public void testSimpleAttribute() throws Exception {

		List result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::BooleanTest inv: self.simpleAttribute = true", this.booleanTest1);
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(BooleanAttributeTestCase.booleanSimple1, ((Boolean) result.get(0)).booleanValue());

		// List result = adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::BooleanTest inv: self.simpleAttribute ", booleanTest1));
		// assertEquals(result.size(), 1);
		// assertEquals(booleanSimple1,((Boolean)result.get(0)).booleanValue());
		//
		// result = adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::BooleanTest inv: self.simpleAttribute ", booleanTest2));
		// assertEquals(result.size(), 1);
		// assertEquals(booleanSimple2,((Boolean)result.get(0)).booleanValue());
	}

	// public void testOptionalSimpleAttribute() throws Exception {
	// List result = adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::BooleanTest inv: self.optionalSimpleAttribute ", booleanTest1));
	// assertEquals(result.size(), 1);
	// assertEquals(booleanOptionalSimple1,((Boolean)result.get(0)).booleanValue());
	//
	// result = adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::BooleanTest inv: self.optionalSimpleAttribute ", booleanTest2));
	// assertEquals(result.size(), 1);
	// assertEquals(booleanOptionalSimple2,((Boolean)result.get(0)).booleanValue());
	// }
	//
	// public void testBagAttribute() throws Exception {
	// List result = adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::BooleanTest inv: self.bagAttribute ", booleanTest1));
	// assertEquals(result.size(), 1);
	// Collection result1 = (Collection)result.get(0);
	// Vector resultExpected = new Vector();
	// resultExpected.add(new Boolean(true));
	// resultExpected.add(new Boolean(false));
	// assertEquals(booleanBag1.length, result1.size());
	// assertTrue(result1.containsAll(new Vector(resultExpected)));
	//        
	// result = adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::BooleanTest inv: self.bagAttribute ", booleanTest2));
	// assertEquals(result.size(), 1);
	// result1 = (Collection)result.get(0);
	// resultExpected = new Vector();
	// resultExpected.add(new Boolean(true));
	// resultExpected.add(new Boolean(false));
	// assertEquals(booleanBag1.length, result1.size());
	// assertTrue(result1.containsAll(new Vector(resultExpected)));
	//
	// }
	//
	// public void testSetAttribute() throws Exception {
	// List result = adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::BooleanTest inv: self.setAttribute ", booleanTest1));
	// assertEquals(result.size(), 1);
	// Collection result1 = (Collection)result.get(0);
	// Vector resultExpected = new Vector();
	// resultExpected.add(new Boolean(true));
	// resultExpected.add(new Boolean(false));
	// assertEquals(booleanSet1.length, result1.size());
	// assertTrue(result1.containsAll(new Vector(resultExpected)));
	//
	// result = adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::BooleanTest inv: self.setAttribute ", booleanTest2));
	// assertEquals(result.size(), 1);
	// result1 = (Collection)result.get(0);
	// resultExpected = new Vector();
	// resultExpected.add(new Boolean(true));
	// resultExpected.add(new Boolean(false));
	// assertEquals(booleanSet2.length, result1.size());
	// assertTrue(result1.containsAll(new Vector(resultExpected)));
	// }
	//
	// public void testOrderedSetAttribute() throws Exception {
	// List result = adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::BooleanTest inv: self.orderedSetAttribute ", booleanTest1));
	// assertEquals(result.size(), 1);
	// Collection result1 = (Collection)result.get(0);
	// Vector resultExpected = new Vector();
	// resultExpected.add(new Boolean(true));
	// resultExpected.add(new Boolean(false));
	// assertEquals(booleanOrderedSet1.length, result1.size());
	// assertTrue(result1.containsAll(new Vector(resultExpected)));
	//
	// result = adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::BooleanTest inv: self.orderedSetAttribute ", booleanTest2));
	// assertEquals(result.size(), 1);
	// result1 = (Collection)result.get(0);
	// resultExpected = new Vector();
	// resultExpected.add(new Boolean(true));
	// resultExpected.add(new Boolean(false));
	// assertEquals(booleanOrderedSet2.length, result1.size());
	// assertTrue(result1.containsAll(new Vector(resultExpected)));
	// }
	//
	// public void testSequenceAttribute() throws Exception {
	// List result = adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::BooleanTest inv: self.sequenceAttribute ", booleanTest1));
	// assertEquals(result.size(), 1);
	// Collection result1 = (Collection)result.get(0);
	// Vector resultExpected = new Vector();
	// resultExpected.add(new Boolean(true));
	// resultExpected.add(new Boolean(false));
	// assertEquals(booleanSequence1.length, result1.size());
	// assertTrue(result1.containsAll(new Vector(resultExpected)));
	//
	// result = adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::BooleanTest inv: self.sequenceAttribute ", booleanTest2));
	// assertEquals(result.size(), 1);
	// result1 = (Collection)result.get(0);
	// resultExpected = new Vector();
	// resultExpected.add(new Boolean(true));
	// resultExpected.add(new Boolean(false));
	// assertEquals(booleanSequence2.length, result1.size());
	// assertTrue(result1.containsAll(new Vector(resultExpected)));
	// }

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		this.booleanTest1 = this.adapter.createModelElement(this.META_BooleanTest);
		this.adapter.setValueForFeature(this.booleanTest1, this.META_BooleanTest_simpleAttribute, new Boolean(BooleanAttributeTestCase.booleanSimple1));
		this.adapter.setValueForFeature(this.booleanTest1, this.META_BooleanTest_optionalSimpleAttribute, new Boolean(BooleanAttributeTestCase.booleanOptionalSimple1));
		this.adapter.setValueForFeature(this.booleanTest1, this.META_BooleanTest_setAttribute, BooleanAttributeTestCase.booleanSet1);
		this.adapter.setValueForFeature(this.booleanTest1, this.META_BooleanTest_bagAttribute, BooleanAttributeTestCase.booleanBag1);
		this.adapter.setValueForFeature(this.booleanTest1, this.META_BooleanTest_orderedSetAttribute, BooleanAttributeTestCase.booleanOrderedSet1);
		this.adapter.setValueForFeature(this.booleanTest1, this.META_BooleanTest_sequenceAttribute, BooleanAttributeTestCase.booleanSequence1);

		this.booleanTest2 = this.adapter.createModelElement(this.META_BooleanTest);
		this.adapter.setValueForFeature(this.booleanTest2, this.META_BooleanTest_simpleAttribute, new Boolean(BooleanAttributeTestCase.booleanSimple2));
		this.adapter.setValueForFeature(this.booleanTest2, this.META_BooleanTest_optionalSimpleAttribute, new Boolean(BooleanAttributeTestCase.booleanOptionalSimple2));
		this.adapter.setValueForFeature(this.booleanTest2, this.META_BooleanTest_setAttribute, BooleanAttributeTestCase.booleanSet2);
		this.adapter.setValueForFeature(this.booleanTest2, this.META_BooleanTest_bagAttribute, BooleanAttributeTestCase.booleanBag2);
		this.adapter.setValueForFeature(this.booleanTest2, this.META_BooleanTest_orderedSetAttribute, BooleanAttributeTestCase.booleanOrderedSet2);
		this.adapter.setValueForFeature(this.booleanTest2, this.META_BooleanTest_sequenceAttribute, BooleanAttributeTestCase.booleanSequence2);

	}

	@Override
	protected void tearDown() throws Exception {
		this.adapter.delete(this.booleanTest1);
		this.adapter.delete(this.booleanTest2);
		super.tearDown();
	}
}
