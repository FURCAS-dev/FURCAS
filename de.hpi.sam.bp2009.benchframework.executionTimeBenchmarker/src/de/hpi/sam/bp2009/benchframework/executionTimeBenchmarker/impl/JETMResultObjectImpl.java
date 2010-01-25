/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl;

import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerPackage;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.JETMResultObject;

import de.hpi.sam.bp2009.benchframework.impl.ResultObjectImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>JETM Result Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.JETMResultObjectImpl#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.JETMResultObjectImpl#getEndTime <em>End Time</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.JETMResultObjectImpl#getTicks <em>Ticks</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.JETMResultObjectImpl#getTransactionTime <em>Transaction Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JETMResultObjectImpl extends ResultObjectImpl implements JETMResultObject {
	/**
	 * The default value of the '{@link #getStartTime() <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartTime()
	 * @generated
	 * @ordered
	 */
	protected static final long START_TIME_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getStartTime() <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartTime()
	 * @generated
	 * @ordered
	 */
	protected long startTime = START_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndTime() <em>End Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndTime()
	 * @generated
	 * @ordered
	 */
	protected static final long END_TIME_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getEndTime() <em>End Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndTime()
	 * @generated
	 * @ordered
	 */
	protected long endTime = END_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTicks() <em>Ticks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTicks()
	 * @generated
	 * @ordered
	 */
	protected static final long TICKS_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getTicks() <em>Ticks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTicks()
	 * @generated
	 * @ordered
	 */
	protected long ticks = TICKS_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransactionTime() <em>Transaction Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransactionTime()
	 * @generated
	 * @ordered
	 */
	protected static final double TRANSACTION_TIME_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getTransactionTime() <em>Transaction Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransactionTime()
	 * @generated
	 * @ordered
	 */
	protected double transactionTime = TRANSACTION_TIME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JETMResultObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionTimeBenchmarkerPackage.Literals.JETM_RESULT_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getStartTime() {
		return startTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartTime(long newStartTime) {
		long oldStartTime = startTime;
		startTime = newStartTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionTimeBenchmarkerPackage.JETM_RESULT_OBJECT__START_TIME, oldStartTime, startTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getEndTime() {
		return endTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndTime(long newEndTime) {
		long oldEndTime = endTime;
		endTime = newEndTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionTimeBenchmarkerPackage.JETM_RESULT_OBJECT__END_TIME, oldEndTime, endTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getTicks() {
		return ticks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTicks(long newTicks) {
		long oldTicks = ticks;
		ticks = newTicks;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionTimeBenchmarkerPackage.JETM_RESULT_OBJECT__TICKS, oldTicks, ticks));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTransactionTime() {
		return transactionTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransactionTime(double newTransactionTime) {
		double oldTransactionTime = transactionTime;
		transactionTime = newTransactionTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionTimeBenchmarkerPackage.JETM_RESULT_OBJECT__TRANSACTION_TIME, oldTransactionTime, transactionTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getDuration() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExecutionTimeBenchmarkerPackage.JETM_RESULT_OBJECT__START_TIME:
				return getStartTime();
			case ExecutionTimeBenchmarkerPackage.JETM_RESULT_OBJECT__END_TIME:
				return getEndTime();
			case ExecutionTimeBenchmarkerPackage.JETM_RESULT_OBJECT__TICKS:
				return getTicks();
			case ExecutionTimeBenchmarkerPackage.JETM_RESULT_OBJECT__TRANSACTION_TIME:
				return getTransactionTime();
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
			case ExecutionTimeBenchmarkerPackage.JETM_RESULT_OBJECT__START_TIME:
				setStartTime((Long)newValue);
				return;
			case ExecutionTimeBenchmarkerPackage.JETM_RESULT_OBJECT__END_TIME:
				setEndTime((Long)newValue);
				return;
			case ExecutionTimeBenchmarkerPackage.JETM_RESULT_OBJECT__TICKS:
				setTicks((Long)newValue);
				return;
			case ExecutionTimeBenchmarkerPackage.JETM_RESULT_OBJECT__TRANSACTION_TIME:
				setTransactionTime((Double)newValue);
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
			case ExecutionTimeBenchmarkerPackage.JETM_RESULT_OBJECT__START_TIME:
				setStartTime(START_TIME_EDEFAULT);
				return;
			case ExecutionTimeBenchmarkerPackage.JETM_RESULT_OBJECT__END_TIME:
				setEndTime(END_TIME_EDEFAULT);
				return;
			case ExecutionTimeBenchmarkerPackage.JETM_RESULT_OBJECT__TICKS:
				setTicks(TICKS_EDEFAULT);
				return;
			case ExecutionTimeBenchmarkerPackage.JETM_RESULT_OBJECT__TRANSACTION_TIME:
				setTransactionTime(TRANSACTION_TIME_EDEFAULT);
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
			case ExecutionTimeBenchmarkerPackage.JETM_RESULT_OBJECT__START_TIME:
				return startTime != START_TIME_EDEFAULT;
			case ExecutionTimeBenchmarkerPackage.JETM_RESULT_OBJECT__END_TIME:
				return endTime != END_TIME_EDEFAULT;
			case ExecutionTimeBenchmarkerPackage.JETM_RESULT_OBJECT__TICKS:
				return ticks != TICKS_EDEFAULT;
			case ExecutionTimeBenchmarkerPackage.JETM_RESULT_OBJECT__TRANSACTION_TIME:
				return transactionTime != TRANSACTION_TIME_EDEFAULT;
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
		result.append(" (startTime: ");
		result.append(startTime);
		result.append(", endTime: ");
		result.append(endTime);
		result.append(", ticks: ");
		result.append(ticks);
		result.append(", transactionTime: ");
		result.append(transactionTime);
		result.append(')');
		return result.toString();
	}

} //JETMResultObjectImpl
