/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;

public class NotificationIdentifier {
    protected URI notifierClassURI = null;

    protected static final int EVENT_TYPE_EDEFAULT = 0;

    protected int eventType = EVENT_TYPE_EDEFAULT;

    protected URI featureURI = null;

    protected Set<URI> oldValueClassURIs = new HashSet<URI>();
    protected Set<URI> newValueClassURIs = new HashSet<URI>();
    protected boolean touch = false;
    protected boolean reset = false;
    protected boolean containment = false;

    protected NotificationIdentifier() {
        super();
    }

    public URI getNotifierClassURI() {
        return notifierClassURI;
    }

    public void setNotifierClassURI(URI newNotifierClassURI) {
        notifierClassURI = newNotifierClassURI;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int newEventType) {
        eventType = newEventType;
    }

    public URI getFeatureURI() {
        return featureURI;
    }

    public void setFeatureURI(URI newFeatureURI) {
        featureURI = newFeatureURI;
    }

    public Set<URI> getOldValueClassURIs() {
        return oldValueClassURIs;
    }

    public void setOldValueClassURIs(Set<URI> newOldValueClassURIs) {
        oldValueClassURIs = newOldValueClassURIs;
    }

    public Set<URI> getNewValueClassURIs() {
        return newValueClassURIs;
    }

    public void setNewValueClassURIs(Set<URI> newNewValueClassURIs) {
        newValueClassURIs = newNewValueClassURIs;
    }

    public boolean isTouch() {
        return touch;
    }

    public void setTouch(boolean newTouch) {
        touch = newTouch;
    }

    public boolean isReset() {
        return reset;
    }

    public void setReset(boolean newReset) {
        reset = newReset;
    }

    public boolean isContainment() {
        return containment;
    }

    public void setContainment(boolean newContainment) {
        containment = newContainment;
    }

    public int getHash() {
        return hashCode();
    }

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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (containment ? 1231 : 1237);
        result = prime * result + eventType;
        result = prime * result + ((featureURI == null) ? 0 : featureURI.hashCode());
        result = prime * result + ((newValueClassURIs == null) ? 0 : newValueClassURIs.hashCode());
        result = prime * result + ((notifierClassURI == null) ? 0 : notifierClassURI.hashCode());
        result = prime * result + ((oldValueClassURIs == null) ? 0 : oldValueClassURIs.hashCode());
        result = prime * result + (reset ? 1231 : 1237);
        result = prime * result + (touch ? 1231 : 1237);
        return result;
    }

    /*
     * (non-Javadoc)
     * 
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
        NotificationIdentifier other = (NotificationIdentifier) obj;
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString() {
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

} // NotificationIdentifierImpl
