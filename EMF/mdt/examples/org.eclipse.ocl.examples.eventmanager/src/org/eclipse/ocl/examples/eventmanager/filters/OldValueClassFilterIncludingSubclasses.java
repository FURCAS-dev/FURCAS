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
 * Matches an event's {@link Notification#getOldValue()} to an {@link EObject#eClass()} 
 * and all subclasses of this {@link EClass}. If the new value is a collection then this
 * filter matches if at least one of the collection's elements is matched.
 * <p>
 * 
 * When several such filters are combined in an {@link AndFilter}, the
 * {@link AndFilter} matches if all of its operand filters match. This does not
 * require the individual {@link OldValueClassFilterIncludingSubclasses}s to
 * match based on the same element in case the old value happens to be a
 * collection. For example, assume there are two classes <code>X</code> and
 * <code>Y</code> with a class <code>Z</code> that has both, <code>X</code> and
 * <code>Y</code> as its superclasses (multiple inheritance). Assume there is an
 * {@link AndFiter} with two {@link OldValueClassFilterIncludingSubclasses}s
 * inside, one matching <code>X</code>, the other matching <code>Y</code>. If
 * only a single element is the old value of a {@link Notification}, the
 * {@link AndFilter} matches the notification if and only if the old value
 * conforms to both, <code>X</code> and <code>Y</code>, for example if its type
 * is <code>Z</code>. However, if there are two elements in the old value
 * collection of the {@link Notification}, one of type <code>X</code> and the
 * other of type <code>Y</code>, the first
 * {@link OldValueClassFilterIncludingSubclasses} matches because of the
 * <code>X</code> element, and the second
 * {@link OldValueClassFilterIncludingSubclasses} matches because of the
 * <code>Y</code> element and hence the {@link AndFilter} matches. However, no
 * single element in the old value collection fulfills both criteria.
 * 
 * @author Philipp Berger, Axel Uhl
 *
 */
public class OldValueClassFilterIncludingSubclasses extends ClassFilterIncludingSubclasses {

    public OldValueClassFilterIncludingSubclasses(EClass clazz, boolean isNegated) {
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
        OldValueClassFilterIncludingSubclasses other = (OldValueClassFilterIncludingSubclasses) obj;
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
            return (isNegated()?"negated ":"") + "old value filter incl subs for old " + getWantedClass().toString();
        return (isNegated()?"negated ":"") + "old value filter incl subs for undefined old";
    }

    @Override
    public OldValueClassFilterIncludingSubclasses clone() {
        return new OldValueClassFilterIncludingSubclasses(getWantedClass(), isNegated());
    }
} // OldValueClassFilterImpl
