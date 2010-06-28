/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package TCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>End Of Line Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link TCS.EndOfLineRule#getStart <em>Start</em>}</li>
 *   <li>{@link TCS.EndOfLineRule#isDropStart <em>Drop Start</em>}</li>
 * </ul>
 * </p>
 *
 * @see TCS.TCSPackage#getEndOfLineRule()
 * @model
 * @generated
 */
public interface EndOfLineRule extends Rule {
	/**
	 * Returns the value of the '<em><b>Start</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' containment reference.
	 * @see #setStart(StringPattern)
	 * @see TCS.TCSPackage#getEndOfLineRule_Start()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	StringPattern getStart();

	/**
	 * Sets the value of the '{@link TCS.EndOfLineRule#getStart <em>Start</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' containment reference.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(StringPattern value);

	/**
	 * Returns the value of the '<em><b>Drop Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Drop Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Drop Start</em>' attribute.
	 * @see #setDropStart(boolean)
	 * @see TCS.TCSPackage#getEndOfLineRule_DropStart()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isDropStart();

	/**
	 * Sets the value of the '{@link TCS.EndOfLineRule#isDropStart <em>Drop Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Drop Start</em>' attribute.
	 * @see #isDropStart()
	 * @generated
	 */
	void setDropStart(boolean value);

} // EndOfLineRule
