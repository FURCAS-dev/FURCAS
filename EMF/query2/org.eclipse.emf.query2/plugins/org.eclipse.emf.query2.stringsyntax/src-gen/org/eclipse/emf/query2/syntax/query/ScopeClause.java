/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.emf.query2.syntax.query;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scope Clause</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.syntax.query.ScopeClause#isNotIn <em>Not In</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.syntax.query.ScopeClause#getUris <em>Uris</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.syntax.query.QueryPackage#getScopeClause()
 * @model
 * @generated
 */
public interface ScopeClause extends EObject
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
   * @see org.eclipse.emf.query2.syntax.query.QueryPackage#getScopeClause_NotIn()
   * @model
   * @generated
   */
  boolean isNotIn();

  /**
   * Sets the value of the '{@link org.eclipse.emf.query2.syntax.query.ScopeClause#isNotIn <em>Not In</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Not In</em>' attribute.
   * @see #isNotIn()
   * @generated
   */
  void setNotIn(boolean value);

  /**
   * Returns the value of the '<em><b>Uris</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Uris</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Uris</em>' attribute list.
   * @see org.eclipse.emf.query2.syntax.query.QueryPackage#getScopeClause_Uris()
   * @model unique="false"
   * @generated
   */
  EList<String> getUris();

} // ScopeClause
