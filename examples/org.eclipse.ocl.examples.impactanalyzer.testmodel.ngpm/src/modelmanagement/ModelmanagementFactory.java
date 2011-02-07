/**
 * <copyright>
 * </copyright>
 *
 * $Id: ModelmanagementFactory.java,v 1.1 2011/02/07 16:43:31 auhl Exp $
 */
package modelmanagement;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see modelmanagement.ModelmanagementPackage
 * @generated
 */
public interface ModelmanagementFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	ModelmanagementFactory eINSTANCE = modelmanagement.impl.ModelmanagementFactoryImpl.init();

	/**
     * Returns a new object of class '<em>Package</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Package</em>'.
     * @generated
     */
	Package createPackage();

	/**
     * Returns a new object of class '<em>Application</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Application</em>'.
     * @generated
     */
	Application createApplication();

	/**
     * Returns a new object of class '<em>Package Owner</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Package Owner</em>'.
     * @generated
     */
	PackageOwner createPackageOwner();

	/**
     * Returns a new object of class '<em>Module</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Module</em>'.
     * @generated
     */
	Module createModule();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	ModelmanagementPackage getModelmanagementPackage();

} //ModelmanagementFactory
