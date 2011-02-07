/**
 * <copyright>
 * </copyright>
 *
 * $Id: BindingFactory.java,v 1.1 2011/02/07 16:57:59 auhl Exp $
 */
package integration.binding;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see integration.binding.BindingPackage
 * @generated
 */
public interface BindingFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	BindingFactory eINSTANCE = integration.binding.impl.BindingFactoryImpl.init();

	/**
     * Returns a new object of class '<em>Http Get Binding</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Http Get Binding</em>'.
     * @generated
     */
	HttpGetBinding createHttpGetBinding();

	/**
     * Returns a new object of class '<em>Http Put Binding</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Http Put Binding</em>'.
     * @generated
     */
	HttpPutBinding createHttpPutBinding();

	/**
     * Returns a new object of class '<em>Simple Url Pattern</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Simple Url Pattern</em>'.
     * @generated
     */
	SimpleUrlPattern createSimpleUrlPattern();

	/**
     * Returns a new object of class '<em>Rest Url Pattern</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Rest Url Pattern</em>'.
     * @generated
     */
	RestUrlPattern createRestUrlPattern();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	BindingPackage getBindingPackage();

} //BindingFactory
