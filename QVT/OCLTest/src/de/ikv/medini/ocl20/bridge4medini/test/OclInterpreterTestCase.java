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

package de.ikv.medini.ocl20.bridge4medini.test;

import de.ikv.medini.ocl.test.OCLTestAdapter;

public abstract class OclInterpreterTestCase extends MediniTestCase {

	public final String META_SuperClass = "TestMetaModel::ClassifierTest::SuperClass";

	public final String META_SuperClass_superName = "SuperName";

	public final String META_SubClass = "TestMetaModel::ClassifierTest::SubClass";

	public final String META_SubClass_subName = "SubName";

	public final String META_SubClass_abstractSuperClass = "abstractSuperClass";

	public final String META_BooleanTest = "TestMetaModel::PrimitiveTypesTests::BooleanTest";

	public final String META_BooleanTest_simpleAttribute = "SimpleAttribute";

	public final String META_BooleanTest_optionalSimpleAttribute = "OptionalSimpleAttribute";

	public final String META_BooleanTest_setAttribute = "SetAttribute";

	public final String META_BooleanTest_orderedSetAttribute = "OrderedSetAttribute";

	public final String META_BooleanTest_bagAttribute = "BagAttribute";

	public final String META_BooleanTest_sequenceAttribute = "SequenceAttribute";

	public final String META_DoubleTest = "TestMetaModel::PrimitiveTypesTests::DoubleTest";

	public final String META_DoubleTest_simpleAttribute = "SimpleAttribute";

	public final String META_DoubleTest_optionalSimpleAttribute = "OptionalSimpleAttribute";

	public final String META_DoubleTest_setAttribute = "SetAttribute";

	public final String META_DoubleTest_orderedSetAttribute = "OrderedSetAttribute";

	public final String META_DoubleTest_bagAttribute = "BagAttribute";

	public final String META_DoubleTest_sequenceAttribute = "SequenceAttribute";

	public final String META_FloatTest = "TestMetaModel::PrimitiveTypesTest::FloatTest";

	public final String META_FloatTest_simpleAttribute = "SimpleAttribute";

	public final String META_FloatTest_optionalSimpleAttribute = "OptionalSimpleAttribute";

	public final String META_FloatTest_setAttribute = "SetAttribute";

	public final String META_FloatTest_orderedSetAttribute = "OrderedSetAttribute";

	public final String META_FloatTest_bagAttribute = "BagAttribute";

	public final String META_FloatTest_sequenceAttribute = "SequenceAttribute";

	public final String META_IntegerTest = "TestMetaModel::PrimitiveTypesTest::IntegerTest";

	public final String META_IntegerTest_simpleAttribute = "SimpleAttribute";

	public final String META_IntegerTest_optionalSimpleAttribute = "OptionalSimpleAttribute";

	public final String META_IntegerTest_setAttribute = "SetAttribute";

	public final String META_IntegerTest_orderedSetAttribute = "OrderedSetAttribute";

	public final String META_IntegerTest_bagAttribute = "BagAttribute";

	public final String META_IntegerTest_sequenceAttribute = "SequenceAttribute";

	public final String META_LongTest = "TestMetaModel::PrimitiveTypesTest::LongTest";

	public final String META_LongTest_simpleAttribute = "SimpleAttribute";

	public final String META_LongTest_optionalSimpleAttribute = "OptionalSimpleAttribute";

	public final String META_LongTest_setAttribute = "SetAttribute";

	public final String META_LongTest_orderedSetAttribute = "OrderedSetAttribute";

	public final String META_LongTest_bagAttribute = "BagAttribute";

	public final String META_LongTest_sequenceAttribute = "SequenceAttribute";

	public final String META_StringTest = "TestMetaModel::PrimitiveTypesTest::StringTest";

	public final String META_StringTest_simpleAttribute = "SimpleAttribute";

	public final String META_StringTest_optionalSimpleAttribute = "OptionalSimpleAttribute";

	public final String META_StringTest_setAttribute = "SetAttribute";

	public final String META_StringTest_orderedSetAttribute = "OrderedSetAttribute";

	public final String META_StringTest_bagAttribute = "BagAttribute";

	public final String META_StringTest_sequenceAttribute = "SequenceAttribute";

	public final String META_EnumerationTest = "TestMetaModel::DataTypeTests::EnumerationTest";

	public final String META_EnumerationTest_simpleAttribute = "SimpleAttribute";

	public final String META_EnumerationTest_optionalSimpleAttribute = "OptionalSimpleAttribute";

	public final String META_EnumerationTest_setAttribute = "SetAttribute";

	public final String META_EnumerationTest_orderedSetAttribute = "OrderedSetAttribute";

	public final String META_EnumerationTest_bagAttribute = "BagAttribute";

	public final String META_EnumerationTest_sequenceAttribute = "SequenceAttribute";

