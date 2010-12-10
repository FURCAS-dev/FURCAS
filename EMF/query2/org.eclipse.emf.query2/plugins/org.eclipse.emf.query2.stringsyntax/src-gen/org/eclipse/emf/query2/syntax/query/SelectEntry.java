/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.emf.query2.syntax.query;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Select Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.syntax.query.SelectEntry#getSelect <em>Select</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.syntax.query.SelectEntry#getAttribute <em>Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.syntax.query.QueryPackage#getSelectEntry()
 * @model
 * @generated
 */
public interface SelectEntry extends EObject
{
  /**
   * Returns the value of the '<em><b>Select</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Select</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Select</em>' reference.
   * @see #setSelect(FromEntry)
   * @see org.eclipse.emf.query2.syntax.query.QueryPackage#getSelectEntry_Select()
   * @model
   * @generated
   */
  FromEntry getSelect();

  /**
   * Sets the value of the '{@link org.eclipse.emf.query2.syntax.query.SelectEntry#getSelect <em>Select</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Select</em>' reference.
   * @see #getSelect()
   * @generated
   */
  void setSelect(FromEntry value);

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
   * @see org.eclipse.emf.query2.syntax.query.QueryPackage#getSelectEntry_Attribute()
   * @model
   * @generated
   */
  EAttribute getAttribute();

  /**
   * Sets the value of the '{@link org.eclipse.emf.query2.syntax.query.SelectEntry#getAttribute <em>Attribute</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Attribute</em>' reference.
   * @see #getAttribute()
   * @generated
   */
  void setAttribute(EAttribute value);

} // SelectEntry
