/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests;

import de.ikv.medini.kernel.MediniObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTest#getSequenceAttribute <em>Sequence Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTest#getSetAttribute <em>Set Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTest#getOrderedSetAttribute <em>Ordered Set Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTest#getSimpleAttribute <em>Simple Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTest#getOptionalSimpleAttribute <em>Optional Simple Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTest#getBagAttribute <em>Bag Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.DataTypeTestsPackage#getEnumerationTest()
 * @model
 * @generated
 */
public interface EnumerationTest extends MediniObject {
	/**
	 * Returns the value of the '<em><b>Sequence Attribute</b></em>' attribute list.
	 * The list contents are of type {@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTestType}.
	 * The literals are from the enumeration {@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTestType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence Attribute</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence Attribute</em>' attribute list.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTestType
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.DataTypeTestsPackage#getEnumerationTest_SequenceAttribute()
	 * @model type="de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTestType" unique="false"
	 * @generated
	 */
	EList getSequenceAttribute();

	/**
	 * Returns the value of the '<em><b>Set Attribute</b></em>' attribute list.
	 * The list contents are of type {@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTestType}.
	 * The literals are from the enumeration {@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTestType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Set Attribute</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Set Attribute</em>' attribute list.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTestType
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.DataTypeTestsPackage#getEnumerationTest_SetAttribute()
	 * @model type="de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTestType" ordered="false"
	 * @generated
	 */
	EList getSetAttribute();

	/**
	 * Returns the value of the '<em><b>Ordered Set Attribute</b></em>' attribute list.
	 * The list contents are of type {@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTestType}.
	 * The literals are from the enumeration {@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTestType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ordered Set Attribute</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ordered Set Attribute</em>' attribute list.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTestType
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.DataTypeTestsPackage#getEnumerationTest_OrderedSetAttribute()
	 * @model type="de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTestType"
	 * @generated
	 */
	EList getOrderedSetAttribute();

	/**
	 * Returns the value of the '<em><b>Simple Attribute</b></em>' attribute.
	 * The literals are from the enumeration {@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTestType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Attribute</em>' attribute.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTestType
	 * @see #setSimpleAttribute(EnumerationTestType)
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.DataTypeTestsPackage#getEnumerationTest_SimpleAttribute()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	EnumerationTestType getSimpleAttribute();

	/**
	 * Sets the value of the '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTest#getSimpleAttribute <em>Simple Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Attribute</em>' attribute.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTestType
	 * @see #getSimpleAttribute()
	 * @generated
	 */
	void setSimpleAttribute(EnumerationTestType value);

	/**
	 * Returns the value of the '<em><b>Optional Simple Attribute</b></em>' attribute.
	 * The literals are from the enumeration {@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTestType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Optional Simple Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Optional Simple Attribute</em>' attribute.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTestType
	 * @see #setOptionalSimpleAttribute(EnumerationTestType)
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.DataTypeTestsPackage#getEnumerationTest_OptionalSimpleAttribute()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	EnumerationTestType getOptionalSimpleAttribute();

	/**
	 * Sets the value of the '{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTest#getOptionalSimpleAttribute <em>Optional Simple Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optional Simple Attribute</em>' attribute.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTestType
	 * @see #getOptionalSimpleAttribute()
	 * @generated
	 */
	void setOptionalSimpleAttribute(EnumerationTestType value);

	/**
	 * Returns the value of the '<em><b>Bag Attribute</b></em>' attribute list.
	 * The list contents are of type {@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTestType}.
	 * The literals are from the enumeration {@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTestType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bag Attribute</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bag Attribute</em>' attribute list.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTestType
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.DataTypeTestsPackage#getEnumerationTest_BagAttribute()
	 * @model type="de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTestType" unique="false" ordered="false"
	 * @generated
	 */
	EList getBagAttribute();

} // EnumerationTest