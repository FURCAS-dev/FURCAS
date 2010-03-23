/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.eventCounter;

import org.eclipse.emf.common.util.EMap;

import de.hpi.sam.bp2009.benchframework.ResultObject;

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
	 * Returns the value of the '<em><b>Event Counts</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.Integer},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Counts</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Counts</em>' map.
	 * @see de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterPackage#getEventCounterResultObject_EventCounts()
	 * @model mapType="de.hpi.sam.bp2009.benchframework.eventCounter.EStringToEIntegerMap<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EIntegerObject>"
	 * @generated
	 */
	EMap<String, Integer> getEventCounts();

} // EventCounterResultObject
