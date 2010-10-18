/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.emf.query2.syntax.query;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.syntax.query.Import#getImpURI <em>Imp URI</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.syntax.query.QueryPackage#getImport()
 * @model
 * @generated
 */
public interface Import extends EObject
{
  /**
   * Returns the value of the '<em><b>Imp URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Imp URI</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imp URI</em>' attribute.
   * @see #setImpURI(String)
   * @see org.eclipse.emf.query2.syntax.query.QueryPackage#getImport_ImpURI()
   * @model
   * @generated
   */
  String getImpURI();

  /**
   * Sets the value of the '{@link org.eclipse.emf.query2.syntax.query.Import#getImpURI <em>Imp URI</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Imp URI</em>' attribute.
   * @see #getImpURI()
   * @generated
   */
  void setImpURI(String value);

} // Import
