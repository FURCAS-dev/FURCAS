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

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.ocl.examples.eventmanager.filters.EventTypeFilter;


/**
 * The EventTypeFilterTable manages all Registrations containing {@link de.hpi.sam.bp2009.solution.eventManager.filters.sap.tc.moin.repository.events.filter.EventTypeFilter}.
 * 
 * @see org.eclipse.ocl.examples.eventmanager.framework.TableForEventFilter.tc.moin.repository.events.framework.EventFilterTable
 * @author Daniel Vocke (D044825)
 */
public class TableForEventTypeFilter extends TableForEventFilter {

    public TableForEventTypeFilter(int numberOfFilterTables) {
        super(numberOfFilterTables);
    }
    /**
     * @param event the affected event
     * @return returns a {@link List}of {@link Class Interfaces}which contains all implemented <code>Interfaces</code>
     * of the event and all of its super types.
     */
    public Object getAffectedObject(Notification event) {

        if (isEmpty())
            return null; // the affected object is not needed in this case

        Collection<Integer> result = new HashSet<Integer>(16);
        result.add(event.getEventType());


        return result;
    }

    @Override
    public Class<EventTypeFilter> getIdentifier() {
        return EventTypeFilter.class;
    }

}
