/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager;

import de.hpi.sam.bp2009.solution.eventListener.EventListener;
import de.hpi.sam.bp2009.solution.events.ModelChangeEvent;


import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getEventManager()
 * @model
 * @generated
 */
public interface EventManager extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void subscribe(EventListener caller, ModelChangeEvent modelChangeEvent);

} // EventManager
