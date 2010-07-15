package de.hpi.sam.bp2009.solution.eventManager.framework;

import java.lang.ref.WeakReference;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;

import de.hpi.sam.bp2009.solution.eventManager.EventManager;

/**
 * This special {@link EContentAdapter} is used to notify a given {@link EventManager} if any notification is raised
 * ATTENTION: for the right registration at a target one have to use <code>target.eAdapters().add(myAdapter);</code>
 * @author Philipp
 *
 */
public class EventAdapter extends EContentAdapter {
    private final WeakReference<EventManager> eventManager;

    /**
     * Constructs a new Adapter with the given {@link EventManager} as instance to notify
     * NOTE: the EventManager is held as {@link WeakReference}
     */
    public EventAdapter(EventManager eventManager) {
        this.eventManager = new WeakReference<EventManager>(eventManager);
    }
    
    @Override
    public void notifyChanged(Notification notification) {
        super.notifyChanged(notification);
        EventManager m = this.eventManager.get();
        if(m!=null) {
            m.handleEMFEvent(notification);
        }
    }
}