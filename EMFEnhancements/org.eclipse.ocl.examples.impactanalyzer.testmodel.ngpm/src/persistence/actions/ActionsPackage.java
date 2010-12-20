/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package persistence.actions;

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
 * @see persistence.actions.ActionsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface ActionsPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "actions";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/persistence/actions.ecore";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "persistence.actions";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	ActionsPackage eINSTANCE = persistence.actions.impl.ActionsPackageImpl.init();

	/**
     * The meta object id for the '{@link persistence.actions.impl.StatementWithEntityArgumentImpl <em>Statement With Entity Argument</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see persistence.actions.impl.StatementWithEntityArgumentImpl
     * @see persistence.actions.impl.ActionsPackageImpl#getStatementWithEntityArgument()
     * @generated
     */
	int STATEMENT_WITH_ENTITY_ARGUMENT = 2;

	/**
     * The feature id for the '<em><b>Block</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATEMENT_WITH_ENTITY_ARGUMENT__BLOCK = behavioral.actions.ActionsPackage.STATEMENT_WITH_ARGUMENT__BLOCK;

	/**
     * The feature id for the '<em><b>Argument</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATEMENT_WITH_ENTITY_ARGUMENT__ARGUMENT = behavioral.actions.ActionsPackage.STATEMENT_WITH_ARGUMENT__ARGUMENT;

	/**
     * The number of structural features of the '<em>Statement With Entity Argument</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATEMENT_WITH_ENTITY_ARGUMENT_FEATURE_COUNT = behavioral.actions.ActionsPackage.STATEMENT_WITH_ARGUMENT_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link persistence.actions.impl.StoreImpl <em>Store</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see persistence.actions.impl.StoreImpl
     * @see persistence.actions.impl.ActionsPackageImpl#getStore()
     * @generated
     */
	int STORE = 0;

	/**
     * The feature id for the '<em><b>Block</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STORE__BLOCK = STATEMENT_WITH_ENTITY_ARGUMENT__BLOCK;

	/**
     * The feature id for the '<em><b>Argument</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STORE__ARGUMENT = STATEMENT_WITH_ENTITY_ARGUMENT__ARGUMENT;

	/**
     * The number of structural features of the '<em>Store</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STORE_FEATURE_COUNT = STATEMENT_WITH_ENTITY_ARGUMENT_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link persistence.actions.impl.DeleteImpl <em>Delete</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see persistence.actions.impl.DeleteImpl
     * @see persistence.actions.impl.ActionsPackageImpl#getDelete()
     * @generated
     */
	int DELETE = 1;

	/**
     * The feature id for the '<em><b>Block</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DELETE__BLOCK = STATEMENT_WITH_ENTITY_ARGUMENT__BLOCK;

	/**
     * The feature id for the '<em><b>Argument</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DELETE__ARGUMENT = STATEMENT_WITH_ENTITY_ARGUMENT__ARGUMENT;

	/**
     * The number of structural features of the '<em>Delete</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DELETE_FEATURE_COUNT = STATEMENT_WITH_ENTITY_ARGUMENT_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link persistence.actions.impl.RollbackImpl <em>Rollback</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see persistence.actions.impl.RollbackImpl
     * @see persistence.actions.impl.ActionsPackageImpl#getRollback()
     * @generated
     */
	int ROLLBACK = 3;

	/**
     * The feature id for the '<em><b>Block</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ROLLBACK__BLOCK = behavioral.actions.ActionsPackage.STATEMENT__BLOCK;

	/**
     * The number of structural features of the '<em>Rollback</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ROLLBACK_FEATURE_COUNT = behavioral.actions.ActionsPackage.STATEMENT_FEATURE_COUNT + 0;


	/**
     * Returns the meta object for class '{@link persistence.actions.Store <em>Store</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Store</em>'.
     * @see persistence.actions.Store
     * @generated
     */
	EClass getStore();

	/**
     * Returns the meta object for class '{@link persistence.actions.Delete <em>Delete</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Delete</em>'.
     * @see persistence.actions.Delete
     * @generated
     */
	EClass getDelete();

	/**
     * Returns the meta object for class '{@link persistence.actions.StatementWithEntityArgument <em>Statement With Entity Argument</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Statement With Entity Argument</em>'.
     * @see persistence.actions.StatementWithEntityArgument
     * @generated
     */
	EClass getStatementWithEntityArgument();

	/**
     * Returns the meta object for class '{@link persistence.actions.Rollback <em>Rollback</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Rollback</em>'.
     * @see persistence.actions.Rollback
     * @generated
     */
	EClass getRollback();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	ActionsFactory getActionsFactory();

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
         * The meta object literal for the '{@link persistence.actions.impl.StoreImpl <em>Store</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see persistence.actions.impl.StoreImpl
         * @see persistence.actions.impl.ActionsPackageImpl#getStore()
         * @generated
         */
		EClass STORE = eINSTANCE.getStore();

		/**
         * The meta object literal for the '{@link persistence.actions.impl.DeleteImpl <em>Delete</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see persistence.actions.impl.DeleteImpl
         * @see persistence.actions.impl.ActionsPackageImpl#getDelete()
         * @generated
         */
		EClass DELETE = eINSTANCE.getDelete();

		/**
         * The meta object literal for the '{@link persistence.actions.impl.StatementWithEntityArgumentImpl <em>Statement With Entity Argument</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see persistence.actions.impl.StatementWithEntityArgumentImpl
         * @see persistence.actions.impl.ActionsPackageImpl#getStatementWithEntityArgument()
         * @generated
         */
		EClass STATEMENT_WITH_ENTITY_ARGUMENT = eINSTANCE.getStatementWithEntityArgument();

		/**
         * The meta object literal for the '{@link persistence.actions.impl.RollbackImpl <em>Rollback</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see persistence.actions.impl.RollbackImpl
         * @see persistence.actions.impl.ActionsPackageImpl#getRollback()
         * @generated
         */
		EClass ROLLBACK = eINSTANCE.getRollback();

	}

} //ActionsPackage
