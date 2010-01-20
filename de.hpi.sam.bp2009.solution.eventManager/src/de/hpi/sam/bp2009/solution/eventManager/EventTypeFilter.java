/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager;

import org.eclipse.emf.ecore.EClass;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Type Filter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.EventTypeFilter#getEventEClass <em>Event EClass</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getEventTypeFilter()
 * @model
 * @generated
 */
public interface EventTypeFilter extends EventFilter {

	/**
	 * Returns the value of the '<em><b>Event EClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event EClass</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event EClass</em>' reference.
	 * @see #setEventEClass(EClass)
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getEventTypeFilter_EventEClass()
	 * @model
	 * @generated
	 */
	EClass getEventEClass();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.eventManager.EventTypeFilter#getEventEClass <em>Event EClass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event EClass</em>' reference.
	 * @see #getEventEClass()
	 * @generated
	 */
	void setEventEClass(EClass value);
} // EventTypeFilter
