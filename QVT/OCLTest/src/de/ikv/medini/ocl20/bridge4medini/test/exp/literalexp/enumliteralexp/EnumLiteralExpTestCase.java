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

package de.ikv.medini.ocl20.bridge4medini.test.exp.literalexp.enumliteralexp;

import java.util.List;

import junit.framework.Assert;

import de.ikv.medini.ocl20.bridge4medini.test.OclInterpreterTestCase;

public class EnumLiteralExpTestCase extends OclInterpreterTestCase {

	public void testEnumLiteralExp() throws Exception {

		List result = this.adapter.evaluate("TestMetaModel::DataTypeTests::EnumerationTestType::Label1");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(this.adapter.getLiteralLabelFromQualifiedName(this.META_EnumerationTestType_Label1), (result.get(0).toString()/* added toString() */));

		result = this.adapter.evaluate("TestMetaModel::DataTypeTests::EnumerationTestType::Label2");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(this.adapter.getLiteralLabelFromQualifiedName(this.META_EnumerationTestType_Label2), (result.get(0).toString()));

		result = this.adapter.evaluate("TestMetaModel::DataTypeTests::EnumerationTestType::Label3");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(this.adapter.getLiteralLabelFromQualifiedName(this.META_EnumerationTestType_Label3), (result.get(0).toString()));

		result = this.adapter.evaluate("TestMetaModel::DataTypeTests::EnumerationTestType::Label4");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(this.adapter.getLiteralLabelFromQualifiedName(this.META_EnumerationTestType_Label4), (result.get(0).toString()));

		result = this.adapter.evaluate("TestMetaModel::DataTypeTests::EnumerationTestType::Label4 = TestMetaModel::DataTypeTests::EnumerationTestType::Label4");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("TestMetaModel::DataTypeTests::EnumerationTestType::Label4 <> TestMetaModel::DataTypeTests::EnumerationTestType::Label4");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("TestMetaModel::DataTypeTests::EnumerationTestType::Label4 = TestMetaModel::DataTypeTests::EnumerationTestType::Label3");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("TestMetaModel::DataTypeTests::EnumerationTestType::Label4 <> TestMetaModel::DataTypeTests::EnumerationTestType::Label3");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

	}

	public void testEnumGetterSetter() throws Exception {

		Object enumerationTest = this.adapter.createModelElement(this.META_EnumerationTest);
		Object enumerationTestType_Label1 = this.adapter.getEnumLiteral(this.META_EnumerationTestType_Label1);
		Object enumerationTestType_Label2 = this.adapter.getEnumLiteral(this.META_EnumerationTestType_Label2);
		Object enumerationTestType_Label3 = this.adapter.getEnumLiteral(this.META_EnumerationTestType_Label3);
		this.adapter.setValueForFeature(enumerationTest, this.META_EnumerationTest_sequenceAttribute, new Object[] { enumerationTestType_Label1, enumerationTestType_Label2 });

		List result // = adapter.evaluate("context TestMetaModel::DataTypeTests::EnumerationTest inv: Sequence {
		// TestMetaModel::DataTypeTests::EnumerationTestType::Label1,
		// TestMetaModel::DataTypeTests::EnumerationTestType::Label2 } = Sequence {
		// TestMetaModel::DataTypeTests::EnumerationTestType::Label1,
		// TestMetaModel::DataTypeTests::EnumerationTestType::Label2 }");
		// assertEquals(result.size(), 1);
		// assertEquals(true, ((Boolean)result.get(0)).booleanValue());
		= this.adapter
		        .evaluate("context TestMetaModel::DataTypeTests::EnumerationTest inv: self.sequenceAttribute = Sequence { TestMetaModel::DataTypeTests::EnumerationTestType::Label1, TestMetaModel::DataTypeTests::EnumerationTestType::Label2 }");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

		this.adapter.setValueForFeature(enumerationTest, this.META_EnumerationTest_sequenceAttribute, new Object[] { enumerationTestType_Label1, enumerationTestType_Label3 });
		result = this.adapter
		        .evaluate("context TestMetaModel::DataTypeTests::EnumerationTest inv: self.sequenceAttribute = Sequence { TestMetaModel::DataTypeTests::EnumerationTestType::Label1, TestMetaModel::DataTypeTests::EnumerationTestType::Label2 }");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		this.adapter.delete(enumerationTest);
	}

	/*
	 * private Any createNumberEnumAnySequence(String[] numberEnums) throws Exception {
	 * 
	 * DynSequence dynSequence = null; DynAnyFactory dynAnyFactory = DynAnyFactoryHelper.narrow(OrbUtility.getOrb().resolve_initial_references("DynAnyFactory")); //
	 * MofEnumerationType numberEnumDesignatorType = MofEnumerationTypeHelper.narrow(refGetClassifierDesignatorType("AttributeTests.EnumerationTests.NumberEnum")); TypeCode
	 * typeCode = OrbUtility.getOrb().create_enum_tc(EnumerationTestHelper.id(), "EnumerationTest", new String[] { "Label1", "Label2", "Label3", "Label4" });
	 * 
	 * Any[] anyNumberEnums = new Any[numberEnums.length]; for (int i = 0; i < numberEnums.length; i++) { DynEnum dynEnum = (DynEnum)
	 * dynAnyFactory.create_dyn_any_from_type_code(typeCode); dynEnum.set_as_string(numberEnums[i]); anyNumberEnums[i] = dynEnum.to_any(); } TypeCode sequenceTypeCode =
	 * OrbUtility.getOrb().create_sequence_tc(numberEnums.length, typeCode); dynSequence = (DynSequence) dynAnyFactory.create_dyn_any_from_type_code(sequenceTypeCode);
	 * dynSequence.set_length(anyNumberEnums.length); dynSequence.set_elements(anyNumberEnums);
	 * 
	 * return dynSequence.to_any(); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * private String enumerationTestTypeToString(EnumerationTestType enumerationTestType) { if (enumerationTestType == EnumerationTestType.Label1) { return "Label1"; } else if
	 * (enumerationTestType == EnumerationTestType.Label2) { return "Label2"; } else if (enumerationTestType == EnumerationTestType.Label3) { return "Label3"; } else if
	 * (enumerationTestType == EnumerationTestType.Label4) { return "Label4"; } else { return null; } }
	 */
}
