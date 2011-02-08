/**
 * <copyright>
 * </copyright>
 *
 * $Id: NamedValueWithOptionalInitExpression.java,v 1.1 2011/02/07 17:16:09 auhl Exp $
 */
package behavioral.actions;

import data.classes.NamedValue;

import dataaccess.expressions.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Value With Optional Init Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavioral.actions.NamedValueWithOptionalInitExpression#getInitExpression <em>Init Expression</em>}</li>
 *   <li>{@link behavioral.actions.NamedValueWithOptionalInitExpression#getNamedValueDeclaration <em>Named Value Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavioral.actions.ActionsPackage#getNamedValueWithOptionalInitExpression()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL AssignmentCompatibility='self.initExpression->forAll(ie | ie.getType().conformsTo(self.getType()))'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='AssignmentCompatibility'"
 * @generated
 */
public interface NamedValueWithOptionalInitExpression extends NamedValue {
	/**
     * Returns the value of the '<em><b>Init Expression</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link dataaccess.expressions.Expression#getInitExpressionFor <em>Init Expression For</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Init Expression</em>' containment reference.
     * @see #setInitExpression(Expression)
     * @see behavioral.actions.ActionsPackage#getNamedValueWithOptionalInitExpression_InitExpression()
     * @see dataaccess.expressions.Expression#getInitExpressionFor
     * @model opposite="initExpressionFor" containment="true" resolveProxies="true"
     * @generated
     */
	Expression getInitExpression();

	/**
     * Sets the value of the '{@link behavioral.actions.NamedValueWithOptionalInitExpression#getInitExpression <em>Init Expression</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Init Expression</em>' containment reference.
     * @see #getInitExpression()
     * @generated
     */
	void setInitExpression(Expression value);

	/**
     * Returns the value of the '<em><b>Named Value Declaration</b></em>' reference.
     * It is bidirectional and its opposite is '{@link behavioral.actions.NamedValueDeclaration#getNamedValue <em>Named Value</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Named Value Declaration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Named Value Declaration</em>' reference.
     * @see #setNamedValueDeclaration(NamedValueDeclaration)
     * @see behavioral.actions.ActionsPackage#getNamedValueWithOptionalInitExpression_NamedValueDeclaration()
     * @see behavioral.actions.NamedValueDeclaration#getNamedValue
     * @model opposite="namedValue"
     * @generated
     */
	NamedValueDeclaration getNamedValueDeclaration();

	/**
     * Sets the value of the '{@link behavioral.actions.NamedValueWithOptionalInitExpression#getNamedValueDeclaration <em>Named Value Declaration</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Named Value Declaration</em>' reference.
     * @see #getNamedValueDeclaration()
     * @generated
     */
	void setNamedValueDeclaration(NamedValueDeclaration value);

} // NamedValueWithOptionalInitExpression
