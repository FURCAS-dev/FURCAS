/**
 * <copyright>
 * </copyright>
 *
 * $Id: Data_bindingFactory.java,v 1.1 2011/02/07 16:58:52 auhl Exp $
 */
package ui.data_binding;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see ui.data_binding.Data_bindingPackage
 * @generated
 */
public interface Data_bindingFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	Data_bindingFactory eINSTANCE = ui.data_binding.impl.Data_bindingFactoryImpl.init();

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
	Data_bindingPackage getData_bindingPackage();

} //Data_bindingFactory
