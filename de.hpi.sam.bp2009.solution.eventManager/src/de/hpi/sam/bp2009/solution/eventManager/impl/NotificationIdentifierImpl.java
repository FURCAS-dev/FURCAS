/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.impl;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;
import de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Notification Identifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.impl.NotificationIdentifierImpl#getNotifierClassURI <em>Notifier Class URI</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.impl.NotificationIdentifierImpl#getEventType <em>Event Type</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.impl.NotificationIdentifierImpl#getFeatureURI <em>Feature URI</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.impl.NotificationIdentifierImpl#getOldValueClassURIs <em>Old Value Class UR Is</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.impl.NotificationIdentifierImpl#getNewValueClassURIs <em>New Value Class UR Is</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.impl.NotificationIdentifierImpl#isTouch <em>Touch</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.impl.NotificationIdentifierImpl#isReset <em>Reset</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.impl.NotificationIdentifierImpl#isContainment <em>Containment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NotificationIdentifierImpl extends EObjectImpl implements NotificationIdentifier {
	/**
	 * The default value of the '{@link #getNotifierClassURI() <em>Notifier Class URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotifierClassURI()
	 * @generated
	 * @ordered
	 */
	protected static final URI NOTIFIER_CLASS_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNotifierClassURI() <em>Notifier Class URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotifierClassURI()
	 * @generated
	 * @ordered
	 */
	protected URI notifierClassURI = NOTIFIER_CLASS_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getEventType() <em>Event Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventType()
	 * @generated
	 * @ordered
	 */
	protected static final int EVENT_TYPE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEventType() <em>Event Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventType()
	 * @generated
	 * @ordered
	 */
	protected int eventType = EVENT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFeatureURI() <em>Feature URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureURI()
	 * @generated
	 * @ordered
	 */
	protected static final URI FEATURE_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFeatureURI() <em>Feature URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureURI()
	 * @generated
	 * @ordered
	 */
	protected URI featureURI = FEATURE_URI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOldValueClassURIs() <em>Old Value Class UR Is</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldValueClassURIs()
	 * @generated NOT
	 * @ordered
	 */
	protected Set<URI> oldValueClassURIs = new HashSet<URI>();

	/**
	 * The cached value of the '{@link #getNewValueClassURIs() <em>New Value Class UR Is</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewValueClassURIs()
	 * @generated NOT
	 * @ordered
	 */
	protected Set<URI> newValueClassURIs = new HashSet<URI>();

	/**
	 * The default value of the '{@link #isTouch() <em>Touch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTouch()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TOUCH_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTouch() <em>Touch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTouch()
	 * @generated
	 * @ordered
	 */
	protected boolean touch = TOUCH_EDEFAULT;

	/**
	 * The default value of the '{@link #isReset() <em>Reset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReset()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RESET_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReset() <em>Reset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReset()
	 * @generated
	 * @ordered
	 */
	protected boolean reset = RESET_EDEFAULT;

	/**
	 * The default value of the '{@link #isContainment() <em>Containment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContainment()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONTAINMENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isContainment() <em>Containment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContainment()
	 * @generated
	 * @ordered
	 */
	protected boolean containment = CONTAINMENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NotificationIdentifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventManagerPackage.Literals.NOTIFICATION_IDENTIFIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URI getNotifierClassURI() {
		return notifierClassURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotifierClassURI(URI newNotifierClassURI) {
		URI oldNotifierClassURI = notifierClassURI;
		notifierClassURI = newNotifierClassURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventManagerPackage.NOTIFICATION_IDENTIFIER__NOTIFIER_CLASS_URI, oldNotifierClassURI, notifierClassURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEventType() {
		return eventType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventType(int newEventType) {
		int oldEventType = eventType;
		eventType = newEventType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventManagerPackage.NOTIFICATION_IDENTIFIER__EVENT_TYPE, oldEventType, eventType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URI getFeatureURI() {
		return featureURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureURI(URI newFeatureURI) {
		URI oldFeatureURI = featureURI;
		featureURI = newFeatureURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventManagerPackage.NOTIFICATION_IDENTIFIER__FEATURE_URI, oldFeatureURI, featureURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Set<URI> getOldValueClassURIs() {
		return oldValueClassURIs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOldValueClassURIs(Set<URI> newOldValueClassURIs) {
		Set<URI> oldOldValueClassURIs = oldValueClassURIs;
		oldValueClassURIs = newOldValueClassURIs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventManagerPackage.NOTIFICATION_IDENTIFIER__OLD_VALUE_CLASS_UR_IS, oldOldValueClassURIs, oldValueClassURIs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Set<URI> getNewValueClassURIs() {
		return newValueClassURIs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewValueClassURIs(Set<URI> newNewValueClassURIs) {
		Set<URI> oldNewValueClassURIs = newValueClassURIs;
		newValueClassURIs = newNewValueClassURIs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventManagerPackage.NOTIFICATION_IDENTIFIER__NEW_VALUE_CLASS_UR_IS, oldNewValueClassURIs, newValueClassURIs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTouch() {
		return touch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTouch(boolean newTouch) {
		boolean oldTouch = touch;
		touch = newTouch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventManagerPackage.NOTIFICATION_IDENTIFIER__TOUCH, oldTouch, touch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReset() {
		return reset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReset(boolean newReset) {
		boolean oldReset = reset;
		reset = newReset;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventManagerPackage.NOTIFICATION_IDENTIFIER__RESET, oldReset, reset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isContainment() {
		return containment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainment(boolean newContainment) {
		boolean oldContainment = containment;
		containment = newContainment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventManagerPackage.NOTIFICATION_IDENTIFIER__CONTAINMENT, oldContainment, containment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getHash() {
		return hashCode();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public NotificationIdentifier clone() {
		NotificationIdentifier clone = EventManagerFactory.eINSTANCE.createNotificationIdentifier();
		clone.getNewValueClassURIs().addAll(getNewValueClassURIs());
		clone.getOldValueClassURIs().addAll(getOldValueClassURIs());
		clone.setEventType(getEventType());
		clone.setFeatureURI(getFeatureURI());
		clone.setNotifierClassURI(getNotifierClassURI());
		clone.setReset(isReset());
		clone.setTouch(isTouch());
		clone.setContainment(isContainment());
		return clone;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (containment ? 1231 : 1237);
		result = prime * result + eventType;
		result = prime * result
				+ ((featureURI == null) ? 0 : featureURI.hashCode());
		result = prime
				* result
				+ ((newValueClassURIs == null) ? 0 : newValueClassURIs
						.hashCode());
		result = prime
				* result
				+ ((notifierClassURI == null) ? 0 : notifierClassURI.hashCode());
		result = prime
				* result
				+ ((oldValueClassURIs == null) ? 0 : oldValueClassURIs
						.hashCode());
		result = prime * result + (reset ? 1231 : 1237);
		result = prime * result + (touch ? 1231 : 1237);
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotificationIdentifierImpl other = (NotificationIdentifierImpl) obj;
		if (containment != other.containment)
			return false;
		if (eventType != other.eventType)
			return false;
		if (featureURI == null) {
			if (other.featureURI != null)
				return false;
		} else if (!featureURI.equals(other.featureURI))
			return false;
		if (newValueClassURIs == null) {
			if (other.newValueClassURIs != null)
				return false;
		} else if (!newValueClassURIs.equals(other.newValueClassURIs))
			return false;
		if (notifierClassURI == null) {
			if (other.notifierClassURI != null)
				return false;
		} else if (!notifierClassURI.equals(other.notifierClassURI))
			return false;
		if (oldValueClassURIs == null) {
			if (other.oldValueClassURIs != null)
				return false;
		} else if (!oldValueClassURIs.equals(other.oldValueClassURIs))
			return false;
		if (reset != other.reset)
			return false;
		if (touch != other.touch)
			return false;
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EventManagerPackage.NOTIFICATION_IDENTIFIER__NOTIFIER_CLASS_URI:
				return getNotifierClassURI();
			case EventManagerPackage.NOTIFICATION_IDENTIFIER__EVENT_TYPE:
				return getEventType();
			case EventManagerPackage.NOTIFICATION_IDENTIFIER__FEATURE_URI:
				return getFeatureURI();
			case EventManagerPackage.NOTIFICATION_IDENTIFIER__OLD_VALUE_CLASS_UR_IS:
				return getOldValueClassURIs();
			case EventManagerPackage.NOTIFICATION_IDENTIFIER__NEW_VALUE_CLASS_UR_IS:
				return getNewValueClassURIs();
			case EventManagerPackage.NOTIFICATION_IDENTIFIER__TOUCH:
				return isTouch();
			case EventManagerPackage.NOTIFICATION_IDENTIFIER__RESET:
				return isReset();
			case EventManagerPackage.NOTIFICATION_IDENTIFIER__CONTAINMENT:
				return isContainment();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EventManagerPackage.NOTIFICATION_IDENTIFIER__NOTIFIER_CLASS_URI:
				setNotifierClassURI((URI)newValue);
				return;
			case EventManagerPackage.NOTIFICATION_IDENTIFIER__EVENT_TYPE:
				setEventType((Integer)newValue);
				return;
			case EventManagerPackage.NOTIFICATION_IDENTIFIER__FEATURE_URI:
				setFeatureURI((URI)newValue);
				return;
			case EventManagerPackage.NOTIFICATION_IDENTIFIER__OLD_VALUE_CLASS_UR_IS:
				setOldValueClassURIs((Set<URI>)newValue);
				return;
			case EventManagerPackage.NOTIFICATION_IDENTIFIER__NEW_VALUE_CLASS_UR_IS:
				setNewValueClassURIs((Set<URI>)newValue);
				return;
			case EventManagerPackage.NOTIFICATION_IDENTIFIER__TOUCH:
				setTouch((Boolean)newValue);
				return;
			case EventManagerPackage.NOTIFICATION_IDENTIFIER__RESET:
				setReset((Boolean)newValue);
				return;
			case EventManagerPackage.NOTIFICATION_IDENTIFIER__CONTAINMENT:
				setContainment((Boolean)newValue);
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
			case EventManagerPackage.NOTIFICATION_IDENTIFIER__NOTIFIER_CLASS_URI:
				setNotifierClassURI(NOTIFIER_CLASS_URI_EDEFAULT);
				return;
			case EventManagerPackage.NOTIFICATION_IDENTIFIER__EVENT_TYPE:
				setEventType(EVENT_TYPE_EDEFAULT);
				return;
			case EventManagerPackage.NOTIFICATION_IDENTIFIER__FEATURE_URI:
				setFeatureURI(FEATURE_URI_EDEFAULT);
				return;
			case EventManagerPackage.NOTIFICATION_IDENTIFIER__OLD_VALUE_CLASS_UR_IS:
				setOldValueClassURIs((Set<URI>)null);
				return;
			case EventManagerPackage.NOTIFICATION_IDENTIFIER__NEW_VALUE_CLASS_UR_IS:
				setNewValueClassURIs((Set<URI>)null);
				return;
			case EventManagerPackage.NOTIFICATION_IDENTIFIER__TOUCH:
				setTouch(TOUCH_EDEFAULT);
				return;
			case EventManagerPackage.NOTIFICATION_IDENTIFIER__RESET:
				setReset(RESET_EDEFAULT);
				return;
			case EventManagerPackage.NOTIFICATION_IDENTIFIER__CONTAINMENT:
				setContainment(CONTAINMENT_EDEFAULT);
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
			case EventManagerPackage.NOTIFICATION_IDENTIFIER__NOTIFIER_CLASS_URI:
				return NOTIFIER_CLASS_URI_EDEFAULT == null ? notifierClassURI != null : !NOTIFIER_CLASS_URI_EDEFAULT.equals(notifierClassURI);
			case EventManagerPackage.NOTIFICATION_IDENTIFIER__EVENT_TYPE:
				return eventType != EVENT_TYPE_EDEFAULT;
			case EventManagerPackage.NOTIFICATION_IDENTIFIER__FEATURE_URI:
				return FEATURE_URI_EDEFAULT == null ? featureURI != null : !FEATURE_URI_EDEFAULT.equals(featureURI);
			case EventManagerPackage.NOTIFICATION_IDENTIFIER__OLD_VALUE_CLASS_UR_IS:
				return oldValueClassURIs != null;
			case EventManagerPackage.NOTIFICATION_IDENTIFIER__NEW_VALUE_CLASS_UR_IS:
				return newValueClassURIs != null;
			case EventManagerPackage.NOTIFICATION_IDENTIFIER__TOUCH:
				return touch != TOUCH_EDEFAULT;
			case EventManagerPackage.NOTIFICATION_IDENTIFIER__RESET:
				return reset != RESET_EDEFAULT;
			case EventManagerPackage.NOTIFICATION_IDENTIFIER__CONTAINMENT:
				return containment != CONTAINMENT_EDEFAULT;
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
		result.append(" (notifierClassURI: ");
		result.append(notifierClassURI);
		result.append(", eventType: ");
		result.append(eventType);
		result.append(", featureURI: ");
		result.append(featureURI);
		result.append(", oldValueClassURIs: ");
		result.append(oldValueClassURIs);
		result.append(", newValueClassURIs: ");
		result.append(newValueClassURIs);
		result.append(", touch: ");
		result.append(touch);
		result.append(", reset: ");
		result.append(reset);
		result.append(", containment: ");
		result.append(containment);
		result.append(')');
		return result.toString();
	}

} //NotificationIdentifierImpl
