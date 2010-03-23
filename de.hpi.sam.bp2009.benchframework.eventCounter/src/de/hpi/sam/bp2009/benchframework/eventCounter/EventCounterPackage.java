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
	 * The feature id for the '<em><b>Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COUNTER_START__OPTION = BenchframeworkPackage.START_OPERATOR__OPTION;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COUNTER_START__RESULT = BenchframeworkPackage.START_OPERATOR__RESULT;

	/**
	 * The feature id for the '<em><b>Test Run</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COUNTER_START__TEST_RUN = BenchframeworkPackage.START_OPERATOR__TEST_RUN;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COUNTER_START__NAME = BenchframeworkPackage.START_OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COUNTER_START__DESCRIPTION = BenchframeworkPackage.START_OPERATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>End Operator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COUNTER_START__END_OPERATOR = BenchframeworkPackage.START_OPERATOR__END_OPERATOR;

	/**
	 * The feature id for the '<em><b>Adapter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COUNTER_START__ADAPTER = BenchframeworkPackage.START_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Start</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COUNTER_START_FEATURE_COUNT = BenchframeworkPackage.START_OPERATOR_FEATURE_COUNT + 1;

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
	 * The feature id for the '<em><b>Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COUNTER_END__OPTION = BenchframeworkPackage.END_OPERATOR__OPTION;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COUNTER_END__RESULT = BenchframeworkPackage.END_OPERATOR__RESULT;

	/**
	 * The feature id for the '<em><b>Test Run</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COUNTER_END__TEST_RUN = BenchframeworkPackage.END_OPERATOR__TEST_RUN;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COUNTER_END__NAME = BenchframeworkPackage.END_OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COUNTER_END__DESCRIPTION = BenchframeworkPackage.END_OPERATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Start Operator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COUNTER_END__START_OPERATOR = BenchframeworkPackage.END_OPERATOR__START_OPERATOR;

	/**
	 * The number of structural features of the '<em>End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COUNTER_END_FEATURE_COUNT = BenchframeworkPackage.END_OPERATOR_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterOptionObjectImpl <em>Option Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterOptionObjectImpl
	 * @see de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterPackageImpl#getEventCounterOptionObject()
	 * @generated
	 */
	int EVENT_COUNTER_OPTION_OBJECT = 2;

	/**
	 * The number of structural features of the '<em>Option Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COUNTER_OPTION_OBJECT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterResultObjectImpl <em>Result Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterResultObjectImpl
	 * @see de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterPackageImpl#getEventCounterResultObject()
	 * @generated
	 */
	int EVENT_COUNTER_RESULT_OBJECT = 3;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COUNTER_RESULT_OBJECT__STATUS = BenchframeworkPackage.RESULT_OBJECT__STATUS;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COUNTER_RESULT_OBJECT__MESSAGE = BenchframeworkPackage.RESULT_OBJECT__MESSAGE;

	/**
	 * The feature id for the '<em><b>Event Counts</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COUNTER_RESULT_OBJECT__EVENT_COUNTS = BenchframeworkPackage.RESULT_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Result Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COUNTER_RESULT_OBJECT_FEATURE_COUNT = BenchframeworkPackage.RESULT_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.eventCounter.impl.EStringToEIntegerMapImpl <em>EString To EInteger Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.eventCounter.impl.EStringToEIntegerMapImpl
	 * @see de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterPackageImpl#getEStringToEIntegerMap()
	 * @generated
	 */
	int ESTRING_TO_EINTEGER_MAP = 4;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_EINTEGER_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_EINTEGER_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>EString To EInteger Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_EINTEGER_MAP_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '<em>Adapter</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.notify.Adapter
	 * @see de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterPackageImpl#getAdapter()
	 * @generated
	 */
	int ADAPTER = 5;


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
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterOptionObject <em>Option Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Option Object</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterOptionObject
	 * @generated
	 */
	EClass getEventCounterOptionObject();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterResultObject <em>Result Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Result Object</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterResultObject
	 * @generated
	 */
	EClass getEventCounterResultObject();

	/**
	 * Returns the meta object for the map '{@link de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterResultObject#getEventCounts <em>Event Counts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Event Counts</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterResultObject#getEventCounts()
	 * @see #getEventCounterResultObject()
	 * @generated
	 */
	EReference getEventCounterResultObject_EventCounts();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>EString To EInteger Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EString To EInteger Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueDataType="org.eclipse.emf.ecore.EIntegerObject"
	 * @generated
	 */
	EClass getEStringToEIntegerMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToEIntegerMap()
	 * @generated
	 */
	EAttribute getEStringToEIntegerMap_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToEIntegerMap()
	 * @generated
	 */
	EAttribute getEStringToEIntegerMap_Value();

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
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterOptionObjectImpl <em>Option Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterOptionObjectImpl
		 * @see de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterPackageImpl#getEventCounterOptionObject()
		 * @generated
		 */
		EClass EVENT_COUNTER_OPTION_OBJECT = eINSTANCE.getEventCounterOptionObject();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterResultObjectImpl <em>Result Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterResultObjectImpl
		 * @see de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterPackageImpl#getEventCounterResultObject()
		 * @generated
		 */
		EClass EVENT_COUNTER_RESULT_OBJECT = eINSTANCE.getEventCounterResultObject();

		/**
		 * The meta object literal for the '<em><b>Event Counts</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_COUNTER_RESULT_OBJECT__EVENT_COUNTS = eINSTANCE.getEventCounterResultObject_EventCounts();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.eventCounter.impl.EStringToEIntegerMapImpl <em>EString To EInteger Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.eventCounter.impl.EStringToEIntegerMapImpl
		 * @see de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterPackageImpl#getEStringToEIntegerMap()
		 * @generated
		 */
		EClass ESTRING_TO_EINTEGER_MAP = eINSTANCE.getEStringToEIntegerMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESTRING_TO_EINTEGER_MAP__KEY = eINSTANCE.getEStringToEIntegerMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESTRING_TO_EINTEGER_MAP__VALUE = eINSTANCE.getEStringToEIntegerMap_Value();

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