	// public final String META_EnumerationTestType="TestMetaModel::DataTypeTests::EnumerationTestType";
	public final String META_EnumerationTestType_Label1 = "TestMetaModel::DataTypeTests::EnumerationTestType::Label1";

	public final String META_EnumerationTestType_Label2 = "TestMetaModel::DataTypeTests::EnumerationTestType::Label2";

	public final String META_EnumerationTestType_Label3 = "TestMetaModel::DataTypeTests::EnumerationTestType::Label3";

	public final String META_EnumerationTestType_Label4 = "TestMetaModel::DataTypeTests::EnumerationTestType::Label4";

	public final String META_StaticBooleanTest = "TestMetaModel::PrimitiveTypesStaticTests::StaticBooleanTest";

	public final String META_StaticBooleanTest_simpleAttribute = "SimpleAttribute";

	public final String META_StaticBooleanTest_optionalSimpleAttribute = "OptionalSimpleAttribute";

	public final String META_StaticBooleanTest_setAttribute = "SetAttribute";

	public final String META_StaticBooleanTest_orderedSetAttribute = "OrderedSetAttribute";

	public final String META_StaticBooleanTest_bagAttribute = "BagAttribute";

	public final String META_StaticBooleanTest_sequenceAttribute = "SequenceAttribute";

	public final String META_StaticDoubleTest = "TestMetaModel::PrimitiveTypesStaticTests::StaticDoubleTest";

	public final String META_StaticDoubleTest_simpleAttribute = "SimpleAttribute";

	public final String META_StaticDoubleTest_optionalSimpleAttribute = "OptionalSimpleAttribute";

	public final String META_StaticDoubleTest_setAttribute = "SetAttribute";

	public final String META_StaticDoubleTest_orderedSetAttribute = "OrderedSetAttribute";

	public final String META_StaticDoubleTest_bagAttribute = "BagAttribute";

	public final String META_StaticDoubleTest_sequenceAttribute = "SequenceAttribute";

	public final String META_StaticFloatTest = "TestMetaModel::PrimitiveTypesStaticTests::FloatTest";

	public final String META_StaticFloatTest_simpleAttribute = "SimpleAttribute";

	public final String META_StaticFloatTest_optionalSimpleAttribute = "PptionalSimpleAttribute";

	public final String META_StaticFloatTest_setAttribute = "SetAttribute";

	public final String META_StaticFloatTest_orderedSetAttribute = "OrderedSetAttribute";

	public final String META_StaticFloatTest_bagAttribute = "BagAttribute";

	public final String META_StaticFloatTest_sequenceAttribute = "SequenceAttribute";

	public final String META_StaticIntegerTest = "TestMetaModel::PrimitiveTypesStaticTests::StaticIntegerTest";

	public final String META_StaticIntegerTest_simpleAttribute = "SimpleAttribute";

	public final String META_StaticIntegerTest_optionalSimpleAttribute = "OptionalSimpleAttribute";

	public final String META_StaticIntegerTest_setAttribute = "SetAttribute";

	public final String META_StaticIntegerTest_orderedSetAttribute = "OrderedSetAttribute";

	public final String META_StaticIntegerTest_bagAttribute = "BagAttribute";

	public final String META_StaticIntegerTest_sequenceAttribute = "SequenceAttribute";

	public final String META_StaticLongTest = "TestMetaModel::PrimitiveTypesStaticTests::StaticLongTest";

	public final String META_StaticLongTest_simpleAttribute = "SimpleAttribute";

	public final String META_StaticLongTest_optionalSimpleAttribute = "OptionalSimpleAttribute";

	public final String META_StaticLongTest_setAttribute = "SetAttribute";

	public final String META_StaticLongTest_orderedSetAttribute = "OrderedSetAttribute";

	public final String META_StaticLongTest_bagAttribute = "BagAttribute";

	public final String META_StaticLongTest_sequenceAttribute = "SequenceAttribute";

	public final String META_StaticStringTest = "TestMetaModel::PrimitiveTypesStaticTests::StaticStringTest";

	public final String META_StaticStringTest_simpleAttribute = "SimpleAttribute";

	public final String META_StaticStringTest_optionalSimpleAttribute = "OptionalSimpleAttribute";

	public final String META_StaticStringTest_setAttribute = "SetAttribute";

	public final String META_StaticStringTest_orderedSetAttribute = "OrderedSetAttribute";

	public final String META_StaticStringTest_bagAttribute = "BagAttribute";

	public final String META_StaticStringTest_sequenceAttribute = "SequenceAttribute";

	public OCLTestAdapter adapter;

	protected void setUp() throws Exception {
		super.setUp();
		Class adapterClass = Class.forName(this.getProperty("adapter"));
		this.adapter = (OCLTestAdapter) adapterClass.getConstructor(new Class[0]).newInstance(new Object[0]);
		this.adapter.setUp(this.getProperties());
	}

	protected void tearDown() throws Exception {
		this.adapter.tearDown();
		this.adapter = null;
		super.tearDown();
	}

}
