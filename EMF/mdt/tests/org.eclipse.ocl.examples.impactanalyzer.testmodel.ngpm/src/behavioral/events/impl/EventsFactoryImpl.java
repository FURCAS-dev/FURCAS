/**
 * <copyright>
 * </copyright>
 *
 * $Id: EventsFactoryImpl.java,v 1.1 2011/02/07 17:17:58 auhl Exp $
 */
package behavioral.events.impl;

import behavioral.events.*;

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
public class EventsFactoryImpl extends EFactoryImpl implements EventsFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static EventsFactory init() {
        try {
            EventsFactory theEventsFactory = (EventsFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/behavioral/events.ecore"); 
            if (theEventsFactory != null) {
                return theEventsFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new EventsFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EventsFactoryImpl() {
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
            case EventsPackage.SUBSCRIPTION: return createSubscription();
            case EventsPackage.EVENT_FILTER: return createEventFilter();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Subscription createSubscription() {
        SubscriptionImpl subscription = new SubscriptionImpl();
        return subscription;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EventFilter createEventFilter() {
        EventFilterImpl eventFilter = new EventFilterImpl();
        return eventFilter;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EventsPackage getEventsPackage() {
        return (EventsPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static EventsPackage getPackage() {
        return EventsPackage.eINSTANCE;
    }

} //EventsFactoryImpl
