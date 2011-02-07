/**
 * <copyright>
 * </copyright>
 *
 * $Id: FunctionSignatureTypeDefinition.java,v 1.1 2011/02/07 17:18:46 auhl Exp $
 */
package data.classes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Signature Type Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.classes.FunctionSignatureTypeDefinition#getSignature <em>Signature</em>}</li>
 *   <li>{@link data.classes.FunctionSignatureTypeDefinition#getOwnedSignature <em>Owned Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @see data.classes.ClassesPackage#getFunctionSignatureTypeDefinition()
 * @model
 * @generated
 */
public interface FunctionSignatureTypeDefinition extends TypeDefinition {
	/**
     * Returns the value of the '<em><b>Signature</b></em>' reference.
     * It is bidirectional and its opposite is '{@link data.classes.Signature#getTypeDefinition <em>Type Definition</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Signature</em>' reference.
     * @see #setSignature(Signature)
     * @see data.classes.ClassesPackage#getFunctionSignatureTypeDefinition_Signature()
     * @see data.classes.Signature#getTypeDefinition
     * @model opposite="typeDefinition" required="true"
     * @generated
     */
	Signature getSignature();

	/**
     * Sets the value of the '{@link data.classes.FunctionSignatureTypeDefinition#getSignature <em>Signature</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Signature</em>' reference.
     * @see #getSignature()
     * @generated
     */
	void setSignature(Signature value);

	/**
     * Returns the value of the '<em><b>Owned Signature</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Signature</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Owned Signature</em>' containment reference.
     * @see #setOwnedSignature(Signature)
     * @see data.classes.ClassesPackage#getFunctionSignatureTypeDefinition_OwnedSignature()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
	Signature getOwnedSignature();

	/**
     * Sets the value of the '{@link data.classes.FunctionSignatureTypeDefinition#getOwnedSignature <em>Owned Signature</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Owned Signature</em>' containment reference.
     * @see #getOwnedSignature()
     * @generated
     */
	void setOwnedSignature(Signature value);

} // FunctionSignatureTypeDefinition
