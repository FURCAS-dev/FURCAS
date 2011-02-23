/**
 * <copyright>
 * </copyright>
 *
 * $Id: SAMSchemaVariable.java,v 1.1 2011/02/07 17:17:57 auhl Exp $
 */
package behavioral.status_and_action_old;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SAM Schema Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavioral.status_and_action_old.SAMSchemaVariable#isHasStateGuard <em>Has State Guard</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMSchemaVariable#getSamStatusSchema <em>Sam Status Schema</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMSchemaVariable#getSamSchemaValues <em>Sam Schema Values</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMSchemaVariable#getSamSchemaValue <em>Sam Schema Value</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMSchemaVariable#getSamTargetSchemaDerivators <em>Sam Target Schema Derivators</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMSchemaVariable#getSamSourceSchemaDerivators <em>Sam Source Schema Derivators</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMSchemaVariable()
 * @model
 * @generated
 */
public interface SAMSchemaVariable extends EObject {
	/**
     * Returns the value of the '<em><b>Has State Guard</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has State Guard</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Has State Guard</em>' attribute.
     * @see #setHasStateGuard(boolean)
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMSchemaVariable_HasStateGuard()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	boolean isHasStateGuard();

	/**
     * Sets the value of the '{@link behavioral.status_and_action_old.SAMSchemaVariable#isHasStateGuard <em>Has State Guard</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Has State Guard</em>' attribute.
     * @see #isHasStateGuard()
     * @generated
     */
	void setHasStateGuard(boolean value);

	/**
     * Returns the value of the '<em><b>Sam Status Schema</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMStatusSchema#getSamSchemaVariables <em>Sam Schema Variables</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Status Schema</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Status Schema</em>' container reference.
     * @see #setSamStatusSchema(SAMStatusSchema)
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMSchemaVariable_SamStatusSchema()
     * @see behavioral.status_and_action_old.SAMStatusSchema#getSamSchemaVariables
     * @model opposite="samSchemaVariables" required="true"
     * @generated
     */
	SAMStatusSchema getSamStatusSchema();

	/**
     * Sets the value of the '{@link behavioral.status_and_action_old.SAMSchemaVariable#getSamStatusSchema <em>Sam Status Schema</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Sam Status Schema</em>' container reference.
     * @see #getSamStatusSchema()
     * @generated
     */
	void setSamStatusSchema(SAMStatusSchema value);

	/**
     * Returns the value of the '<em><b>Sam Schema Values</b></em>' containment reference list.
     * The list contents are of type {@link behavioral.status_and_action_old.SAMSchemaValue}.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMSchemaValue#getSamSchemaVariable <em>Sam Schema Variable</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Schema Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Schema Values</em>' containment reference list.
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMSchemaVariable_SamSchemaValues()
     * @see behavioral.status_and_action_old.SAMSchemaValue#getSamSchemaVariable
     * @model opposite="samSchemaVariable" containment="true" resolveProxies="true"
     * @generated
     */
	EList<SAMSchemaValue> getSamSchemaValues();

	/**
     * Returns the value of the '<em><b>Sam Schema Value</b></em>' reference.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMStatusVariable#getSamSchemaVariables <em>Sam Schema Variables</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Schema Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Schema Value</em>' reference.
     * @see #setSamSchemaValue(SAMStatusVariable)
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMSchemaVariable_SamSchemaValue()
     * @see behavioral.status_and_action_old.SAMStatusVariable#getSamSchemaVariables
     * @model opposite="samSchemaVariables" required="true"
     * @generated
     */
	SAMStatusVariable getSamSchemaValue();

	/**
     * Sets the value of the '{@link behavioral.status_and_action_old.SAMSchemaVariable#getSamSchemaValue <em>Sam Schema Value</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Sam Schema Value</em>' reference.
     * @see #getSamSchemaValue()
     * @generated
     */
	void setSamSchemaValue(SAMStatusVariable value);

	/**
     * Returns the value of the '<em><b>Sam Target Schema Derivators</b></em>' reference list.
     * The list contents are of type {@link behavioral.status_and_action_old.SAMSchemaDerivator}.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMSchemaDerivator#getSamSourceSchemaVariables <em>Sam Source Schema Variables</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Target Schema Derivators</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Target Schema Derivators</em>' reference list.
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMSchemaVariable_SamTargetSchemaDerivators()
     * @see behavioral.status_and_action_old.SAMSchemaDerivator#getSamSourceSchemaVariables
     * @model opposite="samSourceSchemaVariables"
     * @generated
     */
	EList<SAMSchemaDerivator> getSamTargetSchemaDerivators();

	/**
     * Returns the value of the '<em><b>Sam Source Schema Derivators</b></em>' reference list.
     * The list contents are of type {@link behavioral.status_and_action_old.SAMSchemaDerivator}.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMSchemaDerivator#getSamTargetSchemaVariable <em>Sam Target Schema Variable</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Source Schema Derivators</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Source Schema Derivators</em>' reference list.
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMSchemaVariable_SamSourceSchemaDerivators()
     * @see behavioral.status_and_action_old.SAMSchemaDerivator#getSamTargetSchemaVariable
     * @model opposite="samTargetSchemaVariable"
     * @generated
     */
	EList<SAMSchemaDerivator> getSamSourceSchemaDerivators();

} // SAMSchemaVariable
