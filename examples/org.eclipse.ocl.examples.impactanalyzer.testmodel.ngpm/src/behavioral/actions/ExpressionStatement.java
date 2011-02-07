/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExpressionStatement.java,v 1.1 2011/02/07 16:43:31 auhl Exp $
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
public interface ExpressionStatement extends Statement {
	/**
     * Returns the value of the '<em><b>Expression</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link dataaccess.expressions.Expression#getExpressionStatement <em>Expression Statement</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Expression</em>' containment reference.
     * @see #setExpression(Expression)
     * @see behavioral.actions.ActionsPackage#getExpressionStatement_Expression()
     * @see dataaccess.expressions.Expression#getExpressionStatement
     * @model opposite="expressionStatement" containment="true" resolveProxies="true" required="true"
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
