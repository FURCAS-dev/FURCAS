/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.tests;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.ResourceSet;

import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;

public class EventManagerNaive implements EventManager {
    private EventAdapter adapter = new EventAdapter(this);
    protected HashMap<EventFilter, Set<Adapter>> filterToListener = new HashMap<EventFilter, Set<Adapter>>();
    private final WeakHashMap<ResourceSet, Object> resourceSets;
    private boolean active = true;

    public EventManagerNaive(ResourceSet set) {
        super();
        adapter.setTarget(set);
        this.resourceSets = new WeakHashMap<ResourceSet, Object>();
        resourceSets.put(set, null);
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
        for (ResourceSet rs : resourceSets.keySet()) {
            if (rs != null && adapter != null) {
                rs.eAdapters().remove(adapter);
            }
        }
        super.finalize();
    }

    public void addToObservedResourceSets(ResourceSet resourceSet) {
        resourceSet.eAdapters().add(adapter);
        resourceSets.put(resourceSet, null);
    }

    public void removeFromObservedResourceSets(ResourceSet resourceSet) {
        resourceSet.eAdapters().remove(adapter);
        resourceSets.remove(resourceSet);
    }
} // EventManagerImpl
