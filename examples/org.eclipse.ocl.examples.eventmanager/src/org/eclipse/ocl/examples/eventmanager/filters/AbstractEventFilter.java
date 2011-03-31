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

import java.util.Collection;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.ocl.examples.eventmanager.EventFilter;
import org.eclipse.ocl.examples.eventmanager.EventManager;

/**
 * An EventFilter matches a given specification for the properties 
 * of a {@link Notification} against an incoming {@link Notification}.
 * It is used to pass a {@link Notification} specification to an {@link EventManager}
 * 
 * @author Philipp Berger, Axel Uhl
 *
 */
public abstract class AbstractEventFilter implements EventFilter {

    private boolean negated;

    /**
     * default constructor
     * @param negated defines whether the filter is negated
     */
    public AbstractEventFilter(boolean negated) {
        super();
        this.negated = negated;
    }

    public abstract int hashCode();

    public abstract boolean equals(Object obj);

    /**
     * Returns the unique property for an {@link AbstractEventFilter} object
     * @return
     */
    public abstract Object getFilterCriterion();

	/**
	 * Returns whether the filter is negated. If the filter is negated it will
	 * match every {@link Notification} which is not matching this filter's
	 * regular specification.
	 * 
	 * @return <code>true</code> if the filter is negated
	 */
    public boolean isNegated() {
        return negated;

    }
    /* (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    public abstract AbstractEventFilter clone() ;

    /**
     * Sets whether this filter is negated
     * if the filter is negated it will match every {@link Notification} 
     * which is not matching the intern specification
     * @param b true for negating the filter, false for not
     */
    public void setNegated(boolean b) {
        negated = b;
    }
    
    /**
     * If any of <code>n.</code>{@link Notification#getOldValue() getOldValue()} and
     * <code>n.</code>{@link Notification#getNewValue() getNewValue()} is a collection
     * with more than one element, the notification is expanded into one notification
     * per element in the collection. If both, <code>oldValue</code> and <code>newValue</code>
     * are collections with more than one element, all combinations are produced.
     */
    protected Set<Notification> expandNewAndOldValueCollections(Notification n) {
    	Set<Notification> result = null;
    	if (n.getOldValue() instanceof Collection<?> && ((Collection<?>) n.getOldValue()).size()>1) {
//    		if ()
//    		for ()
    	}
    	return result;
    }

} // EventFilterImpl
