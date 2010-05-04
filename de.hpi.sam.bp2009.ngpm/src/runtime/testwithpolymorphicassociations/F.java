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
 * A representation of the model object '<em><b>F</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link runtime.testwithpolymorphicassociations.F#getA <em>A</em>}</li>
 * </ul>
 * </p>
 *
 * @see runtime.testwithpolymorphicassociations.TestwithpolymorphicassociationsPackage#getF()
 * @model
 * @generated
 */
public interface F extends EObject
{
  /**
   * Returns the value of the '<em><b>A</b></em>' reference list.
   * The list contents are of type {@link runtime.testwithpolymorphicassociations.E}.
   * It is bidirectional and its opposite is '{@link runtime.testwithpolymorphicassociations.E#getB <em>B</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>A</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>A</em>' reference list.
   * @see runtime.testwithpolymorphicassociations.TestwithpolymorphicassociationsPackage#getF_A()
   * @see runtime.testwithpolymorphicassociations.E#getB
   * @model opposite="b"
   * @generated
   */
  EList<E> getA();

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

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  void f();

} // F
