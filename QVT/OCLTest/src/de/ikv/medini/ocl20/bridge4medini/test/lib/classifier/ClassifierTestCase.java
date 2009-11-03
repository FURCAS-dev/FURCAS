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

package de.ikv.medini.ocl20.bridge4medini.test.lib.classifier;

import java.util.Collection;
import java.util.List;

import junit.framework.Assert;

import de.ikv.medini.ocl.test.util.Utilities;
import de.ikv.medini.ocl20.bridge4medini.test.OclInterpreterTestCase;

public class ClassifierTestCase extends OclInterpreterTestCase {

	Object/* SubClass */subClass1 = null;

	Object/* SubClass */subClass2 = null;

	Object/* SuperClass */superClass11 = null;

	Object/* SuperClass */superClass12 = null;

	Object/* SuperClass */superClass13 = null;

	Object/* SuperClass */superClass21 = null;

	Object/* SuperClass */superClass22 = null;

	Object/* SuperClass */superClass23 = null;

	public void testAssociations() throws Exception {
		// List result = adapter.evaluate("context Integer def: inc() : Integer = self + 1 ");
		// assertEquals("hihihuhu", getMediniOclProcessor().evaluateToString("context TestMetaModel::ClassifierTest::SubClass inv: self.abstractSuperClass->collect( asc |
		// asc.subClass)->select( current | current.oclIsTypeOf( TestMetaModel::ClassifierTest::SubClass ))->isEmpty() ", new EnvironmentEntry[0]));

		// assertEquals("hihi", getMediniOclProcessor().evaluateToString("context OclVoid inv: TestMetaModel::ClassifierTest::SubClass.allInstances().abstractSuperClass ", new
		// EnvironmentEntry[0]));

		List result = this.adapter.evaluate("context OclVoid inv: TestMetaModel::ClassifierTest::SubClass.allInstances().abstractSuperClass ");
		Assert.assertEquals(result.size(), 1);

		Object[] all = new Object[] { this.superClass11, this.superClass12, this.superClass13, this.superClass21, this.superClass22, this.superClass23 };

		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Assert.assertTrue(Utilities.areIdentitiesEqual(result1, Utilities.asArrayList(all), this.adapter));
	}

	@Override
	protected void setUp() throws Exception {

		super.setUp();

		this.subClass1 = this.adapter.createModelElement(this.META_SubClass);
		this.subClass2 = this.adapter.createModelElement(this.META_SubClass);

		this.superClass11 = this.adapter.createModelElement(this.META_SuperClass);
		this.superClass12 = this.adapter.createModelElement(this.META_SuperClass);
		this.superClass13 = this.adapter.createModelElement(this.META_SuperClass);
		this.superClass21 = this.adapter.createModelElement(this.META_SuperClass);
		this.superClass22 = this.adapter.createModelElement(this.META_SuperClass);
		this.superClass23 = this.adapter.createModelElement(this.META_SuperClass);

		this.adapter.addValueForFeature(this.subClass1, this.META_SubClass_abstractSuperClass, this.superClass11);
		this.adapter.addValueForFeature(this.subClass1, this.META_SubClass_abstractSuperClass, this.superClass12);
		this.adapter.addValueForFeature(this.subClass1, this.META_SubClass_abstractSuperClass, this.superClass13);
		this.adapter.addValueForFeature(this.subClass2, this.META_SubClass_abstractSuperClass, this.superClass21);
		this.adapter.addValueForFeature(this.subClass2, this.META_SubClass_abstractSuperClass, this.superClass22);
		this.adapter.addValueForFeature(this.subClass2, this.META_SubClass_abstractSuperClass, this.superClass23);

	}

	@Override
	protected void tearDown() throws Exception {

		this.adapter.delete(this.subClass1);
		this.adapter.delete(this.subClass2);

		this.adapter.delete(this.superClass11);
		this.adapter.delete(this.superClass12);
		this.adapter.delete(this.superClass13);
		this.adapter.delete(this.superClass21);
		this.adapter.delete(this.superClass22);
		this.adapter.delete(this.superClass23);

		super.tearDown();
	}
	/*
	 * private static Map extractTuple(Any any) throws AnyValueHandlingException { HashMap result = new HashMap(); TupleSlot[] anyTupleSlots = TupleHelper.extract(any); for (int i =
	 * 0; i < anyTupleSlots.length; i++) { TupleSlot currentTupleSlot = anyTupleSlots[i]; result.put(currentTupleSlot.name, DynAnyUtility.extractAnyValue(currentTupleSlot.value)); }
	 * return result; }
	 */
}
