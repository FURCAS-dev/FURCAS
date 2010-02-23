/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.eventCounter;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterFactory
 * @model kind="package"
 * @generated
 */
public interface EventCounterPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "eventCounter";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://de.hpi.sam.bp2009.benchframework.eventCounter";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "benchframework.eventCounter";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EventCounterPackage eINSTANCE = de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterStartImpl <em>Start</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterStartImpl
	 * @see de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterPackageImpl#getEventCounterStart()
	 * @generated
	 */
	int EVENT_COUNTER_START = 0;

	/**
	 * The feature id for the '<em><b>Option</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COUNTER_START__OPTION = BenchframeworkPackage.OPERATOR__OPTION;

	/**
	 * The feature id for the '<em><b>Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COUNTER_START__RESULT = BenchframeworkPackage.OPERATOR__RESULT;

	/**
	 * The feature id for the '<em><b>Test Run</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COUNTER_START__TEST_RUN = BenchframeworkPackage.OPERATOR__TEST_RUN;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COUNTER_START__NAME = BenchframeworkPackage.OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COUNTER_START__DESCRIPTION = BenchframeworkPackage.OPERATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>End Point</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COUNTER_START__END_POINT = BenchframeworkPackage.OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COUNTER_START__COUNT = BenchframeworkPackage.OPERATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Adapter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COUNTER_START__ADAPTER = BenchframeworkPackage.OPERATOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Start</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COUNTER_START_FEATURE_COUNT = BenchframeworkPackage.OPERATOR_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterEndImpl <em>End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterEndImpl
	 * @see de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterPackageImpl#getEventCounterEnd()
	 * @generated
	 */
	int EVENT_COUNTER_END = 1;

	/**
	 * The feature id for the '<em><b>Option</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COUNTER_END__OPTION = BenchframeworkPackage.OPERATOR__OPTION;

	/**
	 * The feature id for the '<em><b>Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COUNTER_END__RESULT = BenchframeworkPackage.OPERATOR__RESULT;

	/**
	 * The feature id for the '<em><b>Test Run</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COUNTER_END__TEST_RUN = BenchframeworkPackage.OPERATOR__TEST_RUN;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COUNTER_END__NAME = BenchframeworkPackage.OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COUNTER_END__DESCRIPTION = BenchframeworkPackage.OPERATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Start Point</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COUNTER_END__START_POINT = BenchframeworkPackage.OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COUNTER_END_FEATURE_COUNT = BenchframeworkPackage.OPERATOR_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '<em>Adapter</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.notify.Adapter
	 * @see de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterPackageImpl#getAdapter()
	 * @generated
	 */
	int ADAPTER = 2;


	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Start</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterStart
	 * @generated
	 */
	EClass getEventCounterStart();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterStart#getEndPoint <em>End Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>End Point</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterStart#getEndPoint()
	 * @see #getEventCounterStart()
	 * @generated
	 */
	EReference getEventCounterStart_EndPoint();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterStart#getCount <em>Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Count</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterStart#getCount()
	 * @see #getEventCounterStart()
	 * @generated
	 */
	EAttribute getEventCounterStart_Count();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterStart#getAdapter <em>Adapter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Adapter</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterStart#getAdapter()
	 * @see #getEventCounterStart()
	 * @generated
	 */
	EAttribute getEventCounterStart_Adapter();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>End</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterEnd
	 * @generated
	 */
	EClass getEventCounterEnd();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterEnd#getStartPoint <em>Start Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Start Point</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterEnd#getStartPoint()
	 * @see #getEventCounterEnd()
	 * @generated
	 */
	EReference getEventCounterEnd_StartPoint();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.common.notify.Adapter <em>Adapter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Adapter</em>'.
	 * @see org.eclipse.emf.common.notify.Adapter
	 * @model instanceClass="org.eclipse.emf.common.notify.Adapter"
	 * @generated
	 */
	EDataType getAdapter();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EventCounterFactory getEventCounterFactory();

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
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterStartImpl <em>Start</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterStartImpl
		 * @see de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterPackageImpl#getEventCounterStart()
		 * @generated
		 */
		EClass EVENT_COUNTER_START = eINSTANCE.getEventCounterStart();

		/**
		 * The meta object literal for the '<em><b>End Point</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_COUNTER_START__END_POINT = eINSTANCE.getEventCounterStart_EndPoint();

		/**
		 * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_COUNTER_START__COUNT = eINSTANCE.getEventCounterStart_Count();

		/**
		 * The meta object literal for the '<em><b>Adapter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_COUNTER_START__ADAPTER = eINSTANCE.getEventCounterStart_Adapter();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterEndImpl <em>End</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterEndImpl
		 * @see de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterPackageImpl#getEventCounterEnd()
		 * @generated
		 */
		EClass EVENT_COUNTER_END = eINSTANCE.getEventCounterEnd();

		/**
		 * The meta object literal for the '<em><b>Start Point</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_COUNTER_END__START_POINT = eINSTANCE.getEventCounterEnd_StartPoint();

		/**
		 * The meta object literal for the '<em>Adapter</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.notify.Adapter
		 * @see de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterPackageImpl#getAdapter()
		 * @generated
		 */
		EDataType ADAPTER = eINSTANCE.getAdapter();

	}

} //EventCounterPackage
