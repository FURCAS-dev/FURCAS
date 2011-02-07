/**
 * <copyright>
 * </copyright>
 *
 * $Id: NamedValueDeclaration.java,v 1.1 2011/02/07 16:43:31 auhl Exp $
 */
package behavioral.actions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Value Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavioral.actions.NamedValueDeclaration#getNamedValue <em>Named Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavioral.actions.ActionsPackage#getNamedValueDeclaration()
 * @model
 * @generated
 */
public interface NamedValueDeclaration extends Statement {
	/**
     * Returns the value of the '<em><b>Named Value</b></em>' reference.
     * It is bidirectional and its opposite is '{@link behavioral.actions.NamedValueWithOptionalInitExpression#getNamedValueDeclaration <em>Named Value Declaration</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Named Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Named Value</em>' reference.
     * @see #setNamedValue(NamedValueWithOptionalInitExpression)
     * @see behavioral.actions.ActionsPackage#getNamedValueDeclaration_NamedValue()
     * @see behavioral.actions.NamedValueWithOptionalInitExpression#getNamedValueDeclaration
     * @model opposite="namedValueDeclaration" required="true"
     * @generated
     */
	NamedValueWithOptionalInitExpression getNamedValue();

	/**
     * Sets the value of the '{@link behavioral.actions.NamedValueDeclaration#getNamedValue <em>Named Value</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Named Value</em>' reference.
     * @see #getNamedValue()
     * @generated
     */
	void setNamedValue(NamedValueWithOptionalInitExpression value);

} // NamedValueDeclaration
