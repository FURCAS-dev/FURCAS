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
 * A representation of the model object '<em><b>Service Interface Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sproxy_content.ServiceInterfaceOperation#getRequestMessageType <em>Request Message Type</em>}</li>
 *   <li>{@link sproxy_content.ServiceInterfaceOperation#getResponseMessageType <em>Response Message Type</em>}</li>
 *   <li>{@link sproxy_content.ServiceInterfaceOperation#getFaultMessageType <em>Fault Message Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see sproxy_content.Sproxy_contentPackage#getServiceInterfaceOperation()
 * @model
 * @generated
 */
public interface ServiceInterfaceOperation extends NamedElement
{
  /**
   * Returns the value of the '<em><b>Request Message Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Request Message Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Request Message Type</em>' reference.
   * @see #setRequestMessageType(DataType)
   * @see sproxy_content.Sproxy_contentPackage#getServiceInterfaceOperation_RequestMessageType()
   * @model required="true"
   *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
   * @generated
   */
  DataType getRequestMessageType();

  /**
   * Sets the value of the '{@link sproxy_content.ServiceInterfaceOperation#getRequestMessageType <em>Request Message Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Request Message Type</em>' reference.
   * @see #getRequestMessageType()
   * @generated
   */
  void setRequestMessageType(DataType value);

  /**
   * Returns the value of the '<em><b>Response Message Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Response Message Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Response Message Type</em>' reference.
   * @see #setResponseMessageType(DataType)
   * @see sproxy_content.Sproxy_contentPackage#getServiceInterfaceOperation_ResponseMessageType()
   * @model required="true"
   *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
   * @generated
   */
  DataType getResponseMessageType();

  /**
   * Sets the value of the '{@link sproxy_content.ServiceInterfaceOperation#getResponseMessageType <em>Response Message Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Response Message Type</em>' reference.
   * @see #getResponseMessageType()
   * @generated
   */
  void setResponseMessageType(DataType value);

  /**
   * Returns the value of the '<em><b>Fault Message Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fault Message Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fault Message Type</em>' reference.
   * @see #setFaultMessageType(DataType)
   * @see sproxy_content.Sproxy_contentPackage#getServiceInterfaceOperation_FaultMessageType()
   * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
   * @generated
   */
  DataType getFaultMessageType();

  /**
   * Sets the value of the '{@link sproxy_content.ServiceInterfaceOperation#getFaultMessageType <em>Fault Message Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fault Message Type</em>' reference.
   * @see #getFaultMessageType()
   * @generated
   */
  void setFaultMessageType(DataType value);

} // ServiceInterfaceOperation
