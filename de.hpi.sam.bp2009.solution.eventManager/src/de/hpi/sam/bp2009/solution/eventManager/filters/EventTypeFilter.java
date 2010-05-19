/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.filters;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier;

public class EventTypeFilter extends EventFilter {

    protected static final Notification MATCHING_NOTIFICATION_EDEFAULT = null;

    protected Notification matchingNotification = MATCHING_NOTIFICATION_EDEFAULT;

    protected static final Integer EVENT_TYPE_EDEFAULT = null;

    protected Integer eventType = EVENT_TYPE_EDEFAULT;

    public EventTypeFilter() {
        super();
    }

    public EventTypeFilter(Integer eventType2) {
        super();
        setEventType(eventType2);
    }

    public EList<NotificationIdentifier> buildNotificationIdentifiers(NotificationIdentifier identifier) {
        EList<NotificationIdentifier> result = new BasicEList<NotificationIdentifier>();
        result.add(identifier);
        identifier.setEventType(getEventType());
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
        EventTypeFilter other = (EventTypeFilter) obj;
        if (eventType == null) {
            if (other.eventType != null)
                return false;
        } else if (!eventType.equals(other.eventType))
            return false;
        return true;
    }

    public Integer getEventType() {
        return eventType;
    }

    public Notification getMatchingNotification() {
        return matchingNotification;
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
        result = prime * result + ((eventType == null) ? 0 : eventType.hashCode());
        return result;
    }

    public boolean matchesFor(Notification event) {
        return event.getEventType() == getEventType();
    }

    public void setEventType(Integer newEventType) {
        eventType = newEventType;
    }

    public void setMatchingNotification(Notification newMatchingNotification) {
        matchingNotification = newMatchingNotification;
    }

    @Override
    public String toString() {
        switch (getEventType()) {
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
    @Override
    public EventTypeFilter clone(){
        return new EventTypeFilter(getEventType());
        
    }
    @Override
    public Object getFilterCriterion() {
        return getEventType();
    }
} // EventTypeFilterImpl
