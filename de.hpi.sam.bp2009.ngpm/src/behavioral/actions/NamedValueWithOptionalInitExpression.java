/**
 * <copyright>
 * </copyright>
 *
 * $Id$
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
 * </ul>
 * </p>
 *
 * @see behavioral.actions.ActionsPackage#getNamedValueWithOptionalInitExpression()
 * @model abstract="true"
 *        annotation="http://de.hpi.sam.bp2009.OCL AssignmentCompatibility='self.initExpression->forAll(ie | ie.getType().conformsTo(self.getType()))'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='AssignmentCompatibility'"
 * @generated
 */
public interface NamedValueWithOptionalInitExpression extends NamedValue
{
  /**
   * Returns the value of the '<em><b>Init Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Init Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Init Expression</em>' containment reference.
   * @see #setInitExpression(Expression)
   * @see behavioral.actions.ActionsPackage#getNamedValueWithOptionalInitExpression_InitExpression()
   * @model containment="true"
   *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='initExpressionFor'"
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

} // NamedValueWithOptionalInitExpression
