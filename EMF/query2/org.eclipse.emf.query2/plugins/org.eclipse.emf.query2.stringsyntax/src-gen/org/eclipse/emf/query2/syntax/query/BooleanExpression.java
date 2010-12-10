/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.emf.query2.syntax.query;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.syntax.query.BooleanExpression#isTrue <em>True</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.syntax.query.QueryPackage#getBooleanExpression()
 * @model
 * @generated
 */
public interface BooleanExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>True</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>True</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>True</em>' attribute.
   * @see #setTrue(boolean)
   * @see org.eclipse.emf.query2.syntax.query.QueryPackage#getBooleanExpression_True()
   * @model
   * @generated
   */
  boolean isTrue();

  /**
   * Sets the value of the '{@link org.eclipse.emf.query2.syntax.query.BooleanExpression#isTrue <em>True</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>True</em>' attribute.
   * @see #isTrue()
   * @generated
   */
  void setTrue(boolean value);

} // BooleanExpression
