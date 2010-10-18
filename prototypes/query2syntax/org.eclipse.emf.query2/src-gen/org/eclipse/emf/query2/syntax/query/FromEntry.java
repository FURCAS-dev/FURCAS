/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.emf.query2.syntax.query;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>From Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.syntax.query.FromEntry#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.syntax.query.FromEntry#isWithoutsubtypes <em>Withoutsubtypes</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.syntax.query.FromEntry#getWithoutsubtypesTypes <em>Withoutsubtypes Types</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.syntax.query.FromEntry#getAlias <em>Alias</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.syntax.query.FromEntry#getScopeClause <em>Scope Clause</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.syntax.query.QueryPackage#getFromEntry()
 * @model
 * @generated
 */
public interface FromEntry extends EObject
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(EClass)
   * @see org.eclipse.emf.query2.syntax.query.QueryPackage#getFromEntry_Type()
   * @model
   * @generated
   */
  EClass getType();

  /**
   * Sets the value of the '{@link org.eclipse.emf.query2.syntax.query.FromEntry#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(EClass value);

  /**
   * Returns the value of the '<em><b>Withoutsubtypes</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Withoutsubtypes</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Withoutsubtypes</em>' attribute.
   * @see #setWithoutsubtypes(boolean)
   * @see org.eclipse.emf.query2.syntax.query.QueryPackage#getFromEntry_Withoutsubtypes()
   * @model
   * @generated
   */
  boolean isWithoutsubtypes();

  /**
   * Sets the value of the '{@link org.eclipse.emf.query2.syntax.query.FromEntry#isWithoutsubtypes <em>Withoutsubtypes</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Withoutsubtypes</em>' attribute.
   * @see #isWithoutsubtypes()
   * @generated
   */
  void setWithoutsubtypes(boolean value);

  /**
   * Returns the value of the '<em><b>Withoutsubtypes Types</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.emf.ecore.EClass}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Withoutsubtypes Types</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Withoutsubtypes Types</em>' reference list.
   * @see org.eclipse.emf.query2.syntax.query.QueryPackage#getFromEntry_WithoutsubtypesTypes()
   * @model
   * @generated
   */
  EList<EClass> getWithoutsubtypesTypes();

  /**
   * Returns the value of the '<em><b>Alias</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Alias</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Alias</em>' attribute.
   * @see #setAlias(String)
   * @see org.eclipse.emf.query2.syntax.query.QueryPackage#getFromEntry_Alias()
   * @model
   * @generated
   */
  String getAlias();

  /**
   * Sets the value of the '{@link org.eclipse.emf.query2.syntax.query.FromEntry#getAlias <em>Alias</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Alias</em>' attribute.
   * @see #getAlias()
   * @generated
   */
  void setAlias(String value);

  /**
   * Returns the value of the '<em><b>Scope Clause</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Scope Clause</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Scope Clause</em>' containment reference.
   * @see #setScopeClause(ScopeClause)
   * @see org.eclipse.emf.query2.syntax.query.QueryPackage#getFromEntry_ScopeClause()
   * @model containment="true"
   * @generated
   */
  ScopeClause getScopeClause();

  /**
   * Sets the value of the '{@link org.eclipse.emf.query2.syntax.query.FromEntry#getScopeClause <em>Scope Clause</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Scope Clause</em>' containment reference.
   * @see #getScopeClause()
   * @generated
   */
  void setScopeClause(ScopeClause value);

} // FromEntry
