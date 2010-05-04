/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package runtime.primitivetypes;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see runtime.primitivetypes.PrimitivetypesPackage
 * @generated
 */
public interface PrimitivetypesFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  PrimitivetypesFactory eINSTANCE = runtime.primitivetypes.impl.PrimitivetypesFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Binary</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Binary</em>'.
   * @generated
   */
  Binary createBinary();

  /**
   * Returns a new object of class '<em>Boolean</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Boolean</em>'.
   * @generated
   */
  Boolean createBoolean();

  /**
   * Returns a new object of class '<em>Date Time</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Date Time</em>'.
   * @generated
   */
  DateTime createDateTime();

  /**
   * Returns a new object of class '<em>Number</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Number</em>'.
   * @generated
   */
  Number createNumber();

  /**
   * Returns a new object of class '<em>String</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>String</em>'.
   * @generated
   */
  String createString();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  PrimitivetypesPackage getPrimitivetypesPackage();

} //PrimitivetypesFactory
