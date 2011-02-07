/**
 * <copyright>
 * </copyright>
 *
 * $Id: SAMStatusSchema.java,v 1.1 2011/02/07 16:47:38 auhl Exp $
 */
package behavioral.status_and_action_old;

import data.classes.SapClass;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SAM Status Schema</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavioral.status_and_action_old.SAMStatusSchema#getName <em>Name</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMStatusSchema#getBusinessObjectNode <em>Business Object Node</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMStatusSchema#getSamOperators <em>Sam Operators</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMStatusSchema#getSamSchemaVariables <em>Sam Schema Variables</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMStatusSchema#getSamSchemaActions <em>Sam Schema Actions</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMStatusSchema#getSamSchemaDerivators <em>Sam Schema Derivators</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMStatusSchema()
 * @model
 * @generated
 */
public interface SAMStatusSchema extends EObject {
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
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMStatusSchema_Name()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	String getName();

	/**
     * Sets the value of the '{@link behavioral.status_and_action_old.SAMStatusSchema#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
	void setName(String value);

	/**
     * Returns the value of the '<em><b>Business Object Node</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link data.classes.SapClass#getSamStatusSchema <em>Sam Status Schema</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Business Object Node</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Business Object Node</em>' container reference.
     * @see #setBusinessObjectNode(SapClass)
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMStatusSchema_BusinessObjectNode()
     * @see data.classes.SapClass#getSamStatusSchema
     * @model opposite="samStatusSchema" required="true"
     * @generated
     */
	SapClass getBusinessObjectNode();

	/**
     * Sets the value of the '{@link behavioral.status_and_action_old.SAMStatusSchema#getBusinessObjectNode <em>Business Object Node</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Business Object Node</em>' container reference.
     * @see #getBusinessObjectNode()
     * @generated
     */
	void setBusinessObjectNode(SapClass value);

	/**
     * Returns the value of the '<em><b>Sam Operators</b></em>' containment reference list.
     * The list contents are of type {@link behavioral.status_and_action_old.SAMOperator}.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMOperator#getSamStatusSchema <em>Sam Status Schema</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Operators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Operators</em>' containment reference list.
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMStatusSchema_SamOperators()
     * @see behavioral.status_and_action_old.SAMOperator#getSamStatusSchema
     * @model opposite="samStatusSchema" containment="true" resolveProxies="true"
     * @generated
     */
	EList<SAMOperator> getSamOperators();

	/**
     * Returns the value of the '<em><b>Sam Schema Variables</b></em>' containment reference list.
     * The list contents are of type {@link behavioral.status_and_action_old.SAMSchemaVariable}.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMSchemaVariable#getSamStatusSchema <em>Sam Status Schema</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Schema Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Schema Variables</em>' containment reference list.
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMStatusSchema_SamSchemaVariables()
     * @see behavioral.status_and_action_old.SAMSchemaVariable#getSamStatusSchema
     * @model opposite="samStatusSchema" containment="true" resolveProxies="true"
     * @generated
     */
	EList<SAMSchemaVariable> getSamSchemaVariables();

	/**
     * Returns the value of the '<em><b>Sam Schema Actions</b></em>' containment reference list.
     * The list contents are of type {@link behavioral.status_and_action_old.SAMSchemaAction}.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMSchemaAction#getSamStatusSchema <em>Sam Status Schema</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Schema Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Schema Actions</em>' containment reference list.
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMStatusSchema_SamSchemaActions()
     * @see behavioral.status_and_action_old.SAMSchemaAction#getSamStatusSchema
     * @model opposite="samStatusSchema" containment="true" resolveProxies="true"
     * @generated
     */
	EList<SAMSchemaAction> getSamSchemaActions();

	/**
     * Returns the value of the '<em><b>Sam Schema Derivators</b></em>' containment reference list.
     * The list contents are of type {@link behavioral.status_and_action_old.SAMSchemaDerivator}.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMSchemaDerivator#getSamStatusSchema <em>Sam Status Schema</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Schema Derivators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Schema Derivators</em>' containment reference list.
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMStatusSchema_SamSchemaDerivators()
     * @see behavioral.status_and_action_old.SAMSchemaDerivator#getSamStatusSchema
     * @model opposite="samStatusSchema" containment="true" resolveProxies="true"
     * @generated
     */
	EList<SAMSchemaDerivator> getSamSchemaDerivators();

} // SAMStatusSchema
