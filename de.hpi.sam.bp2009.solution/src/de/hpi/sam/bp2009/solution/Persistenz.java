/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution;

import de.hpi.sam.bp2009.solution.eventManager.EventManager;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Persistenz</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.Persistenz#getEventManager <em>Event Manager</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.solution.SolutionPackage#getPersistenz()
 * @model
 * @generated
 */
public interface Persistenz extends EObject {
	/**
	 * Returns the value of the '<em><b>Event Manager</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Manager</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Manager</em>' reference.
	 * @see #setEventManager(EventManager)
	 * @see de.hpi.sam.bp2009.solution.SolutionPackage#getPersistenz_EventManager()
	 * @model
	 * @generated
	 */
	EventManager getEventManager();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.Persistenz#getEventManager <em>Event Manager</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Manager</em>' reference.
	 * @see #getEventManager()
	 * @generated
	 */
	void setEventManager(EventManager value);

} // Persistenz
