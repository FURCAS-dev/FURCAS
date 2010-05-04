/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package integration.xsd;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Content</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link integration.xsd.SimpleContent#getBase <em>Base</em>}</li>
 *   <li>{@link integration.xsd.SimpleContent#getEnumVals <em>Enum Vals</em>}</li>
 * </ul>
 * </p>
 *
 * @see integration.xsd.XsdPackage#getSimpleContent()
 * @model
 * @generated
 */
public interface SimpleContent extends AbstractContent
{
  /**
   * Returns the value of the '<em><b>Base</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Base</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Base</em>' containment reference.
   * @see #setBase(runtime.primitivetypes.String)
   * @see integration.xsd.XsdPackage#getSimpleContent_Base()
   * @model containment="true"
   * @generated
   */
  runtime.primitivetypes.String getBase();

  /**
   * Sets the value of the '{@link integration.xsd.SimpleContent#getBase <em>Base</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Base</em>' containment reference.
   * @see #getBase()
   * @generated
   */
  void setBase(runtime.primitivetypes.String value);

  /**
   * Returns the value of the '<em><b>Enum Vals</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Enum Vals</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enum Vals</em>' containment reference.
   * @see #setEnumVals(runtime.primitivetypes.String)
   * @see integration.xsd.XsdPackage#getSimpleContent_EnumVals()
   * @model containment="true"
   * @generated
   */
  runtime.primitivetypes.String getEnumVals();

  /**
   * Sets the value of the '{@link integration.xsd.SimpleContent#getEnumVals <em>Enum Vals</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Enum Vals</em>' containment reference.
   * @see #getEnumVals()
   * @generated
   */
  void setEnumVals(runtime.primitivetypes.String value);

} // SimpleContent
