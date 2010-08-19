/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.eventManagerEvaluation;

import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.ResourceSet;

import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.framework.EventAdapter;

public class EventManagerNaive implements EventManager {
    private EventAdapter adapter = new EventAdapter(this);
    protected HashMap<EventFilter, Set<Adapter>> filterToListener = new HashMap<EventFilter, Set<Adapter>>();
    private WeakReference<ResourceSet> resourceSet;
    private boolean active = true;

    public EventManagerNaive(ResourceSet set) {
        super();
        adapter.setTarget(set);
        this.resourceSet = new WeakReference<ResourceSet>(set);
    }

    @Override
    public ResourceSet getResourceSet() {
        return resourceSet.get();
    }
    
    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    public void handleEMFEvent(Notification notification) {
        if (active) {
            Collection<Notification> notis = EventManagerFactory.eINSTANCE.createNotificationForComposites(notification);
            for (Notification noti : notis) {
                for (EventFilter filter : this.filterToListener.keySet()) {
                    if (filter.matchesFor(noti)) {
                        for (Adapter a : this.filterToListener.get(filter)) {
                            a.notifyChanged(noti);
                        }
                    }
                }
            }
        }
    }

    public void subscribe(Collection<? extends Notifier> root, EventFilter filter, Adapter caller) {
        for (Notifier noti : root) {
            subscribe(noti, filter, caller);
        }
    }

    public void subscribe(Notifier root, EventFilter filter, Adapter caller) {
        if (root != null)
            root.eAdapters().add(adapter);
        if (this.filterToListener.get(filter) == null) {
            this.filterToListener.put(filter, new HashSet<Adapter>());
        }
        this.filterToListener.get(filter).add(caller);

    }

    public boolean unsubscribe(Adapter caller) {
        boolean result = false;
        Entry<EventFilter, Set<Adapter>> resultingEntry = null;
        for (Entry<EventFilter, Set<Adapter>> entry : this.filterToListener.entrySet()) {
            if (entry.getValue().contains(caller)) {
                resultingEntry = entry;
                result = entry.getValue().remove(caller);
                break;
            }
        }
        if (resultingEntry != null && resultingEntry.getValue().size() == 0) {
            return this.filterToListener.remove(resultingEntry.getKey()) != null;
        }

        return result;
    }

    @Override
    public void subscribe(EventFilter filter, Adapter caller) {
        subscribe((Notifier) null, filter, caller);

    }

    @Override
    protected void finalize() throws Throwable {
        if (this.getResourceSet() != null && adapter != null) {
            adapter.unsetTarget(getResourceSet());
        }
        super.finalize();

    }
} // EventManagerImpl
