/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests;

import de.ikv.medini.kernel.MediniObject;

import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticIntegerTest;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Navigable Association Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.NavigableAssociationTest#getComponentEnd <em>Component End</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.NavigableAssociationTest#getAggregate <em>Aggregate</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.RelationshipTestsPackage#getNavigableAssociationTest()
 * @model
 * @generated
 */
public interface NavigableAssociationTest extends MediniObject {
	/**
	 * Returns the value of the '<em><b>Component End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component End</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component End</em>' reference.
	 * @see #setComponentEnd(StaticIntegerTest)
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.RelationshipTestsPackage#getNavigableAssociationTest_ComponentEnd()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	StaticIntegerTest getComponentEnd();

	/**
	 * Sets the value of the '{@link de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.NavigableAssociationTest#getComponentEnd <em>Component End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component End</em>' reference.
	 * @see #getComponentEnd()
	 * @generated
	 */
	void setComponentEnd(StaticIntegerTest value);

	/**
	 * Returns the value of the '<em><b>Aggregate</b></em>' reference list.
	 * The list contents are of type {@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticLongTest}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregate</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aggregate</em>' reference list.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.RelationshipTestsPackage#getNavigableAssociationTest_Aggregate()
	 * @model type="de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticLongTest" ordered="false"
	 * @generated
	 */
	EList getAggregate();

} // NavigableAssociationTest