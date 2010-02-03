/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.modifiedEventManager;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.benchframework.modifiedEventManager.ModifiedEventManagerPackage
 * @generated
 */
public interface ModifiedEventManagerFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModifiedEventManagerFactory eINSTANCE = de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.ModifiedEventManagerFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Modified Event Manager</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Modified Event Manager</em>'.
	 * @generated
	 */
	ModifiedEventManager createModifiedEventManager();

	/**
	 * Returns a new object of class '<em>Incoming Event Notification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Incoming Event Notification</em>'.
	 * @generated
	 */
	IncomingEventNotification createIncomingEventNotification();

	/**
	 * Returns a new object of class '<em>Outgoing Event Notification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Outgoing Event Notification</em>'.
	 * @generated
	 */
	OutgoingEventNotification createOutgoingEventNotification();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ModifiedEventManagerPackage getModifiedEventManagerPackage();

} //ModifiedEventManagerFactory
