/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.status_and_action_old;

import data.classes.SapClass;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SAM Status Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavioral.status_and_action_old.SAMStatusVariable#getName <em>Name</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMStatusVariable#isIsAgentVariable <em>Is Agent Variable</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMStatusVariable#getBusinessObjectNode <em>Business Object Node</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMStatusVariable#getSamStatusValues <em>Sam Status Values</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMStatusVariable#getSamSchemaVariables <em>Sam Schema Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMStatusVariable()
 * @model
 * @generated
 */
public interface SAMStatusVariable extends EObject {
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
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMStatusVariable_Name()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	String getName();

	/**
     * Sets the value of the '{@link behavioral.status_and_action_old.SAMStatusVariable#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
	void setName(String value);

	/**
     * Returns the value of the '<em><b>Is Agent Variable</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Agent Variable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Is Agent Variable</em>' attribute.
     * @see #setIsAgentVariable(boolean)
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMStatusVariable_IsAgentVariable()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	boolean isIsAgentVariable();

	/**
     * Sets the value of the '{@link behavioral.status_and_action_old.SAMStatusVariable#isIsAgentVariable <em>Is Agent Variable</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Is Agent Variable</em>' attribute.
     * @see #isIsAgentVariable()
     * @generated
     */
	void setIsAgentVariable(boolean value);

	/**
     * Returns the value of the '<em><b>Business Object Node</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link data.classes.SapClass#getSamStatusVariables <em>Sam Status Variables</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Business Object Node</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Business Object Node</em>' container reference.
     * @see #setBusinessObjectNode(SapClass)
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMStatusVariable_BusinessObjectNode()
     * @see data.classes.SapClass#getSamStatusVariables
     * @model opposite="samStatusVariables" required="true"
     * @generated
     */
	SapClass getBusinessObjectNode();

	/**
     * Sets the value of the '{@link behavioral.status_and_action_old.SAMStatusVariable#getBusinessObjectNode <em>Business Object Node</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Business Object Node</em>' container reference.
     * @see #getBusinessObjectNode()
     * @generated
     */
	void setBusinessObjectNode(SapClass value);

	/**
     * Returns the value of the '<em><b>Sam Status Values</b></em>' containment reference list.
     * The list contents are of type {@link behavioral.status_and_action_old.SAMStatusValue}.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMStatusValue#getSamStatusVariable <em>Sam Status Variable</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Status Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Status Values</em>' containment reference list.
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMStatusVariable_SamStatusValues()
     * @see behavioral.status_and_action_old.SAMStatusValue#getSamStatusVariable
     * @model opposite="samStatusVariable" containment="true" resolveProxies="true"
     * @generated
     */
	EList<SAMStatusValue> getSamStatusValues();

	/**
     * Returns the value of the '<em><b>Sam Schema Variables</b></em>' reference list.
     * The list contents are of type {@link behavioral.status_and_action_old.SAMSchemaVariable}.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMSchemaVariable#getSamSchemaValue <em>Sam Schema Value</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Schema Variables</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Schema Variables</em>' reference list.
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMStatusVariable_SamSchemaVariables()
     * @see behavioral.status_and_action_old.SAMSchemaVariable#getSamSchemaValue
     * @model opposite="samSchemaValue"
     * @generated
     */
	EList<SAMSchemaVariable> getSamSchemaVariables();

} // SAMStatusVariable
