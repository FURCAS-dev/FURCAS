/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package abapmapping.abapdictionary;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abap Primtive Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link abapmapping.abapdictionary.AbapPrimtiveType#getLength <em>Length</em>}</li>
 * </ul>
 * </p>
 *
 * @see abapmapping.abapdictionary.AbapdictionaryPackage#getAbapPrimtiveType()
 * @model
 * @generated
 */
public interface AbapPrimtiveType extends UnstructuredAbapType {
	/**
     * Returns the value of the '<em><b>Length</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Length</em>' attribute.
     * @see #setLength(int)
     * @see abapmapping.abapdictionary.AbapdictionaryPackage#getAbapPrimtiveType_Length()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	int getLength();

	/**
     * Sets the value of the '{@link abapmapping.abapdictionary.AbapPrimtiveType#getLength <em>Length</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Length</em>' attribute.
     * @see #getLength()
     * @generated
     */
	void setLength(int value);

} // AbapPrimtiveType
