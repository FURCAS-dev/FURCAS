/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager;

import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.ResourceSet;

import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.framework.RecursiveContaimentNotificationCreator;

public class EventManagerImpl implements EventManager {
    private EventAdapter adapter = new EventAdapter(this);
    private HashMap<EventFilter, Adapter> filterToListener = new HashMap<EventFilter, Adapter>();
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
        Collection<Notification> notis = RecursiveContaimentNotificationCreator.createNotificationForComposites(notification);
        for(Notification noti: notis){
            for (EventFilter filter : this.filterToListener.keySet()) {
                if(filter.matchesFor(noti)){
                    this.notifyApplication(this.filterToListener.get(filter), noti, filter);
                }
            }
        }


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
       this.filterToListener.put(filter, caller);

    }

    public boolean unsubscribe(Adapter caller) {
        boolean result = false;
        if(this.filterToListener.containsValue(caller)){
            Entry<EventFilter, Adapter> resultingEntry=null;
            for(Entry<EventFilter, Adapter> entry:this.filterToListener.entrySet()){
                if(entry.getValue()==caller){
                    resultingEntry = entry;
                    break;
                }
            }
            return this.filterToListener.remove(resultingEntry.getKey()) != null;
            
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
