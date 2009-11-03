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
 * A representation of the model object '<em><b>Static Integer Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticIntegerTest#getSequenceAttribute <em>Sequence Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticIntegerTest#getSetAttribute <em>Set Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticIntegerTest#getOrderedSetAttribute <em>Ordered Set Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticIntegerTest#getSimpleAttribute <em>Simple Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticIntegerTest#getOptionalSimpleAttribute <em>Optional Simple Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticIntegerTest#getBagAttribute <em>Bag Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticIntegerTest#getDummy <em>Dummy</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.PrimitiveTypesStaticTestsPackage#getStaticIntegerTest()
 * @model
 * @generated
 */
public interface StaticIntegerTest extends MediniObject {
	/**
	 * Returns the value of the '<em><b>Sequence Attribute</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence Attribute</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence Attribute</em>' attribute list.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.PrimitiveTypesStaticTestsPackage#getStaticIntegerTest_SequenceAttribute()
	 * @model type="int" unique="false"
	 * @generated
	 */
	EList getSequenceAttribute();

	/**
	 * Returns the value of the '<em><b>Set Attribute</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Set Attribute</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Set Attribute</em>' attribute list.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.PrimitiveTypesStaticTestsPackage#getStaticIntegerTest_SetAttribute()
	 * @model type="int" ordered="false"
	 * @generated
	 */
	EList getSetAttribute();

	/**
	 * Returns the value of the '<em><b>Ordered Set Attribute</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ordered Set Attribute</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ordered Set Attribute</em>' attribute list.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.PrimitiveTypesStaticTestsPackage#getStaticIntegerTest_OrderedSetAttribute()
	 * @model type="int"
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
	 * @see #setSimpleAttribute(int)
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.PrimitiveTypesStaticTestsPackage#getStaticIntegerTest_SimpleAttribute()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	int getSimpleAttribute();

	/**
	 * Sets the value of the '{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticIntegerTest#getSimpleAttribute <em>Simple Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Attribute</em>' attribute.
	 * @see #getSimpleAttribute()
	 * @generated
	 */
	void setSimpleAttribute(int value);

	/**
	 * Returns the value of the '<em><b>Optional Simple Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Optional Simple Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Optional Simple Attribute</em>' attribute.
	 * @see #setOptionalSimpleAttribute(int)
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.PrimitiveTypesStaticTestsPackage#getStaticIntegerTest_OptionalSimpleAttribute()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	int getOptionalSimpleAttribute();

	/**
	 * Sets the value of the '{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticIntegerTest#getOptionalSimpleAttribute <em>Optional Simple Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optional Simple Attribute</em>' attribute.
	 * @see #getOptionalSimpleAttribute()
	 * @generated
	 */
	void setOptionalSimpleAttribute(int value);

	/**
	 * Returns the value of the '<em><b>Bag Attribute</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bag Attribute</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bag Attribute</em>' attribute list.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.PrimitiveTypesStaticTestsPackage#getStaticIntegerTest_BagAttribute()
	 * @model type="int" unique="false" ordered="false"
	 * @generated
	 */
	EList getBagAttribute();

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
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.PrimitiveTypesStaticTestsPackage#getStaticIntegerTest_Dummy()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	int getDummy();

	/**
	 * Sets the value of the '{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticIntegerTest#getDummy <em>Dummy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dummy</em>' attribute.
	 * @see #getDummy()
	 * @generated
	 */
	void setDummy(int value);

} // StaticIntegerTest