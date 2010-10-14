/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.status_and_action_old;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SAM Schema Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavioral.status_and_action_old.SAMSchemaAction#getSamStatusSchema <em>Sam Status Schema</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMSchemaAction#getSamAction <em>Sam Action</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMSchemaAction#getSamTargetSchemaValues <em>Sam Target Schema Values</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMSchemaAction#getSamSchemaValues <em>Sam Schema Values</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMSchemaAction#getSamSchemaOperators <em>Sam Schema Operators</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMSchemaAction()
 * @model
 * @generated
 */
public interface SAMSchemaAction extends EObject {
	/**
     * Returns the value of the '<em><b>Sam Status Schema</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMStatusSchema#getSamSchemaActions <em>Sam Schema Actions</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Status Schema</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Status Schema</em>' container reference.
     * @see #setSamStatusSchema(SAMStatusSchema)
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMSchemaAction_SamStatusSchema()
     * @see behavioral.status_and_action_old.SAMStatusSchema#getSamSchemaActions
     * @model opposite="samSchemaActions" required="true"
     * @generated
     */
	SAMStatusSchema getSamStatusSchema();

	/**
     * Sets the value of the '{@link behavioral.status_and_action_old.SAMSchemaAction#getSamStatusSchema <em>Sam Status Schema</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Sam Status Schema</em>' container reference.
     * @see #getSamStatusSchema()
     * @generated
     */
	void setSamStatusSchema(SAMStatusSchema value);

	/**
     * Returns the value of the '<em><b>Sam Action</b></em>' reference.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMAction#getSamSchemaActions <em>Sam Schema Actions</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Action</em>' reference.
     * @see #setSamAction(SAMAction)
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMSchemaAction_SamAction()
     * @see behavioral.status_and_action_old.SAMAction#getSamSchemaActions
     * @model opposite="samSchemaActions" required="true"
     * @generated
     */
	SAMAction getSamAction();

	/**
     * Sets the value of the '{@link behavioral.status_and_action_old.SAMSchemaAction#getSamAction <em>Sam Action</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Sam Action</em>' reference.
     * @see #getSamAction()
     * @generated
     */
	void setSamAction(SAMAction value);

	/**
     * Returns the value of the '<em><b>Sam Target Schema Values</b></em>' reference list.
     * The list contents are of type {@link behavioral.status_and_action_old.SAMSchemaValue}.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMSchemaValue#getSamSourceSchemaActions <em>Sam Source Schema Actions</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Target Schema Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Target Schema Values</em>' reference list.
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMSchemaAction_SamTargetSchemaValues()
     * @see behavioral.status_and_action_old.SAMSchemaValue#getSamSourceSchemaActions
     * @model opposite="samSourceSchemaActions"
     * @generated
     */
	EList<SAMSchemaValue> getSamTargetSchemaValues();

	/**
     * Returns the value of the '<em><b>Sam Schema Values</b></em>' reference list.
     * The list contents are of type {@link behavioral.status_and_action_old.SAMSchemaValue}.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMSchemaValue#getSamSchemaActions <em>Sam Schema Actions</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Schema Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Schema Values</em>' reference list.
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMSchemaAction_SamSchemaValues()
     * @see behavioral.status_and_action_old.SAMSchemaValue#getSamSchemaActions
     * @model opposite="samSchemaActions"
     * @generated
     */
	EList<SAMSchemaValue> getSamSchemaValues();

	/**
     * Returns the value of the '<em><b>Sam Schema Operators</b></em>' reference list.
     * The list contents are of type {@link behavioral.status_and_action_old.SAMOperator}.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMOperator#getSamSchemaActions <em>Sam Schema Actions</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Schema Operators</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Schema Operators</em>' reference list.
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMSchemaAction_SamSchemaOperators()
     * @see behavioral.status_and_action_old.SAMOperator#getSamSchemaActions
     * @model opposite="samSchemaActions"
     * @generated
     */
	EList<SAMOperator> getSamSchemaOperators();

} // SAMSchemaAction
