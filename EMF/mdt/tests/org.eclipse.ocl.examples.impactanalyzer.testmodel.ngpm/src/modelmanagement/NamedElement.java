/**
 * <copyright>
 * </copyright>
 *
 * $Id: NamedElement.java,v 1.1 2011/02/07 17:16:09 auhl Exp $
 */
package modelmanagement;

import localization.TranslatableText;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link modelmanagement.NamedElement#getName <em>Name</em>}</li>
 *   <li>{@link modelmanagement.NamedElement#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see modelmanagement.ModelmanagementPackage#getNamedElement()
 * @model abstract="true"
 * @generated
 */
public interface NamedElement extends EObject {
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
     * @see modelmanagement.ModelmanagementPackage#getNamedElement_Name()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	String getName();

	/**
     * Sets the value of the '{@link modelmanagement.NamedElement#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
	void setName(String value);

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
     * @see modelmanagement.ModelmanagementPackage#getNamedElement_Description()
     * @model containment="true" ordered="false"
     * @generated
     */
	TranslatableText getDescription();

	/**
     * Sets the value of the '{@link modelmanagement.NamedElement#getDescription <em>Description</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Description</em>' containment reference.
     * @see #getDescription()
     * @generated
     */
	void setDescription(TranslatableText value);

} // NamedElement
