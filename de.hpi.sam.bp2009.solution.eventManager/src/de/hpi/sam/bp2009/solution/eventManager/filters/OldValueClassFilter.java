/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.filters;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

public class OldValueClassFilter extends ClassFilter {

    public OldValueClassFilter(EClass clazz, boolean includeSubclasses, boolean isNegated) {
        super(clazz, includeSubclasses, isNegated);
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
            return ((EObject) event.getOldValue()).eClass().equals(getWantedClass());
        }
        if (event.getOldValue() instanceof EList<?>) {
            for (Object o : (EList<?>) event.getOldValue()) {
                if (o instanceof EObject && ((EObject) o).eClass().equals(getWantedClass())) {
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
            return "filter for old " + getWantedClass().toString();
        return "filter for undefined old";
    }

    @Override
    public OldValueClassFilter clone() {
        return new OldValueClassFilter(getWantedClass(), getIncludeSubClasses(), isNegated());
    }

    /**
     * This method avoids an "instanceof" construct when a filter of the same type as an instance
     * of this class or any of its subclasses shall be created.
     */
    public OldValueClassFilter clone(EClass wantedClass, boolean includeSubclasses, boolean negated) {
        return new OldValueClassFilter(wantedClass, includeSubclasses, negated);
    }
} // OldValueClassFilterImpl
