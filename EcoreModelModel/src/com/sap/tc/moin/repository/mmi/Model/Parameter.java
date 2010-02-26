/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.tc.moin.repository.mmi.Model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.Parameter#getDirection <em>Direction</em>}</li>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.Parameter#getMultiplicity <em>Multiplicity</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getParameter()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='Model.Parameter' metaObjectMofId='45ED2E29A900062A80A049E01ED7EBBBCB1ECB46' isStructureType='false'"
 * @generated
 */
public interface Parameter extends TypedElement {
	/**
	 * Returns the value of the '<em><b>Direction</b></em>' attribute.
	 * The literals are from the enumeration {@link com.sap.tc.moin.repository.mmi.Model.DirectionKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direction</em>' attribute.
	 * @see com.sap.tc.moin.repository.mmi.Model.DirectionKind
	 * @see #setDirection(DirectionKind)
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getParameter_Direction()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	DirectionKind getDirection();

	/**
	 * Sets the value of the '{@link com.sap.tc.moin.repository.mmi.Model.Parameter#getDirection <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction</em>' attribute.
	 * @see com.sap.tc.moin.repository.mmi.Model.DirectionKind
	 * @see #getDirection()
	 * @generated
	 */
	void setDirection(DirectionKind value);

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
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getParameter_Multiplicity()
	 * @model containment="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='45ED2E29DFC4906A7103466E07DE9423EFE4A909'"
	 * @generated
	 */
	MultiplicityType getMultiplicity();

	/**
	 * Sets the value of the '{@link com.sap.tc.moin.repository.mmi.Model.Parameter#getMultiplicity <em>Multiplicity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multiplicity</em>' containment reference.
	 * @see #getMultiplicity()
	 * @generated
	 */
	void setMultiplicity(MultiplicityType value);

} // Parameter
