/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.emf.query2.query;

import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Where Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.query.ReferenceWhereEntry#getReference <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.query.QueryPackage#getReferenceWhereEntry()
 * @model
 * @generated
 */
public interface ReferenceWhereEntry extends AbstractAliasWhereEntry
{
  /**
   * Returns the value of the '<em><b>Reference</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Reference</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reference</em>' reference.
   * @see #setReference(EReference)
   * @see org.eclipse.emf.query2.query.QueryPackage#getReferenceWhereEntry_Reference()
   * @model
   * @generated
   */
  EReference getReference();

  /**
   * Sets the value of the '{@link org.eclipse.emf.query2.query.ReferenceWhereEntry#getReference <em>Reference</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reference</em>' reference.
   * @see #getReference()
   * @generated
   */
  void setReference(EReference value);

} // ReferenceWhereEntry
