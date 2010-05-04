/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.actions;

import dataaccess.expressions.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavioral.actions.ExpressionStatement#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavioral.actions.ActionsPackage#getExpressionStatement()
 * @model
 * @generated
 */
public interface ExpressionStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(Expression)
   * @see behavioral.actions.ActionsPackage#getExpressionStatement_Expression()
   * @model containment="true" required="true"
   *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='expressionStatement'"
   * @generated
   */
  Expression getExpression();

  /**
   * Sets the value of the '{@link behavioral.actions.ExpressionStatement#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(Expression value);

} // ExpressionStatement
