/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.eventCounter;

import de.hpi.sam.bp2009.benchframework.ResultObject;

import java.util.Map;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterResultObject#getEventCounts <em>Event Counts</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterPackage#getEventCounterResultObject()
 * @model
 * @generated
 */
public interface EventCounterResultObject extends ResultObject {
	/**
	 * Returns the value of the '<em><b>Event Counts</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Counts</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Counts</em>' attribute.
	 * @see #setEventCounts(Map)
	 * @see de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterPackage#getEventCounterResultObject_EventCounts()
	 * @model transient="true"
	 * @generated
	 */
	Map<String, Integer> getEventCounts();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterResultObject#getEventCounts <em>Event Counts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Counts</em>' attribute.
	 * @see #getEventCounts()
	 * @generated
	 */
	void setEventCounts(Map<String, Integer> value);

} // EventCounterResultObject
