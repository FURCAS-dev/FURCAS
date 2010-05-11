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
	 * Returns a new object of class '<em>Class Filter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Filter</em>'.
	 * @generated
	 */
	ClassFilter createClassFilter();

	/**
	 * Returns a new object of class '<em>Attribute Filter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Filter</em>'.
	 * @generated
	 */
	AttributeFilter createAttributeFilter();

	/**
	 * Returns a new object of class '<em>Association Filter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Association Filter</em>'.
	 * @generated
	 */
	AssociationFilter createAssociationFilter();

	/**
	 * Returns a new object of class '<em>Old Value Class Filter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Old Value Class Filter</em>'.
	 * @generated
	 */
	OldValueClassFilter createOldValueClassFilter();

	/**
	 * Returns a new object of class '<em>New Value Class Filter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>New Value Class Filter</em>'.
	 * @generated
	 */
	NewValueClassFilter createNewValueClassFilter();

	/**
	 * Returns a new object of class '<em>Structural Feature Filter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structural Feature Filter</em>'.
	 * @generated
	 */
	StructuralFeatureFilter createStructuralFeatureFilter();

	/**
	 * Returns a new object of class '<em>Notification Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Notification Identifier</em>'.
	 * @generated
	 */
	NotificationIdentifier createNotificationIdentifier();

	/**
	 * Returns a new object of class '<em>Notification Identifier Builder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Notification Identifier Builder</em>'.
	 * @generated
	 */
	NotificationIdentifierBuilder createNotificationIdentifierBuilder();

	/**
	 * Returns a new object of class '<em>Containment Filter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Containment Filter</em>'.
	 * @generated
	 */
	ContainmentFilter createContainmentFilter();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EventManagerPackage getEventManagerPackage();

} //EventManagerFactory