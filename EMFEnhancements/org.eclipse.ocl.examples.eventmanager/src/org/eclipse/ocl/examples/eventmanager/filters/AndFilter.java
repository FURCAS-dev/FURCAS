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
package org.eclipse.ocl.examples.eventmanager.filters;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.ocl.examples.eventmanager.framework.LogicalOperationFilterImpl;


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
