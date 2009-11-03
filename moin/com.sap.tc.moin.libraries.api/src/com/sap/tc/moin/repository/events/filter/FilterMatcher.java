package com.sap.tc.moin.repository.events.filter;

import com.sap.tc.moin.repository.events.type.ChangeEvent;

/**
 * A FilterMatcher provides the ability to specify if an {@link EventFilter}
 * matches an event. MOIN provides default implementations for all MOIN
 * EventFilers. <br>
 * FilterMatchers can override the default matchers for existing Filter.<br>
 * FilterMatchers can also be used for custom (i.e. non-MOIN) filters.
 * 
 * @author d024032
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface FilterMatcher {

    /**
     * @param event the event that shall be checked if it matches the filter
     * @param filter the filter that shall be checked if it matches the event
     * @return <code>true</code> if the filter and the event match.
     */
    boolean matchesForFilterType( ChangeEvent event, EventFilter filter );
}
