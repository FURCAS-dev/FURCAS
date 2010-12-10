/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.emf.query2.syntax.query;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression Where Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.syntax.query.ExpressionWhereEntry#getLhs <em>Lhs</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.syntax.query.ExpressionWhereEntry#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.syntax.query.ExpressionWhereEntry#getRhs <em>Rhs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.syntax.query.QueryPackage#getExpressionWhereEntry()
 * @model
 * @generated
 */
public interface ExpressionWhereEntry extends WhereEntry
{
  /**
   * Returns the value of the '<em><b>Lhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lhs</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lhs</em>' containment reference.
   * @see #setLhs(AliasAttributeExpression)
   * @see org.eclipse.emf.query2.syntax.query.QueryPackage#getExpressionWhereEntry_Lhs()
   * @model containment="true"
   * @generated
   */
  AliasAttributeExpression getLhs();

  /**
   * Sets the value of the '{@link org.eclipse.emf.query2.syntax.query.ExpressionWhereEntry#getLhs <em>Lhs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lhs</em>' containment reference.
   * @see #getLhs()
   * @generated
   */
  void setLhs(AliasAttributeExpression value);

  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.emf.query2.syntax.query.Operator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see org.eclipse.emf.query2.syntax.query.Operator
   * @see #setOperator(Operator)
   * @see org.eclipse.emf.query2.syntax.query.QueryPackage#getExpressionWhereEntry_Operator()
   * @model
   * @generated
   */
  Operator getOperator();

  /**
   * Sets the value of the '{@link org.eclipse.emf.query2.syntax.query.ExpressionWhereEntry#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see org.eclipse.emf.query2.syntax.query.Operator
   * @see #getOperator()
   * @generated
   */
  void setOperator(Operator value);

  /**
   * Returns the value of the '<em><b>Rhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rhs</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rhs</em>' containment reference.
   * @see #setRhs(Expression)
   * @see org.eclipse.emf.query2.syntax.query.QueryPackage#getExpressionWhereEntry_Rhs()
   * @model containment="true"
   * @generated
   */
  Expression getRhs();

  /**
   * Sets the value of the '{@link org.eclipse.emf.query2.syntax.query.ExpressionWhereEntry#getRhs <em>Rhs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rhs</em>' containment reference.
   * @see #getRhs()
   * @generated
   */
  void setRhs(Expression value);

} // ExpressionWhereEntry
