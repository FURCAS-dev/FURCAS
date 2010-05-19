package de.hpi.sam.bp2009.solution.eventManager.filters;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;

import de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier;

public class NotFilter extends LogicalOperationFilter {
    public NotFilter() {
        super();
    }
    public NotFilter(EventFilter subTypeFilterTree) {
        filters.add(subTypeFilterTree);
    }

    @Override
    public boolean matchesFor(Notification event) {
        if(filters.isEmpty())
            return true;
        return !(filters.iterator().next().matchesFor(event));

    }

    @Override
    public EList<NotificationIdentifier> buildNotificationIdentifiers(NotificationIdentifier identifier) {
        // TODO Auto-generated methodbuildNotificationIdentifiers stub
        System.out.println("buildNotificationIdentifiers");
        throw new UnsupportedOperationException("buildNotificationIdentifiers not yet implemented");

    }
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 47;
        int result = 1;
        result = prime * result + ((filters == null) ? 0 : filters.hashCode());
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
        LogicalOperationFilter other = (LogicalOperationFilter) obj;
        if (filters == null) {
            if (other.filters != null)
                return false;
        } else if (!filters.equals(other.filters))
            return false;
        return true;
    }
    
    @Override
    public NotFilter clone(){
        return new NotFilter(cloneContents()[0]);
        
    }

}
