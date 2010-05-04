/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reflection;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see reflection.ReflectionPackage
 * @generated
 */
public interface ReflectionFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ReflectionFactory eINSTANCE = reflection.impl.ReflectionFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Object</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Object</em>'.
   * @generated
   */
  Object createObject();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ReflectionPackage getReflectionPackage();

} //ReflectionFactory
