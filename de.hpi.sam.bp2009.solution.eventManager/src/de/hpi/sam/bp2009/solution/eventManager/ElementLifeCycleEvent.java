/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager;

import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Life Cycle Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.ElementLifeCycleEvent#getContainingElement <em>Containing Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getElementLifeCycleEvent()
 * @model abstract="true"
 * @generated
 */
public interface ElementLifeCycleEvent extends ElementChangeEvent {

	/**
	 * Returns the value of the '<em><b>Containing Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containing Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containing Element</em>' reference.
	 * @see #setContainingElement(EObject)
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getElementLifeCycleEvent_ContainingElement()
	 * @model
	 * @generated
	 */
	EObject getContainingElement();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.eventManager.ElementLifeCycleEvent#getContainingElement <em>Containing Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containing Element</em>' reference.
	 * @see #getContainingElement()
	 * @generated
	 */
	void setContainingElement(EObject value);
} // ElementLifeCycleEvent
