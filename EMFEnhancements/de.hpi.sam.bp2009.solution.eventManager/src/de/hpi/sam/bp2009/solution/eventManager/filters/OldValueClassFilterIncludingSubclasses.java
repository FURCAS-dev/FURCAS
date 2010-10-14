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
            return "old value filter incl subs for old " + getWantedClass().toString();
        return "old value filter incl subs for undefined old";
    }

    @Override
    public OldValueClassFilterIncludingSubclasses clone() {
        return new OldValueClassFilterIncludingSubclasses(getWantedClass(), isNegated());
    }
} // OldValueClassFilterImpl
