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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.examples.eventmanager.filters.AssociationFilter;

/**
 * The AssociationFilterTable manages all Registrations containing
 * {@link de.hpi.sam.bp2009.solution.eventManager.filters.sap.tc.moin.repository.events.filter.AssociationFilter}.
 * 
 * @see org.eclipse.ocl.examples.eventmanager.framework.TableForEventFilter.tc.moin.repository.events.framework.EventFilterTable
 * @author Daniel Vocke (D044825)
 */
public class TableForAssociationFilter extends TableForEventFilter {

    public TableForAssociationFilter(int numberOfFilterTables) {
        super(numberOfFilterTables);
    }

    /**
     * @return the affected meta object of <code>LinkChangedEvents</code>. If the event is not of type
     * <code>LinkChangeEvent</code>, <code>null</code> is returned.
     */
    public Object getAffectedObject(Notification event) {

        if (isEmpty() || !(event.getFeature()!=null && event.getFeature() instanceof EReference))
            return null;
        return event.getFeature();
    }

    @Override
    public Class<AssociationFilter> getIdentifier() {
        return AssociationFilter.class;
    }
    
    @Override
    protected String criterionToString(Object criterion) {
        return ((EReference) criterion).getName();
    }

}
