/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.tc.moin.repository.mmi.Model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.Class#isIsSingleton <em>Is Singleton</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getClass_()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='Model.Class' metaObjectMofId='45ED2E29E9B8C271FD484D6E2F52CCB9570C451A' isStructureType='false'"
 * @generated
 */
public interface Class extends Classifier {
	/**
	 * Returns the value of the '<em><b>Is Singleton</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Singleton</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Singleton</em>' attribute.
	 * @see #setIsSingleton(boolean)
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getClass_IsSingleton()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsSingleton();

	/**
	 * Sets the value of the '{@link com.sap.tc.moin.repository.mmi.Model.Class#isIsSingleton <em>Is Singleton</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Singleton</em>' attribute.
	 * @see #isIsSingleton()
	 * @generated
	 */
	void setIsSingleton(boolean value);

} // Class
