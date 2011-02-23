/**
 * <copyright>
 * </copyright>
 *
 * $Id: TransactionsPackage.java,v 1.1 2011/02/07 17:17:58 auhl Exp $
 */
package behavioral.transactions;

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
 * Allows modelers / developers to specify transactional boundaries, tentative updates, compensation strategies etc.
 * 
 * Also, mark in the models how pieces of data-modifying functionality can share transactional scopes with other pieces. Make the distinction between shared transactions and compensation explicit.
 * <!-- end-model-doc -->
 * @see behavioral.transactions.TransactionsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface TransactionsPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "transactions";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/behavioral/transactions.ecore";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "behavioral.transactions";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	TransactionsPackage eINSTANCE = behavioral.transactions.impl.TransactionsPackageImpl.init();

	/**
     * The meta object id for the '{@link behavioral.transactions.impl.DummyImpl <em>Dummy</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.transactions.impl.DummyImpl
     * @see behavioral.transactions.impl.TransactionsPackageImpl#getDummy()
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
     * Returns the meta object for class '{@link behavioral.transactions.Dummy <em>Dummy</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Dummy</em>'.
     * @see behavioral.transactions.Dummy
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
	TransactionsFactory getTransactionsFactory();

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
         * The meta object literal for the '{@link behavioral.transactions.impl.DummyImpl <em>Dummy</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.transactions.impl.DummyImpl
         * @see behavioral.transactions.impl.TransactionsPackageImpl#getDummy()
         * @generated
         */
		EClass DUMMY = eINSTANCE.getDummy();

	}

} //TransactionsPackage
