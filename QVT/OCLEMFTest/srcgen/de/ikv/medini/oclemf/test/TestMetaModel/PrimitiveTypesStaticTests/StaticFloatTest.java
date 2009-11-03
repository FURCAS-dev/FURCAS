/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests;

import de.ikv.medini.kernel.MediniObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Static Float Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticFloatTest#getSequenceAttribute <em>Sequence Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticFloatTest#getSetAttribute <em>Set Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticFloatTest#getOrderedSetAttribute <em>Ordered Set Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticFloatTest#getSimpleAttribute <em>Simple Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticFloatTest#getOptionalSimpleAttribute <em>Optional Simple Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticFloatTest#getDummy <em>Dummy</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticFloatTest#getBagAttribute <em>Bag Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.PrimitiveTypesStaticTestsPackage#getStaticFloatTest()
 * @model
 * @generated
 */
public interface StaticFloatTest extends MediniObject {
	/**
	 * Returns the value of the '<em><b>Sequence Attribute</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Float}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence Attribute</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence Attribute</em>' attribute list.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.PrimitiveTypesStaticTestsPackage#getStaticFloatTest_SequenceAttribute()
	 * @model type="float" unique="false"
	 * @generated
	 */
	EList getSequenceAttribute();

	/**
	 * Returns the value of the '<em><b>Set Attribute</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Float}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Set Attribute</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Set Attribute</em>' attribute list.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.PrimitiveTypesStaticTestsPackage#getStaticFloatTest_SetAttribute()
	 * @model type="float" ordered="false"
	 * @generated
	 */
	EList getSetAttribute();

	/**
	 * Returns the value of the '<em><b>Ordered Set Attribute</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Float}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ordered Set Attribute</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ordered Set Attribute</em>' attribute list.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.PrimitiveTypesStaticTestsPackage#getStaticFloatTest_OrderedSetAttribute()
	 * @model type="float"
	 * @generated
	 */
	EList getOrderedSetAttribute();

	/**
	 * Returns the value of the '<em><b>Simple Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Attribute</em>' attribute.
	 * @see #setSimpleAttribute(float)
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.PrimitiveTypesStaticTestsPackage#getStaticFloatTest_SimpleAttribute()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	float getSimpleAttribute();

	/**
	 * Sets the value of the '{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticFloatTest#getSimpleAttribute <em>Simple Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Attribute</em>' attribute.
	 * @see #getSimpleAttribute()
	 * @generated
	 */
	void setSimpleAttribute(float value);

	/**
	 * Returns the value of the '<em><b>Optional Simple Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Optional Simple Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Optional Simple Attribute</em>' attribute.
	 * @see #setOptionalSimpleAttribute(float)
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.PrimitiveTypesStaticTestsPackage#getStaticFloatTest_OptionalSimpleAttribute()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	float getOptionalSimpleAttribute();

	/**
	 * Sets the value of the '{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticFloatTest#getOptionalSimpleAttribute <em>Optional Simple Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optional Simple Attribute</em>' attribute.
	 * @see #getOptionalSimpleAttribute()
	 * @generated
	 */
	void setOptionalSimpleAttribute(float value);

	/**
	 * Returns the value of the '<em><b>Dummy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dummy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dummy</em>' attribute.
	 * @see #setDummy(int)
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.PrimitiveTypesStaticTestsPackage#getStaticFloatTest_Dummy()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	int getDummy();

	/**
	 * Sets the value of the '{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticFloatTest#getDummy <em>Dummy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dummy</em>' attribute.
	 * @see #getDummy()
	 * @generated
	 */
	void setDummy(int value);

	/**
	 * Returns the value of the '<em><b>Bag Attribute</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Float}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bag Attribute</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bag Attribute</em>' attribute list.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.PrimitiveTypesStaticTestsPackage#getStaticFloatTest_BagAttribute()
	 * @model type="float" unique="false" ordered="false"
	 * @generated
	 */
	EList getBagAttribute();

} // StaticFloatTest