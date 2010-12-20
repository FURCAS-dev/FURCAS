/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ui.data_binding;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see ui.data_binding.Data_bindingFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface Data_bindingPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "data_binding";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/ui/data_binding.ecore";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "ui.data_binding";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	Data_bindingPackage eINSTANCE = ui.data_binding.impl.Data_bindingPackageImpl.init();

	/**
     * The meta object id for the '{@link ui.data_binding.impl.DummyImpl <em>Dummy</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see ui.data_binding.impl.DummyImpl
     * @see ui.data_binding.impl.Data_bindingPackageImpl#getDummy()
     * @generated
     */
	int DUMMY = 0;

	/**
     * The number of structural features of the '<em>Dummy</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DUMMY_FEATURE_COUNT = 0;


	/**
     * Returns the meta object for class '{@link ui.data_binding.Dummy <em>Dummy</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Dummy</em>'.
     * @see ui.data_binding.Dummy
     * @generated
     */
	EClass getDummy();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	Data_bindingFactory getData_bindingFactory();

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
	interface Literals {
		/**
         * The meta object literal for the '{@link ui.data_binding.impl.DummyImpl <em>Dummy</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see ui.data_binding.impl.DummyImpl
         * @see ui.data_binding.impl.Data_bindingPackageImpl#getDummy()
         * @generated
         */
		EClass DUMMY = eINSTANCE.getDummy();

	}

} //Data_bindingPackage
