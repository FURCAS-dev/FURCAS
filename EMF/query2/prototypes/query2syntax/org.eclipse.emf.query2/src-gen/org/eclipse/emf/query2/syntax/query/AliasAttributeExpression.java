/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.emf.query2.syntax.query;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alias Attribute Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.syntax.query.AliasAttributeExpression#getAlias <em>Alias</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.syntax.query.AliasAttributeExpression#getAttribute <em>Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.syntax.query.QueryPackage#getAliasAttributeExpression()
 * @model
 * @generated
 */
public interface AliasAttributeExpression extends Expression
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
   * @see org.eclipse.emf.query2.syntax.query.QueryPackage#getAliasAttributeExpression_Alias()
   * @model
   * @generated
   */
  FromEntry getAlias();

  /**
   * Sets the value of the '{@link org.eclipse.emf.query2.syntax.query.AliasAttributeExpression#getAlias <em>Alias</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Alias</em>' reference.
   * @see #getAlias()
   * @generated
   */
  void setAlias(FromEntry value);

  /**
   * Returns the value of the '<em><b>Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attribute</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attribute</em>' reference.
   * @see #setAttribute(EStructuralFeature)
   * @see org.eclipse.emf.query2.syntax.query.QueryPackage#getAliasAttributeExpression_Attribute()
   * @model
   * @generated
   */
  EStructuralFeature getAttribute();

  /**
   * Sets the value of the '{@link org.eclipse.emf.query2.syntax.query.AliasAttributeExpression#getAttribute <em>Attribute</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Attribute</em>' reference.
   * @see #getAttribute()
   * @generated
   */
  void setAttribute(EStructuralFeature value);

} // AliasAttributeExpression
