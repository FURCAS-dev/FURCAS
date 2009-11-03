/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests;

import de.ikv.medini.kernel.MediniObject;

import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StringTest;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.ClassTest#getMultiClassReference <em>Multi Class Reference</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.ClassTest#getSingleClassReference <em>Single Class Reference</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.ClassTest#getSingleClassAttribute <em>Single Class Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.ClassTest#getMultiUniqueClassAttribute <em>Multi Unique Class Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.ClassTest#getMultiNonUniqueClassAttribute <em>Multi Non Unique Class Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.RelationshipTestsPackage#getClassTest()
 * @model
 * @generated
 */
public interface ClassTest extends MediniObject {
	/**
	 * Returns the value of the '<em><b>Multi Class Reference</b></em>' reference list.
	 * The list contents are of type {@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticBooleanTest}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multi Class Reference</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multi Class Reference</em>' reference list.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.RelationshipTestsPackage#getClassTest_MultiClassReference()
	 * @model type="de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticBooleanTest" ordered="false"
	 * @generated
	 */
	EList getMultiClassReference();

	/**
	 * Returns the value of the '<em><b>Single Class Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Single Class Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Single Class Reference</em>' reference.
	 * @see #setSingleClassReference(StringTest)
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.RelationshipTestsPackage#getClassTest_SingleClassReference()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	StringTest getSingleClassReference();

	/**
	 * Sets the value of the '{@link de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.ClassTest#getSingleClassReference <em>Single Class Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Single Class Reference</em>' reference.
	 * @see #getSingleClassReference()
	 * @generated
	 */
	void setSingleClassReference(StringTest value);

	/**
	 * Returns the value of the '<em><b>Single Class Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Single Class Attribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Single Class Attribute</em>' reference.
	 * @see #setSingleClassAttribute(de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.StringTest)
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.RelationshipTestsPackage#getClassTest_SingleClassAttribute()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.StringTest getSingleClassAttribute();

	/**
	 * Sets the value of the '{@link de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.ClassTest#getSingleClassAttribute <em>Single Class Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Single Class Attribute</em>' reference.
	 * @see #getSingleClassAttribute()
	 * @generated
	 */
	void setSingleClassAttribute(de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.StringTest value);

	/**
	 * Returns the value of the '<em><b>Multi Unique Class Attribute</b></em>' reference list.
	 * The list contents are of type {@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.IntegerTest}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multi Unique Class Attribute</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multi Unique Class Attribute</em>' reference list.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.RelationshipTestsPackage#getClassTest_MultiUniqueClassAttribute()
	 * @model type="de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.IntegerTest" ordered="false"
	 * @generated
	 */
	EList getMultiUniqueClassAttribute();

	/**
	 * Returns the value of the '<em><b>Multi Non Unique Class Attribute</b></em>' reference list.
	 * The list contents are of type {@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.StringTest}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multi Non Unique Class Attribute</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multi Non Unique Class Attribute</em>' reference list.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.RelationshipTestsPackage#getClassTest_MultiNonUniqueClassAttribute()
	 * @model type="de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.StringTest" ordered="false"
	 * @generated
	 */
	EList getMultiNonUniqueClassAttribute();

} // ClassTest