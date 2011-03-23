/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.eventmanager.filters;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

/**
 * Matches an {@link Notification#getEventType() event type}
 * the constants are defined in {@link Notifier}
 * @author Philipp Berger
 *
 */
public class EventTypeFilter extends EventFilter {
    private final int eventType;

    /**
     * Creates a new {@link EventTypeFilter} with the given filter type.
     * For the different types {@see Notifier}
     * @param eventType
     * @param negated defines whether the filter is negated
     */
    public EventTypeFilter(int eventType, boolean negated) {
        super(negated);
        this.eventType = eventType;
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

    /**
     * Gives the event type of this filter object
     * @return an integer representing the event type
     */
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
    	String result;
        switch (getEventType()) {
        case 0:
            result = "filter CREATE";

        case 1:
            result = "filter SET";

        case 2:
            result = "filter UNSET";

        case 3:
            result = "filter ADD";

        case 4:
            result = "filter REMOVE";

        case 5:
            result = "filter ADD_MANY";

        case 6:
            result = "filter REMOVE_MANY";

        case 7:
            result = "filter MOVE";

        case 8:
            result = "filter REMOVING_ADAPTER";

        case 9:
            result = "filter RESOLVE";
        }

        result = "filter undefined";
        return (isNegated()?"negated ":"") + result;
    }

    @Override
    public EventTypeFilter clone() {
        return new EventTypeFilter(getEventType(), isNegated());

    }

    @Override
    public Object getFilterCriterion() {
        return getEventType();
    }
} // EventTypeFilterImpl
