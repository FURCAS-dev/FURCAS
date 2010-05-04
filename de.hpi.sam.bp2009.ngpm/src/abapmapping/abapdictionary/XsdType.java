/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package abapmapping.abapdictionary;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Xsd Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link abapmapping.abapdictionary.XsdType#getXsdType <em>Xsd Type</em>}</li>
 *   <li>{@link abapmapping.abapdictionary.XsdType#getLength <em>Length</em>}</li>
 *   <li>{@link abapmapping.abapdictionary.XsdType#getPattern <em>Pattern</em>}</li>
 *   <li>{@link abapmapping.abapdictionary.XsdType#getTotalDigits <em>Total Digits</em>}</li>
 *   <li>{@link abapmapping.abapdictionary.XsdType#getFractionDigits <em>Fraction Digits</em>}</li>
 * </ul>
 * </p>
 *
 * @see abapmapping.abapdictionary.AbapdictionaryPackage#getXsdType()
 * @model
 * @generated
 */
public interface XsdType extends EObject
{
  /**
   * Returns the value of the '<em><b>Xsd Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Xsd Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Xsd Type</em>' containment reference.
   * @see #setXsdType(runtime.primitivetypes.String)
   * @see abapmapping.abapdictionary.AbapdictionaryPackage#getXsdType_XsdType()
   * @model containment="true"
   * @generated
   */
  runtime.primitivetypes.String getXsdType();

  /**
   * Sets the value of the '{@link abapmapping.abapdictionary.XsdType#getXsdType <em>Xsd Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Xsd Type</em>' containment reference.
   * @see #getXsdType()
   * @generated
   */
  void setXsdType(runtime.primitivetypes.String value);

  /**
   * Returns the value of the '<em><b>Length</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Length</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Length</em>' attribute.
   * @see #setLength(long)
   * @see abapmapping.abapdictionary.AbapdictionaryPackage#getXsdType_Length()
   * @model dataType="primitivetypes.Integer"
   * @generated
   */
  long getLength();

  /**
   * Sets the value of the '{@link abapmapping.abapdictionary.XsdType#getLength <em>Length</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Length</em>' attribute.
   * @see #getLength()
   * @generated
   */
  void setLength(long value);

  /**
   * Returns the value of the '<em><b>Pattern</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pattern</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pattern</em>' containment reference.
   * @see #setPattern(runtime.primitivetypes.String)
   * @see abapmapping.abapdictionary.AbapdictionaryPackage#getXsdType_Pattern()
   * @model containment="true"
   * @generated
   */
  runtime.primitivetypes.String getPattern();

  /**
   * Sets the value of the '{@link abapmapping.abapdictionary.XsdType#getPattern <em>Pattern</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pattern</em>' containment reference.
   * @see #getPattern()
   * @generated
   */
  void setPattern(runtime.primitivetypes.String value);

  /**
   * Returns the value of the '<em><b>Total Digits</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Total Digits</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Total Digits</em>' attribute.
   * @see #setTotalDigits(long)
   * @see abapmapping.abapdictionary.AbapdictionaryPackage#getXsdType_TotalDigits()
   * @model dataType="primitivetypes.Integer"
   * @generated
   */
  long getTotalDigits();

  /**
   * Sets the value of the '{@link abapmapping.abapdictionary.XsdType#getTotalDigits <em>Total Digits</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Total Digits</em>' attribute.
   * @see #getTotalDigits()
   * @generated
   */
  void setTotalDigits(long value);

  /**
   * Returns the value of the '<em><b>Fraction Digits</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fraction Digits</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fraction Digits</em>' attribute.
   * @see #setFractionDigits(long)
   * @see abapmapping.abapdictionary.AbapdictionaryPackage#getXsdType_FractionDigits()
   * @model dataType="primitivetypes.Integer"
   * @generated
   */
  long getFractionDigits();

  /**
   * Sets the value of the '{@link abapmapping.abapdictionary.XsdType#getFractionDigits <em>Fraction Digits</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fraction Digits</em>' attribute.
   * @see #getFractionDigits()
   * @generated
   */
  void setFractionDigits(long value);

} // XsdType
