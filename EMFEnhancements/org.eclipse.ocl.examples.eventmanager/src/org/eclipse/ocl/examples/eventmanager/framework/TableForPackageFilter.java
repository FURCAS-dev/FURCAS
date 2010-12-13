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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.eventmanager.filters.PackageFilter;


/**
 * The PackageFilterTable manages all Registrations containing
 * {@link de.hpi.sam.bp2009.solution.eventManager.filters.sap.tc.moin.repository.events.filter.PackageFilter}.
 * 
 * @see org.eclipse.ocl.examples.eventmanager.framework.TableForEventFilter.tc.moin.repository.events.framework.EventFilterTable
 * @author Daniel Vocke (D044825)
 */
public class TableForPackageFilter extends TableForEventFilter {

    public TableForPackageFilter(int numberOfFilterTables) {
        super(numberOfFilterTables);
    }

    /**
     * @return the MRI(s) of the package proxy of the affected elements. If the passed event is not of type
     *         <code>ModelChangeEvent</code> or no registrations are stored in this instance, null is returned.
     */
    public Object getAffectedObject(Notification event) {
        if (event.getNotifier() instanceof EObject) {
            return ((EObject) event.getNotifier()).eClass().getEPackage();
        }
        return null;
    }

    @Override
    public Class<PackageFilter> getIdentifier() {
        return PackageFilter.class;
    }

}
