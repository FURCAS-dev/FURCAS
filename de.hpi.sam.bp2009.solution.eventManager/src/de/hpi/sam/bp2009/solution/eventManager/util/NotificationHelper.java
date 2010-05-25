package de.hpi.sam.bp2009.solution.eventManager.util;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

public class NotificationHelper {
    
    /**
     * Checks whether a {@link Notification} was caused by an attribute value change.
     * @param n the {@link Notification} to check
     * @return true if n was caused by an attribute value change, false otherwise
     */
    public static boolean isAttributeValueChangeEvent(Notification n){
        boolean result = false;
        EStructuralFeature feature = getNotificationFeature(n);
        if (feature != null){
            result = feature instanceof EAttribute;
        }
        return result;
    }

    /**
     * Checks whether a {@link Notification} was caused by a reference change.
     * @param n the {@link Notification} to check
     * @return true if n was caused by a reference change, false otherwise
     */
    public static boolean isLinkLifeCycleEvent(Notification n) {
        boolean result = false;
        EStructuralFeature feature = getNotificationFeature(n);
        if (feature != null){
            result = feature instanceof EReference;
        }
        return result;
    }
    
    /**
     * Checks whether a {@link Notification} was caused by an element creation/deletion.
     * @param n the {@link Notification} to check
     * @return true if n was caused by an element creation/deletion, false otherwise
     */
    public static boolean isElementLifeCycleEvent(Notification n) {
        /*
         * if there was an containment reference changed
         */
        if(n.getFeature()!=null && n.getFeature() instanceof EReference){
            return ((EReference)n.getFeature()).isContainment();
            }
        /*
         * or an element was added / removed from a resource
         */
        else if(n.getFeature() == null && (n.getNotifier() instanceof Resource)){
            return true;
        }
        
        return false;
    }
    
    /**
     * Get the {@link EStructuralFeature} whose change caused the notification
     * @param n the {@link Notification} to check
     * @return the {@link EStructuralFeature} whose change caused the notification
     */
    public static EStructuralFeature getNotificationFeature(Notification n){
        return n.getFeature()==null?null:(EStructuralFeature)n.getFeature();
//        Object notifier = n.getNotifier();
//        if (notifier instanceof EObject){
//            EClass cls = ((EObject) notifier).eClass();
//            EStructuralFeature feature = cls.getEStructuralFeature(n.getFeatureID(notifier.getClass()));
//            return feature;
//        }
//        return null;
    }
}
