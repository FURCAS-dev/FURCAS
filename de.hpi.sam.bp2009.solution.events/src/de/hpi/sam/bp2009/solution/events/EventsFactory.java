/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.events;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.solution.events.EventsPackage
 * @generated
 */
public interface EventsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EventsFactory eINSTANCE = de.hpi.sam.bp2009.solution.events.impl.EventsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Model Change Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Change Event</em>'.
	 * @generated
	 */
	ModelChangeEvent createModelChangeEvent();

	/**
	 * Returns a new object of class '<em>Element Change Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Element Change Event</em>'.
	 * @generated
	 */
	ElementChangeEvent createElementChangeEvent();

	/**
	 * Returns a new object of class '<em>Attribute Value Change Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Value Change Event</em>'.
	 * @generated
	 */
	AttributeValueChangeEvent createAttributeValueChangeEvent();

	/**
	 * Returns a new object of class '<em>Element Life Cycle Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Element Life Cycle Event</em>'.
	 * @generated
	 */
	ElementLifeCycleEvent createElementLifeCycleEvent();

	/**
	 * Returns a new object of class '<em>Link Life Cycle Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Life Cycle Event</em>'.
	 * @generated
	 */
	LinkLifeCycleEvent createLinkLifeCycleEvent();

	/**
	 * Returns a new object of class '<em>Element Create Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Element Create Event</em>'.
	 * @generated
	 */
	ElementCreateEvent createElementCreateEvent();

	/**
	 * Returns a new object of class '<em>Element Delete Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Element Delete Event</em>'.
	 * @generated
	 */
	ElementDeleteEvent createElementDeleteEvent();

	/**
	 * Returns a new object of class '<em>Link Create Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Create Event</em>'.
	 * @generated
	 */
	LinkCreateEvent createLinkCreateEvent();

	/**
	 * Returns a new object of class '<em>Link Delete Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Delete Event</em>'.
	 * @generated
	 */
	LinkDeleteEvent createLinkDeleteEvent();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EventsPackage getEventsPackage();

} //EventsFactory
