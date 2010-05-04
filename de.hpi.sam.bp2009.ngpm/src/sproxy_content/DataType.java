/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sproxy_content;

import abapmapping.abapdictionary.AbapType;

import modelmanagement.NamedElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A DataType that is not a nodeDataType maps to a Class (node data types are combined with their respective BONodes into a single Class). The elements and attributes are mapped to respective Associations.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sproxy_content.DataType#getElements <em>Elements</em>}</li>
 *   <li>{@link sproxy_content.DataType#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link sproxy_content.DataType#getAbapType <em>Abap Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see sproxy_content.Sproxy_contentPackage#getDataType()
 * @model
 * @generated
 */
public interface DataType extends NamedElement
{
  /**
   * Returns the value of the '<em><b>Elements</b></em>' reference list.
   * The list contents are of type {@link sproxy_content.Element}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elements</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' reference list.
   * @see sproxy_content.Sproxy_contentPackage#getDataType_Elements()
   * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
   * @generated
   */
  EList<Element> getElements();

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' reference list.
   * The list contents are of type {@link sproxy_content.Attribute}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attributes</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' reference list.
   * @see sproxy_content.Sproxy_contentPackage#getDataType_Attributes()
   * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
   * @generated
   */
  EList<Attribute> getAttributes();

  /**
   * Returns the value of the '<em><b>Abap Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Abap Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Abap Type</em>' reference.
   * @see #setAbapType(AbapType)
   * @see sproxy_content.Sproxy_contentPackage#getDataType_AbapType()
   * @model required="true"
   *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
   * @generated
   */
  AbapType getAbapType();

  /**
   * Sets the value of the '{@link sproxy_content.DataType#getAbapType <em>Abap Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Abap Type</em>' reference.
   * @see #getAbapType()
   * @generated
   */
  void setAbapType(AbapType value);

} // DataType
