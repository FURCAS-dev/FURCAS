/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.emf.query2.query;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Attribute Where Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.query.StringAttributeWhereEntry#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.query.StringAttributeWhereEntry#getPattern <em>Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.query.QueryPackage#getStringAttributeWhereEntry()
 * @model
 * @generated
 */
public interface StringAttributeWhereEntry extends AttributeWhereEntry
{
  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.emf.query2.query.StringOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see org.eclipse.emf.query2.query.StringOperator
   * @see #setOperator(StringOperator)
   * @see org.eclipse.emf.query2.query.QueryPackage#getStringAttributeWhereEntry_Operator()
   * @model
   * @generated
   */
  StringOperator getOperator();

  /**
   * Sets the value of the '{@link org.eclipse.emf.query2.query.StringAttributeWhereEntry#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see org.eclipse.emf.query2.query.StringOperator
   * @see #getOperator()
   * @generated
   */
  void setOperator(StringOperator value);

  /**
   * Returns the value of the '<em><b>Pattern</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pattern</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pattern</em>' attribute.
   * @see #setPattern(String)
   * @see org.eclipse.emf.query2.query.QueryPackage#getStringAttributeWhereEntry_Pattern()
   * @model
   * @generated
   */
  String getPattern();

  /**
   * Sets the value of the '{@link org.eclipse.emf.query2.query.StringAttributeWhereEntry#getPattern <em>Pattern</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pattern</em>' attribute.
   * @see #getPattern()
   * @generated
   */
  void setPattern(String value);

} // StringAttributeWhereEntry
