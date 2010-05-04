/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sproxy_content;

import modelmanagement.NamedElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sproxy_content.ServiceInterface#getOperations <em>Operations</em>}</li>
 * </ul>
 * </p>
 *
 * @see sproxy_content.Sproxy_contentPackage#getServiceInterface()
 * @model
 * @generated
 */
public interface ServiceInterface extends NamedElement
{
  /**
   * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
   * The list contents are of type {@link sproxy_content.ServiceInterfaceOperation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operations</em>' containment reference list.
   * @see sproxy_content.Sproxy_contentPackage#getServiceInterface_Operations()
   * @model containment="true"
   *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
   * @generated
   */
  EList<ServiceInterfaceOperation> getOperations();

} // ServiceInterface
