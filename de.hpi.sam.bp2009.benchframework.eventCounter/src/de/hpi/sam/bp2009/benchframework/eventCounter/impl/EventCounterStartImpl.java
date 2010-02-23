/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.eventCounter.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;
import de.hpi.sam.bp2009.benchframework.OptionObject;
import de.hpi.sam.bp2009.benchframework.ResultObject;
import de.hpi.sam.bp2009.benchframework.Status;
import de.hpi.sam.bp2009.benchframework.TestRun;
import de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterEnd;
import de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterFactory;
import de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterPackage;
import de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterResultObject;
import de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterStart;
import de.hpi.sam.bp2009.benchframework.modifiedEventManager.NotifyLiterals;
import de.hpi.sam.bp2009.solution.eventManager.EventManager;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Start</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterStartImpl#getOption <em>Option</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterStartImpl#getResult <em>Result</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterStartImpl#getTestRun <em>Test Run</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterStartImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterStartImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterStartImpl#getEndPoint <em>End Point</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.eventCounter.impl.EventCounterStartImpl#getAdapter <em>Adapter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventCounterStartImpl extends EObjectImpl implements EventCounterStart {
	private static final String DESCRIPTION = "Count Internal Events handled by the Impact Analyzer";

	private static final String NAME = "Event Counter";

	/**
	 * The cached value of the '{@link #getOption() <em>Option</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOption()
	 * @generated
	 * @ordered
	 */
	protected OptionObject option;

	/**
	 * The cached value of the '{@link #getResult() <em>Result</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected ResultObject result;

	/**
	 * The cached value of the '{@link #getTestRun() <em>Test Run</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestRun()
	 * @generated
	 * @ordered
	 */
	protected TestRun testRun;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEndPoint() <em>End Point</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndPoint()
	 * @generated
	 * @ordered
	 */
	protected EventCounterEnd endPoint;

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
		setEndPoint(EventCounterFactory.eINSTANCE.createEventCounterEnd()); 
		
		//create the result object
		EventCounterResultObject rslt = EventCounterFactory.eINSTANCE.createEventCounterResultObject();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("incoming EMF Events", 0);
		map.put("outgoing Internal Events", 0);
		rslt.setEventCounts(map);
		rslt.setStatus(Status.UNKOWN);
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
	public OptionObject getOption() {
		if (option != null && option.eIsProxy()) {
			InternalEObject oldOption = (InternalEObject)option;
			option = (OptionObject)eResolveProxy(oldOption);
			if (option != oldOption) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventCounterPackage.EVENT_COUNTER_START__OPTION, oldOption, option));
			}
		}
		return option;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptionObject basicGetOption() {
		return option;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOption(OptionObject newOption) {
		OptionObject oldOption = option;
		option = newOption;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventCounterPackage.EVENT_COUNTER_START__OPTION, oldOption, option));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultObject getResult() {
		if (result != null && result.eIsProxy()) {
			InternalEObject oldResult = (InternalEObject)result;
			result = (ResultObject)eResolveProxy(oldResult);
			if (result != oldResult) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventCounterPackage.EVENT_COUNTER_START__RESULT, oldResult, result));
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultObject basicGetResult() {
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResult(ResultObject newResult) {
		ResultObject oldResult = result;
		result = newResult;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventCounterPackage.EVENT_COUNTER_START__RESULT, oldResult, result));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestRun getTestRun() {
		if (testRun != null && testRun.eIsProxy()) {
			InternalEObject oldTestRun = (InternalEObject)testRun;
			testRun = (TestRun)eResolveProxy(oldTestRun);
			if (testRun != oldTestRun) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventCounterPackage.EVENT_COUNTER_START__TEST_RUN, oldTestRun, testRun));
			}
		}
		return testRun;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestRun basicGetTestRun() {
		return testRun;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventCounterEnd getEndPoint() {
		if (endPoint != null && endPoint.eIsProxy()) {
			InternalEObject oldEndPoint = (InternalEObject)endPoint;
			endPoint = (EventCounterEnd)eResolveProxy(oldEndPoint);
			if (endPoint != oldEndPoint) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventCounterPackage.EVENT_COUNTER_START__END_POINT, oldEndPoint, endPoint));
			}
		}
		return endPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventCounterEnd basicGetEndPoint() {
		return endPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEndPoint(EventCounterEnd newEndPoint, NotificationChain msgs) {
		EventCounterEnd oldEndPoint = endPoint;
		endPoint = newEndPoint;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventCounterPackage.EVENT_COUNTER_START__END_POINT, oldEndPoint, newEndPoint);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndPoint(EventCounterEnd newEndPoint) {
		if (newEndPoint != endPoint) {
			NotificationChain msgs = null;
			if (endPoint != null)
				msgs = ((InternalEObject)endPoint).eInverseRemove(this, EventCounterPackage.EVENT_COUNTER_END__START_POINT, EventCounterEnd.class, msgs);
			if (newEndPoint != null)
				msgs = ((InternalEObject)newEndPoint).eInverseAdd(this, EventCounterPackage.EVENT_COUNTER_END__START_POINT, EventCounterEnd.class, msgs);
			msgs = basicSetEndPoint(newEndPoint, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventCounterPackage.EVENT_COUNTER_START__END_POINT, newEndPoint, newEndPoint));
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EventCounterPackage.EVENT_COUNTER_START__TEST_RUN:
				if (testRun != null)
					msgs = ((InternalEObject)testRun).eInverseRemove(this, BenchframeworkPackage.TEST_RUN__OPERATORS, TestRun.class, msgs);
				return basicSetTestRun((TestRun)otherEnd, msgs);
			case EventCounterPackage.EVENT_COUNTER_START__END_POINT:
				if (endPoint != null)
					msgs = ((InternalEObject)endPoint).eInverseRemove(this, EventCounterPackage.EVENT_COUNTER_END__START_POINT, EventCounterEnd.class, msgs);
				return basicSetEndPoint((EventCounterEnd)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EventCounterPackage.EVENT_COUNTER_START__TEST_RUN:
				return basicSetTestRun(null, msgs);
			case EventCounterPackage.EVENT_COUNTER_START__END_POINT:
				return basicSetEndPoint(null, msgs);
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
			case EventCounterPackage.EVENT_COUNTER_START__OPTION:
				if (resolve) return getOption();
				return basicGetOption();
			case EventCounterPackage.EVENT_COUNTER_START__RESULT:
				if (resolve) return getResult();
				return basicGetResult();
			case EventCounterPackage.EVENT_COUNTER_START__TEST_RUN:
				if (resolve) return getTestRun();
				return basicGetTestRun();
			case EventCounterPackage.EVENT_COUNTER_START__NAME:
				return getName();
			case EventCounterPackage.EVENT_COUNTER_START__DESCRIPTION:
				return getDescription();
			case EventCounterPackage.EVENT_COUNTER_START__END_POINT:
				if (resolve) return getEndPoint();
				return basicGetEndPoint();
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
			case EventCounterPackage.EVENT_COUNTER_START__OPTION:
				setOption((OptionObject)newValue);
				return;
			case EventCounterPackage.EVENT_COUNTER_START__RESULT:
				setResult((ResultObject)newValue);
				return;
			case EventCounterPackage.EVENT_COUNTER_START__TEST_RUN:
				setTestRun((TestRun)newValue);
				return;
			case EventCounterPackage.EVENT_COUNTER_START__NAME:
				setName((String)newValue);
				return;
			case EventCounterPackage.EVENT_COUNTER_START__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case EventCounterPackage.EVENT_COUNTER_START__END_POINT:
				setEndPoint((EventCounterEnd)newValue);
				return;
			case EventCounterPackage.EVENT_COUNTER_START__ADAPTER:
				setAdapter((Adapter)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public NotificationChain basicSetTestRun(TestRun newTestRun, NotificationChain msgs) {
		TestRun oldTestRun = testRun;
		if(endPoint!=null)
			endPoint.setTestRun(newTestRun);
		testRun = newTestRun;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BenchframeworkPackage.OPERATOR__TEST_RUN, oldTestRun, newTestRun);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTestRun(TestRun newTestRun) {
		if (newTestRun != testRun) {
			NotificationChain msgs = null;
			if (testRun != null)
				msgs = ((InternalEObject)testRun).eInverseRemove(this, BenchframeworkPackage.TEST_RUN__OPERATORS, TestRun.class, msgs);
			if (newTestRun != null)
				msgs = ((InternalEObject)newTestRun).eInverseAdd(this, BenchframeworkPackage.TEST_RUN__OPERATORS, TestRun.class, msgs);
			msgs = basicSetTestRun(newTestRun, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventCounterPackage.EVENT_COUNTER_START__TEST_RUN, newTestRun, newTestRun));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventCounterPackage.EVENT_COUNTER_START__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventCounterPackage.EVENT_COUNTER_START__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EventCounterPackage.EVENT_COUNTER_START__OPTION:
				setOption((OptionObject)null);
				return;
			case EventCounterPackage.EVENT_COUNTER_START__RESULT:
				setResult((ResultObject)null);
				return;
			case EventCounterPackage.EVENT_COUNTER_START__TEST_RUN:
				setTestRun((TestRun)null);
				return;
			case EventCounterPackage.EVENT_COUNTER_START__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EventCounterPackage.EVENT_COUNTER_START__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case EventCounterPackage.EVENT_COUNTER_START__END_POINT:
				setEndPoint((EventCounterEnd)null);
				return;
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
			case EventCounterPackage.EVENT_COUNTER_START__OPTION:
				return option != null;
			case EventCounterPackage.EVENT_COUNTER_START__RESULT:
				return result != null;
			case EventCounterPackage.EVENT_COUNTER_START__TEST_RUN:
				return testRun != null;
			case EventCounterPackage.EVENT_COUNTER_START__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EventCounterPackage.EVENT_COUNTER_START__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case EventCounterPackage.EVENT_COUNTER_START__END_POINT:
				return endPoint != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(", adapter: ");
		result.append(adapter);
		result.append(')');
		return result.toString();
	}
	
	@Override
	public void execute() {
		//register an adapter at the Modified Event Manager
		final EventManager em = testRun.getInstanceForClass(de.hpi.sam.bp2009.solution.eventManager.EventManager.class);
		em.eAdapters().add(new Adapter() {		
			@Override
			public void notifyChanged(Notification notification) {
				Map<String, Integer> counters = ((EventCounterResultObject)getResult()).getEventCounts();
				
				if (notification.getEventType() == NotifyLiterals.START_EMF_EVENT_HANDLING_VALUE){
					counters.put("incoming EMF Events", counters.get("incoming EMF Events") + 1);
				} else if (notification.getEventType() == NotifyLiterals.START_APPLICATION_NOTIFICATION_VALUE) {
					counters.put("outgoing Internal Events", counters.get("outgoing Internal Events") + 1);
				}
			}
			@Override
			public boolean isAdapterForType(Object type) { return false; }
			@Override
			public Notifier getTarget() { return null; }
			@Override
			public void setTarget(Notifier newTarget) {}
		});
	}


} //ExecutionTimeBenchmarkerStartImpl
