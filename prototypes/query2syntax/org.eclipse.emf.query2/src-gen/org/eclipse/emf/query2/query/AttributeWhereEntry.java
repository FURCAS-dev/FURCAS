/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.emf.query2.query;

import org.eclipse.emf.ecore.EAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Where Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.query.AttributeWhereEntry#getAttribute <em>Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.query.QueryPackage#getAttributeWhereEntry()
 * @model
 * @generated
 */
public interface AttributeWhereEntry extends AbstractAliasWhereEntry
{
  /**
   * Returns the value of the '<em><b>Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attribute</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attribute</em>' reference.
   * @see #setAttribute(EAttribute)
   * @see org.eclipse.emf.query2.query.QueryPackage#getAttributeWhereEntry_Attribute()
   * @model
   * @generated
   */
  EAttribute getAttribute();

  /**
   * Sets the value of the '{@link org.eclipse.emf.query2.query.AttributeWhereEntry#getAttribute <em>Attribute</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Attribute</em>' reference.
   * @see #getAttribute()
   * @generated
   */
  void setAttribute(EAttribute value);

} // AttributeWhereEntry
