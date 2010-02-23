/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.eventCounter;

import de.hpi.sam.bp2009.benchframework.Operator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>End</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This operator ends execution time measurement.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterEnd#getStartPoint <em>Start Point</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterPackage#getEventCounterEnd()
 * @model
 * @generated
 */
public interface EventCounterEnd extends Operator {
	/**
	 * Returns the value of the '<em><b>Start Point</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterStart#getEndPoint <em>End Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Point</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Point</em>' reference.
	 * @see #setStartPoint(EventCounterStart)
	 * @see de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterPackage#getEventCounterEnd_StartPoint()
	 * @see de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterStart#getEndPoint
	 * @model opposite="endPoint"
	 * @generated
	 */
	EventCounterStart getStartPoint();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterEnd#getStartPoint <em>Start Point</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Point</em>' reference.
	 * @see #getStartPoint()
	 * @generated
	 */
	void setStartPoint(EventCounterStart value);

} // EventCounterEnd
