/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.tc.moin.repository.mmi.Model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Structural Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.StructuralFeature#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.StructuralFeature#isIsChangeable <em>Is Changeable</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getStructuralFeature()
 * @model abstract="true"
 * @generated
 */
public interface StructuralFeature extends Feature, TypedElement {
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
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getStructuralFeature_Multiplicity()
	 * @model containment="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='45ED2E29E564ECD211A1449105FDCEEB38C6634A'"
	 * @generated
	 */
	MultiplicityType getMultiplicity();

	/**
	 * Sets the value of the '{@link com.sap.tc.moin.repository.mmi.Model.StructuralFeature#getMultiplicity <em>Multiplicity</em>}' containment reference.
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
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getStructuralFeature_IsChangeable()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsChangeable();

	/**
	 * Sets the value of the '{@link com.sap.tc.moin.repository.mmi.Model.StructuralFeature#isIsChangeable <em>Is Changeable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Changeable</em>' attribute.
	 * @see #isIsChangeable()
	 * @generated
	 */
	void setIsChangeable(boolean value);

} // StructuralFeature
