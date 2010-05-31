/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.util.EContentAdapter;

import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;

public class EventManagerImpl implements EventManager {
    private class EventAdapter extends EContentAdapter {
        @Override
        public void notifyChanged(Notification notification) {
            super.notifyChanged(notification);
            handleEMFEvent(notification);
        }
    }

    private EventAdapter adapter = new EventAdapter();
    private HashMap<NotificationIdentifier, Set<Adapter>> identifierToListener = new HashMap<NotificationIdentifier, Set<Adapter>>();
    private NotificationIdentifierBuilder bld = EventManagerFactory.eINSTANCE.createNotificationIdentifierBuilder();

    protected EventManagerImpl() {
        super();
        this.adapter = new EventAdapter();
    }

    public void handleEMFEvent(Notification notification) {
        for (NotificationIdentifier id : bld.buildFrom(notification)) {
            for (Adapter a : getListenerList(id)) {
                notifyApplication(a, notification, null);
            }
        }

    }

    private Set<Adapter> getListenerList(NotificationIdentifier id) {
        Set<Adapter> rs = identifierToListener.get(id);
        if (rs == null) {
            return Collections.emptySet();
        }
        return rs;
    }

    public void notifyApplication(Adapter application, Notification event, EventFilter matchingFilter) {
        application.notifyChanged(event);
    }

    public void subscribe(Collection<? extends Notifier> root, EventFilter filter, Adapter caller) {
        for (Notifier noti : root) {
            subscribe(noti, filter, caller);
        }
    }

    public void subscribe(Notifier root, EventFilter filter, Adapter caller) {
        if(root!=null)
            root.eAdapters().add(adapter);
        for (NotificationIdentifier id : filter.buildNotificationIdentifiers(EventManagerFactory.eINSTANCE
                .createNotificationIdentifier())) {
            if (identifierToListener.get(id) == null) {
                identifierToListener.put(id, new HashSet<Adapter>());
            }
            getListenerList(id).add(caller);
        }

    }

    public boolean unsubscribe(Adapter caller) {
        boolean result = false;
        for (Set<Adapter> set : identifierToListener.values()) {
            result = result ? result : set.remove(caller);
        }
        return result;
    }

    @Override
    @Deprecated
    public void subscribeTransactional(Collection<? extends Notifier> root, EventFilter filter, Adapter caller) {
        // TODO Auto-generated methodsubscribeTransactional stub
        System.out.println("subscribeTransactional");

    }

    @Override
    public void subscribe(EventFilter filter, Adapter caller) {
        subscribe((Notifier)null, filter, caller);
        
    }

    @Override
    @Deprecated
    public void subscribeTransactional(EventFilter filter, Adapter caller) {
        subscribeTransactional(null, filter, caller);
    }

    @Override
    public boolean detachFrom(Notifier... notifiers) {
        for(Notifier n: notifiers){
            adapter.unsetTarget(n);
        }
        return true;
        
    }

    @Override
    public Collection<? extends Notifier> getAllNotifiers() {
        
        Collection<Notifier> result = new ArrayList<Notifier>();
        result.add(adapter.getTarget());
        return result;
        
    }

    @Override
    public boolean attachTo(Notifier... notifiers) {
        // TODO Auto-generated methodattachTo stub
        System.out.println("attachTo");
        return false;
        
    }

} // EventManagerImpl
