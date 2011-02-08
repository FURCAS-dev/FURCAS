/**
 * <copyright>
 * </copyright>
 *
 * $Id: Context_driversFactory.java,v 1.1 2011/02/07 17:18:47 auhl Exp $
 */
package configuration.context_drivers;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see configuration.context_drivers.Context_driversPackage
 * @generated
 */
public interface Context_driversFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	Context_driversFactory eINSTANCE = configuration.context_drivers.impl.Context_driversFactoryImpl.init();

	/**
     * Returns a new object of class '<em>Context Category</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Context Category</em>'.
     * @generated
     */
	ContextCategory createContextCategory();

	/**
     * Returns a new object of class '<em>Context Category Value</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Context Category Value</em>'.
     * @generated
     */
	ContextCategoryValue createContextCategoryValue();

	/**
     * Returns a new object of class '<em>Contextual Element</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Contextual Element</em>'.
     * @generated
     */
	ContextualElement createContextualElement();

	/**
     * Returns a new object of class '<em>Contex Configuration</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Contex Configuration</em>'.
     * @generated
     */
	ContexConfiguration createContexConfiguration();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	Context_driversPackage getContext_driversPackage();

} //Context_driversFactory
