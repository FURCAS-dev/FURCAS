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
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.syntax.query.Model#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.syntax.query.Model#getDefaultQuery <em>Default Query</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.syntax.query.Model#getNamedQueries <em>Named Queries</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.syntax.query.QueryPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.query2.syntax.query.Import}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imports</em>' containment reference list.
   * @see org.eclipse.emf.query2.syntax.query.QueryPackage#getModel_Imports()
   * @model containment="true"
   * @generated
   */
  EList<Import> getImports();

  /**
   * Returns the value of the '<em><b>Default Query</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Default Query</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Default Query</em>' containment reference.
   * @see #setDefaultQuery(MQLquery)
   * @see org.eclipse.emf.query2.syntax.query.QueryPackage#getModel_DefaultQuery()
   * @model containment="true"
   * @generated
   */
  MQLquery getDefaultQuery();

  /**
   * Sets the value of the '{@link org.eclipse.emf.query2.syntax.query.Model#getDefaultQuery <em>Default Query</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Default Query</em>' containment reference.
   * @see #getDefaultQuery()
   * @generated
   */
  void setDefaultQuery(MQLquery value);

  /**
   * Returns the value of the '<em><b>Named Queries</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.query2.syntax.query.NamedQuery}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Named Queries</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Named Queries</em>' containment reference list.
   * @see org.eclipse.emf.query2.syntax.query.QueryPackage#getModel_NamedQueries()
   * @model containment="true"
   * @generated
   */
  EList<NamedQuery> getNamedQueries();

} // Model
