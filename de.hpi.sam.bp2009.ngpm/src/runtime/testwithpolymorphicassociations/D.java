/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package runtime.testwithpolymorphicassociations;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>D</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link runtime.testwithpolymorphicassociations.D#getA <em>A</em>}</li>
 * </ul>
 * </p>
 *
 * @see runtime.testwithpolymorphicassociations.TestwithpolymorphicassociationsPackage#getD()
 * @model
 * @generated
 */
public interface D extends EObject
{
  /**
   * Returns the value of the '<em><b>A</b></em>' reference list.
   * The list contents are of type {@link runtime.testwithpolymorphicassociations.C}.
   * It is bidirectional and its opposite is '{@link runtime.testwithpolymorphicassociations.C#getB <em>B</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>A</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>A</em>' reference list.
   * @see runtime.testwithpolymorphicassociations.TestwithpolymorphicassociationsPackage#getD_A()
   * @see runtime.testwithpolymorphicassociations.C#getB
   * @model opposite="b"
   * @generated
   */
  EList<C> getA();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  void b();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  void d();

} // D
