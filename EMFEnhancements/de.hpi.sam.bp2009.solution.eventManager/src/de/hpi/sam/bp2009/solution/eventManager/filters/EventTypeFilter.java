/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.filters;

import org.eclipse.emf.common.notify.Notification;

public class EventTypeFilter extends EventFilter {
    private final int eventType;

    public EventTypeFilter(int eventType2) {
        super();
        eventType = eventType2;
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
        if (eventType != other.eventType) {
            return false;
        }
        return isNegated() == ((EventFilter) other).isNegated();
    }

    public int getEventType() {
        return eventType;
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
        result = prime * result + eventType;
        if (isNegated()) {
            result = prime * result;
        }
        return result;
    }

    public boolean matchesFor(Notification event) {
        return event.getEventType() == getEventType();
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
    public EventTypeFilter clone() {
        return new EventTypeFilter(getEventType());

    }

    @Override
    public Object getFilterCriterion() {
        return getEventType();
    }
} // EventTypeFilterImpl