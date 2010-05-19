/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.filters;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier;

public class ClassFilter extends EventFilter {

    protected EClass wantedClass;

    public ClassFilter() {
        super();
    }

    public ClassFilter(EClass subClass, boolean includeSubclasses, boolean negated) {
        super();
        setWantedClass(subClass);
        setNegated(negated);
    }

    public EList<NotificationIdentifier> buildNotificationIdentifiers(NotificationIdentifier identifier) {
        EList<NotificationIdentifier> result = new BasicEList<NotificationIdentifier>();
        result.add(identifier);

        identifier.setNotifierClassURI(EcoreUtil.getURI(getWantedClass()));
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
        return true;
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
        return result;
    }

    public boolean matchesFor(Notification event) {
        // TODO check if an URI based comparison is more adequate
        Object notifier = event.getNotifier();
        if (notifier == null || !(notifier instanceof EObject))
            return false;
        if (((EObject) notifier).eClass().equals(getWantedClass()))
            return true;
        if (((EObject) notifier).eClass().equals(getWantedClass())) {
            return true;
        }
        return ((EObject) notifier).eClass().getEAllSuperTypes().contains(getWantedClass());
    }

    public void setWantedClass(EClass newWantedClass) {
        wantedClass = newWantedClass;
    }

    @Override
    public String toString() {
        if (getWantedClass() != null)
            return "wantedClass :" + getWantedClass().toString();
        return "empty ClassFilter";
    }

    public boolean getIncludeSubClasses() {
        // TODO Auto-generated methodgetIncludeSubClasses stub
//        System.out.println("getIncludeSubClasses");
        return false;
        
    }
    @Override
    public ClassFilter clone() {
        return new ClassFilter(getWantedClass(), getIncludeSubClasses(), isNegated());
        
    }
    @Override
    public Object getFilterCriterion() {
        return getWantedClass();
        
    }
} // ClassFilterImpl
