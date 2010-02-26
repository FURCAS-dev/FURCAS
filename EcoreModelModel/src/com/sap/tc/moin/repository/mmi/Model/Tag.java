/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.tc.moin.repository.mmi.Model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tag</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.Tag#getTagId <em>Tag Id</em>}</li>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.Tag#getValues <em>Values</em>}</li>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.Tag#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getTag()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='Model.Tag' metaObjectMofId='45ED2E29545D7A2836A940A93CC3A3E5E8010D2D' isStructureType='false'"
 * @generated
 */
public interface Tag extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Tag Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tag Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tag Id</em>' attribute.
	 * @see #setTagId(String)
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getTag_TagId()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getTagId();

	/**
	 * Sets the value of the '{@link com.sap.tc.moin.repository.mmi.Model.Tag#getTagId <em>Tag Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tag Id</em>' attribute.
	 * @see #getTagId()
	 * @generated
	 */
	void setTagId(String value);

	/**
	 * Returns the value of the '<em><b>Values</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' attribute list.
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getTag_Values()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getValues();

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' reference list.
	 * The list contents are of type {@link com.sap.tc.moin.repository.mmi.Model.ModelElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' reference list.
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getTag_Elements()
	 * @model required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='Model.AttachesTo' metaObjectMofId='45ED2E29092EBA89637D4A76065DC0F48C45219D' storedEnd='1' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	EList<ModelElement> getElements();

} // Tag
