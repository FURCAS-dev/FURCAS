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
package org.eclipse.ocl.examples.eventmanager.tests.filters;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.ocl.examples.eventmanager.filters.AbstractEventFilter;


final class FalseFilter extends AbstractEventFilter {
    FalseFilter() {
		super(false);
	}

    public boolean matchesFor(Notification event) {
        return false;
    }

    @Override
    public int hashCode() {
        return 3;

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        return true;
    }

    @Override
    public FalseFilter clone() {
        return new FalseFilter();
    }

    @Override
    public Object getFilterCriterion() {
        return false;
    }
}
