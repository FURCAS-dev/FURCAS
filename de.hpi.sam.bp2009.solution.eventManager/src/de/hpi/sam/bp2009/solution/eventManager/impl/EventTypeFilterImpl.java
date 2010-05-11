/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;
import de.hpi.sam.bp2009.solution.eventManager.EventTypeFilter;
import de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Type Filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.impl.EventTypeFilterImpl#getMatchingNotification <em>Matching Notification</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.impl.EventTypeFilterImpl#getEventType <em>Event Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventTypeFilterImpl extends EventFilterImpl implements EventTypeFilter {
	/**
	 * The default value of the '{@link #getMatchingNotification() <em>Matching Notification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatchingNotification()
	 * @generated
	 * @ordered
	 */
	protected static final Notification MATCHING_NOTIFICATION_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getMatchingNotification() <em>Matching Notification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatchingNotification()
	 * @generated
	 * @ordered
	 */
	protected Notification matchingNotification = MATCHING_NOTIFICATION_EDEFAULT;
	/**
	 * The default value of the '{@link #getEventType() <em>Event Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventType()
	 * @generated
	 * @ordered
	 */
	protected static final Integer EVENT_TYPE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getEventType() <em>Event Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventType()
	 * @generated
	 * @ordered
	 */
	protected Integer eventType = EVENT_TYPE_EDEFAULT;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected EventTypeFilterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventManagerPackage.Literals.EVENT_TYPE_FILTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Notification getMatchingNotification() {
		return matchingNotification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMatchingNotification(Notification newMatchingNotification) {
		Notification oldMatchingNotification = matchingNotification;
		matchingNotification = newMatchingNotification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventManagerPackage.EVENT_TYPE_FILTER__MATCHING_NOTIFICATION, oldMatchingNotification, matchingNotification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getEventType() {
		return eventType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventType(Integer newEventType) {
		Integer oldEventType = eventType;
		eventType = newEventType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventManagerPackage.EVENT_TYPE_FILTER__EVENT_TYPE, oldEventType, eventType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean matchesFor(Notification event) {
		return event.getEventType()==getEventType(); 
	}

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<NotificationIdentifier> buildNotificationIdentifiers(NotificationIdentifier identifier) {
		EList<NotificationIdentifier> result = new BasicEList<NotificationIdentifier>();
		result.add(identifier);
		identifier.setEventType(getEventType());
		return result ;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EventManagerPackage.EVENT_TYPE_FILTER__MATCHING_NOTIFICATION:
				return getMatchingNotification();
			case EventManagerPackage.EVENT_TYPE_FILTER__EVENT_TYPE:
				return getEventType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EventManagerPackage.EVENT_TYPE_FILTER__MATCHING_NOTIFICATION:
				setMatchingNotification((Notification)newValue);
				return;
			case EventManagerPackage.EVENT_TYPE_FILTER__EVENT_TYPE:
				setEventType((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EventManagerPackage.EVENT_TYPE_FILTER__MATCHING_NOTIFICATION:
				setMatchingNotification(MATCHING_NOTIFICATION_EDEFAULT);
				return;
			case EventManagerPackage.EVENT_TYPE_FILTER__EVENT_TYPE:
				setEventType(EVENT_TYPE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EventManagerPackage.EVENT_TYPE_FILTER__MATCHING_NOTIFICATION:
				return MATCHING_NOTIFICATION_EDEFAULT == null ? matchingNotification != null : !MATCHING_NOTIFICATION_EDEFAULT.equals(matchingNotification);
			case EventManagerPackage.EVENT_TYPE_FILTER__EVENT_TYPE:
				return EVENT_TYPE_EDEFAULT == null ? eventType != null : !EVENT_TYPE_EDEFAULT.equals(eventType);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
	    switch(getEventType()){
	    case 0:
	        return "filter CREATE";

            case 1:
                return "filter SET";

            case 2:
                return "filter UNSET";

            case 3:
                return "filter ADD";

            case 4:
                return "filter REMOVE";

            case 5: 
                return "filter ADD_MANY";

            case 6:
                return "filter REMOVE_MANY";


            case 7:
                return "filter MOVE";    

            case 8:
                return "filter REMOVING_ADAPTER"; 

            case 9: 
                return "filter RESOLVE";
	    }

	    
		return "filter undefined";
	}

} //EventTypeFilterImpl
