/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Super Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.SuperClass#getSuperName <em>Super Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.ClassifierTestPackage#getSuperClass()
 * @model
 * @generated
 */
public interface SuperClass extends AbstractSuperClass {
	/**
	 * Returns the value of the '<em><b>Super Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Name</em>' attribute.
	 * @see #setSuperName(String)
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.ClassifierTestPackage#getSuperClass_SuperName()
	 * @model default="" unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getSuperName();

	/**
	 * Sets the value of the '{@link de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.SuperClass#getSuperName <em>Super Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Name</em>' attribute.
	 * @see #getSuperName()
	 * @generated
	 */
	void setSuperName(String value);

} // SuperClass