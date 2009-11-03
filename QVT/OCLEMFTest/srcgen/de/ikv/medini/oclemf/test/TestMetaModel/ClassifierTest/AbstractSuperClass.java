/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest;

import de.ikv.medini.kernel.MediniObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Super Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.AbstractSuperClass#getSubClass <em>Sub Class</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.AbstractSuperClass#getAbstractSuperName <em>Abstract Super Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.ClassifierTestPackage#getAbstractSuperClass()
 * @model
 * @generated
 */
public interface AbstractSuperClass extends MediniObject {
	/**
	 * Returns the value of the '<em><b>Sub Class</b></em>' reference list.
	 * The list contents are of type {@link de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.SubClass}.
	 * It is bidirectional and its opposite is '{@link de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.SubClass#getAbstractSuperClass <em>Abstract Super Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Class</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Class</em>' reference list.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.ClassifierTestPackage#getAbstractSuperClass_SubClass()
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.SubClass#getAbstractSuperClass
	 * @model type="de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.SubClass" opposite="abstractSuperClass" ordered="false"
	 * @generated
	 */
	EList getSubClass();

	/**
	 * Returns the value of the '<em><b>Abstract Super Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract Super Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract Super Name</em>' attribute.
	 * @see #setAbstractSuperName(String)
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.ClassifierTestPackage#getAbstractSuperClass_AbstractSuperName()
	 * @model default="" unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getAbstractSuperName();

	/**
	 * Sets the value of the '{@link de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.AbstractSuperClass#getAbstractSuperName <em>Abstract Super Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract Super Name</em>' attribute.
	 * @see #getAbstractSuperName()
	 * @generated
	 */
	void setAbstractSuperName(String value);

} // AbstractSuperClass