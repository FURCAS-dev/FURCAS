/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.tc.moin.repository.mmi.Model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.CollectionType#getMultiplicity <em>Multiplicity</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getCollectionType()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='Model.CollectionType' metaObjectMofId='E07A6DE164E626510A3611DEB84F0019993BA221' isStructureType='false'"
 * @generated
 */
public interface CollectionType extends TypedElement, DataType {
	/**
	 * Returns the value of the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiplicity</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiplicity</em>' containment reference.
	 * @see #setMultiplicity(MultiplicityType)
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getCollectionType_Multiplicity()
	 * @model containment="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='E07A6DE164E626500A3611DEB6450019993BA221'"
	 * @generated
	 */
	MultiplicityType getMultiplicity();

	/**
	 * Sets the value of the '{@link com.sap.tc.moin.repository.mmi.Model.CollectionType#getMultiplicity <em>Multiplicity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multiplicity</em>' containment reference.
	 * @see #getMultiplicity()
	 * @generated
	 */
	void setMultiplicity(MultiplicityType value);

} // CollectionType
