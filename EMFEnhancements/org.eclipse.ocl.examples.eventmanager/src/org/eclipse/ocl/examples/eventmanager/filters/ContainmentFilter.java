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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public class ContainmentFilter extends EventFilter {

    private ContainmentFilter() {
        super();
    }

    static final public ContainmentFilter INSTANCE = new ContainmentFilter();

    @Override
    public boolean matchesFor(Notification event) {
        if (event.getFeature() instanceof EReference) {
            return ((EReference) event.getFeature()).isContainment();
        } else if (!(event.getNotifier() instanceof EObject)) {
            return true;
        }
        return false;

    }

    @Override
    public int hashCode() {
        return "ContainmentFilterImpl".hashCode() + 31*(isNegated() ? 43 : 0);

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        return isNegated() == ((EventFilter) obj).isNegated();
    }

    @Override
    public ContainmentFilter clone() {
        return INSTANCE;

    }

    @Override
    public Object getFilterCriterion() {
        return true;
    }
} // ContainmentFilterImpl
