package de.hpi.sam.bp2009.solution.eventManager.filters;

import org.eclipse.emf.common.notify.Notification;

import de.hpi.sam.bp2009.solution.eventManager.framework.LogicalOperationFilterImpl;

public class NotFilter extends LogicalOperationFilterImpl {
    public NotFilter() {
        super();
    }

    public NotFilter(EventFilter subTypeFilterTree) {
        super(subTypeFilterTree);
    }

    @Override
    public boolean matchesFor(Notification event) {
        if (getOperands().isEmpty())
            return true;
        return !(getOperands().iterator().next().matchesFor(event));

    }

    @Override
    public NotFilter clone() {
        return new NotFilter(cloneContents()[0]);

    }

}
