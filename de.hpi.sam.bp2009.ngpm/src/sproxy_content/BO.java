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
 * A representation of the model object '<em><b>BO</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Partition ID consists of BO's name and namespace. The single BO is the single root of that partition. The partition contains the subordinate BONodes with their Operations (Action/Query), Associations, the StautsAndActionSchemas as well as all ESF properties pertinent to any of these nodes.
 * 
 * Together with its root BONode, the BO element is mapped to a Class. The BO properties such as its name determine the key properties of the resulting class. The node's data structure and child nodes determine other structural properties of the resulting Class.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sproxy_content.BO#getRootNode <em>Root Node</em>}</li>
 *   <li>{@link sproxy_content.BO#getStatusDerivators <em>Status Derivators</em>}</li>
 *   <li>{@link sproxy_content.BO#getTemplate <em>Template</em>}</li>
 *   <li>{@link sproxy_content.BO#getProjections <em>Projections</em>}</li>
 * </ul>
 * </p>
 *
 * @see sproxy_content.Sproxy_contentPackage#getBO()
 * @model
 * @generated
 */
public interface BO extends NamedElement
{
  /**
   * Returns the value of the '<em><b>Root Node</b></em>' containment reference.
   * It is bidirectional and its opposite is '{@link sproxy_content.BONode#getBo <em>Bo</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Root Node</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Root Node</em>' containment reference.
   * @see #setRootNode(BONode)
   * @see sproxy_content.Sproxy_contentPackage#getBO_RootNode()
   * @see sproxy_content.BONode#getBo
   * @model opposite="bo" containment="true" required="true"
   * @generated
   */
  BONode getRootNode();

  /**
   * Sets the value of the '{@link sproxy_content.BO#getRootNode <em>Root Node</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Root Node</em>' containment reference.
   * @see #getRootNode()
   * @generated
   */
  void setRootNode(BONode value);

  /**
   * Returns the value of the '<em><b>Status Derivators</b></em>' reference list.
   * The list contents are of type {@link sproxy_content.StatusDerivator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Status Derivators</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Status Derivators</em>' reference list.
   * @see sproxy_content.Sproxy_contentPackage#getBO_StatusDerivators()
   * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
   * @generated
   */
  EList<StatusDerivator> getStatusDerivators();

  /**
   * Returns the value of the '<em><b>Template</b></em>' reference.
   * It is bidirectional and its opposite is '{@link sproxy_content.BO#getProjections <em>Projections</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Template</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Template</em>' reference.
   * @see #setTemplate(BO)
   * @see sproxy_content.Sproxy_contentPackage#getBO_Template()
   * @see sproxy_content.BO#getProjections
   * @model opposite="projections"
   * @generated
   */
  BO getTemplate();

  /**
   * Sets the value of the '{@link sproxy_content.BO#getTemplate <em>Template</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Template</em>' reference.
   * @see #getTemplate()
   * @generated
   */
  void setTemplate(BO value);

  /**
   * Returns the value of the '<em><b>Projections</b></em>' reference list.
   * The list contents are of type {@link sproxy_content.BO}.
   * It is bidirectional and its opposite is '{@link sproxy_content.BO#getTemplate <em>Template</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Projections</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Projections</em>' reference list.
   * @see sproxy_content.Sproxy_contentPackage#getBO_Projections()
   * @see sproxy_content.BO#getTemplate
   * @model opposite="template"
   * @generated
   */
  EList<BO> getProjections();

} // BO
