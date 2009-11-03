/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests;

import de.ikv.medini.kernel.MediniObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Double Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.DoubleTest#getBagAttribute <em>Bag Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.DoubleTest#getOptionalSimpleAttribute <em>Optional Simple Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.DoubleTest#getOrderedSetAttribute <em>Ordered Set Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.DoubleTest#getSequenceAttribute <em>Sequence Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.DoubleTest#getSetAttribute <em>Set Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.DoubleTest#getSimpleAttribute <em>Simple Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.PrimitiveTypesTestsPackage#getDoubleTest()
 * @model
 * @generated
 */
public interface DoubleTest extends MediniObject {
	/**
	 * Returns the value of the '<em><b>Bag Attribute</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Double}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bag Attribute</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bag Attribute</em>' attribute list.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.PrimitiveTypesTestsPackage#getDoubleTest_BagAttribute()
	 * @model type="double" unique="false" ordered="false"
	 * @generated
	 */
	EList getBagAttribute();

	/**
	 * Returns the value of the '<em><b>Optional Simple Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Optional Simple Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Optional Simple Attribute</em>' attribute.
	 * @see #setOptionalSimpleAttribute(double)
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.PrimitiveTypesTestsPackage#getDoubleTest_OptionalSimpleAttribute()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	double getOptionalSimpleAttribute();

	/**
	 * Sets the value of the '{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.DoubleTest#getOptionalSimpleAttribute <em>Optional Simple Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optional Simple Attribute</em>' attribute.
	 * @see #getOptionalSimpleAttribute()
	 * @generated
	 */
	void setOptionalSimpleAttribute(double value);

	/**
	 * Returns the value of the '<em><b>Ordered Set Attribute</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Double}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ordered Set Attribute</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ordered Set Attribute</em>' attribute list.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.PrimitiveTypesTestsPackage#getDoubleTest_OrderedSetAttribute()
	 * @model type="double"
	 * @generated
	 */
	EList getOrderedSetAttribute();

	/**
	 * Returns the value of the '<em><b>Sequence Attribute</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Double}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence Attribute</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence Attribute</em>' attribute list.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.PrimitiveTypesTestsPackage#getDoubleTest_SequenceAttribute()
	 * @model type="double" unique="false"
	 * @generated
	 */
	EList getSequenceAttribute();

	/**
	 * Returns the value of the '<em><b>Set Attribute</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Double}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Set Attribute</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Set Attribute</em>' attribute list.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.PrimitiveTypesTestsPackage#getDoubleTest_SetAttribute()
	 * @model type="double" ordered="false"
	 * @generated
	 */
	EList getSetAttribute();

	/**
	 * Returns the value of the '<em><b>Simple Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Attribute</em>' attribute.
	 * @see #setSimpleAttribute(double)
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.PrimitiveTypesTestsPackage#getDoubleTest_SimpleAttribute()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	double getSimpleAttribute();

	/**
	 * Sets the value of the '{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.DoubleTest#getSimpleAttribute <em>Simple Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Attribute</em>' attribute.
	 * @see #getSimpleAttribute()
	 * @generated
	 */
	void setSimpleAttribute(double value);

} // DoubleTest