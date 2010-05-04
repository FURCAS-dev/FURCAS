/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sproxy_content;

import abapmapping.abapdictionary.UnstructuredAbapType;

import modelmanagement.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Maps to an Association between the Classes to which the owning DataType and the UnstructuredAbapType have been mapped, respectively.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sproxy_content.Attribute#getStatusAttribute <em>Status Attribute</em>}</li>
 *   <li>{@link sproxy_content.Attribute#getAbapType <em>Abap Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see sproxy_content.Sproxy_contentPackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends NamedElement, Field
{
  /**
   * Returns the value of the '<em><b>Status Attribute</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Status Attribute</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Status Attribute</em>' containment reference.
   * @see #setStatusAttribute(runtime.primitivetypes.Boolean)
   * @see sproxy_content.Sproxy_contentPackage#getAttribute_StatusAttribute()
   * @model containment="true"
   * @generated
   */
  runtime.primitivetypes.Boolean getStatusAttribute();

  /**
   * Sets the value of the '{@link sproxy_content.Attribute#getStatusAttribute <em>Status Attribute</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Status Attribute</em>' containment reference.
   * @see #getStatusAttribute()
   * @generated
   */
  void setStatusAttribute(runtime.primitivetypes.Boolean value);

  /**
   * Returns the value of the '<em><b>Abap Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Abap Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Abap Type</em>' reference.
   * @see #setAbapType(UnstructuredAbapType)
   * @see sproxy_content.Sproxy_contentPackage#getAttribute_AbapType()
   * @model required="true"
   *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
   * @generated
   */
  UnstructuredAbapType getAbapType();

  /**
   * Sets the value of the '{@link sproxy_content.Attribute#getAbapType <em>Abap Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Abap Type</em>' reference.
   * @see #getAbapType()
   * @generated
   */
  void setAbapType(UnstructuredAbapType value);

} // Attribute
