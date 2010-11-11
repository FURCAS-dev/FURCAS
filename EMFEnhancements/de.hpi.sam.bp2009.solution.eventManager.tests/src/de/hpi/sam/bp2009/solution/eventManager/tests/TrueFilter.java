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
package de.hpi.sam.bp2009.solution.eventManager.tests;

import org.eclipse.emf.common.notify.Notification;

import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;

final class TrueFilter extends EventFilter {
    @Override
    public boolean matchesFor(Notification event) {
        return true;

    }

    @Override
    public int hashCode() {

        return 2;

    }

    @Override
    public boolean equals(Object obj) {
        return false;

    }

    @Override
    public EventFilter clone() {
        return new TrueFilter();
        
    }

    @Override
    public Object getFilterCriterion() {
        return true;
        
    }
}
