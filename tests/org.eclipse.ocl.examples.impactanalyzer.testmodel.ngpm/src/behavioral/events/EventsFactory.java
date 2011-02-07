/**
 * <copyright>
 * </copyright>
 *
 * $Id: EventsFactory.java,v 1.1 2011/02/07 17:17:58 auhl Exp $
 */
package behavioral.events;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see behavioral.events.EventsPackage
 * @generated
 */
public interface EventsFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	EventsFactory eINSTANCE = behavioral.events.impl.EventsFactoryImpl.init();

	/**
     * Returns a new object of class '<em>Subscription</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Subscription</em>'.
     * @generated
     */
	Subscription createSubscription();

	/**
     * Returns a new object of class '<em>Event Filter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Event Filter</em>'.
     * @generated
     */
	EventFilter createEventFilter();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	EventsPackage getEventsPackage();

} //EventsFactory
