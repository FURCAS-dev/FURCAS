/**
 * <copyright>
 * </copyright>
 *
 * $Id$
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
public interface NamedValueDeclaration extends Statement
{
  /**
   * Returns the value of the '<em><b>Named Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Named Value</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Named Value</em>' reference.
   * @see #setNamedValue(NamedValueWithOptionalInitExpression)
   * @see behavioral.actions.ActionsPackage#getNamedValueDeclaration_NamedValue()
   * @model required="true"
   *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='namedValueDeclaration'"
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
