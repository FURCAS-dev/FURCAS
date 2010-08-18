package de.hpi.sam.bp2009.solution.eventManager.framework;

import org.eclipse.emf.common.notify.Notification;

import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;

public class NotFilter extends LogicalOperationFilterImpl {
    public NotFilter() {
        super();
    }

    public NotFilter(EventFilter subTypeFilterTree) {
        filters.add(subTypeFilterTree);
    }

    @Override
    public boolean matchesFor(Notification event) {
        if (filters.isEmpty())
            return true;
        return !(filters.iterator().next().matchesFor(event));

    }

    @Override
    public NotFilter clone() {
        return new NotFilter(cloneContents()[0]);

    }

}
