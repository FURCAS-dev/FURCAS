/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl;

import de.hpi.sam.bp2009.benchframework.modifiedEventManager.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModifiedEventManagerFactoryImpl extends EFactoryImpl implements ModifiedEventManagerFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ModifiedEventManagerFactory init() {
		try {
			ModifiedEventManagerFactory theModifiedEventManagerFactory = (ModifiedEventManagerFactory)EPackage.Registry.INSTANCE.getEFactory("http://de.hpi.sam.bp2009.benchframework.modifiedEventManager"); 
			if (theModifiedEventManagerFactory != null) {
				return theModifiedEventManagerFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ModifiedEventManagerFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifiedEventManagerFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ModifiedEventManagerPackage.MODIFIED_EVENT_MANAGER: return createModifiedEventManager();
			case ModifiedEventManagerPackage.INCOMING_EVENT_NOTIFICATION: return createIncomingEventNotification();
			case ModifiedEventManagerPackage.OUTGOING_EVENT_NOTIFICATION: return createOutgoingEventNotification();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifiedEventManager createModifiedEventManager() {
		ModifiedEventManagerImpl modifiedEventManager = new ModifiedEventManagerImpl();
		return modifiedEventManager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IncomingEventNotification createIncomingEventNotification() {
		IncomingEventNotificationImpl incomingEventNotification = new IncomingEventNotificationImpl();
		return incomingEventNotification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutgoingEventNotification createOutgoingEventNotification() {
		OutgoingEventNotificationImpl outgoingEventNotification = new OutgoingEventNotificationImpl();
		return outgoingEventNotification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifiedEventManagerPackage getModifiedEventManagerPackage() {
		return (ModifiedEventManagerPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ModifiedEventManagerPackage getPackage() {
		return ModifiedEventManagerPackage.eINSTANCE;
	}

} //ModifiedEventManagerFactoryImpl
