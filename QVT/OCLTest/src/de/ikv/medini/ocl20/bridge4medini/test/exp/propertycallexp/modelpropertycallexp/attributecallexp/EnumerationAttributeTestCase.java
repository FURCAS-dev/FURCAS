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

public class EnumerationAttributeTestCase extends OclInterpreterTestCase {

	Object EnumerationTestType_Label1;

	Object EnumerationTestType_Label2;

	Object EnumerationTestType_Label3;

	Object EnumerationTestType_Label4;

	private static Object enumSimple1;

	private static Object enumOptionalSimple1;

	private static Object[] enumSet1;

	private static Object[] enumOrderedSet1;

	private static Object[] enumSequence1;

	private static Object[] enumBag1;

	private static Object enumSimple2;

	private static Object enumOptionalSimple2;

	private static Object[] enumSet2;

	private static Object[] enumOrderedSet2;

	private static Object[] enumSequence2;

	private static Object[] enumBag2;

	private Object/* EnumerationTest */enumTest1;

	private Object/* EnumerationTest */enumTest2;

	public void testSimpleAttribute() throws Exception {
		List result = this.adapter.evaluate("context TestMetaModel::DataTypeTests::EnumerationTest inv: self.simpleAttribute ", this.enumTest1);
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(this.enumerationTestTypeToString(EnumerationAttributeTestCase.enumSimple1), (result.get(0).toString()/* ADDED .toString() */));

		result = this.adapter.evaluate("context TestMetaModel::DataTypeTests::EnumerationTest inv: self.simpleAttribute ", this.enumTest2);
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(this.enumerationTestTypeToString(EnumerationAttributeTestCase.enumSimple2), (result.get(0).toString()/* ADDED .toString() */));
	}

	public void testOptionalSimpleAttribute() throws Exception {
		List result = this.adapter.evaluate("context TestMetaModel::DataTypeTests::EnumerationTest inv: self.optionalSimpleAttribute ", this.enumTest1);
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(this.enumerationTestTypeToString(EnumerationAttributeTestCase.enumOptionalSimple1), (result.get(0).toString()/* ADDED .toString() */));

		result = this.adapter.evaluate("context TestMetaModel::DataTypeTests::EnumerationTest inv: self.optionalSimpleAttribute ", this.enumTest2);
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(this.enumerationTestTypeToString(EnumerationAttributeTestCase.enumOptionalSimple2), (result.get(0).toString()/* ADDED .toString() */));
	}

	public void testBagAttribute() throws Exception {
		List result = this.adapter.evaluate("context TestMetaModel::DataTypeTests::EnumerationTest inv: self.bagAttribute ", this.enumTest1);
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(EnumerationAttributeTestCase.enumBag1.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toStringVector(EnumerationAttributeTestCase.enumBag2)));

