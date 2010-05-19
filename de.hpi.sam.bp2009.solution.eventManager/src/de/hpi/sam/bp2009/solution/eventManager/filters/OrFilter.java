/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.filters;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier;

public class OrFilter extends LogicalOperationFilter {

    public OrFilter() {
        super();
    }
    public OrFilter(EventFilter... newFilters) {
        super(newFilters);
    }

    public EList<NotificationIdentifier> buildNotificationIdentifiers(NotificationIdentifier identifier) {
        Set<NotificationIdentifier> result = new HashSet<NotificationIdentifier>();
        for (EventFilter f : getOperands()) {
            result.addAll(f.buildNotificationIdentifiers(identifier.clone()));
        }
        EList<NotificationIdentifier> notiResult = new BasicEList<NotificationIdentifier>();
        for (NotificationIdentifier i : result) {
            notiResult.add(i);
        }
        return notiResult;
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
        LogicalOperationFilter other = (LogicalOperationFilter) obj;
        if (filters == null) {
            if (other.filters != null)
                return false;
        } else if (!filters.equals(other.filters))
            return false;
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 29;
        int result = 1;
        result = prime * result + ((filters == null) ? 0 : filters.hashCode());
        return result;
    }

    public boolean matchesFor(Notification event) {

        for (EventFilter otherFilter : getOperands()) {
            if (otherFilter.matchesFor(event))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder bld = new StringBuilder();
        boolean first = true;

        for (EventFilter f : getOperands()) {
            if (!first) {
                bld.append("\n OR ");
            } else {
                first = false;
            }
            bld.append("(");
            bld.append(f.toString());
            bld.append(")");
        }

        return bld.toString();
    }
    @Override
    public OrFilter clone(){
        return new OrFilter( cloneContents());
        
    }

} // OrFilterImpl
