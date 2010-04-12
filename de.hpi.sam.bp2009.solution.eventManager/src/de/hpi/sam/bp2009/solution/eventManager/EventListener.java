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
 * A representation of the model object '<em><b>Event Listener</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getEventListener()
 * @model abstract="true"
 * @generated
 */
public interface EventListener extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void handleEvent(ModelChangeEvent event, EventFilter matchingFilter);

} // EventListener
