/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package abapmapping.abapdictionary;

import localization.TranslatableText;

import org.eclipse.emf.ecore.EObject;

import sproxy_content.LanguageDependentText;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Code Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * We deliberately reduced code values to unstructured, primitive values. Those examples that we are aware of where codes are of structured types only contain unmaintained attributes such as LIST_AGENCY_IDs and other supplementary components that can in our opinion safely be omitted for the time being.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link abapmapping.abapdictionary.CodeValue#getLanguageDependentDescription <em>Language Dependent Description</em>}</li>
 *   <li>{@link abapmapping.abapdictionary.CodeValue#getValue <em>Value</em>}</li>
 *   <li>{@link abapmapping.abapdictionary.CodeValue#getDescription <em>Description</em>}</li>
 *   <li>{@link abapmapping.abapdictionary.CodeValue#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see abapmapping.abapdictionary.AbapdictionaryPackage#getCodeValue()
 * @model
 * @generated
 */
public interface CodeValue extends EObject
{
  /**
   * Returns the value of the '<em><b>Language Dependent Description</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Language Dependent Description</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Language Dependent Description</em>' reference.
   * @see #setLanguageDependentDescription(LanguageDependentText)
   * @see abapmapping.abapdictionary.AbapdictionaryPackage#getCodeValue_LanguageDependentDescription()
   * @model required="true"
   *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
   * @generated
   */
  LanguageDependentText getLanguageDependentDescription();

  /**
   * Sets the value of the '{@link abapmapping.abapdictionary.CodeValue#getLanguageDependentDescription <em>Language Dependent Description</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Language Dependent Description</em>' reference.
   * @see #getLanguageDependentDescription()
   * @generated
   */
  void setLanguageDependentDescription(LanguageDependentText value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(runtime.primitivetypes.String)
   * @see abapmapping.abapdictionary.AbapdictionaryPackage#getCodeValue_Value()
   * @model containment="true"
   * @generated
   */
  runtime.primitivetypes.String getValue();

  /**
   * Sets the value of the '{@link abapmapping.abapdictionary.CodeValue#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(runtime.primitivetypes.String value);

  /**
   * Returns the value of the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' containment reference.
   * @see #setDescription(TranslatableText)
   * @see abapmapping.abapdictionary.AbapdictionaryPackage#getCodeValue_Description()
   * @model containment="true"
   * @generated
   */
  TranslatableText getDescription();

  /**
   * Sets the value of the '{@link abapmapping.abapdictionary.CodeValue#getDescription <em>Description</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' containment reference.
   * @see #getDescription()
   * @generated
   */
  void setDescription(TranslatableText value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(AbapPrimtiveType)
   * @see abapmapping.abapdictionary.AbapdictionaryPackage#getCodeValue_Type()
   * @model required="true"
   *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
   * @generated
   */
  AbapPrimtiveType getType();

  /**
   * Sets the value of the '{@link abapmapping.abapdictionary.CodeValue#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(AbapPrimtiveType value);

} // CodeValue
