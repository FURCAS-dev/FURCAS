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
 * A representation of the model object '<em><b>Static Boolean Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticBooleanTest#isSimpleAttribute <em>Simple Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticBooleanTest#getOrderedSetAttribute <em>Ordered Set Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticBooleanTest#getSetAttribute <em>Set Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticBooleanTest#getBagAttribute <em>Bag Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticBooleanTest#isOptionalSimpleAttribute <em>Optional Simple Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticBooleanTest#getSequenceAttribute <em>Sequence Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticBooleanTest#getDummy <em>Dummy</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.PrimitiveTypesStaticTestsPackage#getStaticBooleanTest()
 * @model
 * @generated
 */
public interface StaticBooleanTest extends MediniObject {
	/**
	 * Returns the value of the '<em><b>Simple Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Attribute</em>' attribute.
	 * @see #setSimpleAttribute(boolean)
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.PrimitiveTypesStaticTestsPackage#getStaticBooleanTest_SimpleAttribute()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isSimpleAttribute();

	/**
	 * Sets the value of the '{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticBooleanTest#isSimpleAttribute <em>Simple Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Attribute</em>' attribute.
	 * @see #isSimpleAttribute()
	 * @generated
	 */
	void setSimpleAttribute(boolean value);

	/**
	 * Returns the value of the '<em><b>Ordered Set Attribute</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Boolean}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ordered Set Attribute</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ordered Set Attribute</em>' attribute list.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.PrimitiveTypesStaticTestsPackage#getStaticBooleanTest_OrderedSetAttribute()
	 * @model type="boolean"
	 * @generated
	 */
	EList getOrderedSetAttribute();

	/**
	 * Returns the value of the '<em><b>Set Attribute</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Boolean}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Set Attribute</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Set Attribute</em>' attribute list.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.PrimitiveTypesStaticTestsPackage#getStaticBooleanTest_SetAttribute()
	 * @model type="boolean" ordered="false"
	 * @generated
	 */
	EList getSetAttribute();

	/**
	 * Returns the value of the '<em><b>Bag Attribute</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Boolean}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bag Attribute</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bag Attribute</em>' attribute list.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.PrimitiveTypesStaticTestsPackage#getStaticBooleanTest_BagAttribute()
	 * @model type="boolean" unique="false" ordered="false"
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
	 * @see #setOptionalSimpleAttribute(boolean)
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.PrimitiveTypesStaticTestsPackage#getStaticBooleanTest_OptionalSimpleAttribute()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	boolean isOptionalSimpleAttribute();

	/**
	 * Sets the value of the '{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticBooleanTest#isOptionalSimpleAttribute <em>Optional Simple Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optional Simple Attribute</em>' attribute.
	 * @see #isOptionalSimpleAttribute()
	 * @generated
	 */
	void setOptionalSimpleAttribute(boolean value);

	/**
	 * Returns the value of the '<em><b>Sequence Attribute</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Boolean}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence Attribute</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence Attribute</em>' attribute list.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.PrimitiveTypesStaticTestsPackage#getStaticBooleanTest_SequenceAttribute()
	 * @model type="boolean" unique="false"
	 * @generated
	 */
	EList getSequenceAttribute();

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
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.PrimitiveTypesStaticTestsPackage#getStaticBooleanTest_Dummy()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	int getDummy();

	/**
	 * Sets the value of the '{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticBooleanTest#getDummy <em>Dummy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dummy</em>' attribute.
	 * @see #getDummy()
	 * @generated
	 */
	void setDummy(int value);

} // StaticBooleanTest