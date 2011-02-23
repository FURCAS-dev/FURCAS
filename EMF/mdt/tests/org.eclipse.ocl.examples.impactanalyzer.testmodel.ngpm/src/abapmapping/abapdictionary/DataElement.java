/**
 * <copyright>
 * </copyright>
 *
 * $Id: DataElement.java,v 1.1 2011/02/07 17:16:09 auhl Exp $
 */
package abapmapping.abapdictionary;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link abapmapping.abapdictionary.DataElement#getAbapType <em>Abap Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see abapmapping.abapdictionary.AbapdictionaryPackage#getDataElement()
 * @model
 * @generated
 */
public interface DataElement extends UnstructuredAbapType {
	/**
     * Returns the value of the '<em><b>Abap Type</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abap Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Abap Type</em>' reference.
     * @see #setAbapType(AbapPrimtiveType)
     * @see abapmapping.abapdictionary.AbapdictionaryPackage#getDataElement_AbapType()
     * @model required="true"
     * @generated
     */
	AbapPrimtiveType getAbapType();

	/**
     * Sets the value of the '{@link abapmapping.abapdictionary.DataElement#getAbapType <em>Abap Type</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Abap Type</em>' reference.
     * @see #getAbapType()
     * @generated
     */
	void setAbapType(AbapPrimtiveType value);

} // DataElement
