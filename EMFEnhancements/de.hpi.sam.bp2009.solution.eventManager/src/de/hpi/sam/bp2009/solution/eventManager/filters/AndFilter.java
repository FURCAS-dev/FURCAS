/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.filters;

import org.eclipse.emf.common.notify.Notification;

import de.hpi.sam.bp2009.solution.eventManager.framework.LogicalOperationFilterImpl;

public class AndFilter extends LogicalOperationFilterImpl {


    public AndFilter() {
        super();
    }
    public AndFilter(EventFilter... newFilters) {
        super(newFilters);
    }


    public boolean matchesFor(Notification event) {
        for (EventFilter operator : this.getOperands()) {
            if (!(operator.matchesFor(event)))
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder bld = new StringBuilder();
        boolean first = true;

        for (EventFilter f : getOperands()) {

            if (!first) {
                bld.append("\n AND ");
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
    public LogicalOperationFilterImpl clone(){
        return new AndFilter(cloneContents());
        
    }
} // AndFilterImpl
