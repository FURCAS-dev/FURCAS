/*******************************************************************************
 * Copyright (c) 2010, 2011 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.eventmanager;

import org.eclipse.emf.common.notify.Notification;

/**
 * Represents a filter that can be applied to and
 * {@link #matchesFor(Notification) match} a {@link Notification}. Different
 * sorts of filters exist. They can be constructed using the factory methods of
 * {@link EventManagerFactory}, such as
 * {@link EventManagerFactory#createClassFilter(org.eclipse.emf.ecore.EClass)}.<p>
 * 
 * @author Axel Uhl
 * 
 */
public interface EventFilter {
    /**
     * Tests if the incoming {@link Notification} matches the intern specification
     * @param event the {@link Notification} to control
     * @return whether the given {@link Notification} matches the intern specification
     */
    boolean matchesFor(Notification event);

	/**
	 * Returns whether the filter is negated. If the filter is negated it will
	 * match every {@link Notification} which is not matching this filter's
	 * regular specification.
	 * 
	 * @return <code>true</code> if the filter is negated
	 */
    boolean isNegated();

	/**
	 * Returns the unique property for which this filter looks in a
	 * {@link Notification}.
	 */
    Object getFilterCriterion();

    EventFilter clone();
}
