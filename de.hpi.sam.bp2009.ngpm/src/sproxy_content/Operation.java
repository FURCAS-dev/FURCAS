/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sproxy_content;

import modelmanagement.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sproxy_content.Operation#getParameterType <em>Parameter Type</em>}</li>
 *   <li>{@link sproxy_content.Operation#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see sproxy_content.Sproxy_contentPackage#getOperation()
 * @model
 * @generated
 */
public interface Operation extends NamedElement
{
  /**
   * Returns the value of the '<em><b>Parameter Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameter Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameter Type</em>' reference.
   * @see #setParameterType(DataType)
   * @see sproxy_content.Sproxy_contentPackage#getOperation_ParameterType()
   * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
   * @generated
   */
  DataType getParameterType();

  /**
   * Sets the value of the '{@link sproxy_content.Operation#getParameterType <em>Parameter Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parameter Type</em>' reference.
   * @see #getParameterType()
   * @generated
   */
  void setParameterType(DataType value);

  /**
   * Returns the value of the '<em><b>Properties</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Properties</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Properties</em>' reference.
   * @see #setProperties(OperationProperties)
   * @see sproxy_content.Sproxy_contentPackage#getOperation_Properties()
   * @model required="true"
   *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
   * @generated
   */
  OperationProperties getProperties();

  /**
   * Sets the value of the '{@link sproxy_content.Operation#getProperties <em>Properties</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Properties</em>' reference.
   * @see #getProperties()
   * @generated
   */
  void setProperties(OperationProperties value);

} // Operation
