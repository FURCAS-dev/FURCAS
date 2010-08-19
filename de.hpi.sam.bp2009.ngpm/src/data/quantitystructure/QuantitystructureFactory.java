/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.quantitystructure;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see data.quantitystructure.QuantitystructurePackage
 * @generated
 */
public interface QuantitystructureFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	QuantitystructureFactory eINSTANCE = data.quantitystructure.impl.QuantitystructureFactoryImpl.init();

	/**
     * Returns a new object of class '<em>Dummy</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Dummy</em>'.
     * @generated
     */
	Dummy createDummy();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	QuantitystructurePackage getQuantitystructurePackage();

} //QuantitystructureFactory
