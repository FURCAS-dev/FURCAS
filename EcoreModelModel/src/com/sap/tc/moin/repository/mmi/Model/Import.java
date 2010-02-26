/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.tc.moin.repository.mmi.Model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.Import#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.Import#isIsClustered <em>Is Clustered</em>}</li>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.Import#getImportedNamespace <em>Imported Namespace</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getImport()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='Model.Import' metaObjectMofId='45ED2E29372BCE32CB9241CD1FB9E2F08880B940' isStructureType='false'"
 * @generated
 */
public interface Import extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Visibility</b></em>' attribute.
	 * The literals are from the enumeration {@link com.sap.tc.moin.repository.mmi.Model.VisibilityKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visibility</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visibility</em>' attribute.
	 * @see com.sap.tc.moin.repository.mmi.Model.VisibilityKind
	 * @see #setVisibility(VisibilityKind)
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getImport_Visibility()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	VisibilityKind getVisibility();

	/**
	 * Sets the value of the '{@link com.sap.tc.moin.repository.mmi.Model.Import#getVisibility <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visibility</em>' attribute.
	 * @see com.sap.tc.moin.repository.mmi.Model.VisibilityKind
	 * @see #getVisibility()
	 * @generated
	 */
	void setVisibility(VisibilityKind value);

	/**
	 * Returns the value of the '<em><b>Is Clustered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Clustered</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Clustered</em>' attribute.
	 * @see #setIsClustered(boolean)
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getImport_IsClustered()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsClustered();

	/**
	 * Sets the value of the '{@link com.sap.tc.moin.repository.mmi.Model.Import#isIsClustered <em>Is Clustered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Clustered</em>' attribute.
	 * @see #isIsClustered()
	 * @generated
	 */
	void setIsClustered(boolean value);

	/**
	 * Returns the value of the '<em><b>Imported Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported Namespace</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported Namespace</em>' reference.
	 * @see #setImportedNamespace(Namespace)
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getImport_ImportedNamespace()
	 * @model required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='Model.Aliases' metaObjectMofId='45ED2E297C6E4C4F64E543CC20E2ED5F34992C72' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	Namespace getImportedNamespace();

	/**
	 * Sets the value of the '{@link com.sap.tc.moin.repository.mmi.Model.Import#getImportedNamespace <em>Imported Namespace</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Imported Namespace</em>' reference.
	 * @see #getImportedNamespace()
	 * @generated
	 */
	void setImportedNamespace(Namespace value);

} // Import
