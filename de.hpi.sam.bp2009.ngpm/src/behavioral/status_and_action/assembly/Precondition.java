/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.status_and_action.assembly;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Precondition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavioral.status_and_action.assembly.Precondition#getStrategy <em>Strategy</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavioral.status_and_action.assembly.AssemblyPackage#getPrecondition()
 * @model
 * @generated
 */
public interface Precondition extends Connector {
	/**
     * Returns the value of the '<em><b>Strategy</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Strategy</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Strategy</em>' reference.
     * @see #setStrategy(Strategy)
     * @see behavioral.status_and_action.assembly.AssemblyPackage#getPrecondition_Strategy()
     * @model required="true"
     *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='owner'"
     * @generated
     */
	Strategy getStrategy();

	/**
     * Sets the value of the '{@link behavioral.status_and_action.assembly.Precondition#getStrategy <em>Strategy</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Strategy</em>' reference.
     * @see #getStrategy()
     * @generated
     */
	void setStrategy(Strategy value);

} // Precondition
