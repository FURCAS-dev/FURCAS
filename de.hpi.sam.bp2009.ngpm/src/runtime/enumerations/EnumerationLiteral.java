/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package runtime.enumerations;

import localization.TranslatableText;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link runtime.enumerations.EnumerationLiteral#getName <em>Name</em>}</li>
 *   <li>{@link runtime.enumerations.EnumerationLiteral#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see runtime.enumerations.EnumerationsPackage#getEnumerationLiteral()
 * @model
 * @generated
 */
public interface EnumerationLiteral extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see runtime.enumerations.EnumerationsPackage#getEnumerationLiteral_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link runtime.enumerations.EnumerationLiteral#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' containment reference.
   * @see #setDescription(TranslatableText)
   * @see runtime.enumerations.EnumerationsPackage#getEnumerationLiteral_Description()
   * @model containment="true"
   * @generated
   */
  TranslatableText getDescription();

  /**
   * Sets the value of the '{@link runtime.enumerations.EnumerationLiteral#getDescription <em>Description</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' containment reference.
   * @see #getDescription()
   * @generated
   */
  void setDescription(TranslatableText value);

} // EnumerationLiteral
