/**
 * <copyright>
 * </copyright>
 *
 * $Id: CodeValue.java,v 1.1 2011/02/07 17:16:09 auhl Exp $
 */
package abapmapping.abapdictionary;

import localization.TranslatableText;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Code Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * We deliberately reduced code values to unstructured, primitive values. Those examples that we are aware of where codes are of structured types only contain unmaintained attributes such as LIST_AGENCY_IDs and other supplementary components that can in our opinion safely be omitted for the time being.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link abapmapping.abapdictionary.CodeValue#getValue <em>Value</em>}</li>
 *   <li>{@link abapmapping.abapdictionary.CodeValue#getDescription <em>Description</em>}</li>
 *   <li>{@link abapmapping.abapdictionary.CodeValue#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see abapmapping.abapdictionary.AbapdictionaryPackage#getCodeValue()
 * @model
 * @generated
 */
public interface CodeValue extends EObject {
	/**
     * Returns the value of the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Value</em>' attribute.
     * @see #setValue(String)
     * @see abapmapping.abapdictionary.AbapdictionaryPackage#getCodeValue_Value()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	String getValue();

	/**
     * Sets the value of the '{@link abapmapping.abapdictionary.CodeValue#getValue <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' attribute.
     * @see #getValue()
     * @generated
     */
	void setValue(String value);

	/**
     * Returns the value of the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Description</em>' containment reference.
     * @see #setDescription(TranslatableText)
     * @see abapmapping.abapdictionary.AbapdictionaryPackage#getCodeValue_Description()
     * @model containment="true" required="true" ordered="false"
     * @generated
     */
	TranslatableText getDescription();

	/**
     * Sets the value of the '{@link abapmapping.abapdictionary.CodeValue#getDescription <em>Description</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Description</em>' containment reference.
     * @see #getDescription()
     * @generated
     */
	void setDescription(TranslatableText value);

	/**
     * Returns the value of the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' reference.
     * @see #setType(AbapPrimtiveType)
     * @see abapmapping.abapdictionary.AbapdictionaryPackage#getCodeValue_Type()
     * @model required="true"
     * @generated
     */
	AbapPrimtiveType getType();

	/**
     * Sets the value of the '{@link abapmapping.abapdictionary.CodeValue#getType <em>Type</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' reference.
     * @see #getType()
     * @generated
     */
	void setType(AbapPrimtiveType value);

} // CodeValue
