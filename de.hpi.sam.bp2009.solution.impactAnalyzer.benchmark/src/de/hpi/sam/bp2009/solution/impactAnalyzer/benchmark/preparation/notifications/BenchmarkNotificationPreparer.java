package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;


public class BenchmarkNotificationPreparer {
    public static Collection<Notification> preparePrimitveNotification() {
	return new PrimitiveNotificationProducer().produce();
    }

    public static Collection<Notification> prepareRealWorldReplayNotification(){
	return new RealWorldReplayNotificationProducer().produce();
    }
}
