/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.emf.query2.query;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Alias Where Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.query.ReferenceAliasWhereEntry#getRightAlias <em>Right Alias</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.query.QueryPackage#getReferenceAliasWhereEntry()
 * @model
 * @generated
 */
public interface ReferenceAliasWhereEntry extends ReferenceWhereEntry
{
  /**
   * Returns the value of the '<em><b>Right Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right Alias</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right Alias</em>' reference.
   * @see #setRightAlias(FromEntry)
   * @see org.eclipse.emf.query2.query.QueryPackage#getReferenceAliasWhereEntry_RightAlias()
   * @model
   * @generated
   */
  FromEntry getRightAlias();

  /**
   * Sets the value of the '{@link org.eclipse.emf.query2.query.ReferenceAliasWhereEntry#getRightAlias <em>Right Alias</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right Alias</em>' reference.
   * @see #getRightAlias()
   * @generated
   */
  void setRightAlias(FromEntry value);

} // ReferenceAliasWhereEntry
