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
 * A representation of the model object '<em><b>End</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link executionTimeBenchmarker.ExecutionTimeBenchmarkerEnd#getStartPoint <em>Start Point</em>}</li>
 * </ul>
 * </p>
 *
 * @see executionTimeBenchmarker.ExecutionTimeBenchmarkerPackage#getExecutionTimeBenchmarkerEnd()
 * @model
 * @generated
 */
public interface ExecutionTimeBenchmarkerEnd extends Operator {
	/**
	 * Returns the value of the '<em><b>Start Point</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Point</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Point</em>' reference.
	 * @see #setStartPoint(ExecutionTimeBenchmarkerStart)
	 * @see executionTimeBenchmarker.ExecutionTimeBenchmarkerPackage#getExecutionTimeBenchmarkerEnd_StartPoint()
	 * @model
	 * @generated
	 */
	ExecutionTimeBenchmarkerStart getStartPoint();

	/**
	 * Sets the value of the '{@link executionTimeBenchmarker.ExecutionTimeBenchmarkerEnd#getStartPoint <em>Start Point</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Point</em>' reference.
	 * @see #getStartPoint()
	 * @generated
	 */
	void setStartPoint(ExecutionTimeBenchmarkerStart value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void end();

} // ExecutionTimeBenchmarkerEnd
