/**
 * <copyright>
 * </copyright>
 *
 * $Id: BusinessconfigurationFactory.java,v 1.1 2011/02/07 16:43:31 auhl Exp $
 */
package configuration.businessconfiguration;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see configuration.businessconfiguration.BusinessconfigurationPackage
 * @generated
 */
public interface BusinessconfigurationFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	BusinessconfigurationFactory eINSTANCE = configuration.businessconfiguration.impl.BusinessconfigurationFactoryImpl.init();

	/**
     * Returns a new object of class '<em>Scoping Context</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Scoping Context</em>'.
     * @generated
     */
	ScopingContext createScopingContext();

	/**
     * Returns a new object of class '<em>Industry</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Industry</em>'.
     * @generated
     */
	Industry createIndustry();

	/**
     * Returns a new object of class '<em>Country</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Country</em>'.
     * @generated
     */
	Country createCountry();

	/**
     * Returns a new object of class '<em>Configuration Element</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Configuration Element</em>'.
     * @generated
     */
	ConfigurationElement createConfigurationElement();

	/**
     * Returns a new object of class '<em>Business Topic</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Business Topic</em>'.
     * @generated
     */
	BusinessTopic createBusinessTopic();

	/**
     * Returns a new object of class '<em>Business Package</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Business Package</em>'.
     * @generated
     */
	BusinessPackage createBusinessPackage();

	/**
     * Returns a new object of class '<em>Business Option</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Business Option</em>'.
     * @generated
     */
	BusinessOption createBusinessOption();

	/**
     * Returns a new object of class '<em>Business Area</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Business Area</em>'.
     * @generated
     */
	BusinessArea createBusinessArea();

	/**
     * Returns a new object of class '<em>Value Set</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Value Set</em>'.
     * @generated
     */
	ValueSet createValueSet();

	/**
     * Returns a new object of class '<em>Value Set Entry</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Value Set Entry</em>'.
     * @generated
     */
	ValueSetEntry createValueSetEntry();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	BusinessconfigurationPackage getBusinessconfigurationPackage();

} //BusinessconfigurationFactory
