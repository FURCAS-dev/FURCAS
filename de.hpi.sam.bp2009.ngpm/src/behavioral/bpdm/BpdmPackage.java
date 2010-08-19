/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.bpdm;

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
 * @see behavioral.bpdm.BpdmFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://de.hpi.sam.bp2009.OCL' validationDelegates='http://de.hpi.sam.bp2009.OCL'"
 * @generated
 */
public interface BpdmPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "bpdm";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http:///behavioral/bpdm.ecore";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "behavioral.bpdm";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	BpdmPackage eINSTANCE = behavioral.bpdm.impl.BpdmPackageImpl.init();

	/**
     * The meta object id for the '{@link behavioral.bpdm.impl.DummyImpl <em>Dummy</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.bpdm.impl.DummyImpl
     * @see behavioral.bpdm.impl.BpdmPackageImpl#getDummy()
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
     * Returns the meta object for class '{@link behavioral.bpdm.Dummy <em>Dummy</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Dummy</em>'.
     * @see behavioral.bpdm.Dummy
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
	BpdmFactory getBpdmFactory();

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
         * The meta object literal for the '{@link behavioral.bpdm.impl.DummyImpl <em>Dummy</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.bpdm.impl.DummyImpl
         * @see behavioral.bpdm.impl.BpdmPackageImpl#getDummy()
         * @generated
         */
		EClass DUMMY = eINSTANCE.getDummy();

	}

} //BpdmPackage
