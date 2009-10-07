/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.emf.query2.query;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Or Where Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.query.OrWhereEntry#getEntries <em>Entries</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.query.QueryPackage#getOrWhereEntry()
 * @model
 * @generated
 */
public interface OrWhereEntry extends WhereEntry
{
  /**
   * Returns the value of the '<em><b>Entries</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.query2.query.WhereEntry}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Entries</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Entries</em>' containment reference list.
   * @see org.eclipse.emf.query2.query.QueryPackage#getOrWhereEntry_Entries()
   * @model containment="true"
   * @generated
   */
  EList<WhereEntry> getEntries();

} // OrWhereEntry
