/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package TCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Token</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link TCS.Token#getPattern <em>Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @see TCS.TCSPackage#getToken()
 * @model
 * @generated
 */
public interface Token extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' containment reference.
	 * @see #setPattern(OrPattern)
	 * @see TCS.TCSPackage#getToken_Pattern()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	OrPattern getPattern();

	/**
	 * Sets the value of the '{@link TCS.Token#getPattern <em>Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' containment reference.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(OrPattern value);

} // Token
