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
import org.eclipse.ocl.examples.eventmanager.EventManager;

/**
 * An EventFilter matches a given specification for the properties 
 * of a {@link Notification} against an incoming {@link Notification}.
 * It is used to pass a {@link Notification} specification to an {@link EventManager}
 * @author Philipp Berger
 *
 */
public abstract class EventFilter {

    private boolean negated;

    /**
     * default constructor
     * @param negated defines whether the filter is negated
     */
    public EventFilter(boolean negated) {
        super();
        this.negated = negated;
    }

    /**
     * Tests if the incoming {@link Notification} matches the intern specification
     * @param event the {@link Notification} to control
     * @return whether the given {@link Notification} matches the intern specification
     */
    abstract public boolean matchesFor(Notification event);

    public abstract int hashCode();

    public abstract boolean equals(Object obj);

    /**
     * Returns the unique property for an {@link EventFilter} object
     * @return
     */
    public abstract Object getFilterCriterion();

    /**
     * Returns whether the filter is negated
     * if the filter is negated it will match every {@link Notification} 
     * which is not matching the intern specification
     * @return true if the filter is negated
     */
    public boolean isNegated() {
        return negated;

    }
    /* (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    public abstract EventFilter clone() ;

    /**
     * Sets whether this filter is negated
     * if the filter is negated it will match every {@link Notification} 
     * which is not matching the intern specification
     * @param b true for negating the filter, false for not
     */
    public void setNegated(boolean b) {
        negated = b;
        
    }


} // EventFilterImpl
