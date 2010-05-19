package de.hpi.sam.bp2009.solution.eventManager.filters;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

abstract public class LogicalOperationFilter extends EventFilter {
    Set<EventFilter> filters = new HashSet<EventFilter>();

    public Set<EventFilter> getOperands() {
        return filters;
    }

    protected EventFilter[] cloneContents() {
        Set<EventFilter> clonedContent = new HashSet<EventFilter>();
        for(EventFilter filter : filters){
            clonedContent.add(filter.clone());
        }
        EventFilter[] cloned = clonedContent.toArray(new EventFilter[clonedContent.size()]);
        return cloned;
    }

    public LogicalOperationFilter(EventFilter... newFilters) {
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
}
