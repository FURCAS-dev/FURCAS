package de.hpi.sam.bp2009.solution.eventManager;

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
        // if there was an containment reference changed
        if(n.getFeature()!=null && n.getFeature() instanceof EReference){
            return ((EReference)n.getFeature()).isContainment();
        }
        // or an element was added / removed from a resource
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
    }

    /**
     * Checks whether the given event contains is a Many Event
     * if true, one can handle the old/newValue objects as Lists
     * @param event the {@link Notification} to check
     * @return {@link Boolean} <code>true</code> if is a many notification
     */
    public static boolean isManyEvent(Notification event) {
        switch (event.getEventType()) {
        case Notification.ADD_MANY:
        case Notification.REMOVE_MANY:
            return true;
        }
        return false;
    }

    /**
     * Checks whether the given event represent an add of a value to the model.
     * @param event {@link Notification} to check
     * @return <code>true</code> if there is an {@link Notification#ADD}  or {@link Notification#ADD_MANY}  or a {@link Notification#SET}  which set not to null
     */
    public static boolean isAddEvent(Notification event) {
        switch (event.getEventType()) {
        case Notification.ADD:
        case Notification.ADD_MANY:
            return true;
        case Notification.SET:
            return event.getNewValue()!=null;
        }
        return false;
    }
}
