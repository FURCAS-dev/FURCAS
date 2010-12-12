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
 * Matches an event's {@link Notification#getNotifier() notifier}'s {@link EObject#eClass() class}
 * 
 * @author Daniel Vocke, Philipp Berger, Axel Uhl
 *
 */
public class ClassFilter extends EventFilter {

    protected EClass wantedClass;

    public ClassFilter(EClass clazz, boolean negated) {
        super();
        setWantedClass(clazz);
        setNegated(negated);
    }

    public EClass getWantedClass() {
        return wantedClass;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((wantedClass == null) ? 0 : wantedClass.hashCode());
        if (isNegated()) {
            result = prime * result;
        }
        return result;
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
        ClassFilter other = (ClassFilter) obj;
        if (wantedClass == null) {
            if (other.wantedClass != null)
                return false;
        } else if (!wantedClass.equals(other.wantedClass))
            return false;
        return isNegated() == ((EventFilter) other).isNegated();
    }

    public boolean matchesFor(Notification event) {
        // TODO check if an URI based comparison is more adequate
        Object notifier = event.getNotifier();
        if (notifier == null || !(notifier instanceof EObject))
            return false;
        EClass cls = ((EObject) notifier).eClass();
        return matches(cls);
    }

    protected boolean matches(EClass cls) {
        if (cls.equals(getWantedClass())) {
            return true;
        }
        return false;
//        return getIncludeSubClasses() && cls.getEAllSuperTypes().contains(getWantedClass());
    }

    private void setWantedClass(EClass newWantedClass) {
        wantedClass = newWantedClass;
    }

    @Override
    public String toString() {
        if (getWantedClass() != null)
            return "wantedClass :" + getWantedClass().toString();
        return "empty ClassFilter";
    }
    @Override
    public ClassFilter clone() {
        return new ClassFilter(getWantedClass(), isNegated());
    }
    
    @Override
    public Object getFilterCriterion() {
        return getWantedClass();

    }
} // ClassFilterImpl
