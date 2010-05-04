/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package integration.xsd;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Notation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link integration.xsd.Notation#getPublicDec <em>Public Dec</em>}</li>
 *   <li>{@link integration.xsd.Notation#getSystemDec <em>System Dec</em>}</li>
 * </ul>
 * </p>
 *
 * @see integration.xsd.XsdPackage#getNotation()
 * @model
 * @generated
 */
public interface Notation extends NamedElement
{
  /**
   * Returns the value of the '<em><b>Public Dec</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Public Dec</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Public Dec</em>' containment reference.
   * @see #setPublicDec(runtime.primitivetypes.String)
   * @see integration.xsd.XsdPackage#getNotation_PublicDec()
   * @model containment="true"
   * @generated
   */
  runtime.primitivetypes.String getPublicDec();

  /**
   * Sets the value of the '{@link integration.xsd.Notation#getPublicDec <em>Public Dec</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Public Dec</em>' containment reference.
   * @see #getPublicDec()
   * @generated
   */
  void setPublicDec(runtime.primitivetypes.String value);

  /**
   * Returns the value of the '<em><b>System Dec</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>System Dec</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>System Dec</em>' containment reference.
   * @see #setSystemDec(runtime.primitivetypes.String)
   * @see integration.xsd.XsdPackage#getNotation_SystemDec()
   * @model containment="true"
   * @generated
   */
  runtime.primitivetypes.String getSystemDec();

  /**
   * Sets the value of the '{@link integration.xsd.Notation#getSystemDec <em>System Dec</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>System Dec</em>' containment reference.
   * @see #getSystemDec()
   * @generated
   */
  void setSystemDec(runtime.primitivetypes.String value);

} // Notation
