/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker;

import org.eclipse.emf.common.util.EMap;

import de.hpi.sam.bp2009.benchframework.StartOperator;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;

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
public interface ExecutionTimeBenchmarkerStart extends StartOperator {
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
	 * Returns the value of the '<em><b>String To Point</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link etm.core.monitor.EtmPoint},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String To Point</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String To Point</em>' map.
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerPackage#getExecutionTimeBenchmarkerStart_StringToPoint()
	 * @model mapType="de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.EStringToETMPointMap<org.eclipse.emf.ecore.EString, de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ETMPoint>"
	 * @generated
	 */
	EMap<String, EtmPoint> getStringToPoint();

} // ExecutionTimeBenchmarkerStart
