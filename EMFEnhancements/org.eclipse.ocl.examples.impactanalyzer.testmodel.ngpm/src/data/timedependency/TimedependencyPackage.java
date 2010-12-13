/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.timedependency;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * Models the aspect of time-dependent data. If a structural feature such as a class or a property or an association is marked as time-dependent, clients expect to find time-dependent access operations for read access. If no time is specified, the time of access is implicitly assumed.
 * 
 * Modifications to such structures keep the history of the data. Again, if no modification time is explicitly specified, the time at which the modification occurs is used implicitly.
 * 
 * Clarify if it should be possible to "modify history." In other words, should it be possible to make structural changes in data that was already recorded in the past?
 * 
 * TODO Perhaps this package should be separated out into an own top-level metamodel package because it has dependencies on behavioral/actions and dataaccess/expressions.
 * <!-- end-model-doc -->
 * @see data.timedependency.TimedependencyFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface TimedependencyPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "timedependency";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http:///data/timedependency.ecore";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "data.timedependency";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	TimedependencyPackage eINSTANCE = data.timedependency.impl.TimedependencyPackageImpl.init();

	/**
     * The meta object id for the '{@link data.timedependency.impl.TimeDependencyImpl <em>Time Dependency</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.timedependency.impl.TimeDependencyImpl
     * @see data.timedependency.impl.TimedependencyPackageImpl#getTimeDependency()
     * @generated
     */
	int TIME_DEPENDENCY = 0;

	/**
     * The feature id for the '<em><b>Record Cutoff In Milliseconds</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TIME_DEPENDENCY__RECORD_CUTOFF_IN_MILLISECONDS = 0;

	/**
     * The feature id for the '<em><b>Can Change Past</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TIME_DEPENDENCY__CAN_CHANGE_PAST = 1;

	/**
     * The feature id for the '<em><b>Timespan</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TIME_DEPENDENCY__TIMESPAN = 2;

	/**
     * The feature id for the '<em><b>The Class</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TIME_DEPENDENCY__THE_CLASS = 3;

	/**
     * The feature id for the '<em><b>Association</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TIME_DEPENDENCY__ASSOCIATION = 4;

	/**
     * The number of structural features of the '<em>Time Dependency</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TIME_DEPENDENCY_FEATURE_COUNT = 5;


	/**
     * Returns the meta object for class '{@link data.timedependency.TimeDependency <em>Time Dependency</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Time Dependency</em>'.
     * @see data.timedependency.TimeDependency
     * @generated
     */
	EClass getTimeDependency();

	/**
     * Returns the meta object for the attribute '{@link data.timedependency.TimeDependency#getRecordCutoffInMilliseconds <em>Record Cutoff In Milliseconds</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Record Cutoff In Milliseconds</em>'.
     * @see data.timedependency.TimeDependency#getRecordCutoffInMilliseconds()
     * @see #getTimeDependency()
     * @generated
     */
	EAttribute getTimeDependency_RecordCutoffInMilliseconds();

	/**
     * Returns the meta object for the attribute '{@link data.timedependency.TimeDependency#isCanChangePast <em>Can Change Past</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Can Change Past</em>'.
     * @see data.timedependency.TimeDependency#isCanChangePast()
     * @see #getTimeDependency()
     * @generated
     */
	EAttribute getTimeDependency_CanChangePast();

	/**
     * Returns the meta object for the attribute '{@link data.timedependency.TimeDependency#isTimespan <em>Timespan</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Timespan</em>'.
     * @see data.timedependency.TimeDependency#isTimespan()
     * @see #getTimeDependency()
     * @generated
     */
	EAttribute getTimeDependency_Timespan();

	/**
     * Returns the meta object for the container reference '{@link data.timedependency.TimeDependency#getTheClass <em>The Class</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>The Class</em>'.
     * @see data.timedependency.TimeDependency#getTheClass()
     * @see #getTimeDependency()
     * @generated
     */
	EReference getTimeDependency_TheClass();

	/**
     * Returns the meta object for the container reference '{@link data.timedependency.TimeDependency#getAssociation <em>Association</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Association</em>'.
     * @see data.timedependency.TimeDependency#getAssociation()
     * @see #getTimeDependency()
     * @generated
     */
	EReference getTimeDependency_Association();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	TimedependencyFactory getTimedependencyFactory();

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
         * The meta object literal for the '{@link data.timedependency.impl.TimeDependencyImpl <em>Time Dependency</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.timedependency.impl.TimeDependencyImpl
         * @see data.timedependency.impl.TimedependencyPackageImpl#getTimeDependency()
         * @generated
         */
		EClass TIME_DEPENDENCY = eINSTANCE.getTimeDependency();

		/**
         * The meta object literal for the '<em><b>Record Cutoff In Milliseconds</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute TIME_DEPENDENCY__RECORD_CUTOFF_IN_MILLISECONDS = eINSTANCE.getTimeDependency_RecordCutoffInMilliseconds();

		/**
         * The meta object literal for the '<em><b>Can Change Past</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute TIME_DEPENDENCY__CAN_CHANGE_PAST = eINSTANCE.getTimeDependency_CanChangePast();

		/**
         * The meta object literal for the '<em><b>Timespan</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute TIME_DEPENDENCY__TIMESPAN = eINSTANCE.getTimeDependency_Timespan();

		/**
         * The meta object literal for the '<em><b>The Class</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference TIME_DEPENDENCY__THE_CLASS = eINSTANCE.getTimeDependency_TheClass();

		/**
         * The meta object literal for the '<em><b>Association</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference TIME_DEPENDENCY__ASSOCIATION = eINSTANCE.getTimeDependency_Association();

	}

} //TimedependencyPackage
