/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager;

import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Notification Identifier Builder</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getNotificationIdentifierBuilder()
 * @model
 * @generated
 */
public interface NotificationIdentifierBuilder extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifierSet" notiDataType="de.hpi.sam.bp2009.solution.eventManager.Notification"
	 * @generated
	 */
	Set<NotificationIdentifier> buildFrom(Notification noti);

} // NotificationIdentifierBuilder
