package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

/**
 * The purpose of this notification producer is only to create one notification
 * in order to be able to run the impact analysis at all. This notifications
 * shall not be used for reliable benchmarks.
 * 
 * @author D049667
 */
public class PrimitiveNotificationProducer implements NotificationProducer {

    @Override
    public Collection<Notification> produce() {
		ArrayList<Notification> notificationList = new ArrayList<Notification>();
	
		EObject obj = data.classes.ClassesFactory.eINSTANCE.createSapClass();
		EAttribute attribute = (EAttribute) obj.eClass().getEStructuralFeature("valueType");
	
		notificationList.add(NotificationHelper.createAttributeChangeNotification(obj, attribute, true, false));
	
		return notificationList;
    }

}
