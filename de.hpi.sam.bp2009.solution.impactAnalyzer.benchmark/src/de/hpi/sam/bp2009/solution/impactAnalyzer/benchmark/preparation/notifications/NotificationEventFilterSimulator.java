package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.Resource;

import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;

public class NotificationEventFilterSimulator {


    public static Collection<Notification> filter(Collection<Notification> notificationToFilterList, ImpactAnalyzer ia, Resource model){
	EventManager eventManager = EventManagerFactory.eINSTANCE.getEventManagerFor(model.getResourceSet());
	EventFilter filter = ia.createFilterForExpression(false);

	NotificationEventFilterSimulator.NotificationReceiverWithFilter adapter = new NotificationEventFilterSimulator.NotificationReceiverWithFilter(filter);
	eventManager.subscribe(filter, adapter);

	for(Notification noti : notificationToFilterList){
	    eventManager.handleEMFEvent(noti);
	}

	return adapter.getReceived();
    }

    private static class NotificationReceiverWithFilter implements Adapter {
        private final Set<Notification> received = new HashSet<Notification>();
        private final EventFilter filter;
        private Notifier target;

        public NotificationReceiverWithFilter(EventFilter filter) {
            this.filter = filter;
        }

        @Override
        public void notifyChanged(Notification notification) {
            if (getReceived().contains(notification)) {
                System.out.println("Received same notification twice with filter "+filter);
            } else {
                getReceived().add(notification);            }
        }

        @Override
        public Notifier getTarget() {
            return target;
        }

        @Override
        public void setTarget(Notifier newTarget) {
            target = newTarget;
        }

        @Override
        public boolean isAdapterForType(Object type) {
            return false;
        }

	public Set<Notification> getReceived() {
	    return received;
	}

    }
}
