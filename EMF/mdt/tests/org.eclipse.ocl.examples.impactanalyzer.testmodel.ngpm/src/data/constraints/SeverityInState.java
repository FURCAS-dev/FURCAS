/**
 * <copyright>
 * </copyright>
 *
 * $Id: SeverityInState.java,v 1.1 2011/02/07 17:18:46 auhl Exp $
 */
package data.constraints;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Severity In State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.constraints.SeverityInState#getState <em>State</em>}</li>
 *   <li>{@link data.constraints.SeverityInState#getSeverity <em>Severity</em>}</li>
 * </ul>
 * </p>
 *
 * @see data.constraints.ConstraintsPackage#getSeverityInState()
 * @model
 * @generated
 */
public interface SeverityInState extends EObject {
	/**
     * Returns the value of the '<em><b>State</b></em>' attribute.
     * The literals are from the enumeration {@link data.constraints.ObjectState}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>State</em>' attribute.
     * @see data.constraints.ObjectState
     * @see #setState(ObjectState)
     * @see data.constraints.ConstraintsPackage#getSeverityInState_State()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	ObjectState getState();

	/**
     * Sets the value of the '{@link data.constraints.SeverityInState#getState <em>State</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>State</em>' attribute.
     * @see data.constraints.ObjectState
     * @see #getState()
     * @generated
     */
	void setState(ObjectState value);

	/**
     * Returns the value of the '<em><b>Severity</b></em>' attribute.
     * The literals are from the enumeration {@link data.constraints.Severity}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Severity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Severity</em>' attribute.
     * @see data.constraints.Severity
     * @see #setSeverity(Severity)
     * @see data.constraints.ConstraintsPackage#getSeverityInState_Severity()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	Severity getSeverity();

	/**
     * Sets the value of the '{@link data.constraints.SeverityInState#getSeverity <em>Severity</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Severity</em>' attribute.
     * @see data.constraints.Severity
     * @see #getSeverity()
     * @generated
     */
	void setSeverity(Severity value);

} // SeverityInState
