/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.tc.moin.repository.mmi.Model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association End</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.AssociationEnd#isIsNavigable <em>Is Navigable</em>}</li>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.AssociationEnd#getAggregation <em>Aggregation</em>}</li>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.AssociationEnd#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.AssociationEnd#isIsChangeable <em>Is Changeable</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getAssociationEnd()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='Model.AssociationEnd' metaObjectMofId='45ED2E294D5F42A5B94C462B13F4F76DE1C16DBF' isStructureType='false'"
 * @generated
 */
public interface AssociationEnd extends TypedElement {
	/**
	 * Returns the value of the '<em><b>Is Navigable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Navigable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Navigable</em>' attribute.
	 * @see #setIsNavigable(boolean)
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getAssociationEnd_IsNavigable()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsNavigable();

	/**
	 * Sets the value of the '{@link com.sap.tc.moin.repository.mmi.Model.AssociationEnd#isIsNavigable <em>Is Navigable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Navigable</em>' attribute.
	 * @see #isIsNavigable()
	 * @generated
	 */
	void setIsNavigable(boolean value);

	/**
	 * Returns the value of the '<em><b>Aggregation</b></em>' attribute.
	 * The literals are from the enumeration {@link com.sap.tc.moin.repository.mmi.Model.AggregationKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aggregation</em>' attribute.
	 * @see com.sap.tc.moin.repository.mmi.Model.AggregationKind
	 * @see #setAggregation(AggregationKind)
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getAssociationEnd_Aggregation()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	AggregationKind getAggregation();

	/**
	 * Sets the value of the '{@link com.sap.tc.moin.repository.mmi.Model.AssociationEnd#getAggregation <em>Aggregation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aggregation</em>' attribute.
	 * @see com.sap.tc.moin.repository.mmi.Model.AggregationKind
	 * @see #getAggregation()
	 * @generated
	 */
	void setAggregation(AggregationKind value);

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
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getAssociationEnd_Multiplicity()
	 * @model containment="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='45ED2E29C7FBD27A2BCB41EE3695E4606F8C01E9'"
	 * @generated
	 */
	MultiplicityType getMultiplicity();

	/**
	 * Sets the value of the '{@link com.sap.tc.moin.repository.mmi.Model.AssociationEnd#getMultiplicity <em>Multiplicity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multiplicity</em>' containment reference.
	 * @see #getMultiplicity()
	 * @generated
	 */
	void setMultiplicity(MultiplicityType value);

	/**
	 * Returns the value of the '<em><b>Is Changeable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Changeable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Changeable</em>' attribute.
	 * @see #setIsChangeable(boolean)
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getAssociationEnd_IsChangeable()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsChangeable();

	/**
	 * Sets the value of the '{@link com.sap.tc.moin.repository.mmi.Model.AssociationEnd#isIsChangeable <em>Is Changeable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Changeable</em>' attribute.
	 * @see #isIsChangeable()
	 * @generated
	 */
	void setIsChangeable(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	AssociationEnd otherEnd();

} // AssociationEnd
