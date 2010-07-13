/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.filters;

import org.eclipse.emf.common.notify.Notification;

public class OrFilter extends LogicalOperationFilter {

    public OrFilter() {
        super();
    }

    public OrFilter(EventFilter... newFilters) {
        super(newFilters);
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
        return isNegated() == ((EventFilter) other).isNegated();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 29;
        int result = 1;
        result = prime * result + ((filters == null) ? 0 : filters.hashCode());
        if (isNegated()) {
            result = prime * result;
        }
        return result;
    }

    public boolean matchesFor(Notification event) {

        for (EventFilter otherFilter : getOperands()) {
            if (otherFilter.matchesFor(event))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder bld = new StringBuilder();
        boolean first = true;

        for (EventFilter f : getOperands()) {
            if (!first) {
                bld.append("\n OR ");
            } else {
                first = false;
            }
            bld.append("(");
            bld.append(f.toString());
            bld.append(")");
        }

        return bld.toString();
    }

    @Override
    public OrFilter clone() {
        return new OrFilter(cloneContents());

    }

} // OrFilterImpl
