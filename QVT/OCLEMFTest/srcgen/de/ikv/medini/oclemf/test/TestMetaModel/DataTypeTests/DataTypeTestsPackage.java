/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests;

import de.ikv.medini.kernel.KernelPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.DataTypeTestsFactory
 * @model kind="package"
 * @generated
 */
public interface DataTypeTestsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "DataTypeTests";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///TestMetaModel/DataTypeTests.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "TestMetaModel.DataTypeTests";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DataTypeTestsPackage eINSTANCE = de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.DataTypeTestsPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.EnumerationTestImpl <em>Enumeration Test</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.EnumerationTestImpl
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.DataTypeTestsPackageImpl#getEnumerationTest()
	 * @generated
	 */
	int ENUMERATION_TEST = 0;

	/**
	 * The feature id for the '<em><b>Medini Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TEST__MEDINI_IDENTIFIER = KernelPackage.MEDINI_OBJECT__MEDINI_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Sequence Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TEST__SEQUENCE_ATTRIBUTE = KernelPackage.MEDINI_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Set Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TEST__SET_ATTRIBUTE = KernelPackage.MEDINI_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ordered Set Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TEST__ORDERED_SET_ATTRIBUTE = KernelPackage.MEDINI_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Simple Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TEST__SIMPLE_ATTRIBUTE = KernelPackage.MEDINI_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Optional Simple Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TEST__OPTIONAL_SIMPLE_ATTRIBUTE = KernelPackage.MEDINI_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Bag Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TEST__BAG_ATTRIBUTE = KernelPackage.MEDINI_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Enumeration Test</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TEST_FEATURE_COUNT = KernelPackage.MEDINI_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.StructureTestImpl <em>Structure Test</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.StructureTestImpl
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.DataTypeTestsPackageImpl#getStructureTest()
	 * @generated
	 */
	int STRUCTURE_TEST = 1;

	/**
	 * The feature id for the '<em><b>Medini Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_TEST__MEDINI_IDENTIFIER = KernelPackage.MEDINI_OBJECT__MEDINI_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Sequence Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_TEST__SEQUENCE_ATTRIBUTE = KernelPackage.MEDINI_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Set Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_TEST__SET_ATTRIBUTE = KernelPackage.MEDINI_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ordered Set Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_TEST__ORDERED_SET_ATTRIBUTE = KernelPackage.MEDINI_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Simple Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_TEST__SIMPLE_ATTRIBUTE = KernelPackage.MEDINI_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Optional Simple Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_TEST__OPTIONAL_SIMPLE_ATTRIBUTE = KernelPackage.MEDINI_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Bag Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_TEST__BAG_ATTRIBUTE = KernelPackage.MEDINI_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Structure Test</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_TEST_FEATURE_COUNT = KernelPackage.MEDINI_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.StructureTestTypeImpl <em>Structure Test Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.StructureTestTypeImpl
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.DataTypeTestsPackageImpl#getStructureTestType()
	 * @generated
	 */
	int STRUCTURE_TEST_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Medini Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_TEST_TYPE__MEDINI_IDENTIFIER = KernelPackage.MEDINI_OBJECT__MEDINI_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Integer Struct Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_TEST_TYPE__INTEGER_STRUCT_FIELD = KernelPackage.MEDINI_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Enum Struct Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_TEST_TYPE__ENUM_STRUCT_FIELD = KernelPackage.MEDINI_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>String Struct Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_TEST_TYPE__STRING_STRUCT_FIELD = KernelPackage.MEDINI_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Boolean Struct Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_TEST_TYPE__BOOLEAN_STRUCT_FIELD = KernelPackage.MEDINI_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Float Structure Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_TEST_TYPE__FLOAT_STRUCTURE_FIELD = KernelPackage.MEDINI_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Double Structure Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_TEST_TYPE__DOUBLE_STRUCTURE_FIELD = KernelPackage.MEDINI_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Long Struct Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_TEST_TYPE__LONG_STRUCT_FIELD = KernelPackage.MEDINI_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Class Struct Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_TEST_TYPE__CLASS_STRUCT_FIELD = KernelPackage.MEDINI_OBJECT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Structure Test Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_TEST_TYPE_FEATURE_COUNT = KernelPackage.MEDINI_OBJECT_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTestType <em>Enumeration Test Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTestType
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.DataTypeTestsPackageImpl#getEnumerationTestType()
	 * @generated
	 */
	int ENUMERATION_TEST_TYPE = 3;


	/**
	 * Returns the meta object for class '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTest <em>Enumeration Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration Test</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTest
	 * @generated
	 */
	EClass getEnumerationTest();

	/**
	 * Returns the meta object for the attribute list '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTest#getSequenceAttribute <em>Sequence Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Sequence Attribute</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTest#getSequenceAttribute()
	 * @see #getEnumerationTest()
	 * @generated
	 */
	EAttribute getEnumerationTest_SequenceAttribute();

	/**
	 * Returns the meta object for the attribute list '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTest#getSetAttribute <em>Set Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Set Attribute</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTest#getSetAttribute()
	 * @see #getEnumerationTest()
	 * @generated
	 */
	EAttribute getEnumerationTest_SetAttribute();

	/**
	 * Returns the meta object for the attribute list '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTest#getOrderedSetAttribute <em>Ordered Set Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Ordered Set Attribute</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTest#getOrderedSetAttribute()
	 * @see #getEnumerationTest()
	 * @generated
	 */
	EAttribute getEnumerationTest_OrderedSetAttribute();

	/**
	 * Returns the meta object for the attribute '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTest#getSimpleAttribute <em>Simple Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simple Attribute</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTest#getSimpleAttribute()
	 * @see #getEnumerationTest()
	 * @generated
	 */
	EAttribute getEnumerationTest_SimpleAttribute();

	/**
	 * Returns the meta object for the attribute '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTest#getOptionalSimpleAttribute <em>Optional Simple Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Optional Simple Attribute</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTest#getOptionalSimpleAttribute()
	 * @see #getEnumerationTest()
	 * @generated
	 */
	EAttribute getEnumerationTest_OptionalSimpleAttribute();

	/**
	 * Returns the meta object for the attribute list '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTest#getBagAttribute <em>Bag Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Bag Attribute</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTest#getBagAttribute()
	 * @see #getEnumerationTest()
	 * @generated
	 */
	EAttribute getEnumerationTest_BagAttribute();

	/**
	 * Returns the meta object for class '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTest <em>Structure Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structure Test</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTest
	 * @generated
	 */
	EClass getStructureTest();

	/**
	 * Returns the meta object for the reference list '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTest#getSequenceAttribute <em>Sequence Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sequence Attribute</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTest#getSequenceAttribute()
	 * @see #getStructureTest()
	 * @generated
	 */
	EReference getStructureTest_SequenceAttribute();

	/**
	 * Returns the meta object for the reference list '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTest#getSetAttribute <em>Set Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Set Attribute</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTest#getSetAttribute()
	 * @see #getStructureTest()
	 * @generated
	 */
	EReference getStructureTest_SetAttribute();

	/**
	 * Returns the meta object for the reference list '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTest#getOrderedSetAttribute <em>Ordered Set Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ordered Set Attribute</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTest#getOrderedSetAttribute()
	 * @see #getStructureTest()
	 * @generated
	 */
	EReference getStructureTest_OrderedSetAttribute();

	/**
	 * Returns the meta object for the reference '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTest#getSimpleAttribute <em>Simple Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Simple Attribute</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTest#getSimpleAttribute()
	 * @see #getStructureTest()
	 * @generated
	 */
	EReference getStructureTest_SimpleAttribute();

	/**
	 * Returns the meta object for the reference '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTest#getOptionalSimpleAttribute <em>Optional Simple Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Optional Simple Attribute</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTest#getOptionalSimpleAttribute()
	 * @see #getStructureTest()
	 * @generated
	 */
	EReference getStructureTest_OptionalSimpleAttribute();

	/**
	 * Returns the meta object for the reference list '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTest#getBagAttribute <em>Bag Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Bag Attribute</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTest#getBagAttribute()
	 * @see #getStructureTest()
	 * @generated
	 */
	EReference getStructureTest_BagAttribute();

	/**
	 * Returns the meta object for class '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType <em>Structure Test Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structure Test Type</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType
	 * @generated
	 */
	EClass getStructureTestType();

	/**
	 * Returns the meta object for the attribute '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType#getIntegerStructField <em>Integer Struct Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Integer Struct Field</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType#getIntegerStructField()
	 * @see #getStructureTestType()
	 * @generated
	 */
	EAttribute getStructureTestType_IntegerStructField();

	/**
	 * Returns the meta object for the attribute '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType#getEnumStructField <em>Enum Struct Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enum Struct Field</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType#getEnumStructField()
	 * @see #getStructureTestType()
	 * @generated
	 */
	EAttribute getStructureTestType_EnumStructField();

	/**
	 * Returns the meta object for the attribute '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType#getStringStructField <em>String Struct Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String Struct Field</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType#getStringStructField()
	 * @see #getStructureTestType()
	 * @generated
	 */
	EAttribute getStructureTestType_StringStructField();

	/**
	 * Returns the meta object for the attribute '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType#isBooleanStructField <em>Boolean Struct Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Boolean Struct Field</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType#isBooleanStructField()
	 * @see #getStructureTestType()
	 * @generated
	 */
	EAttribute getStructureTestType_BooleanStructField();

	/**
	 * Returns the meta object for the attribute '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType#getFloatStructureField <em>Float Structure Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Float Structure Field</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType#getFloatStructureField()
	 * @see #getStructureTestType()
	 * @generated
	 */
	EAttribute getStructureTestType_FloatStructureField();

	/**
	 * Returns the meta object for the attribute '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType#getDoubleStructureField <em>Double Structure Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Double Structure Field</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType#getDoubleStructureField()
	 * @see #getStructureTestType()
	 * @generated
	 */
	EAttribute getStructureTestType_DoubleStructureField();

	/**
	 * Returns the meta object for the attribute '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType#getLongStructField <em>Long Struct Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Long Struct Field</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType#getLongStructField()
	 * @see #getStructureTestType()
	 * @generated
	 */
	EAttribute getStructureTestType_LongStructField();

	/**
	 * Returns the meta object for the reference '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType#getClassStructField <em>Class Struct Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Class Struct Field</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType#getClassStructField()
	 * @see #getStructureTestType()
	 * @generated
	 */
	EReference getStructureTestType_ClassStructField();

	/**
	 * Returns the meta object for enum '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTestType <em>Enumeration Test Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Enumeration Test Type</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTestType
	 * @generated
	 */
	EEnum getEnumerationTestType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DataTypeTestsFactory getDataTypeTestsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.EnumerationTestImpl <em>Enumeration Test</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.EnumerationTestImpl
		 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.DataTypeTestsPackageImpl#getEnumerationTest()
		 * @generated
		 */
		EClass ENUMERATION_TEST = eINSTANCE.getEnumerationTest();

		/**
		 * The meta object literal for the '<em><b>Sequence Attribute</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATION_TEST__SEQUENCE_ATTRIBUTE = eINSTANCE.getEnumerationTest_SequenceAttribute();

		/**
		 * The meta object literal for the '<em><b>Set Attribute</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATION_TEST__SET_ATTRIBUTE = eINSTANCE.getEnumerationTest_SetAttribute();

		/**
		 * The meta object literal for the '<em><b>Ordered Set Attribute</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATION_TEST__ORDERED_SET_ATTRIBUTE = eINSTANCE.getEnumerationTest_OrderedSetAttribute();

		/**
		 * The meta object literal for the '<em><b>Simple Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATION_TEST__SIMPLE_ATTRIBUTE = eINSTANCE.getEnumerationTest_SimpleAttribute();

		/**
		 * The meta object literal for the '<em><b>Optional Simple Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATION_TEST__OPTIONAL_SIMPLE_ATTRIBUTE = eINSTANCE.getEnumerationTest_OptionalSimpleAttribute();

		/**
		 * The meta object literal for the '<em><b>Bag Attribute</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATION_TEST__BAG_ATTRIBUTE = eINSTANCE.getEnumerationTest_BagAttribute();

		/**
		 * The meta object literal for the '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.StructureTestImpl <em>Structure Test</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.StructureTestImpl
		 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.DataTypeTestsPackageImpl#getStructureTest()
		 * @generated
		 */
		EClass STRUCTURE_TEST = eINSTANCE.getStructureTest();

		/**
		 * The meta object literal for the '<em><b>Sequence Attribute</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE_TEST__SEQUENCE_ATTRIBUTE = eINSTANCE.getStructureTest_SequenceAttribute();

		/**
		 * The meta object literal for the '<em><b>Set Attribute</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE_TEST__SET_ATTRIBUTE = eINSTANCE.getStructureTest_SetAttribute();

		/**
		 * The meta object literal for the '<em><b>Ordered Set Attribute</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE_TEST__ORDERED_SET_ATTRIBUTE = eINSTANCE.getStructureTest_OrderedSetAttribute();

		/**
		 * The meta object literal for the '<em><b>Simple Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE_TEST__SIMPLE_ATTRIBUTE = eINSTANCE.getStructureTest_SimpleAttribute();

		/**
		 * The meta object literal for the '<em><b>Optional Simple Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE_TEST__OPTIONAL_SIMPLE_ATTRIBUTE = eINSTANCE.getStructureTest_OptionalSimpleAttribute();

		/**
		 * The meta object literal for the '<em><b>Bag Attribute</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE_TEST__BAG_ATTRIBUTE = eINSTANCE.getStructureTest_BagAttribute();

		/**
		 * The meta object literal for the '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.StructureTestTypeImpl <em>Structure Test Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.StructureTestTypeImpl
		 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.DataTypeTestsPackageImpl#getStructureTestType()
		 * @generated
		 */
		EClass STRUCTURE_TEST_TYPE = eINSTANCE.getStructureTestType();

		/**
		 * The meta object literal for the '<em><b>Integer Struct Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUCTURE_TEST_TYPE__INTEGER_STRUCT_FIELD = eINSTANCE.getStructureTestType_IntegerStructField();

		/**
		 * The meta object literal for the '<em><b>Enum Struct Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUCTURE_TEST_TYPE__ENUM_STRUCT_FIELD = eINSTANCE.getStructureTestType_EnumStructField();

		/**
		 * The meta object literal for the '<em><b>String Struct Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUCTURE_TEST_TYPE__STRING_STRUCT_FIELD = eINSTANCE.getStructureTestType_StringStructField();

		/**
		 * The meta object literal for the '<em><b>Boolean Struct Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUCTURE_TEST_TYPE__BOOLEAN_STRUCT_FIELD = eINSTANCE.getStructureTestType_BooleanStructField();

		/**
		 * The meta object literal for the '<em><b>Float Structure Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUCTURE_TEST_TYPE__FLOAT_STRUCTURE_FIELD = eINSTANCE.getStructureTestType_FloatStructureField();

		/**
		 * The meta object literal for the '<em><b>Double Structure Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUCTURE_TEST_TYPE__DOUBLE_STRUCTURE_FIELD = eINSTANCE.getStructureTestType_DoubleStructureField();

		/**
		 * The meta object literal for the '<em><b>Long Struct Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUCTURE_TEST_TYPE__LONG_STRUCT_FIELD = eINSTANCE.getStructureTestType_LongStructField();

		/**
		 * The meta object literal for the '<em><b>Class Struct Field</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE_TEST_TYPE__CLASS_STRUCT_FIELD = eINSTANCE.getStructureTestType_ClassStructField();

		/**
		 * The meta object literal for the '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTestType <em>Enumeration Test Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTestType
		 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.DataTypeTestsPackageImpl#getEnumerationTestType()
		 * @generated
		 */
		EEnum ENUMERATION_TEST_TYPE = eINSTANCE.getEnumerationTestType();

	}

} //DataTypeTestsPackage
