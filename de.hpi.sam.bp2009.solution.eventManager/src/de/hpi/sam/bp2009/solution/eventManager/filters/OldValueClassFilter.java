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
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier;

public class OldValueClassFilter extends ClassFilter {


    public OldValueClassFilter() {
        super();
    }

    public OldValueClassFilter(EClass affectedClass2) {
        super();
        setWantedClass(affectedClass2);
    }

    @Override
    public EList<NotificationIdentifier> buildNotificationIdentifiers(NotificationIdentifier identifier) {
        identifier.getOldValueClassURIs().add(EcoreUtil.getURI(getWantedClass()));
        return getEListForNotificationIdentifier(identifier);

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
        if (getWantedClass() == null) {
            if (other.getWantedClass() != null)
                return false;
        } else if (!getWantedClass().equals(other.getWantedClass()))
            return false;
        return true;
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
        result = prime * result + ((getWantedClass() == null) ? 0 : getWantedClass().hashCode());
        return result;
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
    public OldValueClassFilter clone(){
        return new OldValueClassFilter(getWantedClass());

    }
    @Override
    public Object getFilterCriterion() {
        return getWantedClass();
        
    }

} // OldValueClassFilterImpl
