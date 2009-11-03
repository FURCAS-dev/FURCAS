/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.SubClass#getSubName <em>Sub Name</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.SubClass#getAbstractSuperClass <em>Abstract Super Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.ClassifierTestPackage#getSubClass()
 * @model
 * @generated
 */
public interface SubClass extends SuperClass {
	/**
	 * Returns the value of the '<em><b>Sub Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Name</em>' attribute.
	 * @see #setSubName(String)
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.ClassifierTestPackage#getSubClass_SubName()
	 * @model default="" unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getSubName();

	/**
	 * Sets the value of the '{@link de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.SubClass#getSubName <em>Sub Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Name</em>' attribute.
	 * @see #getSubName()
	 * @generated
	 */
	void setSubName(String value);

	/**
	 * Returns the value of the '<em><b>Abstract Super Class</b></em>' reference list.
	 * The list contents are of type {@link de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.AbstractSuperClass}.
	 * It is bidirectional and its opposite is '{@link de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.AbstractSuperClass#getSubClass <em>Sub Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract Super Class</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract Super Class</em>' reference list.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.ClassifierTestPackage#getSubClass_AbstractSuperClass()
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.AbstractSuperClass#getSubClass
	 * @model type="de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.AbstractSuperClass" opposite="subClass" ordered="false"
	 * @generated
	 */
	EList getAbstractSuperClass();

} // SubClass