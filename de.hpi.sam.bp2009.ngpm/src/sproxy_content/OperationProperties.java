/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sproxy_content;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sproxy_content.OperationProperties#getEnabled <em>Enabled</em>}</li>
 *   <li>{@link sproxy_content.OperationProperties#getEnabledFinal <em>Enabled Final</em>}</li>
 * </ul>
 * </p>
 *
 * @see sproxy_content.Sproxy_contentPackage#getOperationProperties()
 * @model
 * @generated
 */
public interface OperationProperties extends EObject
{
  /**
   * Returns the value of the '<em><b>Enabled</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Enabled</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enabled</em>' containment reference.
   * @see #setEnabled(runtime.primitivetypes.Boolean)
   * @see sproxy_content.Sproxy_contentPackage#getOperationProperties_Enabled()
   * @model containment="true"
   * @generated
   */
  runtime.primitivetypes.Boolean getEnabled();

  /**
   * Sets the value of the '{@link sproxy_content.OperationProperties#getEnabled <em>Enabled</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Enabled</em>' containment reference.
   * @see #getEnabled()
   * @generated
   */
  void setEnabled(runtime.primitivetypes.Boolean value);

  /**
   * Returns the value of the '<em><b>Enabled Final</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Enabled Final</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enabled Final</em>' containment reference.
   * @see #setEnabledFinal(runtime.primitivetypes.Boolean)
   * @see sproxy_content.Sproxy_contentPackage#getOperationProperties_EnabledFinal()
   * @model containment="true"
   * @generated
   */
  runtime.primitivetypes.Boolean getEnabledFinal();

  /**
   * Sets the value of the '{@link sproxy_content.OperationProperties#getEnabledFinal <em>Enabled Final</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Enabled Final</em>' containment reference.
   * @see #getEnabledFinal()
   * @generated
   */
  void setEnabledFinal(runtime.primitivetypes.Boolean value);

} // OperationProperties
