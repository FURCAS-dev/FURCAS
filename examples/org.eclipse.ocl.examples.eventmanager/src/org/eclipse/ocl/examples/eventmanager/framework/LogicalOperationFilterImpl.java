/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.eventmanager.framework;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.ocl.examples.eventmanager.EventFilter;
import org.eclipse.ocl.examples.eventmanager.filters.AbstractEventFilter;
import org.eclipse.ocl.examples.eventmanager.filters.LogicalOperationFilter;


/**
 * Is the basis for any {@link LogicalOperationFilter} implementation.
 * Contains a set of {@link EventFilter filters} and offers package intern methods to modify this set
 * @author Philipp Berger
 *
 */
abstract public class LogicalOperationFilterImpl extends AbstractEventFilter implements LogicalOperationFilter {
    private Set<EventFilter> filters = new HashSet<EventFilter>();

    /**
     * Returns a  {@link Collections#unmodifiableSet(Set) read-only collection} containing the filters
     */
    public Set<EventFilter> getOperands() {
        return Collections.unmodifiableSet(filters);
    }
    
    /**
     * {@link Set#clear() Clears} the {@link #getOperands() operands}
     */
    protected void clearOperands() {
        filters.clear();
    }
    
    /**
     * {@link Set#add(Object) Adds} an {@link EventFilter filter} to 
     * the {@link #getOperands() operands}
     * @param filter to add
     */
    protected void addOperand(EventFilter filter) {
        filters.add(filter);
    }

    /**
     * {@link Set#addAll(Collection)Adds}  a {@link Collection collection} of {@link EventFilter filters} to 
     * the {@link #getOperands() operands}
     * @param filters to add
     */
    protected void addOperands(Collection<EventFilter> filters) {
        this.filters.addAll(filters);
    }

    /**
     * Creates a new Array with {@link EventFilter#clone() clone} 
     * for each contained {@link #getOperands() operand}
     * @return the array of clones
     */
    protected EventFilter[] cloneContents() {
        Set<EventFilter> clonedContent = new HashSet<EventFilter>();
        for(EventFilter filter : filters){
            clonedContent.add(filter.clone());
        }
        EventFilter[] cloned = clonedContent.toArray(new EventFilter[clonedContent.size()]);
        return cloned;
    }

    /**
     * Creates a filter containing the given {@link EventFilter filters} as {@link #getOperands() operands}
     * @param filters to be operands
     */
    public LogicalOperationFilterImpl(EventFilter... filters) {
        this.filters.addAll(Arrays.asList(filters));
    }
    /**
     * @return a modifiable {@link Set set} of {@link #getOperands()}  
     */
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
