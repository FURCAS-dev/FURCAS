package de.hpi.sam.bp2009.solution.eventManager.tests;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier;
import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;

final class FalseFilter extends EventFilter {
    @Override
    public boolean matchesFor(Notification event) {
        return false;

    }

    @Override
    public EList<NotificationIdentifier> buildNotificationIdentifiers(
            NotificationIdentifier identifier) {
        EList<NotificationIdentifier> test = new BasicEList<NotificationIdentifier>();
        test.add(identifier);
        if(identifier!=null){
            identifier.setEventType(666);
        }
        return test ;

    }

    @Override
    public int hashCode() {
        return 3;

    }

    @Override
    public boolean equals(Object obj) {
        return false;

    }

    @Override
    public FalseFilter clone() {
        return new FalseFilter();
        
    }

    @Override
    public Object getFilterCriterion() {
        return false;
        
    }
}