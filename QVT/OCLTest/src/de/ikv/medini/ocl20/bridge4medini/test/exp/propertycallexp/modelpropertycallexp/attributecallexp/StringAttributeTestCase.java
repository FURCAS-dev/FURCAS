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

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import junit.framework.Assert;
import de.ikv.medini.ocl20.bridge4medini.test.OclInterpreterTestCase;

public class StringAttributeTestCase extends OclInterpreterTestCase {

	private static String stringSimple1 = "test1";

	private static String stringOptionalSimple1 = "test2";

	private static String[] stringSet1 = new String[] { "test1", "test2" };

	private static String[] stringOrderedSet1 = new String[] { "test1", "test2" };

	private static String[] stringSequence1 = new String[] { "test1", "test2", "test1", "test2" };

	private static String[] stringBag1 = new String[] { "test2", "test2" };

	private static String stringSimple2 = "test3";

	private static String stringOptionalSimple2 = "test4";

	private static String[] stringSet2 = new String[] {};

	private static String[] stringOrderedSet2 = new String[] {};

	private static String[] stringSequence2 = new String[] {};

	private static String[] stringBag2 = new String[] {};

	private Object/* StringTest */stringTest1;

	private Object/* StringTest */stringTest2;

	public void testSimpleAttribute() throws Exception {
		List result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::StringTest inv: self.simpleAttribute ", this.stringTest1);
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(StringAttributeTestCase.stringSimple1, ((String) result.get(0)));

		result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::StringTest inv: self.simpleAttribute ", this.stringTest2);
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(StringAttributeTestCase.stringSimple2, ((String) result.get(0)));
	}

	public void testOptionalSimpleAttribute() throws Exception {
		List result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::StringTest inv: self.optionalSimpleAttribute ", this.stringTest1);
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(StringAttributeTestCase.stringOptionalSimple1, ((String) result.get(0)));

		result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::StringTest inv: self.optionalSimpleAttribute ", this.stringTest2);
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(StringAttributeTestCase.stringOptionalSimple2, ((String) result.get(0)));
	}

	public void testBagAttribute() throws Exception {
		List result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::StringTest inv: self.bagAttribute ", this.stringTest1);
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(StringAttributeTestCase.stringBag1.length, result1.size());
		Assert.assertTrue(result1.containsAll(Arrays.asList(StringAttributeTestCase.stringBag1)));

		result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::StringTest inv: self.bagAttribute ", this.stringTest2);
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		Assert.assertEquals(StringAttributeTestCase.stringBag2.length, result1.size());
		Assert.assertTrue(result1.containsAll(Arrays.asList(StringAttributeTestCase.stringBag2)));

	}

	public void testSetAttribute() throws Exception {
		List result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::StringTest inv: self.setAttribute ", this.stringTest1);
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(StringAttributeTestCase.stringSet1.length, result1.size());
		Assert.assertTrue(result1.containsAll(Arrays.asList(StringAttributeTestCase.stringSet1)));

		result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::StringTest inv: self.setAttribute ", this.stringTest2);
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		Assert.assertEquals(StringAttributeTestCase.stringSet2.length, result1.size());
		Assert.assertTrue(result1.containsAll(Arrays.asList(StringAttributeTestCase.stringSet2)));
	}

	public void testOrderedSetAttribute() throws Exception {
		List result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::StringTest inv: self.orderedSetAttribute ", this.stringTest1);
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(StringAttributeTestCase.stringOrderedSet1.length, result1.size());
		Assert.assertTrue(result1.containsAll(Arrays.asList(StringAttributeTestCase.stringOrderedSet1)));

		result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::StringTest inv: self.orderedSetAttribute ", this.stringTest2);
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		Assert.assertEquals(StringAttributeTestCase.stringOrderedSet2.length, result1.size());
		Assert.assertTrue(result1.containsAll(Arrays.asList(StringAttributeTestCase.stringOrderedSet2)));
	}

	public void testSequenceAttribute() throws Exception {
		List result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::StringTest inv: self.sequenceAttribute ", this.stringTest1);
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(StringAttributeTestCase.stringSequence1.length, result1.size());
		Assert.assertTrue(result1.containsAll(Arrays.asList(StringAttributeTestCase.stringSequence1)));

		result = this.adapter.evaluate("context TestMetaModel::PrimitiveTypesTests::StringTest inv: self.sequenceAttribute ", this.stringTest2);
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		Assert.assertEquals(StringAttributeTestCase.stringSequence2.length, result1.size());
		Assert.assertTrue(result1.containsAll(Arrays.asList(StringAttributeTestCase.stringSequence2)));
	}

	@Override
	protected void setUp() throws Exception {

		super.setUp();

		this.stringTest1 = this.adapter.createModelElement(this.META_StringTest);
		this.adapter.setValueForFeature(this.stringTest1, this.META_StringTest_simpleAttribute, StringAttributeTestCase.stringSimple1);
		this.adapter.setValueForFeature(this.stringTest1, this.META_StringTest_optionalSimpleAttribute, StringAttributeTestCase.stringOptionalSimple1);
		this.adapter.setValueForFeature(this.stringTest1, this.META_StringTest_setAttribute, StringAttributeTestCase.stringSet1);
		this.adapter.setValueForFeature(this.stringTest1, this.META_StringTest_bagAttribute, StringAttributeTestCase.stringBag1);
		this.adapter.setValueForFeature(this.stringTest1, this.META_StringTest_orderedSetAttribute, StringAttributeTestCase.stringOrderedSet1);
		this.adapter.setValueForFeature(this.stringTest1, this.META_StringTest_sequenceAttribute, StringAttributeTestCase.stringSequence1);

		this.stringTest2 = this.adapter.createModelElement(this.META_StringTest);
		this.adapter.setValueForFeature(this.stringTest2, this.META_StringTest_simpleAttribute, StringAttributeTestCase.stringSimple2);
		this.adapter.setValueForFeature(this.stringTest2, this.META_StringTest_optionalSimpleAttribute, StringAttributeTestCase.stringOptionalSimple2);
		this.adapter.setValueForFeature(this.stringTest2, this.META_StringTest_setAttribute, StringAttributeTestCase.stringSet2);
		this.adapter.setValueForFeature(this.stringTest2, this.META_StringTest_bagAttribute, StringAttributeTestCase.stringBag2);
		this.adapter.setValueForFeature(this.stringTest2, this.META_StringTest_orderedSetAttribute, StringAttributeTestCase.stringOrderedSet2);
		this.adapter.setValueForFeature(this.stringTest2, this.META_StringTest_sequenceAttribute, StringAttributeTestCase.stringSequence2);

	}

	@Override
	protected void tearDown() throws Exception {
		this.adapter.delete(this.stringTest1);
		this.adapter.delete(this.stringTest2);
		super.tearDown();
	}
}
