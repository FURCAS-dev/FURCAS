/**
 * <copyright>
 * </copyright>
 *
 * $Id: VariableExpression.java,v 1.1 2011/02/07 16:53:51 auhl Exp $
 */
package dataaccess.expressions;

import data.classes.NamedValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The variable referenced by this type of expression must be visible within the scope where this expression occurs.
 * 
 * TODO: How to determine the block containing this VariableExpression? This will be important to determine if the variable is visible.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataaccess.expressions.VariableExpression#getVariable <em>Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataaccess.expressions.ExpressionsPackage#getVariableExpression()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL VariableExpressionType='self.getType().conformsTo(self.variable.getType())'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='VariableExpressionType'"
 * @generated
 */
public interface VariableExpression extends Expression {
	/**
     * Returns the value of the '<em><b>Variable</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Variable</em>' reference.
     * @see #setVariable(NamedValue)
     * @see dataaccess.expressions.ExpressionsPackage#getVariableExpression_Variable()
     * @model required="true"
     * @generated
     */
	NamedValue getVariable();

	/**
     * Sets the value of the '{@link dataaccess.expressions.VariableExpression#getVariable <em>Variable</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Variable</em>' reference.
     * @see #getVariable()
     * @generated
     */
	void setVariable(NamedValue value);

} // VariableExpression
