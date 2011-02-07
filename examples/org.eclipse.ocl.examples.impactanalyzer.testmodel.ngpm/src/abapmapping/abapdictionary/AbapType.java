/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbapType.java,v 1.1 2011/02/07 16:43:31 auhl Exp $
 */
package abapmapping.abapdictionary;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abap Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link abapmapping.abapdictionary.AbapType#getName <em>Name</em>}</li>
 *   <li>{@link abapmapping.abapdictionary.AbapType#getXsdRepresentation <em>Xsd Representation</em>}</li>
 * </ul>
 * </p>
 *
 * @see abapmapping.abapdictionary.AbapdictionaryPackage#getAbapType()
 * @model
 * @generated
 */
public interface AbapType extends EObject {
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
     * @see abapmapping.abapdictionary.AbapdictionaryPackage#getAbapType_Name()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	String getName();

	/**
     * Sets the value of the '{@link abapmapping.abapdictionary.AbapType#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
	void setName(String value);

	/**
     * Returns the value of the '<em><b>Xsd Representation</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xsd Representation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Xsd Representation</em>' reference.
     * @see #setXsdRepresentation(XsdType)
     * @see abapmapping.abapdictionary.AbapdictionaryPackage#getAbapType_XsdRepresentation()
     * @model required="true"
     * @generated
     */
	XsdType getXsdRepresentation();

	/**
     * Sets the value of the '{@link abapmapping.abapdictionary.AbapType#getXsdRepresentation <em>Xsd Representation</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Xsd Representation</em>' reference.
     * @see #getXsdRepresentation()
     * @generated
     */
	void setXsdRepresentation(XsdType value);

} // AbapType
