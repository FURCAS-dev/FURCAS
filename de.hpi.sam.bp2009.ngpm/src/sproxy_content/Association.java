/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sproxy_content;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sproxy_content.Association#getComposite <em>Composite</em>}</li>
 *   <li>{@link sproxy_content.Association#getTargetNode <em>Target Node</em>}</li>
 *   <li>{@link sproxy_content.Association#getOwner <em>Owner</em>}</li>
 *   <li>{@link sproxy_content.Association#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see sproxy_content.Sproxy_contentPackage#getAssociation()
 * @model
 * @generated
 */
public interface Association extends EObject
{
  /**
   * Returns the value of the '<em><b>Composite</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Composite</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Composite</em>' containment reference.
   * @see #setComposite(runtime.primitivetypes.Boolean)
   * @see sproxy_content.Sproxy_contentPackage#getAssociation_Composite()
   * @model containment="true"
   * @generated
   */
  runtime.primitivetypes.Boolean getComposite();

  /**
   * Sets the value of the '{@link sproxy_content.Association#getComposite <em>Composite</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Composite</em>' containment reference.
   * @see #getComposite()
   * @generated
   */
  void setComposite(runtime.primitivetypes.Boolean value);

  /**
   * Returns the value of the '<em><b>Target Node</b></em>' reference.
   * It is bidirectional and its opposite is '{@link sproxy_content.BONode#getAssociation <em>Association</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target Node</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target Node</em>' reference.
   * @see #setTargetNode(BONode)
   * @see sproxy_content.Sproxy_contentPackage#getAssociation_TargetNode()
   * @see sproxy_content.BONode#getAssociation
   * @model opposite="association" required="true"
   * @generated
   */
  BONode getTargetNode();

  /**
   * Sets the value of the '{@link sproxy_content.Association#getTargetNode <em>Target Node</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target Node</em>' reference.
   * @see #getTargetNode()
   * @generated
   */
  void setTargetNode(BONode value);

  /**
   * Returns the value of the '<em><b>Owner</b></em>' reference.
   * It is bidirectional and its opposite is '{@link sproxy_content.BONode#getOutboundAssociations <em>Outbound Associations</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owner</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owner</em>' reference.
   * @see #setOwner(BONode)
   * @see sproxy_content.Sproxy_contentPackage#getAssociation_Owner()
   * @see sproxy_content.BONode#getOutboundAssociations
   * @model opposite="outboundAssociations" required="true"
   * @generated
   */
  BONode getOwner();

  /**
   * Sets the value of the '{@link sproxy_content.Association#getOwner <em>Owner</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Owner</em>' reference.
   * @see #getOwner()
   * @generated
   */
  void setOwner(BONode value);

  /**
   * Returns the value of the '<em><b>Properties</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Properties</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Properties</em>' reference.
   * @see #setProperties(AssociationProperties)
   * @see sproxy_content.Sproxy_contentPackage#getAssociation_Properties()
   * @model required="true"
   *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
   * @generated
   */
  AssociationProperties getProperties();

  /**
   * Sets the value of the '{@link sproxy_content.Association#getProperties <em>Properties</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Properties</em>' reference.
   * @see #getProperties()
   * @generated
   */
  void setProperties(AssociationProperties value);

} // Association
