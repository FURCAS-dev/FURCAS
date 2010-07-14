package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.NotificationForModelList;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerImpl;


public class MultipleNotificationInstanceScopeAnalysisTask implements BenchmarkTask{
    private final OCLExpression expression;
    private final Collection<NotificationForModelList> notiList;
    private final ImpactAnalyzer ia;

    private final Iterator<NotificationForModelList> notificationListIterator;

    private NotificationForModelList recentNotificationList;

    public MultipleNotificationInstanceScopeAnalysisTask(OCLExpression expression, EClass context, Collection<NotificationForModelList> noti) {
	this.expression = expression;
	notiList = noti;

	notificationListIterator = notiList.iterator();
	recentNotificationList = null;

	ia = new ImpactAnalyzerImpl(expression, context);
    }

    @Override
    public Collection<EObject> call() throws Exception {

	for(Notification noti : recentNotificationList.getNotificationList()) {
	    ia.getContextObjects(noti);
	}

	return null;
    }

    public void nextNotification(){
	recentNotificationList = notificationListIterator.next();
    }

    public boolean hasNextNotification(){
	return notificationListIterator.hasNext();
    }

    public Resource getRecentModel(){
	return recentNotificationList.getModel();
    }

    @Override
    public String toString(){
	return expression.toString();
    }

}
