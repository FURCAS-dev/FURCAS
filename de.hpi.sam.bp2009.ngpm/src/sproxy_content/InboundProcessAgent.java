/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sproxy_content;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Inbound Process Agent</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sproxy_content.InboundProcessAgent#getInboundServiceInterfaces <em>Inbound Service Interfaces</em>}</li>
 * </ul>
 * </p>
 *
 * @see sproxy_content.Sproxy_contentPackage#getInboundProcessAgent()
 * @model
 * @generated
 */
public interface InboundProcessAgent extends ProcessAgent
{
  /**
   * Returns the value of the '<em><b>Inbound Service Interfaces</b></em>' reference list.
   * The list contents are of type {@link sproxy_content.ServiceInterface}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Inbound Service Interfaces</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inbound Service Interfaces</em>' reference list.
   * @see sproxy_content.Sproxy_contentPackage#getInboundProcessAgent_InboundServiceInterfaces()
   * @model required="true"
   *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
   * @generated
   */
  EList<ServiceInterface> getInboundServiceInterfaces();

} // InboundProcessAgent
