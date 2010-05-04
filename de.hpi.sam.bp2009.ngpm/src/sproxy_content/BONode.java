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
 * A representation of the model object '<em><b>BO Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * BONodes other than root nodes are mapped to a Class, together with its nodeDataType. The DataType as well as the Associations on the BONode determine the set of Associations attached to the resulting Class.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sproxy_content.BONode#getNodeDataType <em>Node Data Type</em>}</li>
 *   <li>{@link sproxy_content.BONode#getBo <em>Bo</em>}</li>
 *   <li>{@link sproxy_content.BONode#getActions <em>Actions</em>}</li>
 *   <li>{@link sproxy_content.BONode#getStatusAndActionSchemas <em>Status And Action Schemas</em>}</li>
 *   <li>{@link sproxy_content.BONode#getAssociation <em>Association</em>}</li>
 *   <li>{@link sproxy_content.BONode#getOutboundAssociations <em>Outbound Associations</em>}</li>
 *   <li>{@link sproxy_content.BONode#getQueries <em>Queries</em>}</li>
 *   <li>{@link sproxy_content.BONode#getProperties <em>Properties</em>}</li>
 *   <li>{@link sproxy_content.BONode#getFieldProperties <em>Field Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see sproxy_content.Sproxy_contentPackage#getBONode()
 * @model annotation="http://de.hpi.sam.bp2009.OCL EitherRootOrChild='self.bo->isEmpty() implies self.association->exists(a:Association | a.composite)'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='EitherRootOrChild'"
 * @generated
 */
public interface BONode extends NamedElement
{
  /**
   * Returns the value of the '<em><b>Node Data Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Node Data Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Node Data Type</em>' reference.
   * @see #setNodeDataType(DataType)
   * @see sproxy_content.Sproxy_contentPackage#getBONode_NodeDataType()
   * @model required="true"
   *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
   * @generated
   */
  DataType getNodeDataType();

  /**
   * Sets the value of the '{@link sproxy_content.BONode#getNodeDataType <em>Node Data Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Node Data Type</em>' reference.
   * @see #getNodeDataType()
   * @generated
   */
  void setNodeDataType(DataType value);

  /**
   * Returns the value of the '<em><b>Bo</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link sproxy_content.BO#getRootNode <em>Root Node</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bo</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bo</em>' container reference.
   * @see #setBo(BO)
   * @see sproxy_content.Sproxy_contentPackage#getBONode_Bo()
   * @see sproxy_content.BO#getRootNode
   * @model opposite="rootNode"
   * @generated
   */
  BO getBo();

  /**
   * Sets the value of the '{@link sproxy_content.BONode#getBo <em>Bo</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Bo</em>' container reference.
   * @see #getBo()
   * @generated
   */
  void setBo(BO value);

  /**
   * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
   * The list contents are of type {@link sproxy_content.Action}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Actions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Actions</em>' containment reference list.
   * @see sproxy_content.Sproxy_contentPackage#getBONode_Actions()
   * @model containment="true"
   *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
   * @generated
   */
  EList<Action> getActions();

  /**
   * Returns the value of the '<em><b>Status And Action Schemas</b></em>' containment reference list.
   * The list contents are of type {@link sproxy_content.StatusAndActionSchema}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Status And Action Schemas</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Status And Action Schemas</em>' containment reference list.
   * @see sproxy_content.Sproxy_contentPackage#getBONode_StatusAndActionSchemas()
   * @model containment="true"
   *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
   * @generated
   */
  EList<StatusAndActionSchema> getStatusAndActionSchemas();

  /**
   * Returns the value of the '<em><b>Association</b></em>' reference list.
   * The list contents are of type {@link sproxy_content.Association}.
   * It is bidirectional and its opposite is '{@link sproxy_content.Association#getTargetNode <em>Target Node</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Association</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Association</em>' reference list.
   * @see sproxy_content.Sproxy_contentPackage#getBONode_Association()
   * @see sproxy_content.Association#getTargetNode
   * @model opposite="targetNode"
   * @generated
   */
  EList<Association> getAssociation();

  /**
   * Returns the value of the '<em><b>Outbound Associations</b></em>' reference list.
   * The list contents are of type {@link sproxy_content.Association}.
   * It is bidirectional and its opposite is '{@link sproxy_content.Association#getOwner <em>Owner</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Outbound Associations</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Outbound Associations</em>' reference list.
   * @see sproxy_content.Sproxy_contentPackage#getBONode_OutboundAssociations()
   * @see sproxy_content.Association#getOwner
   * @model opposite="owner"
   * @generated
   */
  EList<Association> getOutboundAssociations();

  /**
   * Returns the value of the '<em><b>Queries</b></em>' containment reference list.
   * The list contents are of type {@link sproxy_content.Query}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Queries</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Queries</em>' containment reference list.
   * @see sproxy_content.Sproxy_contentPackage#getBONode_Queries()
   * @model containment="true"
   *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
   * @generated
   */
  EList<Query> getQueries();

  /**
   * Returns the value of the '<em><b>Properties</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Properties</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Properties</em>' reference.
   * @see #setProperties(NodeProperties)
   * @see sproxy_content.Sproxy_contentPackage#getBONode_Properties()
   * @model required="true"
   *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
   * @generated
   */
  NodeProperties getProperties();

  /**
   * Sets the value of the '{@link sproxy_content.BONode#getProperties <em>Properties</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Properties</em>' reference.
   * @see #getProperties()
   * @generated
   */
  void setProperties(NodeProperties value);

  /**
   * Returns the value of the '<em><b>Field Properties</b></em>' containment reference list.
   * The list contents are of type {@link sproxy_content.FieldProperties}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Field Properties</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Field Properties</em>' containment reference list.
   * @see sproxy_content.Sproxy_contentPackage#getBONode_FieldProperties()
   * @model containment="true"
   *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
   * @generated
   */
  EList<FieldProperties> getFieldProperties();

} // BONode