		result = this.adapter.evaluate("context TestMetaModel::DataTypeTests::EnumerationTest inv: self.bagAttribute ", this.enumTest2);
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		Assert.assertEquals(EnumerationAttributeTestCase.enumBag2.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toStringVector(EnumerationAttributeTestCase.enumBag2)));

	}

	public void testSetAttribute() throws Exception {
		List result = this.adapter.evaluate("context TestMetaModel::DataTypeTests::EnumerationTest inv: self.setAttribute ", this.enumTest1);
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(EnumerationAttributeTestCase.enumSet1.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toStringVector(EnumerationAttributeTestCase.enumSet2)));

		result = this.adapter.evaluate("context TestMetaModel::DataTypeTests::EnumerationTest inv: self.setAttribute ", this.enumTest2);
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		Assert.assertEquals(EnumerationAttributeTestCase.enumSet2.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toStringVector(EnumerationAttributeTestCase.enumSet2)));
	}

	public void testOrderedSetAttribute() throws Exception {
		List result = this.adapter.evaluate("context TestMetaModel::DataTypeTests::EnumerationTest inv: self.orderedSetAttribute ", this.enumTest1);
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(EnumerationAttributeTestCase.enumOrderedSet1.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toStringVector(EnumerationAttributeTestCase.enumOrderedSet2)));

		result = this.adapter.evaluate("context TestMetaModel::DataTypeTests::EnumerationTest inv: self.orderedSetAttribute ", this.enumTest2);
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		Assert.assertEquals(EnumerationAttributeTestCase.enumOrderedSet2.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toStringVector(EnumerationAttributeTestCase.enumOrderedSet2)));
	}

	public void testSequenceAttribute() throws Exception {
		List result = this.adapter.evaluate("context TestMetaModel::DataTypeTests::EnumerationTest inv: self.sequenceAttribute ", this.enumTest1);
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertEquals(EnumerationAttributeTestCase.enumSequence1.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toStringVector(EnumerationAttributeTestCase.enumSequence2)));

		result = this.adapter.evaluate("context TestMetaModel::DataTypeTests::EnumerationTest inv: self.sequenceAttribute ", this.enumTest2);
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		Assert.assertEquals(EnumerationAttributeTestCase.enumSequence2.length, result1.size());
		Assert.assertTrue(result1.containsAll(this.toStringVector(EnumerationAttributeTestCase.enumSequence2)));
	}

	@Override
	protected void setUp() throws Exception {

		super.setUp();

		this.EnumerationTestType_Label1 = this.adapter.getEnumLiteral(this.META_EnumerationTestType_Label1);
		this.EnumerationTestType_Label2 = this.adapter.getEnumLiteral(this.META_EnumerationTestType_Label2);
		this.EnumerationTestType_Label3 = this.adapter.getEnumLiteral(this.META_EnumerationTestType_Label3);
		this.EnumerationTestType_Label4 = this.adapter.getEnumLiteral(this.META_EnumerationTestType_Label4);

		EnumerationAttributeTestCase.enumSimple1 = this.EnumerationTestType_Label1;
		EnumerationAttributeTestCase.enumOptionalSimple1 = this.EnumerationTestType_Label2;
		EnumerationAttributeTestCase.enumSet1 = new Object[] { this.EnumerationTestType_Label1, this.EnumerationTestType_Label2 };
		EnumerationAttributeTestCase.enumOrderedSet1 = new Object[] { this.EnumerationTestType_Label2, this.EnumerationTestType_Label3 };
		EnumerationAttributeTestCase.enumSequence1 = new Object[] { this.EnumerationTestType_Label1, this.EnumerationTestType_Label2, this.EnumerationTestType_Label2, this.EnumerationTestType_Label3 };
		EnumerationAttributeTestCase.enumBag1 = new Object[] { this.EnumerationTestType_Label1, this.EnumerationTestType_Label2, this.EnumerationTestType_Label2, this.EnumerationTestType_Label4 };

		EnumerationAttributeTestCase.enumSimple2 = this.EnumerationTestType_Label3;
		EnumerationAttributeTestCase.enumOptionalSimple2 = this.EnumerationTestType_Label4;
		EnumerationAttributeTestCase.enumSet2 = new Object[] {};
		EnumerationAttributeTestCase.enumOrderedSet2 = new Object[] {};
		EnumerationAttributeTestCase.enumSequence2 = new Object[] {};
		EnumerationAttributeTestCase.enumBag2 = new Object[] {};

		this.enumTest1 = this.adapter.createModelElement(this.META_EnumerationTest);
		this.adapter.setValueForFeature(this.enumTest1, this.META_EnumerationTest_simpleAttribute, EnumerationAttributeTestCase.enumSimple1);
		this.adapter.setValueForFeature(this.enumTest1, this.META_EnumerationTest_optionalSimpleAttribute, EnumerationAttributeTestCase.enumOptionalSimple1);
		this.adapter.setValueForFeature(this.enumTest1, this.META_EnumerationTest_setAttribute, EnumerationAttributeTestCase.enumSet1);
		this.adapter.setValueForFeature(this.enumTest1, this.META_EnumerationTest_bagAttribute, EnumerationAttributeTestCase.enumBag1);
		this.adapter.setValueForFeature(this.enumTest1, this.META_EnumerationTest_orderedSetAttribute, EnumerationAttributeTestCase.enumOrderedSet1);
		this.adapter.setValueForFeature(this.enumTest1, this.META_EnumerationTest_sequenceAttribute, EnumerationAttributeTestCase.enumSequence1);

		this.enumTest2 = this.adapter.createModelElement(this.META_EnumerationTest);
		this.adapter.setValueForFeature(this.enumTest2, this.META_EnumerationTest_simpleAttribute, EnumerationAttributeTestCase.enumSimple2);
		this.adapter.setValueForFeature(this.enumTest2, this.META_EnumerationTest_optionalSimpleAttribute, EnumerationAttributeTestCase.enumOptionalSimple2);
		this.adapter.setValueForFeature(this.enumTest2, this.META_EnumerationTest_setAttribute, EnumerationAttributeTestCase.enumSet2);
		this.adapter.setValueForFeature(this.enumTest2, this.META_EnumerationTest_bagAttribute, EnumerationAttributeTestCase.enumBag2);
		this.adapter.setValueForFeature(this.enumTest2, this.META_EnumerationTest_orderedSetAttribute, EnumerationAttributeTestCase.enumOrderedSet2);
		this.adapter.setValueForFeature(this.enumTest2, this.META_EnumerationTest_sequenceAttribute, EnumerationAttributeTestCase.enumSequence2);

	}

	@Override
	protected void tearDown() throws Exception {
		this.adapter.delete(this.enumTest1);
		this.adapter.delete(this.enumTest2);
		super.tearDown();
	}

	private Vector toStringVector(Object[] enumerationArray) {
		Vector result = new Vector();
		for (Object element : enumerationArray) {
			result.add(this.enumerationTestTypeToString(element));
		}
		return result;
	}

	private String enumerationTestTypeToString(Object enumerationTestType) {
		return this.adapter.getLiteralLabel(enumerationTestType);
	}
}
