/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.modifiedEventManager;

import de.hpi.sam.bp2009.solution.eventManager.EventManager;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Modified Event Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see de.hpi.sam.bp2009.benchframework.modifiedEventManager.ModifiedEventManagerPackage#getModifiedEventManager()
 * @model
 * @generated
 */
public interface ModifiedEventManager extends EventManager {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void sendBenchmarkNotification(Object communicationPartner, boolean incoming);
} // ModifiedEventManager
