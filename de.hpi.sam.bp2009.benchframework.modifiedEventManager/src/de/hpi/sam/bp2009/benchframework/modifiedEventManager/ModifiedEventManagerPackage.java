/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.modifiedEventManager;

import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.benchframework.modifiedEventManager.ModifiedEventManagerFactory
 * @model kind="package"
 * @generated
 */
public interface ModifiedEventManagerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "modifiedEventManager";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://de.hpi.sam.bp2009.benchframework.modifiedEventManager";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "benchframework.modifiedEventManager";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModifiedEventManagerPackage eINSTANCE = de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.ModifiedEventManagerPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.ModifiedEventManagerImpl <em>Modified Event Manager</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.ModifiedEventManagerImpl
	 * @see de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.ModifiedEventManagerPackageImpl#getModifiedEventManager()
	 * @generated
	 */
	int MODIFIED_EVENT_MANAGER = 0;

	/**
	 * The feature id for the '<em><b>Event Mapper</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_EVENT_MANAGER__EVENT_MAPPER = EventManagerPackage.EVENT_MANAGER__EVENT_MAPPER;

	/**
	 * The number of structural features of the '<em>Modified Event Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_EVENT_MANAGER_FEATURE_COUNT = EventManagerPackage.EVENT_MANAGER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.IncomingEventNotificationImpl <em>Incoming Event Notification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.IncomingEventNotificationImpl
	 * @see de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.ModifiedEventManagerPackageImpl#getIncomingEventNotification()
	 * @generated
	 */
	int INCOMING_EVENT_NOTIFICATION = 1;

	/**
	 * The number of structural features of the '<em>Incoming Event Notification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCOMING_EVENT_NOTIFICATION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.OutgoingEventNotificationImpl <em>Outgoing Event Notification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.OutgoingEventNotificationImpl
	 * @see de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.ModifiedEventManagerPackageImpl#getOutgoingEventNotification()
	 * @generated
	 */
	int OUTGOING_EVENT_NOTIFICATION = 2;

	/**
	 * The number of structural features of the '<em>Outgoing Event Notification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTGOING_EVENT_NOTIFICATION_FEATURE_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.modifiedEventManager.ModifiedEventManager <em>Modified Event Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Modified Event Manager</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.modifiedEventManager.ModifiedEventManager
	 * @generated
	 */
	EClass getModifiedEventManager();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.modifiedEventManager.IncomingEventNotification <em>Incoming Event Notification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Incoming Event Notification</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.modifiedEventManager.IncomingEventNotification
	 * @generated
	 */
	EClass getIncomingEventNotification();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.modifiedEventManager.OutgoingEventNotification <em>Outgoing Event Notification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Outgoing Event Notification</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.modifiedEventManager.OutgoingEventNotification
	 * @generated
	 */
	EClass getOutgoingEventNotification();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModifiedEventManagerFactory getModifiedEventManagerFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.ModifiedEventManagerImpl <em>Modified Event Manager</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.ModifiedEventManagerImpl
		 * @see de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.ModifiedEventManagerPackageImpl#getModifiedEventManager()
		 * @generated
		 */
		EClass MODIFIED_EVENT_MANAGER = eINSTANCE.getModifiedEventManager();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.IncomingEventNotificationImpl <em>Incoming Event Notification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.IncomingEventNotificationImpl
		 * @see de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.ModifiedEventManagerPackageImpl#getIncomingEventNotification()
		 * @generated
		 */
		EClass INCOMING_EVENT_NOTIFICATION = eINSTANCE.getIncomingEventNotification();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.OutgoingEventNotificationImpl <em>Outgoing Event Notification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.OutgoingEventNotificationImpl
		 * @see de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.ModifiedEventManagerPackageImpl#getOutgoingEventNotification()
		 * @generated
		 */
		EClass OUTGOING_EVENT_NOTIFICATION = eINSTANCE.getOutgoingEventNotification();

	}

} //ModifiedEventManagerPackage
