/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.eventCounter.impl;

import de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterPackage;
import de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterResultObject;

import de.hpi.sam.bp2009.benchframework.impl.ResultObjectImpl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Result Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterResultObjectImpl#getEventCounts <em>Event Counts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventCounterResultObjectImpl extends ResultObjectImpl implements EventCounterResultObject {
	/**
	 * The cached value of the '{@link #getEventCounts() <em>Event Counts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventCounts()
	 * @generated
	 * @ordered
	 */
	protected Map<String, Integer> eventCounts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventCounterResultObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventCounterPackage.Literals.EVENT_COUNTER_RESULT_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<String, Integer> getEventCounts() {
		return eventCounts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventCounts(Map<String, Integer> newEventCounts) {
		Map<String, Integer> oldEventCounts = eventCounts;
		eventCounts = newEventCounts;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventCounterPackage.EVENT_COUNTER_RESULT_OBJECT__EVENT_COUNTS, oldEventCounts, eventCounts));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EventCounterPackage.EVENT_COUNTER_RESULT_OBJECT__EVENT_COUNTS:
				return getEventCounts();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EventCounterPackage.EVENT_COUNTER_RESULT_OBJECT__EVENT_COUNTS:
				setEventCounts((Map<String, Integer>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EventCounterPackage.EVENT_COUNTER_RESULT_OBJECT__EVENT_COUNTS:
				setEventCounts((Map<String, Integer>)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EventCounterPackage.EVENT_COUNTER_RESULT_OBJECT__EVENT_COUNTS:
				return eventCounts != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (eventCounts: ");
		result.append(eventCounts);
		result.append(')');
		return result.toString();
	}

} //EventCounterResultObjectImpl
