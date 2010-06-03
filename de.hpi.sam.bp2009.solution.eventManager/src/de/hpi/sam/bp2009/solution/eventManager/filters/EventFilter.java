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

public abstract class EventFilter {

    private boolean negated = false;

    public EventFilter() {
        super();
    }

    abstract public boolean matchesFor(Notification event);

    public abstract EList<NotificationIdentifier> buildNotificationIdentifiers(NotificationIdentifier identifier);

    protected EList<NotificationIdentifier> getEListForNotificationIdentifier(NotificationIdentifier identifier) {
        EList<NotificationIdentifier> result = new BasicEList<NotificationIdentifier>();
        result.add(identifier);
        return result;
    }

    public abstract int hashCode();

    public abstract boolean equals(Object obj);

    public abstract Object getFilterCriterion();

    public boolean isNegated() {
        return negated;

    }
    public abstract EventFilter clone() ;

    public void setNegated(boolean b) {
        negated = b;
        
    }


} // EventFilterImpl
