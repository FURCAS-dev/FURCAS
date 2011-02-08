/**
 * <copyright>
 * </copyright>
 *
 * $Id: SAMSchemaDerivator.java,v 1.1 2011/02/07 17:17:57 auhl Exp $
 */
package behavioral.status_and_action_old;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SAM Schema Derivator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavioral.status_and_action_old.SAMSchemaDerivator#getSamDerivator <em>Sam Derivator</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMSchemaDerivator#getSamStatusSchema <em>Sam Status Schema</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMSchemaDerivator#getSamSourceSchemaVariables <em>Sam Source Schema Variables</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMSchemaDerivator#getSamTargetSchemaVariable <em>Sam Target Schema Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMSchemaDerivator()
 * @model
 * @generated
 */
public interface SAMSchemaDerivator extends EObject {
	/**
     * Returns the value of the '<em><b>Sam Derivator</b></em>' reference.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMDerivator#getSamSchemaDerivators <em>Sam Schema Derivators</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Derivator</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Derivator</em>' reference.
     * @see #setSamDerivator(SAMDerivator)
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMSchemaDerivator_SamDerivator()
     * @see behavioral.status_and_action_old.SAMDerivator#getSamSchemaDerivators
     * @model opposite="samSchemaDerivators" required="true"
     * @generated
     */
	SAMDerivator getSamDerivator();

	/**
     * Sets the value of the '{@link behavioral.status_and_action_old.SAMSchemaDerivator#getSamDerivator <em>Sam Derivator</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Sam Derivator</em>' reference.
     * @see #getSamDerivator()
     * @generated
     */
	void setSamDerivator(SAMDerivator value);

	/**
     * Returns the value of the '<em><b>Sam Status Schema</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMStatusSchema#getSamSchemaDerivators <em>Sam Schema Derivators</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Status Schema</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Status Schema</em>' container reference.
     * @see #setSamStatusSchema(SAMStatusSchema)
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMSchemaDerivator_SamStatusSchema()
     * @see behavioral.status_and_action_old.SAMStatusSchema#getSamSchemaDerivators
     * @model opposite="samSchemaDerivators" required="true"
     * @generated
     */
	SAMStatusSchema getSamStatusSchema();

	/**
     * Sets the value of the '{@link behavioral.status_and_action_old.SAMSchemaDerivator#getSamStatusSchema <em>Sam Status Schema</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Sam Status Schema</em>' container reference.
     * @see #getSamStatusSchema()
     * @generated
     */
	void setSamStatusSchema(SAMStatusSchema value);

	/**
     * Returns the value of the '<em><b>Sam Source Schema Variables</b></em>' reference list.
     * The list contents are of type {@link behavioral.status_and_action_old.SAMSchemaVariable}.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMSchemaVariable#getSamTargetSchemaDerivators <em>Sam Target Schema Derivators</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Source Schema Variables</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Source Schema Variables</em>' reference list.
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMSchemaDerivator_SamSourceSchemaVariables()
     * @see behavioral.status_and_action_old.SAMSchemaVariable#getSamTargetSchemaDerivators
     * @model opposite="samTargetSchemaDerivators"
     * @generated
     */
	EList<SAMSchemaVariable> getSamSourceSchemaVariables();

	/**
     * Returns the value of the '<em><b>Sam Target Schema Variable</b></em>' reference list.
     * The list contents are of type {@link behavioral.status_and_action_old.SAMSchemaVariable}.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMSchemaVariable#getSamSourceSchemaDerivators <em>Sam Source Schema Derivators</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Target Schema Variable</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Target Schema Variable</em>' reference list.
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMSchemaDerivator_SamTargetSchemaVariable()
     * @see behavioral.status_and_action_old.SAMSchemaVariable#getSamSourceSchemaDerivators
     * @model opposite="samSourceSchemaDerivators"
     * @generated
     */
	EList<SAMSchemaVariable> getSamTargetSchemaVariable();

} // SAMSchemaDerivator
