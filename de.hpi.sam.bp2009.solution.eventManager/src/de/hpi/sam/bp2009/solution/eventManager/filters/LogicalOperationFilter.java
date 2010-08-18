package de.hpi.sam.bp2009.solution.eventManager.filters;

import java.util.Set;

public interface LogicalOperationFilter {
    /**
     * Returns a read-only collection containing the filters
     */
    Set<EventFilter> getOperands();
}
