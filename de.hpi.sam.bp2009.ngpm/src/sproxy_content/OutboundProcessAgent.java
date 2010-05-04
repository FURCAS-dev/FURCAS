/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sproxy_content;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Outbound Process Agent</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sproxy_content.OutboundProcessAgent#getOutboundServiceInterface <em>Outbound Service Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @see sproxy_content.Sproxy_contentPackage#getOutboundProcessAgent()
 * @model
 * @generated
 */
public interface OutboundProcessAgent extends ProcessAgent
{
  /**
   * Returns the value of the '<em><b>Outbound Service Interface</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Outbound Service Interface</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Outbound Service Interface</em>' reference.
   * @see #setOutboundServiceInterface(ServiceInterface)
   * @see sproxy_content.Sproxy_contentPackage#getOutboundProcessAgent_OutboundServiceInterface()
   * @model required="true"
   *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
   * @generated
   */
  ServiceInterface getOutboundServiceInterface();

  /**
   * Sets the value of the '{@link sproxy_content.OutboundProcessAgent#getOutboundServiceInterface <em>Outbound Service Interface</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Outbound Service Interface</em>' reference.
   * @see #getOutboundServiceInterface()
   * @generated
   */
  void setOutboundServiceInterface(ServiceInterface value);

} // OutboundProcessAgent
