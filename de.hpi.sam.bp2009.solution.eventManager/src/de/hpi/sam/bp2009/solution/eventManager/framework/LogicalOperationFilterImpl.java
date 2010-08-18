package de.hpi.sam.bp2009.solution.eventManager.framework;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.LogicalOperationFilter;

abstract public class LogicalOperationFilterImpl extends EventFilter implements LogicalOperationFilter {
    Set<EventFilter> filters = new HashSet<EventFilter>();

    /**
     * Returns a read-only collection containing the filters
     */
    @Override
    public Set<EventFilter> getOperands() {
        return Collections.unmodifiableSet(filters);
    }
    
    protected void clearOperands() {
        filters.clear();
    }
    
    protected void addOperand(EventFilter filter) {
        filters.add(filter);
    }

    protected void addOperands(Collection<EventFilter> filters) {
        this.filters.addAll(filters);
    }

    protected EventFilter[] cloneContents() {
        Set<EventFilter> clonedContent = new HashSet<EventFilter>();
        for(EventFilter filter : filters){
            clonedContent.add(filter.clone());
        }
        EventFilter[] cloned = clonedContent.toArray(new EventFilter[clonedContent.size()]);
        return cloned;
    }

    public LogicalOperationFilterImpl(EventFilter... newFilters) {
        filters.addAll(Arrays.asList(newFilters));
    }
    @Override
    public Object getFilterCriterion() {
        Set<Object> result = new HashSet<Object>();
        for(EventFilter f: getOperands()){
            result.add(f.getFilterCriterion());
        }
        return result;
        
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LogicalOperationFilterImpl other = (LogicalOperationFilterImpl) obj;
        if (filters == null) {
            if (other.filters != null)
                return false;
        } else if (!filters.equals(other.filters))
            return false;
        return isNegated() == ((EventFilter) other).isNegated();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((filters == null) ? 0 : filters.hashCode());
        if (isNegated()) {
            result = prime * result;
        }
        return result;
    }
}
