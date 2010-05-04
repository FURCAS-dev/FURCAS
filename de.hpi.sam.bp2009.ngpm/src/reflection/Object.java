/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reflection;

import data.classes.SapClass;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reflection.Object#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see reflection.ReflectionPackage#getObject()
 * @model
 * @generated
 */
public interface Object extends EObject
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * It is bidirectional and its opposite is '{@link data.classes.SapClass#getInstances <em>Instances</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(SapClass)
   * @see reflection.ReflectionPackage#getObject_Type()
   * @see data.classes.SapClass#getInstances
   * @model opposite="instances" required="true"
   * @generated
   */
  SapClass getType();

  /**
   * Sets the value of the '{@link reflection.Object#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(SapClass value);

} // Object
