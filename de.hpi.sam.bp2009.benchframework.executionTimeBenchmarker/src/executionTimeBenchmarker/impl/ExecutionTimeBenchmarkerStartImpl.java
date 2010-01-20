/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package executionTimeBenchmarker.impl;

import java.util.ArrayList;

import de.hpi.sam.bp2009.benchframework.impl.OperatorImpl;

import etm.core.configuration.BasicEtmConfigurator;
import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;
import executionTimeBenchmarker.ExecutionTimeBenchmarkerEnd;
import executionTimeBenchmarker.ExecutionTimeBenchmarkerFactory;
import executionTimeBenchmarker.ExecutionTimeBenchmarkerPackage;
import executionTimeBenchmarker.ExecutionTimeBenchmarkerStart;
import executionTimeBenchmarker.JETMResultObject;

import org.eclipse.emf.common.notify.Notification;

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
 *   <li>{@link executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerStartImpl#getEndPoint <em>End Point</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionTimeBenchmarkerStartImpl extends OperatorImpl implements ExecutionTimeBenchmarkerStart {
	private final EtmMonitor etmMonitor= EtmManager.getEtmMonitor();
	/**
	 * The cached value of the '{@link #getEndPoint() <em>End Point</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndPoint()
	 * @generated
	 * @ordered
	 */
	protected ExecutionTimeBenchmarkerEnd endPoint;
	private ArrayList<EtmPoint> measurePoints = new ArrayList<EtmPoint>();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionTimeBenchmarkerStartImpl() {
		super();
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
	public void setEndPoint(ExecutionTimeBenchmarkerEnd newEndPoint) {
		ExecutionTimeBenchmarkerEnd oldEndPoint = endPoint;
		endPoint = newEndPoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__END_POINT, oldEndPoint, endPoint));
	}

	public void start() {
		BasicEtmConfigurator.configure();
		etmMonitor.start();
		EtmPoint point = etmMonitor.createPoint("Run: " + measurePoints.size()+1);
		measurePoints.add(0, point);
	}
	
	public void end() {
		EtmPoint point = measurePoints.get(0);
		point.collect();
		//create ResultObject
		JETMResultObject tmpResult = ExecutionTimeBenchmarkerFactory.eINSTANCE.createJETMResultObject();
		tmpResult.setStartTime(point.getStartTime());
		tmpResult.setEndTime(point.getEndTime());
		tmpResult.setTicks(point.getTicks());
		tmpResult.setTransactionTime(point.getTransactionTime());
		etmMonitor.stop();
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
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__END_POINT:
				setEndPoint((ExecutionTimeBenchmarkerEnd)null);
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
		}
		return super.eIsSet(featureID);
	}

} //ExecutionTimeBenchmarkerStartImpl
