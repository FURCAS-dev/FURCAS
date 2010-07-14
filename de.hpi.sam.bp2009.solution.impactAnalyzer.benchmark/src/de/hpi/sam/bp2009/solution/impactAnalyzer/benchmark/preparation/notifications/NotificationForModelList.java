package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * The {@link NotificiationForModelList} encapsulates a list of notifications for one model
 *
 * @author Manuel Holzleitner (D049667)
 */
public class NotificationForModelList {
    private final Resource model;
    private final List<Notification> notificationList;

    public NotificationForModelList(Resource model, List<Notification> notificationList){
	this.model = model;
	this.notificationList = notificationList;
    }

    public Resource getModel() {
	return model;
    }

    public List<Notification> getNotificationList() {
	return notificationList;
    }

}
