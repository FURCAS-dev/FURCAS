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
 * A representation of the model object '<em><b>SAM Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavioral.status_and_action_old.SAMAction#getName <em>Name</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMAction#isIsAgentAction <em>Is Agent Action</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMAction#getBusinessObjectNode <em>Business Object Node</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMAction#getSamSchemaActions <em>Sam Schema Actions</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMAction()
 * @model
 * @generated
 */
public interface SAMAction extends EObject {
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
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMAction_Name()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	String getName();

	/**
     * Sets the value of the '{@link behavioral.status_and_action_old.SAMAction#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
	void setName(String value);

	/**
     * Returns the value of the '<em><b>Is Agent Action</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Agent Action</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Is Agent Action</em>' attribute.
     * @see #setIsAgentAction(boolean)
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMAction_IsAgentAction()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	boolean isIsAgentAction();

	/**
     * Sets the value of the '{@link behavioral.status_and_action_old.SAMAction#isIsAgentAction <em>Is Agent Action</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Is Agent Action</em>' attribute.
     * @see #isIsAgentAction()
     * @generated
     */
	void setIsAgentAction(boolean value);

	/**
     * Returns the value of the '<em><b>Business Object Node</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link data.classes.SapClass#getSamActions <em>Sam Actions</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Business Object Node</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Business Object Node</em>' container reference.
     * @see #setBusinessObjectNode(SapClass)
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMAction_BusinessObjectNode()
     * @see data.classes.SapClass#getSamActions
     * @model opposite="samActions" required="true"
     * @generated
     */
	SapClass getBusinessObjectNode();

	/**
     * Sets the value of the '{@link behavioral.status_and_action_old.SAMAction#getBusinessObjectNode <em>Business Object Node</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Business Object Node</em>' container reference.
     * @see #getBusinessObjectNode()
     * @generated
     */
	void setBusinessObjectNode(SapClass value);

	/**
     * Returns the value of the '<em><b>Sam Schema Actions</b></em>' reference list.
     * The list contents are of type {@link behavioral.status_and_action_old.SAMSchemaAction}.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMSchemaAction#getSamAction <em>Sam Action</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Schema Actions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Schema Actions</em>' reference list.
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMAction_SamSchemaActions()
     * @see behavioral.status_and_action_old.SAMSchemaAction#getSamAction
     * @model opposite="samAction"
     * @generated
     */
	EList<SAMSchemaAction> getSamSchemaActions();

} // SAMAction
