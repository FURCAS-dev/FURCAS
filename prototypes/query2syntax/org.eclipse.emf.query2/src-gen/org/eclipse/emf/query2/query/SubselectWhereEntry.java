/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.emf.query2.query;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subselect Where Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.query.SubselectWhereEntry#isNotIn <em>Not In</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.query.SubselectWhereEntry#getSubQuery <em>Sub Query</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.query.QueryPackage#getSubselectWhereEntry()
 * @model
 * @generated
 */
public interface SubselectWhereEntry extends ReferenceWhereEntry
{
  /**
   * Returns the value of the '<em><b>Not In</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Not In</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Not In</em>' attribute.
   * @see #setNotIn(boolean)
   * @see org.eclipse.emf.query2.query.QueryPackage#getSubselectWhereEntry_NotIn()
   * @model
   * @generated
   */
  boolean isNotIn();

  /**
   * Sets the value of the '{@link org.eclipse.emf.query2.query.SubselectWhereEntry#isNotIn <em>Not In</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Not In</em>' attribute.
   * @see #isNotIn()
   * @generated
   */
  void setNotIn(boolean value);

  /**
   * Returns the value of the '<em><b>Sub Query</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sub Query</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sub Query</em>' containment reference.
   * @see #setSubQuery(MQLquery)
   * @see org.eclipse.emf.query2.query.QueryPackage#getSubselectWhereEntry_SubQuery()
   * @model containment="true"
   * @generated
   */
  MQLquery getSubQuery();

  /**
   * Sets the value of the '{@link org.eclipse.emf.query2.query.SubselectWhereEntry#getSubQuery <em>Sub Query</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sub Query</em>' containment reference.
   * @see #getSubQuery()
   * @generated
   */
  void setSubQuery(MQLquery value);

} // SubselectWhereEntry
