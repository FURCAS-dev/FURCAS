/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package integration.xsd;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link integration.xsd.Annotation#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link integration.xsd.Annotation#getAppInfo <em>App Info</em>}</li>
 * </ul>
 * </p>
 *
 * @see integration.xsd.XsdPackage#getAnnotation()
 * @model
 * @generated
 */
public interface Annotation extends EObject
{
  /**
   * Returns the value of the '<em><b>Documentation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Documentation</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Documentation</em>' containment reference.
   * @see #setDocumentation(runtime.primitivetypes.String)
   * @see integration.xsd.XsdPackage#getAnnotation_Documentation()
   * @model containment="true"
   * @generated
   */
  runtime.primitivetypes.String getDocumentation();

  /**
   * Sets the value of the '{@link integration.xsd.Annotation#getDocumentation <em>Documentation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Documentation</em>' containment reference.
   * @see #getDocumentation()
   * @generated
   */
  void setDocumentation(runtime.primitivetypes.String value);

  /**
   * Returns the value of the '<em><b>App Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>App Info</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>App Info</em>' containment reference.
   * @see #setAppInfo(runtime.primitivetypes.String)
   * @see integration.xsd.XsdPackage#getAnnotation_AppInfo()
   * @model containment="true"
   * @generated
   */
  runtime.primitivetypes.String getAppInfo();

  /**
   * Sets the value of the '{@link integration.xsd.Annotation#getAppInfo <em>App Info</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>App Info</em>' containment reference.
   * @see #getAppInfo()
   * @generated
   */
  void setAppInfo(runtime.primitivetypes.String value);

} // Annotation
