/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.eventCounter.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterPackage;
import de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterResultObject;
import de.hpi.sam.bp2009.benchframework.impl.ResultObjectImpl;

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
	 * The cached value of the '{@link #getEventCounts() <em>Event Counts</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventCounts()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, Integer> eventCounts;

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
	public EMap<String, Integer> getEventCounts() {
		if (eventCounts == null) {
			eventCounts = new EcoreEMap<String,Integer>(EventCounterPackage.Literals.ESTRING_TO_EINTEGER_MAP, EStringToEIntegerMapImpl.class, this, EventCounterPackage.EVENT_COUNTER_RESULT_OBJECT__EVENT_COUNTS);
		}
		return eventCounts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EventCounterPackage.EVENT_COUNTER_RESULT_OBJECT__EVENT_COUNTS:
				return ((InternalEList<?>)getEventCounts()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
				if (coreType) return getEventCounts();
				else return getEventCounts().map();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EventCounterPackage.EVENT_COUNTER_RESULT_OBJECT__EVENT_COUNTS:
				((EStructuralFeature.Setting)getEventCounts()).set(newValue);
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
				getEventCounts().clear();
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
				return eventCounts != null && !eventCounts.isEmpty();
		}
		return super.eIsSet(featureID);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getCSV() {
		String msg = "";
		for (String key : this.getEventCounts().keySet()){
			msg += key + " " + this.getEventCounts().get(key).toString() + " , ";
		}		
		return msg;
	}

} //EventCounterResultObjectImpl
