package de.hpi.sam.bp2009.solution.eventManager.framework;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;

/**
 * The EventTypeFilterTable manages all Registrations containing {@link de.hpi.sam.bp2009.solution.eventManager.filters.sap.tc.moin.repository.events.filter.EventTypeFilter}.
 * 
 * @see de.hpi.sam.bp2009.solution.eventManager.framework.TableForEventFilter.tc.moin.repository.events.framework.EventFilterTable
 * @author Daniel Vocke (D044825)
 */
public class TableForEventTypeFilter extends TableForEventFilter {

    public TableForEventTypeFilter() {
    }
    /**
     * @param event the affected event
     * @return returns a {@link List}of {@link Class Interfaces}which contains all implemented <code>Interfaces</code>
     * of the event and all of its super types.
     */
    public Object getAffectedObject(Notification event) {

        if (isEmpty())
            return null; // the affected object is not needed in this case

        Collection<Integer> result = new HashSet<Integer>(16);
        result.add(event.getEventType());


        return result;
    }

    @Override
    public Object getIdentifier() {
        return de.hpi.sam.bp2009.solution.eventManager.filters.EventTypeFilter.class;
    }

    
}