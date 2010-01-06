/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventListener;

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
 * @see de.hpi.sam.bp2009.solution.eventListener.EventListenerFactory
 * @model kind="package"
 * @generated
 */
public interface EventListenerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "eventListener";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://de.hpi.sam.bp2009.solution.eventListener";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "solution.eventListener";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EventListenerPackage eINSTANCE = de.hpi.sam.bp2009.solution.eventListener.impl.EventListenerPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventListener.EventListener <em>Event Listener</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventListener.EventListener
	 * @see de.hpi.sam.bp2009.solution.eventListener.impl.EventListenerPackageImpl#getEventListener()
	 * @generated
	 */
	int EVENT_LISTENER = 0;

	/**
	 * The number of structural features of the '<em>Event Listener</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_LISTENER_FEATURE_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventListener.EventListener <em>Event Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Listener</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventListener.EventListener
	 * @generated
	 */
	EClass getEventListener();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EventListenerFactory getEventListenerFactory();

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
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventListener.EventListener <em>Event Listener</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventListener.EventListener
		 * @see de.hpi.sam.bp2009.solution.eventListener.impl.EventListenerPackageImpl#getEventListener()
		 * @generated
		 */
		EClass EVENT_LISTENER = eINSTANCE.getEventListener();

	}

} //EventListenerPackage
