/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sproxy_content;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sproxy_content.Field#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see sproxy_content.Sproxy_contentPackage#getField()
 * @model
 * @generated
 */
public interface Field extends EObject
{
  /**
   * Returns the value of the '<em><b>Properties</b></em>' reference list.
   * The list contents are of type {@link sproxy_content.FieldProperties}.
   * It is bidirectional and its opposite is '{@link sproxy_content.FieldProperties#getField <em>Field</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Properties</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Properties</em>' reference list.
   * @see sproxy_content.Sproxy_contentPackage#getField_Properties()
   * @see sproxy_content.FieldProperties#getField
   * @model opposite="field"
   * @generated
   */
  EList<FieldProperties> getProperties();

} // Field
