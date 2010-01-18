/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package executionTimeBenchmarker;

import de.hpi.sam.bp2009.benchframework.Operator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Start</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link executionTimeBenchmarker.ExecutionTimeBenchmarkerStart#getEndPoint <em>End Point</em>}</li>
 * </ul>
 * </p>
 *
 * @see executionTimeBenchmarker.ExecutionTimeBenchmarkerPackage#getExecutionTimeBenchmarkerStart()
 * @model
 * @generated
 */
public interface ExecutionTimeBenchmarkerStart extends Operator {
	/**
	 * Returns the value of the '<em><b>End Point</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Point</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Point</em>' reference.
	 * @see #setEndPoint(ExecutionTimeBenchmarkerEnd)
	 * @see executionTimeBenchmarker.ExecutionTimeBenchmarkerPackage#getExecutionTimeBenchmarkerStart_EndPoint()
	 * @model
	 * @generated
	 */
	ExecutionTimeBenchmarkerEnd getEndPoint();

	/**
	 * Sets the value of the '{@link executionTimeBenchmarker.ExecutionTimeBenchmarkerStart#getEndPoint <em>End Point</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Point</em>' reference.
	 * @see #getEndPoint()
	 * @generated
	 */
	void setEndPoint(ExecutionTimeBenchmarkerEnd value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void start();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void end();

} // ExecutionTimeBenchmarkerStart
