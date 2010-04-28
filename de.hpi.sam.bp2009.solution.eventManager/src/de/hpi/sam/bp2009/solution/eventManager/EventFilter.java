/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Filter</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getEventFilter()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface EventFilter extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model eventDataType="de.hpi.sam.bp2009.solution.eventManager.Notification"
	 * @generated
	 */
	boolean matchesFor(Notification event);

} // EventFilter
