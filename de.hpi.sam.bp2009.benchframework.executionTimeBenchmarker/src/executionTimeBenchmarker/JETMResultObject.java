/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package executionTimeBenchmarker;

import de.hpi.sam.bp2009.benchframework.ResultObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JETM Result Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link executionTimeBenchmarker.JETMResultObject#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link executionTimeBenchmarker.JETMResultObject#getEndTime <em>End Time</em>}</li>
 *   <li>{@link executionTimeBenchmarker.JETMResultObject#getTicks <em>Ticks</em>}</li>
 *   <li>{@link executionTimeBenchmarker.JETMResultObject#getTransactionTime <em>Transaction Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see executionTimeBenchmarker.ExecutionTimeBenchmarkerPackage#getJETMResultObject()
 * @model
 * @generated
 */
public interface JETMResultObject extends ResultObject {
	/**
	 * Returns the value of the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Time</em>' attribute.
	 * @see #setStartTime(long)
	 * @see executionTimeBenchmarker.ExecutionTimeBenchmarkerPackage#getJETMResultObject_StartTime()
	 * @model
	 * @generated
	 */
	long getStartTime();

	/**
	 * Sets the value of the '{@link executionTimeBenchmarker.JETMResultObject#getStartTime <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Time</em>' attribute.
	 * @see #getStartTime()
	 * @generated
	 */
	void setStartTime(long value);

	/**
	 * Returns the value of the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Time</em>' attribute.
	 * @see #setEndTime(long)
	 * @see executionTimeBenchmarker.ExecutionTimeBenchmarkerPackage#getJETMResultObject_EndTime()
	 * @model
	 * @generated
	 */
	long getEndTime();

	/**
	 * Sets the value of the '{@link executionTimeBenchmarker.JETMResultObject#getEndTime <em>End Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Time</em>' attribute.
	 * @see #getEndTime()
	 * @generated
	 */
	void setEndTime(long value);

	/**
	 * Returns the value of the '<em><b>Ticks</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ticks</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ticks</em>' attribute.
	 * @see #setTicks(long)
	 * @see executionTimeBenchmarker.ExecutionTimeBenchmarkerPackage#getJETMResultObject_Ticks()
	 * @model
	 * @generated
	 */
	long getTicks();

	/**
	 * Sets the value of the '{@link executionTimeBenchmarker.JETMResultObject#getTicks <em>Ticks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ticks</em>' attribute.
	 * @see #getTicks()
	 * @generated
	 */
	void setTicks(long value);

	/**
	 * Returns the value of the '<em><b>Transaction Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transaction Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transaction Time</em>' attribute.
	 * @see #setTransactionTime(double)
	 * @see executionTimeBenchmarker.ExecutionTimeBenchmarkerPackage#getJETMResultObject_TransactionTime()
	 * @model
	 * @generated
	 */
	double getTransactionTime();

	/**
	 * Sets the value of the '{@link executionTimeBenchmarker.JETMResultObject#getTransactionTime <em>Transaction Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transaction Time</em>' attribute.
	 * @see #getTransactionTime()
	 * @generated
	 */
	void setTransactionTime(double value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	long getDuration();

} // JETMResultObject
