package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;


public class NotificationEventFilterSimulator {


	public static boolean isNotFilteredThroughEventFilter(Notification notification, EventFilter filter, EventManager eventManager) {
		NotificationEventFilterSimulator.NotificationReceiverWithFilter adapter = new NotificationEventFilterSimulator.NotificationReceiverWithFilter(filter);

		eventManager.subscribe(filter, adapter);
		eventManager.handleEMFEvent(notification);
		eventManager.unsubscribe(adapter);

		if (adapter.getReceived().size() == 1
				&& adapter.getReceived().get(0).equals(notification)) {
			return true;
		} else {
			if (adapter.getReceived().contains(notification)){
				return true;
			}
			System.out.println(adapter.getReceived().size() );
			return false;
		}
	}

    private static class NotificationReceiverWithFilter implements Adapter {
        private final ArrayList<Notification> received = new ArrayList<Notification>();
        //private final EventFilter filter;
        private Notifier target;

        public NotificationReceiverWithFilter(EventFilter filter) {
       //        this.filter = filter;
        }
        
        
        @Override
        public void notifyChanged(Notification notification) {
            if (getReceived().contains(notification)) {
              //  System.out.println("Received same notification twice with filter "+filter);
            } else {
                getReceived().add(notification);          
            }
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

	public List<Notification> getReceived() {
	    return received;
	}

    }
}
