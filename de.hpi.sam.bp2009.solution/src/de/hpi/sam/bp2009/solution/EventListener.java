/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution;

import de.hpi.sam.bp2009.solution.events.ModelChangeEvent;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Listener</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see de.hpi.sam.bp2009.solution.SolutionPackage#getEventListener()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface EventListener extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void callback(ModelChangeEvent event);

} // EventListener
