/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.emf.query2.query;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Double Where Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.query.DoubleWhereEntry#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.query.QueryPackage#getDoubleWhereEntry()
 * @model
 * @generated
 */
public interface DoubleWhereEntry extends NumericAttributeWhereEntry
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(double)
   * @see org.eclipse.emf.query2.query.QueryPackage#getDoubleWhereEntry_Value()
   * @model
   * @generated
   */
  double getValue();

  /**
   * Sets the value of the '{@link org.eclipse.emf.query2.query.DoubleWhereEntry#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(double value);

} // DoubleWhereEntry
