/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.eventCounter.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterEnd;
import de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterFactory;
import de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterOptionObject;
import de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterPackage;
import de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterResultObject;
import de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterStart;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EventCounterFactoryImpl extends EFactoryImpl implements EventCounterFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EventCounterFactory init() {
		try {
			EventCounterFactory theEventCounterFactory = (EventCounterFactory)EPackage.Registry.INSTANCE.getEFactory("http://de.hpi.sam.bp2009.benchframework.eventCounter"); 
			if (theEventCounterFactory != null) {
				return theEventCounterFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EventCounterFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventCounterFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EventCounterPackage.EVENT_COUNTER_START: return createEventCounterStart();
			case EventCounterPackage.EVENT_COUNTER_END: return createEventCounterEnd();
			case EventCounterPackage.EVENT_COUNTER_OPTION_OBJECT: return createEventCounterOptionObject();
			case EventCounterPackage.EVENT_COUNTER_RESULT_OBJECT: return createEventCounterResultObject();
			case EventCounterPackage.ESTRING_TO_EINTEGER_MAP: return (EObject)createEStringToEIntegerMap();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventCounterStart createEventCounterStart() {
		EventCounterStartImpl eventCounterStart = new EventCounterStartImpl();
		return eventCounterStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventCounterEnd createEventCounterEnd() {
		EventCounterEndImpl eventCounterEnd = new EventCounterEndImpl();
		return eventCounterEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventCounterOptionObject createEventCounterOptionObject() {
		EventCounterOptionObjectImpl eventCounterOptionObject = new EventCounterOptionObjectImpl();
		return eventCounterOptionObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventCounterResultObject createEventCounterResultObject() {
		EventCounterResultObjectImpl eventCounterResultObject = new EventCounterResultObjectImpl();
		return eventCounterResultObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, Integer> createEStringToEIntegerMap() {
		EStringToEIntegerMapImpl eStringToEIntegerMap = new EStringToEIntegerMapImpl();
		return eStringToEIntegerMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventCounterPackage getEventCounterPackage() {
		return (EventCounterPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EventCounterPackage getPackage() {
		return EventCounterPackage.eINSTANCE;
	}

} //EventCounterFactoryImpl
