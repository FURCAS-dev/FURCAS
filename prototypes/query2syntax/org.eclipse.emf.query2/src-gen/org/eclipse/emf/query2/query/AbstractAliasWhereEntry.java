/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.emf.query2.query;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Alias Where Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.query.AbstractAliasWhereEntry#getAlias <em>Alias</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.query.QueryPackage#getAbstractAliasWhereEntry()
 * @model
 * @generated
 */
public interface AbstractAliasWhereEntry extends WhereEntry
{
  /**
   * Returns the value of the '<em><b>Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Alias</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Alias</em>' reference.
   * @see #setAlias(FromEntry)
   * @see org.eclipse.emf.query2.query.QueryPackage#getAbstractAliasWhereEntry_Alias()
   * @model
   * @generated
   */
  FromEntry getAlias();

  /**
   * Sets the value of the '{@link org.eclipse.emf.query2.query.AbstractAliasWhereEntry#getAlias <em>Alias</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Alias</em>' reference.
   * @see #getAlias()
   * @generated
   */
  void setAlias(FromEntry value);

} // AbstractAliasWhereEntry
