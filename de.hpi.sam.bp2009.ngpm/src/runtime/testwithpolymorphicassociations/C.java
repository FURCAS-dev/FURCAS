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
 * A representation of the model object '<em><b>C</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link runtime.testwithpolymorphicassociations.C#getCtoD <em>Cto D</em>}</li>
 *   <li>{@link runtime.testwithpolymorphicassociations.C#getAtoB <em>Ato B</em>}</li>
 *   <li>{@link runtime.testwithpolymorphicassociations.C#getB <em>B</em>}</li>
 * </ul>
 * </p>
 *
 * @see runtime.testwithpolymorphicassociations.TestwithpolymorphicassociationsPackage#getC()
 * @model
 * @generated
 */
public interface C extends EObject
{
  /**
   * Returns the value of the '<em><b>Cto D</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cto D</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cto D</em>' attribute.
   * @see #setCtoD(String)
   * @see runtime.testwithpolymorphicassociations.TestwithpolymorphicassociationsPackage#getC_CtoD()
   * @model
   * @generated
   */
  String getCtoD();

  /**
   * Sets the value of the '{@link runtime.testwithpolymorphicassociations.C#getCtoD <em>Cto D</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cto D</em>' attribute.
   * @see #getCtoD()
   * @generated
   */
  void setCtoD(String value);

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
   * @see runtime.testwithpolymorphicassociations.TestwithpolymorphicassociationsPackage#getC_AtoB()
   * @model
   * @generated
   */
  String getAtoB();

  /**
   * Sets the value of the '{@link runtime.testwithpolymorphicassociations.C#getAtoB <em>Ato B</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ato B</em>' attribute.
   * @see #getAtoB()
   * @generated
   */
  void setAtoB(String value);

  /**
   * Returns the value of the '<em><b>B</b></em>' reference list.
   * The list contents are of type {@link runtime.testwithpolymorphicassociations.D}.
   * It is bidirectional and its opposite is '{@link runtime.testwithpolymorphicassociations.D#getA <em>A</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>B</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>B</em>' reference list.
   * @see runtime.testwithpolymorphicassociations.TestwithpolymorphicassociationsPackage#getC_B()
   * @see runtime.testwithpolymorphicassociations.D#getA
   * @model opposite="a"
   * @generated
   */
  EList<D> getB();

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

} // C
