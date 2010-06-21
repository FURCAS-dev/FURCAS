package de.hpi.sam.bp2009.solution.eventManager.filters;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

public class PackageFilter extends EventFilter {

    private EPackage ePackage;

    public PackageFilter() {
        super();
    }

    public PackageFilter(EPackage _package) {
        this.ePackage = _package;
    }

    @Override
    public boolean matchesFor(Notification event) {
        if (event.getNotifier() != null && event.getNotifier() instanceof EObject) {
            for (EPackage p = ((EObject) event.getNotifier()).eClass().getEPackage(); p != null; p = p.getESuperPackage()) {
                if (p.equals(getEPackage())) {
                    return true;
                }
            }
        }
        return false;

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
        result = prime * result + ((ePackage == null) ? 0 : ePackage.hashCode());
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
        PackageFilter other = (PackageFilter) obj;
        if (ePackage == null) {
            if (other.ePackage != null)
                return false;
        } else if (!ePackage.equals(other.ePackage))
            return false;
        return true;
    }

    public EPackage getEPackage() {
        return ePackage;
    }

    @Override
    public PackageFilter clone() {
        return new PackageFilter(getEPackage());

    }

    @Override
    public Object getFilterCriterion() {
        return getEPackage();
    }
}
