/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package integration.xsd;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link integration.xsd.NamedElement#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see integration.xsd.XsdPackage#getNamedElement()
 * @model abstract="true"
 * @generated
 */
public interface NamedElement extends Root
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' containment reference.
   * @see #setName(runtime.primitivetypes.String)
   * @see integration.xsd.XsdPackage#getNamedElement_Name()
   * @model containment="true"
   * @generated
   */
  runtime.primitivetypes.String getName();

  /**
   * Sets the value of the '{@link integration.xsd.NamedElement#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(runtime.primitivetypes.String value);

} // NamedElement
