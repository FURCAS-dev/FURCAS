/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Mydsl;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see Mydsl.MydslPackage
 * @generated
 */
public interface MydslFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    MydslFactory eINSTANCE = Mydsl.impl.MydslFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Example Class</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Example Class</em>'.
     * @generated
     */
    ExampleClass createExampleClass();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    MydslPackage getMydslPackage();

} //MydslFactory
