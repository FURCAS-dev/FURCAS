/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.status_and_action_old;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SAM Status Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavioral.status_and_action_old.SAMStatusValue#getName <em>Name</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMStatusValue#getSamStatusVariable <em>Sam Status Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMStatusValue()
 * @model
 * @generated
 */
public interface SAMStatusValue extends EObject {
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
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMStatusValue_Name()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	String getName();

	/**
     * Sets the value of the '{@link behavioral.status_and_action_old.SAMStatusValue#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
	void setName(String value);

	/**
     * Returns the value of the '<em><b>Sam Status Variable</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMStatusVariable#getSamStatusValues <em>Sam Status Values</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Status Variable</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Status Variable</em>' container reference.
     * @see #setSamStatusVariable(SAMStatusVariable)
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMStatusValue_SamStatusVariable()
     * @see behavioral.status_and_action_old.SAMStatusVariable#getSamStatusValues
     * @model opposite="samStatusValues" required="true"
     * @generated
     */
	SAMStatusVariable getSamStatusVariable();

	/**
     * Sets the value of the '{@link behavioral.status_and_action_old.SAMStatusValue#getSamStatusVariable <em>Sam Status Variable</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Sam Status Variable</em>' container reference.
     * @see #getSamStatusVariable()
     * @generated
     */
	void setSamStatusVariable(SAMStatusVariable value);

} // SAMStatusValue
