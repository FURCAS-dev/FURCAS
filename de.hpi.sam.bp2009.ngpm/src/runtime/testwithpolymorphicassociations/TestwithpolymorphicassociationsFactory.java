/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package runtime.testwithpolymorphicassociations;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see runtime.testwithpolymorphicassociations.TestwithpolymorphicassociationsPackage
 * @generated
 */
public interface TestwithpolymorphicassociationsFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TestwithpolymorphicassociationsFactory eINSTANCE = runtime.testwithpolymorphicassociations.impl.TestwithpolymorphicassociationsFactoryImpl.init();

  /**
   * Returns a new object of class '<em>A</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>A</em>'.
   * @generated
   */
  A createA();

  /**
   * Returns a new object of class '<em>C</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>C</em>'.
   * @generated
   */
  C createC();

  /**
   * Returns a new object of class '<em>B</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>B</em>'.
   * @generated
   */
  B createB();

  /**
   * Returns a new object of class '<em>D</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>D</em>'.
   * @generated
   */
  D createD();

  /**
   * Returns a new object of class '<em>E</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>E</em>'.
   * @generated
   */
  E createE();

  /**
   * Returns a new object of class '<em>F</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>F</em>'.
   * @generated
   */
  F createF();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  TestwithpolymorphicassociationsPackage getTestwithpolymorphicassociationsPackage();

} //TestwithpolymorphicassociationsFactory
