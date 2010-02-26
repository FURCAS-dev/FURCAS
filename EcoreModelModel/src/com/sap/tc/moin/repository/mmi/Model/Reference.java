/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.tc.moin.repository.mmi.Model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.Reference#getExposedEnd <em>Exposed End</em>}</li>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.Reference#getReferencedEnd <em>Referenced End</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getReference()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='Model.Reference' metaObjectMofId='45ED2E2927D6234A5FEB4A9136C380ABBE1B3593' isStructureType='false'"
 * @generated
 */
public interface Reference extends StructuralFeature {
	/**
	 * Returns the value of the '<em><b>Exposed End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exposed End</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exposed End</em>' reference.
	 * @see #setExposedEnd(AssociationEnd)
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getReference_ExposedEnd()
	 * @model required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='Model.Exposes' metaObjectMofId='45ED2E29192FDBB8BCE642AC2DE4C73FB0EB657F' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	AssociationEnd getExposedEnd();

	/**
	 * Sets the value of the '{@link com.sap.tc.moin.repository.mmi.Model.Reference#getExposedEnd <em>Exposed End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exposed End</em>' reference.
	 * @see #getExposedEnd()
	 * @generated
	 */
	void setExposedEnd(AssociationEnd value);

	/**
	 * Returns the value of the '<em><b>Referenced End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced End</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced End</em>' reference.
	 * @see #setReferencedEnd(AssociationEnd)
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getReference_ReferencedEnd()
	 * @model required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='Model.RefersTo' metaObjectMofId='45ED2E2935733359781E47111E31E56279382F75' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	AssociationEnd getReferencedEnd();

	/**
	 * Sets the value of the '{@link com.sap.tc.moin.repository.mmi.Model.Reference#getReferencedEnd <em>Referenced End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced End</em>' reference.
	 * @see #getReferencedEnd()
	 * @generated
	 */
	void setReferencedEnd(AssociationEnd value);

} // Reference
