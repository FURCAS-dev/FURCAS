/**
 * <copyright>
 * </copyright>
 *
 * $Id: SAMOperator.java,v 1.1 2011/02/07 16:47:38 auhl Exp $
 */
package behavioral.status_and_action_old;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SAM Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavioral.status_and_action_old.SAMOperator#getKind <em>Kind</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMOperator#getSamStatusSchema <em>Sam Status Schema</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMOperator#getSamSchemaValues <em>Sam Schema Values</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMOperator#getSamSourceOperators <em>Sam Source Operators</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMOperator#getSamTargetOperators <em>Sam Target Operators</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMOperator#getSamSchemaActions <em>Sam Schema Actions</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMOperator()
 * @model
 * @generated
 */
public interface SAMOperator extends EObject {
	/**
     * Returns the value of the '<em><b>Kind</b></em>' attribute.
     * The literals are from the enumeration {@link behavioral.status_and_action_old.SAMOperatorKindEnum}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Kind</em>' attribute.
     * @see behavioral.status_and_action_old.SAMOperatorKindEnum
     * @see #setKind(SAMOperatorKindEnum)
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMOperator_Kind()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	SAMOperatorKindEnum getKind();

	/**
     * Sets the value of the '{@link behavioral.status_and_action_old.SAMOperator#getKind <em>Kind</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Kind</em>' attribute.
     * @see behavioral.status_and_action_old.SAMOperatorKindEnum
     * @see #getKind()
     * @generated
     */
	void setKind(SAMOperatorKindEnum value);

	/**
     * Returns the value of the '<em><b>Sam Status Schema</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMStatusSchema#getSamOperators <em>Sam Operators</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Status Schema</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Status Schema</em>' container reference.
     * @see #setSamStatusSchema(SAMStatusSchema)
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMOperator_SamStatusSchema()
     * @see behavioral.status_and_action_old.SAMStatusSchema#getSamOperators
     * @model opposite="samOperators" required="true"
     * @generated
     */
	SAMStatusSchema getSamStatusSchema();

	/**
     * Sets the value of the '{@link behavioral.status_and_action_old.SAMOperator#getSamStatusSchema <em>Sam Status Schema</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Sam Status Schema</em>' container reference.
     * @see #getSamStatusSchema()
     * @generated
     */
	void setSamStatusSchema(SAMStatusSchema value);

	/**
     * Returns the value of the '<em><b>Sam Schema Values</b></em>' reference list.
     * The list contents are of type {@link behavioral.status_and_action_old.SAMSchemaValue}.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMSchemaValue#getSamOperators <em>Sam Operators</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Schema Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Schema Values</em>' reference list.
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMOperator_SamSchemaValues()
     * @see behavioral.status_and_action_old.SAMSchemaValue#getSamOperators
     * @model opposite="samOperators"
     * @generated
     */
	EList<SAMSchemaValue> getSamSchemaValues();

	/**
     * Returns the value of the '<em><b>Sam Source Operators</b></em>' reference list.
     * The list contents are of type {@link behavioral.status_and_action_old.SAMOperator}.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMOperator#getSamTargetOperators <em>Sam Target Operators</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Source Operators</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Source Operators</em>' reference list.
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMOperator_SamSourceOperators()
     * @see behavioral.status_and_action_old.SAMOperator#getSamTargetOperators
     * @model opposite="samTargetOperators"
     * @generated
     */
	EList<SAMOperator> getSamSourceOperators();

	/**
     * Returns the value of the '<em><b>Sam Target Operators</b></em>' reference list.
     * The list contents are of type {@link behavioral.status_and_action_old.SAMOperator}.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMOperator#getSamSourceOperators <em>Sam Source Operators</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Target Operators</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Target Operators</em>' reference list.
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMOperator_SamTargetOperators()
     * @see behavioral.status_and_action_old.SAMOperator#getSamSourceOperators
     * @model opposite="samSourceOperators"
     * @generated
     */
	EList<SAMOperator> getSamTargetOperators();

	/**
     * Returns the value of the '<em><b>Sam Schema Actions</b></em>' reference list.
     * The list contents are of type {@link behavioral.status_and_action_old.SAMSchemaAction}.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMSchemaAction#getSamSchemaOperators <em>Sam Schema Operators</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Schema Actions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Schema Actions</em>' reference list.
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMOperator_SamSchemaActions()
     * @see behavioral.status_and_action_old.SAMSchemaAction#getSamSchemaOperators
     * @model opposite="samSchemaOperators"
     * @generated
     */
	EList<SAMSchemaAction> getSamSchemaActions();

} // SAMOperator
