package de.hpi.sam.bp2009.solution.eventManager.filters;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EPackage;

import de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier;

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
        // TODO Auto-generated methodmatchesFor stub
        System.out.println("matchesFor");
        return false;

    }

    @Override
    public EList<NotificationIdentifier> buildNotificationIdentifiers(NotificationIdentifier identifier) {
        // TODO Auto-generated methodbuildNotificationIdentifiers stub
        System.out.println("buildNotificationIdentifiers");
        return null;

    }

    @Override
    public int hashCode() {
        // TODO Auto-generated methodhashCode stub
        System.out.println("hashCode");
        return 0;

    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated methodequals stub
        System.out.println("equals");
        return false;

    }

    public EPackage getEPackage() {
        return ePackage;
    }

    @Override
    public PackageFilter clone(){
        return new PackageFilter(getEPackage());

    }
    @Override
    public Object getFilterCriterion() {
        return getEPackage();
    }
}
