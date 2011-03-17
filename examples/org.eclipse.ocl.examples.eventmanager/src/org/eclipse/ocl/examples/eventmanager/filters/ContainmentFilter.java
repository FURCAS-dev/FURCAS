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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.examples.eventmanager.framework.EventManagerTableBased;

/**
 * The Containment filter matches {@link Notification#getFeature()} is an {@link EReference} 
 * and {@link EReference#isContainment()} is true
 * or it matches if the {@link Notification#getNotifier()} is not an {@link EObject},
 * so it might be a {@link ResourceSet} or a {@link Resource}
 * @author Philipp Berger
 *
 */
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

    /**
     * This method will only returns true, the logic is moved to the {@link EventManagerTableBased}
     * @see org.eclipse.ocl.examples.eventmanager.filters.EventFilter#getFilterCriterion()
     */
    @Override
    public Object getFilterCriterion() {
        return true;
    }
} // ContainmentFilterImpl
