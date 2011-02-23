/**
 * <copyright>
 * </copyright>
 *
 * $Id: BusinesstasksPackage.java,v 1.1 2011/02/07 17:17:57 auhl Exp $
 */
package behavioral.businesstasks;

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
 * If it turns out to be beneficial, elements in this package cover the creation and management of BTM-related objects, such as creating a business task, assigning it to specific users or roles, etc.
 * <!-- end-model-doc -->
 * @see behavioral.businesstasks.BusinesstasksFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface BusinesstasksPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "businesstasks";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/behavioral/businesstasks.ecore";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "behavioral.businesstasks";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	BusinesstasksPackage eINSTANCE = behavioral.businesstasks.impl.BusinesstasksPackageImpl.init();

	/**
     * The meta object id for the '{@link behavioral.businesstasks.impl.TaskAgentImpl <em>Task Agent</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.businesstasks.impl.TaskAgentImpl
     * @see behavioral.businesstasks.impl.BusinesstasksPackageImpl#getTaskAgent()
     * @generated
     */
	int TASK_AGENT = 0;

	/**
     * The number of structural features of the '<em>Task Agent</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TASK_AGENT_FEATURE_COUNT = 0;


	/**
     * Returns the meta object for class '{@link behavioral.businesstasks.TaskAgent <em>Task Agent</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Task Agent</em>'.
     * @see behavioral.businesstasks.TaskAgent
     * @generated
     */
	EClass getTaskAgent();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	BusinesstasksFactory getBusinesstasksFactory();

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
         * The meta object literal for the '{@link behavioral.businesstasks.impl.TaskAgentImpl <em>Task Agent</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.businesstasks.impl.TaskAgentImpl
         * @see behavioral.businesstasks.impl.BusinesstasksPackageImpl#getTaskAgent()
         * @generated
         */
		EClass TASK_AGENT = eINSTANCE.getTaskAgent();

	}

} //BusinesstasksPackage
