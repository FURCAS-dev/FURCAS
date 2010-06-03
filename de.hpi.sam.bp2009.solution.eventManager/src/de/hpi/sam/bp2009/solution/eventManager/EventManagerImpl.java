/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager;

import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.ResourceSet;

import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;

public class EventManagerImpl implements EventManager {
    private EventAdapter adapter = new EventAdapter(this);
    private HashMap<NotificationIdentifier, Set<Adapter>> identifierToListener = new HashMap<NotificationIdentifier, Set<Adapter>>();
    private NotificationIdentifierBuilder bld = EventManagerFactory.eINSTANCE.createNotificationIdentifierBuilder();
    private WeakReference<ResourceSet> resourceSet;

    protected EventManagerImpl(ResourceSet set) {
        super();
        adapter.setTarget(set);
        this.resourceSet= new WeakReference<ResourceSet>(set);
    }
    @Override
    public ResourceSet getResourceSet() {
        return resourceSet.get();
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
    public void subscribe(EventFilter filter, Adapter caller) {
        subscribe((Notifier)null, filter, caller);
        
    }

    @Override
    public void subscribeTransactional(EventFilter filter, Adapter caller) {
        throw new UnsupportedOperationException();
    }
    @Override
    protected void finalize() throws Throwable {
        if(this.getResourceSet()!=null && adapter!=null){
            adapter.unsetTarget(getResourceSet());
        }
        super.finalize();
        
    }
} // EventManagerImpl
