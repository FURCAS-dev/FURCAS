/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerEnd;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerFactory;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerPackage;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerStart;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.JETMResultObject;
import de.hpi.sam.bp2009.benchframework.impl.OperatorImpl;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>End</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerEndImpl#getStartPoint <em>Start Point</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionTimeBenchmarkerEndImpl extends OperatorImpl implements ExecutionTimeBenchmarkerEnd {
	/**
	 * The cached value of the '{@link #getStartPoint() <em>Start Point</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartPoint()
	 * @generated
	 * @ordered
	 */
	protected ExecutionTimeBenchmarkerStart startPoint;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ExecutionTimeBenchmarkerEndImpl() {
		super();
		setName("Execution Time Benchmark End");
		setDescription("Ends a time measurement.");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionTimeBenchmarkerPackage.Literals.EXECUTION_TIME_BENCHMARKER_END;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionTimeBenchmarkerStart getStartPoint() {
		if (startPoint != null && startPoint.eIsProxy()) {
			InternalEObject oldStartPoint = (InternalEObject)startPoint;
			startPoint = (ExecutionTimeBenchmarkerStart)eResolveProxy(oldStartPoint);
			if (startPoint != oldStartPoint) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__START_POINT, oldStartPoint, startPoint));
			}
		}
		return startPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionTimeBenchmarkerStart basicGetStartPoint() {
		return startPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStartPoint(ExecutionTimeBenchmarkerStart newStartPoint, NotificationChain msgs) {
		ExecutionTimeBenchmarkerStart oldStartPoint = startPoint;
		startPoint = newStartPoint;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__START_POINT, oldStartPoint, newStartPoint);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartPoint(ExecutionTimeBenchmarkerStart newStartPoint) {
		if (newStartPoint != startPoint) {
			NotificationChain msgs = null;
			if (startPoint != null)
				msgs = ((InternalEObject)startPoint).eInverseRemove(this, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__END_POINT, ExecutionTimeBenchmarkerStart.class, msgs);
			if (newStartPoint != null)
				msgs = ((InternalEObject)newStartPoint).eInverseAdd(this, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__END_POINT, ExecutionTimeBenchmarkerStart.class, msgs);
			msgs = basicSetStartPoint(newStartPoint, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__START_POINT, newStartPoint, newStartPoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__START_POINT:
				if (startPoint != null)
					msgs = ((InternalEObject)startPoint).eInverseRemove(this, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__END_POINT, ExecutionTimeBenchmarkerStart.class, msgs);
				return basicSetStartPoint((ExecutionTimeBenchmarkerStart)otherEnd, msgs);
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
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__START_POINT:
				return basicSetStartPoint(null, msgs);
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
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__START_POINT:
				if (resolve) return getStartPoint();
				return basicGetStartPoint();
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
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__START_POINT:
				setStartPoint((ExecutionTimeBenchmarkerStart)newValue);
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
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__START_POINT:
				setStartPoint((ExecutionTimeBenchmarkerStart)null);
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
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__START_POINT:
				return startPoint != null;
		}
		return super.eIsSet(featureID);
	}
	@Override
	public void execute(){
		EtmMonitor monitor = getStartPoint().getMonitor();
		EtmPoint point = getStartPoint().getPoint();
		point.collect();
		monitor.stop();
		JETMResultObject rslt = ExecutionTimeBenchmarkerFactory.eINSTANCE.createJETMResultObject();
		rslt.setStartTime(point.getStartTime());
		rslt.setEndTime(point.getEndTime());
		rslt.setTicks(point.getTicks());
		rslt.setTransactionTime(point.getTransactionTime());
	}

} //ExecutionTimeBenchmarkerEndImpl
