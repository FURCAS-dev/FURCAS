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
 * A representation of the model object '<em><b>E</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link runtime.testwithpolymorphicassociations.E#getEtoF <em>Eto F</em>}</li>
 *   <li>{@link runtime.testwithpolymorphicassociations.E#getB <em>B</em>}</li>
 * </ul>
 * </p>
 *
 * @see runtime.testwithpolymorphicassociations.TestwithpolymorphicassociationsPackage#getE()
 * @model
 * @generated
 */
public interface E extends EObject
{
  /**
   * Returns the value of the '<em><b>Eto F</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Eto F</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Eto F</em>' attribute.
   * @see #setEtoF(String)
   * @see runtime.testwithpolymorphicassociations.TestwithpolymorphicassociationsPackage#getE_EtoF()
   * @model
   * @generated
   */
  String getEtoF();

  /**
   * Sets the value of the '{@link runtime.testwithpolymorphicassociations.E#getEtoF <em>Eto F</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Eto F</em>' attribute.
   * @see #getEtoF()
   * @generated
   */
  void setEtoF(String value);

  /**
   * Returns the value of the '<em><b>B</b></em>' reference list.
   * The list contents are of type {@link runtime.testwithpolymorphicassociations.F}.
   * It is bidirectional and its opposite is '{@link runtime.testwithpolymorphicassociations.F#getA <em>A</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>B</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>B</em>' reference list.
   * @see runtime.testwithpolymorphicassociations.TestwithpolymorphicassociationsPackage#getE_B()
   * @see runtime.testwithpolymorphicassociations.F#getA
   * @model opposite="a"
   * @generated
   */
  EList<F> getB();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  void a();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  void c();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  void e();

} // E
