/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;

import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;

public interface EventManager {
    final static int CONTAINMENT_EVENT_TYPE = 666;

    void subscribe(EList<Notifier> root, EventFilter filter, Adapter caller);

    void subscribeTransactional(EList<Notifier> root, EventFilter filter, Adapter caller);

    void notifyApplication(Adapter application, Notification msg, EventFilter matchingFilter);

    void handleEMFEvent(Notification notification);

    boolean unsubscribe(Adapter caller);

} // EventManager
