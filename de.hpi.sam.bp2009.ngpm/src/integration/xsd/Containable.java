/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package integration.xsd;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Containable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link integration.xsd.Containable#getMinOccurs <em>Min Occurs</em>}</li>
 *   <li>{@link integration.xsd.Containable#getMaxOccurs <em>Max Occurs</em>}</li>
 * </ul>
 * </p>
 *
 * @see integration.xsd.XsdPackage#getContainable()
 * @model abstract="true"
 * @generated
 */
public interface Containable extends Root
{
  /**
   * Returns the value of the '<em><b>Min Occurs</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Min Occurs</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Min Occurs</em>' attribute.
   * @see #setMinOccurs(long)
   * @see integration.xsd.XsdPackage#getContainable_MinOccurs()
   * @model dataType="primitivetypes.Integer"
   * @generated
   */
  long getMinOccurs();

  /**
   * Sets the value of the '{@link integration.xsd.Containable#getMinOccurs <em>Min Occurs</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Min Occurs</em>' attribute.
   * @see #getMinOccurs()
   * @generated
   */
  void setMinOccurs(long value);

  /**
   * Returns the value of the '<em><b>Max Occurs</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Max Occurs</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Max Occurs</em>' attribute.
   * @see #setMaxOccurs(long)
   * @see integration.xsd.XsdPackage#getContainable_MaxOccurs()
   * @model dataType="primitivetypes.Integer"
   * @generated
   */
  long getMaxOccurs();

  /**
   * Sets the value of the '{@link integration.xsd.Containable#getMaxOccurs <em>Max Occurs</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Max Occurs</em>' attribute.
   * @see #getMaxOccurs()
   * @generated
   */
  void setMaxOccurs(long value);

} // Containable
