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

public class OldValueClassFilter extends EventFilter {

    protected EClass affectedClass;

    public OldValueClassFilter() {
        super();
    }

    public OldValueClassFilter(EClass affectedClass2) {
        super();
        setAffectedClass(affectedClass2);
    }

    public EClass basicGetAffectedClass() {
        return affectedClass;
    }

    @Override
    public EList<NotificationIdentifier> buildNotificationIdentifiers(NotificationIdentifier identifier) {
        identifier.getOldValueClassURIs().add(EcoreUtil.getURI(getAffectedClass()));
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
        if (affectedClass == null) {
            if (other.affectedClass != null)
                return false;
        } else if (!affectedClass.equals(other.affectedClass))
            return false;
        return true;
    }

    public EClass getAffectedClass() {

        return affectedClass;
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
        result = prime * result + ((affectedClass == null) ? 0 : affectedClass.hashCode());
        return result;
    }

    public boolean matchesFor(Notification event) {
        if (event.getOldValue() == null) {
            return false;
        }
        if (event.getOldValue() instanceof EObject) {
            return ((EObject) event.getOldValue()).eClass().equals(getAffectedClass());
        }
        if (event.getOldValue() instanceof EList<?>) {
            for (Object o : (EList<?>) event.getOldValue()) {
                if (o instanceof EObject && ((EObject) o).eClass().equals(getAffectedClass())) {
                    return true;
                }
            }
            return false;
        }

        return false;
    }

    public void setAffectedClass(EClass newAffectedClass) {
        affectedClass = newAffectedClass;
    }

    @Override
    public String toString() {
        if (getAffectedClass() != null)
            return "filter for old " + getAffectedClass().toString();
        return "filter for undefined old";
    }

    @Override
    public OldValueClassFilter clone(){
        return new OldValueClassFilter(getAffectedClass());

    }
    @Override
    public Object getFilterCriterion() {
        return getAffectedClass();
        
    }

} // OldValueClassFilterImpl
