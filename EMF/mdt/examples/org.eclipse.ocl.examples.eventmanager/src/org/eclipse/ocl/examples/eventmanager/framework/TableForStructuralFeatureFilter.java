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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.eventmanager.filters.StructuralFeatureFilter;



/**
 * This filter table manages all Registrations containing {@link PropertyFilter}.
 * 
 * @see org.eclipse.ocl.examples.eventmanager.framework.TableForEventFilter.tc.moin.repository.events.framework.EventFilterTable
 * @author Daniel Vocke (D044825), Axel Uhl
 */
public class TableForStructuralFeatureFilter extends TableForEventFilter {

    public TableForStructuralFeatureFilter(int numberOfFilterTables) {
        super(numberOfFilterTables);
    }

    /**
     * @return the affected meta object of <code>AttributeValueEvents</code>. If the event is not of type
     * <code>AttributeValueEvent</code>, <code>null</code> is returned.
     */
    public Object getAffectedObject(Notification event) {
        if (isEmpty() || event.getFeature() == null) {
            return null;
        }
        //TODO check if source obj is the right one
        return event.getFeature();
    }

    @Override
    public Class<StructuralFeatureFilter> getIdentifier() {
        return StructuralFeatureFilter.class;
    }

    @Override
    protected String criterionToString(Object criterion) {
        return ((EStructuralFeature) criterion).getName();
    }
}
