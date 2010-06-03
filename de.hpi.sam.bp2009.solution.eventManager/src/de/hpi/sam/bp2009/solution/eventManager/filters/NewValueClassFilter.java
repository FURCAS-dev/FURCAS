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

public class NewValueClassFilter extends ClassFilter {


    public NewValueClassFilter() {
        super();
    }

    public NewValueClassFilter(EClass affectedClass2) {
        super();
        setWantedClass(affectedClass2);
    }

    public NewValueClassFilter(EClass subClass, boolean includeSubclasses, boolean negated) {
        super(subClass, includeSubclasses, negated);
    }

    @Override
    public EList<NotificationIdentifier> buildNotificationIdentifiers(NotificationIdentifier identifier) {
        identifier.getNewValueClassURIs().add(EcoreUtil.getURI(getWantedClass()));
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
        NewValueClassFilter other = (NewValueClassFilter) obj;
        return super.equals(other);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return 37 * super.hashCode();
    }

    public boolean matchesFor(Notification event) {
        if (event.getNewValue() instanceof EObject) {
            return ((EObject) event.getNewValue()).eClass().equals(getWantedClass());
        }
        if (event.getNewValue() instanceof EList<?>) {
            for (Object o : (EList<?>) event.getNewValue()) {
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
            return "filter for new " + getWantedClass().toString();
        return "filter for undefined new";
    }

    @Override
    public NewValueClassFilter clone() {
        return new NewValueClassFilter(getWantedClass());

    }
} // NewValueClassFilterImpl
