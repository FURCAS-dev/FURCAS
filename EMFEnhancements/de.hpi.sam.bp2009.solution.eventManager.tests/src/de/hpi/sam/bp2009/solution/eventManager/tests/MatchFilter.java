package de.hpi.sam.bp2009.solution.eventManager.tests;

import org.eclipse.emf.common.notify.Notification;

import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;

final class MatchFilter extends EventFilter {
    /**
     * 
     */
    private final EventManagerTest eventManagerTest;

    /**
     * @param eventManagerTest
     */
    MatchFilter(EventManagerTest eventManagerTest) {
        this.eventManagerTest = eventManagerTest;
    }

    @Override
    public boolean matchesFor(Notification event) {	
        return this.eventManagerTest.matchingNotification.equals(event);}

    int hash =new Double(Math.random()).intValue();
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((eventManagerTest == null) ? 0 : eventManagerTest.hashCode());
        result = prime * result + hash;
        if (isNegated()) {
            result = prime * result;
        }
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
        MatchFilter other = (MatchFilter) obj;
        if (eventManagerTest == null) {
            if (other.eventManagerTest != null)
                return false;
        } else if (!eventManagerTest.equals(other.eventManagerTest))
            return false;
        if (hash != other.hash)
            return false;
        return isNegated() == ((EventFilter) other).isNegated();
    }

    @Override
    public EventFilter clone() {
        return new MatchFilter(eventManagerTest);
        
    }

    @Override
    public Object getFilterCriterion() {
        return null;
        
    }
}