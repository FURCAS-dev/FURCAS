/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package integration.xsd;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Notation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link integration.xsd.Notation#getPublicDec <em>Public Dec</em>}</li>
 *   <li>{@link integration.xsd.Notation#getSystemDec <em>System Dec</em>}</li>
 * </ul>
 * </p>
 *
 * @see integration.xsd.XsdPackage#getNotation()
 * @model
 * @generated
 */
public interface Notation extends NamedElement {
	/**
     * Returns the value of the '<em><b>Public Dec</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Public Dec</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Public Dec</em>' attribute.
     * @see #setPublicDec(String)
     * @see integration.xsd.XsdPackage#getNotation_PublicDec()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	String getPublicDec();

	/**
     * Sets the value of the '{@link integration.xsd.Notation#getPublicDec <em>Public Dec</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Public Dec</em>' attribute.
     * @see #getPublicDec()
     * @generated
     */
	void setPublicDec(String value);

	/**
     * Returns the value of the '<em><b>System Dec</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Dec</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>System Dec</em>' attribute.
     * @see #setSystemDec(String)
     * @see integration.xsd.XsdPackage#getNotation_SystemDec()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	String getSystemDec();

	/**
     * Sets the value of the '{@link integration.xsd.Notation#getSystemDec <em>System Dec</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>System Dec</em>' attribute.
     * @see #getSystemDec()
     * @generated
     */
	void setSystemDec(String value);

} // Notation
