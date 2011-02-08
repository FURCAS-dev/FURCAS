/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbapStructureField.java,v 1.1 2011/02/07 17:16:09 auhl Exp $
 */
package abapmapping.abapdictionary;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abap Structure Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link abapmapping.abapdictionary.AbapStructureField#getName <em>Name</em>}</li>
 *   <li>{@link abapmapping.abapdictionary.AbapStructureField#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see abapmapping.abapdictionary.AbapdictionaryPackage#getAbapStructureField()
 * @model
 * @generated
 */
public interface AbapStructureField extends EObject {
	/**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see abapmapping.abapdictionary.AbapdictionaryPackage#getAbapStructureField_Name()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	String getName();

	/**
     * Sets the value of the '{@link abapmapping.abapdictionary.AbapStructureField#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
	void setName(String value);

	/**
     * Returns the value of the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' reference.
     * @see #setType(AbapType)
     * @see abapmapping.abapdictionary.AbapdictionaryPackage#getAbapStructureField_Type()
     * @model required="true"
     * @generated
     */
	AbapType getType();

	/**
     * Sets the value of the '{@link abapmapping.abapdictionary.AbapStructureField#getType <em>Type</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' reference.
     * @see #getType()
     * @generated
     */
	void setType(AbapType value);

} // AbapStructureField
