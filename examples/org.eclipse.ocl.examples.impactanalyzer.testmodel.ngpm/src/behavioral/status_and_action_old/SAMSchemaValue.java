/**
 * <copyright>
 * </copyright>
 *
 * $Id: SAMSchemaValue.java,v 1.1 2011/02/07 16:47:38 auhl Exp $
 */
package behavioral.status_and_action_old;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SAM Schema Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavioral.status_and_action_old.SAMSchemaValue#isIsInitial <em>Is Initial</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMSchemaValue#isIsInhibiting <em>Is Inhibiting</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMSchemaValue#getSamSchemaVariable <em>Sam Schema Variable</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMSchemaValue#getSamSourceSchemaActions <em>Sam Source Schema Actions</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMSchemaValue#getSamSourceSchemaValues <em>Sam Source Schema Values</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMSchemaValue#getSamTargetSchemaValues <em>Sam Target Schema Values</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMSchemaValue#getSamOperators <em>Sam Operators</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMSchemaValue#getSamSchemaActions <em>Sam Schema Actions</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMSchemaValue()
 * @model
 * @generated
 */
public interface SAMSchemaValue extends EObject {
	/**
     * Returns the value of the '<em><b>Is Initial</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Initial</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Is Initial</em>' attribute.
     * @see #setIsInitial(boolean)
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMSchemaValue_IsInitial()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	boolean isIsInitial();

	/**
     * Sets the value of the '{@link behavioral.status_and_action_old.SAMSchemaValue#isIsInitial <em>Is Initial</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Is Initial</em>' attribute.
     * @see #isIsInitial()
     * @generated
     */
	void setIsInitial(boolean value);

	/**
     * Returns the value of the '<em><b>Is Inhibiting</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Inhibiting</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Is Inhibiting</em>' attribute.
     * @see #setIsInhibiting(boolean)
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMSchemaValue_IsInhibiting()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	boolean isIsInhibiting();

	/**
     * Sets the value of the '{@link behavioral.status_and_action_old.SAMSchemaValue#isIsInhibiting <em>Is Inhibiting</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Is Inhibiting</em>' attribute.
     * @see #isIsInhibiting()
     * @generated
     */
	void setIsInhibiting(boolean value);

	/**
     * Returns the value of the '<em><b>Sam Schema Variable</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMSchemaVariable#getSamSchemaValues <em>Sam Schema Values</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Schema Variable</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Schema Variable</em>' container reference.
     * @see #setSamSchemaVariable(SAMSchemaVariable)
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMSchemaValue_SamSchemaVariable()
     * @see behavioral.status_and_action_old.SAMSchemaVariable#getSamSchemaValues
     * @model opposite="samSchemaValues" required="true"
     * @generated
     */
	SAMSchemaVariable getSamSchemaVariable();

	/**
     * Sets the value of the '{@link behavioral.status_and_action_old.SAMSchemaValue#getSamSchemaVariable <em>Sam Schema Variable</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Sam Schema Variable</em>' container reference.
     * @see #getSamSchemaVariable()
     * @generated
     */
	void setSamSchemaVariable(SAMSchemaVariable value);

	/**
     * Returns the value of the '<em><b>Sam Source Schema Actions</b></em>' reference list.
     * The list contents are of type {@link behavioral.status_and_action_old.SAMSchemaAction}.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMSchemaAction#getSamTargetSchemaValues <em>Sam Target Schema Values</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Source Schema Actions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Source Schema Actions</em>' reference list.
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMSchemaValue_SamSourceSchemaActions()
     * @see behavioral.status_and_action_old.SAMSchemaAction#getSamTargetSchemaValues
     * @model opposite="samTargetSchemaValues"
     * @generated
     */
	EList<SAMSchemaAction> getSamSourceSchemaActions();

	/**
     * Returns the value of the '<em><b>Sam Source Schema Values</b></em>' reference list.
     * The list contents are of type {@link behavioral.status_and_action_old.SAMSchemaValue}.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMSchemaValue#getSamTargetSchemaValues <em>Sam Target Schema Values</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Source Schema Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Source Schema Values</em>' reference list.
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMSchemaValue_SamSourceSchemaValues()
     * @see behavioral.status_and_action_old.SAMSchemaValue#getSamTargetSchemaValues
     * @model opposite="samTargetSchemaValues"
     * @generated
     */
	EList<SAMSchemaValue> getSamSourceSchemaValues();

	/**
     * Returns the value of the '<em><b>Sam Target Schema Values</b></em>' reference list.
     * The list contents are of type {@link behavioral.status_and_action_old.SAMSchemaValue}.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMSchemaValue#getSamSourceSchemaValues <em>Sam Source Schema Values</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Target Schema Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Target Schema Values</em>' reference list.
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMSchemaValue_SamTargetSchemaValues()
     * @see behavioral.status_and_action_old.SAMSchemaValue#getSamSourceSchemaValues
     * @model opposite="samSourceSchemaValues"
     * @generated
     */
	EList<SAMSchemaValue> getSamTargetSchemaValues();

	/**
     * Returns the value of the '<em><b>Sam Operators</b></em>' reference list.
     * The list contents are of type {@link behavioral.status_and_action_old.SAMOperator}.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMOperator#getSamSchemaValues <em>Sam Schema Values</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Operators</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Operators</em>' reference list.
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMSchemaValue_SamOperators()
     * @see behavioral.status_and_action_old.SAMOperator#getSamSchemaValues
     * @model opposite="samSchemaValues"
     * @generated
     */
	EList<SAMOperator> getSamOperators();

	/**
     * Returns the value of the '<em><b>Sam Schema Actions</b></em>' reference list.
     * The list contents are of type {@link behavioral.status_and_action_old.SAMSchemaAction}.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMSchemaAction#getSamSchemaValues <em>Sam Schema Values</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Schema Actions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Schema Actions</em>' reference list.
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMSchemaValue_SamSchemaActions()
     * @see behavioral.status_and_action_old.SAMSchemaAction#getSamSchemaValues
     * @model opposite="samSchemaValues"
     * @generated
     */
	EList<SAMSchemaAction> getSamSchemaActions();

} // SAMSchemaValue
