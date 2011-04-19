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
 * Matches an event's {@link Notification#getNewValue()} to an
 * {@link EObject#eClass()}. An exact match, not considering any inheritance
 * relations, is required. If the {@link Notification#getNewValue() new value}
 * is a collection, e.g., because several elements were assigned to a
 * many-feature at once, this filter matches if at least one of the elements'
 * class is matched.
 * <p>
 * 
 * When several such filters are combined in an {@link AndFilter}, the
 * {@link AndFilter} matches if all of its operand filters match. This does not
 * require the individual {@link NewValueClassFilter}s to match based on the
 * same element in case the new value happens to be a collection. For example,
 * assume there are two classes <code>X</code> and <code>Y</code>. Assume there
 * is an {@link AndFiter} with two {@link NewValueClassFilter}s inside, one
 * matching <code>X</code>, the other matching <code>Y</code>. If there are two
 * elements in the new value collection of the {@link Notification}, one of type
 * <code>X</code> and the other of type <code>Y</code>, the first
 * {@link NewValueClassFilter} matches because of the <code>X</code> element,
 * and the second {@link NewValueClassFilter} matches because of the
 * <code>Y</code> element and hence the {@link AndFilter} matches. However, no
 * single element in the new value collection fulfills both criteria.
 * 
 * @author Philipp Berger, Axel Uhl
 * 
 */
public class NewValueClassFilter extends ClassFilter {

    public NewValueClassFilter(EClass subClass, boolean negated) {
        super(subClass, negated);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NewValueClassFilter other = (NewValueClassFilter) obj;
        return super.equals(other);
    }

    @Override
    public int hashCode() {
        return 37 * super.hashCode();
    }

    public boolean matchesFor(Notification event) {
        if (event.getNewValue() instanceof EObject) {
            return matches(((EObject) event.getNewValue()).eClass());
        }
        if (event.getNewValue() instanceof EList<?>) {
            for (Object o : (EList<?>) event.getNewValue()) {
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
            return (isNegated()?"negated ":"") + "new value filter for new " + getWantedClass().toString();
        return (isNegated()?"negated ":"") + "new value filter for undefined new";
    }

    @Override
    public NewValueClassFilter clone() {
        return new NewValueClassFilter(getWantedClass(), isNegated());
    }

} // NewValueClassFilterImpl
