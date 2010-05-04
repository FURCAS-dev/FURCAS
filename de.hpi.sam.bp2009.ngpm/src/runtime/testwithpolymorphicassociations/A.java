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
 * A representation of the model object '<em><b>A</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link runtime.testwithpolymorphicassociations.A#getAtoB <em>Ato B</em>}</li>
 *   <li>{@link runtime.testwithpolymorphicassociations.A#getB <em>B</em>}</li>
 * </ul>
 * </p>
 *
 * @see runtime.testwithpolymorphicassociations.TestwithpolymorphicassociationsPackage#getA()
 * @model
 * @generated
 */
public interface A extends EObject
{
  /**
   * Returns the value of the '<em><b>Ato B</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ato B</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ato B</em>' attribute.
   * @see #setAtoB(String)
   * @see runtime.testwithpolymorphicassociations.TestwithpolymorphicassociationsPackage#getA_AtoB()
   * @model
   * @generated
   */
  String getAtoB();

  /**
   * Sets the value of the '{@link runtime.testwithpolymorphicassociations.A#getAtoB <em>Ato B</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ato B</em>' attribute.
   * @see #getAtoB()
   * @generated
   */
  void setAtoB(String value);

  /**
   * Returns the value of the '<em><b>B</b></em>' reference list.
   * The list contents are of type {@link runtime.testwithpolymorphicassociations.B}.
   * It is bidirectional and its opposite is '{@link runtime.testwithpolymorphicassociations.B#getA <em>A</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>B</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>B</em>' reference list.
   * @see runtime.testwithpolymorphicassociations.TestwithpolymorphicassociationsPackage#getA_B()
   * @see runtime.testwithpolymorphicassociations.B#getA
   * @model opposite="a"
   * @generated
   */
  EList<B> getB();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  void a();

} // A
