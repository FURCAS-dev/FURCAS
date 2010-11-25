/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mydsl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see mydsl.MydslFactory
 * @model kind="package"
 * @generated
 */
public interface MydslPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "mydsl";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.mydsl.com/metamodel/";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "mydsl";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MydslPackage eINSTANCE = mydsl.impl.MydslPackageImpl.init();

  /**
   * The meta object id for the '{@link mydsl.impl.ExampleClassImpl <em>Example Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see mydsl.impl.ExampleClassImpl
   * @see mydsl.impl.MydslPackageImpl#getExampleClass()
   * @generated
   */
  int EXAMPLE_CLASS = 0;

  /**
   * The number of structural features of the '<em>Example Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXAMPLE_CLASS_FEATURE_COUNT = 0;


  /**
   * Returns the meta object for class '{@link mydsl.ExampleClass <em>Example Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Example Class</em>'.
   * @see mydsl.ExampleClass
   * @generated
   */
  EClass getExampleClass();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  MydslFactory getMydslFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link mydsl.impl.ExampleClassImpl <em>Example Class</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see mydsl.impl.ExampleClassImpl
     * @see mydsl.impl.MydslPackageImpl#getExampleClass()
     * @generated
     */
    EClass EXAMPLE_CLASS = eINSTANCE.getExampleClass();

  }

} //MydslPackage
