/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl;

import java.util.UUID;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;
import de.hpi.sam.bp2009.benchframework.TestRun;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerEnd;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerFactory;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerOptionObject;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerPackage;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerStart;

import de.hpi.sam.bp2009.benchframework.impl.OperatorImpl;
import etm.core.configuration.BasicEtmConfigurator;
import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;

import etm.core.monitor.EtmPoint;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Start</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerStartImpl#getEndPoint <em>End Point</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerStartImpl#getMonitor <em>Monitor</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerStartImpl#getPoint <em>Point</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionTimeBenchmarkerStartImpl extends OperatorImpl implements ExecutionTimeBenchmarkerStart {
	/**
	 * The cached value of the '{@link #getEndPoint() <em>End Point</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndPoint()
	 * @generated
	 * @ordered
	 */
	protected ExecutionTimeBenchmarkerEnd endPoint;

	/**
	 * The default value of the '{@link #getMonitor() <em>Monitor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMonitor()
	 * @generated
	 * @ordered
	 */
	protected static final EtmMonitor MONITOR_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getMonitor() <em>Monitor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMonitor()
	 * @generated
	 * @ordered
	 */
	protected EtmMonitor monitor = MONITOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getPoint() <em>Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPoint()
	 * @generated
	 * @ordered
	 */
	protected static final EtmPoint POINT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPoint() <em>Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPoint()
	 * @generated
	 * @ordered
	 */
	protected EtmPoint point = POINT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ExecutionTimeBenchmarkerStartImpl() {
		super();
		ExecutionTimeBenchmarkerOptionObject options = ExecutionTimeBenchmarkerFactory.eINSTANCE.createExecutionTimeBenchmarkerOptionObject();
		setOption(options);
		setName("Execution Time Benchmark Start");
		setDescription("Starts a time measurement.");
		ExecutionTimeBenchmarkerEnd end = ExecutionTimeBenchmarkerFactory.eINSTANCE.createExecutionTimeBenchmarkerEnd();
		setEndPoint(end); //setStartPoint is the EOpposite of this reference, we don't need to set it explicitly
		end.setOption(options);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionTimeBenchmarkerPackage.Literals.EXECUTION_TIME_BENCHMARKER_START;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionTimeBenchmarkerEnd getEndPoint() {
		if (endPoint != null && endPoint.eIsProxy()) {
			InternalEObject oldEndPoint = (InternalEObject)endPoint;
			endPoint = (ExecutionTimeBenchmarkerEnd)eResolveProxy(oldEndPoint);
			if (endPoint != oldEndPoint) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__END_POINT, oldEndPoint, endPoint));
			}
		}
		return endPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionTimeBenchmarkerEnd basicGetEndPoint() {
		return endPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEndPoint(ExecutionTimeBenchmarkerEnd newEndPoint, NotificationChain msgs) {
		ExecutionTimeBenchmarkerEnd oldEndPoint = endPoint;
		if(oldEndPoint!=null)
			oldEndPoint.setTestRun(null);
		if(newEndPoint!=null)
			newEndPoint.setTestRun(getTestRun());
		endPoint = newEndPoint;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__END_POINT, oldEndPoint, newEndPoint);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndPoint(ExecutionTimeBenchmarkerEnd newEndPoint) {
		if (newEndPoint != endPoint) {
			NotificationChain msgs = null;
			if (endPoint != null)
				msgs = ((InternalEObject)endPoint).eInverseRemove(this, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__START_POINT, ExecutionTimeBenchmarkerEnd.class, msgs);
			if (newEndPoint != null)
				msgs = ((InternalEObject)newEndPoint).eInverseAdd(this, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__START_POINT, ExecutionTimeBenchmarkerEnd.class, msgs);
			msgs = basicSetEndPoint(newEndPoint, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__END_POINT, newEndPoint, newEndPoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EtmMonitor getMonitor() {
		return monitor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMonitor(EtmMonitor newMonitor) {
		EtmMonitor oldMonitor = monitor;
		monitor = newMonitor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__MONITOR, oldMonitor, monitor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EtmPoint getPoint() {
		return point;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPoint(EtmPoint newPoint) {
		EtmPoint oldPoint = point;
		point = newPoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__POINT, oldPoint, point));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__END_POINT:
				if (endPoint != null)
					msgs = ((InternalEObject)endPoint).eInverseRemove(this, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__START_POINT, ExecutionTimeBenchmarkerEnd.class, msgs);
				return basicSetEndPoint((ExecutionTimeBenchmarkerEnd)otherEnd, msgs);
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
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__END_POINT:
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
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__END_POINT:
				if (resolve) return getEndPoint();
				return basicGetEndPoint();
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__MONITOR:
				return getMonitor();
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__POINT:
				return getPoint();
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
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__END_POINT:
				setEndPoint((ExecutionTimeBenchmarkerEnd)newValue);
				return;
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__MONITOR:
				setMonitor((EtmMonitor)newValue);
				return;
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__POINT:
				setPoint((EtmPoint)newValue);
				return;
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__TEST_RUN:
				setTestRun((TestRun)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}
	@Override
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
	 * @generated NOT
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__END_POINT:
				setEndPoint((ExecutionTimeBenchmarkerEnd)null);
				return;
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__MONITOR:
				setMonitor(MONITOR_EDEFAULT);
				return;
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__POINT:
				setPoint(POINT_EDEFAULT);
				return;
			//make sure start and endpoint reference the same testrun
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__TEST_RUN:
				setTestRun(null);
				getEndPoint().setTestRun(null);
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
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__END_POINT:
				return endPoint != null;
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__MONITOR:
				return MONITOR_EDEFAULT == null ? monitor != null : !MONITOR_EDEFAULT.equals(monitor);
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__POINT:
				return POINT_EDEFAULT == null ? point != null : !POINT_EDEFAULT.equals(point);
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
		result.append(" (monitor: ");
		result.append(monitor);
		result.append(", point: ");
		result.append(point);
		result.append(')');
		return result.toString();
	}
	
	/* not sure if ETMMonitor is a singleton...might lead to problems when using more than one ExecutionTimeBenchmarker
	 * @see de.hpi.sam.bp2009.benchframework.impl.OperatorImpl#execute()
	 */
	@Override
	public void execute() {
		BasicEtmConfigurator.configure();
		EtmMonitor monitor = EtmManager.getEtmMonitor();
		monitor.start();
		point = monitor.createPoint(UUID.randomUUID().toString());
	}


} //ExecutionTimeBenchmarkerStartImpl
