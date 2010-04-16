/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Mapper</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getEventMapper()
 * @model
 * @generated
 */
public interface EventMapper extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model notificationDataType="de.hpi.sam.bp2009.solution.eventManager.Notification"
	 * @generated
	 */
	EList<ModelChangeEvent> mapNotificationToEvent(Notification notification);

} // EventMapper
