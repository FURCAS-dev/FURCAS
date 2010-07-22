package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

/**
 * A {@link NotificationProducer} creates {@link Notification} in a specified way.
 * They either can create synthesized notifications on synthesized models or
 * simulate real word notifications on real world models.
 *
 * @author Manuel Holzleitner (D049667)
 */
public interface NotificationProducer {
    public Collection<RawNotification> produce();
}
