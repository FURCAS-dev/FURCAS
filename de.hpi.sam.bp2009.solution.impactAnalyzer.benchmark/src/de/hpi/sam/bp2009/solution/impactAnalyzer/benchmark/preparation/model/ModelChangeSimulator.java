package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.model;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class ModelChangeSimulator {
	public static void changeModel(Notification notification){
		if(notification.getEventType() == Notification.REMOVE){
			EcoreUtil.remove((EObject)notification.getNotifier());
		}
	}
}
