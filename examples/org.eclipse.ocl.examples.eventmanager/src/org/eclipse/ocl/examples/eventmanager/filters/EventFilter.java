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

public abstract class EventFilter {

    private boolean negated = false;

    public EventFilter() {
        super();
    }

    abstract public boolean matchesFor(Notification event);

    public abstract int hashCode();

    public abstract boolean equals(Object obj);

    public abstract Object getFilterCriterion();

    public boolean isNegated() {
        return negated;

    }
    public abstract EventFilter clone() ;

    public void setNegated(boolean b) {
        negated = b;
        
    }


} // EventFilterImpl
