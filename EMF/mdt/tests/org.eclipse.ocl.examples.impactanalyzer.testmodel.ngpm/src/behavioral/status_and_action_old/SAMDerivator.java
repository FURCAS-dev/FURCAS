/**
 * <copyright>
 * </copyright>
 *
 * $Id: SAMDerivator.java,v 1.1 2011/02/07 17:17:57 auhl Exp $
 */
package behavioral.status_and_action_old;

import data.classes.SapClass;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SAM Derivator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavioral.status_and_action_old.SAMDerivator#getKind <em>Kind</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMDerivator#getBusinessObject <em>Business Object</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.SAMDerivator#getSamSchemaDerivators <em>Sam Schema Derivators</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMDerivator()
 * @model
 * @generated
 */
public interface SAMDerivator extends EObject {
	/**
     * Returns the value of the '<em><b>Kind</b></em>' attribute.
     * The literals are from the enumeration {@link behavioral.status_and_action_old.SAMDerivatorKindEnum}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Kind</em>' attribute.
     * @see behavioral.status_and_action_old.SAMDerivatorKindEnum
     * @see #setKind(SAMDerivatorKindEnum)
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMDerivator_Kind()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	SAMDerivatorKindEnum getKind();

	/**
     * Sets the value of the '{@link behavioral.status_and_action_old.SAMDerivator#getKind <em>Kind</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Kind</em>' attribute.
     * @see behavioral.status_and_action_old.SAMDerivatorKindEnum
     * @see #getKind()
     * @generated
     */
	void setKind(SAMDerivatorKindEnum value);

	/**
     * Returns the value of the '<em><b>Business Object</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link data.classes.SapClass#getSamDerivators <em>Sam Derivators</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Business Object</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Business Object</em>' container reference.
     * @see #setBusinessObject(SapClass)
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMDerivator_BusinessObject()
     * @see data.classes.SapClass#getSamDerivators
     * @model opposite="samDerivators" required="true"
     * @generated
     */
	SapClass getBusinessObject();

	/**
     * Sets the value of the '{@link behavioral.status_and_action_old.SAMDerivator#getBusinessObject <em>Business Object</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Business Object</em>' container reference.
     * @see #getBusinessObject()
     * @generated
     */
	void setBusinessObject(SapClass value);

	/**
     * Returns the value of the '<em><b>Sam Schema Derivators</b></em>' reference list.
     * The list contents are of type {@link behavioral.status_and_action_old.SAMSchemaDerivator}.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMSchemaDerivator#getSamDerivator <em>Sam Derivator</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Schema Derivators</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Schema Derivators</em>' reference list.
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMDerivator_SamSchemaDerivators()
     * @see behavioral.status_and_action_old.SAMSchemaDerivator#getSamDerivator
     * @model opposite="samDerivator"
     * @generated
     */
	EList<SAMSchemaDerivator> getSamSchemaDerivators();

} // SAMDerivator
