/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker;

import de.hpi.sam.bp2009.benchframework.Operator;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;
import java.util.Map;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Start</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This operator starts execution time measurement.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerStart#getEndPoint <em>End Point</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerStart#getMonitor <em>Monitor</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerStart#getPoint <em>Point</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerStart#getStringToPoint <em>String To Point</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerPackage#getExecutionTimeBenchmarkerStart()
 * @model
 * @generated
 */
public interface ExecutionTimeBenchmarkerStart extends Operator {
	/**
	 * Returns the value of the '<em><b>End Point</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerEnd#getStartPoint <em>Start Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Point</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Point</em>' reference.
	 * @see #setEndPoint(ExecutionTimeBenchmarkerEnd)
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerPackage#getExecutionTimeBenchmarkerStart_EndPoint()
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerEnd#getStartPoint
	 * @model opposite="startPoint"
	 * @generated
	 */
	ExecutionTimeBenchmarkerEnd getEndPoint();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerStart#getEndPoint <em>End Point</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Point</em>' reference.
	 * @see #getEndPoint()
	 * @generated
	 */
	void setEndPoint(ExecutionTimeBenchmarkerEnd value);

	/**
	 * Returns the value of the '<em><b>Monitor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Monitor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Monitor</em>' attribute.
	 * @see #setMonitor(EtmMonitor)
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerPackage#getExecutionTimeBenchmarkerStart_Monitor()
	 * @model dataType="de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ETMMonitor"
	 * @generated
	 */
	EtmMonitor getMonitor();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerStart#getMonitor <em>Monitor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Monitor</em>' attribute.
	 * @see #getMonitor()
	 * @generated
	 */
	void setMonitor(EtmMonitor value);

	/**
	 * Returns the value of the '<em><b>Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Point</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Point</em>' attribute.
	 * @see #setPoint(EtmPoint)
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerPackage#getExecutionTimeBenchmarkerStart_Point()
	 * @model dataType="de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ETMPoint"
	 * @generated
	 */
	EtmPoint getPoint();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerStart#getPoint <em>Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Point</em>' attribute.
	 * @see #getPoint()
	 * @generated
	 */
	void setPoint(EtmPoint value);

	/**
	 * Returns the value of the '<em><b>String To Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String To Point</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String To Point</em>' attribute.
	 * @see #setStringToPoint(Map)
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerPackage#getExecutionTimeBenchmarkerStart_StringToPoint()
	 * @model transient="true"
	 * @generated
	 */
	Map<String, EtmPoint> getStringToPoint();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerStart#getStringToPoint <em>String To Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>String To Point</em>' attribute.
	 * @see #getStringToPoint()
	 * @generated
	 */
	void setStringToPoint(Map<String, EtmPoint> value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ETMPoint"
	 * @generated
	 */
	EtmPoint getStartPointForUUID(String uuid);

} // ExecutionTimeBenchmarkerStart
