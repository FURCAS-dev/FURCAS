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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * Matches an event's {@link Notification#getOldValue()} to an {@link EObject#eClass()}.
 * An exact match, not considering any inheritance relations, is required. If the
 * {@link Notification#getOldValue() new value} is a collection, e.g., because several
 * elements were removed from a many-feature at once, this filter matches if at least
 * one of the elements' class is matched.
 * 
 * @author Philipp Berger, Axel Uhl
 *
 */
public class OldValueClassFilter extends ClassFilter {

    public OldValueClassFilter(EClass clazz, boolean isNegated) {
        super(clazz, isNegated);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OldValueClassFilter other = (OldValueClassFilter) obj;
        return super.equals(other);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return 43 * super.hashCode();
    }

    public boolean matchesFor(Notification event) {
        if (event.getOldValue() == null) {
            return false;
        }
        if (event.getOldValue() instanceof EObject) {
            return matches(((EObject) event.getOldValue()).eClass());
        }
        if (event.getOldValue() instanceof EList<?>) {
            for (Object o : (EList<?>) event.getOldValue()) {
                if (o instanceof EObject && matches(((EObject) o).eClass())) {
                    return true;
                }
            }
            return false;
        }

        return false;
    }

    @Override
    public String toString() {
        if (getWantedClass() != null)
            return "old value filter for old " + getWantedClass().toString();
        return "old value filter for undefined old";
    }

    @Override
    public OldValueClassFilter clone() {
        return new OldValueClassFilter(getWantedClass(), isNegated());
    }
} // OldValueClassFilterImpl
