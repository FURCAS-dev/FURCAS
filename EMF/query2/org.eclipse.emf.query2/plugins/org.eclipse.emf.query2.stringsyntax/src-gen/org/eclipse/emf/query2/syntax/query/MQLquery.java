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
 * A representation of the model object '<em><b>MQ Lquery</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.syntax.query.MQLquery#getFromEntries <em>From Entries</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.syntax.query.MQLquery#getSelectEntries <em>Select Entries</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.syntax.query.MQLquery#getWhereEntry <em>Where Entry</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.syntax.query.QueryPackage#getMQLquery()
 * @model
 * @generated
 */
public interface MQLquery extends EObject
{
  /**
   * Returns the value of the '<em><b>From Entries</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.query2.syntax.query.FromEntry}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>From Entries</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>From Entries</em>' containment reference list.
   * @see org.eclipse.emf.query2.syntax.query.QueryPackage#getMQLquery_FromEntries()
   * @model containment="true"
   * @generated
   */
  EList<FromEntry> getFromEntries();

  /**
   * Returns the value of the '<em><b>Select Entries</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.query2.syntax.query.SelectEntry}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Select Entries</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Select Entries</em>' containment reference list.
   * @see org.eclipse.emf.query2.syntax.query.QueryPackage#getMQLquery_SelectEntries()
   * @model containment="true"
   * @generated
   */
  EList<SelectEntry> getSelectEntries();

  /**
   * Returns the value of the '<em><b>Where Entry</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Where Entry</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Where Entry</em>' containment reference.
   * @see #setWhereEntry(WhereEntry)
   * @see org.eclipse.emf.query2.syntax.query.QueryPackage#getMQLquery_WhereEntry()
   * @model containment="true"
   * @generated
   */
  WhereEntry getWhereEntry();

  /**
   * Sets the value of the '{@link org.eclipse.emf.query2.syntax.query.MQLquery#getWhereEntry <em>Where Entry</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Where Entry</em>' containment reference.
   * @see #getWhereEntry()
   * @generated
   */
  void setWhereEntry(WhereEntry value);

} // MQLquery
