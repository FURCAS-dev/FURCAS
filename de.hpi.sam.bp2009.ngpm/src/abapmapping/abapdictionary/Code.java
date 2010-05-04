/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package abapmapping.abapdictionary;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Code</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link abapmapping.abapdictionary.Code#getExtensible <em>Extensible</em>}</li>
 *   <li>{@link abapmapping.abapdictionary.Code#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see abapmapping.abapdictionary.AbapdictionaryPackage#getCode()
 * @model annotation="http://de.hpi.sam.bp2009.OCL TypeOfValuesEqualsAbapType='self.values->forAll(cv:CodeValue |\r\n      cv.type = self.abapType)'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='TypeOfValuesEqualsAbapType'"
 * @generated
 */
public interface Code extends DataElement
{
  /**
   * Returns the value of the '<em><b>Extensible</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extensible</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extensible</em>' containment reference.
   * @see #setExtensible(runtime.primitivetypes.Boolean)
   * @see abapmapping.abapdictionary.AbapdictionaryPackage#getCode_Extensible()
   * @model containment="true"
   * @generated
   */
  runtime.primitivetypes.Boolean getExtensible();

  /**
   * Sets the value of the '{@link abapmapping.abapdictionary.Code#getExtensible <em>Extensible</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extensible</em>' containment reference.
   * @see #getExtensible()
   * @generated
   */
  void setExtensible(runtime.primitivetypes.Boolean value);

  /**
   * Returns the value of the '<em><b>Values</b></em>' containment reference list.
   * The list contents are of type {@link abapmapping.abapdictionary.CodeValue}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Values</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Values</em>' containment reference list.
   * @see abapmapping.abapdictionary.AbapdictionaryPackage#getCode_Values()
   * @model containment="true"
   *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
   * @generated
   */
  EList<CodeValue> getValues();

} // Code
