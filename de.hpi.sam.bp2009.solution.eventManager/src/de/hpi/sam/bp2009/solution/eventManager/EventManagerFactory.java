/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage
 * @generated
 */
public interface EventManagerFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EventManagerFactory eINSTANCE = de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Event Manager</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event Manager</em>'.
	 * @generated
	 */
	EventManager createEventManager();

	/**
	 * Returns a new object of class '<em>Attribute Value Change Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Value Change Event</em>'.
	 * @generated
	 */
	AttributeValueChangeEvent createAttributeValueChangeEvent();

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
	 * Returns a new object of class '<em>Event Type Filter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event Type Filter</em>'.
	 * @generated
	 */
	EventTypeFilter createEventTypeFilter();

	/**
	 * Returns a new object of class '<em>And Filter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>And Filter</em>'.
	 * @generated
	 */
	AndFilter createAndFilter();

	/**
	 * Returns a new object of class '<em>Or Filter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Or Filter</em>'.
	 * @generated
	 */
	OrFilter createOrFilter();

	/**
	 * Returns a new object of class '<em>Not Filter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Not Filter</em>'.
	 * @generated
	 */
	NotFilter createNotFilter();

	/**
	 * Returns a new object of class '<em>Class Filter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Filter</em>'.
	 * @generated
	 */
	ClassFilter createClassFilter();

	/**
	 * Returns a new object of class '<em>Instance Filter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instance Filter</em>'.
	 * @generated
	 */
	InstanceFilter createInstanceFilter();

	/**
	 * Returns a new object of class '<em>Attribute Filter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Filter</em>'.
	 * @generated
	 */
	AttributeFilter createAttributeFilter();

	/**
	 * Returns a new object of class '<em>Container Filter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Container Filter</em>'.
	 * @generated
	 */
	ContainerFilter createContainerFilter();

	/**
	 * Returns a new object of class '<em>Composition Hierarchy Filter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composition Hierarchy Filter</em>'.
	 * @generated
	 */
	CompositionHierarchyFilter createCompositionHierarchyFilter();

	/**
	 * Returns a new object of class '<em>Package Filter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Package Filter</em>'.
	 * @generated
	 */
	PackageFilter createPackageFilter();

	/**
	 * Returns a new object of class '<em>Association Filter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Association Filter</em>'.
	 * @generated
	 */
	AssociationFilter createAssociationFilter();

	/**
	 * Returns a new object of class '<em>Event Mapper</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event Mapper</em>'.
	 * @generated
	 */
	EventMapper createEventMapper();

	/**
	 * Returns a new object of class '<em>Attribute Multi Value Change Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Multi Value Change Event</em>'.
	 * @generated
	 */
	AttributeMultiValueChangeEvent createAttributeMultiValueChangeEvent();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EventManagerPackage getEventManagerPackage();

} //EventManagerFactory
