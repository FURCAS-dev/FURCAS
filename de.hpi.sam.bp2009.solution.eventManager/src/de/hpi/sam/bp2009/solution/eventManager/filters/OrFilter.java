/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.filters;

import org.eclipse.emf.common.notify.Notification;

import de.hpi.sam.bp2009.solution.eventManager.framework.LogicalOperationFilterImpl;

public class OrFilter extends LogicalOperationFilterImpl {

    public OrFilter() {
        super();
    }

    public OrFilter(EventFilter... newFilters) {
        super(newFilters);
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
