/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.impl;

import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.hpi.sam.bp2009.solution.eventManager.EventNotification;
import de.hpi.sam.bp2009.solution.eventManager.ModelChangeEvent;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Notification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.impl.EventNotificationImpl#getEvent <em>Event</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.impl.EventNotificationImpl#getNotification <em>Notification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated NOT
 */
public class EventNotificationImpl extends EObjectImpl implements EventNotification {

	/**
	 * The cached value of the '{@link #getEvent() <em>Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvent()
	 * @generated
	 * @ordered
	 */
	protected ModelChangeEvent event;

	/**
	 * The default value of the '{@link #getNotification() <em>Notification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotification()
	 * @generated
	 * @ordered
	 */
	protected static final Notification NOTIFICATION_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getNotification() <em>Notification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotification()
	 * @generated
	 * @ordered
	 */
	protected Notification notification = NOTIFICATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventNotificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventManagerPackage.Literals.EVENT_NOTIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelChangeEvent getEvent() {
		if (event != null && event.eIsProxy()) {
			InternalEObject oldEvent = (InternalEObject)event;
			event = (ModelChangeEvent)eResolveProxy(oldEvent);
			if (event != oldEvent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventManagerPackage.EVENT_NOTIFICATION__EVENT, oldEvent, event));
			}
		}
		return event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelChangeEvent basicGetEvent() {
		return event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEvent(ModelChangeEvent newEvent) {
		ModelChangeEvent oldEvent = event;
		event = newEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventManagerPackage.EVENT_NOTIFICATION__EVENT, oldEvent, event));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Notification getNotification() {
		return notification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotification(Notification newNotification) {
		Notification oldNotification = notification;
		notification = newNotification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventManagerPackage.EVENT_NOTIFICATION__NOTIFICATION, oldNotification, notification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EventManagerPackage.EVENT_NOTIFICATION__EVENT:
				if (resolve) return getEvent();
				return basicGetEvent();
			case EventManagerPackage.EVENT_NOTIFICATION__NOTIFICATION:
				return getNotification();
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
			case EventManagerPackage.EVENT_NOTIFICATION__EVENT:
				setEvent((ModelChangeEvent)newValue);
				return;
			case EventManagerPackage.EVENT_NOTIFICATION__NOTIFICATION:
				setNotification((Notification)newValue);
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
			case EventManagerPackage.EVENT_NOTIFICATION__EVENT:
				setEvent((ModelChangeEvent)null);
				return;
			case EventManagerPackage.EVENT_NOTIFICATION__NOTIFICATION:
				setNotification(NOTIFICATION_EDEFAULT);
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
			case EventManagerPackage.EVENT_NOTIFICATION__EVENT:
				return event != null;
			case EventManagerPackage.EVENT_NOTIFICATION__NOTIFICATION:
				return NOTIFICATION_EDEFAULT == null ? notification != null : !NOTIFICATION_EDEFAULT.equals(notification);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (notification: ");
		result.append(notification);
		result.append(')');
		return result.toString();
	}

	@Override
	public int getEventType() {
		if(this.getNotification()==null)
			return 0;
		return this.getNotification().getEventType();
	}

	@Override
	public Object getFeature() {
		if(this.getNotification()==null)
			return null;
		return this.getNotification().getFeature();
	}

	@Override
	public int getFeatureID(Class<?> expectedClass) {
		if(this.getNotification()==null)
			return 0;
		return this.getNotification().getFeatureID(expectedClass);
	}

	@Override
	public boolean getNewBooleanValue() {
		if(this.getNotification()==null)
			return false;
		return this.getNotification().getNewBooleanValue();
	}

	@Override
	public byte getNewByteValue() {
		if(this.getNotification()==null)
			return 0;
		return this.getNotification().getNewByteValue();
	}

	@Override
	public char getNewCharValue() {
		if(this.getNotification()==null)
			return 0;
		return this.getNotification().getNewCharValue();
	}

	@Override
	public double getNewDoubleValue() {
		if(this.getNotification()==null)
			return 0;
		return this.getNotification().getNewDoubleValue();
	}

	@Override
	public float getNewFloatValue() {
		if(this.getNotification()==null)
			return 0;
		return this.getNotification().getNewFloatValue();
	}

	@Override
	public int getNewIntValue() {
		if(this.getNotification()==null)
			return 0;
		return this.getNotification().getNewIntValue();
	}

	@Override
	public long getNewLongValue() {
		if(this.getNotification()==null)
			return 0;
		return this.getNotification().getNewLongValue();
	}

	@Override
	public short getNewShortValue() {
		if(this.getNotification()==null)
			return 0;
		return this.getNotification().getNewShortValue();
	}

	@Override
	public String getNewStringValue() {
		if(this.getNotification()==null)
			return null;
		return this.getNotification().getNewStringValue();
	}

	@Override
	public Object getNewValue() {
		if(this.getNotification()==null)
			return null;
		return this.getNotification().getNewValue();
	}

	@Override
	public Object getNotifier() {
		if(this.getNotification()==null)
			return 0;
		return this.getNotification().getNotifier();
	}

	@Override
	public boolean getOldBooleanValue() {
		if(this.getNotification()==null)
			return false;
		return this.getNotification().getOldBooleanValue();
	}

	@Override
	public byte getOldByteValue() {
		if(this.getNotification()==null)
			return 0;
		return this.getNotification().getOldByteValue();
	}

	@Override
	public char getOldCharValue() {
		if(this.getNotification()==null)
			return 0;
		return this.getNotification().getOldCharValue();
	}

	@Override
	public double getOldDoubleValue() {
		if(this.getNotification()==null)
			return 0;
		return this.getNotification().getOldDoubleValue();
	}

	@Override
	public float getOldFloatValue() {
		if(this.getNotification()==null)
			return 0;
		return this.getNotification().getOldFloatValue();
	}

	@Override
	public int getOldIntValue() {
		if(this.getNotification()==null)
			return 0;
		return this.getNotification().getOldIntValue();
	}

	@Override
	public long getOldLongValue() {
		if(this.getNotification()==null)
			return 0;
		return this.getNotification().getOldLongValue();
	}

	@Override
	public short getOldShortValue() {
		if(this.getNotification()==null)
			return 0;
		return this.getNotification().getOldShortValue();
	}

	@Override
	public String getOldStringValue() {
		if(this.getNotification()==null)
			return null;
		return this.getNotification().getOldStringValue();
	}

	@Override
	public Object getOldValue() {
		if(this.getNotification()==null)
			return null;
		return this.getNotification().getOldValue();
	}

	@Override
	public int getPosition() {
		if(this.getNotification()==null)
			return 0;
		return this.getNotification().getPosition();
	}

	@Override
	public boolean isReset() {
		if(this.getNotification()==null)
			return false;
		return this.getNotification().isReset();
	}

	@Override
	public boolean isTouch() {
		if(this.getNotification()==null)
			return false;
		return this.getNotification().isTouch();
	}

	@Override
	public boolean merge(Notification notification) {
		if(this.getNotification()==null)
			return false;
		return this.getNotification().merge(notification);
	}

	@Override
	public boolean wasSet() {
		if(this.getNotification()==null)
			return false;
		return this.getNotification().wasSet();
	}

} //EventNotificationImpl
