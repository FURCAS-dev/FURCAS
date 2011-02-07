/**
 * <copyright>
 * </copyright>
 *
 * $Id: ObjectBasedExpression.java,v 1.1 2011/02/07 16:53:51 auhl Exp $
 */
package dataaccess.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Based Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A specific type of expression that is evaluated in the context of a specific object. Another expression is used to determine this object. An example for such an expression would be association navigation, where the object where the navigation starts has to be specified by the "object" expression.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataaccess.expressions.ObjectBasedExpression#getObject <em>Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataaccess.expressions.ExpressionsPackage#getObjectBasedExpression()
 * @model abstract="true"
 * @generated
 */
public interface ObjectBasedExpression extends Expression {
	/**
     * Returns the value of the '<em><b>Object</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link dataaccess.expressions.Expression#getObjectBasedExpression <em>Object Based Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Object</em>' containment reference.
     * @see #setObject(Expression)
     * @see dataaccess.expressions.ExpressionsPackage#getObjectBasedExpression_Object()
     * @see dataaccess.expressions.Expression#getObjectBasedExpression
     * @model opposite="objectBasedExpression" containment="true" resolveProxies="true" required="true"
     * @generated
     */
	Expression getObject();

	/**
     * Sets the value of the '{@link dataaccess.expressions.ObjectBasedExpression#getObject <em>Object</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Object</em>' containment reference.
     * @see #getObject()
     * @generated
     */
	void setObject(Expression value);

} // ObjectBasedExpression
