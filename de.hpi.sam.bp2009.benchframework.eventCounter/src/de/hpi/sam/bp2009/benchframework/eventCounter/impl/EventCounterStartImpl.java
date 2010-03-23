/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.eventCounter.impl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.hpi.sam.bp2009.benchframework.Status;
import de.hpi.sam.bp2009.benchframework.TestRun;
import de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterFactory;
import de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterPackage;
import de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterResultObject;
import de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterStart;
import de.hpi.sam.bp2009.benchframework.impl.StartOperatorImpl;
import de.hpi.sam.bp2009.benchframework.modifiedEventManager.ModifiedEventManagerNotifyLiterals;
import de.hpi.sam.bp2009.solution.eventManager.EventManager;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Start</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterStartImpl#getAdapter <em>Adapter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventCounterStartImpl extends StartOperatorImpl implements EventCounterStart {
	private static final String DESCRIPTION = "Count Internal Events handled by the Impact Analyzer";

	private static final String NAME = "Event Counter";

	/**
	 * The default value of the '{@link #getAdapter() <em>Adapter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdapter()
	 * @generated
	 * @ordered
	 */
	protected static final Adapter ADAPTER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAdapter() <em>Adapter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdapter()
	 * @generated
	 * @ordered
	 */
	protected Adapter adapter = ADAPTER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EventCounterStartImpl() {
		super();
		setName(NAME);
		setDescription(DESCRIPTION);
		setEndOperator(EventCounterFactory.eINSTANCE.createEventCounterEnd()); 
		
		//create the result object
		EventCounterResultObject rslt = EventCounterFactory.eINSTANCE.createEventCounterResultObject();
		rslt.getEventCounts().put("incoming EMF Events", 0);
		rslt.getEventCounts().put("outgoing Internal Events", 0);

		rslt.setStatus(Status.UNKNOWN);
		setResult(rslt);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventCounterPackage.Literals.EVENT_COUNTER_START;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter getAdapter() {
		return adapter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdapter(Adapter newAdapter) {
		Adapter oldAdapter = adapter;
		adapter = newAdapter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventCounterPackage.EVENT_COUNTER_START__ADAPTER, oldAdapter, adapter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EventCounterPackage.EVENT_COUNTER_START__ADAPTER:
				return getAdapter();
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
			case EventCounterPackage.EVENT_COUNTER_START__ADAPTER:
				setAdapter((Adapter)newValue);
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
			case EventCounterPackage.EVENT_COUNTER_START__ADAPTER:
				setAdapter(ADAPTER_EDEFAULT);
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
			case EventCounterPackage.EVENT_COUNTER_START__ADAPTER:
				return ADAPTER_EDEFAULT == null ? adapter != null : !ADAPTER_EDEFAULT.equals(adapter);
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
		result.append(" (adapter: ");
		result.append(adapter);
		result.append(')');
		return result.toString();
	}
	
	@Override
	public void execute() {
		//register an adapter at the Modified Event Manager
		final EventManager em = ((TestRun)eContainer()).getInstanceForClass(de.hpi.sam.bp2009.solution.eventManager.EventManager.class);
		setAdapter(new Adapter() {		
			@Override
			public void notifyChanged(Notification notification) {
				EMap<String, Integer> counters = ((EventCounterResultObject)getResult()).getEventCounts();
				
				if (notification.getEventType() == ModifiedEventManagerNotifyLiterals.START_EMF_EVENT_HANDLING_VALUE){
					counters.put("incoming EMF Events", counters.get("incoming EMF Events") + 1);
				} else if (notification.getEventType() == ModifiedEventManagerNotifyLiterals.START_APPLICATION_NOTIFICATION_VALUE) {
					counters.put("outgoing Internal Events", counters.get("outgoing Internal Events") + 1);
				}
			}
			@Override
			public boolean isAdapterForType(Object type) { return false; }
			@Override
			public Notifier getTarget() { return em; }
			@Override
			public void setTarget(Notifier newTarget) {}
		});
		em.eAdapters().add(getAdapter());
	}


} //ExecutionTimeBenchmarkerStartImpl
