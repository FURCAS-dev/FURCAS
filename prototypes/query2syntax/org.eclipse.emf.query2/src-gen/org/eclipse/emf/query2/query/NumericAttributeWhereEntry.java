/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.emf.query2.query;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Numeric Attribute Where Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.query.NumericAttributeWhereEntry#getOperator <em>Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.query.QueryPackage#getNumericAttributeWhereEntry()
 * @model
 * @generated
 */
public interface NumericAttributeWhereEntry extends AttributeWhereEntry
{
  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.emf.query2.query.NumericOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see org.eclipse.emf.query2.query.NumericOperator
   * @see #setOperator(NumericOperator)
   * @see org.eclipse.emf.query2.query.QueryPackage#getNumericAttributeWhereEntry_Operator()
   * @model
   * @generated
   */
  NumericOperator getOperator();

  /**
   * Sets the value of the '{@link org.eclipse.emf.query2.query.NumericAttributeWhereEntry#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see org.eclipse.emf.query2.query.NumericOperator
   * @see #getOperator()
   * @generated
   */
  void setOperator(NumericOperator value);

} // NumericAttributeWhereEntry
