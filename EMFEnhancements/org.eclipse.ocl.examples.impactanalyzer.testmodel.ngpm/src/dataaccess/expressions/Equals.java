/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Equals</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * compares two or more values/objects. Entity type instances are compared based on their identity. Value type instances are compared by their value. The type of an Equals expression is Boolean.
 * 
 * The getType() implementation can only infer the type once TypeDefinition is a value type, values of which can be constructed in an OCL expression.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataaccess.expressions.Equals#getLeft <em>Left</em>}</li>
 *   <li>{@link dataaccess.expressions.Equals#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataaccess.expressions.ExpressionsPackage#getEquals()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL ConformaceOneWayOrAnother='self.left.getType().conformsTo(self.right.getType()) or\r\n  self.right.getType().conformsTo(self.left.getType())'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ConformaceOneWayOrAnother'"
 * @generated
 */
public interface Equals extends Expression {
	/**
     * Returns the value of the '<em><b>Left</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link dataaccess.expressions.Expression#getLeftOfEquals <em>Left Of Equals</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Left</em>' containment reference.
     * @see #setLeft(Expression)
     * @see dataaccess.expressions.ExpressionsPackage#getEquals_Left()
     * @see dataaccess.expressions.Expression#getLeftOfEquals
     * @model opposite="leftOfEquals" containment="true" resolveProxies="true" required="true"
     * @generated
     */
	Expression getLeft();

	/**
     * Sets the value of the '{@link dataaccess.expressions.Equals#getLeft <em>Left</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Left</em>' containment reference.
     * @see #getLeft()
     * @generated
     */
	void setLeft(Expression value);

	/**
     * Returns the value of the '<em><b>Right</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link dataaccess.expressions.Expression#getRightOfEquals <em>Right Of Equals</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Right</em>' containment reference.
     * @see #setRight(Expression)
     * @see dataaccess.expressions.ExpressionsPackage#getEquals_Right()
     * @see dataaccess.expressions.Expression#getRightOfEquals
     * @model opposite="rightOfEquals" containment="true" resolveProxies="true" required="true"
     * @generated
     */
	Expression getRight();

	/**
     * Sets the value of the '{@link dataaccess.expressions.Equals#getRight <em>Right</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Right</em>' containment reference.
     * @see #getRight()
     * @generated
     */
	void setRight(Expression value);

} // Equals
