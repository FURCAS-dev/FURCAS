package de.hpi.sam.bp2009.solution.impactAnalyzer.util;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class NotificationHelper {
    
    public static boolean isAttributeValueChangeEvent(Notification n){
        boolean result = false;
        EStructuralFeature feature = getNotificationFeature(n);
        if (feature != null){
            result = feature instanceof EAttribute;
        }
        return result;
    }

    public static boolean isLinkLifeCycleEvent(Notification n) {
        boolean result = false;
        EStructuralFeature feature = getNotificationFeature(n);
        if (feature != null){
            result = feature instanceof EReference;
        }
        return result;
    }
    
    public static EStructuralFeature getNotificationFeature(Notification n){
        Object notifier = n.getNotifier();
        if (notifier instanceof EObject){
            EClass cls = ((EObject) notifier).eClass();
            EStructuralFeature feature = cls.getEStructuralFeature(n.getFeatureID(notifier.getClass()));
            return feature;
        }
        return null;
    }

    public static boolean isElementLifeCycleEvent(Notification event) {
        // TODO Auto-generated method stub
        return false;
    }
}
