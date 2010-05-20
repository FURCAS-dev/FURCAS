/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager;

import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;

public interface EventManager {
    final static int CONTAINMENT_EVENT_TYPE = 666;

    void subscribe(Collection<? extends Notifier> root, EventFilter filter, Adapter caller);

    void subscribeTransactional(Collection<? extends Notifier> root, EventFilter filter, Adapter caller);

    void notifyApplication(Adapter application, Notification msg, EventFilter matchingFilter);

    void handleEMFEvent(Notification notification);

    boolean unsubscribe(Adapter caller);

} // EventManager
