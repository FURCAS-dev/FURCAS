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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * Matches an event if its {@link Notification#getNotifier() notifier}'s {@link EObject#eClass() class}
 * equals the class passed to this filter's constructor or any subclasses thereof.
 * 
 * @author Philipp Berger, Axel Uhl
 *
 */
public class ClassFilterIncludingSubclasses extends ClassFilter {

    /**
     * The default constructor
     * @param clazz the {@link EClass} to match for
     * @param negated if the filter is negated
     */
    public ClassFilterIncludingSubclasses(EClass clazz, boolean negated) {
        super(clazz, negated);
    }
    @Override
    protected boolean matches(EClass cls) {
        if (super.matches(cls)) {
            return true;
        }
        return cls.getEAllSuperTypes().contains(getWantedClass());
        
    }
    @Override
    public int hashCode() {
        return 2*super.hashCode();
    }
    @Override
    public ClassFilterIncludingSubclasses clone() {
        return new ClassFilterIncludingSubclasses(getWantedClass(), isNegated());
        
    }
    @Override
    public String toString() {
        if (getWantedClass() != null)
            return "wantedClass conformsTo " + getWantedClass().toString();
        return "empty ClassFilter";
    }
}
