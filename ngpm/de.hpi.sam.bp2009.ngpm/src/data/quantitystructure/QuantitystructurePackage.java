/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.quantitystructure;

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
 * <!-- begin-model-doc -->
 * Helps modelers to specify the numbers of instances of types, relations and the access patterns over them. This can later be used to optimize data representation, partitioning and deployment.
 * <!-- end-model-doc -->
 * @see data.quantitystructure.QuantitystructureFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://de.hpi.sam.bp2009.OCL' validationDelegates='http://de.hpi.sam.bp2009.OCL'"
 * @generated
 */
public interface QuantitystructurePackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "quantitystructure";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http:///data/quantitystructure.ecore";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "data.quantitystructure";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	QuantitystructurePackage eINSTANCE = data.quantitystructure.impl.QuantitystructurePackageImpl.init();

	/**
     * The meta object id for the '{@link data.quantitystructure.impl.DummyImpl <em>Dummy</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.quantitystructure.impl.DummyImpl
     * @see data.quantitystructure.impl.QuantitystructurePackageImpl#getDummy()
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
     * Returns the meta object for class '{@link data.quantitystructure.Dummy <em>Dummy</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Dummy</em>'.
     * @see data.quantitystructure.Dummy
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
	QuantitystructureFactory getQuantitystructureFactory();

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
         * The meta object literal for the '{@link data.quantitystructure.impl.DummyImpl <em>Dummy</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.quantitystructure.impl.DummyImpl
         * @see data.quantitystructure.impl.QuantitystructurePackageImpl#getDummy()
         * @generated
         */
		EClass DUMMY = eINSTANCE.getDummy();

	}

} //QuantitystructurePackage
