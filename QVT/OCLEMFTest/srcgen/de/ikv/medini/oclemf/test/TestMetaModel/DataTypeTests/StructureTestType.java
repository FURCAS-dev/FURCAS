/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests;

import de.ikv.medini.kernel.MediniObject;

import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.StringTest;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Structure Test Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType#getIntegerStructField <em>Integer Struct Field</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType#getEnumStructField <em>Enum Struct Field</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType#getStringStructField <em>String Struct Field</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType#isBooleanStructField <em>Boolean Struct Field</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType#getFloatStructureField <em>Float Structure Field</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType#getDoubleStructureField <em>Double Structure Field</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType#getLongStructField <em>Long Struct Field</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType#getClassStructField <em>Class Struct Field</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.DataTypeTestsPackage#getStructureTestType()
 * @model
 * @generated
 */
public interface StructureTestType extends MediniObject {
	/**
	 * Returns the value of the '<em><b>Integer Struct Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Integer Struct Field</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Integer Struct Field</em>' attribute.
	 * @see #setIntegerStructField(int)
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.DataTypeTestsPackage#getStructureTestType_IntegerStructField()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	int getIntegerStructField();

	/**
	 * Sets the value of the '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType#getIntegerStructField <em>Integer Struct Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Integer Struct Field</em>' attribute.
	 * @see #getIntegerStructField()
	 * @generated
	 */
	void setIntegerStructField(int value);

	/**
	 * Returns the value of the '<em><b>Enum Struct Field</b></em>' attribute.
	 * The literals are from the enumeration {@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTestType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enum Struct Field</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enum Struct Field</em>' attribute.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTestType
	 * @see #setEnumStructField(EnumerationTestType)
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.DataTypeTestsPackage#getStructureTestType_EnumStructField()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	EnumerationTestType getEnumStructField();

	/**
	 * Sets the value of the '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType#getEnumStructField <em>Enum Struct Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enum Struct Field</em>' attribute.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTestType
	 * @see #getEnumStructField()
	 * @generated
	 */
	void setEnumStructField(EnumerationTestType value);

	/**
	 * Returns the value of the '<em><b>String Struct Field</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String Struct Field</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String Struct Field</em>' attribute.
	 * @see #setStringStructField(String)
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.DataTypeTestsPackage#getStructureTestType_StringStructField()
	 * @model default="" unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getStringStructField();

	/**
	 * Sets the value of the '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType#getStringStructField <em>String Struct Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>String Struct Field</em>' attribute.
	 * @see #getStringStructField()
	 * @generated
	 */
	void setStringStructField(String value);

	/**
	 * Returns the value of the '<em><b>Boolean Struct Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boolean Struct Field</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boolean Struct Field</em>' attribute.
	 * @see #setBooleanStructField(boolean)
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.DataTypeTestsPackage#getStructureTestType_BooleanStructField()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isBooleanStructField();

	/**
	 * Sets the value of the '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType#isBooleanStructField <em>Boolean Struct Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Boolean Struct Field</em>' attribute.
	 * @see #isBooleanStructField()
	 * @generated
	 */
	void setBooleanStructField(boolean value);

	/**
	 * Returns the value of the '<em><b>Float Structure Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Float Structure Field</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Float Structure Field</em>' attribute.
	 * @see #setFloatStructureField(float)
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.DataTypeTestsPackage#getStructureTestType_FloatStructureField()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	float getFloatStructureField();

	/**
	 * Sets the value of the '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType#getFloatStructureField <em>Float Structure Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Float Structure Field</em>' attribute.
	 * @see #getFloatStructureField()
	 * @generated
	 */
	void setFloatStructureField(float value);

	/**
	 * Returns the value of the '<em><b>Double Structure Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Double Structure Field</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Double Structure Field</em>' attribute.
	 * @see #setDoubleStructureField(double)
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.DataTypeTestsPackage#getStructureTestType_DoubleStructureField()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	double getDoubleStructureField();

	/**
	 * Sets the value of the '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType#getDoubleStructureField <em>Double Structure Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Double Structure Field</em>' attribute.
	 * @see #getDoubleStructureField()
	 * @generated
	 */
	void setDoubleStructureField(double value);

	/**
	 * Returns the value of the '<em><b>Long Struct Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Long Struct Field</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Long Struct Field</em>' attribute.
	 * @see #setLongStructField(long)
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.DataTypeTestsPackage#getStructureTestType_LongStructField()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	long getLongStructField();

	/**
	 * Sets the value of the '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType#getLongStructField <em>Long Struct Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Long Struct Field</em>' attribute.
	 * @see #getLongStructField()
	 * @generated
	 */
	void setLongStructField(long value);

	/**
	 * Returns the value of the '<em><b>Class Struct Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Struct Field</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Struct Field</em>' reference.
	 * @see #setClassStructField(StringTest)
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.DataTypeTestsPackage#getStructureTestType_ClassStructField()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	StringTest getClassStructField();

	/**
	 * Sets the value of the '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType#getClassStructField <em>Class Struct Field</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Struct Field</em>' reference.
	 * @see #getClassStructField()
	 * @generated
	 */
	void setClassStructField(StringTest value);

} // StructureTestType