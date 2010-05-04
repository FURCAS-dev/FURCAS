/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reflection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * <!-- begin-model-doc -->
 * Allows for instantiating classes of the metamodel in the application. In other words, Class is an instance of type Class, Block is a Class, there can be expressions of type Class and of type Block etc.
 * 
 * Similarly, for Operation, an operation object can be instantiated. Ideally, there should be literals that can be used to identify operation objects in the program syntax (maybe special syntax for the operation currently executing). An operation invocation expression can then be constructed at runtime, only that still the constraints for the type safety must be met.
 * 
 * This may mean that an operation invocation expression can be written as calling an operation with a specific kind of signature, and the actual operation's signature then must match that signature.
 * <!-- end-model-doc -->
 * @see reflection.ReflectionFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://de.hpi.sam.bp2009.OCL' validationDelegates='http://de.hpi.sam.bp2009.OCL'"
 * @generated
 */
public interface ReflectionPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "reflection";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http:///reflection.ecore";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "reflection";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ReflectionPackage eINSTANCE = reflection.impl.ReflectionPackageImpl.init();

  /**
   * The meta object id for the '{@link reflection.impl.ObjectImpl <em>Object</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reflection.impl.ObjectImpl
   * @see reflection.impl.ReflectionPackageImpl#getObject()
   * @generated
   */
  int OBJECT = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT__TYPE = 0;

  /**
   * The number of structural features of the '<em>Object</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link reflection.Object <em>Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Object</em>'.
   * @see reflection.Object
   * @generated
   */
  EClass getObject();

  /**
   * Returns the meta object for the reference '{@link reflection.Object#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see reflection.Object#getType()
   * @see #getObject()
   * @generated
   */
  EReference getObject_Type();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ReflectionFactory getReflectionFactory();

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
     * The meta object literal for the '{@link reflection.impl.ObjectImpl <em>Object</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reflection.impl.ObjectImpl
     * @see reflection.impl.ReflectionPackageImpl#getObject()
     * @generated
     */
    EClass OBJECT = eINSTANCE.getObject();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OBJECT__TYPE = eINSTANCE.getObject_Type();

  }

} //ReflectionPackage
